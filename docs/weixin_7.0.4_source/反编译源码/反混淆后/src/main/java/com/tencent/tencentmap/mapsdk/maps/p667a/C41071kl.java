package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kl */
final class C41071kl<T, S extends C36529kt> implements C46800kj<T, S> {
    /* renamed from: a */
    private final List<? extends C46800kj<T, S>> f16531a;
    /* renamed from: b */
    private final C16304ky f16532b;
    /* renamed from: c */
    private final C31072kf f16533c;

    C41071kl(List<? extends C46800kj<T, S>> list, C31072kf c31072kf) {
        AppMethodBeat.m2504i(100236);
        if (list.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(100236);
            throw illegalArgumentException;
        }
        this.f16533c = c31072kf;
        this.f16531a = list;
        this.f16532b = C36528ks.m60515a(list);
        AppMethodBeat.m2505o(100236);
    }

    /* renamed from: b */
    public final C36529kt mo29553b() {
        return this.f16532b;
    }

    /* renamed from: a */
    public final void mo65162a(C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly) {
        AppMethodBeat.m2504i(100237);
        if (((Boolean) c31081mf.mo12522a(mo29553b().mo29565a())).booleanValue()) {
            for (C46800kj c46800kj : this.f16531a) {
                if (c5908ly.mo12544c()) {
                    AppMethodBeat.m2505o(100237);
                    return;
                }
                c46800kj.mo65162a(c31081mf, c5908ly);
            }
            AppMethodBeat.m2505o(100237);
            return;
        }
        AppMethodBeat.m2505o(100237);
    }

    /* renamed from: c */
    public final int mo65163c() {
        AppMethodBeat.m2504i(100238);
        int size = this.f16531a.size();
        AppMethodBeat.m2505o(100238);
        return size;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final List<? extends C46800kj<T, S>> mo65164a() {
        return this.f16531a;
    }

    /* renamed from: a */
    public final List<C46800kj<T, S>> mo65161a(C16298kg<? extends T, ? extends S> c16298kg) {
        AppMethodBeat.m2504i(100239);
        C46800kj a = this.f16533c.mo50528d().mo12531a(c16298kg.mo29553b().mo29565a(), this.f16531a);
        List a2 = C36528ks.m60517a(this.f16531a, a, a.mo65161a(c16298kg));
        if (a2.size() <= this.f16533c.mo50525a()) {
            a2 = Collections.singletonList(new C41071kl(a2, this.f16533c));
            AppMethodBeat.m2505o(100239);
            return a2;
        }
        List<C46800kj<T, S>> a3 = m71451a(this.f16533c.mo50527c().mo12532a(a2, this.f16533c.mo50526b()));
        AppMethodBeat.m2505o(100239);
        return a3;
    }

    /* renamed from: a */
    private List<C46800kj<T, S>> m71451a(C16303kw<? extends C46800kj<T, S>> c16303kw) {
        AppMethodBeat.m2504i(100240);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C41071kl(c16303kw.mo29562a().mo57770a(), this.f16533c));
        arrayList.add(new C41071kl(c16303kw.mo29563b().mo57770a(), this.f16533c));
        AppMethodBeat.m2505o(100240);
        return arrayList;
    }
}
