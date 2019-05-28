package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.Collection;
import java.util.Set;
import p000a.C25046c;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C0012s;
import p000a.p005f.p006a.C0013t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C17127l;
import p000a.p005f.p006a.C17128u;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31215d;
import p000a.p005f.p006a.C31216k;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C31592o;
import p000a.p005f.p006a.C31593p;
import p000a.p005f.p006a.C31594w;
import p000a.p005f.p006a.C36930e;
import p000a.p005f.p006a.C36931g;
import p000a.p005f.p006a.C36932n;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p006a.C41373h;
import p000a.p005f.p006a.C44851f;
import p000a.p005f.p006a.C44852v;
import p000a.p005f.p006a.C7997c;
import p000a.p005f.p006a.C7998i;
import p000a.p005f.p006a.C7999j;
import p000a.p005f.p007b.p1144a.C17130f;
import p000a.p005f.p007b.p1144a.C36934b;
import p000a.p005f.p007b.p1144a.C41374a;

/* renamed from: a.f.b.z */
public class C0014z {
    /* renamed from: o */
    private static <T extends Throwable> T m9o(T t) {
        AppMethodBeat.m2504i(55899);
        Throwable b = C25052j.m39372b(t, C0014z.class.getName());
        AppMethodBeat.m2505o(55899);
        return b;
    }

    /* renamed from: q */
    private static void m10q(Object obj, String str) {
        AppMethodBeat.m2504i(55900);
        ClassCastException classCastException = (ClassCastException) C0014z.m9o(new ClassCastException((obj == null ? BuildConfig.COMMAND : obj.getClass().getName()) + " cannot be cast to " + str));
        AppMethodBeat.m2505o(55900);
        throw classCastException;
    }

    /* renamed from: dp */
    public static Collection m4dp(Object obj) {
        AppMethodBeat.m2504i(55901);
        if ((obj instanceof C41374a) && !(obj instanceof C36934b)) {
            C0014z.m10q(obj, "kotlin.collections.MutableCollection");
        }
        Collection dq = C0014z.m5dq(obj);
        AppMethodBeat.m2505o(55901);
        return dq;
    }

    /* renamed from: dq */
    private static Collection m5dq(Object obj) {
        AppMethodBeat.m2504i(55902);
        try {
            Collection collection = (Collection) obj;
            AppMethodBeat.m2505o(55902);
            return collection;
        } catch (ClassCastException classCastException) {
            ClassCastException classCastException2 = (ClassCastException) C0014z.m9o(classCastException2);
            AppMethodBeat.m2505o(55902);
            throw classCastException2;
        }
    }

    /* renamed from: dr */
    public static Set m6dr(Object obj) {
        AppMethodBeat.m2504i(55903);
        if ((obj instanceof C41374a) && !(obj instanceof C17130f)) {
            C0014z.m10q(obj, "kotlin.collections.MutableSet");
        }
        Set ds = C0014z.m7ds(obj);
        AppMethodBeat.m2505o(55903);
        return ds;
    }

    /* renamed from: ds */
    private static Set m7ds(Object obj) {
        AppMethodBeat.m2504i(55904);
        try {
            Set set = (Set) obj;
            AppMethodBeat.m2505o(55904);
            return set;
        } catch (ClassCastException classCastException) {
            ClassCastException classCastException2 = (ClassCastException) C0014z.m9o(classCastException2);
            AppMethodBeat.m2505o(55904);
            throw classCastException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dt */
    public static Object m8dt(Object obj) {
        AppMethodBeat.m2504i(55905);
        if (obj != null) {
            Object obj2;
            if (obj instanceof C25046c) {
                int dWz;
                if (obj instanceof C17132h) {
                    dWz = ((C17132h) obj).dWz();
                } else if (obj instanceof C31214a) {
                    dWz = 0;
                } else if (obj instanceof C17126b) {
                    dWz = 1;
                } else if (obj instanceof C31591m) {
                    dWz = 2;
                } else if (obj instanceof C36933q) {
                    dWz = 3;
                } else if (obj instanceof C0011r) {
                    dWz = 4;
                } else if (obj instanceof C0012s) {
                    dWz = 5;
                } else if (obj instanceof C0013t) {
                    dWz = 6;
                } else if (obj instanceof C17128u) {
                    dWz = 7;
                } else if (obj instanceof C44852v) {
                    dWz = 8;
                } else if (obj instanceof C31594w) {
                    dWz = 9;
                } else if (obj instanceof C7997c) {
                    dWz = 10;
                } else if (obj instanceof C31215d) {
                    dWz = 11;
                } else if (obj instanceof C36930e) {
                    dWz = 12;
                } else if (obj instanceof C44851f) {
                    dWz = 13;
                } else if (obj instanceof C36931g) {
                    dWz = 14;
                } else if (obj instanceof C41373h) {
                    dWz = 15;
                } else if (obj instanceof C7998i) {
                    dWz = 16;
                } else if (obj instanceof C7999j) {
                    dWz = 17;
                } else if (obj instanceof C31216k) {
                    dWz = 18;
                } else if (obj instanceof C17127l) {
                    dWz = 19;
                } else if (obj instanceof C36932n) {
                    dWz = 20;
                } else if (obj instanceof C31592o) {
                    dWz = 21;
                } else if (obj instanceof C31593p) {
                    dWz = 22;
                } else {
                    dWz = -1;
                }
                if (dWz == 2) {
                    obj2 = 1;
                    if (obj2 == null) {
                        C0014z.m10q(obj, "kotlin.jvm.functions.Function2");
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
            }
        }
        AppMethodBeat.m2505o(55905);
        return obj;
    }
}
