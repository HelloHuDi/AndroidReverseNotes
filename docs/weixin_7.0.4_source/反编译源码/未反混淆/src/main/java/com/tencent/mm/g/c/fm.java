package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm extends c {
    private static final int dDp = "expireTime".hashCode();
    private static final int dDt = "weight".hashCode();
    private static final int dSs = "timeStamp".hashCode();
    private static final int dYo = "appIdKey".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlB = "size".hashCode();
    private boolean dDh = true;
    private boolean dDl = true;
    private boolean dSm = true;
    private boolean dYn = true;
    private boolean diZ = true;
    private boolean dkE = true;
    private boolean dlz = true;
    public String field_appId;
    public String field_appIdKey;
    public long field_expireTime;
    public long field_size;
    public long field_timeStamp;
    public String field_value;
    public String field_weight;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dYo == hashCode) {
                    this.field_appIdKey = cursor.getString(i);
                    this.dYn = true;
                } else if (djh == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (dDt == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (dSs == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dYn) {
            contentValues.put("appIdKey", this.field_appIdKey);
        }
        if (this.diZ) {
            contentValues.put("value", this.field_value);
        }
        if (this.dDl) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.dSm) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.dlz) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
