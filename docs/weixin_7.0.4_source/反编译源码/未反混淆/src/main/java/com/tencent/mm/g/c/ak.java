package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public abstract class ak extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int drO = "code_id".hashCode();
    private static final int drP = TMQQDownloaderOpenSDKConst.UINTYPE_CODE.hashCode();
    private static final int drk = "card_id".hashCode();
    private boolean diU = true;
    private boolean dqR = true;
    private boolean drM = true;
    private boolean drN = true;
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (drO == hashCode) {
                    this.field_code_id = cursor.getString(i);
                } else if (drk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (drP == hashCode) {
                    this.field_code = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.drM) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.dqR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.drN) {
            contentValues.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.field_code);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
