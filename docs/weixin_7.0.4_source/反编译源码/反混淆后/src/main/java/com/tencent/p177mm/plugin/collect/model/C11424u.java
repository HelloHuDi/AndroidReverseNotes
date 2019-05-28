package com.tencent.p177mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6538pr;
import com.tencent.p177mm.plugin.collect.reward.p366a.C33865c;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;

/* renamed from: com.tencent.mm.plugin.collect.model.u */
public final class C11424u extends C4884c<C6538pr> {
    Dialog gnn;

    public C11424u() {
        AppMethodBeat.m2504i(41000);
        this.xxI = C6538pr.class.getName().hashCode();
        AppMethodBeat.m2505o(41000);
    }

    /* renamed from: a */
    private boolean m19179a(final C6538pr c6538pr) {
        AppMethodBeat.m2504i(41001);
        C4990ab.m7417i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", Integer.valueOf(c6538pr.cLS.type));
        if (c6538pr.cLS.aIq == null || c6538pr.cLS.aIq.get() == null) {
            C4990ab.m7416i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            c6538pr.cLS.callback.run();
            AppMethodBeat.m2505o(41001);
        } else {
            Context context = (Context) c6538pr.cLS.aIq.get();
            C1207m c2832k;
            if (c6538pr.cLS.type == 0) {
                this.gnn = C30901g.m49317a(context, false, null);
                c2832k = new C2832k(c6538pr.cLS.cLU, c6538pr.cLS.scene);
                C1720g.m3540Rg().mo14539a(1800, new C1202f() {

                    /* renamed from: com.tencent.mm.plugin.collect.model.u$1$1 */
                    class C114261 implements C40929a {
                        C114261() {
                        }

                        /* renamed from: e */
                        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                            c6538pr.cLT.aIm = str;
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.collect.model.u$1$3 */
                    class C114283 implements C40929a<C2832k> {
                        C114283() {
                        }

                        /* renamed from: e */
                        public final /* bridge */ /* synthetic */ void mo7656e(int i, int i2, String str, C1207m c1207m) {
                            C2832k c2832k = (C2832k) c1207m;
                            c6538pr.cLT.actionType = c2832k.kCj.kdC;
                            c6538pr.cLT.cLV = c2832k.kCj.wVU;
                        }
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(40998);
                        if (C11424u.this.gnn != null && C11424u.this.gnn.isShowing()) {
                            C11424u.this.gnn.dismiss();
                            C11424u.this.gnn = null;
                        }
                        C1720g.m3540Rg().mo14546b(1800, (C1202f) this);
                        final C2832k c2832k = (C2832k) c1207m;
                        c2832k.mo70318a(new C114283()).mo70319b(new C40929a() {
                            /* renamed from: e */
                            public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                                c6538pr.cLT.aIm = c2832k.kCj.kCm;
                            }
                        }).mo70320c(new C114261());
                        c6538pr.cLS.callback.run();
                        AppMethodBeat.m2505o(40998);
                    }
                });
                C1720g.m3540Rg().mo14541a(c2832k, 0);
            } else if (c6538pr.cLS.type == 1) {
                this.gnn = C30901g.m49317a(context, false, null);
                c2832k = new C33865c(c6538pr.cLS.cLU, c6538pr.cLS.scene);
                C1720g.m3540Rg().mo14539a(2811, new C1202f() {

                    /* renamed from: com.tencent.mm.plugin.collect.model.u$2$3 */
                    class C114223 implements C40929a<C33865c> {
                        C114223() {
                        }

                        /* renamed from: e */
                        public final /* bridge */ /* synthetic */ void mo7656e(int i, int i2, String str, C1207m c1207m) {
                            C33865c c33865c = (C33865c) c1207m;
                            c6538pr.cLT.actionType = c33865c.kDw.kdC;
                            c6538pr.cLT.cLV = c33865c.kDw.wVU;
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.collect.model.u$2$1 */
                    class C114231 implements C40929a {
                        C114231() {
                        }

                        /* renamed from: e */
                        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                            c6538pr.cLT.aIm = str;
                        }
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(40999);
                        if (C11424u.this.gnn != null && C11424u.this.gnn.isShowing()) {
                            C11424u.this.gnn.dismiss();
                            C11424u.this.gnn = null;
                        }
                        C1720g.m3540Rg().mo14546b(2811, (C1202f) this);
                        final C33865c c33865c = (C33865c) c1207m;
                        c33865c.mo70318a(new C114223()).mo70319b(new C40929a() {
                            /* renamed from: e */
                            public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                                c6538pr.cLT.aIm = c33865c.kDw.kCm;
                            }
                        }).mo70320c(new C114231());
                        c6538pr.cLS.callback.run();
                        AppMethodBeat.m2505o(40999);
                    }
                });
                C1720g.m3540Rg().mo14541a(c2832k, 0);
            } else {
                C4990ab.m7421w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", Integer.valueOf(c6538pr.cLS.type));
            }
            AppMethodBeat.m2505o(41001);
        }
        return false;
    }
}
