package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ar extends a {
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

    public final ar bF(long j) {
        this.cTJ = j;
        return this;
    }

    public final long FE() {
        return this.cTJ;
    }

    public final ar bG(long j) {
        this.cYQ = j;
        return this;
    }

    public final long FF() {
        return this.cYQ;
    }

    public final long FG() {
        return this.cZK;
    }

    public final ar fA(String str) {
        AppMethodBeat.i(108862);
        this.cZq = t("SourceUserName", str, true);
        AppMethodBeat.o(108862);
        return this;
    }

    public final ar bH(long j) {
        this.cYR = j;
        return this;
    }

    public final ar bI(long j) {
        this.cYZ = j;
        return this;
    }

    public final long FH() {
        return this.cYZ;
    }

    public final ar bJ(long j) {
        this.cZL = j;
        return this;
    }

    public final ar bK(long j) {
        this.cZM = j;
        return this;
    }

    public final long FI() {
        return this.cZM;
    }

    public final ar bL(long j) {
        this.cZN = j;
        return this;
    }

    public final long FJ() {
        return this.cZN;
    }

    public final ar bM(long j) {
        this.cZO = j;
        return this;
    }

    public final long FK() {
        return this.cZO;
    }

    public final ar bN(long j) {
        this.cZP = j;
        return this;
    }

    public final long FL() {
        return this.cZP;
    }

    public final ar bO(long j) {
        this.cZQ = j;
        return this;
    }

    public final long FM() {
        return this.cZQ;
    }

    public final ar bP(long j) {
        this.cZR = j;
        return this;
    }

    public final long FN() {
        return this.cZR;
    }

    public final ar fB(String str) {
        AppMethodBeat.i(108863);
        this.cZl = t("ActionTrace", str, true);
        AppMethodBeat.o(108863);
        return this;
    }

    public final ar bQ(long j) {
        this.cZS = j;
        return this;
    }

    public final long FO() {
        return this.cZS;
    }

    public final ar fC(String str) {
        AppMethodBeat.i(108864);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(108864);
        return this;
    }

    public final String getSessionId() {
        return this.cWo;
    }

    public final ar bR(long j) {
        this.cZT = j;
        return this;
    }

    public final ar oh(long j) {
        this.cZU = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108865);
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
        VX(str);
        AppMethodBeat.o(108865);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108866);
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
        AppMethodBeat.o(108866);
        return stringBuffer2;
    }
}
