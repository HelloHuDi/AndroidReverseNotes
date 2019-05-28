package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.ui.view.e */
public final class C11357e extends C45800i {
    private View kqC;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88742);
        C42837b bcv = this.kqK.bcv();
        C15368nz c15368nz = bcv.aZV().vUk;
        if (c15368nz != null) {
            C4990ab.m7416i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + c15368nz.qsz);
            C4990ab.m7416i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + c15368nz.text);
            C4990ab.m7416i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + c15368nz.vTr);
        }
        if (c15368nz == null || TextUtils.isEmpty(c15368nz.text) || !bcv.aZT()) {
            if (this.kqC != null) {
                this.kqC.setVisibility(8);
            }
            AppMethodBeat.m2505o(88742);
            return;
        }
        if (this.kqC == null) {
            this.kqC = ((ViewStub) findViewById(2131822026)).inflate();
        }
        ((TextView) this.kqC.findViewById(2131821942)).setText(c15368nz.text);
        this.kqC.setOnClickListener(this.kqK.bcz());
        AppMethodBeat.m2505o(88742);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88743);
        if (this.kqC != null) {
            this.kqC.setVisibility(8);
        }
        AppMethodBeat.m2505o(88743);
    }
}
