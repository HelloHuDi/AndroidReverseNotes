package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C9715b;
import com.tencent.p177mm.modelvideo.C9715b.C9714a;
import com.tencent.p177mm.p235i.C44686h.C26326a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a */
public final class C3945a implements C9715b {
    C9714a hYm;
    String qfW = "";

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a$a */
    class C3941a implements C26326a {
        private C3941a() {
        }

        /* synthetic */ C3941a(C3945a c3945a, byte b) {
            this();
        }

        public final void onMoovReady(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(37496);
            if (C3945a.this.hYm != null && C3945a.this.qfW.equals(str)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37492);
                        C7060h.pYm.mo15419k(955, 27, 1);
                        C3945a.this.hYm.mo21050ml(i);
                        AppMethodBeat.m2505o(37492);
                    }
                });
            }
            AppMethodBeat.m2505o(37496);
        }

        public final void onDataAvailable(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(37497);
            if (C3945a.this.hYm != null && C3945a.this.qfW.equals(str)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37493);
                        C7060h.pYm.mo15419k(955, 29, 1);
                        C3945a.this.hYm.onDataAvailable(str, i, i2);
                        AppMethodBeat.m2505o(37493);
                    }
                });
            }
            AppMethodBeat.m2505o(37497);
        }

        /* renamed from: h */
        public final void mo8706h(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(37498);
            if (C3945a.this.hYm != null && C3945a.this.qfW.equals(str)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37494);
                        C3945a.this.hYm.mo9075h(str, i, i2);
                        AppMethodBeat.m2505o(37494);
                    }
                });
            }
            AppMethodBeat.m2505o(37498);
        }

        /* renamed from: a */
        public final void mo8705a(final String str, final int i, C9545d c9545d) {
            AppMethodBeat.m2504i(37499);
            if (C3945a.this.hYm != null && C3945a.this.qfW.equals(str)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37495);
                        C7060h.pYm.mo15419k(955, 31, 1);
                        C3945a.this.hYm.mo9058ad(str, i);
                        AppMethodBeat.m2505o(37495);
                    }
                });
            }
            AppMethodBeat.m2505o(37499);
        }
    }

    /* renamed from: r */
    public final void mo8715r(String str, String str2, String str3) {
        AppMethodBeat.m2504i(37500);
        this.qfW = str;
        C4990ab.m7417i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str3, str2);
        AdLandingPagesProxy.getInstance().downloadLandingPageVideo(str, str3, str2, new C3941a(this, (byte) 0));
        AppMethodBeat.m2505o(37500);
    }

    /* renamed from: dV */
    public final void mo8713dV(String str) {
        AppMethodBeat.m2504i(37501);
        C4990ab.m7417i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.qfW.equals(str)) {
            AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(str);
        }
        AppMethodBeat.m2505o(37501);
    }

    public final void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.m2504i(37502);
        C4990ab.m7417i("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qfW.equals(str)) {
            AdLandingPagesProxy.getInstance().requestVideoData(str, i, i2);
        }
        AppMethodBeat.m2505o(37502);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(37503);
        C4990ab.m7417i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qfW.equals(str)) {
            boolean isVideoDataAvailable = AdLandingPagesProxy.getInstance().isVideoDataAvailable(str, i, i2);
            AppMethodBeat.m2505o(37503);
            return isVideoDataAvailable;
        }
        AppMethodBeat.m2505o(37503);
        return false;
    }

    /* renamed from: a */
    public final void mo8712a(C9714a c9714a) {
        this.hYm = c9714a;
    }
}
