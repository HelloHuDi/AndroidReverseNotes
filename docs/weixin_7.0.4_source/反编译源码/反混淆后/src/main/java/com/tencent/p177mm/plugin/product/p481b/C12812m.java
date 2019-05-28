package com.tencent.p177mm.plugin.product.p481b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.product.p737c.C12815k;
import com.tencent.p177mm.plugin.product.p737c.C12816l;
import com.tencent.p177mm.plugin.product.p737c.C28671a;
import com.tencent.p177mm.plugin.product.p737c.C28672c;
import com.tencent.p177mm.plugin.product.p737c.C34682m;
import com.tencent.p177mm.plugin.product.p737c.C34683n;
import com.tencent.p177mm.plugin.product.p737c.C39488e;
import com.tencent.p177mm.plugin.product.p737c.C46132f;
import com.tencent.p177mm.plugin.product.p737c.C46133h;
import com.tencent.p177mm.plugin.product.p737c.C7017j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.product.b.m */
public final class C12812m {
    public String pho;
    public int php;
    public int phq = BaseClientBuilder.API_PRIORITY_OTHER;
    public int phr = BaseClientBuilder.API_PRIORITY_OTHER;
    public C28672c phs;
    public C34683n pht;
    public LinkedList<C12816l> phu = new LinkedList();
    public C46132f phv;
    public String phw;
    public String phx;
    public String phy;
    public int status = 6;

    public C12812m() {
        AppMethodBeat.m2504i(44003);
        AppMethodBeat.m2505o(44003);
    }

    /* renamed from: a */
    public static C12812m m20812a(C12812m c12812m, String str) {
        C12812m c12812m2;
        AppMethodBeat.m2504i(44004);
        if (c12812m == null) {
            c12812m2 = new C12812m();
        } else {
            c12812m2 = c12812m;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            c12812m2.pho = jSONObject.getString("product_id");
            c12812m2.php = jSONObject.getInt("product_type");
            c12812m2.phq = jSONObject.optInt(C8741b.QUANTITY, BaseClientBuilder.API_PRIORITY_OTHER);
            c12812m2.phr = jSONObject.optInt("left_buy_quantity", BaseClientBuilder.API_PRIORITY_OTHER);
            c12812m2.status = jSONObject.optInt("status", 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                c12812m2.phv = new C46132f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    C46132f c46132f = c12812m2.phv;
                    C7017j c7017j = new C7017j();
                    c7017j.bJt = optJSONObject.getInt("flag");
                    c46132f.phQ = c7017j;
                } else {
                    c12812m2.phv.phR = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                c12812m2.phs = new C28672c();
                c12812m2.phs.name = optJSONObject2.getString("name");
                c12812m2.phs.phD = optJSONObject2.getInt("ori_price");
                c12812m2.phs.phE = optJSONObject2.getInt("up_price");
                c12812m2.phs.phF = optJSONObject2.getInt("low_price");
                c12812m2.phs.phG = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!C5046bo.isNullOrNil(string)) {
                        c12812m2.phs.phG.add(string);
                    }
                }
                c12812m2.phs.fjz = optJSONObject2.getString("digest");
                c12812m2.phs.pcl = optJSONObject2.getString("fee_type");
                c12812m2.phs.detail = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    c12812m2.phs.phO = new C12815k();
                    c12812m2.phs.phO.kKZ = optJSONObject.optString("icon_url");
                    c12812m2.phs.phO.url = optJSONObject.optString("url");
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    c12812m2.phs.phM = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        C34682m c34682m = new C34682m();
                        c34682m.phX = jSONObject2.getString("id");
                        c34682m.phY = jSONObject2.getString("name");
                        c34682m.phZ = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            C46133h c46133h = new C46133h();
                            c46133h.f17901id = jSONObject3.getString("id");
                            c46133h.name = jSONObject3.getString("name");
                            c46133h.phS = true;
                            c34682m.phZ.add(c46133h);
                        }
                        c12812m2.phs.phM.add(c34682m);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    c12812m2.phs.phN = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        C28671a c28671a = new C28671a();
                        c28671a.Name = jSONObject2.getString("name");
                        c28671a.jCt = 0;
                        if (!C5046bo.isNullOrNil(c28671a.Name)) {
                            c12812m2.phs.phN.add(c28671a);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            C28671a c28671a2 = new C28671a();
                            c28671a2.Name = jSONObject4.getString("name");
                            c28671a2.phA = jSONObject4.getString("tips");
                            c28671a2.jCt = jSONObject4.getInt("type");
                            c28671a2.ncM = jSONObject4.getString(C8741b.CONTENT);
                            c28671a2.IconUrl = jSONObject4.getString("icon_url");
                            c12812m2.phs.phN.add(c28671a2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                c12812m2.phu = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    C12816l c12816l = new C12816l();
                    c12816l.phU = optJSONObject.getString("id_info");
                    c12816l.phV = optJSONObject.getInt(C8741b.PRICE);
                    c12816l.phq = optJSONObject.getInt(C8741b.QUANTITY);
                    c12816l.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    c12816l.phW = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        C39488e c39488e = new C39488e();
                        c39488e.f16177id = jSONObject5.getInt("id");
                        c39488e.name = jSONObject5.getString("name");
                        c39488e.value = jSONObject5.getInt(C8741b.PRICE);
                        c12816l.phW.add(c39488e);
                    }
                    c12812m2.phu.add(c12816l);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                c12812m2.pht = new C34683n();
                c12812m2.pht.csB = optJSONObject.getString("appid");
                c12812m2.pht.name = optJSONObject.getString("name");
                c12812m2.pht.username = optJSONObject.getString("username");
                c12812m2.pht.pia = optJSONObject.optString("logo");
                c12812m2.pht.bJt = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                c12812m2.phx = optJSONObject.optString("self_buy_button_word");
                c12812m2.phy = optJSONObject.optString("product_mixed_h5_html");
            }
            AppMethodBeat.m2505o(44004);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(44004);
        }
        return c12812m2;
    }

    /* renamed from: b */
    public static C12812m m20813b(C12812m c12812m, String str) {
        int i = 0;
        AppMethodBeat.m2504i(44005);
        if (c12812m == null) {
            c12812m = new C12812m();
        }
        Map z = C5049br.m7595z(str, "mallProductInfo");
        if (z == null) {
            AppMethodBeat.m2505o(44005);
            return null;
        }
        c12812m.pho = C5046bo.nullAsNil((String) z.get(".mallProductInfo.id"));
        c12812m.php = C5046bo.getInt((String) z.get(".mallProductInfo.type"), 0);
        c12812m.phs = new C28672c();
        c12812m.phs.name = C5046bo.nullAsNil((String) z.get(".mallProductInfo.name"));
        c12812m.phs.fjz = C5046bo.nullAsNil((String) z.get(".mallProductInfo.digest"));
        c12812m.phs.phE = C5046bo.getInt((String) z.get(".mallProductInfo.highPrice"), 0);
        c12812m.phs.phF = C5046bo.getInt((String) z.get(".mallProductInfo.lowPrice"), 0);
        c12812m.phs.phD = C5046bo.getInt((String) z.get(".mallProductInfo.originPrice"), 0);
        c12812m.phw = C5046bo.nullAsNil((String) z.get(".mallProductInfo.sourceUrl"));
        int i2 = C5046bo.getInt((String) z.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            c12812m.phs.phG = new LinkedList();
            while (i < i2) {
                String nullAsNil;
                if (i == 0) {
                    nullAsNil = C5046bo.nullAsNil((String) z.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    nullAsNil = C5046bo.nullAsNil((String) z.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i))));
                }
                if (!C5046bo.isNullOrNil(nullAsNil)) {
                    c12812m.phs.phG.add(nullAsNil);
                }
                i++;
            }
        }
        c12812m.phs.phO = new C12815k();
        c12812m.phs.phO.url = C5046bo.nullAsNil((String) z.get(".mallProductInfo.shareInfo.shareUrl"));
        c12812m.phs.phO.kKZ = C5046bo.nullAsNil((String) z.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        c12812m.pht = new C34683n();
        c12812m.pht.csB = C5046bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.appID"));
        c12812m.pht.name = C5046bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.appName"));
        c12812m.pht.username = C5046bo.nullAsNil((String) z.get(".mallProductInfo.sellerInfo.usrName"));
        AppMethodBeat.m2505o(44005);
        return c12812m;
    }

    public final String bZY() {
        AppMethodBeat.m2504i(44006);
        String str;
        if (this.phs != null && this.phs.phO != null && !C5046bo.isNullOrNil(this.phs.phO.kKZ)) {
            str = this.phs.phO.kKZ;
            AppMethodBeat.m2505o(44006);
            return str;
        } else if (this.phs == null || this.phs.phG == null || this.phs.phG.size() <= 0) {
            AppMethodBeat.m2505o(44006);
            return null;
        } else {
            str = (String) this.phs.phG.get(0);
            AppMethodBeat.m2505o(44006);
            return str;
        }
    }
}
