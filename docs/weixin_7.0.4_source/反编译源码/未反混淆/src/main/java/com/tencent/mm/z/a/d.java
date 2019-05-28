package com.tencent.mm.z.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;

public final class d extends m implements k {
    private f eIc;
    private a<d> eIg;
    private final b ehh;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public d(String str, LinkedList<String> linkedList, String str2, int i, a<d> aVar) {
        this(str, linkedList, 0, str2, 0, i, -1, aVar);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4, a<d> aVar) {
        this(str, linkedList, i, str2, i2, i3, i4);
        this.eIg = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(77763);
        ab.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new avy();
        aVar.fsK = new avz();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.fsI = FaceManager.FACE_WITH_EYES_CLOSED;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        avy avy = (avy) this.ehh.fsG.fsP;
        if (i4 > 0) {
            avy.wzG = new cxh();
            avy.wzG.scene = i4;
        }
        avy.fKh = str;
        avy.wzD = linkedList;
        avy.wzM = i;
        avy.wzN = str2;
        avy.wzF = i2;
        avy.wzE = i3;
        AppMethodBeat.o(77763);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77764);
        ab.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIg != null) {
            this.eIg.a(i2, i3, str, this);
        }
        AppMethodBeat.o(77764);
    }

    public final int getType() {
        return FaceManager.FACE_WITH_EYES_CLOSED;
    }

    public final avy Qw() {
        if (this.ehh == null) {
            return null;
        }
        return (avy) this.ehh.fsG.fsP;
    }

    public final avz Qx() {
        return (avz) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(77765);
        ab.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(77765);
        return a;
    }
}
