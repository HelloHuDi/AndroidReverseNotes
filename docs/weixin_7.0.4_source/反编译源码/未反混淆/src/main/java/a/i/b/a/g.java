package a.i.b.a;

import a.f.a.m;
import a.f.b.i;
import a.f.b.j;
import a.f.b.k;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.s;
import a.i.b.a.c.e.a.u;
import a.i.b.a.c.j.a.q;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import a.i.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001`B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010O\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010Z\u001a\u00020XH\u0016J\u0012\u0010[\u001a\u00020%2\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020<H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R3\u0010\u001a\u001a$\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0016\u00108\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\n8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0016\u0010A\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010C\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\bD\u00102R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\rR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\rR\u0016\u0010K\u001a\u0004\u0018\u00010L8VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006a"}, dWq = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflect_api", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflect_api", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflect-api"})
public final class g<T> extends i implements a.i.b<T> {
    final Class<T> AVA;
    final a.i.b.a.z.b<a> AWF;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, dWq = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
    public final class a extends a.i.b.a.i.b {
        static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(a.class), "annotations", "getAnnotations()Ljava/util/List;")), v.a(new t(v.aN(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), v.a(new t(v.aN(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), v.a(new t(v.aN(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), v.a(new t(v.aN(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), v.a(new t(v.aN(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), v.a(new t(v.aN(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), v.a(new t(v.aN(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), v.a(new t(v.aN(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final a.i.b.a.z.a AWG = z.a(null, new i(this));
        private final a.i.b.a.z.a AWH = z.a(null, new d(this));
        private final a.i.b.a.z.a AWI = z.a(null, new p(this));
        final a.i.b.a.z.a AWJ = z.a(null, new n(this));
        private final a.i.b.a.z.a AWK = z.a(null, new e(this));
        private final a.i.b.a.z.a AWL = z.a(null, new l(this));
        private final a.i.b.a.z.b AWM = z.h(new m(this));
        private final a.i.b.a.z.a AWN = z.a(null, new r(this));
        private final a.i.b.a.z.a AWO = z.a(null, new q(this));
        private final a.i.b.a.z.a AWP = z.a(null, new o(this));
        private final a.i.b.a.z.a AWQ = z.a(null, new g(this));
        private final a.i.b.a.z.a AWR = z.a(null, new h(this));
        private final a.i.b.a.z.a AWS = z.a(null, new j(this));
        private final a.i.b.a.z.a AWT = z.a(null, new k(this));
        final a.i.b.a.z.a AWU = z.a(null, new b(this));
        final a.i.b.a.z.a AWV = z.a(null, new c(this));
        private final a.i.b.a.z.a AWW = z.a(null, new f(this));
        private final a.i.b.a.z.a AWX = z.a(null, new a(this));

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
        static final class r extends a.f.b.k implements a.f.a.a<List<? extends w>> {
            final /* synthetic */ a AWZ;

            r(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118713);
                List dYq = this.AWZ.dWX().dYq();
                a.f.b.j.o(dYq, "descriptor.declaredTypeParameters");
                Iterable<ar> iterable = dYq;
                Collection arrayList = new ArrayList(a.a.m.d(iterable));
                for (ar wVar : iterable) {
                    arrayList.add(new w(wVar));
                }
                List list = (List) arrayList;
                AppMethodBeat.o(118713);
                return list;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class j extends a.f.b.k implements a.f.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            j(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118703);
                Collection a = g.this.a(g.this.dWZ(), c.INHERITED);
                AppMethodBeat.o(118703);
                return a;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<List<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            a(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118694);
                List b = a.a.t.b((Collection) this.AWZ.AWU.invoke(), (Iterable) (Collection) this.AWZ.AWV.invoke());
                AppMethodBeat.o(118694);
                return b;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class b extends a.f.b.k implements a.f.a.a<List<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            b(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118695);
                List b = a.a.t.b(this.AWZ.dXb(), (Iterable) a.a(this.AWZ));
                AppMethodBeat.o(118695);
                return b;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class c extends a.f.b.k implements a.f.a.a<List<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            c(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118696);
                List b = a.a.t.b(a.b(this.AWZ), (Iterable) a.c(this.AWZ));
                AppMethodBeat.o(118696);
                return b;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
        static final class l extends a.f.b.k implements a.f.a.a<List<? extends g<? extends Object>>> {
            final /* synthetic */ a AWZ;

            l(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118705);
                Collection arrayList = new ArrayList();
                for (Object next : a.i.b.a.c.i.e.j.a.a(this.AWZ.dWX().dZk(), null, null, 3)) {
                    if (!a.i.b.a.c.i.d.x((a.i.b.a.c.b.l) next)) {
                        arrayList.add(next);
                    }
                }
                Collection arrayList2 = new ArrayList();
                for (a.i.b.a.c.b.l lVar : (List) arrayList) {
                    if (lVar == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(118705);
                        throw vVar;
                    }
                    Object gVar;
                    Class a = af.a((a.i.b.a.c.b.e) lVar);
                    if (a != null) {
                        gVar = new g(a);
                    } else {
                        gVar = null;
                    }
                    if (gVar != null) {
                        arrayList2.add(gVar);
                    }
                }
                List list = (List) arrayList2;
                AppMethodBeat.o(118705);
                return list;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class k extends a.f.b.k implements a.f.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            k(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118704);
                Collection a = g.this.a(g.this.dXa(), c.INHERITED);
                AppMethodBeat.o(118704);
                return a;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
        static final class m extends a.f.b.k implements a.f.a.a<T> {
            final /* synthetic */ a AWZ;

            m(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x0042  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final T invoke() {
                AppMethodBeat.i(118706);
                a.i.b.a.c.b.e dWX = this.AWZ.dWX();
                if (dWX.dYc() != a.i.b.a.c.b.f.OBJECT) {
                    AppMethodBeat.o(118706);
                    return null;
                }
                Field declaredField;
                T t;
                if (dWX.dYg()) {
                    a.i.b.a.c.a.d dVar = a.i.b.a.c.a.d.AZQ;
                    if (!a.i.b.a.c.a.d.b(dWX)) {
                        declaredField = g.this.AVA.getEnclosingClass().getDeclaredField(dWX.dZg().name);
                        t = declaredField.get(null);
                        if (t != null) {
                            a.v vVar = new a.v("null cannot be cast to non-null type T");
                            AppMethodBeat.o(118706);
                            throw vVar;
                        }
                        AppMethodBeat.o(118706);
                        return t;
                    }
                }
                declaredField = g.this.AVA.getDeclaredField("INSTANCE");
                t = declaredField.get(null);
                if (t != null) {
                }
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "", "T", "", "invoke"})
        static final class d extends a.f.b.k implements a.f.a.a<List<? extends Annotation>> {
            final /* synthetic */ a AWZ;

            d(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118697);
                List a = af.a((a.i.b.a.c.b.a.a) this.AWZ.dWX());
                AppMethodBeat.o(118697);
                return a;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
        static final class o extends a.f.b.k implements a.f.a.a<List<? extends g<? extends T>>> {
            final /* synthetic */ a AWZ;

            o(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118708);
                Collection<a.i.b.a.c.b.e> dYp = this.AWZ.dWX().dYp();
                a.f.b.j.o(dYp, "descriptor.sealedSubclasses");
                Collection arrayList = new ArrayList();
                for (a.i.b.a.c.b.e eVar : dYp) {
                    if (eVar == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(118708);
                        throw vVar;
                    }
                    Object gVar;
                    Class a = af.a(eVar);
                    if (a != null) {
                        gVar = new g(a);
                    } else {
                        gVar = null;
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                List list = (List) arrayList;
                AppMethodBeat.o(118708);
                return list;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
        static final class q extends a.f.b.k implements a.f.a.a<List<? extends u>> {
            final /* synthetic */ a AWZ;

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
            static final class a extends a.f.b.k implements a.f.a.a<Type> {
                final /* synthetic */ w AXa;
                final /* synthetic */ q AXb;

                a(w wVar, q qVar) {
                    this.AXa = wVar;
                    this.AXb = qVar;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(118710);
                    a.i.b.a.c.b.h dYs = this.AXa.ejw().dYs();
                    Throwable xVar;
                    if (dYs instanceof a.i.b.a.c.b.e) {
                        Class a = af.a((a.i.b.a.c.b.e) dYs);
                        if (a == null) {
                            xVar = new x("Unsupported superclass of " + this.AXb.AWZ + ": " + dYs);
                            AppMethodBeat.o(118710);
                            throw xVar;
                        } else if (a.f.b.j.j(g.this.AVA.getSuperclass(), a)) {
                            Type genericSuperclass = g.this.AVA.getGenericSuperclass();
                            a.f.b.j.o(genericSuperclass, "jClass.genericSuperclass");
                            AppMethodBeat.o(118710);
                            return genericSuperclass;
                        } else {
                            Class[] interfaces = g.this.AVA.getInterfaces();
                            a.f.b.j.o(interfaces, "jClass.interfaces");
                            int indexOf = a.a.i.indexOf(interfaces, a);
                            if (indexOf < 0) {
                                xVar = new x("No superclass of " + this.AXb.AWZ + " in Java reflection for " + dYs);
                                AppMethodBeat.o(118710);
                                throw xVar;
                            }
                            Object obj = g.this.AVA.getGenericInterfaces()[indexOf];
                            a.f.b.j.o(obj, "jClass.genericInterfaces[index]");
                            AppMethodBeat.o(118710);
                            return obj;
                        }
                    }
                    xVar = new x("Supertype not a class: ".concat(String.valueOf(dYs)));
                    AppMethodBeat.o(118710);
                    throw xVar;
                }
            }

            q(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118712);
                an dXY = this.AWZ.dWX().dXY();
                a.f.b.j.o(dXY, "descriptor.typeConstructor");
                Collection<w> eap = dXY.eap();
                a.f.b.j.o(eap, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(eap.size());
                for (w wVar : eap) {
                    Collection collection = arrayList;
                    a.f.b.j.o(wVar, "kotlinType");
                    collection.add(new u(wVar, new a(wVar, this)));
                }
                if (!a.i.b.a.c.a.g.e(this.AWZ.dWX())) {
                    Object obj;
                    Iterable<u> iterable = arrayList;
                    if (!((Collection) iterable).isEmpty()) {
                        for (u uVar : iterable) {
                            a.i.b.a.c.b.e Z = a.i.b.a.c.i.d.Z(uVar.AYl);
                            a.f.b.j.o(Z, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            a.i.b.a.c.b.f dYc = Z.dYc();
                            a.f.b.j.o(dYc, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (dYc == a.i.b.a.c.b.f.INTERFACE || dYc == a.i.b.a.c.b.f.ANNOTATION_CLASS) {
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
                        ad dXM = a.i.b.a.c.i.c.a.G(this.AWZ.dWX()).dXM();
                        a.f.b.j.o(dXM, "descriptor.builtIns.anyType");
                        collection2.add(new u(dXM, AnonymousClass1.AXc));
                    }
                }
                List at = a.i.b.a.c.n.a.at(arrayList);
                AppMethodBeat.o(118712);
                return at;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
        static final class e extends a.f.b.k implements a.f.a.a<List<? extends a.i.e<? extends T>>> {
            final /* synthetic */ a AWZ;

            e(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118698);
                Iterable<a.i.b.a.c.b.k> dWR = g.this.dWR();
                Collection arrayList = new ArrayList(a.a.m.d(dWR));
                for (a.i.b.a.c.b.k jVar : dWR) {
                    arrayList.add(new j(g.this, jVar));
                }
                List list = (List) arrayList;
                AppMethodBeat.o(118698);
                return list;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
        static final class n extends a.f.b.k implements a.f.a.a<String> {
            final /* synthetic */ a AWZ;

            n(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118707);
                if (g.this.AVA.isAnonymousClass()) {
                    AppMethodBeat.o(118707);
                    return null;
                }
                a.i.b.a.c.f.a a = g.a(g.this);
                if (a.ByO) {
                    AppMethodBeat.o(118707);
                    return null;
                }
                Object obj = a.ehE().ByQ.ByV;
                AppMethodBeat.o(118707);
                return obj;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
        static final class p extends a.f.b.k implements a.f.a.a<String> {
            final /* synthetic */ a AWZ;

            p(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118709);
                if (g.this.AVA.isAnonymousClass()) {
                    AppMethodBeat.o(118709);
                    return null;
                }
                a.i.b.a.c.f.a a = g.a(g.this);
                Object aP;
                if (a.ByO) {
                    aP = a.aP(g.this.AVA);
                    AppMethodBeat.o(118709);
                    return aP;
                }
                aP = a.ByN.ByQ.ehK().name;
                a.f.b.j.o(aP, "classId.shortClassName.asString()");
                AppMethodBeat.o(118709);
                return aP;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class g extends a.f.b.k implements a.f.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            g(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118700);
                Collection a = g.this.a(g.this.dWZ(), c.DECLARED);
                AppMethodBeat.o(118700);
                return a;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class h extends a.f.b.k implements a.f.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            h(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118701);
                Collection a = g.this.a(g.this.dXa(), c.DECLARED);
                AppMethodBeat.o(118701);
                return a;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class f extends a.f.b.k implements a.f.a.a<List<? extends e<?>>> {
            final /* synthetic */ a AWZ;

            f(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118699);
                List b = a.a.t.b(this.AWZ.dXb(), (Iterable) a.b(this.AWZ));
                AppMethodBeat.o(118699);
                return b;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
        static final class i extends a.f.b.k implements a.f.a.a<a.i.b.a.c.b.e> {
            final /* synthetic */ a AWZ;

            i(a aVar) {
                this.AWZ = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                Object i;
                AppMethodBeat.i(118702);
                a.i.b.a.c.f.a a = g.a(g.this);
                a.i.b.a.b.i dXe = ((a) g.this.AWF.invoke()).dXe();
                if (a.ByO) {
                    i = dXe.AZx.i(a);
                } else {
                    i = s.a(dXe.AZx.Bdv, a);
                }
                if (i == null) {
                    g.b(g.this);
                    AppMethodBeat.o(118702);
                    throw null;
                }
                AppMethodBeat.o(118702);
                return i;
            }
        }

        static {
            AppMethodBeat.i(118714);
            AppMethodBeat.o(118714);
        }

        public a() {
            super();
            AppMethodBeat.i(118717);
            AppMethodBeat.o(118717);
        }

        public final a.i.b.a.c.b.e dWX() {
            AppMethodBeat.i(118715);
            a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) this.AWG.invoke();
            AppMethodBeat.o(118715);
            return eVar;
        }

        public final Collection<e<?>> dXb() {
            AppMethodBeat.i(118716);
            Collection collection = (Collection) this.AWQ.invoke();
            AppMethodBeat.o(118716);
            return collection;
        }

        public static final /* synthetic */ String aP(Class cls) {
            AppMethodBeat.i(118718);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                a.f.b.j.o(simpleName, "name");
                simpleName = a.k.v.jf(simpleName, enclosingMethod.getName() + "$");
                AppMethodBeat.o(118718);
                return simpleName;
            }
            Constructor enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                a.f.b.j.o(simpleName, "name");
                simpleName = a.k.v.jf(simpleName, enclosingConstructor.getName() + "$");
                AppMethodBeat.o(118718);
                return simpleName;
            }
            a.f.b.j.o(simpleName, "name");
            a.f.b.j.p(simpleName, "receiver$0");
            a.f.b.j.p(simpleName, "missingDelimiterValue");
            int a = a.k.v.a((CharSequence) simpleName, '$', 0, 6);
            if (a == -1) {
                AppMethodBeat.o(118718);
                return simpleName;
            }
            simpleName = simpleName.substring(a + 1, simpleName.length());
            a.f.b.j.o(simpleName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            AppMethodBeat.o(118718);
            return simpleName;
        }

        public static final /* synthetic */ Collection a(a aVar) {
            AppMethodBeat.i(118719);
            Collection collection = (Collection) aVar.AWS.invoke();
            AppMethodBeat.o(118719);
            return collection;
        }

        public static final /* synthetic */ Collection b(a aVar) {
            AppMethodBeat.i(118720);
            Collection collection = (Collection) aVar.AWR.invoke();
            AppMethodBeat.o(118720);
            return collection;
        }

        public static final /* synthetic */ Collection c(a aVar) {
            AppMethodBeat.i(118721);
            Collection collection = (Collection) aVar.AWT.invoke();
            AppMethodBeat.o(118721);
            return collection;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f0\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class b extends k implements a.f.a.a<a> {
        final /* synthetic */ g AWY;

        b(g gVar) {
            this.AWY = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118723);
            a aVar = new a();
            AppMethodBeat.o(118723);
            return aVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0015\u0010\u0006\u001a\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "T", "", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    static final class c extends i implements m<q, u, ah> {
        public static final c AXd = new c();

        static {
            AppMethodBeat.i(118726);
            AppMethodBeat.o(118726);
        }

        c() {
            super(2);
        }

        public final d dWF() {
            AppMethodBeat.i(118725);
            a.i.b aN = v.aN(q.class);
            AppMethodBeat.o(118725);
            return aN;
        }

        public final String due() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        public final String getName() {
            return "loadProperty";
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118724);
            q qVar = (q) obj;
            u uVar = (u) obj2;
            j.p(qVar, "p1");
            j.p(uVar, "p2");
            ah g = qVar.g(uVar);
            AppMethodBeat.o(118724);
            return g;
        }
    }

    public g(Class<T> cls) {
        j.p(cls, "jClass");
        AppMethodBeat.i(118739);
        this.AVA = cls;
        a.i.b.a.z.b h = z.h(new b(this));
        j.o(h, "ReflectProperties.lazy { Data() }");
        this.AWF = h;
        AppMethodBeat.o(118739);
    }

    public final Class<T> dWH() {
        return this.AVA;
    }

    private e dWX() {
        AppMethodBeat.i(118727);
        e dWX = ((a) this.AWF.invoke()).dWX();
        AppMethodBeat.o(118727);
        return dWX;
    }

    private final a.i.b.a.c.f.a dWY() {
        AppMethodBeat.i(118728);
        ad adVar = ad.AYC;
        Class cls = this.AVA;
        j.p(cls, "klass");
        h aR;
        a.i.b.a.c.f.a aVar;
        if (cls.isArray()) {
            cls = cls.getComponentType();
            j.o(cls, "klass.componentType");
            aR = ad.aR(cls);
            if (aR != null) {
                aVar = new a.i.b.a.c.f.a(a.i.b.a.c.a.g.AZV, aR.Bca);
                AppMethodBeat.o(118728);
                return aVar;
            }
            aVar = a.i.b.a.c.f.a.n(a.i.b.a.c.a.g.Bag.Bat.ehI());
            j.o(aVar, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
            AppMethodBeat.o(118728);
            return aVar;
        } else if (j.j(cls, Void.TYPE)) {
            aVar = ad.AYB;
            AppMethodBeat.o(118728);
            return aVar;
        } else {
            aR = ad.aR(cls);
            if (aR != null) {
                aVar = new a.i.b.a.c.f.a(a.i.b.a.c.a.g.AZV, aR.BbZ);
                AppMethodBeat.o(118728);
                return aVar;
            }
            a.i.b.a.c.f.a bb = a.i.b.a.e.b.bb(cls);
            if (!bb.ByO) {
                a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
                a.i.b.a.c.f.b ehE = bb.ehE();
                j.o(ehE, "classId.asSingleFqName()");
                aVar = a.i.b.a.c.a.b.c.f(ehE);
                if (aVar != null) {
                    AppMethodBeat.o(118728);
                    return aVar;
                }
            }
            AppMethodBeat.o(118728);
            return bb;
        }
    }

    public final a.i.b.a.c.i.e.h dWZ() {
        AppMethodBeat.i(118729);
        a.i.b.a.c.i.e.h dXR = dWX().dZf().dXR();
        AppMethodBeat.o(118729);
        return dXR;
    }

    public final a.i.b.a.c.i.e.h dXa() {
        AppMethodBeat.i(118730);
        a.i.b.a.c.i.e.h dXX = dWX().dXX();
        j.o(dXX, "descriptor.staticScope");
        AppMethodBeat.o(118730);
        return dXX;
    }

    public final Collection<a.i.b.a.c.b.k> dWR() {
        AppMethodBeat.i(118731);
        e dWX = dWX();
        if (dWX.dYc() == f.INTERFACE || dWX.dYc() == f.OBJECT) {
            Collection collection = a.a.v.AUP;
            AppMethodBeat.o(118731);
            return collection;
        }
        Collection<a.i.b.a.c.b.k> dYb = dWX.dYb();
        j.o(dYb, "descriptor.constructors");
        AppMethodBeat.o(118731);
        return dYb;
    }

    public final Collection<ah> a(a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(118732);
        j.p(fVar, "name");
        Collection b = a.a.t.b(dWZ().a(fVar, a.i.b.a.c.c.a.c.FROM_REFLECTION), (Iterable) dXa().a(fVar, a.i.b.a.c.c.a.c.FROM_REFLECTION));
        AppMethodBeat.o(118732);
        return b;
    }

    public final Collection<a.i.b.a.c.b.t> b(a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(118733);
        j.p(fVar, "name");
        Collection b = a.a.t.b(dWZ().b(fVar, a.i.b.a.c.c.a.c.FROM_REFLECTION), (Iterable) dXa().b(fVar, a.i.b.a.c.c.a.c.FROM_REFLECTION));
        AppMethodBeat.o(118733);
        return b;
    }

    public final String dWI() {
        AppMethodBeat.i(118735);
        String str = (String) ((a) this.AWF.invoke()).AWJ.invoke();
        AppMethodBeat.o(118735);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118736);
        if ((obj instanceof g) && j.j(a.f.a.c(this), a.f.a.c((a.i.b) obj))) {
            AppMethodBeat.o(118736);
            return true;
        }
        AppMethodBeat.o(118736);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(118737);
        int hashCode = a.f.a.c(this).hashCode();
        AppMethodBeat.o(118737);
        return hashCode;
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(118738);
        StringBuilder stringBuilder = new StringBuilder("class ");
        a.i.b.a.c.f.a dWY = dWY();
        a.i.b.a.c.f.b bVar = dWY.BcW;
        j.o(bVar, "classId.packageFqName");
        if (bVar.ByQ.ByV.isEmpty()) {
            str = "";
        } else {
            str = bVar.ByQ.ByV + ".";
        }
        String str2 = dWY.ByN.ByQ.ByV;
        j.o(str2, "classId.relativeClassName.asString()");
        str = stringBuilder.append(str + a.k.u.a(str2, '.', '$')).toString();
        AppMethodBeat.o(118738);
        return str;
    }

    public final ah SJ(int i) {
        AppMethodBeat.i(118734);
        while (j.j(this.AVA.getSimpleName(), "DefaultImpls")) {
            Class declaringClass = this.AVA.getDeclaringClass();
            if (declaringClass == null || !declaringClass.isInterface()) {
                break;
            }
            a.i.b aM = a.f.a.aM(declaringClass);
            if (aM == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                AppMethodBeat.o(118734);
                throw vVar;
            }
            this = (g) aM;
        }
        e dWX = this.dWX();
        if (!(dWX instanceof a.i.b.a.c.j.a.a.d)) {
            dWX = null;
        }
        a.i.b.a.c.j.a.a.d dVar = (a.i.b.a.c.j.a.a.d) dWX;
        if (dVar != null) {
            a.i.b.a.c.g.i.c cVar = dVar.BGD;
            a.i.b.a.c.g.i.f fVar = a.i.b.a.c.e.b.b.BxI;
            j.o(fVar, "JvmProtoBuf.classLocalVariable");
            u uVar = (u) a.i.b.a.c.e.a.f.a(cVar, fVar, i);
            if (uVar != null) {
                ah ahVar = (ah) af.a(this.AVA, uVar, dVar.BHj.AWq, dVar.BHj.AWr, dVar.BGE, c.AXd);
                AppMethodBeat.o(118734);
                return ahVar;
            }
            AppMethodBeat.o(118734);
            return null;
        }
        AppMethodBeat.o(118734);
        return null;
    }
}
