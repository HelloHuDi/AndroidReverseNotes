package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.sdk.platformtools.ab;
import org.xwalk.core.XWalkEnvironment;

public final class j extends m implements k {
    private final b ehh;
    private f ehi;

    public j(String str, String str2) {
        this(str, str2, 0);
    }

    public j(String str, String str2, int i) {
        AppMethodBeat.i(126858);
        a aVar = new a();
        aVar.fsJ = new bwf();
        aVar.fsK = new bwg();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.fsI = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bwf bwf = (bwf) this.ehh.fsG.fsP;
        bwf.wWV = str;
        bwf.ncM = str2;
        bwf.wBm = i;
        AppMethodBeat.o(126858);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126859);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(126859);
        return a;
    }

    public final int getType() {
        return XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126860);
        ab.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126860);
    }
}
