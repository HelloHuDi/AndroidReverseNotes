package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference */
public class VcardContactUserHeaderPreference extends Preference {
    private String bCu;
    private final Context context;
    private String qaA;
    private ImageView qgZ;
    private TextView qha;
    private TextView qhb;
    private TextView qhc;
    private TextView qhd;
    private String qhe;
    private String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81360);
        super.onBindView(view);
        C4990ab.m7412e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.qgZ = (ImageView) view.findViewById(2131828389);
        this.qha = (TextView) view.findViewById(2131828390);
        if (this.qhe != null) {
            this.qha.setText(this.qhe);
        }
        this.qhb = (TextView) view.findViewById(2131828391);
        if (this.bCu != null) {
            this.qhb.setText(this.context.getString(C25738R.string.f05, new Object[]{this.bCu}));
            this.qhb.setVisibility(0);
        }
        this.qhc = (TextView) view.findViewById(2131828393);
        if (this.qaA != null) {
            this.qhc.setText(this.context.getString(C25738R.string.f0_, new Object[]{this.qaA}));
            this.qhc.setVisibility(0);
        }
        this.qhd = (TextView) view.findViewById(2131828392);
        if (this.title != null) {
            this.qhd.setText(this.context.getString(C25738R.string.f0a, new Object[]{this.title}));
            this.qhd.setVisibility(0);
        }
        AppMethodBeat.m2505o(81360);
    }

    /* renamed from: a */
    public final void mo62587a(C39626r c39626r) {
        AppMethodBeat.m2504i(81361);
        if (c39626r != null) {
            if (!C5046bo.isNullOrNil(c39626r.qam.aDu())) {
                this.qhe = c39626r.qam.aDu();
            }
            if (!C5046bo.isNullOrNil(c39626r.bCu)) {
                this.bCu = c39626r.bCu;
            }
            if (!C5046bo.isNullOrNil(c39626r.qaA)) {
                this.qaA = c39626r.qaA;
            }
            if (!C5046bo.isNullOrNil(c39626r.title)) {
                this.title = c39626r.title;
            }
        }
        AppMethodBeat.m2505o(81361);
    }
}
