package biz.fortune.dao;

import java.util.List;

import biz.fortune.vo.FortuneVO;

public interface FortuneDAO {
	FortuneVO getFortune(int fortuneno);
	List<FortuneVO> getFortuneList();
	List<FortuneVO> searchFortuneList(int humanno);
	int addFortune(FortuneVO fortune);
	int deleteFortune(int fortuneno);
	int updateFortune(FortuneVO fortune);
	int deleteHuman(int humanno);
}
