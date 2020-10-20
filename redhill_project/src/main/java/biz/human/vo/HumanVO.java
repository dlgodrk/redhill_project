package biz.human.vo;
public class HumanVO {
	private int humanno;
	private String name;
	private String sex;
	private int birthyear;
	private int birthmonth;
	private int birthday;
	private int birthhour;
	private int birthminute;
	private String phonenumber;
	private String details;
	private String sunmoon;
	
	public HumanVO(int humanno, String name, String sex, int birthyear, int birthmonth, int birthday, int birthhour,
			int birthminute, String phonenumber, String details, String sunmoon) {
		this.humanno = humanno;
		this.name = name;
		this.sex = sex;
		this.birthyear = birthyear;
		this.birthmonth = birthmonth;
		this.birthday = birthday;
		this.birthhour = birthhour;
		this.birthminute = birthminute;
		this.phonenumber = phonenumber;
		this.details = details;
		this.sunmoon = sunmoon;
	}
	public HumanVO() {}
	
	public String getSunmoon() {
		return sunmoon;
	}
	public void setSunmoon(String sunmoon) {
		this.sunmoon = sunmoon;
	}
	public int getHumanno() {
		return humanno;
	}
	public void setHumanno(int humanno) {
		this.humanno = humanno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
	public int getBirthmonth() {
		return birthmonth;
	}
	public void setBirthmonth(int birthmonth) {
		this.birthmonth = birthmonth;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getBirthhour() {
		return birthhour;
	}
	public void setBirthhour(int birthhour) {
		this.birthhour = birthhour;
	}
	public int getBirthminute() {
		return birthminute;
	}
	public void setBirthminute(int birthminute) {
		this.birthminute = birthminute;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "HumanVO [humanno=" + humanno + ", name=" + name + ", sex=" + sex + ", birthyear=" + birthyear
				+ ", birthmonth=" + birthmonth + ", birthday=" + birthday + ", birthhour=" + birthhour
				+ ", birthminute=" + birthminute + ", phonenumber=" + phonenumber + ", details=" + details
				+ ", sunmoon=" + sunmoon + "]";
	}
	
}

