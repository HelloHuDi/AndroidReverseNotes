package com.tencent.p177mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p711c.C45399fb;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.Bankcard */
public class Bankcard extends C45399fb implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new C225731();
    public static C4924a ccO;
    public static int twF = 1;
    public static int twG = 2;
    public static int twH = 4;
    public static int twI = 8;
    public static int twJ = 16;
    public static int twK = 32;
    public static int twL = 64;
    public static int twM = 128;
    public String twN;
    public String twO;
    public String twP;
    public String twQ;
    public String twR;
    public double twS;
    public String twT;
    public double twU;
    public String twV;
    public String twW;
    public String twX;
    public String twY;
    public String twZ;
    public int twf;
    public String twh;
    public String txa;
    public boolean txb;
    public C43807e txc;
    public long txd;
    public long txe;
    public long txf;
    public String txg;
    public int txh;
    public int txi;
    public String txj;
    public String txk;
    public int txl;
    public String txm;
    public long txn;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Bankcard$1 */
    static class C225731 implements Creator<Bankcard> {
        C225731() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46702);
            Bankcard bankcard = new Bankcard(parcel);
            AppMethodBeat.m2505o(46702);
            return bankcard;
        }
    }

    static {
        AppMethodBeat.m2504i(46714);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[40];
        c4924a.columns = new String[41];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "bindSerial";
        c4924a.xDd.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "bindSerial";
        c4924a.columns[1] = "cardType";
        c4924a.xDd.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "bankcardState";
        c4924a.xDd.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "forbidWord";
        c4924a.xDd.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "bankName";
        c4924a.xDd.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "bankcardType";
        c4924a.xDd.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "bankcardTypeName";
        c4924a.xDd.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "bankcardTag";
        c4924a.xDd.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "bankcardTail";
        c4924a.xDd.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "supportTag";
        c4924a.xDd.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "mobile";
        c4924a.xDd.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "trueName";
        c4924a.xDd.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "desc";
        c4924a.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "bankPhone";
        c4924a.xDd.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "bizUsername";
        c4924a.xDd.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "onceQuotaKind";
        c4924a.xDd.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[16] = "onceQuotaVirtual";
        c4924a.xDd.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[17] = "dayQuotaKind";
        c4924a.xDd.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[18] = "dayQuotaVirtual";
        c4924a.xDd.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[19] = "fetchArriveTime";
        c4924a.xDd.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[20] = "fetchArriveTimeWording";
        c4924a.xDd.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[21] = "repay_url";
        c4924a.xDd.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[22] = "wxcreditState";
        c4924a.xDd.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[23] = "bankcardClientType";
        c4924a.xDd.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[24] = "ext_msg";
        c4924a.xDd.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        c4924a.columns[25] = "support_micropay";
        c4924a.xDd.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[26] = "arrive_type";
        c4924a.xDd.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        c4924a.columns[27] = "avail_save_wording";
        c4924a.xDd.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[28] = "fetch_charge_rate";
        c4924a.xDd.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[29] = "full_fetch_charge_fee";
        c4924a.xDd.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        c4924a.columns[30] = "fetch_charge_info";
        c4924a.xDd.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        c4924a.columns[31] = "tips";
        c4924a.xDd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        c4924a.columns[32] = "forbid_title";
        c4924a.xDd.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[33] = "forbid_url";
        c4924a.xDd.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[34] = "no_micro_word";
        c4924a.xDd.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        c4924a.columns[35] = "card_bottom_wording";
        c4924a.xDd.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[36] = "support_lqt_turn_in";
        c4924a.xDd.put("support_lqt_turn_in", "INTEGER");
        stringBuilder.append(" support_lqt_turn_in INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[37] = "support_lqt_turn_out";
        c4924a.xDd.put("support_lqt_turn_out", "INTEGER");
        stringBuilder.append(" support_lqt_turn_out INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[38] = "is_hightlight_pre_arrive_time_wording";
        c4924a.xDd.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        stringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[39] = "card_state_name";
        c4924a.xDd.put("card_state_name", "TEXT");
        stringBuilder.append(" card_state_name TEXT");
        c4924a.columns[40] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46714);
    }

    public Bankcard() {
        this.twR = null;
        this.txa = null;
        this.txb = false;
    }

    public Bankcard(byte b) {
        this.twR = null;
        this.txa = null;
        this.txb = false;
        this.field_bankcardTag = 1;
    }

    private boolean isSupport(int i) {
        return (this.field_bankcardTag & i) > 0;
    }

    /* renamed from: gh */
    public static boolean m78503gh(int i, int i2) {
        AppMethodBeat.m2504i(46703);
        C4990ab.m7410d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        if ((i & i2) > 0) {
            AppMethodBeat.m2505o(46703);
            return true;
        }
        AppMethodBeat.m2505o(46703);
        return false;
    }

    /* renamed from: Ho */
    public static boolean m78501Ho(int i) {
        return (i & 2) > 0;
    }

    /* renamed from: a */
    public final int mo69481a(int i, Orders orders) {
        AppMethodBeat.m2504i(46704);
        if (this.field_bankcardState != 0) {
            C4990ab.m7410d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            int i2 = this.field_bankcardState;
            AppMethodBeat.m2505o(46704);
            return i2;
        } else if (orders != null && orders.czZ.equals(this.twR)) {
            AppMethodBeat.m2505o(46704);
            return 4;
        } else if (isSupport(i)) {
            if (orders == null || orders.tAn.isEmpty() || orders.tAn.contains(this.field_bankcardType)) {
                AppMethodBeat.m2505o(46704);
                return 0;
            }
            AppMethodBeat.m2505o(46704);
            return 7;
        } else if (cPf()) {
            AppMethodBeat.m2505o(46704);
            return 5;
        } else {
            AppMethodBeat.m2505o(46704);
            return 6;
        }
    }

    /* renamed from: Y */
    public static String m78502Y(Context context, int i) {
        AppMethodBeat.m2504i(46705);
        String string;
        switch (i) {
            case 1:
                string = context.getString(C25738R.string.fo0);
                AppMethodBeat.m2505o(46705);
                return string;
            case 2:
                string = context.getString(C25738R.string.fo6);
                AppMethodBeat.m2505o(46705);
                return string;
            case 3:
                string = context.getString(C25738R.string.foa);
                AppMethodBeat.m2505o(46705);
                return string;
            case 4:
                string = context.getString(C25738R.string.fo2);
                AppMethodBeat.m2505o(46705);
                return string;
            case 5:
                string = context.getString(C25738R.string.fny);
                AppMethodBeat.m2505o(46705);
                return string;
            case 6:
                string = context.getString(C25738R.string.fo4);
                AppMethodBeat.m2505o(46705);
                return string;
            case 7:
                string = context.getString(C25738R.string.fo9);
                AppMethodBeat.m2505o(46705);
                return string;
            default:
                string = context.getString(C25738R.string.fo7);
                AppMethodBeat.m2505o(46705);
                return string;
        }
    }

    public final boolean cPb() {
        AppMethodBeat.m2504i(46706);
        boolean z = (this.field_cardType & twH) > 0;
        C4990ab.m7410d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(46706);
        return z;
    }

    public final boolean cPc() {
        AppMethodBeat.m2504i(46707);
        boolean z = (this.field_cardType & twI) > 0;
        C4990ab.m7410d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(46707);
        return z;
    }

    public final boolean cPd() {
        AppMethodBeat.m2504i(46708);
        boolean z = (this.field_cardType & twL) > 0;
        C4990ab.m7410d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(46708);
        return z;
    }

    public final boolean cPe() {
        AppMethodBeat.m2504i(46709);
        boolean z = (this.field_cardType & twG) > 0;
        C4990ab.m7410d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(46709);
        return z;
    }

    public final boolean cPf() {
        AppMethodBeat.m2504i(46710);
        boolean z = (this.field_cardType & twF) <= 0;
        C4990ab.m7410d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(46710);
        return z;
    }

    public final boolean cPg() {
        return (this.field_cardType & twM) > 0;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(46711);
        this.twR = null;
        this.txa = null;
        this.txb = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.txb = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.twR = parcel.readString();
        this.twf = parcel.readInt();
        this.txa = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
        this.txg = parcel.readString();
        this.txd = parcel.readLong();
        this.txf = parcel.readLong();
        this.txe = parcel.readLong();
        this.txh = parcel.readInt();
        this.txl = parcel.readInt();
        this.txi = parcel.readInt();
        this.txj = parcel.readString();
        this.txk = parcel.readString();
        this.txm = parcel.readString();
        this.txn = parcel.readLong();
        AppMethodBeat.m2505o(46711);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(46712);
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.txb ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.twR);
        parcel.writeInt(this.twf);
        parcel.writeString(this.txa);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
        parcel.writeString(this.txg);
        parcel.writeLong(this.txd);
        parcel.writeLong(this.txf);
        parcel.writeLong(this.txe);
        parcel.writeInt(this.txh);
        parcel.writeInt(this.txl);
        parcel.writeInt(this.txi);
        parcel.writeString(this.txj);
        parcel.writeString(this.txk);
        parcel.writeString(this.txm);
        parcel.writeLong(this.txn);
        AppMethodBeat.m2505o(46712);
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(46713);
        super.mo8995d(cursor);
        AppMethodBeat.m2505o(46713);
    }
}
