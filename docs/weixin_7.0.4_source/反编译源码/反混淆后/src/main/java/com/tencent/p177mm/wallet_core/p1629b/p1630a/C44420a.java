package com.tencent.p177mm.wallet_core.p1629b.p1630a;

import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.atl;
import com.tencent.p177mm.protocal.protobuf.atm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.b.a.a */
public abstract class C44420a extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    /* renamed from: a */
    public abstract void mo6950a(int i, String str, JSONObject jSONObject);

    public abstract String bgF();

    public abstract int bgG();

    /* renamed from: M */
    public final void mo70315M(Map<String, String> map) {
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
        C4990ab.m7416i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + atl.wxx + ", req = " + stringBuilder.toString());
        atl.wxz = new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes());
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        C4990ab.m7416i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str + " " + getType());
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
                    b = jSONObject.optString("retmsg");
                    if (C5046bo.isNullOrNil(b)) {
                        b = atm.errorMsg;
                    }
                    if ((i4 == 0 && i3 == 0) || bgH()) {
                        mo6950a(i4, b, jSONObject);
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
                    C4990ab.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e, "", new Object[0]);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map z = C5049br.m7595z(str, "e");
            if (z != null) {
                C4990ab.m7410d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
            str = C4996ah.getContext().getString(C25738R.string.fdx);
        }
        if (i != 0) {
            C4990ab.m7412e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bgG() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        return mo4457a(c1902e, this.ehh, this);
    }

    public boolean bgH() {
        return false;
    }
}
