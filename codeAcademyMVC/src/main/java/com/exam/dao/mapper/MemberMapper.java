package com.exam.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.exam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO vo);
	
	@Select("SELECT COUNT(*) AS cnt FROM members WHERE id = #{id}")
	public int countMemberById(String id);
	
	@Select("SELECT COUNT(*) AS cnt FROM members WHERE email = #{email}")
	public int countMemberByEmail(String email);
	
	@Select("SELECT * FROM members WHERE id = #{id}")
	public MemberVO getMemberById(String id);
	
	@Select("SELECT * FROM members")
	public List<MemberVO> getMembers();
	
	@Update("UPDATE members SET passwd=#{passwd}, email=#{email}, tel=#{tel}, gender=#{gender} WHERE id = #{id}")
	public int updateMember(MemberVO memberVO);
	
	@Delete("DELETE FROM members WHERE id=#{id}")
	public int deleteMember(String id);
	
	@Select("SELECT gender, COUNT(*) AS cnt FROM members GROUP BY gender")
	public List<Map<String, Object>> getGenderRatio();
}
