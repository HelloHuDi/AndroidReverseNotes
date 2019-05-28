package com.tencent.p177mm.plugin.p436hp.tinker;

import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p1112c.C36550f;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C46818c;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.lib.util.C5952a.C5951a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.C44598a;
import com.tinkerboots.sdk.C44598a.C44600a;
import com.tinkerboots.sdk.p688a.p1579a.C46841a;
import com.tinkerboots.sdk.tinker.p1356b.C25022a;
import com.tinkerboots.sdk.tinker.p1356b.C41147b;
import com.tinkerboots.sdk.tinker.p1356b.C44602c;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

/* renamed from: com.tencent.mm.plugin.hp.tinker.d */
public final class C34364d {
    private static boolean nue = false;

    /* renamed from: com.tencent.mm.plugin.hp.tinker.d$1 */
    static class C283201 implements C5951a {
        C283201() {
        }

        /* renamed from: i */
        public final void mo12652i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(90642);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(90642);
        }

        /* renamed from: w */
        public final void mo12654w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(90643);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(90643);
        }

        /* renamed from: e */
        public final void mo12651e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(90644);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(90644);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(90645);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(90645);
        }
    }

    /* renamed from: b */
    public static void m56347b(ApplicationLike applicationLike) {
        AppMethodBeat.m2504i(90646);
        C4990ab.m7416i("Tinker.TinkerPatchManager", "try installing tinker");
        if (nue) {
            C4990ab.m7420w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            AppMethodBeat.m2505o(90646);
            return;
        }
        long j;
        long j2 = 0;
        try {
            j2 = ((long) C1668a.m3396Ra()) & 4294967295L;
            C4990ab.m7417i("Tinker.TinkerPatchManager", "uin is %s", C5046bo.anv(String.valueOf(j2)));
            j = j2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
            j = j2;
        }
        C44600a c44600a = new C44600a(applicationLike);
        C24779c c24779c = new C24779c(applicationLike.getApplication());
        TinkerRuntimeException tinkerRuntimeException;
        if (c44600a.ABE != null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.m2505o(90646);
            throw tinkerRuntimeException;
        }
        c44600a.ABE = c24779c;
        C24782e c24782e = new C24782e(applicationLike.getApplication());
        if (c44600a.ABF != null) {
            tinkerRuntimeException = new TinkerRuntimeException("patchReporter is already set.");
            AppMethodBeat.m2505o(90646);
            throw tinkerRuntimeException;
        }
        c44600a.ABF = c24782e;
        C43215b c43215b = new C43215b(applicationLike.getApplication());
        if (c44600a.ABD != null) {
            tinkerRuntimeException = new TinkerRuntimeException("listener is already set.");
            AppMethodBeat.m2505o(90646);
            throw tinkerRuntimeException;
        }
        c44600a.ABD = c43215b;
        Class cls = TinkerPatchResultService.class;
        if (c44600a.ATW != null) {
            tinkerRuntimeException = new TinkerRuntimeException("resultServiceClass is already set.");
            AppMethodBeat.m2505o(90646);
            throw tinkerRuntimeException;
        }
        c44600a.ATW = cls;
        if (c44600a.ABE == null) {
            c44600a.ABE = new C25022a(c44600a.context);
        }
        if (c44600a.ABF == null) {
            c44600a.ABF = new C44602c(c44600a.context);
        }
        if (c44600a.ABD == null) {
            c44600a.ABD = new C41147b(c44600a.context);
        }
        if (c44600a.ATV == null) {
            c44600a.ATV = new C36550f();
        }
        if (c44600a.ATW == null) {
            c44600a.ATW = TinkerServerResultService.class;
        }
        if (c44600a.ATX == null) {
            c44600a.ATX = new C46841a();
        }
        C44598a c44598a = new C44598a(c44600a.context, c44600a.cdV, c44600a.ABE, c44600a.ABF, c44600a.ABD, c44600a.ATV, c44600a.ATW, c44600a.ATX);
        if (C44598a.ATQ != null) {
            tinkerRuntimeException = new TinkerRuntimeException("TinkerClient instance is already set.");
            AppMethodBeat.m2505o(90646);
            throw tinkerRuntimeException;
        }
        C44598a.ATQ = c44598a;
        c44598a = C44598a.dWj().mo71470SG(C21075g.m32385em(C4996ah.getContext()));
        boolean dnO = C4872b.dnO();
        if (c44598a.ATS == null || c44598a.ATR == null) {
            C5952a.m9283e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            c44598a = C44598a.ATQ;
        } else {
            C5952a.m9284i("Tinker.TinkerClient", "set debugger to %b", Boolean.valueOf(dnO));
            c44598a.ATS.isDebug = dnO;
            c44598a = C44598a.ATQ;
        }
        c44598a = c44598a.mo71471iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).mo71471iN("code-version", C5058f.CLIENT_VERSION).mo71471iN("code-reversion", C5058f.REV).mo71471iN(TencentLocation.NETWORK_PROVIDER, String.valueOf(C5023at.isWifi(C4996ah.getContext()) ? 3 : 2)).mo71471iN(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(VERSION.SDK_INT)).mo71471iN("os-name", C7243d.vxl).mo71471iN("device-brand", C7243d.vxi).mo71471iN("device-name", C7243d.DEVICE_NAME);
        C21074f c21074f = new C21074f();
        if (c44598a.ATS == null || c44598a.ATR == null) {
            C5952a.m9283e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            C5952a.m9284i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", Integer.valueOf(c21074f.hashCode()));
            c44598a.ATS.ATX = c21074f;
        }
        C4990ab.m7416i("Tinker.TinkerPatchManager", "try installing end");
        nue = true;
        AppMethodBeat.m2505o(90646);
    }

    public static void bGq() {
        AppMethodBeat.m2504i(90647);
        C5952a.m9282a(new C283201());
        AppMethodBeat.m2505o(90647);
    }

    public static void bGr() {
        AppMethodBeat.m2504i(90648);
        if (nue) {
            C31097a.m50180iX(C1244b.cdV.getApplication()).bGr();
            AppMethodBeat.m2505o(90648);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("cleanPatch but tinker is not installed");
        AppMethodBeat.m2505o(90648);
        throw runtimeException;
    }

    /* renamed from: OG */
    public static void m56346OG(String str) {
        AppMethodBeat.m2504i(90649);
        if (nue) {
            C46818c.m89042cf(C1244b.cdV.getApplication(), str);
            AppMethodBeat.m2505o(90649);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("upgrade patch but tinker is not installed");
        AppMethodBeat.m2505o(90649);
        throw runtimeException;
    }
}
