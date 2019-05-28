package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public final class d extends ec {
    protected static a ccO;
    public int bJt;
    private SKBuiltinBuffer_t qrM;
    public int scene;

    public final a Ag() {
        return ccO;
    }

    public d() {
        this.bJt = -1;
        this.field_insertBatch = 2;
    }

    public d(bym bym) {
        AppMethodBeat.i(24428);
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
        this.field_regionCode = RegionCodeDecoder.aC(bym.guW, this.field_province, this.field_city);
        AppMethodBeat.o(24428);
    }

    public final String getProvince() {
        AppMethodBeat.i(24429);
        if (!bo.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    RegionCodeDecoder.duj();
                    this.field_province = RegionCodeDecoder.apR(split[0]);
                } else {
                    RegionCodeDecoder.duj();
                    this.field_province = RegionCodeDecoder.id(split[0], split[1]);
                }
            }
        }
        String str = this.field_province;
        AppMethodBeat.o(24429);
        return str;
    }

    public final String getCity() {
        AppMethodBeat.i(24430);
        if (!bo.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    RegionCodeDecoder.duj();
                    this.field_city = RegionCodeDecoder.aD(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    RegionCodeDecoder.duj();
                    this.field_city = RegionCodeDecoder.id(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        String str = this.field_city;
        AppMethodBeat.o(24430);
        return str;
    }

    private int cjx() {
        AppMethodBeat.i(24431);
        try {
            int intValue = Integer.valueOf(this.field_reserved4).intValue();
            AppMethodBeat.o(24431);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.o(24431);
            return 0;
        }
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(24432);
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
        AppMethodBeat.o(24432);
        return contentValues;
    }

    static {
        AppMethodBeat.i(24433);
        a aVar = new a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shakeItemID";
        aVar.xDd.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "shakeItemID";
        aVar.columns[1] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "province";
        aVar.xDd.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "city";
        aVar.xDd.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "signature";
        aVar.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "distance";
        aVar.xDd.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sex";
        aVar.xDd.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "imgstatus";
        aVar.xDd.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "hasHDImg";
        aVar.xDd.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "insertBatch";
        aVar.xDd.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved1";
        aVar.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved2";
        aVar.xDd.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "reserved3";
        aVar.xDd.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "reserved4";
        aVar.xDd.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "lvbuffer";
        aVar.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "regionCode";
        aVar.xDd.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "snsFlag";
        aVar.xDd.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "sns_bgurl";
        aVar.xDd.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(24433);
    }
}
