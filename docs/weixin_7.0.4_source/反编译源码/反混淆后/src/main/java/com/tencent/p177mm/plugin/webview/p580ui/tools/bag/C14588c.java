package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43946a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.c */
public final class C14588c {
    C43945g uyr;
    C43943f uys;
    float uyt;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.c$1 */
    class C145891 implements C43946a {
        C145891() {
        }

        /* renamed from: bg */
        public final void mo26833bg(float f) {
            float f2 = 1.0f;
            AppMethodBeat.m2504i(8150);
            C43943f c43943f = C14588c.this.uys;
            if (f < 0.15f) {
                f2 = 0.0f;
            } else {
                float f3 = 2.0f * f;
                if (f3 <= 1.0f) {
                    f2 = f3;
                }
            }
            c43943f.mo69625bh(f2);
            AppMethodBeat.m2505o(8150);
        }

        /* renamed from: l */
        public final void mo26834l(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8151);
            C14588c.this.uyt = motionEvent.getRawX();
            AppMethodBeat.m2505o(8151);
        }

        /* renamed from: ba */
        public final boolean mo26832ba(boolean z) {
            AppMethodBeat.m2504i(8152);
            if (z) {
                C14588c.this.uys.mo69625bh(1.0f);
                C14588c.this.uys.mo69626d(C14588c.this.uyt, 21);
                AppMethodBeat.m2505o(8152);
                return true;
            }
            C14588c.this.uys.mo69625bh(0.0f);
            AppMethodBeat.m2505o(8152);
            return false;
        }
    }

    public C14588c(C43945g c43945g, C43943f c43943f) {
        this.uyr = c43945g;
        this.uys = c43943f;
    }
}
