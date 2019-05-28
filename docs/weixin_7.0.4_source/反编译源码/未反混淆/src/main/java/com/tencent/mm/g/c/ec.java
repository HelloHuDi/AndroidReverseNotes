package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec extends c {
    private static final int dPG = "shakeItemID".hashCode();
    private static final int dPH = "province".hashCode();
    private static final int dPI = "city".hashCode();
    private static final int dPJ = "distance".hashCode();
    private static final int dPK = "sex".hashCode();
    private static final int dPL = "imgstatus".hashCode();
    private static final int dPM = "hasHDImg".hashCode();
    private static final int dPN = "insertBatch".hashCode();
    private static final int dPO = "regionCode".hashCode();
    private static final int dPP = "snsFlag".hashCode();
    private static final int dPQ = "sns_bgurl".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlj = "signature".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dqA = "lvbuffer".hashCode();
    private static final int dqk = "nickname".hashCode();
    private static final int dxt = "reserved1".hashCode();
    private static final int dxu = "reserved2".hashCode();
    private static final int dxv = "reserved3".hashCode();
    private static final int dxw = "reserved4".hashCode();
    private boolean dPA = true;
    private boolean dPB = true;
    private boolean dPC = true;
    private boolean dPD = true;
    private boolean dPE = true;
    private boolean dPF = true;
    private boolean dPv = true;
    private boolean dPw = true;
    private boolean dPx = true;
    private boolean dPy = true;
    private boolean dPz = true;
    private boolean djK = true;
    private boolean dkS = true;
    private boolean dlm = true;
    private boolean dqg = true;
    private boolean dqp = true;
    private boolean dwH = true;
    private boolean dwI = true;
    private boolean dwJ = true;
    private boolean dwK = true;
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dPG == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i);
                    this.dPv = true;
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dPH == hashCode) {
                    this.field_province = cursor.getString(i);
                } else if (dPI == hashCode) {
                    this.field_city = cursor.getString(i);
                } else if (dlj == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (dPJ == hashCode) {
                    this.field_distance = cursor.getString(i);
                } else if (dPK == hashCode) {
                    this.field_sex = cursor.getInt(i);
                } else if (dPL == hashCode) {
                    this.field_imgstatus = cursor.getInt(i);
                } else if (dPM == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i);
                } else if (dPN == hashCode) {
                    this.field_insertBatch = cursor.getInt(i);
                } else if (dxt == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (dxu == hashCode) {
                    this.field_reserved2 = cursor.getInt(i);
                } else if (dxv == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (dxw == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dqA == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (dPO == hashCode) {
                    this.field_regionCode = cursor.getString(i);
                } else if (dPP == hashCode) {
                    this.field_snsFlag = cursor.getInt(i);
                } else if (dPQ == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dPv) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.dPw) {
            contentValues.put("province", this.field_province);
        }
        if (this.dPx) {
            contentValues.put("city", this.field_city);
        }
        if (this.dkS) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.dPy) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.dPz) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.dPA) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.dPB) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.dPC) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.dwH) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.dwI) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.dwJ) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.dwK) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dqp) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.dPD) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.dPE) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.dPF) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
