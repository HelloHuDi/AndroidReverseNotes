package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

final class a {
    static final String[] huC;

    static {
        AppMethodBeat.i(65351);
        LinkedList linkedList = new LinkedList();
        for (Field field : android.support.d.a.class.getDeclaredFields()) {
            try {
                if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getName().startsWith("TAG_")) {
                    linkedList.add((String) field.get(null));
                }
            } catch (Exception e) {
            }
        }
        huC = (String[]) linkedList.toArray(new String[linkedList.size()]);
        AppMethodBeat.o(65351);
    }

    static void a(android.support.d.a aVar, android.support.d.a aVar2) {
        AppMethodBeat.i(65350);
        for (String str : huC) {
            String attribute = aVar.getAttribute(str);
            if (attribute != null) {
                aVar2.setAttribute(str, attribute);
            }
        }
        aVar2.saveAttributes();
        AppMethodBeat.o(65350);
    }
}
