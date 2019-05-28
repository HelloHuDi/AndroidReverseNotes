package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fh extends c {
    private static final int dVR = "wallet_region".hashCode();
    private static final int dWG = "wallet_grey_item_buf".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dVL = true;
    private boolean dWF = true;
    public byte[] field_wallet_grey_item_buf;
    public int field_wallet_region;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dVR == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.dVL = true;
                } else if (dWG == hashCode) {
                    this.field_wallet_grey_item_buf = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dVL) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.dWF) {
            contentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
