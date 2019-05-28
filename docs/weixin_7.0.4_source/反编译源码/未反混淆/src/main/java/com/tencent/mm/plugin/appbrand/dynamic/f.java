package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static f hlA = new f();
    Map<String, b> hlB = new ConcurrentHashMap();
    com.tencent.mm.ipcinvoker.wx_extension.b.a hlC = new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
        public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(10682);
            if (!(i == 0 && i2 == 0)) {
                ab.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", str);
            }
            AppMethodBeat.o(10682);
        }
    };

    public static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10683);
            Bundle bundle = (Bundle) obj;
            if (bundle.getBoolean("isOpenWeappFial", false)) {
                f.azA().aZ(f.access$000(bundle.getString("sceneNote")), bundle.getInt("widgetState") + AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                AppMethodBeat.o(10683);
                return;
            }
            f.azA().aZ(bundle.getString("id"), bundle.getInt("widgetState"));
            AppMethodBeat.o(10683);
        }
    }

    public static class b {
        String appId = "";
        int fmr = 0;
        String hlE = "";
        LinkedList<Integer> hlF = new LinkedList();
        String query = "";

        public b(String str, String str2, int i, String str3) {
            AppMethodBeat.i(10684);
            this.hlE = str;
            this.appId = str2;
            this.fmr = i;
            this.query = str3;
            AppMethodBeat.o(10684);
        }
    }

    public f() {
        AppMethodBeat.i(10685);
        AppMethodBeat.o(10685);
    }

    static /* synthetic */ String access$000(String str) {
        AppMethodBeat.i(10690);
        String zU = zU(str);
        AppMethodBeat.o(10690);
        return zU;
    }

    static {
        AppMethodBeat.i(10691);
        AppMethodBeat.o(10691);
    }

    public static f azA() {
        return hlA;
    }

    public final boolean aZ(String str, int i) {
        AppMethodBeat.i(10686);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10686);
            return false;
        } else if (this.hlB.containsKey(str)) {
            switch (i) {
                case TXLiveConstants.PLAY_WARNING_RECONNECT /*2103*/:
                    j.azE().E(str, 628, 9);
                    break;
            }
            boolean add = ((b) this.hlB.get(str)).hlF.add(Integer.valueOf(i));
            AppMethodBeat.o(10686);
            return add;
        } else {
            ab.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", str);
            AppMethodBeat.o(10686);
            return false;
        }
    }

    public static void zT(String str) {
        AppMethodBeat.i(10687);
        Bundle bundle = new Bundle();
        String zU = zU(str);
        bundle.putString("id", zU);
        bundle.putInt("widgetState", 2109);
        com.tencent.mm.ipcinvoker.f.a(i.azC().zV(zU), bundle, a.class, null);
        AppMethodBeat.o(10687);
    }

    public static void n(int i, String str, String str2) {
        AppMethodBeat.i(10688);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOpenWeappFial", true);
        bundle.putInt("widgetState", i);
        bundle.putString("appid", str);
        bundle.putString("sceneNote", str2);
        com.tencent.mm.ipcinvoker.f.a(i.azC().zV(zU(str2)), bundle, a.class, null);
        AppMethodBeat.o(10688);
    }

    private static String zU(String str) {
        AppMethodBeat.i(10689);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(10689);
            return str2;
        }
        Matcher matcher = Pattern.compile(":widgetId=.*:").matcher(str);
        if (matcher.matches()) {
            str2 = matcher.group();
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.substring(str2.indexOf("=") + 1, str2.lastIndexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                AppMethodBeat.o(10689);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(10689);
        return str2;
    }
}
