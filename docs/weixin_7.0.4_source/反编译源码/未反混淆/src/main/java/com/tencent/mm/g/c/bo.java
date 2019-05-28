package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bo extends c {
    private static final int dAa = "fromUser".hashCode();
    private static final int dAb = "toUser".hashCode();
    private static final int dAc = "realChatName".hashCode();
    private static final int dAd = "favProto".hashCode();
    private static final int dAe = "ext".hashCode();
    private static final int dAf = "edittime".hashCode();
    private static final int dAg = "tagProto".hashCode();
    private static final int dAh = "sessionId".hashCode();
    private static final int dAi = "datatotalsize".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int diR = "rowid".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkj = "sourceType".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dnz = BaseTemplateParser.POSTFIX_ORIG.hashCode();
    private static final int dvy = "id".hashCode();
    private static final int dzF = "localId".hashCode();
    private static final int dzV = "localSeq".hashCode();
    private static final int dzW = "updateSeq".hashCode();
    private static final int dzX = "sourceId".hashCode();
    private static final int dzY = "itemStatus".hashCode();
    private static final int dzZ = "sourceCreateTime".hashCode();
    private boolean djK = true;
    private boolean djL = true;
    private boolean dln = true;
    private boolean dnC = true;
    private boolean dnw = true;
    private boolean dvv = true;
    private boolean dzD = true;
    private boolean dzH = true;
    private boolean dzI = true;
    private boolean dzJ = true;
    private boolean dzK = true;
    private boolean dzL = true;
    private boolean dzM = true;
    private boolean dzN = true;
    private boolean dzO = true;
    private boolean dzP = true;
    private boolean dzQ = true;
    private boolean dzR = true;
    private boolean dzS = true;
    private boolean dzT = true;
    private boolean dzU = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public abf field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public abs field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "localId";
        aVar.columns[1] = "id";
        aVar.xDd.put("id", "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "localSeq";
        aVar.xDd.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "updateSeq";
        aVar.xDd.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "flag";
        aVar.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "sourceId";
        aVar.xDd.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "itemStatus";
        aVar.xDd.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.xDd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "sourceCreateTime";
        aVar.xDd.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "fromUser";
        aVar.xDd.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "toUser";
        aVar.xDd.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "realChatName";
        aVar.xDd.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "favProto";
        aVar.xDd.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = BaseTemplateParser.POSTFIX_ORIG;
        aVar.xDd.put(BaseTemplateParser.POSTFIX_ORIG, "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "ext";
        aVar.xDd.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "edittime";
        aVar.xDd.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "tagProto";
        aVar.xDd.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[19] = "sessionId";
        aVar.xDd.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "datatotalsize";
        aVar.xDd.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (dzF == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.dzD = true;
                } else if (dvy == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dzV == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (dzW == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (dzX == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (dzY == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (dkj == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (dzZ == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dAa == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (dAb == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (dAc == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (dAd == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_favProto = (abf) new abf().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (dnz == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (dAe == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (dAf == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (dAg == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tagProto = (abs) new abs().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        ab.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (dAh == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (dAi == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
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
        if (this.dvv) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dzH) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.dzI) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.dzJ) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.dzK) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.djL) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.dzL) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dzM) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.dzN) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.dzO) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.dzP && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.dnw) {
            contentValues.put(BaseTemplateParser.POSTFIX_ORIG, this.field_xml);
        }
        if (this.dzQ) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.dzR) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.dzS && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                ab.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.dzT) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.dzU) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
