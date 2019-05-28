package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.c */
public abstract class C6570c extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djg = "abtestkey".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dji = "expId".hashCode();
    private static final int djj = "sequence".hashCode();
    private static final int djk = "prioritylevel".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int djn = "noReport".hashCode();
    private boolean diY = true;
    private boolean diZ = true;
    private boolean dja = true;
    private boolean djb = true;
    private boolean djc = true;
    private boolean djd = true;
    private boolean dje = true;
    private boolean djf = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djg == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.diY = true;
                } else if (djh == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (dji == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (djj == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (djk == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (djm == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (djn == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diY) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.diZ) {
            contentValues.put("value", this.field_value);
        }
        if (this.dja) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.djb) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.djc) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dje) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.djf) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
