package com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.a.b.d */
public final class C39821d extends C22052a {
    public boolean czr;
    public String userName;

    public C39821d(String str, boolean z) {
        super(new C46236n());
        AppMethodBeat.m2504i(39956);
        this.userName = str;
        this.czr = z;
        dLZ();
        AppMethodBeat.m2505o(39956);
    }

    public final Cursor cuR() {
        boolean z;
        AppMethodBeat.m2504i(39957);
        init();
        C1720g.m3537RQ();
        if (this.userName.equals((String) C1720g.m3536RP().mo5239Ry().get(2, null))) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7410d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
        Cursor e = C13373af.cnF().mo62937e(this.userName, z, cuO());
        AppMethodBeat.m2505o(39957);
        return e;
    }

    /* renamed from: w */
    public final String mo63009w(long j, String str) {
        AppMethodBeat.m2504i(39958);
        C4990ab.m7411d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", Integer.valueOf(C13373af.cnv().cod()), str);
        String jW = C29036i.m46118jW(C13373af.cnF().mo62925a(j, C13373af.cnv().mo8616Yc(this.userName), this.userName, this.czr));
        if (!this.rmL.equals("") && jW.compareTo(this.rmL) >= 0) {
            jW = this.rmL;
        }
        aao cqL = C13373af.cnJ().mo69179YX(this.userName).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.m2505o(39958);
            return jW;
        }
        String jW2 = C29036i.m46118jW(cqL.wfM);
        if (jW.equals("")) {
            AppMethodBeat.m2505o(39958);
            return jW2;
        } else if (jW2.compareTo(jW) > 0) {
            AppMethodBeat.m2505o(39958);
            return jW2;
        } else {
            AppMethodBeat.m2505o(39958);
            return jW;
        }
    }
}
