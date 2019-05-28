package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.wy;

public final class k extends i {
    private View kqL;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88752);
        if (this.kqL == null) {
            this.kqL = ((ViewStub) findViewById(R.id.ac5)).inflate();
        }
        this.kqL.setOnClickListener(this.kqK.bcz());
        wy wyVar = this.kqK.bcv().aZV().vUo;
        if (TextUtils.isEmpty(wyVar.detail)) {
            findViewById(R.id.abl).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.abm)).setText(wyVar.detail);
            findViewById(R.id.abl).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.id.abk);
        if (wyVar.wcS == null || wyVar.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) wyVar.wcS.get(0))) {
            imageView.setVisibility(8);
            AppMethodBeat.o(88752);
            return;
        }
        String str = (String) wyVar.wcS.get(0);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.ePK = e.eSn;
        o.ahq();
        aVar.ePY = null;
        aVar.ePJ = m.Gz(str);
        aVar.ePH = true;
        aVar.eQf = false;
        aVar.ePF = true;
        o.ahp().a(str, imageView, aVar.ahG());
        AppMethodBeat.o(88752);
    }

    public final void bes() {
        AppMethodBeat.i(88753);
        if (this.kqL != null) {
            this.kqL.setVisibility(8);
        }
        AppMethodBeat.o(88753);
    }
}
