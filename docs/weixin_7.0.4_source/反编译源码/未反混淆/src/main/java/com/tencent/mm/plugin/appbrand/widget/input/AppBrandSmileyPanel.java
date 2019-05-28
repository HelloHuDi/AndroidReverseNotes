package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

public final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase implements e {
    private int jfI = -1;
    private int jfJ = -1;
    private boolean mInLayout = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int getPanelHeightInLandscape() {
        AppMethodBeat.i(134275);
        getManager();
        int[] aMw = c.aMw();
        int min;
        if (this.jfJ <= 0 || this.jfJ >= aMw[1]) {
            min = (Math.min(aMw[0], aMw[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.dimen.em);
            AppMethodBeat.o(134275);
            return min;
        }
        min = this.jfJ;
        AppMethodBeat.o(134275);
        return min;
    }

    private int getPanelDefaultHeightInPort() {
        AppMethodBeat.i(134276);
        if (this.jfI < 0) {
            this.jfI = x.gs(getContext());
        }
        int i;
        if (this.jfI > 0) {
            i = this.jfI;
            AppMethodBeat.o(134276);
            return i;
        }
        getManager();
        int[] aMw = c.aMw();
        i = (Math.max(aMw[0], aMw[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.dimen.em);
        this.jfI = i;
        AppMethodBeat.o(134276);
        return i;
    }

    public final View getPanelView() {
        return this;
    }

    public final boolean qD(int i) {
        if (i <= 0 || this.jfJ == i) {
            return false;
        }
        this.jfJ = i;
        return true;
    }

    public final int getForcedPanelHeight() {
        return this.jfJ;
    }

    public final int getAppropriateHeightInPort() {
        AppMethodBeat.i(134277);
        int i;
        if (this.jfJ > 0) {
            i = this.jfJ;
            AppMethodBeat.o(134277);
            return i;
        }
        i = getPanelDefaultHeightInPort();
        AppMethodBeat.o(134277);
        return i;
    }

    public final c aQY() {
        AppMethodBeat.i(134278);
        ak akVar = new ak();
        AppMethodBeat.o(134278);
        return akVar;
    }

    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(134279);
        if (isShown()) {
            du(i, MeasureSpec.makeMeasureSpec(!x.gu(getContext()) ? getPanelHeightInLandscape() : getAppropriateHeightInPort(), ErrorDialogData.SUPPRESSED));
            AppMethodBeat.o(134279);
            return;
        }
        du(i, MeasureSpec.makeMeasureSpec(0, j.INVALID_ID));
        AppMethodBeat.o(134279);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(134280);
        qG(i);
        if (i == 0) {
            initView();
        }
        AppMethodBeat.o(134280);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(134281);
        this.mInLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = false;
        AppMethodBeat.o(134281);
    }

    public final boolean aQZ() {
        AppMethodBeat.i(134282);
        boolean isInLayout;
        if (d.iW(18)) {
            isInLayout = super.isInLayout();
            AppMethodBeat.o(134282);
            return isInLayout;
        }
        isInLayout = this.mInLayout;
        AppMethodBeat.o(134282);
        return isInLayout;
    }

    public final boolean aQV() {
        AppMethodBeat.i(134283);
        ab.d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", Integer.valueOf(this.jfJ), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()));
        if (this.jfJ <= 0 || this.jfJ != getMeasuredHeight()) {
            AppMethodBeat.o(134283);
            return false;
        }
        AppMethodBeat.o(134283);
        return true;
    }
}
