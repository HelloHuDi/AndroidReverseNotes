package com.bumptech.glide;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C37189d;
import com.bumptech.glide.p086c.p087a.C0744f;
import com.bumptech.glide.p086c.p087a.C8511e.C8512a;
import com.bumptech.glide.p086c.p088b.C25424s;
import com.bumptech.glide.p086c.p088b.C31937h;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C31954p;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p092d.p094f.C41564f;
import com.bumptech.glide.p086c.p092d.p094f.C8553e;
import com.bumptech.glide.p095h.C25464h;
import com.bumptech.glide.p095h.p1136a.C37193a;
import com.bumptech.glide.p790e.C17547c;
import com.bumptech.glide.p790e.C17548d;
import com.bumptech.glide.p790e.C17549e;
import com.bumptech.glide.p790e.C25455f;
import com.bumptech.glide.p790e.C37190b;
import com.bumptech.glide.p790e.C41567a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.h */
public final class C31976h {
    private final C31954p awM = new C31954p(this.awV);
    public final C41567a awN = new C41567a();
    private final C17549e awO = new C17549e();
    public final C25455f awP = new C25455f();
    public final C0744f awQ = new C0744f();
    private final C41564f awR = new C41564f();
    final C37190b awS = new C37190b();
    private final C17548d awT = new C17548d();
    private final C17547c awU = new C17547c();
    private final C8387a<List<Throwable>> awV = C37193a.m62345op();

    /* renamed from: com.bumptech.glide.h$b */
    public static final class C17556b extends C25462a {
        public C17556b() {
            super("Failed to find image header parser.");
        }
    }

    /* renamed from: com.bumptech.glide.h$c */
    public static class C17557c extends C25462a {
        public C17557c(Object obj) {
            super("Failed to find any ModelLoaders for model: ".concat(String.valueOf(obj)));
            AppMethodBeat.m2504i(91621);
            AppMethodBeat.m2505o(91621);
        }

        public C17557c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
            AppMethodBeat.m2504i(91622);
            AppMethodBeat.m2505o(91622);
        }
    }

    /* renamed from: com.bumptech.glide.h$a */
    public static class C25462a extends RuntimeException {
        public C25462a(String str) {
            super(str);
        }
    }

    /* renamed from: com.bumptech.glide.h$d */
    public static class C31245d extends C25462a {
        public C31245d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            AppMethodBeat.m2504i(91623);
            AppMethodBeat.m2505o(91623);
        }
    }

    /* renamed from: com.bumptech.glide.h$e */
    public static class C31977e extends C25462a {
        public C31977e(Class<?> cls) {
            super("Failed to find source encoder for data class: ".concat(String.valueOf(cls)));
            AppMethodBeat.m2504i(91624);
            AppMethodBeat.m2505o(91624);
        }
    }

    public C31976h() {
        AppMethodBeat.m2504i(91625);
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.awO.mo31974s(arrayList);
        AppMethodBeat.m2505o(91625);
    }

    /* renamed from: a */
    public final <Data> C31976h mo52075a(Class<Data> cls, C37189d<Data> c37189d) {
        AppMethodBeat.m2504i(91626);
        this.awN.mo66580b(cls, c37189d);
        AppMethodBeat.m2505o(91626);
        return this;
    }

    /* renamed from: a */
    public final <Data, TResource> C31976h mo52079a(Class<Data> cls, Class<TResource> cls2, C31968k<Data, TResource> c31968k) {
        AppMethodBeat.m2504i(91627);
        mo52080a("legacy_append", cls, cls2, c31968k);
        AppMethodBeat.m2505o(91627);
        return this;
    }

    /* renamed from: a */
    public final <Data, TResource> C31976h mo52080a(String str, Class<Data> cls, Class<TResource> cls2, C31968k<Data, TResource> c31968k) {
        AppMethodBeat.m2504i(91628);
        this.awO.mo31971a(str, c31968k, cls, cls2);
        AppMethodBeat.m2505o(91628);
        return this;
    }

    /* renamed from: a */
    public final <TResource> C31976h mo52076a(Class<TResource> cls, C31969l<TResource> c31969l) {
        AppMethodBeat.m2504i(91629);
        this.awP.mo42494b(cls, c31969l);
        AppMethodBeat.m2505o(91629);
        return this;
    }

    /* renamed from: a */
    public final C31976h mo52074a(C8512a<?> c8512a) {
        AppMethodBeat.m2504i(91630);
        this.awQ.mo2192b(c8512a);
        AppMethodBeat.m2505o(91630);
        return this;
    }

    /* renamed from: a */
    public final <TResource, Transcode> C31976h mo52078a(Class<TResource> cls, Class<Transcode> cls2, C8553e<TResource, Transcode> c8553e) {
        AppMethodBeat.m2504i(91631);
        this.awR.mo66577b(cls, cls2, c8553e);
        AppMethodBeat.m2505o(91631);
        return this;
    }

    /* renamed from: a */
    public final <Model, Data> C31976h mo52077a(Class<Model> cls, Class<Data> cls2, C31953o<Model, Data> c31953o) {
        AppMethodBeat.m2504i(91632);
        this.awM.mo52065b(cls, cls2, c31953o);
        AppMethodBeat.m2505o(91632);
        return this;
    }

    /* renamed from: a */
    public final <Data, TResource, Transcode> C25424s<Data, TResource, Transcode> mo52073a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.m2504i(91633);
        C25424s<Data, TResource, Transcode> c = this.awU.mo31969c(cls, cls2, cls3);
        if (C17547c.m27398a(c)) {
            AppMethodBeat.m2505o(91633);
            return null;
        }
        if (c == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : this.awO.mo31973h(cls, cls2)) {
                for (Class cls5 : this.awR.mo66579d(cls4, cls3)) {
                    arrayList.add(new C31937h(cls, cls4, cls5, this.awO.mo31972g(cls, cls4), this.awR.mo66578c(cls4, cls5), this.awV));
                }
            }
            if (arrayList.isEmpty()) {
                c = null;
            } else {
                c = new C25424s(cls, cls2, cls3, arrayList, this.awV);
            }
            C17547c c17547c = this.awU;
            synchronized (c17547c.aGZ) {
                try {
                    c17547c.aGZ.put(new C25464h(cls, cls2, cls3), c != null ? c : C17547c.aGY);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(91633);
                }
            }
        }
        AppMethodBeat.m2505o(91633);
        return c;
    }

    /* renamed from: b */
    public final <Model, TResource, Transcode> List<Class<?>> mo52081b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.m2504i(91634);
        List<Class<?>> f = this.awT.mo31970f(cls, cls2);
        if (f == null) {
            ArrayList arrayList = new ArrayList();
            for (Class h : this.awM.mo52066r(cls)) {
                for (Class cls4 : this.awO.mo31973h(h, cls2)) {
                    if (!(this.awR.mo66579d(cls4, cls3).isEmpty() || arrayList.contains(cls4))) {
                        arrayList.add(cls4);
                    }
                }
            }
            C17548d c17548d = this.awT;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (c17548d.aHc) {
                try {
                    c17548d.aHc.put(new C25464h(cls, cls2), unmodifiableList);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(91634);
                    }
                }
            }
            f = arrayList;
        }
        AppMethodBeat.m2505o(91634);
        return f;
    }

    /* renamed from: P */
    public final <Model> List<C37175n<Model, ?>> mo52072P(Model model) {
        AppMethodBeat.m2504i(91635);
        List P = this.awM.mo52064P(model);
        if (P.isEmpty()) {
            C17557c c17557c = new C17557c(model);
            AppMethodBeat.m2505o(91635);
            throw c17557c;
        }
        AppMethodBeat.m2505o(91635);
        return P;
    }

    /* renamed from: lF */
    public final List<C0776f> mo52082lF() {
        AppMethodBeat.m2504i(91636);
        List nK = this.awS.mo59284nK();
        if (nK.isEmpty()) {
            C17556b c17556b = new C17556b();
            AppMethodBeat.m2505o(91636);
            throw c17556b;
        }
        AppMethodBeat.m2505o(91636);
        return nK;
    }
}
