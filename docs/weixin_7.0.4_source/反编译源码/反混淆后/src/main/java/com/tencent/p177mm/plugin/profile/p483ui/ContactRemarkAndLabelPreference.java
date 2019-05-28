package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference */
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
        AppMethodBeat.m2504i(23428);
        this.mContext = context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23428);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23429);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970164, viewGroup2);
        AppMethodBeat.m2505o(23429);
        return onCreateView;
    }

    public final void onBindView(View view) {
        LayoutParams layoutParams;
        int i;
        AppMethodBeat.m2504i(23430);
        this.iDT = (TextView) view.findViewById(2131820678);
        this.pmh = (TextView) view.findViewById(2131826049);
        this.pmi = (TextView) view.findViewById(2131826050);
        if (!(this.iDT == null || C5046bo.isNullOrNil(this.lYc))) {
            this.iDT.setVisibility(0);
            this.iDT.setText(this.lYc);
            layoutParams = (LayoutParams) this.iDT.getLayoutParams();
            layoutParams.width = C1338a.m2856al(this.mContext, C25738R.dimen.f9862i8);
            this.iDT.setLayoutParams(layoutParams);
        }
        if (this.pmh != null) {
            if (this.pmj) {
                this.pmh.setVisibility(0);
                this.pmh.setCompoundDrawablesWithIntrinsicBounds(C1318a.card_photoicon, 0, 0, 0);
                i = 1;
            } else {
                this.pmh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!C5046bo.isNullOrNil(this.pmk)) {
                this.pmh.setVisibility(0);
                this.pmh.setText(C44089j.m79293b(this.mContext, C5046bo.nullAsNil(this.pmk), this.pmh.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.pmi == null || C5046bo.isNullOrNil(this.pml))) {
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
        AppMethodBeat.m2505o(23430);
    }
}
