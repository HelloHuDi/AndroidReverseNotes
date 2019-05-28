package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsArtistPreference */
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
        AppMethodBeat.m2504i(38733);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(38733);
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38734);
        this.pnJ = "";
        this.mTitle = "";
        this.qle = -1;
        this.qlf = 8;
        this.rph = null;
        this.rpi = "";
        this.crP = (MMActivity) context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(38734);
    }

    private void csN() {
        AppMethodBeat.m2504i(38735);
        if (!(this.rph == null || this.rpi == null || this.rpi.equals("") || this.crP == null)) {
            this.rph.setText(this.crP.getString(C25738R.string.eap, new Object[]{this.rpi}));
        }
        AppMethodBeat.m2505o(38735);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(38736);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        this.mTitle = this.crP.getString(C25738R.string.eaq);
        layoutInflater.inflate(2130970129, viewGroup2);
        AppMethodBeat.m2505o(38736);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(38737);
        super.onBindView(view);
        this.rph = (TextView) view.findViewById(2131826015);
        ((TextView) view.findViewById(2131826014)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(2131822348);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(C1338a.m2864g(this.crP, this.qle));
            }
        }
        csN();
        AppMethodBeat.m2505o(38737);
    }

    /* renamed from: ZE */
    public final void mo47258ZE(String str) {
        AppMethodBeat.m2504i(38738);
        this.rpi = str;
        csN();
        AppMethodBeat.m2505o(38738);
    }
}
