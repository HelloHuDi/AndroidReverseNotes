package com.tencent.mm.z.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class c extends m implements k {
    private f eIc;
    private a<c> eIf;
    private final b ehh;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, a<c> aVar) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.eIf = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(77760);
        ab.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new awa();
        aVar.fsK = new awb();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.fsI = 1029;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        awa awa = (awa) this.ehh.fsG.fsP;
        awa.fKh = str;
        awa.wzD = linkedList;
        awa.wzM = i;
        awa.Url = str2;
        awa.wzN = str3;
        awa.wzF = i2;
        if (i3 > 0) {
            awa.wzG = new cxh();
            awa.wzG.scene = i3;
        }
        AppMethodBeat.o(77760);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77761);
        ab.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIf != null) {
            this.eIf.a(i2, i3, str, this);
        }
        AppMethodBeat.o(77761);
    }

    public final int getType() {
        return 1029;
    }

    public final awa Qu() {
        if (this.ehh == null) {
            return null;
        }
        return (awa) this.ehh.fsG.fsP;
    }

    public final awb Qv() {
        return (awb) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(77762);
        ab.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(77762);
        return a;
    }
}
