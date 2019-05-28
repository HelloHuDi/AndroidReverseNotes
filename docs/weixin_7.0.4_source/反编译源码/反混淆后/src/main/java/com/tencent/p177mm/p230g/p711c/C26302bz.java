package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

/* renamed from: com.tencent.mm.g.c.bz */
public abstract class C26302bz extends C4925c {
    private static final int dDG = "randomTime".hashCode();
    private static final int dDH = "isFirst".hashCode();
    private static final int dDI = "nextCheckTime".hashCode();
    private static final int dDJ = "isRunning".hashCode();
    private static final int dDK = "noWifi".hashCode();
    private static final int dDL = "noSdcard".hashCode();
    private static final int dDM = "noEnoughSpace".hashCode();
    private static final int dDN = "lowBattery".hashCode();
    private static final int dDO = "continueDelay".hashCode();
    private static final int dDP = "SecondaryUrl".hashCode();
    private static final int dDQ = "downloadInWidget".hashCode();
    private static final int dDp = "expireTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlB = "size".hashCode();
    private static final int dmH = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dDA = true;
    private boolean dDB = true;
    private boolean dDC = true;
    private boolean dDD = true;
    private boolean dDE = true;
    private boolean dDF = true;
    private boolean dDh = true;
    private boolean dDv = true;
    private boolean dDw = true;
    private boolean dDx = true;
    private boolean dDy = true;
    private boolean dDz = true;
    private boolean dkE = true;
    private boolean dlz = true;
    private boolean dmk = true;
    private boolean drR = true;
    private boolean dwB = true;
    public String field_SecondaryUrl;
    public String field_appId;
    public boolean field_continueDelay;
    public boolean field_downloadInWidget;
    public String field_downloadUrl;
    public long field_expireTime;
    public boolean field_isFirst;
    public boolean field_isRunning;
    public boolean field_lowBattery;
    public String field_md5;
    public long field_nextCheckTime;
    public boolean field_noEnoughSpace;
    public boolean field_noSdcard;
    public boolean field_noWifi;
    public String field_packageName;
    public long field_randomTime;
    public long field_size;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.dkE = true;
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dmH == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (dDG == hashCode) {
                    this.field_randomTime = cursor.getLong(i);
                } else if (dDH == hashCode) {
                    this.field_isFirst = cursor.getInt(i) != 0;
                } else if (dDI == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (dDJ == hashCode) {
                    this.field_isRunning = cursor.getInt(i) != 0;
                } else if (dDK == hashCode) {
                    this.field_noWifi = cursor.getInt(i) != 0;
                } else if (dDL == hashCode) {
                    this.field_noSdcard = cursor.getInt(i) != 0;
                } else if (dDM == hashCode) {
                    this.field_noEnoughSpace = cursor.getInt(i) != 0;
                } else if (dDN == hashCode) {
                    this.field_lowBattery = cursor.getInt(i) != 0;
                } else if (dDO == hashCode) {
                    this.field_continueDelay = cursor.getInt(i) != 0;
                } else if (dDP == hashCode) {
                    this.field_SecondaryUrl = cursor.getString(i);
                } else if (dDQ == hashCode) {
                    this.field_downloadInWidget = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.drR) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.dlz) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dmk) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.dDv) {
            contentValues.put("randomTime", Long.valueOf(this.field_randomTime));
        }
        if (this.dDw) {
            contentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
        }
        if (this.dDx) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.dDy) {
            contentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
        }
        if (this.dDz) {
            contentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
        }
        if (this.dDA) {
            contentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
        }
        if (this.dDB) {
            contentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
        }
        if (this.dDC) {
            contentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
        }
        if (this.dDD) {
            contentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
        }
        if (this.dDE) {
            contentValues.put("SecondaryUrl", this.field_SecondaryUrl);
        }
        if (this.dDF) {
            contentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
