package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.SummaryBelowPreference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.RightBelowPreference */
public class RightBelowPreference extends SummaryBelowPreference {
    private CharSequence tqM;

    public RightBelowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightBelowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(46204);
        View onCreateView = super.onCreateView(viewGroup);
        ((ViewGroup) ((ViewGroup) onCreateView.findViewById(2131821019)).findViewById(16908312)).addView((ViewGroup) View.inflate(this.mContext, 2130971155, null));
        AppMethodBeat.m2505o(46204);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(46205);
        super.onBindView(view);
        if (!C5046bo.m7519ac(this.tqM)) {
            ((TextView) view.findViewById(2131829016)).setText(this.tqM);
        }
        view.findViewById(2131821517).setVisibility(8);
        AppMethodBeat.m2505o(46205);
    }

    /* renamed from: L */
    public final void mo56186L(CharSequence charSequence) {
        AppMethodBeat.m2504i(46206);
        this.tqM = charSequence;
        notifyChanged();
        AppMethodBeat.m2505o(46206);
    }
}
