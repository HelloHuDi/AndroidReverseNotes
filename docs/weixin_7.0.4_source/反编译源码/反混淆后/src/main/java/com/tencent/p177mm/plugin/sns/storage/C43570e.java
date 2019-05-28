package com.tencent.p177mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p711c.C32695f;
import com.tencent.p177mm.protocal.protobuf.C23375bs;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.storage.e */
public final class C43570e extends C32695f {
    protected static C4924a ccO;
    protected static Map<String, C21984b> reY = new ConcurrentHashMap();
    protected static Map<String, C21980a> reZ = new ConcurrentHashMap();
    public String reW = null;
    protected int reX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final C21984b cqo() {
        C21984b c21984b;
        AppMethodBeat.m2504i(37801);
        if (this.field_adxml == null) {
            c21984b = null;
        } else if (reY.containsKey(this.field_adxml)) {
            c21984b = (C21984b) reY.get(this.field_adxml);
            AppMethodBeat.m2505o(37801);
            return c21984b;
        } else {
            c21984b = new C21984b(this.field_adxml);
            reY.put(this.field_adxml, c21984b);
        }
        if (c21984b == null) {
            c21984b = new C21984b(null);
            AppMethodBeat.m2505o(37801);
            return c21984b;
        }
        AppMethodBeat.m2505o(37801);
        return c21984b;
    }

    private C21984b cqp() {
        C21984b c21984b;
        AppMethodBeat.m2504i(37802);
        if (this.field_recxml == null) {
            c21984b = null;
        } else if (reY.containsKey(this.field_recxml)) {
            c21984b = (C21984b) reY.get(this.field_recxml);
            AppMethodBeat.m2505o(37802);
            return c21984b;
        } else {
            c21984b = new C21984b(this.field_recxml);
            reY.put(this.field_recxml, c21984b);
        }
        if (c21984b == null) {
            c21984b = new C21984b(null);
            AppMethodBeat.m2505o(37802);
            return c21984b;
        }
        AppMethodBeat.m2505o(37802);
        return c21984b;
    }

    public final C21980a cqq() {
        C21980a c21980a;
        AppMethodBeat.m2504i(37803);
        if (this.field_adinfo == null) {
            c21980a = null;
        } else if (reZ.containsKey(this.field_adinfo)) {
            c21980a = (C21980a) reZ.get(this.field_adinfo);
            AppMethodBeat.m2505o(37803);
            return c21980a;
        } else {
            c21980a = new C21980a(this.field_adinfo);
            reZ.put(this.field_adinfo, c21980a);
        }
        if (c21980a == null) {
            c21980a = new C21980a(null);
            AppMethodBeat.m2505o(37803);
            return c21980a;
        }
        AppMethodBeat.m2505o(37803);
        return c21980a;
    }

    public final C21980a cqr() {
        C21980a c21980a;
        AppMethodBeat.m2504i(37804);
        if (this.field_atAdinfo == null) {
            c21980a = null;
        } else if (reZ.containsKey(this.field_atAdinfo)) {
            c21980a = (C21980a) reZ.get(this.field_atAdinfo);
            AppMethodBeat.m2505o(37804);
            return c21980a;
        } else {
            c21980a = new C21980a(this.field_atAdinfo);
            reZ.put(this.field_atAdinfo, c21980a);
        }
        if (c21980a == null) {
            c21980a = new C21980a(null);
            AppMethodBeat.m2505o(37804);
            return c21980a;
        }
        AppMethodBeat.m2505o(37804);
        return c21980a;
    }

    public final boolean coX() {
        AppMethodBeat.m2504i(37805);
        C21984b cqo = cqo();
        if (cqo != null) {
            boolean coX = cqo.coX();
            AppMethodBeat.m2505o(37805);
            return coX;
        }
        AppMethodBeat.m2505o(37805);
        return false;
    }

    public final int cqs() {
        AppMethodBeat.m2504i(37806);
        C21984b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.m2505o(37806);
            return 0;
        }
        int i = cqp.qUA;
        AppMethodBeat.m2505o(37806);
        return i;
    }

    public final int getSource() {
        AppMethodBeat.m2504i(37807);
        C21984b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.m2505o(37807);
            return 0;
        }
        int i = cqp.qUA;
        AppMethodBeat.m2505o(37807);
        return i;
    }

    public final int cqt() {
        AppMethodBeat.m2504i(37808);
        C21984b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.m2505o(37808);
            return 0;
        }
        int i = cqp.qUB;
        AppMethodBeat.m2505o(37808);
        return i;
    }

    /* renamed from: c */
    public final void mo69153c(TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(37809);
        try {
            this.field_content = timeLineObject.toByteArray();
            AppMethodBeat.m2505o(37809);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(37809);
        }
    }

    /* renamed from: YR */
    public final boolean mo69150YR(String str) {
        AppMethodBeat.m2504i(37810);
        try {
            this.field_content = C37953e.m64188tC(str).toByteArray();
            this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
            AppMethodBeat.m2505o(37810);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(37810);
            return false;
        }
    }

    public final TimeLineObject cqu() {
        AppMethodBeat.m2504i(37811);
        TimeLineObject ajM;
        if (this.field_content == null) {
            ajM = C37953e.ajM();
            AppMethodBeat.m2505o(37811);
            return ajM;
        }
        if (this.reW == null) {
            this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
        }
        if (C46236n.rfe.containsKey(this.reW)) {
            ajM = (TimeLineObject) C46236n.rfe.get(this.reW);
            if (ajM != null) {
                AppMethodBeat.m2505o(37811);
                return ajM;
            }
        }
        try {
            ajM = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
            C46236n.rfe.put(this.reW, ajM);
            AppMethodBeat.m2505o(37811);
            return ajM;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            ajM = C37953e.ajM();
            AppMethodBeat.m2505o(37811);
            return ajM;
        }
    }

    /* renamed from: a */
    public final void mo69151a(C23375bs c23375bs) {
        AppMethodBeat.m2504i(37812);
        try {
            this.field_remindInfoGroup = c23375bs.toByteArray();
            AppMethodBeat.m2505o(37812);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + e.getMessage());
            AppMethodBeat.m2505o(37812);
        }
    }

    public final C23375bs cqv() {
        C23375bs c23375bs;
        Exception e;
        AppMethodBeat.m2504i(37813);
        try {
            if (this.field_remindInfoGroup != null) {
                c23375bs = new C23375bs();
                try {
                    c23375bs.parseFrom(this.field_remindInfoGroup);
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7412e("MicroMsg.AdSnsInfo", "parse remindInfo error! " + e.getMessage());
                    AppMethodBeat.m2505o(37813);
                    return c23375bs;
                }
            }
            c23375bs = null;
        } catch (Exception e3) {
            e = e3;
            c23375bs = null;
            C4990ab.m7412e("MicroMsg.AdSnsInfo", "parse remindInfo error! " + e.getMessage());
            AppMethodBeat.m2505o(37813);
            return c23375bs;
        }
        AppMethodBeat.m2505o(37813);
        return c23375bs;
    }

    public final C1332b cqw() {
        AppMethodBeat.m2504i(37814);
        if (cqv() == null || cqv().vDY == null || cqv().vDY.wTA == null) {
            AppMethodBeat.m2505o(37814);
            return null;
        }
        C1332b buffer = cqv().vDY.wTA.getBuffer();
        AppMethodBeat.m2505o(37814);
        return buffer;
    }

    public final C1332b cqx() {
        AppMethodBeat.m2504i(37815);
        if (cqv() == null || cqv().vDY == null || cqv().vDY.wTB == null) {
            AppMethodBeat.m2505o(37815);
            return null;
        }
        C1332b buffer = cqv().vDY.wTB.getBuffer();
        AppMethodBeat.m2505o(37815);
        return buffer;
    }

    public final C1332b cqy() {
        AppMethodBeat.m2504i(37816);
        if (cqv() == null || cqv().vDZ == null || cqv().vDZ.wTA == null) {
            AppMethodBeat.m2505o(37816);
            return null;
        }
        C1332b buffer = cqv().vDZ.wTA.getBuffer();
        AppMethodBeat.m2505o(37816);
        return buffer;
    }

    public final C1332b cqz() {
        AppMethodBeat.m2504i(37817);
        if (cqv() == null || cqv().vDZ == null || cqv().vDZ.wTB == null) {
            AppMethodBeat.m2505o(37817);
            return null;
        }
        C1332b buffer = cqv().vDZ.wTB.getBuffer();
        AppMethodBeat.m2505o(37817);
        return buffer;
    }

    /* renamed from: bi */
    public final void mo69152bi(byte[] bArr) {
        AppMethodBeat.m2504i(37818);
        this.field_attrBuf = bArr;
        this.reW = C1178g.m2591x(this.field_content) + C1178g.m2591x(this.field_attrBuf);
        AppMethodBeat.m2505o(37818);
    }

    /* renamed from: DF */
    public final void mo69148DF(int i) {
        this.field_sourceType |= i;
    }

    public final String cqA() {
        AppMethodBeat.m2504i(37819);
        String ao = C35002v.m57489ao("ad_table_", this.field_snsId);
        AppMethodBeat.m2505o(37819);
        return ao;
    }

    public final C46236n cqB() {
        AppMethodBeat.m2504i(37820);
        C46236n c46236n = new C46236n();
        c46236n.mo74257c(cqu());
        C4990ab.m7411d("MicroMsg.AdSnsInfo", "from server xml ok %d", Long.valueOf(this.field_snsId));
        c46236n.reX = this.reX;
        c46236n.field_userName = this.field_userName;
        c46236n.mo74294ls(this.field_createTime);
        c46236n.field_likeFlag = this.field_likeFlag;
        c46236n.mo74293kz(this.field_snsId);
        c46236n.field_sourceType = this.field_sourceType;
        c46236n.field_content = this.field_content;
        c46236n.mo74252DF(2);
        c46236n.mo74252DF(32);
        c46236n.field_attrBuf = this.field_attrBuf;
        TimeLineObject cqu = c46236n.cqu();
        cqu.jBB = this.field_userName;
        c46236n.field_pravited = cqu.wEJ;
        c46236n.cqR();
        c46236n.mo74257c(cqu);
        if (cqu.xfI != null) {
            c46236n.field_type = cqu.xfI.wbJ;
            c46236n.field_subType = cqu.xfI.wbL;
        }
        c46236n.rfh = this;
        AppMethodBeat.m2505o(37820);
        return c46236n;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(37821);
        super.mo8995d(cursor);
        this.reX = (int) this.xDa;
        AppMethodBeat.m2505o(37821);
    }

    public final Bundle cqC() {
        AppMethodBeat.m2504i(37822);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.mo10098Hl());
        bundle.putInt("localid", this.reX);
        AppMethodBeat.m2505o(37822);
        return bundle;
    }

    /* renamed from: L */
    public final void mo69149L(Bundle bundle) {
        AppMethodBeat.m2504i(37823);
        if (bundle == null) {
            AppMethodBeat.m2505o(37823);
            return;
        }
        ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
        this.field_snsId = contentValues.getAsLong("snsId").longValue();
        this.field_userName = contentValues.getAsString("userName");
        this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
        this.field_createTime = contentValues.getAsInteger("createTime").intValue();
        this.field_head = contentValues.getAsInteger("head").intValue();
        this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
        this.field_type = contentValues.getAsInteger("type").intValue();
        this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
        this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
        this.field_pravited = contentValues.getAsInteger("pravited").intValue();
        this.field_stringSeq = contentValues.getAsString("stringSeq");
        this.field_content = contentValues.getAsByteArray(C8741b.CONTENT);
        this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
        this.field_postBuf = contentValues.getAsByteArray("postBuf");
        this.field_adinfo = contentValues.getAsString("adinfo");
        this.field_adxml = contentValues.getAsString("adxml");
        this.field_createAdTime = contentValues.getAsInteger("createAdTime").intValue();
        this.field_exposureTime = contentValues.getAsInteger("exposureTime").intValue();
        this.field_firstControlTime = contentValues.getAsInteger("firstControlTime").intValue();
        this.field_recxml = contentValues.getAsString("recxml");
        this.field_subType = contentValues.getAsInteger("subType").intValue();
        this.xDa = contentValues.getAsLong("rowid").longValue();
        this.field_atAdinfo = contentValues.getAsString("atAdinfo");
        this.field_remindInfoGroup = contentValues.getAsByteArray("remindInfoGroup");
        this.reX = bundle.getInt("localid");
        AppMethodBeat.m2505o(37823);
    }

    static {
        AppMethodBeat.m2504i(37824);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[24];
        c4924a.columns = new String[25];
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
        c4924a.columns[14] = "adinfo";
        c4924a.xDd.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "adxml";
        c4924a.xDd.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "createAdTime";
        c4924a.xDd.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "exposureTime";
        c4924a.xDd.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[18] = "firstControlTime";
        c4924a.xDd.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[19] = "recxml";
        c4924a.xDd.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[20] = "subType";
        c4924a.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[21] = "exposureCount";
        c4924a.xDd.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[22] = "atAdinfo";
        c4924a.xDd.put("atAdinfo", "TEXT");
        stringBuilder.append(" atAdinfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[23] = "remindInfoGroup";
        c4924a.xDd.put("remindInfoGroup", "BLOB");
        stringBuilder.append(" remindInfoGroup BLOB");
        c4924a.columns[24] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(37824);
    }
}
