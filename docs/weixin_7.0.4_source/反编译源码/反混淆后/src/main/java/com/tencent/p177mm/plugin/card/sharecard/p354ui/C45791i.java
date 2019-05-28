package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.i */
public final class C45791i {
    private View jcl;
    MMActivity jiE;
    View khC;
    TextView khD;
    TextView khE;
    private boolean khF = false;

    public C45791i(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    public final void bbX() {
        AppMethodBeat.m2504i(88205);
        this.khC.setVisibility(8);
        AppMethodBeat.m2505o(88205);
    }

    /* renamed from: cu */
    public final void mo73587cu() {
        AppMethodBeat.m2504i(88206);
        Integer num = (Integer) C42852am.bbb().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || C42856b.bbw()) {
            this.khC.setVisibility(8);
            AppMethodBeat.m2505o(88206);
            return;
        }
        this.khC.setVisibility(0);
        this.khD.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.mo45426sN(10))) {
            this.khD.setVisibility(8);
        } else {
            this.khD.setVisibility(0);
            this.khD.setText(shareCardInfo.mo45426sN(10));
        }
        if (TextUtils.isEmpty("")) {
            this.khE.setVisibility(8);
            AppMethodBeat.m2505o(88206);
            return;
        }
        this.khE.setVisibility(0);
        this.khE.setText("");
        AppMethodBeat.m2505o(88206);
    }
}
