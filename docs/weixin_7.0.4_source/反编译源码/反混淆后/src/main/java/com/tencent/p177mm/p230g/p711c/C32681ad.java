package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ad */
public abstract class C32681ad extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dpA = "show_confirm".hashCode();
    private static final int dpB = "use_preset_banner_tips".hashCode();
    private static final int dpq = "qyUin".hashCode();
    private static final int dpr = "userUin".hashCode();
    private static final int dps = "userFlag".hashCode();
    private static final int dpt = "wwExposeTimes".hashCode();
    private static final int dpu = "wwMaxExposeTimes".hashCode();
    private static final int dpv = "wwCorpId".hashCode();
    private static final int dpw = "wwUserVid".hashCode();
    private static final int dpx = "userType".hashCode();
    private static final int dpy = "chatOpen".hashCode();
    private static final int dpz = "wwUnreadCnt".hashCode();
    private boolean djF = true;
    private boolean dpe = true;
    private boolean dpf = true;
    private boolean dpg = true;
    private boolean dph = true;
    private boolean dpi = true;
    private boolean dpj = true;
    private boolean dpk = true;
    private boolean dpl = true;
    private boolean dpm = true;
    private boolean dpn = true;
    private boolean dpo = true;
    private boolean dpp = true;
    public boolean field_chatOpen;
    public int field_qyUin;
    public boolean field_show_confirm;
    public boolean field_use_preset_banner_tips;
    public int field_userFlag;
    public String field_userName;
    public int field_userType;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public int field_wwUnreadCnt;
    public long field_wwUserVid;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.djF = true;
                } else if (dpq == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (dpr == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (dps == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (dpt == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i);
                } else if (dpu == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i);
                } else if (dpv == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i);
                } else if (dpw == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i);
                } else if (dpx == hashCode) {
                    this.field_userType = cursor.getInt(i);
                } else if (dpy == hashCode) {
                    this.field_chatOpen = cursor.getInt(i) != 0;
                } else if (dpz == hashCode) {
                    this.field_wwUnreadCnt = cursor.getInt(i);
                } else if (dpA == hashCode) {
                    this.field_show_confirm = cursor.getInt(i) != 0;
                } else if (dpB == hashCode) {
                    this.field_use_preset_banner_tips = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.dpe) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.dpf) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.dpg) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.dph) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.dpi) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.dpj) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.dpk) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.dpl) {
            contentValues.put("userType", Integer.valueOf(this.field_userType));
        }
        if (this.dpm) {
            contentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
        }
        if (this.dpn) {
            contentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
        }
        if (this.dpo) {
            contentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
        }
        if (this.dpp) {
            contentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
