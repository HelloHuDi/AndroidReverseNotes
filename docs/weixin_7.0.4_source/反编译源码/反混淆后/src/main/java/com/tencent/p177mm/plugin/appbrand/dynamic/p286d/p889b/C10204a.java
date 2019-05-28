package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C37936z;
import com.tencent.p177mm.p230g.p232b.p233a.C18455cy;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a.C26860b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a.C26861c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a.C42420d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a.C42421e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C38202a;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.a */
public final class C10204a {
    private static Map<String, Map<Integer, C42421e>> hnt;
    private static final Pattern hnu = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");

    static {
        AppMethodBeat.m2504i(10881);
        AppMethodBeat.m2505o(10881);
    }

    /* renamed from: bb */
    public static C42421e m17844bb(String str, int i) {
        HashMap hashMap;
        Map map;
        AppMethodBeat.m2504i(10878);
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
        C42421e c42421e = (C42421e) map.get(Integer.valueOf(i));
        if (c42421e == null) {
            switch (i) {
                case 0:
                    c42421e = new C42420d();
                    break;
                case 1:
                    c42421e = new C26860b();
                    break;
                case 2:
                    c42421e = new C26861c();
                    break;
                default:
                    c42421e = new C26861c();
                    break;
            }
            map.put(Integer.valueOf(i), c42421e);
        }
        AppMethodBeat.m2505o(10878);
        return c42421e;
    }

    /* renamed from: Ah */
    public static void m17842Ah(String str) {
        AppMethodBeat.m2504i(10879);
        if (hnt == null) {
            AppMethodBeat.m2505o(10879);
            return;
        }
        Map map = (Map) hnt.get(str);
        if (map != null) {
            for (C42421e reset : map.values()) {
                reset.reset();
            }
            map.clear();
        }
        AppMethodBeat.m2505o(10879);
    }

    /* renamed from: bN */
    public static void m17843bN(final String str, final String str2) {
        AppMethodBeat.m2504i(10880);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(10880);
            return;
        }
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(10877);
                Matcher matcher = C10204a.hnu.matcher(str2);
                if (matcher.find()) {
                    C4990ab.m7417i("DrawCanvasMgr", "invalid draw data %s", str2);
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
                    C10211f.azA();
                    String str = str;
                    String substring = str2.substring(i, end);
                    if (!(str == null || str.length() == 0)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", str);
                        bundle.putInt("widgetState", 2113);
                        C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle, C10213a.class, null);
                    }
                    IPCDynamicPageView Ak = C38202a.aAb().mo60935Ak(str);
                    if (!(Ak == null || Ak.hpp == null)) {
                        C37936z c37936z = (C37936z) Ak.hpp.mo53363px("onWidgetDrawDataInvalid");
                        if (c37936z != null) {
                            c37936z.mo9595pv(substring);
                        }
                    }
                    new C18455cy().mo33728hX("").mo33729hY(C18652u.m29154pr(str)).mo33730hZ(C18178q.encode(substring)).ajK();
                }
                AppMethodBeat.m2505o(10877);
            }
        }, "onDrawFrame");
        AppMethodBeat.m2505o(10880);
    }
}
