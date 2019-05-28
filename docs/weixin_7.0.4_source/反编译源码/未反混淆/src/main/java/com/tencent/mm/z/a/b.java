package com.tencent.mm.z.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b extends m implements k {
    private f eIc;
    private a<b> eIe;
    private final com.tencent.mm.ai.b ehh;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public b(String str, LinkedList<String> linkedList, int i, int i2, int i3, a<b> aVar) {
        this(str, linkedList, i, i2, i3);
        this.eIe = aVar;
    }

    public b(String str, LinkedList<String> linkedList, int i, a<b> aVar) {
        this(str, linkedList, 0, i, -1, aVar);
    }

    private b(String str, LinkedList<String> linkedList, int i, int i2, int i3) {
        AppMethodBeat.i(77757);
        ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new avu();
        aVar.fsK = new avv();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.fsI = 1158;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        avu avu = (avu) this.ehh.fsG.fsP;
        if (i3 > 0) {
            avu.wzG = new cxh();
            avu.wzG.scene = i3;
        }
        avu.fKh = str;
        avu.wzD = linkedList;
        avu.wzF = i;
        avu.wzE = i2;
        AppMethodBeat.o(77757);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77758);
        ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIe != null) {
            this.eIe.a(i2, i3, str, this);
        }
        AppMethodBeat.o(77758);
    }

    public final int getType() {
        return 1158;
    }

    public final avu Qs() {
        if (this.ehh == null) {
            return null;
        }
        return (avu) this.ehh.fsG.fsP;
    }

    public final avv Qt() {
        return (avv) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(77759);
        ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(77759);
        return a;
    }
}
