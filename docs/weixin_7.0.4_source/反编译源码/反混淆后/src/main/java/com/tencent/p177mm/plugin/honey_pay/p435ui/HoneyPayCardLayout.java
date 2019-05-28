package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.ati;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout */
public class HoneyPayCardLayout extends LinearLayout {
    private ImageView kEn;
    private String nra;
    private TextView nrs;
    private TextView nrt;
    private WalletTextView nru;
    private TextView nrv;
    private CdnImageView nrw;

    public HoneyPayCardLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(41788);
        init();
        AppMethodBeat.m2505o(41788);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(41789);
        init();
        AppMethodBeat.m2505o(41789);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(41790);
        init();
        AppMethodBeat.m2505o(41790);
    }

    private void init() {
        AppMethodBeat.m2504i(41791);
        View inflate = HoneyPayCardLayout.inflate(getContext(), 2130969822, this);
        this.kEn = (ImageView) inflate.findViewById(2131824868);
        this.nru = (WalletTextView) inflate.findViewById(2131824870);
        this.nrs = (TextView) inflate.findViewById(2131824869);
        this.nrt = (TextView) inflate.findViewById(2131824871);
        this.nrv = (TextView) inflate.findViewById(2131824867);
        this.nrw = (CdnImageView) inflate.findViewById(2131824866);
        this.nru.setPrefix(C44423ae.dOd());
        AppMethodBeat.m2505o(41791);
    }

    public void setCardRecord(ati ati) {
        long j = 0;
        AppMethodBeat.m2504i(41792);
        this.nra = ati.wpp;
        this.nrv.setText(ati.kdf);
        if (!C5046bo.isNullOrNil(ati.cIY)) {
            this.nrw.mo38952eb(ati.cIY, C28289c.m44890wS(ati.iAd));
        }
        C40460b.m69433a(this.kEn, ati.vYh, 0.06f, false);
        C36391e.m60004d(this.nrs, ati.vYh);
        this.nru.setText(C28289c.m44887iR(ati.wch));
        if (ati.wxp == 0) {
            this.nrt.setTextColor(Color.parseColor("#FA9D3B"));
            this.nrt.setText(C25738R.string.cd9);
            AppMethodBeat.m2505o(41792);
        } else if (ati.wxp != 1) {
            C4990ab.m7421w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", Integer.valueOf(ati.wxp));
            AppMethodBeat.m2505o(41792);
        } else if (ati.wxr == 0) {
            long j2 = ati.wxq;
            if (j2 < 0) {
                C4990ab.m7421w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", Long.valueOf(j2));
            } else {
                j = j2;
            }
            this.nrt.setText(getContext().getString(C25738R.string.cd8, new Object[]{C44423ae.dOd() + C28289c.m44887iR(j)}));
            AppMethodBeat.m2505o(41792);
        } else {
            C4990ab.m7416i("MicroMsg.HoneyPayCardLayout", "show check detail");
            this.nrt.setText("");
            AppMethodBeat.m2505o(41792);
        }
    }
}
