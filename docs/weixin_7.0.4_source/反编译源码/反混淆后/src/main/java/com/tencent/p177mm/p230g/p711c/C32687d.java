package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.d */
public abstract class C32687d extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dji = "expId".hashCode();
    private static final int djj = "sequence".hashCode();
    private static final int djk = "prioritylevel".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int djs = "layerId".hashCode();
    private static final int djt = "business".hashCode();
    private static final int dju = "needReport".hashCode();
    private static final int djv = "rawXML".hashCode();
    private boolean dja = true;
    private boolean djb = true;
    private boolean djc = true;
    private boolean djd = true;
    private boolean dje = true;
    private boolean djo = true;
    private boolean djp = true;
    private boolean djq = true;
    private boolean djr = true;
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djs == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.djo = true;
                } else if (djt == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (dju == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (djv == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djo) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.djp) {
            contentValues.put("business", this.field_business);
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
        if (this.djq) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.djr) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
