package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static ak cbT;
    File cbQ;
    private ReentrantLock cbR = new ReentrantLock();
    private Condition cbS = this.cbR.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (cbT == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                cbT = new ak(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.cbQ = file;
            return;
        }
        ab.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        cbT.post(new Runnable() {
            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.cx(str);
                    ab.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        ab.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    ab.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                b.this.cbR.lock();
                try {
                    b.this.cbQ = file;
                    b.this.cbS.signal();
                    ab.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    b.this.cbR.unlock();
                }
            }
        });
    }

    public final File getFile() {
        this.cbR.lock();
        while (this.cbQ == null) {
            try {
                ab.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.cbS.await();
            } catch (Exception e) {
            } finally {
                this.cbR.unlock();
            }
        }
        return this.cbQ;
    }
}
