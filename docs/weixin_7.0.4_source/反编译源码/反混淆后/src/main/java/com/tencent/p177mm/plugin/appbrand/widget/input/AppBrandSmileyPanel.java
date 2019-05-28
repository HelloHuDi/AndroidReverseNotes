package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27414c;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27415e;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.AppBrandSmileyPanel */
public final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase implements C27415e {
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
        AppMethodBeat.m2504i(134275);
        getManager();
        int[] aMw = C27414c.aMw();
        int min;
        if (this.jfJ <= 0 || this.jfJ >= aMw[1]) {
            min = (Math.min(aMw[0], aMw[1]) / 2) - getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9755em);
            AppMethodBeat.m2505o(134275);
            return min;
        }
        min = this.jfJ;
        AppMethodBeat.m2505o(134275);
        return min;
    }

    private int getPanelDefaultHeightInPort() {
        AppMethodBeat.m2504i(134276);
        if (this.jfI < 0) {
            this.jfI = C40619x.m70073gs(getContext());
        }
        int i;
        if (this.jfI > 0) {
            i = this.jfI;
            AppMethodBeat.m2505o(134276);
            return i;
        }
        getManager();
        int[] aMw = C27414c.aMw();
        i = (Math.max(aMw[0], aMw[1]) / 2) - getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9755em);
        this.jfI = i;
        AppMethodBeat.m2505o(134276);
        return i;
    }

    public final View getPanelView() {
        return this;
    }

    /* renamed from: qD */
    public final boolean mo22694qD(int i) {
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
        AppMethodBeat.m2504i(134277);
        int i;
        if (this.jfJ > 0) {
            i = this.jfJ;
            AppMethodBeat.m2505o(134277);
            return i;
        }
        i = getPanelDefaultHeightInPort();
        AppMethodBeat.m2505o(134277);
        return i;
    }

    public final C27414c aQY() {
        AppMethodBeat.m2504i(134278);
        C38596ak c38596ak = new C38596ak();
        AppMethodBeat.m2505o(134278);
        return c38596ak;
    }

    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(134279);
        if (isShown()) {
            mo61393du(i, MeasureSpec.makeMeasureSpec(!C40619x.m70075gu(getContext()) ? getPanelHeightInLandscape() : getAppropriateHeightInPort(), ErrorDialogData.SUPPRESSED));
            AppMethodBeat.m2505o(134279);
            return;
        }
        mo61393du(i, MeasureSpec.makeMeasureSpec(0, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(134279);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(134280);
        mo61399qG(i);
        if (i == 0) {
            initView();
        }
        AppMethodBeat.m2505o(134280);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(134281);
        this.mInLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = false;
        AppMethodBeat.m2505o(134281);
    }

    public final boolean aQZ() {
        AppMethodBeat.m2504i(134282);
        boolean isInLayout;
        if (C1443d.m3068iW(18)) {
            isInLayout = super.isInLayout();
            AppMethodBeat.m2505o(134282);
            return isInLayout;
        }
        isInLayout = this.mInLayout;
        AppMethodBeat.m2505o(134282);
        return isInLayout;
    }

    public final boolean aQV() {
        AppMethodBeat.m2504i(134283);
        C4990ab.m7411d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", Integer.valueOf(this.jfJ), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()));
        if (this.jfJ <= 0 || this.jfJ != getMeasuredHeight()) {
            AppMethodBeat.m2505o(134283);
            return false;
        }
        AppMethodBeat.m2505o(134283);
        return true;
    }
}
