package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.model.av */
public final class C13417av implements C21919f {
    private static HashMap<String, C13418b> qNg = new HashMap();
    private static HashMap<String, WeakReference<C13418b>> qNh = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.model.av$b */
    class C13418b {
        long endTime = -1;
        int fjN = 0;
        boolean nnR = false;
        long qNi = -1;
        long qNk = -1;
        int qNl = 0;
        HashMap<String, C13419a> qNm = new HashMap();
        long startTime = -1;

        C13418b() {
            AppMethodBeat.m2504i(36674);
            AppMethodBeat.m2505o(36674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.av$a */
    class C13419a {
        String cHr;
        long qNi = -1;

        C13419a() {
        }
    }

    static {
        AppMethodBeat.m2504i(36681);
        AppMethodBeat.m2505o(36681);
    }

    /* renamed from: Yi */
    public static void m21558Yi(String str) {
        AppMethodBeat.m2504i(36675);
        if (C1947ae.giZ) {
            C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", str);
        }
        WeakReference weakReference = (WeakReference) qNh.get(str);
        if (weakReference != null) {
            C13418b c13418b = (C13418b) weakReference.get();
            if (c13418b != null) {
                c13418b.nnR = true;
                AppMethodBeat.m2505o(36675);
                return;
            }
        }
        AppMethodBeat.m2505o(36675);
    }

    /* renamed from: Yj */
    public static void m21559Yj(String str) {
        AppMethodBeat.m2504i(36676);
        if (C1947ae.giZ) {
            C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", str);
        }
        WeakReference weakReference = (WeakReference) qNh.get(str);
        if (weakReference != null) {
            C13418b c13418b = (C13418b) weakReference.get();
            if (c13418b != null) {
                if (c13418b != null && c13418b.qNi == -1) {
                    HashMap hashMap = c13418b.qNm;
                    if (hashMap != null && hashMap.containsKey(str)) {
                        C13419a c13419a = (C13419a) hashMap.get(str);
                        if (c13419a != null && c13419a.qNi == -1) {
                            c13419a.qNi = 1;
                            c13418b.qNl++;
                        }
                    }
                }
                AppMethodBeat.m2505o(36676);
                return;
            }
        }
        AppMethodBeat.m2505o(36676);
    }

    /* renamed from: Yk */
    public static void m21560Yk(String str) {
        AppMethodBeat.m2504i(36677);
        C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", str);
        if (qNg.containsKey(str)) {
            C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", str);
            C13418b c13418b = (C13418b) qNg.get(str);
            if (!(c13418b == null || c13418b.qNi != -1 || c13418b.startTime == -1)) {
                c13418b.qNi = 1;
                c13418b.qNl = c13418b.fjN;
                c13418b.endTime = System.currentTimeMillis();
                c13418b.qNk = c13418b.endTime - c13418b.startTime;
                for (C13419a c13419a : c13418b.qNm.values()) {
                    c13419a.qNi = 1;
                }
            }
        }
        AppMethodBeat.m2505o(36677);
    }

    /* renamed from: a */
    public final void mo25499a(String str, TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(36678);
        if (!qNg.containsKey(str)) {
            if (C1947ae.giZ) {
                C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", str);
            }
            if (timeLineObject != null && timeLineObject.xfI != null && timeLineObject.xfI.wbJ == 1 && timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0) {
                C13418b c13418b = new C13418b();
                c13418b.fjN = timeLineObject.xfI.wbK.size();
                c13418b.qNl = 0;
                c13418b.qNm = new HashMap();
                Iterator it = timeLineObject.xfI.wbK.iterator();
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    C13419a c13419a = new C13419a();
                    c13419a.cHr = bau.f17915Id;
                    c13418b.qNm.put(bau.f17915Id, c13419a);
                    qNh.put(bau.f17915Id, new WeakReference(c13418b));
                }
                c13418b.startTime = System.currentTimeMillis();
                qNg.put(str, c13418b);
                AppMethodBeat.m2505o(36678);
                return;
            } else if (C1947ae.giZ) {
                C4990ab.m7410d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
        AppMethodBeat.m2505o(36678);
    }

    /* renamed from: XJ */
    public final void mo25498XJ(String str) {
        AppMethodBeat.m2504i(36679);
        if (qNg.containsKey(str)) {
            if (C1947ae.giZ) {
                C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", str);
            }
            C13418b c13418b = (C13418b) qNg.get(str);
            if (!(c13418b == null || c13418b.startTime == -1 || c13418b.qNi != -1)) {
                c13418b.endTime = System.currentTimeMillis();
                c13418b.qNk = c13418b.endTime - c13418b.startTime;
                if (c13418b.qNl == c13418b.fjN) {
                    c13418b.qNi = 1;
                    AppMethodBeat.m2505o(36679);
                    return;
                }
                c13418b.qNi = 2;
            }
        }
        AppMethodBeat.m2505o(36679);
    }

    public final void cmU() {
        AppMethodBeat.m2504i(36680);
        C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", Integer.valueOf(qNg.size()));
        int cms = C29036i.cms();
        for (String str : qNg.keySet()) {
            C13418b c13418b = (C13418b) qNg.get(str);
            if (c13418b != null && c13418b.nnR) {
                if (c13418b.qNk == -1 || c13418b.qNi == -1 || c13418b.startTime == -1) {
                    if (c13418b.startTime != -1) {
                        c13418b.endTime = System.currentTimeMillis();
                        c13418b.qNk = c13418b.endTime - c13418b.startTime;
                        if (c13418b.fjN == c13418b.qNl) {
                            c13418b.qNi = 1;
                        } else {
                            c13418b.qNi = 2;
                        }
                    }
                }
                C4990ab.m7411d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", Integer.valueOf(c13418b.fjN), Long.valueOf(c13418b.qNi), Long.valueOf(c13418b.qNk), Integer.valueOf(c13418b.qNl), Integer.valueOf(cms));
                C7060h.pYm.mo8381e(11600, Integer.valueOf(c13418b.fjN), Long.valueOf(c13418b.qNi), Long.valueOf(c13418b.qNk), Integer.valueOf(c13418b.qNl), Integer.valueOf(cms));
            }
        }
        qNg.clear();
        qNh.clear();
        AppMethodBeat.m2505o(36680);
    }
}
