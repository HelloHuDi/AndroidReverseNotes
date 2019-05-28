package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;

public final class b {
    private Rect eAp = new Rect();
    private int maxHeight;
    private int sjj;
    private View view;
    private a zLV;
    private boolean zLW = false;
    private int zLX;
    private int zLY;
    private int zLZ;
    Runnable zMa;
    Runnable zMb;

    public interface a {
        void m(boolean z, int i);
    }

    public b(View view, a aVar) {
        AppMethodBeat.i(107853);
        this.view = view;
        this.zLV = aVar;
        this.zLZ = ae.fr(view.getContext());
        this.sjj = x.gq(view.getContext());
        AppMethodBeat.o(107853);
    }

    public final void PR(int i) {
        AppMethodBeat.i(107854);
        if (!dKz() || isInMultiWindowMode()) {
            ab.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
            AppMethodBeat.o(107854);
            return;
        }
        boolean z;
        int i2 = this.zLX;
        int height = this.eAp.height();
        this.zLX = MeasureSpec.getSize(i);
        this.view.getWindowVisibleDisplayFrame(this.eAp);
        if (!this.zLW) {
            this.zLW = height != this.eAp.bottom;
        }
        this.zLY = this.eAp.bottom;
        if (this.zLY > this.maxHeight - this.zLZ) {
            this.maxHeight = this.zLY;
        }
        height = this.maxHeight - this.zLY;
        if (height > this.zLZ) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.sjj = height;
        }
        if (height == this.zLZ) {
            this.zLV.m(false, this.sjj - height);
        } else {
            this.zLV.m(height > this.zLZ, this.sjj);
        }
        if ((this.zLW && i2 > this.zLX + this.zLZ) || i2 < this.zLX - this.zLZ) {
            ab.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", Boolean.valueOf(z));
            this.zLW = false;
            if (z) {
                if (this.zMa != null) {
                    this.zMa.run();
                    this.zMa = null;
                    AppMethodBeat.o(107854);
                    return;
                }
            } else if (this.zMb != null) {
                this.zMb.run();
                this.zMb = null;
            }
        }
        AppMethodBeat.o(107854);
    }

    public final void az(Runnable runnable) {
        AppMethodBeat.i(107855);
        this.zMa = runnable;
        this.zMb = null;
        this.view.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(107851);
                if (b.this.zMa != null) {
                    ab.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
                    b.this.zMa.run();
                    b.this.zMa = null;
                }
                AppMethodBeat.o(107851);
            }
        }, 200);
        AppMethodBeat.o(107855);
    }

    public final void aA(Runnable runnable) {
        AppMethodBeat.i(107856);
        this.zMb = runnable;
        this.zMa = null;
        this.view.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(107852);
                if (b.this.zMb != null) {
                    ab.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
                    b.this.zMb.run();
                    b.this.zMb = null;
                }
                AppMethodBeat.o(107852);
            }
        }, 200);
        AppMethodBeat.o(107856);
    }

    private boolean dKz() {
        AppMethodBeat.i(107857);
        boolean gu = x.gu(this.view.getContext());
        AppMethodBeat.o(107857);
        return gu;
    }

    private boolean isInMultiWindowMode() {
        AppMethodBeat.i(107858);
        if (d.iW(24) && (this.view.getContext() instanceof Activity)) {
            boolean isInMultiWindowMode = ((Activity) this.view.getContext()).isInMultiWindowMode();
            AppMethodBeat.o(107858);
            return isInMultiWindowMode;
        }
        AppMethodBeat.o(107858);
        return false;
    }
}
