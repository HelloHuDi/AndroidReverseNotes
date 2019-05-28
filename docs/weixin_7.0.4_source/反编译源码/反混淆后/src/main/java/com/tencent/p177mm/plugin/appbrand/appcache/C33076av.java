package com.tencent.p177mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.C45535l;
import com.tencent.p177mm.plugin.appbrand.config.C45535l.C42404c;
import com.tencent.p177mm.plugin.appbrand.debugger.C10187c;
import com.tencent.p177mm.plugin.appbrand.debugger.C26848h;
import com.tencent.p177mm.plugin.appbrand.debugger.C46890d;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.protocal.protobuf.cnp;
import com.tencent.p177mm.protocal.protobuf.cwk;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.av */
public final class C33076av implements C1837a {
    public static final Map<String, C33079c> gUU;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.av$d */
    static final class C2054d implements C33079c {
        private C2054d() {
        }

        /* synthetic */ C2054d(byte b) {
            this();
        }

        /* renamed from: u */
        public final void mo5821u(Map<String, String> map) {
            AppMethodBeat.m2504i(129435);
            if (map.get(".sysmsg.AppPublicLibraryNotify") == null) {
                AppMethodBeat.m2505o(129435);
                return;
            }
            int i = C5046bo.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
            String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
            String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
            int i2 = C5046bo.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
            if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str) || i <= 0) {
                C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", str2, str, Integer.valueOf(i));
                AppMethodBeat.m2505o(129435);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
            cwk cwk = new cwk();
            cwk.version = i;
            cwk.cvZ = str;
            cwk.url = str2;
            cwk.wPu = i2;
            C10068aj.m17652a(cwk);
            AppMethodBeat.m2505o(129435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.av$b */
    static final class C33077b implements C33079c {
        private C33077b() {
        }

        /* synthetic */ C33077b(byte b) {
            this();
        }

        /* renamed from: u */
        public final void mo5821u(Map<String, String> map) {
            AppMethodBeat.m2504i(129433);
            m54062i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i = 0;
            do {
                i++;
            } while (m54062i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(i)), map));
            AppMethodBeat.m2505o(129433);
        }

        /* renamed from: i */
        private boolean m54062i(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(129434);
            C4990ab.m7411d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", str);
            if (map.get(str) == null) {
                AppMethodBeat.m2505o(129434);
                return false;
            }
            final String str2 = (String) map.get(str + ".AppID");
            String str3 = (String) map.get(str + ".UserName");
            final int i = C5046bo.getInt((String) map.get(str + ".Type"), 1);
            String str4 = (String) map.get(str + ".URL");
            long j = C5046bo.getLong((String) map.get(str + ".StartTime"), C5046bo.anT());
            C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(C5046bo.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(C42340f.auV().mo60848a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)));
            if (C42340f.auV().mo60848a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
                if (999 != i) {
                    C42406r.m75079zt(str3);
                    final String zn = C26842p.m42741zn(str2);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(129432);
                            C45694h.m84422bt(str2, i);
                            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.f9005m7, new Object[]{C5046bo.m7532bc(zn, str2)}), 1).show();
                            AppMethodBeat.m2505o(129432);
                        }
                    });
                } else {
                    C42360t.gTk.mo67866dy(false);
                }
                C42340f.auT().mo73332aK(str3, i);
            }
            AppMethodBeat.m2505o(129434);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.av$c */
    public interface C33079c {
        /* renamed from: u */
        void mo5821u(Map<String, String> map);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.av$a */
    static final class C33080a implements C33079c {
        private C33080a() {
        }

        /* synthetic */ C33080a(byte b) {
            this();
        }

        /* renamed from: u */
        public final void mo5821u(Map<String, String> map) {
            AppMethodBeat.m2504i(129431);
            if (map.get(".sysmsg.mmbizwxaconfig") == null) {
                AppMethodBeat.m2505o(129431);
                return;
            }
            int i = C5046bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
            final int i2 = C5046bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
            final String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
            C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(C5046bo.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0)));
            LinkedList linkedList = new LinkedList();
            cnp cnp = new cnp();
            cnp.version = r1;
            cnp.type = i2;
            linkedList.add(cnp);
            C45535l.m83973a(str, linkedList, false);
            C45535l.m83971a(str, i2, i, new C42404c() {
                /* renamed from: xC */
                public final void mo53649xC(String str) {
                    AppMethodBeat.m2504i(129430);
                    C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", str);
                    C10276d.m17935j(str, i2, str);
                    AppMethodBeat.m2505o(129430);
                }
            }, true);
            AppMethodBeat.m2505o(129431);
        }
    }

    static {
        AppMethodBeat.m2504i(129438);
        HashMap hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new C33077b());
        hashMap.put("AppPublicLibraryNotify", new C2054d());
        hashMap.put("mmbizwxaconfig", new C33080a());
        hashMap.put("ForceOpenAppNotify", new C46890d());
        hashMap.put("AppBrandForceKill", new C10187c());
        if (DebuggerShell.ayT()) {
            hashMap.put("AppBrandTestUpdateWxaUsageListNotify", new C26848h());
        }
        gUU = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.m2505o(129438);
    }

    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(129436);
        final String a = C1946aa.m4148a(c1197a.eAB.vED);
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7420w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
            AppMethodBeat.m2505o(129436);
            return;
        }
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129429);
                C33076av.m54060xB(a);
                AppMethodBeat.m2505o(129429);
            }
        }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
        AppMethodBeat.m2505o(129436);
    }

    /* renamed from: xB */
    static /* synthetic */ void m54060xB(String str) {
        AppMethodBeat.m2504i(129437);
        if (C42340f.auV() == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            AppMethodBeat.m2505o(129437);
            return;
        }
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null || z.size() <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            AppMethodBeat.m2505o(129437);
            return;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        C4990ab.m7417i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", str2);
        if (!C5046bo.isNullOrNil(str2)) {
            C33079c c33079c = (C33079c) gUU.get(str2);
            if (c33079c != null) {
                c33079c.mo5821u(z);
            }
        }
        AppMethodBeat.m2505o(129437);
    }
}
