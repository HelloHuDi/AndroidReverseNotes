package com.tencent.p177mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.pluginsdk.model.app.C40442x;
import com.tencent.p177mm.protocal.protobuf.C40503app;
import com.tencent.p177mm.protocal.protobuf.apo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.model.l */
public final class C44063l extends C40442x {
    public String hzi;

    public C44063l(String str, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(27300);
        C4990ab.m7417i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", str);
        this.hzi = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apo();
        c1196a.fsK = new C40503app();
        c1196a.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        this.lty = c1196a.acD();
        apo apo = (apo) this.lty.fsG.fsP;
        apo.mZr = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!C5046bo.isNullOrNil(str2)) {
                linkedList2.add(C1946aa.m4154vy(str2));
            }
        }
        apo.vEg = linkedList2;
        apo.wnW = linkedList.size();
        AppMethodBeat.m2505o(27300);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27301);
        C4990ab.m7416i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.m2505o(27301);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.m2505o(27301);
    }

    public final byte[] dhj() {
        AppMethodBeat.m2504i(27302);
        try {
            byte[] ZT = ((C6295b) this.lty.acF()).mo5742ZT();
            AppMethodBeat.m2505o(27302);
            return ZT;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            AppMethodBeat.m2505o(27302);
            return null;
        }
    }

    /* renamed from: bG */
    public final void mo9871bG(byte[] bArr) {
        AppMethodBeat.m2504i(27303);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            AppMethodBeat.m2505o(27303);
            return;
        }
        try {
            this.lty.fsH.mo5744P(bArr);
            AppMethodBeat.m2505o(27303);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            AppMethodBeat.m2505o(27303);
        }
    }

    public final int getType() {
        return 14;
    }

    public final C40503app dhk() {
        if (this.lty == null) {
            return null;
        }
        return (C40503app) this.lty.fsH.fsP;
    }
}
