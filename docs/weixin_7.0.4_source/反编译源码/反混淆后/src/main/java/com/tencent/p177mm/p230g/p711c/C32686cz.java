package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cz */
public abstract class C32686cz extends C4925c {
    private static final int dJM = "wxGroupId".hashCode();
    private static final int dJN = "roomId".hashCode();
    private static final int dJO = "roomKey".hashCode();
    private static final int dJP = "routeId".hashCode();
    private static final int dJQ = "inviteUserName".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dsU = "memberCount".hashCode();
    private static final int dxr = "state".hashCode();
    private static final int dxy = "groupId".hashCode();
    private boolean dJH = true;
    private boolean dJI = true;
    private boolean dJJ = true;
    private boolean dJK = true;
    private boolean dJL = true;
    private boolean djH = true;
    private boolean dsA = true;
    private boolean dwF = true;
    private boolean dwM = true;
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dJM == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.dJH = true;
                } else if (dxy == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (dJN == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (dJO == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (dJP == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (dJQ == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (dsU == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dxr == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dJH) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.dwM) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.dJI) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.dJJ) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.dJK) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.dJL) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.dsA) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dwF) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
