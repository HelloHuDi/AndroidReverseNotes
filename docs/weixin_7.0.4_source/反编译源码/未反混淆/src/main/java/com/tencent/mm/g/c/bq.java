package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.mm.sdk.e.c;

public abstract class bq extends c {
    private static final int dAA = "tag".hashCode();
    private static final int dAB = "actionType".hashCode();
    private static final int dAC = "helpUrl".hashCode();
    private static final int dAD = "updateUrl".hashCode();
    private static final int dAE = "androidUrl".hashCode();
    private static final int dAF = "iconPath".hashCode();
    private static final int dAG = Param.TIMESTAMP.hashCode();
    private static final int dAx = "featureId".hashCode();
    private static final int dAy = "titlePY".hashCode();
    private static final int dAz = "titleShortPY".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dnT = "url".hashCode();
    private boolean dAn = true;
    private boolean dAo = true;
    private boolean dAp = true;
    private boolean dAq = true;
    private boolean dAr = true;
    private boolean dAs = true;
    private boolean dAt = true;
    private boolean dAu = true;
    private boolean dAv = true;
    private boolean dAw = true;
    private boolean dnP = true;
    private boolean dnx = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dAx == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.dAn = true;
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dAy == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (dAz == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (dAA == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (dAB == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dAC == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (dAD == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (dAE == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (dAF == hashCode) {
                    this.field_iconPath = cursor.getString(i);
                } else if (dAG == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dAn) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dAo) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.dAp) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.dAq) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.dAr) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dAs) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.dAt) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.dAu) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.dAv) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.dAw) {
            contentValues.put(Param.TIMESTAMP, Long.valueOf(this.field_timestamp));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
