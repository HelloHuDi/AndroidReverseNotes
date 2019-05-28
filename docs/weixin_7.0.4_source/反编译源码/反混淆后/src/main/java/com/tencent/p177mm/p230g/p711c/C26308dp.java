package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dp */
public abstract class C26308dp extends C4925c {
    private static final int dMK = "retryTimes".hashCode();
    private static final int dML = "retriedCount".hashCode();
    private static final int dMM = "retryInterval".hashCode();
    private static final int dMN = "networkType".hashCode();
    private static final int dMO = "pkgMd5".hashCode();
    private static final int dMP = "lastRetryTime".hashCode();
    private static final int dMQ = "firstTimeTried".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dmd = "reportId".hashCode();
    private boolean dMD = true;
    private boolean dME = true;
    private boolean dMF = true;
    private boolean dMG = true;
    private boolean dMH = true;
    private boolean dMI = true;
    private boolean dMJ = true;
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dma = true;
    public String field_appId;
    public boolean field_firstTimeTried;
    public long field_lastRetryTime;
    public int field_networkType;
    public String field_pkgMd5;
    public int field_reportId;
    public int field_retriedCount;
    public long field_retryInterval;
    public int field_retryTimes;
    public int field_type;
    public int field_version;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dMK == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (dML == hashCode) {
                    this.field_retriedCount = cursor.getInt(i);
                } else if (dMM == hashCode) {
                    this.field_retryInterval = cursor.getLong(i);
                } else if (dMN == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (dMO == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (dMP == hashCode) {
                    this.field_lastRetryTime = cursor.getLong(i);
                } else if (dMQ == hashCode) {
                    this.field_firstTimeTried = cursor.getInt(i) != 0;
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dMD) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.dME) {
            contentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
        }
        if (this.dMF) {
            contentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
        }
        if (this.dMG) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.dMH) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.dMI) {
            contentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
        }
        if (this.dMJ) {
            contentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
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
