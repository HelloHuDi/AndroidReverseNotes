package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailHeaderPreference */
public class WalletWXCreditDetailHeaderPreference extends Preference {
    TextView gng;
    private LayoutInflater mInflater;
    TextView uZu;

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(48717);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(48717);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(48718);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(2130971187, viewGroup2);
        AppMethodBeat.m2505o(48718);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(48719);
        super.onBindView(view);
        this.gng = (TextView) view.findViewById(2131829093);
        this.uZu = (TextView) view.findViewById(2131829092);
        AppMethodBeat.m2505o(48719);
    }
}
