package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a implements Runnable {
    private long iBv = 0;
    private a kwK;
    c kwL;

    public interface a {
        void a(a aVar);
    }

    public abstract void execute();

    public String alb() {
        return this.iBv;
    }

    public a(a aVar) {
        this.kwK = aVar;
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        try {
            this.iBv = bo.yz();
            execute();
            this.iBv = bo.az(this.iBv);
            if (this.kwL != null) {
                this.kwL.f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.a(this);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AbstractTask", e, "", new Object[0]);
            if (this.kwL != null) {
                this.kwL.f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.a(this);
            }
        } catch (Throwable th) {
            if (this.kwL != null) {
                this.kwL.f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.a(this);
            }
            throw th;
        }
    }
}
