package biz.human.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.human.dao.HumanDAO;
import biz.human.vo.HumanVO;

@Service("humanservice")
public class HumanServiceImpl implements HumanService{
	
	@Autowired
	HumanDAO dao;
	
	@Override
	public HumanVO getHuman(int humanno) {
		return dao.getHuman(humanno);
	}

	@Override
	public List<HumanVO> getHumanList() {
		return dao.getHumanList();
	}

	@Override
	public int addHuman(HumanVO human) {
		return dao.addHuman(human);
	}

	@Override
	public int deleteHuman(int humanno) {
		return dao.deleteHuman(humanno);
	}

	@Override
	public List<HumanVO> searchHuman(String name) {
		return dao.searchHuman(name);
	}

	@Override
	public int updateHuman(HumanVO human) {
		return dao.updateHuman(human);
	}

}
