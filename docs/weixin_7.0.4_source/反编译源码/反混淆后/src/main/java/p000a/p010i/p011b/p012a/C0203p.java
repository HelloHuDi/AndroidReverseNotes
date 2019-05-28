package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0219k;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.C36666l;
import p000a.p010i.C36666l.C8296a;
import p000a.p010i.p011b.p012a.C25262z.C25263b;
import p000a.p010i.p011b.p012a.C46948s.C8288c;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0012*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, dWq = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.p */
public class C0203p<R> extends C46948s<R> implements C36666l<R> {
    private final C25263b<C0204a<R>> AXO;
    private final C44856f<Object> AXP = C17344i.m26853a(C0219k.AUm, new C0206c(this));

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.p$a */
    public static final class C0204a<R> extends C8288c<R> implements C8296a<R> {
        private final C0203p<R> AXQ;

        public C0204a(C0203p<? extends R> c0203p) {
            C25052j.m39376p(c0203p, "property");
            AppMethodBeat.m2504i(118827);
            this.AXQ = c0203p;
            AppMethodBeat.m2505o(118827);
        }

        public final R invoke() {
            AppMethodBeat.m2504i(118826);
            Object obj = this.AXQ.get();
            AppMethodBeat.m2505o(118826);
            return obj;
        }

        public final /* bridge */ /* synthetic */ C46948s dXg() {
            return this.AXQ;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"})
    /* renamed from: a.i.b.a.p$b */
    static final class C0205b extends C25053k implements C31214a<C0204a<? extends R>> {
        final /* synthetic */ C0203p AXR;

        C0205b(C0203p c0203p) {
            this.AXR = c0203p;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118828);
            C0204a c0204a = new C0204a(this.AXR);
            AppMethodBeat.m2505o(118828);
            return c0204a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "invoke"})
    /* renamed from: a.i.b.a.p$c */
    static final class C0206c extends C25053k implements C31214a<Object> {
        final /* synthetic */ C0203p AXR;

        C0206c(C0203p c0203p) {
            this.AXR = c0203p;
            super(0);
        }

        public final Object invoke() {
            AppMethodBeat.m2504i(118829);
            Object a = this.AXR.mo76270a(this.AXR.dXo(), this.AXR.AXt);
            AppMethodBeat.m2505o(118829);
            return a;
        }
    }

    public final /* synthetic */ C8296a dWM() {
        AppMethodBeat.m2504i(118831);
        C8296a dXj = dXj();
        AppMethodBeat.m2505o(118831);
        return dXj;
    }

    public final /* synthetic */ C8288c dXk() {
        AppMethodBeat.m2504i(118832);
        C8288c dXj = dXj();
        AppMethodBeat.m2505o(118832);
        return dXj;
    }

    public C0203p(C8275i c8275i, C31220ah c31220ah) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(c31220ah, "descriptor");
        super(c8275i, c31220ah);
        AppMethodBeat.m2504i(118835);
        C25263b h = C25262z.m39834h(new C0205b(this));
        C25052j.m39375o(h, "ReflectProperties.lazy { Getter(this) }");
        this.AXO = h;
        AppMethodBeat.m2505o(118835);
    }

    public C0203p(C8275i c8275i, String str, String str2, Object obj) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(str, "name");
        C25052j.m39376p(str2, "signature");
        super(c8275i, str, str2, obj);
        AppMethodBeat.m2504i(118836);
        C25263b h = C25262z.m39834h(new C0205b(this));
        C25052j.m39375o(h, "ReflectProperties.lazy { Getter(this) }");
        this.AXO = h;
        AppMethodBeat.m2505o(118836);
    }

    private C0204a<R> dXj() {
        AppMethodBeat.m2504i(118830);
        Object invoke = this.AXO.invoke();
        C25052j.m39375o(invoke, "_getter()");
        C0204a c0204a = (C0204a) invoke;
        AppMethodBeat.m2505o(118830);
        return c0204a;
    }

    public final R get() {
        AppMethodBeat.m2504i(118833);
        Object W = dXj().mo66046W(new Object[0]);
        AppMethodBeat.m2505o(118833);
        return W;
    }

    public final R invoke() {
        AppMethodBeat.m2504i(118834);
        Object obj = get();
        AppMethodBeat.m2505o(118834);
        return obj;
    }
}
