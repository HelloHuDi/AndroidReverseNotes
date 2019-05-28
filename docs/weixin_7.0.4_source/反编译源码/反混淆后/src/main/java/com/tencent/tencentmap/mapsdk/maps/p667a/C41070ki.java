package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ki */
final class C41070ki<T, S extends C36529kt> implements C46800kj<T, S> {
    /* renamed from: a */
    private final List<C16298kg<T, S>> f16528a;
    /* renamed from: b */
    private final C16304ky f16529b;
    /* renamed from: c */
    private final C31072kf f16530c;

    C41070ki(List<C16298kg<T, S>> list, C31072kf c31072kf) {
        AppMethodBeat.m2504i(100230);
        this.f16528a = list;
        this.f16530c = c31072kf;
        this.f16529b = C36528ks.m60515a(list);
        AppMethodBeat.m2505o(100230);
    }

    /* renamed from: b */
    public final C36529kt mo29553b() {
        return this.f16529b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final List<C16298kg<T, S>> mo65160a() {
        return this.f16528a;
    }

    /* renamed from: a */
    public final void mo65162a(C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly) {
        AppMethodBeat.m2504i(100231);
        if (((Boolean) c31081mf.mo12522a(mo29553b().mo29565a())).booleanValue()) {
            for (C16298kg c16298kg : this.f16528a) {
                if (c5908ly.mo12544c()) {
                    AppMethodBeat.m2505o(100231);
                    return;
                } else if (((Boolean) c31081mf.mo12522a(c16298kg.mo29553b())).booleanValue()) {
                    c5908ly.mo57773a((Object) c16298kg);
                }
            }
            AppMethodBeat.m2505o(100231);
            return;
        }
        AppMethodBeat.m2505o(100231);
    }

    /* renamed from: c */
    public final int mo65163c() {
        AppMethodBeat.m2504i(100232);
        int size = this.f16528a.size();
        AppMethodBeat.m2505o(100232);
        return size;
    }

    /* renamed from: a */
    public final List<C46800kj<T, S>> mo65161a(C16298kg<? extends T, ? extends S> c16298kg) {
        AppMethodBeat.m2504i(100233);
        List a = C36528ks.m60516a(this.f16528a, c16298kg);
        if (a.size() <= this.f16530c.mo50525a()) {
            a = Collections.singletonList(new C41070ki(a, this.f16530c));
            AppMethodBeat.m2505o(100233);
            return a;
        }
        List<C46800kj<T, S>> a2 = m71445a(this.f16530c.mo50527c().mo12532a(a, this.f16530c.mo50526b()));
        AppMethodBeat.m2505o(100233);
        return a2;
    }

    /* renamed from: a */
    private List<C46800kj<T, S>> m71445a(C16303kw<C16298kg<T, S>> c16303kw) {
        AppMethodBeat.m2504i(100234);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C41070ki(c16303kw.mo29562a().mo57770a(), this.f16530c));
        arrayList.add(new C41070ki(c16303kw.mo29563b().mo57770a(), this.f16530c));
        AppMethodBeat.m2505o(100234);
        return arrayList;
    }
}
