package com.keegoo.productor.queue.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keegoo.productor.InitProductor;

/**
 * 
 * ClassName: PushGroupMsgThread 
 * 处理消息线程
 * date: 2015年9月11日 下午2:02:11 
 *
 * @author sid
 */
public class PushGroupMsgThread extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(PushGroupMsgThread.class);

	private String[] strs;

	public PushGroupMsgThread(String[] strs) {
		this.strs = strs;
	}

	@Override
	public void run() {
		try {
			// TODO 消息发送
			String msgId = this.strs[0];
			String groupId = this.strs[1];
			String msg = this.strs[2];
			logger.info("发送消息"+InitProductor.application.getProperty("productor.url.group")+"，具体发送接口和处理方式待确定："+msgId+groupId+msg);
		} catch (Exception e) {
			logger.error("群组发送消息队列处理数据错误", e);
		}
	}

}
