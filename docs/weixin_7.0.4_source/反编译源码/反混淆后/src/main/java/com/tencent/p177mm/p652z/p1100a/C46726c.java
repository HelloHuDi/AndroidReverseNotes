package com.tencent.p177mm.p652z.p1100a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.awa;
import com.tencent.p177mm.protocal.protobuf.awb;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.z.a.c */
public final class C46726c extends C1207m implements C1918k {
    private C1202f eIc;
    private C44434a<C46726c> eIf;
    private final C7472b ehh;

    /* renamed from: com.tencent.mm.z.a.c$a */
    public interface C44434a<T extends C1207m> {
        /* renamed from: a */
        void mo9736a(int i, int i2, String str, T t);
    }

    public C46726c(String str, LinkedList<String> linkedList, String str2, String str3, C44434a<C46726c> c44434a) {
        this(str, linkedList, 0, str2, str3, 0, -1, c44434a);
    }

    public C46726c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, C44434a<C46726c> c44434a) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.eIf = c44434a;
    }

    private C46726c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        AppMethodBeat.m2504i(77760);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new awa();
        c1196a.fsK = new awb();
        c1196a.uri = "/cgi-bin/mmbiz-bin/js-login";
        c1196a.fsI = 1029;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(77760);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77761);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.eIf != null) {
            this.eIf.mo9736a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(77761);
    }

    public final int getType() {
        return 1029;
    }

    /* renamed from: Qu */
    public final awa mo75143Qu() {
        if (this.ehh == null) {
            return null;
        }
        return (awa) this.ehh.fsG.fsP;
    }

    /* renamed from: Qv */
    public final awb mo75144Qv() {
        return (awb) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77762);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(77762);
        return a;
    }
}
