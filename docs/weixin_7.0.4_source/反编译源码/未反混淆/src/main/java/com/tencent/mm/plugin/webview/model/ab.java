package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.bum;
import java.util.LinkedList;

public final class ab extends m implements k {
    private f eIc;
    private final b ehh;

    public ab(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.i(6646);
        a aVar = new a();
        aVar.fsJ = new bul();
        aVar.fsK = new bum();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        this.ehh = aVar.acD();
        bul bul = (bul) this.ehh.fsG.fsP;
        bul.wII = i;
        bul.csB = str;
        bul.wIJ = linkedList;
        bul.state = str2;
        bul.wWc = str3;
        AppMethodBeat.o(6646);
    }

    public ab(String str, String str2, String str3, LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(6647);
        a aVar = new a();
        aVar.fsJ = new bul();
        aVar.fsK = new bum();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        this.ehh = aVar.acD();
        bul bul = (bul) this.ehh.fsG.fsP;
        bul.wII = 1;
        bul.csB = str;
        bul.wIJ = linkedList;
        bul.state = str2;
        bul.wWc = str3;
        bul.wcA = i;
        AppMethodBeat.o(6647);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6648);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6648);
    }

    public final bum cXC() {
        return (bum) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 1346;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6649);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6649);
        return a;
    }
}
