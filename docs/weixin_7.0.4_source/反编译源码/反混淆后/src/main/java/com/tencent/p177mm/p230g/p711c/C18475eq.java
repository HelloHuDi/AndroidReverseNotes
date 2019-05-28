package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.eq */
public abstract class C18475eq extends C4925c {
    private static final int dSr = "baseItemData".hashCode();
    private static final int dSs = "timeStamp".hashCode();
    private static final int dSt = "storyLocalId".hashCode();
    private static final int dSu = "mixFlag".hashCode();
    private static final int dSv = "mixRetryTime".hashCode();
    private static final int dSw = "available".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dSl = true;
    private boolean dSm = true;
    private boolean dSn = true;
    private boolean dSo = true;
    private boolean dSp = true;
    private boolean dSq = true;
    public int field_available;
    public byte[] field_baseItemData;
    public int field_mixFlag;
    public int field_mixRetryTime;
    public int field_storyLocalId;
    public long field_timeStamp;

    /* renamed from: Hm */
    public static C4924a m28759Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "baseItemData";
        c4924a.xDd.put("baseItemData", "BLOB");
        stringBuilder.append(" baseItemData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[1] = "timeStamp";
        c4924a.xDd.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "storyLocalId";
        c4924a.xDd.put("storyLocalId", "INTEGER");
        stringBuilder.append(" storyLocalId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "mixFlag";
        c4924a.xDd.put("mixFlag", "INTEGER");
        stringBuilder.append(" mixFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "mixRetryTime";
        c4924a.xDd.put("mixRetryTime", "INTEGER");
        stringBuilder.append(" mixRetryTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "available";
        c4924a.xDd.put("available", "INTEGER");
        stringBuilder.append(" available INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dSr == hashCode) {
                    this.field_baseItemData = cursor.getBlob(i);
                } else if (dSs == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (dSt == hashCode) {
                    this.field_storyLocalId = cursor.getInt(i);
                } else if (dSu == hashCode) {
                    this.field_mixFlag = cursor.getInt(i);
                } else if (dSv == hashCode) {
                    this.field_mixRetryTime = cursor.getInt(i);
                } else if (dSw == hashCode) {
                    this.field_available = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dSl) {
            contentValues.put("baseItemData", this.field_baseItemData);
        }
        if (this.dSm) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.dSn) {
            contentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
        }
        if (this.dSo) {
            contentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
        }
        if (this.dSp) {
            contentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
        }
        if (this.dSq) {
            contentValues.put("available", Integer.valueOf(this.field_available));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
