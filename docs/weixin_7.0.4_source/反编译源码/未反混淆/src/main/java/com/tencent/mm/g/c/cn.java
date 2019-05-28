package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;

public abstract class cn extends c {
    private static final int dGi = "phonenumber".hashCode();
    private static final int dGj = "calltime".hashCode();
    private static final int dGk = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int dGl = "addressId".hashCode();
    private static final int dGm = "phoneType".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private boolean dGd = true;
    private boolean dGe = true;
    private boolean dGf = true;
    private boolean dGg = true;
    private boolean dGh = true;
    private boolean diU = true;
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dGi == hashCode) {
                    this.field_phonenumber = cursor.getString(i);
                } else if (dGj == hashCode) {
                    this.field_calltime = cursor.getLong(i);
                } else if (dGk == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dGl == hashCode) {
                    this.field_addressId = cursor.getLong(i);
                } else if (dGm == hashCode) {
                    this.field_phoneType = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dGd) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.dGe) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.dGf) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dGg) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.dGh) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
