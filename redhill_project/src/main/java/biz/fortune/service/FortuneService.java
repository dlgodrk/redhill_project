package biz.fortune.service;

import java.util.List;

import biz.fortune.vo.FortuneVO;

public interface FortuneService {
	FortuneVO getFortune(int fortuneno);
	List<FortuneVO> getFortuneList();
	List<FortuneVO> searchFortuneList(int humanno);
	int addFortune(FortuneVO fortune);
	int deleteFortune(int fortuneno);
	int deleteHuman(int humanno);
	int updateFortune(FortuneVO fortune);
}
