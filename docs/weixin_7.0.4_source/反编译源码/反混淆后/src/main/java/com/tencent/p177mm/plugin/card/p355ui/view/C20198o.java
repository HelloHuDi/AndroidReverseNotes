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
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C20176a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.card.ui.view.o */
public final class C20198o extends C45800i {
    private View krb;
    private ImageView krc;
    private TextView krd;
    private TextView kre;

    public final void initView() {
        AppMethodBeat.m2504i(88772);
        this.krb = findViewById(2131822017);
        this.krc = (ImageView) findViewById(2131824180);
        this.krd = (TextView) findViewById(2131824181);
        this.kre = (TextView) findViewById(2131824182);
        this.krb.setVisibility(8);
        AppMethodBeat.m2505o(88772);
    }

    public final void update() {
        AppMethodBeat.m2504i(88773);
        C42837b bcv = this.kqK.bcv();
        Context bcy = this.kqK.bcy();
        C20176a bcC = this.kqK.bcC();
        this.krb.setVisibility(0);
        this.krd.setText(C44089j.m79293b(bcy, ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bcC.kiN).mo16706Oi(), this.krd.getTextSize()));
        if (bcv.aZX() != null && !TextUtils.isEmpty(bcv.aZX().wYl)) {
            this.kre.setText(C44089j.m79293b(bcy, bcv.aZX().wYl, this.kre.getTextSize()));
        } else if (TextUtils.isEmpty(bcv.aZV().kdf)) {
            if (bcv.aZH()) {
                this.kre.setText(bcy.getString(C25738R.string.af9, new Object[]{this.kqK.bcD().getTitle()}));
            } else {
                this.kre.setText(bcy.getString(C25738R.string.aen, new Object[]{this.kqK.bcD().getTitle()}));
            }
        } else if (bcv.aZH()) {
            this.kre.setText(bcy.getString(C25738R.string.af9, new Object[]{bcv.aZV().kdf}));
        } else {
            this.kre.setText(bcy.getString(C25738R.string.aen, new Object[]{bcv.aZV().kdf}));
        }
        C40460b.m69434b(this.krc, bcC.kiN);
        this.krc.setOnClickListener(this.kqK.bcz());
        AppMethodBeat.m2505o(88773);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88774);
        this.krb.setVisibility(8);
        AppMethodBeat.m2505o(88774);
    }
}
