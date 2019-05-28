package com.tencent.p177mm.p201az;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.openim.p716b.C9768l;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p230g.p231a.C42023mc.C18321a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i.C3461a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.bgu;
import com.tencent.p177mm.protocal.protobuf.bhp;
import com.tencent.p177mm.protocal.protobuf.bhr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.az.n */
public final class C37500n implements C1202f, C3462i {
    public HashMap<Integer, HashSet<WeakReference<C3461a>>> fBy;
    private final int fCD;
    C7564ap fCF;
    C1177f<Integer, Integer> fCy;
    private C1177f<Integer, Integer> fLI;
    C25850i fLJ;
    boolean frc;
    long frn;

    /* renamed from: com.tencent.mm.az.n$a */
    class C17968a extends C7564ap {
        public C17968a(C37500n c37500n, List<C3463b> list, LinkedList<Integer> linkedList, LinkedList<bhp> linkedList2) {
            final C37500n c37500n2 = C37500n.this;
            final List<C3463b> list2 = list;
            final LinkedList<Integer> linkedList3 = linkedList;
            final LinkedList<bhp> linkedList4 = linkedList2;
            final C37500n c37500n3 = c37500n;
            super(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
                private int fIf = 0;
                private int fLL = 0;

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    int i = 0;
                    AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                    int size = list2.size();
                    int size2 = linkedList3.size();
                    int i2 = size < size2 ? size : size2;
                    if (size != size2) {
                        C4990ab.m7421w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.fIf));
                    }
                    ArrayList arrayList = new ArrayList();
                    if (this.fIf >= i2) {
                        c37500n2.frc = false;
                        if (this.fLL > 0) {
                            long j;
                            C7564ap c7564ap = c37500n2.fCF;
                            if (c37500n2.fCy.size() > 0) {
                                j = 500;
                            } else {
                                j = 0;
                            }
                            c7564ap.mo16770ae(j, j);
                        }
                        AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
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
                        final C3463b c3463b = (C3463b) list2.get(this.fIf);
                        if (this.fIf < linkedList4.size()) {
                            bhp = (bhp) linkedList4.get(this.fIf);
                        } else {
                            bhp = null;
                        }
                        int i3 = c3463b.f1272id;
                        C4990ab.m7411d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", Integer.valueOf(i3), Integer.valueOf(c3463b.getCmdId()), Integer.valueOf(intValue));
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                String str;
                                String str2;
                                AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
                                C37500n c37500n = c37500n3;
                                int cmdId = c3463b.getCmdId();
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
                                c37500n.mo60428c(cmdId, i, str, str2);
                                AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
                            }
                        });
                        if (intValue == 0) {
                            this.fLL++;
                            arrayList.add(c3463b);
                            c37500n2.fCy.remove(Integer.valueOf(i3));
                        } else if (intValue == -433) {
                            C4990ab.m7413e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", Integer.valueOf(i3), Integer.valueOf(c3463b.getCmdId()));
                        } else {
                            Integer num = (Integer) c37500n2.fCy.mo4404ai(Integer.valueOf(i3));
                            C4990ab.m7411d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(i3), Long.valueOf(c3463b.fCv), num);
                            if (num == null) {
                                c37500n2.fCy.mo4412k(Integer.valueOf(i3), Integer.valueOf(1));
                            } else if (num.intValue() < 2) {
                                c37500n2.fCy.mo4412k(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                            } else {
                                C4990ab.m7411d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(i3), Long.valueOf(c3463b.fCv));
                                arrayList.add(c3463b);
                            }
                        }
                        this.fIf++;
                    }
                    size = arrayList.size();
                    if (size > 0) {
                        C1720g.m3537RQ();
                        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                        while (i < size) {
                            c37500n2.fLJ.mo43835b((C3463b) arrayList.get(i));
                            i++;
                        }
                        C1720g.m3537RQ();
                        C1720g.m3536RP().eJN.mo15640mB(iV);
                    }
                    AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
                    String str = super.toString() + "|RespHandler";
                    AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
                    return str;
                }
            }, true);
            AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
            AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
        }
    }

    /* renamed from: com.tencent.mm.az.n$1 */
    class C375011 implements C5015a {
        C375011() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(991);
            C4990ab.m7410d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
            C37500n c37500n = C37500n.this;
            long anU = C5046bo.anU();
            if (c37500n.frc && anU - c37500n.frn > 10000) {
                c37500n.frc = false;
            }
            if (c37500n.frc) {
                C4990ab.m7410d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
            } else {
                List list;
                C25850i c25850i = c37500n.fLJ;
                ArrayList arrayList = new ArrayList();
                Cursor a = c25850i.fni.mo10104a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"}, 0);
                if (a == null) {
                    list = arrayList;
                } else {
                    int count = a.getCount();
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            a.moveToPosition(i);
                            C3463b c3463b = new C3463b(0);
                            c3463b.f1272id = a.getInt(0);
                            c3463b.fCv = a.getLong(1);
                            c3463b.cmdId = a.getInt(2);
                            c3463b.buffer = a.getBlob(3);
                            c3463b.oqP = a.getInt(4);
                            c3463b.oqQ = a.getLong(5);
                            c3463b.oqR = a.getString(6);
                            c3463b.oqS = a.getString(7);
                            arrayList.add(c3463b);
                        }
                    }
                    a.close();
                    Object list2 = arrayList;
                }
                if (list2.size() == 0) {
                    C4990ab.m7410d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                } else {
                    if (!c37500n.frc && list2.size() > 0) {
                        c37500n.frn = anU;
                        c37500n.frc = true;
                        LinkedList<C3463b> linkedList = new LinkedList();
                        for (C3463b c3463b2 : list2) {
                            if (c3463b2.getCmdId() == 0 && c3463b2.oqP > 0) {
                                linkedList.add(c3463b2);
                            }
                        }
                        list2.removeAll(linkedList);
                        for (C3463b c3463b22 : linkedList) {
                            if ("@openim".equals(c3463b22.oqR)) {
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14541a(new C9768l(c3463b22), 0);
                            } else {
                                c37500n.fLJ.mo43835b(c3463b22);
                            }
                        }
                        if (!list2.isEmpty()) {
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(new C32323b(list2), 0);
                        }
                    }
                    C4990ab.m7411d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", Long.valueOf(c37500n.frn), Boolean.valueOf(c37500n.frc), Long.valueOf(System.currentTimeMillis() - anU), Integer.valueOf(list2.size()));
                }
            }
            AppMethodBeat.m2505o(991);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
            String str = super.toString() + "|pusherTry";
            AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
            return str;
        }
    }

    public C37500n(C25850i c25850i) {
        AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
        this.frc = false;
        this.fCy = new C7598c(200);
        this.fLI = new C7598c(200);
        this.fBy = new HashMap();
        this.frn = 0;
        this.fCD = 500;
        this.fCF = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C375011(), false);
        this.fBy = new HashMap();
        this.fLJ = c25850i;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(681, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(806, (C1202f) this);
        AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
    }

    /* renamed from: a */
    public final void mo7918a(int i, C3461a c3461a) {
        HashSet hashSet;
        AppMethodBeat.m2504i(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        HashSet hashSet2 = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet2 == null) {
            hashSet = new HashSet();
        } else {
            hashSet = hashSet2;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C3461a) weakReference.get()).equals(c3461a)) {
                AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
                return;
            }
        }
        hashSet.add(new WeakReference(c3461a));
        this.fBy.put(Integer.valueOf(i), hashSet);
        AppMethodBeat.m2505o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
    }

    /* renamed from: b */
    public final void mo7919b(int i, C3461a c3461a) {
        AppMethodBeat.m2504i(999);
        HashSet hashSet = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet == null) {
            AppMethodBeat.m2505o(999);
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C3461a) weakReference.get()).equals(c3461a)) {
                hashSet.remove(weakReference);
                AppMethodBeat.m2505o(999);
                return;
            }
        }
        if (hashSet.size() == 0) {
            this.fBy.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(999);
            return;
        }
        this.fBy.put(Integer.valueOf(i), hashSet);
        AppMethodBeat.m2505o(999);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo60428c(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(1000);
        HashSet hashSet = (HashSet) this.fBy.get(Integer.valueOf(i));
        if (hashSet == null) {
            AppMethodBeat.m2505o(1000);
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
            ((C3461a) it.next()).mo7917x(i2, str, str2);
        }
        linkedList.clear();
        AppMethodBeat.m2505o(1000);
    }

    /* renamed from: c */
    public final void mo7920c(C3463b c3463b) {
        AppMethodBeat.m2504i(1001);
        if (c3463b != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(c3463b.getCmdId());
            objArr[1] = Integer.valueOf(c3463b.getBuffer() == null ? -1 : c3463b.getBuffer().length);
            objArr[2] = C5046bo.dpG();
            C4990ab.m7417i(str, str2, objArr);
            c3463b.fCv = C5046bo.anU();
            C25850i c25850i = this.fLJ;
            if (c3463b != null) {
                c3463b.bJt = -1;
                ContentValues contentValues = new ContentValues();
                if ((c3463b.bJt & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(c3463b.fCv));
                }
                if ((c3463b.bJt & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(c3463b.getCmdId()));
                }
                if ((c3463b.bJt & 8) != 0) {
                    contentValues.put("buffer", c3463b.getBuffer());
                }
                if ((c3463b.bJt & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(c3463b.oqP));
                }
                if ((c3463b.bJt & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(c3463b.oqQ));
                }
                if ((c3463b.bJt & 64) != 0) {
                    contentValues.put("reserved3", c3463b.oqR);
                }
                if ((c3463b.bJt & 128) != 0) {
                    contentValues.put("reserved4", c3463b.oqS);
                }
                int insert = (int) c25850i.fni.insert("oplog2", "id", contentValues);
                if (insert > 0) {
                    c3463b.f1272id = insert;
                }
            }
        } else {
            C4990ab.m7416i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.fCF.mo16770ae(0, 0);
        AppMethodBeat.m2505o(1001);
    }

    /* renamed from: d */
    public final void mo7921d(C3463b c3463b) {
        AppMethodBeat.m2504i(1002);
        C1720g.m3537RQ();
        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
        this.fLJ.mo43835b(c3463b);
        C1720g.m3537RQ();
        C1720g.m3536RP().eJN.mo15640mB(iV);
        AppMethodBeat.m2505o(1002);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(1003);
        C4990ab.m7417i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        String str2;
        int cmdId;
        if (c1207m.getType() == 806) {
            bgu bgu = (bgu) ((C7472b) c1207m.ftl).fsH.fsP;
            C3463b c3463b = ((C9768l) c1207m).gfe;
            if (i != 0 && i2 != 0) {
                String str3 = "";
                if (bgu == null || bgu.getBaseResponse() == null) {
                    str2 = str3;
                } else {
                    str2 = C1946aa.m4148a(bgu.getBaseResponse().ErrMsg);
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    str = str2;
                }
                cmdId = c3463b.getCmdId();
                mo60428c(c3463b.getCmdId(), -1, "", str);
                this.frc = false;
                Integer num = (Integer) this.fLI.mo4404ai(Integer.valueOf(cmdId));
                C4990ab.m7411d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(cmdId), Long.valueOf(c3463b.fCv), num);
                if (num == null) {
                    this.fLI.mo4412k(Integer.valueOf(cmdId), Integer.valueOf(1));
                    AppMethodBeat.m2505o(1003);
                } else if (num.intValue() < 2) {
                    this.fLI.mo4412k(Integer.valueOf(cmdId), Integer.valueOf(num.intValue() + 1));
                    AppMethodBeat.m2505o(1003);
                } else {
                    C4990ab.m7411d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(cmdId), Long.valueOf(c3463b.fCv));
                    this.fLJ.mo43835b(c3463b);
                    AppMethodBeat.m2505o(1003);
                }
            } else if (c1207m instanceof C9768l) {
                int i3;
                long j;
                if (bgu.getBaseResponse() != null) {
                    i3 = bgu.getBaseResponse().Ret;
                } else {
                    i3 = 0;
                }
                C42023mc c42023mc = new C42023mc();
                c42023mc.cHU.ret = i3;
                C4879a.xxA.mo10055m(c42023mc);
                mo60428c(c3463b.getCmdId(), i3, "", "");
                C4990ab.m7417i("MicroMsg.OplogService", "openim op success, type:%d id %d", Integer.valueOf(c3463b.oqP), Integer.valueOf(c3463b.getCmdId()));
                this.fLJ.mo43835b(c3463b);
                this.frc = false;
                C7564ap c7564ap = this.fCF;
                if (this.fCy.size() > 0) {
                    j = 500;
                } else {
                    j = 0;
                }
                c7564ap.mo16770ae(j, j);
                AppMethodBeat.m2505o(1003);
            } else {
                AppMethodBeat.m2505o(1003);
            }
        } else if (c1207m.getType() != 681) {
            AppMethodBeat.m2505o(1003);
        } else if (i == 0 && i2 == 0 && ((C32323b) c1207m).fLr != null) {
            bhr bhr = ((C32323b) c1207m).fLr.fLu.fLw;
            if (bhr.Ret != 0 || bhr.wKS == null || bhr.wKS.wof == null) {
                C4990ab.m7413e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(bhr.Ret));
                this.frc = false;
                AppMethodBeat.m2505o(1003);
                return;
            }
            if (!(bhr.wKS == null || bhr.wKS.wof.size() == 0)) {
                C42023mc c42023mc2 = new C42023mc();
                c42023mc2.cHU.ret = ((Integer) bhr.wKS.wof.getLast()).intValue();
                LinkedList linkedList = bhr.wKS.wKT;
                c42023mc2.cHU.cHV = linkedList.isEmpty() ? "" : ((bhp) linkedList.getLast()).Title;
                C18321a c18321a = c42023mc2.cHU;
                if (linkedList.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = ((bhp) linkedList.getLast()).ncM;
                }
                c18321a.cHW = str2;
                if (C5046bo.isNullOrNil(c42023mc2.cHU.cHV) && C5046bo.isNullOrNil(c42023mc2.cHU.cHW)) {
                    for (cmdId = linkedList.size() - 1; cmdId >= 0; cmdId--) {
                        c42023mc2.cHU.cHV = ((bhp) linkedList.get(cmdId)).Title;
                        c42023mc2.cHU.cHW = ((bhp) linkedList.get(cmdId)).ncM;
                        if (!C5046bo.isNullOrNil(c42023mc2.cHU.cHV) || !C5046bo.isNullOrNil(c42023mc2.cHU.cHW)) {
                            break;
                        }
                    }
                }
                C4879a.xxA.mo10055m(c42023mc2);
            }
            new C17968a(this, ((C32323b) c1207m).fLs, bhr.wKS.wof, bhr.wKS.wKT).mo16770ae(50, 50);
            AppMethodBeat.m2505o(1003);
        } else {
            C4990ab.m7413e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", Integer.valueOf(i), Integer.valueOf(i2), ((C32323b) c1207m).fLr.toString());
            this.frc = false;
            AppMethodBeat.m2505o(1003);
        }
    }
}
