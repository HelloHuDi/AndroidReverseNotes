package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int dnB = "description".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int drh = "card_type".hashCode();
    private static final int dri = "logo_url".hashCode();
    private static final int drj = "time".hashCode();
    private static final int drk = "card_id".hashCode();
    private static final int drl = "card_tp_id".hashCode();
    private static final int drm = "msg_id".hashCode();
    private static final int drn = "msg_type".hashCode();
    private static final int dro = "jump_type".hashCode();
    private static final int drp = "buttonData".hashCode();
    private static final int drq = "operData".hashCode();
    private static final int drr = "report_scene".hashCode();
    private static final int drs = "read_state".hashCode();
    private static final int drt = "accept_buttons".hashCode();
    private static final int dru = "consumed_box_id".hashCode();
    private static final int drv = "jump_buttons".hashCode();
    private static final int drw = "logo_color".hashCode();
    private static final int drx = "unavailable_qr_code_list".hashCode();
    private static final int dry = "all_unavailable".hashCode();
    private static final int drz = "need_pull_card_entrance".hashCode();
    private boolean dnP = true;
    private boolean dnx = true;
    private boolean dny = true;
    private boolean dqO = true;
    private boolean dqP = true;
    private boolean dqQ = true;
    private boolean dqR = true;
    private boolean dqS = true;
    private boolean dqT = true;
    private boolean dqU = true;
    private boolean dqV = true;
    private boolean dqW = true;
    private boolean dqX = true;
    private boolean dqY = true;
    private boolean dqZ = true;
    private boolean dra = true;
    private boolean drb = true;
    private boolean drc = true;
    private boolean drd = true;
    private boolean dre = true;
    private boolean drf = true;
    private boolean drg = true;
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public boolean field_need_pull_card_entrance;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (drh == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dnB == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (dri == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (drj == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (drk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (drl == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (drm == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.dqT = true;
                } else if (drn == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (dro == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (drp == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (drq == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (drr == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (drs == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (drt == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (dru == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (drv == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (drw == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (drx == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i);
                } else if (dry == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i) != 0;
                } else if (drz == hashCode) {
                    this.field_need_pull_card_entrance = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dqO) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dny) {
            contentValues.put("description", this.field_description);
        }
        if (this.dqP) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.dqQ) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.dqR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.dqS) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.dqT) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.dqU) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.dqV) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dqW) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.dqX) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.dqY) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.dqZ) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.dra) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.drb) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.drc) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.drd) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.dre) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.drf) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.drg) {
            contentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
