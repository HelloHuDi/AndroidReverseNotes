package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ep extends c {
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

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "storyId";
        aVar.xDd.put("storyId", "LONG PRIMARY KEY ");
        stringBuilder.append(" storyId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "storyId";
        aVar.columns[1] = "readCommentId";
        aVar.xDd.put("readCommentId", "INTEGER");
        stringBuilder.append(" readCommentId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "syncCommentId";
        aVar.xDd.put("syncCommentId", "INTEGER");
        stringBuilder.append(" syncCommentId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "readCommentTime";
        aVar.xDd.put("readCommentTime", "INTEGER");
        stringBuilder.append(" readCommentTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "syncCommentTime";
        aVar.xDd.put("syncCommentTime", "INTEGER");
        stringBuilder.append(" syncCommentTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "commentFlag";
        aVar.xDd.put("commentFlag", "INTEGER");
        stringBuilder.append(" commentFlag INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
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

    public final ContentValues Hl() {
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
