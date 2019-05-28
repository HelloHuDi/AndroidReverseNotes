package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cx extends c {
    private static final int dJe = "storyID".hashCode();
    private static final int dJf = "commentListCount".hashCode();
    private static final int dJg = "itemStoryFlag".hashCode();
    private static final int dJh = "readCount".hashCode();
    private static final int dJi = "favoriteTime".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dke = "localFlag".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkj = "sourceType".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dko = "attrBuf".hashCode();
    private static final int dkp = "postBuf".hashCode();
    private boolean dIZ = true;
    private boolean dJa = true;
    private boolean dJb = true;
    private boolean dJc = true;
    private boolean dJd = true;
    private boolean djF = true;
    private boolean djG = true;
    private boolean djH = true;
    private boolean djK = true;
    private boolean djL = true;
    private boolean djP = true;
    private boolean djQ = true;
    private boolean djR = true;
    public byte[] field_attrBuf;
    public int field_commentListCount;
    public byte[] field_content;
    public int field_createTime;
    public int field_favoriteTime;
    public int field_itemStoryFlag;
    public int field_localFlag;
    public byte[] field_postBuf;
    public int field_readCount;
    public int field_sourceType;
    public long field_storyID;
    public int field_type;
    public String field_userName;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "storyID";
        aVar.xDd.put("storyID", "LONG");
        stringBuilder.append(" storyID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.xDd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "commentListCount";
        aVar.xDd.put("commentListCount", "INTEGER");
        stringBuilder.append(" commentListCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "attrBuf";
        aVar.xDd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "postBuf";
        aVar.xDd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.xDd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "itemStoryFlag";
        aVar.xDd.put("itemStoryFlag", "INTEGER");
        stringBuilder.append(" itemStoryFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "readCount";
        aVar.xDd.put("readCount", "INTEGER");
        stringBuilder.append(" readCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "favoriteTime";
        aVar.xDd.put("favoriteTime", "INTEGER");
        stringBuilder.append(" favoriteTime INTEGER");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dJe == hashCode) {
                    this.field_storyID = cursor.getLong(i);
                } else if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (dke == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (dJf == hashCode) {
                    this.field_commentListCount = cursor.getInt(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (dko == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (dkp == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (dkj == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dJg == hashCode) {
                    this.field_itemStoryFlag = cursor.getInt(i);
                } else if (dJh == hashCode) {
                    this.field_readCount = cursor.getInt(i);
                } else if (dJi == hashCode) {
                    this.field_favoriteTime = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dIZ) {
            contentValues.put("storyID", Long.valueOf(this.field_storyID));
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.djG) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.djH) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.dJa) {
            contentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.djQ) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.djR) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.djL) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dJb) {
            contentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
        }
        if (this.dJc) {
            contentValues.put("readCount", Integer.valueOf(this.field_readCount));
        }
        if (this.dJd) {
            contentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
