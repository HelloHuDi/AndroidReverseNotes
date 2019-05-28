package p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap.C17158a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C17165b;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C25133aa;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37014ae;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37014ae.C36998b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C25205w;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31758k;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31764t;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8226r;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.j.a.a.l */
public final class C24618l extends C17165b {
    final C31758k BHj;
    private final C25187a BID = new C25187a(this.BHj.Brl.Baf, new C8220a(this));
    final C37014ae BIE;

    /* renamed from: a.i.b.a.c.j.a.a.l$a */
    static final class C8220a extends C25053k implements C31214a<List<? extends C44869c>> {
        final /* synthetic */ C24618l BIF;

        C8220a(C24618l c24618l) {
            this.BIF = c24618l;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122427);
            List m = C25035t.m39352m(this.BIF.BHj.Brl.BGR.mo58994a(this.BIF.BIE, this.BIF.BHj.AWq));
            AppMethodBeat.m2505o(122427);
            return m;
        }
    }

    /* renamed from: J */
    public final /* synthetic */ void mo101J(C46867w c46867w) {
        AppMethodBeat.m2504i(122429);
        C25052j.m39376p(c46867w, "type");
        Throwable illegalStateException = new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(122429);
        throw illegalStateException;
    }

    public final List<C46867w> eaq() {
        Object obj;
        List list;
        Collection arrayList;
        AppMethodBeat.m2504i(122428);
        C37014ae c37014ae = this.BIE;
        C41420h c41420h = this.BHj.AWr;
        C25052j.m39376p(c37014ae, "receiver$0");
        C25052j.m39376p(c41420h, "typeTable");
        List list2 = c37014ae.BvE;
        if (list2.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            list = list2;
        } else {
            list = null;
        }
        if (list == null) {
            list = c37014ae.BvF;
            C25052j.m39375o(list, "upperBoundIdList");
            Iterable<Integer> iterable = list;
            arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (Integer num : iterable) {
                C25052j.m39375o(num, "it");
                arrayList.add(c41420h.mo66063Uk(num.intValue()));
            }
            list = (List) arrayList;
        }
        if (list.isEmpty()) {
            list2 = C25033k.listOf(C41434a.m72275G(this).dXN());
            AppMethodBeat.m2505o(122428);
            return list2;
        }
        Iterable<C25133aa> iterable2 = list;
        C25205w c25205w = this.BHj.BHb;
        arrayList = new ArrayList(C25034m.m39318d(iterable2));
        for (C25133aa r : iterable2) {
            arrayList.add(c25205w.mo42066r(r));
        }
        List<C46867w> list3 = (List) arrayList;
        AppMethodBeat.m2505o(122428);
        return list3;
    }

    public final /* bridge */ /* synthetic */ C0026g dYn() {
        return this.BID;
    }

    public C24618l(C31758k c31758k, C37014ae c37014ae, int i) {
        C25052j.m39376p(c31758k, "c");
        C25052j.m39376p(c37014ae, "proto");
        C25212i c25212i = c31758k.Brl.Baf;
        C31642l c31642l = c31758k.Bht;
        C37022f b = C8226r.m14531b(c31758k.AWq, c37014ae.Buf);
        C31764t c31764t = C31764t.BHx;
        C36998b c36998b = c37014ae.BvD;
        C25052j.m39375o(c36998b, "proto.variance");
        super(c25212i, c31642l, b, C31764t.m51442b(c36998b), c37014ae.BvC, i, C41398am.BeR, C17158a.BeT);
        AppMethodBeat.m2504i(122430);
        this.BHj = c31758k;
        this.BIE = c37014ae;
        AppMethodBeat.m2505o(122430);
    }
}
