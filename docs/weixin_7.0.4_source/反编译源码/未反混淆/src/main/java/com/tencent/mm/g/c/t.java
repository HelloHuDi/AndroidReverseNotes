package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.ttpic.baseutils.BaseTemplateParser;

public abstract class t extends c {
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dmb = "source".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dnB = "description".hashCode();
    private static final int dnz = BaseTemplateParser.POSTFIX_ORIG.hashCode();
    private boolean diM = true;
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dlY = true;
    private boolean dnw = true;
    private boolean dnx = true;
    private boolean dny = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.diM = true;
                } else if (dnz == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dnB == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (dmb == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dnw) {
            contentValues.put(BaseTemplateParser.POSTFIX_ORIG, this.field_xml);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dny) {
            contentValues.put("description", this.field_description);
        }
        if (this.dlY) {
            contentValues.put("source", this.field_source);
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
