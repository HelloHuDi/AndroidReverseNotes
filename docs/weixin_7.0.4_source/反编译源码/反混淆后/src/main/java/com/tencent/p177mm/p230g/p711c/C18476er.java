package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.er */
public abstract class C18476er extends C4925c {
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

    /* renamed from: Hm */
    public static C4924a m28762Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "userName";
        c4924a.xDd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "userName";
        c4924a.columns[1] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "userStoryFlag";
        c4924a.xDd.put("userStoryFlag", "INTEGER");
        stringBuilder.append(" userStoryFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "newThumbUrl";
        c4924a.xDd.put("newThumbUrl", "TEXT");
        stringBuilder.append(" newThumbUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "newVideoUrl";
        c4924a.xDd.put("newVideoUrl", "TEXT");
        stringBuilder.append(" newVideoUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "syncId";
        c4924a.xDd.put("syncId", "LONG");
        stringBuilder.append(" syncId LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "readId";
        c4924a.xDd.put("readId", "LONG");
        stringBuilder.append(" readId LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "storyPostTime";
        c4924a.xDd.put("storyPostTime", "INTEGER");
        stringBuilder.append(" storyPostTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "storyObjOneDay";
        c4924a.xDd.put("storyObjOneDay", "INTEGER");
        stringBuilder.append(" storyObjOneDay INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "readTime";
        c4924a.xDd.put("readTime", "LONG");
        stringBuilder.append(" readTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "preloadStoryId";
        c4924a.xDd.put("preloadStoryId", "LONG");
        stringBuilder.append(" preloadStoryId LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "preloadMediaId";
        c4924a.xDd.put("preloadMediaId", "TEXT");
        stringBuilder.append(" preloadMediaId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "preLoadResource";
        c4924a.xDd.put("preLoadResource", "LONG");
        stringBuilder.append(" preLoadResource LONG");
        stringBuilder.append(", ");
        c4924a.columns[14] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        c4924a.columns[15] = "userInfo";
        c4924a.xDd.put("userInfo", "BLOB");
        stringBuilder.append(" userInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[16] = "favoriteMd5";
        c4924a.xDd.put("favoriteMd5", "TEXT");
        stringBuilder.append(" favoriteMd5 TEXT");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
