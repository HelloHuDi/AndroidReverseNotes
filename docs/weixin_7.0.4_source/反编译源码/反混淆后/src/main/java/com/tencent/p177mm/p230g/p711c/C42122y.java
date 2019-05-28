package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.y */
public abstract class C42122y extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnS = "appMsgReportContextId".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int dnU = "reportTime".hashCode();
    private static final int dnV = "aScene".hashCode();
    private boolean dnO = true;
    private boolean dnP = true;
    private boolean dnQ = true;
    private boolean dnR = true;
    public int field_aScene;
    public long field_appMsgReportContextId;
    public long field_reportTime;
    public String field_url;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnS == hashCode) {
                    this.field_appMsgReportContextId = cursor.getLong(i);
                    this.dnO = true;
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dnU == hashCode) {
                    this.field_reportTime = cursor.getLong(i);
                } else if (dnV == hashCode) {
                    this.field_aScene = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnO) {
            contentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dnQ) {
            contentValues.put("reportTime", Long.valueOf(this.field_reportTime));
        }
        if (this.dnR) {
            contentValues.put("aScene", Integer.valueOf(this.field_aScene));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
