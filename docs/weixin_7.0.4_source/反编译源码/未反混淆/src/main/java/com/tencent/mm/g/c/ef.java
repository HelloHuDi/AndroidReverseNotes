package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef extends c {
    private static final int dDb = "retryCount".hashCode();
    private static final int dQu = "state_flag".hashCode();
    private static final int dQv = "update_time".hashCode();
    private static final int dQw = "seq".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int drk = "card_id".hashCode();
    private boolean dCI = true;
    private boolean dQr = true;
    private boolean dQs = true;
    private boolean dQt = true;
    private boolean dqR = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (drk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.dqR = true;
                } else if (dQu == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (dQv == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (dQw == hashCode) {
                    this.field_seq = cursor.getLong(i);
                } else if (dDb == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dqR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.dQr) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.dQs) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.dQt) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.dCI) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
