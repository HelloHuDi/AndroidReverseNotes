package com.tencent.mm.wallet_core.b.a;

import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.wallet_core.c.u;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends u {
    private b ehh;
    private f ehi;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String bgF();

    public abstract int bgG();

    public final void M(Map<String, String> map) {
        if (this.ehh == null) {
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
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
        ab.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + atl.wxx + ", req = " + stringBuilder.toString());
        atl.wxz = new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes());
    }

    public final void e(int i, int i2, String str, q qVar) {
        ab.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str + " " + getType());
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
                    b = jSONObject.optString("retmsg");
                    if (bo.isNullOrNil(b)) {
                        b = atm.errorMsg;
                    }
                    if ((i4 == 0 && i3 == 0) || bgH()) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = 1000;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e, "", new Object[0]);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map z = br.z(str, "e");
            if (z != null) {
                ab.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
            str = ah.getContext().getString(R.string.fdx);
        }
        if (i != 0) {
            ab.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
    }

    public final int a(e eVar, f fVar) {
        this.ehi = fVar;
        return a(eVar, this.ehh, this);
    }

    public boolean bgH() {
        return false;
    }
}
