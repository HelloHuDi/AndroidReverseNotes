package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea extends c {
    private static final int dPi = "productId".hashCode();
    private static final int dPj = "xmlContent".hashCode();
    private static final int dPk = "ScanTime".hashCode();
    private static final int dPl = "funcType".hashCode();
    private static final int dPm = "qrcodeUrl".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkC = "scene".hashCode();
    private boolean dPd = true;
    private boolean dPe = true;
    private boolean dPf = true;
    private boolean dPg = true;
    private boolean dPh = true;
    private boolean dkA = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dPi == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.dPd = true;
                } else if (dPj == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (dPk == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (dPl == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (dPm == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dPd) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.dPe) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.dPf) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.dPg) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.dPh) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
