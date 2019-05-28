package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44540v.C44541a;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bd */
public final class C46770bd {
    /* renamed from: a */
    private Context f18084a = null;

    public C46770bd(Context context) {
        this.f18084a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x028e A:{Catch:{ Throwable -> 0x0267 }} */
    /* JADX WARNING: Missing block: B:79:0x01df, code skipped:
            if (r1.mo70958d().equals(r2.f1533e) == false) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:86:0x0211, code skipped:
            if (r1.mo70960f().equals(r2.f1534f) == false) goto L_0x0213;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo75357a(int i, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(98547);
        if (i != 101) {
            C16205ag.m24686c("com strategy unmatch key: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(98547);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            C44540v e = C36541t.m60530a(this.f18084a).mo57789e();
            if (e == null) {
                C16205ag.m24686c("imposible! common strategy null!", new Object[0]);
                AppMethodBeat.m2505o(98547);
                return;
            }
            try {
                Object obj;
                C5855ae c5855ae = new C5855ae();
                c5855ae.mo12387a(new C41028ai(bArr));
                if (e == null) {
                    obj = null;
                } else {
                    Object obj2;
                    Object obj3 = null;
                    if (!c5855ae.f1524c.equals(e.mo70939b())) {
                        C16205ag.m24685b("strategy url changed to: %s", c5855ae.f1524c);
                        obj3 = 1;
                        e.mo70936a(c5855ae.f1524c);
                    }
                    if (c5855ae.f1523b != e.mo70940c()) {
                        C16205ag.m24685b("QueryPeriod changed to: %d", Integer.valueOf(c5855ae.f1523b));
                        obj3 = 1;
                        e.mo70933a(c5855ae.f1523b);
                    }
                    ArrayList arrayList = c5855ae.f1522a;
                    if (e == null) {
                        obj = null;
                    } else {
                        obj = null;
                        int i2;
                        C44541a c44541a;
                        if (arrayList != null) {
                            SparseArray e2 = e.mo70942e();
                            if (e2 != null) {
                                i2 = 0;
                                obj2 = null;
                                while (i2 < e2.size()) {
                                    c44541a = (C44541a) e2.valueAt(i2);
                                    Iterator it = arrayList.iterator();
                                    Object obj4 = obj2;
                                    while (it.hasNext()) {
                                        C5856af c5856af = (C5856af) it.next();
                                        if (c5856af.f1529a == c44541a.mo70959e()) {
                                            C16205ag.m24683a("server module strategy mid: %d", Byte.valueOf(c5856af.f1529a));
                                            boolean z2 = c5856af.f1530b == (byte) 1;
                                            if (c44541a.mo70954a() != z2) {
                                                C16205ag.m24685b("mid: %d , isUsable changed: %b ", Byte.valueOf(c5856af.f1529a), Boolean.valueOf(z2));
                                                obj4 = 1;
                                                c44541a.mo70953a(z2);
                                            }
                                            if (!c44541a.mo70955b().equals(c5856af.f1531c)) {
                                                C16205ag.m24685b("mid: %d , url changed: %s", Byte.valueOf(c5856af.f1529a), c5856af.f1531c);
                                                obj4 = 1;
                                                c44541a.mo70950a(c5856af.f1531c);
                                            }
                                            if (c5856af.f1529a == (byte) 1 || c5856af.f1529a == (byte) 2) {
                                                if (c44541a.mo70957c() == null || c5856af.f1532d == null) {
                                                    if (c5856af.f1532d != null && c44541a.mo70957c() == null) {
                                                        C16205ag.m24685b("mid: %d , detail changed...", Byte.valueOf(c5856af.f1529a));
                                                        obj4 = 1;
                                                        c44541a.mo70951a(c5856af.f1532d);
                                                        C36541t.m60530a(this.f18084a).mo57781a(c5856af.f1529a, c5856af.f1532d);
                                                    }
                                                } else if (!c44541a.mo70957c().equals(c5856af.f1532d)) {
                                                    C16205ag.m24685b("mid: %d , detail changed...", Byte.valueOf(c5856af.f1529a));
                                                    obj4 = 1;
                                                    c44541a.mo70951a(c5856af.f1532d);
                                                    C36541t.m60530a(this.f18084a).mo57781a(c5856af.f1529a, c5856af.f1532d);
                                                }
                                            }
                                            if (c5856af.f1529a == (byte) 1) {
                                                if (c44541a.mo70958d() == null || c5856af.f1533e == null) {
                                                    if (c44541a.mo70958d() == null) {
                                                        if (c5856af.f1533e != null) {
                                                        }
                                                        if (c44541a.mo70960f() != null || c5856af.f1534f == null) {
                                                            if (c44541a.mo70960f() == null) {
                                                                if (c5856af.f1534f != null) {
                                                                }
                                                            }
                                                        }
                                                        C16205ag.m24685b("mid: %d , SampleEventSet changed...", Byte.valueOf(c5856af.f1529a));
                                                        obj4 = 1;
                                                        c44541a.mo70956b(C24349e.m37579a(c5856af.f1534f));
                                                    }
                                                }
                                                C16205ag.m24685b("mid: %d , PreventEventCode changed...", Byte.valueOf(c5856af.f1529a));
                                                obj4 = 1;
                                                c44541a.mo70952a(C24349e.m37579a(c5856af.f1533e));
                                                if (c44541a.mo70960f() != null) {
                                                }
                                                if (c44541a.mo70960f() == null) {
                                                }
                                                C16205ag.m24685b("mid: %d , SampleEventSet changed...", Byte.valueOf(c5856af.f1529a));
                                                obj4 = 1;
                                                c44541a.mo70956b(C24349e.m37579a(c5856af.f1534f));
                                            }
                                        }
                                        obj4 = obj4;
                                    }
                                    i2++;
                                    obj2 = obj4;
                                }
                            }
                        } else {
                            SparseArray e3 = e.mo70942e();
                            if (e3 != null) {
                                i2 = e3.size();
                                int i3 = 0;
                                obj2 = null;
                                while (i3 < i2) {
                                    c44541a = (C44541a) e3.valueAt(i3);
                                    if (c44541a.mo70954a()) {
                                        C16205ag.m24685b("mid: %d , server not response strategy, sdk local close it!", Integer.valueOf(c44541a.mo70959e()));
                                        obj2 = 1;
                                        c44541a.mo70953a(false);
                                    }
                                    i3++;
                                    obj2 = obj2;
                                }
                            }
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj3;
                    }
                    Map map = c5855ae.f1525d;
                    if (e == null) {
                        obj = null;
                    } else {
                        obj = null;
                        if (map == null || e.mo70941d() == null) {
                            if (map != null && e.mo70941d() == null) {
                                e.mo70937a(map);
                                obj = 1;
                            }
                        } else if (!map.equals(e.mo70941d())) {
                            e.mo70937a(map);
                            obj = 1;
                        }
                    }
                    obj = obj != null ? 1 : obj2;
                }
                if (obj != null) {
                    if (z) {
                        C16205ag.m24688e("update common strategy should save ", new Object[0]);
                        Context context = this.f18084a;
                        if (bArr != null) {
                            C44544y c44544y = new C44544y();
                            c44544y.mo70962a(i);
                            c44544y.mo70964a(bArr);
                            C24349e.m37581a(context, c44544y);
                        }
                    }
                    C16205ag.m24688e("com strategy changed notify! ", new Object[0]);
                    C36541t a = C36541t.m60530a(this.f18084a);
                    a.mo57783a(e);
                    if (z) {
                        a.mo57787b();
                    }
                }
                AppMethodBeat.m2505o(98547);
                return;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d("error to common strategy!", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(98547);
    }
}
