package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bg */
public abstract class C6565bg extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dmI = "modifyTime".hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dys = "prodcutID".hashCode();
    private static final int dyt = "totalCount".hashCode();
    private static final int dyu = "continuCount".hashCode();
    private static final int dyv = "showTipsTime".hashCode();
    private static final int dyw = "setFlagTime".hashCode();
    private boolean dml = true;
    private boolean dnC = true;
    private boolean dyn = true;
    private boolean dyo = true;
    private boolean dyp = true;
    private boolean dyq = true;
    private boolean dyr = true;
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dys == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.dyn = true;
                } else if (dyt == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (dyu == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (dmI == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (dyv == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (dyw == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dyn) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.dyo) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.dyp) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.dml) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.dyq) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.dyr) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
