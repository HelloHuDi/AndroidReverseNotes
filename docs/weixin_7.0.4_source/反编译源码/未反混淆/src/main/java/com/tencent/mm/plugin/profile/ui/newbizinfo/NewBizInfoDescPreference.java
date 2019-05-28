package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.ttpic.baseutils.IOUtils;

public class NewBizInfoDescPreference extends Preference {
    private MMActivity crP;
    private LinearLayout eol;
    private MMNeat7extView jXz;
    private boolean lyb = false;
    d ppN;

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23845);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(23845);
    }

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23846);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(23846);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23847);
        this.eol = (LinearLayout) view.findViewById(R.id.b2a);
        this.jXz = (MMNeat7extView) view.findViewById(R.id.b2b);
        this.lyb = true;
        if (!this.lyb) {
            ab.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", Boolean.valueOf(this.lyb));
            AppMethodBeat.o(23847);
        } else if (this.ppN == null) {
            this.eol.setVisibility(4);
            AppMethodBeat.o(23847);
        } else {
            String jS = jS(false);
            if (bo.isNullOrNil(jS)) {
                this.eol.setVisibility(8);
            } else {
                this.eol.setVisibility(0);
                this.jXz.ah(jS);
                if (this.ppN.field_originalArticleCount > 0 && this.ppN.field_friendSubscribeCount > 0) {
                    int dPe;
                    a QV = this.jXz.QV(com.tencent.mm.bz.a.gd(this.crP) - ((int) (com.tencent.mm.bz.a.getDensity(this.crP) * 24.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    if (dPe > 1) {
                        this.jXz.ah(jS(true));
                    }
                    AppMethodBeat.o(23847);
                    return;
                }
            }
            AppMethodBeat.o(23847);
        }
    }

    private String jS(boolean z) {
        AppMethodBeat.i(23848);
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        if (this.ppN.field_originalArticleCount > 0 && this.ppN.field_friendSubscribeCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(R.string.auv), new Object[]{Integer.valueOf(this.ppN.field_originalArticleCount)}));
            if (z) {
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            } else {
                stringBuilder.append("  ");
            }
            stringBuilder.append(String.format(this.crP.getResources().getString(R.string.aud), new Object[]{Integer.valueOf(this.ppN.field_friendSubscribeCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(23848);
            return stringBuilder2;
        } else if (this.ppN.field_originalArticleCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(R.string.auv), new Object[]{Integer.valueOf(this.ppN.field_originalArticleCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(23848);
            return stringBuilder2;
        } else if (this.ppN.field_friendSubscribeCount > 0) {
            stringBuilder.append(String.format(this.crP.getResources().getString(R.string.aud), new Object[]{Integer.valueOf(this.ppN.field_friendSubscribeCount)}));
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(23848);
            return stringBuilder2;
        } else {
            stringBuilder2 = "";
            AppMethodBeat.o(23848);
            return stringBuilder2;
        }
    }
}
