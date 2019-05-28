package com.tencent.p177mm.p218cj;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C32710b;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.svg.p610a.C5154e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C16384e;
import com.tencent.xweb.C24531u;
import com.tencent.xweb.util.C6036c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.cj.a */
public final class C1390a {
    public static C6036c AiA = new C13921();
    public static C24531u AiB = new C13912();
    public static WebViewExtensionListener AiC = new C13933();
    public static C16384e AiD = new C13944();

    /* renamed from: com.tencent.mm.cj.a$2 */
    static class C13912 extends C24531u {
        final String TAG = "XWebIdkey";

        C13912() {
        }

        /* renamed from: k */
        public final void mo4776k(long j, long j2, long j3) {
            AppMethodBeat.m2504i(80375);
            C4990ab.m7418v("XWebIdkey", "callback: idkeyStat:" + j + ", " + j2 + ", " + j3);
            C7060h.pYm.mo8378a(j, j2, j3, true);
            AppMethodBeat.m2505o(80375);
        }

        /* renamed from: aG */
        public final void mo4775aG(int i, int i2, int i3) {
            AppMethodBeat.m2504i(80376);
            C4990ab.m7418v("XWebIdkey", "callback: idkeyForPair:577, " + i + ", 1, 577, " + i2 + ", " + i3);
            C7060h.pYm.mo8375a(C24699w.CTRL_INDEX, C24699w.CTRL_INDEX, i, i2, 1, i3, true);
            AppMethodBeat.m2505o(80376);
        }

        /* renamed from: X */
        public final void mo4773X(int i, String str) {
            AppMethodBeat.m2504i(80377);
            C4990ab.m7418v("XWebIdkey", "callback: kvStat:" + i + ", " + str);
            C7060h.pYm.mo8374X(i, str);
            AppMethodBeat.m2505o(80377);
        }

        /* renamed from: a */
        public final void mo4774a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
            AppMethodBeat.m2504i(80378);
            C4990ab.m7418v("XWebIdkey", "callback: kvStat:15003, 190301," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
            C7060h.pYm.mo8381e(15003, Integer.valueOf(XWalkEnvironment.SDK_VERSION), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(C5023at.getNetType(C4996ah.getContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            AppMethodBeat.m2505o(80378);
        }
    }

    /* renamed from: com.tencent.mm.cj.a$1 */
    static class C13921 implements C6036c {
        final String TAG = "IXWebLogClient";

        C13921() {
        }

        /* renamed from: i */
        public final void mo4779i(String str, String str2) {
            AppMethodBeat.m2504i(80370);
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(80370);
        }

        /* renamed from: e */
        public final void mo4778e(String str, String str2) {
            AppMethodBeat.m2504i(80371);
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(80371);
        }

        /* renamed from: w */
        public final void mo4781w(String str, String str2) {
            AppMethodBeat.m2504i(80372);
            C4990ab.m7420w(str, str2);
            AppMethodBeat.m2505o(80372);
        }

        /* renamed from: d */
        public final void mo4777d(String str, String str2) {
            AppMethodBeat.m2504i(80373);
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(80373);
        }

        /* renamed from: v */
        public final void mo4780v(String str, String str2) {
            AppMethodBeat.m2504i(80374);
            C4990ab.m7418v(str, str2);
            AppMethodBeat.m2505o(80374);
        }
    }

    /* renamed from: com.tencent.mm.cj.a$3 */
    static class C13933 extends WebViewExtensionListener {
        C13933() {
        }

        public final Object onMiscCallBack(String str, Object... objArr) {
            AppMethodBeat.m2504i(80379);
            if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                C5154e.m7847a((Resources) objArr[0], (Map) objArr[1]);
            }
            AppMethodBeat.m2505o(80379);
            return null;
        }

        public final int getHostByName(String str, List<String> list) {
            AppMethodBeat.m2504i(80380);
            if (C32710b.m53380PL().mo53222le("com.tencent.mm")) {
                Bundle bundle = (Bundle) XIPCInvoker.m83628a("com.tencent.mm", new IPCString(str), C1395a.class);
                if (list == null || bundle == null) {
                    AppMethodBeat.m2505o(80380);
                    return 0;
                }
                list.clear();
                ArrayList stringArrayList = bundle.getStringArrayList("ipList");
                int i = bundle.getInt("result");
                list.addAll(stringArrayList);
                AppMethodBeat.m2505o(80380);
                return i;
            }
            AppMethodBeat.m2505o(80380);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.cj.a$4 */
    static class C13944 implements C16384e {
        C13944() {
        }

        /* renamed from: x */
        public final SharedPreferences mo4784x(String str, int i, boolean z) {
            C5018as amG;
            AppMethodBeat.m2504i(80381);
            if (z) {
                amG = C5018as.amG(str);
            } else {
                int i2;
                if (i == 4) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                amG = C5018as.m7465eg(str, i2);
            }
            if (amG == null) {
                AppMethodBeat.m2505o(80381);
                return null;
            }
            SharedPreferences c1396b = new C1396b(amG);
            AppMethodBeat.m2505o(80381);
            return c1396b;
        }
    }

    /* renamed from: com.tencent.mm.cj.a$a */
    static final class C1395a implements C45413i<IPCString, Bundle> {
        private C1395a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(80383);
            Bundle e = C1395a.m2941e((IPCString) obj);
            AppMethodBeat.m2505o(80383);
            return e;
        }

        /* renamed from: e */
        private static Bundle m2941e(IPCString iPCString) {
            AppMethodBeat.m2504i(80382);
            Bundle bundle = new Bundle();
            try {
                int i;
                ArrayList arrayList = new ArrayList();
                if (C5046bo.isNullOrNil(iPCString.value)) {
                    i = 0;
                } else {
                    i = C1720g.m3535RO().eJo.ftA.getHostByName(iPCString.value, arrayList);
                }
                bundle.putStringArrayList("ipList", arrayList);
                bundle.putInt("result", i);
                AppMethodBeat.m2505o(80382);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("GetHostByNameTask", e, "GetHostByNameTask", new Object[0]);
                AppMethodBeat.m2505o(80382);
            }
            return bundle;
        }
    }

    static {
        AppMethodBeat.m2504i(80385);
        AppMethodBeat.m2505o(80385);
    }

    public static String dOY() {
        AppMethodBeat.m2504i(80384);
        String processName = C4996ah.getProcessName();
        if (processName == null) {
            processName = "";
            AppMethodBeat.m2505o(80384);
            return processName;
        } else if (processName.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            processName = processName.substring(processName.lastIndexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).toLowerCase();
            if (processName.startsWith("appbrand")) {
                processName = "appbrand";
                AppMethodBeat.m2505o(80384);
                return processName;
            }
            AppMethodBeat.m2505o(80384);
            return processName;
        } else if (processName.contains(".")) {
            processName = processName.substring(processName.lastIndexOf(".") + 1).toLowerCase();
            AppMethodBeat.m2505o(80384);
            return processName;
        } else {
            AppMethodBeat.m2505o(80384);
            return processName;
        }
    }
}
