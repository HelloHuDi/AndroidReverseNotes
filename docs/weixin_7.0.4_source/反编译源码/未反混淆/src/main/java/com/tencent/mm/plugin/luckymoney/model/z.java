package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.u;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class z extends u {
    b ehh;
    private f ehi;
    public k nYe;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String bgF();

    public final void M(Map<String, String> map) {
        String Yz = r.Yz();
        g.RQ();
        ad aoO = ((j) g.K(j.class)).XM().aoO(Yz);
        if (aoO != null) {
            map.put("province", aoO.dsj());
            map.put("city", aoO.getCityCode());
        }
        if (this.ehh == null) {
            a aVar = new a();
            aVar.fsJ = new atl();
            aVar.fsK = new atm();
            aVar.uri = bgF();
            aVar.fsI = getType();
            aVar.fsL = 0;
            aVar.fsM = 0;
            this.ehh = aVar.acD();
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
            if (!bo.isNullOrNil(str)) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(str);
                i = true;
            }
        }
        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + atl.wxx + ", req = " + stringBuilder.toString());
        atl.wxz = new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes());
    }

    public final void e(int i, int i2, String str, q qVar) {
        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        atm atm = (atm) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            int i3 = atm.wxB;
            String b = aa.b(atm.wxA);
            if (i3 != 0 || bo.isNullOrNil(b)) {
                str = atm.wxC;
                i2 = 2;
                i = 1000;
            } else {
                i3 = atm.cvG;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    String str2 = atm.errorMsg;
                    if (bo.isNullOrNil(str2)) {
                        str2 = jSONObject.optString("retmsg");
                    }
                    this.nYe = k.aS(jSONObject);
                    if (jSONObject.has("showmess") && i4 != 268502454) {
                        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        com.tencent.mm.plugin.wallet_core.model.a a = ao.a(null, jSONObject);
                        qq qqVar = new qq();
                        qqVar.cMN.cMO = a;
                        com.tencent.mm.sdk.b.a.xxA.m(qqVar);
                        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
                    } else if (i4 == 0 && i3 == 0) {
                        a(i4, str2, jSONObject);
                        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
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
                        ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", tenpayErrType : " + i3 + ", resp = " + b);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    str = ah.getContext().getString(R.string.fdx);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map z = br.z(str, "e");
            if (z != null) {
                ab.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) z.get(".e.Content");
            } else {
                str = ah.getContext().getString(R.string.fdx);
            }
        }
        if (i != 0) {
            ab.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
    }

    public final boolean bLD() {
        if (this.nYe == null) {
            return false;
        }
        return true;
    }

    public final int a(e eVar, f fVar) {
        this.ehi = fVar;
        return a(eVar, this.ehh, this);
    }

    public int bgG() {
        return -1;
    }

    public final int bLE() {
        return bgG();
    }
}
