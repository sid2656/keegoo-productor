/**
 * Project Name:keegoo-productor
 * File Name:ProductorUtils.java
 * Package Name:com.keegoo.productor
 * Date:2015年9月11日下午2:20:28
 * Copyright (c) 2015, sid Jenkins All Rights Reserved.
 * 
 *
*/

package com.keegoo.productor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keegoo.productor.queue.GroupMsgQueue;
import com.keegoo.productor.queue.SoleMsgQueue;
import com.keegoo.productor.queue.thread.PushGroupMsgThread;

/**
 * ClassName:ProductorUtils
 * Reason:	 发送消息的处理类
 * Date:     2015年9月11日 下午2:20:28 
 * @author   sid
 * @see 	 
 */
public class ProductorUtils {

	private static final Logger logger = LoggerFactory.getLogger(PushGroupMsgThread.class);

	public static void pushMsgToGroup(String... strs){
		try {
			GroupMsgQueue.getQueue().put(strs);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("分组队列存放失败:",e);
		}
	}
	
	public static void pushMsgToSole(String... strs){
		try {
			SoleMsgQueue.getQueue().put(strs);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("分组队列存放失败:",e);
		}
	}
}

