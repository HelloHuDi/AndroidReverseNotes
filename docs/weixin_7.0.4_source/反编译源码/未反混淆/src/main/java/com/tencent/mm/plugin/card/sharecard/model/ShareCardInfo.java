package com.tencent.mm.plugin.card.sharecard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ee;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;

public class ShareCardInfo extends ee implements Parcelable, b {
    public static final Creator<ShareCardInfo> CREATOR = new Creator<ShareCardInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareCardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88040);
            ShareCardInfo shareCardInfo = new ShareCardInfo(parcel);
            AppMethodBeat.o(88040);
            return shareCardInfo;
        }
    };
    protected static a ccO;
    public String kbY = "";
    public oi kcY;
    public no kcZ;
    public bzi kda;
    public od kdb;
    public boolean kdc = true;

    public final a Ag() {
        return ccO;
    }

    public final boolean aZD() {
        AppMethodBeat.i(88041);
        if (aZV() == null || aZV().iAd != 10) {
            AppMethodBeat.o(88041);
            return false;
        }
        AppMethodBeat.o(88041);
        return true;
    }

    public final boolean aZE() {
        AppMethodBeat.i(88042);
        if (aZV() == null || aZV().iAd != 0) {
            AppMethodBeat.o(88042);
            return false;
        }
        AppMethodBeat.o(88042);
        return true;
    }

    public final boolean aZF() {
        AppMethodBeat.i(88043);
        if (aZV() == null || aZV().iAd != 20) {
            AppMethodBeat.o(88043);
            return false;
        }
        AppMethodBeat.o(88043);
        return true;
    }

    public final boolean aZG() {
        AppMethodBeat.i(88044);
        if (aZV() == null || aZV().iAd != 11) {
            AppMethodBeat.o(88044);
            return false;
        }
        AppMethodBeat.o(88044);
        return true;
    }

    public final boolean aZH() {
        AppMethodBeat.i(88045);
        if (aZV() == null || aZV().iAd != 30) {
            AppMethodBeat.o(88045);
            return false;
        }
        AppMethodBeat.o(88045);
        return true;
    }

    public final boolean aZI() {
        AppMethodBeat.i(88046);
        boolean sP = l.sP(aZV().iAd);
        AppMethodBeat.o(88046);
        return sP;
    }

    public final boolean aZJ() {
        AppMethodBeat.i(88047);
        if ((aZV().vUd & 2) == 0) {
            AppMethodBeat.o(88047);
            return true;
        }
        AppMethodBeat.o(88047);
        return false;
    }

    public final boolean aZK() {
        AppMethodBeat.i(88048);
        if ((aZV().vUd & 1) == 0) {
            AppMethodBeat.o(88048);
            return true;
        }
        AppMethodBeat.o(88048);
        return false;
    }

    public final boolean aZL() {
        AppMethodBeat.i(88049);
        if ((aZV().vUg & 1) == 0) {
            AppMethodBeat.o(88049);
            return true;
        }
        AppMethodBeat.o(88049);
        return false;
    }

    public final boolean aZM() {
        AppMethodBeat.i(88050);
        if ((aZV().vUg & 16) == 0) {
            AppMethodBeat.o(88050);
            return true;
        }
        AppMethodBeat.o(88050);
        return false;
    }

    public final boolean aZN() {
        AppMethodBeat.i(88051);
        if ((aZV().vUg & 2) > 0) {
            AppMethodBeat.o(88051);
            return true;
        }
        AppMethodBeat.o(88051);
        return false;
    }

    public final boolean aZO() {
        return false;
    }

    public final boolean aZP() {
        AppMethodBeat.i(88052);
        if ((aZV().vUg & 4) > 0) {
            AppMethodBeat.o(88052);
            return true;
        }
        AppMethodBeat.o(88052);
        return false;
    }

    public final boolean aZQ() {
        AppMethodBeat.i(88053);
        if ((aZV().vUg & 8) > 0) {
            AppMethodBeat.o(88053);
            return true;
        }
        AppMethodBeat.o(88053);
        return false;
    }

    public final boolean isNormal() {
        return this.kcZ != null && this.kcZ.status == 0;
    }

    public final boolean isAcceptable() {
        AppMethodBeat.i(88054);
        if (isNormal()) {
            if (this.kcY != null) {
                ab.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            ab.i("MicroMsg.ShareCardInfo", "stock_num:" + this.kcZ.vSd + " limit_num:" + this.kcZ.vSe);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.o(88054);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.o(88054);
                return false;
            } else if (this.kcZ.vSd == 0 || this.kcZ.vSe == 0) {
                AppMethodBeat.o(88054);
                return false;
            } else {
                AppMethodBeat.o(88054);
                return false;
            }
        }
        AppMethodBeat.o(88054);
        return false;
    }

    public final boolean aZS() {
        AppMethodBeat.i(88055);
        if (isNormal()) {
            if (this.kcY != null) {
                ab.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            ab.i("MicroMsg.ShareCardInfo", "avail_num:" + this.kcZ.vSa);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.o(88055);
                return true;
            } else if (this.kcZ.vSa > 0) {
                AppMethodBeat.o(88055);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.o(88055);
                return false;
            } else if (this.kcZ.vSa == 0) {
                AppMethodBeat.o(88055);
                return false;
            } else {
                AppMethodBeat.o(88055);
                return false;
            }
        }
        AppMethodBeat.o(88055);
        return false;
    }

    public final boolean aZT() {
        AppMethodBeat.i(88056);
        if (this.kcY == null || this.kcY.vUk == null || TextUtils.isEmpty(this.kcY.vUk.text)) {
            AppMethodBeat.o(88056);
            return false;
        }
        nz nzVar = this.kcY.vUk;
        int currentTimeMillis = nzVar.qsz - ((int) (System.currentTimeMillis() / 1000));
        if (nzVar.qsz <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.o(88056);
            return false;
        }
        AppMethodBeat.o(88056);
        return true;
    }

    public final boolean aZU() {
        return this.kcY != null && this.kcY.vUx == 1;
    }

    public final oi aZV() {
        AppMethodBeat.i(88057);
        oi oiVar;
        if (this.kcY != null) {
            oiVar = this.kcY;
            AppMethodBeat.o(88057);
            return oiVar;
        }
        try {
            this.kcY = (oi) new oi().parseFrom(this.field_cardTpInfoData);
            oiVar = this.kcY;
            AppMethodBeat.o(88057);
            return oiVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            oiVar = new oi();
            AppMethodBeat.o(88057);
            return oiVar;
        }
    }

    public final void a(oi oiVar) {
        AppMethodBeat.i(88058);
        this.kcY = oiVar;
        try {
            this.field_cardTpInfoData = oiVar.toByteArray();
            AppMethodBeat.o(88058);
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
            AppMethodBeat.o(88058);
        }
    }

    public final no aZW() {
        AppMethodBeat.i(88059);
        no noVar;
        if (this.kcZ != null) {
            noVar = this.kcZ;
            AppMethodBeat.o(88059);
            return noVar;
        }
        try {
            this.kcZ = (no) new no().parseFrom(this.field_dataInfoData);
            noVar = this.kcZ;
            AppMethodBeat.o(88059);
            return noVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            noVar = new no();
            AppMethodBeat.o(88059);
            return noVar;
        }
    }

    public final void a(no noVar) {
        AppMethodBeat.i(88060);
        this.kcZ = noVar;
        if (this.kcZ != null) {
            try {
                this.field_dataInfoData = noVar.toByteArray();
                AppMethodBeat.o(88060);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(88060);
    }

    public final bzi aZX() {
        AppMethodBeat.i(88061);
        bzi bzi;
        if (this.kda != null) {
            bzi = this.kda;
            AppMethodBeat.o(88061);
            return bzi;
        }
        try {
            this.kda = (bzi) new bzi().parseFrom(this.field_shareInfoData);
            bzi = this.kda;
            AppMethodBeat.o(88061);
            return bzi;
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            bzi = new bzi();
            AppMethodBeat.o(88061);
            return bzi;
        }
    }

    public final void a(bzi bzi) {
        AppMethodBeat.i(88062);
        this.kda = bzi;
        try {
            this.field_shareInfoData = bzi.toByteArray();
            AppMethodBeat.o(88062);
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.o(88062);
        }
    }

    public final od aZY() {
        AppMethodBeat.i(88063);
        od odVar;
        if (this.kdb != null) {
            odVar = this.kdb;
            AppMethodBeat.o(88063);
            return odVar;
        }
        try {
            this.kdb = (od) new od().parseFrom(this.field_shopInfoData);
            odVar = this.kdb;
            AppMethodBeat.o(88063);
            return odVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.o(88063);
            return null;
        }
    }

    public final void a(od odVar) {
        AppMethodBeat.i(88064);
        this.kdb = odVar;
        try {
            this.field_shopInfoData = odVar.toByteArray();
            AppMethodBeat.o(88064);
        } catch (Exception e) {
            ab.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.o(88064);
        }
    }

    public ShareCardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(88065);
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_share_time = parcel.readLong();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_block_mask = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_categoryType = parcel.readInt();
        this.field_itemIndex = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_dataInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_cardTpInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_cardTpInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_shareInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_shareInfoData[i] = parcel.readByte();
            }
        }
        i = parcel.readInt();
        if (i > 0) {
            this.field_shopInfoData = new byte[i];
            while (i2 < i) {
                this.field_shopInfoData[i2] = parcel.readByte();
                i2++;
            }
        }
        AppMethodBeat.o(88065);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(88066);
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeLong(this.field_share_time);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_block_mask);
        parcel.writeLong(this.field_end_time);
        parcel.writeInt(this.field_categoryType);
        parcel.writeInt(this.field_itemIndex);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
        }
        AppMethodBeat.o(88066);
    }

    public final long getEndTime() {
        return this.field_end_time;
    }

    public final String aZZ() {
        return this.field_card_id;
    }

    public final String baa() {
        return this.field_card_tp_id;
    }

    public final String bab() {
        return this.field_from_username;
    }

    public final void Gi(String str) {
        this.field_from_username = str;
    }

    public final long bac() {
        return this.field_local_updateTime;
    }

    public final boolean aZB() {
        AppMethodBeat.i(88067);
        if (aZV() == null || aZV().vUn != 0) {
            AppMethodBeat.o(88067);
            return false;
        }
        AppMethodBeat.o(88067);
        return true;
    }

    public final boolean aZC() {
        AppMethodBeat.i(88068);
        if (aZV() == null || aZV().vUn != 1) {
            AppMethodBeat.o(88068);
            return false;
        }
        AppMethodBeat.o(88068);
        return true;
    }

    public final String sN(int i) {
        AppMethodBeat.i(88069);
        String str;
        if (i == 10) {
            str = (String) am.bbb().getValue("key_share_card_local_city");
            AppMethodBeat.o(88069);
            return str;
        } else if (i != 0) {
            str = "";
            AppMethodBeat.o(88069);
            return str;
        } else if (com.tencent.mm.plugin.card.sharecard.a.b.bbv()) {
            str = ah.getResources().getString(R.string.agt);
            AppMethodBeat.o(88069);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(88069);
            return str;
        }
    }

    public final String bad() {
        return "";
    }

    public final int bae() {
        return this.field_categoryType;
    }

    public final String baf() {
        AppMethodBeat.i(88070);
        ab.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.kbY);
        String str = this.kbY;
        AppMethodBeat.o(88070);
        return str;
    }

    public final boolean aZR() {
        AppMethodBeat.i(88071);
        if (aZV() == null || aZV().vUs != 1) {
            AppMethodBeat.o(88071);
            return false;
        }
        AppMethodBeat.o(88071);
        return true;
    }

    static {
        AppMethodBeat.i(88072);
        a aVar = new a();
        aVar.xDb = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xDd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "card_id";
        aVar.columns[1] = "card_tp_id";
        aVar.xDd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "from_username";
        aVar.xDd.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "consumer";
        aVar.xDd.put("consumer", "TEXT");
        stringBuilder.append(" consumer TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "app_id";
        aVar.xDd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "share_time";
        aVar.xDd.put("share_time", "LONG");
        stringBuilder.append(" share_time LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "local_updateTime";
        aVar.xDd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "begin_time";
        aVar.xDd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "end_time";
        aVar.xDd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "updateSeq";
        aVar.xDd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "block_mask";
        aVar.xDd.put("block_mask", "LONG");
        stringBuilder.append(" block_mask LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "dataInfoData";
        aVar.xDd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "cardTpInfoData";
        aVar.xDd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "shareInfoData";
        aVar.xDd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "shopInfoData";
        aVar.xDd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "categoryType";
        aVar.xDd.put("categoryType", "INTEGER default '0' ");
        stringBuilder.append(" categoryType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "itemIndex";
        aVar.xDd.put("itemIndex", "INTEGER default '0' ");
        stringBuilder.append(" itemIndex INTEGER default '0' ");
        aVar.columns[19] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(88072);
    }
}
