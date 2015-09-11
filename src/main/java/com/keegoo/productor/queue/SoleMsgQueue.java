package com.keegoo.productor.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * ClassName: SoleMsgQueue 
 * Reason: 单独消息队列
 * date: 2015年9月11日 下午2:05:41 
 *
 * @author sid
 */
public class SoleMsgQueue {
	/**
	 * 接收数据队列
	 */
	private static LinkedBlockingQueue<String[]> sole_queue = new LinkedBlockingQueue<String[]>();

	public static LinkedBlockingQueue<String[]> getQueue() {
		return sole_queue;
	}
}
