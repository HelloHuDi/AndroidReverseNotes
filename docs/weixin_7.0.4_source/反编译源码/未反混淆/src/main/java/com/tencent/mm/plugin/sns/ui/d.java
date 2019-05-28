package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T> {
    private ak handler;
    List<Integer> rga;

    /* renamed from: com.tencent.mm.plugin.sns.ui.d$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean rge;

        AnonymousClass3(boolean z) {
            this.rge = z;
        }

        public final void run() {
            AppMethodBeat.i(38079);
            if (this.rge) {
                d dVar = d.this;
                if (dVar.rga.size() > 1) {
                    dVar.rga.remove(0);
                }
            }
            AppMethodBeat.o(38079);
        }
    }

    public abstract List<T> Kx();

    public abstract void dq(List<T> list);

    public d() {
        this.handler = null;
        this.rga = new LinkedList();
        this.handler = af.bCo();
        this.rga.clear();
    }

    /* Access modifiers changed, original: protected|final */
    public final void hM(final boolean z) {
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
                ab.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            ab.d("MicroMsg.AdapterLoader", "thread load" + this.rga.size());
        } else {
            ab.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.rga.size() <= 1) {
            this.rga.add(Integer.valueOf(i));
            if (z) {
                af.cno().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38077);
                        d.this.dp(d.this.Kx());
                        AppMethodBeat.o(38077);
                    }
                });
            } else {
                dp(Kx());
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dp(final List<T> list) {
        this.handler.post(new Runnable() {
            final /* synthetic */ boolean rge = true;

            public final void run() {
                AppMethodBeat.i(38078);
                d.this.dq(list);
                af.cno().post(new AnonymousClass3(this.rge));
                AppMethodBeat.o(38078);
            }
        });
    }
}
