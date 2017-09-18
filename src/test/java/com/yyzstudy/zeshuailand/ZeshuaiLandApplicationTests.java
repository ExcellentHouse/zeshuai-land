package com.yyzstudy.zeshuailand;

import com.yyzstudy.zeshuailand.dao.AreaRepository;
import com.yyzstudy.zeshuailand.dao.CommunityRepository;
import com.yyzstudy.zeshuailand.model.po.Area;
import com.yyzstudy.zeshuailand.model.po.Community;
import com.yyzstudy.zeshuailand.service.AreaService;
import com.yyzstudy.zeshuailand.service.AuthService;
import com.yyzstudy.zeshuailand.service.CommunityService;
import com.yyzstudy.zeshuailand.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZeshuaiLandApplicationTests {

	@Autowired
	private AreaService areaService;

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private CommunityRepository communityRepository;

	@Autowired
	private CommunityService communityService;

	@Autowired
	private AuthService authService;


	@Test
	public void contextLoads() {
		areaRepository.deleteAll();
		Area area1 = new Area(UUIDUtil.getUUID(), "杭州", "西湖区", "翠苑");
		Area area2 = new Area(UUIDUtil.getUUID(), "杭州", "西湖区", "古荡");
		Area area3 = new Area(UUIDUtil.getUUID(), "杭州", "西湖区", "黄龙");
		Area area4 = new Area(UUIDUtil.getUUID(), "杭州", "滨江区", "奥体");
		Area area5 = new Area(UUIDUtil.getUUID(), "杭州", "滨江区", "白马湖");
		Area area6 = new Area(UUIDUtil.getUUID(), "杭州", "滨江区", "彩虹城");
		Area area7 = new Area(UUIDUtil.getUUID(), "杭州", "余杭区", "闲林");
		Area area8 = new Area(UUIDUtil.getUUID(), "杭州", "余杭区", "乔司");
		Area area9 = new Area(UUIDUtil.getUUID(), "杭州", "余杭区", "临平");
		Area area11 = new Area(UUIDUtil.getUUID(), "抚顺市", "东洲区", "阿金沟(沟王子剑)");
		Area area12 = new Area(UUIDUtil.getUUID(), "抚顺市", "东洲区", "东洲大街");
		Area area13 = new Area(UUIDUtil.getUUID(), "抚顺市", "东洲区", "五满意大街");
		Area area14 = new Area(UUIDUtil.getUUID(), "抚顺市", "顺城区", "顺城大街");
		Area area15 = new Area(UUIDUtil.getUUID(), "抚顺市", "顺城区", "顺城中街");
		Area area16 = new Area(UUIDUtil.getUUID(), "抚顺市", "顺城区", "顺城小街");
		Area area17 = new Area(UUIDUtil.getUUID(), "抚顺市", "新抚区", "新抚大街");
		Area area18 = new Area(UUIDUtil.getUUID(), "抚顺市", "新抚区", "新抚中街");
		Area area19 = new Area(UUIDUtil.getUUID(), "抚顺市", "新抚区", "新抚小街");
		ArrayList<Area> areas = new ArrayList<>(Arrays.asList(
				area1,area2,area3,area4,area5,area6,area7,area8,area9,
				area11,area12,area13,area14,area15,area16,area17,area18,area19));
		areaService.save(areas);
    }

    @Test
	public void communityInitialize(){
		communityRepository.deleteAll();
		Community community1 = new Community(UUIDUtil.getUUID(),
				"五满意小区",
				"抚顺市东洲区东洲大街五满意小区",
				1999,
				"普通住房",
				4000.0,
				22,
				"/image/test1;",new Area("8b727201da01481ca268dd906e46e9b1",null,null,null));
		Community community2 = new Community(UUIDUtil.getUUID(),
				"超棒小区",
				"抚顺市顺城区顺城大街超棒小区",
				2010,
				"普通住房",
				8000.0,
				122,
				"/image/test2;",new Area("cb6ff253cc6a4e4896f4586b44db26c0",null,null,null));
		communityRepository.save(Arrays.asList(community1,community2));
		System.out.println(communityService.findAllPageing(0,10));
	}
	@Test
	public void testSpecificationFilter(){
		System.out.println(communityRepository);
		Specification querySpecifi = new Specification<Community>() {
			@Override
			public Predicate toPredicate(Root<Community> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.lt(root.get("builtYear"), 1996));
				predicates.add(criteriaBuilder.gt(root.get("builtYear"), 1992));


				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		communityRepository.findAll(querySpecifi);
	}
	@Test
	public void testBcrypt(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//$2a$10$fwbYWzH5nwK4R.I7PXsr1u/x8rj7QDXKZUZzVASlYXojzqBiX3gCS
		System.out.println(encoder.encode("qwer"));

		authService.login("qwer", "qwer");
		System.out.println(authService.login("qwer", "qwer"));

	}

}
