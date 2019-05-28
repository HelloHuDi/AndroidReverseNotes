package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class w {
    public static b fuq = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, m mVar);
    }

    public interface b {
        p Rh();
    }

    static final class c implements a, com.tencent.mm.vending.e.a {
        private a fuA;

        public c(a aVar) {
            this.fuA = aVar;
        }

        public final void dead() {
            this.fuA = null;
        }

        public final int a(int i, int i2, String str, b bVar, m mVar) {
            AppMethodBeat.i(58304);
            if (this.fuA != null) {
                int a = this.fuA.a(i, i2, str, bVar, mVar);
                AppMethodBeat.o(58304);
                return a;
            }
            AppMethodBeat.o(58304);
            return -100000;
        }
    }

    public static boolean adF() {
        AppMethodBeat.i(58305);
        if (fuq == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(58305);
            return false;
        } else if (fuq.Rh() == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(58305);
            return false;
        } else {
            AppMethodBeat.o(58305);
            return true;
        }
    }

    public static void c(m mVar) {
        AppMethodBeat.i(58306);
        if (fuq == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(58306);
        } else if (fuq.Rh() == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(58306);
        } else if (mVar == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
            AppMethodBeat.o(58306);
        } else {
            fuq.Rh().c(mVar);
            AppMethodBeat.o(58306);
        }
    }

    public static m a(b bVar, a aVar, boolean z) {
        AppMethodBeat.i(139009);
        m a = a(bVar, aVar, z, null);
        AppMethodBeat.o(139009);
        return a;
    }

    public static m a(b bVar, a aVar, boolean z, com.tencent.mm.vending.e.b bVar2) {
        AppMethodBeat.i(58310);
        com.tencent.mm.vending.e.a cVar = new c(aVar);
        if (aVar == null) {
            cVar = null;
        }
        if (!(bVar2 == null || cVar == null)) {
            bVar2.keep(cVar);
        }
        m b = b(bVar, cVar, z);
        AppMethodBeat.o(58310);
        return b;
    }

    private static m b(final b bVar, final a aVar, final boolean z) {
        AppMethodBeat.i(138431);
        if (fuq == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(138431);
            return null;
        } else if (fuq.Rh() == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(138431);
            return null;
        } else if (bVar == null) {
            ab.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            AppMethodBeat.o(138431);
            return null;
        } else {
            m anonymousClass1 = new m() {
                private k fsE = new k() {
                    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                        AppMethodBeat.i(58296);
                        if (AnonymousClass1.this.fut != 2) {
                            AnonymousClass1.this.fuu.stopTimer();
                            AnonymousClass1.this.fut = 1;
                            w.a(z, aVar, i2, i3, str, bVar, AnonymousClass1.this.fus);
                        } else {
                            ab.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.fus.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bo.anU() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        AnonymousClass1.this.fur.onSceneEnd(i2, i3, str, AnonymousClass1.this.fus);
                        ab.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.fus.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bo.anU() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.o(58296);
                    }
                };
                f fur = null;
                final m fus = this;
                int fut = 0;
                ap fuu = new ap(w.fuq.Rh().ftB.oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(58297);
                        ab.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(AnonymousClass1.this.fus.bqV), Integer.valueOf(AnonymousClass1.this.fus.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bo.anU() - AnonymousClass1.this.startTime));
                        if (AnonymousClass1.this.fus.bqV) {
                            AppMethodBeat.o(58297);
                        } else if (AnonymousClass1.this.fut == 1) {
                            AppMethodBeat.o(58297);
                        } else {
                            AnonymousClass1.this.fut = 2;
                            w.a(z, aVar, 3, -1, "", bVar, AnonymousClass1.this.fus);
                            AppMethodBeat.o(58297);
                        }
                        return false;
                    }

                    public final String toString() {
                        AppMethodBeat.i(58298);
                        String str = super.toString() + "|protectNotCallback";
                        AppMethodBeat.o(58298);
                        return str;
                    }
                }, false);
                final long startTime = bo.anU();

                public final int getType() {
                    return bVar.fsI;
                }

                public final int a(e eVar, f fVar) {
                    AppMethodBeat.i(58300);
                    this.fur = fVar;
                    int a = a(eVar, bVar, this.fsE);
                    ab.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.fus.hashCode()), Integer.valueOf(bVar.fsI), Integer.valueOf(a), Long.valueOf(bo.anU() - this.startTime));
                    if (aVar != null) {
                        if (a < 0) {
                            w.a(z, aVar, 3, -1, "", bVar, this.fus);
                        } else {
                            this.fuu.ae(60000, 60000);
                        }
                    }
                    AppMethodBeat.o(58300);
                    return a;
                }
            };
            if (fuq.Rh().a(anonymousClass1, 0)) {
                AppMethodBeat.o(138431);
                return anonymousClass1;
            }
            AppMethodBeat.o(138431);
            return null;
        }
    }

    public static b b(b bVar) {
        AppMethodBeat.i(58307);
        a(bVar, null, false, null);
        AppMethodBeat.o(58307);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        AppMethodBeat.i(58308);
        a(bVar, aVar, false, null);
        AppMethodBeat.o(58308);
        return bVar;
    }

    static /* synthetic */ int a(boolean z, a aVar, int i, int i2, String str, b bVar, m mVar) {
        AppMethodBeat.i(58312);
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final m mVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                mVar2 = mVar;
                fuq.Rh().ftB.aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(58301);
                        aVar2.a(i3, i4, str2, bVar2, mVar2);
                        AppMethodBeat.o(58301);
                    }

                    public final String toString() {
                        AppMethodBeat.i(58302);
                        String str = super.toString() + "|tryCallback";
                        AppMethodBeat.o(58302);
                        return str;
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                mVar2 = mVar;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(58303);
                        aVar2.a(i3, i4, str2, bVar2, mVar2);
                        AppMethodBeat.o(58303);
                    }
                });
            }
        }
        AppMethodBeat.o(58312);
        return 0;
    }
}
