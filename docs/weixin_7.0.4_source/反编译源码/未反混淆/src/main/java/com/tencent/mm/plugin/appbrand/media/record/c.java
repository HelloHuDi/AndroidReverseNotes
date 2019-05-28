package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static Map<String, com.tencent.mm.sdk.b.c> ilh = new HashMap();
    private static ArrayList<String> ili = new ArrayList();
    private static boolean ilj = false;

    static final class a implements i<IPCVoid, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(105589);
            IPCString aIf = aIf();
            AppMethodBeat.o(105589);
            return aIf;
        }

        private static IPCString aIf() {
            AppMethodBeat.i(105588);
            IPCString iPCString;
            try {
                ab.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
                iPCString = new IPCString(g.RP().Rz().dur());
                AppMethodBeat.o(105588);
                return iPCString;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", e, "ipc updateDeviceInfo task", new Object[0]);
                iPCString = new IPCString("");
                AppMethodBeat.o(105588);
                return iPCString;
            }
        }
    }

    static {
        AppMethodBeat.i(105595);
        AppMethodBeat.o(105595);
    }

    public static void onCreate() {
    }

    public static void onDestroy() {
        AppMethodBeat.i(105590);
        ab.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
        Iterator it = ili.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) ilh.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xxA.d(cVar);
            }
        }
        ilh.clear();
        ili.clear();
        g aIm = g.aIm();
        ab.i("MicroMsg.Record.AudioRecordMgr", "destroy");
        if (aIm.ilp == com.tencent.mm.plugin.appbrand.media.record.g.a.START || aIm.ilp == com.tencent.mm.plugin.appbrand.media.record.g.a.RESUME || aIm.ilp == com.tencent.mm.plugin.appbrand.media.record.g.a.ERROR) {
            aIm.EB();
        }
        if (aIm.ilw) {
            if (!(aIm.ilo == null || aIm.ilo.imo == null)) {
                aIm.ilo.imo.a(null);
                aIm.ilo.imo.aIl();
            }
            aIm.ilw = false;
        }
        AppMethodBeat.o(105590);
    }

    public static void b(String str, com.tencent.mm.sdk.b.c cVar) {
        AppMethodBeat.i(105591);
        if (ilh.containsKey(str)) {
            ab.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", str);
            AppMethodBeat.o(105591);
        } else if (cVar == null) {
            ab.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
            AppMethodBeat.o(105591);
        } else {
            ab.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", str);
            ilh.put(str, cVar);
            if (!ili.contains(str)) {
                ili.add(str);
            }
            com.tencent.mm.sdk.b.a.xxA.b(cVar);
            AppMethodBeat.o(105591);
        }
    }

    public static void Cx(String str) {
        AppMethodBeat.i(105592);
        if (ilh.containsKey(str)) {
            ab.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", str);
            ili.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) ilh.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xxA.d(cVar);
            }
            AppMethodBeat.o(105592);
            return;
        }
        ab.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", str);
        AppMethodBeat.o(105592);
    }

    public static void aIe() {
        AppMethodBeat.i(105593);
        if (ilj) {
            ab.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.o(105593);
            return;
        }
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(105587);
                c.access$000();
                AppMethodBeat.o(105587);
            }
        }, "record_update_device_info");
        AppMethodBeat.o(105593);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(105594);
        if (ilj) {
            ab.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.o(105594);
            return;
        }
        ab.i("MicroMsg.Record.AppBrandRecordClientService", "to do update device info!");
        ilj = true;
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", null, a.class);
        if (!(iPCString == null || iPCString.value == null)) {
            q.ku(iPCString.value);
            ab.i("MicroMsg.Record.AppBrandRecordClientService", "update device info success!");
        }
        AppMethodBeat.o(105594);
    }
}
