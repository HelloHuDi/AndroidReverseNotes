package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ez */
public abstract class C32694ez extends C4925c {
    private static final int dGw = "createtime".hashCode();
    private static final int dTT = "filename".hashCode();
    private static final int dTU = "user".hashCode();
    private static final int dTV = "msgid".hashCode();
    private static final int dTW = "filenowsize".hashCode();
    private static final int dTX = "totallen".hashCode();
    private static final int dTY = "lastmodifytime".hashCode();
    private static final int dTZ = "clientid".hashCode();
    private static final int dUa = "voicelenght".hashCode();
    private static final int dUb = "msglocalid".hashCode();
    private static final int dUc = "human".hashCode();
    private static final int dUd = "voiceformat".hashCode();
    private static final int dUe = "nettimes".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dlb = "offset".hashCode();
    private static final int dxt = "reserved1".hashCode();
    private static final int dxu = "reserved2".hashCode();
    private boolean dGr = true;
    private boolean dTH = true;
    private boolean dTI = true;
    private boolean dTJ = true;
    private boolean dTK = true;
    private boolean dTL = true;
    private boolean dTM = true;
    private boolean dTN = true;
    private boolean dTO = true;
    private boolean dTP = true;
    private boolean dTQ = true;
    private boolean dTR = true;
    private boolean dTS = true;
    private boolean diU = true;
    private boolean dkK = true;
    private boolean dwH = true;
    private boolean dwI = true;
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dTT == hashCode) {
                    this.field_filename = cursor.getString(i);
                } else if (dTU == hashCode) {
                    this.field_user = cursor.getString(i);
                } else if (dTV == hashCode) {
                    this.field_msgid = cursor.getLong(i);
                } else if (dlb == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (dTW == hashCode) {
                    this.field_filenowsize = cursor.getInt(i);
                } else if (dTX == hashCode) {
                    this.field_totallen = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dGw == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (dTY == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i);
                } else if (dTZ == hashCode) {
                    this.field_clientid = cursor.getString(i);
                } else if (dUa == hashCode) {
                    this.field_voicelenght = cursor.getInt(i);
                } else if (dUb == hashCode) {
                    this.field_msglocalid = cursor.getInt(i);
                } else if (dUc == hashCode) {
                    this.field_human = cursor.getString(i);
                } else if (dUd == hashCode) {
                    this.field_voiceformat = cursor.getInt(i);
                } else if (dUe == hashCode) {
                    this.field_nettimes = cursor.getInt(i);
                } else if (dxt == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (dxu == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dTH) {
            contentValues.put("filename", this.field_filename);
        }
        if (this.dTI) {
            contentValues.put("user", this.field_user);
        }
        if (this.dTJ) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.dkK) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.dTK) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.dTL) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dGr) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.dTM) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.dTN) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.dTO) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.dTP) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.dTQ) {
            contentValues.put("human", this.field_human);
        }
        if (this.dTR) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.dTS) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.dwH) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.dwI) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
