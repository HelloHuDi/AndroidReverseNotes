package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class dv extends c {
    private static final int dAb = "toUser".hashCode();
    private static final int dNM = "oriMsgId".hashCode();
    private static final int dNN = "dataProto".hashCode();
    private static final int dNO = "favFrom".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dye = "desc".hashCode();
    private static final int dzF = "localId".hashCode();
    private boolean dNJ = true;
    private boolean dNK = true;
    private boolean dNL = true;
    private boolean diM = true;
    private boolean diU = true;
    private boolean djK = true;
    private boolean dnx = true;
    private boolean dya = true;
    private boolean dzD = true;
    private boolean dzN = true;
    public abf field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzF == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.dzD = true;
                } else if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (dNM == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i);
                } else if (dAb == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dye == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (dNN == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (abf) new abf().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
                    }
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dNO == hashCode) {
                    this.field_favFrom = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dNJ) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.dzN) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dya) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.dNK && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
            }
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dNL) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
