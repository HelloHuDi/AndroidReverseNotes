package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dg */
public abstract class C18469dg extends C4925c {
    private static final int dLR = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int dLV = "appid".hashCode();
    private static final int dMb = "wordingId".hashCode();
    private static final int dMc = "wording".hashCode();
    private static final int dMd = "pinyin".hashCode();
    private static final int dMe = "quanpin".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean dLO = true;
    private boolean dLT = true;
    private boolean dLX = true;
    private boolean dLY = true;
    private boolean dLZ = true;
    private boolean dMa = true;
    private boolean dln = true;
    public String field_appid;
    public String field_language;
    public String field_pinyin;
    public String field_quanpin;
    public long field_updateTime;
    public String field_wording;
    public String field_wordingId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dLV == hashCode) {
                    this.field_appid = cursor.getString(i);
                } else if (dMb == hashCode) {
                    this.field_wordingId = cursor.getString(i);
                } else if (dLR == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (dMc == hashCode) {
                    this.field_wording = cursor.getString(i);
                } else if (dMd == hashCode) {
                    this.field_pinyin = cursor.getString(i);
                } else if (dMe == hashCode) {
                    this.field_quanpin = cursor.getString(i);
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
        if (this.dLT) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.dLX) {
            contentValues.put("wordingId", this.field_wordingId);
        }
        if (this.dLO) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.dLY) {
            contentValues.put("wording", this.field_wording);
        }
        if (this.dLZ) {
            contentValues.put("pinyin", this.field_pinyin);
        }
        if (this.dMa) {
            contentValues.put("quanpin", this.field_quanpin);
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
