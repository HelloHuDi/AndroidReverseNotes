package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView iDT;
    private String lYc;
    private Context mContext;
    private TextView pmh;
    private TextView pmi;
    private boolean pmj = false;
    private String pmk;
    private String pml;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23428);
        this.mContext = context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(23428);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23429);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af4, viewGroup2);
        AppMethodBeat.o(23429);
        return onCreateView;
    }

    public final void onBindView(View view) {
        LayoutParams layoutParams;
        int i;
        AppMethodBeat.i(23430);
        this.iDT = (TextView) view.findViewById(R.id.cx);
        this.pmh = (TextView) view.findViewById(R.id.d_t);
        this.pmi = (TextView) view.findViewById(R.id.d_u);
        if (!(this.iDT == null || bo.isNullOrNil(this.lYc))) {
            this.iDT.setVisibility(0);
            this.iDT.setText(this.lYc);
            layoutParams = (LayoutParams) this.iDT.getLayoutParams();
            layoutParams.width = a.al(this.mContext, R.dimen.i8);
            this.iDT.setLayoutParams(layoutParams);
        }
        if (this.pmh != null) {
            if (this.pmj) {
                this.pmh.setVisibility(0);
                this.pmh.setCompoundDrawablesWithIntrinsicBounds(R.raw.card_photoicon, 0, 0, 0);
                i = 1;
            } else {
                this.pmh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!bo.isNullOrNil(this.pmk)) {
                this.pmh.setVisibility(0);
                this.pmh.setText(j.b(this.mContext, bo.nullAsNil(this.pmk), this.pmh.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.pmi == null || bo.isNullOrNil(this.pml))) {
            i |= 2;
            this.pmi.setVisibility(0);
            this.pmi.setText(this.pml);
        }
        int i2 = i;
        if (i2 == 1) {
            ((LayoutParams) this.pmh.getLayoutParams()).addRule(15);
        }
        if (i2 == 2) {
            layoutParams = (LayoutParams) this.pmi.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(15);
        }
        super.onBindView(view);
        AppMethodBeat.o(23430);
    }
}
