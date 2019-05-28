package com.tencent.p177mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelmulti.C18670p;
import com.tencent.p177mm.modelmulti.C26460o.C26464c;
import com.tencent.p177mm.modelmulti.C42215j;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r.C21278a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39366h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.p591a.C46481f;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.f */
public final class C12531f implements C46481f {
    private C21280t oqx;

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.f$b */
    static class C12532b implements Runnable {
        private String TAG;
        private final C18670p fIx;
        private final LinkedList<C40573tb> mgm;
        private int oqy;

        public C12532b(String str, C18670p c18670p, LinkedList<C40573tb> linkedList) {
            this.TAG = str;
            this.fIx = c18670p;
            this.mgm = linkedList;
        }

        public final void run() {
            AppMethodBeat.m2504i(1060);
            if (this.fIx != null) {
                int i = this.fIx.fJD;
                if (i == 3 || (!this.fIx.caA && (i == 1 || i == 2 || i == 8))) {
                    this.oqy = 0;
                    Iterator it = this.mgm.iterator();
                    while (it.hasNext()) {
                        C40573tb c40573tb = (C40573tb) it.next();
                        byte[] a = C1946aa.m4150a(c40573tb.wau);
                        if (c40573tb.wat == 5) {
                            try {
                                String bts = ((C7254cm) new C7254cm().parseFrom(a)).vEB.toString();
                                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bts);
                                if (bts.endsWith("@chatroom") && aoO.dua == 0) {
                                    this.oqy++;
                                }
                            } catch (IOException e) {
                                C4990ab.m7412e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                            }
                        }
                    }
                    if (this.oqy > 0) {
                        if (this.oqy <= 5) {
                            C7053e.pXa.mo8378a(202, (long) this.oqy, 1, false);
                        } else if (this.oqy <= 10) {
                            C7053e.pXa.mo8378a(202, 6, 1, false);
                        } else if (this.oqy <= 15) {
                            C7053e.pXa.mo8378a(202, 7, 1, false);
                        } else if (this.oqy <= 20) {
                            C7053e.pXa.mo8378a(202, 8, 1, false);
                        } else {
                            C7053e.pXa.mo8378a(202, 9, 1, false);
                        }
                        C4990ab.m7416i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.oqy);
                        switch (i) {
                            case 1:
                                C7053e.pXa.mo8378a(202, 11, 1, false);
                                break;
                            case 2:
                                C7053e.pXa.mo8378a(202, 12, 1, false);
                                break;
                            case 3:
                                C7053e.pXa.mo8378a(202, 10, 1, false);
                                break;
                            case 8:
                                C7053e.pXa.mo8378a(202, 13, 1, false);
                                break;
                        }
                        C4990ab.m7416i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
                    }
                }
            }
            AppMethodBeat.m2505o(1060);
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.f$a */
    static class C12533a implements C21280t {
        private C12533a() {
        }

        /* synthetic */ C12533a(byte b) {
            this();
        }

        public final void bOs() {
        }

        /* renamed from: a */
        public final void mo8118a(C7620bi c7620bi, C7254cm c7254cm) {
        }
    }

    /* renamed from: ca */
    public final void mo24456ca(Object obj) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
        C32467c bOt = C21281u.bOt();
        if (bOt != null) {
            this.oqx = (C21280t) bOt.get();
        }
        if (this.oqx == null) {
            this.oqx = new C12533a();
        }
        if (obj instanceof C42215j) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15242QW(((C42215j) obj).TAG);
            ((C39366h) C1720g.m3528K(C39366h.class)).mo39198Pl();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
            return;
        }
        if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15242QW((String) obj);
                ((C39366h) C1720g.m3528K(C39366h.class)).mo39198Pl();
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                return;
            }
        } else if (obj instanceof C26464c) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15242QW(obj.toString());
            ((C39366h) C1720g.m3528K(C39366h.class)).mo39198Pl();
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
    }

    /* renamed from: a */
    public final void mo24455a(C40573tb c40573tb, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
        C21279r yv = C21278a.m32648yv(c40573tb.wat);
        if (yv != null) {
            try {
                yv.mo36640a(c40573tb, bArr, z, this.oqx);
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
                return;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                RuntimeException runtimeException = new RuntimeException("docmd: parse protobuf error");
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
                throw runtimeException;
            }
        }
        C4990ab.m7421w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(c40573tb.wat));
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_HUAYE);
    }

    /* renamed from: cc */
    public final void mo24457cc(Object obj) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        if (obj instanceof C42215j) {
            LinkedList linkedList;
            this.oqx.bOs();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX(((C42215j) obj).TAG);
            C5004al RS = C1720g.m3539RS();
            String str = ((C42215j) obj).TAG;
            C18670p c18670p = ((C42215j) obj).fIx;
            C42215j c42215j = (C42215j) obj;
            if (c42215j.fIF == null || c42215j.fIF.vyH.vTR == null) {
                linkedList = null;
            } else {
                linkedList = c42215j.fIF.vyH.vTR.jBw;
            }
            RS.mo10302aa(new C12532b(str, c18670p, linkedList));
            ((C39366h) C1720g.m3528K(C39366h.class)).mo39199Pm();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.oqx.bOs();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX((String) obj);
            ((C39366h) C1720g.m3528K(C39366h.class)).mo39199Pm();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        } else {
            if (obj instanceof C26464c) {
                this.oqx.bOs();
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX(obj.toString());
                ((C39366h) C1720g.m3528K(C39366h.class)).mo39199Pm();
            }
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_BAIXIANG);
        }
    }

    /* renamed from: cd */
    public final void mo24458cd(Object obj) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_BAIHUA);
        if (obj instanceof C42215j) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX(((C42215j) obj).TAG);
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_BAIHUA);
    }
}
