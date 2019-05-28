package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.el;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n extends el {
    protected static a ccO;
    protected static Map<String, TimeLineObject> rfe = new ConcurrentHashMap();
    protected static Map<String, bav> rff = new ConcurrentHashMap();
    private boolean qFG = false;
    public String reW = null;
    public int reX;
    public String rfg = null;
    public e rfh;
    private bav rfi = null;

    public final a Ag() {
        return ccO;
    }

    public final bav cqM() {
        AppMethodBeat.i(37882);
        bav bav;
        if (this.field_postBuf == null) {
            bav = new bav();
            AppMethodBeat.o(37882);
            return bav;
        }
        if (this.rfg == null) {
            this.rfg = g.x(this.field_postBuf);
        }
        if (rff.containsKey(this.rfg)) {
            this.rfi = (bav) rff.get(this.rfg);
            if (this.rfi != null) {
                bav = this.rfi;
                AppMethodBeat.o(37882);
                return bav;
            }
        }
        try {
            this.rfi = (bav) new bav().parseFrom(this.field_postBuf);
            rff.put(this.rfg, this.rfi);
            bav = this.rfi;
            AppMethodBeat.o(37882);
            return bav;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            bav = new bav();
            AppMethodBeat.o(37882);
            return bav;
        }
    }

    public n(byte b) {
        AppMethodBeat.i(37883);
        kz(0);
        AppMethodBeat.o(37883);
    }

    public static n z(n nVar) {
        AppMethodBeat.i(37884);
        n nVar2 = new n();
        nVar2.reX = nVar.reX;
        nVar2.field_snsId = nVar.field_snsId;
        nVar2.field_userName = nVar.field_userName;
        nVar2.field_localFlag = nVar.field_localFlag;
        nVar2.field_createTime = nVar.field_createTime;
        nVar2.field_head = nVar.field_head;
        nVar2.field_localPrivate = nVar.field_localPrivate;
        nVar2.field_type = nVar.field_type;
        nVar2.field_sourceType = nVar.field_sourceType;
        nVar2.field_likeFlag = nVar.field_likeFlag;
        nVar2.field_pravited = nVar.field_pravited;
        nVar2.field_stringSeq = nVar.field_stringSeq;
        nVar2.field_content = nVar.field_content;
        nVar2.field_attrBuf = nVar.field_attrBuf;
        AppMethodBeat.o(37884);
        return nVar2;
    }

    public final void kz(long j) {
        AppMethodBeat.i(37885);
        this.field_snsId = j;
        if (j != 0) {
            kB(j);
        }
        AppMethodBeat.o(37885);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int kA(long j) {
        int intValue;
        AppMethodBeat.i(37887);
        Object format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            intValue = Integer.valueOf(format).intValue();
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(format)));
            intValue = (int) (j / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        }
        AppMethodBeat.o(37887);
        return intValue;
    }

    public final void ls(int i) {
        AppMethodBeat.i(37888);
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = kA((long) i);
            AppMethodBeat.o(37888);
            return;
        }
        if (this.field_head == 0) {
            this.field_head = kA((long) this.field_createTime);
        }
        AppMethodBeat.o(37888);
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

    public final void bi(byte[] bArr) {
        AppMethodBeat.i(37890);
        this.field_attrBuf = bArr;
        this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
        AppMethodBeat.o(37890);
    }

    public final void kB(long j) {
        AppMethodBeat.i(37891);
        this.field_stringSeq = i.jV(j);
        this.field_stringSeq = i.Xl(this.field_stringSeq);
        ab.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
        AppMethodBeat.o(37891);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(37892);
        super.d(cursor);
        this.reX = (int) this.xDa;
        AppMethodBeat.o(37892);
    }

    public static synchronized void release() {
        synchronized (n.class) {
            AppMethodBeat.i(37893);
            rfe.clear();
            rff.clear();
            AppMethodBeat.o(37893);
        }
    }

    public final TimeLineObject cqu() {
        AppMethodBeat.i(37894);
        TimeLineObject ajM;
        if (this.field_content == null) {
            ajM = e.ajM();
            AppMethodBeat.o(37894);
            return ajM;
        }
        if (this.reW == null) {
            this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
        }
        if (rfe.containsKey(this.reW)) {
            ajM = (TimeLineObject) rfe.get(this.reW);
            if (ajM != null) {
                AppMethodBeat.o(37894);
                return ajM;
            }
        }
        try {
            ajM = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
            rfe.put(this.reW, ajM);
            AppMethodBeat.o(37894);
            return ajM;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            ajM = e.ajM();
            AppMethodBeat.o(37894);
            return ajM;
        }
    }

    public final void c(TimeLineObject timeLineObject) {
        AppMethodBeat.i(37895);
        try {
            this.field_content = timeLineObject.toByteArray();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
        AppMethodBeat.o(37895);
    }

    public final boolean YR(String str) {
        AppMethodBeat.i(37896);
        try {
            this.field_content = e.tC(str).toByteArray();
            this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
            AppMethodBeat.o(37896);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            AppMethodBeat.o(37896);
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

    public static boolean kC(long j) {
        AppMethodBeat.i(37897);
        if (bo.fp(j / 1000) > 1200) {
            AppMethodBeat.o(37897);
            return true;
        }
        AppMethodBeat.o(37897);
        return false;
    }

    public final boolean DI(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void DF(int i) {
        this.field_sourceType |= i;
    }

    public final void DJ(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b cqo() {
        AppMethodBeat.i(37898);
        if (this.rfh == null) {
            this.rfh = af.cnI().ku(this.field_snsId);
        }
        b bVar;
        if (this.rfh == null) {
            bVar = new b(null);
            AppMethodBeat.o(37898);
            return bVar;
        }
        bVar = this.rfh.cqo();
        AppMethodBeat.o(37898);
        return bVar;
    }

    public final a cqq() {
        AppMethodBeat.i(37899);
        if (this.rfh == null) {
            this.rfh = af.cnI().ku(this.field_snsId);
        }
        a aVar;
        if (this.rfh == null) {
            aVar = new a(null);
            AppMethodBeat.o(37899);
            return aVar;
        }
        aVar = this.rfh.cqq();
        AppMethodBeat.o(37899);
        return aVar;
    }

    public final a cqr() {
        AppMethodBeat.i(37900);
        if (this.rfh == null) {
            this.rfh = af.cnI().ku(this.field_snsId);
        }
        a aVar;
        if (this.rfh == null) {
            aVar = new a(null);
            AppMethodBeat.o(37900);
            return aVar;
        }
        aVar = this.rfh.cqr();
        AppMethodBeat.o(37900);
        return aVar;
    }

    public final String cqZ() {
        AppMethodBeat.i(37901);
        a cqq = cqq();
        String str;
        if (cqq == null) {
            str = "";
            AppMethodBeat.o(37901);
            return str;
        }
        str = cqq.qTL;
        AppMethodBeat.o(37901);
        return str;
    }

    public final String cra() {
        AppMethodBeat.i(37902);
        a cqq = cqq();
        String str;
        if (cqq == null) {
            str = "";
            AppMethodBeat.o(37902);
            return str;
        }
        str = cqq.qTK;
        AppMethodBeat.o(37902);
        return str;
    }

    public final String getAdLink() {
        AppMethodBeat.i(37903);
        b cqo = cqo();
        String str;
        if (cqo != null) {
            str = cqo.qTA;
            AppMethodBeat.o(37903);
            return str;
        }
        str = "";
        AppMethodBeat.o(37903);
        return str;
    }

    public final String crb() {
        AppMethodBeat.i(37904);
        a cqq = cqq();
        String str;
        if (cqq != null) {
            str = cqq.qTA;
            AppMethodBeat.o(37904);
            return str;
        }
        str = "";
        AppMethodBeat.o(37904);
        return str;
    }

    public final String crc() {
        AppMethodBeat.i(37905);
        a cqq = cqq();
        String str;
        if (cqq != null) {
            str = cqq.qPj;
            AppMethodBeat.o(37905);
            return str;
        }
        str = "";
        AppMethodBeat.o(37905);
        return str;
    }

    public final e crd() {
        AppMethodBeat.i(37906);
        if (this.rfh == null) {
            this.rfh = af.cnI().ku(this.field_snsId);
        }
        if (this.rfh != null) {
            this.rfh.field_createTime = this.field_createTime;
            this.rfh.field_userName = this.field_userName;
            this.rfh.field_likeFlag = this.field_likeFlag;
            this.rfh.field_attrBuf = this.field_attrBuf;
        }
        e eVar = this.rfh;
        AppMethodBeat.o(37906);
        return eVar;
    }

    public final boolean sh() {
        AppMethodBeat.i(139040);
        boolean DI = DI(32);
        AppMethodBeat.o(139040);
        return DI;
    }

    public final int cre() {
        AppMethodBeat.i(37908);
        b cqo = cqo();
        if (cqo != null) {
            int i = cqo.qUA;
            AppMethodBeat.o(37908);
            return i;
        }
        AppMethodBeat.o(37908);
        return 0;
    }

    public final boolean coX() {
        AppMethodBeat.i(37909);
        b cqo = cqo();
        if (cqo != null) {
            boolean coX = cqo.coX();
            AppMethodBeat.o(37909);
            return coX;
        }
        AppMethodBeat.o(37909);
        return false;
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean cnn() {
        return this.field_snsId == 0;
    }

    public final boolean crg() {
        AppMethodBeat.i(37911);
        if (cqu() == null || cqu().xfI.wbJ != 27) {
            AppMethodBeat.o(37911);
            return false;
        }
        AppMethodBeat.o(37911);
        return true;
    }

    public final boolean coP() {
        AppMethodBeat.i(37912);
        if (cqo() == null || !cqo().coP()) {
            AppMethodBeat.o(37912);
            return false;
        }
        AppMethodBeat.o(37912);
        return true;
    }

    public final boolean coQ() {
        AppMethodBeat.i(37913);
        if (cqo() == null || !cqo().coQ()) {
            AppMethodBeat.o(37913);
            return false;
        }
        AppMethodBeat.o(37913);
        return true;
    }

    public final Bundle cqC() {
        AppMethodBeat.i(37914);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.Hl());
        bundle.putInt("localid", this.reX);
        if (crd() != null) {
            bundle.putBundle("adValues", crd().cqC());
        }
        AppMethodBeat.o(37914);
        return bundle;
    }

    public final String cqA() {
        AppMethodBeat.i(37886);
        String ao;
        if (DI(32)) {
            ao = v.ao("ad_table_", this.field_snsId);
            AppMethodBeat.o(37886);
            return ao;
        }
        ao = v.ao("sns_table_", this.field_snsId);
        AppMethodBeat.o(37886);
        return ao;
    }

    public final String cqU() {
        AppMethodBeat.i(37889);
        String ao;
        if (DI(32)) {
            ao = v.ao("ad_table_", (long) this.reX);
            AppMethodBeat.o(37889);
            return ao;
        }
        ao = v.ao("sns_table_", (long) this.reX);
        AppMethodBeat.o(37889);
        return ao;
    }

    public final int crf() {
        AppMethodBeat.i(37910);
        if (DI(32)) {
            b cqo = cqo();
            TimeLineObject cqu = cqu();
            if (cqo.coO()) {
                AppMethodBeat.o(37910);
                return 3;
            } else if (cqu != null && cqu.xfI.wbJ == 27) {
                AppMethodBeat.o(37910);
                return 6;
            } else if (cqo.coP() || cqo.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    AppMethodBeat.o(37910);
                    return 4;
                }
                AppMethodBeat.o(37910);
                return 5;
            } else if (this.field_type == 1) {
                AppMethodBeat.o(37910);
                return 1;
            } else {
                AppMethodBeat.o(37910);
                return 2;
            }
        }
        AppMethodBeat.o(37910);
        return -1;
    }

    static {
        AppMethodBeat.i(37915);
        a aVar = new a();
        aVar.xDb = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsId";
        aVar.xDd.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.xDd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "head";
        aVar.xDd.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPrivate";
        aVar.xDd.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "sourceType";
        aVar.xDd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "likeFlag";
        aVar.xDd.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "pravited";
        aVar.xDd.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "stringSeq";
        aVar.xDd.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrBuf";
        aVar.xDd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "postBuf";
        aVar.xDd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "subType";
        aVar.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        aVar.columns[15] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(37915);
    }
}
