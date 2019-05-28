package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bl extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlA = "dataType".hashCode();
    private static final int dla = "totalLen".hashCode();
    private static final int dlb = "offset".hashCode();
    private static final int dlv = "path".hashCode();
    private static final int dmI = "modifyTime".hashCode();
    private static final int dxE = "cdnUrl".hashCode();
    private static final int dzA = "attrFlag".hashCode();
    private static final int dzw = "dataId".hashCode();
    private static final int dzx = "favLocalId".hashCode();
    private static final int dzy = "cdnKey".hashCode();
    private static final int dzz = "extFlag".hashCode();
    private boolean diU = true;
    private boolean djK = true;
    private boolean dkJ = true;
    private boolean dkK = true;
    private boolean dlr = true;
    private boolean dly = true;
    private boolean dml = true;
    private boolean dwS = true;
    private boolean dzr = true;
    private boolean dzs = true;
    private boolean dzt = true;
    private boolean dzu = true;
    private boolean dzv = true;
    public long field_attrFlag;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "dataId";
        aVar.xDd.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "dataId";
        aVar.columns[1] = "favLocalId";
        aVar.xDd.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "cdnUrl";
        aVar.xDd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "cdnKey";
        aVar.xDd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "totalLen";
        aVar.xDd.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "offset";
        aVar.xDd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "path";
        aVar.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "dataType";
        aVar.xDd.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.xDd.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "extFlag";
        aVar.xDd.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrFlag";
        aVar.xDd.put("attrFlag", "LONG default '0' ");
        stringBuilder.append(" attrFlag LONG default '0' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzw == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.dzr = true;
                } else if (dzx == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dxE == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (dzy == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (dla == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (dlb == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dlv == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (dlA == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (dmI == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (dzz == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (dzA == hashCode) {
                    this.field_attrFlag = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzr) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.dzs) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dwS) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.dzt) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.dkJ) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.dkK) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dlr) {
            contentValues.put("path", this.field_path);
        }
        if (this.dly) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.dml) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.dzu) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.dzv) {
            contentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
