package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "playErrType", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "doReport", "", "eventType", "getPlayType", "playStatus", "init", "plugin-brandservice_release"})
public final class d {
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public b jWx;
    public String jYA = "";
    private final String jYw = ",";
    public int jYx;
    public int jYy;
    public int jYz;

    public final void sE(int i) {
        AppMethodBeat.i(15325);
        int Me = com.tencent.mm.af.l.Me();
        if (Me == 100) {
            Me = -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Me);
        stringBuilder.append(this.jYw);
        b bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.HE());
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.jVD);
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.jVE);
        stringBuilder.append(this.jYw);
        stringBuilder.append(s.getSessionId());
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.jVF);
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.fgd);
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.aYl().fjB);
        stringBuilder.append(this.jYw);
        stringBuilder.append(i);
        stringBuilder.append(this.jYw);
        stringBuilder.append((int) (System.currentTimeMillis() / 1000));
        stringBuilder.append(this.jYw);
        stringBuilder.append(this.jYx);
        stringBuilder.append(this.jYw);
        stringBuilder.append(this.jYy);
        stringBuilder.append(this.jYw);
        stringBuilder.append(this.jYz);
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.scene);
        stringBuilder.append(this.jYw);
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        stringBuilder.append(bVar.jSW);
        stringBuilder.append(this.jYw);
        stringBuilder.append(this.jYA);
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "sb.toString()");
        ab.d(this.TAG, "eventType: " + i + " reportData: " + stringBuilder2);
        h.pYm.X(17149, stringBuilder2);
        AppMethodBeat.o(15325);
    }
}
