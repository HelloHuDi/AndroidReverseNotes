package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class m extends com.tencent.mm.ai.m implements k {
    private String account;
    private b ehh;
    private f ehi;

    public m(String str) {
        AppMethodBeat.i(123433);
        this.account = str;
        a aVar = new a();
        aVar.fsJ = new amu();
        aVar.fsK = new amv();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        this.ehh = aVar.acD();
        ((amu) this.ehh.fsG.fsP).jBB = str;
        AppMethodBeat.o(123433);
    }

    public final int getType() {
        return 302;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(123434);
        if (bo.isNullOrNil(this.account)) {
            ab.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            AppMethodBeat.o(123434);
            return -1;
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(123434);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(123435);
        ab.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            amv amv = (amv) this.ehh.fsH.fsP;
            tr trVar = new tr();
            trVar.cPQ.cPR = amv.wrv.xke;
            com.tencent.mm.sdk.b.a.xxA.m(trVar);
            if (r.Yz().equals(amv.wru.wcB.toString()) && !bo.isNullOrNil(amv.wrv.vXn)) {
                g.RP().Ry().set(ac.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, amv.wrv.vXn);
            }
            ab.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(amv.wru.wHd), Integer.valueOf(amv.wrv.xjY));
            g.RP().Ry().set(64, Integer.valueOf(amv.wrv.vCl));
            g.RP().Ry().set(144385, Integer.valueOf(amv.wrv.xjY));
            g.RP().Ry().set(40, Integer.valueOf(amv.wru.wHd));
            g.RP().Ry().set(339975, Integer.valueOf(amv.wrv.xkg));
            ab.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(amv.wrv.xkg));
            g.RP().Ry().set(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(amv.wrv.wlv));
            ab.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(amv.wrv.xkg), Integer.valueOf(amv.wrv.wlv));
            g.RP().Ry().set(208903, amv.wrv.vLf);
            g.RP().Ry().set(274433, amv.wrv.wGn);
            g.RP().Ry().set(274434, amv.wrv.wGm);
            g.RP().Ry().set(274436, amv.wrv.xjZ);
            g.RP().Ry().set(ac.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bo.bc(amv.wrv.duq, ""));
            g.RP().Ry().set(ac.a.USERINFO_F2F_RING_TONE_STRING, amv.wrv.xki);
            ab.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", amv.wrv.duq);
            av.fly.ak("last_login_use_voice", amv.wru.wHd);
            if (VERSION.SDK_INT < 23) {
                System.putString(ah.getContext().getContentResolver(), "89884a87498ef44f", amv.wrv.xkf);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(123435);
    }
}
