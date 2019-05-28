package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.C38394f.C27123a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.a */
public final class C27110a implements C38394f {
    int idH = 0;
    C27116c idI;
    private C27123a idJ;
    private C7564ap idK = new C7564ap(new C271112(), true);

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.a$1 */
    class C271091 implements Runnable {
        C271091() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117365);
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "retry play video, error count:%d", Integer.valueOf(C27110a.this.idH));
            if (C27110a.this.idI != null) {
                C27116c c27116c = C27110a.this.idI;
                if (c27116c.idR != null) {
                    if (c27116c.iea) {
                        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler retry when error, video has prepared");
                        c27116c.pause();
                        if (c27116c.idR != null) {
                            int currentPosition = c27116c.idR.getCurrentPosition();
                            c27116c.ieb = true;
                            c27116c.seek(currentPosition);
                            AppMethodBeat.m2505o(117365);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler retry when error, video has not prepared");
                    c27116c.prepareAsync();
                }
            }
            AppMethodBeat.m2505o(117365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.a$2 */
    class C271112 implements C5015a {
        C271112() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(117366);
            if (C27110a.this.idH > 0) {
                if (C27110a.this.idI != null) {
                    boolean isPlaying;
                    C27116c c27116c = C27110a.this.idI;
                    if (c27116c.idR != null) {
                        isPlaying = c27116c.idR.isPlaying();
                    } else {
                        isPlaying = false;
                    }
                    if (isPlaying) {
                        C27110a.this.aGD();
                        AppMethodBeat.m2505o(117366);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(117366);
                return true;
            }
            AppMethodBeat.m2505o(117366);
            return false;
        }
    }

    public C27110a(C27116c c27116c, C27123a c27123a) {
        AppMethodBeat.m2504i(117367);
        this.idI = c27116c;
        this.idJ = c27123a;
        AppMethodBeat.m2505o(117367);
    }

    /* renamed from: dh */
    public final void mo44768dh(int i, int i2) {
        AppMethodBeat.m2504i(117370);
        this.idH++;
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d), error count:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.idH));
        if (this.idH >= 5) {
            aGD();
            if (this.idJ != null) {
                String str;
                C27123a c27123a = this.idJ;
                if (i == -1024) {
                    str = "VIDEO_ERROR";
                } else if (i == -1010) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1007) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1004) {
                    if (C5023at.isConnected(C4996ah.getContext())) {
                        str = "MEDIA_ERR_DECODE";
                    } else {
                        str = "MEDIA_ERR_NETWORK";
                    }
                } else if (C5023at.isConnected(C4996ah.getContext())) {
                    str = "MEDIA_ERR_DECODE";
                } else {
                    str = "MEDIA_ERR_NETWORK";
                }
                c27123a.mo44783I(str, i, i2);
                AppMethodBeat.m2505o(117370);
                return;
            }
        }
        C5004al.m7442n(new C271091(), 200);
        AppMethodBeat.m2505o(117370);
    }

    /* Access modifiers changed, original: final */
    public final void aGD() {
        AppMethodBeat.m2504i(117371);
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "reset error count");
        this.idH = 0;
        AppMethodBeat.m2505o(117371);
    }

    public final void init() {
        AppMethodBeat.m2504i(117368);
        if (this.idH > 0 && this.idK != null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "start error check timer");
            this.idK.mo16770ae(5000, 5000);
        }
        AppMethodBeat.m2505o(117368);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(117369);
        if (this.idK != null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "stop error check timer");
            this.idK.stopTimer();
        }
        AppMethodBeat.m2505o(117369);
    }
}
