package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.protocal.protobuf.cqs;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.q */
public final class C26851q {
    private static int hkt = -1;

    /* renamed from: a */
    public static void m42758a(cqs cqs, C19166k c19166k) {
        AppMethodBeat.m2504i(101890);
        if (c19166k != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - c19166k.hjf);
            ((C33458b) C37384e.m62986C(C33458b.class)).mo53944e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(c19166k.size), Integer.valueOf(cqs.computeSize()), Integer.valueOf(0), "", "", Integer.valueOf(C26851q.azp()), Integer.valueOf(C26851q.azq()));
        }
        AppMethodBeat.m2505o(101890);
    }

    /* renamed from: a */
    public static void m42757a(C26846b c26846b, int i) {
        AppMethodBeat.m2504i(101891);
        int currentTimeMillis = (int) (System.currentTimeMillis() - c26846b.hjf);
        ((C33458b) C37384e.m62986C(C33458b.class)).mo53944e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(c26846b.size), Integer.valueOf(i), Integer.valueOf(1), "", C5046bo.nullAsNil(c26846b.ctq), Integer.valueOf(C26851q.azp()), Integer.valueOf(C26851q.azq()));
        AppMethodBeat.m2505o(101891);
    }

    /* renamed from: a */
    public static void m42759a(String str, LinkedList<String> linkedList, long j, int i, int i2) {
        Object obj;
        AppMethodBeat.m2504i(101892);
        String str2 = "";
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            obj = (String) linkedList.get(0);
        } else {
            String obj2 = str2;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        ((C33458b) C37384e.m62986C(C33458b.class)).mo53944e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), str, obj2, Integer.valueOf(C26851q.azp()), Integer.valueOf(C26851q.azq()));
        AppMethodBeat.m2505o(101892);
    }

    /* renamed from: zM */
    public static String m42760zM(String str) {
        AppMethodBeat.m2504i(101893);
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        String group;
        if (matcher.find()) {
            group = matcher.group(1);
            AppMethodBeat.m2505o(101893);
            return group;
        }
        group = "";
        AppMethodBeat.m2505o(101893);
        return group;
    }

    private static int azp() {
        AppMethodBeat.m2504i(101894);
        int i;
        if (hkt >= 0) {
            i = hkt;
            AppMethodBeat.m2505o(101894);
            return i;
        }
        i = C5023at.getISPCode(C4996ah.getContext());
        hkt = i;
        AppMethodBeat.m2505o(101894);
        return i;
    }

    public static int azq() {
        AppMethodBeat.m2504i(101895);
        Context context = C4996ah.getContext();
        int i = 5;
        if (!C5023at.isConnected(context)) {
            i = 0;
        } else if (C5023at.is2G(context)) {
            i = 1;
        } else if (C5023at.is3G(context)) {
            i = 2;
        } else if (C5023at.is4G(context)) {
            i = 3;
        } else if (C5023at.isWifi(context)) {
            i = 4;
        }
        AppMethodBeat.m2505o(101895);
        return i;
    }
}
