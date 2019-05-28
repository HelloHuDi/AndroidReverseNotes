package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;

/* renamed from: com.tencent.mm.ai.w */
public final class C1226w {
    public static C1225b fuq = null;

    /* renamed from: com.tencent.mm.ai.w$a */
    public interface C1224a {
        /* renamed from: a */
        int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m);
    }

    /* renamed from: com.tencent.mm.ai.w$b */
    public interface C1225b {
        /* renamed from: Rh */
        C6300p mo4497Rh();
    }

    /* renamed from: com.tencent.mm.ai.w$c */
    static final class C1230c implements C1224a, C5684a {
        private C1224a fuA;

        public C1230c(C1224a c1224a) {
            this.fuA = c1224a;
        }

        public final void dead() {
            this.fuA = null;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(58304);
            if (this.fuA != null) {
                int a = this.fuA.mo4496a(i, i2, str, c7472b, c1207m);
                AppMethodBeat.m2505o(58304);
                return a;
            }
            AppMethodBeat.m2505o(58304);
            return -100000;
        }
    }

    public static boolean adF() {
        AppMethodBeat.m2504i(58305);
        if (fuq == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.m2505o(58305);
            return false;
        } else if (fuq.mo4497Rh() == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.m2505o(58305);
            return false;
        } else {
            AppMethodBeat.m2505o(58305);
            return true;
        }
    }

    /* renamed from: c */
    public static void m2659c(C1207m c1207m) {
        AppMethodBeat.m2504i(58306);
        if (fuq == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.m2505o(58306);
        } else if (fuq.mo4497Rh() == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.m2505o(58306);
        } else if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
            AppMethodBeat.m2505o(58306);
        } else {
            fuq.mo4497Rh().mo14547c(c1207m);
            AppMethodBeat.m2505o(58306);
        }
    }

    /* renamed from: a */
    public static C1207m m2655a(C7472b c7472b, C1224a c1224a, boolean z) {
        AppMethodBeat.m2504i(139009);
        C1207m a = C1226w.m2656a(c7472b, c1224a, z, null);
        AppMethodBeat.m2505o(139009);
        return a;
    }

    /* renamed from: a */
    public static C1207m m2656a(C7472b c7472b, C1224a c1224a, boolean z, C5685b c5685b) {
        AppMethodBeat.m2504i(58310);
        C5684a c1230c = new C1230c(c1224a);
        if (c1224a == null) {
            c1230c = null;
        }
        if (!(c5685b == null || c1230c == null)) {
            c5685b.keep(c1230c);
        }
        C1207m b = C1226w.m2658b(c7472b, c1230c, z);
        AppMethodBeat.m2505o(58310);
        return b;
    }

    /* renamed from: b */
    private static C1207m m2658b(final C7472b c7472b, final C1224a c1224a, final boolean z) {
        AppMethodBeat.m2504i(138431);
        if (fuq == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.m2505o(138431);
            return null;
        } else if (fuq.mo4497Rh() == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.m2505o(138431);
            return null;
        } else if (c7472b == null) {
            C4990ab.m7412e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            AppMethodBeat.m2505o(138431);
            return null;
        } else {
            C1207m c12271 = new C1207m() {
                private C1918k fsE = new C12281();
                C1202f fur = null;
                final C1207m fus = this;
                int fut = 0;
                C7564ap fuu = new C7564ap(C1226w.fuq.mo4497Rh().ftB.oAl.getLooper(), new C12292(), false);
                final long startTime = C5046bo.anU();

                /* renamed from: com.tencent.mm.ai.w$1$1 */
                class C12281 implements C1918k {
                    C12281() {
                    }

                    /* renamed from: a */
                    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
                        AppMethodBeat.m2504i(58296);
                        if (C12271.this.fut != 2) {
                            C12271.this.fuu.stopTimer();
                            C12271.this.fut = 1;
                            C1226w.m2653a(z, c1224a, i2, i3, str, c7472b, C12271.this.fus);
                        } else {
                            C4990ab.m7421w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(C12271.this.fus.hashCode()), Integer.valueOf(C12271.this.getType()), Long.valueOf(C5046bo.anU() - C12271.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        C12271.this.fur.onSceneEnd(i2, i3, str, C12271.this.fus);
                        C4990ab.m7417i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(C12271.this.fus.hashCode()), Integer.valueOf(C12271.this.getType()), Long.valueOf(C5046bo.anU() - C12271.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.m2505o(58296);
                    }
                }

                /* renamed from: com.tencent.mm.ai.w$1$2 */
                class C12292 implements C5015a {
                    C12292() {
                    }

                    /* renamed from: BI */
                    public final boolean mo4499BI() {
                        AppMethodBeat.m2504i(58297);
                        C4990ab.m7421w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(C12271.this.fus.bqV), Integer.valueOf(C12271.this.fus.hashCode()), Integer.valueOf(C12271.this.getType()), Long.valueOf(C5046bo.anU() - C12271.this.startTime));
                        if (C12271.this.fus.bqV) {
                            AppMethodBeat.m2505o(58297);
                        } else if (C12271.this.fut == 1) {
                            AppMethodBeat.m2505o(58297);
                        } else {
                            C12271.this.fut = 2;
                            C1226w.m2653a(z, c1224a, 3, -1, "", c7472b, C12271.this.fus);
                            AppMethodBeat.m2505o(58297);
                        }
                        return false;
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(58298);
                        String str = super.toString() + "|protectNotCallback";
                        AppMethodBeat.m2505o(58298);
                        return str;
                    }
                }

                public final int getType() {
                    return c7472b.fsI;
                }

                /* renamed from: a */
                public final int mo4456a(C1902e c1902e, C1202f c1202f) {
                    AppMethodBeat.m2504i(58300);
                    this.fur = c1202f;
                    int a = mo4457a(c1902e, c7472b, this.fsE);
                    C4990ab.m7417i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.fus.hashCode()), Integer.valueOf(c7472b.fsI), Integer.valueOf(a), Long.valueOf(C5046bo.anU() - this.startTime));
                    if (c1224a != null) {
                        if (a < 0) {
                            C1226w.m2653a(z, c1224a, 3, -1, "", c7472b, this.fus);
                        } else {
                            this.fuu.mo16770ae(60000, 60000);
                        }
                    }
                    AppMethodBeat.m2505o(58300);
                    return a;
                }
            };
            if (fuq.mo4497Rh().mo14541a(c12271, 0)) {
                AppMethodBeat.m2505o(138431);
                return c12271;
            }
            AppMethodBeat.m2505o(138431);
            return null;
        }
    }

    /* renamed from: b */
    public static C7472b m2657b(C7472b c7472b) {
        AppMethodBeat.m2504i(58307);
        C1226w.m2656a(c7472b, null, false, null);
        AppMethodBeat.m2505o(58307);
        return c7472b;
    }

    /* renamed from: a */
    public static C7472b m2654a(C7472b c7472b, C1224a c1224a) {
        AppMethodBeat.m2504i(58308);
        C1226w.m2656a(c7472b, c1224a, false, null);
        AppMethodBeat.m2505o(58308);
        return c7472b;
    }

    /* renamed from: a */
    static /* synthetic */ int m2653a(boolean z, C1224a c1224a, int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
        AppMethodBeat.m2504i(58312);
        if (c1224a != null) {
            final C1224a c1224a2;
            final int i3;
            final int i4;
            final String str2;
            final C7472b c7472b2;
            final C1207m c1207m2;
            if (z) {
                c1224a2 = c1224a;
                i3 = i;
                i4 = i2;
                str2 = str;
                c7472b2 = c7472b;
                c1207m2 = c1207m;
                fuq.mo4497Rh().ftB.mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(58301);
                        c1224a2.mo4496a(i3, i4, str2, c7472b2, c1207m2);
                        AppMethodBeat.m2505o(58301);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(58302);
                        String str = super.toString() + "|tryCallback";
                        AppMethodBeat.m2505o(58302);
                        return str;
                    }
                });
            } else {
                c1224a2 = c1224a;
                i3 = i;
                i4 = i2;
                str2 = str;
                c7472b2 = c7472b;
                c1207m2 = c1207m;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(58303);
                        c1224a2.mo4496a(i3, i4, str2, c7472b2, c1207m2);
                        AppMethodBeat.m2505o(58303);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(58312);
        return 0;
    }
}
