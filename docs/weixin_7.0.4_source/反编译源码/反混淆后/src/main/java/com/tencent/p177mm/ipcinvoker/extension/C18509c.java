package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ipcinvoker.extension.c */
public final class C18509c {
    private static List<C18508a> eGw = new LinkedList();
    private static Map<String, C18508a> eGx = new HashMap();

    static {
        AppMethodBeat.m2504i(114085);
        AppMethodBeat.m2505o(114085);
    }

    /* renamed from: ar */
    public static C18508a m28815ar(Object obj) {
        AppMethodBeat.m2504i(114081);
        for (C18508a c18508a : eGw) {
            if (c18508a.mo20824aq(obj)) {
                AppMethodBeat.m2505o(114081);
                return c18508a;
            }
        }
        AppMethodBeat.m2505o(114081);
        return null;
    }

    /* renamed from: a */
    public static void m28814a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(114082);
        C18508a ar = C18509c.m28815ar(obj);
        if (ar != null) {
            ar.mo20823a(obj, parcel);
        }
        AppMethodBeat.m2505o(114082);
    }

    /* renamed from: a */
    public static void m28813a(C18508a c18508a) {
        AppMethodBeat.m2504i(114084);
        if (c18508a == null || eGw.contains(c18508a)) {
            AppMethodBeat.m2505o(114084);
            return;
        }
        eGx.put(c18508a.getClass().getName(), c18508a);
        eGw.add(c18508a);
        AppMethodBeat.m2505o(114084);
    }

    /* renamed from: a */
    public static Object m28812a(String str, Parcel parcel) {
        AppMethodBeat.m2504i(114083);
        C18508a c18508a = (C18508a) eGx.get(str);
        if (c18508a != null) {
            Object d = c18508a.mo20825d(parcel);
            AppMethodBeat.m2505o(114083);
            return d;
        }
        AppMethodBeat.m2505o(114083);
        return null;
    }
}
