package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class bd extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dyk = "designerIDAndType".hashCode();
    private boolean djP = true;
    private boolean dyj = true;
    public byte[] field_content;
    public String field_designerIDAndType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dyk == hashCode) {
                    this.field_designerIDAndType = cursor.getString(i);
                    this.dyj = true;
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dyj) {
            contentValues.put("designerIDAndType", this.field_designerIDAndType);
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
