package top.qiuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.qiuk.po.ResultJson;

@Controller
@RequestMapping("/qiukk")
public class Test1 {

	@ResponseBody
	@RequestMapping("/test/{id}")
	public ResultJson test(@PathVariable String id) {
		System.out.println(id);
		return new ResultJson();
	}
}
