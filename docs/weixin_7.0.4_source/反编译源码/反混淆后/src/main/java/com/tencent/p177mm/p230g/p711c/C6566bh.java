package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bh */
public abstract class C6566bh extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int dxy = "groupId".hashCode();
    private static final int dyB = "exptId".hashCode();
    private static final int dyC = "exptSeq".hashCode();
    private static final int dyD = "exptContent".hashCode();
    private static final int dyE = "exptType".hashCode();
    private boolean djd = true;
    private boolean dje = true;
    private boolean dwM = true;
    private boolean dyA = true;
    private boolean dyx = true;
    private boolean dyy = true;
    private boolean dyz = true;
    public long field_endTime;
    public String field_exptContent;
    public int field_exptId;
    public int field_exptSeq;
    public int field_exptType;
    public int field_groupId;
    public long field_startTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dyB == hashCode) {
                    this.field_exptId = cursor.getInt(i);
                    this.dyx = true;
                } else if (dxy == hashCode) {
                    this.field_groupId = cursor.getInt(i);
                } else if (dyC == hashCode) {
                    this.field_exptSeq = cursor.getInt(i);
                } else if (dyD == hashCode) {
                    this.field_exptContent = cursor.getString(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (djm == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (dyE == hashCode) {
                    this.field_exptType = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dyx) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.dwM) {
            contentValues.put("groupId", Integer.valueOf(this.field_groupId));
        }
        if (this.dyy) {
            contentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
        }
        if (this.dyz) {
            contentValues.put("exptContent", this.field_exptContent);
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dje) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.dyA) {
            contentValues.put("exptType", Integer.valueOf(this.field_exptType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
