package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek extends c {
    private static final int dRA = "bgId".hashCode();
    private static final int dRB = "bgUrl".hashCode();
    private static final int dRC = "older_bgId".hashCode();
    private static final int dRD = "local_flag".hashCode();
    private static final int dRE = "istyle".hashCode();
    private static final int dRF = "iFlag".hashCode();
    private static final int dRG = "icount".hashCode();
    private static final int dRH = "faultS".hashCode();
    private static final int dRI = "snsBgId".hashCode();
    private static final int dRJ = "snsuser".hashCode();
    private static final int dRK = "adsession".hashCode();
    private static final int dRL = "lastFirstPageRequestErrCode".hashCode();
    private static final int dRM = "lastFirstPageRequestErrType".hashCode();
    private static final int dRz = "newerIds".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dRl = true;
    private boolean dRm = true;
    private boolean dRn = true;
    private boolean dRo = true;
    private boolean dRp = true;
    private boolean dRq = true;
    private boolean dRr = true;
    private boolean dRs = true;
    private boolean dRt = true;
    private boolean dRu = true;
    private boolean dRv = true;
    private boolean dRw = true;
    private boolean dRx = true;
    private boolean dRy = true;
    private boolean djF = true;
    private boolean dwB = true;
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.djF = true;
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dRz == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (dRA == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (dRB == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (dRC == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (dRD == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (dRE == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (dRF == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (dRG == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (dRH == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (dRI == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (dRJ == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (dRK == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (dRL == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i);
                } else if (dRM == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dRl) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.dRm) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.dRn) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.dRo) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.dRp) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.dRq) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.dRr) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.dRs) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.dRt) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.dRu) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.dRv) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.dRw) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.dRx) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.dRy) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
