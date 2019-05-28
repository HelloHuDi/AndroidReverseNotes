package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wallet.p748a.C22492i;
import com.tencent.p177mm.plugin.wallet.p748a.C29527o;
import com.tencent.p177mm.plugin.wallet.p748a.C35390a;
import com.tencent.p177mm.plugin.wallet.p748a.C35391c;
import com.tencent.p177mm.plugin.wallet.p748a.C35392d;
import com.tencent.p177mm.plugin.wallet.p748a.C35396n;
import com.tencent.p177mm.plugin.wallet.p748a.C40049b;
import com.tencent.p177mm.plugin.wallet.p748a.C40051m;
import com.tencent.p177mm.plugin.wallet.p748a.C43758t;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet.p748a.C7174f;
import com.tencent.p177mm.plugin.wallet.p748a.C7175g;
import com.tencent.p177mm.plugin.wallet.p748a.C7176h;
import com.tencent.p177mm.protocal.protobuf.aca;
import com.tencent.p177mm.protocal.protobuf.cgd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.ttpic.baseutils.IOUtils;
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
import p1121d.p1122a.p1123a.C16442f;
import p1121d.p1122a.p1123a.C24578d;
import p1121d.p1122a.p1123a.C31176c;
import p1121d.p1122a.p1123a.C31177e;
import p1121d.p1122a.p1123a.C41148b;
import p1121d.p1122a.p1123a.C44604a;
import p1121d.p1122a.p1123a.C44605g;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders */
public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new C401121();
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
    public C7176h tAr = new C7176h();
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

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$Promotions */
    public static class Promotions implements Parcelable {
        public static final Creator<Promotions> CREATOR = new C43921();
        public String name;
        public String pcm;
        public String pia;
        public int tBn;
        public C31176c tBw;
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

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$Promotions$1 */
        static class C43921 implements Creator<Promotions> {
            C43921() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Promotions[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46812);
                Promotions promotions = new Promotions(parcel);
                AppMethodBeat.m2505o(46812);
                return promotions;
            }
        }

        public Promotions(Parcel parcel) {
            AppMethodBeat.m2504i(46813);
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
            AppMethodBeat.m2505o(46813);
        }

        static {
            AppMethodBeat.m2504i(46815);
            AppMethodBeat.m2505o(46815);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46814);
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
            AppMethodBeat.m2505o(46814);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$RecommendTinyAppInfo */
    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Creator<RecommendTinyAppInfo> CREATOR = new C142331();
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

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$RecommendTinyAppInfo$1 */
        static class C142331 implements Creator<RecommendTinyAppInfo> {
            C142331() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RecommendTinyAppInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46816);
                RecommendTinyAppInfo recommendTinyAppInfo = new RecommendTinyAppInfo(parcel);
                AppMethodBeat.m2505o(46816);
                return recommendTinyAppInfo;
            }
        }

        public RecommendTinyAppInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46817);
            this.ttf = parcel.readString();
            this.tzU = parcel.readString();
            this.tzV = parcel.readString();
            this.tzW = parcel.readString();
            this.ttg = parcel.readString();
            this.tzY = parcel.readInt();
            AppMethodBeat.m2505o(46817);
        }

        static {
            AppMethodBeat.m2504i(46819);
            AppMethodBeat.m2505o(46819);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46818);
            parcel.writeString(this.ttf);
            parcel.writeString(this.tzU);
            parcel.writeString(this.tzV);
            parcel.writeString(this.tzW);
            parcel.writeString(this.ttg);
            parcel.writeInt(this.tzY);
            AppMethodBeat.m2505o(46818);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$Commodity */
    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new C225761();
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
        public C22579a tBc = new C22579a();

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$Commodity$1 */
        static class C225761 implements Creator<Commodity> {
            C225761() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Commodity[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46794);
                Commodity commodity = new Commodity(parcel);
                AppMethodBeat.m2505o(46794);
                return commodity;
            }
        }

        public int describeContents() {
            return 0;
        }

        public Commodity() {
            AppMethodBeat.m2504i(46795);
            AppMethodBeat.m2505o(46795);
        }

        public Commodity(Parcel parcel) {
            AppMethodBeat.m2504i(46796);
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
            AppMethodBeat.m2505o(46796);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46797);
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
            AppMethodBeat.m2505o(46797);
        }

        static {
            AppMethodBeat.m2504i(46798);
            AppMethodBeat.m2505o(46798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$RemarksInfo */
    public static class RemarksInfo implements Parcelable {
        public static final Creator<RemarksInfo> CREATOR = new C225771();
        public String tBD;
        public String tBE;

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$RemarksInfo$1 */
        static class C225771 implements Creator<RemarksInfo> {
            C225771() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemarksInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46820);
                RemarksInfo remarksInfo = new RemarksInfo(parcel);
                AppMethodBeat.m2505o(46820);
                return remarksInfo;
            }
        }

        protected RemarksInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46821);
            this.tBD = parcel.readString();
            this.tBE = parcel.readString();
            AppMethodBeat.m2505o(46821);
        }

        static {
            AppMethodBeat.m2504i(46823);
            AppMethodBeat.m2505o(46823);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46822);
            parcel.writeString(this.tBD);
            parcel.writeString(this.tBE);
            AppMethodBeat.m2505o(46822);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$a */
    public static class C22579a {
        public String text = "";
        public String url = "";
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DeductInfo */
    public static class DeductInfo implements Parcelable {
        public static final Creator<DeductInfo> CREATOR = new C354791();
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

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DeductInfo$1 */
        static class C354791 implements Creator<DeductInfo> {
            C354791() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46799);
                DeductInfo deductInfo = new DeductInfo(parcel);
                AppMethodBeat.m2505o(46799);
                return deductInfo;
            }
        }

        public DeductInfo() {
            AppMethodBeat.m2504i(46800);
            AppMethodBeat.m2505o(46800);
        }

        public DeductInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46801);
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
            AppMethodBeat.m2505o(46801);
        }

        static {
            AppMethodBeat.m2504i(46803);
            AppMethodBeat.m2505o(46803);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46802);
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
            AppMethodBeat.m2505o(46802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DeductShowInfo */
    public static class DeductShowInfo implements Parcelable {
        public static final Creator<DeductShowInfo> CREATOR = new C296271();
        public String name;
        public int tBi;
        public String tBj;
        public String tBk;
        public String tBl;
        public String value;

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DeductShowInfo$1 */
        static class C296271 implements Creator<DeductShowInfo> {
            C296271() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductShowInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46804);
                DeductShowInfo deductShowInfo = new DeductShowInfo(parcel);
                AppMethodBeat.m2505o(46804);
                return deductShowInfo;
            }
        }

        protected DeductShowInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46805);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.tBi = parcel.readInt();
            this.tBj = parcel.readString();
            this.tBk = parcel.readString();
            this.tBl = parcel.readString();
            AppMethodBeat.m2505o(46805);
        }

        static {
            AppMethodBeat.m2504i(46807);
            AppMethodBeat.m2505o(46807);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46806);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeInt(this.tBi);
            parcel.writeString(this.tBj);
            parcel.writeString(this.tBk);
            parcel.writeString(this.tBl);
            AppMethodBeat.m2505o(46806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$ShowInfo */
    public static class ShowInfo implements Parcelable {
        public static final Creator<ShowInfo> CREATOR = new C225781();
        public String mVA;
        public String name;
        public String tBF;
        public int tBG;
        public String tBH;
        public String tBI;
        public String tBJ;
        public int tBK;
        public String value;

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$ShowInfo$1 */
        static class C225781 implements Creator<ShowInfo> {
            C225781() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ShowInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46824);
                ShowInfo showInfo = new ShowInfo(parcel);
                AppMethodBeat.m2505o(46824);
                return showInfo;
            }
        }

        protected ShowInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46825);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.mVA = parcel.readString();
            this.tBF = parcel.readString();
            this.tBG = parcel.readInt();
            this.tBH = parcel.readString();
            this.tBI = parcel.readString();
            this.tBJ = parcel.readString();
            this.tBK = parcel.readInt();
            AppMethodBeat.m2505o(46825);
        }

        public String toString() {
            AppMethodBeat.m2504i(46826);
            String format = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[]{this.name, this.value, this.mVA, this.tBF, Integer.valueOf(this.tBG), this.tBH, this.tBI, this.tBJ, Integer.valueOf(this.tBK)});
            AppMethodBeat.m2505o(46826);
            return format;
        }

        static {
            AppMethodBeat.m2504i(46828);
            AppMethodBeat.m2505o(46828);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46827);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.mVA);
            parcel.writeString(this.tBF);
            parcel.writeInt(this.tBG);
            parcel.writeString(this.tBH);
            parcel.writeString(this.tBI);
            parcel.writeString(this.tBJ);
            parcel.writeInt(this.tBK);
            AppMethodBeat.m2505o(46827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$SimpleCashierInfo */
    public static class SimpleCashierInfo implements Parcelable {
        public static final Creator<SimpleCashierInfo> CREATOR = new C354801();
        public String pbn;
        public String pbo;
        public int tBL;

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$SimpleCashierInfo$1 */
        static class C354801 implements Creator<SimpleCashierInfo> {
            C354801() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SimpleCashierInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46829);
                SimpleCashierInfo simpleCashierInfo = new SimpleCashierInfo(parcel);
                AppMethodBeat.m2505o(46829);
                return simpleCashierInfo;
            }
        }

        protected SimpleCashierInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46830);
            this.tBL = parcel.readInt();
            this.pbn = parcel.readString();
            this.pbo = parcel.readString();
            AppMethodBeat.m2505o(46830);
        }

        static {
            AppMethodBeat.m2504i(46832);
            AppMethodBeat.m2505o(46832);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46831);
            parcel.writeInt(this.tBL);
            parcel.writeString(this.pbn);
            parcel.writeString(this.pbo);
            AppMethodBeat.m2505o(46831);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$1 */
    static class C401121 implements Creator<Orders> {
        C401121() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orders[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46793);
            Orders orders = new Orders(parcel);
            AppMethodBeat.m2505o(46793);
            return orders;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DiscountInfo */
    public static class DiscountInfo implements Parcelable {
        public static final Creator<DiscountInfo> CREATOR = new C401111();
        public String pOz;
        public double tBm;

        /* renamed from: com.tencent.mm.plugin.wallet_core.model.Orders$DiscountInfo$1 */
        static class C401111 implements Creator<DiscountInfo> {
            C401111() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DiscountInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(46808);
                DiscountInfo discountInfo = new DiscountInfo(parcel);
                AppMethodBeat.m2505o(46808);
                return discountInfo;
            }
        }

        public DiscountInfo(Parcel parcel) {
            AppMethodBeat.m2504i(46809);
            this.tBm = parcel.readDouble();
            this.pOz = parcel.readString();
            AppMethodBeat.m2505o(46809);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(46810);
            parcel.writeDouble(this.tBm);
            parcel.writeString(this.pOz);
            AppMethodBeat.m2505o(46810);
        }

        static {
            AppMethodBeat.m2504i(46811);
            AppMethodBeat.m2505o(46811);
        }
    }

    public Orders() {
        AppMethodBeat.m2504i(46833);
        AppMethodBeat.m2505o(46833);
    }

    /* renamed from: ap */
    public static Orders m68762ap(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46834);
        Orders orders = null;
        if (jSONObject != null) {
            Orders orders2 = new Orders();
            try {
                orders2.tzZ = C5046bo.anU();
                orders2.pTN = C36391e.m59996b(jSONObject.optString("total_fee"), "100", RoundingMode.HALF_UP);
                orders2.ekv = jSONObject.getString("num");
                orders2.tuo = jSONObject.optInt("bank_card_tag", 1);
                orders2.pcl = jSONObject.optString("fee_type", "");
                orders2.pPp = C36391e.m59996b(jSONObject.optString("charge_fee"), "100", RoundingMode.HALF_UP);
                orders2.tAa = C36391e.m59996b(jSONObject.optString("fetch_fee"), "100", RoundingMode.HALF_UP);
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
                    commodity.kCJ = C36391e.m59996b(jSONObject2.optString("fee"), "100", RoundingMode.HALF_UP);
                    commodity.pcc = jSONObject2.optInt("count", 1);
                    commodity.pce = jSONObject2.getString("pay_status");
                    commodity.pcj = jSONObject2.optString("buy_bank_name");
                    commodity.pcf = jSONObject2.getString("pay_status_name");
                    commodity.pbZ = jSONObject2.optString("spid");
                    commodity.pca = jSONObject2.optString("sp_name");
                    commodity.pch = jSONObject2.optInt("modify_timestamp");
                    commodity.cAa = jSONObject2.getString(C8741b.TRANSACTION_ID);
                    commodity.pcl = jSONObject2.optString("fee_type");
                    if (C5046bo.isNullOrNil(orders2.pcl)) {
                        orders2.pcl = commodity.pcl;
                    }
                    commodity.pcm = jSONObject2.optString("appusername");
                    commodity.pbP = jSONObject2.optString("app_telephone");
                    orders2.tAq.add(commodity);
                    if (i == 0) {
                        orders2.tAm = jSONObject2.optString("support_bank");
                        orders2.tAn = Orders.acx(orders2.tAm);
                    }
                }
                if (jSONObject.has("is_open_fee_protocal")) {
                    orders2.tAi = C36391e.m60017n(jSONObject, "is_open_fee_protocal");
                } else {
                    orders2.tAi = Bankcard.m78503gh(orders2.tuo, 2);
                }
                orders2.tAr = Orders.m68761aB(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject == null) {
                    C4990ab.m7412e("MicroMsg.Orders", "bindqueryresp is null ");
                } else {
                    optJSONObject = optJSONObject.optJSONObject("user_info");
                    if (optJSONObject == null) {
                        C4990ab.m7412e("MicroMsg.Orders", "user_info is null ");
                    } else {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                        if (optJSONObject2 == null) {
                            C4990ab.m7412e("MicroMsg.Orders", "touch_info is null ");
                        } else {
                            boolean z;
                            orders2.tAo = C36391e.dOL() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                            orders2.tAp = optJSONObject2.optString("touch_forbidword");
                            String optString = optJSONObject2.optString("touch_challenge");
                            if (1 == optJSONObject2.optInt("need_change_auth_key")) {
                                z = true;
                            } else {
                                z = false;
                            }
                            C35481v.tCn.msn = optString;
                            C35481v.tCn.mso = z;
                            C4990ab.m7417i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", Integer.valueOf(orders2.tAo), optString, Boolean.valueOf(z));
                        }
                    }
                }
                orders2.tAs = jSONObject.optInt("needbindcardtoshowfavinfo");
                orders2.tAt = jSONObject.optString("discount_wording");
                orders2.tAu = jSONObject.optString("favor_rule_wording");
                Orders.m68760a(orders2, jSONObject.optJSONObject("entrustpayinfo"));
                String optString2 = jSONObject.optString("field_area_info");
                if (!C5046bo.isNullOrNil(optString2)) {
                    try {
                        orders2.field_infos.addAll(((aca) new aca().parseFrom(Base64.decode(optString2, 0))).field_info);
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
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
                C4990ab.printErrStackTrace("MicroMsg.Orders", e2, "", new Object[0]);
                orders = orders2;
            }
        }
        AppMethodBeat.m2505o(46834);
        return orders;
    }

    /* renamed from: aB */
    private static C7176h m68761aB(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46835);
        C7176h c7176h = new C7176h();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            C4990ab.m7410d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            AppMethodBeat.m2505o(46835);
            return c7176h;
        }
        int i;
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        int i2;
        JSONArray optJSONArray2;
        c7176h.tmR = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        c7176h.tmS = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        c7176h.tmT = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        c7176h.tmU = optJSONObject.optString("favorComposeId");
        c7176h.tmX = optJSONObject.optInt("useNaturalDefense");
        c7176h.tmY = optJSONObject.optString("discountWording");
        c7176h.tmZ = optJSONObject.optString("favorRuleWording");
        c7176h.tna = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        c7176h.tnb = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        c7176h.tnc = optJSONObject.optInt("isVariableFavor");
        c7176h.tnd = optJSONObject.optString("invariableFavorDesc");
        c7176h.tne = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray3.length(); i++) {
            jSONObject2 = optJSONArray3.getJSONObject(i);
            C43758t c43758t = new C43758t();
            c43758t.tnJ = jSONObject2.optInt("favType");
            c43758t.tnK = jSONObject2.optInt("favSubType");
            c43758t.tnL = jSONObject2.optLong("favProperty");
            c43758t.tnM = jSONObject2.optString("favorTypeDesc");
            c43758t.tmO = jSONObject2.optString("favId");
            c43758t.tnN = jSONObject2.optString("favName");
            c43758t.tnO = jSONObject2.optString("favDesc");
            c43758t.tmP = jSONObject2.optString("favorUseManual");
            c43758t.tmQ = jSONObject2.optString("favorRemarks");
            c43758t.tnP = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            c43758t.tnQ = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            c43758t.tnR = jSONObject2.optInt("needBankPay");
            c43758t.tnS = jSONObject2.optString("bankNo");
            c43758t.pcj = jSONObject2.optString("bankName");
            c43758t.tnT = jSONObject2.optString("bankLogoUrl");
            optJSONArray = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    c43758t.tnU.add(C1332b.m2847bI(optJSONArray.optString(i2).getBytes()));
                }
            }
            c7176h.tmV.add(c43758t);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            c7176h.tmW = new C22492i();
            optJSONArray3 = optJSONObject2.optJSONArray("favorComposeInfo");
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= optJSONArray3.length()) {
                    break;
                }
                optJSONObject2 = optJSONArray3.getJSONObject(i2);
                C46330j c46330j = new C46330j();
                c46330j.tnk = optJSONObject2.optString("faovrComposeId");
                c46330j.tnl = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                c46330j.tmT = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                c46330j.tna = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                c46330j.tnb = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                c46330j.tnc = optJSONObject2.optInt("isVariableFavor");
                c46330j.tnd = optJSONObject2.optString("invariableFavorDesc");
                c46330j.tne = optJSONObject2.optString("variableFavorDesc");
                optJSONArray = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    C7174f c7174f = new C7174f();
                    c7174f.tmO = jSONObject3.optString("favId");
                    c7174f.tmP = jSONObject3.optString("favorUseManual");
                    c7174f.tmQ = jSONObject3.optString("favorRemarks");
                    c46330j.tnm.add(c7174f);
                }
                c7176h.tmW.tni.add(c46330j);
                i = i2 + 1;
            }
        }
        C35390a c35390a = new C35390a();
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
                    C35391c c35391c = new C35391c();
                    optJSONObject2 = optJSONArray.getJSONObject(i2);
                    c35391c.pbo = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            C35392d c35392d = new C35392d();
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i);
                            c35392d.pOz = optJSONObject4.optString("favor_desc");
                            c35392d.tmM = optJSONObject4.optInt("is_default_show", 0);
                            c35391c.tmL.add(c35392d);
                        }
                    }
                    c35390a.tmA.add(c35391c);
                    i = i2 + 1;
                }
            }
            optJSONArray2 = optJSONObject3.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                c35390a.tmB = new C35396n();
                for (i = 0; i < optJSONArray2.length(); i++) {
                    C29527o c29527o = new C29527o();
                    c29527o.pOz = optJSONArray2.optJSONObject(i).optString("favor_desc");
                    c35390a.tmB.tns.add(c29527o);
                }
            }
        }
        c7176h.tnf = c35390a;
        optJSONArray2 = optJSONObject.optJSONArray("favcombid_forbindcard_list");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (i = 0; i < length; i++) {
                optJSONObject3 = optJSONArray2.optJSONObject(i);
                if (optJSONObject3 != null) {
                    C7175g c7175g = new C7175g();
                    c7175g.tmE = optJSONObject3.optString("default_fav_comb_id");
                    optJSONObject3 = optJSONObject3.optJSONObject("payment_channel");
                    if (optJSONObject3 != null) {
                        C40051m c40051m = new C40051m();
                        c40051m.pbo = optJSONObject3.optString("bind_serial");
                        c40051m.jkL = optJSONObject3.optInt("selected");
                        c40051m.tnr = optJSONObject3.optString("bankCode");
                        c7175g.tmC = c40051m;
                    }
                    c7176h.tng.add(c7175g);
                }
            }
        }
        C40049b c40049b = new C40049b();
        jSONObject2 = optJSONObject.optJSONObject("bank_fav_guide");
        if (jSONObject2 != null) {
            C40051m c40051m2 = new C40051m();
            JSONObject optJSONObject5 = jSONObject2.optJSONObject("payment_channel");
            if (optJSONObject5 != null) {
                c40051m2.tnr = optJSONObject5.optString("bankCode");
                c40051m2.jkL = optJSONObject5.optInt("selected");
                c40051m2.pbo = optJSONObject5.optString("bind_serial");
                c40049b.tmC = c40051m2;
            }
            c40049b.tmD = jSONObject2.optInt("is_show_guide");
            c40049b.tmE = jSONObject2.optString("default_fav_comb_id");
            c40049b.tmF = jSONObject2.optString("guide_content");
            c40049b.tmG = jSONObject2.optString("guide_content_color");
            c40049b.tmH = jSONObject2.optString("guide_btn_text");
            c40049b.tmI = jSONObject2.optString("guide_btn_text_color");
            c40049b.tmJ = jSONObject2.optString("guide_btn_bg_color");
            c40049b.tmK = jSONObject2.optString("guide_logo");
            c7176h.tnh = c40049b;
        }
        AppMethodBeat.m2505o(46835);
        return c7176h;
    }

    /* renamed from: a */
    public static Orders m68757a(JSONObject jSONObject, Orders orders) {
        AppMethodBeat.m2504i(46836);
        if (jSONObject == null || orders == null) {
            C4990ab.m7420w("MicroMsg.Orders", "oldOrders is null");
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
                        commodity.cAa = jSONObject2.getString(C8741b.TRANSACTION_ID);
                        Orders.m68758a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString(C8741b.TRANSACTION_ID);
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.cAa)) {
                                Orders.m68758a(commodity2, jSONObject2, i);
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
                Orders.m68763b(orders, jSONObject);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(46836);
        return orders;
    }

    /* renamed from: a */
    private static void m68758a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(46837);
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
            if (!(C5046bo.isNullOrNil(promotions.name) || C5046bo.isNullOrNil(promotions.url))) {
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
            Orders.m68759a(promotions2, jSONObject2.optJSONObject("exposure_info"));
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
        AppMethodBeat.m2505o(46837);
    }

    /* renamed from: a */
    public static void m68759a(Promotions promotions, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46838);
        C4990ab.m7417i("MicroMsg.Orders", "parseExposureInfo: %s", jSONObject);
        if (jSONObject == null) {
            promotions.tBw = null;
            AppMethodBeat.m2505o(46838);
            return;
        }
        try {
            C31176c c31176c = new C31176c();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                c31176c.wew = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    C44605g c44605g = new C44605g();
                    c44605g.pia = jSONObject2.optString("logo");
                    c44605g.BTP = jSONObject2.optString("award_name");
                    c44605g.BTQ = jSONObject2.optString("award_description");
                    c44605g.BTR = jSONObject2.optString("background_img");
                    c44605g.BTT = jSONObject2.optString("award_description_color");
                    c44605g.BTS = jSONObject2.optString("award_name_color");
                    c31176c.wew.add(c44605g);
                }
            }
            c31176c.BTA = jSONObject.optInt("is_query_others", 0);
            c31176c.wdr = jSONObject.optString("draw_lottery_params");
            c31176c.wex = jSONObject.optInt("is_show_btn");
            c31176c.BTE = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                c31176c.wey = new C44604a();
                c31176c.wey.BTs = optJSONObject.optString("btn_words");
                c31176c.wey.BTt = optJSONObject.optString("btn_color");
                c31176c.wey.BTu = optJSONObject.optInt("btn_op_type");
                c31176c.wey.url = optJSONObject.optString("url");
                c31176c.wey.wqf = optJSONObject.optString("get_lottery_params");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    c31176c.wey.BTv = new C16442f();
                    c31176c.wey.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                    c31176c.wey.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                    c31176c.wey.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            c31176c.wev = jSONObject.optString("exposure_info_modify_params");
            c31176c.BTB = jSONObject.optInt("user_opertaion_type");
            c31176c.BTC = jSONObject.optInt("is_show_layer");
            optJSONObject = jSONObject.optJSONObject("layer_info");
            if (optJSONObject != null) {
                c31176c.BTD = new C31177e();
                c31176c.BTD.BTG = optJSONObject.optString("layer_title");
                c31176c.BTD.BTH = optJSONObject.optString("layer_logo");
                c31176c.BTD.BTI = optJSONObject.optString("layer_type");
                c31176c.BTD.BTJ = optJSONObject.optString("layer_name");
                c31176c.BTD.BTK = optJSONObject.optString("layer_description");
                c31176c.BTD.BTL = optJSONObject.optInt("is_show_layer_btn");
                if (!C5046bo.isNullOrNil(optJSONObject.optString("voice_url"))) {
                    c31176c.BTD.BTN = new C1332b(optJSONObject.optString("voice_url").getBytes());
                }
                if (!C5046bo.isNullOrNil(optJSONObject.optString("voice_data"))) {
                    c31176c.BTD.BTO = new C1332b(optJSONObject.optString("voice_data").getBytes());
                }
                optJSONObject = optJSONObject.optJSONObject("layer_btn_info");
                if (optJSONObject != null) {
                    c31176c.BTD.BTM = new C24578d();
                    c31176c.BTD.BTM.BTs = optJSONObject.optString("btn_words");
                    c31176c.BTD.BTM.BTt = optJSONObject.optString("btn_color");
                    c31176c.BTD.BTM.BTu = optJSONObject.optInt("btn_op_type");
                    c31176c.BTD.BTM.wqf = optJSONObject.optString("get_lottery_params");
                    c31176c.BTD.BTM.url = optJSONObject.optString("url");
                    optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                    if (optJSONObject != null) {
                        c31176c.BTD.BTM.BTv = new C16442f();
                        c31176c.BTD.BTM.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                        c31176c.BTD.BTM.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                        c31176c.BTD.BTM.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                    }
                }
            }
            optJSONObject = jSONObject.optJSONObject("draw_lottery_info");
            if (optJSONObject != null) {
                c31176c.BTF = new C41148b();
                c31176c.BTF.url = optJSONObject.optString("url");
                c31176c.BTF.BTw = optJSONObject.optString("animation_wording");
                c31176c.BTF.BTx = optJSONObject.optString("animation_wording_color");
                c31176c.BTF.BTy = optJSONObject.optString("after_animation_wording");
                c31176c.BTF.BTz = optJSONObject.optString("after_animation_wording_color");
                c31176c.BTF.xis = optJSONObject.optInt("op_type");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    c31176c.BTF.BTv = new C16442f();
                    c31176c.BTF.BTv.wMk = optJSONObject.optString("activity_tinyapp_username");
                    c31176c.BTF.BTv.wMl = optJSONObject.optString("activity_tinyapp_path");
                    c31176c.BTF.BTv.wMm = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            promotions.tBw = c31176c;
            AppMethodBeat.m2505o(46838);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Orders", e, "parseExposureInfo error: %s", e.getMessage());
            AppMethodBeat.m2505o(46838);
        }
    }

    /* renamed from: a */
    private static void m68760a(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46839);
        if (jSONObject != null) {
            C4990ab.m7416i("MicroMsg.Orders", "parseDeductInfo json is not null");
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
                        C4990ab.m7412e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
                    }
                }
                AppMethodBeat.m2505o(46839);
                return;
            }
            C4990ab.m7412e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(length)));
            AppMethodBeat.m2505o(46839);
            return;
        }
        C4990ab.m7416i("MicroMsg.Orders", "parseDeductInfo json is null");
        AppMethodBeat.m2505o(46839);
    }

    /* renamed from: b */
    private static void m68763b(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46840);
        if (jSONObject != null) {
            try {
                orders.tAC = jSONObject.optInt("is_use_show_info", 0);
                C4990ab.m7417i("MicroMsg.Orders", "is_use_show_info: %s", Integer.valueOf(orders.tAC));
                JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    C4990ab.m7417i("MicroMsg.Orders", "showInfo size: %s", Integer.valueOf(optJSONArray.length()));
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
                            if (!C5046bo.isNullOrNil(showInfo.name) || !C5046bo.isNullOrNil(showInfo.value)) {
                                orders.tAE.add(showInfo);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(46840);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Orders", e, "parseShowInfo error", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(46840);
    }

    public String toString() {
        AppMethodBeat.m2504i(46841);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.czZ).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("token").append(this.token).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("num").append(this.ekv).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("totalFee").append(this.pTN).append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(46841);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> acx(String str) {
        AppMethodBeat.m2504i(46842);
        HashSet hashSet = new HashSet();
        if (!C5046bo.isNullOrNil(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        AppMethodBeat.m2505o(46842);
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(46843);
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
        this.tAn = Orders.acx(this.tAm);
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
        AppMethodBeat.m2505o(46843);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46844);
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
        AppMethodBeat.m2505o(46844);
    }

    static {
        AppMethodBeat.m2504i(46845);
        AppMethodBeat.m2505o(46845);
    }
}
