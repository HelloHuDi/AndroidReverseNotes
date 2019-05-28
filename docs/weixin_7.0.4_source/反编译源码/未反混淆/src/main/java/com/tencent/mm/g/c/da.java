package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da extends c {
    private static final int dJM = "wxGroupId".hashCode();
    private static final int dJQ = "inviteUserName".hashCode();
    private static final int dJT = "memberUuid".hashCode();
    private static final int dJU = "memberId".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dkf = "createTime".hashCode();
    private boolean dJH = true;
    private boolean dJL = true;
    private boolean dJR = true;
    private boolean dJS = true;
    private boolean diU = true;
    private boolean djF = true;
    private boolean djH = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dJT == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (dJM == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (dJQ == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (dJU == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dJR) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.dJH) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.dJL) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.dJS) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
