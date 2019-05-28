package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class cy extends c {
    private static final int dEg = "msgSeq".hashCode();
    private static final int dJp = "isShowTimer".hashCode();
    private static final int dJq = "reserved".hashCode();
    private static final int dJr = "transContent".hashCode();
    private static final int dJs = "transBrandWording".hashCode();
    private static final int dJt = "bizClientMsgId".hashCode();
    private static final int dJu = "bizChatUserId".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dok = "bizChatId".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dqA = "lvbuffer".hashCode();
    private static final int dqB = "talkerId".hashCode();
    private static final int dqx = "msgSvrId".hashCode();
    private static final int dqy = "talker".hashCode();
    private static final int dqz = "imgPath".hashCode();
    private String cMn;
    private boolean dEa = false;
    public int dJA;
    public int dJB;
    public String dJC;
    public String dJD;
    public String dJE;
    public int dJF;
    public byte[] dJG;
    public boolean dJj = false;
    private boolean dJk = false;
    private boolean dJl = false;
    public boolean dJm = false;
    private boolean dJn = false;
    public boolean dJo = false;
    public String dJv;
    public int dJw;
    public int dJx;
    protected int dJy;
    public int dJz;
    private boolean diM = false;
    private boolean diU = false;
    private boolean djH = false;
    private boolean djK = false;
    private boolean djP = false;
    private boolean dnC = false;
    private boolean dnW = false;
    private boolean doh = false;
    public int dqI;
    public String dqJ;
    private boolean dqm = false;
    private boolean dqn = false;
    private boolean dqo = false;
    public boolean dqp = false;
    private boolean dqq = false;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    private int field_type;

    public final void setMsgId(long j) {
        this.field_msgId = j;
        this.diM = true;
    }

    public final long HA() {
        return this.field_msgId;
    }

    public final void eI(long j) {
        this.field_msgSvrId = j;
        this.dqm = true;
    }

    public final long HB() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.djK = true;
    }

    public int getType() {
        return this.field_type;
    }

    public void setStatus(int i) {
        this.field_status = i;
        this.diU = true;
    }

    public final int getStatus() {
        return this.field_status;
    }

    public final void hO(int i) {
        this.field_isSend = i;
        this.doh = true;
    }

    public final int HC() {
        return this.field_isSend;
    }

    public final void eJ(long j) {
        this.field_createTime = j;
        this.djH = true;
    }

    public final long HD() {
        return this.field_createTime;
    }

    public final void ju(String str) {
        this.field_talker = str;
        this.dqn = true;
    }

    public final String HE() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.djP = true;
    }

    public final String getContent() {
        return this.field_content;
    }

    public final void jv(String str) {
        this.field_imgPath = str;
        this.dqo = true;
    }

    public final String HF() {
        return this.field_imgPath;
    }

    public final void jw(String str) {
        this.field_reserved = str;
        this.dJk = true;
    }

    public final String HG() {
        return this.field_reserved;
    }

    public final void I(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.dqp = true;
    }

    public final void hX(int i) {
        this.field_talkerId = i;
        this.dqq = true;
    }

    public final void jx(String str) {
        this.field_transContent = str;
        this.dJl = true;
    }

    public final void jy(String str) {
        this.field_bizClientMsgId = str;
        this.dJn = true;
    }

    public final void eK(long j) {
        this.field_bizChatId = j;
        this.dnW = true;
    }

    public final void eL(long j) {
        this.field_msgSeq = j;
        this.dEa = true;
    }

    public final void hY(int i) {
        this.field_flag = i;
        this.dnC = true;
    }

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.diM = true;
                } else if (dqx == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (dJp == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dqz == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (dJq == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (dqA == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (dqB == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (dJr == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (dJs == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (dJt == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (dok == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (dJu == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (dEg == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    y yVar = new y();
                    int bX = yVar.bX(this.field_lvbuffer);
                    if (bX != 0) {
                        ab.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    if (!yVar.dof()) {
                        this.dJv = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dqI = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dqJ = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dJw = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJx = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJy = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJz = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJA = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJB = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dJC = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dJD = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dJE = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dJF = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.cMn = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dJG = yVar.getBuffer();
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public final void jz(String str) {
        this.dJv = str;
        this.dqp = true;
    }

    public final void ht(int i) {
        this.dqI = i;
        this.dqp = true;
    }

    public final void ix(String str) {
        this.dqJ = str;
        this.dqp = true;
    }

    public final void hZ(int i) {
        this.dJw = i;
        this.dqp = true;
    }

    public final void ia(int i) {
        this.dJx = i;
        this.dqp = true;
    }

    public final void ib(int i) {
        this.dJy = i;
        this.dqp = true;
    }

    public final void HH() {
        this.dJz = 1;
        this.dqp = true;
    }

    public final void ic(int i) {
        this.dJA = i;
        this.dqp = true;
    }

    public final void id(int i) {
        this.dJB = i;
        this.dqp = true;
    }

    public final void jA(String str) {
        this.dJD = str;
        this.dqp = true;
    }

    public final void jB(String str) {
        this.dJE = str;
        this.dqp = true;
    }

    public final void ie(int i) {
        this.dJF = i;
        this.dqp = true;
    }

    public ContentValues Hl() {
        try {
            if (this.dqp) {
                y yVar = new y();
                yVar.dog();
                yVar.amu(this.dJv);
                yVar.LY(this.dqI);
                yVar.amu(this.dqJ);
                yVar.LY(this.dJw);
                yVar.LY(this.dJx);
                yVar.LY(this.dJy);
                yVar.LY(this.dJz);
                yVar.LY(this.dJA);
                yVar.LY(this.dJB);
                yVar.amu(this.dJC);
                yVar.amu(this.dJD);
                yVar.amu(this.dJE);
                yVar.LY(this.dJF);
                yVar.amu(this.cMn);
                yVar.bY(this.dJG);
                this.field_lvbuffer = yVar.doh();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dqm) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.doh) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.dJj) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dqn) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.dqo) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.dJk) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.dqp) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.dqq) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.dJl) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.dJm) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.dJn) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.dnW) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.dJo) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.dEa) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
