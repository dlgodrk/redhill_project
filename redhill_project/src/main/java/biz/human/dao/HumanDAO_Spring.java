package biz.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import biz.human.vo.HumanVO;

@Component("humanspring")
public class HumanDAO_Spring implements HumanDAO{

	@Autowired
	JdbcTemplate template ;
	
	@Override
	public HumanVO getHuman(int humanno) {
		String sql = "select * from humaninfo where humanno=?";
		HumanVO vo = null;
		try{
			vo = template.queryForObject(sql, 
					new Object[] {humanno},
					new HumanRowMapper());
			return vo;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	} 

	@Override
	public List<HumanVO> getHumanList() {
		String sql = "select * from humaninfo order by humanno";
		List<HumanVO> list = null;
		try{
			list = template.query(sql,
					new HumanRowMapper());
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int addHuman(HumanVO human) {
		String sql = "insert into humaninfo (humanno, name, sex, birthyear, birthmonth, "
				+ "birthday, birthhour, birthminute, phonenumber, details, sunmoon) "
				+ "values ((select nvl(max(humanno),0)+1 from humaninfo), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, 
				human.getName(),
				human.getSex(),
				human.getBirthyear(),
				human.getBirthmonth(),
				human.getBirthday(),
				human.getBirthhour(),
				human.getBirthminute(),
				human.getPhonenumber(),
				human.getDetails(),
				human.getSunmoon()
				);
	}

	@Override
	public int deleteHuman(int humanno) {
		String sql = "delete from humaninfo where humanno = ?";
		return template.update(sql,humanno);
	}

	@Override
	public List<HumanVO> searchHuman(String name) {
		String sql = "select * from humaninfo where upper(name) like '%'||?||'%'";
		List<HumanVO> list = null;
		try{
			list = template.query(sql, new Object[] {name.toUpperCase()},
					new HumanRowMapper());
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateHuman(HumanVO human) {
		String sql = "update humaninfo set name=?, sex=?, birthyear=?, birthmonth=?, "
				+ "birthday=?, birthhour=?, birthminute=?, phonenumber=?, details=?, sunmoon=? "
				+ " where humanno = ?";
		return template.update(sql, 
				human.getName(),
				human.getSex(),
				human.getBirthyear(),
				human.getBirthmonth(),
				human.getBirthday(),
				human.getBirthhour(),
				human.getBirthminute(),
				human.getPhonenumber(),
				human.getDetails(),
				human.getSunmoon(),
				human.getHumanno());
			
	}
}
class HumanRowMapper implements RowMapper<HumanVO>{
	@Override
	public HumanVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HumanVO vo = new HumanVO();
		vo.setBirthday(rs.getInt("birthday"));
		vo.setBirthhour(rs.getInt("birthhour"));
		vo.setBirthminute(rs.getInt("birthminute"));
		vo.setBirthmonth(rs.getInt("birthmonth"));
		vo.setBirthyear(rs.getInt("birthyear"));
		vo.setDetails(rs.getString("details"));
		vo.setHumanno(rs.getInt("humanno"));
		vo.setName(rs.getString("name"));
		vo.setPhonenumber(rs.getString("phonenumber"));
		vo.setSex(rs.getString("sex"));
		vo.setSunmoon(rs.getString("sunmoon"));
		return vo;
	}
}