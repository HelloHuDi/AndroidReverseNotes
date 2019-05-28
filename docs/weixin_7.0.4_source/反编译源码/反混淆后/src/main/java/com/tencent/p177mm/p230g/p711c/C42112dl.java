package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.dl */
public abstract class C42112dl extends C4925c {
    private static final int dBg = DownloadInfo.FILENAME.hashCode();
    private static final int dKC = "musicId".hashCode();
    private static final int dMu = "musicUrl".hashCode();
    private static final int dMv = "indexBitData".hashCode();
    private static final int dMw = "fileCacheComplete".hashCode();
    private static final int dMx = "pieceFileMIMEType".hashCode();
    private static final int dMy = "removeDirtyBit".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dAK = true;
    private boolean dJV = true;
    private boolean dMp = true;
    private boolean dMq = true;
    private boolean dMr = true;
    private boolean dMs = true;
    private boolean dMt = true;
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;
    public int field_removeDirtyBit;

    /* renamed from: Hm */
    public static C4924a m74240Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "musicId";
        c4924a.xDd.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "musicId";
        c4924a.columns[1] = "musicUrl";
        c4924a.xDd.put("musicUrl", "TEXT");
        stringBuilder.append(" musicUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = DownloadInfo.FILENAME;
        c4924a.xDd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "indexBitData";
        c4924a.xDd.put("indexBitData", "BLOB");
        stringBuilder.append(" indexBitData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[4] = "fileCacheComplete";
        c4924a.xDd.put("fileCacheComplete", "INTEGER");
        stringBuilder.append(" fileCacheComplete INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "pieceFileMIMEType";
        c4924a.xDd.put("pieceFileMIMEType", "TEXT");
        stringBuilder.append(" pieceFileMIMEType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "removeDirtyBit";
        c4924a.xDd.put("removeDirtyBit", "INTEGER");
        stringBuilder.append(" removeDirtyBit INTEGER");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dKC == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.dJV = true;
                } else if (dMu == hashCode) {
                    this.field_musicUrl = cursor.getString(i);
                } else if (dBg == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (dMv == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i);
                } else if (dMw == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i);
                } else if (dMx == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i);
                } else if (dMy == hashCode) {
                    this.field_removeDirtyBit = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dJV) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.dMp) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.dAK) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.dMq) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.dMr) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.dMs) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.dMt) {
            contentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
