package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.cx */
public abstract class C45394cx extends C4925c {
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
    private static final int dkn = C8741b.CONTENT.hashCode();
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

    /* renamed from: Hm */
    public static C4924a m83580Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "storyID";
        c4924a.xDd.put("storyID", "LONG");
        stringBuilder.append(" storyID LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "userName";
        c4924a.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "localFlag";
        c4924a.xDd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createTime";
        c4924a.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "commentListCount";
        c4924a.xDd.put("commentListCount", "INTEGER");
        stringBuilder.append(" commentListCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        c4924a.columns[6] = "attrBuf";
        c4924a.xDd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[7] = "postBuf";
        c4924a.xDd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[8] = "sourceType";
        c4924a.xDd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "itemStoryFlag";
        c4924a.xDd.put("itemStoryFlag", "INTEGER");
        stringBuilder.append(" itemStoryFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "readCount";
        c4924a.xDd.put("readCount", "INTEGER");
        stringBuilder.append(" readCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "favoriteTime";
        c4924a.xDd.put("favoriteTime", "INTEGER");
        stringBuilder.append(" favoriteTime INTEGER");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
            contentValues.put(C8741b.CONTENT, this.field_content);
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
