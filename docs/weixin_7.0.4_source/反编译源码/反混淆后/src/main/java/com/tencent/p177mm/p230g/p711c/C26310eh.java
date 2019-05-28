package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

/* renamed from: com.tencent.mm.g.c.eh */
public abstract class C26310eh extends C4925c {
    private static final int dBg = DownloadInfo.FILENAME.hashCode();
    private static final int dQO = "cnValue".hashCode();
    private static final int dQP = "qqValue".hashCode();
    private static final int dQQ = "twValue".hashCode();
    private static final int dQR = "enValue".hashCode();
    private static final int dQS = "thValue".hashCode();
    private static final int dQT = "eggIndex".hashCode();
    private static final int dQU = "position".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int dnE = "flag".hashCode();
    private boolean dAK = true;
    private boolean dQH = true;
    private boolean dQI = true;
    private boolean dQJ = true;
    private boolean dQK = true;
    private boolean dQL = true;
    private boolean dQM = true;
    private boolean dQN = true;
    private boolean djw = true;
    private boolean dnC = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djA == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.djw = true;
                } else if (dQO == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (dQP == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (dQQ == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (dQR == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (dQS == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (dBg == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (dQT == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (dQU == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djw) {
            contentValues.put("key", this.field_key);
        }
        if (this.dQH) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.dQI) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.dQJ) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.dQK) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.dQL) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.dAK) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.dQM) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.dQN) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
