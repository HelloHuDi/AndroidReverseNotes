package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q {
    private static int hkt = -1;

    public static void a(cqs cqs, k kVar) {
        AppMethodBeat.i(101890);
        if (kVar != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - kVar.hjf);
            ((b) e.C(b.class)).e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(kVar.size), Integer.valueOf(cqs.computeSize()), Integer.valueOf(0), "", "", Integer.valueOf(azp()), Integer.valueOf(azq()));
        }
        AppMethodBeat.o(101890);
    }

    public static void a(b bVar, int i) {
        AppMethodBeat.i(101891);
        int currentTimeMillis = (int) (System.currentTimeMillis() - bVar.hjf);
        ((b) e.C(b.class)).e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(bVar.size), Integer.valueOf(i), Integer.valueOf(1), "", bo.nullAsNil(bVar.ctq), Integer.valueOf(azp()), Integer.valueOf(azq()));
        AppMethodBeat.o(101891);
    }

    public static void a(String str, LinkedList<String> linkedList, long j, int i, int i2) {
        Object obj;
        AppMethodBeat.i(101892);
        String str2 = "";
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            obj = (String) linkedList.get(0);
        } else {
            String obj2 = str2;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        ((b) e.C(b.class)).e(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), str, obj2, Integer.valueOf(azp()), Integer.valueOf(azq()));
        AppMethodBeat.o(101892);
    }

    public static String zM(String str) {
        AppMethodBeat.i(101893);
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        String group;
        if (matcher.find()) {
            group = matcher.group(1);
            AppMethodBeat.o(101893);
            return group;
        }
        group = "";
        AppMethodBeat.o(101893);
        return group;
    }

    private static int azp() {
        AppMethodBeat.i(101894);
        int i;
        if (hkt >= 0) {
            i = hkt;
            AppMethodBeat.o(101894);
            return i;
        }
        i = at.getISPCode(ah.getContext());
        hkt = i;
        AppMethodBeat.o(101894);
        return i;
    }

    public static int azq() {
        AppMethodBeat.i(101895);
        Context context = ah.getContext();
        int i = 5;
        if (!at.isConnected(context)) {
            i = 0;
        } else if (at.is2G(context)) {
            i = 1;
        } else if (at.is3G(context)) {
            i = 2;
        } else if (at.is4G(context)) {
            i = 3;
        } else if (at.isWifi(context)) {
            i = 4;
        }
        AppMethodBeat.o(101895);
        return i;
    }
}
