package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class o extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlJ = "recommendCard".hashCode();
    private boolean dkE = true;
    private boolean dlI = true;
    public String field_appId;
    public bqd field_recommendCard;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.dkE = true;
                } else if (dlJ == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_recommendCard = (bqd) new bqd().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseAppBrandRecommendCard", e.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlI && this.field_recommendCard != null) {
            try {
                contentValues.put("recommendCard", this.field_recommendCard.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseAppBrandRecommendCard", e.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
