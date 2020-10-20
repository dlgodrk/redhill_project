package biz.human.dao;

import java.util.List;

import biz.human.vo.HumanVO;

public interface HumanDAO {
	HumanVO getHuman(int humanno);
	List<HumanVO> getHumanList();
	int addHuman(HumanVO human);
	int deleteHuman(int humanno);
	List<HumanVO> searchHuman(String name);
	int updateHuman(HumanVO human);
}
