package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class Bankcard extends fb implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46702);
            Bankcard bankcard = new Bankcard(parcel);
            AppMethodBeat.o(46702);
            return bankcard;
        }
    };
    public static a ccO;
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
    public e txc;
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

    static {
        AppMethodBeat.i(46714);
        a aVar = new a();
        aVar.xDb = new Field[40];
        aVar.columns = new String[41];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bindSerial";
        aVar.xDd.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "bindSerial";
        aVar.columns[1] = "cardType";
        aVar.xDd.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "bankcardState";
        aVar.xDd.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "forbidWord";
        aVar.xDd.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bankName";
        aVar.xDd.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "bankcardType";
        aVar.xDd.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bankcardTypeName";
        aVar.xDd.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bankcardTag";
        aVar.xDd.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "bankcardTail";
        aVar.xDd.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "supportTag";
        aVar.xDd.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "mobile";
        aVar.xDd.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "trueName";
        aVar.xDd.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "desc";
        aVar.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bankPhone";
        aVar.xDd.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bizUsername";
        aVar.xDd.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "onceQuotaKind";
        aVar.xDd.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[16] = "onceQuotaVirtual";
        aVar.xDd.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[17] = "dayQuotaKind";
        aVar.xDd.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[18] = "dayQuotaVirtual";
        aVar.xDd.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[19] = "fetchArriveTime";
        aVar.xDd.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[20] = "fetchArriveTimeWording";
        aVar.xDd.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "repay_url";
        aVar.xDd.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "wxcreditState";
        aVar.xDd.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "bankcardClientType";
        aVar.xDd.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "ext_msg";
        aVar.xDd.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "support_micropay";
        aVar.xDd.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "arrive_type";
        aVar.xDd.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "avail_save_wording";
        aVar.xDd.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[28] = "fetch_charge_rate";
        aVar.xDd.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[29] = "full_fetch_charge_fee";
        aVar.xDd.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[30] = "fetch_charge_info";
        aVar.xDd.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tips";
        aVar.xDd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "forbid_title";
        aVar.xDd.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "forbid_url";
        aVar.xDd.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "no_micro_word";
        aVar.xDd.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "card_bottom_wording";
        aVar.xDd.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "support_lqt_turn_in";
        aVar.xDd.put("support_lqt_turn_in", "INTEGER");
        stringBuilder.append(" support_lqt_turn_in INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "support_lqt_turn_out";
        aVar.xDd.put("support_lqt_turn_out", "INTEGER");
        stringBuilder.append(" support_lqt_turn_out INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "is_hightlight_pre_arrive_time_wording";
        aVar.xDd.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        stringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        stringBuilder.append(", ");
        aVar.columns[39] = "card_state_name";
        aVar.xDd.put("card_state_name", "TEXT");
        stringBuilder.append(" card_state_name TEXT");
        aVar.columns[40] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46714);
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

    public static boolean gh(int i, int i2) {
        AppMethodBeat.i(46703);
        ab.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        if ((i & i2) > 0) {
            AppMethodBeat.o(46703);
            return true;
        }
        AppMethodBeat.o(46703);
        return false;
    }

    public static boolean Ho(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        AppMethodBeat.i(46704);
        if (this.field_bankcardState != 0) {
            ab.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            int i2 = this.field_bankcardState;
            AppMethodBeat.o(46704);
            return i2;
        } else if (orders != null && orders.czZ.equals(this.twR)) {
            AppMethodBeat.o(46704);
            return 4;
        } else if (isSupport(i)) {
            if (orders == null || orders.tAn.isEmpty() || orders.tAn.contains(this.field_bankcardType)) {
                AppMethodBeat.o(46704);
                return 0;
            }
            AppMethodBeat.o(46704);
            return 7;
        } else if (cPf()) {
            AppMethodBeat.o(46704);
            return 5;
        } else {
            AppMethodBeat.o(46704);
            return 6;
        }
    }

    public static String Y(Context context, int i) {
        AppMethodBeat.i(46705);
        String string;
        switch (i) {
            case 1:
                string = context.getString(R.string.fo0);
                AppMethodBeat.o(46705);
                return string;
            case 2:
                string = context.getString(R.string.fo6);
                AppMethodBeat.o(46705);
                return string;
            case 3:
                string = context.getString(R.string.foa);
                AppMethodBeat.o(46705);
                return string;
            case 4:
                string = context.getString(R.string.fo2);
                AppMethodBeat.o(46705);
                return string;
            case 5:
                string = context.getString(R.string.fny);
                AppMethodBeat.o(46705);
                return string;
            case 6:
                string = context.getString(R.string.fo4);
                AppMethodBeat.o(46705);
                return string;
            case 7:
                string = context.getString(R.string.fo9);
                AppMethodBeat.o(46705);
                return string;
            default:
                string = context.getString(R.string.fo7);
                AppMethodBeat.o(46705);
                return string;
        }
    }

    public final boolean cPb() {
        AppMethodBeat.i(46706);
        boolean z = (this.field_cardType & twH) > 0;
        ab.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(46706);
        return z;
    }

    public final boolean cPc() {
        AppMethodBeat.i(46707);
        boolean z = (this.field_cardType & twI) > 0;
        ab.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(46707);
        return z;
    }

    public final boolean cPd() {
        AppMethodBeat.i(46708);
        boolean z = (this.field_cardType & twL) > 0;
        ab.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(46708);
        return z;
    }

    public final boolean cPe() {
        AppMethodBeat.i(46709);
        boolean z = (this.field_cardType & twG) > 0;
        ab.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(46709);
        return z;
    }

    public final boolean cPf() {
        AppMethodBeat.i(46710);
        boolean z = (this.field_cardType & twF) <= 0;
        ab.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(46710);
        return z;
    }

    public final boolean cPg() {
        return (this.field_cardType & twM) > 0;
    }

    public final a Ag() {
        return ccO;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(46711);
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
        AppMethodBeat.o(46711);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.i(46712);
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
        AppMethodBeat.o(46712);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(46713);
        super.d(cursor);
        AppMethodBeat.o(46713);
    }
}
