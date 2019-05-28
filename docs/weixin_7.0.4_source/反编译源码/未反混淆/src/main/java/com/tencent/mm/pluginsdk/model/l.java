package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends x {
    public String hzi;

    public l(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(27300);
        ab.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", str);
        this.hzi = str;
        a aVar = new a();
        aVar.fsJ = new apo();
        aVar.fsK = new app();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        this.lty = aVar.acD();
        apo apo = (apo) this.lty.fsG.fsP;
        apo.mZr = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!bo.isNullOrNil(str2)) {
                linkedList2.add(aa.vy(str2));
            }
        }
        apo.vEg = linkedList2;
        apo.wnW = linkedList.size();
        AppMethodBeat.o(27300);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27301);
        ab.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(27301);
            return;
        }
        ab.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(27301);
    }

    public final byte[] dhj() {
        AppMethodBeat.i(27302);
        try {
            byte[] ZT = ((b) this.lty.acF()).ZT();
            AppMethodBeat.o(27302);
            return ZT;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            AppMethodBeat.o(27302);
            return null;
        }
    }

    public final void bG(byte[] bArr) {
        AppMethodBeat.i(27303);
        if (bArr == null) {
            ab.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            AppMethodBeat.o(27303);
            return;
        }
        try {
            this.lty.fsH.P(bArr);
            AppMethodBeat.o(27303);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            AppMethodBeat.o(27303);
        }
    }

    public final int getType() {
        return 14;
    }

    public final app dhk() {
        if (this.lty == null) {
            return null;
        }
        return (app) this.lty.fsH.fsP;
    }
}
