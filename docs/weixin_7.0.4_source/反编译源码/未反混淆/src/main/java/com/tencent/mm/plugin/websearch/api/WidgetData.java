package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData implements Parcelable {
    public static final Creator<WidgetData> CREATOR = new Creator<WidgetData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(124258);
            WidgetData widgetData = new WidgetData(parcel);
            AppMethodBeat.o(124258);
            return widgetData;
        }
    };
    public String query;
    public MoreFooter ubr;
    public Info ubs;
    public Style ubt;
    public int ubu;
    public String ubv;

    public static class Style implements Parcelable {
        public static final Creator<Style> CREATOR = new Creator<Style>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Style[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(124272);
                Style style = new Style(parcel);
                AppMethodBeat.o(124272);
                return style;
            }
        };
        public boolean cNN = true;
        public int height;
        public String hfo;
        public int offsetX;
        public int offsetY;
        public double ubH = 65.0d;
        public int ubI;
        public int width;

        public String toString() {
            AppMethodBeat.i(124273);
            String obj = super.toString();
            AppMethodBeat.o(124273);
            return obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(124274);
            parcel.writeDouble(this.ubH);
            parcel.writeInt(this.ubI);
            parcel.writeInt(this.offsetX);
            parcel.writeInt(this.offsetY);
            parcel.writeInt(this.height);
            parcel.writeString(this.hfo);
            parcel.writeInt(this.width);
            parcel.writeByte(this.cNN ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(124274);
        }

        protected Style(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(124275);
            this.ubH = parcel.readDouble();
            this.ubI = parcel.readInt();
            this.offsetX = parcel.readInt();
            this.offsetY = parcel.readInt();
            this.height = parcel.readInt();
            this.hfo = parcel.readString();
            this.width = parcel.readInt();
            if (parcel.readByte() == (byte) 0) {
                z = false;
            }
            this.cNN = z;
            AppMethodBeat.o(124275);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(124276);
            if (this == obj) {
                AppMethodBeat.o(124276);
                return true;
            } else if (obj instanceof Style) {
                Style style = (Style) obj;
                if (Double.compare(style.ubH, this.ubH) == 0 && this.ubI == style.ubI && this.offsetX == style.offsetX && this.offsetY == style.offsetY && this.height == style.height && this.width == style.width && this.cNN == style.cNN && Objects.equals(this.hfo, style.hfo)) {
                    AppMethodBeat.o(124276);
                    return true;
                }
                AppMethodBeat.o(124276);
                return false;
            } else {
                AppMethodBeat.o(124276);
                return false;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(124277);
            int hash = Objects.hash(new Object[]{Double.valueOf(this.ubH), Integer.valueOf(this.ubI), Integer.valueOf(this.offsetX), Integer.valueOf(this.offsetY), Integer.valueOf(this.height), this.hfo, Integer.valueOf(this.width), Boolean.valueOf(this.cNN)});
            AppMethodBeat.o(124277);
            return hash;
        }

        static {
            AppMethodBeat.i(124278);
            AppMethodBeat.o(124278);
        }
    }

    public static class Info implements Parcelable {
        public static final Creator<Info> CREATOR = new Creator<Info>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Info[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(124259);
                Info info = new Info(parcel);
                AppMethodBeat.o(124259);
                return info;
            }
        };
        public String bCu;
        public String csB;
        public String csu;
        public String downloadUrl;
        public int fmr;
        public String fpS;
        public String hlm;
        public String iconUrl;
        public String kcx;
        public String label;
        public String ubA;
        public String ubB;
        public long ubC;
        public String ubD;
        public boolean ubE;
        public String ubw;
        public String ubx;
        public String uby;
        public int ubz;
        public String userName;
        public int version;

        public String toString() {
            AppMethodBeat.i(124260);
            String format = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[]{this.csB, this.fpS, Long.valueOf(this.ubC), this.csu});
            AppMethodBeat.o(124260);
            return format;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(124261);
            if (this == obj) {
                AppMethodBeat.o(124261);
                return true;
            } else if (obj instanceof Info) {
                Info info = (Info) obj;
                if (this.fmr == info.fmr && this.ubz == info.ubz && this.version == info.version && this.ubC == info.ubC && this.ubE == info.ubE && Objects.equals(this.ubw, info.ubw) && Objects.equals(this.bCu, info.bCu) && Objects.equals(this.ubx, info.ubx) && Objects.equals(this.uby, info.uby) && Objects.equals(this.csu, info.csu) && Objects.equals(this.csB, info.csB) && Objects.equals(this.userName, info.userName) && Objects.equals(this.ubA, info.ubA) && Objects.equals(this.iconUrl, info.iconUrl) && Objects.equals(this.downloadUrl, info.downloadUrl) && Objects.equals(this.ubB, info.ubB) && Objects.equals(this.hlm, info.hlm) && Objects.equals(this.label, info.label) && Objects.equals(this.fpS, info.fpS) && Objects.equals(this.ubD, info.ubD) && Objects.equals(this.kcx, info.kcx)) {
                    AppMethodBeat.o(124261);
                    return true;
                }
                AppMethodBeat.o(124261);
                return false;
            } else {
                AppMethodBeat.o(124261);
                return false;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(124262);
            int hash = Objects.hash(new Object[]{Integer.valueOf(this.fmr), this.ubw, this.bCu, this.ubx, this.uby, this.csu, this.csB, this.userName, Integer.valueOf(this.ubz), Integer.valueOf(this.version), this.ubA, this.iconUrl, this.downloadUrl, this.ubB, this.hlm, this.label, Long.valueOf(this.ubC), this.fpS, this.ubD, this.kcx, Boolean.valueOf(this.ubE)});
            AppMethodBeat.o(124262);
            return hash;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(124263);
            parcel.writeInt(this.fmr);
            parcel.writeString(this.ubw);
            parcel.writeString(this.bCu);
            parcel.writeString(this.ubx);
            parcel.writeString(this.uby);
            parcel.writeString(this.csu);
            parcel.writeString(this.csB);
            parcel.writeString(this.userName);
            parcel.writeInt(this.ubz);
            parcel.writeInt(this.version);
            parcel.writeString(this.ubA);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.downloadUrl);
            parcel.writeString(this.ubB);
            parcel.writeString(this.hlm);
            parcel.writeString(this.label);
            parcel.writeLong(this.ubC);
            parcel.writeString(this.fpS);
            parcel.writeString(this.ubD);
            parcel.writeString(this.kcx);
            parcel.writeByte(this.ubE ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(124263);
        }

        protected Info(Parcel parcel) {
            AppMethodBeat.i(124264);
            this.fmr = parcel.readInt();
            this.ubw = parcel.readString();
            this.bCu = parcel.readString();
            this.ubx = parcel.readString();
            this.uby = parcel.readString();
            this.csu = parcel.readString();
            this.csB = parcel.readString();
            this.userName = parcel.readString();
            this.ubz = parcel.readInt();
            this.version = parcel.readInt();
            this.ubA = parcel.readString();
            this.iconUrl = parcel.readString();
            this.downloadUrl = parcel.readString();
            this.ubB = parcel.readString();
            this.hlm = parcel.readString();
            this.label = parcel.readString();
            this.ubC = parcel.readLong();
            this.fpS = parcel.readString();
            this.ubD = parcel.readString();
            this.kcx = parcel.readString();
            this.ubE = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(124264);
        }

        static {
            AppMethodBeat.i(124265);
            AppMethodBeat.o(124265);
        }
    }

    public static class MoreFooter implements Parcelable {
        public static final Creator<MoreFooter> CREATOR = new Creator<MoreFooter>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MoreFooter[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(124266);
                MoreFooter moreFooter = new MoreFooter(parcel);
                AppMethodBeat.o(124266);
                return moreFooter;
            }
        };
        public String title;
        public String ubF;
        public String ubG;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(124267);
            parcel.writeString(this.title);
            parcel.writeString(this.ubF);
            parcel.writeString(this.ubG);
            AppMethodBeat.o(124267);
        }

        protected MoreFooter(Parcel parcel) {
            AppMethodBeat.i(124268);
            this.title = parcel.readString();
            this.ubF = parcel.readString();
            this.ubG = parcel.readString();
            AppMethodBeat.o(124268);
        }

        static {
            AppMethodBeat.i(124271);
            AppMethodBeat.o(124271);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(124269);
            if (this == obj) {
                AppMethodBeat.o(124269);
                return true;
            } else if (obj instanceof MoreFooter) {
                MoreFooter moreFooter = (MoreFooter) obj;
                if (Objects.equals(this.title, moreFooter.title) && Objects.equals(this.ubF, moreFooter.ubF) && Objects.equals(this.ubG, moreFooter.ubG)) {
                    AppMethodBeat.o(124269);
                    return true;
                }
                AppMethodBeat.o(124269);
                return false;
            } else {
                AppMethodBeat.o(124269);
                return false;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(124270);
            int hash = Objects.hash(new Object[]{this.title, this.ubF, this.ubG});
            AppMethodBeat.o(124270);
            return hash;
        }
    }

    public String toString() {
        AppMethodBeat.i(124279);
        String str = "info: [%s], style:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.ubs == null ? "" : this.ubs.toString();
        objArr[1] = this.ubt == null ? "" : this.ubt.toString();
        String format = String.format(str, objArr);
        AppMethodBeat.o(124279);
        return format;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(124280);
        if (this == obj) {
            AppMethodBeat.o(124280);
            return true;
        } else if (obj instanceof WidgetData) {
            WidgetData widgetData = (WidgetData) obj;
            if (this.ubu == widgetData.ubu && Objects.equals(this.ubr, widgetData.ubr) && Objects.equals(this.ubs, widgetData.ubs) && Objects.equals(this.ubt, widgetData.ubt) && Objects.equals(this.query, widgetData.query) && Objects.equals(this.ubv, widgetData.ubv)) {
                AppMethodBeat.o(124280);
                return true;
            }
            AppMethodBeat.o(124280);
            return false;
        } else {
            AppMethodBeat.o(124280);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(124281);
        int hash = Objects.hash(new Object[]{this.ubr, this.ubs, this.ubt, Integer.valueOf(this.ubu), this.query, this.ubv});
        AppMethodBeat.o(124281);
        return hash;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static WidgetData l(JSONObject jSONObject, String str) {
        int i = 1;
        AppMethodBeat.i(124282);
        WidgetData cVI = cVI();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("boxInfo").getJSONObject("providerInfo");
            if (jSONObject2 == null) {
                AppMethodBeat.o(124282);
                return null;
            }
            cVI.ubs.csB = jSONObject.optString("appID");
            cVI.ubs.version = jSONObject.optInt("appVersion");
            cVI.ubs.ubA = jSONObject.optString("docID");
            cVI.ubs.iconUrl = jSONObject.optString("iconUrl");
            cVI.ubs.bCu = jSONObject.optString("nickName");
            cVI.ubs.userName = jSONObject.optString("username");
            cVI.ubs.ubw = "widgetData=".concat(String.valueOf(URLEncoder.encode(jSONObject2.optString("widgetData"))));
            cVI.ubs.csu = jSONObject2.optString("jumpUrl") + "&" + cVI.ubs.ubw;
            cVI.ubs.ubx = jSONObject2.optString("wxaData");
            cVI.ubs.fmr = jSONObject2.optInt("type");
            try {
                String optString = jSONObject2.optString("relay_info");
                if (optString != null) {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    cVI.ubs.ubB = jSONObject3.optString("widget_stat_buffer");
                    cVI.ubs.downloadUrl = jSONObject3.optString("downloadurl");
                    cVI.ubs.uby = jSONObject3.optString("launchwxawidget");
                    cVI.ubs.ubz = jSONObject3.optInt("widget_version_type");
                    cVI.ubs.fpS = jSONObject3.optString("appid");
                    JSONArray optJSONArray = jSONObject3.optJSONArray("widget_labels");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        cVI.ubs.label = null;
                    } else {
                        cVI.ubs.label = optJSONArray.optString(0);
                    }
                    cVI.ubs.ubE = jSONObject3.optInt("need_localsearch_footer") == 1;
                    cVI.ubs.ubD = jSONObject3.optString("localsearch_header");
                    cVI.ubs.kcx = jSONObject3.optString("localsearch_footer");
                    cVI.ubs.ubC = jSONObject3.optLong("openapp_permission");
                    if (jSONObject3.has("footer")) {
                        JSONObject optJSONObject = jSONObject3.optJSONObject("footer");
                        if (optJSONObject.has("type")) {
                            i = optJSONObject.optInt("type");
                        }
                        cVI.ubu = i;
                        switch (cVI.ubu) {
                            case 2:
                                cVI.ubr = new MoreFooter();
                                cVI.ubr.title = optJSONObject.optString("title");
                                cVI.ubr.ubF = optJSONObject.optString("username");
                                cVI.ubr.ubG = optJSONObject.optString("jumpurl");
                                break;
                            default:
                                d.w("WidgetData", "unknow footer type %d", Integer.valueOf(cVI.ubu));
                                break;
                        }
                    }
                    cVI.ubu = 1;
                }
            } catch (JSONException e) {
                d.printErrStackTrace("WidgetData", e, "", new Object[0]);
            }
            cVI.ubs.hlm = str;
            cVI.ubt.ubI = jSONObject.optInt("maxHeight");
            cVI.ubt.height = a.ao(ah.getContext(), jSONObject2.optInt("height"));
            cVI.ubt.width = a.ao(ah.getContext(), jSONObject2.optInt("width"));
            AppMethodBeat.o(124282);
            return cVI;
        } catch (JSONException e2) {
            d.printErrStackTrace("WidgetData", e2, "", new Object[0]);
            AppMethodBeat.o(124282);
            return null;
        }
    }

    private static WidgetData cVI() {
        AppMethodBeat.i(124283);
        WidgetData widgetData = new WidgetData();
        widgetData.ubs = new Info();
        widgetData.ubt = new Style();
        AppMethodBeat.o(124283);
        return widgetData;
    }

    public static WidgetData adQ(String str) {
        AppMethodBeat.i(124284);
        if (str == null || str.length() == 0) {
            d.i("WidgetData", "insert args invalid");
            AppMethodBeat.o(124284);
            return null;
        }
        WidgetData cVI = cVI();
        try {
            int optInt;
            JSONObject jSONObject = new JSONObject(str);
            cVI.ubs.csB = jSONObject.optString("appid");
            cVI.ubs.version = jSONObject.optInt("version");
            cVI.ubs.bCu = jSONObject.optString("nickName");
            cVI.ubs.userName = jSONObject.optString("username");
            cVI.ubs.fpS = jSONObject.optString("srcAppid");
            cVI.ubs.ubw = jSONObject.optString("inputData");
            cVI.ubs.csu = jSONObject.optString("pagePath");
            cVI.ubs.ubx = jSONObject.optString("wxaData");
            cVI.ubs.uby = jSONObject.optString("launchwxawidget");
            cVI.ubs.fmr = bo.ank(jSONObject.optString("serviceType"));
            Info info = cVI.ubs;
            if (jSONObject.has("debugMode")) {
                optInt = jSONObject.optInt("debugMode");
            } else {
                optInt = 0;
            }
            info.ubz = optInt;
            cVI.ubs.hlm = jSONObject.optString("searchId");
            String optString = jSONObject.optString("relayInfoStr");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (jSONObject2.has("openapp_permission")) {
                        cVI.ubs.ubC = jSONObject2.optLong("openapp_permission");
                    }
                }
            } catch (JSONException e) {
                d.printErrStackTrace("WidgetData", e, "", new Object[0]);
            }
            cVI.ubt.ubI = jSONObject.has("maxHeight") ? jSONObject.optInt("maxHeight") : BaseClientBuilder.API_PRIORITY_OTHER;
            cVI.ubt.height = jSONObject.optInt("height");
            cVI.ubt.width = jSONObject.optInt("width");
            cVI.ubt.hfo = jSONObject.optString("backgroundColor");
            cVI.ubt.ubH = jSONObject.has("minHeight") ? jSONObject.optDouble("minHeight") : 0.0d;
            cVI.ubt.offsetX = jSONObject.optInt("offsetX");
            cVI.ubt.offsetY = jSONObject.optInt("offsetY");
            cVI.ubt.cNN = jSONObject.has("show") ? jSONObject.optBoolean("show") : true;
            AppMethodBeat.o(124284);
            return cVI;
        } catch (JSONException e2) {
            d.printErrStackTrace("WidgetData", e2, "", new Object[0]);
            AppMethodBeat.o(124284);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(124285);
        parcel.writeParcelable(this.ubr, i);
        parcel.writeParcelable(this.ubs, i);
        parcel.writeParcelable(this.ubt, i);
        parcel.writeInt(this.ubu);
        parcel.writeString(this.query);
        parcel.writeString(this.ubv);
        AppMethodBeat.o(124285);
    }

    protected WidgetData(Parcel parcel) {
        AppMethodBeat.i(124286);
        this.ubr = (MoreFooter) parcel.readParcelable(MoreFooter.class.getClassLoader());
        this.ubs = (Info) parcel.readParcelable(Info.class.getClassLoader());
        this.ubt = (Style) parcel.readParcelable(Style.class.getClassLoader());
        this.ubu = parcel.readInt();
        this.query = parcel.readString();
        this.ubv = parcel.readString();
        AppMethodBeat.o(124286);
    }

    static {
        AppMethodBeat.i(124287);
        AppMethodBeat.o(124287);
    }
}
