package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31824m;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C41457n;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.l.a.b */
public final class C8228b {
    /* renamed from: gb */
    public static final C41447az m14532gb(List<? extends C41447az> list) {
        AppMethodBeat.m2504i(122714);
        C25052j.m39376p(list, "types");
        C41447az c41447az;
        switch (list.size()) {
            case 0:
                Throwable illegalStateException = new IllegalStateException("Expected some types".toString());
                AppMethodBeat.m2505o(122714);
                throw illegalStateException;
            case 1:
                c41447az = (C41447az) C25035t.m39341fN(list);
                AppMethodBeat.m2505o(122714);
                return c41447az;
            default:
                Iterable<C41447az> iterable = list;
                Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                Object obj = null;
                Object obj2 = null;
                for (C41447az c41447az2 : iterable) {
                    Object obj3;
                    Object obj4 = (obj != null || C25239y.m39807an(c41447az2)) ? 1 : null;
                    if (c41447az2 instanceof C8235ad) {
                        obj3 = (C8235ad) c41447az2;
                    } else if (!(c41447az2 instanceof C17325q)) {
                        C31824m c31824m = new C31824m();
                        AppMethodBeat.m2505o(122714);
                        throw c31824m;
                    } else if (C41457n.m72337ag(c41447az2)) {
                        AppMethodBeat.m2505o(122714);
                        return c41447az2;
                    } else {
                        obj3 = ((C17325q) c41447az2).BJx;
                        int obj22 = 1;
                    }
                    arrayList.add(obj3);
                    obj = obj4;
                }
                List list2 = (List) arrayList;
                if (obj != null) {
                    C8235ad awn = C25235p.awn("Intersection of error types: ".concat(String.valueOf(list)));
                    C25052j.m39375o(awn, "ErrorUtils.createErrorTy… of error types: $types\")");
                    c41447az2 = awn;
                    AppMethodBeat.m2505o(122714);
                    return c41447az2;
                } else if (obj22 == null) {
                    C25215s c25215s = C25215s.BLd;
                    c41447az2 = C25215s.m39741gc(list2);
                    AppMethodBeat.m2505o(122714);
                    return c41447az2;
                } else {
                    Iterable<C41447az> iterable2 = list;
                    Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable2));
                    for (C41447az al : iterable2) {
                        arrayList2.add(C44924t.m82163al(al));
                    }
                    List list3 = (List) arrayList2;
                    C25215s c25215s2 = C25215s.BLd;
                    C8235ad gc = C25215s.m39741gc(list2);
                    c25215s2 = C25215s.BLd;
                    c41447az2 = C17326x.m26839a(gc, C25215s.m39741gc(list3));
                    AppMethodBeat.m2505o(122714);
                    return c41447az2;
                }
        }
    }
}
