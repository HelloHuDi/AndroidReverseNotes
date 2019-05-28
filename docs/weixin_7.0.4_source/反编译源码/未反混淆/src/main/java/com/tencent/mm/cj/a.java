package com.tencent.mm.cj;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.svg.a.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.u;
import com.tencent.xweb.util.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    public static c AiA = new c() {
        final String TAG = "IXWebLogClient";

        public final void i(String str, String str2) {
            AppMethodBeat.i(80370);
            ab.i(str, str2);
            AppMethodBeat.o(80370);
        }

        public final void e(String str, String str2) {
            AppMethodBeat.i(80371);
            ab.e(str, str2);
            AppMethodBeat.o(80371);
        }

        public final void w(String str, String str2) {
            AppMethodBeat.i(80372);
            ab.w(str, str2);
            AppMethodBeat.o(80372);
        }

        public final void d(String str, String str2) {
            AppMethodBeat.i(80373);
            ab.d(str, str2);
            AppMethodBeat.o(80373);
        }

        public final void v(String str, String str2) {
            AppMethodBeat.i(80374);
            ab.v(str, str2);
            AppMethodBeat.o(80374);
        }
    };
    public static u AiB = new u() {
        final String TAG = "XWebIdkey";

        public final void k(long j, long j2, long j3) {
            AppMethodBeat.i(80375);
            ab.v("XWebIdkey", "callback: idkeyStat:" + j + ", " + j2 + ", " + j3);
            h.pYm.a(j, j2, j3, true);
            AppMethodBeat.o(80375);
        }

        public final void aG(int i, int i2, int i3) {
            AppMethodBeat.i(80376);
            ab.v("XWebIdkey", "callback: idkeyForPair:577, " + i + ", 1, 577, " + i2 + ", " + i3);
            h.pYm.a(w.CTRL_INDEX, w.CTRL_INDEX, i, i2, 1, i3, true);
            AppMethodBeat.o(80376);
        }

        public final void X(int i, String str) {
            AppMethodBeat.i(80377);
            ab.v("XWebIdkey", "callback: kvStat:" + i + ", " + str);
            h.pYm.X(i, str);
            AppMethodBeat.o(80377);
        }

        public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
            AppMethodBeat.i(80378);
            ab.v("XWebIdkey", "callback: kvStat:15003, 190301," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
            h.pYm.e(15003, Integer.valueOf(XWalkEnvironment.SDK_VERSION), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(at.getNetType(ah.getContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            AppMethodBeat.o(80378);
        }
    };
    public static WebViewExtensionListener AiC = new WebViewExtensionListener() {
        public final Object onMiscCallBack(String str, Object... objArr) {
            AppMethodBeat.i(80379);
            if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                e.a((Resources) objArr[0], (Map) objArr[1]);
            }
            AppMethodBeat.o(80379);
            return null;
        }

        public final int getHostByName(String str, List<String> list) {
            AppMethodBeat.i(80380);
            if (b.PL().le("com.tencent.mm")) {
                Bundle bundle = (Bundle) XIPCInvoker.a("com.tencent.mm", new IPCString(str), a.class);
                if (list == null || bundle == null) {
                    AppMethodBeat.o(80380);
                    return 0;
                }
                list.clear();
                ArrayList stringArrayList = bundle.getStringArrayList("ipList");
                int i = bundle.getInt("result");
                list.addAll(stringArrayList);
                AppMethodBeat.o(80380);
                return i;
            }
            AppMethodBeat.o(80380);
            return 0;
        }
    };
    public static com.tencent.xweb.e AiD = new com.tencent.xweb.e() {
        public final SharedPreferences x(String str, int i, boolean z) {
            as amG;
            AppMethodBeat.i(80381);
            if (z) {
                amG = as.amG(str);
            } else {
                int i2;
                if (i == 4) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                amG = as.eg(str, i2);
            }
            if (amG == null) {
                AppMethodBeat.o(80381);
                return null;
            }
            SharedPreferences bVar = new b(amG);
            AppMethodBeat.o(80381);
            return bVar;
        }
    };

    static final class a implements i<IPCString, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(80383);
            Bundle e = e((IPCString) obj);
            AppMethodBeat.o(80383);
            return e;
        }

        private static Bundle e(IPCString iPCString) {
            AppMethodBeat.i(80382);
            Bundle bundle = new Bundle();
            try {
                int i;
                ArrayList arrayList = new ArrayList();
                if (bo.isNullOrNil(iPCString.value)) {
                    i = 0;
                } else {
                    i = g.RO().eJo.ftA.getHostByName(iPCString.value, arrayList);
                }
                bundle.putStringArrayList("ipList", arrayList);
                bundle.putInt("result", i);
                AppMethodBeat.o(80382);
            } catch (Exception e) {
                ab.printErrStackTrace("GetHostByNameTask", e, "GetHostByNameTask", new Object[0]);
                AppMethodBeat.o(80382);
            }
            return bundle;
        }
    }

    static {
        AppMethodBeat.i(80385);
        AppMethodBeat.o(80385);
    }

    public static String dOY() {
        AppMethodBeat.i(80384);
        String processName = ah.getProcessName();
        if (processName == null) {
            processName = "";
            AppMethodBeat.o(80384);
            return processName;
        } else if (processName.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            processName = processName.substring(processName.lastIndexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).toLowerCase();
            if (processName.startsWith("appbrand")) {
                processName = "appbrand";
                AppMethodBeat.o(80384);
                return processName;
            }
            AppMethodBeat.o(80384);
            return processName;
        } else if (processName.contains(".")) {
            processName = processName.substring(processName.lastIndexOf(".") + 1).toLowerCase();
            AppMethodBeat.o(80384);
            return processName;
        } else {
            AppMethodBeat.o(80384);
            return processName;
        }
    }
}
