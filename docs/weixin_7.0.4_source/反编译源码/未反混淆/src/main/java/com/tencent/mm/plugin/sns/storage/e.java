package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.b;
import com.tencent.mm.g.c.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends f {
    protected static a ccO;
    protected static Map<String, b> reY = new ConcurrentHashMap();
    protected static Map<String, a> reZ = new ConcurrentHashMap();
    public String reW = null;
    protected int reX;

    public final a Ag() {
        return ccO;
    }

    public final b cqo() {
        b bVar;
        AppMethodBeat.i(37801);
        if (this.field_adxml == null) {
            bVar = null;
        } else if (reY.containsKey(this.field_adxml)) {
            bVar = (b) reY.get(this.field_adxml);
            AppMethodBeat.o(37801);
            return bVar;
        } else {
            bVar = new b(this.field_adxml);
            reY.put(this.field_adxml, bVar);
        }
        if (bVar == null) {
            bVar = new b(null);
            AppMethodBeat.o(37801);
            return bVar;
        }
        AppMethodBeat.o(37801);
        return bVar;
    }

    private b cqp() {
        b bVar;
        AppMethodBeat.i(37802);
        if (this.field_recxml == null) {
            bVar = null;
        } else if (reY.containsKey(this.field_recxml)) {
            bVar = (b) reY.get(this.field_recxml);
            AppMethodBeat.o(37802);
            return bVar;
        } else {
            bVar = new b(this.field_recxml);
            reY.put(this.field_recxml, bVar);
        }
        if (bVar == null) {
            bVar = new b(null);
            AppMethodBeat.o(37802);
            return bVar;
        }
        AppMethodBeat.o(37802);
        return bVar;
    }

    public final a cqq() {
        a aVar;
        AppMethodBeat.i(37803);
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (reZ.containsKey(this.field_adinfo)) {
            aVar = (a) reZ.get(this.field_adinfo);
            AppMethodBeat.o(37803);
            return aVar;
        } else {
            aVar = new a(this.field_adinfo);
            reZ.put(this.field_adinfo, aVar);
        }
        if (aVar == null) {
            aVar = new a(null);
            AppMethodBeat.o(37803);
            return aVar;
        }
        AppMethodBeat.o(37803);
        return aVar;
    }

    public final a cqr() {
        a aVar;
        AppMethodBeat.i(37804);
        if (this.field_atAdinfo == null) {
            aVar = null;
        } else if (reZ.containsKey(this.field_atAdinfo)) {
            aVar = (a) reZ.get(this.field_atAdinfo);
            AppMethodBeat.o(37804);
            return aVar;
        } else {
            aVar = new a(this.field_atAdinfo);
            reZ.put(this.field_atAdinfo, aVar);
        }
        if (aVar == null) {
            aVar = new a(null);
            AppMethodBeat.o(37804);
            return aVar;
        }
        AppMethodBeat.o(37804);
        return aVar;
    }

    public final boolean coX() {
        AppMethodBeat.i(37805);
        b cqo = cqo();
        if (cqo != null) {
            boolean coX = cqo.coX();
            AppMethodBeat.o(37805);
            return coX;
        }
        AppMethodBeat.o(37805);
        return false;
    }

    public final int cqs() {
        AppMethodBeat.i(37806);
        b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.o(37806);
            return 0;
        }
        int i = cqp.qUA;
        AppMethodBeat.o(37806);
        return i;
    }

    public final int getSource() {
        AppMethodBeat.i(37807);
        b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.o(37807);
            return 0;
        }
        int i = cqp.qUA;
        AppMethodBeat.o(37807);
        return i;
    }

    public final int cqt() {
        AppMethodBeat.i(37808);
        b cqp = cqp();
        if (cqp == null) {
            AppMethodBeat.o(37808);
            return 0;
        }
        int i = cqp.qUB;
        AppMethodBeat.o(37808);
        return i;
    }

    public final void c(TimeLineObject timeLineObject) {
        AppMethodBeat.i(37809);
        try {
            this.field_content = timeLineObject.toByteArray();
            AppMethodBeat.o(37809);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            AppMethodBeat.o(37809);
        }
    }

    public final boolean YR(String str) {
        AppMethodBeat.i(37810);
        try {
            this.field_content = com.tencent.mm.modelsns.e.tC(str).toByteArray();
            this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
            AppMethodBeat.o(37810);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            AppMethodBeat.o(37810);
            return false;
        }
    }

    public final TimeLineObject cqu() {
        AppMethodBeat.i(37811);
        TimeLineObject ajM;
        if (this.field_content == null) {
            ajM = com.tencent.mm.modelsns.e.ajM();
            AppMethodBeat.o(37811);
            return ajM;
        }
        if (this.reW == null) {
            this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
        }
        if (n.rfe.containsKey(this.reW)) {
            ajM = (TimeLineObject) n.rfe.get(this.reW);
            if (ajM != null) {
                AppMethodBeat.o(37811);
                return ajM;
            }
        }
        try {
            ajM = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
            n.rfe.put(this.reW, ajM);
            AppMethodBeat.o(37811);
            return ajM;
        } catch (Exception e) {
            ab.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            ajM = com.tencent.mm.modelsns.e.ajM();
            AppMethodBeat.o(37811);
            return ajM;
        }
    }

    public final void a(bs bsVar) {
        AppMethodBeat.i(37812);
        try {
            this.field_remindInfoGroup = bsVar.toByteArray();
            AppMethodBeat.o(37812);
        } catch (Exception e) {
            ab.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + e.getMessage());
            AppMethodBeat.o(37812);
        }
    }

    public final bs cqv() {
        bs bsVar;
        Exception e;
        AppMethodBeat.i(37813);
        try {
            if (this.field_remindInfoGroup != null) {
                bsVar = new bs();
                try {
                    bsVar.parseFrom(this.field_remindInfoGroup);
                } catch (Exception e2) {
                    e = e2;
                    ab.e("MicroMsg.AdSnsInfo", "parse remindInfo error! " + e.getMessage());
                    AppMethodBeat.o(37813);
                    return bsVar;
                }
            }
            bsVar = null;
        } catch (Exception e3) {
            e = e3;
            bsVar = null;
            ab.e("MicroMsg.AdSnsInfo", "parse remindInfo error! " + e.getMessage());
            AppMethodBeat.o(37813);
            return bsVar;
        }
        AppMethodBeat.o(37813);
        return bsVar;
    }

    public final b cqw() {
        AppMethodBeat.i(37814);
        if (cqv() == null || cqv().vDY == null || cqv().vDY.wTA == null) {
            AppMethodBeat.o(37814);
            return null;
        }
        b buffer = cqv().vDY.wTA.getBuffer();
        AppMethodBeat.o(37814);
        return buffer;
    }

    public final b cqx() {
        AppMethodBeat.i(37815);
        if (cqv() == null || cqv().vDY == null || cqv().vDY.wTB == null) {
            AppMethodBeat.o(37815);
            return null;
        }
        b buffer = cqv().vDY.wTB.getBuffer();
        AppMethodBeat.o(37815);
        return buffer;
    }

    public final b cqy() {
        AppMethodBeat.i(37816);
        if (cqv() == null || cqv().vDZ == null || cqv().vDZ.wTA == null) {
            AppMethodBeat.o(37816);
            return null;
        }
        b buffer = cqv().vDZ.wTA.getBuffer();
        AppMethodBeat.o(37816);
        return buffer;
    }

    public final b cqz() {
        AppMethodBeat.i(37817);
        if (cqv() == null || cqv().vDZ == null || cqv().vDZ.wTB == null) {
            AppMethodBeat.o(37817);
            return null;
        }
        b buffer = cqv().vDZ.wTB.getBuffer();
        AppMethodBeat.o(37817);
        return buffer;
    }

    public final void bi(byte[] bArr) {
        AppMethodBeat.i(37818);
        this.field_attrBuf = bArr;
        this.reW = g.x(this.field_content) + g.x(this.field_attrBuf);
        AppMethodBeat.o(37818);
    }

    public final void DF(int i) {
        this.field_sourceType |= i;
    }

    public final String cqA() {
        AppMethodBeat.i(37819);
        String ao = v.ao("ad_table_", this.field_snsId);
        AppMethodBeat.o(37819);
        return ao;
    }

    public final n cqB() {
        AppMethodBeat.i(37820);
        n nVar = new n();
        nVar.c(cqu());
        ab.d("MicroMsg.AdSnsInfo", "from server xml ok %d", Long.valueOf(this.field_snsId));
        nVar.reX = this.reX;
        nVar.field_userName = this.field_userName;
        nVar.ls(this.field_createTime);
        nVar.field_likeFlag = this.field_likeFlag;
        nVar.kz(this.field_snsId);
        nVar.field_sourceType = this.field_sourceType;
        nVar.field_content = this.field_content;
        nVar.DF(2);
        nVar.DF(32);
        nVar.field_attrBuf = this.field_attrBuf;
        TimeLineObject cqu = nVar.cqu();
        cqu.jBB = this.field_userName;
        nVar.field_pravited = cqu.wEJ;
        nVar.cqR();
        nVar.c(cqu);
        if (cqu.xfI != null) {
            nVar.field_type = cqu.xfI.wbJ;
            nVar.field_subType = cqu.xfI.wbL;
        }
        nVar.rfh = this;
        AppMethodBeat.o(37820);
        return nVar;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(37821);
        super.d(cursor);
        this.reX = (int) this.xDa;
        AppMethodBeat.o(37821);
    }

    public final Bundle cqC() {
        AppMethodBeat.i(37822);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.Hl());
        bundle.putInt("localid", this.reX);
        AppMethodBeat.o(37822);
        return bundle;
    }

    public final void L(Bundle bundle) {
        AppMethodBeat.i(37823);
        if (bundle == null) {
            AppMethodBeat.o(37823);
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
        this.field_content = contentValues.getAsByteArray(FirebaseAnalytics.b.CONTENT);
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
        AppMethodBeat.o(37823);
    }

    static {
        AppMethodBeat.i(37824);
        a aVar = new a();
        aVar.xDb = new Field[24];
        aVar.columns = new String[25];
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
        aVar.columns[11] = FirebaseAnalytics.b.CONTENT;
        aVar.xDd.put(FirebaseAnalytics.b.CONTENT, "BLOB");
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
        aVar.columns[14] = "adinfo";
        aVar.xDd.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "adxml";
        aVar.xDd.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "createAdTime";
        aVar.xDd.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "exposureTime";
        aVar.xDd.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "firstControlTime";
        aVar.xDd.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "recxml";
        aVar.xDd.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "subType";
        aVar.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "exposureCount";
        aVar.xDd.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[22] = "atAdinfo";
        aVar.xDd.put("atAdinfo", "TEXT");
        stringBuilder.append(" atAdinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "remindInfoGroup";
        aVar.xDd.put("remindInfoGroup", "BLOB");
        stringBuilder.append(" remindInfoGroup BLOB");
        aVar.columns[24] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(37824);
    }
}
