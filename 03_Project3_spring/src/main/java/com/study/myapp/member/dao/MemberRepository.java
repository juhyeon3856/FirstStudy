package com.study.myapp.member.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.study.myapp.member.model.MemberVO;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MemberRepository implements IMemberRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;

	private class MemberMapper implements RowMapper<MemberVO> {
		@Override
		public MemberVO mapRow(ResultSet rs, int count) throws SQLException{
			MemberVO member = new MemberVO();
			member.setName(rs.getString("name"));
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setEmail(rs.getString("email"));
			member.setPhoneNum(rs.getString("phone_num"));
			member.setAddress(rs.getString("address"));
			return member;
		}
	}
	

	@Override
	public void deleteMember(String memberId) {
		String query = "delete from proMembers where id=?";
		jdbcTemplate.update(query, memberId);
	}
	
	@Override
	public void insertMember(MemberVO member) {
		String query = "insert into proMembers values(?,?,?,?,?,?)";
		jdbcTemplate.update(query, 
				member.getName(),
				member.getId(),
				member.getPw(),
				member.getEmail(),
				member.getPhoneNum(),
				member.getAddress()
				);
	}

	@Override
	public void updateMember(MemberVO member){
		String query = "update proMembers set name=?, pw=?,email=?, phone_num=?,address=? where id=?";
		jdbcTemplate.update(query, 
				member.getName(),
				member.getPw(),
				member.getEmail(),
				member.getPhoneNum(),
				member.getAddress(),
				member.getId()
				);
	}	

	@Override
	public MemberVO confirmId(String memberId) {
		String query = "select name, id, pw, email, phone_num, address from proMembers where id=?";
		return jdbcTemplate.queryForObject(query, new MemberMapper(), memberId);
	}

	@Override
	public String userCheck(String memebrId) {
		String query = "select pw from proMembers where id=?";
		return jdbcTemplate.queryForObject(query, String.class, memebrId);
	}

	@Override
	public String searchID(String memberName, String memberPhoneNum) {
		String query = "select id from proMembers where name=? and phone_num=?";
		return jdbcTemplate.queryForObject(query, String.class, memberName, memberPhoneNum);		
	}

	@Override
	public String searchPW(String memberId, String memberName, String memberPhoneNum) {	
		String query = "select pw from proMembers where id=? and name=? and phone_num=?";
		return jdbcTemplate.queryForObject(query, String.class, memberId, memberName, memberPhoneNum);		
	}
	

	@Override
	public MemberVO getMember(String memberId) {
		String query = "select name, id, pw, email, phone_num, address from proMembers where id=?";
		return jdbcTemplate.queryForObject(query, new MemberMapper(), memberId);		
	}
}
