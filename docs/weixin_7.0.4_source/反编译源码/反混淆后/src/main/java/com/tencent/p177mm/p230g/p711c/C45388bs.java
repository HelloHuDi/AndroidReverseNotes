package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bs */
public abstract class C45388bs extends C4925c {
    private static final int dBH = "ForcePushId".hashCode();
    private static final int dBI = "CreateTime".hashCode();
    private static final int dBJ = "ExpiredTime".hashCode();
    private static final int dBK = "Description".hashCode();
    private static final int dBL = "UserIcon".hashCode();
    private static final int dBM = "UserName".hashCode();
    private static final int dBN = "Extinfo".hashCode();
    private static final int dBO = "Status".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dBA = true;
    private boolean dBB = true;
    private boolean dBC = true;
    private boolean dBD = true;
    private boolean dBE = true;
    private boolean dBF = true;
    private boolean dBG = true;
    private boolean dBz = true;
    public long field_CreateTime;
    public String field_Description;
    public long field_ExpiredTime;
    public String field_Extinfo;
    public String field_ForcePushId;
    public int field_Status;
    public String field_UserIcon;
    public String field_UserName;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dBH == hashCode) {
                    this.field_ForcePushId = cursor.getString(i);
                } else if (dBI == hashCode) {
                    this.field_CreateTime = cursor.getLong(i);
                } else if (dBJ == hashCode) {
                    this.field_ExpiredTime = cursor.getLong(i);
                } else if (dBK == hashCode) {
                    this.field_Description = cursor.getString(i);
                } else if (dBL == hashCode) {
                    this.field_UserIcon = cursor.getString(i);
                } else if (dBM == hashCode) {
                    this.field_UserName = cursor.getString(i);
                    this.dBE = true;
                } else if (dBN == hashCode) {
                    this.field_Extinfo = cursor.getString(i);
                } else if (dBO == hashCode) {
                    this.field_Status = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dBz) {
            contentValues.put("ForcePushId", this.field_ForcePushId);
        }
        if (this.dBA) {
            contentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
        }
        if (this.dBB) {
            contentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
        }
        if (this.dBC) {
            contentValues.put("Description", this.field_Description);
        }
        if (this.dBD) {
            contentValues.put("UserIcon", this.field_UserIcon);
        }
        if (this.dBE) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.dBF) {
            contentValues.put("Extinfo", this.field_Extinfo);
        }
        if (this.dBG) {
            contentValues.put("Status", Integer.valueOf(this.field_Status));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
