package local.java.excercise.isbn;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IsbnTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testValidate13NullValue() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.IS_NULL);
		new ISBN13(null).validate();
	}

	@Test
	public void testValidate13EmptyValue() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(13, 0));
		new ISBN13("").validate();
	}

	@Test
	public void testValidate13InsufficientLength() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(13, 12));
		new ISBN13("123456789012").validate();
	}

	@Test
	public void testValidate13ExceedingLength() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(13, 14));
		new ISBN13("12345678901234").validate();
	}

	@Test
	public void testValidate13IllegalCharactersAlphabetic() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.NON_NUMERIC);
		new ISBN13("a234567890123").validate();
	}

	@Test
	public void testValidate13IllegalCharactersSpecial() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.NON_NUMERIC);
		new ISBN13(";234567890123").validate();
	}

	@Ignore
	@Test
	public void testValidate13InvalidChechSum() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(13, 14));
		new ISBN13("9781234567896").validate();
	}

	@Test
	public void testValidate13Valid() throws Exception {
		new ISBN13("9781234567897").validate();
	}

	@Test
	public void testValidate10NullValue() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.IS_NULL);
		new ISBN10(null).validate();
	}

	@Test
	public void testValidate10EmptyValue() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(10, 0));
		new ISBN10("").validate();
	}

	@Test
	public void testValidate10InsufficientLength() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(10, 9));
		new ISBN10("123456789").validate();
	}

	@Test
	public void testValidate10ExceedingLength() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.invalidLength(10, 11));
		new ISBN10("12345678901").validate();
	}

	@Test
	public void testValidate10IllegalCharactersAlphabetic() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.NON_NUMERIC);
		new ISBN10("a567890123").validate();
	}

	@Test
	public void testValidate10IllegalCharactersSpecial() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.NON_NUMERIC);
		new ISBN10(";567890123").validate();
	}

	@Test
	public void testValidate10InvalidChechSum() throws Exception {
		exception.expect(IllegalStateException.class);
		exception.expectMessage(ErrorMessage.INVALID_CHECKSUM);
		new ISBN10("1234567890").validate();
	}

	@Test
	public void testValidate10Valid() throws Exception {
		new ISBN10("0139069798").validate();
	}

	@Test
	public void testValidate10ValidWithUppercaseX() throws Exception {
		new ISBN10("089620829X").validate();
	}

	@Test
	public void testValidate10ValidWithLowercaseX() throws Exception {
		new ISBN10("089620829x").validate();
	}

	static class ErrorMessage {
		public static final String NON_NUMERIC = "Invalid value: non numeric characters present";
		public static final String IS_NULL = "isbn value can't be null";
		public static final String INVALID_LENGTH = "Invalid length. Expected %d but is %d";
		public static final String INVALID_CHECKSUM = "Checksum is invalid";

		public static String invalidLength(int expected, int actual) {
			return String.format(INVALID_LENGTH, expected, actual);
		}
	}

	abstract class ISBNValue {

		protected String value;
		private int length;

		public ISBNValue(String value, int length) {
			this.value = value;
			this.length = length;
		}

		public void validate() {
			validateLength();
			validateCharacters();
			validateChecksum();
		}

		private void validateCharacters() {
			String formattedValue = value.toLowerCase().endsWith("x") ? value.substring(0, value.length() - 1) : value;
			long digitChars = formattedValue.chars().boxed().filter(Character::isDigit).count();
			if (digitChars != (formattedValue.equals(value) ? length : length - 1)) {
				throw new IllegalStateException(ErrorMessage.NON_NUMERIC);
			}
		}

		protected abstract void validateChecksum();

		private void validateLength() {
			if (value == null) {
				throw new IllegalStateException(ErrorMessage.IS_NULL);
			}
			if (value.length() != length) {
				throw new IllegalStateException(ErrorMessage.invalidLength(length, value.length()));
			}
		}
	}

	class ISBN13 extends ISBNValue {

		public ISBN13(String value) {
			super(value, 13);
		}

		@Override
		protected void validateChecksum() {

		}
	}

	class ISBN10 extends ISBNValue {

		public ISBN10(String value) {
			super(value, 10);
		}

		@Override
		protected void validateChecksum() {
			AtomicInteger coef = new AtomicInteger(10);
			int totalSum = value.toLowerCase().chars().mapToObj(c -> (char) c)
					.map(ch -> ch == 'x' ? 10 : Character.getNumericValue(ch)).map(v -> v * coef.getAndDecrement())
					.reduce(0, Integer::sum);

			int checksum = totalSum % 11;
			if (checksum != 0) {
				throw new IllegalStateException(ErrorMessage.INVALID_CHECKSUM);
			}
		}
	}
}
