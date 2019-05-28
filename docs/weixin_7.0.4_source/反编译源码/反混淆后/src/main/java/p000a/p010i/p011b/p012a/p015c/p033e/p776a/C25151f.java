package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;

/* renamed from: a.i.b.a.c.e.a.f */
public final class C25151f {
    /* renamed from: a */
    public static final <M extends C25158c<M>, T> T m39618a(C25158c<M> c25158c, C8180f<M, T> c8180f) {
        AppMethodBeat.m2504i(121081);
        C25052j.m39376p(c25158c, "receiver$0");
        C25052j.m39376p(c8180f, ShareConstants.MEDIA_EXTENSION);
        if (c25158c.mo42017c(c8180f)) {
            Object e = c25158c.mo42019e(c8180f);
            AppMethodBeat.m2505o(121081);
            return e;
        }
        AppMethodBeat.m2505o(121081);
        return null;
    }

    /* renamed from: a */
    public static final <M extends C25158c<M>, T> T m39619a(C25158c<M> c25158c, C8180f<M, List<T>> c8180f, int i) {
        AppMethodBeat.m2504i(121082);
        C25052j.m39376p(c25158c, "receiver$0");
        C25052j.m39376p(c8180f, ShareConstants.MEDIA_EXTENSION);
        if (i < c25158c.mo42018d(c8180f)) {
            Object a = c25158c.mo42016a(c8180f, i);
            AppMethodBeat.m2505o(121082);
            return a;
        }
        AppMethodBeat.m2505o(121082);
        return null;
    }
}
