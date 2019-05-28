package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class an extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dta = "lastPushSeq".hashCode();
    private static final int dtb = "lastLocalSeq".hashCode();
    private static final int dtc = "lastPushCreateTime".hashCode();
    private static final int dtd = "lastLocalCreateTime".hashCode();
    private static final int dte = "seqBlockInfo".hashCode();
    private boolean dlm = true;
    private boolean dsV = true;
    private boolean dsW = true;
    private boolean dsX = true;
    private boolean dsY = true;
    private boolean dsZ = true;
    public long field_lastLocalCreateTime;
    public long field_lastLocalSeq;
    public long field_lastPushCreateTime;
    public long field_lastPushSeq;
    public d field_seqBlockInfo;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dta == hashCode) {
                    this.field_lastPushSeq = cursor.getLong(i);
                } else if (dtb == hashCode) {
                    this.field_lastLocalSeq = cursor.getLong(i);
                } else if (dtc == hashCode) {
                    this.field_lastPushCreateTime = cursor.getLong(i);
                } else if (dtd == hashCode) {
                    this.field_lastLocalCreateTime = cursor.getLong(i);
                } else if (dte == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_seqBlockInfo = (d) new d().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseChatroomMsgSeq", e.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dsV) {
            contentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
        }
        if (this.dsW) {
            contentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
        }
        if (this.dsX) {
            contentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
        }
        if (this.dsY) {
            contentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
        }
        if (this.dsZ && this.field_seqBlockInfo != null) {
            try {
                contentValues.put("seqBlockInfo", this.field_seqBlockInfo.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseChatroomMsgSeq", e.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
