package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.ep */
public abstract class C18474ep extends C4925c {
    private static final int dSf = "storyId".hashCode();
    private static final int dSg = "readCommentId".hashCode();
    private static final int dSh = "syncCommentId".hashCode();
    private static final int dSi = "readCommentTime".hashCode();
    private static final int dSj = "syncCommentTime".hashCode();
    private static final int dSk = "commentFlag".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dRZ = true;
    private boolean dSa = true;
    private boolean dSb = true;
    private boolean dSc = true;
    private boolean dSd = true;
    private boolean dSe = true;
    public int field_commentFlag;
    public int field_readCommentId;
    public int field_readCommentTime;
    public long field_storyId;
    public int field_syncCommentId;
    public int field_syncCommentTime;

    /* renamed from: Hm */
    public static C4924a m28756Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "storyId";
        c4924a.xDd.put("storyId", "LONG PRIMARY KEY ");
        stringBuilder.append(" storyId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "storyId";
        c4924a.columns[1] = "readCommentId";
        c4924a.xDd.put("readCommentId", "INTEGER");
        stringBuilder.append(" readCommentId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "syncCommentId";
        c4924a.xDd.put("syncCommentId", "INTEGER");
        stringBuilder.append(" syncCommentId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "readCommentTime";
        c4924a.xDd.put("readCommentTime", "INTEGER");
        stringBuilder.append(" readCommentTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "syncCommentTime";
        c4924a.xDd.put("syncCommentTime", "INTEGER");
        stringBuilder.append(" syncCommentTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "commentFlag";
        c4924a.xDd.put("commentFlag", "INTEGER");
        stringBuilder.append(" commentFlag INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dSf == hashCode) {
                    this.field_storyId = cursor.getLong(i);
                    this.dRZ = true;
                } else if (dSg == hashCode) {
                    this.field_readCommentId = cursor.getInt(i);
                } else if (dSh == hashCode) {
                    this.field_syncCommentId = cursor.getInt(i);
                } else if (dSi == hashCode) {
                    this.field_readCommentTime = cursor.getInt(i);
                } else if (dSj == hashCode) {
                    this.field_syncCommentTime = cursor.getInt(i);
                } else if (dSk == hashCode) {
                    this.field_commentFlag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dRZ) {
            contentValues.put("storyId", Long.valueOf(this.field_storyId));
        }
        if (this.dSa) {
            contentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
        }
        if (this.dSb) {
            contentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
        }
        if (this.dSc) {
            contentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
        }
        if (this.dSd) {
            contentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
        }
        if (this.dSe) {
            contentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
