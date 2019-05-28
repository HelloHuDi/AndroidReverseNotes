package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    private View jcl;
    MMActivity jiE;
    View khC;
    TextView khD;
    TextView khE;
    private boolean khF = false;

    public i(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    public final void bbX() {
        AppMethodBeat.i(88205);
        this.khC.setVisibility(8);
        AppMethodBeat.o(88205);
    }

    public final void cu() {
        AppMethodBeat.i(88206);
        Integer num = (Integer) am.bbb().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || b.bbw()) {
            this.khC.setVisibility(8);
            AppMethodBeat.o(88206);
            return;
        }
        this.khC.setVisibility(0);
        this.khD.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.sN(10))) {
            this.khD.setVisibility(8);
        } else {
            this.khD.setVisibility(0);
            this.khD.setText(shareCardInfo.sN(10));
        }
        if (TextUtils.isEmpty("")) {
            this.khE.setVisibility(8);
            AppMethodBeat.o(88206);
            return;
        }
        this.khE.setVisibility(0);
        this.khE.setText("");
        AppMethodBeat.o(88206);
    }
}
