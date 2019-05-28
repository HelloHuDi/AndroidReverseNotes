package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.aj */
public abstract class C37834aj extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int drG = "lower_bound".hashCode();
    private static final int drH = "need_insert_show_timestamp".hashCode();
    private static final int drI = "show_timestamp_encrypt_key".hashCode();
    private static final int drJ = "expire_time_interval".hashCode();
    private static final int drK = "show_expire_interval".hashCode();
    private static final int drL = "fetch_time".hashCode();
    private static final int drk = "card_id".hashCode();
    private boolean dqR = true;
    private boolean drA = true;
    private boolean drB = true;
    private boolean drC = true;
    private boolean drD = true;
    private boolean drE = true;
    private boolean drF = true;
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (drk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.dqR = true;
                } else if (drG == hashCode) {
                    this.field_lower_bound = cursor.getInt(i);
                } else if (drH == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i) != 0;
                } else if (drI == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i);
                } else if (drJ == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i);
                } else if (drK == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i);
                } else if (drL == hashCode) {
                    this.field_fetch_time = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dqR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.drA) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.drB) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.drC) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.drD) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.drE) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.drF) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
