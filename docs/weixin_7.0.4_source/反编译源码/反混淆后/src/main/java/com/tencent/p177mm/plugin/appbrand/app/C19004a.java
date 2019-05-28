package com.tencent.p177mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.appbrand.appcache.C26736ah;
import com.tencent.p177mm.plugin.appbrand.appcache.C26747f;
import com.tencent.p177mm.plugin.appbrand.appcache.C42346af;
import com.tencent.p177mm.plugin.appbrand.appcache.C45511ad;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C2058a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C2060e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45514d;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C7600h;
import com.tencent.p177mm.plugin.appbrand.appusage.C26772k;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.C42376n;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C26758b;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C42388d;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.sdk.p603e.C4927e;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.app.a */
final class C19004a {
    static final Map<C2047a, String[]> gQL = new HashMap();
    private static final Map<Class, Object> gQM = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$a */
    public interface C2047a<T> {
        /* renamed from: b */
        T mo5812b(C4927e c4927e);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$6 */
    static class C67376 implements C2047a<C2058a> {
        C67376() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129177);
            C2058a c2058a = new C2058a(c4927e);
            AppMethodBeat.m2505o(129177);
            return c2058a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$12 */
    static class C1005212 implements C2047a<C26772k> {
        C1005212() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129183);
            C26772k c26772k = new C26772k(c4927e);
            AppMethodBeat.m2505o(129183);
            return c26772k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$4 */
    static class C100534 implements C2047a<C26779s> {
        C100534() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129175);
            C26779s c26779s = new C26779s((C7480h) c4927e);
            AppMethodBeat.m2505o(129175);
            return c26779s;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$5 */
    static class C100545 implements C2047a<C42388d> {
        C100545() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129176);
            C42388d c42388d = new C42388d(c4927e);
            AppMethodBeat.m2505o(129176);
            return c42388d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$7 */
    static class C100557 implements C2047a<C26747f> {
        C100557() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129178);
            C26747f c26747f = new C26747f(c4927e);
            AppMethodBeat.m2505o(129178);
            return c26747f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$11 */
    static class C1900511 implements C2047a<C26736ah> {
        C1900511() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129182);
            C26736ah c26736ah = new C26736ah(c4927e);
            AppMethodBeat.m2505o(129182);
            return c26736ah;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$13 */
    static class C1900613 implements C2047a<C7600h> {
        C1900613() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129184);
            C7600h c7600h = new C7600h(c4927e);
            AppMethodBeat.m2505o(129184);
            return c7600h;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$14 */
    static class C1900714 implements C2047a<C45514d> {
        C1900714() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129185);
            C45514d c45514d = new C45514d(c4927e);
            AppMethodBeat.m2505o(129185);
            return c45514d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$8 */
    static class C190088 implements C2047a<C45511ad> {
        C190088() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129179);
            C45511ad c45511ad = new C45511ad(c4927e);
            AppMethodBeat.m2505o(129179);
            return c45511ad;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$9 */
    static class C190099 implements C2047a<C42376n> {
        C190099() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129180);
            C42376n c42376n = new C42376n(c4927e);
            AppMethodBeat.m2505o(129180);
            return c42376n;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$2 */
    static class C190102 implements C2047a<C45513b> {
        C190102() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129173);
            C45513b c45513b = new C45513b(c4927e);
            AppMethodBeat.m2505o(129173);
            return c45513b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$10 */
    static class C1901110 implements C2047a<C2060e> {
        C1901110() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129181);
            C2060e c2060e = new C2060e(c4927e);
            AppMethodBeat.m2505o(129181);
            return c2060e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$15 */
    static class C1901215 implements C2047a<C42346af> {
        C1901215() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129186);
            C42346af c42346af = new C42346af(c4927e);
            AppMethodBeat.m2505o(129186);
            return c42346af;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$1 */
    static class C190131 implements C2047a<C42611l> {
        C190131() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129172);
            C42611l c42611l = new C42611l(c4927e);
            AppMethodBeat.m2505o(129172);
            return c42611l;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$3 */
    static class C190143 implements C2047a<C26758b> {
        C190143() {
        }

        /* renamed from: b */
        public final /* synthetic */ Object mo5812b(C4927e c4927e) {
            AppMethodBeat.m2504i(129174);
            C26758b c26758b = new C26758b(c4927e);
            AppMethodBeat.m2505o(129174);
            return c26758b;
        }
    }

    /* renamed from: a */
    private static void m29579a(C2047a c2047a, String[] strArr) {
        AppMethodBeat.m2504i(129187);
        gQL.put(c2047a, strArr);
        AppMethodBeat.m2505o(129187);
    }

    static {
        AppMethodBeat.m2504i(129191);
        C19004a.m29579a(new C190131(), C42611l.fjY);
        C19004a.m29579a(new C190088(), C45511ad.fjY);
        C19004a.m29579a(new C190099(), C42376n.fjY);
        C19004a.m29579a(new C1901110(), C2060e.fjY);
        C19004a.m29579a(new C1900511(), C26736ah.fjY);
        C19004a.m29579a(new C1005212(), C26772k.fjY);
        C19004a.m29579a(new C1900613(), C7600h.fjY);
        C19004a.m29579a(new C1900714(), C45514d.fjY);
        C19004a.m29579a(new C1901215(), C42346af.fjY);
        C19004a.m29579a(new C190102(), C45513b.fjY);
        C19004a.m29579a(new C190143(), C26758b.fjY);
        C19004a.m29579a(new C100534(), C26779s.fjY);
        C19004a.m29579a(new C100545(), C42388d.fjY);
        C19004a.m29579a(new C67376(), C2058a.fjY);
        C19004a.m29579a(new C100557(), C26747f.fjY);
        AppMethodBeat.m2505o(129191);
    }

    /* renamed from: a */
    static void m29580a(C4927e c4927e) {
        AppMethodBeat.m2504i(129188);
        synchronized (gQM) {
            try {
                gQM.clear();
                for (C2047a b : gQL.keySet()) {
                    Object b2 = b.mo5812b(c4927e);
                    gQM.put(b2.getClass(), b2);
                }
            } finally {
                AppMethodBeat.m2505o(129188);
            }
        }
    }

    static void auD() {
        AppMethodBeat.m2504i(129189);
        synchronized (gQM) {
            try {
                gQM.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129189);
            }
        }
    }

    /* renamed from: E */
    static <T> T m29578E(Class<T> cls) {
        T t;
        AppMethodBeat.m2504i(129190);
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (gQM) {
            try {
                t = gQM.get(cls);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129190);
            }
        }
        return t;
    }
}
