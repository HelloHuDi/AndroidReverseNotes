package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ee extends c {
    private static final int dQe = "from_username".hashCode();
    private static final int dQf = "consumer".hashCode();
    private static final int dQg = "share_time".hashCode();
    private static final int dQh = "local_updateTime".hashCode();
    private static final int dQi = "begin_time".hashCode();
    private static final int dQj = "end_time".hashCode();
    private static final int dQk = "block_mask".hashCode();
    private static final int dQl = "dataInfoData".hashCode();
    private static final int dQm = "cardTpInfoData".hashCode();
    private static final int dQn = "shareInfoData".hashCode();
    private static final int dQo = "shopInfoData".hashCode();
    private static final int dQp = "categoryType".hashCode();
    private static final int dQq = "itemIndex".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int drk = "card_id".hashCode();
    private static final int drl = "card_tp_id".hashCode();
    private static final int dxx = "app_id".hashCode();
    private static final int dzW = "updateSeq".hashCode();
    private boolean dPR = true;
    private boolean dPS = true;
    private boolean dPT = true;
    private boolean dPU = true;
    private boolean dPV = true;
    private boolean dPW = true;
    private boolean dPX = true;
    private boolean dPY = true;
    private boolean dPZ = true;
    private boolean dQa = true;
    private boolean dQb = true;
    private boolean dQc = true;
    private boolean dQd = true;
    private boolean diU = true;
    private boolean dln = true;
    private boolean dqR = true;
    private boolean dqS = true;
    private boolean dwL = true;
    private boolean dzI = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (drk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.dqR = true;
                } else if (drl == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (dQe == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (dQf == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (dxx == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dQg == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (dQh == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dQi == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (dQj == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (dzW == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (dQk == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (dQl == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (dQm == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (dQn == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (dQo == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (dQp == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (dQq == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dqR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.dqS) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.dPR) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.dPS) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.dwL) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dPT) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.dPU) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dPV) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.dPW) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.dzI) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.dPX) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
        }
        if (this.dPY) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.dPZ) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.dQa) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.dQb) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.dQc) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.dQd) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
