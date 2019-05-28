package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class v extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnJ = "deviceId".hashCode();
    private static final int dnK = "sessionName".hashCode();
    private static final int dnL = "moveTime".hashCode();
    private boolean dnG = true;
    private boolean dnH = true;
    private boolean dnI = true;
    public String field_deviceId;
    public gp field_moveTime;
    public String field_sessionName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnJ == hashCode) {
                    this.field_deviceId = cursor.getString(i);
                } else if (dnK == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (dnL == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (gp) new gp().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.dnG) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.dnH) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.dnI && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
