package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import java.util.Collections;

public final class i {
    public static boolean kw(long j) {
        int i = 2;
        int i2 = 0;
        AppMethodBeat.i(37838);
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(37838);
            return false;
        }
        boolean z;
        boolean z2;
        String[] split = ((String) g.RP().Ry().get(a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        if (split.length <= 0 || !bo.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !bo.getBoolean(split[1], false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        ArrayList arrayList = new ArrayList();
        while (i < split.length) {
            long j2 = bo.getLong(split[i], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
            i++;
        }
        if (kD.cqu().xfI.wbJ == 15) {
            if (z) {
                AppMethodBeat.o(37838);
                return false;
            }
            z = true;
        } else if (kD.cqu().xfI.wbJ != 1) {
            AppMethodBeat.o(37838);
            return false;
        } else if (z2) {
            AppMethodBeat.o(37838);
            return false;
        } else {
            z2 = true;
        }
        if (!arrayList.contains(Long.valueOf(j))) {
            arrayList.add(Long.valueOf(j));
        }
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        while (i2 < arrayList.size()) {
            append.append("&").append(arrayList.get(i2));
            i2++;
        }
        g.RP().Ry().set(a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        h(Long.valueOf(j));
        AppMethodBeat.o(37838);
        return true;
    }

    public static void kx(long j) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        AppMethodBeat.i(37839);
        String[] split = ((String) g.RP().Ry().get(a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        if (split.length <= 0 || !bo.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !bo.getBoolean(split[1], false)) {
            z2 = false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < split.length; i2++) {
            long j2 = bo.getLong(split[i2], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        arrayList.remove(Long.valueOf(j));
        Collections.reverse(arrayList);
        h(arrayList.size() > 0 ? (Long) arrayList.get(0) : null);
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        while (i < arrayList.size()) {
            append.append("&").append(arrayList.get(i));
            i++;
        }
        g.RP().Ry().set(a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        AppMethodBeat.o(37839);
    }

    public static void h(Long l) {
        AppMethodBeat.i(37840);
        g.RP().Ry().set(a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, (Object) l);
        AppMethodBeat.o(37840);
    }
}
