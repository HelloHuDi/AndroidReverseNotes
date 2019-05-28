package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class b {
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
        AppMethodBeat.i(136193);
        boolean equals;
        if (!(obj instanceof b) || ((b) obj).kPJ == null) {
            equals = super.equals(obj);
            AppMethodBeat.o(136193);
            return equals;
        }
        equals = ((b) obj).kPJ.equals(this.kPJ);
        AppMethodBeat.o(136193);
        return equals;
    }

    public static List<b> dD(Context context) {
        AppMethodBeat.i(136194);
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(136194);
            return arrayList;
        }
        int i = 0;
        for (String str : string.split(";")) {
            if (!bo.isNullOrNil(str)) {
                b bVar = new b();
                bVar.type = 2;
                bVar.kPJ = new String(Base64.decode(str, 0));
                i++;
                bVar.position = i;
                arrayList.add(bVar);
            }
        }
        if (!bo.ek(arrayList)) {
            b bVar2 = new b();
            bVar2.type = 1;
            arrayList.add(0, bVar2);
        }
        AppMethodBeat.o(136194);
        return arrayList;
    }

    public static void al(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(136195);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136195);
            return;
        }
        am(context, str);
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
        AppMethodBeat.o(136195);
    }

    public static void am(Context context, String str) {
        AppMethodBeat.i(136196);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136196);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("search_history_href", 0);
        sharedPreferences.edit().putString("search_history_list", sharedPreferences.getString("search_history_list", "").replace(Base64.encodeToString(str.getBytes(), 0) + ";", "")).commit();
        AppMethodBeat.o(136196);
    }
}
