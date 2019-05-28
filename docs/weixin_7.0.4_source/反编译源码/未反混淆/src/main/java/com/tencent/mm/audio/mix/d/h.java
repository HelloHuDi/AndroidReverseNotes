package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h {
    private static h cmh;
    private ThreadPoolExecutor cmi;
    private PriorityBlockingQueue<Runnable> cmj = new PriorityBlockingQueue(33);
    private LinkedList<i> cmk = new LinkedList();
    private int cml;
    private Object lock = new Object();

    public static h DQ() {
        AppMethodBeat.i(137076);
        if (cmh == null) {
            synchronized (h.class) {
                try {
                    if (cmh == null) {
                        cmh = new h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(137076);
                    }
                }
            }
        }
        h hVar = cmh;
        AppMethodBeat.o(137076);
        return hVar;
    }

    private h() {
        int i = 8;
        AppMethodBeat.i(137077);
        b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        int i2 = (i2 * 2) + 2;
        if (i2 > 32) {
            i = 32;
        } else if (i2 >= 8) {
            i = i2;
        }
        this.cml = i;
        this.cmi = new ThreadPoolExecutor(i, 32, 120, TimeUnit.SECONDS, this.cmj, new g());
        this.cmi.setMaximumPoolSize(32);
        b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(i));
        AppMethodBeat.o(137077);
    }

    private void setCorePoolSize(int i) {
        AppMethodBeat.i(137078);
        if (i > 32) {
            this.cml = 32;
        } else if (i < 4) {
            this.cml = 4;
        } else {
            this.cml = i;
        }
        b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i));
        this.cmi.setCorePoolSize(i);
        AppMethodBeat.o(137078);
    }

    public static void a(i iVar) {
        AppMethodBeat.i(137079);
        h DQ = DQ();
        synchronized (DQ.lock) {
            try {
                iVar.reset();
                DQ.cmk.add(iVar);
                int i = DQ.cml;
                if (DQ.cmk.size() > i) {
                    DQ.setCorePoolSize(i + 2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137079);
            }
        }
        DQ.cmi.execute(iVar);
    }

    public static void b(i iVar) {
        AppMethodBeat.i(137080);
        h DQ = DQ();
        synchronized (DQ.lock) {
            try {
                DQ.cmk.remove(iVar);
                if (DQ.cmk.size() <= 4) {
                    DQ.cml = 4;
                    DQ.setCorePoolSize(DQ.cml);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137080);
            }
        }
        DQ.cmi.remove(iVar);
    }
}
