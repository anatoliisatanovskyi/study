package local.java.excercise.concurrency;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CocncurrencyTest {

	static Map<String, Long> timeMap = new HashMap<>();
	int maxCount = 1000000;
	int threadCount = 4;

	@Test
	public void TestASynchronized() throws Exception {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		AtomicInteger counter = new AtomicInteger();
		CountDownLatch cdl = new CountDownLatch(threadCount);
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		Object obj = new Object();
		long time = 0;
		for (int i = 0; i < threadCount; i++) {
			time = System.nanoTime();
			service.submit(new Runnable() {
				public void run() {

					try {
						synchronized (obj) {
							while (counter.get() < maxCount) {
								counter.incrementAndGet();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						cdl.countDown();
					}

				}

			});

		}
		cdl.await();
		long finish = System.nanoTime() - time;
		System.out.println("Counter: " + counter.get());
		System.out.println("Time on operation: " + finish);
		service.shutdown();
		timeMap.put(methodName, finish);
	}

	@Test
	public void TestBSemaphore() throws Exception {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		AtomicInteger counter = new AtomicInteger();
		CountDownLatch cdl = new CountDownLatch(threadCount);
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		Semaphore sem = new Semaphore(1);
		long time = 0;
		for (int i = 0; i < threadCount; i++) {
			time = System.nanoTime();
			service.submit(new Runnable() {
				public void run() {
					try {
						sem.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {

						while (counter.get() < maxCount) {
							counter.incrementAndGet();
							sem.release();
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						cdl.countDown();
					}

				}

			});

		}
		cdl.await();
		long finish = System.nanoTime() - time;
		System.out.println("Counter: " + counter.get());
		System.out.println("Time on operation: " + finish);
		service.shutdown();
		timeMap.put(methodName, finish);
	}

	@Test
	public void TestCLocks() throws Exception {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		AtomicInteger counter = new AtomicInteger();
		CountDownLatch cdl = new CountDownLatch(threadCount);
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		ReentrantLock lock = new ReentrantLock();
		long time = 0;
		for (int i = 0; i < threadCount; i++) {
			time = System.nanoTime();
			service.submit(new Runnable() {
				public void run() {
					try {
						lock.lock();
						while (counter.get() < maxCount) {

							counter.incrementAndGet();

						}
						lock.unlock();

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						cdl.countDown();
					}

				}

			});

		}
		cdl.await();
		long finish = System.nanoTime() - time;
		System.out.println("Counter: " + counter.get());
		System.out.println("Time on operation: " + finish);
		service.shutdown();
		timeMap.put(methodName, finish);
	}

	@Test
	public void TestDArhanTricks() throws Exception {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		AtomicInteger counter = new AtomicInteger();
		CountDownLatch cdl = new CountDownLatch(threadCount);
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		long time = 0;
		for (int i = 0; i < threadCount; i++) {
			time = System.nanoTime();
			service.submit(new Runnable() {
				public void run() {

					while (true) {
						int newValue = performIncreasment();
						if (newValue >= maxCount) {
							break;
						}
					}
					cdl.countDown();
				}

				private int performIncreasment() {
					return counter.getAndUpdate(v -> v < maxCount ? v + 1 : v);
				}
			});

		}
		cdl.await();

		long finish = System.nanoTime() - time;
		System.out.println("Counter: " + counter.get());
		System.out.println("Time on operation: " + finish);
		service.shutdown();
		timeMap.put(methodName, finish);
	}

	@Test
	public void TestYprintMap() throws Exception {
		Map<Long, String> mapToPrint = new TreeMap<>();
		for (Map.Entry<String, Long> entry : timeMap.entrySet()) {
			mapToPrint.put(entry.getValue(), entry.getKey());

		}
		int place = 1;
		for (Map.Entry<Long, String> entryPrint : mapToPrint.entrySet()) {
			System.out.println(place + ": " + entryPrint.getKey() + " " + entryPrint.getValue());
			place++;
		}

	}
}
