package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.b.g;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e implements b {
    private s pKR = new s();
    RecordVoiceBaseView pLj;

    public e() {
        AppMethodBeat.i(24374);
        AppMethodBeat.o(24374);
    }

    public final View eK(Context context) {
        AppMethodBeat.i(24375);
        View inflate = View.inflate(context, R.layout.anr, null);
        ((RecordVoiceBaseView) inflate.findViewById(R.id.bsk)).setVoiceHelper(this.pKR);
        AppMethodBeat.o(24375);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(24376);
        View findViewById = view.findViewById(R.id.dx5);
        this.pLj = (RecordVoiceBaseView) view.findViewById(R.id.bsk);
        if (bVar.dataType == 0) {
            this.pLj.setVisibility(8);
            findViewById.setVisibility(0);
            AppMethodBeat.o(24376);
            return;
        }
        if (bVar.dataType == 1) {
            findViewById.setVisibility(8);
            this.pLj.setVisibility(0);
            String a = g.a(bVar);
            gh ghVar = new gh();
            ghVar.cAH.type = 17;
            ghVar.cAH.cAJ = bVar.cAv;
            a.xxA.m(ghVar);
            int i2 = ghVar.cAI.ret;
            if (!com.tencent.mm.a.e.ct(a)) {
                if (bo.isNullOrNil(bVar.cAv.wfZ)) {
                    findViewById.setVisibility(0);
                    this.pLj.setVisibility(8);
                } else {
                    ab.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", Long.valueOf(bVar.mnW.field_localId), bVar.cAv.wfZ);
                    gh ghVar2 = new gh();
                    ghVar2.cAH.type = 16;
                    ghVar2.cAH.cvv = bVar.mnW.field_localId;
                    a.xxA.m(ghVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.pLj;
            int i3 = bVar.cAv.duration;
            recordVoiceBaseView.path = bo.bc(a, "");
            recordVoiceBaseView.cAO = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.fY((long) i3)) + "''");
            }
        }
        AppMethodBeat.o(24376);
    }

    public final void destroy() {
        AppMethodBeat.i(24377);
        s sVar = this.pKR;
        sVar.stopPlay();
        sVar.buK();
        s.mfW = null;
        sVar.callbacks.clear();
        AppMethodBeat.o(24377);
    }

    public final void pause() {
        AppMethodBeat.i(24378);
        if (this.pKR != null && this.pKR.callbacks.size() > 0) {
            for (s.a onFinish : this.pKR.callbacks) {
                onFinish.onFinish();
            }
        }
        AppMethodBeat.o(24378);
    }
}
