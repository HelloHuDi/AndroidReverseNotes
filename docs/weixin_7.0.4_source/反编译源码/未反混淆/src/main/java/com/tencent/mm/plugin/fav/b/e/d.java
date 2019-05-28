package com.tencent.mm.plugin.fav.b.e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d implements f, z {
    private static Map<Integer, a> cqS = new HashMap();
    private static Map<Integer, Integer> mhg = new HashMap();
    private Queue<g> cqQ = new LinkedList();
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    public ap cra = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(5376);
            try {
                d.d(d.this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavModService", e, "", new Object[0]);
            }
            AppMethodBeat.o(5376);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(5377);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(5377);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ void e(d dVar) {
        AppMethodBeat.i(5386);
        dVar.Fb();
        AppMethodBeat.o(5386);
    }

    static {
        AppMethodBeat.i(5387);
        AppMethodBeat.o(5387);
    }

    public d() {
        AppMethodBeat.i(5378);
        com.tencent.mm.kernel.g.Rg().a((int) v2helper.EMethodSetAgcRxOn, (f) this);
        AppMethodBeat.o(5378);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
        AppMethodBeat.i(5379);
        if (mVar.getType() != v2helper.EMethodSetAgcRxOn) {
            AppMethodBeat.o(5379);
        } else if (mVar instanceof al) {
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(5372);
                    d.this.cqU = false;
                    int i = ((al) mVar).mgq;
                    d.cqS.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        d.this.cqV = d.this.cqV - 1;
                    }
                    g iF = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) i);
                    if (iF == null || iF.field_itemStatus == 10) {
                        AppMethodBeat.o(5372);
                        return;
                    }
                    if (i != 0 || i2 != 0) {
                        Integer valueOf = Integer.valueOf(bo.a((Integer) d.mhg.get(Integer.valueOf(i)), 0));
                        if (!(i == 1 || i == 0)) {
                            valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        }
                        if (valueOf.intValue() <= 0) {
                            int ed = h.ed(i, i2);
                            com.tencent.mm.plugin.report.service.h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(iF.field_type), Integer.valueOf(ed), Long.valueOf(b.b(iF)), Long.valueOf(h.ix(iF.field_localId)));
                            d.mhg.remove(Integer.valueOf(i));
                            ab.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", Integer.valueOf(i));
                            iF.field_itemStatus = 18;
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                        }
                    } else if (iF.field_itemStatus == 17) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(iF.field_type), Integer.valueOf(0), Long.valueOf(b.b(iF)), Long.valueOf(h.ix(iF.field_localId)));
                        ab.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", Integer.valueOf(iF.field_id));
                        iF.field_itemStatus = 10;
                        d.A(iF);
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iB(iF.field_localId);
                    }
                    if (d.this.cqV <= 0) {
                        ab.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                        d.e(d.this);
                    } else if (!d.d(d.this)) {
                        d.startSync();
                        AppMethodBeat.o(5372);
                        return;
                    }
                    AppMethodBeat.o(5372);
                }

                public final String toString() {
                    AppMethodBeat.i(5373);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(5373);
                    return str;
                }
            });
            AppMethodBeat.o(5379);
        } else {
            AppMethodBeat.o(5379);
        }
    }

    public final void run() {
        AppMethodBeat.i(5380);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5374);
                long currentTimeMillis = System.currentTimeMillis() - d.this.cqW;
                if (d.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(5374);
                        return;
                    }
                    ab.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + d.this.running);
                }
                d.this.cqU = false;
                d.this.running = true;
                d.this.cqV = 3;
                d.this.cra.ae(10, 10);
                AppMethodBeat.o(5374);
            }

            public final String toString() {
                AppMethodBeat.i(5375);
                String str = super.toString() + "|run";
                AppMethodBeat.o(5375);
                return str;
            }
        });
        AppMethodBeat.o(5380);
    }

    public final void Fb() {
        AppMethodBeat.i(5381);
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        mhg.clear();
        AppMethodBeat.o(5381);
    }

    public static void startSync() {
        AppMethodBeat.i(5382);
        com.tencent.mm.kernel.g.Rg().a(new aj(), 0);
        AppMethodBeat.o(5382);
    }

    private static void a(long j, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2) {
        AppMethodBeat.i(5383);
        bca bca = new bca();
        bca.wGC = 4;
        bca.wGD = 0;
        linkedList.add(bca);
        ab.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", Long.valueOf(j), Integer.valueOf(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().iA(j).size()));
        for (c cVar : r0) {
            boolean LB = b.LB(cVar.field_dataId);
            if (bo.isNullOrNil(cVar.field_cdnUrl) || LB) {
                ab.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", cVar.field_cdnUrl, Boolean.valueOf(LB), Long.valueOf(j));
            } else {
                bcd bcd = new bcd();
                bcd.ncF = "dataitem." + cVar.field_dataId + ".cdn_dataurl";
                bcd.pXM = cVar.field_cdnUrl;
                linkedList2.add(bcd);
                bcd = new bcd();
                bcd.ncF = "dataitem." + cVar.field_dataId + ".cdn_datakey";
                bcd.pXM = cVar.field_cdnKey;
                linkedList2.add(bcd);
                bcd = new bcd();
                bcd.ncF = "dataitem." + cVar.field_dataId;
                bcd.wGI = "datastatus";
                bcd.pXM = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                linkedList2.add(bcd);
                g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(cVar.field_favLocalId);
                if (iE != null) {
                    int i;
                    if (iE.field_type == 4) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        aar a = b.a(iE, cVar.field_dataId);
                        if (a != null) {
                            bcd bcd2 = new bcd();
                            bcd2.ncF = "dataitem." + cVar.field_dataId + ".stream_videoid";
                            bcd2.pXM = a.wgJ;
                            linkedList2.add(bcd2);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(5383);
    }

    static /* synthetic */ void A(g gVar) {
        AppMethodBeat.i(5384);
        abi abi = new abi();
        StringBuffer stringBuffer = new StringBuffer();
        abi.vEp = gVar.field_id;
        stringBuffer.append("favid:" + gVar.field_id);
        abi.wiy = new LinkedList();
        Iterator it = gVar.field_favProto.wiv.iterator();
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
                aar.LH(0);
            }
        }
        ab.i("MicroMsg.Fav.FavModService", "checkFavItem %s", stringBuffer.toString());
        if (abi.wiy.size() > 0) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).checkFavItem(abi);
        }
        AppMethodBeat.o(5384);
    }

    static /* synthetic */ boolean d(d dVar) {
        AppMethodBeat.i(5385);
        dVar.cqW = System.currentTimeMillis();
        if (!dVar.cqU && dVar.cqQ.size() == 0) {
            List<g> buW = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buW();
            if (!(buW == null || buW.size() == 0)) {
                for (g gVar : buW) {
                    if (cqS.containsKey(Integer.valueOf(gVar.field_id))) {
                        ab.i("MicroMsg.Fav.FavModService", "File is Already running:" + gVar.field_id);
                    } else {
                        if (!mhg.containsKey(Integer.valueOf(gVar.field_id))) {
                            mhg.put(Integer.valueOf(gVar.field_id), Integer.valueOf(3));
                        }
                        dVar.cqQ.add(gVar);
                        cqS.put(Integer.valueOf(gVar.field_id), null);
                    }
                }
                ab.i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + dVar.cqQ.size() + "]");
                dVar.cqQ.size();
            }
        }
        if (!dVar.cqU && dVar.cqQ.size() <= 0) {
            dVar.Fb();
            ab.i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
        } else if (!dVar.cqU && dVar.cqQ.size() > 0) {
            g gVar2 = (g) dVar.cqQ.poll();
            if (gVar2 != null && gVar2.field_id > 0) {
                dVar.cqU = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (gVar2.buC()) {
                    ab.i("MicroMsg.Fav.FavModService", "Resend Item %d", Long.valueOf(gVar2.field_localId));
                    com.tencent.mm.kernel.g.Rg().a(new al(gVar2.field_id, linkedList, linkedList2, g.s(gVar2), (byte) 0), 0);
                } else if (gVar2.field_type != 18) {
                    a(gVar2.field_localId, linkedList, linkedList2);
                    com.tencent.mm.kernel.g.Rg().a(new al(gVar2.field_id, linkedList, linkedList2), 0);
                } else {
                    bca bca = new bca();
                    bca.wGC = 1;
                    bca.wGD = (int) bo.anT();
                    linkedList.add(bca);
                    com.tencent.mm.kernel.g.Rg().a(new al(gVar2.field_id, linkedList, linkedList2, g.s(gVar2)), 0);
                }
                AppMethodBeat.o(5385);
                return true;
            }
        }
        AppMethodBeat.o(5385);
        return false;
    }
}
