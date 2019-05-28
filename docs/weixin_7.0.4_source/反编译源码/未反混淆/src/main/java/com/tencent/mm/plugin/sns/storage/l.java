package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ek;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public final class l extends ek {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final void cqI() {
        this.field_local_flag &= -3;
    }

    public final boolean cqJ() {
        return (this.field_local_flag & 2) > 0;
    }

    public final void a(ccl ccl) {
        AppMethodBeat.i(37855);
        if (ccl == null) {
            AppMethodBeat.o(37855);
            return;
        }
        try {
            this.field_snsuser = ccl.toByteArray();
            AppMethodBeat.o(37855);
        } catch (Exception e) {
            AppMethodBeat.o(37855);
        }
    }

    public final ccl cqK() {
        AppMethodBeat.i(37856);
        try {
            ccl ccl = (ccl) new ccl().parseFrom(this.field_snsuser);
            AppMethodBeat.o(37856);
            return ccl;
        } catch (Exception e) {
            AppMethodBeat.o(37856);
            return null;
        }
    }

    public final aao cqL() {
        AppMethodBeat.i(37857);
        acs acs = new acs();
        aao aao = new aao();
        if (!bo.cb(this.field_faultS)) {
            try {
                aao aao2;
                acs = (acs) new acs().parseFrom(this.field_faultS);
                if (acs.wkv.size() > 0) {
                    aao2 = (aao) acs.wkv.getFirst();
                } else {
                    aao2 = aao;
                }
                aao = aao2;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(37857);
        return aao;
    }

    static {
        AppMethodBeat.i(37858);
        a aVar = new a();
        aVar.xDb = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xDd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "userName";
        aVar.columns[1] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "newerIds";
        aVar.xDd.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "bgId";
        aVar.xDd.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bgUrl";
        aVar.xDd.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "older_bgId";
        aVar.xDd.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "local_flag";
        aVar.xDd.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "istyle";
        aVar.xDd.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "iFlag";
        aVar.xDd.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "icount";
        aVar.xDd.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "faultS";
        aVar.xDd.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "snsBgId";
        aVar.xDd.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "snsuser";
        aVar.xDd.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "adsession";
        aVar.xDd.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "lastFirstPageRequestErrCode";
        aVar.xDd.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastFirstPageRequestErrType";
        aVar.xDd.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        aVar.columns[16] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(37858);
    }
}
