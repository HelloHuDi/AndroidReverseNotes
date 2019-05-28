package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject {
    public String cBb;
    public String lCb;
    public MallTransactionObject pbI;
    public b pbJ;
    public ArrayList<ProductSectionItem> pbK;
    public List<a> pbL;
    public List<HelpCenter> pbM = new LinkedList();
    int pbN = -1;
    public String pbO;
    public String pbP;
    public int pbQ;

    public static class HelpCenter implements Parcelable {
        public static final Creator<HelpCenter> CREATOR = new Creator<HelpCenter>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HelpCenter[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(43739);
                HelpCenter helpCenter = new HelpCenter(parcel);
                AppMethodBeat.o(43739);
                return helpCenter;
            }
        };
        public boolean cui;
        public String name;
        public String url;

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            AppMethodBeat.i(43740);
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.cui = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(43740);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(43741);
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.cui ? 1 : 0));
            AppMethodBeat.o(43741);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(43742);
            AppMethodBeat.o(43742);
        }
    }

    public static class a {
        public int jumpType;
        public String jumpUrl;
        public boolean kch;
        public String name;
        public int type = 0;
        public String value;
    }

    public static class b {
        public String mZj;
        public int oyB;
        public String pbR;
        public String pbS;
        public String thumbUrl;
    }

    public MallOrderDetailObject() {
        AppMethodBeat.i(43743);
        AppMethodBeat.o(43743);
    }

    static ArrayList<ProductSectionItem> ac(JSONObject jSONObject) {
        AppMethodBeat.i(43744);
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            AppMethodBeat.o(43744);
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(43744);
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.pdy = ad(jSONObject3);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.pdz = jSONObject3.optString(com.google.firebase.analytics.FirebaseAnalytics.b.PRICE);
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.pdA = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        AppMethodBeat.o(43744);
        return arrayList;
    }

    private static List<Skus> ad(JSONObject jSONObject) {
        AppMethodBeat.i(43745);
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(43745);
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
        AppMethodBeat.o(43745);
        return arrayList;
    }
}
