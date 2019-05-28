package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.protocal.protobuf.aav;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.bn */
public abstract class C26299bn extends C4925c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dki = "type".hashCode();
    private static final int drj = "time".hashCode();
    private static final int dzF = "localId".hashCode();
    private static final int dzG = "modItem".hashCode();
    private boolean djK = true;
    private boolean dkA = true;
    private boolean dqQ = true;
    private boolean dzD = true;
    private boolean dzE = true;
    public long field_localId;
    public aav field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;

    /* renamed from: Hm */
    public static C4924a m41806Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "localId";
        c4924a.xDd.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "modItem";
        c4924a.xDd.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        c4924a.columns[2] = "time";
        c4924a.xDd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "scene";
        c4924a.xDd.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
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
                if (dzF == hashCode) {
                    this.field_localId = cursor.getLong(i);
                } else if (dzG == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (aav) new aav().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (drj == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.dzE && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.dqQ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
