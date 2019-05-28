package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private String gDV;
    private TextView iDT;
    private String mTitle;
    private TextView plD;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23395);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(23395);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23396);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aew, viewGroup2);
        AppMethodBeat.o(23396);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23397);
        this.iDT = (TextView) view.findViewById(R.id.cx);
        this.plD = (TextView) view.findViewById(R.id.g0);
        if (this.iDT != null) {
            this.iDT.setText(this.mTitle);
        }
        if (this.plD != null) {
            this.plD.setText(this.gDV);
        }
        super.onBindView(view);
        AppMethodBeat.o(23397);
    }
}
