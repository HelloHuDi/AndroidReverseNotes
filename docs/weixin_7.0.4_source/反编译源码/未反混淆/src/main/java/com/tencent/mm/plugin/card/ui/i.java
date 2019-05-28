package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;

public final class i implements a {
    View jcl;
    MMActivity jiE;
    boolean khF = false;
    View kmK;
    TextView kmL;
    ImageView kmM;
    View kmN;
    TextView kmO;
    ImageView kmP;

    public i(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(88590);
        bdm();
        AppMethodBeat.o(88590);
    }

    public final void aVU() {
    }

    /* Access modifiers changed, original: final */
    public final void bdm() {
        AppMethodBeat.i(88591);
        if (am.bba().kbN <= 0 || !this.khF) {
            this.kmK.setVisibility(8);
            if (this.kmN != null) {
                this.kmN.setVisibility(8);
            }
            AppMethodBeat.o(88591);
            return;
        }
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
        String str2 = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
        int dimensionPixelOffset = this.jiE.getResources().getDimensionPixelOffset(R.dimen.vn);
        if (TextUtils.isEmpty(str2)) {
            this.kmM.setImageResource(R.drawable.azd);
        } else {
            m.a(this.kmM, str2, dimensionPixelOffset, (int) R.drawable.azd, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.kmL.setText(this.jiE.getString(R.string.aex, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.kmL.setText(str);
        }
        this.kmK.setVisibility(0);
        if (this.kmN != null) {
            if (TextUtils.isEmpty(str2)) {
                this.kmP.setImageResource(R.drawable.azd);
            } else {
                m.a(this.kmP, str2, dimensionPixelOffset, (int) R.drawable.azd, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.kmO.setText(this.jiE.getString(R.string.aex, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.kmO.setText(str);
            }
            this.kmN.setVisibility(0);
        }
        AppMethodBeat.o(88591);
    }
}
