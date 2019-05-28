package com.tencent.mm.plugin.hp.c;

import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public class a extends m implements k {
    protected final b ehh;
    protected f ehi;
    protected int gOW = 0;
    protected LinkedList<bhw> kdX = new LinkedList();
    protected String ntS;
    protected String ntT;
    protected LinkedList<bhv> ntU = new LinkedList();
    protected int ntV = 0;
    protected String type;

    public a() {
        AppMethodBeat.i(90616);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bhw();
        aVar.fsK = new bhx();
        aVar.uri = "/cgi-bin/micromsg-bin/prconfig";
        aVar.fsI = 3899;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(90616);
    }

    public final int getType() {
        return 3899;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(90617);
        this.ehi = fVar;
        bhw bhw = (bhw) this.ehh.fsG.fsP;
        bhw.wLb = this.ntS;
        bhw.pdA = this.ntT;
        bhw.wLc = this.ntU;
        bhw.type = this.type;
        bhw.tOS = this.kdX;
        bhw.wLd = this.ntV;
        bhw.wLe = this.gOW;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(90617);
        return a;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(90618);
        ab.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(90618);
    }

    public static LinkedList<bhv> bGn() {
        AppMethodBeat.i(90619);
        LinkedList linkedList = new LinkedList();
        long j = 0;
        try {
            j = ((long) com.tencent.mm.kernel.a.Ra()) & 4294967295L;
            ab.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "uin is %s", bo.anv(String.valueOf(j)));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
        }
        linkedList.add(eH("code-version", com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION));
        linkedList.add(eH("code-reversion", com.tencent.mm.sdk.platformtools.f.REV));
        linkedList.add(eH(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(VERSION.SDK_INT)));
        linkedList.add(eH("os-name", d.vxl));
        linkedList.add(eH("device-brand", d.vxi));
        linkedList.add(eH("device-name", d.DEVICE_NAME));
        linkedList.add(eH(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)));
        linkedList.add(eH(TencentLocation.NETWORK_PROVIDER, String.valueOf(at.isWifi(ah.getContext()) ? 3 : 2)));
        List<com.tencent.mm.plugin.boots.a.a> aVJ = ((c) g.K(c.class)).aVJ();
        if (aVJ != null) {
            for (com.tencent.mm.plugin.boots.a.a aVar : aVJ) {
                linkedList.add(eH(Integer.toHexString(aVar.field_key), String.valueOf(aVar.field_dau)));
            }
        }
        AppMethodBeat.o(90619);
        return linkedList;
    }

    private static bhv eH(String str, String str2) {
        AppMethodBeat.i(90620);
        bhv bhv = new bhv();
        bhv.key = str;
        bhv.value = str2;
        AppMethodBeat.o(90620);
        return bhv;
    }
}
