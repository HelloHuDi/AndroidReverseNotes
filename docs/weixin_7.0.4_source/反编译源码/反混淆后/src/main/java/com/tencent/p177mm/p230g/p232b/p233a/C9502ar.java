package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ar */
public final class C9502ar extends C46180a {
    private long cTJ = 0;
    private String cWo = "";
    public long cYQ = 0;
    public long cYR = 0;
    private long cYZ = 0;
    public long cZK = 0;
    private long cZL = 0;
    private long cZM = 0;
    private long cZN = 0;
    private long cZO = 0;
    private long cZP = 0;
    private long cZQ = 0;
    private long cZR = 0;
    private long cZS = 0;
    public long cZT = 0;
    private long cZU = 0;
    private long cZV = 0;
    private String cZl = "";
    private String cZq = "";
    public long cZr = 0;

    public final int getId() {
        return 16658;
    }

    /* renamed from: bF */
    public final C9502ar mo20742bF(long j) {
        this.cTJ = j;
        return this;
    }

    /* renamed from: FE */
    public final long mo20731FE() {
        return this.cTJ;
    }

    /* renamed from: bG */
    public final C9502ar mo20743bG(long j) {
        this.cYQ = j;
        return this;
    }

    /* renamed from: FF */
    public final long mo20732FF() {
        return this.cYQ;
    }

    /* renamed from: FG */
    public final long mo20733FG() {
        return this.cZK;
    }

    /* renamed from: fA */
    public final C9502ar mo20755fA(String str) {
        AppMethodBeat.m2504i(108862);
        this.cZq = mo74169t("SourceUserName", str, true);
        AppMethodBeat.m2505o(108862);
        return this;
    }

    /* renamed from: bH */
    public final C9502ar mo20744bH(long j) {
        this.cYR = j;
        return this;
    }

    /* renamed from: bI */
    public final C9502ar mo20745bI(long j) {
        this.cYZ = j;
        return this;
    }

    /* renamed from: FH */
    public final long mo20734FH() {
        return this.cYZ;
    }

    /* renamed from: bJ */
    public final C9502ar mo20746bJ(long j) {
        this.cZL = j;
        return this;
    }

    /* renamed from: bK */
    public final C9502ar mo20747bK(long j) {
        this.cZM = j;
        return this;
    }

    /* renamed from: FI */
    public final long mo20735FI() {
        return this.cZM;
    }

    /* renamed from: bL */
    public final C9502ar mo20748bL(long j) {
        this.cZN = j;
        return this;
    }

    /* renamed from: FJ */
    public final long mo20736FJ() {
        return this.cZN;
    }

    /* renamed from: bM */
    public final C9502ar mo20749bM(long j) {
        this.cZO = j;
        return this;
    }

    /* renamed from: FK */
    public final long mo20737FK() {
        return this.cZO;
    }

    /* renamed from: bN */
    public final C9502ar mo20750bN(long j) {
        this.cZP = j;
        return this;
    }

    /* renamed from: FL */
    public final long mo20738FL() {
        return this.cZP;
    }

    /* renamed from: bO */
    public final C9502ar mo20751bO(long j) {
        this.cZQ = j;
        return this;
    }

    /* renamed from: FM */
    public final long mo20739FM() {
        return this.cZQ;
    }

    /* renamed from: bP */
    public final C9502ar mo20752bP(long j) {
        this.cZR = j;
        return this;
    }

    /* renamed from: FN */
    public final long mo20740FN() {
        return this.cZR;
    }

    /* renamed from: fB */
    public final C9502ar mo20756fB(String str) {
        AppMethodBeat.m2504i(108863);
        this.cZl = mo74169t("ActionTrace", str, true);
        AppMethodBeat.m2505o(108863);
        return this;
    }

    /* renamed from: bQ */
    public final C9502ar mo20753bQ(long j) {
        this.cZS = j;
        return this;
    }

    /* renamed from: FO */
    public final long mo20741FO() {
        return this.cZS;
    }

    /* renamed from: fC */
    public final C9502ar mo20757fC(String str) {
        AppMethodBeat.m2504i(108864);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(108864);
        return this;
    }

    public final String getSessionId() {
        return this.cWo;
    }

    /* renamed from: bR */
    public final C9502ar mo20754bR(long j) {
        this.cZT = j;
        return this;
    }

    /* renamed from: oh */
    public final C9502ar mo20759oh(long j) {
        this.cZU = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108865);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZK);
        stringBuffer.append(str);
        stringBuffer.append(this.cZq);
        stringBuffer.append(str);
        stringBuffer.append(this.cZr);
        stringBuffer.append(str);
        stringBuffer.append(this.cYR);
        stringBuffer.append(str);
        stringBuffer.append(this.cYZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZL);
        stringBuffer.append(str);
        stringBuffer.append(this.cZM);
        stringBuffer.append(str);
        stringBuffer.append(this.cZN);
        stringBuffer.append(str);
        stringBuffer.append(this.cZO);
        stringBuffer.append(str);
        stringBuffer.append(this.cZP);
        stringBuffer.append(str);
        stringBuffer.append(this.cZQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZR);
        stringBuffer.append(str);
        stringBuffer.append(this.cZl);
        stringBuffer.append(str);
        stringBuffer.append(this.cZS);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cZT);
        stringBuffer.append(str);
        stringBuffer.append(this.cZU);
        stringBuffer.append(str);
        stringBuffer.append(this.cZV);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(108865);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108866);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.cTJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ProfileSource:").append(this.cZK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceUserName:").append(this.cZq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceContactType:").append(this.cZr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasUnreadStoryTips:").append(this.cYR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterTime:").append(this.cYZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExitTime:").append(this.cZL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TotalUserNameCount:").append(this.cZM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FriendUserNameCount:").append(this.cZN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TotalStoryCount:").append(this.cZO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FriendStoryCount:").append(this.cZP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TotalBrowserCount:").append(this.cZQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FriendBrowserCount:").append(this.cZR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ActionTrace:").append(this.cZl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AllVideoBrowserCountWithRepeat:").append(this.cZS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitPlayFriendCount:").append(this.cZT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsShowComment:").append(this.cZU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsInformComment:").append(this.cZV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108866);
        return stringBuffer2;
    }
}
