package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do extends c {
    private static final int dMB = "sceneList".hashCode();
    private static final int dMC = "cgiList".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)"};
    private static final int diR = "rowid".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dmd = "reportId".hashCode();
    private boolean dMA = true;
    private boolean dMz = true;
    private boolean djd = true;
    private boolean dje = true;
    private boolean dkE = true;
    private boolean dlm = true;
    private boolean dma = true;
    public String field_appId;
    public String field_cgiList;
    public long field_endTime;
    public int field_reportId;
    public String field_sceneList;
    public long field_startTime;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (djm == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (dMB == hashCode) {
                    this.field_sceneList = cursor.getString(i);
                } else if (dMC == hashCode) {
                    this.field_cgiList = cursor.getString(i);
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dje) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.dMz) {
            contentValues.put("sceneList", this.field_sceneList);
        }
        if (this.dMA) {
            contentValues.put("cgiList", this.field_cgiList);
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
