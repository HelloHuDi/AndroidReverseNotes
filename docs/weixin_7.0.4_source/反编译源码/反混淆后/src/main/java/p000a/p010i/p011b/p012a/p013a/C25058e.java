package p000a.p010i.p011b.p012a.p013a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C36646h;
import p000a.p001a.C36913i;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C31598x;
import p000a.p010i.p011b.p012a.p013a.C36943d.C36942a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001c*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0006\u001b\u001c\u001d\u001e\u001f B3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0004R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0001\u0005!\"#$%¨\u0006&"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.a.e */
public abstract class C25058e<M extends Member> implements C36943d<M> {
    public static final C25067b AZe = new C25067b();
    final List<Type> AYH;
    final M AZb;
    final Type AZc;
    final Class<?> AZd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0001\u0006\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$f */
    public static abstract class C8009f extends C25058e<Method> {
        private final boolean AZg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$a */
        public static final class C8010a extends C8009f implements C44860c {
            private final Object AXt;

            public C8010a(Method method, Object obj) {
                C25052j.m39376p(method, C8741b.METHOD);
                super(method, false, null, 4);
                AppMethodBeat.m2504i(118992);
                this.AXt = obj;
                AppMethodBeat.m2505o(118992);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118991);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                Object a = mo17817a(this.AXt, objArr);
                AppMethodBeat.m2505o(118991);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$f */
        public static final class C8011f extends C8009f {
            public C8011f(Method method) {
                C25052j.m39376p(method, C8741b.METHOD);
                super(method, false, null, 6);
                AppMethodBeat.m2504i(119002);
                AppMethodBeat.m2505o(119002);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(119001);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                Object a = mo17817a(null, objArr);
                AppMethodBeat.m2505o(119001);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$b */
        public static final class C8012b extends C8009f implements C44860c {
            public C8012b(Method method) {
                C25052j.m39376p(method, C8741b.METHOD);
                super(method, false, null, 4);
                AppMethodBeat.m2504i(118994);
                AppMethodBeat.m2505o(118994);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118993);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                Object a = mo17817a(null, objArr);
                AppMethodBeat.m2505o(118993);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$c */
        public static final class C8013c extends C8009f implements C44860c {
            private final Object AXt;

            public C8013c(Method method, Object obj) {
                C25052j.m39376p(method, C8741b.METHOD);
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                C25052j.m39375o(genericParameterTypes, "method.genericParameterTypes");
                if (genericParameterTypes.length <= 1) {
                    genericParameterTypes = new Type[0];
                } else {
                    genericParameterTypes = C36646h.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                    if (genericParameterTypes == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.m2505o(118996);
                        throw c44941v;
                    }
                }
                super(method, genericParameterTypes);
                this.AXt = obj;
                AppMethodBeat.m2505o(118996);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118995);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                C31598x c31598x = new C31598x(2);
                c31598x.add(this.AXt);
                c31598x.mo51593do(objArr);
                Object a = mo17817a(null, c31598x.toArray(new Object[c31598x.ckx.size()]));
                AppMethodBeat.m2505o(118995);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$d */
        public static final class C8014d extends C8009f {
            public C8014d(Method method) {
                C25052j.m39376p(method, C8741b.METHOD);
                super(method, false, null, 6);
                AppMethodBeat.m2504i(118998);
                AppMethodBeat.m2505o(118998);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                Object[] objArr2;
                AppMethodBeat.m2504i(118997);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArr2 = new Object[0];
                } else {
                    objArr2 = C36646h.copyOfRange(objArr, 1, objArr.length);
                    if (objArr2 == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.m2505o(118997);
                        throw c44941v;
                    }
                }
                Object a = mo17817a(obj, objArr2);
                AppMethodBeat.m2505o(118997);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$f$e */
        public static final class C8015e extends C8009f {
            public C8015e(Method method) {
                C25052j.m39376p(method, C8741b.METHOD);
                super(method, true, null, 4);
                AppMethodBeat.m2504i(119000);
                AppMethodBeat.m2505o(119000);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                Object[] objArr2;
                AppMethodBeat.m2504i(118999);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                mo41945dz(C36913i.m61680M(objArr));
                if (objArr.length <= 1) {
                    objArr2 = new Object[0];
                } else {
                    objArr2 = C36646h.copyOfRange(objArr, 1, objArr.length);
                    if (objArr2 == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.m2505o(118999);
                        throw c44941v;
                    }
                }
                Object a = mo17817a(null, objArr2);
                AppMethodBeat.m2505o(118999);
                return a;
            }
        }

        private C8009f(Method method, boolean z, Type[] typeArr) {
            Member member = method;
            Type genericReturnType = method.getGenericReturnType();
            C25052j.m39375o(genericReturnType, "method.genericReturnType");
            super(member, genericReturnType, z ? method.getDeclaringClass() : null, typeArr, (byte) 0);
            this.AZg = C25052j.m39373j(this.AZc, Void.TYPE);
        }

        public /* synthetic */ C8009f(Method method, Type[] typeArr) {
            this(method, false, typeArr);
        }

        /* synthetic */ C8009f(Method method, boolean z, Type[] typeArr, int i) {
            boolean z2 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z;
            if ((i & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                C25052j.m39375o(typeArr, "method.genericParameterTypes");
            }
            this(method, z2, typeArr);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final Object mo17817a(Object obj, Object[] objArr) {
            C25052j.m39376p(objArr, "args");
            return this.AZg ? C37091y.AUy : ((Method) this.AZb).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$d */
    public static abstract class C25059d extends C25058e<Field> {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$d$d */
        public static final class C8008d extends C25059d {
            public C8008d(Field field) {
                C25052j.m39376p(field, "field");
                super(field, true, (byte) 0);
                AppMethodBeat.m2504i(118981);
                AppMethodBeat.m2505o(118981);
            }

            /* renamed from: X */
            public final void mo17816X(Object[] objArr) {
                AppMethodBeat.m2504i(118980);
                C25052j.m39376p(objArr, "args");
                super.mo17816X(objArr);
                mo41945dz(C36913i.m61680M(objArr));
                AppMethodBeat.m2505o(118980);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$d$b */
        public static final class C17135b extends C25059d implements C44860c {
            public C17135b(Field field) {
                C25052j.m39376p(field, "field");
                super(field, false, (byte) 0);
                AppMethodBeat.m2504i(118978);
                AppMethodBeat.m2505o(118978);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$d$c */
        public static final class C25060c extends C25059d {
            public C25060c(Field field) {
                C25052j.m39376p(field, "field");
                super(field, true, (byte) 0);
                AppMethodBeat.m2504i(118979);
                AppMethodBeat.m2505o(118979);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$d$e */
        public static final class C25061e extends C25059d {
            public C25061e(Field field) {
                C25052j.m39376p(field, "field");
                super(field, false, (byte) 0);
                AppMethodBeat.m2504i(118982);
                AppMethodBeat.m2505o(118982);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$d$a */
        public static final class C25062a extends C25059d implements C44860c {
            private final Object AXt;

            public C25062a(Field field, Object obj) {
                C25052j.m39376p(field, "field");
                super(field, false, (byte) 0);
                AppMethodBeat.m2504i(118977);
                this.AXt = obj;
                AppMethodBeat.m2505o(118977);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118976);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                Object obj = ((Field) this.AZb).get(this.AXt);
                AppMethodBeat.m2505o(118976);
                return obj;
            }
        }

        private C25059d(Field field, boolean z) {
            Class declaringClass;
            Member member = field;
            Type genericType = field.getGenericType();
            C25052j.m39375o(genericType, "field.genericType");
            if (z) {
                declaringClass = field.getDeclaringClass();
            } else {
                declaringClass = null;
            }
            super(member, genericType, declaringClass, new Type[0], (byte) 0);
        }

        public /* synthetic */ C25059d(Field field, boolean z, byte b) {
            this(field, z);
        }

        /* renamed from: W */
        public Object mo17818W(Object[] objArr) {
            C25052j.m39376p(objArr, "args");
            mo17816X(objArr);
            return ((Field) this.AZb).get(this.AZd != null ? C36913i.m61678L(objArr) : null);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$e */
    public static abstract class C25063e extends C25058e<Field> {
        private final boolean AZf;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$e$a */
        public static final class C17136a extends C25063e implements C44860c {
            private final Object AXt;

            public C17136a(Field field, boolean z, Object obj) {
                C25052j.m39376p(field, "field");
                super(field, z, false, (byte) 0);
                AppMethodBeat.m2504i(118984);
                this.AXt = obj;
                AppMethodBeat.m2505o(118984);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118983);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                ((Field) this.AZb).set(this.AXt, C36913i.m61678L(objArr));
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(118983);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$e$b */
        public static final class C17137b extends C25063e implements C44860c {
            public C17137b(Field field, boolean z) {
                C25052j.m39376p(field, "field");
                super(field, z, false, (byte) 0);
                AppMethodBeat.m2504i(118986);
                AppMethodBeat.m2505o(118986);
            }

            /* renamed from: W */
            public final Object mo17818W(Object[] objArr) {
                AppMethodBeat.m2504i(118985);
                C25052j.m39376p(objArr, "args");
                mo17816X(objArr);
                ((Field) this.AZb).set(null, C36913i.m61681N(objArr));
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(118985);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$e$c */
        public static final class C17138c extends C25063e {
            public C17138c(Field field, boolean z) {
                C25052j.m39376p(field, "field");
                super(field, z, true, (byte) 0);
                AppMethodBeat.m2504i(118987);
                AppMethodBeat.m2505o(118987);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$e$d */
        public static final class C25064d extends C25063e {
            public C25064d(Field field, boolean z) {
                C25052j.m39376p(field, "field");
                super(field, z, true, (byte) 0);
                AppMethodBeat.m2504i(118989);
                AppMethodBeat.m2505o(118989);
            }

            /* renamed from: X */
            public final void mo17816X(Object[] objArr) {
                AppMethodBeat.m2504i(118988);
                C25052j.m39376p(objArr, "args");
                super.mo17816X(objArr);
                mo41945dz(C36913i.m61680M(objArr));
                AppMethodBeat.m2505o(118988);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"})
        /* renamed from: a.i.b.a.a.e$e$e */
        public static final class C25065e extends C25063e {
            public C25065e(Field field, boolean z) {
                C25052j.m39376p(field, "field");
                super(field, z, false, (byte) 0);
                AppMethodBeat.m2504i(118990);
                AppMethodBeat.m2505o(118990);
            }
        }

        private C25063e(Field field, boolean z, boolean z2) {
            Member member = field;
            Class cls = Void.TYPE;
            C25052j.m39375o(cls, "Void.TYPE");
            Type type = cls;
            Class declaringClass = z2 ? field.getDeclaringClass() : null;
            Type[] typeArr = new Type[1];
            Type genericType = field.getGenericType();
            C25052j.m39375o(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, declaringClass, typeArr, (byte) 0);
            this.AZf = z;
        }

        public /* synthetic */ C25063e(Field field, boolean z, boolean z2, byte b) {
            this(field, z, z2);
        }

        /* renamed from: X */
        public void mo17816X(Object[] objArr) {
            C25052j.m39376p(objArr, "args");
            super.mo17816X(objArr);
            if (this.AZf && C36913i.m61681N(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        /* renamed from: W */
        public Object mo17818W(Object[] objArr) {
            C25052j.m39376p(objArr, "args");
            mo17816X(objArr);
            ((Field) this.AZb).set(this.AZd != null ? C36913i.m61678L(objArr) : null, C36913i.m61681N(objArr));
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$a */
    public static final class C25066a extends C25058e<Constructor<?>> implements C44860c {
        private final Object AXt;

        public C25066a(Constructor<?> constructor, Object obj) {
            C25052j.m39376p(constructor, "constructor");
            Member member = constructor;
            Class declaringClass = constructor.getDeclaringClass();
            C25052j.m39375o(declaringClass, "constructor.declaringClass");
            Type type = declaringClass;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C25052j.m39375o(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, null, genericParameterTypes, (byte) 0);
            AppMethodBeat.m2504i(118973);
            this.AXt = obj;
            AppMethodBeat.m2505o(118973);
        }

        /* renamed from: W */
        public final Object mo17818W(Object[] objArr) {
            AppMethodBeat.m2504i(118972);
            C25052j.m39376p(objArr, "args");
            mo17816X(objArr);
            Constructor constructor = (Constructor) this.AZb;
            C31598x c31598x = new C31598x(2);
            c31598x.add(this.AXt);
            c31598x.mo51593do(objArr);
            Object newInstance = constructor.newInstance(c31598x.toArray(new Object[c31598x.ckx.size()]));
            AppMethodBeat.m2505o(118972);
            return newInstance;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", "", "()V", "dropFirst", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$b */
    public static final class C25067b {
        private C25067b() {
        }

        public /* synthetic */ C25067b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.a.e$c */
    public static final class C25068c extends C25058e<Constructor<?>> {
        public C25068c(Constructor<?> constructor) {
            C25052j.m39376p(constructor, "constructor");
            Member member = constructor;
            Class declaringClass = constructor.getDeclaringClass();
            C25052j.m39375o(declaringClass, "constructor.declaringClass");
            Type type = declaringClass;
            Class declaringClass2 = constructor.getDeclaringClass();
            C25052j.m39375o(declaringClass2, "klass");
            Class declaringClass3 = declaringClass2.getDeclaringClass();
            if (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) {
                declaringClass3 = null;
            }
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C25052j.m39375o(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, declaringClass3, genericParameterTypes, (byte) 0);
            AppMethodBeat.m2505o(118975);
        }

        /* renamed from: W */
        public final Object mo17818W(Object[] objArr) {
            AppMethodBeat.m2504i(118974);
            C25052j.m39376p(objArr, "args");
            mo17816X(objArr);
            Object newInstance = ((Constructor) this.AZb).newInstance(Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.m2505o(118974);
            return newInstance;
        }
    }

    /* JADX WARNING: Missing block: B:3:0x002d, code skipped:
            if (r0 == null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C25058e(M m, Type type, Class<?> cls, Type[] typeArr) {
        List listOf;
        this.AZb = m;
        this.AZc = type;
        this.AZd = cls;
        Class cls2 = this.AZd;
        if (cls2 != null) {
            C31598x c31598x = new C31598x(2);
            c31598x.add(cls2);
            c31598x.mo51593do(typeArr);
            listOf = C7987l.listOf((Type[]) c31598x.toArray(new Type[c31598x.ckx.size()]));
        }
        listOf = C36913i.m61684Q(typeArr);
        this.AYH = listOf;
    }

    public /* synthetic */ C25058e(Member member, Type type, Class cls, Type[] typeArr, byte b) {
        this(member, type, cls, typeArr);
    }

    /* renamed from: X */
    public void mo17816X(Object[] objArr) {
        C25052j.m39376p(objArr, "args");
        C36942a.m61718a(this, objArr);
    }

    public final M dXw() {
        return this.AZb;
    }

    public final Type dXx() {
        return this.AZc;
    }

    public final List<Type> dXy() {
        return this.AYH;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dz */
    public final void mo41945dz(Object obj) {
        if (obj == null || !this.AZb.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }
}
