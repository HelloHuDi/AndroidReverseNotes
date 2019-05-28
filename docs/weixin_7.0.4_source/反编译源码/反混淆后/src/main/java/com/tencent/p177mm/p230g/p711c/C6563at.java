package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.at */
public abstract class C6563at extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dom = "unReadCount".hashCode();
    private static final int doq = "digest".hashCode();
    private static final int dor = "digestUser".hashCode();
    private static final int dos = "atCount".hashCode();
    private static final int dot = "editingMsg".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dow = "msgType".hashCode();
    private static final int dox = "msgCount".hashCode();
    private static final int dva = "chatmode".hashCode();
    private static final int dvb = "conversationTime".hashCode();
    private static final int dvc = "customNotify".hashCode();
    private static final int dvd = "showTips".hashCode();
    private static final int dve = "hasTrunc".hashCode();
    private static final int dvf = "parentRef".hashCode();
    private static final int dvg = "attrflag".hashCode();
    private static final int dvh = "sightTime".hashCode();
    private static final int dvi = "unReadMuteCount".hashCode();
    private static final int dvj = "lastSeq".hashCode();
    private static final int dvk = "UnDeliverCount".hashCode();
    private static final int dvl = "UnReadInvite".hashCode();
    private static final int dvm = "firstUnDeliverSeq".hashCode();
    private boolean diU = false;
    private boolean djP = false;
    private boolean dlm = false;
    private boolean dnC = false;
    private boolean dnY = false;
    private boolean doc = false;
    private boolean dod = false;
    private boolean doe = false;
    private boolean dof = false;
    private boolean doh = false;
    private boolean doi = false;
    private boolean doj = false;
    private boolean duN = false;
    private boolean duO = false;
    private boolean duP = false;
    public boolean duQ = false;
    private boolean duR = false;
    private boolean duS = false;
    private boolean duT = false;
    public boolean duU = false;
    private boolean duV = false;
    private boolean duW = false;
    private boolean duX = false;
    private boolean duY = false;
    private boolean duZ = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;

    /* renamed from: hL */
    public final void mo14747hL(int i) {
        this.field_msgCount = i;
        this.doj = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.dlm = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    /* renamed from: hM */
    public final void mo14748hM(int i) {
        this.field_unReadCount = i;
        this.dnY = true;
    }

    /* renamed from: hN */
    public final void mo14749hN(int i) {
        this.field_chatmode = i;
        this.duN = true;
    }

    public final void setStatus(int i) {
        this.field_status = i;
        this.diU = true;
    }

    /* renamed from: hO */
    public final void mo14750hO(int i) {
        this.field_isSend = i;
        this.doh = true;
    }

    /* renamed from: eD */
    public final void mo14742eD(long j) {
        this.field_conversationTime = j;
        this.duO = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.djP = true;
    }

    /* renamed from: jg */
    public final void mo14757jg(String str) {
        this.field_msgType = str;
        this.doi = true;
    }

    /* renamed from: eE */
    public final void mo14743eE(long j) {
        this.field_flag = j;
        this.dnC = true;
    }

    /* renamed from: jh */
    public final void mo14758jh(String str) {
        this.field_digest = str;
        this.doc = true;
    }

    /* renamed from: ji */
    public final void mo14759ji(String str) {
        this.field_digestUser = str;
        this.dod = true;
    }

    /* renamed from: hP */
    public final void mo14751hP(int i) {
        this.field_hasTrunc = i;
        this.duR = true;
    }

    /* renamed from: jj */
    public final void mo14760jj(String str) {
        this.field_parentRef = str;
        this.duS = true;
    }

    /* renamed from: hQ */
    public final void mo14752hQ(int i) {
        this.field_attrflag = i;
        this.duT = true;
    }

    /* renamed from: jk */
    public final void mo14761jk(String str) {
        this.field_editingMsg = str;
        this.dof = true;
    }

    /* renamed from: hR */
    public final void mo14753hR(int i) {
        this.field_atCount = i;
        this.doe = true;
    }

    /* renamed from: hS */
    public final void mo14754hS(int i) {
        this.field_unReadMuteCount = i;
        this.duV = true;
    }

    /* renamed from: eF */
    public final void mo14744eF(long j) {
        this.field_lastSeq = j;
        this.duW = true;
    }

    /* renamed from: Hx */
    public final long mo14739Hx() {
        return this.field_lastSeq;
    }

    /* renamed from: hT */
    public final void mo14755hT(int i) {
        this.field_UnDeliverCount = i;
        this.duX = true;
    }

    /* renamed from: Hy */
    public final int mo14740Hy() {
        return this.field_UnDeliverCount;
    }

    /* renamed from: hU */
    public final void mo14756hU(int i) {
        this.field_UnReadInvite = i;
        this.duY = true;
    }

    /* renamed from: eG */
    public final void mo14745eG(long j) {
        this.field_firstUnDeliverSeq = j;
        this.duZ = true;
    }

    /* renamed from: Hz */
    public final long mo14741Hz() {
        return this.field_firstUnDeliverSeq;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dox == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dom == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (dva == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (dvb == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dow == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (dvc == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (dvd == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (doq == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (dor == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (dve == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (dvf == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (dvg == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (dot == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (dos == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (dvh == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (dvi == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (dvj == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (dvk == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (dvl == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (dvm == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.doj) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dnY) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.duN) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.doh) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.duO) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.doi) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.duP) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.duQ) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.dnC) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.doc) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.dod) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.duR) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.duS) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.duT) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.dof) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.doe) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.duU) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.duV) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.duW) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.duX) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.duY) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.duZ) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
