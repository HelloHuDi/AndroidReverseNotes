package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

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
        AppMethodBeat.i(41788);
        init();
        AppMethodBeat.o(41788);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41789);
        init();
        AppMethodBeat.o(41789);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(41790);
        init();
        AppMethodBeat.o(41790);
    }

    private void init() {
        AppMethodBeat.i(41791);
        View inflate = inflate(getContext(), R.layout.a6v, this);
        this.kEn = (ImageView) inflate.findViewById(R.id.cev);
        this.nru = (WalletTextView) inflate.findViewById(R.id.cex);
        this.nrs = (TextView) inflate.findViewById(R.id.cew);
        this.nrt = (TextView) inflate.findViewById(R.id.cey);
        this.nrv = (TextView) inflate.findViewById(R.id.ceu);
        this.nrw = (CdnImageView) inflate.findViewById(R.id.cet);
        this.nru.setPrefix(ae.dOd());
        AppMethodBeat.o(41791);
    }

    public void setCardRecord(ati ati) {
        long j = 0;
        AppMethodBeat.i(41792);
        this.nra = ati.wpp;
        this.nrv.setText(ati.kdf);
        if (!bo.isNullOrNil(ati.cIY)) {
            this.nrw.eb(ati.cIY, c.wS(ati.iAd));
        }
        b.a(this.kEn, ati.vYh, 0.06f, false);
        e.d(this.nrs, ati.vYh);
        this.nru.setText(c.iR(ati.wch));
        if (ati.wxp == 0) {
            this.nrt.setTextColor(Color.parseColor("#FA9D3B"));
            this.nrt.setText(R.string.cd9);
            AppMethodBeat.o(41792);
        } else if (ati.wxp != 1) {
            ab.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", Integer.valueOf(ati.wxp));
            AppMethodBeat.o(41792);
        } else if (ati.wxr == 0) {
            long j2 = ati.wxq;
            if (j2 < 0) {
                ab.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", Long.valueOf(j2));
            } else {
                j = j2;
            }
            this.nrt.setText(getContext().getString(R.string.cd8, new Object[]{ae.dOd() + c.iR(j)}));
            AppMethodBeat.o(41792);
        } else {
            ab.i("MicroMsg.HoneyPayCardLayout", "show check detail");
            this.nrt.setText("");
            AppMethodBeat.o(41792);
        }
    }
}
