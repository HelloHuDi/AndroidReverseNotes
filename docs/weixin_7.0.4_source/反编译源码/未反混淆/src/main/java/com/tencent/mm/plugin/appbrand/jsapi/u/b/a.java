package com.tencent.mm.plugin.appbrand.jsapi.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;

public final class a implements f {
    int idH = 0;
    c idI;
    private com.tencent.mm.plugin.appbrand.jsapi.u.b.f.a idJ;
    private ap idK = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(117366);
            if (a.this.idH > 0) {
                if (a.this.idI != null) {
                    boolean isPlaying;
                    c cVar = a.this.idI;
                    if (cVar.idR != null) {
                        isPlaying = cVar.idR.isPlaying();
                    } else {
                        isPlaying = false;
                    }
                    if (isPlaying) {
                        a.this.aGD();
                        AppMethodBeat.o(117366);
                        return false;
                    }
                }
                AppMethodBeat.o(117366);
                return true;
            }
            AppMethodBeat.o(117366);
            return false;
        }
    }, true);

    public a(c cVar, com.tencent.mm.plugin.appbrand.jsapi.u.b.f.a aVar) {
        AppMethodBeat.i(117367);
        this.idI = cVar;
        this.idJ = aVar;
        AppMethodBeat.o(117367);
    }

    public final void dh(int i, int i2) {
        AppMethodBeat.i(117370);
        this.idH++;
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d), error count:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.idH));
        if (this.idH >= 5) {
            aGD();
            if (this.idJ != null) {
                String str;
                com.tencent.mm.plugin.appbrand.jsapi.u.b.f.a aVar = this.idJ;
                if (i == -1024) {
                    str = "VIDEO_ERROR";
                } else if (i == -1010) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1007) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1004) {
                    if (at.isConnected(ah.getContext())) {
                        str = "MEDIA_ERR_DECODE";
                    } else {
                        str = "MEDIA_ERR_NETWORK";
                    }
                } else if (at.isConnected(ah.getContext())) {
                    str = "MEDIA_ERR_DECODE";
                } else {
                    str = "MEDIA_ERR_NETWORK";
                }
                aVar.I(str, i, i2);
                AppMethodBeat.o(117370);
                return;
            }
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117365);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "retry play video, error count:%d", Integer.valueOf(a.this.idH));
                if (a.this.idI != null) {
                    c cVar = a.this.idI;
                    if (cVar.idR != null) {
                        if (cVar.iea) {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler retry when error, video has prepared");
                            cVar.pause();
                            if (cVar.idR != null) {
                                int currentPosition = cVar.idR.getCurrentPosition();
                                cVar.ieb = true;
                                cVar.seek(currentPosition);
                                AppMethodBeat.o(117365);
                                return;
                            }
                        }
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler retry when error, video has not prepared");
                        cVar.prepareAsync();
                    }
                }
                AppMethodBeat.o(117365);
            }
        }, 200);
        AppMethodBeat.o(117370);
    }

    /* Access modifiers changed, original: final */
    public final void aGD() {
        AppMethodBeat.i(117371);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "reset error count");
        this.idH = 0;
        AppMethodBeat.o(117371);
    }

    public final void init() {
        AppMethodBeat.i(117368);
        if (this.idH > 0 && this.idK != null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "start error check timer");
            this.idK.ae(5000, 5000);
        }
        AppMethodBeat.o(117368);
    }

    public final void destroy() {
        AppMethodBeat.i(117369);
        if (this.idK != null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "stop error check timer");
            this.idK.stopTimer();
        }
        AppMethodBeat.o(117369);
    }
}
