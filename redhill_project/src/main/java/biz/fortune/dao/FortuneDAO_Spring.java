package biz.fortune.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import biz.fortune.vo.FortuneVO;

@Component("fortunespring")
public class FortuneDAO_Spring implements FortuneDAO{

	@Autowired
	JdbcTemplate template;
	
	public FortuneVO getFortune(int fortuneno) {
		String sql = "select * from fortune where fortuneno=?";
		FortuneVO vo = null;
		try{
			vo = template.queryForObject(sql, 
					new Object[] {fortuneno},
					new FortuneRowMapper());
			return vo;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FortuneVO> getFortuneList() {
		String sql = "select * from fortune order by humanno";
		List<FortuneVO> list = null;
		try{
			list = template.query(sql,
					new FortuneRowMapper());
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FortuneVO> searchFortuneList(int humanno) {
		String sql = "select * from fortune where humanno = ? order by fortuneno";
		List<FortuneVO> list = null;
		try{
			list = template.query(sql, new Object[] {humanno},
					new FortuneRowMapper());
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public int addFortune(FortuneVO fortune) {
		String sql = "insert into fortune (fortuneno, humanno, innerfortune, outerfortune, "
				+ "changefortune, explainfortune, details,fortunedate) "
				+ "values ((select nvl(max(fortuneno),0)+1 from fortune), ?, ?, ?, ?, ?, ?,?)";
		return template.update(sql, 
				fortune.getHumanno(),
				fortune.getInnerfortune(),
				fortune.getOuterfortune(),
				fortune.getChangefortune(),
				fortune.getExplainfortune(),
				fortune.getDetails(),
				fortune.getFortunedate());
	}

	@Override
	public int deleteFortune(int fortuneno) {
		String sql = "delete from fortune where fortuneno = ?";
		return template.update(sql,fortuneno);
	}

	@Override
	public int updateFortune(FortuneVO fortune) {
		String sql = "update fortune set innerfortune=?, outerfortune=?, "
				+ "changefortune=?, explainfortune=?, details=? "
				+ " where fortuneno=?";
		return template.update(sql, 
				fortune.getInnerfortune(),
				fortune.getOuterfortune(),
				fortune.getChangefortune(),
				fortune.getExplainfortune(),
				fortune.getDetails(),
				fortune.getFortuneno());
	}

	@Override
	public int deleteHuman(int humanno) {
		String sql = "delete from fortune where humanno = ?";
		return template.update(sql,humanno);
	}

}

class FortuneRowMapper implements RowMapper<FortuneVO>{
	@Override
	public FortuneVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FortuneVO vo = new FortuneVO();
		vo.setChangefortune(rs.getInt("changefortune"));
		vo.setDetails(rs.getString("details"));
		vo.setExplainfortune(rs.getString("explainfortune"));
		vo.setFortuneno(rs.getInt("fortuneno"));
		vo.setHumanno(rs.getInt("humanno"));
		vo.setInnerfortune(rs.getInt("innerfortune"));
		vo.setOuterfortune(rs.getInt("outerfortune"));
		vo.setFortunedate(rs.getString("fortunedate"));
		return vo;
	}
}