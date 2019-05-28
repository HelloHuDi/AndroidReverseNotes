package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class at extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
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

    public final void hL(int i) {
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

    public final void hM(int i) {
        this.field_unReadCount = i;
        this.dnY = true;
    }

    public final void hN(int i) {
        this.field_chatmode = i;
        this.duN = true;
    }

    public final void setStatus(int i) {
        this.field_status = i;
        this.diU = true;
    }

    public final void hO(int i) {
        this.field_isSend = i;
        this.doh = true;
    }

    public final void eD(long j) {
        this.field_conversationTime = j;
        this.duO = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.djP = true;
    }

    public final void jg(String str) {
        this.field_msgType = str;
        this.doi = true;
    }

    public final void eE(long j) {
        this.field_flag = j;
        this.dnC = true;
    }

    public final void jh(String str) {
        this.field_digest = str;
        this.doc = true;
    }

    public final void ji(String str) {
        this.field_digestUser = str;
        this.dod = true;
    }

    public final void hP(int i) {
        this.field_hasTrunc = i;
        this.duR = true;
    }

    public final void jj(String str) {
        this.field_parentRef = str;
        this.duS = true;
    }

    public final void hQ(int i) {
        this.field_attrflag = i;
        this.duT = true;
    }

    public final void jk(String str) {
        this.field_editingMsg = str;
        this.dof = true;
    }

    public final void hR(int i) {
        this.field_atCount = i;
        this.doe = true;
    }

    public final void hS(int i) {
        this.field_unReadMuteCount = i;
        this.duV = true;
    }

    public final void eF(long j) {
        this.field_lastSeq = j;
        this.duW = true;
    }

    public final long Hx() {
        return this.field_lastSeq;
    }

    public final void hT(int i) {
        this.field_UnDeliverCount = i;
        this.duX = true;
    }

    public final int Hy() {
        return this.field_UnDeliverCount;
    }

    public final void hU(int i) {
        this.field_UnReadInvite = i;
        this.duY = true;
    }

    public final void eG(long j) {
        this.field_firstUnDeliverSeq = j;
        this.duZ = true;
    }

    public final long Hz() {
        return this.field_firstUnDeliverSeq;
    }

    public final void d(Cursor cursor) {
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

    public final ContentValues Hl() {
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
            contentValues.put(b.CONTENT, this.field_content);
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
