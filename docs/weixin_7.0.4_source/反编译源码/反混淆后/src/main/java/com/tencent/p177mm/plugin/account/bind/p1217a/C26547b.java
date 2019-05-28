package com.tencent.p177mm.plugin.account.bind.p1217a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C35928jq;
import com.tencent.p177mm.protocal.protobuf.C35929jr;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.account.bind.a.b */
public final class C26547b extends C1207m implements C1918k {
    private String cCU;
    private String cCW;
    public final C7472b ehh;
    private C1202f ehi;
    public long fPN;

    public C26547b(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] d;
        AppMethodBeat.m2504i(13320);
        this.fPN = 0;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35928jq();
        c1196a.fsK = new C35929jr();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindqq";
        c1196a.fsI = 144;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.fPN = j;
        C35928jq c35928jq = (C35928jq) this.ehh.fsG.fsP;
        c35928jq.vLV = new C1183p(j).intValue();
        c35928jq.vLJ = "";
        c35928jq.vLW = "";
        c35928jq.vLX = "";
        c35928jq.vLY = "";
        c35928jq.vMa = new bts().alV("");
        c35928jq.vLZ = 1;
        if (z) {
            d = C1720g.m3534RN().mo5158QR().mo4504d(j, str3);
        } else {
            d = C1720g.m3534RN().mo5158QR().mo4503a(j, C5046bo.ane(str), true);
        }
        c35928jq.vJT = new SKBuiltinBuffer_t().setBuffer(d);
        c35928jq.vMb = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(47, null))));
        C4990ab.m7417i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(C5046bo.m7541cc(d)), str3, str2, str4, r1);
        AppMethodBeat.m2505o(13320);
    }

    public C26547b(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        AppMethodBeat.m2504i(13321);
        this.cCU = str5;
        this.cCW = str6;
        C35928jq c35928jq = (C35928jq) this.ehh.fsG.fsP;
        c35928jq.vLx = str5;
        c35928jq.vLy = str6;
        AppMethodBeat.m2505o(13321);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13322);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13322);
        return a;
    }

    public final int getType() {
        return 144;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        boolean z;
        AppMethodBeat.m2504i(13323);
        C35928jq c35928jq = (C35928jq) this.ehh.fsG.fsP;
        C35929jr c35929jr = (C35929jr) this.ehh.fsH.fsP;
        byte[] a = C1946aa.m4150a(c35929jr.vHJ);
        if (C5046bo.m7540cb(a)) {
            z = false;
        } else {
            z = C1720g.m3534RN().mo5158QR().mo4502a(new C1183p(c35928jq.vLV).longValue(), a);
        }
        C4990ab.m7417i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(C5046bo.m7541cc(a)), c35929jr.vLX);
        if (i2 == 0 && i3 == 0) {
            int i4 = C1720g.m3536RP().mo5239Ry().getInt(9, 0);
            C1720g.m3536RP().mo5239Ry().set(9, Integer.valueOf(c35928jq.vLV));
            if (i4 != 0) {
                if (C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(String.valueOf(i4))) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, C1853r.m3846Yz());
                }
                for (String str2 : C37914bx.fnB.aat()) {
                    if (String.valueOf(i4).equals(C37914bx.fnB.getString(str2, "login_user_name"))) {
                        C37914bx.fnB.mo60668n(str2, "login_user_name", str2);
                    }
                }
            }
            if (c35928jq.vLZ == 1) {
                C1720g.m3536RP().mo5239Ry().set(17, Integer.valueOf(c35929jr.vCo));
            }
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15357aT(c35929jr.vMe, c35929jr.vMd == 1);
            i4 = c35928jq.vLV;
            if (i4 != 0) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15359cE(new C1183p(i4) + "@qqim", 3);
            }
            C41730b.m73494d((long) i4, 3);
            C1720g.m3536RP().mo5239Ry().set(32, c35928jq.vLJ);
            C1720g.m3536RP().mo5239Ry().set(33, c35928jq.vLW);
            C4990ab.m7417i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(z), C5046bo.anv(C5046bo.m7543cd(C1720g.m3534RN().mo5158QR().mo4506ft(new C1183p(c35928jq.vLV).longValue()))));
            C1720g.m3536RP().mo5239Ry().set(72, r2);
            C1720g.m3536RP().mo5239Ry().set(46, C5046bo.m7543cd(C1946aa.m4150a(c35929jr.vHP)));
            Object cd = C5046bo.m7543cd(C1946aa.m4150a(c35928jq.vMb));
            C1720g.m3536RP().mo5239Ry().set(47, cd);
            C1720g.m3536RP().eJH.set(18, cd);
            C1720g.m3536RP().mo5239Ry().set(-1535680990, c35929jr.vMf);
        } else if (i2 == 4) {
            C1720g.m3536RP().mo5239Ry().set(32, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(33, (Object) "");
        }
        if (c35928jq.vLZ == 3 && i3 == -3) {
            i3 = Downloads.MIN_WAIT_FOR_NETWORK;
            C4990ab.m7410d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13323);
    }
}
