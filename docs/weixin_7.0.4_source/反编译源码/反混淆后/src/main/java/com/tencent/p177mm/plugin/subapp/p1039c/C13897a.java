package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bfs;
import com.tencent.p177mm.protocal.protobuf.bft;
import com.tencent.p177mm.protocal.protobuf.coc;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.subapp.c.a */
public final class C13897a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C13897a(LinkedList<coc> linkedList, int i) {
        AppMethodBeat.m2504i(25247);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfs();
        c1196a.fsK = new bft();
        c1196a.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        c1196a.fsI = ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
        this.ehh = c1196a.acD();
        bfs bfs = (bfs) this.ehh.fsG.fsP;
        bfs.OpCode = 1;
        bfs.wJz = linkedList;
        bfs.wJy = i;
        AppMethodBeat.m2505o(25247);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25248);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25248);
        return a;
    }

    public final int getType() {
        return ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25249);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25249);
    }
}
