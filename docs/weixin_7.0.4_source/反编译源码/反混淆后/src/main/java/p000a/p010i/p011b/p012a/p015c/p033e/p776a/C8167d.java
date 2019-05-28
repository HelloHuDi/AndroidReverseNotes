package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import p000a.C8311t;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31696y;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37018w;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37018w.C31227b;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37018w.C31227b.C25150b;

/* renamed from: a.i.b.a.c.e.a.d */
public final class C8167d implements C31702c {
    private final C31696y Bxg;
    private final C37018w Bxh;

    public C8167d(C31696y c31696y, C37018w c37018w) {
        C25052j.m39376p(c31696y, "strings");
        C25052j.m39376p(c37018w, "qualifiedNames");
        AppMethodBeat.m2504i(121080);
        this.Bxg = c31696y;
        this.Bxh = c37018w;
        AppMethodBeat.m2505o(121080);
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(121076);
        String string = this.Bxg.getString(i);
        C25052j.m39375o(string, "strings.getString(index)");
        AppMethodBeat.m2505o(121076);
        return string;
    }

    /* renamed from: Uh */
    public final String mo17959Uh(int i) {
        AppMethodBeat.m2504i(121077);
        C8311t Uj = m14408Uj(i);
        List list = (List) Uj.first;
        String a = C25035t.m39322a((Iterable) (List) Uj.second, (CharSequence) ".", null, null, 0, null, null, 62);
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(121077);
            return a;
        }
        String str = C25035t.m39322a((Iterable) list, (CharSequence) "/", null, null, 0, null, null, 62) + IOUtils.DIR_SEPARATOR_UNIX + a;
        AppMethodBeat.m2505o(121077);
        return str;
    }

    /* renamed from: Ui */
    public final boolean mo17960Ui(int i) {
        AppMethodBeat.m2504i(121078);
        boolean booleanValue = ((Boolean) m14408Uj(i).AUw).booleanValue();
        AppMethodBeat.m2505o(121078);
        return booleanValue;
    }

    /* renamed from: Uj */
    private final C8311t<List<String>, List<String>, Boolean> m14408Uj(int i) {
        AppMethodBeat.m2504i(121079);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            C31227b Ty = this.Bxh.mo59031Ty(i);
            C31696y c31696y = this.Bxg;
            C25052j.m39375o(Ty, "proto");
            String string = c31696y.getString(Ty.BuR);
            C25150b c25150b = Ty.BuS;
            if (c25150b == null) {
                C25052j.dWJ();
            }
            switch (C8168e.eQZ[c25150b.ordinal()]) {
                case 1:
                    linkedList2.addFirst(string);
                    break;
                case 2:
                    linkedList.addFirst(string);
                    break;
                case 3:
                    linkedList2.addFirst(string);
                    z = true;
                    break;
                default:
                    break;
            }
            i = Ty.BuQ;
        }
        C8311t c8311t = new C8311t(linkedList, linkedList2, Boolean.valueOf(z));
        AppMethodBeat.m2505o(121079);
        return c8311t;
    }
}
