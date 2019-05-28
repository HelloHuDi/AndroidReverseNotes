package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.g;

public final class u extends c<pr> {
    Dialog gnn;

    public u() {
        AppMethodBeat.i(41000);
        this.xxI = pr.class.getName().hashCode();
        AppMethodBeat.o(41000);
    }

    private boolean a(final pr prVar) {
        AppMethodBeat.i(41001);
        ab.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", Integer.valueOf(prVar.cLS.type));
        if (prVar.cLS.aIq == null || prVar.cLS.aIq.get() == null) {
            ab.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            prVar.cLS.callback.run();
            AppMethodBeat.o(41001);
        } else {
            Context context = (Context) prVar.cLS.aIq.get();
            m kVar;
            if (prVar.cLS.type == 0) {
                this.gnn = g.a(context, false, null);
                kVar = new k(prVar.cLS.cLU, prVar.cLS.scene);
                com.tencent.mm.kernel.g.Rg().a(1800, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(40998);
                        if (u.this.gnn != null && u.this.gnn.isShowing()) {
                            u.this.gnn.dismiss();
                            u.this.gnn = null;
                        }
                        com.tencent.mm.kernel.g.Rg().b(1800, (f) this);
                        final k kVar = (k) mVar;
                        kVar.a(new a<k>() {
                            public final /* bridge */ /* synthetic */ void e(int i, int i2, String str, m mVar) {
                                k kVar = (k) mVar;
                                prVar.cLT.actionType = kVar.kCj.kdC;
                                prVar.cLT.cLV = kVar.kCj.wVU;
                            }
                        }).b(new a() {
                            public final void e(int i, int i2, String str, m mVar) {
                                prVar.cLT.aIm = kVar.kCj.kCm;
                            }
                        }).c(new a() {
                            public final void e(int i, int i2, String str, m mVar) {
                                prVar.cLT.aIm = str;
                            }
                        });
                        prVar.cLS.callback.run();
                        AppMethodBeat.o(40998);
                    }
                });
                com.tencent.mm.kernel.g.Rg().a(kVar, 0);
            } else if (prVar.cLS.type == 1) {
                this.gnn = g.a(context, false, null);
                kVar = new com.tencent.mm.plugin.collect.reward.a.c(prVar.cLS.cLU, prVar.cLS.scene);
                com.tencent.mm.kernel.g.Rg().a(2811, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(40999);
                        if (u.this.gnn != null && u.this.gnn.isShowing()) {
                            u.this.gnn.dismiss();
                            u.this.gnn = null;
                        }
                        com.tencent.mm.kernel.g.Rg().b(2811, (f) this);
                        final com.tencent.mm.plugin.collect.reward.a.c cVar = (com.tencent.mm.plugin.collect.reward.a.c) mVar;
                        cVar.a(new a<com.tencent.mm.plugin.collect.reward.a.c>() {
                            public final /* bridge */ /* synthetic */ void e(int i, int i2, String str, m mVar) {
                                com.tencent.mm.plugin.collect.reward.a.c cVar = (com.tencent.mm.plugin.collect.reward.a.c) mVar;
                                prVar.cLT.actionType = cVar.kDw.kdC;
                                prVar.cLT.cLV = cVar.kDw.wVU;
                            }
                        }).b(new a() {
                            public final void e(int i, int i2, String str, m mVar) {
                                prVar.cLT.aIm = cVar.kDw.kCm;
                            }
                        }).c(new a() {
                            public final void e(int i, int i2, String str, m mVar) {
                                prVar.cLT.aIm = str;
                            }
                        });
                        prVar.cLS.callback.run();
                        AppMethodBeat.o(40999);
                    }
                });
                com.tencent.mm.kernel.g.Rg().a(kVar, 0);
            } else {
                ab.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", Integer.valueOf(prVar.cLS.type));
            }
            AppMethodBeat.o(41001);
        }
        return false;
    }
}
