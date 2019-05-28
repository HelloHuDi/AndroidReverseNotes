package com.tencent.p177mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.order.model.MallOrderDetailObject */
public final class MallOrderDetailObject {
    public String cBb;
    public String lCb;
    public MallTransactionObject pbI;
    public C34661b pbJ;
    public ArrayList<ProductSectionItem> pbK;
    public List<C34660a> pbL;
    public List<HelpCenter> pbM = new LinkedList();
    int pbN = -1;
    public String pbO;
    public String pbP;
    public int pbQ;

    /* renamed from: com.tencent.mm.plugin.order.model.MallOrderDetailObject$HelpCenter */
    public static class HelpCenter implements Parcelable {
        public static final Creator<HelpCenter> CREATOR = new C346591();
        public boolean cui;
        public String name;
        public String url;

        /* renamed from: com.tencent.mm.plugin.order.model.MallOrderDetailObject$HelpCenter$1 */
        static class C346591 implements Creator<HelpCenter> {
            C346591() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HelpCenter[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(43739);
                HelpCenter helpCenter = new HelpCenter(parcel);
                AppMethodBeat.m2505o(43739);
                return helpCenter;
            }
        }

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            AppMethodBeat.m2504i(43740);
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.cui = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(43740);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(43741);
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.cui ? 1 : 0));
            AppMethodBeat.m2505o(43741);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.m2504i(43742);
            AppMethodBeat.m2505o(43742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.model.MallOrderDetailObject$a */
    public static class C34660a {
        public int jumpType;
        public String jumpUrl;
        public boolean kch;
        public String name;
        public int type = 0;
        public String value;
    }

    /* renamed from: com.tencent.mm.plugin.order.model.MallOrderDetailObject$b */
    public static class C34661b {
        public String mZj;
        public int oyB;
        public String pbR;
        public String pbS;
        public String thumbUrl;
    }

    public MallOrderDetailObject() {
        AppMethodBeat.m2504i(43743);
        AppMethodBeat.m2505o(43743);
    }

    /* renamed from: ac */
    static ArrayList<ProductSectionItem> m56900ac(JSONObject jSONObject) {
        AppMethodBeat.m2504i(43744);
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            AppMethodBeat.m2505o(43744);
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(43744);
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.pdy = MallOrderDetailObject.m56901ad(jSONObject3);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.pdz = jSONObject3.optString(C8741b.PRICE);
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.pdA = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        AppMethodBeat.m2505o(43744);
        return arrayList;
    }

    /* renamed from: ad */
    private static List<Skus> m56901ad(JSONObject jSONObject) {
        AppMethodBeat.m2504i(43745);
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(43745);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Skus skus = new Skus();
            skus.key = jSONObject2.optString("key");
            skus.value = jSONObject2.optString("value");
            arrayList.add(skus);
        }
        AppMethodBeat.m2505o(43745);
        return arrayList;
    }
}
