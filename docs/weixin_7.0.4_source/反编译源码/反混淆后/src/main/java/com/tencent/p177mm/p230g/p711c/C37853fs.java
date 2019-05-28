package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fs */
public abstract class C37853fs extends C4925c {
    private static final int dDI = "nextCheckTime".hashCode();
    private static final int dXW = "pkgId".hashCode();
    private static final int dXZ = "pkgSize".hashCode();
    private static final int dYD = "domain".hashCode();
    private static final int dYG = "accessTime".hashCode();
    private static final int dYT = "autoDownloadCount".hashCode();
    private static final int dYa = "downloadNetType".hashCode();
    private static final int dYi = "disable".hashCode();
    private static final int dZg = "disableWvCache".hashCode();
    private static final int dZh = "clearPkgTime".hashCode();
    private static final int dZi = "checkIntervalTime".hashCode();
    private static final int dZj = "packMethod".hashCode();
    private static final int dZk = "charset".hashCode();
    private static final int dZl = "bigPackageReady".hashCode();
    private static final int dZm = "preloadFilesReady".hashCode();
    private static final int dZn = "preloadFilesAtomic".hashCode();
    private static final int dZo = "totalDownloadCount".hashCode();
    private static final int dZp = "packageDownloadCount".hashCode();
    private static final int dZq = "downloadTriggerType".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dlV = "pkgPath".hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dDx = true;
    private boolean dXR = true;
    private boolean dXU = true;
    private boolean dXV = true;
    private boolean dYO = true;
    private boolean dYV = true;
    private boolean dYW = true;
    private boolean dYX = true;
    private boolean dYY = true;
    private boolean dYZ = true;
    private boolean dYd = true;
    private boolean dYw = true;
    private boolean dYz = true;
    private boolean dZa = true;
    private boolean dZb = true;
    private boolean dZc = true;
    private boolean dZd = true;
    private boolean dZe = true;
    private boolean dZf = true;
    private boolean djH = true;
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dlP = true;
    private boolean drR = true;
    private boolean dwB = true;
    public long field_accessTime;
    public String field_appId;
    public int field_autoDownloadCount;
    public boolean field_bigPackageReady;
    public String field_charset;
    public long field_checkIntervalTime;
    public long field_clearPkgTime;
    public long field_createTime;
    public boolean field_disable;
    public boolean field_disableWvCache;
    public String field_domain;
    public int field_downloadNetType;
    public int field_downloadTriggerType;
    public String field_downloadUrl;
    public String field_md5;
    public long field_nextCheckTime;
    public int field_packMethod;
    public int field_packageDownloadCount;
    public String field_pkgId;
    public String field_pkgPath;
    public int field_pkgSize;
    public boolean field_preloadFilesAtomic;
    public boolean field_preloadFilesReady;
    public int field_totalDownloadCount;
    public String field_version;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dXW == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                    this.dXR = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (dlV == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (dZg == hashCode) {
                    this.field_disableWvCache = cursor.getInt(i) != 0;
                } else if (dZh == hashCode) {
                    this.field_clearPkgTime = cursor.getLong(i);
                } else if (dZi == hashCode) {
                    this.field_checkIntervalTime = cursor.getLong(i);
                } else if (dZj == hashCode) {
                    this.field_packMethod = cursor.getInt(i);
                } else if (dYD == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dXZ == hashCode) {
                    this.field_pkgSize = cursor.getInt(i);
                } else if (dYa == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (dDI == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dYG == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (dZk == hashCode) {
                    this.field_charset = cursor.getString(i);
                } else if (dZl == hashCode) {
                    this.field_bigPackageReady = cursor.getInt(i) != 0;
                } else if (dZm == hashCode) {
                    this.field_preloadFilesReady = cursor.getInt(i) != 0;
                } else if (dZn == hashCode) {
                    this.field_preloadFilesAtomic = cursor.getInt(i) != 0;
                } else if (dYT == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (dYi == hashCode) {
                    this.field_disable = cursor.getInt(i) != 0;
                } else if (dZo == hashCode) {
                    this.field_totalDownloadCount = cursor.getInt(i);
                } else if (dZp == hashCode) {
                    this.field_packageDownloadCount = cursor.getInt(i);
                } else if (dZq == hashCode) {
                    this.field_downloadTriggerType = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dXR) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlM) {
            contentValues.put("version", this.field_version);
        }
        if (this.dlP) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.dYV) {
            contentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
        }
        if (this.dYW) {
            contentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
        }
        if (this.dYX) {
            contentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
        }
        if (this.dYY) {
            contentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
        }
        if (this.dYw) {
            contentValues.put("domain", this.field_domain);
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
        if (this.dDx) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dYz) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.field_charset == null) {
            this.field_charset = "UTF-8";
        }
        if (this.dYZ) {
            contentValues.put("charset", this.field_charset);
        }
        if (this.dZa) {
            contentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
        }
        if (this.dZb) {
            contentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
        }
        if (this.dZc) {
            contentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
        }
        if (this.dYO) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.dYd) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.dZd) {
            contentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
        }
        if (this.dZe) {
            contentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
        }
        if (this.dZf) {
            contentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
