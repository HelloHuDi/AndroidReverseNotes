package com.tencent.p177mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32643tr;
import com.tencent.p177mm.protocal.protobuf.amu;
import com.tencent.p177mm.protocal.protobuf.amv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.modelsimple.m */
public final class C32826m extends C1207m implements C1918k {
    private String account;
    private C7472b ehh;
    private C1202f ehi;

    public C32826m(String str) {
        AppMethodBeat.m2504i(123433);
        this.account = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amu();
        c1196a.fsK = new amv();
        c1196a.uri = "/cgi-bin/micromsg-bin/getprofile";
        this.ehh = c1196a.acD();
        ((amu) this.ehh.fsG.fsP).jBB = str;
        AppMethodBeat.m2505o(123433);
    }

    public final int getType() {
        return 302;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123434);
        if (C5046bo.isNullOrNil(this.account)) {
            C4990ab.m7412e("MicroMsg.NetSceneGetProfile", "null or empty username");
            AppMethodBeat.m2505o(123434);
            return -1;
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(123434);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(123435);
        C4990ab.m7410d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            amv amv = (amv) this.ehh.fsH.fsP;
            C32643tr c32643tr = new C32643tr();
            c32643tr.cPQ.cPR = amv.wrv.xke;
            C4879a.xxA.mo10055m(c32643tr);
            if (C1853r.m3846Yz().equals(amv.wru.wcB.toString()) && !C5046bo.isNullOrNil(amv.wrv.vXn)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SELFINFO_SMALLIMGURL_STRING, amv.wrv.vXn);
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(amv.wru.wHd), Integer.valueOf(amv.wrv.xjY));
            C1720g.m3536RP().mo5239Ry().set(64, Integer.valueOf(amv.wrv.vCl));
            C1720g.m3536RP().mo5239Ry().set(144385, Integer.valueOf(amv.wrv.xjY));
            C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(amv.wru.wHd));
            C1720g.m3536RP().mo5239Ry().set(339975, Integer.valueOf(amv.wrv.xkg));
            C4990ab.m7417i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(amv.wrv.xkg));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(amv.wrv.wlv));
            C4990ab.m7417i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(amv.wrv.xkg), Integer.valueOf(amv.wrv.wlv));
            C1720g.m3536RP().mo5239Ry().set(208903, amv.wrv.vLf);
            C1720g.m3536RP().mo5239Ry().set(274433, amv.wrv.wGn);
            C1720g.m3536RP().mo5239Ry().set(274434, amv.wrv.wGm);
            C1720g.m3536RP().mo5239Ry().set(274436, amv.wrv.xjZ);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, C5046bo.m7532bc(amv.wrv.duq, ""));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_F2F_RING_TONE_STRING, amv.wrv.xki);
            C4990ab.m7411d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", amv.wrv.duq);
            C6665av.fly.mo14897ak("last_login_use_voice", amv.wru.wHd);
            if (VERSION.SDK_INT < 23) {
                System.putString(C4996ah.getContext().getContentResolver(), "89884a87498ef44f", amv.wrv.xkf);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(123435);
    }
}
