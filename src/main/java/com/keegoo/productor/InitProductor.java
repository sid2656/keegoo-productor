/**
 * Project Name:keegoo-productor
 * File Name:InitProductor.java
 * Package Name:com.keegoo.productor
 * Date:2015年9月11日下午12:02:32
 * Copyright (c) 2015, sid Jenkins All Rights Reserved.
 * 
 *
*/

package com.keegoo.productor;

import java.util.Properties;

import com.keegoo.productor.queue.thread.PushGroupMsgThreadManager;
import com.keegoo.productor.queue.thread.PushSoleMsgThreadManager;
import com.keegoo.productor.utils.PropertiesUtil;

/**
 * ClassName:InitProductor
 * Function: TODO ADD FUNCTION. 
 * Reason:	 TODO ADD REASON. 
 * Date:     2015年9月11日 下午12:02:32 
 * @author   sid
 * @see 	 
 */
public class InitProductor {
	/**
	 * 系统根目录
	 */
	public static final String ROOT_PATH = System.getProperty("user.dir");
	
	/**
	 * 配置文件地址
	 */
	private static final String charset="utf-8";
	public static Properties application;

	static{
		application = PropertiesUtil.getProperties("productor.properties", charset);
		// 启动消息处理
		PushGroupMsgThreadManager.getInstance().run(0,0);
		PushSoleMsgThreadManager.getInstance().run(0, 0);
	}
}

