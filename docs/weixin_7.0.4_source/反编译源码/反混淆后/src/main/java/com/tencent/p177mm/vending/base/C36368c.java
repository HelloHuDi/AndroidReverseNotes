package com.tencent.p177mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p640f.C5687a;

/* renamed from: com.tencent.mm.vending.base.c */
public final class C36368c {
    /* renamed from: b */
    private Looper f15103b;
    /* renamed from: c */
    private Handler f15104c;
    /* renamed from: d */
    private Handler f15105d;
    /* renamed from: e */
    byte[] f15106e = new byte[0];
    C36369a zXA;
    private Looper zXz;

    /* renamed from: com.tencent.mm.vending.base.c$a */
    public interface C36369a {
        void dMc();

        void dMd();

        void synchronizing(int i, Object obj);
    }

    public C36368c(Looper looper, Looper looper2) {
        AppMethodBeat.m2504i(126148);
        this.zXz = looper;
        this.f15103b = looper2;
        this.f15104c = new Handler(this.zXz) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(126162);
                C36368c.this.mo57287s(message.what, message.obj);
                AppMethodBeat.m2505o(126162);
            }
        };
        this.f15105d = new Handler(this.f15103b) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(126153);
                synchronized (C36368c.this.f15106e) {
                    try {
                        if (C36368c.this.zXA != null) {
                            C36368c.this.zXA.synchronizing(message.what, message.obj);
                        }
                        C36368c.this.f15106e.notify();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(126153);
                    }
                }
            }
        };
        AppMethodBeat.m2505o(126148);
    }

    /* renamed from: s */
    public final void mo57287s(int i, Object obj) {
        AppMethodBeat.m2504i(126149);
        if (Looper.myLooper() == this.zXz) {
            if (this.zXA == null) {
                C5687a.m8543w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                AppMethodBeat.m2505o(126149);
                return;
            }
            this.zXA.dMc();
            synchronized (this.f15106e) {
                try {
                    this.f15105d.sendMessageAtFrontOfQueue(this.f15105d.obtainMessage(i, obj));
                    try {
                        this.f15106e.wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126149);
                }
            }
            this.zXA.dMd();
        } else if (Looper.myLooper() == this.f15103b) {
            this.f15104c.sendMessageAtFrontOfQueue(this.f15104c.obtainMessage(i, obj));
            AppMethodBeat.m2505o(126149);
        } else {
            AppMethodBeat.m2505o(126149);
        }
    }
}
