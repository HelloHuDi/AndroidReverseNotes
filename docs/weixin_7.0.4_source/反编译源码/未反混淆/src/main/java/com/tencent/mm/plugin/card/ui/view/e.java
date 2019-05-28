package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends i {
    private View kqC;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88742);
        b bcv = this.kqK.bcv();
        nz nzVar = bcv.aZV().vUk;
        if (nzVar != null) {
            ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + nzVar.qsz);
            ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + nzVar.text);
            ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + nzVar.vTr);
        }
        if (nzVar == null || TextUtils.isEmpty(nzVar.text) || !bcv.aZT()) {
            if (this.kqC != null) {
                this.kqC.setVisibility(8);
            }
            AppMethodBeat.o(88742);
            return;
        }
        if (this.kqC == null) {
            this.kqC = ((ViewStub) findViewById(R.id.ac1)).inflate();
        }
        ((TextView) this.kqC.findViewById(R.id.a_r)).setText(nzVar.text);
        this.kqC.setOnClickListener(this.kqK.bcz());
        AppMethodBeat.o(88742);
    }

    public final void bes() {
        AppMethodBeat.i(88743);
        if (this.kqC != null) {
            this.kqC.setVisibility(8);
        }
        AppMethodBeat.o(88743);
    }
}
