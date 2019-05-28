package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C31824m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;

/* renamed from: a.i.b.a.c.l.at */
public final class C17315at {
    /* renamed from: a */
    public static final C46867w m26808a(C46867w c46867w, List<? extends C41446ap> list, C0026g c0026g) {
        AppMethodBeat.m2504i(122656);
        C25052j.m39376p(c46867w, "receiver$0");
        C25052j.m39376p(list, "newArguments");
        C25052j.m39376p(c0026g, "newAnnotations");
        if ((list.isEmpty() || list == c46867w.ejt()) && c0026g == c46867w.dYn()) {
            AppMethodBeat.m2505o(122656);
            return c46867w;
        }
        C41447az ekn = c46867w.ekn();
        C46867w a;
        if (ekn instanceof C17325q) {
            a = C17326x.m26839a(C17315at.m26807a(((C17325q) ekn).BJx, (List) list, c0026g), C17315at.m26807a(((C17325q) ekn).BJy, (List) list, c0026g));
            AppMethodBeat.m2505o(122656);
            return a;
        } else if (ekn instanceof C8235ad) {
            a = C17315at.m26807a((C8235ad) ekn, (List) list, c0026g);
            AppMethodBeat.m2505o(122656);
            return a;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122656);
            throw c31824m;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ C8235ad m26806a(C8235ad c8235ad, List list) {
        AppMethodBeat.m2504i(122658);
        C8235ad a = C17315at.m26807a(c8235ad, list, c8235ad.dYn());
        AppMethodBeat.m2505o(122658);
        return a;
    }

    /* renamed from: a */
    private static C8235ad m26807a(C8235ad c8235ad, List<? extends C41446ap> list, C0026g c0026g) {
        AppMethodBeat.m2504i(122657);
        C25052j.m39376p(c8235ad, "receiver$0");
        C25052j.m39376p(list, "newArguments");
        C25052j.m39376p(c0026g, "newAnnotations");
        if (list.isEmpty() && c0026g == c8235ad.dYn()) {
            AppMethodBeat.m2505o(122657);
            return c8235ad;
        } else if (list.isEmpty()) {
            c8235ad = c8235ad.mo18030d(c0026g);
            AppMethodBeat.m2505o(122657);
            return c8235ad;
        } else {
            c8235ad = C17326x.m26840c(c0026g, c8235ad.ejw(), list, c8235ad.eci());
            AppMethodBeat.m2505o(122657);
            return c8235ad;
        }
    }

    /* renamed from: av */
    public static final C8235ad m26809av(C46867w c46867w) {
        AppMethodBeat.m2504i(122659);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (!(ekn instanceof C8235ad)) {
            ekn = null;
        }
        C8235ad c8235ad = (C8235ad) ekn;
        if (c8235ad == null) {
            Throwable illegalStateException = new IllegalStateException("This is should be simple type: ".concat(String.valueOf(c46867w)).toString());
            AppMethodBeat.m2505o(122659);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(122659);
        return c8235ad;
    }
}
