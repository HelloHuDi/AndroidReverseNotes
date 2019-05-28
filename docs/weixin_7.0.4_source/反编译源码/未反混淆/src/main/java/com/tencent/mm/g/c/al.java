package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkY = "mediaId".hashCode();
    private static final int drY = "downloadUrlHashCode".hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dsa = "httpsUrl".hashCode();
    private static final int dsb = "filePath".hashCode();
    private static final int dsc = "verifyHeaders".hashCode();
    private static final int dsd = "game_package_download".hashCode();
    private static final int dse = "allowMobileNetDownload".hashCode();
    private static final int dsf = "wifiAutoDownload".hashCode();
    private boolean dkH = true;
    private boolean drQ = true;
    private boolean drR = true;
    private boolean drS = true;
    private boolean drT = true;
    private boolean drU = true;
    private boolean drV = true;
    private boolean drW = true;
    private boolean drX = true;
    public Boolean field_allowMobileNetDownload;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public String field_filePath;
    public Boolean field_game_package_download;
    public String field_httpsUrl;
    public String field_mediaId;
    public String field_verifyHeaders;
    public Boolean field_wifiAutoDownload;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkY == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (drY == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                    this.drQ = true;
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dsa == hashCode) {
                    this.field_httpsUrl = cursor.getString(i);
                } else if (dsb == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (dsc == hashCode) {
                    this.field_verifyHeaders = cursor.getString(i);
                } else if (dsd == hashCode) {
                    this.field_game_package_download = Boolean.valueOf(cursor.getInt(i) != 0);
                } else if (dse == hashCode) {
                    this.field_allowMobileNetDownload = Boolean.valueOf(cursor.getInt(i) != 0);
                } else if (dsf == hashCode) {
                    this.field_wifiAutoDownload = Boolean.valueOf(cursor.getInt(i) != 0);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkH) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.drQ) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.drR) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.drS) {
            contentValues.put("httpsUrl", this.field_httpsUrl);
        }
        if (this.drT) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.drU) {
            contentValues.put("verifyHeaders", this.field_verifyHeaders);
        }
        if (this.drV) {
            contentValues.put("game_package_download", this.field_game_package_download);
        }
        if (this.drW) {
            contentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
        }
        if (this.drX) {
            contentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
