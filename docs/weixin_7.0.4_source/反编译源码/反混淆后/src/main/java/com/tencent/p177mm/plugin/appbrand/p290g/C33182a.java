package com.tencent.p177mm.plugin.appbrand.p290g;

import android.support.p056d.C0252a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.g.a */
final class C33182a {
    static final String[] huC;

    static {
        AppMethodBeat.m2504i(65351);
        LinkedList linkedList = new LinkedList();
        for (Field field : C0252a.class.getDeclaredFields()) {
            try {
                if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getName().startsWith("TAG_")) {
                    linkedList.add((String) field.get(null));
                }
            } catch (Exception e) {
            }
        }
        huC = (String[]) linkedList.toArray(new String[linkedList.size()]);
        AppMethodBeat.m2505o(65351);
    }

    /* renamed from: a */
    static void m54272a(C0252a c0252a, C0252a c0252a2) {
        AppMethodBeat.m2504i(65350);
        for (String str : huC) {
            String attribute = c0252a.getAttribute(str);
            if (attribute != null) {
                c0252a2.setAttribute(str, attribute);
            }
        }
        c0252a2.saveAttributes();
        AppMethodBeat.m2505o(65350);
    }
}
