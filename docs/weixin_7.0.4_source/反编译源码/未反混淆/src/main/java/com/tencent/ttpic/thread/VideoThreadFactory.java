package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoThreadFactory implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);
    private final int priority;

    public VideoThreadFactory(int i) {
        AppMethodBeat.i(83789);
        this.priority = i;
        AppMethodBeat.o(83789);
    }

    public Thread newThread(Runnable runnable) {
        AppMethodBeat.i(83790);
        Thread thread = new Thread(runnable, "Video AsyncTask #" + this.mCount.getAndIncrement());
        thread.setPriority(this.priority);
        AppMethodBeat.o(83790);
        return thread;
    }
}
