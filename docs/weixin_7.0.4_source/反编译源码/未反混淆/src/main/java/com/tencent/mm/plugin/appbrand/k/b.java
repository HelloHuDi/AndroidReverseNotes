package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import java.util.Locale;

public final class b extends m implements k {
    private f eIc;
    private com.tencent.mm.ai.b fpJ;
    private csz ioc;

    public b() {
        AppMethodBeat.i(132309);
        a aVar = new a();
        aVar.fsJ = new csy();
        aVar.fsK = new csz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        this.fpJ = aVar.acD();
        AppMethodBeat.o(132309);
    }

    public final int getType() {
        return 1170;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(132310);
        ab.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(132310);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(132311);
        ab.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ioc = (csz) this.fpJ.fsH.fsP;
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.ioc.xqh == null) {
            AppMethodBeat.o(132311);
            return;
        }
        z Ry = g.RP().Ry();
        Ry.set(ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, Locale.getDefault().getLanguage());
        Ry.set(ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, this.ioc.xqh.nzz);
        Ry.set(ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, this.ioc.xqh.xqg);
        Ry.set(ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(132311);
    }
}
