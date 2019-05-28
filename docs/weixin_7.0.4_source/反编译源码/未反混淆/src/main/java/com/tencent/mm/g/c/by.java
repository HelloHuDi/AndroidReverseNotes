package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by extends c {
    private static final int dDn = "mergerId".hashCode();
    private static final int dDo = "gameMsgId".hashCode();
    private static final int dDp = "expireTime".hashCode();
    private static final int dDq = "showInMsgList".hashCode();
    private static final int dDr = "label".hashCode();
    private static final int dDs = "isHidden".hashCode();
    private static final int dDt = "weight".hashCode();
    private static final int dDu = "receiveTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int djv = "rawXML".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dow = "msgType".hashCode();
    private static final int dqH = "isRead".hashCode();
    private boolean dDf = true;
    private boolean dDg = true;
    private boolean dDh = true;
    private boolean dDi = true;
    private boolean dDj = true;
    private boolean dDk = true;
    private boolean dDl = true;
    private boolean dDm = true;
    private boolean diM = true;
    private boolean djH = true;
    private boolean djr = true;
    private boolean dkE = true;
    private boolean doi = true;
    private boolean dqw = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public long field_receiveTime;
    public boolean field_showInMsgList;
    public String field_weight;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.diM = true;
                } else if (dDn == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (dDo == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (dow == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dDq == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (dqH == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (dDr == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (dDs == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (dDt == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (djv == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (dDu == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dDf) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.dDg) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.doi) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dDi) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.dqw) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.dDj) {
            contentValues.put("label", this.field_label);
        }
        if (this.dDk) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.dDl) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.djr) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.dDm) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
