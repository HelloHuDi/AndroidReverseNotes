package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C30309s;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "playErrType", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "doReport", "", "eventType", "getPlayType", "playStatus", "init", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d */
public final class C27562d {
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public C45767b jWx;
    public String jYA = "";
    private final String jYw = ",";
    public int jYx;
    public int jYy;
    public int jYz;

    /* renamed from: sE */
    public final void mo45367sE(int i) {
        AppMethodBeat.m2504i(15325);
        int Me = C1192l.m2616Me();
        if (Me == 100) {
            Me = -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Me);
        stringBuilder.append(this.jYw);
        C45767b c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.mo73552HE());
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.jVD);
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.jVE);
        stringBuilder.append(this.jYw);
        stringBuilder.append(C30309s.getSessionId());
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.jVF);
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.fgd);
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.aYl().fjB);
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
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.scene);
        stringBuilder.append(this.jYw);
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        stringBuilder.append(c45767b.jSW);
        stringBuilder.append(this.jYw);
        stringBuilder.append(this.jYA);
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "sb.toString()");
        C4990ab.m7410d(this.TAG, "eventType: " + i + " reportData: " + stringBuilder2);
        C7060h.pYm.mo8374X(17149, stringBuilder2);
        AppMethodBeat.m2505o(15325);
    }
}
