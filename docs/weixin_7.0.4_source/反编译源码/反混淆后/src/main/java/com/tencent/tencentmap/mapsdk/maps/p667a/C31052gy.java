package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gy */
public class C31052gy extends Thread {
    /* renamed from: a */
    private C46789gm f14152a;
    /* renamed from: b */
    private boolean f14153b = false;
    /* renamed from: c */
    private boolean f14154c = false;
    /* renamed from: d */
    private byte[] f14155d = null;

    public C31052gy(C46789gm c46789gm) {
        this.f14152a = c46789gm;
    }

    public void run() {
        AppMethodBeat.m2504i(99499);
        while (!this.f14153b) {
            if (this.f14154c) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(99499);
                }
            } else if (!m49917d()) {
                try {
                    C31052gy.sleep(160);
                } catch (InterruptedException e2) {
                }
            }
        }
        mo50385c();
        if (this.f14155d != null) {
            synchronized (this.f14155d) {
                try {
                    this.f14155d.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99499);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(99499);
    }

    /* renamed from: a */
    public void mo50383a(byte[] bArr) {
        AppMethodBeat.m2504i(99500);
        this.f14155d = bArr;
        this.f14153b = true;
        interrupt();
        AppMethodBeat.m2505o(99500);
    }

    /* renamed from: a */
    public void mo50382a() {
        this.f14154c = true;
    }

    /* renamed from: b */
    public void mo50384b() {
        AppMethodBeat.m2504i(99501);
        this.f14154c = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99501);
            }
        }
    }

    /* renamed from: c */
    public void mo50385c() {
    }

    /* renamed from: d */
    private boolean m49917d() {
        AppMethodBeat.m2504i(99502);
        if (this.f14152a != null) {
            boolean j = this.f14152a.mo75457j();
            AppMethodBeat.m2505o(99502);
            return j;
        }
        AppMethodBeat.m2505o(99502);
        return false;
    }
}
