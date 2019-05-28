package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.protocal.protobuf.C15338ev;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5069y;
import java.io.IOException;

/* renamed from: com.tencent.mm.g.c.ag */
public abstract class C32682ag extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int doR = "bitFlag".hashCode();
    private static final int dqA = "lvbuffer".hashCode();
    private static final int dqB = "talkerId".hashCode();
    private static final int dqC = "isExpand".hashCode();
    private static final int dqD = "orderFlag".hashCode();
    private static final int dqE = "hasShow".hashCode();
    private static final int dqF = "placeTop".hashCode();
    private static final int dqG = "appMsgStatInfoProto".hashCode();
    private static final int dqH = "isRead".hashCode();
    private static final int dqx = "msgSvrId".hashCode();
    private static final int dqy = "talker".hashCode();
    private static final int dqz = "imgPath".hashCode();
    private boolean diM = true;
    private boolean diU = true;
    private boolean djH = true;
    private boolean djK = true;
    private boolean djP = true;
    private boolean doF = true;
    private int dqI;
    private String dqJ;
    private boolean dqm = true;
    private boolean dqn = true;
    private boolean dqo = true;
    private boolean dqp = true;
    private boolean dqq = true;
    private boolean dqr = true;
    private boolean dqs = true;
    private boolean dqt = true;
    private boolean dqu = true;
    private boolean dqv = true;
    private boolean dqw = true;
    public C15338ev field_appMsgStatInfoProto;
    public int field_bitFlag;
    public String field_content;
    public long field_createTime;
    public int field_hasShow;
    public String field_imgPath;
    public boolean field_isExpand;
    public int field_isRead;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSvrId;
    public long field_orderFlag;
    public int field_placeTop;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public int field_type;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dqz == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (dqA == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (dqB == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (dqC == hashCode) {
                    this.field_isExpand = cursor.getInt(i) != 0;
                } else if (dqD == hashCode) {
                    this.field_orderFlag = cursor.getLong(i);
                } else if (dqE == hashCode) {
                    this.field_hasShow = cursor.getInt(i);
                } else if (dqF == hashCode) {
                    this.field_placeTop = cursor.getInt(i);
                } else if (dqG == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_appMsgStatInfoProto = (C15338ev) new C15338ev().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseBizTimeLineInfo", e.getMessage());
                    }
                } else if (dqH == hashCode) {
                    this.field_isRead = cursor.getInt(i);
                } else if (doR == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    C5069y c5069y = new C5069y();
                    int bX = c5069y.mo10393bX(this.field_lvbuffer);
                    if (bX != 0) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    if (!c5069y.dof()) {
                        this.dqI = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dqJ = c5069y.getString();
                    }
                }
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
            }
        }
    }

    /* renamed from: ht */
    public final void mo53212ht(int i) {
        this.dqI = i;
        this.dqp = true;
    }

    /* renamed from: ix */
    public final void mo53213ix(String str) {
        this.dqJ = str;
        this.dqp = true;
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        try {
            if (this.dqp) {
                C5069y c5069y = new C5069y();
                c5069y.dog();
                c5069y.mo10391LY(this.dqI);
                c5069y.amu(this.dqJ);
                this.field_lvbuffer = c5069y.doh();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", e.getMessage());
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
        if (this.dqp) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.dqq) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.dqr) {
            contentValues.put("isExpand", Boolean.valueOf(this.field_isExpand));
        }
        if (this.dqs) {
            contentValues.put("orderFlag", Long.valueOf(this.field_orderFlag));
        }
        if (this.dqt) {
            contentValues.put("hasShow", Integer.valueOf(this.field_hasShow));
        }
        if (this.dqu) {
            contentValues.put("placeTop", Integer.valueOf(this.field_placeTop));
        }
        if (this.dqv && this.field_appMsgStatInfoProto != null) {
            try {
                contentValues.put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
            } catch (IOException e2) {
                C4990ab.m7412e("MicroMsg.SDK.BaseBizTimeLineInfo", e2.getMessage());
            }
        }
        if (this.dqw) {
            contentValues.put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.doF) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
