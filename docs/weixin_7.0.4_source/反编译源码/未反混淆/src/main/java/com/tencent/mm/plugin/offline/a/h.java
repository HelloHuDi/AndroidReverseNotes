package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends m implements k {
    private b ehh;
    private f ehi;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract int bgI();

    public final void M(Map<String, String> map) {
        String uri;
        int ZU;
        int i = 0;
        if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
            map.put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.f.dlI());
        }
        if (this.ehh == null) {
            a aVar = new a();
            aVar.fsJ = new cgr();
            aVar.fsK = new cgs();
            uri = getUri();
            ZU = ZU();
            aVar.uri = uri;
            aVar.fsI = ZU;
            aVar.fsL = 185;
            aVar.fsM = 1000000185;
            this.ehh = aVar.acD();
        }
        cgr cgr = (cgr) this.ehh.fsG.fsP;
        cgr.wxx = bgI();
        cgr.wxy = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        for (Object obj : toArray) {
            uri = (String) map.get(obj);
            if (!bo.isNullOrNil(uri)) {
                if (i2 != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(uri);
                i2 = 1;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        ZU = 0;
        while (true) {
            i2 = i;
            if (i2 >= toArray.length) {
                break;
            }
            int i3;
            Object obj2 = toArray[i2];
            uri = (String) map.get(obj2);
            if (bo.isNullOrNil(uri)) {
                i3 = ZU;
            } else {
                if (ZU != 0) {
                    stringBuilder2.append("&");
                }
                stringBuilder2.append(obj2);
                stringBuilder2.append("=");
                stringBuilder2.append(q.encode(uri));
                i3 = 1;
            }
            i = i2 + 1;
            ZU = i3;
        }
        stringBuilder2.append(ZU != 0 ? "&" : "");
        stringBuilder2.append("WCPaySign");
        stringBuilder2.append("=");
        stringBuilder2.append(signWith3Des);
        cgr.wxz = new SKBuiltinBuffer_t().setBuffer(stringBuilder2.toString().getBytes());
    }

    public final int getType() {
        return 385;
    }

    public final int a(e eVar, f fVar) {
        this.ehi = fVar;
        return a(eVar, this.ehh, this);
    }

    public void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        ab.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        cgs cgs = (cgs) ((b) qVar).fsH.fsP;
        if (i2 != 0 || i3 != 0) {
            Map z = br.z(str, "e");
            if (z != null) {
                ab.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
        } else if (cgs.wxB == 0) {
            try {
                JSONObject jSONObject = new JSONObject(aa.b(cgs.wxA));
                int i4 = jSONObject.getInt("retcode");
                String str2 = cgs.wNf;
                if (bo.isNullOrNil(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = cgs.wNe;
                if (i4 == 0 && i5 == 0) {
                    a(i4, str2, jSONObject);
                } else {
                    ab.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i5)));
                    if (i5 == 0) {
                        i3 = -1000;
                    } else {
                        i3 = i5;
                    }
                    ab.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(str2)));
                    str = str2;
                    i2 = 1000;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = ah.getContext().getString(R.string.fdx);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = cgs.wxC;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            ab.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        ab.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int ZU() {
        return 385;
    }
}
