package biz.human.service;

import java.util.List;

import biz.human.vo.HumanVO;

public interface HumanService {
	HumanVO getHuman(int humanno);
	List<HumanVO> getHumanList();
	int addHuman(HumanVO human);
	int deleteHuman(int humanno);
	List<HumanVO> searchHuman(String name);
	int updateHuman(HumanVO human);
}
