package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference extends Preference {
    TextView gng;
    private LayoutInflater mInflater;
    TextView uZu;

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(48717);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(48717);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(48718);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.b6n, viewGroup2);
        AppMethodBeat.o(48718);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(48719);
        super.onBindView(view);
        this.gng = (TextView) view.findViewById(R.id.fi3);
        this.uZu = (TextView) view.findViewById(R.id.fi2);
        AppMethodBeat.o(48719);
    }
}
