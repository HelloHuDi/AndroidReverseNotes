package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    public b ehh;
    private f ehi;
    private long sAZ = System.currentTimeMillis();

    public g(long j, String str, String str2, String str3, com.tencent.mm.pluginsdk.model.app.f fVar, String str4) {
        AppMethodBeat.i(96392);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostVideo", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", Long.valueOf(j), str, str2, str3, str4);
        a aVar = new a();
        aVar.fsI = 2534;
        aVar.uri = "/cgi-bin/mmsearch-bin/colikepost";
        aVar.fsJ = new ti();
        aVar.fsK = new tj();
        this.ehh = aVar.acD();
        ti tiVar = (ti) this.ehh.fsG.fsP;
        tiVar.timestamp = j;
        tiVar.way = str;
        tiVar.vGv = str2;
        tiVar.nQB = str3;
        tiVar.waz = new te();
        tiVar.waz.appName = fVar.field_appName;
        tiVar.waz.appId = fVar.field_appId;
        tiVar.waz.version = str4;
        AppMethodBeat.o(96392);
    }

    public final int getType() {
        return 2534;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96393);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96393);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96394);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostVideo", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96394);
    }
}
