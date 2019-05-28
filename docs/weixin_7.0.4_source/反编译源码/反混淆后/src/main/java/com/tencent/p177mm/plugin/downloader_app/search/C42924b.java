package com.tencent.p177mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.downloader_app.search.b */
public final class C42924b {
    String appId;
    String iconUrl;
    String jumpUrl;
    String kPJ;
    String kPK;
    List<String> kPL;
    int position;
    long size;
    int state;
    int type;

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(136193);
        boolean equals;
        if (!(obj instanceof C42924b) || ((C42924b) obj).kPJ == null) {
            equals = super.equals(obj);
            AppMethodBeat.m2505o(136193);
            return equals;
        }
        equals = ((C42924b) obj).kPJ.equals(this.kPJ);
        AppMethodBeat.m2505o(136193);
        return equals;
    }

    /* renamed from: dD */
    public static List<C42924b> m76229dD(Context context) {
        AppMethodBeat.m2504i(136194);
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(136194);
            return arrayList;
        }
        int i = 0;
        for (String str : string.split(";")) {
            if (!C5046bo.isNullOrNil(str)) {
                C42924b c42924b = new C42924b();
                c42924b.type = 2;
                c42924b.kPJ = new String(Base64.decode(str, 0));
                i++;
                c42924b.position = i;
                arrayList.add(c42924b);
            }
        }
        if (!C5046bo.m7548ek(arrayList)) {
            C42924b c42924b2 = new C42924b();
            c42924b2.type = 1;
            arrayList.add(0, c42924b2);
        }
        AppMethodBeat.m2505o(136194);
        return arrayList;
    }

    /* renamed from: al */
    public static void m76227al(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(136195);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136195);
            return;
        }
        C42924b.m76228am(context, str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("search_history_href", 0);
        String string = sharedPreferences.getString("search_history_list", "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Base64.encodeToString(str.getBytes(), 0));
        stringBuffer.append(";");
        stringBuffer.append(string);
        String[] split = stringBuffer.toString().split(";");
        stringBuffer.setLength(0);
        while (i < split.length && i < 10) {
            stringBuffer.append(split[i]);
            stringBuffer.append(";");
            i++;
        }
        sharedPreferences.edit().putString("search_history_list", stringBuffer.toString()).commit();
        AppMethodBeat.m2505o(136195);
    }

    /* renamed from: am */
    public static void m76228am(Context context, String str) {
        AppMethodBeat.m2504i(136196);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136196);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("search_history_href", 0);
        sharedPreferences.edit().putString("search_history_list", sharedPreferences.getString("search_history_list", "").replace(Base64.encodeToString(str.getBytes(), 0) + ";", "")).commit();
        AppMethodBeat.m2505o(136196);
    }
}
