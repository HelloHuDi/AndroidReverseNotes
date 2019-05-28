package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C26183ky;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.luggage.C12134c;
import com.tencent.p177mm.plugin.game.luggage.C12146d;
import com.tencent.p177mm.plugin.game.luggage.C12146d.C12149a;
import com.tencent.p177mm.plugin.game.luggage.C28214e;
import com.tencent.p177mm.plugin.game.luggage.p432d.C3228d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.C40393b;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C14805a;
import com.tencent.p177mm.plugin.wepkg.model.C40398f;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.plugin.wepkg.utils.C35766b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.game.model.aw */
public class C46010aw extends C4884c<C26183ky> {
    private static volatile String cOG;
    private static volatile long mYE;
    private static volatile long mYF;
    private static Set<String> mYG = new HashSet();
    private static Set<String> mYH = new HashSet();
    private long mYI;
    private C34299b mYJ;

    /* renamed from: com.tencent.mm.plugin.game.model.aw$a */
    static class C12163a implements C37866a<Bundle, Bundle> {
        private C12163a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(111474);
            final Bundle bundle = (Bundle) obj;
            if (bundle == null) {
                if (c18507c != null) {
                    c18507c.mo5960ao(bundle);
                }
                AppMethodBeat.m2505o(111474);
                return;
            }
            C35766b.uXV = bundle.getBoolean("is_wepkg_disable");
            String string = bundle.getString("call_raw_url");
            final boolean z = bundle.getBoolean("preload_webcore", false);
            if (z) {
                C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore");
            }
            C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload entrance url:%s, isToolsProcess:%b, isToolsMpProcess:%b", string, Boolean.valueOf(C4996ah.doF()), Boolean.valueOf(C4996ah.doG()));
            if (WepkgMainProcessService.isLive()) {
                C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload wepkg");
                C30022d.aNS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(111471);
                        C46010aw.m85484b(bundle, z, c18507c);
                        AppMethodBeat.m2505o(111471);
                    }
                });
                AppMethodBeat.m2505o(111474);
                return;
            }
            C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "prestart WepkgMainProcessService and preload wepkg");
            C30022d.m47516b(string, new C14805a() {

                /* renamed from: com.tencent.mm.plugin.game.model.aw$a$2$1 */
                class C121661 implements Runnable {
                    C121661() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(111472);
                        C46010aw.m85484b(bundle, z, c18507c);
                        AppMethodBeat.m2505o(111472);
                    }
                }

                /* renamed from: a */
                public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.m2504i(111473);
                    if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.csN) {
                        C30022d.aNS().mo10302aa(new C121661());
                    }
                    AppMethodBeat.m2505o(111473);
                }
            });
            AppMethodBeat.m2505o(111474);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.aw$4 */
    class C282234 implements Runnable {
        C282234() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111466);
            C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", Integer.valueOf(1000), C46010aw.cOG);
            C46010aw.cOG = "";
            AppMethodBeat.m2505o(111466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.aw$b */
    class C34299b implements Runnable {
        private final C26183ky mYU;

        public C34299b(C26183ky c26183ky) {
            this.mYU = c26183ky;
        }

        public final void run() {
            AppMethodBeat.m2504i(111475);
            C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
            C46010aw.m85482a(C46010aw.this, this.mYU, null);
            C7060h.pYm.mo15419k(939, 2, 1);
            AppMethodBeat.m2505o(111475);
        }
    }

    public C46010aw() {
        AppMethodBeat.m2504i(111476);
        this.xxI = C26183ky.class.getName().hashCode();
        AppMethodBeat.m2505o(111476);
    }

    /* renamed from: b */
    static /* synthetic */ void m85484b(Bundle bundle, boolean z, C18507c c18507c) {
        AppMethodBeat.m2504i(111484);
        C46010aw.m85479a(bundle, z, c18507c);
        AppMethodBeat.m2505o(111484);
    }

    /* renamed from: b */
    static /* synthetic */ void m85485b(C18507c c18507c, Bundle bundle) {
        AppMethodBeat.m2504i(111485);
        C46010aw.m85481a(c18507c, bundle);
        AppMethodBeat.m2505o(111485);
    }

    static {
        AppMethodBeat.m2504i(111486);
        AppMethodBeat.m2505o(111486);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m85483a(final C26183ky c26183ky) {
        AppMethodBeat.m2504i(111477);
        C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", Integer.valueOf(c26183ky.cGQ.type));
        if (c26183ky.cGQ.intent == null) {
            AppMethodBeat.m2505o(111477);
        } else {
            if (c26183ky.cGQ.type == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.mYI;
                C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", Long.valueOf(currentTimeMillis), Long.valueOf(this.mYI));
                if (System.currentTimeMillis() - this.mYI < 500) {
                    C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
                    AppMethodBeat.m2505o(111477);
                }
            }
            this.mYI = System.currentTimeMillis();
            String str;
            switch (c26183ky.cGQ.type) {
                case 0:
                case 1:
                case 2:
                    String str2 = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                    String str3 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(c26183ky.cGQ.type);
                    objArr[1] = Integer.valueOf(hashCode());
                    objArr[2] = Integer.valueOf(c26183ky.hashCode());
                    objArr[3] = Long.valueOf(Thread.currentThread().getId());
                    objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                    C4990ab.m7417i(str2, str3, objArr);
                    str = "";
                    try {
                        str = c26183ky.cGQ.intent.getStringExtra("rawUrl");
                    } catch (Exception e) {
                    }
                    str2 = c26183ky.cGQ.intent.getStringExtra("game_float_layer_url");
                    synchronized (C46010aw.class) {
                        try {
                            if (C5046bo.nullAsNil(cOG).equalsIgnoreCase(str)) {
                                C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                                break;
                            }
                            cOG = str;
                            mYE = System.currentTimeMillis();
                            mYF = System.currentTimeMillis();
                            if (C4996ah.bqo()) {
                                C35766b.uXV = C45985a.bDh();
                            }
                            if (C30022d.aig(str)) {
                                C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", C30022d.aid(str));
                                c26183ky.cGQ.group = C1178g.m2591x(C5046bo.nullAsNil(str).getBytes()) + "_" + System.currentTimeMillis();
                                this.mYJ = new C34299b(c26183ky);
                                C5004al.m7442n(this.mYJ, 500);
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("is_wepkg_disable", C35766b.uXV);
                                bundle.putString("call_raw_url", str);
                                if (!C5046bo.isNullOrNil(str2)) {
                                    bundle.putString("float_layer_url", str2);
                                }
                                if (c26183ky.cGQ.type == 2) {
                                    bundle.putBoolean("is_luggage", true);
                                }
                                ToolsProcessIPCService.m63913a(bundle, C12163a.class, new C18507c<Bundle>() {
                                    /* renamed from: ao */
                                    public final /* synthetic */ void mo5960ao(Object obj) {
                                        AppMethodBeat.m2504i(111463);
                                        Bundle bundle = (Bundle) obj;
                                        C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", Long.valueOf(System.currentTimeMillis() - C46010aw.mYF));
                                        if (bundle != null) {
                                            C46010aw.m85482a(C46010aw.this, c26183ky, bundle);
                                        }
                                        AppMethodBeat.m2505o(111463);
                                    }
                                });
                            } else {
                                C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + C35766b.uXV);
                                m85480a(c26183ky, null);
                            }
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(111477);
                                break;
                            }
                        }
                    }
                case 3:
                    str = c26183ky.cGQ.intent.getStringExtra("rawUrl");
                    if (!mYH.contains(str) && C30022d.aig(str)) {
                        mYH.add(str);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("call_raw_url", str);
                        bundle2.putBoolean("preload_webcore", true);
                        bundle2.putBoolean("is_luggage", true);
                        ToolsProcessIPCService.m63913a(bundle2, C12163a.class, new C18507c<Bundle>() {
                            /* renamed from: ao */
                            public final /* synthetic */ void mo5960ao(Object obj) {
                                AppMethodBeat.m2504i(111464);
                                C46010aw.mYH.remove(str);
                                AppMethodBeat.m2505o(111464);
                            }
                        });
                        C18514l.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(111465);
                                if (C46010aw.mYH.contains(str)) {
                                    C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
                                    C46010aw.mYH.remove(str);
                                    C7060h.pYm.mo15419k(939, 3, 1);
                                }
                                AppMethodBeat.m2505o(111465);
                            }
                        }, 10000);
                    }
                    AppMethodBeat.m2505o(111477);
                    break;
            }
            AppMethodBeat.m2505o(111477);
        }
        return false;
    }

    /* renamed from: a */
    private synchronized void m85480a(final C26183ky c26183ky, Bundle bundle) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(111478);
            C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
            C5004al.m7439af(this.mYJ);
            C5004al.m7442n(new C282234(), 1000);
            if (c26183ky == null) {
                AppMethodBeat.m2505o(111478);
            } else {
                if (!C5046bo.isNullOrNil(c26183ky.cGQ.group)) {
                    if (mYG.contains(c26183ky.cGQ.group)) {
                        mYG.remove(c26183ky.cGQ.group);
                        AppMethodBeat.m2505o(111478);
                    } else {
                        mYG.add(c26183ky.cGQ.group);
                    }
                }
                final Context context = c26183ky.cGQ.context != null ? c26183ky.cGQ.context : C4996ah.getContext();
                if (c26183ky.cGQ.intent == null) {
                    c26183ky.cGQ.intent = new Intent();
                }
                String stringExtra = c26183ky.cGQ.intent.getStringExtra("rawUrl");
                C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
                c26183ky.cGQ.intent.putExtra("start_activity_time", System.currentTimeMillis());
                switch (c26183ky.cGQ.type) {
                    case 0:
                        C25985d.m41467b(context, "webview", ".ui.tools.game.GameWebViewUI", c26183ky.cGQ.intent);
                        break;
                    case 1:
                        C25985d.m41467b(context, "webview", ".ui.tools.TransparentWebViewUI", c26183ky.cGQ.intent);
                        break;
                    case 2:
                        if (bundle != null) {
                            z = bundle.getBoolean("has_preload_webcore", false);
                        }
                        C18514l.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(111467);
                                C25985d.m41467b(context, "game", ".luggage.LuggageGameWebViewUI", c26183ky.cGQ.intent);
                                AppMethodBeat.m2505o(111467);
                            }
                        }, z ? 100 : 0);
                        break;
                }
                C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", Long.valueOf(System.currentTimeMillis() - mYE));
                try {
                    c26183ky.cGQ.context = null;
                } catch (Exception e) {
                }
                C35765a.m58633b("preloadWebTime", stringExtra, C30022d.aid(stringExtra), null, -1, r6, null);
                AppMethodBeat.m2505o(111478);
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m85479a(final Bundle bundle, boolean z, final C18507c c18507c) {
        synchronized (C46010aw.class) {
            AppMethodBeat.m2504i(111479);
            C4990ab.m7411d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", Boolean.valueOf(z));
            boolean z2 = bundle.getBoolean("is_luggage", false);
            final String string = bundle.getString("call_raw_url");
            String string2 = bundle.getString("float_layer_url");
            final GameWebPerformanceInfo kU = GameWebPerformanceInfo.m63878kU(string);
            if (z2) {
                final C32186k NO = C12146d.m20085NO(string);
                if (NO != null) {
                    if (z) {
                        C4990ab.m7416i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
                    } else {
                        C18514l.m28819q(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(111468);
                                ((C3228d) NO.mo52835xr()).onResume();
                                ((C3228d) NO.mo52835xr()).setBlockNetworkImage(false);
                                AppMethodBeat.m2505o(111468);
                            }
                        });
                        C12134c.m20060a(NO, string, true);
                    }
                    bundle.putBoolean("has_preload_webcore", true);
                    C46010aw.m85481a(c18507c, bundle);
                    AppMethodBeat.m2505o(111479);
                } else if (!z) {
                    C46010aw.m85477NV(string2);
                    C46010aw.m85477NV(string);
                    C46010aw.m85481a(c18507c, bundle);
                    AppMethodBeat.m2505o(111479);
                } else if (kU.eBU != 0) {
                    c18507c.mo5960ao(bundle);
                    AppMethodBeat.m2505o(111479);
                } else if (C46010aw.m85477NV(string)) {
                    C46010aw.m85477NV(string2);
                    kU.eBM = 1;
                    kU.eBX = System.currentTimeMillis();
                    C7060h.pYm.mo15419k(939, 0, 1);
                    C12146d.m20086a(C28214e.class, string, new C12149a() {

                        /* renamed from: com.tencent.mm.plugin.game.model.aw$7$1 */
                        class C342981 implements Runnable {
                            C342981() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(111469);
                                C32186k NO = C12146d.m20085NO(string);
                                if (NO != null) {
                                    ((C3228d) NO.mo52835xr()).setBlockNetworkImage(true);
                                    ((C3228d) NO.mo52835xr()).onPause();
                                }
                                kU.eBY = System.currentTimeMillis();
                                C46010aw.m85485b(c18507c, bundle);
                                AppMethodBeat.m2505o(111469);
                            }
                        }

                        /* renamed from: wM */
                        public final void mo7076wM() {
                            AppMethodBeat.m2504i(111470);
                            C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", Long.valueOf(System.currentTimeMillis()));
                            C18514l.m28819q(new C342981());
                            AppMethodBeat.m2505o(111470);
                        }
                    });
                    AppMethodBeat.m2505o(111479);
                } else {
                    C4990ab.m7410d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
                    GameWebPerformanceInfo.m63880kW(string);
                    C46010aw.m85481a(c18507c, bundle);
                    AppMethodBeat.m2505o(111479);
                }
            } else {
                C46010aw.m85477NV(string2);
                C46010aw.m85477NV(string);
                C46010aw.m85481a(c18507c, bundle);
                AppMethodBeat.m2505o(111479);
            }
        }
    }

    /* renamed from: NV */
    private static boolean m85477NV(String str) {
        AppMethodBeat.m2504i(111480);
        if (C5046bo.isNullOrNil(str) || !C30022d.aig(str)) {
            AppMethodBeat.m2505o(111480);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", str);
        GameWebPerformanceInfo kU = GameWebPerformanceInfo.m63878kU(str);
        kU.eBV = System.currentTimeMillis();
        C40398f ahx = C40393b.ahx(str);
        kU.eBW = System.currentTimeMillis();
        if (ahx != null) {
            AppMethodBeat.m2505o(111480);
            return true;
        }
        AppMethodBeat.m2505o(111480);
        return false;
    }

    /* renamed from: a */
    private static void m85481a(C18507c c18507c, Bundle bundle) {
        AppMethodBeat.m2504i(111481);
        if (c18507c != null) {
            c18507c.mo5960ao(bundle);
        }
        AppMethodBeat.m2505o(111481);
    }
}
