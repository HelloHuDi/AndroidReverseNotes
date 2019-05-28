package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p711c.C42114el;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.storage.n */
public final class C46236n extends C42114el {
    protected static C4924a ccO;
    protected static Map<String, TimeLineObject> rfe = new ConcurrentHashMap();
    protected static Map<String, bav> rff = new ConcurrentHashMap();
    private boolean qFG = false;
    public String reW = null;
    public int reX;
    public String rfg = null;
    public C43570e rfh;
    private bav rfi = null;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final bav cqM() {
        AppMethodBeat.m2504i(37882);
        bav bav;
        if (this.field_postBuf == null) {
            bav = new bav();
            AppMethodBeat.m2505o(37882);
            return bav;
        }
        if (this.rfg == null) {
            this.rfg = C1178g.m2591x(this.field_postBuf);
        }
        if (rff.containsKey(this.rfg)) {
            this.rfi = (bav) rff.get(this.rfg);
            if (this.rfi != null) {
                bav = this.rfi;
                AppMethodBeat.m2505o(37882);
                return bav;
            }
        }
        try {
            this.rfi = (bav) new bav().parseFrom(this.field_postBuf);
            rff.put(this.rfg, this.rfi);
            bav = this.rfi;
            AppMethodBeat.m2505o(37882);
            return bav;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            bav = new bav();
            AppMethodBeat.m2505o(37882);
            return bav;
        }
    }

    public C46236n(byte b) {
        AppMethodBeat.m2504i(37883);
        mo74293kz(0);
        AppMethodBeat.m2505o(37883);
    }

    /* renamed from: z */
    public static C46236n m86476z(C46236n c46236n) {
        AppMethodBeat.m2504i(37884);
        C46236n c46236n2 = new C46236n();
        c46236n2.reX = c46236n.reX;
        c46236n2.field_snsId = c46236n.field_snsId;
        c46236n2.field_userName = c46236n.field_userName;
        c46236n2.field_localFlag = c46236n.field_localFlag;
        c46236n2.field_createTime = c46236n.field_createTime;
        c46236n2.field_head = c46236n.field_head;
        c46236n2.field_localPrivate = c46236n.field_localPrivate;
        c46236n2.field_type = c46236n.field_type;
        c46236n2.field_sourceType = c46236n.field_sourceType;
        c46236n2.field_likeFlag = c46236n.field_likeFlag;
        c46236n2.field_pravited = c46236n.field_pravited;
        c46236n2.field_stringSeq = c46236n.field_stringSeq;
        c46236n2.field_content = c46236n.field_content;
        c46236n2.field_attrBuf = c46236n.field_attrBuf;
        AppMethodBeat.m2505o(37884);
        return c46236n2;
    }

    /* renamed from: kz */
    public final void mo74293kz(long j) {
        AppMethodBeat.m2504i(37885);
        this.field_snsId = j;
        if (j != 0) {
            mo74292kB(j);
        }
        AppMethodBeat.m2505o(37885);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    /* renamed from: kA */
    private static int m86474kA(long j) {
        int intValue;
        AppMethodBeat.m2504i(37887);
        Object format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            intValue = Integer.valueOf(format).intValue();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(format)));
            intValue = (int) (j / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        }
        AppMethodBeat.m2505o(37887);
        return intValue;
    }

    /* renamed from: ls */
    public final void mo74294ls(int i) {
        AppMethodBeat.m2504i(37888);
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = C46236n.m86474kA((long) i);
            AppMethodBeat.m2505o(37888);
            return;
        }
        if (this.field_head == 0) {
            this.field_head = C46236n.m86474kA((long) this.field_createTime);
        }
        AppMethodBeat.m2505o(37888);
    }

    public final int cqN() {
        return this.field_createTime;
    }

    public final void cqO() {
        this.field_localPrivate |= 1;
    }

    public final int cqP() {
        return this.field_localPrivate;
    }

    public final boolean cqQ() {
        return (this.field_localFlag & 128) > 0;
    }

    public final void cqR() {
        this.field_localFlag |= 2;
    }

    public final void cqS() {
        this.field_localFlag &= -3;
    }

    public final boolean cqT() {
        return (this.field_localFlag & 2) > 0;
    }

    /* renamed from: bi */
    public final void mo74256bi(byte[] bArr) {
        AppMethodBeat.m2504i(37890);
        this.field_attrBuf = bArr;
        this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
        AppMethodBeat.m2505o(37890);
    }

    /* renamed from: kB */
    public final void mo74292kB(long j) {
        AppMethodBeat.m2504i(37891);
        this.field_stringSeq = C29036i.m46117jV(j);
        this.field_stringSeq = C29036i.m46089Xl(this.field_stringSeq);
        C4990ab.m7410d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
        AppMethodBeat.m2505o(37891);
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(37892);
        super.mo8995d(cursor);
        this.reX = (int) this.xDa;
        AppMethodBeat.m2505o(37892);
    }

    public static synchronized void release() {
        synchronized (C46236n.class) {
            AppMethodBeat.m2504i(37893);
            rfe.clear();
            rff.clear();
            AppMethodBeat.m2505o(37893);
        }
    }

    public final TimeLineObject cqu() {
        AppMethodBeat.m2504i(37894);
        TimeLineObject ajM;
        if (this.field_content == null) {
            ajM = C37953e.ajM();
            AppMethodBeat.m2505o(37894);
            return ajM;
        }
        if (this.reW == null) {
            this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
        }
        if (rfe.containsKey(this.reW)) {
            ajM = (TimeLineObject) rfe.get(this.reW);
            if (ajM != null) {
                AppMethodBeat.m2505o(37894);
                return ajM;
            }
        }
        try {
            ajM = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
            rfe.put(this.reW, ajM);
            AppMethodBeat.m2505o(37894);
            return ajM;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            ajM = C37953e.ajM();
            AppMethodBeat.m2505o(37894);
            return ajM;
        }
    }

    /* renamed from: c */
    public final void mo74257c(TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(37895);
        try {
            this.field_content = timeLineObject.toByteArray();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
        AppMethodBeat.m2505o(37895);
    }

    /* renamed from: YR */
    public final boolean mo74255YR(String str) {
        AppMethodBeat.m2504i(37896);
        try {
            this.field_content = C37953e.m64188tC(str).toByteArray();
            this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
            AppMethodBeat.m2505o(37896);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(37896);
            return false;
        }
    }

    public final boolean cqV() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean cqW() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void cqX() {
        this.field_localFlag &= -33;
    }

    public final void cqY() {
        this.field_localFlag |= 32;
    }

    /* renamed from: kC */
    public static boolean m86475kC(long j) {
        AppMethodBeat.m2504i(37897);
        if (C5046bo.m7549fp(j / 1000) > 1200) {
            AppMethodBeat.m2505o(37897);
            return true;
        }
        AppMethodBeat.m2505o(37897);
        return false;
    }

    /* renamed from: DI */
    public final boolean mo74253DI(int i) {
        return (this.field_sourceType & i) > 0;
    }

    /* renamed from: DF */
    public final void mo74252DF(int i) {
        this.field_sourceType |= i;
    }

    /* renamed from: DJ */
    public final void mo74254DJ(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final C21984b cqo() {
        AppMethodBeat.m2504i(37898);
        if (this.rfh == null) {
            this.rfh = C13373af.cnI().mo69174ku(this.field_snsId);
        }
        C21984b c21984b;
        if (this.rfh == null) {
            c21984b = new C21984b(null);
            AppMethodBeat.m2505o(37898);
            return c21984b;
        }
        c21984b = this.rfh.cqo();
        AppMethodBeat.m2505o(37898);
        return c21984b;
    }

    public final C21980a cqq() {
        AppMethodBeat.m2504i(37899);
        if (this.rfh == null) {
            this.rfh = C13373af.cnI().mo69174ku(this.field_snsId);
        }
        C21980a c21980a;
        if (this.rfh == null) {
            c21980a = new C21980a(null);
            AppMethodBeat.m2505o(37899);
            return c21980a;
        }
        c21980a = this.rfh.cqq();
        AppMethodBeat.m2505o(37899);
        return c21980a;
    }

    public final C21980a cqr() {
        AppMethodBeat.m2504i(37900);
        if (this.rfh == null) {
            this.rfh = C13373af.cnI().mo69174ku(this.field_snsId);
        }
        C21980a c21980a;
        if (this.rfh == null) {
            c21980a = new C21980a(null);
            AppMethodBeat.m2505o(37900);
            return c21980a;
        }
        c21980a = this.rfh.cqr();
        AppMethodBeat.m2505o(37900);
        return c21980a;
    }

    public final String cqZ() {
        AppMethodBeat.m2504i(37901);
        C21980a cqq = cqq();
        String str;
        if (cqq == null) {
            str = "";
            AppMethodBeat.m2505o(37901);
            return str;
        }
        str = cqq.qTL;
        AppMethodBeat.m2505o(37901);
        return str;
    }

    public final String cra() {
        AppMethodBeat.m2504i(37902);
        C21980a cqq = cqq();
        String str;
        if (cqq == null) {
            str = "";
            AppMethodBeat.m2505o(37902);
            return str;
        }
        str = cqq.qTK;
        AppMethodBeat.m2505o(37902);
        return str;
    }

    public final String getAdLink() {
        AppMethodBeat.m2504i(37903);
        C21984b cqo = cqo();
        String str;
        if (cqo != null) {
            str = cqo.qTA;
            AppMethodBeat.m2505o(37903);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(37903);
        return str;
    }

    public final String crb() {
        AppMethodBeat.m2504i(37904);
        C21980a cqq = cqq();
        String str;
        if (cqq != null) {
            str = cqq.qTA;
            AppMethodBeat.m2505o(37904);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(37904);
        return str;
    }

    public final String crc() {
        AppMethodBeat.m2504i(37905);
        C21980a cqq = cqq();
        String str;
        if (cqq != null) {
            str = cqq.qPj;
            AppMethodBeat.m2505o(37905);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(37905);
        return str;
    }

    public final C43570e crd() {
        AppMethodBeat.m2504i(37906);
        if (this.rfh == null) {
            this.rfh = C13373af.cnI().mo69174ku(this.field_snsId);
        }
        if (this.rfh != null) {
            this.rfh.field_createTime = this.field_createTime;
            this.rfh.field_userName = this.field_userName;
            this.rfh.field_likeFlag = this.field_likeFlag;
            this.rfh.field_attrBuf = this.field_attrBuf;
        }
        C43570e c43570e = this.rfh;
        AppMethodBeat.m2505o(37906);
        return c43570e;
    }

    /* renamed from: sh */
    public final boolean mo74295sh() {
        AppMethodBeat.m2504i(139040);
        boolean DI = mo74253DI(32);
        AppMethodBeat.m2505o(139040);
        return DI;
    }

    public final int cre() {
        AppMethodBeat.m2504i(37908);
        C21984b cqo = cqo();
        if (cqo != null) {
            int i = cqo.qUA;
            AppMethodBeat.m2505o(37908);
            return i;
        }
        AppMethodBeat.m2505o(37908);
        return 0;
    }

    public final boolean coX() {
        AppMethodBeat.m2504i(37909);
        C21984b cqo = cqo();
        if (cqo != null) {
            boolean coX = cqo.coX();
            AppMethodBeat.m2505o(37909);
            return coX;
        }
        AppMethodBeat.m2505o(37909);
        return false;
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean cnn() {
        return this.field_snsId == 0;
    }

    public final boolean crg() {
        AppMethodBeat.m2504i(37911);
        if (cqu() == null || cqu().xfI.wbJ != 27) {
            AppMethodBeat.m2505o(37911);
            return false;
        }
        AppMethodBeat.m2505o(37911);
        return true;
    }

    public final boolean coP() {
        AppMethodBeat.m2504i(37912);
        if (cqo() == null || !cqo().coP()) {
            AppMethodBeat.m2505o(37912);
            return false;
        }
        AppMethodBeat.m2505o(37912);
        return true;
    }

    public final boolean coQ() {
        AppMethodBeat.m2504i(37913);
        if (cqo() == null || !cqo().coQ()) {
            AppMethodBeat.m2505o(37913);
            return false;
        }
        AppMethodBeat.m2505o(37913);
        return true;
    }

    public final Bundle cqC() {
        AppMethodBeat.m2504i(37914);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.mo10098Hl());
        bundle.putInt("localid", this.reX);
        if (crd() != null) {
            bundle.putBundle("adValues", crd().cqC());
        }
        AppMethodBeat.m2505o(37914);
        return bundle;
    }

    public final String cqA() {
        AppMethodBeat.m2504i(37886);
        String ao;
        if (mo74253DI(32)) {
            ao = C35002v.m57489ao("ad_table_", this.field_snsId);
            AppMethodBeat.m2505o(37886);
            return ao;
        }
        ao = C35002v.m57489ao("sns_table_", this.field_snsId);
        AppMethodBeat.m2505o(37886);
        return ao;
    }

    public final String cqU() {
        AppMethodBeat.m2504i(37889);
        String ao;
        if (mo74253DI(32)) {
            ao = C35002v.m57489ao("ad_table_", (long) this.reX);
            AppMethodBeat.m2505o(37889);
            return ao;
        }
        ao = C35002v.m57489ao("sns_table_", (long) this.reX);
        AppMethodBeat.m2505o(37889);
        return ao;
    }

    public final int crf() {
        AppMethodBeat.m2504i(37910);
        if (mo74253DI(32)) {
            C21984b cqo = cqo();
            TimeLineObject cqu = cqu();
            if (cqo.coO()) {
                AppMethodBeat.m2505o(37910);
                return 3;
            } else if (cqu != null && cqu.xfI.wbJ == 27) {
                AppMethodBeat.m2505o(37910);
                return 6;
            } else if (cqo.coP() || cqo.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    AppMethodBeat.m2505o(37910);
                    return 4;
                }
                AppMethodBeat.m2505o(37910);
                return 5;
            } else if (this.field_type == 1) {
                AppMethodBeat.m2505o(37910);
                return 1;
            } else {
                AppMethodBeat.m2505o(37910);
                return 2;
            }
        }
        AppMethodBeat.m2505o(37910);
        return -1;
    }

    static {
        AppMethodBeat.m2504i(37915);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[15];
        c4924a.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "snsId";
        c4924a.xDd.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "userName";
        c4924a.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "localFlag";
        c4924a.xDd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createTime";
        c4924a.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "head";
        c4924a.xDd.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "localPrivate";
        c4924a.xDd.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "sourceType";
        c4924a.xDd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "likeFlag";
        c4924a.xDd.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "pravited";
        c4924a.xDd.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "stringSeq";
        c4924a.xDd.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        c4924a.columns[12] = "attrBuf";
        c4924a.xDd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[13] = "postBuf";
        c4924a.xDd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[14] = "subType";
        c4924a.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        c4924a.columns[15] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(37915);
    }
}
