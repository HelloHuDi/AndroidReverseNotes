package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static Map<String, Map<Integer, e>> hnt;
    private static final Pattern hnu = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");

    static {
        AppMethodBeat.i(10881);
        AppMethodBeat.o(10881);
    }

    public static e bb(String str, int i) {
        HashMap hashMap;
        Map map;
        AppMethodBeat.i(10878);
        if (hnt == null) {
            hashMap = new HashMap();
            hnt = hashMap;
            hashMap.put(str, new HashMap());
        }
        Map map2 = (Map) hnt.get(str);
        if (map2 == null) {
            hashMap = new HashMap();
            hnt.put(str, hashMap);
            map = hashMap;
        } else {
            map = map2;
        }
        e eVar = (e) map.get(Integer.valueOf(i));
        if (eVar == null) {
            switch (i) {
                case 0:
                    eVar = new d();
                    break;
                case 1:
                    eVar = new b();
                    break;
                case 2:
                    eVar = new c();
                    break;
                default:
                    eVar = new c();
                    break;
            }
            map.put(Integer.valueOf(i), eVar);
        }
        AppMethodBeat.o(10878);
        return eVar;
    }

    public static void Ah(String str) {
        AppMethodBeat.i(10879);
        if (hnt == null) {
            AppMethodBeat.o(10879);
            return;
        }
        Map map = (Map) hnt.get(str);
        if (map != null) {
            for (e reset : map.values()) {
                reset.reset();
            }
            map.clear();
        }
        AppMethodBeat.o(10879);
    }

    public static void bN(final String str, final String str2) {
        AppMethodBeat.i(10880);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(10880);
            return;
        }
        com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(10877);
                Matcher matcher = a.hnu.matcher(str2);
                if (matcher.find()) {
                    ab.i("DrawCanvasMgr", "invalid draw data %s", str2);
                    int start = matcher.start();
                    int end = matcher.end();
                    if (start > 30) {
                        i = start - 30;
                    }
                    if (end < str2.length() - 30) {
                        end += 30;
                    } else {
                        end = str2.length();
                    }
                    f.azA();
                    String str = str;
                    String substring = str2.substring(i, end);
                    if (!(str == null || str.length() == 0)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", str);
                        bundle.putInt("widgetState", 2113);
                        com.tencent.mm.ipcinvoker.f.a(i.azC().zV(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                    }
                    IPCDynamicPageView Ak = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().Ak(str);
                    if (!(Ak == null || Ak.hpp == null)) {
                        z zVar = (z) Ak.hpp.px("onWidgetDrawDataInvalid");
                        if (zVar != null) {
                            zVar.pv(substring);
                        }
                    }
                    new cy().hX("").hY(u.pr(str)).hZ(q.encode(substring)).ajK();
                }
                AppMethodBeat.o(10877);
            }
        }, "onDrawFrame");
        AppMethodBeat.o(10880);
    }
}
