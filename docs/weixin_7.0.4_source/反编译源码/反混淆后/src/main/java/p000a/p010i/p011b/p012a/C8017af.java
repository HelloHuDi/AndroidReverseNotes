package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C44941v;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C36646h;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C8000p;
import p000a.p010i.C44858a;
import p000a.p010i.p011b.p012a.p013a.C36941b;
import p000a.p010i.p011b.p012a.p014b.C16483e;
import p000a.p010i.p011b.p012a.p014b.C16483e.C8020a;
import p000a.p010i.p011b.p012a.p014b.C36946i;
import p000a.p010i.p011b.p012a.p014b.C41176k.C8024a;
import p000a.p010i.p011b.p012a.p014b.C44863a;
import p000a.p010i.p011b.p012a.p014b.C8019d;
import p000a.p010i.p011b.p012a.p015c.p016a.p017b.C41391c;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44868a;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C8040f;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8148p;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a.C8132a;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31694o;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36656u;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C6143s;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41422h;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41424j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C25151f;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i.C37008a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17276b;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17281i;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25170a;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25171j;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25173q;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C44639o;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C0147q;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31758k;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8225i;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;
import p000a.p010i.p011b.p012a.p049e.C25250j;
import p000a.p010i.p011b.p012a.p049e.C31792n;
import p000a.p010i.p011b.p012a.p049e.C37076b;
import p000a.p010i.p011b.p012a.p049e.C44932c;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001an\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\b\b\u0001\u0010\u0013*\u00020\u00062\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u001d\u0010\u001f\u001a\u0019\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00130 ¢\u0006\u0002\b\"H\u0000¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000eH\u0000\u001a\"\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,H\b¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/*\u0004\u0018\u000100H\u0000\u001a\u0010\u00101\u001a\u0004\u0018\u000102*\u0004\u0018\u000100H\u0000\u001a\u0014\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000104*\u0004\u0018\u000100H\u0000\u001a\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001a\u000e\u00109\u001a\u0004\u0018\u000107*\u00020:H\u0002\u001a\u0012\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020<H\u0000\u001a\u000e\u0010=\u001a\u0004\u0018\u00010>*\u00020?H\u0000\u001a\u001a\u0010@\u001a\u0004\u0018\u000100*\u0006\u0012\u0002\b\u00030A2\u0006\u0010%\u001a\u00020&H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\"\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006B"}, dWq = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isPublicInBytecode", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Z", "packageModuleName", "", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "getPackageModuleName", "(Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;)Ljava/lang/String;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.af */
public final class C8017af {
    private static final C8174b AYE = new C8174b("kotlin.jvm.JvmStatic");

    static {
        AppMethodBeat.m2504i(118946);
        AppMethodBeat.m2505o(118946);
    }

    public static final C8174b dXv() {
        return AYE;
    }

    /* renamed from: a */
    public static final Class<?> m14194a(C46865e c46865e) {
        AppMethodBeat.m2504i(118935);
        C25052j.m39376p(c46865e, "receiver$0");
        C41398am dYo = c46865e.dYo();
        C25052j.m39375o(dYo, "source");
        C44941v c44941v;
        Class<?> cls;
        if (dYo instanceof C8148p) {
            C8143n c8143n = ((C8148p) dYo).BrH;
            if (c8143n == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.components.ReflectKotlinClass");
                AppMethodBeat.m2505o(118935);
                throw c44941v;
            }
            Class cls2 = ((C16483e) c8143n).AZs;
            AppMethodBeat.m2505o(118935);
            return cls2;
        } else if (dYo instanceof C8024a) {
            C31792n c31792n = ((C8024a) dYo).AZF;
            if (c31792n == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.structure.ReflectJavaClass");
                AppMethodBeat.m2505o(118935);
                throw c44941v;
            }
            cls = ((C25250j) c31792n).AZs;
            AppMethodBeat.m2505o(118935);
            return cls;
        } else {
            C41391c c41391c = C41391c.Bdq;
            C8175c n = C8203d.m14486n(c46865e);
            C25052j.m39375o(n, "DescriptorUtils.getFqName(this)");
            C8173a c = C41391c.m72179c(n);
            if (c == null) {
                c = C41434a.m72281c(c46865e);
            }
            if (c == null) {
                AppMethodBeat.m2505o(118935);
                return null;
            }
            String str = c.BcW.ByQ.ByV;
            C25052j.m39375o(str, "classId.packageFqName.asString()");
            String str2 = c.ByN.ByQ.ByV;
            C25052j.m39375o(str2, "classId.relativeClassName.asString()");
            cls = C8017af.m14195a(C37076b.m62032aX(c46865e.getClass()), str, str2);
            AppMethodBeat.m2505o(118935);
            return cls;
        }
    }

    /* renamed from: a */
    private static Class<?> m14195a(ClassLoader classLoader, String str, String str2) {
        AppMethodBeat.m2504i(118936);
        C25052j.m39376p(classLoader, "classLoader");
        C25052j.m39376p(str, DownloadInfoColumns.PACKAGENAME);
        C25052j.m39376p(str2, "className");
        if (C25052j.m39373j(str, "kotlin")) {
            Class<?> cls;
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        cls = boolean[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        cls = short[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        cls = char[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        cls = byte[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        cls = double[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        cls = Object[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        cls = int[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        cls = float[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        cls = long[].class;
                        AppMethodBeat.m2505o(118936);
                        return cls;
                    }
                    break;
            }
        }
        Class a = C8019d.m14203a(classLoader, str + '.' + C6163u.m9834a(str2, '.', '$'));
        AppMethodBeat.m2505o(118936);
        return a;
    }

    /* renamed from: a */
    public static final List<Annotation> m14199a(C44868a c44868a) {
        AppMethodBeat.m2504i(118937);
        C25052j.m39376p(c44868a, "receiver$0");
        Collection arrayList = new ArrayList();
        for (C44869c c44869c : c44868a.dYn()) {
            Object obj;
            C41398am dYo = c44869c.dYo();
            if (dYo instanceof C44863a) {
                obj = ((C44863a) dYo).AZp;
            } else if (dYo instanceof C8024a) {
                C31792n c31792n = ((C8024a) dYo).AZF;
                if (!(c31792n instanceof C44932c)) {
                    c31792n = null;
                }
                C44932c c44932c = (C44932c) c31792n;
                if (c44932c != null) {
                    obj = c44932c.AZp;
                } else {
                    obj = null;
                }
            } else {
                obj = C8017af.m14198a(c44869c);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(118937);
        return list;
    }

    /* renamed from: a */
    private static final Annotation m14198a(C44869c c44869c) {
        Class a;
        Class cls;
        AppMethodBeat.m2504i(118938);
        C46865e l = C41434a.m72282l(c44869c);
        if (l != null) {
            a = C8017af.m14194a(l);
        } else {
            a = null;
        }
        if (a instanceof Class) {
            cls = a;
        } else {
            cls = null;
        }
        if (cls == null) {
            AppMethodBeat.m2505o(118938);
            return null;
        }
        Collection arrayList = new ArrayList();
        for (Entry entry : c44869c.eah().entrySet()) {
            C37022f c37022f = (C37022f) entry.getKey();
            C41432f c41432f = (C41432f) entry.getValue();
            ClassLoader classLoader = cls.getClassLoader();
            C25052j.m39375o(classLoader, "annotationClass.classLoader");
            Object a2 = C8017af.m14196a(c41432f, classLoader);
            a2 = a2 != null ? C8312u.m14628I(c37022f.name, a2) : null;
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Annotation annotation = (Annotation) C36941b.m61714a(cls, C31586ag.m51052v((List) arrayList));
        AppMethodBeat.m2505o(118938);
        return annotation;
    }

    /* renamed from: a */
    private static final Object m14196a(C41432f<?> c41432f, ClassLoader classLoader) {
        AppMethodBeat.m2504i(118939);
        Object toArray;
        C44941v c44941v;
        if (c41432f instanceof C25170a) {
            Annotation a = C8017af.m14198a((C44869c) ((C25170a) c41432f).getValue());
            AppMethodBeat.m2505o(118939);
            return a;
        } else if (c41432f instanceof C17276b) {
            Iterable<C41432f> iterable = (Iterable) ((C17276b) c41432f).getValue();
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C41432f a2 : iterable) {
                arrayList.add(C8017af.m14196a(a2, classLoader));
            }
            toArray = ((List) arrayList).toArray(new Object[0]);
            if (toArray == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(118939);
                throw c44941v;
            }
            AppMethodBeat.m2505o(118939);
            return toArray;
        } else if (c41432f instanceof C17281i) {
            C31826o c31826o = (C31826o) ((C17281i) c41432f).getValue();
            C8173a c8173a = (C8173a) c31826o.first;
            C37022f c37022f = (C37022f) c31826o.second;
            String str = c8173a.BcW.ByQ.ByV;
            C25052j.m39375o(str, "enumClassId.packageFqName.asString()");
            String str2 = c8173a.ByN.ByQ.ByV;
            C25052j.m39375o(str2, "enumClassId.relativeClassName.asString()");
            Class a3 = C8017af.m14195a(classLoader, str, str2);
            if (a3 == null) {
                AppMethodBeat.m2505o(118939);
                return null;
            } else if (a3 == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                AppMethodBeat.m2505o(118939);
                throw c44941v;
            } else {
                toArray = Enum.valueOf(a3, c37022f.name);
                AppMethodBeat.m2505o(118939);
                return toArray;
            }
        } else if (c41432f instanceof C44639o) {
            C0036h dYs = ((C44639o) c41432f).ejy().ejw().dYs();
            if (!(dYs instanceof C46865e)) {
                dYs = null;
            }
            C46865e c46865e = (C46865e) dYs;
            if (c46865e != null) {
                toArray = C8017af.m14194a(c46865e);
                AppMethodBeat.m2505o(118939);
                return toArray;
            }
            AppMethodBeat.m2505o(118939);
            return null;
        } else if ((c41432f instanceof C25171j) || (c41432f instanceof C25173q)) {
            AppMethodBeat.m2505o(118939);
            return null;
        } else {
            toArray = c41432f.getValue();
            AppMethodBeat.m2505o(118939);
            return toArray;
        }
    }

    /* renamed from: dw */
    public static final C31794j m14201dw(Object obj) {
        AppMethodBeat.m2504i(118940);
        C31794j c31794j = (C31794j) (!(obj instanceof C31794j) ? null : obj);
        if (c31794j == null) {
            C25051i c25051i = (C25051i) (!(obj instanceof C25051i) ? null : obj);
            C44858a dWD = c25051i != null ? c25051i.dWD() : null;
            if (!(dWD instanceof C31794j)) {
                dWD = null;
            }
            c31794j = (C31794j) dWD;
        }
        AppMethodBeat.m2505o(118940);
        return c31794j;
    }

    /* renamed from: dx */
    public static final C46948s<?> m14202dx(Object obj) {
        AppMethodBeat.m2504i(118941);
        C46948s<?> c46948s = (C46948s) (!(obj instanceof C46948s) ? null : obj);
        if (c46948s == null) {
            C8000p c8000p = (C8000p) (!(obj instanceof C8000p) ? null : obj);
            C44858a dWD = c8000p != null ? c8000p.dWD() : null;
            if (!(dWD instanceof C46948s)) {
                dWD = null;
            }
            c46948s = (C46948s) dWD;
        }
        AppMethodBeat.m2505o(118941);
        return c46948s;
    }

    /* renamed from: c */
    public static final boolean m14200c(C25085b c25085b) {
        AppMethodBeat.m2504i(118943);
        C25052j.m39376p(c25085b, "receiver$0");
        C25082az dYf = c25085b.dYf();
        C25052j.m39375o(dYf, "visibility");
        if ((C25052j.m39373j(dYf, C8051ay.Bfa) || C25052j.m39373j(dYf, C8051ay.BeZ)) && !C8040f.m14213a(c25085b)) {
            AppMethodBeat.m2505o(118943);
            return true;
        }
        AppMethodBeat.m2505o(118943);
        return false;
    }

    /* renamed from: a */
    public static final C41396ak m14193a(C8045a c8045a) {
        AppMethodBeat.m2504i(118944);
        C25052j.m39376p(c8045a, "receiver$0");
        if (c8045a.dYR() != null) {
            C31642l dXW = c8045a.dXW();
            if (dXW == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.m2505o(118944);
                throw c44941v;
            }
            C41396ak dZl = ((C46865e) dXW).dZl();
            AppMethodBeat.m2505o(118944);
            return dZl;
        }
        AppMethodBeat.m2505o(118944);
        return null;
    }

    /* renamed from: a */
    public static final <M extends C8185q, D extends C8045a> D m14192a(Class<?> cls, M m, C31702c c31702c, C41420h c41420h, C31698a c31698a, C31591m<? super C0147q, ? super M, ? extends D> c31591m) {
        Object obj;
        AppMethodBeat.m2504i(118945);
        C25052j.m39376p(cls, "moduleAnchor");
        C25052j.m39376p(m, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25052j.m39376p(c31698a, "metadataVersion");
        C25052j.m39376p(c31591m, "createDescriptor");
        C36946i aQ = C8293y.m14621aQ(cls);
        if (m instanceof C31694o) {
            obj = ((C31694o) m).Btp;
        } else if (m instanceof C36656u) {
            obj = ((C36656u) m).Btp;
        } else {
            Throwable illegalStateException = new IllegalStateException("Unsupported message: ".concat(String.valueOf(m)).toString());
            AppMethodBeat.m2505o(118945);
            throw illegalStateException;
        }
        C8225i c8225i = aQ.AZx;
        C31642l c31642l = aQ.AZx.Bdv;
        C37008a c37008a = C37007i.Bxj;
        C37007i ego = C37007i.Bxi;
        C25052j.m39375o(obj, "typeParameters");
        C8045a c8045a = (C8045a) c31591m.mo212m(new C0147q(new C31758k(c8225i, c31702c, c31642l, c41420h, ego, c31698a, null, null, obj)), m);
        AppMethodBeat.m2505o(118945);
        return c8045a;
    }

    /* JADX WARNING: Missing block: B:17:0x0064, code skipped:
            if (r0 == null) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final String m14197a(C16483e c16483e) {
        String string;
        AppMethodBeat.m2504i(118942);
        while (true) {
            Object c16483e2;
            C25052j.m39376p(c16483e2, "receiver$0");
            C8134a c8134a = c16483e2.AZt;
            if (c8134a.Bsd.ehy()) {
                switch (C8018ag.eQZ[c8134a.Bsc.ordinal()]) {
                    case 1:
                    case 2:
                        String[] strArr = c8134a.Bsf;
                        if (strArr == null) {
                            C25052j.dWJ();
                        }
                        String[] strArr2 = c8134a.strings;
                        if (strArr2 == null) {
                            C25052j.dWJ();
                        }
                        C31826o e = C41424j.m72248e(strArr, strArr2);
                        C41422h c41422h = (C41422h) e.first;
                        C25158c c25158c = (C6143s) e.second;
                        C8180f c8180f = C0092b.BxK;
                        C25052j.m39375o(c8180f, "JvmProtoBuf.packageModuleName");
                        Integer num = (Integer) C25151f.m39618a(c25158c, c8180f);
                        if (num != null) {
                            string = c41422h.getString(num.intValue());
                            break;
                        }
                        String str = "main";
                        AppMethodBeat.m2505o(118942);
                        return str;
                    case 3:
                        List asList;
                        Object[] objArr = c8134a.Bsf;
                        if ((c8134a.Bsc == C8132a.MULTIFILE_CLASS ? 1 : null) == null) {
                            objArr = null;
                        }
                        if (objArr != null) {
                            asList = C36646h.asList(objArr);
                        } else {
                            asList = null;
                        }
                        if (asList == null) {
                            asList = C17115v.AUP;
                        }
                        string = (String) C25035t.m39338fK(asList);
                        if (string != null) {
                            C8020a c8020a = C16483e.AZu;
                            Class loadClass = c16483e2.AZs.getClassLoader().loadClass(C6163u.m9834a(string, IOUtils.DIR_SEPARATOR_UNIX, '.'));
                            C25052j.m39375o(loadClass, "klass.classLoader.loadCl…rtName.replace('/', '.'))");
                            c16483e2 = C8020a.m14204aV(loadClass);
                            if (c16483e2 == null) {
                                break;
                            }
                        } else {
                            AppMethodBeat.m2505o(118942);
                            return null;
                        }
                    default:
                        break;
                }
            }
            AppMethodBeat.m2505o(118942);
            return null;
        }
        string = null;
        AppMethodBeat.m2505o(118942);
        return string;
    }
}
