package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class y extends i {
    private MMActivity jiE;
    private b kaS;
    private View krt;

    public final void initView() {
        AppMethodBeat.i(88789);
        this.jiE = this.kqK.bcy();
        AppMethodBeat.o(88789);
    }

    public final void update() {
        AppMethodBeat.i(88790);
        this.kaS = this.kqK.bcv();
        if (this.krt == null) {
            this.krt = ((ViewStub) findViewById(R.id.abz)).inflate();
        }
        if (this.kaS.aZF()) {
            this.krt.setBackgroundDrawable(l.H(this.jiE, this.jiE.getResources().getColor(R.color.it)));
        }
        TextView textView = (TextView) this.krt.findViewById(R.id.ajz);
        if (this.kaS.aZW() == null) {
            ab.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            AppMethodBeat.o(88790);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.jiE.getResources().getColor(R.color.rb));
        if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
            m.c(textView, this.kaS.aZW().status);
            AppMethodBeat.o(88790);
            return;
        }
        textView.setText(this.kaS.aZV().vUu);
        AppMethodBeat.o(88790);
    }

    public final void bes() {
        AppMethodBeat.i(88791);
        if (this.krt != null) {
            this.krt.setVisibility(8);
        }
        AppMethodBeat.o(88791);
    }
}
