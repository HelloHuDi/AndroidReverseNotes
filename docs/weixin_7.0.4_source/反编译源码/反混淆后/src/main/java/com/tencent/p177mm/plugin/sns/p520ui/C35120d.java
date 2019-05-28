package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.d */
public abstract class C35120d<T> {
    private C7306ak handler;
    List<Integer> rga;

    /* renamed from: com.tencent.mm.plugin.sns.ui.d$3 */
    class C220793 implements Runnable {
        final /* synthetic */ boolean rge;

        C220793(boolean z) {
            this.rge = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(38079);
            if (this.rge) {
                C35120d c35120d = C35120d.this;
                if (c35120d.rga.size() > 1) {
                    c35120d.rga.remove(0);
                }
            }
            AppMethodBeat.m2505o(38079);
        }
    }

    /* renamed from: Kx */
    public abstract List<T> mo55747Kx();

    /* renamed from: dq */
    public abstract void mo55749dq(List<T> list);

    public C35120d() {
        this.handler = null;
        this.rga = new LinkedList();
        this.handler = C13373af.bCo();
        this.rga.clear();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: hM */
    public final void mo55750hM(final boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            Object obj;
            for (Integer intValue : this.rga) {
                if (intValue.intValue() == 1) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                C4990ab.m7412e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            C4990ab.m7410d("MicroMsg.AdapterLoader", "thread load" + this.rga.size());
        } else {
            C4990ab.m7410d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.rga.size() <= 1) {
            this.rga.add(Integer.valueOf(i));
            if (z) {
                C13373af.cno().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(38077);
                        C35120d.this.mo55748dp(C35120d.this.mo55747Kx());
                        AppMethodBeat.m2505o(38077);
                    }
                });
            } else {
                mo55748dp(mo55747Kx());
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dp */
    public final void mo55748dp(final List<T> list) {
        this.handler.post(new Runnable() {
            final /* synthetic */ boolean rge = true;

            public final void run() {
                AppMethodBeat.m2504i(38078);
                C35120d.this.mo55749dq(list);
                C13373af.cno().post(new C220793(this.rge));
                AppMethodBeat.m2505o(38078);
            }
        });
    }
}
