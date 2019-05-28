package com.tencent.p177mm.p652z.p1100a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.avy;
import com.tencent.p177mm.protocal.protobuf.avz;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.z.a.d */
public final class C44435d extends C1207m implements C1918k {
    private C1202f eIc;
    private C36403a<C44435d> eIg;
    private final C7472b ehh;

    /* renamed from: com.tencent.mm.z.a.d$a */
    public interface C36403a<T extends C1207m> {
        /* renamed from: a */
        void mo9735a(int i, int i2, String str, T t);
    }

    public C44435d(String str, LinkedList<String> linkedList, String str2, int i, C36403a<C44435d> c36403a) {
        this(str, linkedList, 0, str2, 0, i, -1, c36403a);
    }

    public C44435d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4, C36403a<C44435d> c36403a) {
        this(str, linkedList, i, str2, i2, i3, i4);
        this.eIg = c36403a;
    }

    private C44435d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(77763);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avy();
        c1196a.fsK = new avz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        c1196a.fsI = FaceManager.FACE_WITH_EYES_CLOSED;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(77763);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77764);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIg != null) {
            this.eIg.mo9735a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(77764);
    }

    public final int getType() {
        return FaceManager.FACE_WITH_EYES_CLOSED;
    }

    /* renamed from: Qw */
    public final avy mo70365Qw() {
        if (this.ehh == null) {
            return null;
        }
        return (avy) this.ehh.fsG.fsP;
    }

    /* renamed from: Qx */
    public final avz mo70366Qx() {
        return (avz) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77765);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(77765);
        return a;
    }
}
