package com.tencent.p177mm.audio.mix.p831d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.audio.mix.d.h */
public class C41777h {
    private static C41777h cmh;
    private ThreadPoolExecutor cmi;
    private PriorityBlockingQueue<Runnable> cmj = new PriorityBlockingQueue(33);
    private LinkedList<C41778i> cmk = new LinkedList();
    private int cml;
    private Object lock = new Object();

    /* renamed from: DQ */
    public static C41777h m73745DQ() {
        AppMethodBeat.m2504i(137076);
        if (cmh == null) {
            synchronized (C41777h.class) {
                try {
                    if (cmh == null) {
                        cmh = new C41777h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(137076);
                    }
                }
            }
        }
        C41777h c41777h = cmh;
        AppMethodBeat.m2505o(137076);
        return c41777h;
    }

    private C41777h() {
        int i = 8;
        AppMethodBeat.m2504i(137077);
        C45174b.m83210i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        int i2 = (i2 * 2) + 2;
        if (i2 > 32) {
            i = 32;
        } else if (i2 >= 8) {
            i = i2;
        }
        this.cml = i;
        this.cmi = new ThreadPoolExecutor(i, 32, 120, TimeUnit.SECONDS, this.cmj, new C41776g());
        this.cmi.setMaximumPoolSize(32);
        C45174b.m83210i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(i));
        AppMethodBeat.m2505o(137077);
    }

    private void setCorePoolSize(int i) {
        AppMethodBeat.m2504i(137078);
        if (i > 32) {
            this.cml = 32;
        } else if (i < 4) {
            this.cml = 4;
        } else {
            this.cml = i;
        }
        C45174b.m83210i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i));
        this.cmi.setCorePoolSize(i);
        AppMethodBeat.m2505o(137078);
    }

    /* renamed from: a */
    public static void m73746a(C41778i c41778i) {
        AppMethodBeat.m2504i(137079);
        C41777h DQ = C41777h.m73745DQ();
        synchronized (DQ.lock) {
            try {
                c41778i.reset();
                DQ.cmk.add(c41778i);
                int i = DQ.cml;
                if (DQ.cmk.size() > i) {
                    DQ.setCorePoolSize(i + 2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137079);
            }
        }
        DQ.cmi.execute(c41778i);
    }

    /* renamed from: b */
    public static void m73747b(C41778i c41778i) {
        AppMethodBeat.m2504i(137080);
        C41777h DQ = C41777h.m73745DQ();
        synchronized (DQ.lock) {
            try {
                DQ.cmk.remove(c41778i);
                if (DQ.cmk.size() <= 4) {
                    DQ.cml = 4;
                    DQ.setCorePoolSize(DQ.cml);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137080);
            }
        }
        DQ.cmi.remove(c41778i);
    }
}
