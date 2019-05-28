package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class de extends c {
    private static final int dLQ = "acctTypeId".hashCode();
    private static final int dLR = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int dLS = "accTypeRec".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean dLN = true;
    private boolean dLO = true;
    private boolean dLP = true;
    private boolean dln = true;
    public as field_accTypeRec;
    public String field_acctTypeId;
    public String field_language;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dLQ == hashCode) {
                    this.field_acctTypeId = cursor.getString(i);
                } else if (dLR == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (dLS == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_accTypeRec = (as) new as().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
                    }
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dLN) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.dLO) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.dLP && this.field_accTypeRec != null) {
            try {
                contentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
            }
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
