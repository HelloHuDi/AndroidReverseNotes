package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    private static final int dAA = "tag".hashCode();
    private static final int dAm = "subtype".hashCode();
    private static final int dGw = "createtime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dxo = "svrid".hashCode();
    private static final int dxt = "reserved1".hashCode();
    private static final int dxu = "reserved2".hashCode();
    private static final int dxv = "reserved3".hashCode();
    private static final int dye = "desc".hashCode();
    private static final int qrt = "thumburl".hashCode();
    private static final int qru = "reservedBuf".hashCode();
    private boolean dAk = true;
    private boolean dAq = true;
    private boolean dGr = true;
    private boolean diU = true;
    private boolean djK = true;
    private boolean dnx = true;
    private boolean dwC = true;
    private boolean dwH = true;
    private boolean dwI = true;
    private boolean dwJ = true;
    private boolean dya = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean qrr = true;
    private boolean qrs = true;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dxo == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.dwC = true;
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dAm == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (dGw == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (dAA == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dye == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (qrt == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (dxt == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (dxu == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (dxv == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (qru == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dwC) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dAk) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.dGr) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.dAq) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dya) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.qrr) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.dwH) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.dwI) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.dwJ) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.qrs) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
