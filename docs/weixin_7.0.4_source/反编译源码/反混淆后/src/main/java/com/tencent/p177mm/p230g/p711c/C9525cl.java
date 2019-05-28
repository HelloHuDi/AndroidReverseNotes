package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cl */
public abstract class C9525cl extends C4925c {
    private static final int dFV = "pushTime".hashCode();
    private static final int dFW = "descUrl".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dow = "msgType".hashCode();
    private static final int dqH = "isRead".hashCode();
    private static final int dzp = "svrId".hashCode();
    private boolean dFT = true;
    private boolean dFU = true;
    private boolean djP = true;
    private boolean dnx = true;
    private boolean doi = true;
    private boolean dqw = true;
    private boolean dzm = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzp == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.dzm = true;
                } else if (dqH == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dFV == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (dow == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (dFW == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzm) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.dqw) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.dFT) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.doi) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.dFU) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
