
public enum DayOfWeek {

	MONDAY(8), TUESDAY(5), WEDNESDAY(6), THIRSDAY(7), FRIDAY(10), SATURDAY(5), SUNDAY(5);

	private int hours;

	private DayOfWeek(int hours) {
		this.hours = hours;
	}

	public static DayOfWeek[] getDaysByHours(int workingHours) {
		int i = 0;
		int k = 0;
		for (DayOfWeek day : DayOfWeek.values()) {
			if (day.hours == workingHours) {
				i++;

			}

		}

		DayOfWeek[] workingDays = new DayOfWeek[i];
		for (DayOfWeek day : DayOfWeek.values()) {
			if (day.hours == workingHours) {
				workingDays[k] = day;
				k++;
			}
		}
		return workingDays;
	}

	public static int getSummaryHours(DayOfWeek[] days) {
		int summ = 0;
		String copy = "";
		for (DayOfWeek dayOfWeek : days) {
			if (!copy.contains(dayOfWeek.name())) {
				summ += dayOfWeek.hours;
				copy = copy.concat(dayOfWeek.name());

			}

		}
		return summ;
	}

}
