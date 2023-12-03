package projetCOO.util;

import java.time.DayOfWeek;

public class Time {

	protected DayOfWeek day;
	protected int hour;
		
	public Time(DayOfWeek d, int h) {
		this.day = d;
		this.hour = h;
	}
	
	/**
	 * gives the day of this Time 
	 * @return DayOfWeek
	 */
	public DayOfWeek getDay() {
		return this.day;
	}
	
	
	
	/**
	 * Changes the day
	 * @param d
	 */
	public void setDay(DayOfWeek d) {
		this.day = d;
	}
	
	/**
	 * changes the hour
	 * @return int
	 */
	public int getHour() {
		return this.hour;
	}
	
	/**
	 * changes the hour
	 * @param h
	 */
	public void setHour(int h) {
		this.hour = h;
	}
	
	public String toString() {
		return this.day.name() + ", " + this.hour;
	}

}
