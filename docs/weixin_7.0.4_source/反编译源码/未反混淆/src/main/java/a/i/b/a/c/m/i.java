package a.i.b.a.c.m;

import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.l.w;
import a.i.b.a.c.m.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class i extends a {
    private static final List<d> BLH;
    public static final i BLI = new i();

    static final class c extends k implements a.f.a.b<t, String> {
        public static final c BLM = new c();

        static {
            AppMethodBeat.i(122884);
            AppMethodBeat.o(122884);
        }

        c() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            Object obj2;
            AppMethodBeat.i(122883);
            t tVar = (t) obj;
            j.p(tVar, "receiver$0");
            ak dYR = tVar.dYR();
            if (dYR == null) {
                dYR = tVar.dYQ();
            }
            i iVar = i.BLI;
            if (dYR != null) {
                boolean c;
                w dYT = tVar.dYT();
                if (dYT != null) {
                    w dZS = dYR.dZS();
                    j.o(dZS, "receiver.type");
                    c = a.i.b.a.c.l.c.a.c(dYT, dZS);
                } else {
                    c = false;
                }
                if (c) {
                    obj2 = 1;
                    if (obj2 != null) {
                        String str = "receiver must be a supertype of the return type";
                        AppMethodBeat.o(122883);
                        return str;
                    }
                    AppMethodBeat.o(122883);
                    return null;
                }
            }
            obj2 = null;
            if (obj2 != null) {
            }
        }
    }

    static final class a extends k implements a.f.a.b<t, String> {
        public static final a BLJ = new a();

        static {
            AppMethodBeat.i(122877);
            AppMethodBeat.o(122877);
        }

        a() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            Object obj2;
            i iVar;
            AppMethodBeat.i(122876);
            t tVar = (t) obj;
            j.p(tVar, "receiver$0");
            List dYV = tVar.dYV();
            j.o(dYV, "valueParameters");
            au auVar = (au) a.a.t.fM(dYV);
            if (auVar != null) {
                if (a.i.b.a.c.i.c.a.b(auVar) || auVar.dZV() != null) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 == 1) {
                    obj2 = 1;
                    iVar = i.BLI;
                    if (obj2 != null) {
                        String str = "last parameter should not have a default value or be a vararg";
                        AppMethodBeat.o(122876);
                        return str;
                    }
                    AppMethodBeat.o(122876);
                    return null;
                }
            }
            obj2 = null;
            iVar = i.BLI;
            if (obj2 != null) {
            }
        }
    }

    static final class b extends k implements a.f.a.b<t, String> {
        public static final b BLK = new b();

        static {
            AppMethodBeat.i(122882);
            AppMethodBeat.o(122882);
        }

        b() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            Object obj2;
            AppMethodBeat.i(122881);
            t tVar = (t) obj;
            j.p(tVar, "receiver$0");
            AnonymousClass1 anonymousClass1 = AnonymousClass1.BLL;
            i iVar = i.BLI;
            l dXW = tVar.dXW();
            j.o(dXW, "containingDeclaration");
            if (!AnonymousClass1.M(dXW)) {
                Collection dYX = tVar.dYX();
                j.o(dYX, "overriddenDescriptors");
                Iterable<t> iterable = dYX;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (t tVar2 : iterable) {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.BLL;
                        j.o(tVar2, "it");
                        dXW = tVar2.dXW();
                        j.o(dXW, "it.containingDeclaration");
                        if (AnonymousClass1.M(dXW)) {
                            obj2 = 1;
                            break;
                        }
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                    obj2 = null;
                    if (obj2 != null) {
                        String str = "must override ''equals()'' in Any";
                        AppMethodBeat.o(122881);
                        return str;
                    }
                    AppMethodBeat.o(122881);
                    return null;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
            }
        }
    }

    static {
        AppMethodBeat.i(122885);
        d[] dVarArr = new d[18];
        dVarArr[0] = new d(j.BLV, new b[]{a.i.b.a.c.m.f.b.BLE, new a.i.b.a.c.m.l.a(1)});
        dVarArr[1] = new d(j.BLW, new b[]{a.i.b.a.c.m.f.b.BLE, new a.i.b.a.c.m.l.a(2)}, (a.f.a.b) a.BLJ);
        dVarArr[2] = new d(j.BLN, new b[]{a.i.b.a.c.m.f.b.BLE, h.BLG, new a.i.b.a.c.m.l.a(2), e.BLC});
        dVarArr[3] = new d(j.BLO, new b[]{a.i.b.a.c.m.f.b.BLE, h.BLG, new a.i.b.a.c.m.l.a(3), e.BLC});
        dVarArr[4] = new d(j.BLP, new b[]{a.i.b.a.c.m.f.b.BLE, h.BLG, new a.i.b.a.c.m.l.b(), e.BLC});
        dVarArr[5] = new d(j.BLT, new b[]{a.i.b.a.c.m.f.b.BLE});
        dVarArr[6] = new d(j.BLS, new b[]{a.i.b.a.c.m.f.b.BLE, d.BMH, h.BLG, a.i.b.a.c.m.k.a.BMA});
        dVarArr[7] = new d(j.BLU, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.l.c.BMG});
        dVarArr[8] = new d(j.BLX, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.l.c.BMG});
        dVarArr[9] = new d(j.BLY, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.l.c.BMG, a.i.b.a.c.m.k.a.BMA});
        dVarArr[10] = new d(j.BMn, new b[]{a.i.b.a.c.m.f.b.BLE, d.BMH, h.BLG});
        dVarArr[11] = new d(j.BLQ, new b[]{a.i.b.a.c.m.f.a.BLD}, (a.f.a.b) b.BLK);
        dVarArr[12] = new d(j.BLR, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.k.b.BMC, d.BMH, h.BLG});
        dVarArr[13] = new d((Collection) j.BMw, new b[]{a.i.b.a.c.m.f.b.BLE, d.BMH, h.BLG});
        dVarArr[14] = new d((Collection) j.BMv, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.l.c.BMG});
        dVarArr[15] = new d((Collection) a.a.l.listOf(j.BMc, j.BMd), new b[]{a.i.b.a.c.m.f.b.BLE}, (a.f.a.b) c.BLM);
        dVarArr[16] = new d((Collection) j.BMx, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.k.c.BME, d.BMH, h.BLG});
        dVarArr[17] = new d(j.BLZ, new b[]{a.i.b.a.c.m.f.b.BLE, a.i.b.a.c.m.l.c.BMG});
        BLH = a.a.l.listOf(dVarArr);
        AppMethodBeat.o(122885);
    }

    private i() {
    }

    public final List<d> ekt() {
        return BLH;
    }
}
