package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;

public final class d extends b {
    private int iUG = 0;
    private boolean iUU = false;
    private int iUV;
    private boolean iUW = false;
    private Integer iUX = null;
    private boolean irI = true;

    final class a extends ColorDrawable {
        a() {
            super(0);
        }

        public final void setColor(int i) {
            AppMethodBeat.i(87484);
            super.setColor(i);
            aOP();
            AppMethodBeat.o(87484);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.i(87485);
            super.setAlpha(i);
            aOP();
            AppMethodBeat.o(87485);
        }

        private void aOP() {
            AppMethodBeat.i(87486);
            d.this.setStatusBarColor(getColor());
            AppMethodBeat.o(87486);
        }
    }

    public d(Context context) {
        super(context);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(87487);
        super.onViewAdded(view);
        if (view instanceof b) {
            view.setBackground(new a());
            AppMethodBeat.o(87487);
            return;
        }
        IllegalAccessError illegalAccessError = new IllegalAccessError("Cant add non ActionBar instance here");
        AppMethodBeat.o(87487);
        throw illegalAccessError;
    }

    private b getActionBar() {
        AppMethodBeat.i(87488);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(87488);
            return null;
        }
        b bVar = (b) getChildAt(0);
        AppMethodBeat.o(87488);
        return bVar;
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean canAnimate() {
        return false;
    }

    public final void setStatusBarForegroundStyle(boolean z) {
        AppMethodBeat.i(87489);
        if (getActionBar() == null) {
            AppMethodBeat.o(87489);
            return;
        }
        K(getActionBar().getBackgroundColor(), z);
        AppMethodBeat.o(87489);
    }

    public final void setStatusBarColor(int i) {
        AppMethodBeat.i(87490);
        K(i, this.iUU);
        AppMethodBeat.o(87490);
    }

    public final void K(int i, boolean z) {
        AppMethodBeat.i(87491);
        this.iUG = i;
        this.iUU = z;
        if (this.irI) {
            super.a(i, z, true);
            AppMethodBeat.o(87491);
            return;
        }
        if (!this.iUW) {
            super.a(i, z, false);
        }
        AppMethodBeat.o(87491);
    }

    public final void aOO() {
        AppMethodBeat.i(87492);
        K(this.iUG, this.iUU);
        AppMethodBeat.o(87492);
    }

    public final void setActuallyVisible(boolean z) {
        AppMethodBeat.i(87493);
        boolean z2 = z != this.irI;
        this.irI = z;
        if (z2 && z) {
            aOO();
            setDeferStatusBarHeightChange(false);
            setWillNotDraw(false);
        }
        if (z2 && !z) {
            setDeferStatusBarHeightChange(true);
        }
        AppMethodBeat.o(87493);
    }

    public final void setDeferStatusBarHeightChange(boolean z) {
        AppMethodBeat.i(87494);
        Object obj = z != this.iUW ? 1 : null;
        this.iUW = z;
        if (!(obj == null || z)) {
            super.pO(this.iUV);
        }
        AppMethodBeat.o(87494);
    }

    public final void pO(int i) {
        AppMethodBeat.i(87495);
        if (this.iUX != null) {
            int intValue = this.iUX.intValue();
            this.iUV = intValue;
            super.pO(intValue);
            AppMethodBeat.o(87495);
            return;
        }
        this.iUV = i;
        if (this.iUW) {
            AppMethodBeat.o(87495);
            return;
        }
        super.pO(i);
        AppMethodBeat.o(87495);
    }

    public final void setForceTopInsetsHeight(int i) {
        AppMethodBeat.i(87496);
        this.iUX = Integer.valueOf(i);
        AppMethodBeat.o(87496);
    }
}
