package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p005f.C25047a;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.C36663b;
import p000a.p010i.C44935d;
import p000a.p010i.C8295e;
import p000a.p010i.p011b.p012a.C25262z.C25263b;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.C8275i.C8274c;
import p000a.p010i.p011b.p012a.C8275i.C8281b;
import p000a.p010i.p011b.p012a.p014b.C36946i;
import p000a.p010i.p011b.p012a.p015c.p016a.C0024d;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p016a.p017b.C41391c;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C0037k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8081s;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44868a;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36656u;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C25151f;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C25177j.C8205a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C0147q;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C25188d;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p049e.C37076b;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001`B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010O\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010Z\u001a\u00020XH\u0016J\u0012\u0010[\u001a\u00020%2\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020<H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R3\u0010\u001a\u001a$\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0016\u00108\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\n8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0016\u0010A\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010C\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\bD\u00102R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\rR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\rR\u0016\u0010K\u001a\u0004\u0018\u00010L8VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006a"}, dWq = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflect_api", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflect_api", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.g */
public final class C16493g<T> extends C8275i implements C36663b<T> {
    final Class<T> AVA;
    final C25263b<C0182a> AWF;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, dWq = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.g$a */
    public final class C0182a extends C8281b {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "annotations", "getAnnotations()Ljava/util/List;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "constructors", "getConstructors()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "supertypes", "getSupertypes()Ljava/util/List;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C0182a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final C25266a AWG = C25262z.m39833a(null, new C0200i(this));
        private final C25266a AWH = C25262z.m39833a(null, new C0190d(this));
        private final C25266a AWI = C25262z.m39833a(null, new C0196p(this));
        final C25266a AWJ = C25262z.m39833a(null, new C0195n(this));
        private final C25266a AWK = C25262z.m39833a(null, new C0194e(this));
        private final C25266a AWL = C25262z.m39833a(null, new C0187l(this));
        private final C25263b AWM = C25262z.m39834h(new C0189m(this));
        private final C25266a AWN = C25262z.m39833a(null, new C0181r(this));
        private final C25266a AWO = C25262z.m39833a(null, new C0192q(this));
        private final C25266a AWP = C25262z.m39833a(null, new C0191o(this));
        private final C25266a AWQ = C25262z.m39833a(null, new C0197g(this));
        private final C25266a AWR = C25262z.m39833a(null, new C0198h(this));
        private final C25266a AWS = C25262z.m39833a(null, new C0183j(this));
        private final C25266a AWT = C25262z.m39833a(null, new C0188k(this));
        final C25266a AWU = C25262z.m39833a(null, new C0185b(this));
        final C25266a AWV = C25262z.m39833a(null, new C0186c(this));
        private final C25266a AWW = C25262z.m39833a(null, new C0199f(this));
        private final C25266a AWX = C25262z.m39833a(null, new C0184a(this));

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$r */
        static final class C0181r extends C25053k implements C31214a<List<? extends C31808w>> {
            final /* synthetic */ C0182a AWZ;

            C0181r(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118713);
                List dYq = this.AWZ.dWX().dYq();
                C25052j.m39375o(dYq, "descriptor.declaredTypeParameters");
                Iterable<C36955ar> iterable = dYq;
                Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                for (C36955ar c31808w : iterable) {
                    arrayList.add(new C31808w(c31808w));
                }
                List list = (List) arrayList;
                AppMethodBeat.m2505o(118713);
                return list;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$j */
        static final class C0183j extends C25053k implements C31214a<Collection<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0183j(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118703);
                Collection a = C16493g.this.mo18063a(C16493g.this.dWZ(), C8274c.INHERITED);
                AppMethodBeat.m2505o(118703);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$a */
        static final class C0184a extends C25053k implements C31214a<List<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0184a(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118694);
                List b = C25035t.m39331b((Collection) this.AWZ.AWU.invoke(), (Iterable) (Collection) this.AWZ.AWV.invoke());
                AppMethodBeat.m2505o(118694);
                return b;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$b */
        static final class C0185b extends C25053k implements C31214a<List<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0185b(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118695);
                List b = C25035t.m39331b(this.AWZ.dXb(), (Iterable) C0182a.m300a(this.AWZ));
                AppMethodBeat.m2505o(118695);
                return b;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$c */
        static final class C0186c extends C25053k implements C31214a<List<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0186c(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118696);
                List b = C25035t.m39331b(C0182a.m302b(this.AWZ), (Iterable) C0182a.m303c(this.AWZ));
                AppMethodBeat.m2505o(118696);
                return b;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
        /* renamed from: a.i.b.a.g$a$l */
        static final class C0187l extends C25053k implements C31214a<List<? extends C16493g<? extends Object>>> {
            final /* synthetic */ C0182a AWZ;

            C0187l(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118705);
                Collection arrayList = new ArrayList();
                for (Object next : C8205a.m14503a(this.AWZ.dWX().dZk(), null, null, 3)) {
                    if (!C8203d.m14499x((C31642l) next)) {
                        arrayList.add(next);
                    }
                }
                Collection arrayList2 = new ArrayList();
                for (C31642l c31642l : (List) arrayList) {
                    if (c31642l == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.m2505o(118705);
                        throw c44941v;
                    }
                    Object c16493g;
                    Class a = C8017af.m14194a((C46865e) c31642l);
                    if (a != null) {
                        c16493g = new C16493g(a);
                    } else {
                        c16493g = null;
                    }
                    if (c16493g != null) {
                        arrayList2.add(c16493g);
                    }
                }
                List list = (List) arrayList2;
                AppMethodBeat.m2505o(118705);
                return list;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$k */
        static final class C0188k extends C25053k implements C31214a<Collection<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0188k(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118704);
                Collection a = C16493g.this.mo18063a(C16493g.this.dXa(), C8274c.INHERITED);
                AppMethodBeat.m2505o(118704);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
        /* renamed from: a.i.b.a.g$a$m */
        static final class C0189m extends C25053k implements C31214a<T> {
            final /* synthetic */ C0182a AWZ;

            C0189m(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x0042  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final T invoke() {
                AppMethodBeat.m2504i(118706);
                C46865e dWX = this.AWZ.dWX();
                if (dWX.dYc() != C36964f.OBJECT) {
                    AppMethodBeat.m2505o(118706);
                    return null;
                }
                Field declaredField;
                T t;
                if (dWX.dYg()) {
                    C0024d c0024d = C0024d.AZQ;
                    if (!C0024d.m24b(dWX)) {
                        declaredField = C16493g.this.AVA.getEnclosingClass().getDeclaredField(dWX.dZg().name);
                        t = declaredField.get(null);
                        if (t != null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type T");
                            AppMethodBeat.m2505o(118706);
                            throw c44941v;
                        }
                        AppMethodBeat.m2505o(118706);
                        return t;
                    }
                }
                declaredField = C16493g.this.AVA.getDeclaredField("INSTANCE");
                t = declaredField.get(null);
                if (t != null) {
                }
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$d */
        static final class C0190d extends C25053k implements C31214a<List<? extends Annotation>> {
            final /* synthetic */ C0182a AWZ;

            C0190d(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118697);
                List a = C8017af.m14199a((C44868a) this.AWZ.dWX());
                AppMethodBeat.m2505o(118697);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$o */
        static final class C0191o extends C25053k implements C31214a<List<? extends C16493g<? extends T>>> {
            final /* synthetic */ C0182a AWZ;

            C0191o(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118708);
                Collection<C46865e> dYp = this.AWZ.dWX().dYp();
                C25052j.m39375o(dYp, "descriptor.sealedSubclasses");
                Collection arrayList = new ArrayList();
                for (C46865e c46865e : dYp) {
                    if (c46865e == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.m2505o(118708);
                        throw c44941v;
                    }
                    Object c16493g;
                    Class a = C8017af.m14194a(c46865e);
                    if (a != null) {
                        c16493g = new C16493g(a);
                    } else {
                        c16493g = null;
                    }
                    if (c16493g != null) {
                        arrayList.add(c16493g);
                    }
                }
                List list = (List) arrayList;
                AppMethodBeat.m2505o(118708);
                return list;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$q */
        static final class C0192q extends C25053k implements C31214a<List<? extends C31806u>> {
            final /* synthetic */ C0182a AWZ;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
            /* renamed from: a.i.b.a.g$a$q$a */
            static final class C0180a extends C25053k implements C31214a<Type> {
                final /* synthetic */ C46867w AXa;
                final /* synthetic */ C0192q AXb;

                C0180a(C46867w c46867w, C0192q c0192q) {
                    this.AXa = c46867w;
                    this.AXb = c0192q;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(118710);
                    C0036h dYs = this.AXa.ejw().dYs();
                    Throwable c25261x;
                    if (dYs instanceof C46865e) {
                        Class a = C8017af.m14194a((C46865e) dYs);
                        if (a == null) {
                            c25261x = new C25261x("Unsupported superclass of " + this.AXb.AWZ + ": " + dYs);
                            AppMethodBeat.m2505o(118710);
                            throw c25261x;
                        } else if (C25052j.m39373j(C16493g.this.AVA.getSuperclass(), a)) {
                            Type genericSuperclass = C16493g.this.AVA.getGenericSuperclass();
                            C25052j.m39375o(genericSuperclass, "jClass.genericSuperclass");
                            AppMethodBeat.m2505o(118710);
                            return genericSuperclass;
                        } else {
                            Class[] interfaces = C16493g.this.AVA.getInterfaces();
                            C25052j.m39375o(interfaces, "jClass.interfaces");
                            int indexOf = C36913i.indexOf(interfaces, a);
                            if (indexOf < 0) {
                                c25261x = new C25261x("No superclass of " + this.AXb.AWZ + " in Java reflection for " + dYs);
                                AppMethodBeat.m2505o(118710);
                                throw c25261x;
                            }
                            Object obj = C16493g.this.AVA.getGenericInterfaces()[indexOf];
                            C25052j.m39375o(obj, "jClass.genericInterfaces[index]");
                            AppMethodBeat.m2505o(118710);
                            return obj;
                        }
                    }
                    c25261x = new C25261x("Supertype not a class: ".concat(String.valueOf(dYs)));
                    AppMethodBeat.m2505o(118710);
                    throw c25261x;
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Ljava/lang/Class;", "", "T", "invoke"})
            /* renamed from: a.i.b.a.g$a$q$1 */
            static final class C01931 extends C25053k implements C31214a<Class<Object>> {
                public static final C01931 AXc = new C01931();

                static {
                    AppMethodBeat.m2504i(118711);
                    AppMethodBeat.m2505o(118711);
                }

                C01931() {
                    super(0);
                }

                public final /* bridge */ /* synthetic */ Object invoke() {
                    return Object.class;
                }
            }

            C0192q(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118712);
                C17313an dXY = this.AWZ.dWX().dXY();
                C25052j.m39375o(dXY, "descriptor.typeConstructor");
                Collection<C46867w> eap = dXY.eap();
                C25052j.m39375o(eap, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(eap.size());
                for (C46867w c46867w : eap) {
                    Collection collection = arrayList;
                    C25052j.m39375o(c46867w, "kotlinType");
                    collection.add(new C31806u(c46867w, new C0180a(c46867w, this)));
                }
                if (!C31619g.m51119e(this.AWZ.dWX())) {
                    Object obj;
                    Iterable<C31806u> iterable = arrayList;
                    if (!((Collection) iterable).isEmpty()) {
                        for (C31806u c31806u : iterable) {
                            C46865e Z = C8203d.m14470Z(c31806u.AYl);
                            C25052j.m39375o(Z, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            C36964f dYc = Z.dYc();
                            C25052j.m39375o(dYc, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (dYc == C36964f.INTERFACE || dYc == C36964f.ANNOTATION_CLASS) {
                                obj = 1;
                                continue;
                            } else {
                                obj = null;
                                continue;
                            }
                            if (obj == null) {
                                obj = null;
                                break;
                            }
                        }
                    }
                    int i = 1;
                    if (obj != null) {
                        Collection collection2 = arrayList;
                        C8235ad dXM = C41434a.m72275G(this.AWZ.dWX()).dXM();
                        C25052j.m39375o(dXM, "descriptor.builtIns.anyType");
                        collection2.add(new C31806u(dXM, C01931.AXc));
                    }
                }
                List at = C31780a.m51477at(arrayList);
                AppMethodBeat.m2505o(118712);
                return at;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$e */
        static final class C0194e extends C25053k implements C31214a<List<? extends C8295e<? extends T>>> {
            final /* synthetic */ C0182a AWZ;

            C0194e(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118698);
                Iterable<C0037k> dWR = C16493g.this.dWR();
                Collection arrayList = new ArrayList(C25034m.m39318d(dWR));
                for (C0037k c31794j : dWR) {
                    arrayList.add(new C31794j(C16493g.this, c31794j));
                }
                List list = (List) arrayList;
                AppMethodBeat.m2505o(118698);
                return list;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$n */
        static final class C0195n extends C25053k implements C31214a<String> {
            final /* synthetic */ C0182a AWZ;

            C0195n(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118707);
                if (C16493g.this.AVA.isAnonymousClass()) {
                    AppMethodBeat.m2505o(118707);
                    return null;
                }
                C8173a a = C16493g.m25317a(C16493g.this);
                if (a.ByO) {
                    AppMethodBeat.m2505o(118707);
                    return null;
                }
                Object obj = a.ehE().ByQ.ByV;
                AppMethodBeat.m2505o(118707);
                return obj;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$p */
        static final class C0196p extends C25053k implements C31214a<String> {
            final /* synthetic */ C0182a AWZ;

            C0196p(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118709);
                if (C16493g.this.AVA.isAnonymousClass()) {
                    AppMethodBeat.m2505o(118709);
                    return null;
                }
                C8173a a = C16493g.m25317a(C16493g.this);
                Object aP;
                if (a.ByO) {
                    aP = C0182a.m301aP(C16493g.this.AVA);
                    AppMethodBeat.m2505o(118709);
                    return aP;
                }
                aP = a.ByN.ByQ.ehK().name;
                C25052j.m39375o(aP, "classId.shortClassName.asString()");
                AppMethodBeat.m2505o(118709);
                return aP;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$g */
        static final class C0197g extends C25053k implements C31214a<Collection<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0197g(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118700);
                Collection a = C16493g.this.mo18063a(C16493g.this.dWZ(), C8274c.DECLARED);
                AppMethodBeat.m2505o(118700);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$h */
        static final class C0198h extends C25053k implements C31214a<Collection<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0198h(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118701);
                Collection a = C16493g.this.mo18063a(C16493g.this.dXa(), C8274c.DECLARED);
                AppMethodBeat.m2505o(118701);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$f */
        static final class C0199f extends C25053k implements C31214a<List<? extends C46869e<?>>> {
            final /* synthetic */ C0182a AWZ;

            C0199f(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118699);
                List b = C25035t.m39331b(this.AWZ.dXb(), (Iterable) C0182a.m302b(this.AWZ));
                AppMethodBeat.m2505o(118699);
                return b;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
        /* renamed from: a.i.b.a.g$a$i */
        static final class C0200i extends C25053k implements C31214a<C46865e> {
            final /* synthetic */ C0182a AWZ;

            C0200i(C0182a c0182a) {
                this.AWZ = c0182a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                Object i;
                AppMethodBeat.m2504i(118702);
                C8173a a = C16493g.m25317a(C16493g.this);
                C36946i dXe = ((C0182a) C16493g.this.AWF.invoke()).dXe();
                if (a.ByO) {
                    i = dXe.AZx.mo18023i(a);
                } else {
                    i = C8081s.m14261a(dXe.AZx.Bdv, a);
                }
                if (i == null) {
                    C16493g.m25318b(C16493g.this);
                    AppMethodBeat.m2505o(118702);
                    throw null;
                }
                AppMethodBeat.m2505o(118702);
                return i;
            }
        }

        static {
            AppMethodBeat.m2504i(118714);
            AppMethodBeat.m2505o(118714);
        }

        public C0182a() {
            super();
            AppMethodBeat.m2504i(118717);
            AppMethodBeat.m2505o(118717);
        }

        public final C46865e dWX() {
            AppMethodBeat.m2504i(118715);
            C46865e c46865e = (C46865e) this.AWG.invoke();
            AppMethodBeat.m2505o(118715);
            return c46865e;
        }

        public final Collection<C46869e<?>> dXb() {
            AppMethodBeat.m2504i(118716);
            Collection collection = (Collection) this.AWQ.invoke();
            AppMethodBeat.m2505o(118716);
            return collection;
        }

        /* renamed from: aP */
        public static final /* synthetic */ String m301aP(Class cls) {
            AppMethodBeat.m2504i(118718);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                C25052j.m39375o(simpleName, "name");
                simpleName = C31820v.m51543jf(simpleName, enclosingMethod.getName() + "$");
                AppMethodBeat.m2505o(118718);
                return simpleName;
            }
            Constructor enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                C25052j.m39375o(simpleName, "name");
                simpleName = C31820v.m51543jf(simpleName, enclosingConstructor.getName() + "$");
                AppMethodBeat.m2505o(118718);
                return simpleName;
            }
            C25052j.m39375o(simpleName, "name");
            C25052j.m39376p(simpleName, "receiver$0");
            C25052j.m39376p(simpleName, "missingDelimiterValue");
            int a = C31820v.m51514a((CharSequence) simpleName, '$', 0, 6);
            if (a == -1) {
                AppMethodBeat.m2505o(118718);
                return simpleName;
            }
            simpleName = simpleName.substring(a + 1, simpleName.length());
            C25052j.m39375o(simpleName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            AppMethodBeat.m2505o(118718);
            return simpleName;
        }

        /* renamed from: a */
        public static final /* synthetic */ Collection m300a(C0182a c0182a) {
            AppMethodBeat.m2504i(118719);
            Collection collection = (Collection) c0182a.AWS.invoke();
            AppMethodBeat.m2505o(118719);
            return collection;
        }

        /* renamed from: b */
        public static final /* synthetic */ Collection m302b(C0182a c0182a) {
            AppMethodBeat.m2504i(118720);
            Collection collection = (Collection) c0182a.AWR.invoke();
            AppMethodBeat.m2505o(118720);
            return collection;
        }

        /* renamed from: c */
        public static final /* synthetic */ Collection m303c(C0182a c0182a) {
            AppMethodBeat.m2504i(118721);
            Collection collection = (Collection) c0182a.AWT.invoke();
            AppMethodBeat.m2505o(118721);
            return collection;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f0\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    /* renamed from: a.i.b.a.g$b */
    static final class C16494b extends C25053k implements C31214a<C0182a> {
        final /* synthetic */ C16493g AWY;

        C16494b(C16493g c16493g) {
            this.AWY = c16493g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118723);
            C0182a c0182a = new C0182a();
            AppMethodBeat.m2505o(118723);
            return c0182a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0015\u0010\u0006\u001a\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "T", "", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    /* renamed from: a.i.b.a.g$c */
    static final class C16495c extends C25051i implements C31591m<C0147q, C36656u, C31220ah> {
        public static final C16495c AXd = new C16495c();

        static {
            AppMethodBeat.m2504i(118726);
            AppMethodBeat.m2505o(118726);
        }

        C16495c() {
            super(2);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(118725);
            C36663b aN = C44855v.m82055aN(C0147q.class);
            AppMethodBeat.m2505o(118725);
            return aN;
        }

        public final String due() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        public final String getName() {
            return "loadProperty";
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118724);
            C0147q c0147q = (C0147q) obj;
            C36656u c36656u = (C36656u) obj2;
            C25052j.m39376p(c0147q, "p1");
            C25052j.m39376p(c36656u, "p2");
            C31220ah g = c0147q.mo238g(c36656u);
            AppMethodBeat.m2505o(118724);
            return g;
        }
    }

    public C16493g(Class<T> cls) {
        C25052j.m39376p(cls, "jClass");
        AppMethodBeat.m2504i(118739);
        this.AVA = cls;
        C25263b h = C25262z.m39834h(new C16494b(this));
        C25052j.m39375o(h, "ReflectProperties.lazy { Data() }");
        this.AWF = h;
        AppMethodBeat.m2505o(118739);
    }

    public final Class<T> dWH() {
        return this.AVA;
    }

    private C46865e dWX() {
        AppMethodBeat.m2504i(118727);
        C46865e dWX = ((C0182a) this.AWF.invoke()).dWX();
        AppMethodBeat.m2505o(118727);
        return dWX;
    }

    private final C8173a dWY() {
        AppMethodBeat.m2504i(118728);
        C36944ad c36944ad = C36944ad.AYC;
        Class cls = this.AVA;
        C25052j.m39376p(cls, "klass");
        C31622h aR;
        C8173a c8173a;
        if (cls.isArray()) {
            cls = cls.getComponentType();
            C25052j.m39375o(cls, "klass.componentType");
            aR = C36944ad.m61720aR(cls);
            if (aR != null) {
                c8173a = new C8173a(C31619g.AZV, aR.Bca);
                AppMethodBeat.m2505o(118728);
                return c8173a;
            }
            c8173a = C8173a.m14427n(C31619g.Bag.Bat.ehI());
            C25052j.m39375o(c8173a, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
            AppMethodBeat.m2505o(118728);
            return c8173a;
        } else if (C25052j.m39373j(cls, Void.TYPE)) {
            c8173a = C36944ad.AYB;
            AppMethodBeat.m2505o(118728);
            return c8173a;
        } else {
            aR = C36944ad.m61720aR(cls);
            if (aR != null) {
                c8173a = new C8173a(C31619g.AZV, aR.BbZ);
                AppMethodBeat.m2505o(118728);
                return c8173a;
            }
            C8173a bb = C37076b.m62036bb(cls);
            if (!bb.ByO) {
                C41391c c41391c = C41391c.Bdq;
                C8174b ehE = bb.ehE();
                C25052j.m39375o(ehE, "classId.asSingleFqName()");
                c8173a = C41391c.m72180f(ehE);
                if (c8173a != null) {
                    AppMethodBeat.m2505o(118728);
                    return c8173a;
                }
            }
            AppMethodBeat.m2505o(118728);
            return bb;
        }
    }

    public final C31746h dWZ() {
        AppMethodBeat.m2504i(118729);
        C31746h dXR = dWX().dZf().dXR();
        AppMethodBeat.m2505o(118729);
        return dXR;
    }

    public final C31746h dXa() {
        AppMethodBeat.m2504i(118730);
        C31746h dXX = dWX().dXX();
        C25052j.m39375o(dXX, "descriptor.staticScope");
        AppMethodBeat.m2505o(118730);
        return dXX;
    }

    public final Collection<C0037k> dWR() {
        AppMethodBeat.m2504i(118731);
        C46865e dWX = dWX();
        if (dWX.dYc() == C36964f.INTERFACE || dWX.dYc() == C36964f.OBJECT) {
            Collection collection = C17115v.AUP;
            AppMethodBeat.m2505o(118731);
            return collection;
        }
        Collection<C0037k> dYb = dWX.dYb();
        C25052j.m39375o(dYb, "descriptor.constructors");
        AppMethodBeat.m2505o(118731);
        return dYb;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo18062a(C37022f c37022f) {
        AppMethodBeat.m2504i(118732);
        C25052j.m39376p(c37022f, "name");
        Collection b = C25035t.m39331b(dWZ().mo219a(c37022f, C0039c.FROM_REFLECTION), (Iterable) dXa().mo219a(c37022f, C0039c.FROM_REFLECTION));
        AppMethodBeat.m2505o(118732);
        return b;
    }

    /* renamed from: b */
    public final Collection<C8083t> mo18064b(C37022f c37022f) {
        AppMethodBeat.m2504i(118733);
        C25052j.m39376p(c37022f, "name");
        Collection b = C25035t.m39331b(dWZ().mo221b(c37022f, C0039c.FROM_REFLECTION), (Iterable) dXa().mo221b(c37022f, C0039c.FROM_REFLECTION));
        AppMethodBeat.m2505o(118733);
        return b;
    }

    public final String dWI() {
        AppMethodBeat.m2504i(118735);
        String str = (String) ((C0182a) this.AWF.invoke()).AWJ.invoke();
        AppMethodBeat.m2505o(118735);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118736);
        if ((obj instanceof C16493g) && C25052j.m39373j(C25047a.m39371c(this), C25047a.m39371c((C36663b) obj))) {
            AppMethodBeat.m2505o(118736);
            return true;
        }
        AppMethodBeat.m2505o(118736);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118737);
        int hashCode = C25047a.m39371c(this).hashCode();
        AppMethodBeat.m2505o(118737);
        return hashCode;
    }

    public final String toString() {
        String str;
        AppMethodBeat.m2504i(118738);
        StringBuilder stringBuilder = new StringBuilder("class ");
        C8173a dWY = dWY();
        C8174b c8174b = dWY.BcW;
        C25052j.m39375o(c8174b, "classId.packageFqName");
        if (c8174b.ByQ.ByV.isEmpty()) {
            str = "";
        } else {
            str = c8174b.ByQ.ByV + ".";
        }
        String str2 = dWY.ByN.ByQ.ByV;
        C25052j.m39375o(str2, "classId.relativeClassName.asString()");
        str = stringBuilder.append(str + C6163u.m9834a(str2, '.', '$')).toString();
        AppMethodBeat.m2505o(118738);
        return str;
    }

    /* renamed from: SJ */
    public final C31220ah mo18061SJ(int i) {
        AppMethodBeat.m2504i(118734);
        while (C25052j.m39373j(this.AVA.getSimpleName(), "DefaultImpls")) {
            Class declaringClass = this.AVA.getDeclaringClass();
            if (declaringClass == null || !declaringClass.isInterface()) {
                break;
            }
            C36663b aM = C25047a.m39369aM(declaringClass);
            if (aM == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                AppMethodBeat.m2505o(118734);
                throw c44941v;
            }
            this = (C16493g) aM;
        }
        C46865e dWX = this.dWX();
        if (!(dWX instanceof C25188d)) {
            dWX = null;
        }
        C25188d c25188d = (C25188d) dWX;
        if (c25188d != null) {
            C25158c c25158c = c25188d.BGD;
            C8180f c8180f = C0092b.BxI;
            C25052j.m39375o(c8180f, "JvmProtoBuf.classLocalVariable");
            C36656u c36656u = (C36656u) C25151f.m39619a(c25158c, c8180f, i);
            if (c36656u != null) {
                C31220ah c31220ah = (C31220ah) C8017af.m14192a(this.AVA, c36656u, c25188d.BHj.AWq, c25188d.BHj.AWr, c25188d.BGE, C16495c.AXd);
                AppMethodBeat.m2505o(118734);
                return c31220ah;
            }
            AppMethodBeat.m2505o(118734);
            return null;
        }
        AppMethodBeat.m2505o(118734);
        return null;
    }
}
