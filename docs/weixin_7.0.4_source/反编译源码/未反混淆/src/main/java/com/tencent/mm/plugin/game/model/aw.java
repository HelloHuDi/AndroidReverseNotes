package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.luggage.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public class aw extends c<ky> {
    private static volatile String cOG;
    private static volatile long mYE;
    private static volatile long mYF;
    private static Set<String> mYG = new HashSet();
    private static Set<String> mYH = new HashSet();
    private long mYI;
    private b mYJ;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(111474);
            final Bundle bundle = (Bundle) obj;
            if (bundle == null) {
                if (cVar != null) {
                    cVar.ao(bundle);
                }
                AppMethodBeat.o(111474);
                return;
            }
            com.tencent.mm.plugin.wepkg.utils.b.uXV = bundle.getBoolean("is_wepkg_disable");
            String string = bundle.getString("call_raw_url");
            final boolean z = bundle.getBoolean("preload_webcore", false);
            if (z) {
                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore");
            }
            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload entrance url:%s, isToolsProcess:%b, isToolsMpProcess:%b", string, Boolean.valueOf(ah.doF()), Boolean.valueOf(ah.doG()));
            if (WepkgMainProcessService.isLive()) {
                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload wepkg");
                d.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(111471);
                        aw.b(bundle, z, cVar);
                        AppMethodBeat.o(111471);
                    }
                });
                AppMethodBeat.o(111474);
                return;
            }
            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "prestart WepkgMainProcessService and preload wepkg");
            d.b(string, new com.tencent.mm.plugin.wepkg.model.a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.i(111473);
                    if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.csN) {
                        d.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111472);
                                aw.b(bundle, z, cVar);
                                AppMethodBeat.o(111472);
                            }
                        });
                    }
                    AppMethodBeat.o(111473);
                }
            });
            AppMethodBeat.o(111474);
        }
    }

    class b implements Runnable {
        private final ky mYU;

        public b(ky kyVar) {
            this.mYU = kyVar;
        }

        public final void run() {
            AppMethodBeat.i(111475);
            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
            aw.a(aw.this, this.mYU, null);
            h.pYm.k(939, 2, 1);
            AppMethodBeat.o(111475);
        }
    }

    public aw() {
        AppMethodBeat.i(111476);
        this.xxI = ky.class.getName().hashCode();
        AppMethodBeat.o(111476);
    }

    static /* synthetic */ void b(Bundle bundle, boolean z, com.tencent.mm.ipcinvoker.c cVar) {
        AppMethodBeat.i(111484);
        a(bundle, z, cVar);
        AppMethodBeat.o(111484);
    }

    static /* synthetic */ void b(com.tencent.mm.ipcinvoker.c cVar, Bundle bundle) {
        AppMethodBeat.i(111485);
        a(cVar, bundle);
        AppMethodBeat.o(111485);
    }

    static {
        AppMethodBeat.i(111486);
        AppMethodBeat.o(111486);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(final ky kyVar) {
        AppMethodBeat.i(111477);
        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", Integer.valueOf(kyVar.cGQ.type));
        if (kyVar.cGQ.intent == null) {
            AppMethodBeat.o(111477);
        } else {
            if (kyVar.cGQ.type == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.mYI;
                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", Long.valueOf(currentTimeMillis), Long.valueOf(this.mYI));
                if (System.currentTimeMillis() - this.mYI < 500) {
                    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
                    AppMethodBeat.o(111477);
                }
            }
            this.mYI = System.currentTimeMillis();
            String str;
            switch (kyVar.cGQ.type) {
                case 0:
                case 1:
                case 2:
                    String str2 = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                    String str3 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(kyVar.cGQ.type);
                    objArr[1] = Integer.valueOf(hashCode());
                    objArr[2] = Integer.valueOf(kyVar.hashCode());
                    objArr[3] = Long.valueOf(Thread.currentThread().getId());
                    objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                    ab.i(str2, str3, objArr);
                    str = "";
                    try {
                        str = kyVar.cGQ.intent.getStringExtra("rawUrl");
                    } catch (Exception e) {
                    }
                    str2 = kyVar.cGQ.intent.getStringExtra("game_float_layer_url");
                    synchronized (aw.class) {
                        try {
                            if (bo.nullAsNil(cOG).equalsIgnoreCase(str)) {
                                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                                break;
                            }
                            cOG = str;
                            mYE = System.currentTimeMillis();
                            mYF = System.currentTimeMillis();
                            if (ah.bqo()) {
                                com.tencent.mm.plugin.wepkg.utils.b.uXV = com.tencent.mm.plugin.game.commlib.a.bDh();
                            }
                            if (d.aig(str)) {
                                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", d.aid(str));
                                kyVar.cGQ.group = g.x(bo.nullAsNil(str).getBytes()) + "_" + System.currentTimeMillis();
                                this.mYJ = new b(kyVar);
                                al.n(this.mYJ, 500);
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.uXV);
                                bundle.putString("call_raw_url", str);
                                if (!bo.isNullOrNil(str2)) {
                                    bundle.putString("float_layer_url", str2);
                                }
                                if (kyVar.cGQ.type == 2) {
                                    bundle.putBoolean("is_luggage", true);
                                }
                                ToolsProcessIPCService.a(bundle, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                                    public final /* synthetic */ void ao(Object obj) {
                                        AppMethodBeat.i(111463);
                                        Bundle bundle = (Bundle) obj;
                                        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", Long.valueOf(System.currentTimeMillis() - aw.mYF));
                                        if (bundle != null) {
                                            aw.a(aw.this, kyVar, bundle);
                                        }
                                        AppMethodBeat.o(111463);
                                    }
                                });
                            } else {
                                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.uXV);
                                a(kyVar, null);
                            }
                        } finally {
                            while (true) {
                                AppMethodBeat.o(111477);
                                break;
                            }
                        }
                    }
                case 3:
                    str = kyVar.cGQ.intent.getStringExtra("rawUrl");
                    if (!mYH.contains(str) && d.aig(str)) {
                        mYH.add(str);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("call_raw_url", str);
                        bundle2.putBoolean("preload_webcore", true);
                        bundle2.putBoolean("is_luggage", true);
                        ToolsProcessIPCService.a(bundle2, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                            public final /* synthetic */ void ao(Object obj) {
                                AppMethodBeat.i(111464);
                                aw.mYH.remove(str);
                                AppMethodBeat.o(111464);
                            }
                        });
                        l.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111465);
                                if (aw.mYH.contains(str)) {
                                    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
                                    aw.mYH.remove(str);
                                    h.pYm.k(939, 3, 1);
                                }
                                AppMethodBeat.o(111465);
                            }
                        }, 10000);
                    }
                    AppMethodBeat.o(111477);
                    break;
            }
            AppMethodBeat.o(111477);
        }
        return false;
    }

    private synchronized void a(final ky kyVar, Bundle bundle) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(111478);
            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
            al.af(this.mYJ);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111466);
                    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", Integer.valueOf(1000), aw.cOG);
                    aw.cOG = "";
                    AppMethodBeat.o(111466);
                }
            }, 1000);
            if (kyVar == null) {
                AppMethodBeat.o(111478);
            } else {
                if (!bo.isNullOrNil(kyVar.cGQ.group)) {
                    if (mYG.contains(kyVar.cGQ.group)) {
                        mYG.remove(kyVar.cGQ.group);
                        AppMethodBeat.o(111478);
                    } else {
                        mYG.add(kyVar.cGQ.group);
                    }
                }
                final Context context = kyVar.cGQ.context != null ? kyVar.cGQ.context : ah.getContext();
                if (kyVar.cGQ.intent == null) {
                    kyVar.cGQ.intent = new Intent();
                }
                String stringExtra = kyVar.cGQ.intent.getStringExtra("rawUrl");
                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
                kyVar.cGQ.intent.putExtra("start_activity_time", System.currentTimeMillis());
                switch (kyVar.cGQ.type) {
                    case 0:
                        com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.game.GameWebViewUI", kyVar.cGQ.intent);
                        break;
                    case 1:
                        com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.TransparentWebViewUI", kyVar.cGQ.intent);
                        break;
                    case 2:
                        if (bundle != null) {
                            z = bundle.getBoolean("has_preload_webcore", false);
                        }
                        l.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111467);
                                com.tencent.mm.bp.d.b(context, "game", ".luggage.LuggageGameWebViewUI", kyVar.cGQ.intent);
                                AppMethodBeat.o(111467);
                            }
                        }, z ? 100 : 0);
                        break;
                }
                ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", Long.valueOf(System.currentTimeMillis() - mYE));
                try {
                    kyVar.cGQ.context = null;
                } catch (Exception e) {
                }
                com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", stringExtra, d.aid(stringExtra), null, -1, r6, null);
                AppMethodBeat.o(111478);
            }
        }
    }

    private static synchronized void a(final Bundle bundle, boolean z, final com.tencent.mm.ipcinvoker.c cVar) {
        synchronized (aw.class) {
            AppMethodBeat.i(111479);
            ab.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", Boolean.valueOf(z));
            boolean z2 = bundle.getBoolean("is_luggage", false);
            final String string = bundle.getString("call_raw_url");
            String string2 = bundle.getString("float_layer_url");
            final GameWebPerformanceInfo kU = GameWebPerformanceInfo.kU(string);
            if (z2) {
                final k NO = com.tencent.mm.plugin.game.luggage.d.NO(string);
                if (NO != null) {
                    if (z) {
                        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
                    } else {
                        l.q(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111468);
                                ((com.tencent.mm.plugin.game.luggage.d.d) NO.xr()).onResume();
                                ((com.tencent.mm.plugin.game.luggage.d.d) NO.xr()).setBlockNetworkImage(false);
                                AppMethodBeat.o(111468);
                            }
                        });
                        com.tencent.mm.plugin.game.luggage.c.a(NO, string, true);
                    }
                    bundle.putBoolean("has_preload_webcore", true);
                    a(cVar, bundle);
                    AppMethodBeat.o(111479);
                } else if (!z) {
                    NV(string2);
                    NV(string);
                    a(cVar, bundle);
                    AppMethodBeat.o(111479);
                } else if (kU.eBU != 0) {
                    cVar.ao(bundle);
                    AppMethodBeat.o(111479);
                } else if (NV(string)) {
                    NV(string2);
                    kU.eBM = 1;
                    kU.eBX = System.currentTimeMillis();
                    h.pYm.k(939, 0, 1);
                    com.tencent.mm.plugin.game.luggage.d.a(e.class, string, new com.tencent.mm.plugin.game.luggage.d.a() {
                        public final void wM() {
                            AppMethodBeat.i(111470);
                            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", Long.valueOf(System.currentTimeMillis()));
                            l.q(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(111469);
                                    k NO = com.tencent.mm.plugin.game.luggage.d.NO(string);
                                    if (NO != null) {
                                        ((com.tencent.mm.plugin.game.luggage.d.d) NO.xr()).setBlockNetworkImage(true);
                                        ((com.tencent.mm.plugin.game.luggage.d.d) NO.xr()).onPause();
                                    }
                                    kU.eBY = System.currentTimeMillis();
                                    aw.b(cVar, bundle);
                                    AppMethodBeat.o(111469);
                                }
                            });
                            AppMethodBeat.o(111470);
                        }
                    });
                    AppMethodBeat.o(111479);
                } else {
                    ab.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
                    GameWebPerformanceInfo.kW(string);
                    a(cVar, bundle);
                    AppMethodBeat.o(111479);
                }
            } else {
                NV(string2);
                NV(string);
                a(cVar, bundle);
                AppMethodBeat.o(111479);
            }
        }
    }

    private static boolean NV(String str) {
        AppMethodBeat.i(111480);
        if (bo.isNullOrNil(str) || !d.aig(str)) {
            AppMethodBeat.o(111480);
            return false;
        }
        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", str);
        GameWebPerformanceInfo kU = GameWebPerformanceInfo.kU(str);
        kU.eBV = System.currentTimeMillis();
        f ahx = com.tencent.mm.plugin.wepkg.b.ahx(str);
        kU.eBW = System.currentTimeMillis();
        if (ahx != null) {
            AppMethodBeat.o(111480);
            return true;
        }
        AppMethodBeat.o(111480);
        return false;
    }

    private static void a(com.tencent.mm.ipcinvoker.c cVar, Bundle bundle) {
        AppMethodBeat.i(111481);
        if (cVar != null) {
            cVar.ao(bundle);
        }
        AppMethodBeat.o(111481);
    }
}
