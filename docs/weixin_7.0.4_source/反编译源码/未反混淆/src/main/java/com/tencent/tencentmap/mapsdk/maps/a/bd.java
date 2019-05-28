package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.e;
import com.tencent.tencentmap.mapsdk.maps.a.v.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class bd {
    private Context a = null;

    public bd(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x028e A:{Catch:{ Throwable -> 0x0267 }} */
    /* JADX WARNING: Missing block: B:79:0x01df, code skipped:
            if (r1.d().equals(r2.e) == false) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:86:0x0211, code skipped:
            if (r1.f().equals(r2.f) == false) goto L_0x0213;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, byte[] bArr, boolean z) {
        AppMethodBeat.i(98547);
        if (i != 101) {
            ag.c("com strategy unmatch key: %d", Integer.valueOf(i));
            AppMethodBeat.o(98547);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            v e = t.a(this.a).e();
            if (e == null) {
                ag.c("imposible! common strategy null!", new Object[0]);
                AppMethodBeat.o(98547);
                return;
            }
            try {
                Object obj;
                ae aeVar = new ae();
                aeVar.a(new ai(bArr));
                if (e == null) {
                    obj = null;
                } else {
                    Object obj2;
                    Object obj3 = null;
                    if (!aeVar.c.equals(e.b())) {
                        ag.b("strategy url changed to: %s", aeVar.c);
                        obj3 = 1;
                        e.a(aeVar.c);
                    }
                    if (aeVar.b != e.c()) {
                        ag.b("QueryPeriod changed to: %d", Integer.valueOf(aeVar.b));
                        obj3 = 1;
                        e.a(aeVar.b);
                    }
                    ArrayList arrayList = aeVar.a;
                    if (e == null) {
                        obj = null;
                    } else {
                        obj = null;
                        int i2;
                        a aVar;
                        if (arrayList != null) {
                            SparseArray e2 = e.e();
                            if (e2 != null) {
                                i2 = 0;
                                obj2 = null;
                                while (i2 < e2.size()) {
                                    aVar = (a) e2.valueAt(i2);
                                    Iterator it = arrayList.iterator();
                                    Object obj4 = obj2;
                                    while (it.hasNext()) {
                                        af afVar = (af) it.next();
                                        if (afVar.a == aVar.e()) {
                                            ag.a("server module strategy mid: %d", Byte.valueOf(afVar.a));
                                            boolean z2 = afVar.b == (byte) 1;
                                            if (aVar.a() != z2) {
                                                ag.b("mid: %d , isUsable changed: %b ", Byte.valueOf(afVar.a), Boolean.valueOf(z2));
                                                obj4 = 1;
                                                aVar.a(z2);
                                            }
                                            if (!aVar.b().equals(afVar.c)) {
                                                ag.b("mid: %d , url changed: %s", Byte.valueOf(afVar.a), afVar.c);
                                                obj4 = 1;
                                                aVar.a(afVar.c);
                                            }
                                            if (afVar.a == (byte) 1 || afVar.a == (byte) 2) {
                                                if (aVar.c() == null || afVar.d == null) {
                                                    if (afVar.d != null && aVar.c() == null) {
                                                        ag.b("mid: %d , detail changed...", Byte.valueOf(afVar.a));
                                                        obj4 = 1;
                                                        aVar.a(afVar.d);
                                                        t.a(this.a).a(afVar.a, afVar.d);
                                                    }
                                                } else if (!aVar.c().equals(afVar.d)) {
                                                    ag.b("mid: %d , detail changed...", Byte.valueOf(afVar.a));
                                                    obj4 = 1;
                                                    aVar.a(afVar.d);
                                                    t.a(this.a).a(afVar.a, afVar.d);
                                                }
                                            }
                                            if (afVar.a == (byte) 1) {
                                                if (aVar.d() == null || afVar.e == null) {
                                                    if (aVar.d() == null) {
                                                        if (afVar.e != null) {
                                                        }
                                                        if (aVar.f() != null || afVar.f == null) {
                                                            if (aVar.f() == null) {
                                                                if (afVar.f != null) {
                                                                }
                                                            }
                                                        }
                                                        ag.b("mid: %d , SampleEventSet changed...", Byte.valueOf(afVar.a));
                                                        obj4 = 1;
                                                        aVar.b(e.a(afVar.f));
                                                    }
                                                }
                                                ag.b("mid: %d , PreventEventCode changed...", Byte.valueOf(afVar.a));
                                                obj4 = 1;
                                                aVar.a(e.a(afVar.e));
                                                if (aVar.f() != null) {
                                                }
                                                if (aVar.f() == null) {
                                                }
                                                ag.b("mid: %d , SampleEventSet changed...", Byte.valueOf(afVar.a));
                                                obj4 = 1;
                                                aVar.b(e.a(afVar.f));
                                            }
                                        }
                                        obj4 = obj4;
                                    }
                                    i2++;
                                    obj2 = obj4;
                                }
                            }
                        } else {
                            SparseArray e3 = e.e();
                            if (e3 != null) {
                                i2 = e3.size();
                                int i3 = 0;
                                obj2 = null;
                                while (i3 < i2) {
                                    aVar = (a) e3.valueAt(i3);
                                    if (aVar.a()) {
                                        ag.b("mid: %d , server not response strategy, sdk local close it!", Integer.valueOf(aVar.e()));
                                        obj2 = 1;
                                        aVar.a(false);
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
                    Map map = aeVar.d;
                    if (e == null) {
                        obj = null;
                    } else {
                        obj = null;
                        if (map == null || e.d() == null) {
                            if (map != null && e.d() == null) {
                                e.a(map);
                                obj = 1;
                            }
                        } else if (!map.equals(e.d())) {
                            e.a(map);
                            obj = 1;
                        }
                    }
                    obj = obj != null ? 1 : obj2;
                }
                if (obj != null) {
                    if (z) {
                        ag.e("update common strategy should save ", new Object[0]);
                        Context context = this.a;
                        if (bArr != null) {
                            y yVar = new y();
                            yVar.a(i);
                            yVar.a(bArr);
                            e.a(context, yVar);
                        }
                    }
                    ag.e("com strategy changed notify! ", new Object[0]);
                    t a = t.a(this.a);
                    a.a(e);
                    if (z) {
                        a.b();
                    }
                }
                AppMethodBeat.o(98547);
                return;
            } catch (Throwable th) {
                ag.a(th);
                ag.d("error to common strategy!", new Object[0]);
            }
        }
        AppMethodBeat.o(98547);
    }
}
