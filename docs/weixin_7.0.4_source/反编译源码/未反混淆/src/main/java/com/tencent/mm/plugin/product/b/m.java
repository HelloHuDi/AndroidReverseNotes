package com.tencent.mm.plugin.product.b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {
    public String pho;
    public int php;
    public int phq = BaseClientBuilder.API_PRIORITY_OTHER;
    public int phr = BaseClientBuilder.API_PRIORITY_OTHER;
    public c phs;
    public n pht;
    public LinkedList<l> phu = new LinkedList();
    public f phv;
    public String phw;
    public String phx;
    public String phy;
    public int status = 6;

    public m() {
        AppMethodBeat.i(44003);
        AppMethodBeat.o(44003);
    }

    public static m a(m mVar, String str) {
        m mVar2;
        AppMethodBeat.i(44004);
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.pho = jSONObject.getString("product_id");
            mVar2.php = jSONObject.getInt("product_type");
            mVar2.phq = jSONObject.optInt(b.QUANTITY, BaseClientBuilder.API_PRIORITY_OTHER);
            mVar2.phr = jSONObject.optInt("left_buy_quantity", BaseClientBuilder.API_PRIORITY_OTHER);
            mVar2.status = jSONObject.optInt("status", 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.phv = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.phv;
                    j jVar = new j();
                    jVar.bJt = optJSONObject.getInt("flag");
                    fVar.phQ = jVar;
                } else {
                    mVar2.phv.phR = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.phs = new c();
                mVar2.phs.name = optJSONObject2.getString("name");
                mVar2.phs.phD = optJSONObject2.getInt("ori_price");
                mVar2.phs.phE = optJSONObject2.getInt("up_price");
                mVar2.phs.phF = optJSONObject2.getInt("low_price");
                mVar2.phs.phG = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!bo.isNullOrNil(string)) {
                        mVar2.phs.phG.add(string);
                    }
                }
                mVar2.phs.fjz = optJSONObject2.getString("digest");
                mVar2.phs.pcl = optJSONObject2.getString("fee_type");
                mVar2.phs.detail = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.phs.phO = new k();
                    mVar2.phs.phO.kKZ = optJSONObject.optString("icon_url");
                    mVar2.phs.phO.url = optJSONObject.optString("url");
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.phs.phM = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.phX = jSONObject2.getString("id");
                        mVar3.phY = jSONObject2.getString("name");
                        mVar3.phZ = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString("id");
                            hVar.name = jSONObject3.getString("name");
                            hVar.phS = true;
                            mVar3.phZ.add(hVar);
                        }
                        mVar2.phs.phM.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.phs.phN = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.Name = jSONObject2.getString("name");
                        aVar.jCt = 0;
                        if (!bo.isNullOrNil(aVar.Name)) {
                            mVar2.phs.phN.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.Name = jSONObject4.getString("name");
                            aVar2.phA = jSONObject4.getString("tips");
                            aVar2.jCt = jSONObject4.getInt("type");
                            aVar2.ncM = jSONObject4.getString(b.CONTENT);
                            aVar2.IconUrl = jSONObject4.getString("icon_url");
                            mVar2.phs.phN.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.phu = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.phU = optJSONObject.getString("id_info");
                    lVar.phV = optJSONObject.getInt(b.PRICE);
                    lVar.phq = optJSONObject.getInt(b.QUANTITY);
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.phW = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt("id");
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt(b.PRICE);
                        lVar.phW.add(eVar);
                    }
                    mVar2.phu.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.pht = new n();
                mVar2.pht.csB = optJSONObject.getString("appid");
                mVar2.pht.name = optJSONObject.getString("name");
                mVar2.pht.username = optJSONObject.getString("username");
                mVar2.pht.pia = optJSONObject.optString("logo");
                mVar2.pht.bJt = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.phx = optJSONObject.optString("self_buy_button_word");
                mVar2.phy = optJSONObject.optString("product_mixed_h5_html");
            }
            AppMethodBeat.o(44004);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
            AppMethodBeat.o(44004);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        AppMethodBeat.i(44005);
        if (mVar == null) {
            mVar = new m();
        }
        Map z = br.z(str, "mallProductInfo");
        if (z == null) {
            AppMethodBeat.o(44005);
            return null;
        }
        mVar.pho = bo.nullAsNil((String) z.get(".mallProductInfo.id"));
        mVar.php = bo.getInt((String) z.get(".mallProductInfo.type"), 0);
        mVar.phs = new c();
        mVar.phs.name = bo.nullAsNil((String) z.get(".mallProductInfo.name"));
        mVar.phs.fjz = bo.nullAsNil((String) z.get(".mallProductInfo.digest"));
        mVar.phs.phE = bo.getInt((String) z.get(".mallProductInfo.highPrice"), 0);
        mVar.phs.phF = bo.getInt((String) z.get(".mallProductInfo.lowPrice"), 0);
        mVar.phs.phD = bo.getInt((String) z.get(".mallProductInfo.originPrice"), 0);
        mVar.phw = bo.nullAsNil((String) z.get(".mallProductInfo.sourceUrl"));
        int i2 = bo.getInt((String) z.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.phs.phG = new LinkedList();
            while (i < i2) {
                String nullAsNil;
                if (i == 0) {
                    nullAsNil = bo.nullAsNil((String) z.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    nullAsNil = bo.nullAsNil((String) z.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i))));
                }
                if (!bo.isNullOrNil(nullAsNil)) {
                    mVar.phs.phG.add(nullAsNil);
                }
                i++;
            }
        }
        mVar.phs.phO = new k();
        mVar.phs.phO.url = bo.nullAsNil((String) z.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.phs.phO.kKZ = bo.nullAsNil((String) z.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.pht = new n();
        mVar.pht.csB = bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.appID"));
        mVar.pht.name = bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.appName"));
        mVar.pht.username = bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.usrName"));
        AppMethodBeat.o(44005);
        return mVar;
    }

    public final String bZY() {
        AppMethodBeat.i(44006);
        String str;
        if (this.phs != null && this.phs.phO != null && !bo.isNullOrNil(this.phs.phO.kKZ)) {
            str = this.phs.phO.kKZ;
            AppMethodBeat.o(44006);
            return str;
        } else if (this.phs == null || this.phs.phG == null || this.phs.phG.size() <= 0) {
            AppMethodBeat.o(44006);
            return null;
        } else {
            str = (String) this.phs.phG.get(0);
            AppMethodBeat.o(44006);
            return str;
        }
    }
}
