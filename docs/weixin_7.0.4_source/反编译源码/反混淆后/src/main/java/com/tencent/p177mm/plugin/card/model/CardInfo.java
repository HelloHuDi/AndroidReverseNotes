package com.tencent.p177mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42118ew;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.protocal.protobuf.C44151oi;
import com.tencent.p177mm.protocal.protobuf.bzi;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.model.CardInfo */
public class CardInfo extends C42118ew implements Parcelable, C42837b {
    public static final Creator<CardInfo> CREATOR = new C457801();
    protected static C4924a ccO;
    public String kbY;
    public C44151oi kcY;
    public C35938no kcZ;
    public bzi kda;
    public C23422od kdb;
    public boolean kdc;

    /* renamed from: com.tencent.mm.plugin.card.model.CardInfo$1 */
    static class C457801 implements Creator<CardInfo> {
        C457801() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(87791);
            CardInfo cardInfo = new CardInfo(parcel);
            AppMethodBeat.m2505o(87791);
            return cardInfo;
        }
    }

    public CardInfo() {
        this.kdc = true;
        this.kbY = "";
        this.field_card_type = -1;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean aZD() {
        AppMethodBeat.m2504i(87792);
        if (aZV() == null || aZV().iAd != 10) {
            AppMethodBeat.m2505o(87792);
            return false;
        }
        AppMethodBeat.m2505o(87792);
        return true;
    }

    public final boolean aZE() {
        AppMethodBeat.m2504i(87793);
        if (aZV() == null || aZV().iAd != 0) {
            AppMethodBeat.m2505o(87793);
            return false;
        }
        AppMethodBeat.m2505o(87793);
        return true;
    }

    public final boolean aZF() {
        AppMethodBeat.m2504i(87794);
        if (aZV() == null || aZV().iAd != 20) {
            AppMethodBeat.m2505o(87794);
            return false;
        }
        AppMethodBeat.m2505o(87794);
        return true;
    }

    public final boolean aZG() {
        AppMethodBeat.m2504i(87795);
        if (aZV() == null || aZV().iAd != 11) {
            AppMethodBeat.m2505o(87795);
            return false;
        }
        AppMethodBeat.m2505o(87795);
        return true;
    }

    public final boolean aZH() {
        AppMethodBeat.m2504i(87796);
        if (aZV() == null || aZV().iAd != 30) {
            AppMethodBeat.m2505o(87796);
            return false;
        }
        AppMethodBeat.m2505o(87796);
        return true;
    }

    public final boolean aZI() {
        AppMethodBeat.m2504i(87797);
        boolean sP = C38736l.m65733sP(aZV().iAd);
        AppMethodBeat.m2505o(87797);
        return sP;
    }

    public final boolean aZJ() {
        AppMethodBeat.m2504i(87798);
        if ((aZV().vUd & 2) == 0) {
            AppMethodBeat.m2505o(87798);
            return true;
        }
        AppMethodBeat.m2505o(87798);
        return false;
    }

    public final boolean aZK() {
        AppMethodBeat.m2504i(87799);
        if ((aZV().vUd & 1) == 0) {
            AppMethodBeat.m2505o(87799);
            return true;
        }
        AppMethodBeat.m2505o(87799);
        return false;
    }

    public final boolean aZL() {
        AppMethodBeat.m2504i(87800);
        if ((aZV().vUg & 1) == 0) {
            AppMethodBeat.m2505o(87800);
            return true;
        }
        AppMethodBeat.m2505o(87800);
        return false;
    }

    public final boolean aZM() {
        AppMethodBeat.m2504i(87801);
        if ((aZV().vUg & 16) == 0) {
            AppMethodBeat.m2505o(87801);
            return true;
        }
        AppMethodBeat.m2505o(87801);
        return false;
    }

    public final boolean aZN() {
        AppMethodBeat.m2504i(87802);
        if ((aZV().vUg & 2) > 0) {
            AppMethodBeat.m2505o(87802);
            return true;
        }
        AppMethodBeat.m2505o(87802);
        return false;
    }

    public final boolean aZO() {
        AppMethodBeat.m2504i(87803);
        if ((aZV().vUg & 32) > 0) {
            AppMethodBeat.m2505o(87803);
            return true;
        }
        AppMethodBeat.m2505o(87803);
        return false;
    }

    public final boolean aZP() {
        AppMethodBeat.m2504i(87804);
        if ((aZV().vUg & 4) > 0) {
            AppMethodBeat.m2505o(87804);
            return true;
        }
        AppMethodBeat.m2505o(87804);
        return false;
    }

    public final boolean aZQ() {
        AppMethodBeat.m2504i(87805);
        if ((aZV().vUg & 8) > 0) {
            AppMethodBeat.m2505o(87805);
            return true;
        }
        AppMethodBeat.m2505o(87805);
        return false;
    }

    public final boolean isNormal() {
        return this.kcZ != null && this.kcZ.status == 0;
    }

    public final boolean isAcceptable() {
        AppMethodBeat.m2504i(87806);
        if (isNormal()) {
            if (this.kcY != null) {
                C4990ab.m7416i("MicroMsg.CardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            C4990ab.m7416i("MicroMsg.CardInfo", "stock_num:" + this.kcZ.vSd + " limit_num:" + this.kcZ.vSe);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.m2505o(87806);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.m2505o(87806);
                return false;
            } else if (this.kcZ.vSd == 0 || this.kcZ.vSe == 0) {
                AppMethodBeat.m2505o(87806);
                return false;
            } else {
                AppMethodBeat.m2505o(87806);
                return false;
            }
        }
        AppMethodBeat.m2505o(87806);
        return false;
    }

    public final boolean aZS() {
        AppMethodBeat.m2504i(87807);
        if (isNormal()) {
            if (this.kcY != null) {
                C4990ab.m7416i("MicroMsg.CardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            C4990ab.m7416i("MicroMsg.CardInfo", "avail_num:" + this.kcZ.vSa);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.m2505o(87807);
                return true;
            } else if (this.kcZ.vSa > 0) {
                AppMethodBeat.m2505o(87807);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.m2505o(87807);
                return false;
            } else if (this.kcZ.vSa == 0) {
                AppMethodBeat.m2505o(87807);
                return false;
            } else {
                AppMethodBeat.m2505o(87807);
                return false;
            }
        }
        AppMethodBeat.m2505o(87807);
        return false;
    }

    public final boolean aZT() {
        AppMethodBeat.m2504i(87808);
        if (this.kcY == null || this.kcY.vUk == null || TextUtils.isEmpty(this.kcY.vUk.text)) {
            AppMethodBeat.m2505o(87808);
            return false;
        }
        C15368nz c15368nz = this.kcY.vUk;
        int currentTimeMillis = c15368nz.qsz - ((int) (System.currentTimeMillis() / 1000));
        if (c15368nz.qsz <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.m2505o(87808);
            return false;
        }
        AppMethodBeat.m2505o(87808);
        return true;
    }

    public final boolean aZU() {
        return this.kcY != null && this.kcY.vUx == 1;
    }

    public final C44151oi aZV() {
        AppMethodBeat.m2504i(87809);
        C44151oi c44151oi;
        if (this.kcY != null) {
            c44151oi = this.kcY;
            AppMethodBeat.m2505o(87809);
            return c44151oi;
        }
        try {
            if (this.field_cardTpInfoData != null) {
                this.kcY = (C44151oi) new C44151oi().parseFrom(this.field_cardTpInfoData);
                c44151oi = this.kcY;
                AppMethodBeat.m2505o(87809);
                return c44151oi;
            }
            c44151oi = new C44151oi();
            AppMethodBeat.m2505o(87809);
            return c44151oi;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            c44151oi = new C44151oi();
            AppMethodBeat.m2505o(87809);
            return c44151oi;
        }
    }

    /* renamed from: a */
    public final void mo73581a(C44151oi c44151oi) {
        AppMethodBeat.m2504i(87810);
        this.kcY = c44151oi;
        if (c44151oi != null) {
            try {
                this.field_cardTpInfoData = c44151oi.toByteArray();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(87810);
                return;
            }
        }
        AppMethodBeat.m2505o(87810);
    }

    public final C35938no aZW() {
        AppMethodBeat.m2504i(87811);
        C35938no c35938no;
        if (this.kcZ != null) {
            c35938no = this.kcZ;
            AppMethodBeat.m2505o(87811);
            return c35938no;
        }
        try {
            if (this.field_dataInfoData != null) {
                this.kcZ = (C35938no) new C35938no().parseFrom(this.field_dataInfoData);
                c35938no = this.kcZ;
                AppMethodBeat.m2505o(87811);
                return c35938no;
            }
            c35938no = new C35938no();
            AppMethodBeat.m2505o(87811);
            return c35938no;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            c35938no = new C35938no();
            AppMethodBeat.m2505o(87811);
            return c35938no;
        }
    }

    /* renamed from: a */
    public final void mo45388a(C35938no c35938no) {
        AppMethodBeat.m2504i(87812);
        this.kcZ = c35938no;
        if (this.kcZ != null) {
            this.field_status = this.kcZ.status;
            if (c35938no != null) {
                try {
                    this.field_dataInfoData = c35938no.toByteArray();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(87812);
            return;
        }
        AppMethodBeat.m2505o(87812);
    }

    public final bzi aZX() {
        AppMethodBeat.m2504i(87813);
        bzi bzi;
        if (this.kda != null) {
            bzi = this.kda;
            AppMethodBeat.m2505o(87813);
            return bzi;
        }
        try {
            if (this.field_shareInfoData != null) {
                this.kda = (bzi) new bzi().parseFrom(this.field_shareInfoData);
                bzi = this.kda;
                AppMethodBeat.m2505o(87813);
                return bzi;
            }
            bzi = new bzi();
            AppMethodBeat.m2505o(87813);
            return bzi;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            bzi = new bzi();
            AppMethodBeat.m2505o(87813);
            return bzi;
        }
    }

    /* renamed from: a */
    public final void mo73580a(bzi bzi) {
        AppMethodBeat.m2504i(87814);
        this.kda = bzi;
        if (bzi != null) {
            try {
                this.field_shareInfoData = bzi.toByteArray();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                AppMethodBeat.m2505o(87814);
                return;
            }
        }
        AppMethodBeat.m2505o(87814);
    }

    public final C23422od aZY() {
        AppMethodBeat.m2504i(87815);
        C23422od c23422od;
        if (this.kdb != null) {
            c23422od = this.kdb;
            AppMethodBeat.m2505o(87815);
            return c23422od;
        }
        try {
            if (this.field_shopInfoData != null) {
                this.kdb = (C23422od) new C23422od().parseFrom(this.field_shopInfoData);
                c23422od = this.kdb;
                AppMethodBeat.m2505o(87815);
                return c23422od;
            }
            AppMethodBeat.m2505o(87815);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(87815);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo45389a(C23422od c23422od) {
        AppMethodBeat.m2504i(87816);
        this.kdb = c23422od;
        if (c23422od != null) {
            try {
                this.field_shopInfoData = c23422od.toByteArray();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
                AppMethodBeat.m2505o(87816);
                return;
            }
        }
        AppMethodBeat.m2505o(87816);
    }

    public CardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(87817);
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
        AppMethodBeat.m2505o(87817);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(87818);
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
            AppMethodBeat.m2505o(87818);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(87818);
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

    /* renamed from: Gi */
    public final void mo45386Gi(String str) {
        this.field_from_username = str;
    }

    public final long bac() {
        return this.field_local_updateTime;
    }

    public final boolean aZB() {
        AppMethodBeat.m2504i(87819);
        if (aZV() == null || aZV().vUn != 0) {
            AppMethodBeat.m2505o(87819);
            return false;
        }
        AppMethodBeat.m2505o(87819);
        return true;
    }

    public final boolean aZC() {
        AppMethodBeat.m2504i(87820);
        if (aZV() == null || aZV().vUn != 1) {
            AppMethodBeat.m2505o(87820);
            return false;
        }
        AppMethodBeat.m2505o(87820);
        return true;
    }

    /* renamed from: sN */
    public final String mo45426sN(int i) {
        return null;
    }

    public final String bad() {
        return null;
    }

    public final int bae() {
        return 0;
    }

    public final String baf() {
        AppMethodBeat.m2504i(87821);
        C4990ab.m7410d("MicroMsg.CardInfo", "encrypt_code:" + this.kbY);
        String str = this.kbY;
        AppMethodBeat.m2505o(87821);
        return str;
    }

    public final boolean aZR() {
        AppMethodBeat.m2504i(87822);
        if (aZV() == null || aZV().vUs != 1) {
            AppMethodBeat.m2505o(87822);
            return false;
        }
        AppMethodBeat.m2505o(87822);
        return true;
    }

    static {
        AppMethodBeat.m2504i(87823);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[22];
        c4924a.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "card_id";
        c4924a.xDd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "card_id";
        c4924a.columns[1] = "card_tp_id";
        c4924a.xDd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "from_username";
        c4924a.xDd.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "delete_state_flag";
        c4924a.xDd.put("delete_state_flag", "INTEGER");
        stringBuilder.append(" delete_state_flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "local_updateTime";
        c4924a.xDd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "updateSeq";
        c4924a.xDd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "create_time";
        c4924a.xDd.put("create_time", "LONG");
        stringBuilder.append(" create_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "begin_time";
        c4924a.xDd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = "end_time";
        c4924a.xDd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "block_mask";
        c4924a.xDd.put("block_mask", "TEXT");
        stringBuilder.append(" block_mask TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "dataInfoData";
        c4924a.xDd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[13] = "cardTpInfoData";
        c4924a.xDd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[14] = "shareInfoData";
        c4924a.xDd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[15] = "shopInfoData";
        c4924a.xDd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[16] = "stickyIndex";
        c4924a.xDd.put("stickyIndex", "INTEGER");
        stringBuilder.append(" stickyIndex INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "stickyEndTime";
        c4924a.xDd.put("stickyEndTime", "INTEGER");
        stringBuilder.append(" stickyEndTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[18] = "stickyAnnouncement";
        c4924a.xDd.put("stickyAnnouncement", "TEXT");
        stringBuilder.append(" stickyAnnouncement TEXT");
        stringBuilder.append(", ");
        c4924a.columns[19] = "card_type";
        c4924a.xDd.put("card_type", "INTEGER default '-1' ");
        stringBuilder.append(" card_type INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "label_wording";
        c4924a.xDd.put("label_wording", "TEXT");
        stringBuilder.append(" label_wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[21] = "is_dynamic";
        c4924a.xDd.put("is_dynamic", "INTEGER");
        stringBuilder.append(" is_dynamic INTEGER");
        c4924a.columns[22] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(87823);
    }
}
