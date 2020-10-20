package biz.fortune.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fortune.dao.FortuneDAO;
import biz.fortune.vo.FortuneVO;

@Service("fortuneservice")
public class FortuneServiceImpl implements FortuneService{

	@Autowired
	FortuneDAO dao;
	public FortuneVO getFortune(int fortuneno) {
		return dao.getFortune(fortuneno);
	}

	@Override
	public List<FortuneVO> getFortuneList() {
		return dao.getFortuneList();
	}

	@Override
	public List<FortuneVO> searchFortuneList(int humanno) {
		return dao.searchFortuneList(humanno);
	}

	@Override
	public int addFortune(FortuneVO fortune) {
		return dao.addFortune(fortune);
	}

	@Override
	public int deleteFortune(int fortuneno) {
		return dao.deleteFortune(fortuneno);
	}

	@Override
	public int updateFortune(FortuneVO fortune) {
		return dao.updateFortune(fortune);
	}

	@Override
	public int deleteHuman(int humanno) {
		return dao.deleteHuman(humanno);
	}

}
