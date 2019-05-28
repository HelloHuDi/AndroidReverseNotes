package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference */
public class NewBizInfoDescPreference extends Preference {
    private MMActivity crP;
    private LinearLayout eol;
    private MMNeat7extView jXz;
    private boolean lyb = false;
    C46140d ppN;

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23845);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(23845);
    }

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23846);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(23846);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23847);
        this.eol = (LinearLayout) view.findViewById(2131822997);
        this.jXz = (MMNeat7extView) view.findViewById(2131822998);
        this.lyb = true;
        if (!this.lyb) {
            C4990ab.m7421w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", Boolean.valueOf(this.lyb));
            AppMethodBeat.m2505o(23847);
        } else if (this.ppN == null) {
            this.eol.setVisibility(4);
            AppMethodBeat.m2505o(23847);
        } else {
            String jS = m45592jS(false);
            if (C5046bo.isNullOrNil(jS)) {
                this.eol.setVisibility(8);
            } else {
                this.eol.setVisibility(0);
                this.jXz.mo15921ah(jS);
                if (this.ppN.field_originalArticleCount > 0 && this.ppN.field_friendSubscribeCount > 0) {
                    int dPe;
                    C5782a QV = this.jXz.mo15918QV(C1338a.m2868gd(this.crP) - ((int) (C1338a.getDensity(this.crP) * 24.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    if (dPe > 1) {
                        this.jXz.mo15921ah(m45592jS(true));
                    }
                    AppMethodBeat.m2505o(23847);
                    return;
                }
            }
            AppMethodBeat.m2505o(23847);
        }
    }

    /* renamed from: jS */
    private String m45592jS(boolean z) {
        AppMethodBeat.m2504i(23848);
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        if (this.ppN.field_originalArticleCount > 0 && this.ppN.field_friendSubscribeCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(C25738R.string.auv), new Object[]{Integer.valueOf(this.ppN.field_originalArticleCount)}));
            if (z) {
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            } else {
                stringBuilder.append("  ");
            }
            stringBuilder.append(String.format(this.crP.getResources().getString(C25738R.string.aud), new Object[]{Integer.valueOf(this.ppN.field_friendSubscribeCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(23848);
            return stringBuilder2;
        } else if (this.ppN.field_originalArticleCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(C25738R.string.auv), new Object[]{Integer.valueOf(this.ppN.field_originalArticleCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(23848);
            return stringBuilder2;
        } else if (this.ppN.field_friendSubscribeCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(C25738R.string.aud), new Object[]{Integer.valueOf(this.ppN.field_friendSubscribeCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(23848);
            return stringBuilder2;
        } else {
            stringBuilder2 = "";
            AppMethodBeat.m2505o(23848);
            return stringBuilder2;
        }
    }
}
