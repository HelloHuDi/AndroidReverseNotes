package a.i.b.a;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ai;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.az;
import a.i.b.a.c.d.a.o;
import a.i.k;
import a.k.i;
import a.l;
import a.m;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 <*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004;<=>B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\n\u00102\u001a\u0004\u0018\u00010\u0015H\u0004J\u0013\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00107\u001a\u0004\u0018\u00010\nH\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0014\u0010)\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010(R\u0013\u0010,\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00100¨\u0006?"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflect-api"})
public abstract class s<R> extends e<R> implements k<R> {
    private static final Object AXZ = new Object();
    public static final b AYa = new b();
    private final a.i.b.a.z.a<Field> AXX;
    private final a.i.b.a.z.a<ah> AXY;
    final i AXs;
    final Object AXt;
    final String name;
    final String signature;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflect-api"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    public static abstract class c<R> extends a<R, R> implements a.i.k.a<R> {
        static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), v.a(new t(v.aN(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final a.i.b.a.z.a AWG = z.a(null, new b(this));
        private final a.i.b.a.z.a AXq = z.a(null, new a(this));

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
        static final class b extends a.f.b.k implements a.f.a.a<ai> {
            final /* synthetic */ c AYb;

            b(c cVar) {
                this.AYb = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118858);
                Object dZI = this.AYb.dXg().dWT().dZI();
                if (dZI == null) {
                    ah dXp = this.AYb.dXg().dWT();
                    a.i.b.a.c.b.a.g.a aVar = g.BfJ;
                    dZI = a.i.b.a.c.i.c.a(dXp, a.i.b.a.c.b.a.g.a.eai());
                }
                AppMethodBeat.o(118858);
                return dZI;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<a.i.b.a.a.d<?>> {
            final /* synthetic */ c AYb;

            a(c cVar) {
                this.AYb = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118857);
                a.i.b.a.a.d a = t.a(this.AYb, true);
                AppMethodBeat.o(118857);
                return a;
            }
        }

        public final /* synthetic */ a.i.b.a.c.b.b dWT() {
            return dXr();
        }

        public final /* synthetic */ ag dXq() {
            return dXr();
        }

        public final String getName() {
            return "<get-" + dXg().name + '>';
        }

        private ai dXr() {
            return (ai) this.AWG.invoke();
        }

        public final a.i.b.a.a.d<?> dWU() {
            return (a.i.b.a.a.d) this.AXq.invoke();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<ah> {
        final /* synthetic */ s AYd;

        e(s sVar) {
            this.AYd = sVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            i jVar;
            int i = 0;
            AppMethodBeat.i(118861);
            i iVar = this.AYd.AXs;
            String str = this.AYd.name;
            String str2 = this.AYd.signature;
            j.p(str, "name");
            j.p(str2, "signature");
            a.k.k kVar = i.AXf;
            CharSequence charSequence = str2;
            j.p(charSequence, "input");
            Matcher matcher = kVar.BPf.matcher(charSequence);
            j.o(matcher, "nativePattern.matcher(input)");
            if (matcher.matches()) {
                jVar = new a.k.j(matcher, charSequence);
            } else {
                jVar = null;
            }
            Throwable xVar;
            if (jVar != null) {
                String str3 = (String) jVar.ekN().BOX.ekM().get(1);
                ah SJ = iVar.SJ(Integer.parseInt(str3));
                if (SJ == null) {
                    xVar = new x("Local property #" + str3 + " not found in " + iVar.dWH());
                    AppMethodBeat.o(118861);
                    throw xVar;
                }
                AppMethodBeat.o(118861);
                return SJ;
            }
            ah ahVar;
            a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
            j.o(avX, "Name.identifier(name)");
            Collection arrayList = new ArrayList();
            for (Object next : iVar.a(avX)) {
                ahVar = (ah) next;
                ad adVar = ad.AYC;
                if (j.j(ad.c(ahVar).pq(), str2)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (list.isEmpty()) {
                xVar = new x("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + iVar);
                AppMethodBeat.o(118861);
                throw xVar;
            } else if (list.size() != 1) {
                Map linkedHashMap = new LinkedHashMap();
                for (Object next2 : list) {
                    az dYf = ((ah) next2).dYf();
                    ArrayList arrayList2 = linkedHashMap.get(dYf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(dYf, arrayList2);
                    }
                    arrayList2.add(next2);
                }
                Comparator comparator = f.AXp;
                j.p(linkedHashMap, "receiver$0");
                j.p(comparator, "comparator");
                TreeMap treeMap = new TreeMap(comparator);
                treeMap.putAll(linkedHashMap);
                Collection values = treeMap.values();
                j.o(values, "properties\n             …                }).values");
                List list2 = (List) a.a.t.g(values);
                if (list2.size() == 1) {
                    j.o(list2, "mostVisibleProperties");
                    ahVar = (ah) a.a.t.fJ(list2);
                    AppMethodBeat.o(118861);
                    return ahVar;
                }
                avX = a.i.b.a.c.f.f.avX(str);
                j.o(avX, "Name.identifier(name)");
                String a = a.a.t.a((Iterable) iVar.a(avX), (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, (a.f.a.b) e.AXo, 30);
                StringBuilder append = new StringBuilder("Property '").append(str).append("' (JVM signature: ").append(str2).append(") not resolved in ").append(iVar).append(':');
                if (a.length() == 0) {
                    i = 1;
                }
                xVar = new x(append.append(i != 0 ? " no members found" : IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(a))).toString());
                AppMethodBeat.o(118861);
                throw xVar;
            } else {
                ahVar = (ah) a.a.t.fN(list);
                AppMethodBeat.o(118861);
                return ahVar;
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflect-api"})
    public static abstract class a<PropertyType, ReturnType> extends e<ReturnType> implements a.i.e<ReturnType> {
        public abstract s<PropertyType> dXg();

        public abstract ag dXq();

        public final i dWV() {
            return dXg().AXs;
        }

        public final boolean isBound() {
            return dXg().isBound();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    public static abstract class d<R> extends a<R, y> implements a.i.f.a<R> {
        static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), v.a(new t(v.aN(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final a.i.b.a.z.a AWG = z.a(null, new b(this));
        private final a.i.b.a.z.a AXq = z.a(null, new a(this));

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
        static final class b extends a.f.b.k implements a.f.a.a<aj> {
            final /* synthetic */ d AYc;

            b(d dVar) {
                this.AYc = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118860);
                Object dZJ = this.AYc.dXg().dWT().dZJ();
                if (dZJ == null) {
                    ah dXp = this.AYc.dXg().dWT();
                    a.i.b.a.c.b.a.g.a aVar = g.BfJ;
                    g eai = a.i.b.a.c.b.a.g.a.eai();
                    a.i.b.a.c.b.a.g.a aVar2 = g.BfJ;
                    dZJ = a.i.b.a.c.i.c.a(dXp, eai, a.i.b.a.c.b.a.g.a.eai());
                }
                AppMethodBeat.o(118860);
                return dZJ;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<a.i.b.a.a.d<?>> {
            final /* synthetic */ d AYc;

            a(d dVar) {
                this.AYc = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118859);
                a.i.b.a.a.d a = t.a(this.AYc, false);
                AppMethodBeat.o(118859);
                return a;
            }
        }

        public final /* synthetic */ a.i.b.a.c.b.b dWT() {
            return dXs();
        }

        public final /* synthetic */ ag dXq() {
            return dXs();
        }

        public final String getName() {
            return "<set-" + dXg().name + '>';
        }

        private aj dXs() {
            return (aj) this.AWG.invoke();
        }

        public final a.i.b.a.a.d<?> dWU() {
            return (a.i.b.a.a.d) this.AXq.invoke();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a<Field> {
        final /* synthetic */ s AYd;

        f(s sVar) {
            this.AYd = sVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118862);
            Field dXt = dXt();
            AppMethodBeat.o(118862);
            return dXt;
        }

        private Field dXt() {
            Field field = null;
            AppMethodBeat.i(118863);
            ad adVar = ad.AYC;
            d c = ad.c(this.AYd.dWT());
            if (c instanceof a.i.b.a.d.c) {
                ah ahVar = ((a.i.b.a.d.c) c).AWn;
                a.i.b.a.c.e.b.a.j jVar = a.i.b.a.c.e.b.a.j.ByD;
                a.i.b.a.c.e.b.a.f.a a = a.i.b.a.c.e.b.a.j.a(((a.i.b.a.d.c) c).AWo, ((a.i.b.a.d.c) c).AWq, ((a.i.b.a.d.c) c).AWr);
                if (a != null) {
                    Class enclosingClass;
                    Field declaredField;
                    if (o.d(ahVar) || a.i.b.a.c.e.b.a.j.f(((a.i.b.a.d.c) c).AWo)) {
                        enclosingClass = this.AYd.AXs.dWH().getEnclosingClass();
                    } else {
                        a.i.b.a.c.b.l dXW = ahVar.dXW();
                        if (dXW instanceof a.i.b.a.c.b.e) {
                            enclosingClass = af.a((a.i.b.a.c.b.e) dXW);
                        } else {
                            enclosingClass = this.AYd.AXs.dWH();
                        }
                    }
                    if (enclosingClass != null) {
                        try {
                            declaredField = enclosingClass.getDeclaredField(a.name);
                        } catch (NoSuchFieldException e) {
                        }
                    } else {
                        declaredField = null;
                    }
                    field = declaredField;
                    AppMethodBeat.o(118863);
                    return field;
                }
                AppMethodBeat.o(118863);
                return null;
            } else if (c instanceof a.i.b.a.d.a) {
                field = ((a.i.b.a.d.a) c).eum;
                AppMethodBeat.o(118863);
                return field;
            } else if (c instanceof a.i.b.a.d.b) {
                AppMethodBeat.o(118863);
                return null;
            } else if (c instanceof a.i.b.a.d.d) {
                AppMethodBeat.o(118863);
                return null;
            } else {
                m mVar = new m();
                AppMethodBeat.o(118863);
                throw mVar;
            }
        }
    }

    public abstract c<R> dXk();

    public final i dWV() {
        return this.AXs;
    }

    public final String getName() {
        return this.name;
    }

    private s(i iVar, String str, String str2, ah ahVar, Object obj) {
        this.AXs = iVar;
        this.name = str;
        this.signature = str2;
        this.AXt = obj;
        a.i.b.a.z.a a = z.a(null, new f(this));
        j.o(a, "ReflectProperties.lazySo…y -> null\n        }\n    }");
        this.AXX = a;
        a = z.a(ahVar, new e(this));
        j.o(a, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.AXY = a;
    }

    public s(i iVar, String str, String str2, Object obj) {
        j.p(iVar, "container");
        j.p(str, "name");
        j.p(str2, "signature");
        this(iVar, str, str2, null, obj);
    }

    public s(i iVar, ah ahVar) {
        j.p(iVar, "container");
        j.p(ahVar, "descriptor");
        String str = ahVar.dZg().name;
        j.o(str, "descriptor.name.asString()");
        ad adVar = ad.AYC;
        this(iVar, str, ad.c(ahVar).pq(), ahVar, a.f.b.c.AVy);
    }

    public final boolean isBound() {
        return j.j(this.AXt, a.f.b.c.AVy) ^ 1;
    }

    public final Field dXn() {
        return (Field) this.AXX.invoke();
    }

    /* Access modifiers changed, original: protected|final */
    public final Field dXo() {
        return dWT().ead() ? dXn() : null;
    }

    /* Access modifiers changed, original: protected|final */
    public final Object a(Field field, Object obj) {
        try {
            if (obj != AXZ || dWT().dYQ() != null) {
                return field != null ? field.get(obj) : null;
            } else {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
        } catch (IllegalAccessException e) {
            throw new a.i.a.b(e);
        }
    }

    /* renamed from: dXp */
    public final ah dWT() {
        Object invoke = this.AXY.invoke();
        j.o(invoke, "_descriptor()");
        return (ah) invoke;
    }

    public final a.i.b.a.a.d<?> dWU() {
        return dXk().dWU();
    }

    public boolean equals(Object obj) {
        s dx = af.dx(obj);
        if (dx != null && j.j(this.AXs, dx.AXs) && j.j(this.name, dx.name) && j.j(this.signature, dx.signature) && j.j(this.AXt, dx.AXt)) {
            return true;
        }
        return false;
    }

    public String toString() {
        ab abVar = ab.AYy;
        return ab.b(dWT());
    }

    public int hashCode() {
        return (((this.AXs.hashCode() * 31) + this.name.hashCode()) * 31) + this.signature.hashCode();
    }
}
