package com.spring.demo.eurekaclient;

import com.spring.demo.eurekaclient.config.MQConsumerConfig;
import com.spring.demo.eurekaclient.config.MQProducerConfig;
import com.spring.demo.eurekaclient.listen.MQConsumeMsgListenerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.spring.demo.eurekaclient")
public class EurekaClientApplication {

	@Autowired
	private MQProducerConfig mqProducerConfig;

	@Autowired
	private MQConsumerConfig mqConsumerConfig;

	@Autowired
	private MQConsumeMsgListenerProcessor mqMessageListenerProcessor;


	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
//
//	@Bean(name = "defaultMQProducer")
//	public DefaultMQProducer getRocketMQProducer() throws Exception {
//		if (StringUtils.isEmpty(mqProducerConfig.getGroupName())) {
//			throw new RuntimeException("groupName is blank");
//		}
//		if (StringUtils.isEmpty(mqProducerConfig.getNamesrvAddr())) {
//			throw new RuntimeException("nameServerAddr is blank");
//		}
//		DefaultMQProducer producer;
//		producer = new DefaultMQProducer(mqProducerConfig.getGroupName());
//		producer.setNamesrvAddr(mqProducerConfig.getNamesrvAddr()); //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
//		// producer.setInstanceName(instanceName);
//		if (mqProducerConfig.getMaxMessageSize() != null) {
//			producer.setMaxMessageSize(mqProducerConfig.getMaxMessageSize());
//		}
//		if (mqProducerConfig.getSendMsgTimeout() != null) {
//			producer.setSendMsgTimeout(mqProducerConfig.getSendMsgTimeout());
//		}
//		//如果发送消息失败，设置重试次数，默认为2次
//		if (mqProducerConfig.getRetryTimesWhenSendFailed() != null) {
//			producer.setRetryTimesWhenSendFailed(mqProducerConfig.getRetryTimesWhenSendFailed());
//		}
//		try {
//			producer.start();
////			LOGGER.info(String.format("producer is start ! groupName:[%s],namesrvAddr:[%s]", this.groupName, this.namesrvAddr));
//		} catch (MQClientException e) {
//			//LOGGER.error(String.format("producer is error {}" , e.getMessage(),e));
//			throw new RuntimeException(e);
//		}
//		return producer;
//	}
//
//	@Bean
//	public DefaultMQPushConsumer getRocketMQConsumer() throws Exception {
//		if (StringUtils.isEmpty(mqConsumerConfig.getGroupName())) {
//			throw new RuntimeException("groupName is null !!!");
//		}
//		if (StringUtils.isEmpty(mqConsumerConfig.getNamesrvAddr())) {
//			throw new RuntimeException("namesrvAddr is null !!!");
//		}
//		if (StringUtils.isEmpty(mqConsumerConfig.getTopics())) {
//			throw new RuntimeException("topics is null !!!");
//		}
//		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(mqConsumerConfig.getGroupName());
//		consumer.setNamesrvAddr(mqConsumerConfig.getNamesrvAddr());
//		consumer.setConsumeThreadMin(mqConsumerConfig.getConsumeThreadMin());
//		consumer.setConsumeThreadMax(mqConsumerConfig.getConsumeThreadMax());
//		consumer.registerMessageListener(mqMessageListenerProcessor);
//		/** * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费 * 如果非第一次启动，那么按照上次消费的位置继续消费 */
//		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET); /** * 设置消费模型，集群还是广播，默认为集群 */
//		//consumer.setMessageModel(MessageModel.CLUSTERING);
//		// /** * 设置一次消费消息的条数，默认为1条 */
//		consumer.setConsumeMessageBatchMaxSize(mqConsumerConfig.getConsumeMessageBatchMaxSize());
//		try { /** * 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，则tag使用*；如果需要指定订阅该主题下的某些tag，则使用||分割，例如tag1||tag2||tag3 */
//			String[] topicTagsArr = mqConsumerConfig.getTopics().split(";");
//			for (String topicTags : topicTagsArr) {
//				String[] topicTag = topicTags.split("~");
//				consumer.subscribe(topicTag[0], topicTag[1]);
//			}
//			consumer.start();
//		} catch (MQClientException e) {
//			throw new RuntimeException(e);
//		}
//		return consumer;
//	}
}
