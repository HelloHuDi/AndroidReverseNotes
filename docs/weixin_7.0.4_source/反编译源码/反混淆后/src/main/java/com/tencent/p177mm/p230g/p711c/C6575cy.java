package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5069y;

/* renamed from: com.tencent.mm.g.c.cy */
public abstract class C6575cy extends C4925c {
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
    private static final int dkn = C8741b.CONTENT.hashCode();
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

    /* renamed from: HA */
    public final long mo14765HA() {
        return this.field_msgId;
    }

    /* renamed from: eI */
    public final void mo14774eI(long j) {
        this.field_msgSvrId = j;
        this.dqm = true;
    }

    /* renamed from: HB */
    public final long mo14766HB() {
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

    /* renamed from: hO */
    public final void mo14781hO(int i) {
        this.field_isSend = i;
        this.doh = true;
    }

    /* renamed from: HC */
    public final int mo14767HC() {
        return this.field_isSend;
    }

    /* renamed from: eJ */
    public final void mo14775eJ(long j) {
        this.field_createTime = j;
        this.djH = true;
    }

    /* renamed from: HD */
    public final long mo14768HD() {
        return this.field_createTime;
    }

    /* renamed from: ju */
    public final void mo14794ju(String str) {
        this.field_talker = str;
        this.dqn = true;
    }

    /* renamed from: HE */
    public final String mo14769HE() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.djP = true;
    }

    public final String getContent() {
        return this.field_content;
    }

    /* renamed from: jv */
    public final void mo14795jv(String str) {
        this.field_imgPath = str;
        this.dqo = true;
    }

    /* renamed from: HF */
    public final String mo14770HF() {
        return this.field_imgPath;
    }

    /* renamed from: jw */
    public final void mo14796jw(String str) {
        this.field_reserved = str;
        this.dJk = true;
    }

    /* renamed from: HG */
    public final String mo14771HG() {
        return this.field_reserved;
    }

    /* renamed from: I */
    public final void mo14773I(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.dqp = true;
    }

    /* renamed from: hX */
    public final void mo14782hX(int i) {
        this.field_talkerId = i;
        this.dqq = true;
    }

    /* renamed from: jx */
    public final void mo14797jx(String str) {
        this.field_transContent = str;
        this.dJl = true;
    }

    /* renamed from: jy */
    public final void mo14798jy(String str) {
        this.field_bizClientMsgId = str;
        this.dJn = true;
    }

    /* renamed from: eK */
    public final void mo14776eK(long j) {
        this.field_bizChatId = j;
        this.dnW = true;
    }

    /* renamed from: eL */
    public final void mo14777eL(long j) {
        this.field_msgSeq = j;
        this.dEa = true;
    }

    /* renamed from: hY */
    public final void mo14783hY(int i) {
        this.field_flag = i;
        this.dnC = true;
    }

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
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
                    C5069y c5069y = new C5069y();
                    int bX = c5069y.mo10393bX(this.field_lvbuffer);
                    if (bX != 0) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    if (!c5069y.dof()) {
                        this.dJv = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dqI = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dqJ = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dJw = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJx = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJy = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJz = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJA = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJB = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dJC = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dJD = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dJE = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dJF = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.cMn = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dJG = c5069y.getBuffer();
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    /* renamed from: jz */
    public final void mo14799jz(String str) {
        this.dJv = str;
        this.dqp = true;
    }

    /* renamed from: ht */
    public final void mo14785ht(int i) {
        this.dqI = i;
        this.dqp = true;
    }

    /* renamed from: ix */
    public final void mo14791ix(String str) {
        this.dqJ = str;
        this.dqp = true;
    }

    /* renamed from: hZ */
    public final void mo14784hZ(int i) {
        this.dJw = i;
        this.dqp = true;
    }

    /* renamed from: ia */
    public final void mo14786ia(int i) {
        this.dJx = i;
        this.dqp = true;
    }

    /* renamed from: ib */
    public final void mo14787ib(int i) {
        this.dJy = i;
        this.dqp = true;
    }

    /* renamed from: HH */
    public final void mo14772HH() {
        this.dJz = 1;
        this.dqp = true;
    }

    /* renamed from: ic */
    public final void mo14788ic(int i) {
        this.dJA = i;
        this.dqp = true;
    }

    /* renamed from: id */
    public final void mo14789id(int i) {
        this.dJB = i;
        this.dqp = true;
    }

    /* renamed from: jA */
    public final void mo14792jA(String str) {
        this.dJD = str;
        this.dqp = true;
    }

    /* renamed from: jB */
    public final void mo14793jB(String str) {
        this.dJE = str;
        this.dqp = true;
    }

    /* renamed from: ie */
    public final void mo14790ie(int i) {
        this.dJF = i;
        this.dqp = true;
    }

    /* renamed from: Hl */
    public ContentValues mo10098Hl() {
        try {
            if (this.dqp) {
                C5069y c5069y = new C5069y();
                c5069y.dog();
                c5069y.amu(this.dJv);
                c5069y.mo10391LY(this.dqI);
                c5069y.amu(this.dqJ);
                c5069y.mo10391LY(this.dJw);
                c5069y.mo10391LY(this.dJx);
                c5069y.mo10391LY(this.dJy);
                c5069y.mo10391LY(this.dJz);
                c5069y.mo10391LY(this.dJA);
                c5069y.mo10391LY(this.dJB);
                c5069y.amu(this.dJC);
                c5069y.amu(this.dJD);
                c5069y.amu(this.dJE);
                c5069y.mo10391LY(this.dJF);
                c5069y.amu(this.cMn);
                c5069y.mo10394bY(this.dJG);
                this.field_lvbuffer = c5069y.doh();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
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
            contentValues.put(C8741b.CONTENT, this.field_content);
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
