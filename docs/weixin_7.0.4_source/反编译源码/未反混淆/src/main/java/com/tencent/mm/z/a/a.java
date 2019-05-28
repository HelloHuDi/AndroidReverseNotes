package com.tencent.mm.z.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class a extends m implements k {
    private f eIc;
    private a<a> eId;
    private final b ehh;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public a(String str, LinkedList<String> linkedList, a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i, int i2, a<a> aVar) {
        this(str, linkedList, i, i2);
        this.eId = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i, int i2) {
        AppMethodBeat.i(77754);
        ab.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", str, Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new avw();
        aVar.fsK = new avx();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.fsI = 1157;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        avw avw = (avw) this.ehh.fsG.fsP;
        if (i2 > 0) {
            avw.wzG = new cxh();
            avw.wzG.scene = i2;
        }
        avw.fKh = str;
        avw.wzD = linkedList;
        avw.wzF = i;
        AppMethodBeat.o(77754);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77755);
        ab.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eId != null) {
            this.eId.a(i2, i3, str, this);
        }
        AppMethodBeat.o(77755);
    }

    public final int getType() {
        return 1157;
    }

    public final avw Qq() {
        if (this.ehh == null) {
            return null;
        }
        return (avw) this.ehh.fsG.fsP;
    }

    public final avx Qr() {
        return (avx) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(77756);
        ab.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(77756);
        return a;
    }
}
