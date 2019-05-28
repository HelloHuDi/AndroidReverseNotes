package com.tencent.p177mm.p178a;

import android.os.HandlerThread;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.a.b */
public class C1170b {
    static C7306ak cbT;
    File cbQ;
    private ReentrantLock cbR = new ReentrantLock();
    private Condition cbS = this.cbR.newCondition();

    public C1170b(final String str) {
        synchronized (C1170b.class) {
            if (cbT == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                cbT = new C7306ak(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.cbQ = file;
            return;
        }
        C4990ab.m7417i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        cbT.post(new Runnable() {
            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    C1173e.m2565cx(str);
                    C4990ab.m7417i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        C4990ab.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    C4990ab.m7417i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                C1170b.this.cbR.lock();
                try {
                    C1170b.this.cbQ = file;
                    C1170b.this.cbS.signal();
                    C4990ab.m7417i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    C1170b.this.cbR.unlock();
                }
            }
        });
    }

    public final File getFile() {
        this.cbR.lock();
        while (this.cbQ == null) {
            try {
                C4990ab.m7416i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.cbS.await();
            } catch (Exception e) {
            } finally {
                this.cbR.unlock();
            }
        }
        return this.cbQ;
    }
}
