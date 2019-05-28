package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bd extends a {
    private long dbm = 0;
    private long dbn = 0;
    private String dbo = "";
    private long dbp = 0;
    private String dbq = "";
    private long dbr = 0;
    private long dbs = 0;
    private long dbt = 0;

    public final int getId() {
        return 17121;
    }

    public final bd fT(String str) {
        AppMethodBeat.i(108887);
        this.dbo = t("QueryContent", str, true);
        AppMethodBeat.o(108887);
        return this;
    }

    public final bd cH(long j) {
        this.dbp = j;
        return this;
    }

    public final bd fU(String str) {
        AppMethodBeat.i(108888);
        this.dbq = t("Behavior", str, true);
        AppMethodBeat.o(108888);
        return this;
    }

    public final String Gw() {
        return this.dbq;
    }

    public final bd cI(long j) {
        this.dbr = j;
        return this;
    }

    public final bd cJ(long j) {
        this.dbs = j;
        return this;
    }

    public final bd cK(long j) {
        this.dbt = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108889);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dbm);
        stringBuffer.append(str);
        stringBuffer.append(this.dbn);
        stringBuffer.append(str);
        stringBuffer.append(this.dbo);
        stringBuffer.append(str);
        stringBuffer.append(this.dbp);
        stringBuffer.append(str);
        stringBuffer.append(this.dbq);
        stringBuffer.append(str);
        stringBuffer.append(this.dbr);
        stringBuffer.append(str);
        stringBuffer.append(this.dbs);
        stringBuffer.append(str);
        stringBuffer.append(this.dbt);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108889);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108890);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SearchID:").append(this.dbm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("RecommentID:").append(this.dbn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("QueryContent:").append(this.dbo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FinishType:").append(this.dbp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Behavior:").append(this.dbq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MaxIndex:").append(this.dbr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewSearchID:").append(this.dbs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewRecommentID:").append(this.dbt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108890);
        return stringBuffer2;
    }
}
