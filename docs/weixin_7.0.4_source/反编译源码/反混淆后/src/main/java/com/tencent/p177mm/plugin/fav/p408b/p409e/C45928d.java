package com.tencent.p177mm.plugin.fav.p408b.p409e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27974z;
import com.tencent.p177mm.plugin.fav.p407a.C39036aj;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abi;
import com.tencent.p177mm.protocal.protobuf.acb;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.fav.b.e.d */
public final class C45928d implements C1202f, C27974z {
    private static Map<Integer, C1446a> cqS = new HashMap();
    private static Map<Integer, Integer> mhg = new HashMap();
    private Queue<C27966g> cqQ = new LinkedList();
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    public C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C206863(), false);
    private boolean running = false;

    /* renamed from: com.tencent.mm.plugin.fav.b.e.d$3 */
    class C206863 implements C5015a {
        C206863() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5376);
            try {
                C45928d.m85212d(C45928d.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavModService", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(5376);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(5377);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(5377);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.d$2 */
    class C279802 implements Runnable {
        C279802() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5374);
            long currentTimeMillis = System.currentTimeMillis() - C45928d.this.cqW;
            if (C45928d.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(5374);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + C45928d.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C45928d.this.running);
            }
            C45928d.this.cqU = false;
            C45928d.this.running = true;
            C45928d.this.cqV = 3;
            C45928d.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(5374);
        }

        public final String toString() {
            AppMethodBeat.m2504i(5375);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(5375);
            return str;
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m85213e(C45928d c45928d) {
        AppMethodBeat.m2504i(5386);
        c45928d.mo73777Fb();
        AppMethodBeat.m2505o(5386);
    }

    static {
        AppMethodBeat.m2504i(5387);
        AppMethodBeat.m2505o(5387);
    }

    public C45928d() {
        AppMethodBeat.m2504i(5378);
        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetAgcRxOn, (C1202f) this);
        AppMethodBeat.m2505o(5378);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(5379);
        if (c1207m.getType() != v2helper.EMethodSetAgcRxOn) {
            AppMethodBeat.m2505o(5379);
        } else if (c1207m instanceof C11850al) {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(5372);
                    C45928d.this.cqU = false;
                    int i = ((C11850al) c1207m).mgq;
                    C45928d.cqS.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        C45928d.this.cqV = C45928d.this.cqV - 1;
                    }
                    C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) i);
                    if (iF == null || iF.field_itemStatus == 10) {
                        AppMethodBeat.m2505o(5372);
                        return;
                    }
                    if (i != 0 || i2 != 0) {
                        Integer valueOf = Integer.valueOf(C5046bo.m7512a((Integer) C45928d.mhg.get(Integer.valueOf(i)), 0));
                        if (!(i == 1 || i == 0)) {
                            valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        }
                        if (valueOf.intValue() <= 0) {
                            int ed = C27968h.m44527ed(i, i2);
                            C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(iF.field_type), Integer.valueOf(ed), Long.valueOf(C39037b.m66369b(iF)), Long.valueOf(C27968h.m44529ix(iF.field_localId)));
                            C45928d.mhg.remove(Integer.valueOf(i));
                            C4990ab.m7413e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", Integer.valueOf(i));
                            iF.field_itemStatus = 18;
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                        }
                    } else if (iF.field_itemStatus == 17) {
                        C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(iF.field_type), Integer.valueOf(0), Long.valueOf(C39037b.m66369b(iF)), Long.valueOf(C27968h.m44529ix(iF.field_localId)));
                        C4990ab.m7417i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", Integer.valueOf(iF.field_id));
                        iF.field_itemStatus = 10;
                        C45928d.m85207A(iF);
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15167iB(iF.field_localId);
                    }
                    if (C45928d.this.cqV <= 0) {
                        C4990ab.m7416i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                        C45928d.m85213e(C45928d.this);
                    } else if (!C45928d.m85212d(C45928d.this)) {
                        C45928d.startSync();
                        AppMethodBeat.m2505o(5372);
                        return;
                    }
                    AppMethodBeat.m2505o(5372);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(5373);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.m2505o(5373);
                    return str;
                }
            });
            AppMethodBeat.m2505o(5379);
        } else {
            AppMethodBeat.m2505o(5379);
        }
    }

    public final void run() {
        AppMethodBeat.m2504i(5380);
        C1720g.m3539RS().mo10302aa(new C279802());
        AppMethodBeat.m2505o(5380);
    }

    /* renamed from: Fb */
    public final void mo73777Fb() {
        AppMethodBeat.m2504i(5381);
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        mhg.clear();
        AppMethodBeat.m2505o(5381);
    }

    public static void startSync() {
        AppMethodBeat.m2504i(5382);
        C1720g.m3540Rg().mo14541a(new C39036aj(), 0);
        AppMethodBeat.m2505o(5382);
    }

    /* renamed from: a */
    private static void m85208a(long j, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2) {
        AppMethodBeat.m2504i(5383);
        bca bca = new bca();
        bca.wGC = 4;
        bca.wGD = 0;
        linkedList.add(bca);
        C4990ab.m7417i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", Long.valueOf(j), Integer.valueOf(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15166iA(j).size()));
        for (C45925c c45925c : r0) {
            boolean LB = C39037b.m66337LB(c45925c.field_dataId);
            if (C5046bo.isNullOrNil(c45925c.field_cdnUrl) || LB) {
                C4990ab.m7413e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", c45925c.field_cdnUrl, Boolean.valueOf(LB), Long.valueOf(j));
            } else {
                bcd bcd = new bcd();
                bcd.ncF = "dataitem." + c45925c.field_dataId + ".cdn_dataurl";
                bcd.pXM = c45925c.field_cdnUrl;
                linkedList2.add(bcd);
                bcd = new bcd();
                bcd.ncF = "dataitem." + c45925c.field_dataId + ".cdn_datakey";
                bcd.pXM = c45925c.field_cdnKey;
                linkedList2.add(bcd);
                bcd = new bcd();
                bcd.ncF = "dataitem." + c45925c.field_dataId;
                bcd.wGI = "datastatus";
                bcd.pXM = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                linkedList2.add(bcd);
                C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c45925c.field_favLocalId);
                if (iE != null) {
                    int i;
                    if (iE.field_type == 4) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        aar a = C39037b.m66346a(iE, c45925c.field_dataId);
                        if (a != null) {
                            bcd bcd2 = new bcd();
                            bcd2.ncF = "dataitem." + c45925c.field_dataId + ".stream_videoid";
                            bcd2.pXM = a.wgJ;
                            linkedList2.add(bcd2);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(5383);
    }

    /* renamed from: A */
    static /* synthetic */ void m85207A(C27966g c27966g) {
        AppMethodBeat.m2504i(5384);
        abi abi = new abi();
        StringBuffer stringBuffer = new StringBuffer();
        abi.vEp = c27966g.field_id;
        stringBuffer.append("favid:" + c27966g.field_id);
        abi.wiy = new LinkedList();
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.whl != 0) {
                acb acb = new acb();
                if (aar.whl > 0) {
                    acb.vXB = aar.mnd;
                    acb.vXH = 0;
                    acb.jBT = aar.whl;
                } else {
                    acb.vXB = aar.mnd;
                    acb.vXH = 1;
                    acb.jBT = -aar.whl;
                }
                stringBuffer.append(" fileId:" + acb.vXB + " IsThumb:" + acb.vXH + " status:" + acb.jBT);
                abi.wiy.add(acb);
                aar.mo27397LH(0);
            }
        }
        C4990ab.m7417i("MicroMsg.Fav.FavModService", "checkFavItem %s", stringBuffer.toString());
        if (abi.wiy.size() > 0) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).checkFavItem(abi);
        }
        AppMethodBeat.m2505o(5384);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m85212d(C45928d c45928d) {
        AppMethodBeat.m2504i(5385);
        c45928d.cqW = System.currentTimeMillis();
        if (!c45928d.cqU && c45928d.cqQ.size() == 0) {
            List<C27966g> buW = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buW();
            if (!(buW == null || buW.size() == 0)) {
                for (C27966g c27966g : buW) {
                    if (cqS.containsKey(Integer.valueOf(c27966g.field_id))) {
                        C4990ab.m7416i("MicroMsg.Fav.FavModService", "File is Already running:" + c27966g.field_id);
                    } else {
                        if (!mhg.containsKey(Integer.valueOf(c27966g.field_id))) {
                            mhg.put(Integer.valueOf(c27966g.field_id), Integer.valueOf(3));
                        }
                        c45928d.cqQ.add(c27966g);
                        cqS.put(Integer.valueOf(c27966g.field_id), null);
                    }
                }
                C4990ab.m7416i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + c45928d.cqQ.size() + "]");
                c45928d.cqQ.size();
            }
        }
        if (!c45928d.cqU && c45928d.cqQ.size() <= 0) {
            c45928d.mo73777Fb();
            C4990ab.m7416i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
        } else if (!c45928d.cqU && c45928d.cqQ.size() > 0) {
            C27966g c27966g2 = (C27966g) c45928d.cqQ.poll();
            if (c27966g2 != null && c27966g2.field_id > 0) {
                c45928d.cqU = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (c27966g2.buC()) {
                    C4990ab.m7417i("MicroMsg.Fav.FavModService", "Resend Item %d", Long.valueOf(c27966g2.field_localId));
                    C1720g.m3540Rg().mo14541a(new C11850al(c27966g2.field_id, linkedList, linkedList2, C27966g.m44521s(c27966g2), (byte) 0), 0);
                } else if (c27966g2.field_type != 18) {
                    C45928d.m85208a(c27966g2.field_localId, linkedList, linkedList2);
                    C1720g.m3540Rg().mo14541a(new C11850al(c27966g2.field_id, linkedList, linkedList2), 0);
                } else {
                    bca bca = new bca();
                    bca.wGC = 1;
                    bca.wGD = (int) C5046bo.anT();
                    linkedList.add(bca);
                    C1720g.m3540Rg().mo14541a(new C11850al(c27966g2.field_id, linkedList, linkedList2, C27966g.m44521s(c27966g2)), 0);
                }
                AppMethodBeat.m2505o(5385);
                return true;
            }
        }
        AppMethodBeat.m2505o(5385);
        return false;
    }
}
