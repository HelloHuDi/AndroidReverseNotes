package com.tencent.p177mm.plugin.shake.p1019b;

import android.content.ContentValues;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p711c.C45396ec;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bym;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.shake.b.d */
public final class C34894d extends C45396ec {
    protected static C4924a ccO;
    public int bJt;
    private SKBuiltinBuffer_t qrM;
    public int scene;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C34894d() {
        this.bJt = -1;
        this.field_insertBatch = 2;
    }

    public C34894d(bym bym) {
        AppMethodBeat.m2504i(24428);
        this.bJt = -1;
        this.field_username = bym.jBB;
        this.field_nickname = bym.jCH;
        this.field_signature = bym.guQ;
        this.field_distance = bym.wBS;
        this.field_reserved4 = String.valueOf(bym.wXK);
        this.field_sex = bym.guN;
        this.field_imgstatus = bym.vEE;
        this.field_hasHDImg = bym.wXI;
        this.field_reserved1 = bym.wBT;
        this.field_reserved3 = bym.wBU;
        this.field_insertBatch = 2;
        if (bym.wBZ != null) {
            this.field_snsFlag = bym.wBZ.guY;
            this.field_sns_bgurl = bym.wBZ.guZ;
        }
        this.qrM = bym.wXJ;
        this.field_province = bym.guO;
        this.field_city = bym.guP;
        this.field_regionCode = RegionCodeDecoder.m7796aC(bym.guW, this.field_province, this.field_city);
        AppMethodBeat.m2505o(24428);
    }

    public final String getProvince() {
        AppMethodBeat.m2504i(24429);
        if (!C5046bo.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    RegionCodeDecoder.duj();
                    this.field_province = RegionCodeDecoder.apR(split[0]);
                } else {
                    RegionCodeDecoder.duj();
                    this.field_province = RegionCodeDecoder.m7798id(split[0], split[1]);
                }
            }
        }
        String str = this.field_province;
        AppMethodBeat.m2505o(24429);
        return str;
    }

    public final String getCity() {
        AppMethodBeat.m2504i(24430);
        if (!C5046bo.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    RegionCodeDecoder.duj();
                    this.field_city = RegionCodeDecoder.m7797aD(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    RegionCodeDecoder.duj();
                    this.field_city = RegionCodeDecoder.m7798id(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        String str = this.field_city;
        AppMethodBeat.m2505o(24430);
        return str;
    }

    private int cjx() {
        AppMethodBeat.m2504i(24431);
        try {
            int intValue = Integer.valueOf(this.field_reserved4).intValue();
            AppMethodBeat.m2505o(24431);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(24431);
            return 0;
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        AppMethodBeat.m2504i(24432);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.bJt & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(cjx()));
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if ((this.bJt & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.bJt & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        AppMethodBeat.m2505o(24432);
        return contentValues;
    }

    static {
        AppMethodBeat.m2504i(24433);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "shakeItemID";
        c4924a.xDd.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "shakeItemID";
        c4924a.columns[1] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "nickname";
        c4924a.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "province";
        c4924a.xDd.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "city";
        c4924a.xDd.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "signature";
        c4924a.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "distance";
        c4924a.xDd.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "sex";
        c4924a.xDd.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "imgstatus";
        c4924a.xDd.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "hasHDImg";
        c4924a.xDd.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "insertBatch";
        c4924a.xDd.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "reserved1";
        c4924a.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "reserved2";
        c4924a.xDd.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[13] = "reserved3";
        c4924a.xDd.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "reserved4";
        c4924a.xDd.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[16] = "lvbuffer";
        c4924a.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        c4924a.columns[17] = "regionCode";
        c4924a.xDd.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "snsFlag";
        c4924a.xDd.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[19] = "sns_bgurl";
        c4924a.xDd.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(24433);
    }
}
