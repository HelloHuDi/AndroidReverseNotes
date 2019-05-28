package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.service.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class n implements d {
    public final WxaAttributes zb(String str) {
        AppMethodBeat.i(129876);
        WxaAttributes d = f.auO().d(str, new String[0]);
        AppMethodBeat.o(129876);
        return d;
    }

    public final WxaAttributes zc(String str) {
        AppMethodBeat.i(129877);
        WxaAttributes e = f.auO().e(str, new String[0]);
        AppMethodBeat.o(129877);
        return e;
    }

    public final void a(String str, final a aVar) {
        AppMethodBeat.i(129878);
        r.a(str, false, new b<WxaAttributes>() {
            public final /* synthetic */ void f(int i, Object obj) {
                AppMethodBeat.i(129870);
                WxaAttributes wxaAttributes = (WxaAttributes) obj;
                if (aVar != null) {
                    aVar.d(wxaAttributes);
                }
                AppMethodBeat.o(129870);
            }
        });
        AppMethodBeat.o(129878);
    }

    public final e<WxaAttributes> zd(final String str) {
        AppMethodBeat.i(129879);
        com.tencent.mm.ci.f b = g.da(str).b(new com.tencent.mm.vending.c.a<WxaAttributes, String>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129872);
                final com.tencent.mm.vending.g.b dMo = com.tencent.mm.vending.g.f.dMo();
                r.a(str, false, new b<WxaAttributes>() {
                    public final /* synthetic */ void f(int i, Object obj) {
                        AppMethodBeat.i(129871);
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        dMo.B(wxaAttributes);
                        AppMethodBeat.o(129871);
                    }
                });
                AppMethodBeat.o(129872);
                return null;
            }
        });
        AppMethodBeat.o(129879);
        return b;
    }

    public final void b(final String str, final a aVar) {
        AppMethodBeat.i(129880);
        if (bo.isNullOrNil(str)) {
            if (aVar != null) {
                aVar.d(null);
            }
            AppMethodBeat.o(129880);
            return;
        }
        final al alVar = new al();
        new ak(alVar.oAl.getLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129875);
                if (com.tencent.mm.kernel.g.RN().QY()) {
                    if (r.zr(str)) {
                        r.a(str, false, new b<WxaAttributes>() {
                            public final /* synthetic */ void f(int i, Object obj) {
                                AppMethodBeat.i(129873);
                                WxaAttributes wxaAttributes = (WxaAttributes) obj;
                                if (aVar != null) {
                                    aVar.d(wxaAttributes);
                                }
                                AppMethodBeat.o(129873);
                            }
                        });
                    } else if (aVar != null) {
                        aVar.d(n.this.zb(str));
                    }
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            AppMethodBeat.i(129874);
                            alVar.oAl.quit();
                            AppMethodBeat.o(129874);
                            return false;
                        }
                    });
                    AppMethodBeat.o(129875);
                    return;
                }
                if (aVar != null) {
                    aVar.d(null);
                }
                AppMethodBeat.o(129875);
            }
        });
        AppMethodBeat.o(129880);
    }

    public final void aE(List<String> list) {
        AppMethodBeat.i(129881);
        if (bo.ek(list)) {
            AppMethodBeat.o(129881);
            return;
        }
        ab.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", bo.c((List) list, ", "));
        r.a(list, j.a.WXA_CUSTOMER_SERVICE);
        AppMethodBeat.o(129881);
    }
}
