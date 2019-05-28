package com.tencent.p177mm.plugin.card.p355ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p352b.C38728f;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C20176a;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C42867g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.card.ui.view.a */
public final class C33804a extends C45800i {
    private View kqr;

    public final void initView() {
        AppMethodBeat.m2504i(88728);
        this.kqr = findViewById(2131822018);
        AppMethodBeat.m2505o(88728);
    }

    public final void update() {
        AppMethodBeat.m2504i(88729);
        C42867g bcA = this.kqK.bcA();
        C42837b bcv = this.kqK.bcv();
        Context bcy = this.kqK.bcy();
        C20176a bcC = this.kqK.bcC();
        C38728f bcD = this.kqK.bcD();
        if (bcA.bdP()) {
            this.kqr.setVisibility(0);
            findViewById(2131821933).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(2131821934);
            TextView textView = (TextView) findViewById(2131821935);
            TextView textView2 = (TextView) findViewById(2131821936);
            if (bcC.kiN != null) {
                textView.setText(C44089j.m79293b(bcy, ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bcC.kiN).mo16706Oi(), textView.getTextSize()));
            }
            if (bcC.emC == 23) {
                if (!TextUtils.isEmpty(bcv.aZV().vUw)) {
                    textView2.setText(bcv.aZV().vUw);
                } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
                    textView2.setText(bcy.getString(C25738R.string.agi, new Object[]{bcD.getTitle()}));
                } else {
                    textView2.setText(bcy.getString(C25738R.string.agi, new Object[]{bcv.aZV().kdf}));
                }
            } else if (bcv.aZX() != null && !TextUtils.isEmpty(bcv.aZX().wYl)) {
                textView2.setText(bcv.aZX().wYl);
            } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
                if (bcv.aZH()) {
                    textView2.setText(bcy.getString(C25738R.string.af9, new Object[]{bcD.getTitle()}));
                } else {
                    textView2.setText(bcy.getString(C25738R.string.aen, new Object[]{bcD.getTitle()}));
                }
            } else if (bcv.aZH()) {
                textView2.setText(bcy.getString(C25738R.string.af9, new Object[]{bcv.aZV().kdf}));
            } else {
                textView2.setText(bcy.getString(C25738R.string.aen, new Object[]{bcv.aZV().kdf}));
            }
            C40460b.m69433a(imageView, bcC.kiN, 0.15f, false);
            imageView.setOnClickListener(this.kqK.bcz());
            AppMethodBeat.m2505o(88729);
        } else if (!bcA.bdQ()) {
            bes();
            AppMethodBeat.m2505o(88729);
        } else if (TextUtils.isEmpty(bcv.aZV().vUw)) {
            this.kqr.setVisibility(8);
            AppMethodBeat.m2505o(88729);
        } else {
            this.kqr.setVisibility(0);
            findViewById(2131821933).setVisibility(8);
            ((TextView) findViewById(2131821936)).setText(bcv.aZV().vUw);
            AppMethodBeat.m2505o(88729);
        }
    }

    public final void bes() {
        AppMethodBeat.m2504i(88730);
        this.kqr.setVisibility(8);
        AppMethodBeat.m2505o(88730);
    }
}
