package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class o {
    public final a unU = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(6858);
            cm cmVar = aVar.eAB;
            if (cmVar.vED == null) {
                AppMethodBeat.o(6858);
            } else if (bo.isNullOrNil(aa.a(cmVar.vED))) {
                AppMethodBeat.o(6858);
            } else {
                c.cYm();
                ab.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                AppMethodBeat.o(6858);
            }
        }
    };
    public final c unV = new c<vn>() {
        {
            AppMethodBeat.i(6859);
            this.xxI = vn.class.getName().hashCode();
            AppMethodBeat.o(6859);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6860);
            vn vnVar = (vn) bVar;
            if (vnVar == null || !(vnVar instanceof vn)) {
                AppMethodBeat.o(6860);
            } else if (bo.isNullOrNil(vnVar.cSA.cHz)) {
                AppMethodBeat.o(6860);
            } else {
                c.cYm();
                ab.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                AppMethodBeat.o(6860);
            }
            return false;
        }
    };
    public final c unW = new c<com.tencent.mm.g.a.bo>() {
        {
            AppMethodBeat.i(6861);
            this.xxI = com.tencent.mm.g.a.bo.class.getName().hashCode();
            AppMethodBeat.o(6861);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6862);
            com.tencent.mm.g.a.bo boVar = (com.tencent.mm.g.a.bo) bVar;
            if (boVar == null || !(boVar instanceof com.tencent.mm.g.a.bo)) {
                AppMethodBeat.o(6862);
            } else {
                if (ah.getContext() != null) {
                    com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                }
                com.tencent.mm.vfs.e.N(com.tencent.mm.compatible.util.e.evd, true);
                WebViewCacheDownloadHelper.cYs();
                AppMethodBeat.o(6862);
            }
            return false;
        }
    };

    public o() {
        AppMethodBeat.i(6863);
        AppMethodBeat.o(6863);
    }
}
