package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.be */
public abstract class C45387be extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int dwb = "productID".hashCode();
    private static final int dym = "lan".hashCode();
    private boolean djP = true;
    private boolean dvB = true;
    private boolean dyl = true;
    public byte[] field_content;
    public String field_lan;
    public String field_productID;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dwb == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.dvB = true;
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (dym == hashCode) {
                    this.field_lan = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dvB) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.dyl) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
