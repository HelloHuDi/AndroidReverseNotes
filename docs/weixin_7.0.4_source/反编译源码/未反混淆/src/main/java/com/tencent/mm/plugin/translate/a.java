package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements at {
    ak handler = new ak(Looper.getMainLooper());
    c sKl = b.sKz;
    az sKm = new az(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private com.tencent.mm.plugin.translate.a.c.a sKn = new com.tencent.mm.plugin.translate.a.c.a() {
        public final void a(final int i, SparseArray<c.c> sparseArray) {
            AppMethodBeat.i(26049);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < sparseArray.size()) {
                    final c.c cVar = (c.c) sparseArray.valueAt(i3);
                    if (cVar != null) {
                        a.this.sKm.e(new com.tencent.mm.sdk.platformtools.az.a() {
                            public final boolean acg() {
                                AppMethodBeat.i(26047);
                                int i = i != 0 ? i : cVar.ret;
                                tj tjVar = new tj();
                                tjVar.cPF.ret = i;
                                tjVar.cPF.cPz = cVar.cPz;
                                tjVar.cPF.id = cVar.id;
                                tjVar.cPF.cPG = cVar.cPG;
                                tjVar.cPF.type = cVar.type;
                                tjVar.cPF.source = cVar.source;
                                tjVar.cPF.cNS = cVar.cNS;
                                com.tencent.mm.sdk.b.a.xxA.m(tjVar);
                                AppMethodBeat.o(26047);
                                return false;
                            }

                            public final boolean acf() {
                                AppMethodBeat.i(26048);
                                ab.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", cVar.id);
                                if (i != 0) {
                                    ab.e("MicroMsg.SubCoreTranslate", "translate error");
                                    AppMethodBeat.o(26048);
                                } else if (cVar.ret != 0) {
                                    ab.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", Integer.valueOf(cVar.ret));
                                    AppMethodBeat.o(26048);
                                } else if (bo.isNullOrNil(cVar.cPG)) {
                                    ab.e("MicroMsg.SubCoreTranslate", "translate return null");
                                    AppMethodBeat.o(26048);
                                } else {
                                    if (cVar.type == 0 || cVar.type == 1) {
                                        ab.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                        c.c cVar = cVar;
                                        aw.ZK();
                                        bi jf = com.tencent.mm.model.c.XO().jf(bo.anl(cVar.id));
                                        jf.jx(bo.vA(cVar.cPG));
                                        jf.field_transBrandWording = bo.vA(bo.nullAsNil(cVar.cNS));
                                        jf.dJm = true;
                                        jf.dJG = cVar.dJG;
                                        jf.dqp = true;
                                        if (cVar.sKA == 1) {
                                            if (jf.dtF()) {
                                                jf.ht(jf.dqI | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                            }
                                        } else if (jf.dtF()) {
                                            jf.ht(jf.dqI & -1025);
                                        }
                                        ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
                                    }
                                    AppMethodBeat.o(26048);
                                }
                                return true;
                            }
                        });
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(26049);
                    return;
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c sKo = new com.tencent.mm.sdk.b.c<th>() {
        {
            AppMethodBeat.i(26051);
            this.xxI = th.class.getName().hashCode();
            AppMethodBeat.o(26051);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(26052);
            final th thVar = (th) bVar;
            ab.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            a.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26050);
                    c cVar = a.this.sKl;
                    String str = thVar.cPy.cPz;
                    String str2 = thVar.cPy.id;
                    int i = thVar.cPy.type;
                    String str3 = thVar.cPy.source;
                    boolean z = thVar.cPy.cPA;
                    byte[] bArr = thVar.cPy.cPB;
                    ab.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", str2, Integer.valueOf(i));
                    if (cVar.abQ(str2)) {
                        ab.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", str2);
                        AppMethodBeat.o(26050);
                        return;
                    }
                    c.c cVar2 = new c.c(str, str2, i, str3, bArr);
                    if (z) {
                        ((LinkedList) cVar.sKx).add(0, cVar2);
                    } else {
                        cVar.sKx.add(cVar2);
                    }
                    cVar.sKy.put(cVar2.id, Integer.valueOf(cVar2.sKB));
                    ab.d("MicroMsg.TranslateServiceManager", "requestCount : %s", Integer.valueOf(cVar.exv));
                    cVar.cHI();
                    AppMethodBeat.o(26050);
                }
            });
            AppMethodBeat.o(26052);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c sKp = new com.tencent.mm.sdk.b.c<ti>() {
        {
            AppMethodBeat.i(26053);
            this.xxI = ti.class.getName().hashCode();
            AppMethodBeat.o(26053);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(26054);
            ti tiVar = (ti) bVar;
            tiVar.cPD.cPE = a.this.sKl.abQ(tiVar.cPC.id);
            AppMethodBeat.o(26054);
            return true;
        }
    };

    public a() {
        AppMethodBeat.i(26055);
        AppMethodBeat.o(26055);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(26056);
        c cVar = this.sKl;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.sKn;
        if (!(aVar == null || cVar.eES.contains(aVar))) {
            cVar.eES.add(aVar);
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.sKo);
        com.tencent.mm.sdk.b.a.xxA.c(this.sKp);
        AppMethodBeat.o(26056);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(26057);
        com.tencent.mm.sdk.b.a.xxA.d(this.sKo);
        com.tencent.mm.sdk.b.a.xxA.d(this.sKp);
        c cVar = this.sKl;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.sKn;
        if (aVar != null && cVar.eES.contains(aVar)) {
            cVar.eES.remove(aVar);
        }
        c cVar2 = this.sKl;
        if (cVar2.sKw != null) {
            for (f fVar : cVar2.sKw) {
                if (fVar != null) {
                    aw.Rg().b(631, fVar);
                    if (fVar.sKG != null) {
                        fVar.sKI.stopTimer();
                        aw.Rg().c(fVar.sKG);
                    }
                    fVar.cHJ();
                    fVar.sKE = null;
                }
            }
        }
        cVar2.sKy.clear();
        cVar2.sKx.clear();
        cVar2.eES.clear();
        cVar2.exv = 0;
        AppMethodBeat.o(26057);
    }
}
