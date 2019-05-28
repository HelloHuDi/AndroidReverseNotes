package com.tencent.p177mm.p652z.p1100a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.avw;
import com.tencent.p177mm.protocal.protobuf.avx;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.z.a.a */
public final class C30907a extends C1207m implements C1918k {
    private C1202f eIc;
    private C30906a<C30907a> eId;
    private final C7472b ehh;

    /* renamed from: com.tencent.mm.z.a.a$a */
    public interface C30906a<T extends C1207m> {
        /* renamed from: a */
        void mo21762a(int i, int i2, String str, T t);
    }

    public C30907a(String str, LinkedList<String> linkedList, C30906a<C30907a> c30906a) {
        this(str, linkedList, 0, -1, c30906a);
    }

    public C30907a(String str, LinkedList<String> linkedList, int i, int i2, C30906a<C30907a> c30906a) {
        this(str, linkedList, i, i2);
        this.eId = c30906a;
    }

    private C30907a(String str, LinkedList<String> linkedList, int i, int i2) {
        AppMethodBeat.m2504i(77754);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", str, Integer.valueOf(i), Integer.valueOf(i2));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avw();
        c1196a.fsK = new avx();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        c1196a.fsI = 1157;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        avw avw = (avw) this.ehh.fsG.fsP;
        if (i2 > 0) {
            avw.wzG = new cxh();
            avw.wzG.scene = i2;
        }
        avw.fKh = str;
        avw.wzD = linkedList;
        avw.wzF = i;
        AppMethodBeat.m2505o(77754);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77755);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eId != null) {
            this.eId.mo21762a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(77755);
    }

    public final int getType() {
        return 1157;
    }

    /* renamed from: Qq */
    public final avw mo49441Qq() {
        if (this.ehh == null) {
            return null;
        }
        return (avw) this.ehh.fsG.fsP;
    }

    /* renamed from: Qr */
    public final avx mo49442Qr() {
        return (avx) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77756);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(77756);
        return a;
    }
}
