package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.j */
public abstract class C6583j extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dlu = "fetchType".hashCode();
    private static final int dlv = "path".hashCode();
    private static final int dlw = SearchIntents.EXTRA_QUERY.hashCode();
    private static final int dlx = "data".hashCode();
    private boolean dkA = true;
    private boolean dlm = true;
    private boolean dln = true;
    private boolean dlq = true;
    private boolean dlr = true;
    private boolean dls = true;
    private boolean dlt = true;
    public String field_data;
    public int field_fetchType;
    public String field_path;
    public String field_query;
    public int field_scene;
    public long field_updateTime;
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
                } else if (dlu == hashCode) {
                    this.field_fetchType = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dlv == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (dlw == hashCode) {
                    this.field_query = cursor.getString(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (dlx == hashCode) {
                    this.field_data = cursor.getString(i);
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
        if (this.dlq) {
            contentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dlr) {
            contentValues.put("path", this.field_path);
        }
        if (this.dls) {
            contentValues.put(SearchIntents.EXTRA_QUERY, this.field_query);
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.dlt) {
            contentValues.put("data", this.field_data);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
