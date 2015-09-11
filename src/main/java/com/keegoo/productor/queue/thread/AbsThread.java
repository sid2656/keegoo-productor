package com.keegoo.productor.queue.thread;

/**
 * 
 * ClassName: AbsThread 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON(可选). 
 * date: 2015年9月11日 下午2:01:50 
 *
 * @author sid
 */
public abstract class AbsThread {

	public boolean isRun = false;

	public void run() {
		run(0, 0);
	}

	public void run(long delay, long period) {
		if (isRun)
			return;
		isRun = true;
		runThread(delay, period);
	}

	public abstract void runThread(long delay, long period);

	public abstract void stop();

}
