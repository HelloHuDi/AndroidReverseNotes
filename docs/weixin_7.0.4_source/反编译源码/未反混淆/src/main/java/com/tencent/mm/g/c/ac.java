package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int doM = "headImageUrl".hashCode();
    private static final int doQ = "needToUpdate".hashCode();
    private static final int doR = "bitFlag".hashCode();
    private static final int doV = "addMemberUrl".hashCode();
    private static final int doX = "userId".hashCode();
    private static final int dol = "brandUserName".hashCode();
    private static final int dpb = "userNamePY".hashCode();
    private static final int dpc = "UserVersion".hashCode();
    private static final int dpd = "profileUrl".hashCode();
    private boolean djF = true;
    private boolean dnX = true;
    private boolean doA = true;
    private boolean doE = true;
    private boolean doF = true;
    private boolean doJ = true;
    private boolean doW = true;
    private boolean doY = true;
    private boolean doZ = true;
    private boolean dpa = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (doX == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.doW = true;
                } else if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (dpb == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (dol == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (dpc == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (doQ == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (doM == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (dpd == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (doR == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (doV == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.doW) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.doY) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.dnX) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.doZ) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.doE) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.doA) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.dpa) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.doF) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.doJ) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
