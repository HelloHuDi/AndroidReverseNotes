package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class fp extends c {
    private static final int dDp = "expireTime".hashCode();
    private static final int dLg = "protocol".hashCode();
    private static final int dOM = "packageId".hashCode();
    private static final int dOu = "contentLength".hashCode();
    private static final int dOv = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int dYC = "urlMd5Hashcode".hashCode();
    private static final int dYD = "domain".hashCode();
    private static final int dYE = "localPath".hashCode();
    private static final int dYF = "isLatestVersion".hashCode();
    private static final int dYG = "accessTime".hashCode();
    private static final int dYH = "cacheType".hashCode();
    private static final int dYI = "contentMd5".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int dzC = "configId".hashCode();
    private boolean dDh = true;
    private boolean dKz = true;
    private boolean dNX = true;
    private boolean dNY = true;
    private boolean dOp = true;
    private boolean dYA = true;
    private boolean dYB = true;
    private boolean dYv = true;
    private boolean dYw = true;
    private boolean dYx = true;
    private boolean dYy = true;
    private boolean dYz = true;
    private boolean djH = true;
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dnP = true;
    private boolean dzB = true;
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dYC == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dYD == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (dYE == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (dOv == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (dOu == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (dYF == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dYG == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (dYH == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (dzC == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (dLg == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (dOM == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (dYI == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dYv) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dYw) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.dlM) {
            contentValues.put("version", this.field_version);
        }
        if (this.dYx) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.dNY) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.dNX) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.dYy) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dYz) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.dYA) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.dzB) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.dKz) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.dOp) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.dYB) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
