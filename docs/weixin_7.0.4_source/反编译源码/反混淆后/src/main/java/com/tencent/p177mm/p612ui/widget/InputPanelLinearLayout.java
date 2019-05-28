package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.C40903b.C36360a;

/* renamed from: com.tencent.mm.ui.widget.InputPanelLinearLayout */
public class InputPanelLinearLayout extends LinearLayout implements C36360a {
    private C40903b zLU;

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107859);
        this.zLU = new C40903b(this, this);
        AppMethodBeat.m2505o(107859);
    }

    public C40903b getInputPanelHelper() {
        return this.zLU;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107860);
        this.zLU.mo64516PR(i2);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(107860);
    }

    /* renamed from: m */
    public void mo39878m(boolean z, int i) {
    }
}
