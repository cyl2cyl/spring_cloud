package com.spring.demo.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyilong
 * @package com.spring.demo.eurekaclient.controller
 * @company
 * @description
 * @date 2018-11-20
 */
@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

//	@Autowired
//	private DefaultMQProducer defaultMQProducer;

	@Value("${management.security.enabled}")
	private String value;

	@GetMapping("/test")
	public String test() {
		String services = value;
		return services;
	}

//	@GetMapping("/send")
//	public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
//		String msg = "demo msg test";
//		logger.info("开始发送消息：" + msg);
//		Message sendMsg = new Message("demoTopic", "DemoTag", msg.getBytes());
//		sendMsg.setDelayTimeLevel(3);
//		//默认3秒超时
//		SendResult sendResult = defaultMQProducer.send(sendMsg);
//		logger.info("消息发送响应信息：" + sendResult.toString());
//	}


}
