package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bn extends c {
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

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "modItem";
        aVar.xDd.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.columns[2] = "time";
        aVar.xDd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.xDd.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
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
                if (dzF == hashCode) {
                    this.field_localId = cursor.getLong(i);
                } else if (dzG == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (aav) new aav().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
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

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.dzE && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
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
