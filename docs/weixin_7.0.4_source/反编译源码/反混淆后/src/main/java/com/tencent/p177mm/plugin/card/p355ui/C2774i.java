package com.tencent.p177mm.plugin.card.p355ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.model.C38747g;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C2752k.C2754a;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.card.ui.i */
public final class C2774i implements C2754a {
    View jcl;
    MMActivity jiE;
    boolean khF = false;
    View kmK;
    TextView kmL;
    ImageView kmM;
    View kmN;
    TextView kmO;
    ImageView kmP;

    /* renamed from: com.tencent.mm.plugin.card.ui.i$2 */
    class C27752 implements OnClickListener {
        C27752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88589);
            C45774b.m84628a(C2774i.this.jiE, false);
            C42852am.bba().baJ();
            C2774i.this.bdm();
            C7060h.pYm.mo8381e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "");
            AppMethodBeat.m2505o(88589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.i$1 */
    class C27761 implements OnClickListener {
        C27761() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88588);
            C45774b.m84628a(C2774i.this.jiE, false);
            C42852am.bba().baJ();
            C2774i.this.bdm();
            C7060h.pYm.mo8381e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "");
            AppMethodBeat.m2505o(88588);
        }
    }

    public C2774i(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    /* renamed from: a */
    public final void mo6836a(C38747g c38747g) {
        AppMethodBeat.m2504i(88590);
        bdm();
        AppMethodBeat.m2505o(88590);
    }

    public final void aVU() {
    }

    /* Access modifiers changed, original: final */
    public final void bdm() {
        AppMethodBeat.m2504i(88591);
        if (C42852am.bba().kbN <= 0 || !this.khF) {
            this.kmK.setVisibility(8);
            if (this.kmN != null) {
                this.kmN.setVisibility(8);
            }
            AppMethodBeat.m2505o(88591);
            return;
        }
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
        int dimensionPixelOffset = this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f10246vn);
        if (TextUtils.isEmpty(str2)) {
            this.kmM.setImageResource(C25738R.drawable.azd);
        } else {
            C45778m.m84644a(this.kmM, str2, dimensionPixelOffset, (int) C25738R.drawable.azd, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.kmL.setText(this.jiE.getString(C25738R.string.aex, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.kmL.setText(str);
        }
        this.kmK.setVisibility(0);
        if (this.kmN != null) {
            if (TextUtils.isEmpty(str2)) {
                this.kmP.setImageResource(C25738R.drawable.azd);
            } else {
                C45778m.m84644a(this.kmP, str2, dimensionPixelOffset, (int) C25738R.drawable.azd, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.kmO.setText(this.jiE.getString(C25738R.string.aex, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.kmO.setText(str);
            }
            this.kmN.setVisibility(0);
        }
        AppMethodBeat.m2505o(88591);
    }
}
