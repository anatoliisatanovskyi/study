package local.java.excercise.visualization;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Test;

public class CustomTest {

	@Test
	public void testName() throws Exception {
		int limit = 100;
		AtomicInteger curr = new AtomicInteger(0);
		AtomicInteger err = new AtomicInteger();
		AtomicInteger flips = new AtomicInteger();
		int numOfThreads = 4;
		CyclicBarrier barrier = new CyclicBarrier(numOfThreads);
		ExecutorService service = Executors.newFixedThreadPool(numOfThreads);
		for (int i = 0; i < numOfThreads; i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					try {
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
					for (int j = 0; j < 100; j++) {
						int result = curr.updateAndGet((curr) -> {
							int next = curr + 1;
							if (next <= limit)
								return next;
							else {
								flips.incrementAndGet();
								return 0;
							}
						});

						if (result > limit) {
							err.incrementAndGet();
						}
					}
				}
			});
		}

		Thread.sleep(5000);

		System.out.printf("curr=%d flips=%d err=%d", curr.get(), flips.get(), err.get());
	}

	@Test
	public void testMultipleInputs() throws Exception {

		InputReceiver inputReceiver = new InputReceiver();
		QueueContainer queueContainer = new QueueContainer();

		AtomicBoolean running = new AtomicBoolean(true);
		int numOfThreads = 6;
		ExecutorService service = Executors.newFixedThreadPool(numOfThreads);
		for (int i = 1; i <= numOfThreads; i++) {
			if (i % 3 == 0) {
				service.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < 300; j++) {
							if (!running.get())
								break;
							if (queueContainer.offer(1, InputType.A))
								inputReceiver.receive(queueContainer);
						}
					}
				});
			} else if (i % 2 == 0) {
				service.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < 300; j++) {
							if (!running.get())
								break;
							if (queueContainer.offer(2, InputType.B))
								inputReceiver.receive(queueContainer);
						}
					}
				});
			} else {
				service.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < 300; j++) {
							if (!running.get())
								break;
							if (queueContainer.offer(3, InputType.C))
								inputReceiver.receive(queueContainer);
						}
					}
				});
			}
		}

		Thread.sleep(20000);
		running.set(false);

		System.out.println(inputReceiver.describe());
		System.out.println(queueContainer);
	}

	class Input {
		Integer a;
		Integer b;
		Integer c;

		boolean isComplete() {
			return a != null && b != null && c != null;
		}
	}

	class InputReceiver {
		Queue<Input> queue = new ConcurrentLinkedQueue<>();

		public void receive(QueueContainer queueContainer) {
			queue.offer(queueContainer.poll());
		}

		public String describe() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("Queue contains %d elements. Complete: %d", queue.size(),
					queue.stream().filter(Input::isComplete).count()));
			return sb.toString();
		}
	}

	class QueueContainer {

		AtomicInteger curr = new AtomicInteger();
		Map<InputType, Queue<Integer>> queueMap = new ConcurrentHashMap<>();

		boolean offer(Integer value, InputType type) {
			queueMap.putIfAbsent(type, new ConcurrentLinkedQueue<>());
			queueMap.get(type).offer(value);

			return curr.updateAndGet(currValue -> {
				if (!type.isIn(currValue)) {
					currValue += type.getVal();
				}
				if (InputType.isComplete(currValue)) {
					currValue = 0;
				}
				return currValue;
			}) == 0;
		}

		public Input poll() {
			Input input = new Input();
			input.a = queueMap.get(InputType.A).poll();
			input.b = queueMap.get(InputType.B).poll();
			input.c = queueMap.get(InputType.C).poll();
			return input;
		}

		@Override
		public String toString() {
			return "curr=" + curr.get() + " "
					+ queueMap.entrySet().stream().map(e -> String.format("%s=%d", e.getKey(), e.getValue().size()))
							.collect(Collectors.toList()).toString();
		}
	}

	enum InputType {

		A(1), B(2), C(4);

		static final int SUM = Arrays.stream(InputType.values()).mapToInt(InputType::getVal).sum();

		int val;

		InputType(int val) {
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		static boolean isComplete(int sum) {
			return SUM == sum;
		}

		boolean isIn(int sum) {
			return (sum & val) == val;
		}
	}
}
