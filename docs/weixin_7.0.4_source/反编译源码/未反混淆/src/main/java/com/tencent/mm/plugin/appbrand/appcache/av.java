package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class av implements com.tencent.mm.model.bz.a {
    public static final Map<String, c> gUU;

    static final class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            AppMethodBeat.i(129435);
            if (map.get(".sysmsg.AppPublicLibraryNotify") == null) {
                AppMethodBeat.o(129435);
                return;
            }
            int i = bo.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
            String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
            String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
            int i2 = bo.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
            if (bo.isNullOrNil(str2) || bo.isNullOrNil(str) || i <= 0) {
                ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", str2, str, Integer.valueOf(i));
                AppMethodBeat.o(129435);
                return;
            }
            ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
            cwk cwk = new cwk();
            cwk.version = i;
            cwk.cvZ = str;
            cwk.url = str2;
            cwk.wPu = i2;
            aj.a(cwk);
            AppMethodBeat.o(129435);
        }
    }

    static final class b implements c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            AppMethodBeat.i(129433);
            i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i = 0;
            do {
                i++;
            } while (i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(i)), map));
            AppMethodBeat.o(129433);
        }

        private boolean i(String str, Map<String, String> map) {
            AppMethodBeat.i(129434);
            ab.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", str);
            if (map.get(str) == null) {
                AppMethodBeat.o(129434);
                return false;
            }
            final String str2 = (String) map.get(str + ".AppID");
            String str3 = (String) map.get(str + ".UserName");
            final int i = bo.getInt((String) map.get(str + ".Type"), 1);
            String str4 = (String) map.get(str + ".URL");
            long j = bo.getLong((String) map.get(str + ".StartTime"), bo.anT());
            ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(bo.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(f.auV().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)));
            if (f.auV().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
                if (999 != i) {
                    r.zt(str3);
                    final String zn = p.zn(str2);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(129432);
                            h.bt(str2, i);
                            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.m7, new Object[]{bo.bc(zn, str2)}), 1).show();
                            AppMethodBeat.o(129432);
                        }
                    });
                } else {
                    t.gTk.dy(false);
                }
                f.auT().aK(str3, i);
            }
            AppMethodBeat.o(129434);
            return true;
        }
    }

    public interface c {
        void u(Map<String, String> map);
    }

    static final class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            AppMethodBeat.i(129431);
            if (map.get(".sysmsg.mmbizwxaconfig") == null) {
                AppMethodBeat.o(129431);
                return;
            }
            int i = bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
            final int i2 = bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
            final String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
            ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0)));
            LinkedList linkedList = new LinkedList();
            cnp cnp = new cnp();
            cnp.version = r1;
            cnp.type = i2;
            linkedList.add(cnp);
            l.a(str, linkedList, false);
            l.a(str, i2, i, new com.tencent.mm.plugin.appbrand.config.l.c() {
                public final void xC(String str) {
                    AppMethodBeat.i(129430);
                    ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", str);
                    com.tencent.mm.plugin.appbrand.ipc.d.j(str, i2, str);
                    AppMethodBeat.o(129430);
                }
            }, true);
            AppMethodBeat.o(129431);
        }
    }

    static {
        AppMethodBeat.i(129438);
        HashMap hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b());
        hashMap.put("AppPublicLibraryNotify", new d());
        hashMap.put("mmbizwxaconfig", new a());
        hashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.d());
        hashMap.put("AppBrandForceKill", new com.tencent.mm.plugin.appbrand.debugger.c());
        if (DebuggerShell.ayT()) {
            hashMap.put("AppBrandTestUpdateWxaUsageListNotify", new com.tencent.mm.plugin.appbrand.debugger.h());
        }
        gUU = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(129438);
    }

    public final void a(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(129436);
        final String a = aa.a(aVar.eAB.vED);
        if (bo.isNullOrNil(a)) {
            ab.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
            AppMethodBeat.o(129436);
            return;
        }
        com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129429);
                av.xB(a);
                AppMethodBeat.o(129429);
            }
        }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
        AppMethodBeat.o(129436);
    }

    static /* synthetic */ void xB(String str) {
        AppMethodBeat.i(129437);
        if (f.auV() == null) {
            ab.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            AppMethodBeat.o(129437);
            return;
        }
        Map z = br.z(str, "sysmsg");
        if (z == null || z.size() <= 0) {
            ab.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            AppMethodBeat.o(129437);
            return;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", str2);
        if (!bo.isNullOrNil(str2)) {
            c cVar = (c) gUU.get(str2);
            if (cVar != null) {
                cVar.u(z);
            }
        }
        AppMethodBeat.o(129437);
    }
}
