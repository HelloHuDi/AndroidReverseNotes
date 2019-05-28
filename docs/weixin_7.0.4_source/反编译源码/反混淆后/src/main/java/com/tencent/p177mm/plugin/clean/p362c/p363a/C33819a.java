package com.tencent.p177mm.plugin.clean.p362c.p363a;

import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.clean.c.a.a */
public abstract class C33819a implements Runnable {
    private long iBv = 0;
    private C33820a kwK;
    C2805c kwL;

    /* renamed from: com.tencent.mm.plugin.clean.c.a.a$a */
    public interface C33820a {
        /* renamed from: a */
        void mo35472a(C33819a c33819a);
    }

    public abstract void execute();

    public String alb() {
        return this.iBv;
    }

    public C33819a(C33820a c33820a) {
        this.kwK = c33820a;
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        try {
            this.iBv = C5046bo.m7588yz();
            execute();
            this.iBv = C5046bo.m7525az(this.iBv);
            if (this.kwL != null) {
                this.kwL.mo6924f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.mo35472a(this);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AbstractTask", e, "", new Object[0]);
            if (this.kwL != null) {
                this.kwL.mo6924f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.mo35472a(this);
            }
        } catch (Throwable th) {
            if (this.kwL != null) {
                this.kwL.mo6924f(Long.valueOf(Thread.currentThread().getId()));
            }
            if (this.kwK != null) {
                this.kwK.mo35472a(this);
            }
            throw th;
        }
    }
}
