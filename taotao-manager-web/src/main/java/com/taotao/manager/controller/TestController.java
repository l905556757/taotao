package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.service.TestService;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired(required = false)
	private TestService testService;

	// http://127.0.0.1/rest/test/date
	/**
	 * 查询服务器时间
	 * 
	 * @return
	 */
	@RequestMapping("date")
	@ResponseBody
	public String queryDate() {
		String date = this.testService.queryDate();
		return date;
	}

}
