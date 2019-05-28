package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9530ek;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.protocal.protobuf.acs;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sns.storage.l */
public final class C29097l extends C9530ek {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final void cqI() {
        this.field_local_flag &= -3;
    }

    public final boolean cqJ() {
        return (this.field_local_flag & 2) > 0;
    }

    /* renamed from: a */
    public final void mo47210a(ccl ccl) {
        AppMethodBeat.m2504i(37855);
        if (ccl == null) {
            AppMethodBeat.m2505o(37855);
            return;
        }
        try {
            this.field_snsuser = ccl.toByteArray();
            AppMethodBeat.m2505o(37855);
        } catch (Exception e) {
            AppMethodBeat.m2505o(37855);
        }
    }

    public final ccl cqK() {
        AppMethodBeat.m2504i(37856);
        try {
            ccl ccl = (ccl) new ccl().parseFrom(this.field_snsuser);
            AppMethodBeat.m2505o(37856);
            return ccl;
        } catch (Exception e) {
            AppMethodBeat.m2505o(37856);
            return null;
        }
    }

    public final aao cqL() {
        AppMethodBeat.m2504i(37857);
        acs acs = new acs();
        aao aao = new aao();
        if (!C5046bo.m7540cb(this.field_faultS)) {
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
        AppMethodBeat.m2505o(37857);
        return aao;
    }

    static {
        AppMethodBeat.m2504i(37858);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[16];
        c4924a.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "userName";
        c4924a.xDd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "userName";
        c4924a.columns[1] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "newerIds";
        c4924a.xDd.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "bgId";
        c4924a.xDd.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "bgUrl";
        c4924a.xDd.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "older_bgId";
        c4924a.xDd.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "local_flag";
        c4924a.xDd.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "istyle";
        c4924a.xDd.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "iFlag";
        c4924a.xDd.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "icount";
        c4924a.xDd.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "faultS";
        c4924a.xDd.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        c4924a.columns[11] = "snsBgId";
        c4924a.xDd.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "snsuser";
        c4924a.xDd.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        c4924a.columns[13] = "adsession";
        c4924a.xDd.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        c4924a.columns[14] = "lastFirstPageRequestErrCode";
        c4924a.xDd.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[15] = "lastFirstPageRequestErrType";
        c4924a.xDd.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        c4924a.columns[16] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(37858);
    }
}
