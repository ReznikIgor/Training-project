
public class App {

	public static void main(String[] args) {

		DayOfWeek[] day = DayOfWeek.getDaysByHours(5);
		System.out.println("Check getDaysByHours");
		for (DayOfWeek day1 : day) {
			System.out.println(day1);
		}

		DayOfWeek[] daysOfWeek = { DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.TUESDAY,
				DayOfWeek.SUNDAY };
		System.out.println("Check getSummaryHours: " + DayOfWeek.getSummaryHours(daysOfWeek));

		System.out.println("Check reversStr(лапа јзора): " + StringUtils.reversStr("лапа јзора"));
		System.out.println("Check palindrome: " + StringUtils.palindrome("ј роза упала на лапу јзора"));
		System.out.println("Check checkLenght: " + StringUtils.checkLenght("лапа") + " "
				+ StringUtils.checkLenght("лапајзораЋапајзора"));
		System.out.println("Check FirstToLast: " + StringUtils.FirstToLast("а роза упала"));
		System.out.println("Check FirstToLastInSent: " + StringUtils.FirstToLastInSent("а роза упала. Ќа лапу јзора."));
		System.out.println("Check containsABC: " + StringUtils.containsABC("abc"));
		System.out.println("Check containsDate: " + StringUtils.containsDate("15.10.2015"));
		System.out.println("Check findPhone: ");
		String[] phones = StringUtils
				.findPhone("first number +3(806)534-76-55, second number will be +4(809)645-78-46");
		for (String phone : phones) {
			System.out.println(phone);

		}
	}

}
