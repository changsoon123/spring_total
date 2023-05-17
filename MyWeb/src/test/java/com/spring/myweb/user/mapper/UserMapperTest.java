package com.spring.myweb.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.myweb.command.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/db-config.xml")
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	@Test
	@DisplayName("회원가입을 진행했을 때 회원가입에 성공해야 한다")
	void registTest() {
		UserVO vo = new UserVO();
		vo.setUserId("abcd");
		vo.setUserPw("aaa12!");
		vo.setUserName("홍길동동");
		
		mapper.join(vo);
		
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디를 조회했을 시 1이 리턴이 되어야 한다.")
	void checkIdTest() {
		String id = "abc12345";
		
		mapper.idCheck(id);
		
//		for (UserVO userVO : list) {
//			
//		}
//		
//		list.forEach(article -> System.out.println(article));
		
		//단언한다.
		assertEquals(mapper.idCheck(id), 1);
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디와 올바른 비밀번호를 입력했을 시 회원의 정보가 리턴되어야 한다.")
	void loginTest() {
		
		
	}
	
	@Test
	@DisplayName("존재하지 않는 회원의 아이디를 입력하면 null이 올 것이다.")
	void getInfoTest() {
		String id = "abcdefg";
		UserVO vo = mapper.getInfo(id);
		
//		assertEquals(vo.getUserId(), "abc12345");
		assertNull(vo);
		
	}
	
	@Test
	@DisplayName("아이디를 제외한 값들")
	void updateTest() {
		String upid = "abc12345";
		String uppw = "wow";
		
		UserVO vo = new UserVO();
		vo.setUserId(upid);
		vo.setUserPw(uppw);
		mapper.updateUser(vo);
		
		assertEquals(vo.getUserPw(), "wow");
		
	}
}