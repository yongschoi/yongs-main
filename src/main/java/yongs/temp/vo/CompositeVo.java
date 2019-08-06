package yongs.temp.vo;

import java.util.List;

public class CompositeVo {
	private List<TempVo> tempList;
	private List<UserVo> usertList;
	
	public List<TempVo> getTempList() {
		return tempList;
	}
	public void setTempList(List<TempVo> tempList) {
		this.tempList = tempList;
	}
	public List<UserVo> getUserList() {
		return usertList;
	}
	public void setUserList(List<UserVo> usertList) {
		this.usertList = usertList;
	}
}
