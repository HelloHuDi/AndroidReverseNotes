package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

/* renamed from: com.tencent.mm.g.c.dh */
public abstract class C42108dh extends C4925c {
    private static final int dMi = "sceneFlag".hashCode();
    private static final int dMj = "msgTypeFlag".hashCode();
    private static final int dMk = "msgState".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dmH = DownloadInfoColumns.PACKAGENAME.hashCode();
    private boolean dMf = true;
    private boolean dMg = true;
    private boolean dMh = true;
    private boolean diU = true;
    private boolean dkE = true;
    private boolean dmk = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;

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
                } else if (dmH == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dMi == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (dMj == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (dMk == hashCode) {
                    this.field_msgState = cursor.getInt(i);
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
        if (this.dmk) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dMf) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.dMg) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.dMh) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
