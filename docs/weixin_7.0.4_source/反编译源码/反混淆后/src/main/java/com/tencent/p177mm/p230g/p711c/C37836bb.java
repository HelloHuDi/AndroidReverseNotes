package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bb */
public abstract class C37836bb extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dwx = "lang".hashCode();
    private static final int dxn = "md5".hashCode();
    private static final int dxy = "groupId".hashCode();
    private static final int dyd = "md5_lang".hashCode();
    private static final int dye = "desc".hashCode();
    private static final int dyf = "click_flag".hashCode();
    private static final int dyg = "download_flag".hashCode();
    private boolean dvX = true;
    private boolean dwB = true;
    private boolean dwM = true;
    private boolean dxZ = true;
    private boolean dya = true;
    private boolean dyb = true;
    private boolean dyc = true;
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dyd == hashCode) {
                    this.field_md5_lang = cursor.getString(i);
                    this.dxZ = true;
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dwx == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (dye == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (dxy == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (dyf == hashCode) {
                    this.field_click_flag = cursor.getInt(i);
                } else if (dyg == hashCode) {
                    this.field_download_flag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dxZ) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dvX) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.dya) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.dwM) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.dyb) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.dyc) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
