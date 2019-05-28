package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.view.View;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.a */
public abstract class C27336a implements C10914l {
    C27335a iLV;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.a$a */
    interface C27335a {
        /* renamed from: a */
        void mo45018a(C27336a c27336a, View view, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.a$1 */
    static class C273371 extends C27336a {
        C273371() {
        }

        /* renamed from: eH */
        public final void mo6421eH(boolean z) {
        }

        public final void aNh() {
        }

        public final void onDetached() {
        }

        public final void onResume() {
        }

        public final View aNi() {
            return null;
        }

        /* renamed from: pS */
        public final void mo6437pS(int i) {
        }

        /* renamed from: pT */
        public final void mo6438pT(int i) {
        }
    }

    public abstract void aNh();

    public abstract View aNi();

    public abstract void onDetached();

    public abstract void onResume();

    /* renamed from: pS */
    public abstract void mo6437pS(int i);

    /* renamed from: pT */
    public abstract void mo6438pT(int i);

    C27336a() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: eG */
    public final void mo45020eG(boolean z) {
        if (aNi() != null) {
            if (z) {
                if (aNi().getVisibility() != 0) {
                    aNi().setVisibility(0);
                }
            } else if (aNi().getVisibility() != 8) {
                aNi().setVisibility(8);
            }
            if (this.iLV != null) {
                this.iLV.mo45018a(this, aNi(), z);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aNj() {
        if (aNi() != null && aNi().getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
