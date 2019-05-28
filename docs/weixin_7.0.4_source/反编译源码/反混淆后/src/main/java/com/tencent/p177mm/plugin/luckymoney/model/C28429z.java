package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C42047qq;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.wallet_core.model.C29628a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.atl;
import com.tencent.p177mm.protocal.protobuf.atm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p649c.C24147k;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.z */
public abstract class C28429z extends C36378u {
    C7472b ehh;
    private C1202f ehi;
    public C24147k nYe;

    /* renamed from: a */
    public abstract void mo7791a(int i, String str, JSONObject jSONObject);

    public abstract String bgF();

    /* renamed from: M */
    public final void mo46410M(Map<String, String> map) {
        String Yz = C1853r.m3846Yz();
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(Yz);
        if (aoO != null) {
            map.put("province", aoO.dsj());
            map.put("city", aoO.getCityCode());
        }
        if (this.ehh == null) {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new atl();
            c1196a.fsK = new atm();
            c1196a.uri = bgF();
            c1196a.fsI = getType();
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            this.ehh = c1196a.acD();
            this.ehh.ftb = true;
        }
        atl atl = (atl) this.ehh.fsG.fsP;
        atl.wxx = bgG();
        atl.wxy = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (!C5046bo.isNullOrNil(str)) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(str);
                i = true;
            }
        }
        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + atl.wxx + ", req = " + stringBuilder.toString());
        atl.wxz = new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes());
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        atm atm = (atm) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            int i3 = atm.wxB;
            String b = C1946aa.m4153b(atm.wxA);
            if (i3 != 0 || C5046bo.isNullOrNil(b)) {
                str = atm.wxC;
                i2 = 2;
                i = 1000;
            } else {
                i3 = atm.cvG;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    String str2 = atm.errorMsg;
                    if (C5046bo.isNullOrNil(str2)) {
                        str2 = jSONObject.optString("retmsg");
                    }
                    this.nYe = C24147k.m37121aS(jSONObject);
                    if (jSONObject.has("showmess") && i4 != 268502454) {
                        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        C29628a a = C12426ao.m20345a(null, jSONObject);
                        C42047qq c42047qq = new C42047qq();
                        c42047qq.cMN.cMO = a;
                        C4879a.xxA.mo10055m(c42047qq);
                        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
                    } else if (i4 == 0 && i3 == 0) {
                        mo7791a(i4, str2, jSONObject);
                        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i3;
                        }
                        str = str2;
                        i2 = i5;
                        i = 1000;
                        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    str = C4996ah.getContext().getString(C25738R.string.fdx);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map z = C5049br.m7595z(str, "e");
            if (z != null) {
                C4990ab.m7410d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) z.get(".e.Content");
            } else {
                str = C4996ah.getContext().getString(C25738R.string.fdx);
            }
        }
        if (i != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
    }

    public final boolean bLD() {
        if (this.nYe == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        return mo4457a(c1902e, this.ehh, this);
    }

    public int bgG() {
        return -1;
    }

    public final int bLE() {
        return bgG();
    }
}
