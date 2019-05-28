package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

public abstract class a implements l {
    a iLV;

    interface a {
        void a(a aVar, View view, boolean z);
    }

    public abstract void aNh();

    public abstract View aNi();

    public abstract void onDetached();

    public abstract void onResume();

    public abstract void pS(int i);

    public abstract void pT(int i);

    a() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void eG(boolean z) {
        if (aNi() != null) {
            if (z) {
                if (aNi().getVisibility() != 0) {
                    aNi().setVisibility(0);
                }
            } else if (aNi().getVisibility() != 8) {
                aNi().setVisibility(8);
            }
            if (this.iLV != null) {
                this.iLV.a(this, aNi(), z);
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
