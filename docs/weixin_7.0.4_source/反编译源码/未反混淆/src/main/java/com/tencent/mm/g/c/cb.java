package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class cb extends c {
    private static final int dEb = "originSvrId".hashCode();
    private static final int dEc = "newMsgId".hashCode();
    private static final int dEd = "fromUserName".hashCode();
    private static final int dEe = "toUserName".hashCode();
    private static final int dEf = "msgSource".hashCode();
    private static final int dEg = "msgSeq".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dxt = "reserved1".hashCode();
    private static final int dxu = "reserved2".hashCode();
    private static final int dxv = "reserved3".hashCode();
    private static final int dxw = "reserved4".hashCode();
    private boolean dDV = true;
    private boolean dDW = true;
    private boolean dDX = true;
    private boolean dDY = true;
    private boolean dDZ = true;
    private boolean dEa = true;
    private boolean djH = true;
    private boolean djP = true;
    private boolean dnC = true;
    private boolean dwH = true;
    private boolean dwI = true;
    private boolean dwJ = true;
    private boolean dwK = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dEb == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.dDV = true;
                } else if (dEc == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (dEd == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (dEe == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dEf == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (dEg == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (dxt == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (dxu == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (dxv == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (dxw == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dDV) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.dDW) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.dDX) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.dDY) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.dDZ) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.dEa) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.dwH) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.dwI) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.dwJ) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.dwK) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
