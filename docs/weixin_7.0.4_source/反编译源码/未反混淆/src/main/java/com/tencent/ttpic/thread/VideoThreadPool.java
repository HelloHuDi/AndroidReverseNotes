package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class VideoThreadPool {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int MAXIMUM_POOL_SIZE = ((CPU_COUNT * 10) + 1);
    private static String TAG = VideoThreadPool.class.getSimpleName();
    private ThreadPoolExecutor DUAL_THREAD_EXECUTOR;
    private final ThreadFactory sThreadFactory;

    static class VideoThreadPoolHolder {
        private static final VideoThreadPool INSTANCE = new VideoThreadPool();

        private VideoThreadPoolHolder() {
        }

        static {
            AppMethodBeat.i(83791);
            AppMethodBeat.o(83791);
        }
    }

    static {
        AppMethodBeat.i(83797);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = (availableProcessors * 2) + 1;
        AppMethodBeat.o(83797);
    }

    public static VideoThreadPool getInstance() {
        AppMethodBeat.i(83792);
        VideoThreadPool access$100 = VideoThreadPoolHolder.INSTANCE;
        AppMethodBeat.o(83792);
        return access$100;
    }

    private VideoThreadPool() {
        AppMethodBeat.i(83793);
        this.sThreadFactory = new VideoThreadFactory(10);
        init();
        AppMethodBeat.o(83793);
    }

    public synchronized ThreadPoolExecutor getDualThreadExecutor() {
        return this.DUAL_THREAD_EXECUTOR;
    }

    public void submit(Runnable runnable) {
        AppMethodBeat.i(83794);
        this.DUAL_THREAD_EXECUTOR.execute(runnable);
        AppMethodBeat.o(83794);
    }

    public void shutdown() {
        AppMethodBeat.i(83795);
        this.DUAL_THREAD_EXECUTOR.shutdownNow();
        while (!this.DUAL_THREAD_EXECUTOR.awaitTermination(500, TimeUnit.MILLISECONDS)) {
            try {
                new StringBuilder("[clear] thread pool active count = ").append(getInstance().getDualThreadExecutor().getActiveCount());
            } catch (InterruptedException e) {
                AppMethodBeat.o(83795);
                return;
            }
        }
        AppMethodBeat.o(83795);
    }

    public void init() {
        AppMethodBeat.i(83796);
        this.DUAL_THREAD_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), this.sThreadFactory, new DiscardOldestPolicy());
        this.DUAL_THREAD_EXECUTOR.allowCoreThreadTimeOut(true);
        AppMethodBeat.o(83796);
    }
}
