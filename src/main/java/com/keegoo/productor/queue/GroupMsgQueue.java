package com.keegoo.productor.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * ClassName: GroupMsgQueue 
 * Reason: 分组消息队列
 * date: 2015年9月11日 下午2:05:55 
 *
 * @author sid
 */
public class GroupMsgQueue {
	/**
	 * 接收数据队列
	 */
	private static LinkedBlockingQueue<String[]> group_queue = new LinkedBlockingQueue<String[]>();

	public static LinkedBlockingQueue<String[]> getQueue() {
		return group_queue;
	}
}
