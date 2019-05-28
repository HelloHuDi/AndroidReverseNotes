package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

/* renamed from: com.tencent.mm.g.c.br */
public abstract class C9521br extends C4925c {
    private static final int dBd = "downloadId".hashCode();
    private static final int dBe = DownloadInfo.SECONDARYURL.hashCode();
    private static final int dBf = "fileSize".hashCode();
    private static final int dBg = DownloadInfo.FILENAME.hashCode();
    private static final int dBh = "fileType".hashCode();
    private static final int dBi = "autoInstall".hashCode();
    private static final int dBj = "showNotification".hashCode();
    private static final int dBk = "sysDownloadId".hashCode();
    private static final int dBl = "downloaderType".hashCode();
    private static final int dBm = "downloadedSize".hashCode();
    private static final int dBn = "totalSize".hashCode();
    private static final int dBo = "autoDownload".hashCode();
    private static final int dBp = DownloadInfoColumns.CHANNELID.hashCode();
    private static final int dBq = "errCode".hashCode();
    private static final int dBr = "startSize".hashCode();
    private static final int dBs = "startState".hashCode();
    private static final int dBt = "fromWeApp".hashCode();
    private static final int dBu = "downloadInWifi".hashCode();
    private static final int dBv = "finishTime".hashCode();
    private static final int dBw = "isSecondDownload".hashCode();
    private static final int dBx = "fromDownloadApp".hashCode();
    private static final int dBy = "reserveInWifi".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dmH = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int dpU = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int drY = "downloadUrlHashCode".hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dsb = "filePath".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dAH = true;
    private boolean dAI = true;
    private boolean dAJ = true;
    private boolean dAK = true;
    private boolean dAL = true;
    private boolean dAM = true;
    private boolean dAN = true;
    private boolean dAO = true;
    private boolean dAP = true;
    private boolean dAQ = true;
    private boolean dAR = true;
    private boolean dAS = true;
    private boolean dAT = true;
    private boolean dAU = true;
    private boolean dAV = true;
    private boolean dAW = true;
    private boolean dAX = true;
    private boolean dAY = true;
    private boolean dAZ = true;
    private boolean dBa = true;
    private boolean dBb = true;
    private boolean dBc = true;
    private boolean diU = true;
    private boolean djd = true;
    private boolean dkA = true;
    private boolean dkE = true;
    private boolean dln = true;
    private boolean dmk = true;
    private boolean dpG = true;
    private boolean drQ = true;
    private boolean drR = true;
    private boolean drT = true;
    private boolean dwB = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public boolean field_downloadInWifi;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_extInfo;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public long field_finishTime;
    public boolean field_fromDownloadApp;
    public boolean field_fromWeApp;
    public boolean field_isSecondDownload;
    public String field_md5;
    public String field_packageName;
    public boolean field_reserveInWifi;
    public int field_scene;
    public String field_secondaryUrl;
    public boolean field_showNotification;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;
    public long field_updateTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dBd == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.dAH = true;
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dBe == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i);
                } else if (dBf == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (dBg == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (dsb == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (dBh == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dBi == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (dBj == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (dBk == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (dBl == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (drY == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (dmH == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (dBm == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (dBn == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (dBo == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (dBp == hashCode) {
                    this.field_channelId = cursor.getString(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (dBq == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (dBr == hashCode) {
                    this.field_startSize = cursor.getLong(i);
                } else if (dBs == hashCode) {
                    this.field_startState = cursor.getInt(i);
                } else if (dBt == hashCode) {
                    this.field_fromWeApp = cursor.getInt(i) != 0;
                } else if (dBu == hashCode) {
                    this.field_downloadInWifi = cursor.getInt(i) != 0;
                } else if (dpU == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (dBv == hashCode) {
                    this.field_finishTime = cursor.getLong(i);
                } else if (dBw == hashCode) {
                    this.field_isSecondDownload = cursor.getInt(i) != 0;
                } else if (dBx == hashCode) {
                    this.field_fromDownloadApp = cursor.getInt(i) != 0;
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dBy == hashCode) {
                    this.field_reserveInWifi = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dAH) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.drR) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.dAI) {
            contentValues.put(DownloadInfo.SECONDARYURL, this.field_secondaryUrl);
        }
        if (this.dAJ) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.dAK) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.drT) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.dAL) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dAM) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.dAN) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.dAO) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.dAP) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.drQ) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.dmk) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.dAQ) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.dAR) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.dAS) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.dAT) {
            contentValues.put(DownloadInfoColumns.CHANNELID, this.field_channelId);
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.dAU) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dAV) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.dAW) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.dAX) {
            contentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
        }
        if (this.dAY) {
            contentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
        }
        if (this.field_extInfo == null) {
            this.field_extInfo = "";
        }
        if (this.dpG) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.dAZ) {
            contentValues.put("finishTime", Long.valueOf(this.field_finishTime));
        }
        if (this.dBa) {
            contentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
        }
        if (this.dBb) {
            contentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dBc) {
            contentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
