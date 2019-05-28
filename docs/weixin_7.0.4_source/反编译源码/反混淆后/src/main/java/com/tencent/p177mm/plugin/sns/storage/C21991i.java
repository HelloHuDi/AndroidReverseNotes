package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.tencent.mm.plugin.sns.storage.i */
public final class C21991i {
    /* renamed from: kw */
    public static boolean m33619kw(long j) {
        int i = 2;
        int i2 = 0;
        AppMethodBeat.m2504i(37838);
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(37838);
            return false;
        }
        boolean z;
        boolean z2;
        String[] split = ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        if (split.length <= 0 || !C5046bo.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !C5046bo.getBoolean(split[1], false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        ArrayList arrayList = new ArrayList();
        while (i < split.length) {
            long j2 = C5046bo.getLong(split[i], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
            i++;
        }
        if (kD.cqu().xfI.wbJ == 15) {
            if (z) {
                AppMethodBeat.m2505o(37838);
                return false;
            }
            z = true;
        } else if (kD.cqu().xfI.wbJ != 1) {
            AppMethodBeat.m2505o(37838);
            return false;
        } else if (z2) {
            AppMethodBeat.m2505o(37838);
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
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        C21991i.m33618h(Long.valueOf(j));
        AppMethodBeat.m2505o(37838);
        return true;
    }

    /* renamed from: kx */
    public static void m33620kx(long j) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        AppMethodBeat.m2504i(37839);
        String[] split = ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        if (split.length <= 0 || !C5046bo.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !C5046bo.getBoolean(split[1], false)) {
            z2 = false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < split.length; i2++) {
            long j2 = C5046bo.getLong(split[i2], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        arrayList.remove(Long.valueOf(j));
        Collections.reverse(arrayList);
        C21991i.m33618h(arrayList.size() > 0 ? (Long) arrayList.get(0) : null);
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        while (i < arrayList.size()) {
            append.append("&").append(arrayList.get(i));
            i++;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        AppMethodBeat.m2505o(37839);
    }

    /* renamed from: h */
    public static void m33618h(Long l) {
        AppMethodBeat.m2504i(37840);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, (Object) l);
        AppMethodBeat.m2505o(37840);
    }
}
