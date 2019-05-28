package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(48713);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(48713);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(48714);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.b6m, viewGroup2);
        AppMethodBeat.o(48714);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(48715);
        super.onBindView(view);
        this.uZs = (TextView) view.findViewById(R.id.fi0);
        this.uZt = (TextView) view.findViewById(R.id.fi1);
        this.uZs.setOnClickListener(this);
        this.uZt.setOnClickListener(this);
        AppMethodBeat.o(48715);
    }

    public void onClick(View view) {
        AppMethodBeat.i(48716);
        if (this.qqV != null) {
            this.qqV.onClick(view);
        }
        AppMethodBeat.o(48716);
    }
}
