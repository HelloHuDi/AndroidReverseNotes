package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.pluginsdk.ui.e.j;

public final class o extends i {
    private View krb;
    private ImageView krc;
    private TextView krd;
    private TextView kre;

    public final void initView() {
        AppMethodBeat.i(88772);
        this.krb = findViewById(R.id.abs);
        this.krc = (ImageView) findViewById(R.id.bx_);
        this.krd = (TextView) findViewById(R.id.bxa);
        this.kre = (TextView) findViewById(R.id.bxb);
        this.krb.setVisibility(8);
        AppMethodBeat.o(88772);
    }

    public final void update() {
        AppMethodBeat.i(88773);
        b bcv = this.kqK.bcv();
        Context bcy = this.kqK.bcy();
        a bcC = this.kqK.bcC();
        this.krb.setVisibility(0);
        this.krd.setText(j.b(bcy, ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bcC.kiN).Oi(), this.krd.getTextSize()));
        if (bcv.aZX() != null && !TextUtils.isEmpty(bcv.aZX().wYl)) {
            this.kre.setText(j.b(bcy, bcv.aZX().wYl, this.kre.getTextSize()));
        } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
            if (bcv.aZH()) {
                this.kre.setText(bcy.getString(R.string.af9, new Object[]{this.kqK.bcD().getTitle()}));
            } else {
                this.kre.setText(bcy.getString(R.string.aen, new Object[]{this.kqK.bcD().getTitle()}));
            }
        } else if (bcv.aZH()) {
            this.kre.setText(bcy.getString(R.string.af9, new Object[]{bcv.aZV().kdf}));
        } else {
            this.kre.setText(bcy.getString(R.string.aen, new Object[]{bcv.aZV().kdf}));
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(this.krc, bcC.kiN);
        this.krc.setOnClickListener(this.kqK.bcz());
        AppMethodBeat.o(88773);
    }

    public final void bes() {
        AppMethodBeat.i(88774);
        this.krb.setVisibility(8);
        AppMethodBeat.o(88774);
    }
}
