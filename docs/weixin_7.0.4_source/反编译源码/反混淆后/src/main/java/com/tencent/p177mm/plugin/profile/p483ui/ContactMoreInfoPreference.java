package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference */
public class ContactMoreInfoPreference extends Preference {
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

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23398);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23398);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23399);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970157, viewGroup2);
        AppMethodBeat.m2505o(23399);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23400);
        this.plE = (ImageView) view.findViewById(2131826041);
        this.plF = (ImageView) view.findViewById(2131826042);
        this.plG = (ImageView) view.findViewById(2131826043);
        this.plH = (ImageView) view.findViewById(2131826044);
        this.plI = (ImageView) view.findViewById(2131826045);
        this.plJ = (ImageView) view.findViewById(2131826046);
        this.klC = (TextView) view.findViewById(2131820678);
        m20822cu();
        super.onBindView(view);
        AppMethodBeat.m2505o(23400);
    }

    /* renamed from: AX */
    public final void mo24862AX(int i) {
        AppMethodBeat.m2504i(23401);
        this.plL = i;
        m20822cu();
        AppMethodBeat.m2505o(23401);
    }

    /* renamed from: AY */
    public final void mo24863AY(int i) {
        AppMethodBeat.m2504i(23402);
        this.plM = i;
        m20822cu();
        AppMethodBeat.m2505o(23402);
    }

    /* renamed from: AZ */
    public final void mo24864AZ(int i) {
        AppMethodBeat.m2504i(23403);
        this.plO = i;
        m20822cu();
        AppMethodBeat.m2505o(23403);
    }

    /* renamed from: Ba */
    public final void mo24865Ba(int i) {
        AppMethodBeat.m2504i(23404);
        this.plP = i;
        m20822cu();
        AppMethodBeat.m2505o(23404);
    }

    /* renamed from: cu */
    private void m20822cu() {
        AppMethodBeat.m2504i(23405);
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
            layoutParams.width = C1338a.m2856al(this.mContext, C25738R.dimen.f9862i8);
            this.klC.setLayoutParams(layoutParams);
        }
        if (this.plJ != null) {
            this.plJ.setVisibility(this.plP);
        }
        AppMethodBeat.m2505o(23405);
    }
}
