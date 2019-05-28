package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private MMActivity crP;
    private String mTitle;
    private String pnJ;
    private int qle;
    private int qlf;
    private TextView rph;
    private String rpi;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(38733);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(38733);
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38734);
        this.pnJ = "";
        this.mTitle = "";
        this.qle = -1;
        this.qlf = 8;
        this.rph = null;
        this.rpi = "";
        this.crP = (MMActivity) context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(38734);
    }

    private void csN() {
        AppMethodBeat.i(38735);
        if (!(this.rph == null || this.rpi == null || this.rpi.equals("") || this.crP == null)) {
            this.rph.setText(this.crP.getString(R.string.eap, new Object[]{this.rpi}));
        }
        AppMethodBeat.o(38735);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(38736);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        this.mTitle = this.crP.getString(R.string.eaq);
        layoutInflater.inflate(R.layout.ae6, viewGroup2);
        AppMethodBeat.o(38736);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(38737);
        super.onBindView(view);
        this.rph = (TextView) view.findViewById(R.id.d9w);
        ((TextView) view.findViewById(R.id.d9v)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(R.id.akq);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(a.g(this.crP, this.qle));
            }
        }
        csN();
        AppMethodBeat.o(38737);
    }

    public final void ZE(String str) {
        AppMethodBeat.i(38738);
        this.rpi = str;
        csN();
        AppMethodBeat.o(38738);
    }
}
