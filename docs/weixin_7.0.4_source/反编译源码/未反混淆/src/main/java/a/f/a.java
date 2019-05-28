package a.f;

import a.f.b.d;
import a.f.b.j;
import a.i.b;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.lang.annotation.Annotation;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, dWq = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        AppMethodBeat.i(56243);
        j.p(bVar, "receiver$0");
        Class dWH = ((d) bVar).dWH();
        if (dWH == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(56243);
            throw vVar;
        }
        AppMethodBeat.o(56243);
        return dWH;
    }

    public static final <T> Class<T> b(b<T> bVar) {
        AppMethodBeat.i(56244);
        j.p(bVar, "receiver$0");
        Class dWH = ((d) bVar).dWH();
        if (!dWH.isPrimitive()) {
            String name = dWH.getName();
            if (name != null) {
                Class<T> cls;
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            cls = Integer.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            cls = Float.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            cls = Short.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            cls = Character.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            cls = Boolean.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            cls = Byte.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            cls = Long.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 399092968:
                        if (name.equals("java.lang.Void")) {
                            cls = Void.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            cls = Double.TYPE;
                            AppMethodBeat.o(56244);
                            return cls;
                        }
                        break;
                }
            }
            AppMethodBeat.o(56244);
            return null;
        } else if (dWH == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(56244);
            throw vVar;
        } else {
            AppMethodBeat.o(56244);
            return dWH;
        }
    }

    public static final <T> Class<T> c(b<T> bVar) {
        AppMethodBeat.i(56245);
        j.p(bVar, "receiver$0");
        Class<T> dWH = ((d) bVar).dWH();
        v vVar;
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
                vVar = new v("null cannot be cast to non-null type java.lang.Class<T>");
                AppMethodBeat.o(56245);
                throw vVar;
            }
            AppMethodBeat.o(56245);
        } else if (dWH == null) {
            vVar = new v("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(56245);
            throw vVar;
        } else {
            AppMethodBeat.o(56245);
        }
        return dWH;
    }

    public static final <T> b<T> aM(Class<T> cls) {
        AppMethodBeat.i(56246);
        j.p(cls, "receiver$0");
        b aN = a.f.b.v.aN(cls);
        AppMethodBeat.o(56246);
        return aN;
    }

    public static final <T extends Annotation> b<? extends T> a(T t) {
        AppMethodBeat.i(56247);
        j.p(t, "receiver$0");
        Class annotationType = t.annotationType();
        j.o(annotationType, "(this as java.lang.annot…otation).annotationType()");
        b aM = aM(annotationType);
        if (aM == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
            AppMethodBeat.o(56247);
            throw vVar;
        }
        AppMethodBeat.o(56247);
        return aM;
    }
}
