package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class es extends c {
    private static final int dSK = "userStoryFlag".hashCode();
    private static final int dTb = "roomname".hashCode();
    private static final int dTc = "newStoryList".hashCode();
    private static final int dTd = "extbuf".hashCode();
    private static final int dTe = "nextSyncTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dSX = true;
    private boolean dSY = true;
    private boolean dSZ = true;
    private boolean dSx = true;
    private boolean dTa = true;
    public byte[] field_extbuf;
    public String field_newStoryList;
    public long field_nextSyncTime;
    public String field_roomname;
    public int field_userStoryFlag;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "roomname";
        aVar.xDd.put("roomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "roomname";
        aVar.columns[1] = "userStoryFlag";
        aVar.xDd.put("userStoryFlag", "INTEGER");
        stringBuilder.append(" userStoryFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "newStoryList";
        aVar.xDd.put("newStoryList", "TEXT");
        stringBuilder.append(" newStoryList TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "extbuf";
        aVar.xDd.put("extbuf", "BLOB");
        stringBuilder.append(" extbuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "nextSyncTime";
        aVar.xDd.put("nextSyncTime", "LONG");
        stringBuilder.append(" nextSyncTime LONG");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dTb == hashCode) {
                    this.field_roomname = cursor.getString(i);
                    this.dSX = true;
                } else if (dSK == hashCode) {
                    this.field_userStoryFlag = cursor.getInt(i);
                } else if (dTc == hashCode) {
                    this.field_newStoryList = cursor.getString(i);
                } else if (dTd == hashCode) {
                    this.field_extbuf = cursor.getBlob(i);
                } else if (dTe == hashCode) {
                    this.field_nextSyncTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_roomname == null) {
            this.field_roomname = "";
        }
        if (this.dSX) {
            contentValues.put("roomname", this.field_roomname);
        }
        if (this.dSx) {
            contentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
        }
        if (this.dSY) {
            contentValues.put("newStoryList", this.field_newStoryList);
        }
        if (this.dSZ) {
            contentValues.put("extbuf", this.field_extbuf);
        }
        if (this.dTa) {
            contentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
