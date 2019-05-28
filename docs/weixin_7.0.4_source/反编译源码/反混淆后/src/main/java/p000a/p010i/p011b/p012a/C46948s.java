package p000a.p010i.p011b.p012a;

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
import p000a.C0220l;
import p000a.C31824m;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C41376c;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.C31815k.C31814a;
import p000a.p010i.C36664f.C36665a;
import p000a.p010i.C8295e;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.C37072d.C31788d;
import p000a.p010i.p011b.p012a.C37072d.C37073c;
import p000a.p010i.p011b.p012a.C37072d.C37074a;
import p000a.p010i.p011b.p012a.C37072d.C37075b;
import p000a.p010i.p011b.p012a.C8275i.C8276e;
import p000a.p010i.p011b.p012a.C8275i.C8277f;
import p000a.p010i.p011b.p012a.p013a.C36943d;
import p000a.p010i.p011b.p012a.p015c.p018b.C17153ag;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41394ai;
import p000a.p010i.p011b.p012a.p015c.p018b.C41395aj;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C25121o;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f.C17261a;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41424j;
import p000a.p010i.p011b.p012a.p015c.p037i.C8202c;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p1145a.C25056b;
import p000a.p051k.C25273j;
import p000a.p051k.C25274k;
import p000a.p051k.C8305i;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 <*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004;<=>B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\n\u00102\u001a\u0004\u0018\u00010\u0015H\u0004J\u0013\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00107\u001a\u0004\u0018\u00010\nH\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0014\u0010)\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010(R\u0013\u0010,\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00100¨\u0006?"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.s */
public abstract class C46948s<R> extends C46869e<R> implements C31815k<R> {
    private static final Object AXZ = new Object();
    public static final C8287b AYa = new C8287b();
    private final C25266a<Field> AXX;
    private final C25266a<C31220ah> AXY;
    final C8275i AXs;
    final Object AXt;
    final String name;
    final String signature;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.s$b */
    public static final class C8287b {
        private C8287b() {
        }

        public /* synthetic */ C8287b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.s$c */
    public static abstract class C8288c<R> extends C25260a<R, R> implements C31814a<R> {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8288c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C8288c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final C25266a AWG = C25262z.m39833a(null, new C8289b(this));
        private final C25266a AXq = C25262z.m39833a(null, new C8290a(this));

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
        /* renamed from: a.i.b.a.s$c$b */
        static final class C8289b extends C25053k implements C31214a<C41394ai> {
            final /* synthetic */ C8288c AYb;

            C8289b(C8288c c8288c) {
                this.AYb = c8288c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118858);
                Object dZI = this.AYb.dXg().dWT().dZI();
                if (dZI == null) {
                    C31220ah dXp = this.AYb.dXg().dWT();
                    C0027a c0027a = C0026g.BfJ;
                    dZI = C8202c.m14458a(dXp, C0027a.eai());
                }
                AppMethodBeat.m2505o(118858);
                return dZI;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        /* renamed from: a.i.b.a.s$c$a */
        static final class C8290a extends C25053k implements C31214a<C36943d<?>> {
            final /* synthetic */ C8288c AYb;

            C8290a(C8288c c8288c) {
                this.AYb = c8288c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118857);
                C36943d a = C31804t.m51506a(this.AYb, true);
                AppMethodBeat.m2505o(118857);
                return a;
            }
        }

        public final /* synthetic */ C25085b dWT() {
            return dXr();
        }

        public final /* synthetic */ C17153ag dXq() {
            return dXr();
        }

        public final String getName() {
            return "<get-" + dXg().name + '>';
        }

        private C41394ai dXr() {
            return (C41394ai) this.AWG.invoke();
        }

        public final C36943d<?> dWU() {
            return (C36943d) this.AXq.invoke();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
    /* renamed from: a.i.b.a.s$e */
    static final class C8291e extends C25053k implements C31214a<C31220ah> {
        final /* synthetic */ C46948s AYd;

        C8291e(C46948s c46948s) {
            this.AYd = c46948s;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C8305i c25273j;
            int i = 0;
            AppMethodBeat.m2504i(118861);
            C8275i c8275i = this.AYd.AXs;
            String str = this.AYd.name;
            String str2 = this.AYd.signature;
            C25052j.m39376p(str, "name");
            C25052j.m39376p(str2, "signature");
            C25274k c25274k = C8275i.AXf;
            CharSequence charSequence = str2;
            C25052j.m39376p(charSequence, "input");
            Matcher matcher = c25274k.BPf.matcher(charSequence);
            C25052j.m39375o(matcher, "nativePattern.matcher(input)");
            if (matcher.matches()) {
                c25273j = new C25273j(matcher, charSequence);
            } else {
                c25273j = null;
            }
            Throwable c25261x;
            if (c25273j != null) {
                String str3 = (String) c25273j.ekN().BOX.ekM().get(1);
                C31220ah SJ = c8275i.mo18061SJ(Integer.parseInt(str3));
                if (SJ == null) {
                    c25261x = new C25261x("Local property #" + str3 + " not found in " + c8275i.dWH());
                    AppMethodBeat.m2505o(118861);
                    throw c25261x;
                }
                AppMethodBeat.m2505o(118861);
                return SJ;
            }
            C31220ah c31220ah;
            C37022f avX = C37022f.avX(str);
            C25052j.m39375o(avX, "Name.identifier(name)");
            Collection arrayList = new ArrayList();
            for (Object next : c8275i.mo18062a(avX)) {
                c31220ah = (C31220ah) next;
                C36944ad c36944ad = C36944ad.AYC;
                if (C25052j.m39373j(C36944ad.m61723c(c31220ah).mo51758pq(), str2)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (list.isEmpty()) {
                c25261x = new C25261x("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + c8275i);
                AppMethodBeat.m2505o(118861);
                throw c25261x;
            } else if (list.size() != 1) {
                Map linkedHashMap = new LinkedHashMap();
                for (Object next2 : list) {
                    C25082az dYf = ((C31220ah) next2).dYf();
                    ArrayList arrayList2 = linkedHashMap.get(dYf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(dYf, arrayList2);
                    }
                    arrayList2.add(next2);
                }
                Comparator comparator = C8277f.AXp;
                C25052j.m39376p(linkedHashMap, "receiver$0");
                C25052j.m39376p(comparator, "comparator");
                TreeMap treeMap = new TreeMap(comparator);
                treeMap.putAll(linkedHashMap);
                Collection values = treeMap.values();
                C25052j.m39375o(values, "properties\n             …                }).values");
                List list2 = (List) C25035t.m39344g(values);
                if (list2.size() == 1) {
                    C25052j.m39375o(list2, "mostVisibleProperties");
                    c31220ah = (C31220ah) C25035t.m39337fJ(list2);
                    AppMethodBeat.m2505o(118861);
                    return c31220ah;
                }
                avX = C37022f.avX(str);
                C25052j.m39375o(avX, "Name.identifier(name)");
                String a = C25035t.m39322a((Iterable) c8275i.mo18062a(avX), (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, (C17126b) C8276e.AXo, 30);
                StringBuilder append = new StringBuilder("Property '").append(str).append("' (JVM signature: ").append(str2).append(") not resolved in ").append(c8275i).append(':');
                if (a.length() == 0) {
                    i = 1;
                }
                c25261x = new C25261x(append.append(i != 0 ? " no members found" : IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(a))).toString());
                AppMethodBeat.m2505o(118861);
                throw c25261x;
            } else {
                c31220ah = (C31220ah) C25035t.m39341fN(list);
                AppMethodBeat.m2505o(118861);
                return c31220ah;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.s$a */
    public static abstract class C25260a<PropertyType, ReturnType> extends C46869e<ReturnType> implements C8295e<ReturnType> {
        public abstract C46948s<PropertyType> dXg();

        public abstract C17153ag dXq();

        public final C8275i dWV() {
            return dXg().AXs;
        }

        public final boolean isBound() {
            return dXg().isBound();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, dWq = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.s$d */
    public static abstract class C31238d<R> extends C25260a<R, C37091y> implements C36665a<R> {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C31238d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31238d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final C25266a AWG = C25262z.m39833a(null, new C17341b(this));
        private final C25266a AXq = C25262z.m39833a(null, new C31239a(this));

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
        /* renamed from: a.i.b.a.s$d$b */
        static final class C17341b extends C25053k implements C31214a<C41395aj> {
            final /* synthetic */ C31238d AYc;

            C17341b(C31238d c31238d) {
                this.AYc = c31238d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118860);
                Object dZJ = this.AYc.dXg().dWT().dZJ();
                if (dZJ == null) {
                    C31220ah dXp = this.AYc.dXg().dWT();
                    C0027a c0027a = C0026g.BfJ;
                    C0026g eai = C0027a.eai();
                    C0027a c0027a2 = C0026g.BfJ;
                    dZJ = C8202c.m14460a(dXp, eai, C0027a.eai());
                }
                AppMethodBeat.m2505o(118860);
                return dZJ;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        /* renamed from: a.i.b.a.s$d$a */
        static final class C31239a extends C25053k implements C31214a<C36943d<?>> {
            final /* synthetic */ C31238d AYc;

            C31239a(C31238d c31238d) {
                this.AYc = c31238d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118859);
                C36943d a = C31804t.m51506a(this.AYc, false);
                AppMethodBeat.m2505o(118859);
                return a;
            }
        }

        public final /* synthetic */ C25085b dWT() {
            return dXs();
        }

        public final /* synthetic */ C17153ag dXq() {
            return dXs();
        }

        public final String getName() {
            return "<set-" + dXg().name + '>';
        }

        private C41395aj dXs() {
            return (C41395aj) this.AWG.invoke();
        }

        public final C36943d<?> dWU() {
            return (C36943d) this.AXq.invoke();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
    /* renamed from: a.i.b.a.s$f */
    static final class C44934f extends C25053k implements C31214a<Field> {
        final /* synthetic */ C46948s AYd;

        C44934f(C46948s c46948s) {
            this.AYd = c46948s;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118862);
            Field dXt = dXt();
            AppMethodBeat.m2505o(118862);
            return dXt;
        }

        private Field dXt() {
            Field field = null;
            AppMethodBeat.m2504i(118863);
            C36944ad c36944ad = C36944ad.AYC;
            C37072d c = C36944ad.m61723c(this.AYd.dWT());
            if (c instanceof C37073c) {
                C31220ah c31220ah = ((C37073c) c).AWn;
                C41424j c41424j = C41424j.ByD;
                C17261a a = C41424j.m72241a(((C37073c) c).AWo, ((C37073c) c).AWq, ((C37073c) c).AWr);
                if (a != null) {
                    Class enclosingClass;
                    Field declaredField;
                    if (C25121o.m39510d(c31220ah) || C41424j.m72250f(((C37073c) c).AWo)) {
                        enclosingClass = this.AYd.AXs.dWH().getEnclosingClass();
                    } else {
                        C31642l dXW = c31220ah.dXW();
                        if (dXW instanceof C46865e) {
                            enclosingClass = C8017af.m14194a((C46865e) dXW);
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
                    AppMethodBeat.m2505o(118863);
                    return field;
                }
                AppMethodBeat.m2505o(118863);
                return null;
            } else if (c instanceof C37074a) {
                field = ((C37074a) c).eum;
                AppMethodBeat.m2505o(118863);
                return field;
            } else if (c instanceof C37075b) {
                AppMethodBeat.m2505o(118863);
                return null;
            } else if (c instanceof C31788d) {
                AppMethodBeat.m2505o(118863);
                return null;
            } else {
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(118863);
                throw c31824m;
            }
        }
    }

    public abstract C8288c<R> dXk();

    public final C8275i dWV() {
        return this.AXs;
    }

    public final String getName() {
        return this.name;
    }

    private C46948s(C8275i c8275i, String str, String str2, C31220ah c31220ah, Object obj) {
        this.AXs = c8275i;
        this.name = str;
        this.signature = str2;
        this.AXt = obj;
        C25266a a = C25262z.m39833a(null, new C44934f(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…y -> null\n        }\n    }");
        this.AXX = a;
        a = C25262z.m39833a(c31220ah, new C8291e(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.AXY = a;
    }

    public C46948s(C8275i c8275i, String str, String str2, Object obj) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(str, "name");
        C25052j.m39376p(str2, "signature");
        this(c8275i, str, str2, null, obj);
    }

    public C46948s(C8275i c8275i, C31220ah c31220ah) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(c31220ah, "descriptor");
        String str = c31220ah.dZg().name;
        C25052j.m39375o(str, "descriptor.name.asString()");
        C36944ad c36944ad = C36944ad.AYC;
        this(c8275i, str, C36944ad.m61723c(c31220ah).mo51758pq(), c31220ah, C41376c.AVy);
    }

    public final boolean isBound() {
        return C25052j.m39373j(this.AXt, C41376c.AVy) ^ 1;
    }

    public final Field dXn() {
        return (Field) this.AXX.invoke();
    }

    /* Access modifiers changed, original: protected|final */
    public final Field dXo() {
        return dWT().ead() ? dXn() : null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Object mo76270a(Field field, Object obj) {
        try {
            if (obj != AXZ || dWT().dYQ() != null) {
                return field != null ? field.get(obj) : null;
            } else {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
        } catch (IllegalAccessException e) {
            throw new C25056b(e);
        }
    }

    /* renamed from: dXp */
    public final C31220ah dWT() {
        Object invoke = this.AXY.invoke();
        C25052j.m39375o(invoke, "_descriptor()");
        return (C31220ah) invoke;
    }

    public final C36943d<?> dWU() {
        return dXk().dWU();
    }

    public boolean equals(Object obj) {
        C46948s dx = C8017af.m14202dx(obj);
        if (dx != null && C25052j.m39373j(this.AXs, dx.AXs) && C25052j.m39373j(this.name, dx.name) && C25052j.m39373j(this.signature, dx.signature) && C25052j.m39373j(this.AXt, dx.AXt)) {
            return true;
        }
        return false;
    }

    public String toString() {
        C41382ab c41382ab = C41382ab.AYy;
        return C41382ab.m72163b(dWT());
    }

    public int hashCode() {
        return (((this.AXs.hashCode() * 31) + this.name.hashCode()) * 31) + this.signature.hashCode();
    }
}
