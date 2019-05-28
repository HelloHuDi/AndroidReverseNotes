package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.baseutils.IOUtils;
import d.a.a.c;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new Creator<Orders>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orders[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46793);
            Orders orders = new Orders(parcel);
            AppMethodBeat.o(46793);
            return orders;
        }
    };
    public static int tAP = 0;
    public static int tAQ = 1;
    public String czZ = "";
    public String ekv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public ArrayList<cgd> field_infos = new ArrayList();
    public String lvz = "";
    public String nickname;
    public String oRi;
    public double pPp;
    public double pTN = 0.0d;
    public String pcl;
    public int tAA = 0;
    public String tAB = "";
    public int tAC = 0;
    public int tAD = 0;
    public ArrayList<ShowInfo> tAE = new ArrayList();
    public String tAF = "";
    public String tAG = "";
    public String tAH = "";
    public String tAI;
    public String tAJ;
    public String tAK = "";
    public String tAL;
    public String tAM;
    public int tAN;
    public SimpleCashierInfo tAO;
    public double tAa = 0.0d;
    public int tAb;
    public int tAc;
    public String tAd;
    public String tAe;
    public String tAf;
    public String tAg;
    public int tAh;
    public boolean tAi = false;
    public String tAj = "";
    public long tAk = 0;
    public String tAl = "";
    public String tAm;
    public Set<String> tAn = new HashSet();
    public int tAo = 0;
    public String tAp = "";
    public List<Commodity> tAq = new ArrayList();
    public h tAr = new h();
    public int tAs = 0;
    public String tAt = "";
    public String tAu = "";
    public DeductInfo tAv;
    public long tAw;
    public long tAx;
    public int tAy = 0;
    public int tAz = 0;
    public String token = "";
    public int tuo;
    public String twd;
    public String tyA;
    public long tzZ;
    public String username;

    public static class Promotions implements Parcelable {
        public static final Creator<Promotions> CREATOR = new Creator<Promotions>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Promotions[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46812);
                Promotions promotions = new Promotions(parcel);
                AppMethodBeat.o(46812);
                return promotions;
            }
        };
        public String name;
        public String pcm;
        public String pia;
        public int tBn;
        public c tBw;
        public String title;
        public long ttW;
        public int type;
        public int tzP;
        public int tzQ;
        public long tzR;
        public String tzS;
        public int uZM;
        public int uZN;
        public String uZO;
        public String uZP;
        public String uZQ;
        public int uZR;
        public String uZS;
        public String uZT;
        public String url;

        public Promotions(Parcel parcel) {
            AppMethodBeat.i(46813);
            this.type = parcel.readInt();
            this.pia = parcel.readString();
            this.name = parcel.readString();
            this.tzS = parcel.readString();
            this.url = parcel.readString();
            this.pcm = parcel.readString();
            this.title = parcel.readString();
            this.tBn = parcel.readInt();
            this.ttW = parcel.readLong();
            this.uZM = parcel.readInt();
            this.uZN = parcel.readInt();
            this.tzP = parcel.readInt();
            this.tzQ = parcel.readInt();
            this.uZO = parcel.readString();
            this.uZP = parcel.readString();
            this.uZQ = parcel.readString();
            this.tzR = parcel.readLong();
            this.uZR = parcel.readInt();
            AppMethodBeat.o(46813);
        }

        static {
            AppMethodBeat.i(46815);
            AppMethodBeat.o(46815);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46814);
            parcel.writeInt(this.type);
            parcel.writeString(this.pia);
            parcel.writeString(this.name);
            parcel.writeString(this.tzS);
            parcel.writeString(this.url);
            parcel.writeString(this.pcm);
            parcel.writeString(this.title);
            parcel.writeInt(this.tBn);
            parcel.writeLong(this.ttW);
            parcel.writeInt(this.uZM);
            parcel.writeInt(this.uZN);
            parcel.writeInt(this.tzP);
            parcel.writeInt(this.tzQ);
            parcel.writeString(this.uZO);
            parcel.writeString(this.uZP);
            parcel.writeString(this.uZQ);
            parcel.writeLong(this.tzR);
            parcel.writeInt(this.uZR);
            AppMethodBeat.o(46814);
        }
    }

    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Creator<RecommendTinyAppInfo> CREATOR = new Creator<RecommendTinyAppInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RecommendTinyAppInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46816);
                RecommendTinyAppInfo recommendTinyAppInfo = new RecommendTinyAppInfo(parcel);
                AppMethodBeat.o(46816);
                return recommendTinyAppInfo;
            }
        };
        public int tBA;
        public int tBB;
        public long tBC;
        public long tBx;
        public long tBy;
        public long tBz;
        public String ttf;
        public String ttg;
        public String tzU;
        public String tzV;
        public String tzW;
        public String tzX;
        public int tzY;

        public RecommendTinyAppInfo(Parcel parcel) {
            AppMethodBeat.i(46817);
            this.ttf = parcel.readString();
            this.tzU = parcel.readString();
            this.tzV = parcel.readString();
            this.tzW = parcel.readString();
            this.ttg = parcel.readString();
            this.tzY = parcel.readInt();
            AppMethodBeat.o(46817);
        }

        static {
            AppMethodBeat.i(46819);
            AppMethodBeat.o(46819);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46818);
            parcel.writeString(this.ttf);
            parcel.writeString(this.tzU);
            parcel.writeString(this.tzV);
            parcel.writeString(this.tzW);
            parcel.writeString(this.ttg);
            parcel.writeInt(this.tzY);
            AppMethodBeat.o(46818);
        }
    }

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Commodity[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46794);
                Commodity commodity = new Commodity(parcel);
                AppMethodBeat.o(46794);
                return commodity;
            }
        };
        public String cAa;
        public String desc;
        public double kCJ = 0.0d;
        public String pbP;
        public String pbX;
        public String pbY;
        public String pbZ;
        public String pca;
        public String pcc;
        public String pce;
        public String pcf;
        public int pch;
        public String pcj;
        public String pcl;
        public String pcm;
        public String pcq;
        public double tAR = 0.0d;
        public String tAS;
        public String tAT;
        public List<DiscountInfo> tAU = new ArrayList();
        public String tAV;
        public String tAW;
        public String tAX;
        public RecommendTinyAppInfo tAY = null;
        public RemarksInfo tAZ;
        public int tAh;
        public List<Promotions> tBa = new ArrayList();
        public boolean tBb = false;
        public a tBc = new a();

        public int describeContents() {
            return 0;
        }

        public Commodity() {
            AppMethodBeat.i(46795);
            AppMethodBeat.o(46795);
        }

        public Commodity(Parcel parcel) {
            AppMethodBeat.i(46796);
            this.pbX = parcel.readString();
            this.pbY = parcel.readString();
            this.pbZ = parcel.readString();
            this.pca = parcel.readString();
            this.desc = parcel.readString();
            this.pcc = parcel.readString();
            this.kCJ = parcel.readDouble();
            this.pce = parcel.readString();
            this.pcf = parcel.readString();
            this.pch = parcel.readInt();
            this.cAa = parcel.readString();
            this.pcj = parcel.readString();
            this.pcl = parcel.readString();
            this.pcm = parcel.readString();
            this.pbP = parcel.readString();
            this.tAT = parcel.readString();
            this.pcq = parcel.readString();
            parcel.readTypedList(this.tAU, DiscountInfo.CREATOR);
            this.tAV = parcel.readString();
            this.tAX = parcel.readString();
            this.tAY = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
            parcel.readTypedList(this.tBa, Promotions.CREATOR);
            this.tAZ = (RemarksInfo) parcel.readParcelable(RemarksInfo.class.getClassLoader());
            AppMethodBeat.o(46796);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46797);
            parcel.writeString(this.pbX);
            parcel.writeString(this.pbY);
            parcel.writeString(this.pbZ);
            parcel.writeString(this.pca);
            parcel.writeString(this.desc);
            parcel.writeString(this.pcc);
            parcel.writeDouble(this.kCJ);
            parcel.writeString(this.pce);
            parcel.writeString(this.pcf);
            parcel.writeInt(this.pch);
            parcel.writeString(this.cAa);
            parcel.writeString(this.pcj);
            parcel.writeString(this.pcl);
            parcel.writeString(this.pcm);
            parcel.writeString(this.pbP);
            parcel.writeString(this.tAT);
            parcel.writeString(this.pcq);
            parcel.writeTypedList(this.tAU);
            parcel.writeString(this.tAV);
            parcel.writeString(this.tAX);
            parcel.writeParcelable(this.tAY, 0);
            parcel.writeTypedList(this.tBa);
            parcel.writeParcelable(this.tAZ, 0);
            AppMethodBeat.o(46797);
        }

        static {
            AppMethodBeat.i(46798);
            AppMethodBeat.o(46798);
        }
    }

    public static class RemarksInfo implements Parcelable {
        public static final Creator<RemarksInfo> CREATOR = new Creator<RemarksInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemarksInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46820);
                RemarksInfo remarksInfo = new RemarksInfo(parcel);
                AppMethodBeat.o(46820);
                return remarksInfo;
            }
        };
        public String tBD;
        public String tBE;

        protected RemarksInfo(Parcel parcel) {
            AppMethodBeat.i(46821);
            this.tBD = parcel.readString();
            this.tBE = parcel.readString();
            AppMethodBeat.o(46821);
        }

        static {
            AppMethodBeat.i(46823);
            AppMethodBeat.o(46823);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46822);
            parcel.writeString(this.tBD);
            parcel.writeString(this.tBE);
            AppMethodBeat.o(46822);
        }
    }

    public static class a {
        public String text = "";
        public String url = "";
    }

    public static class DeductInfo implements Parcelable {
        public static final Creator<DeductInfo> CREATOR = new Creator<DeductInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46799);
                DeductInfo deductInfo = new DeductInfo(parcel);
                AppMethodBeat.o(46799);
                return deductInfo;
            }
        };
        public String desc;
        public String kdE;
        public String tBd;
        public List<DeductShowInfo> tBe = new ArrayList();
        public int tBf;
        public String tBg;
        public String tBh;
        public String title;
        public int tpY;
        public int tpl;
        public String tpm;

        public DeductInfo() {
            AppMethodBeat.i(46800);
            AppMethodBeat.o(46800);
        }

        public DeductInfo(Parcel parcel) {
            AppMethodBeat.i(46801);
            this.title = parcel.readString();
            this.desc = parcel.readString();
            this.tpY = parcel.readInt();
            this.tBd = parcel.readString();
            this.tBf = parcel.readInt();
            parcel.readTypedList(this.tBe, DeductShowInfo.CREATOR);
            this.tpl = parcel.readInt();
            this.kdE = parcel.readString();
            this.tpm = parcel.readString();
            this.tBg = parcel.readString();
            this.tBh = parcel.readString();
            AppMethodBeat.o(46801);
        }

        static {
            AppMethodBeat.i(46803);
            AppMethodBeat.o(46803);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46802);
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
            parcel.writeInt(this.tpY);
            parcel.writeString(this.tBd);
            parcel.writeInt(this.tBf);
            parcel.writeTypedList(this.tBe);
            parcel.writeInt(this.tpl);
            parcel.writeString(this.kdE);
            parcel.writeString(this.tpm);
            parcel.writeString(this.tBg);
            parcel.writeString(this.tBh);
            AppMethodBeat.o(46802);
        }
    }

    public static class DeductShowInfo implements Parcelable {
        public static final Creator<DeductShowInfo> CREATOR = new Creator<DeductShowInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductShowInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46804);
                DeductShowInfo deductShowInfo = new DeductShowInfo(parcel);
                AppMethodBeat.o(46804);
                return deductShowInfo;
            }
        };
        public String name;
        public int tBi;
        public String tBj;
        public String tBk;
        public String tBl;
        public String value;

        protected DeductShowInfo(Parcel parcel) {
            AppMethodBeat.i(46805);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.tBi = parcel.readInt();
            this.tBj = parcel.readString();
            this.tBk = parcel.readString();
            this.tBl = parcel.readString();
            AppMethodBeat.o(46805);
        }

        static {
            AppMethodBeat.i(46807);
            AppMethodBeat.o(46807);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46806);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeInt(this.tBi);
            parcel.writeString(this.tBj);
            parcel.writeString(this.tBk);
            parcel.writeString(this.tBl);
            AppMethodBeat.o(46806);
        }
    }

    public static class ShowInfo implements Parcelable {
        public static final Creator<ShowInfo> CREATOR = new Creator<ShowInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ShowInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46824);
                ShowInfo showInfo = new ShowInfo(parcel);
                AppMethodBeat.o(46824);
                return showInfo;
            }
        };
        public String mVA;
        public String name;
        public String tBF;
        public int tBG;
        public String tBH;
        public String tBI;
        public String tBJ;
        public int tBK;
        public String value;

        protected ShowInfo(Parcel parcel) {
            AppMethodBeat.i(46825);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.mVA = parcel.readString();
            this.tBF = parcel.readString();
            this.tBG = parcel.readInt();
            this.tBH = parcel.readString();
            this.tBI = parcel.readString();
            this.tBJ = parcel.readString();
            this.tBK = parcel.readInt();
            AppMethodBeat.o(46825);
        }

        public String toString() {
            AppMethodBeat.i(46826);
            String format = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[]{this.name, this.value, this.mVA, this.tBF, Integer.valueOf(this.tBG), this.tBH, this.tBI, this.tBJ, Integer.valueOf(this.tBK)});
            AppMethodBeat.o(46826);
            return format;
        }

        static {
            AppMethodBeat.i(46828);
            AppMethodBeat.o(46828);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46827);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.mVA);
            parcel.writeString(this.tBF);
            parcel.writeInt(this.tBG);
            parcel.writeString(this.tBH);
            parcel.writeString(this.tBI);
            parcel.writeString(this.tBJ);
            parcel.writeInt(this.tBK);
            AppMethodBeat.o(46827);
        }
    }

    public static class SimpleCashierInfo implements Parcelable {
        public static final Creator<SimpleCashierInfo> CREATOR = new Creator<SimpleCashierInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SimpleCashierInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46829);
                SimpleCashierInfo simpleCashierInfo = new SimpleCashierInfo(parcel);
                AppMethodBeat.o(46829);
                return simpleCashierInfo;
            }
        };
        public String pbn;
        public String pbo;
        public int tBL;

        protected SimpleCashierInfo(Parcel parcel) {
            AppMethodBeat.i(46830);
            this.tBL = parcel.readInt();
            this.pbn = parcel.readString();
            this.pbo = parcel.readString();
            AppMethodBeat.o(46830);
        }

        static {
            AppMethodBeat.i(46832);
            AppMethodBeat.o(46832);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46831);
            parcel.writeInt(this.tBL);
            parcel.writeString(this.pbn);
            parcel.writeString(this.pbo);
            AppMethodBeat.o(46831);
        }
    }

    public static class DiscountInfo implements Parcelable {
        public static final Creator<DiscountInfo> CREATOR = new Creator<DiscountInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DiscountInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46808);
                DiscountInfo discountInfo = new DiscountInfo(parcel);
                AppMethodBeat.o(46808);
                return discountInfo;
            }
        };
        public String pOz;
        public double tBm;

        public DiscountInfo(Parcel parcel) {
            AppMethodBeat.i(46809);
            this.tBm = parcel.readDouble();
            this.pOz = parcel.readString();
            AppMethodBeat.o(46809);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(46810);
            parcel.writeDouble(this.tBm);
            parcel.writeString(this.pOz);
            AppMethodBeat.o(46810);
        }

        static {
            AppMethodBeat.i(46811);
            AppMethodBeat.o(46811);
        }
    }

    public Orders() {
        AppMethodBeat.i(46833);
        AppMethodBeat.o(46833);
    }

    public static Orders ap(JSONObject jSONObject) {
        AppMethodBeat.i(46834);
        Orders orders = null;
        if (jSONObject != null) {
            Orders orders2 = new Orders();
            try {
                orders2.tzZ = bo.anU();
                orders2.pTN = e.b(jSONObject.optString("total_fee"), "100", RoundingMode.HALF_UP);
                orders2.ekv = jSONObject.getString("num");
                orders2.tuo = jSONObject.optInt("bank_card_tag", 1);
                orders2.pcl = jSONObject.optString("fee_type", "");
                orders2.pPp = e.b(jSONObject.optString("charge_fee"), "100", RoundingMode.HALF_UP);
                orders2.tAa = e.b(jSONObject.optString("fetch_fee"), "100", RoundingMode.HALF_UP);
                orders2.tAb = jSONObject.optInt("is_assign_userinfo_pay");
                orders2.twd = jSONObject.optString("true_name");
                orders2.tyA = jSONObject.optString("cre_id");
                orders2.tAc = jSONObject.optInt("ce_type");
                orders2.tAd = jSONObject.optString("assign_pay_info");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                orders2.tAw = jSONObject.optLong("free_fee");
                orders2.tAx = jSONObject.optLong("remain_fee");
                orders2.tAy = jSONObject.optInt("not_support_bind_card", 0);
                orders2.tAz = jSONObject.optInt("not_support_retry", 0);
                int i = jSONObject.optInt("support_all_bank", 0) == 1 ? 1 : 0;
                if (i != 0) {
                    orders2.tAn = new HashSet();
                }
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity = new Commodity();
                    commodity.desc = jSONObject2.getString("desc");
                    commodity.kCJ = e.b(jSONObject2.optString("fee"), "100", RoundingMode.HALF_UP);
                    commodity.pcc = jSONObject2.optInt("count", 1);
                    commodity.pce = jSONObject2.getString("pay_status");
                    commodity.pcj = jSONObject2.optString("buy_bank_name");
                    commodity.pcf = jSONObject2.getString("pay_status_name");
                    commodity.pbZ = jSONObject2.optString("spid");
                    commodity.pca = jSONObject2.optString("sp_name");
                    commodity.pch = jSONObject2.optInt("modify_timestamp");
                    commodity.cAa = jSONObject2.getString(b.TRANSACTION_ID);
                    commodity.pcl = jSONObject2.optString("fee_type");
                    if (bo.isNullOrNil(orders2.pcl)) {
                        orders2.pcl = commodity.pcl;
                    }
                    commodity.pcm = jSONObject2.optString("appusername");
                    commodity.pbP = jSONObject2.optString("app_telephone");
                    orders2.tAq.add(commodity);
                    if (i == 0) {
                        orders2.tAm = jSONObject2.optString("support_bank");
                        orders2.tAn = acx(orders2.tAm);
                    }
                }
                if (jSONObject.has("is_open_fee_protocal")) {
                    orders2.tAi = e.n(jSONObject, "is_open_fee_protocal");
                } else {
                    orders2.tAi = Bankcard.gh(orders2.tuo, 2);
                }
                orders2.tAr = aB(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject == null) {
                    ab.e("MicroMsg.Orders", "bindqueryresp is null ");
                } else {
                    optJSONObject = optJSONObject.optJSONObject("user_info");
                    if (optJSONObject == null) {
                        ab.e("MicroMsg.Orders", "user_info is null ");
                    } else {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                        if (optJSONObject2 == null) {
                            ab.e("MicroMsg.Orders", "touch_info is null ");
                        } else {
                            boolean z;
                            orders2.tAo = e.dOL() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                            orders2.tAp = optJSONObject2.optString("touch_forbidword");
                            String optString = optJSONObject2.optString("touch_challenge");
                            if (1 == optJSONObject2.optInt("need_change_auth_key")) {
                                z = true;
                            } else {
                                z = false;
                            }
                            v.tCn.msn = optString;
                            v.tCn.mso = z;
                            ab.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", Integer.valueOf(orders2.tAo), optString, Boolean.valueOf(z));
                        }
                    }
                }
                orders2.tAs = jSONObject.optInt("needbindcardtoshowfavinfo");
                orders2.tAt = jSONObject.optString("discount_wording");
                orders2.tAu = jSONObject.optString("favor_rule_wording");
                a(orders2, jSONObject.optJSONObject("entrustpayinfo"));
                String optString2 = jSONObject.optString("field_area_info");
                if (!bo.isNullOrNil(optString2)) {
                    try {
                        orders2.field_infos.addAll(((aca) new aca().parseFrom(Base64.decode(optString2, 0))).field_info);
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
                    }
                }
                orders2.tAH = jSONObject.optString("price_total_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                orders2.tAI = jSONObject.optString("price_fee_type", "");
                orders2.tAJ = jSONObject.optString("price_fee_symbol", "");
                orders2.tAK = jSONObject.optString("settlement_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                orders2.tAL = jSONObject.optString("settlement_type", "");
                orders2.tAM = jSONObject.optString("settlement_symbol", "");
                orders2.tAN = jSONObject.optInt("is_open_field_area", 0);
                optJSONObject = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject != null) {
                    optJSONObject = optJSONObject.optJSONObject("simple_cashier_info");
                    if (optJSONObject != null) {
                        orders2.tAO = new SimpleCashierInfo();
                        orders2.tAO.tBL = optJSONObject.optInt("use_simple_cashier");
                        orders2.tAO.pbn = optJSONObject.optString("bank_type");
                        orders2.tAO.pbo = optJSONObject.optString("bind_serial");
                    }
                }
                orders = orders2;
            } catch (JSONException e2) {
                ab.printErrStackTrace("MicroMsg.Orders", e2, "", new Object[0]);
                orders = orders2;
            }
        }
        AppMethodBeat.o(46834);
        return orders;
    }

    private static h aB(JSONObject jSONObject) {
        AppMethodBeat.i(46835);
        h hVar = new h();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            ab.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            AppMethodBeat.o(46835);
            return hVar;
        }
        int i;
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        int i2;
        JSONArray optJSONArray2;
        hVar.tmR = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        hVar.tmS = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        hVar.tmT = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        hVar.tmU = optJSONObject.optString("favorComposeId");
        hVar.tmX = optJSONObject.optInt("useNaturalDefense");
        hVar.tmY = optJSONObject.optString("discountWording");
        hVar.tmZ = optJSONObject.optString("favorRuleWording");
        hVar.tna = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        hVar.tnb = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        hVar.tnc = optJSONObject.optInt("isVariableFavor");
        hVar.tnd = optJSONObject.optString("invariableFavorDesc");
        hVar.tne = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray3.length(); i++) {
            jSONObject2 = optJSONArray3.getJSONObject(i);
            t tVar = new t();
            tVar.tnJ = jSONObject2.optInt("favType");
            tVar.tnK = jSONObject2.optInt("favSubType");
            tVar.tnL = jSONObject2.optLong("favProperty");
            tVar.tnM = jSONObject2.optString("favorTypeDesc");
            tVar.tmO = jSONObject2.optString("favId");
            tVar.tnN = jSONObject2.optString("favName");
            tVar.tnO = jSONObject2.optString("favDesc");
            tVar.tmP = jSONObject2.optString("favorUseManual");
            tVar.tmQ = jSONObject2.optString("favorRemarks");
            tVar.tnP = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            tVar.tnQ = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            tVar.tnR = jSONObject2.optInt("needBankPay");
            tVar.tnS = jSONObject2.optString("bankNo");
            tVar.pcj = jSONObject2.optString("bankName");
            tVar.tnT = jSONObject2.optString("bankLogoUrl");
            optJSONArray = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    tVar.tnU.add(com.tencent.mm.bt.b.bI(optJSONArray.optString(i2).getBytes()));
                }
            }
            hVar.tmV.add(tVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            hVar.tmW = new i();
            optJSONArray3 = optJSONObject2.optJSONArray("favorComposeInfo");
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= optJSONArray3.length()) {
                    break;
                }
                optJSONObject2 = optJSONArray3.getJSONObject(i2);
                j jVar = new j();
                jVar.tnk = optJSONObject2.optString("faovrComposeId");
                jVar.tnl = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                jVar.tmT = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                jVar.tna = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                jVar.tnb = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                jVar.tnc = optJSONObject2.optInt("isVariableFavor");
                jVar.tnd = optJSONObject2.optString("invariableFavorDesc");
                jVar.tne = optJSONObject2.optString("variableFavorDesc");
                optJSONArray = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    f fVar = new f();
                    fVar.tmO = jSONObject3.optString("favId");
                    fVar.tmP = jSONObject3.optString("favorUseManual");
                    fVar.tmQ = jSONObject3.optString("favorRemarks");
                    jVar.tnm.add(fVar);
                }
                hVar.tmW.tni.add(jVar);
                i = i2 + 1;
            }
        }
        com.tencent.mm.plugin.wallet.a.a aVar = new com.tencent.mm.plugin.wallet.a.a();
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject3 != null) {
            optJSONArray = optJSONObject3.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray != null) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    com.tencent.mm.plugin.wallet.a.c cVar = new com.tencent.mm.plugin.wallet.a.c();
                    optJSONObject2 = optJSONArray.getJSONObject(i2);
                    cVar.pbo = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            d dVar = new d();
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i);
                            dVar.pOz = optJSONObject4.optString("favor_desc");
                            dVar.tmM = optJSONObject4.optInt("is_default_show", 0);
                            cVar.tmL.add(dVar);
                        }
                    }
                    aVar.tmA.add(cVar);
                    i = i2 + 1;
                }
            }
            optJSONArray2 = optJSONObject3.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                aVar.tmB = new n();
                for (i = 0; i < optJSONArray2.length(); i++) {
                    o oVar = new o();
                    oVar.pOz = optJSONArray2.optJSONObject(i).optString("favor_desc");
                    aVar.tmB.tns.add(oVar);
                }
            }
        }
        hVar.tnf = aVar;
        optJSONArray2 = optJSONObject.optJSONArray("favcombid_forbindcard_list");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (i = 0; i < length; i++) {
                optJSONObject3 = optJSONArray2.optJSONObject(i);
                if (optJSONObject3 != null) {
                    g gVar = new g();
                    gVar.tmE = optJSONObject3.optString("default_fav_comb_id");
                    optJSONObject3 = optJSONObject3.optJSONObject("payment_channel");
                    if (optJSONObject3 != null) {
                        m mVar = new m();
                        mVar.pbo = optJSONObject3.optString("bind_serial");
                        mVar.jkL = optJSONObject3.optInt("selected");
                        mVar.tnr = optJSONObject3.optString("bankCode");
                        gVar.tmC = mVar;
                    }
                    hVar.tng.add(gVar);
                }
            }
        }
        com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
        jSONObject2 = optJSONObject.optJSONObject("bank_fav_guide");
        if (jSONObject2 != null) {
            m mVar2 = new m();
            JSONObject optJSONObject5 = jSONObject2.optJSONObject("payment_channel");
            if (optJSONObject5 != null) {
                mVar2.tnr = optJSONObject5.optString("bankCode");
                mVar2.jkL = optJSONObject5.optInt("selected");
                mVar2.pbo = optJSONObject5.optString("bind_serial");
                bVar.tmC = mVar2;
            }
            bVar.tmD = jSONObject2.optInt("is_show_guide");
            bVar.tmE = jSONObject2.optString("default_fav_comb_id");
            bVar.tmF = jSONObject2.optString("guide_content");
            bVar.tmG = jSONObject2.optString("guide_content_color");
            bVar.tmH = jSONObject2.optString("guide_btn_text");
            bVar.tmI = jSONObject2.optString("guide_btn_text_color");
            bVar.tmJ = jSONObject2.optString("guide_btn_bg_color");
            bVar.tmK = jSONObject2.optString("guide_logo");
            hVar.tnh = bVar;
        }
        AppMethodBeat.o(46835);
        return hVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        AppMethodBeat.i(46836);
        if (jSONObject == null || orders == null) {
            ab.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.tAf = optJSONObject.optString("app_recommend_desc");
                    orders.tAg = optJSONObject.optString("app_telephone");
                    orders.tAh = optJSONObject.optInt("recommend_level", 2);
                    orders.lvz = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.tAh;
                List<Commodity> list = orders.tAq;
                orders.tAj = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.tBa = new ArrayList();
                        commodity.tAU = new ArrayList();
                        commodity.cAa = jSONObject2.getString(b.TRANSACTION_ID);
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString(b.TRANSACTION_ID);
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.cAa)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject(Constants.EXTINFO);
                if (optJSONObject != null) {
                    orders.tAk = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.tAl = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
                orders.tAA = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.tAB = jSONObject.optString("pay_succ_btn_wording");
                orders.tAD = jSONObject.optInt("is_jsapi_close_page");
                orders.tAF = jSONObject.optString("jsapi_tinyapp_username");
                orders.tAG = jSONObject.optString("jsapi_tinyapp_path");
                b(orders, jSONObject);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46836);
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        AppMethodBeat.i(46837);
        commodity.pcq = jSONObject.optString("discount");
        commodity.pce = jSONObject.getString("pay_status");
        commodity.pcf = jSONObject.getString("pay_status_name");
        commodity.pcj = jSONObject.optString("buy_bank_name");
        commodity.pch = jSONObject.optInt("pay_timestamp");
        commodity.tAT = jSONObject.optString("card_tail");
        commodity.tAh = i;
        commodity.tAV = jSONObject.optString("rateinfo");
        commodity.tAW = jSONObject.optString("discount_rateinfo");
        commodity.tAX = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.kCJ = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.tAR = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.pcl = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            Promotions promotions = new Promotions();
            promotions.type = tAP;
            promotions.name = optJSONObject.optString("nickname");
            promotions.pcm = optJSONObject.optString("username");
            commodity.tAS = promotions.pcm;
            promotions.pia = optJSONObject.optString("logo_round_url");
            promotions.url = optJSONObject.optString("subscribe_biz_url");
            if (!(bo.isNullOrNil(promotions.name) || bo.isNullOrNil(promotions.url))) {
                commodity.tBa.add(promotions);
                commodity.tBb = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Promotions promotions2 = new Promotions();
            promotions2.type = tAQ;
            promotions2.pia = jSONObject2.optString("icon");
            promotions2.name = jSONObject2.optString("wording");
            promotions2.url = jSONObject2.optString("url");
            promotions2.tzS = jSONObject2.optString("btn_text");
            promotions2.tBn = jSONObject2.optInt("type");
            promotions2.title = jSONObject2.optString("title");
            promotions2.ttW = jSONObject2.optLong("activity_id");
            promotions2.uZM = jSONObject2.optInt("activity_type", 0);
            promotions2.uZO = jSONObject2.optString("small_title");
            promotions2.uZN = jSONObject2.optInt("award_id");
            promotions2.tzP = jSONObject2.optInt("send_record_id");
            promotions2.tzQ = jSONObject2.optInt("user_record_id");
            promotions2.uZP = jSONObject2.optString("activity_tinyapp_username");
            promotions2.uZQ = jSONObject2.optString("activity_tinyapp_path");
            promotions2.tzR = jSONObject2.optLong("activity_mch_id");
            promotions2.uZR = jSONObject2.optInt("activity_tinyapp_version");
            promotions2.uZS = jSONObject2.optString("get_award_params");
            promotions2.uZT = jSONObject2.optString("query_award_status_params");
            a(promotions2, jSONObject2.optJSONObject("exposure_info"));
            commodity.tBa.add(promotions2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.tBc.text = optJSONObject.optString("text");
            commodity.tBc.url = optJSONObject.optString("url");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.tBm = optJSONObject2.optDouble("payment_amount");
                    discountInfo.pOz = optJSONObject2.optString("favor_desc");
                    commodity.tAU.add(discountInfo);
                }
                i2++;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject3 != null) {
            if (commodity.tAY == null) {
                commodity.tAY = new RecommendTinyAppInfo();
            }
            commodity.tAY.ttf = optJSONObject3.optString("tinyapp_name");
            commodity.tAY.tzU = optJSONObject3.optString("tinyapp_logo");
            commodity.tAY.tzV = optJSONObject3.optString("tinyapp_desc");
            commodity.tAY.tzW = optJSONObject3.optString("tinyapp_username");
            commodity.tAY.ttg = optJSONObject3.optString("tinyapp_path");
            commodity.tAY.tzX = optJSONObject3.optString("activity_tinyapp_btn_text");
            commodity.tAY.tBx = optJSONObject3.optLong("activity_id");
            commodity.tAY.tBy = optJSONObject3.optLong("activity_type");
            commodity.tAY.tBz = optJSONObject3.optLong("award_id");
            commodity.tAY.tBA = optJSONObject3.optInt("send_record_id");
            commodity.tAY.tBB = optJSONObject3.optInt("user_record_id");
            commodity.tAY.tBC = optJSONObject3.optLong("activity_mch_id");
            commodity.tAY.tzY = optJSONObject3.optInt("tinyapp_version");
        }
        optJSONObject3 = jSONObject.optJSONObject("remarks_info");
        if (optJSONObject3 != null) {
            if (commodity.tAZ == null) {
                commodity.tAZ = new RemarksInfo();
            }
            commodity.tAZ.tBD = optJSONObject3.optString("remark_title");
            commodity.tAZ.tBE = optJSONObject3.optString("remark_desc");
        }
        AppMethodBeat.o(46837);
    }

    public static void a(Promotions promotions, JSONObject jSONObject) {
        AppMethodBeat.i(46838);
        ab.i("MicroMsg.Orders", "parseExposureInfo: %s", jSONObject);
        if (jSONObject == null) {
            promotions.tBw = null;
            AppMethodBeat.o(46838);
            return;
        }
        try {
            c cVar = new c();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.wew = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    d.a.a.g gVar = new d.a.a.g();
                    gVar.pia = jSONObject2.optString("logo");
                    gVar.BTP = jSONObject2.optString("award_name");
                    gVar.BTQ = jSONObject2.optString("award_description");
                    gVar.BTR = jSONObject2.optString("background_img");
                    gVar.BTT = jSONObject2.optString("award_description_color");
                    gVar.BTS = jSONObject2.optString("award_name_color");
                    cVar.wew.add(gVar);
                }
            }
            cVar.BTA = jSONObject.optInt("is_query_others", 0);
            cVar.wdr = jSONObject.optString("draw_lottery_params");
            cVar.wex = jSONObject.optInt("is_show_btn");
            cVar.BTE = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                cVar.wey = new d.a.a.a();
                cVar.wey.BTs = optJSONObject.optString("btn_words");
                cVar.wey.BTt = optJSONObject.optString("btn_color");
                cVar.wey.BTu = optJSONObject.optInt("btn_op_type");
                cVar.wey.url = optJSONObject.optString("url");
                cVar.wey.wqf = optJSONObject.optString("get_lottery_params");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.wey.BTv = new d.a.a.f();
                    cVar.wey.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                    cVar.wey.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                    cVar.wey.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            cVar.wev = jSONObject.optString("exposure_info_modify_params");
            cVar.BTB = jSONObject.optInt("user_opertaion_type");
            cVar.BTC = jSONObject.optInt("is_show_layer");
            optJSONObject = jSONObject.optJSONObject("layer_info");
            if (optJSONObject != null) {
                cVar.BTD = new d.a.a.e();
                cVar.BTD.BTG = optJSONObject.optString("layer_title");
                cVar.BTD.BTH = optJSONObject.optString("layer_logo");
                cVar.BTD.BTI = optJSONObject.optString("layer_type");
                cVar.BTD.BTJ = optJSONObject.optString("layer_name");
                cVar.BTD.BTK = optJSONObject.optString("layer_description");
                cVar.BTD.BTL = optJSONObject.optInt("is_show_layer_btn");
                if (!bo.isNullOrNil(optJSONObject.optString("voice_url"))) {
                    cVar.BTD.BTN = new com.tencent.mm.bt.b(optJSONObject.optString("voice_url").getBytes());
                }
                if (!bo.isNullOrNil(optJSONObject.optString("voice_data"))) {
                    cVar.BTD.BTO = new com.tencent.mm.bt.b(optJSONObject.optString("voice_data").getBytes());
                }
                optJSONObject = optJSONObject.optJSONObject("layer_btn_info");
                if (optJSONObject != null) {
                    cVar.BTD.BTM = new d.a.a.d();
                    cVar.BTD.BTM.BTs = optJSONObject.optString("btn_words");
                    cVar.BTD.BTM.BTt = optJSONObject.optString("btn_color");
                    cVar.BTD.BTM.BTu = optJSONObject.optInt("btn_op_type");
                    cVar.BTD.BTM.wqf = optJSONObject.optString("get_lottery_params");
                    cVar.BTD.BTM.url = optJSONObject.optString("url");
                    optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                    if (optJSONObject != null) {
                        cVar.BTD.BTM.BTv = new d.a.a.f();
                        cVar.BTD.BTM.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                        cVar.BTD.BTM.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                        cVar.BTD.BTM.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                    }
                }
            }
            optJSONObject = jSONObject.optJSONObject("draw_lottery_info");
            if (optJSONObject != null) {
                cVar.BTF = new d.a.a.b();
                cVar.BTF.url = optJSONObject.optString("url");
                cVar.BTF.BTw = optJSONObject.optString("animation_wording");
                cVar.BTF.BTx = optJSONObject.optString("animation_wording_color");
                cVar.BTF.BTy = optJSONObject.optString("after_animation_wording");
                cVar.BTF.BTz = optJSONObject.optString("after_animation_wording_color");
                cVar.BTF.xis = optJSONObject.optInt("op_type");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.BTF.BTv = new d.a.a.f();
                    cVar.BTF.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                    cVar.BTF.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                    cVar.BTF.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            promotions.tBw = cVar;
            AppMethodBeat.o(46838);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Orders", e, "parseExposureInfo error: %s", e.getMessage());
            AppMethodBeat.o(46838);
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.i(46839);
        if (jSONObject != null) {
            ab.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.tAv = new DeductInfo();
            orders.tAv.title = jSONObject.optString("contract_title");
            orders.tAv.desc = jSONObject.optString("contract_desc");
            orders.tAv.tpY = jSONObject.optInt("auto_deduct_flag", 0);
            orders.tAv.tBd = jSONObject.optString("contract_url");
            orders.tAv.tBf = jSONObject.optInt("is_select_pay_way", 0);
            orders.tAv.tpl = jSONObject.optInt("deduct_show_type", 0);
            orders.tAv.kdE = jSONObject.optString("button_wording", "");
            orders.tAv.tpm = jSONObject.optString("deduct_rule_wording", "");
            orders.tAv.tBg = jSONObject.optString("open_deduct_wording", "");
            orders.tAv.tBh = jSONObject.optString("open_deduct_wording_color", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.tAv.tBe = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString("value");
                        optJSONObject = optJSONObject.optJSONObject("value_attr");
                        if (optJSONObject != null) {
                            deductShowInfo.tBi = optJSONObject.optInt("link_type", 0);
                            deductShowInfo.tBj = optJSONObject.optString("link_weapp");
                            deductShowInfo.tBk = optJSONObject.optString("link_addr");
                            deductShowInfo.tBl = optJSONObject.optString("link_url");
                        }
                        orders.tAv.tBe.add(deductShowInfo);
                    } else {
                        ab.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
                    }
                }
                AppMethodBeat.o(46839);
                return;
            }
            ab.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(length)));
            AppMethodBeat.o(46839);
            return;
        }
        ab.i("MicroMsg.Orders", "parseDeductInfo json is null");
        AppMethodBeat.o(46839);
    }

    private static void b(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.i(46840);
        if (jSONObject != null) {
            try {
                orders.tAC = jSONObject.optInt("is_use_show_info", 0);
                ab.i("MicroMsg.Orders", "is_use_show_info: %s", Integer.valueOf(orders.tAC));
                JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ab.i("MicroMsg.Orders", "showInfo size: %s", Integer.valueOf(optJSONArray.length()));
                    orders.tAE = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            ShowInfo showInfo = new ShowInfo();
                            showInfo.name = optJSONObject.optString("name");
                            showInfo.value = optJSONObject.optString("value");
                            showInfo.mVA = optJSONObject.optString("name_color");
                            showInfo.tBF = optJSONObject.optString("value_color");
                            optJSONObject = optJSONObject.optJSONObject("value_attr");
                            if (optJSONObject != null) {
                                showInfo.tBG = optJSONObject.optInt("link_type");
                                showInfo.tBH = optJSONObject.optString("link_weapp");
                                showInfo.tBI = optJSONObject.optString("link_addr");
                                showInfo.tBJ = optJSONObject.optString("link_url");
                                showInfo.tBK = optJSONObject.optInt("text_attr");
                            }
                            if (!bo.isNullOrNil(showInfo.name) || !bo.isNullOrNil(showInfo.value)) {
                                orders.tAE.add(showInfo);
                            }
                        }
                    }
                }
                AppMethodBeat.o(46840);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Orders", e, "parseShowInfo error", new Object[0]);
            }
        }
        AppMethodBeat.o(46840);
    }

    public String toString() {
        AppMethodBeat.i(46841);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.czZ).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("token").append(this.token).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("num").append(this.ekv).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("totalFee").append(this.pTN).append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(46841);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> acx(String str) {
        AppMethodBeat.i(46842);
        HashSet hashSet = new HashSet();
        if (!bo.isNullOrNil(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        AppMethodBeat.o(46842);
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(46843);
        this.tzZ = parcel.readLong();
        this.czZ = parcel.readString();
        this.token = parcel.readString();
        this.ekv = parcel.readString();
        this.pTN = parcel.readDouble();
        this.tuo = parcel.readInt();
        this.pcl = parcel.readString();
        this.pPp = parcel.readDouble();
        this.tAa = parcel.readDouble();
        this.tAb = parcel.readInt();
        this.twd = parcel.readString();
        this.tyA = parcel.readString();
        this.tAc = parcel.readInt();
        this.tAd = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.oRi = parcel.readString();
        this.tAe = parcel.readString();
        this.tAf = parcel.readString();
        this.tAg = parcel.readString();
        this.tAh = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.tAi = z;
        this.tAj = parcel.readString();
        this.lvz = parcel.readString();
        this.tAk = parcel.readLong();
        this.tAl = parcel.readString();
        parcel.readTypedList(this.tAq, Commodity.CREATOR);
        this.tAm = parcel.readString();
        this.tAn = acx(this.tAm);
        this.tAo = parcel.readInt();
        this.tAp = parcel.readString();
        this.tAv = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.tAy = parcel.readInt();
        this.tAz = parcel.readInt();
        this.tAD = parcel.readInt();
        this.tAG = parcel.readString();
        this.tAF = parcel.readString();
        this.tAC = parcel.readInt();
        parcel.readTypedList(this.tAE, ShowInfo.CREATOR);
        this.tAO = (SimpleCashierInfo) parcel.readParcelable(SimpleCashierInfo.class.getClassLoader());
        AppMethodBeat.o(46843);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46844);
        parcel.writeLong(this.tzZ);
        parcel.writeString(this.czZ);
        parcel.writeString(this.token);
        parcel.writeString(this.ekv);
        parcel.writeDouble(this.pTN);
        parcel.writeInt(this.tuo);
        parcel.writeString(this.pcl);
        parcel.writeDouble(this.pPp);
        parcel.writeDouble(this.tAa);
        parcel.writeInt(this.tAb);
        parcel.writeString(this.twd);
        parcel.writeString(this.tyA);
        parcel.writeInt(this.tAc);
        parcel.writeString(this.tAd);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.oRi);
        parcel.writeString(this.tAe);
        parcel.writeString(this.tAf);
        parcel.writeString(this.tAg);
        parcel.writeInt(this.tAh);
        parcel.writeInt(this.tAi ? 1 : 0);
        parcel.writeString(this.tAj);
        parcel.writeString(this.lvz);
        parcel.writeLong(this.tAk);
        parcel.writeString(this.tAl);
        parcel.writeTypedList(this.tAq);
        parcel.writeString(this.tAm);
        parcel.writeInt(this.tAo);
        parcel.writeString(this.tAp);
        parcel.writeParcelable(this.tAv, 1);
        parcel.writeInt(this.tAy);
        parcel.writeInt(this.tAz);
        parcel.writeInt(this.tAD);
        parcel.writeString(this.tAG);
        parcel.writeString(this.tAF);
        parcel.writeInt(this.tAC);
        parcel.writeTypedList(this.tAE);
        parcel.writeParcelable(this.tAO, 1);
        AppMethodBeat.o(46844);
    }

    static {
        AppMethodBeat.i(46845);
        AppMethodBeat.o(46845);
    }
}
