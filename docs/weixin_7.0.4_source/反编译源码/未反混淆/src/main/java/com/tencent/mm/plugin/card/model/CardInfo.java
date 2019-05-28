package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ew;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class CardInfo extends ew implements Parcelable, b {
    public static final Creator<CardInfo> CREATOR = new Creator<CardInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(87791);
            CardInfo cardInfo = new CardInfo(parcel);
            AppMethodBeat.o(87791);
            return cardInfo;
        }
    };
    protected static a ccO;
    public String kbY;
    public oi kcY;
    public no kcZ;
    public bzi kda;
    public od kdb;
    public boolean kdc;

    public CardInfo() {
        this.kdc = true;
        this.kbY = "";
        this.field_card_type = -1;
    }

    public final a Ag() {
        return ccO;
    }

    public final boolean aZD() {
        AppMethodBeat.i(87792);
        if (aZV() == null || aZV().iAd != 10) {
            AppMethodBeat.o(87792);
            return false;
        }
        AppMethodBeat.o(87792);
        return true;
    }

    public final boolean aZE() {
        AppMethodBeat.i(87793);
        if (aZV() == null || aZV().iAd != 0) {
            AppMethodBeat.o(87793);
            return false;
        }
        AppMethodBeat.o(87793);
        return true;
    }

    public final boolean aZF() {
        AppMethodBeat.i(87794);
        if (aZV() == null || aZV().iAd != 20) {
            AppMethodBeat.o(87794);
            return false;
        }
        AppMethodBeat.o(87794);
        return true;
    }

    public final boolean aZG() {
        AppMethodBeat.i(87795);
        if (aZV() == null || aZV().iAd != 11) {
            AppMethodBeat.o(87795);
            return false;
        }
        AppMethodBeat.o(87795);
        return true;
    }

    public final boolean aZH() {
        AppMethodBeat.i(87796);
        if (aZV() == null || aZV().iAd != 30) {
            AppMethodBeat.o(87796);
            return false;
        }
        AppMethodBeat.o(87796);
        return true;
    }

    public final boolean aZI() {
        AppMethodBeat.i(87797);
        boolean sP = l.sP(aZV().iAd);
        AppMethodBeat.o(87797);
        return sP;
    }

    public final boolean aZJ() {
        AppMethodBeat.i(87798);
        if ((aZV().vUd & 2) == 0) {
            AppMethodBeat.o(87798);
            return true;
        }
        AppMethodBeat.o(87798);
        return false;
    }

    public final boolean aZK() {
        AppMethodBeat.i(87799);
        if ((aZV().vUd & 1) == 0) {
            AppMethodBeat.o(87799);
            return true;
        }
        AppMethodBeat.o(87799);
        return false;
    }

    public final boolean aZL() {
        AppMethodBeat.i(87800);
        if ((aZV().vUg & 1) == 0) {
            AppMethodBeat.o(87800);
            return true;
        }
        AppMethodBeat.o(87800);
        return false;
    }

    public final boolean aZM() {
        AppMethodBeat.i(87801);
        if ((aZV().vUg & 16) == 0) {
            AppMethodBeat.o(87801);
            return true;
        }
        AppMethodBeat.o(87801);
        return false;
    }

    public final boolean aZN() {
        AppMethodBeat.i(87802);
        if ((aZV().vUg & 2) > 0) {
            AppMethodBeat.o(87802);
            return true;
        }
        AppMethodBeat.o(87802);
        return false;
    }

    public final boolean aZO() {
        AppMethodBeat.i(87803);
        if ((aZV().vUg & 32) > 0) {
            AppMethodBeat.o(87803);
            return true;
        }
        AppMethodBeat.o(87803);
        return false;
    }

    public final boolean aZP() {
        AppMethodBeat.i(87804);
        if ((aZV().vUg & 4) > 0) {
            AppMethodBeat.o(87804);
            return true;
        }
        AppMethodBeat.o(87804);
        return false;
    }

    public final boolean aZQ() {
        AppMethodBeat.i(87805);
        if ((aZV().vUg & 8) > 0) {
            AppMethodBeat.o(87805);
            return true;
        }
        AppMethodBeat.o(87805);
        return false;
    }

    public final boolean isNormal() {
        return this.kcZ != null && this.kcZ.status == 0;
    }

    public final boolean isAcceptable() {
        AppMethodBeat.i(87806);
        if (isNormal()) {
            if (this.kcY != null) {
                ab.i("MicroMsg.CardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            ab.i("MicroMsg.CardInfo", "stock_num:" + this.kcZ.vSd + " limit_num:" + this.kcZ.vSe);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.o(87806);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.o(87806);
                return false;
            } else if (this.kcZ.vSd == 0 || this.kcZ.vSe == 0) {
                AppMethodBeat.o(87806);
                return false;
            } else {
                AppMethodBeat.o(87806);
                return false;
            }
        }
        AppMethodBeat.o(87806);
        return false;
    }

    public final boolean aZS() {
        AppMethodBeat.i(87807);
        if (isNormal()) {
            if (this.kcY != null) {
                ab.i("MicroMsg.CardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            ab.i("MicroMsg.CardInfo", "avail_num:" + this.kcZ.vSa);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.o(87807);
                return true;
            } else if (this.kcZ.vSa > 0) {
                AppMethodBeat.o(87807);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.o(87807);
                return false;
            } else if (this.kcZ.vSa == 0) {
                AppMethodBeat.o(87807);
                return false;
            } else {
                AppMethodBeat.o(87807);
                return false;
            }
        }
        AppMethodBeat.o(87807);
        return false;
    }

    public final boolean aZT() {
        AppMethodBeat.i(87808);
        if (this.kcY == null || this.kcY.vUk == null || TextUtils.isEmpty(this.kcY.vUk.text)) {
            AppMethodBeat.o(87808);
            return false;
        }
        nz nzVar = this.kcY.vUk;
        int currentTimeMillis = nzVar.qsz - ((int) (System.currentTimeMillis() / 1000));
        if (nzVar.qsz <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.o(87808);
            return false;
        }
        AppMethodBeat.o(87808);
        return true;
    }

    public final boolean aZU() {
        return this.kcY != null && this.kcY.vUx == 1;
    }

    public final oi aZV() {
        AppMethodBeat.i(87809);
        oi oiVar;
        if (this.kcY != null) {
            oiVar = this.kcY;
            AppMethodBeat.o(87809);
            return oiVar;
        }
        try {
            if (this.field_cardTpInfoData != null) {
                this.kcY = (oi) new oi().parseFrom(this.field_cardTpInfoData);
                oiVar = this.kcY;
                AppMethodBeat.o(87809);
                return oiVar;
            }
            oiVar = new oi();
            AppMethodBeat.o(87809);
            return oiVar;
        } catch (Exception e) {
            ab.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            oiVar = new oi();
            AppMethodBeat.o(87809);
            return oiVar;
        }
    }

    public final void a(oi oiVar) {
        AppMethodBeat.i(87810);
        this.kcY = oiVar;
        if (oiVar != null) {
            try {
                this.field_cardTpInfoData = oiVar.toByteArray();
            } catch (Exception e) {
                ab.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
                AppMethodBeat.o(87810);
                return;
            }
        }
        AppMethodBeat.o(87810);
    }

    public final no aZW() {
        AppMethodBeat.i(87811);
        no noVar;
        if (this.kcZ != null) {
            noVar = this.kcZ;
            AppMethodBeat.o(87811);
            return noVar;
        }
        try {
            if (this.field_dataInfoData != null) {
                this.kcZ = (no) new no().parseFrom(this.field_dataInfoData);
                noVar = this.kcZ;
                AppMethodBeat.o(87811);
                return noVar;
            }
            noVar = new no();
            AppMethodBeat.o(87811);
            return noVar;
        } catch (Exception e) {
            ab.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            noVar = new no();
            AppMethodBeat.o(87811);
            return noVar;
        }
    }

    public final void a(no noVar) {
        AppMethodBeat.i(87812);
        this.kcZ = noVar;
        if (this.kcZ != null) {
            this.field_status = this.kcZ.status;
            if (noVar != null) {
                try {
                    this.field_dataInfoData = noVar.toByteArray();
                } catch (Exception e) {
                    ab.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(87812);
            return;
        }
        AppMethodBeat.o(87812);
    }

    public final bzi aZX() {
        AppMethodBeat.i(87813);
        bzi bzi;
        if (this.kda != null) {
            bzi = this.kda;
            AppMethodBeat.o(87813);
            return bzi;
        }
        try {
            if (this.field_shareInfoData != null) {
                this.kda = (bzi) new bzi().parseFrom(this.field_shareInfoData);
                bzi = this.kda;
                AppMethodBeat.o(87813);
                return bzi;
            }
            bzi = new bzi();
            AppMethodBeat.o(87813);
            return bzi;
        } catch (Exception e) {
            ab.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            bzi = new bzi();
            AppMethodBeat.o(87813);
            return bzi;
        }
    }

    public final void a(bzi bzi) {
        AppMethodBeat.i(87814);
        this.kda = bzi;
        if (bzi != null) {
            try {
                this.field_shareInfoData = bzi.toByteArray();
            } catch (Exception e) {
                ab.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                AppMethodBeat.o(87814);
                return;
            }
        }
        AppMethodBeat.o(87814);
    }

    public final od aZY() {
        AppMethodBeat.i(87815);
        od odVar;
        if (this.kdb != null) {
            odVar = this.kdb;
            AppMethodBeat.o(87815);
            return odVar;
        }
        try {
            if (this.field_shopInfoData != null) {
                this.kdb = (od) new od().parseFrom(this.field_shopInfoData);
                odVar = this.kdb;
                AppMethodBeat.o(87815);
                return odVar;
            }
            AppMethodBeat.o(87815);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            AppMethodBeat.o(87815);
            return null;
        }
    }

    public final void a(od odVar) {
        AppMethodBeat.i(87816);
        this.kdb = odVar;
        if (odVar != null) {
            try {
                this.field_shopInfoData = odVar.toByteArray();
            } catch (Exception e) {
                ab.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                AppMethodBeat.o(87816);
                return;
            }
        }
        AppMethodBeat.o(87816);
    }

    public CardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(87817);
        this.kdc = true;
        this.kbY = "";
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_delete_state_flag = parcel.readInt();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_create_time = parcel.readLong();
        this.field_begin_time = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_block_mask = parcel.readString();
        this.field_stickyIndex = parcel.readInt();
        this.field_stickyEndTime = parcel.readInt();
        this.field_stickyAnnouncement = parcel.readString();
        this.field_card_type = parcel.readInt();
        this.field_label_wording = parcel.readString();
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
        AppMethodBeat.o(87817);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(87818);
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_delete_state_flag);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_create_time);
        parcel.writeLong(this.field_begin_time);
        parcel.writeLong(this.field_end_time);
        parcel.writeString(this.field_block_mask);
        parcel.writeInt(this.field_stickyIndex);
        parcel.writeInt(this.field_stickyEndTime);
        parcel.writeString(this.field_stickyAnnouncement);
        parcel.writeInt(this.field_card_type);
        parcel.writeString(this.field_label_wording);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
            AppMethodBeat.o(87818);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(87818);
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
        AppMethodBeat.i(87819);
        if (aZV() == null || aZV().vUn != 0) {
            AppMethodBeat.o(87819);
            return false;
        }
        AppMethodBeat.o(87819);
        return true;
    }

    public final boolean aZC() {
        AppMethodBeat.i(87820);
        if (aZV() == null || aZV().vUn != 1) {
            AppMethodBeat.o(87820);
            return false;
        }
        AppMethodBeat.o(87820);
        return true;
    }

    public final String sN(int i) {
        return null;
    }

    public final String bad() {
        return null;
    }

    public final int bae() {
        return 0;
    }

    public final String baf() {
        AppMethodBeat.i(87821);
        ab.d("MicroMsg.CardInfo", "encrypt_code:" + this.kbY);
        String str = this.kbY;
        AppMethodBeat.o(87821);
        return str;
    }

    public final boolean aZR() {
        AppMethodBeat.i(87822);
        if (aZV() == null || aZV().vUs != 1) {
            AppMethodBeat.o(87822);
            return false;
        }
        AppMethodBeat.o(87822);
        return true;
    }

    static {
        AppMethodBeat.i(87823);
        a aVar = new a();
        aVar.xDb = new Field[22];
        aVar.columns = new String[23];
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
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "delete_state_flag";
        aVar.xDd.put("delete_state_flag", "INTEGER");
        stringBuilder.append(" delete_state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "local_updateTime";
        aVar.xDd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateSeq";
        aVar.xDd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "create_time";
        aVar.xDd.put("create_time", "LONG");
        stringBuilder.append(" create_time LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "begin_time";
        aVar.xDd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "end_time";
        aVar.xDd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "block_mask";
        aVar.xDd.put("block_mask", "TEXT");
        stringBuilder.append(" block_mask TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "dataInfoData";
        aVar.xDd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "cardTpInfoData";
        aVar.xDd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "shareInfoData";
        aVar.xDd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "shopInfoData";
        aVar.xDd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "stickyIndex";
        aVar.xDd.put("stickyIndex", "INTEGER");
        stringBuilder.append(" stickyIndex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "stickyEndTime";
        aVar.xDd.put("stickyEndTime", "INTEGER");
        stringBuilder.append(" stickyEndTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "stickyAnnouncement";
        aVar.xDd.put("stickyAnnouncement", "TEXT");
        stringBuilder.append(" stickyAnnouncement TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "card_type";
        aVar.xDd.put("card_type", "INTEGER default '-1' ");
        stringBuilder.append(" card_type INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "label_wording";
        aVar.xDd.put("label_wording", "TEXT");
        stringBuilder.append(" label_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "is_dynamic";
        aVar.xDd.put("is_dynamic", "INTEGER");
        stringBuilder.append(" is_dynamic INTEGER");
        aVar.columns[22] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(87823);
    }
}
