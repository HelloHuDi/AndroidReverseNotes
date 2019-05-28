package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fl */
public abstract class C9531fl extends C4925c {
    private static final int dYi = "disable".hashCode();
    private static final int dYj = "configUrl".hashCode();
    private static final int dYk = "configResources".hashCode();
    private static final int dYl = "configCrc32".hashCode();
    private static final int dYm = "isFromXml".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dzC = "configId".hashCode();
    private boolean dYd = true;
    private boolean dYe = true;
    private boolean dYf = true;
    private boolean dYg = true;
    private boolean dYh = true;
    private boolean dzB = true;
    public long field_configCrc32;
    public String field_configId;
    public String field_configResources;
    public String field_configUrl;
    public boolean field_disable;
    public boolean field_isFromXml;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dYi == hashCode) {
                    boolean z;
                    if (cursor.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.field_disable = z;
                } else if (dzC == hashCode) {
                    this.field_configId = cursor.getString(i);
                    this.dzB = true;
                } else if (dYj == hashCode) {
                    this.field_configUrl = cursor.getString(i);
                } else if (dYk == hashCode) {
                    this.field_configResources = cursor.getString(i);
                } else if (dYl == hashCode) {
                    this.field_configCrc32 = cursor.getLong(i);
                } else if (dYm == hashCode) {
                    this.field_isFromXml = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dYd) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.dzB) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.dYe) {
            contentValues.put("configUrl", this.field_configUrl);
        }
        if (this.dYf) {
            contentValues.put("configResources", this.field_configResources);
        }
        if (this.dYg) {
            contentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
        }
        if (this.dYh) {
            contentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
