package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class db extends c {
    private static final int dKC = "musicId".hashCode();
    private static final int dKD = "originMusicId".hashCode();
    private static final int dKE = "musicType".hashCode();
    private static final int dKF = "downloadedLength".hashCode();
    private static final int dKG = "wifiDownloadedLength".hashCode();
    private static final int dKH = "endFlag".hashCode();
    private static final int dKI = "wifiEndFlag".hashCode();
    private static final int dKJ = "songId".hashCode();
    private static final int dKK = "songName".hashCode();
    private static final int dKL = "songSinger".hashCode();
    private static final int dKM = "songAlbum".hashCode();
    private static final int dKN = "songAlbumType".hashCode();
    private static final int dKO = "songAlbumUrl".hashCode();
    private static final int dKP = "songHAlbumUrl".hashCode();
    private static final int dKQ = "songAlbumLocalPath".hashCode();
    private static final int dKR = "songWifiUrl".hashCode();
    private static final int dKS = "songWapLinkUrl".hashCode();
    private static final int dKT = "songWebUrl".hashCode();
    private static final int dKU = "songMediaId".hashCode();
    private static final int dKV = "songSnsAlbumUser".hashCode();
    private static final int dKW = "songSnsShareUser".hashCode();
    private static final int dKX = "songLyric".hashCode();
    private static final int dKY = "songBgColor".hashCode();
    private static final int dKZ = "songLyricColor".hashCode();
    private static final int dLa = "songFileLength".hashCode();
    private static final int dLb = "songWifiFileLength".hashCode();
    private static final int dLc = "hideBanner".hashCode();
    private static final int dLd = "jsWebUrlDomain".hashCode();
    private static final int dLe = "isBlock".hashCode();
    private static final int dLf = "mimetype".hashCode();
    private static final int dLg = "protocol".hashCode();
    private static final int dLh = "barBackToWebView".hashCode();
    private static final int dLi = "musicbar_url".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean dJV = true;
    private boolean dJW = true;
    private boolean dJX = true;
    private boolean dJY = true;
    private boolean dJZ = true;
    private boolean dKA = true;
    private boolean dKB = true;
    private boolean dKa = true;
    private boolean dKb = true;
    private boolean dKc = true;
    private boolean dKd = true;
    private boolean dKe = true;
    private boolean dKf = true;
    private boolean dKg = true;
    private boolean dKh = true;
    private boolean dKi = true;
    private boolean dKj = true;
    private boolean dKk = true;
    private boolean dKl = true;
    private boolean dKm = true;
    private boolean dKn = true;
    private boolean dKo = true;
    private boolean dKp = true;
    private boolean dKq = true;
    private boolean dKr = true;
    private boolean dKs = true;
    private boolean dKt = true;
    private boolean dKu = true;
    private boolean dKv = true;
    private boolean dKw = true;
    private boolean dKx = true;
    private boolean dKy = true;
    private boolean dKz = true;
    private boolean djd = true;
    private boolean dkE = true;
    private boolean dln = true;
    public String field_appId;
    public boolean field_barBackToWebView;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_mimetype;
    public String field_musicId;
    public int field_musicType;
    public String field_musicbar_url;
    public String field_originMusicId;
    public String field_protocol;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[36];
        aVar.columns = new String[37];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.xDd.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "musicId";
        aVar.columns[1] = "originMusicId";
        aVar.xDd.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "musicType";
        aVar.xDd.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "downloadedLength";
        aVar.xDd.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "wifiDownloadedLength";
        aVar.xDd.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endFlag";
        aVar.xDd.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiEndFlag";
        aVar.xDd.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "songId";
        aVar.xDd.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "songName";
        aVar.xDd.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "songSinger";
        aVar.xDd.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "songAlbum";
        aVar.xDd.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "songAlbumType";
        aVar.xDd.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "songAlbumUrl";
        aVar.xDd.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "songHAlbumUrl";
        aVar.xDd.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "songAlbumLocalPath";
        aVar.xDd.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "songWifiUrl";
        aVar.xDd.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "songWapLinkUrl";
        aVar.xDd.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "songWebUrl";
        aVar.xDd.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "songMediaId";
        aVar.xDd.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "songSnsAlbumUser";
        aVar.xDd.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "songSnsShareUser";
        aVar.xDd.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "songLyric";
        aVar.xDd.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "songBgColor";
        aVar.xDd.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[25] = "songLyricColor";
        aVar.xDd.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "songFileLength";
        aVar.xDd.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[27] = "songWifiFileLength";
        aVar.xDd.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[28] = "hideBanner";
        aVar.xDd.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "jsWebUrlDomain";
        aVar.xDd.put("jsWebUrlDomain", "TEXT");
        stringBuilder.append(" jsWebUrlDomain TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "isBlock";
        aVar.xDd.put("isBlock", "INTEGER");
        stringBuilder.append(" isBlock INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "startTime";
        aVar.xDd.put("startTime", "INTEGER");
        stringBuilder.append(" startTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[32] = "mimetype";
        aVar.xDd.put("mimetype", "TEXT");
        stringBuilder.append(" mimetype TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "protocol";
        aVar.xDd.put("protocol", "TEXT");
        stringBuilder.append(" protocol TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "barBackToWebView";
        aVar.xDd.put("barBackToWebView", "INTEGER");
        stringBuilder.append(" barBackToWebView INTEGER");
        stringBuilder.append(", ");
        aVar.columns[35] = "musicbar_url";
        aVar.xDd.put("musicbar_url", "TEXT");
        stringBuilder.append(" musicbar_url TEXT");
        aVar.columns[36] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dKC == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.dJV = true;
                } else if (dKD == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (dKE == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (dKF == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (dKG == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (dKH == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (dKI == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dKJ == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (dKK == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (dKL == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (dKM == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (dKN == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (dKO == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (dKP == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (dKQ == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (dKR == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (dKS == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (dKT == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dKU == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (dKV == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (dKW == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (dKX == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (dKY == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (dKZ == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (dLa == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (dLb == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (dLc == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (dLd == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i);
                } else if (dLe == hashCode) {
                    this.field_isBlock = cursor.getInt(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getInt(i);
                } else if (dLf == hashCode) {
                    this.field_mimetype = cursor.getString(i);
                } else if (dLg == hashCode) {
                    this.field_protocol = cursor.getString(i);
                } else if (dLh == hashCode) {
                    this.field_barBackToWebView = cursor.getInt(i) != 0;
                } else if (dLi == hashCode) {
                    this.field_musicbar_url = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dJV) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.dJW) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.dJX) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.dJY) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.dJZ) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.dKa) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.dKb) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dKc) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.dKd) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.dKe) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.dKf) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.dKg) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.dKh) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.dKi) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.dKj) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.dKk) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.dKl) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.dKm) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dKn) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.dKo) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.dKp) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.dKq) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.dKr) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.dKs) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.dKt) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.dKu) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.dKv) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.dKw) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.dKx) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.djd) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.dKy) {
            contentValues.put("mimetype", this.field_mimetype);
        }
        if (this.dKz) {
            contentValues.put("protocol", this.field_protocol);
        }
        if (this.dKA) {
            contentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
        }
        if (this.dKB) {
            contentValues.put("musicbar_url", this.field_musicbar_url);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
