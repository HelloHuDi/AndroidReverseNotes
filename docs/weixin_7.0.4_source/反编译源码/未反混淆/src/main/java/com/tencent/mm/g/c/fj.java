package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fj extends c {
    private static final int dXW = "pkgId".hashCode();
    private static final int dXX = "oldVersion".hashCode();
    private static final int dXY = "oldPath".hashCode();
    private static final int dXZ = "pkgSize".hashCode();
    private static final int dYa = "downloadNetType".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dXR = true;
    private boolean dXS = true;
    private boolean dXT = true;
    private boolean dXU = true;
    private boolean dXV = true;
    private boolean dlM = true;
    private boolean drR = true;
    private boolean dwB = true;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public String field_md5;
    public String field_oldPath;
    public String field_oldVersion;
    public String field_pkgId;
    public int field_pkgSize;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dXW == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                    this.dXR = true;
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (dXX == hashCode) {
                    this.field_oldVersion = cursor.getString(i);
                } else if (dXY == hashCode) {
                    this.field_oldPath = cursor.getString(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dXZ == hashCode) {
                    this.field_pkgSize = cursor.getInt(i);
                } else if (dYa == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dXR) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.dlM) {
            contentValues.put("version", this.field_version);
        }
        if (this.dXS) {
            contentValues.put("oldVersion", this.field_oldVersion);
        }
        if (this.dXT) {
            contentValues.put("oldPath", this.field_oldPath);
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.drR) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.dXU) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.dXV) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
