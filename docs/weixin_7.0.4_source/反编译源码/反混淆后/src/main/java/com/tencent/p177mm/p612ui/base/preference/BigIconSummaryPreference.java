package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.ui.base.preference.BigIconSummaryPreference */
public class BigIconSummaryPreference extends IconSummaryPreference {
    public BigIconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BigIconSummaryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107130);
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(C25738R.dimen.f9960li));
        AppMethodBeat.m2505o(107130);
        return onCreateView;
    }
}
