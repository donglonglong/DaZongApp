package org.imooc.controller.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.imooc.constant.ApiCodeEnum;
import org.imooc.dao.OrdersDao;
import org.imooc.dto.*;
import org.imooc.service.AdService;
import org.imooc.service.BusinessService;
import org.imooc.service.MemberService;
import org.imooc.service.OrdersService;
import org.imooc.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AdService adService;

	@Value("${ad.number}")
	private int adNumber;

	@Value("10")
	private int businessHomeNumber;

	@Autowired
	private BusinessService businessService;

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private MemberService memberService;
	/**
	 * 首页 —— 广告（超值特惠）
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/homead", method = RequestMethod.GET)
	public List<AdDto> homead() throws JsonParseException, JsonMappingException, IOException {
		AdDto adDto = new AdDto();
		adDto.getPage().setPageNumber(adNumber);
		return adService.searchByPage(adDto);
	}

	/**
	 * 首页 —— 推荐列表（猜你喜欢）
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
	public BusinessListDto homelist(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
		businessDto.getPage().setPageNumber(businessHomeNumber);
		return businessService.searchByPageForApi(businessDto);
	}

	/**
	 * 搜索结果页 - 搜索结果 - 三个参数
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/search/{page.currentPage}/{city}/{category}/{keyword}", method = RequestMethod.GET)
	public BusinessListDto searchByKeyword(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"16414190508477233\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"10379361046633062\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"2684953608146943\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"4327667029608906\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"05417345080828273\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"4165909692594816\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"17548314689876077\"}]}";
		return mapper.readValue(s,new TypeReference<BusinessListDto>() {});
	}

	/**
	 * 搜索结果页 - 搜索结果 - 两个参数
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/search/{page.currentPage}/{city}/{category}", method = RequestMethod.GET)
	public BusinessListDto search(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"16414190508477233\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"10379361046633062\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"2684953608146943\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"4327667029608906\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"05417345080828273\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"4165909692594816\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"17548314689876077\"}]}";
		return mapper.readValue(s,new TypeReference<BusinessListDto>() {});
	}

	/**
	 * 详情页 - 商户信息
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
	public BusinessDto detail(@PathVariable("id") Long id) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String s = "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"天下第一锅\",\"star\":4,\"price\":\"88\",\"subTitle\":\"重庆 & 四川 麻辣火锅\",\"desc\":\"营业时间 11:00 - 21:00 <br> 电话订购 11:00 - 19:00 <br> 网络订购 11:00 - 19:00\"}";
		return mapper.readValue(s,new TypeReference<BusinessDto>() {});
	}

	/**
	 * 详情页 - 用户评论
	 */
	@RequestMapping(value = "/detail/comment/{page}/{id}", method = RequestMethod.GET)
	public CommentListDto detail() throws JsonParseException, JsonMappingException, IOException {
		String s = "{\"hasMore\":true,\"data\":[{\"username\":\"133****3355\",\"comment\":\"非常好吃，棒棒的，下次再来\",\"star\":5},{\"username\":\"135****3452\",\"comment\":\"羊肉够分量，不错\",\"star\":4},{\"username\":\"137****1242\",\"comment\":\"有自助的水果，非常喜欢\",\"star\":4},{\"username\":\"131****3980\",\"comment\":\"桌子环境有点糟糕，不喜欢\",\"star\":2},{\"username\":\"135****3565\",\"comment\":\"基本还可以，中规中矩吧，虽然没有啥惊喜\",\"star\":3},{\"username\":\"130****9879\",\"comment\":\"感觉很棒，服务员态度非常好\",\"star\":5},{\"username\":\"186****7570\",\"comment\":\"要是能多给开点发票就好了，哈哈啊\",\"star\":4}]}";
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(s, new TypeReference<CommentListDto>() {});
	}

	/**
	 * 订单列表
	 */
	@RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
	public List<OrdersDto> orderlist() throws JsonParseException, JsonMappingException, IOException {
		String s = "[{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\"title\":\"汉堡大王\",\"count\":3,\"price\":\"167\",\"commentState\":0},{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\"title\":\"麻辣香锅\",\"count\":1,\"price\":\"188\",\"commentState\":0},{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"好吃自出餐\",\"count\":2,\"price\":\"110\",\"commentState\":2}]";
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(s, new TypeReference<List<OrdersDto>>() {});
	}

	/**
	 * 提交评论
	 */
	@RequestMapping(value = "/submitComment", method = RequestMethod.POST)
	public Map<String, Object> submitComment() {
		Map<String, Object> result = new HashMap<>();
		result.put("errno", 0);
		result.put("msg", "ok");
		return result;
	}

	/**
	 * 根据手机号下发短信验证码
	 */
	@RequestMapping(value = "/sms", method = RequestMethod.POST)
	public ApiCodeDto sms(@RequestParam("username") Long username) {
		ApiCodeDto dto;
		// 1、验证用户手机号是否存在（是否注册过）
		if (memberService.exists(username)) {
			// 2、生成6位随机数
			String code = String.valueOf(CommonUtil.random(6));
			// 3、保存手机号与对应的md5(6位随机数)（一般保存1分钟，1分钟后失效）
			if (memberService.saveCode(username, code)) {
				// 4、调用短信通道，将明文6位随机数发送到对应的手机上。
				if (memberService.sendCode(username, code)) {
					dto = new ApiCodeDto(ApiCodeEnum.SUCCESS.getErrno(), code);
				} else {
					dto = new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
				}
			} else {
				dto = new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
			}
		} else {
			dto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
		}
		return dto;
	}

	/**
	 * 会员登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiCodeDto login(@RequestParam("username") Long username, @RequestParam("code") String code) {
		ApiCodeDto dto;
		// 1、用手机号取出保存的md5(6位随机数)，能取到，并且与提交上来的code值相同为校验通过
		String saveCode = memberService.getCode(username);
		if (saveCode != null) {
			if (saveCode.equals(code)) {
				// 2、如果校验通过，生成一个32位的token
				String token = CommonUtil.getUUID();
				// 3、保存手机号与对应的token（一般这个手机号中途没有与服务端交互的情况下，保持10分钟）
				memberService.saveToken(token, username);
				// 4、将这个token返回给前端
				dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
				dto.setToken(token);
			} else {
				dto = new ApiCodeDto(ApiCodeEnum.CODE_ERROR);
			}
		} else {
			dto = new ApiCodeDto(ApiCodeEnum.CODE_INVALID);
		}
		return dto;
	}

	/***
	 * 买单
	 * @return
	 */
	@RequestMapping(value = "/order",method = RequestMethod.POST)
	public ApiCodeDto order(OrderForBuyDto orderForBuyDto){
		ApiCodeDto dto;
		// 1、校验token是否有效（缓存中是否存在这样一个token，并且对应存放的会员信息（这里指的是手机号）与提交上来的信息一致）
		Long phone = memberService.getPhone(orderForBuyDto.getToken());
		if(phone!= null && phone.equals(orderForBuyDto.getUsername())){
			//2.根据手机号获取会员主键
			Long memberId = memberService.getIdByPhone(phone);
			//3.保存订单
			OrdersDto ordersDto = new OrdersDto();
			ordersDto.setNum(orderForBuyDto.getNum());
			ordersDto.setPrice(orderForBuyDto.getPrice());
			ordersDto.setBusinessId(orderForBuyDto.getId());
			ordersDto.setMemberId(orderForBuyDto.getId());
			ordersService.add(ordersDto);
			dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
			//4.TODO 还有一件重要的事情未做
		}else {
			dto =new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
		}
		return dto;
	}


}
