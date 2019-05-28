package com.tencent.p177mm.plugin.card.sharecard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p711c.C37848ee;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.protocal.protobuf.C44151oi;
import com.tencent.p177mm.protocal.protobuf.bzi;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo */
public class ShareCardInfo extends C37848ee implements Parcelable, C42837b {
    public static final Creator<ShareCardInfo> CREATOR = new C275901();
    protected static C4924a ccO;
    public String kbY = "";
    public C44151oi kcY;
    public C35938no kcZ;
    public bzi kda;
    public C23422od kdb;
    public boolean kdc = true;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo$1 */
    static class C275901 implements Creator<ShareCardInfo> {
        C275901() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareCardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(88040);
            ShareCardInfo shareCardInfo = new ShareCardInfo(parcel);
            AppMethodBeat.m2505o(88040);
            return shareCardInfo;
        }
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean aZD() {
        AppMethodBeat.m2504i(88041);
        if (aZV() == null || aZV().iAd != 10) {
            AppMethodBeat.m2505o(88041);
            return false;
        }
        AppMethodBeat.m2505o(88041);
        return true;
    }

    public final boolean aZE() {
        AppMethodBeat.m2504i(88042);
        if (aZV() == null || aZV().iAd != 0) {
            AppMethodBeat.m2505o(88042);
            return false;
        }
        AppMethodBeat.m2505o(88042);
        return true;
    }

    public final boolean aZF() {
        AppMethodBeat.m2504i(88043);
        if (aZV() == null || aZV().iAd != 20) {
            AppMethodBeat.m2505o(88043);
            return false;
        }
        AppMethodBeat.m2505o(88043);
        return true;
    }

    public final boolean aZG() {
        AppMethodBeat.m2504i(88044);
        if (aZV() == null || aZV().iAd != 11) {
            AppMethodBeat.m2505o(88044);
            return false;
        }
        AppMethodBeat.m2505o(88044);
        return true;
    }

    public final boolean aZH() {
        AppMethodBeat.m2504i(88045);
        if (aZV() == null || aZV().iAd != 30) {
            AppMethodBeat.m2505o(88045);
            return false;
        }
        AppMethodBeat.m2505o(88045);
        return true;
    }

    public final boolean aZI() {
        AppMethodBeat.m2504i(88046);
        boolean sP = C38736l.m65733sP(aZV().iAd);
        AppMethodBeat.m2505o(88046);
        return sP;
    }

    public final boolean aZJ() {
        AppMethodBeat.m2504i(88047);
        if ((aZV().vUd & 2) == 0) {
            AppMethodBeat.m2505o(88047);
            return true;
        }
        AppMethodBeat.m2505o(88047);
        return false;
    }

    public final boolean aZK() {
        AppMethodBeat.m2504i(88048);
        if ((aZV().vUd & 1) == 0) {
            AppMethodBeat.m2505o(88048);
            return true;
        }
        AppMethodBeat.m2505o(88048);
        return false;
    }

    public final boolean aZL() {
        AppMethodBeat.m2504i(88049);
        if ((aZV().vUg & 1) == 0) {
            AppMethodBeat.m2505o(88049);
            return true;
        }
        AppMethodBeat.m2505o(88049);
        return false;
    }

    public final boolean aZM() {
        AppMethodBeat.m2504i(88050);
        if ((aZV().vUg & 16) == 0) {
            AppMethodBeat.m2505o(88050);
            return true;
        }
        AppMethodBeat.m2505o(88050);
        return false;
    }

    public final boolean aZN() {
        AppMethodBeat.m2504i(88051);
        if ((aZV().vUg & 2) > 0) {
            AppMethodBeat.m2505o(88051);
            return true;
        }
        AppMethodBeat.m2505o(88051);
        return false;
    }

    public final boolean aZO() {
        return false;
    }

    public final boolean aZP() {
        AppMethodBeat.m2504i(88052);
        if ((aZV().vUg & 4) > 0) {
            AppMethodBeat.m2505o(88052);
            return true;
        }
        AppMethodBeat.m2505o(88052);
        return false;
    }

    public final boolean aZQ() {
        AppMethodBeat.m2504i(88053);
        if ((aZV().vUg & 8) > 0) {
            AppMethodBeat.m2505o(88053);
            return true;
        }
        AppMethodBeat.m2505o(88053);
        return false;
    }

    public final boolean isNormal() {
        return this.kcZ != null && this.kcZ.status == 0;
    }

    public final boolean isAcceptable() {
        AppMethodBeat.m2504i(88054);
        if (isNormal()) {
            if (this.kcY != null) {
                C4990ab.m7416i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            C4990ab.m7416i("MicroMsg.ShareCardInfo", "stock_num:" + this.kcZ.vSd + " limit_num:" + this.kcZ.vSe);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.m2505o(88054);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.m2505o(88054);
                return false;
            } else if (this.kcZ.vSd == 0 || this.kcZ.vSe == 0) {
                AppMethodBeat.m2505o(88054);
                return false;
            } else {
                AppMethodBeat.m2505o(88054);
                return false;
            }
        }
        AppMethodBeat.m2505o(88054);
        return false;
    }

    public final boolean aZS() {
        AppMethodBeat.m2504i(88055);
        if (isNormal()) {
            if (this.kcY != null) {
                C4990ab.m7416i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kcY.vUt);
            }
            C4990ab.m7416i("MicroMsg.ShareCardInfo", "avail_num:" + this.kcZ.vSa);
            if (this.kcY != null && this.kcY.vUt == 1) {
                AppMethodBeat.m2505o(88055);
                return true;
            } else if (this.kcZ.vSa > 0) {
                AppMethodBeat.m2505o(88055);
                return true;
            } else if (this.kcY != null && this.kcY.vUt == 0) {
                AppMethodBeat.m2505o(88055);
                return false;
            } else if (this.kcZ.vSa == 0) {
                AppMethodBeat.m2505o(88055);
                return false;
            } else {
                AppMethodBeat.m2505o(88055);
                return false;
            }
        }
        AppMethodBeat.m2505o(88055);
        return false;
    }

    public final boolean aZT() {
        AppMethodBeat.m2504i(88056);
        if (this.kcY == null || this.kcY.vUk == null || TextUtils.isEmpty(this.kcY.vUk.text)) {
            AppMethodBeat.m2505o(88056);
            return false;
        }
        C15368nz c15368nz = this.kcY.vUk;
        int currentTimeMillis = c15368nz.qsz - ((int) (System.currentTimeMillis() / 1000));
        if (c15368nz.qsz <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.m2505o(88056);
            return false;
        }
        AppMethodBeat.m2505o(88056);
        return true;
    }

    public final boolean aZU() {
        return this.kcY != null && this.kcY.vUx == 1;
    }

    public final C44151oi aZV() {
        AppMethodBeat.m2504i(88057);
        C44151oi c44151oi;
        if (this.kcY != null) {
            c44151oi = this.kcY;
            AppMethodBeat.m2505o(88057);
            return c44151oi;
        }
        try {
            this.kcY = (C44151oi) new C44151oi().parseFrom(this.field_cardTpInfoData);
            c44151oi = this.kcY;
            AppMethodBeat.m2505o(88057);
            return c44151oi;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            c44151oi = new C44151oi();
            AppMethodBeat.m2505o(88057);
            return c44151oi;
        }
    }

    /* renamed from: a */
    public final void mo45390a(C44151oi c44151oi) {
        AppMethodBeat.m2504i(88058);
        this.kcY = c44151oi;
        try {
            this.field_cardTpInfoData = c44151oi.toByteArray();
            AppMethodBeat.m2505o(88058);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(88058);
        }
    }

    public final C35938no aZW() {
        AppMethodBeat.m2504i(88059);
        C35938no c35938no;
        if (this.kcZ != null) {
            c35938no = this.kcZ;
            AppMethodBeat.m2505o(88059);
            return c35938no;
        }
        try {
            this.kcZ = (C35938no) new C35938no().parseFrom(this.field_dataInfoData);
            c35938no = this.kcZ;
            AppMethodBeat.m2505o(88059);
            return c35938no;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            c35938no = new C35938no();
            AppMethodBeat.m2505o(88059);
            return c35938no;
        }
    }

    /* renamed from: a */
    public final void mo45388a(C35938no c35938no) {
        AppMethodBeat.m2504i(88060);
        this.kcZ = c35938no;
        if (this.kcZ != null) {
            try {
                this.field_dataInfoData = c35938no.toByteArray();
                AppMethodBeat.m2505o(88060);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(88060);
    }

    public final bzi aZX() {
        AppMethodBeat.m2504i(88061);
        bzi bzi;
        if (this.kda != null) {
            bzi = this.kda;
            AppMethodBeat.m2505o(88061);
            return bzi;
        }
        try {
            this.kda = (bzi) new bzi().parseFrom(this.field_shareInfoData);
            bzi = this.kda;
            AppMethodBeat.m2505o(88061);
            return bzi;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            bzi = new bzi();
            AppMethodBeat.m2505o(88061);
            return bzi;
        }
    }

    /* renamed from: a */
    public final void mo45387a(bzi bzi) {
        AppMethodBeat.m2504i(88062);
        this.kda = bzi;
        try {
            this.field_shareInfoData = bzi.toByteArray();
            AppMethodBeat.m2505o(88062);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(88062);
        }
    }

    public final C23422od aZY() {
        AppMethodBeat.m2504i(88063);
        C23422od c23422od;
        if (this.kdb != null) {
            c23422od = this.kdb;
            AppMethodBeat.m2505o(88063);
            return c23422od;
        }
        try {
            this.kdb = (C23422od) new C23422od().parseFrom(this.field_shopInfoData);
            c23422od = this.kdb;
            AppMethodBeat.m2505o(88063);
            return c23422od;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(88063);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo45389a(C23422od c23422od) {
        AppMethodBeat.m2504i(88064);
        this.kdb = c23422od;
        try {
            this.field_shopInfoData = c23422od.toByteArray();
            AppMethodBeat.m2505o(88064);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(88064);
        }
    }

    public ShareCardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(88065);
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
        AppMethodBeat.m2505o(88065);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(88066);
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
        AppMethodBeat.m2505o(88066);
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
        AppMethodBeat.m2504i(88067);
        if (aZV() == null || aZV().vUn != 0) {
            AppMethodBeat.m2505o(88067);
            return false;
        }
        AppMethodBeat.m2505o(88067);
        return true;
    }

    public final boolean aZC() {
        AppMethodBeat.m2504i(88068);
        if (aZV() == null || aZV().vUn != 1) {
            AppMethodBeat.m2505o(88068);
            return false;
        }
        AppMethodBeat.m2505o(88068);
        return true;
    }

    /* renamed from: sN */
    public final String mo45426sN(int i) {
        AppMethodBeat.m2504i(88069);
        String str;
        if (i == 10) {
            str = (String) C42852am.bbb().getValue("key_share_card_local_city");
            AppMethodBeat.m2505o(88069);
            return str;
        } else if (i != 0) {
            str = "";
            AppMethodBeat.m2505o(88069);
            return str;
        } else if (C42856b.bbv()) {
            str = C4996ah.getResources().getString(C25738R.string.agt);
            AppMethodBeat.m2505o(88069);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(88069);
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
        AppMethodBeat.m2504i(88070);
        C4990ab.m7410d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.kbY);
        String str = this.kbY;
        AppMethodBeat.m2505o(88070);
        return str;
    }

    public final boolean aZR() {
        AppMethodBeat.m2504i(88071);
        if (aZV() == null || aZV().vUs != 1) {
            AppMethodBeat.m2505o(88071);
            return false;
        }
        AppMethodBeat.m2505o(88071);
        return true;
    }

    static {
        AppMethodBeat.m2504i(88072);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[19];
        c4924a.columns = new String[20];
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
        c4924a.columns[3] = "consumer";
        c4924a.xDd.put("consumer", "TEXT");
        stringBuilder.append(" consumer TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "app_id";
        c4924a.xDd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "share_time";
        c4924a.xDd.put("share_time", "LONG");
        stringBuilder.append(" share_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "local_updateTime";
        c4924a.xDd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "begin_time";
        c4924a.xDd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = "end_time";
        c4924a.xDd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "updateSeq";
        c4924a.xDd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "block_mask";
        c4924a.xDd.put("block_mask", "LONG");
        stringBuilder.append(" block_mask LONG");
        stringBuilder.append(", ");
        c4924a.columns[13] = "dataInfoData";
        c4924a.xDd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[14] = "cardTpInfoData";
        c4924a.xDd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[15] = "shareInfoData";
        c4924a.xDd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[16] = "shopInfoData";
        c4924a.xDd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[17] = "categoryType";
        c4924a.xDd.put("categoryType", "INTEGER default '0' ");
        stringBuilder.append(" categoryType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "itemIndex";
        c4924a.xDd.put("itemIndex", "INTEGER default '0' ");
        stringBuilder.append(" itemIndex INTEGER default '0' ");
        c4924a.columns[19] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(88072);
    }
}
