package com.tencent.p177mm.plugin.radar.p488b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nJ.\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J\b\u0010$\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.b.d */
public final class C43416d {
    public static final String TAG = TAG;
    public static int cEX = 0;
    public static int pBj = 0;
    public static long pBk = 0;
    public static long pBl = 0;
    public static long pBm = 0;
    public static int pBn = 0;
    private static final long pBo = pBo;
    private static final long pBp = 0;
    public static final C43416d pBq = new C43416d();

    static {
        AppMethodBeat.m2504i(102903);
        AppMethodBeat.m2505o(102903);
    }

    private C43416d() {
    }

    public static long cdz() {
        AppMethodBeat.m2504i(139163);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.m2505o(139163);
        return currentTimeMillis;
    }

    public static void cdx() {
        AppMethodBeat.m2504i(102900);
        cEX = 0;
        pBm = 0;
        pBm = System.currentTimeMillis();
        AppMethodBeat.m2505o(102900);
    }

    public static void cdy() {
        AppMethodBeat.m2504i(102901);
        pBn = 0;
        pBl = 0;
        pBj = 0;
        pBk = 0;
        pBl = System.currentTimeMillis();
        C7060h.pYm.mo8378a(pBo, pBp, 1, false);
        AppMethodBeat.m2505o(102901);
    }
}
