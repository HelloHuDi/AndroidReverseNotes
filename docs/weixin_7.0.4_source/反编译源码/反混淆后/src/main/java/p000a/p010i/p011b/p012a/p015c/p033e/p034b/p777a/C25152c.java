package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p000a.C37091y;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C36938b;
import p000a.p009h.C36938b.C36939a;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.e.b.a.c */
public final class C25152c {
    public static final C25152c Bym = new C25152c();
    private static final Map<String, String> map;

    /* renamed from: a.i.b.a.c.e.b.a.c$a */
    static final class C8170a extends C25053k implements C31591m<String, String, C37091y> {
        final /* synthetic */ Map Byn;

        C8170a(Map map) {
            this.Byn = map;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(121303);
            mo17962iW((String) obj, (String) obj2);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(121303);
            return c37091y;
        }

        /* renamed from: iW */
        public final void mo17962iW(String str, String str2) {
            AppMethodBeat.m2504i(121304);
            C25052j.m39376p(str, "kotlinSimpleName");
            C25052j.m39376p(str2, "javaInternalName");
            this.Byn.put("kotlin/".concat(String.valueOf(str)), "L" + str2 + ';');
            AppMethodBeat.m2505o(121304);
        }
    }

    static {
        int i;
        AppMethodBeat.m2504i(121306);
        Map linkedHashMap = new LinkedHashMap();
        List listOf = C7987l.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", QLog.TAG_REPORTLEVEL_DEVELOPER);
        C36938b g = C7987l.m14174g(listOf);
        C25052j.m39376p(g, "receiver$0");
        C25052j.m39376p(Integer.valueOf(2), "step");
        C36939a c36939a = C36938b.AVL;
        int i2 = g.AVJ;
        int i3 = g.AVK;
        if (g.hzv > 0) {
            i = 2;
        } else {
            i = -2;
        }
        C36938b aP = C36939a.m61713aP(i2, i3, i);
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
        C8170a c8170a = new C8170a(linkedHashMap);
        c8170a.mo17962iW("Any", "java/lang/Object");
        c8170a.mo17962iW("Nothing", "java/lang/Void");
        c8170a.mo17962iW("Annotation", "java/lang/annotation/Annotation");
        for (String str : C7987l.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            c8170a.mo17962iW(str, "java/lang/".concat(String.valueOf(str)));
        }
        for (String str2 : C7987l.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            c8170a.mo17962iW("collections/".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
            c8170a.mo17962iW("collections/Mutable".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
        }
        c8170a.mo17962iW("collections/Iterable", "java/lang/Iterable");
        c8170a.mo17962iW("collections/MutableIterable", "java/lang/Iterable");
        c8170a.mo17962iW("collections/Map.Entry", "java/util/Map$Entry");
        c8170a.mo17962iW("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (i = 0; i <= 22; i++) {
            c8170a.mo17962iW("Function".concat(String.valueOf(i)), "kotlin/jvm/functions/Function".concat(String.valueOf(i)));
            c8170a.mo17962iW("reflect/KFunction".concat(String.valueOf(i)), "kotlin/reflect/KFunction");
        }
        for (String str22 : C7987l.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            c8170a.mo17962iW(str22 + ".Companion", "kotlin/jvm/internal/" + str22 + "CompanionObject");
        }
        map = linkedHashMap;
        AppMethodBeat.m2505o(121306);
    }

    private C25152c() {
    }

    public static final String avV(String str) {
        AppMethodBeat.m2504i(121305);
        C25052j.m39376p(str, "classId");
        String str2 = (String) map.get(str);
        if (str2 == null) {
            str2 = "L" + C6163u.m9834a(str, '.', '$') + ';';
        }
        AppMethodBeat.m2505o(121305);
        return str2;
    }
}
