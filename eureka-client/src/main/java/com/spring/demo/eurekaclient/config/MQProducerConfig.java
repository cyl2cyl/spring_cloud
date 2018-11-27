package com.spring.demo.eurekaclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author caoyilong
 * @package com.spring.demo.eurekaclient.config
 * @company xmiles
 * @description
 * @date 2018-11-22
 */
@Component
@ConfigurationProperties(prefix = "rocketmq.producer")
public class MQProducerConfig {

	private String groupName;

	private String namesrvAddr;
	/**
	 * 消息最大大小，默认4M
	 */
	private Integer maxMessageSize;
	/**
	 * 消息发送超时时间，默认3秒
	 */
	private Integer sendMsgTimeout;
	/**
	 * 消息发送失败重试次数，默认2次
	 */
	private Integer retryTimesWhenSendFailed;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNamesrvAddr() {
		return namesrvAddr;
	}

	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	public Integer getMaxMessageSize() {
		return maxMessageSize;
	}

	public void setMaxMessageSize(Integer maxMessageSize) {
		this.maxMessageSize = maxMessageSize;
	}

	public Integer getSendMsgTimeout() {
		return sendMsgTimeout;
	}

	public void setSendMsgTimeout(Integer sendMsgTimeout) {
		this.sendMsgTimeout = sendMsgTimeout;
	}

	public Integer getRetryTimesWhenSendFailed() {
		return retryTimesWhenSendFailed;
	}

	public void setRetryTimesWhenSendFailed(Integer retryTimesWhenSendFailed) {
		this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
	}

}


