package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fv */
public abstract class C18481fv extends C4925c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)"};
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dmF = "appVersion".hashCode();
    private static final int dmd = "reportId".hashCode();
    private boolean dlm = true;
    private boolean dma = true;
    private boolean dmi = true;
    public int field_appVersion;
    public int field_reportId;
    public String field_username;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dmF == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dmi) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.dma) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
