package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.e.j;

public final class a extends i {
    private View kqr;

    public final void initView() {
        AppMethodBeat.i(88728);
        this.kqr = findViewById(R.id.abt);
        AppMethodBeat.o(88728);
    }

    public final void update() {
        AppMethodBeat.i(88729);
        g bcA = this.kqK.bcA();
        b bcv = this.kqK.bcv();
        Context bcy = this.kqK.bcy();
        com.tencent.mm.plugin.card.ui.e.a bcC = this.kqK.bcC();
        f bcD = this.kqK.bcD();
        if (bcA.bdP()) {
            this.kqr.setVisibility(0);
            findViewById(R.id.a_i).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.id.a_j);
            TextView textView = (TextView) findViewById(R.id.a_k);
            TextView textView2 = (TextView) findViewById(R.id.a_l);
            if (bcC.kiN != null) {
                textView.setText(j.b(bcy, ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bcC.kiN).Oi(), textView.getTextSize()));
            }
            if (bcC.emC == 23) {
                if (!TextUtils.isEmpty(bcv.aZV().vUw)) {
                    textView2.setText(bcv.aZV().vUw);
                } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
                    textView2.setText(bcy.getString(R.string.agi, new Object[]{bcD.getTitle()}));
                } else {
                    textView2.setText(bcy.getString(R.string.agi, new Object[]{bcv.aZV().kdf}));
                }
            } else if (bcv.aZX() != null && !TextUtils.isEmpty(bcv.aZX().wYl)) {
                textView2.setText(bcv.aZX().wYl);
            } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
                if (bcv.aZH()) {
                    textView2.setText(bcy.getString(R.string.af9, new Object[]{bcD.getTitle()}));
                } else {
                    textView2.setText(bcy.getString(R.string.aen, new Object[]{bcD.getTitle()}));
                }
            } else if (bcv.aZH()) {
                textView2.setText(bcy.getString(R.string.af9, new Object[]{bcv.aZV().kdf}));
            } else {
                textView2.setText(bcy.getString(R.string.aen, new Object[]{bcv.aZV().kdf}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, bcC.kiN, 0.15f, false);
            imageView.setOnClickListener(this.kqK.bcz());
            AppMethodBeat.o(88729);
        } else if (!bcA.bdQ()) {
            bes();
            AppMethodBeat.o(88729);
        } else if (TextUtils.isEmpty(bcv.aZV().vUw)) {
            this.kqr.setVisibility(8);
            AppMethodBeat.o(88729);
        } else {
            this.kqr.setVisibility(0);
            findViewById(R.id.a_i).setVisibility(8);
            ((TextView) findViewById(R.id.a_l)).setText(bcv.aZV().vUw);
            AppMethodBeat.o(88729);
        }
    }

    public final void bes() {
        AppMethodBeat.i(88730);
        this.kqr.setVisibility(8);
        AppMethodBeat.o(88730);
    }
}
