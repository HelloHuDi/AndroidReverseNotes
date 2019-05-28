package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a implements b {
    com.tencent.mm.modelvideo.b.a hYm;
    String qfW = "";

    class a implements com.tencent.mm.i.h.a {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void onMoovReady(final String str, final int i, final int i2) {
            AppMethodBeat.i(37496);
            if (a.this.hYm != null && a.this.qfW.equals(str)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37492);
                        h.pYm.k(955, 27, 1);
                        a.this.hYm.ml(i);
                        AppMethodBeat.o(37492);
                    }
                });
            }
            AppMethodBeat.o(37496);
        }

        public final void onDataAvailable(final String str, final int i, final int i2) {
            AppMethodBeat.i(37497);
            if (a.this.hYm != null && a.this.qfW.equals(str)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37493);
                        h.pYm.k(955, 29, 1);
                        a.this.hYm.onDataAvailable(str, i, i2);
                        AppMethodBeat.o(37493);
                    }
                });
            }
            AppMethodBeat.o(37497);
        }

        public final void h(final String str, final int i, final int i2) {
            AppMethodBeat.i(37498);
            if (a.this.hYm != null && a.this.qfW.equals(str)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37494);
                        a.this.hYm.h(str, i, i2);
                        AppMethodBeat.o(37494);
                    }
                });
            }
            AppMethodBeat.o(37498);
        }

        public final void a(final String str, final int i, d dVar) {
            AppMethodBeat.i(37499);
            if (a.this.hYm != null && a.this.qfW.equals(str)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37495);
                        h.pYm.k(955, 31, 1);
                        a.this.hYm.ad(str, i);
                        AppMethodBeat.o(37495);
                    }
                });
            }
            AppMethodBeat.o(37499);
        }
    }

    public final void r(String str, String str2, String str3) {
        AppMethodBeat.i(37500);
        this.qfW = str;
        ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str3, str2);
        AdLandingPagesProxy.getInstance().downloadLandingPageVideo(str, str3, str2, new a(this, (byte) 0));
        AppMethodBeat.o(37500);
    }

    public final void dV(String str) {
        AppMethodBeat.i(37501);
        ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.qfW.equals(str)) {
            AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(str);
        }
        AppMethodBeat.o(37501);
    }

    public final void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.i(37502);
        ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qfW.equals(str)) {
            AdLandingPagesProxy.getInstance().requestVideoData(str, i, i2);
        }
        AppMethodBeat.o(37502);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(37503);
        ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qfW.equals(str)) {
            boolean isVideoDataAvailable = AdLandingPagesProxy.getInstance().isVideoDataAvailable(str, i, i2);
            AppMethodBeat.o(37503);
            return isVideoDataAvailable;
        }
        AppMethodBeat.o(37503);
        return false;
    }

    public final void a(com.tencent.mm.modelvideo.b.a aVar) {
        this.hYm = aVar;
    }
}
