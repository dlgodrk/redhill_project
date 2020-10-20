package biz.fortune.vo;
public class FortuneVO {
	private int fortuneno;
	private int humanno;
	private int innerfortune;
	private int outerfortune;
	private int changefortune;
	private String explainfortune;
	private String details;
	private String fortunedate;
	
	public FortuneVO(int fortuneno, int humanno, int innerfortune, int outerfortune, int changefortune,
			String explainfortune, String details, String fortunedate) {
		this.fortuneno = fortuneno;
		this.humanno = humanno;
		this.innerfortune = innerfortune;
		this.outerfortune = outerfortune;
		this.changefortune = changefortune;
		this.explainfortune = explainfortune;
		this.details = details;
		this.fortunedate = fortunedate;
	}
	public FortuneVO() {}
	
	public int getFortuneno() {
		return fortuneno;
	}
	public void setFortuneno(int fortuneno) {
		this.fortuneno = fortuneno;
	}
	public int getHumanno() {
		return humanno;
	}
	public void setHumanno(int humanno) {
		this.humanno = humanno;
	}
	public int getInnerfortune() {
		return innerfortune;
	}
	public void setInnerfortune(int innerfortune) {
		this.innerfortune = innerfortune;
	}
	public int getOuterfortune() {
		return outerfortune;
	}
	public void setOuterfortune(int outerfortune) {
		this.outerfortune = outerfortune;
	}
	public int getChangefortune() {
		return changefortune;
	}
	public void setChangefortune(int changefortune) {
		this.changefortune = changefortune;
	}
	public String getExplainfortune() {
		return explainfortune;
	}
	public void setExplainfortune(String explainfortune) {
		this.explainfortune = explainfortune;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getFortunedate() {
		return fortunedate;
	}
	public void setFortunedate(String fortunedate) {
		this.fortunedate = fortunedate;
	}
	
	@Override
	public String toString() {
		return "FortuneVO [fortuneno=" + fortuneno + ", humanno=" + humanno + ", innerfortune=" + innerfortune
				+ ", outerfortune=" + outerfortune + ", changefortune=" + changefortune + ", explainfortune="
				+ explainfortune + ", details=" + details + ", fortunedate=" + fortunedate + "]";
	}
	
	
	
	
}
