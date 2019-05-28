package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.c.f;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.tinker.b.b;
import com.tinkerboots.sdk.tinker.b.c;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class d {
    private static boolean nue = false;

    public static void b(ApplicationLike applicationLike) {
        AppMethodBeat.i(90646);
        ab.i("Tinker.TinkerPatchManager", "try installing tinker");
        if (nue) {
            ab.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            AppMethodBeat.o(90646);
            return;
        }
        long j;
        long j2 = 0;
        try {
            j2 = ((long) a.Ra()) & 4294967295L;
            ab.i("Tinker.TinkerPatchManager", "uin is %s", bo.anv(String.valueOf(j2)));
            j = j2;
        } catch (Exception e) {
            ab.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
            j = j2;
        }
        com.tinkerboots.sdk.a.a aVar = new com.tinkerboots.sdk.a.a(applicationLike);
        c cVar = new c(applicationLike.getApplication());
        TinkerRuntimeException tinkerRuntimeException;
        if (aVar.ABE != null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.o(90646);
            throw tinkerRuntimeException;
        }
        aVar.ABE = cVar;
        e eVar = new e(applicationLike.getApplication());
        if (aVar.ABF != null) {
            tinkerRuntimeException = new TinkerRuntimeException("patchReporter is already set.");
            AppMethodBeat.o(90646);
            throw tinkerRuntimeException;
        }
        aVar.ABF = eVar;
        b bVar = new b(applicationLike.getApplication());
        if (aVar.ABD != null) {
            tinkerRuntimeException = new TinkerRuntimeException("listener is already set.");
            AppMethodBeat.o(90646);
            throw tinkerRuntimeException;
        }
        aVar.ABD = bVar;
        Class cls = TinkerPatchResultService.class;
        if (aVar.ATW != null) {
            tinkerRuntimeException = new TinkerRuntimeException("resultServiceClass is already set.");
            AppMethodBeat.o(90646);
            throw tinkerRuntimeException;
        }
        aVar.ATW = cls;
        if (aVar.ABE == null) {
            aVar.ABE = new com.tinkerboots.sdk.tinker.b.a(aVar.context);
        }
        if (aVar.ABF == null) {
            aVar.ABF = new c(aVar.context);
        }
        if (aVar.ABD == null) {
            aVar.ABD = new b(aVar.context);
        }
        if (aVar.ATV == null) {
            aVar.ATV = new f();
        }
        if (aVar.ATW == null) {
            aVar.ATW = TinkerServerResultService.class;
        }
        if (aVar.ATX == null) {
            aVar.ATX = new com.tinkerboots.sdk.a.a.a();
        }
        com.tinkerboots.sdk.a aVar2 = new com.tinkerboots.sdk.a(aVar.context, aVar.cdV, aVar.ABE, aVar.ABF, aVar.ABD, aVar.ATV, aVar.ATW, aVar.ATX);
        if (com.tinkerboots.sdk.a.ATQ != null) {
            tinkerRuntimeException = new TinkerRuntimeException("TinkerClient instance is already set.");
            AppMethodBeat.o(90646);
            throw tinkerRuntimeException;
        }
        com.tinkerboots.sdk.a.ATQ = aVar2;
        aVar2 = com.tinkerboots.sdk.a.dWj().SG(g.em(ah.getContext()));
        boolean dnO = com.tencent.mm.sdk.a.b.dnO();
        if (aVar2.ATS == null || aVar2.ATR == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar2 = com.tinkerboots.sdk.a.ATQ;
        } else {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerClient", "set debugger to %b", Boolean.valueOf(dnO));
            aVar2.ATS.isDebug = dnO;
            aVar2 = com.tinkerboots.sdk.a.ATQ;
        }
        aVar2 = aVar2.iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).iN("code-version", com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION).iN("code-reversion", com.tencent.mm.sdk.platformtools.f.REV).iN(TencentLocation.NETWORK_PROVIDER, String.valueOf(at.isWifi(ah.getContext()) ? 3 : 2)).iN(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(VERSION.SDK_INT)).iN("os-name", com.tencent.mm.protocal.d.vxl).iN("device-brand", com.tencent.mm.protocal.d.vxi).iN("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
        f fVar = new f();
        if (aVar2.ATS == null || aVar2.ATR == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", Integer.valueOf(fVar.hashCode()));
            aVar2.ATS.ATX = fVar;
        }
        ab.i("Tinker.TinkerPatchManager", "try installing end");
        nue = true;
        AppMethodBeat.o(90646);
    }

    public static void bGq() {
        AppMethodBeat.i(90647);
        com.tencent.tinker.lib.util.a.a(new com.tencent.tinker.lib.util.a.a() {
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(90642);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(90642);
            }

            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(90643);
                ab.w(str, str2, objArr);
                AppMethodBeat.o(90643);
            }

            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(90644);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(90644);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(90645);
                ab.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(90645);
            }
        });
        AppMethodBeat.o(90647);
    }

    public static void bGr() {
        AppMethodBeat.i(90648);
        if (nue) {
            com.tencent.tinker.lib.e.a.iX(com.tencent.mm.app.b.cdV.getApplication()).bGr();
            AppMethodBeat.o(90648);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("cleanPatch but tinker is not installed");
        AppMethodBeat.o(90648);
        throw runtimeException;
    }

    public static void OG(String str) {
        AppMethodBeat.i(90649);
        if (nue) {
            com.tencent.tinker.lib.e.c.cf(com.tencent.mm.app.b.cdV.getApplication(), str);
            AppMethodBeat.o(90649);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("upgrade patch but tinker is not installed");
        AppMethodBeat.o(90649);
        throw runtimeException;
    }
}
