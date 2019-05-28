package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ew */
public abstract class C42118ew extends C4925c {
    private static final int dQe = "from_username".hashCode();
    private static final int dQh = "local_updateTime".hashCode();
    private static final int dQi = "begin_time".hashCode();
    private static final int dQj = "end_time".hashCode();
    private static final int dQk = "block_mask".hashCode();
    private static final int dQl = "dataInfoData".hashCode();
    private static final int dQm = "cardTpInfoData".hashCode();
    private static final int dQn = "shareInfoData".hashCode();
    private static final int dQo = "shopInfoData".hashCode();
    private static final int dTA = "stickyIndex".hashCode();
    private static final int dTB = "stickyEndTime".hashCode();
    private static final int dTC = "stickyAnnouncement".hashCode();
    private static final int dTD = "label_wording".hashCode();
    private static final int dTE = "is_dynamic".hashCode();
    private static final int dTy = "delete_state_flag".hashCode();
    private static final int dTz = "create_time".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int drh = "card_type".hashCode();
    private static final int drk = "card_id".hashCode();
    private static final int drl = "card_tp_id".hashCode();
    private static final int dzW = "updateSeq".hashCode();
    private boolean dPR = true;
    private boolean dPU = true;
    private boolean dPV = true;
    private boolean dPW = true;
    private boolean dPX = true;
    private boolean dPY = true;
    private boolean dPZ = true;
    private boolean dQa = true;
    private boolean dQb = true;
    private boolean dTr = true;
    private boolean dTs = true;
    private boolean dTt = true;
    private boolean dTu = true;
    private boolean dTv = true;
    private boolean dTw = true;
    private boolean dTx = true;
    private boolean diU = true;
    private boolean dln = true;
    private boolean dqO = true;
    private boolean dqR = true;
    private boolean dqS = true;
    private boolean dzI = true;
    public long field_begin_time;
    public String field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public long field_create_time;
    public byte[] field_dataInfoData;
    public int field_delete_state_flag;
    public long field_end_time;
    public String field_from_username;
    public boolean field_is_dynamic;
    public String field_label_wording;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public byte[] field_shopInfoData;
    public int field_status;
    public String field_stickyAnnouncement;
    public int field_stickyEndTime;
    public int field_stickyIndex;
    public long field_updateSeq;
    public long field_updateTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dTy == hashCode) {
                    this.field_delete_state_flag = cursor.getInt(i);
                } else if (dQh == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dzW == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (dTz == hashCode) {
                    this.field_create_time = cursor.getLong(i);
                } else if (dQi == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (dQj == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (dQk == hashCode) {
                    this.field_block_mask = cursor.getString(i);
                } else if (dQl == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (dQm == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (dQn == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (dQo == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (dTA == hashCode) {
                    this.field_stickyIndex = cursor.getInt(i);
                } else if (dTB == hashCode) {
                    this.field_stickyEndTime = cursor.getInt(i);
                } else if (dTC == hashCode) {
                    this.field_stickyAnnouncement = cursor.getString(i);
                } else if (drh == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (dTD == hashCode) {
                    this.field_label_wording = cursor.getString(i);
                } else if (dTE == hashCode) {
                    this.field_is_dynamic = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dTr) {
            contentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
        }
        if (this.dPU) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dzI) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.dTs) {
            contentValues.put("create_time", Long.valueOf(this.field_create_time));
        }
        if (this.dPV) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.dPW) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.dPX) {
            contentValues.put("block_mask", this.field_block_mask);
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
        if (this.dTt) {
            contentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
        }
        if (this.dTu) {
            contentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
        }
        if (this.dTv) {
            contentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
        }
        if (this.dqO) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.dTw) {
            contentValues.put("label_wording", this.field_label_wording);
        }
        if (this.dTx) {
            contentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
