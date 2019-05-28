package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n implements f, i {
    public HashMap<Integer, HashSet<WeakReference<com.tencent.mm.plugin.messenger.foundation.a.a.i.a>>> fBy;
    private final int fCD;
    ap fCF;
    com.tencent.mm.a.f<Integer, Integer> fCy;
    private com.tencent.mm.a.f<Integer, Integer> fLI;
    i fLJ;
    boolean frc;
    long frn;

    class a extends ap {
        public a(n nVar, List<b> list, LinkedList<Integer> linkedList, LinkedList<bhp> linkedList2) {
            final n nVar2 = n.this;
            final List<b> list2 = list;
            final LinkedList<Integer> linkedList3 = linkedList;
            final LinkedList<bhp> linkedList4 = linkedList2;
            final n nVar3 = nVar;
            super(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                private int fIf = 0;
                private int fLL = 0;

                public final boolean BI() {
                    int i = 0;
                    AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                    int size = list2.size();
                    int size2 = linkedList3.size();
                    int i2 = size < size2 ? size : size2;
                    if (size != size2) {
                        ab.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.fIf));
                    }
                    ArrayList arrayList = new ArrayList();
                    if (this.fIf >= i2) {
                        nVar2.frc = false;
                        if (this.fLL > 0) {
                            long j;
                            ap apVar = nVar2.fCF;
                            if (nVar2.fCy.size() > 0) {
                                j = 500;
                            } else {
                                j = 0;
                            }
                            apVar.ae(j, j);
                        }
                        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                        return false;
                    }
                    size = this.fIf + 20;
                    if (size > i2) {
                        size2 = i2;
                    } else {
                        size2 = size;
                    }
                    while (this.fIf < size2) {
                        bhp bhp;
                        final int intValue = ((Integer) linkedList3.get(this.fIf)).intValue();
                        final b bVar = (b) list2.get(this.fIf);
                        if (this.fIf < linkedList4.size()) {
                            bhp = (bhp) linkedList4.get(this.fIf);
                        } else {
                            bhp = null;
                        }
                        int i3 = bVar.id;
                        ab.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(intValue));
                        al.d(new Runnable() {
                            public final void run() {
                                String str;
                                String str2;
                                AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
                                n nVar = nVar3;
                                int cmdId = bVar.getCmdId();
                                int i = intValue;
                                if (bhp == null) {
                                    str = "";
                                } else {
                                    str = bhp.Title;
                                }
                                if (bhp == null) {
                                    str2 = "";
                                } else {
                                    str2 = bhp.ncM;
                                }
                                nVar.c(cmdId, i, str, str2);
                                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
                            }
                        });
                        if (intValue == 0) {
                            this.fLL++;
                            arrayList.add(bVar);
                            nVar2.fCy.remove(Integer.valueOf(i3));
                        } else if (intValue == -433) {
                            ab.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()));
                        } else {
                            Integer num = (Integer) nVar2.fCy.ai(Integer.valueOf(i3));
                            ab.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(i3), Long.valueOf(bVar.fCv), num);
                            if (num == null) {
                                nVar2.fCy.k(Integer.valueOf(i3), Integer.valueOf(1));
                            } else if (num.intValue() < 2) {
                                nVar2.fCy.k(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                            } else {
                                ab.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(i3), Long.valueOf(bVar.fCv));
                                arrayList.add(bVar);
                            }
                        }
                        this.fIf++;
                    }
                    size = arrayList.size();
                    if (size > 0) {
                        g.RQ();
                        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                        while (i < size) {
                            nVar2.fLJ.b((b) arrayList.get(i));
                            i++;
                        }
                        g.RQ();
                        g.RP().eJN.mB(iV);
                    }
                    AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
                    String str = super.toString() + "|RespHandler";
                    AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
                    return str;
                }
            }, true);
            AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
        }
    }

    public n(i iVar) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
        this.frc = false;
        this.fCy = new c(200);
        this.fLI = new c(200);
        this.fBy = new HashMap();
        this.frn = 0;
        this.fCD = 500;
        this.fCF = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(991);
                ab.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
                n nVar = n.this;
                long anU = bo.anU();
                if (nVar.frc && anU - nVar.frn > 10000) {
                    nVar.frc = false;
                }
                if (nVar.frc) {
                    ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
                } else {
                    List list;
                    i iVar = nVar.fLJ;
                    ArrayList arrayList = new ArrayList();
                    Cursor a = iVar.fni.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"}, 0);
                    if (a == null) {
                        list = arrayList;
                    } else {
                        int count = a.getCount();
                        if (count > 0) {
                            for (int i = 0; i < count; i++) {
                                a.moveToPosition(i);
                                b bVar = new b(0);
                                bVar.id = a.getInt(0);
                                bVar.fCv = a.getLong(1);
                                bVar.cmdId = a.getInt(2);
                                bVar.buffer = a.getBlob(3);
                                bVar.oqP = a.getInt(4);
                                bVar.oqQ = a.getLong(5);
                                bVar.oqR = a.getString(6);
                                bVar.oqS = a.getString(7);
                                arrayList.add(bVar);
                            }
                        }
                        a.close();
                        Object list2 = arrayList;
                    }
                    if (list2.size() == 0) {
                        ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                    } else {
                        if (!nVar.frc && list2.size() > 0) {
                            nVar.frn = anU;
                            nVar.frc = true;
                            LinkedList<b> linkedList = new LinkedList();
                            for (b bVar2 : list2) {
                                if (bVar2.getCmdId() == 0 && bVar2.oqP > 0) {
                                    linkedList.add(bVar2);
                                }
                            }
                            list2.removeAll(linkedList);
                            for (b bVar22 : linkedList) {
                                if ("@openim".equals(bVar22.oqR)) {
                                    g.RQ();
                                    g.RO().eJo.a(new l(bVar22), 0);
                                } else {
                                    nVar.fLJ.b(bVar22);
                                }
                            }
                            if (!list2.isEmpty()) {
                                g.RQ();
                                g.RO().eJo.a(new b(list2), 0);
                            }
                        }
                        ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", Long.valueOf(nVar.frn), Boolean.valueOf(nVar.frc), Long.valueOf(System.currentTimeMillis() - anU), Integer.valueOf(list2.size()));
                    }
                }
                AppMethodBeat.o(991);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
                String str = super.toString() + "|pusherTry";
                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
                return str;
            }
        }, false);
        this.fBy = new HashMap();
        this.fLJ = iVar;
        g.RQ();
        g.RO().eJo.a(681, (f) this);
        g.RQ();
        g.RO().eJo.a(806, (f) this);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
    }

    public final void a(int i, com.tencent.mm.plugin.messenger.foundation.a.a.i.a aVar) {
        HashSet hashSet;
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        HashSet hashSet2 = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet2 == null) {
            hashSet = new HashSet();
        } else {
            hashSet = hashSet2;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((com.tencent.mm.plugin.messenger.foundation.a.a.i.a) weakReference.get()).equals(aVar)) {
                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
                return;
            }
        }
        hashSet.add(new WeakReference(aVar));
        this.fBy.put(Integer.valueOf(i), hashSet);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
    }

    public final void b(int i, com.tencent.mm.plugin.messenger.foundation.a.a.i.a aVar) {
        AppMethodBeat.i(999);
        HashSet hashSet = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet == null) {
            AppMethodBeat.o(999);
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((com.tencent.mm.plugin.messenger.foundation.a.a.i.a) weakReference.get()).equals(aVar)) {
                hashSet.remove(weakReference);
                AppMethodBeat.o(999);
                return;
            }
        }
        if (hashSet.size() == 0) {
            this.fBy.remove(Integer.valueOf(i));
            AppMethodBeat.o(999);
            return;
        }
        this.fBy.put(Integer.valueOf(i), hashSet);
        AppMethodBeat.o(999);
    }

    /* Access modifiers changed, original: final */
    public final void c(int i, int i2, String str, String str2) {
        AppMethodBeat.i(1000);
        HashSet hashSet = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet == null) {
            AppMethodBeat.o(1000);
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add(weakReference.get());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.a.i.a) it.next()).x(i2, str, str2);
        }
        linkedList.clear();
        AppMethodBeat.o(1000);
    }

    public final void c(b bVar) {
        AppMethodBeat.i(1001);
        if (bVar != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = bo.dpG();
            ab.i(str, str2, objArr);
            bVar.fCv = bo.anU();
            i iVar = this.fLJ;
            if (bVar != null) {
                bVar.bJt = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.bJt & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.fCv));
                }
                if ((bVar.bJt & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.bJt & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.bJt & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.oqP));
                }
                if ((bVar.bJt & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.oqQ));
                }
                if ((bVar.bJt & 64) != 0) {
                    contentValues.put("reserved3", bVar.oqR);
                }
                if ((bVar.bJt & 128) != 0) {
                    contentValues.put("reserved4", bVar.oqS);
                }
                int insert = (int) iVar.fni.insert("oplog2", "id", contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            ab.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.fCF.ae(0, 0);
        AppMethodBeat.o(1001);
    }

    public final void d(b bVar) {
        AppMethodBeat.i(1002);
        g.RQ();
        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
        this.fLJ.b(bVar);
        g.RQ();
        g.RP().eJN.mB(iV);
        AppMethodBeat.o(1002);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(1003);
        ab.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        String str2;
        int cmdId;
        if (mVar.getType() == 806) {
            bgu bgu = (bgu) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
            b bVar = ((l) mVar).gfe;
            if (i != 0 && i2 != 0) {
                String str3 = "";
                if (bgu == null || bgu.getBaseResponse() == null) {
                    str2 = str3;
                } else {
                    str2 = aa.a(bgu.getBaseResponse().ErrMsg);
                }
                if (!bo.isNullOrNil(str2)) {
                    str = str2;
                }
                cmdId = bVar.getCmdId();
                c(bVar.getCmdId(), -1, "", str);
                this.frc = false;
                Integer num = (Integer) this.fLI.ai(Integer.valueOf(cmdId));
                ab.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(cmdId), Long.valueOf(bVar.fCv), num);
                if (num == null) {
                    this.fLI.k(Integer.valueOf(cmdId), Integer.valueOf(1));
                    AppMethodBeat.o(1003);
                } else if (num.intValue() < 2) {
                    this.fLI.k(Integer.valueOf(cmdId), Integer.valueOf(num.intValue() + 1));
                    AppMethodBeat.o(1003);
                } else {
                    ab.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(cmdId), Long.valueOf(bVar.fCv));
                    this.fLJ.b(bVar);
                    AppMethodBeat.o(1003);
                }
            } else if (mVar instanceof l) {
                int i3;
                long j;
                if (bgu.getBaseResponse() != null) {
                    i3 = bgu.getBaseResponse().Ret;
                } else {
                    i3 = 0;
                }
                mc mcVar = new mc();
                mcVar.cHU.ret = i3;
                com.tencent.mm.sdk.b.a.xxA.m(mcVar);
                c(bVar.getCmdId(), i3, "", "");
                ab.i("MicroMsg.OplogService", "openim op success, type:%d id %d", Integer.valueOf(bVar.oqP), Integer.valueOf(bVar.getCmdId()));
                this.fLJ.b(bVar);
                this.frc = false;
                ap apVar = this.fCF;
                if (this.fCy.size() > 0) {
                    j = 500;
                } else {
                    j = 0;
                }
                apVar.ae(j, j);
                AppMethodBeat.o(1003);
            } else {
                AppMethodBeat.o(1003);
            }
        } else if (mVar.getType() != 681) {
            AppMethodBeat.o(1003);
        } else if (i == 0 && i2 == 0 && ((b) mVar).fLr != null) {
            bhr bhr = ((b) mVar).fLr.fLu.fLw;
            if (bhr.Ret != 0 || bhr.wKS == null || bhr.wKS.wof == null) {
                ab.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(bhr.Ret));
                this.frc = false;
                AppMethodBeat.o(1003);
                return;
            }
            if (!(bhr.wKS == null || bhr.wKS.wof.size() == 0)) {
                mc mcVar2 = new mc();
                mcVar2.cHU.ret = ((Integer) bhr.wKS.wof.getLast()).intValue();
                LinkedList linkedList = bhr.wKS.wKT;
                mcVar2.cHU.cHV = linkedList.isEmpty() ? "" : ((bhp) linkedList.getLast()).Title;
                com.tencent.mm.g.a.mc.a aVar = mcVar2.cHU;
                if (linkedList.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = ((bhp) linkedList.getLast()).ncM;
                }
                aVar.cHW = str2;
                if (bo.isNullOrNil(mcVar2.cHU.cHV) && bo.isNullOrNil(mcVar2.cHU.cHW)) {
                    for (cmdId = linkedList.size() - 1; cmdId >= 0; cmdId--) {
                        mcVar2.cHU.cHV = ((bhp) linkedList.get(cmdId)).Title;
                        mcVar2.cHU.cHW = ((bhp) linkedList.get(cmdId)).ncM;
                        if (!bo.isNullOrNil(mcVar2.cHU.cHV) || !bo.isNullOrNil(mcVar2.cHU.cHW)) {
                            break;
                        }
                    }
                }
                com.tencent.mm.sdk.b.a.xxA.m(mcVar2);
            }
            new a(this, ((b) mVar).fLs, bhr.wKS.wof, bhr.wKS.wKT).ae(50, 50);
            AppMethodBeat.o(1003);
        } else {
            ab.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", Integer.valueOf(i), Integer.valueOf(i2), ((b) mVar).fLr.toString());
            this.frc = false;
            AppMethodBeat.o(1003);
        }
    }
}
