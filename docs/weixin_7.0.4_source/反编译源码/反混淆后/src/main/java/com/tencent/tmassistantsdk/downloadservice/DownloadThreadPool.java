package com.tencent.tmassistantsdk.downloadservice;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool {
    public static final String TAG = "DownloadThreadPool";
    protected static DownloadThreadPool mDownloadThreadPool = null;
    final ArrayList<TaskThread> mDownloadThreadList = new ArrayList();
    final ArrayList<DownloadTask> mExecList = new ArrayList();
    protected final Comparator<DownloadTask> mPriorityQueueComparator = new C445541();
    final Object mTaskLock = new Object();
    final Object mThreadlock = new Object();
    final PriorityQueue<DownloadTask> mWaitingList = new PriorityQueue(16, this.mPriorityQueueComparator);

    class TaskThread extends Thread {
        private int mIndex = 0;

        public TaskThread(int i) {
            AppMethodBeat.m2504i(75760);
            this.mIndex = i;
            setName("download_thread_" + this.mIndex);
            start();
            AppMethodBeat.m2505o(75760);
        }

        public void run() {
            AppMethodBeat.m2504i(75761);
            TMLog.m60588i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " starts running...");
            while (true) {
                synchronized (DownloadThreadPool.this.mThreadlock) {
                    try {
                        TMLog.m60588i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is waitting...");
                        DownloadThreadPool.this.mThreadlock.wait();
                    } catch (InterruptedException e) {
                        TMLog.m60588i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                        C4990ab.printErrStackTrace(DownloadThreadPool.TAG, e, "", new Object[0]);
                        AppMethodBeat.m2505o(75761);
                        return;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(75761);
                            throw th;
                        }
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    TMLog.m60588i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                    AppMethodBeat.m2505o(75761);
                    return;
                }
                while (DownloadThreadPool.this.hasWaitingTask()) {
                    DownloadTask downloadTask = null;
                    synchronized (DownloadThreadPool.this.mTaskLock) {
                        try {
                            if (DownloadThreadPool.this.mWaitingList.size() > 0) {
                                downloadTask = (DownloadTask) DownloadThreadPool.this.mWaitingList.remove();
                                DownloadThreadPool.this.mExecList.add(downloadTask);
                            }
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(75761);
                                throw th2;
                            }
                        }
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        TMLog.m60588i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                        AppMethodBeat.m2505o(75761);
                        return;
                    }
                    if (downloadTask != null) {
                        TMLog.m60588i(DownloadThreadPool.TAG, "TaskThread::Run ThreadName: " + getName() + " url: " + downloadTask.getDownloadURI());
                        WakeLock wakeLock = DownloadHelper.getWakeLock();
                        downloadTask.exec(getName());
                        if (wakeLock != null) {
                            wakeLock.release();
                        }
                    }
                    synchronized (DownloadThreadPool.this.mTaskLock) {
                        if (downloadTask != null) {
                            try {
                                DownloadThreadPool.this.mExecList.remove(downloadTask);
                            } catch (Throwable th22) {
                                while (true) {
                                    AppMethodBeat.m2505o(75761);
                                    throw th22;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool$1 */
    class C445541 implements Comparator<DownloadTask> {
        C445541() {
        }

        public int compare(DownloadTask downloadTask, DownloadTask downloadTask2) {
            AppMethodBeat.m2504i(75757);
            if (downloadTask.getPriority() > downloadTask2.getPriority()) {
                AppMethodBeat.m2505o(75757);
                return 1;
            } else if (downloadTask.getPriority() == downloadTask2.getPriority()) {
                AppMethodBeat.m2505o(75757);
                return 0;
            } else {
                AppMethodBeat.m2505o(75757);
                return -1;
            }
        }
    }

    public static DownloadThreadPool getInstance() {
        AppMethodBeat.m2504i(75762);
        if (mDownloadThreadPool == null) {
            mDownloadThreadPool = new DownloadThreadPool();
        }
        DownloadThreadPool downloadThreadPool = mDownloadThreadPool;
        AppMethodBeat.m2505o(75762);
        return downloadThreadPool;
    }

    private DownloadThreadPool() {
        AppMethodBeat.m2504i(75763);
        int maxTaskNum = DownloadSetting.getInstance().getMaxTaskNum();
        for (int i = 0; i < maxTaskNum; i++) {
            this.mDownloadThreadList.add(new TaskThread(i));
        }
        AppMethodBeat.m2505o(75763);
    }

    /* Access modifiers changed, original: 0000 */
    public int addDownloadTask(DownloadTask downloadTask) {
        int i;
        int th;
        int i2 = 75764;
        AppMethodBeat.m2504i(75764);
        synchronized (this.mTaskLock) {
            try {
                this.mWaitingList.add(downloadTask);
                i = this.mThreadlock;
                synchronized (i) {
                    this.mThreadlock.notifyAll();
                }
                th = downloadTask.getTaskId();
            } catch (Throwable th2) {
                while (true) {
                    th = th2;
                }
                i = 75764;
            } finally {
                AppMethodBeat.m2505o(
/*
Method generation error in method: com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.addDownloadTask(com.tencent.tmassistantsdk.downloadservice.DownloadTask):int, dex: classes7.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: INVOKE  (wrap: int
  ?: MERGE  (r3_1 int) = (r3_0 'i2' int), (r2_3 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.addDownloadTask(com.tencent.tmassistantsdk.downloadservice.DownloadTask):int, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_1 int) = (r3_0 'i2' int), (r2_3 'i' int) in method: com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.addDownloadTask(com.tencent.tmassistantsdk.downloadservice.DownloadTask):int, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    /* Access modifiers changed, original: 0000 */
    public void cancelDownloadTask(final int i) {
        AppMethodBeat.m2504i(75765);
        synchronized (this.mTaskLock) {
            try {
                new Thread(new Runnable() {
                    public void run() {
                        DownloadTask downloadTask;
                        AppMethodBeat.m2504i(75759);
                        Iterator it = DownloadThreadPool.this.mExecList.iterator();
                        while (it.hasNext()) {
                            downloadTask = (DownloadTask) it.next();
                            if (downloadTask.getTaskId() == i) {
                                downloadTask.cancel();
                                DownloadThreadPool.this.mExecList.remove(downloadTask);
                                AppMethodBeat.m2505o(75759);
                                return;
                            }
                        }
                        it = DownloadThreadPool.this.mWaitingList.iterator();
                        while (it.hasNext()) {
                            downloadTask = (DownloadTask) it.next();
                            if (downloadTask.getTaskId() == i) {
                                downloadTask.cancel();
                                DownloadThreadPool.this.mWaitingList.remove(downloadTask);
                                AppMethodBeat.m2505o(75759);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(75759);
                    }
                }).start();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75765);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean hasWaitingTask() {
        boolean z;
        AppMethodBeat.m2504i(75766);
        synchronized (this.mTaskLock) {
            try {
                z = this.mWaitingList.size() > 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75766);
            }
        }
        return z;
    }

    public DownloadTask getDownloadTask(String str) {
        DownloadTask downloadTask;
        AppMethodBeat.m2504i(75767);
        synchronized (this.mTaskLock) {
            try {
                Iterator it = this.mExecList.iterator();
                while (it.hasNext()) {
                    downloadTask = (DownloadTask) it.next();
                    if (downloadTask.getDownloadURI().equals(str)) {
                    }
                }
                it = this.mWaitingList.iterator();
                while (it.hasNext()) {
                    downloadTask = (DownloadTask) it.next();
                    if (downloadTask.getDownloadURI().equals(str)) {
                        AppMethodBeat.m2505o(75767);
                        return downloadTask;
                    }
                }
                AppMethodBeat.m2505o(75767);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75767);
            }
        }
        return downloadTask;
    }
}
