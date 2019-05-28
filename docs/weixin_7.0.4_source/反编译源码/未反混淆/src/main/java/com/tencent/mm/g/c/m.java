package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class m extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dlF = "recordId".hashCode();
    private static final int dlG = "brandId".hashCode();
    private static final int dlH = "versionType".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean dkA = true;
    private boolean dlC = true;
    private boolean dlD = true;
    private boolean dlE = true;
    private boolean dln = true;
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public long field_updateTime;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlF == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.dlC = true;
                } else if (dlG == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (dlH == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlC) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.dlD) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.dlE) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
