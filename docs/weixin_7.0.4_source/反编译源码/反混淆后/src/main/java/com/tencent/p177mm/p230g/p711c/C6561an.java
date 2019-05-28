package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.p712j.p713a.p714a.C6595d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.g.c.an */
public abstract class C6561an extends C4925c {
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
    public C6595d field_seqBlockInfo;
    public String field_username;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                            this.field_seqBlockInfo = (C6595d) new C6595d().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseChatroomMsgSeq", e.getMessage());
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
                C4990ab.m7412e("MicroMsg.SDK.BaseChatroomMsgSeq", e.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
