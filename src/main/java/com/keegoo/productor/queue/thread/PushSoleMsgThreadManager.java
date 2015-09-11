package com.keegoo.productor.queue.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keegoo.productor.InitProductor;
import com.keegoo.productor.queue.GroupMsgQueue;

/**
 * 
 * ClassName: PushGroupMsgThreadManager 
 * Reason: 线程池（处理消息）管理
 * date: 2015年9月11日 下午2:17:43 
 *
 * @author sid
 */
public class PushSoleMsgThreadManager extends AbsThread {

	private static final Logger logger = LoggerFactory.getLogger(PushSoleMsgThreadManager.class);

	static PushSoleMsgThreadManager obj;

	public static PushSoleMsgThreadManager getInstance() {
		if (obj == null)
			obj = new PushSoleMsgThreadManager();
		return obj;
	}

	private ThreadPoolExecutor threadPool;

	private volatile boolean isStart=true;

	public PushSoleMsgThreadManager() {
		int corePoolSize = Integer.parseInt(InitProductor.application.getProperty("ParseCorePoolSize"));
		int maximunPoolSize = Integer.parseInt(InitProductor.application.getProperty("ParseMaximumPoolSize"));
		int keepAliveTime = Integer.parseInt(InitProductor.application.getProperty("ParseKeepAliveTime"));
		int queueSize=Integer.parseInt(InitProductor.application.getProperty("ParseQueueSize"));
		threadPool = new ThreadPoolExecutor(corePoolSize, maximunPoolSize,
				keepAliveTime, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSize),
				new ThreadPoolExecutor.CallerRunsPolicy());
	}

	@Override
	public void runThread(long delay, long period) {
		isRun = true;
		isStart=true;

		new Thread(new ParseThreadManage()).start();
		logger.info("服务器消息处理启动完成");

	}

	class ParseThreadManage implements Runnable {
		public void run() {
			while (isStart) {
				String[] strs = null;
				try {
					strs = GroupMsgQueue.getQueue().take();
					threadPool.execute(new PushGroupMsgThread(strs));
				} catch (Exception e) {
					logger.error("消息解析管理线程运行异常", e);
				}
			}
		}
	}

	@Override
	public void stop() {
		isRun = false;
		isStart=false;
	}

}
