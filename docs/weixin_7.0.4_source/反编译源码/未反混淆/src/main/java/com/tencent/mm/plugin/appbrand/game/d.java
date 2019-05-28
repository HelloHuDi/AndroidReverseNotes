package com.tencent.mm.plugin.appbrand.game;

import android.webkit.JavascriptInterface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h.g;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.s;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.appbrand.s.n.a;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.s.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;

public final class d extends e {
    private boolean hqu = false;
    boolean hqv = false;

    d(q qVar, com.tencent.mm.plugin.appbrand.h.q qVar2) {
        super(qVar, qVar2);
    }

    @JavascriptInterface
    public final int allocNativeGlobal() {
        AppMethodBeat.i(130048);
        this.hqu = true;
        ab.i("MicroMsg.WAGameJsContextInterface", "alloc injectNativeGlobal = [%b], ret = [%d]", Boolean.valueOf(this.hqu), Integer.valueOf(super.alloc()));
        this.hqu = false;
        AppMethodBeat.o(130048);
        return super.alloc();
    }

    public final g asI() {
        AppMethodBeat.i(130049);
        final g asI = super.asI();
        if (asI != null) {
            boolean z;
            asI.setJsExceptionHandler(new h() {
                public final void C(String str, String str2) {
                    AppMethodBeat.i(130039);
                    ab.e("MicroMsg.WAGameJsContextInterface", "[WAGameJsException] hy: on exception! message: %s, stacktrace %s", str, str2);
                    m.a(asI, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)}));
                    AppMethodBeat.o(130039);
                }
            });
            if (this.hqu) {
                try {
                    s sVar = (s) asI.af(s.class);
                    ((b) this.gMN).getMBRuntime().bindTo(sVar.getIsolatePtr(), sVar.aGW());
                    z = true;
                } catch (NullPointerException e) {
                    ab.e("MicroMsg.WAGameJsContextInterface", "injectNativeGlobal failed [%s]", e);
                    z = false;
                }
            } else {
                z = true;
            }
            ab.i("MicroMsg.WAGameJsContextInterface", "alloc injectNativeGlobal = [%b], ret = [%b]", Boolean.valueOf(this.hqu), Boolean.valueOf(z));
        }
        AppMethodBeat.o(130049);
        return asI;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(130050);
        if (this.hqu) {
            String Eb = com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/NativeGlobal-WAGame.js");
            if (this.hqv) {
                Eb = Eb + com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/commandbuffer.js");
            }
            n.a((i) gVar, Eb, new a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(130040);
                    ab.i("MicroMsg.WAGameJsContextInterface", "onInjectSdkBefore suc: %s", str);
                    AppMethodBeat.o(130040);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(130041);
                    ab.i("MicroMsg.WAGameJsContextInterface", "onInjectSdkBefore failed: %s", str);
                    AppMethodBeat.o(130041);
                }
            });
        }
        AppMethodBeat.o(130050);
    }

    public final void asH() {
        AppMethodBeat.i(130051);
        super.asH();
        ab.i("MicroMsg.WAGameJsContextInterface", "hy: injected WAGameJSContextInterface");
        AppMethodBeat.o(130051);
    }

    public final void a(g gVar, String str, String str2, a aVar) {
        final String str3;
        final String Ao;
        final long currentTimeMillis;
        AppMethodBeat.i(130052);
        ab.i("MicroMsg.WAGameJsContextInterface", "hy: inject appscript from js context interface: %s %d", str, Integer.valueOf(gVar.aGT()));
        PartialFile[] partialFileArr = this.gMN.getRuntime().ye().hhd.gSR;
        if (str.equals("game.js") && partialFileArr != null && partialFileArr.length > 0) {
            ab.i("MicroMsg.WAGameJsContextInterface", "inject codeLib size:%s", Integer.valueOf(partialFileArr.length));
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
                if (!(bo.isNullOrNil(str3) || bo.isNullOrNil(str6))) {
                    ab.i("MicroMsg.WAGameJsContextInterface", "provider:%s,version:%s", str3, Integer.valueOf(i3));
                    Ao = Ao(str6);
                    if (c.isNullOrNil(Ao)) {
                        ab.e("MicroMsg.WAGameJsContextInterface", "game engine null!");
                    } else {
                        ab.i("MicroMsg.WAGameJsContextInterface", "game engine:%s", Ao.substring(0, 20));
                        currentTimeMillis = System.currentTimeMillis();
                        o.a(this.gMN.getRuntime(), (i) gVar, str, str4, str5, Ao, o.a.USR, (a) new a() {
                            public final void onSuccess(String str) {
                                int i = -1;
                                AppMethodBeat.i(130042);
                                if (d.this.gMN.atU() || d.this.gMN.isRunning()) {
                                    com.tencent.mm.plugin.appbrand.i runtime = d.this.gMN.getRuntime();
                                    String str2 = "MicroMsg.WAGameJsContextInterface";
                                    String str3 = "[QualitySystem] %s runtime.hashCode = [%d]";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str3;
                                    objArr[1] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                                    ab.i(str2, str3, objArr);
                                    str2 = d.this.gMN.getAppId();
                                    str3 = str3;
                                    String str4 = Ao;
                                    long j = currentTimeMillis;
                                    if (runtime != null) {
                                        i = runtime.hashCode();
                                    }
                                    com.tencent.mm.plugin.appbrand.report.quality.a.a(str2, str3, str4, j, i);
                                    d.a(com.tencent.mm.plugin.appbrand.game.d.d.a.INFO, "codeLib " + str3 + " inject success!");
                                }
                                d.dM(true);
                                AppMethodBeat.o(130042);
                            }

                            public final void lo(String str) {
                                AppMethodBeat.i(130043);
                                d.a(com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, "codeLib " + str3 + " inject fail!");
                                d.dM(false);
                                AppMethodBeat.o(130043);
                            }
                        });
                    }
                }
                i = i2 + 1;
            }
        }
        currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.appbrand.game.preload.d aBz = com.tencent.mm.plugin.appbrand.game.preload.d.aBz();
        if (!c.isNullOrNil(str)) {
            if (str.equals("game.js")) {
                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(2000, (int) (bo.anU() - aBz.htn.atI().startTime));
                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(3001, aBz.htv.intValue());
                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(3003, aBz.htu.intValue());
                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(WearableStatusCodes.DUPLICATE_LISTENER, aBz.htw.intValue());
            }
        }
        str3 = str;
        Ao = str2;
        final a aVar2 = aVar;
        o.a(this.gMN.getRuntime(), (i) gVar, str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.cvZ, str2, o.a.USR, (a) new a() {
            public final void onSuccess(String str) {
                int i = -1;
                AppMethodBeat.i(130044);
                if (d.this.gMN.atU() || d.this.gMN.isRunning()) {
                    int hashCode;
                    com.tencent.mm.plugin.appbrand.i runtime = d.this.gMN.getRuntime();
                    String str2 = "MicroMsg.WAGameJsContextInterface";
                    String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                    Object[] objArr = new Object[1];
                    if (runtime != null) {
                        hashCode = runtime.hashCode();
                    } else {
                        hashCode = -1;
                    }
                    objArr[0] = Integer.valueOf(hashCode);
                    ab.i(str2, str3, objArr);
                    str2 = d.this.gMN.getAppId();
                    str3 = str3;
                    String str4 = Ao;
                    long j = currentTimeMillis;
                    if (runtime != null) {
                        i = runtime.hashCode();
                    }
                    com.tencent.mm.plugin.appbrand.report.quality.a.a(str2, str3, str4, j, i);
                }
                if (aVar2 != null) {
                    aVar2.onSuccess(str);
                }
                AppMethodBeat.o(130044);
            }

            public final void lo(String str) {
                AppMethodBeat.i(130045);
                if (aVar2 != null) {
                    aVar2.lo(str);
                }
                AppMethodBeat.o(130045);
            }
        });
        AppMethodBeat.o(130052);
    }

    private static String Ao(String str) {
        AppMethodBeat.i(138121);
        String str2 = null;
        try {
            str2 = com.tencent.mm.vfs.e.cy(str);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.WAGameJsContextInterface", e, "getGameEngineScript exception:%s", e.toString());
        }
        AppMethodBeat.o(138121);
        return str2;
    }

    public final void a(g gVar, String str, String str2) {
        AppMethodBeat.i(130053);
        ab.i("MicroMsg.WAGameJsContextInterface", "hy: injectSdkScript %s [%d]", str, Integer.valueOf(gVar.aGT()));
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = this.gMN.atU();
        final String str3 = str;
        final String str4 = str2;
        o.a(this.gMN, (i) gVar, str, str, "v" + WxaCommLibRuntimeReader.avQ().gVu, str2, o.a.LIB, (a) new a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(130046);
                ab.i("MicroMsg.WAGameJsContextInterface", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", d.this.gMN.getAppId(), str3);
                if (d.this.gMN.atU() || d.this.gMN.isRunning()) {
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    b.a(atU, d.this.gMN.getAppId(), currentTimeMillis, str3, (long) str4.length());
                }
                d.this.ds(true);
                AppMethodBeat.o(130046);
            }

            public final void lo(String str) {
                AppMethodBeat.i(130047);
                ab.e("MicroMsg.WAGameJsContextInterface", "create with appID(%s), scriptPath(%s), sdkScript inject failed", d.this.gMN.getAppId(), str3);
                d.this.ds(false);
                AppMethodBeat.o(130047);
            }
        });
        u.a(this.gMN.getRuntime(), gVar);
        AppMethodBeat.o(130053);
    }

    public final int asL() {
        AppMethodBeat.i(139125);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.o(139125);
        return i;
    }

    public final String asJ() {
        return "WAGameSubContext.js";
    }

    public final String asK() {
        AppMethodBeat.i(130055);
        String xu = WxaCommLibRuntimeReader.xu("WAGameSubContext.js");
        AppMethodBeat.o(130055);
        return xu;
    }

    public final void asM() {
    }

    public final void ds(boolean z) {
        int i;
        int i2 = -1;
        AppMethodBeat.i(130056);
        com.tencent.mm.plugin.report.service.h.pYm.a(778, 17, 1, false);
        if (z) {
            com.tencent.mm.plugin.report.service.h.pYm.a(778, 19, 1, false);
            AppMethodBeat.o(130056);
            return;
        }
        int i3;
        try {
            i3 = this.gMN.getRuntime().ye().hhd.gVu;
            try {
                i2 = this.gMN.getRuntime().ye().hhd.gVt;
                i = i3;
            } catch (NullPointerException e) {
                i = i3;
                com.tencent.mm.plugin.report.service.h.pYm.a(778, 18, 1, false);
                com.tencent.mm.plugin.appbrand.report.c.br(this.gMN.getAppId(), 24);
                com.tencent.mm.plugin.appbrand.report.c.a(this.gMN.getAppId(), i, i2, 778, 18);
                AppMethodBeat.o(130056);
            }
        } catch (NullPointerException e2) {
            i3 = i2;
            i = i3;
            com.tencent.mm.plugin.report.service.h.pYm.a(778, 18, 1, false);
            com.tencent.mm.plugin.appbrand.report.c.br(this.gMN.getAppId(), 24);
            com.tencent.mm.plugin.appbrand.report.c.a(this.gMN.getAppId(), i, i2, 778, 18);
            AppMethodBeat.o(130056);
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(778, 18, 1, false);
        com.tencent.mm.plugin.appbrand.report.c.br(this.gMN.getAppId(), 24);
        com.tencent.mm.plugin.appbrand.report.c.a(this.gMN.getAppId(), i, i2, 778, 18);
        AppMethodBeat.o(130056);
    }

    public final void asN() {
    }

    public final void wL(String str) {
        AppMethodBeat.i(130057);
        ab.i("MicroMsg.WAGameJsContextInterface", "hy: onAppScriptInjectBegin path:%s", str);
        if (!bo.isNullOrNil(str) && str.equals("game.js")) {
            com.tencent.mm.plugin.appbrand.game.f.a.aBG().huc = bo.yz();
        }
        AppMethodBeat.o(130057);
    }

    public final void dt(boolean z) {
        AppMethodBeat.i(130058);
        com.tencent.mm.plugin.report.service.h.pYm.a(778, 21, 1, false);
        if (z) {
            com.tencent.mm.plugin.report.service.h.pYm.a(778, 23, 1, false);
            AppMethodBeat.o(130058);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(778, 22, 1, false);
        com.tencent.mm.plugin.appbrand.report.c.br(this.gMN.getAppId(), 24);
        com.tencent.mm.plugin.appbrand.report.c.a(this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.gVu, this.gMN.getRuntime().ye().hhd.gVt, 778, 22);
        AppMethodBeat.o(130058);
    }

    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.game.d.d.a aVar, String str) {
        AppMethodBeat.i(138123);
        com.tencent.mm.plugin.appbrand.game.d.d.aAI().b(aVar, str);
        AppMethodBeat.o(138123);
    }

    static /* synthetic */ void dM(boolean z) {
        AppMethodBeat.i(138695);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 40, 1, false);
        if (z) {
            com.tencent.mm.plugin.report.service.h.pYm.a(370, 49, 1, false);
            AppMethodBeat.o(138695);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 50, 1, false);
        AppMethodBeat.o(138695);
    }
}
