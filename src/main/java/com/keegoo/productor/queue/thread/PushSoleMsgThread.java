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
public class PushSoleMsgThread extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(PushSoleMsgThread.class);

	private String[] strs;

	public PushSoleMsgThread(String[] strs) {
		this.strs = strs;
	}

	@Override
	public void run() {
		try {
			// TODO 消息发送
			String msgId = this.strs[0];
			String msg = this.strs[1];
			logger.info("发送消息"+InitProductor.application.getProperty("productor.url.sole")+"，具体发送接口和处理方式待确定："+msgId+msg);
		} catch (Exception e) {
			logger.error("群组发送消息队列处理数据错误", e);
		}
	}

}
