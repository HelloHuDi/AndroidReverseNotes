package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p047m.C41461k.C0168a;
import p000a.p010i.p011b.p012a.p015c.p047m.C41461k.C8251b;
import p000a.p010i.p011b.p012a.p015c.p047m.C41461k.C8252c;
import p000a.p010i.p011b.p012a.p015c.p047m.C41462l.C0170a;
import p000a.p010i.p011b.p012a.p015c.p047m.C41462l.C31777b;
import p000a.p010i.p011b.p012a.p015c.p047m.C41462l.C31778c;
import p000a.p010i.p011b.p012a.p015c.p047m.C41462l.C31779d;
import p000a.p010i.p011b.p012a.p015c.p047m.C8248f.C8249b;
import p000a.p010i.p011b.p012a.p015c.p047m.C8248f.C8250a;

/* renamed from: a.i.b.a.c.m.i */
public final class C44926i extends C37060a {
    private static final List<C37065d> BLH;
    public static final C44926i BLI = new C44926i();

    /* renamed from: a.i.b.a.c.m.i$c */
    static final class C31237c extends C25053k implements C17126b<C8083t, String> {
        public static final C31237c BLM = new C31237c();

        static {
            AppMethodBeat.m2504i(122884);
            AppMethodBeat.m2505o(122884);
        }

        C31237c() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            Object obj2;
            AppMethodBeat.m2504i(122883);
            C8083t c8083t = (C8083t) obj;
            C25052j.m39376p(c8083t, "receiver$0");
            C41396ak dYR = c8083t.dYR();
            if (dYR == null) {
                dYR = c8083t.dYQ();
            }
            C44926i c44926i = C44926i.BLI;
            if (dYR != null) {
                boolean c;
                C46867w dYT = c8083t.dYT();
                if (dYT != null) {
                    C46867w dZS = dYR.dZS();
                    C25052j.m39375o(dZS, "receiver.type");
                    c = C41448a.m72318c(dYT, dZS);
                } else {
                    c = false;
                }
                if (c) {
                    obj2 = 1;
                    if (obj2 != null) {
                        String str = "receiver must be a supertype of the return type";
                        AppMethodBeat.m2505o(122883);
                        return str;
                    }
                    AppMethodBeat.m2505o(122883);
                    return null;
                }
            }
            obj2 = null;
            if (obj2 != null) {
            }
        }
    }

    /* renamed from: a.i.b.a.c.m.i$a */
    static final class C41458a extends C25053k implements C17126b<C8083t, String> {
        public static final C41458a BLJ = new C41458a();

        static {
            AppMethodBeat.m2504i(122877);
            AppMethodBeat.m2505o(122877);
        }

        C41458a() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            Object obj2;
            C44926i c44926i;
            AppMethodBeat.m2504i(122876);
            C8083t c8083t = (C8083t) obj;
            C25052j.m39376p(c8083t, "receiver$0");
            List dYV = c8083t.dYV();
            C25052j.m39375o(dYV, "valueParameters");
            C41399au c41399au = (C41399au) C25035t.m39340fM(dYV);
            if (c41399au != null) {
                if (C41434a.m72280b(c41399au) || c41399au.dZV() != null) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 == 1) {
                    obj2 = 1;
                    c44926i = C44926i.BLI;
                    if (obj2 != null) {
                        String str = "last parameter should not have a default value or be a vararg";
                        AppMethodBeat.m2505o(122876);
                        return str;
                    }
                    AppMethodBeat.m2505o(122876);
                    return null;
                }
            }
            obj2 = null;
            c44926i = C44926i.BLI;
            if (obj2 != null) {
            }
        }
    }

    /* renamed from: a.i.b.a.c.m.i$b */
    static final class C41459b extends C25053k implements C17126b<C8083t, String> {
        public static final C41459b BLK = new C41459b();

        /* renamed from: a.i.b.a.c.m.i$b$1 */
        static final class C414601 extends C25053k implements C17126b<C31642l, Boolean> {
            public static final C414601 BLL = new C414601();

            static {
                AppMethodBeat.m2504i(122880);
                AppMethodBeat.m2505o(122880);
            }

            C414601() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122878);
                Boolean valueOf = Boolean.valueOf(C414601.m72340M((C31642l) obj));
                AppMethodBeat.m2505o(122878);
                return valueOf;
            }

            /* renamed from: M */
            public static boolean m72340M(C31642l c31642l) {
                AppMethodBeat.m2504i(122879);
                C25052j.m39376p(c31642l, "receiver$0");
                if ((c31642l instanceof C46865e) && C31619g.m51120f((C46865e) c31642l)) {
                    AppMethodBeat.m2505o(122879);
                    return true;
                }
                AppMethodBeat.m2505o(122879);
                return false;
            }
        }

        static {
            AppMethodBeat.m2504i(122882);
            AppMethodBeat.m2505o(122882);
        }

        C41459b() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            Object obj2;
            AppMethodBeat.m2504i(122881);
            C8083t c8083t = (C8083t) obj;
            C25052j.m39376p(c8083t, "receiver$0");
            C414601 c414601 = C414601.BLL;
            C44926i c44926i = C44926i.BLI;
            C31642l dXW = c8083t.dXW();
            C25052j.m39375o(dXW, "containingDeclaration");
            if (!C414601.m72340M(dXW)) {
                Collection dYX = c8083t.dYX();
                C25052j.m39375o(dYX, "overriddenDescriptors");
                Iterable<C8083t> iterable = dYX;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (C8083t c8083t2 : iterable) {
                        C414601 c4146012 = C414601.BLL;
                        C25052j.m39375o(c8083t2, "it");
                        dXW = c8083t2.dXW();
                        C25052j.m39375o(dXW, "it.containingDeclaration");
                        if (C414601.m72340M(dXW)) {
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
                        AppMethodBeat.m2505o(122881);
                        return str;
                    }
                    AppMethodBeat.m2505o(122881);
                    return null;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
            }
        }
    }

    static {
        AppMethodBeat.m2504i(122885);
        C37065d[] c37065dArr = new C37065d[18];
        c37065dArr[0] = new C37065d(C37066j.BLV, new C44925b[]{C8249b.BLE, new C0170a(1)});
        c37065dArr[1] = new C37065d(C37066j.BLW, new C44925b[]{C8249b.BLE, new C0170a(2)}, (C17126b) C41458a.BLJ);
        c37065dArr[2] = new C37065d(C37066j.BLN, new C44925b[]{C8249b.BLE, C17329h.BLG, new C0170a(2), C25241e.BLC});
        c37065dArr[3] = new C37065d(C37066j.BLO, new C44925b[]{C8249b.BLE, C17329h.BLG, new C0170a(3), C25241e.BLC});
        c37065dArr[4] = new C37065d(C37066j.BLP, new C44925b[]{C8249b.BLE, C17329h.BLG, new C31777b(), C25241e.BLC});
        c37065dArr[5] = new C37065d(C37066j.BLT, new C44925b[]{C8249b.BLE});
        c37065dArr[6] = new C37065d(C37066j.BLS, new C44925b[]{C8249b.BLE, C31779d.BMH, C17329h.BLG, C0168a.BMA});
        c37065dArr[7] = new C37065d(C37066j.BLU, new C44925b[]{C8249b.BLE, C31778c.BMG});
        c37065dArr[8] = new C37065d(C37066j.BLX, new C44925b[]{C8249b.BLE, C31778c.BMG});
        c37065dArr[9] = new C37065d(C37066j.BLY, new C44925b[]{C8249b.BLE, C31778c.BMG, C0168a.BMA});
        c37065dArr[10] = new C37065d(C37066j.BMn, new C44925b[]{C8249b.BLE, C31779d.BMH, C17329h.BLG});
        c37065dArr[11] = new C37065d(C37066j.BLQ, new C44925b[]{C8250a.BLD}, (C17126b) C41459b.BLK);
        c37065dArr[12] = new C37065d(C37066j.BLR, new C44925b[]{C8249b.BLE, C8251b.BMC, C31779d.BMH, C17329h.BLG});
        c37065dArr[13] = new C37065d((Collection) C37066j.BMw, new C44925b[]{C8249b.BLE, C31779d.BMH, C17329h.BLG});
        c37065dArr[14] = new C37065d((Collection) C37066j.BMv, new C44925b[]{C8249b.BLE, C31778c.BMG});
        c37065dArr[15] = new C37065d((Collection) C7987l.listOf(C37066j.BMc, C37066j.BMd), new C44925b[]{C8249b.BLE}, (C17126b) C31237c.BLM);
        c37065dArr[16] = new C37065d((Collection) C37066j.BMx, new C44925b[]{C8249b.BLE, C8252c.BME, C31779d.BMH, C17329h.BLG});
        c37065dArr[17] = new C37065d(C37066j.BLZ, new C44925b[]{C8249b.BLE, C31778c.BMG});
        BLH = C7987l.listOf(c37065dArr);
        AppMethodBeat.m2505o(122885);
    }

    private C44926i() {
    }

    public final List<C37065d> ekt() {
        return BLH;
    }
}
