package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> eGw = new LinkedList();
    private static Map<String, a> eGx = new HashMap();

    static {
        AppMethodBeat.i(114085);
        AppMethodBeat.o(114085);
    }

    public static a ar(Object obj) {
        AppMethodBeat.i(114081);
        for (a aVar : eGw) {
            if (aVar.aq(obj)) {
                AppMethodBeat.o(114081);
                return aVar;
            }
        }
        AppMethodBeat.o(114081);
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(114082);
        a ar = ar(obj);
        if (ar != null) {
            ar.a(obj, parcel);
        }
        AppMethodBeat.o(114082);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(114084);
        if (aVar == null || eGw.contains(aVar)) {
            AppMethodBeat.o(114084);
            return;
        }
        eGx.put(aVar.getClass().getName(), aVar);
        eGw.add(aVar);
        AppMethodBeat.o(114084);
    }

    public static Object a(String str, Parcel parcel) {
        AppMethodBeat.i(114083);
        a aVar = (a) eGx.get(str);
        if (aVar != null) {
            Object d = aVar.d(parcel);
            AppMethodBeat.o(114083);
            return d;
        }
        AppMethodBeat.o(114083);
        return null;
    }
}
