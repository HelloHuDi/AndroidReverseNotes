package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.af */
public abstract class C45384af extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dmP = "openId".hashCode();
    private static final int dqi = "brandUsername".hashCode();
    private static final int dqj = "headImgUrl".hashCode();
    private static final int dqk = "nickname".hashCode();
    private static final int dql = "kfType".hashCode();
    private boolean dln = true;
    private boolean dms = true;
    private boolean dqe = true;
    private boolean dqf = true;
    private boolean dqg = true;
    private boolean dqh = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dmP == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.dms = true;
                } else if (dqi == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (dqj == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dql == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dms) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.dqe) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.dqf) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.dqh) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
