package a.i.b.a.c.e.b.a;

import a.a.l;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.h.b;
import a.k.u;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static final c Bym = new c();
    private static final Map<String, String> map;

    static final class a extends k implements m<String, String, y> {
        final /* synthetic */ Map Byn;

        a(Map map) {
            this.Byn = map;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(121303);
            iW((String) obj, (String) obj2);
            y yVar = y.AUy;
            AppMethodBeat.o(121303);
            return yVar;
        }

        public final void iW(String str, String str2) {
            AppMethodBeat.i(121304);
            j.p(str, "kotlinSimpleName");
            j.p(str2, "javaInternalName");
            this.Byn.put("kotlin/".concat(String.valueOf(str)), "L" + str2 + ';');
            AppMethodBeat.o(121304);
        }
    }

    static {
        int i;
        AppMethodBeat.i(121306);
        Map linkedHashMap = new LinkedHashMap();
        List listOf = l.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", QLog.TAG_REPORTLEVEL_DEVELOPER);
        b g = l.g(listOf);
        j.p(g, "receiver$0");
        j.p(Integer.valueOf(2), "step");
        a.h.b.a aVar = b.AVL;
        int i2 = g.AVJ;
        int i3 = g.AVK;
        if (g.hzv > 0) {
            i = 2;
        } else {
            i = -2;
        }
        b aP = a.h.b.a.aP(i2, i3, i);
        i = aP.AVJ;
        i3 = aP.AVK;
        int i4 = aP.hzv;
        if (i4 <= 0 ? i < i3 : i > i3) {
            while (true) {
                i2 = i;
                linkedHashMap.put("kotlin/" + ((String) listOf.get(i2)), listOf.get(i2 + 1));
                linkedHashMap.put("kotlin/" + ((String) listOf.get(i2)) + "Array", "[" + ((String) listOf.get(i2 + 1)));
                if (i2 == i3) {
                    break;
                }
                i = i2 + i4;
            }
        }
        linkedHashMap.put("kotlin/Unit", "V");
        a aVar2 = new a(linkedHashMap);
        aVar2.iW("Any", "java/lang/Object");
        aVar2.iW("Nothing", "java/lang/Void");
        aVar2.iW("Annotation", "java/lang/annotation/Annotation");
        for (String str : l.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            aVar2.iW(str, "java/lang/".concat(String.valueOf(str)));
        }
        for (String str2 : l.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            aVar2.iW("collections/".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
            aVar2.iW("collections/Mutable".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
        }
        aVar2.iW("collections/Iterable", "java/lang/Iterable");
        aVar2.iW("collections/MutableIterable", "java/lang/Iterable");
        aVar2.iW("collections/Map.Entry", "java/util/Map$Entry");
        aVar2.iW("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (i = 0; i <= 22; i++) {
            aVar2.iW("Function".concat(String.valueOf(i)), "kotlin/jvm/functions/Function".concat(String.valueOf(i)));
            aVar2.iW("reflect/KFunction".concat(String.valueOf(i)), "kotlin/reflect/KFunction");
        }
        for (String str22 : l.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            aVar2.iW(str22 + ".Companion", "kotlin/jvm/internal/" + str22 + "CompanionObject");
        }
        map = linkedHashMap;
        AppMethodBeat.o(121306);
    }

    private c() {
    }

    public static final String avV(String str) {
        AppMethodBeat.i(121305);
        j.p(str, "classId");
        String str2 = (String) map.get(str);
        if (str2 == null) {
            str2 = "L" + u.a(str, '.', '$') + ';';
        }
        AppMethodBeat.o(121305);
        return str2;
    }
}
