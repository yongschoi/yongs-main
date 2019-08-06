package yongs.temp.vo;

public class AccountVo {
	private String no;
	private long balance;
	private String name;
	
	public AccountVo(String no, long balance, String name) {
		this.no = no;
		this.balance = balance;
		this.name = name;		
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
