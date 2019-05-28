package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bd */
public final class C18438bd extends C46180a {
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

    /* renamed from: fT */
    public final C18438bd mo33698fT(String str) {
        AppMethodBeat.m2504i(108887);
        this.dbo = mo74169t("QueryContent", str, true);
        AppMethodBeat.m2505o(108887);
        return this;
    }

    /* renamed from: cH */
    public final C18438bd mo33694cH(long j) {
        this.dbp = j;
        return this;
    }

    /* renamed from: fU */
    public final C18438bd mo33699fU(String str) {
        AppMethodBeat.m2504i(108888);
        this.dbq = mo74169t("Behavior", str, true);
        AppMethodBeat.m2505o(108888);
        return this;
    }

    /* renamed from: Gw */
    public final String mo33693Gw() {
        return this.dbq;
    }

    /* renamed from: cI */
    public final C18438bd mo33695cI(long j) {
        this.dbr = j;
        return this;
    }

    /* renamed from: cJ */
    public final C18438bd mo33696cJ(long j) {
        this.dbs = j;
        return this;
    }

    /* renamed from: cK */
    public final C18438bd mo33697cK(long j) {
        this.dbt = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108889);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108889);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108890);
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
        AppMethodBeat.m2505o(108890);
        return stringBuffer2;
    }
}
