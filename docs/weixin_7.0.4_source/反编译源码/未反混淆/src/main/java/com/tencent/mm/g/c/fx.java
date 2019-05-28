package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class fx extends c {
    private static final int dMk = "msgState".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int eah = "shareKeyHash".hashCode();
    private static final int eai = "btnState".hashCode();
    private static final int eaj = "contentColor".hashCode();
    private static final int eak = "updatePeroid".hashCode();
    private boolean dMh = true;
    private boolean djP = true;
    private boolean ead = true;
    private boolean eae = true;
    private boolean eaf = true;
    private boolean eag = true;
    public int field_btnState;
    public String field_content;
    public String field_contentColor;
    public int field_msgState;
    public int field_shareKeyHash;
    public int field_updatePeroid;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (eah == hashCode) {
                    this.field_shareKeyHash = cursor.getInt(i);
                    this.ead = true;
                } else if (eai == hashCode) {
                    this.field_btnState = cursor.getInt(i);
                } else if (dMk == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (eaj == hashCode) {
                    this.field_contentColor = cursor.getString(i);
                } else if (eak == hashCode) {
                    this.field_updatePeroid = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.ead) {
            contentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
        }
        if (this.eae) {
            contentValues.put("btnState", Integer.valueOf(this.field_btnState));
        }
        if (this.dMh) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.eaf) {
            contentValues.put("contentColor", this.field_contentColor);
        }
        if (this.eag) {
            contentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
