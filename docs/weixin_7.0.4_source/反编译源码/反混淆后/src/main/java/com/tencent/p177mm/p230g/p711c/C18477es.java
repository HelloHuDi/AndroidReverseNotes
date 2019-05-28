package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.es */
public abstract class C18477es extends C4925c {
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

    /* renamed from: Hm */
    public static C4924a m28765Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "roomname";
        c4924a.xDd.put("roomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "roomname";
        c4924a.columns[1] = "userStoryFlag";
        c4924a.xDd.put("userStoryFlag", "INTEGER");
        stringBuilder.append(" userStoryFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "newStoryList";
        c4924a.xDd.put("newStoryList", "TEXT");
        stringBuilder.append(" newStoryList TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "extbuf";
        c4924a.xDd.put("extbuf", "BLOB");
        stringBuilder.append(" extbuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[4] = "nextSyncTime";
        c4924a.xDd.put("nextSyncTime", "LONG");
        stringBuilder.append(" nextSyncTime LONG");
        c4924a.columns[5] = "rowid";
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
