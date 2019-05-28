package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.media.record.C10626g.C10636a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.c */
public final class C45654c {
    private static Map<String, C4884c> ilh = new HashMap();
    private static ArrayList<String> ili = new ArrayList();
    private static boolean ilj = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.c$1 */
    static class C272011 implements Runnable {
        C272011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105587);
            C45654c.access$000();
            AppMethodBeat.m2505o(105587);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.c$a */
    static final class C45655a implements C45413i<IPCVoid, IPCString> {
        private C45655a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(105589);
            IPCString aIf = C45655a.aIf();
            AppMethodBeat.m2505o(105589);
            return aIf;
        }

        private static IPCString aIf() {
            AppMethodBeat.m2504i(105588);
            IPCString iPCString;
            try {
                C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
                iPCString = new IPCString(C1720g.m3536RP().mo5240Rz().dur());
                AppMethodBeat.m2505o(105588);
                return iPCString;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", e, "ipc updateDeviceInfo task", new Object[0]);
                iPCString = new IPCString("");
                AppMethodBeat.m2505o(105588);
                return iPCString;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(105595);
        AppMethodBeat.m2505o(105595);
    }

    public static void onCreate() {
    }

    public static void onDestroy() {
        AppMethodBeat.m2504i(105590);
        C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
        Iterator it = ili.iterator();
        while (it.hasNext()) {
            C4884c c4884c = (C4884c) ilh.remove((String) it.next());
            if (c4884c != null) {
                C4879a.xxA.mo10053d(c4884c);
            }
        }
        ilh.clear();
        ili.clear();
        C10626g aIm = C10626g.aIm();
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "destroy");
        if (aIm.ilp == C10636a.START || aIm.ilp == C10636a.RESUME || aIm.ilp == C10636a.ERROR) {
            aIm.mo22151EB();
        }
        if (aIm.ilw) {
            if (!(aIm.ilo == null || aIm.ilo.imo == null)) {
                aIm.ilo.imo.mo73433a(null);
                aIm.ilo.imo.aIl();
            }
            aIm.ilw = false;
        }
        AppMethodBeat.m2505o(105590);
    }

    /* renamed from: b */
    public static void m84305b(String str, C4884c c4884c) {
        AppMethodBeat.m2504i(105591);
        if (ilh.containsKey(str)) {
            C4990ab.m7413e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", str);
            AppMethodBeat.m2505o(105591);
        } else if (c4884c == null) {
            C4990ab.m7412e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
            AppMethodBeat.m2505o(105591);
        } else {
            C4990ab.m7417i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", str);
            ilh.put(str, c4884c);
            if (!ili.contains(str)) {
                ili.add(str);
            }
            C4879a.xxA.mo10051b(c4884c);
            AppMethodBeat.m2505o(105591);
        }
    }

    /* renamed from: Cx */
    public static void m84304Cx(String str) {
        AppMethodBeat.m2504i(105592);
        if (ilh.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", str);
            ili.remove(str);
            C4884c c4884c = (C4884c) ilh.remove(str);
            if (c4884c != null) {
                C4879a.xxA.mo10053d(c4884c);
            }
            AppMethodBeat.m2505o(105592);
            return;
        }
        C4990ab.m7413e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", str);
        AppMethodBeat.m2505o(105592);
    }

    public static void aIe() {
        AppMethodBeat.m2504i(105593);
        if (ilj) {
            C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.m2505o(105593);
            return;
        }
        C7305d.post(new C272011(), "record_update_device_info");
        AppMethodBeat.m2505o(105593);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(105594);
        if (ilj) {
            C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.m2505o(105594);
            return;
        }
        C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "to do update device info!");
        ilj = true;
        IPCString iPCString = (IPCString) XIPCInvoker.m83628a("com.tencent.mm", null, C45655a.class);
        if (!(iPCString == null || iPCString.value == null)) {
            C1427q.m3050ku(iPCString.value);
            C4990ab.m7416i("MicroMsg.Record.AppBrandRecordClientService", "update device info success!");
        }
        AppMethodBeat.m2505o(105594);
    }
}
