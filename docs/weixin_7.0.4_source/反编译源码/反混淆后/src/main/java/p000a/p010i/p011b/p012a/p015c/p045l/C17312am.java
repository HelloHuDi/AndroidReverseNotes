package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.l.am */
public final class C17312am {
    /* renamed from: aq */
    public static final boolean m26801aq(C46867w c46867w) {
        AppMethodBeat.m2504i(122645);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C17321f)) {
            ekn = null;
        }
        C17321f c17321f = (C17321f) ekn;
        if (c17321f != null) {
            boolean ech = c17321f.ech();
            AppMethodBeat.m2505o(122645);
            return ech;
        }
        AppMethodBeat.m2505o(122645);
        return false;
    }

    /* renamed from: ar */
    public static final C17321f m26802ar(C46867w c46867w) {
        AppMethodBeat.m2504i(122646);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C17321f)) {
            ekn = null;
        }
        C17321f c17321f = (C17321f) ekn;
        if (c17321f == null) {
            AppMethodBeat.m2505o(122646);
            return null;
        } else if (c17321f.ech()) {
            AppMethodBeat.m2505o(122646);
            return c17321f;
        } else {
            AppMethodBeat.m2505o(122646);
            return null;
        }
    }

    /* renamed from: as */
    public static final C46867w m26803as(C46867w c46867w) {
        AppMethodBeat.m2504i(122647);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C41445ak)) {
            ekn = null;
        }
        C41445ak c41445ak = (C41445ak) ekn;
        if (c41445ak != null) {
            C46867w eju = c41445ak.eju();
            if (eju != null) {
                c46867w = eju;
            }
        }
        AppMethodBeat.m2505o(122647);
        return c46867w;
    }

    /* renamed from: at */
    public static final C46867w m26804at(C46867w c46867w) {
        AppMethodBeat.m2504i(122648);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C41445ak)) {
            ekn = null;
        }
        C41445ak c41445ak = (C41445ak) ekn;
        if (c41445ak != null) {
            C46867w ejv = c41445ak.ejv();
            if (ejv != null) {
                c46867w = ejv;
            }
        }
        AppMethodBeat.m2505o(122648);
        return c46867w;
    }

    /* renamed from: b */
    public static final boolean m26805b(C46867w c46867w, C46867w c46867w2) {
        boolean ad;
        AppMethodBeat.m2504i(122649);
        C25052j.m39376p(c46867w, "first");
        C25052j.m39376p(c46867w2, "second");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C41445ak)) {
            ekn = null;
        }
        C41445ak c41445ak = (C41445ak) ekn;
        if (c41445ak != null) {
            ad = c41445ak.mo31391ad(c46867w2);
        } else {
            ad = false;
        }
        if (!ad) {
            ekn = c46867w2.ekn();
            if (!(ekn instanceof C41445ak)) {
                ekn = null;
            }
            c41445ak = (C41445ak) ekn;
            if (c41445ak != null) {
                ad = c41445ak.mo31391ad(c46867w);
            } else {
                ad = false;
            }
            if (!ad) {
                AppMethodBeat.m2505o(122649);
                return false;
            }
        }
        AppMethodBeat.m2505o(122649);
        return true;
    }
}
