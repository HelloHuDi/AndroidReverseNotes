package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.protocal.protobuf.chg;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.IOException;

/* renamed from: com.tencent.mm.g.c.dc */
public abstract class C42107dc extends C4925c {
    private static final int dLA = "hadRead".hashCode();
    private static final int dLB = "isReject".hashCode();
    private static final int dLC = "beginShowTime".hashCode();
    private static final int dLD = "disappearTime".hashCode();
    private static final int dLE = "overdueTime".hashCode();
    private static final int dLF = "tipsShowInfo".hashCode();
    private static final int dLG = "pagestaytime".hashCode();
    private static final int dLv = "tipId".hashCode();
    private static final int dLw = "tipVersion".hashCode();
    private static final int dLx = "tipkey".hashCode();
    private static final int dLy = "tipType".hashCode();
    private static final int dLz = "isExit".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dpU = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private boolean dLj = true;
    private boolean dLk = true;
    private boolean dLl = true;
    private boolean dLm = true;
    private boolean dLn = true;
    private boolean dLo = true;
    private boolean dLp = true;
    private boolean dLq = true;
    private boolean dLr = true;
    private boolean dLs = true;
    private boolean dLt = true;
    private boolean dLu = true;
    private boolean dpG = true;
    public long field_beginShowTime;
    public long field_disappearTime;
    public String field_extInfo;
    public boolean field_hadRead;
    public boolean field_isExit;
    public boolean field_isReject;
    public long field_overdueTime;
    public long field_pagestaytime;
    public int field_tipId;
    public int field_tipType;
    public int field_tipVersion;
    public String field_tipkey;
    public chg field_tipsShowInfo;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dLv == hashCode) {
                    this.field_tipId = cursor.getInt(i);
                    this.dLj = true;
                } else if (dLw == hashCode) {
                    this.field_tipVersion = cursor.getInt(i);
                } else if (dLx == hashCode) {
                    this.field_tipkey = cursor.getString(i);
                } else if (dLy == hashCode) {
                    this.field_tipType = cursor.getInt(i);
                } else if (dLz == hashCode) {
                    this.field_isExit = cursor.getInt(i) != 0;
                } else if (dLA == hashCode) {
                    this.field_hadRead = cursor.getInt(i) != 0;
                } else if (dLB == hashCode) {
                    this.field_isReject = cursor.getInt(i) != 0;
                } else if (dLC == hashCode) {
                    this.field_beginShowTime = cursor.getLong(i);
                } else if (dLD == hashCode) {
                    this.field_disappearTime = cursor.getLong(i);
                } else if (dLE == hashCode) {
                    this.field_overdueTime = cursor.getLong(i);
                } else if (dLF == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tipsShowInfo = (chg) new chg().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
                    }
                } else if (dpU == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (dLG == hashCode) {
                    this.field_pagestaytime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dLj) {
            contentValues.put("tipId", Integer.valueOf(this.field_tipId));
        }
        if (this.dLk) {
            contentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
        }
        if (this.dLl) {
            contentValues.put("tipkey", this.field_tipkey);
        }
        if (this.dLm) {
            contentValues.put("tipType", Integer.valueOf(this.field_tipType));
        }
        if (this.dLn) {
            contentValues.put("isExit", Boolean.valueOf(this.field_isExit));
        }
        if (this.dLo) {
            contentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
        }
        if (this.dLp) {
            contentValues.put("isReject", Boolean.valueOf(this.field_isReject));
        }
        if (this.dLq) {
            contentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
        }
        if (this.dLr) {
            contentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
        }
        if (this.dLs) {
            contentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
        }
        if (this.dLt && this.field_tipsShowInfo != null) {
            try {
                contentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
            }
        }
        if (this.dpG) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.dLu) {
            contentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
