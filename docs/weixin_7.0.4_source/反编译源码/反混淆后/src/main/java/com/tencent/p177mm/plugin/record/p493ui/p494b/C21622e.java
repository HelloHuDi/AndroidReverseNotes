package com.tencent.p177mm.plugin.record.p493ui.p494b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.record.p492b.C21601g;
import com.tencent.p177mm.plugin.record.p492b.C39577s;
import com.tencent.p177mm.plugin.record.p492b.C39577s.C34796a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.plugin.record.p493ui.RecordVoiceBaseView;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.ui.b.e */
public final class C21622e implements C3713b {
    private C39577s pKR = new C39577s();
    RecordVoiceBaseView pLj;

    public C21622e() {
        AppMethodBeat.m2504i(24374);
        AppMethodBeat.m2505o(24374);
    }

    /* renamed from: eK */
    public final View mo8346eK(Context context) {
        AppMethodBeat.m2504i(24375);
        View inflate = View.inflate(context, 2130970485, null);
        ((RecordVoiceBaseView) inflate.findViewById(2131824006)).setVoiceHelper(this.pKR);
        AppMethodBeat.m2505o(24375);
        return inflate;
    }

    /* renamed from: a */
    public final void mo8344a(View view, int i, C43438b c43438b) {
        AppMethodBeat.m2504i(24376);
        View findViewById = view.findViewById(2131826912);
        this.pLj = (RecordVoiceBaseView) view.findViewById(2131824006);
        if (c43438b.dataType == 0) {
            this.pLj.setVisibility(8);
            findViewById.setVisibility(0);
            AppMethodBeat.m2505o(24376);
            return;
        }
        if (c43438b.dataType == 1) {
            findViewById.setVisibility(8);
            this.pLj.setVisibility(0);
            String a = C21601g.m33077a(c43438b);
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 17;
            c37721gh.cAH.cAJ = c43438b.cAv;
            C4879a.xxA.mo10055m(c37721gh);
            int i2 = c37721gh.cAI.ret;
            if (!C1173e.m2561ct(a)) {
                if (C5046bo.isNullOrNil(c43438b.cAv.wfZ)) {
                    findViewById.setVisibility(0);
                    this.pLj.setVisibility(8);
                } else {
                    C4990ab.m7411d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", Long.valueOf(c43438b.mnW.field_localId), c43438b.cAv.wfZ);
                    C37721gh c37721gh2 = new C37721gh();
                    c37721gh2.cAH.type = 16;
                    c37721gh2.cAH.cvv = c43438b.mnW.field_localId;
                    C4879a.xxA.mo10055m(c37721gh2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.pLj;
            int i3 = c43438b.cAv.duration;
            recordVoiceBaseView.path = C5046bo.m7532bc(a, "");
            recordVoiceBaseView.cAO = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) C32850q.m53722fY((long) i3)) + "''");
            }
        }
        AppMethodBeat.m2505o(24376);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(24377);
        C39577s c39577s = this.pKR;
        c39577s.stopPlay();
        c39577s.buK();
        C39577s.mfW = null;
        c39577s.callbacks.clear();
        AppMethodBeat.m2505o(24377);
    }

    public final void pause() {
        AppMethodBeat.m2504i(24378);
        if (this.pKR != null && this.pKR.callbacks.size() > 0) {
            for (C34796a onFinish : this.pKR.callbacks) {
                onFinish.onFinish();
            }
        }
        AppMethodBeat.m2505o(24378);
    }
}
