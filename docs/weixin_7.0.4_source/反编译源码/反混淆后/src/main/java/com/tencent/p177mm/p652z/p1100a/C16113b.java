package com.tencent.p177mm.p652z.p1100a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.avu;
import com.tencent.p177mm.protocal.protobuf.avv;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.z.a.b */
public final class C16113b extends C1207m implements C1918k {
    private C1202f eIc;
    private C16114a<C16113b> eIe;
    private final C7472b ehh;

    /* renamed from: com.tencent.mm.z.a.b$a */
    public interface C16114a<T extends C1207m> {
        /* renamed from: a */
        void mo9731a(int i, int i2, String str, T t);
    }

    public C16113b(String str, LinkedList<String> linkedList, int i, int i2, int i3, C16114a<C16113b> c16114a) {
        this(str, linkedList, i, i2, i3);
        this.eIe = c16114a;
    }

    public C16113b(String str, LinkedList<String> linkedList, int i, C16114a<C16113b> c16114a) {
        this(str, linkedList, 0, i, -1, c16114a);
    }

    private C16113b(String str, LinkedList<String> linkedList, int i, int i2, int i3) {
        AppMethodBeat.m2504i(77757);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avu();
        c1196a.fsK = new avv();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        c1196a.fsI = 1158;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        avu avu = (avu) this.ehh.fsG.fsP;
        if (i3 > 0) {
            avu.wzG = new cxh();
            avu.wzG.scene = i3;
        }
        avu.fKh = str;
        avu.wzD = linkedList;
        avu.wzF = i;
        avu.wzE = i2;
        AppMethodBeat.m2505o(77757);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77758);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIe != null) {
            this.eIe.mo9731a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(77758);
    }

    public final int getType() {
        return 1158;
    }

    /* renamed from: Qs */
    public final avu mo28558Qs() {
        if (this.ehh == null) {
            return null;
        }
        return (avu) this.ehh.fsG.fsP;
    }

    /* renamed from: Qt */
    public final avv mo28559Qt() {
        return (avv) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77759);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(77759);
        return a;
    }
}
