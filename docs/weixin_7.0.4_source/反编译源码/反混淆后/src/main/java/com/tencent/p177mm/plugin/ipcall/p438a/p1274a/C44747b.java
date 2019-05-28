package com.tencent.p177mm.plugin.ipcall.p438a.p1274a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a.C28323a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.ipcall.a.a.b */
public abstract class C44747b extends C43218a implements C28323a {
    protected boolean fVc = false;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    public C28324a nws = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.a.b$a */
    public interface C28324a {
        /* renamed from: a */
        void mo46236a(int i, C1207m c1207m, int i2, int i3);

        /* renamed from: b */
        void mo46237b(int i, C1207m c1207m, int i2, int i3);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.a.b$1 */
    class C343651 implements Runnable {
        C343651() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21791);
            C44747b.this.mo24088b(C44747b.this.nvN);
            AppMethodBeat.m2505o(21791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.a.b$2 */
    class C343662 implements Runnable {
        C343662() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21792);
            C44747b.this.mo24088b(C44747b.this.nvN);
            AppMethodBeat.m2505o(21792);
        }
    }

    /* renamed from: b */
    public abstract void mo24088b(C43219c c43219c);

    public abstract int bHD();

    public abstract void bHE();

    public abstract void bHF();

    public abstract void onStop();

    public final void init() {
        mo68721a((C28323a) this);
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    /* renamed from: a */
    public final void mo68722a(C43219c c43219c) {
        super.mo68722a(c43219c);
        this.fVc = true;
        C4990ab.m7411d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", Integer.valueOf(getServiceType()));
    }

    public final void stop() {
        this.fVc = false;
        onStop();
        C4990ab.m7411d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", Integer.valueOf(getServiceType()));
    }

    /* renamed from: a */
    public final void mo46234a(int i, Object obj, int i2, int i3) {
        C4990ab.m7417i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i), Boolean.valueOf(this.fVc), Integer.valueOf(bHD()));
        bHE();
        if (this.nws != null) {
            this.nws.mo46236a(i, (C1207m) obj, i2, i3);
        }
        if (this.fVc) {
            this.mHandler.postDelayed(new C343651(), (long) bHD());
        }
    }

    /* renamed from: b */
    public final void mo46235b(int i, Object obj, int i2, int i3) {
        C4990ab.m7417i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i), Boolean.valueOf(this.fVc), Integer.valueOf(bHD()));
        bHF();
        if (this.nws != null) {
            this.nws.mo46237b(i, (C1207m) obj, i2, i3);
        }
        if (this.fVc) {
            this.mHandler.postDelayed(new C343662(), (long) bHD());
        }
    }
}
