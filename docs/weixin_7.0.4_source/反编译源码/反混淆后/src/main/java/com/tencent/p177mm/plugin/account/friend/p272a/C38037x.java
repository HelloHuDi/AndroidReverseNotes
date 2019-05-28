package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C35927jp;
import com.tencent.p177mm.protocal.protobuf.C40535jo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.account.friend.a.x */
public final class C38037x extends C1207m implements C1918k {
    private String cCU;
    private String cCW;
    public final C7472b ehh;
    private C1202f ehi;
    private int ftx;

    public C38037x(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        AppMethodBeat.m2504i(108428);
        this.cCU = str4;
        this.cCW = str5;
        C40535jo c40535jo = (C40535jo) this.ehh.fsG.fsP;
        c40535jo.vLx = str4;
        c40535jo.vLy = str5;
        AppMethodBeat.m2505o(108428);
    }

    public C38037x(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.m2504i(108429);
        this.ehi = null;
        this.ftx = 2;
        this.cCU = null;
        this.cCW = null;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40535jo();
        c1196a.fsK = new C35927jp();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        c1196a.fsI = 132;
        c1196a.fsL = 45;
        c1196a.fsM = 1000000045;
        this.ehh = c1196a.acD();
        C40535jo c40535jo = (C40535jo) this.ehh.fsG.fsP;
        c40535jo.vIJ = i;
        c40535jo.vLu = i2;
        c40535jo.vLv = str3;
        if (C5046bo.isNullOrNil(this.cCU) && C5046bo.isNullOrNil(this.cCW)) {
            c40535jo.vLx = C5059g.xyg ? C4996ah.getContext().getString(C25738R.string.dw2) : C4996ah.getContext().getString(C25738R.string.dw1);
            c40535jo.vLy = C7243d.DEVICE_NAME;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            C1720g.m3536RP().mo5239Ry().set(4097, (Object) str);
        } else if (i == 2 || i == 19) {
            str = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        } else if (i == 3) {
            str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        }
        C4990ab.m7410d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        c40535jo.vLs = str;
        c40535jo.vLt = str2;
        c40535jo.luQ = C4988aa.dor();
        AppMethodBeat.m2505o(108429);
    }

    /* renamed from: Ah */
    public final int mo60786Ah() {
        return ((C40535jo) this.ehh.fsG.fsP).vIJ;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108430);
        this.ehi = c1202f;
        C40535jo c40535jo = (C40535jo) this.ehh.fsG.fsP;
        if (c40535jo.vLs == null || c40535jo.vLs.length() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + c40535jo.vLs);
            AppMethodBeat.m2505o(108430);
            return -1;
        } else if ((c40535jo.vIJ == 2 || c40535jo.vIJ == 19) && (c40535jo.vLt == null || c40535jo.vLt.length() <= 0)) {
            C4990ab.m7412e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + c40535jo.vLs);
            AppMethodBeat.m2505o(108430);
            return -1;
        } else {
            int a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(108430);
            return a;
        }
    }

    public final int getType() {
        return 132;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108431);
        C40535jo c40535jo = (C40535jo) this.ehh.fsG.fsP;
        C35927jp c35927jp = (C35927jp) this.ehh.fsH.fsP;
        if (c35927jp != null) {
            int i4 = c35927jp.vHW;
            C4990ab.m7417i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", Integer.valueOf(i4));
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(47, Integer.valueOf(i4));
            C1902e c1902e = C1720g.m3535RO().eJo.ftA;
            if (c1902e != null) {
                c1902e.mo5534cI((i4 & 1) == 0);
            }
        } else {
            C4990ab.m7417i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", c35927jp);
        }
        if (i2 == 0 && i3 == 0) {
            if (c35927jp != null) {
                C4990ab.m7410d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + c35927jp.vLH + "safedevice status = " + c35927jp.vCl);
            }
            if (c40535jo.vIJ == 2 || c40535jo.vIJ == 4 || c40535jo.vIJ == 11 || c40535jo.vIJ == 19) {
                C1720g.m3536RP().mo5239Ry().set(4097, (Object) "");
                String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
                C1720g.m3536RP().mo5239Ry().set(6, c40535jo.vLs);
                if (!C5046bo.isNullOrNil(str2)) {
                    if (C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(str2)) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, C1853r.m3846Yz());
                    }
                    for (String str3 : C37914bx.fnB.aat()) {
                        if (str2.equals(C37914bx.fnB.getString(str3, "login_user_name"))) {
                            C37914bx.fnB.mo60668n(str3, "login_user_name", str3);
                        }
                    }
                }
                if (C5046bo.isNullOrNil(this.cCU) || C5046bo.isNullOrNil(this.cCW)) {
                    C38033l.apP();
                }
                if (c40535jo.vIJ == 19) {
                    C1720g.m3536RP().mo5239Ry().set(12322, null);
                }
                C4990ab.m7410d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (c40535jo.vIJ == 3) {
                C1720g.m3536RP().mo5239Ry().set(4097, (Object) "");
                C1720g.m3536RP().mo5239Ry().set(6, (Object) "");
                C1720g.m3536RP().mo5239Ry().set(12322, null);
                C1720g.m3536RP().mo5239Ry().set(64, Integer.valueOf(c35927jp.vCl));
                C32647tt c32647tt = new C32647tt();
                c32647tt.cPS.cPT = false;
                c32647tt.cPS.cPU = true;
                C4879a.xxA.mo10055m(c32647tt);
                C38033l.apY();
                C38033l.apZ();
                C4990ab.m7410d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108431);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 4 && i3 == -240) {
            C4990ab.m7417i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(108431);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(108431);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108431);
    }

    public final String agg() {
        return ((C35927jp) this.ehh.fsH.fsP).cxb;
    }
}
