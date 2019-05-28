package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.aa */
public abstract class C32680aa extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int doK = "bizChatLocalId".hashCode();
    private static final int doL = "bizChatServId".hashCode();
    private static final int doM = "headImageUrl".hashCode();
    private static final int doN = "chatName".hashCode();
    private static final int doO = "chatNamePY".hashCode();
    private static final int doP = "chatVersion".hashCode();
    private static final int doQ = "needToUpdate".hashCode();
    private static final int doR = "bitFlag".hashCode();
    private static final int doS = "maxMemberCnt".hashCode();
    private static final int doT = "ownerUserId".hashCode();
    private static final int doU = "userList".hashCode();
    private static final int doV = "addMemberUrl".hashCode();
    private static final int dol = "brandUserName".hashCode();
    private static final int dou = "chatType".hashCode();
    private boolean dnX = true;
    private boolean doA = true;
    private boolean doB = true;
    private boolean doC = true;
    private boolean doD = true;
    private boolean doE = true;
    private boolean doF = true;
    private boolean doG = true;
    private boolean doH = true;
    private boolean doI = true;
    private boolean doJ = true;
    private boolean dog = true;
    private boolean doy = true;
    private boolean doz = true;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (doK == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.doy = true;
                } else if (doL == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (dol == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (dou == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (doM == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (doN == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (doO == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (doP == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (doQ == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (doR == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (doS == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (doT == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (doU == hashCode) {
                    this.field_userList = cursor.getString(i);
                } else if (doV == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.doy) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.doz) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.dnX) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.dog) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.doA) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.doB) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.doC) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.doD) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.doE) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.doF) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.doG) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.doH) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.doI) {
            contentValues.put("userList", this.field_userList);
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
