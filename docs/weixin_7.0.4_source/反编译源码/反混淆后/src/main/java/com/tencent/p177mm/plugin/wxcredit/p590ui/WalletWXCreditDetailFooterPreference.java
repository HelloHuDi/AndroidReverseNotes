package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference */
public class WalletWXCreditDetailFooterPreference extends Preference implements OnClickListener {
    private LayoutInflater mInflater;
    OnClickListener qqV;
    private TextView uZs;
    private TextView uZt;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(48713);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(48713);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(48714);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(2130971186, viewGroup2);
        AppMethodBeat.m2505o(48714);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(48715);
        super.onBindView(view);
        this.uZs = (TextView) view.findViewById(2131829090);
        this.uZt = (TextView) view.findViewById(2131829091);
        this.uZs.setOnClickListener(this);
        this.uZt.setOnClickListener(this);
        AppMethodBeat.m2505o(48715);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(48716);
        if (this.qqV != null) {
            this.qqV.onClick(view);
        }
        AppMethodBeat.m2505o(48716);
    }
}
