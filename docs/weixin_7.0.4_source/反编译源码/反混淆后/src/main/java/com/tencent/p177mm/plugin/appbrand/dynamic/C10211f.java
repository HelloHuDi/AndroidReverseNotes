package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f */
public final class C10211f {
    private static C10211f hlA = new C10211f();
    Map<String, C10214b> hlB = new ConcurrentHashMap();
    C9557a hlC = new C102121();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f$1 */
    class C102121 implements C9557a {
        C102121() {
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(10682);
            if (!(i == 0 && i2 == 0)) {
                C4990ab.m7413e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", str);
            }
            AppMethodBeat.m2505o(10682);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f$a */
    public static class C10213a implements C37866a<Bundle, Bundle> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10683);
            Bundle bundle = (Bundle) obj;
            if (bundle.getBoolean("isOpenWeappFial", false)) {
                C10211f.azA().mo21628aZ(C10211f.access$000(bundle.getString("sceneNote")), bundle.getInt("widgetState") + AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                AppMethodBeat.m2505o(10683);
                return;
            }
            C10211f.azA().mo21628aZ(bundle.getString("id"), bundle.getInt("widgetState"));
            AppMethodBeat.m2505o(10683);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f$b */
    public static class C10214b {
        String appId = "";
        int fmr = 0;
        String hlE = "";
        LinkedList<Integer> hlF = new LinkedList();
        String query = "";

        public C10214b(String str, String str2, int i, String str3) {
            AppMethodBeat.m2504i(10684);
            this.hlE = str;
            this.appId = str2;
            this.fmr = i;
            this.query = str3;
            AppMethodBeat.m2505o(10684);
        }
    }

    public C10211f() {
        AppMethodBeat.m2504i(10685);
        AppMethodBeat.m2505o(10685);
    }

    static /* synthetic */ String access$000(String str) {
        AppMethodBeat.m2504i(10690);
        String zU = C10211f.m17852zU(str);
        AppMethodBeat.m2505o(10690);
        return zU;
    }

    static {
        AppMethodBeat.m2504i(10691);
        AppMethodBeat.m2505o(10691);
    }

    public static C10211f azA() {
        return hlA;
    }

    /* renamed from: aZ */
    public final boolean mo21628aZ(String str, int i) {
        AppMethodBeat.m2504i(10686);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(10686);
            return false;
        } else if (this.hlB.containsKey(str)) {
            switch (i) {
                case TXLiveConstants.PLAY_WARNING_RECONNECT /*2103*/:
                    C38203j.azE().mo60938E(str, 628, 9);
                    break;
            }
            boolean add = ((C10214b) this.hlB.get(str)).hlF.add(Integer.valueOf(i));
            AppMethodBeat.m2505o(10686);
            return add;
        } else {
            C4990ab.m7421w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", str);
            AppMethodBeat.m2505o(10686);
            return false;
        }
    }

    /* renamed from: zT */
    public static void m17851zT(String str) {
        AppMethodBeat.m2504i(10687);
        Bundle bundle = new Bundle();
        String zU = C10211f.m17852zU(str);
        bundle.putString("id", zU);
        bundle.putInt("widgetState", 2109);
        C9549f.m17012a(C33164i.azC().mo53694zV(zU), bundle, C10213a.class, null);
        AppMethodBeat.m2505o(10687);
    }

    /* renamed from: n */
    public static void m17850n(int i, String str, String str2) {
        AppMethodBeat.m2504i(10688);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOpenWeappFial", true);
        bundle.putInt("widgetState", i);
        bundle.putString("appid", str);
        bundle.putString("sceneNote", str2);
        C9549f.m17012a(C33164i.azC().mo53694zV(C10211f.m17852zU(str2)), bundle, C10213a.class, null);
        AppMethodBeat.m2505o(10688);
    }

    /* renamed from: zU */
    private static String m17852zU(String str) {
        AppMethodBeat.m2504i(10689);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(10689);
            return str2;
        }
        Matcher matcher = Pattern.compile(":widgetId=.*:").matcher(str);
        if (matcher.matches()) {
            str2 = matcher.group();
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.substring(str2.indexOf("=") + 1, str2.lastIndexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                AppMethodBeat.m2505o(10689);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(10689);
        return str2;
    }
}
