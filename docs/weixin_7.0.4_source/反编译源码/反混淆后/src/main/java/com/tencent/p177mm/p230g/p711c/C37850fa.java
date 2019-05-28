package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fa */
public abstract class C37850fa extends C4925c {
    private static final int dUg = "cmsgId".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private boolean dUf = true;
    private boolean diM = true;
    private boolean djP = true;
    public String field_cmsgId;
    public String field_content;
    public long field_msgId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.diM = true;
                } else if (dUg == hashCode) {
                    this.field_cmsgId = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dUf) {
            contentValues.put("cmsgId", this.field_cmsgId);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
