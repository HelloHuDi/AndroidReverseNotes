package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.SummaryBelowPreference */
public class SummaryBelowPreference extends Preference {
    private View mView;

    public SummaryBelowPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SummaryBelowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107290);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107290);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107291);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, 2130970204, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.m2505o(107291);
        return view;
    }
}
