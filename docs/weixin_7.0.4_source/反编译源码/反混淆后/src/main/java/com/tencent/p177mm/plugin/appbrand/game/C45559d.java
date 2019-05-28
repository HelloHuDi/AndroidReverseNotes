package com.tencent.p177mm.plugin.appbrand.game;

import android.webkit.JavascriptInterface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33176e;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d.C10236a;
import com.tencent.p177mm.plugin.appbrand.game.preload.C38233e;
import com.tencent.p177mm.plugin.appbrand.game.preload.C45564d;
import com.tencent.p177mm.plugin.appbrand.p297h.C10257s;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C38235g;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o.C19718a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42685u;
import com.tencent.p177mm.plugin.appbrand.p329s.C45686m;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.game.d */
public final class C45559d extends C33176e {
    private boolean hqu = false;
    boolean hqv = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d$1 */
    class C21591 implements C42683a {
        C21591() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(130037);
            C4990ab.m7416i("MicroMsg.WAGameJsContextInterface", "Interface dl: success");
            AppMethodBeat.m2505o(130037);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(130038);
            C4990ab.m7416i("MicroMsg.WAGameJsContextInterface", "Interface dl: fail");
            AppMethodBeat.m2505o(130038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d$3 */
    class C455603 implements C42683a {
        C455603() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(130040);
            C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "onInjectSdkBefore suc: %s", str);
            AppMethodBeat.m2505o(130040);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(130041);
            C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "onInjectSdkBefore failed: %s", str);
            AppMethodBeat.m2505o(130041);
        }
    }

    C45559d(C38492q c38492q, C38237q c38237q) {
        super(c38492q, c38237q);
    }

    @JavascriptInterface
    public final int allocNativeGlobal() {
        AppMethodBeat.m2504i(130048);
        this.hqu = true;
        C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "alloc injectNativeGlobal = [%b], ret = [%d]", Boolean.valueOf(this.hqu), Integer.valueOf(super.alloc()));
        this.hqu = false;
        AppMethodBeat.m2505o(130048);
        return super.alloc();
    }

    public final C38235g asI() {
        AppMethodBeat.m2504i(130049);
        final C38235g asI = super.asI();
        if (asI != null) {
            boolean z;
            asI.setJsExceptionHandler(new C33211h() {
                /* renamed from: C */
                public final void mo5989C(String str, String str2) {
                    AppMethodBeat.m2504i(130039);
                    C4990ab.m7413e("MicroMsg.WAGameJsContextInterface", "[WAGameJsException] hy: on exception! message: %s, stacktrace %s", str, str2);
                    C45686m.m84388a(asI, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)}));
                    AppMethodBeat.m2505o(130039);
                }
            });
            if (this.hqu) {
                try {
                    C10257s c10257s = (C10257s) asI.mo14970af(C10257s.class);
                    ((C42439b) this.gMN).getMBRuntime().bindTo(c10257s.getIsolatePtr(), c10257s.aGW());
                    z = true;
                } catch (NullPointerException e) {
                    C4990ab.m7413e("MicroMsg.WAGameJsContextInterface", "injectNativeGlobal failed [%s]", e);
                    z = false;
                }
            } else {
                z = true;
            }
            C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "alloc injectNativeGlobal = [%b], ret = [%b]", Boolean.valueOf(this.hqu), Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(130049);
        return asI;
    }

    /* renamed from: a */
    public final void mo53707a(C38235g c38235g) {
        AppMethodBeat.m2504i(130050);
        if (this.hqu) {
            String Eb = C45672d.m84370Eb("wxa_library/NativeGlobal-WAGame.js");
            if (this.hqv) {
                Eb = Eb + C45672d.m84370Eb("wxa_library/commandbuffer.js");
            }
            C42682n.m75589a((C6747i) c38235g, Eb, new C455603());
        }
        AppMethodBeat.m2505o(130050);
    }

    public final void asH() {
        AppMethodBeat.m2504i(130051);
        super.asH();
        C4990ab.m7416i("MicroMsg.WAGameJsContextInterface", "hy: injected WAGameJSContextInterface");
        AppMethodBeat.m2505o(130051);
    }

    /* renamed from: a */
    public final void mo53709a(C38235g c38235g, String str, String str2, C42683a c42683a) {
        final String str3;
        final String Ao;
        final long currentTimeMillis;
        AppMethodBeat.m2504i(130052);
        C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "hy: inject appscript from js context interface: %s %d", str, Integer.valueOf(c38235g.aGT()));
        PartialFile[] partialFileArr = this.gMN.getRuntime().mo15034ye().hhd.gSR;
        if (str.equals("game.js") && partialFileArr != null && partialFileArr.length > 0) {
            C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "inject codeLib size:%s", Integer.valueOf(partialFileArr.length));
            int length = partialFileArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                PartialFile partialFile = partialFileArr[i2];
                int i3 = partialFile.version;
                str3 = partialFile.bIy;
                String str4 = str3 + "_" + i3;
                String str5 = partialFile.cvZ;
                String str6 = partialFile.filePath;
                if (!(C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str6))) {
                    C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "provider:%s,version:%s", str3, Integer.valueOf(i3));
                    Ao = C45559d.m84037Ao(str6);
                    if (C37414c.isNullOrNil(Ao)) {
                        C4990ab.m7412e("MicroMsg.WAGameJsContextInterface", "game engine null!");
                    } else {
                        C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "game engine:%s", Ao.substring(0, 20));
                        currentTimeMillis = System.currentTimeMillis();
                        C19716o.m30527a(this.gMN.getRuntime(), (C6747i) c38235g, str, str4, str5, Ao, C19718a.USR, (C42683a) new C42683a() {
                            public final void onSuccess(String str) {
                                int i = -1;
                                AppMethodBeat.m2504i(130042);
                                if (C45559d.this.gMN.atU() || C45559d.this.gMN.isRunning()) {
                                    C6750i runtime = C45559d.this.gMN.getRuntime();
                                    String str2 = "MicroMsg.WAGameJsContextInterface";
                                    String str3 = "[QualitySystem] %s runtime.hashCode = [%d]";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str3;
                                    objArr[1] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                                    C4990ab.m7417i(str2, str3, objArr);
                                    str2 = C45559d.this.gMN.getAppId();
                                    str3 = str3;
                                    String str4 = Ao;
                                    long j = currentTimeMillis;
                                    if (runtime != null) {
                                        i = runtime.hashCode();
                                    }
                                    C27285a.m43322a(str2, str3, str4, j, i);
                                    C45559d.m84038a(C10236a.INFO, "codeLib " + str3 + " inject success!");
                                }
                                C45559d.m84039dM(true);
                                AppMethodBeat.m2505o(130042);
                            }

                            /* renamed from: lo */
                            public final void mo5987lo(String str) {
                                AppMethodBeat.m2504i(130043);
                                C45559d.m84038a(C10236a.ERROR, "codeLib " + str3 + " inject fail!");
                                C45559d.m84039dM(false);
                                AppMethodBeat.m2505o(130043);
                            }
                        });
                    }
                }
                i = i2 + 1;
            }
        }
        currentTimeMillis = System.currentTimeMillis();
        C45564d aBz = C45564d.aBz();
        if (!C37414c.isNullOrNil(str)) {
            if (str.equals("game.js")) {
                C38233e.aBD().mo60956cY(2000, (int) (C5046bo.anU() - aBz.htn.atI().startTime));
                C38233e.aBD().mo60956cY(3001, aBz.htv.intValue());
                C38233e.aBD().mo60956cY(3003, aBz.htu.intValue());
                C38233e.aBD().mo60956cY(WearableStatusCodes.DUPLICATE_LISTENER, aBz.htw.intValue());
            }
        }
        str3 = str;
        Ao = str2;
        final C42683a c42683a2 = c42683a;
        C19716o.m30527a(this.gMN.getRuntime(), (C6747i) c38235g, str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.cvZ, str2, C19718a.USR, (C42683a) new C42683a() {
            public final void onSuccess(String str) {
                int i = -1;
                AppMethodBeat.m2504i(130044);
                if (C45559d.this.gMN.atU() || C45559d.this.gMN.isRunning()) {
                    int hashCode;
                    C6750i runtime = C45559d.this.gMN.getRuntime();
                    String str2 = "MicroMsg.WAGameJsContextInterface";
                    String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                    Object[] objArr = new Object[1];
                    if (runtime != null) {
                        hashCode = runtime.hashCode();
                    } else {
                        hashCode = -1;
                    }
                    objArr[0] = Integer.valueOf(hashCode);
                    C4990ab.m7417i(str2, str3, objArr);
                    str2 = C45559d.this.gMN.getAppId();
                    str3 = str3;
                    String str4 = Ao;
                    long j = currentTimeMillis;
                    if (runtime != null) {
                        i = runtime.hashCode();
                    }
                    C27285a.m43322a(str2, str3, str4, j, i);
                }
                if (c42683a2 != null) {
                    c42683a2.onSuccess(str);
                }
                AppMethodBeat.m2505o(130044);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                AppMethodBeat.m2504i(130045);
                if (c42683a2 != null) {
                    c42683a2.mo5987lo(str);
                }
                AppMethodBeat.m2505o(130045);
            }
        });
        AppMethodBeat.m2505o(130052);
    }

    /* renamed from: Ao */
    private static String m84037Ao(String str) {
        AppMethodBeat.m2504i(138121);
        String str2 = null;
        try {
            str2 = C5730e.m8631cy(str);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.WAGameJsContextInterface", e, "getGameEngineScript exception:%s", e.toString());
        }
        AppMethodBeat.m2505o(138121);
        return str2;
    }

    /* renamed from: a */
    public final void mo53708a(C38235g c38235g, String str, String str2) {
        AppMethodBeat.m2504i(130053);
        C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "hy: injectSdkScript %s [%d]", str, Integer.valueOf(c38235g.aGT()));
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = this.gMN.atU();
        final String str3 = str;
        final String str4 = str2;
        C19716o.m30529a(this.gMN, (C6747i) c38235g, str, str, "v" + WxaCommLibRuntimeReader.avQ().gVu, str2, C19718a.LIB, (C42683a) new C42683a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(130046);
                C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", C45559d.this.gMN.getAppId(), str3);
                if (C45559d.this.gMN.atU() || C45559d.this.gMN.isRunning()) {
                    C27285a.aLz();
                    C38501b.m65164a(atU, C45559d.this.gMN.getAppId(), currentTimeMillis, str3, (long) str4.length());
                }
                C45559d.this.mo53720ds(true);
                AppMethodBeat.m2505o(130046);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                AppMethodBeat.m2504i(130047);
                C4990ab.m7413e("MicroMsg.WAGameJsContextInterface", "create with appID(%s), scriptPath(%s), sdkScript inject failed", C45559d.this.gMN.getAppId(), str3);
                C45559d.this.mo53720ds(false);
                AppMethodBeat.m2505o(130047);
            }
        });
        C42685u.m75595a(this.gMN.getRuntime(), c38235g);
        AppMethodBeat.m2505o(130053);
    }

    public final int asL() {
        AppMethodBeat.m2504i(139125);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.m2505o(139125);
        return i;
    }

    public final String asJ() {
        return "WAGameSubContext.js";
    }

    public final String asK() {
        AppMethodBeat.m2504i(130055);
        String xu = WxaCommLibRuntimeReader.m42569xu("WAGameSubContext.js");
        AppMethodBeat.m2505o(130055);
        return xu;
    }

    public final void asM() {
    }

    /* renamed from: ds */
    public final void mo53720ds(boolean z) {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(130056);
        C7060h.pYm.mo8378a(778, 17, 1, false);
        if (z) {
            C7060h.pYm.mo8378a(778, 19, 1, false);
            AppMethodBeat.m2505o(130056);
            return;
        }
        int i3;
        try {
            i3 = this.gMN.getRuntime().mo15034ye().hhd.gVu;
            try {
                i2 = this.gMN.getRuntime().mo15034ye().hhd.gVt;
                i = i3;
            } catch (NullPointerException e) {
                i = i3;
                C7060h.pYm.mo8378a(778, 18, 1, false);
                C19690c.m30502br(this.gMN.getAppId(), 24);
                C19690c.m30497a(this.gMN.getAppId(), i, i2, 778, 18);
                AppMethodBeat.m2505o(130056);
            }
        } catch (NullPointerException e2) {
            i3 = i2;
            i = i3;
            C7060h.pYm.mo8378a(778, 18, 1, false);
            C19690c.m30502br(this.gMN.getAppId(), 24);
            C19690c.m30497a(this.gMN.getAppId(), i, i2, 778, 18);
            AppMethodBeat.m2505o(130056);
        }
        C7060h.pYm.mo8378a(778, 18, 1, false);
        C19690c.m30502br(this.gMN.getAppId(), 24);
        C19690c.m30497a(this.gMN.getAppId(), i, i2, 778, 18);
        AppMethodBeat.m2505o(130056);
    }

    public final void asN() {
    }

    /* renamed from: wL */
    public final void mo53723wL(String str) {
        AppMethodBeat.m2504i(130057);
        C4990ab.m7417i("MicroMsg.WAGameJsContextInterface", "hy: onAppScriptInjectBegin path:%s", str);
        if (!C5046bo.isNullOrNil(str) && str.equals("game.js")) {
            C38226a.aBG().huc = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(130057);
    }

    /* renamed from: dt */
    public final void mo53721dt(boolean z) {
        AppMethodBeat.m2504i(130058);
        C7060h.pYm.mo8378a(778, 21, 1, false);
        if (z) {
            C7060h.pYm.mo8378a(778, 23, 1, false);
            AppMethodBeat.m2505o(130058);
            return;
        }
        C7060h.pYm.mo8378a(778, 22, 1, false);
        C19690c.m30502br(this.gMN.getAppId(), 24);
        C19690c.m30497a(this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.gVu, this.gMN.getRuntime().mo15034ye().hhd.gVt, 778, 22);
        AppMethodBeat.m2505o(130058);
    }

    /* renamed from: a */
    static /* synthetic */ void m84038a(C10236a c10236a, String str) {
        AppMethodBeat.m2504i(138123);
        C45558d.aAI().mo73367b(c10236a, str);
        AppMethodBeat.m2505o(138123);
    }

    /* renamed from: dM */
    static /* synthetic */ void m84039dM(boolean z) {
        AppMethodBeat.m2504i(138695);
        C7060h.pYm.mo8378a(370, 40, 1, false);
        if (z) {
            C7060h.pYm.mo8378a(370, 49, 1, false);
            AppMethodBeat.m2505o(138695);
            return;
        }
        C7060h.pYm.mo8378a(370, 50, 1, false);
        AppMethodBeat.m2505o(138695);
    }
}
