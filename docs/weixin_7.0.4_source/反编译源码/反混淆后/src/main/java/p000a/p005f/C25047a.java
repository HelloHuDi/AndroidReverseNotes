package p000a.p005f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.lang.annotation.Annotation;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41377d;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, dWq = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
/* renamed from: a.f.a */
public final class C25047a {
    /* renamed from: a */
    public static final <T> Class<T> m39368a(C36663b<T> c36663b) {
        AppMethodBeat.m2504i(56243);
        C25052j.m39376p(c36663b, "receiver$0");
        Class dWH = ((C41377d) c36663b).dWH();
        if (dWH == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.m2505o(56243);
            throw c44941v;
        }
        AppMethodBeat.m2505o(56243);
        return dWH;
    }

    /* renamed from: b */
    public static final <T> Class<T> m39370b(C36663b<T> c36663b) {
        AppMethodBeat.m2504i(56244);
        C25052j.m39376p(c36663b, "receiver$0");
        Class dWH = ((C41377d) c36663b).dWH();
        if (!dWH.isPrimitive()) {
            String name = dWH.getName();
            if (name != null) {
                Class<T> cls;
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            cls = Integer.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            cls = Float.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            cls = Short.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            cls = Character.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            cls = Boolean.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            cls = Byte.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            cls = Long.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 399092968:
                        if (name.equals("java.lang.Void")) {
                            cls = Void.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            cls = Double.TYPE;
                            AppMethodBeat.m2505o(56244);
                            return cls;
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(56244);
            return null;
        } else if (dWH == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.m2505o(56244);
            throw c44941v;
        } else {
            AppMethodBeat.m2505o(56244);
            return dWH;
        }
    }

    /* renamed from: c */
    public static final <T> Class<T> m39371c(C36663b<T> c36663b) {
        AppMethodBeat.m2504i(56245);
        C25052j.m39376p(c36663b, "receiver$0");
        Class<T> dWH = ((C41377d) c36663b).dWH();
        C44941v c44941v;
        if (dWH.isPrimitive()) {
            String name = dWH.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            dWH = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            dWH = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            dWH = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            dWH = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            dWH = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            dWH = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                            dWH = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            dWH = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            dWH = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (dWH == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<T>");
                AppMethodBeat.m2505o(56245);
                throw c44941v;
            }
            AppMethodBeat.m2505o(56245);
        } else if (dWH == null) {
            c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.m2505o(56245);
            throw c44941v;
        } else {
            AppMethodBeat.m2505o(56245);
        }
        return dWH;
    }

    /* renamed from: aM */
    public static final <T> C36663b<T> m39369aM(Class<T> cls) {
        AppMethodBeat.m2504i(56246);
        C25052j.m39376p(cls, "receiver$0");
        C36663b aN = C44855v.m82055aN(cls);
        AppMethodBeat.m2505o(56246);
        return aN;
    }

    /* renamed from: a */
    public static final <T extends Annotation> C36663b<? extends T> m39367a(T t) {
        AppMethodBeat.m2504i(56247);
        C25052j.m39376p(t, "receiver$0");
        Class annotationType = t.annotationType();
        C25052j.m39375o(annotationType, "(this as java.lang.annot…otation).annotationType()");
        C36663b aM = C25047a.m39369aM(annotationType);
        if (aM == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
            AppMethodBeat.m2505o(56247);
            throw c44941v;
        }
        AppMethodBeat.m2505o(56247);
        return aM;
    }
}
