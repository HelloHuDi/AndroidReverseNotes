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

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference */
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
        AppMethodBeat.m2504i(23431);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23431);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23432);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970169, viewGroup2);
        AppMethodBeat.m2505o(23432);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23433);
        this.plE = (ImageView) view.findViewById(2131826041);
        this.plF = (ImageView) view.findViewById(2131826042);
        this.plG = (ImageView) view.findViewById(2131826043);
        this.plH = (ImageView) view.findViewById(2131826044);
        this.plI = (ImageView) view.findViewById(2131826045);
        this.plJ = (ImageView) view.findViewById(2131826046);
        this.klC = (TextView) view.findViewById(2131820678);
        m77420cu();
        super.onBindView(view);
        AppMethodBeat.m2505o(23433);
    }

    /* renamed from: Bb */
    public final void mo68935Bb(int i) {
        AppMethodBeat.m2504i(23434);
        this.plK = i;
        m77420cu();
        AppMethodBeat.m2505o(23434);
    }

    /* renamed from: AX */
    public final void mo68931AX(int i) {
        AppMethodBeat.m2504i(23435);
        this.plL = i;
        m77420cu();
        AppMethodBeat.m2505o(23435);
    }

    /* renamed from: AY */
    public final void mo68932AY(int i) {
        AppMethodBeat.m2504i(23436);
        this.plM = i;
        m77420cu();
        AppMethodBeat.m2505o(23436);
    }

    /* renamed from: AZ */
    public final void mo68933AZ(int i) {
        AppMethodBeat.m2504i(23437);
        this.plO = i;
        m77420cu();
        AppMethodBeat.m2505o(23437);
    }

    /* renamed from: Ba */
    public final void mo68934Ba(int i) {
        AppMethodBeat.m2504i(23438);
        this.plP = i;
        m77420cu();
        AppMethodBeat.m2505o(23438);
    }

    /* renamed from: cu */
    private void m77420cu() {
        AppMethodBeat.m2504i(23439);
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
        AppMethodBeat.m2505o(23439);
    }
}
