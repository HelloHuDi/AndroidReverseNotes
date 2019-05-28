package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class er extends c {
    private static final int dGk = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int dSK = "userStoryFlag".hashCode();
    private static final int dSL = "newThumbUrl".hashCode();
    private static final int dSM = "newVideoUrl".hashCode();
    private static final int dSN = "syncId".hashCode();
    private static final int dSO = "readId".hashCode();
    private static final int dSP = "storyPostTime".hashCode();
    private static final int dSQ = "storyObjOneDay".hashCode();
    private static final int dSR = "readTime".hashCode();
    private static final int dSS = "preloadStoryId".hashCode();
    private static final int dST = "preloadMediaId".hashCode();
    private static final int dSU = "preLoadResource".hashCode();
    private static final int dSV = "userInfo".hashCode();
    private static final int dSW = "favoriteMd5".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dGf = true;
    private boolean dSA = true;
    private boolean dSB = true;
    private boolean dSC = true;
    private boolean dSD = true;
    private boolean dSE = true;
    private boolean dSF = true;
    private boolean dSG = true;
    private boolean dSH = true;
    private boolean dSI = true;
    private boolean dSJ = true;
    private boolean dSx = true;
    private boolean dSy = true;
    private boolean dSz = true;
    private boolean djF = true;
    private boolean dln = true;
    private boolean dwB = true;
    public long field_duration;
    public String field_favoriteMd5;
    public String field_md5;
    public String field_newThumbUrl;
    public String field_newVideoUrl;
    public long field_preLoadResource;
    public String field_preloadMediaId;
    public long field_preloadStoryId;
    public long field_readId;
    public long field_readTime;
    public int field_storyObjOneDay;
    public int field_storyPostTime;
    public long field_syncId;
    public long field_updateTime;
    public byte[] field_userInfo;
    public String field_userName;
    public int field_userStoryFlag;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xDd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "userName";
        aVar.columns[1] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userStoryFlag";
        aVar.xDd.put("userStoryFlag", "INTEGER");
        stringBuilder.append(" userStoryFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "newThumbUrl";
        aVar.xDd.put("newThumbUrl", "TEXT");
        stringBuilder.append(" newThumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "newVideoUrl";
        aVar.xDd.put("newVideoUrl", "TEXT");
        stringBuilder.append(" newVideoUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "syncId";
        aVar.xDd.put("syncId", "LONG");
        stringBuilder.append(" syncId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "readId";
        aVar.xDd.put("readId", "LONG");
        stringBuilder.append(" readId LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "storyPostTime";
        aVar.xDd.put("storyPostTime", "INTEGER");
        stringBuilder.append(" storyPostTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "storyObjOneDay";
        aVar.xDd.put("storyObjOneDay", "INTEGER");
        stringBuilder.append(" storyObjOneDay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "readTime";
        aVar.xDd.put("readTime", "LONG");
        stringBuilder.append(" readTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "preloadStoryId";
        aVar.xDd.put("preloadStoryId", "LONG");
        stringBuilder.append(" preloadStoryId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "preloadMediaId";
        aVar.xDd.put("preloadMediaId", "TEXT");
        stringBuilder.append(" preloadMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "preLoadResource";
        aVar.xDd.put("preLoadResource", "LONG");
        stringBuilder.append(" preLoadResource LONG");
        stringBuilder.append(", ");
        aVar.columns[14] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "userInfo";
        aVar.xDd.put("userInfo", "BLOB");
        stringBuilder.append(" userInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "favoriteMd5";
        aVar.xDd.put("favoriteMd5", "TEXT");
        stringBuilder.append(" favoriteMd5 TEXT");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.djF = true;
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dSK == hashCode) {
                    this.field_userStoryFlag = cursor.getInt(i);
                } else if (dSL == hashCode) {
                    this.field_newThumbUrl = cursor.getString(i);
                } else if (dSM == hashCode) {
                    this.field_newVideoUrl = cursor.getString(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dSN == hashCode) {
                    this.field_syncId = cursor.getLong(i);
                } else if (dSO == hashCode) {
                    this.field_readId = cursor.getLong(i);
                } else if (dSP == hashCode) {
                    this.field_storyPostTime = cursor.getInt(i);
                } else if (dSQ == hashCode) {
                    this.field_storyObjOneDay = cursor.getInt(i);
                } else if (dSR == hashCode) {
                    this.field_readTime = cursor.getLong(i);
                } else if (dSS == hashCode) {
                    this.field_preloadStoryId = cursor.getLong(i);
                } else if (dST == hashCode) {
                    this.field_preloadMediaId = cursor.getString(i);
                } else if (dSU == hashCode) {
                    this.field_preLoadResource = cursor.getLong(i);
                } else if (dGk == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (dSV == hashCode) {
                    this.field_userInfo = cursor.getBlob(i);
                } else if (dSW == hashCode) {
                    this.field_favoriteMd5 = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dSx) {
            contentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
        }
        if (this.dSy) {
            contentValues.put("newThumbUrl", this.field_newThumbUrl);
        }
        if (this.dSz) {
            contentValues.put("newVideoUrl", this.field_newVideoUrl);
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dSA) {
            contentValues.put("syncId", Long.valueOf(this.field_syncId));
        }
        if (this.dSB) {
            contentValues.put("readId", Long.valueOf(this.field_readId));
        }
        if (this.dSC) {
            contentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
        }
        if (this.dSD) {
            contentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
        }
        if (this.dSE) {
            contentValues.put("readTime", Long.valueOf(this.field_readTime));
        }
        if (this.dSF) {
            contentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
        }
        if (this.dSG) {
            contentValues.put("preloadMediaId", this.field_preloadMediaId);
        }
        if (this.dSH) {
            contentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
        }
        if (this.dGf) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.dSI) {
            contentValues.put("userInfo", this.field_userInfo);
        }
        if (this.dSJ) {
            contentValues.put("favoriteMd5", this.field_favoriteMd5);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
