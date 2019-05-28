package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.protocal.protobuf.C44123gp;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.g.c.v */
public abstract class C45403v extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnJ = "deviceId".hashCode();
    private static final int dnK = "sessionName".hashCode();
    private static final int dnL = "moveTime".hashCode();
    private boolean dnG = true;
    private boolean dnH = true;
    private boolean dnI = true;
    public String field_deviceId;
    public C44123gp field_moveTime;
    public String field_sessionName;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                            this.field_moveTime = (C44123gp) new C44123gp().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
                C4990ab.m7412e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
