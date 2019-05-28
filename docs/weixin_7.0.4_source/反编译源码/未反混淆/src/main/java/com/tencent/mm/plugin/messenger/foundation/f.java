package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private t oqx;

    static class b implements Runnable {
        private String TAG;
        private final p fIx;
        private final LinkedList<tb> mgm;
        private int oqy;

        public b(String str, p pVar, LinkedList<tb> linkedList) {
            this.TAG = str;
            this.fIx = pVar;
            this.mgm = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(1060);
            if (this.fIx != null) {
                int i = this.fIx.fJD;
                if (i == 3 || (!this.fIx.caA && (i == 1 || i == 2 || i == 8))) {
                    this.oqy = 0;
                    Iterator it = this.mgm.iterator();
                    while (it.hasNext()) {
                        tb tbVar = (tb) it.next();
                        byte[] a = aa.a(tbVar.wau);
                        if (tbVar.wat == 5) {
                            try {
                                String bts = ((cm) new cm().parseFrom(a)).vEB.toString();
                                ad aoO = ((j) g.K(j.class)).XM().aoO(bts);
                                if (bts.endsWith("@chatroom") && aoO.dua == 0) {
                                    this.oqy++;
                                }
                            } catch (IOException e) {
                                ab.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                            }
                        }
                    }
                    if (this.oqy > 0) {
                        if (this.oqy <= 5) {
                            e.pXa.a(202, (long) this.oqy, 1, false);
                        } else if (this.oqy <= 10) {
                            e.pXa.a(202, 6, 1, false);
                        } else if (this.oqy <= 15) {
                            e.pXa.a(202, 7, 1, false);
                        } else if (this.oqy <= 20) {
                            e.pXa.a(202, 8, 1, false);
                        } else {
                            e.pXa.a(202, 9, 1, false);
                        }
                        ab.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.oqy);
                        switch (i) {
                            case 1:
                                e.pXa.a(202, 11, 1, false);
                                break;
                            case 2:
                                e.pXa.a(202, 12, 1, false);
                                break;
                            case 3:
                                e.pXa.a(202, 10, 1, false);
                                break;
                            case 8:
                                e.pXa.a(202, 13, 1, false);
                                break;
                        }
                        ab.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
                    }
                }
            }
            AppMethodBeat.o(1060);
        }
    }

    static class a implements t {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void bOs() {
        }

        public final void a(bi biVar, cm cmVar) {
        }
    }

    public final void ca(Object obj) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
        c bOt = u.bOt();
        if (bOt != null) {
            this.oqx = (t) bOt.get();
        }
        if (this.oqx == null) {
            this.oqx = new a();
        }
        if (obj instanceof com.tencent.mm.modelmulti.j) {
            ((j) g.K(j.class)).bOr().QW(((com.tencent.mm.modelmulti.j) obj).TAG);
            ((h) g.K(h.class)).Pl();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
            return;
        }
        if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((j) g.K(j.class)).bOr().QW((String) obj);
                ((h) g.K(h.class)).Pl();
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                return;
            }
        } else if (obj instanceof o.c) {
            ((j) g.K(j.class)).bOr().QW(obj.toString());
            ((h) g.K(h.class)).Pl();
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
    }

    public final void a(tb tbVar, byte[] bArr, boolean z) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
        r yv = com.tencent.mm.plugin.messenger.foundation.a.r.a.yv(tbVar.wat);
        if (yv != null) {
            try {
                yv.a(tbVar, bArr, z, this.oqx);
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
                return;
            } catch (IOException e) {
                ab.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                RuntimeException runtimeException = new RuntimeException("docmd: parse protobuf error");
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
                throw runtimeException;
            }
        }
        ab.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(tbVar.wat));
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
    }

    public final void cc(Object obj) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        if (obj instanceof com.tencent.mm.modelmulti.j) {
            LinkedList linkedList;
            this.oqx.bOs();
            ((j) g.K(j.class)).bOr().QX(((com.tencent.mm.modelmulti.j) obj).TAG);
            al RS = g.RS();
            String str = ((com.tencent.mm.modelmulti.j) obj).TAG;
            p pVar = ((com.tencent.mm.modelmulti.j) obj).fIx;
            com.tencent.mm.modelmulti.j jVar = (com.tencent.mm.modelmulti.j) obj;
            if (jVar.fIF == null || jVar.fIF.vyH.vTR == null) {
                linkedList = null;
            } else {
                linkedList = jVar.fIF.vyH.vTR.jBw;
            }
            RS.aa(new b(str, pVar, linkedList));
            ((h) g.K(h.class)).Pm();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.oqx.bOs();
            ((j) g.K(j.class)).bOr().QX((String) obj);
            ((h) g.K(h.class)).Pm();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        } else {
            if (obj instanceof o.c) {
                this.oqx.bOs();
                ((j) g.K(j.class)).bOr().QX(obj.toString());
                ((h) g.K(h.class)).Pm();
            }
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        }
    }

    public final void cd(Object obj) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_BAIHUA);
        if (obj instanceof com.tencent.mm.modelmulti.j) {
            ((j) g.K(j.class)).bOr().QX(((com.tencent.mm.modelmulti.j) obj).TAG);
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_BAIHUA);
    }
}
