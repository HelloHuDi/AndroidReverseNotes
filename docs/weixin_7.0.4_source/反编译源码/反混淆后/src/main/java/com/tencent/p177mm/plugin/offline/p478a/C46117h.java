package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cgr;
import com.tencent.p177mm.protocal.protobuf.cgs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.h */
public abstract class C46117h extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    /* renamed from: a */
    public abstract void mo36860a(int i, String str, JSONObject jSONObject);

    public abstract int bgI();

    /* renamed from: M */
    public final void mo74062M(Map<String, String> map) {
        String uri;
        int ZU;
        int i = 0;
        if (!C46512f.dlH()) {
            map.put("jsapi_reqkey", C46512f.dlI());
        }
        if (this.ehh == null) {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cgr();
            c1196a.fsK = new cgs();
            uri = getUri();
            ZU = mo36859ZU();
            c1196a.uri = uri;
            c1196a.fsI = ZU;
            c1196a.fsL = 185;
            c1196a.fsM = 1000000185;
            this.ehh = c1196a.acD();
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
            if (!C5046bo.isNullOrNil(uri)) {
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
            if (C5046bo.isNullOrNil(uri)) {
                i3 = ZU;
            } else {
                if (ZU != 0) {
                    stringBuilder2.append("&");
                }
                stringBuilder2.append(obj2);
                stringBuilder2.append("=");
                stringBuilder2.append(C18178q.encode(uri));
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

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        return mo4457a(c1902e, this.ehh, this);
    }

    /* renamed from: a */
    public void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        C4990ab.m7416i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        cgs cgs = (cgs) ((C7472b) c1929q).fsH.fsP;
        if (i2 != 0 || i3 != 0) {
            Map z = C5049br.m7595z(str, "e");
            if (z != null) {
                C4990ab.m7410d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
        } else if (cgs.wxB == 0) {
            try {
                JSONObject jSONObject = new JSONObject(C1946aa.m4153b(cgs.wxA));
                int i4 = jSONObject.getInt("retcode");
                String str2 = cgs.wNf;
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = cgs.wNe;
                if (i4 == 0 && i5 == 0) {
                    mo36860a(i4, str2, jSONObject);
                } else {
                    C4990ab.m7416i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i5)));
                    if (i5 == 0) {
                        i3 = -1000;
                    } else {
                        i3 = i5;
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(str2)));
                    str = str2;
                    i2 = 1000;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = C4996ah.getContext().getString(C25738R.string.fdx);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = cgs.wxC;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        C4990ab.m7410d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + bgI() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    /* renamed from: ZU */
    public int mo36859ZU() {
        return 385;
    }
}
