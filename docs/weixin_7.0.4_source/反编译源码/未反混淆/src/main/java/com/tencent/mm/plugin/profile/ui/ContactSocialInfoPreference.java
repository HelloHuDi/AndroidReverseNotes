package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference extends Preference {
    private TextView klC;
    private ImageView plE;
    private ImageView plF;
    private ImageView plG;
    private ImageView plH;
    private ImageView plI;
    private ImageView plJ;
    private int plK = 8;
    private int plL = 8;
    private int plM = 8;
    private int plN = 8;
    private int plO = 8;
    private int plP = 8;

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23431);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(23431);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23432);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af9, viewGroup2);
        AppMethodBeat.o(23432);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23433);
        this.plE = (ImageView) view.findViewById(R.id.d_l);
        this.plF = (ImageView) view.findViewById(R.id.d_m);
        this.plG = (ImageView) view.findViewById(R.id.d_n);
        this.plH = (ImageView) view.findViewById(R.id.d_o);
        this.plI = (ImageView) view.findViewById(R.id.d_p);
        this.plJ = (ImageView) view.findViewById(R.id.d_q);
        this.klC = (TextView) view.findViewById(R.id.cx);
        cu();
        super.onBindView(view);
        AppMethodBeat.o(23433);
    }

    public final void Bb(int i) {
        AppMethodBeat.i(23434);
        this.plK = i;
        cu();
        AppMethodBeat.o(23434);
    }

    public final void AX(int i) {
        AppMethodBeat.i(23435);
        this.plL = i;
        cu();
        AppMethodBeat.o(23435);
    }

    public final void AY(int i) {
        AppMethodBeat.i(23436);
        this.plM = i;
        cu();
        AppMethodBeat.o(23436);
    }

    public final void AZ(int i) {
        AppMethodBeat.i(23437);
        this.plO = i;
        cu();
        AppMethodBeat.o(23437);
    }

    public final void Ba(int i) {
        AppMethodBeat.i(23438);
        this.plP = i;
        cu();
        AppMethodBeat.o(23438);
    }

    private void cu() {
        AppMethodBeat.i(23439);
        if (this.plE != null) {
            this.plE.setVisibility(this.plK);
        }
        if (this.plF != null) {
            this.plF.setVisibility(this.plL);
        }
        if (this.plG != null) {
            this.plG.setVisibility(this.plM);
        }
        if (this.plH != null) {
            this.plH.setVisibility(this.plN);
        }
        if (this.plI != null) {
            this.plI.setVisibility(this.plO);
        }
        if (this.klC != null) {
            LayoutParams layoutParams = this.klC.getLayoutParams();
            layoutParams.width = a.al(this.mContext, R.dimen.i8);
            this.klC.setLayoutParams(layoutParams);
        }
        if (this.plJ != null) {
            this.plJ.setVisibility(this.plP);
        }
        AppMethodBeat.o(23439);
    }
}
