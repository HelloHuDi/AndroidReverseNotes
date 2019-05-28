package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class eg extends c {
    private static final int dBg = DownloadInfo.FILENAME.hashCode();
    private static final int dQC = "fileNameHash".hashCode();
    private static final int dQD = "fileMd5".hashCode();
    private static final int dQE = "fileLength".hashCode();
    private static final int dQF = "fileStatus".hashCode();
    private static final int dQG = "fileDuration".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dzF = "localId".hashCode();
    private boolean dAK = true;
    private boolean dQA = true;
    private boolean dQB = true;
    private boolean dQx = true;
    private boolean dQy = true;
    private boolean dQz = true;
    private boolean djH = true;
    private boolean dzD = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzF == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.dzD = true;
                } else if (dBg == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (dQC == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (dQD == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (dQE == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (dQF == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (dQG == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.dAK) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.dQx) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.dQy) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.dQz) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.dQA) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.dQB) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
