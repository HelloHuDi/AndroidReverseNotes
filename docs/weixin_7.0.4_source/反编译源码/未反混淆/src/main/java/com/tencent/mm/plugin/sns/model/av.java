package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class av implements f {
    private static HashMap<String, b> qNg = new HashMap();
    private static HashMap<String, WeakReference<b>> qNh = new HashMap();

    class b {
        long endTime = -1;
        int fjN = 0;
        boolean nnR = false;
        long qNi = -1;
        long qNk = -1;
        int qNl = 0;
        HashMap<String, a> qNm = new HashMap();
        long startTime = -1;

        b() {
            AppMethodBeat.i(36674);
            AppMethodBeat.o(36674);
        }
    }

    class a {
        String cHr;
        long qNi = -1;

        a() {
        }
    }

    static {
        AppMethodBeat.i(36681);
        AppMethodBeat.o(36681);
    }

    public static void Yi(String str) {
        AppMethodBeat.i(36675);
        if (ae.giZ) {
            ab.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", str);
        }
        WeakReference weakReference = (WeakReference) qNh.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.nnR = true;
                AppMethodBeat.o(36675);
                return;
            }
        }
        AppMethodBeat.o(36675);
    }

    public static void Yj(String str) {
        AppMethodBeat.i(36676);
        if (ae.giZ) {
            ab.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", str);
        }
        WeakReference weakReference = (WeakReference) qNh.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                if (bVar != null && bVar.qNi == -1) {
                    HashMap hashMap = bVar.qNm;
                    if (hashMap != null && hashMap.containsKey(str)) {
                        a aVar = (a) hashMap.get(str);
                        if (aVar != null && aVar.qNi == -1) {
                            aVar.qNi = 1;
                            bVar.qNl++;
                        }
                    }
                }
                AppMethodBeat.o(36676);
                return;
            }
        }
        AppMethodBeat.o(36676);
    }

    public static void Yk(String str) {
        AppMethodBeat.i(36677);
        ab.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", str);
        if (qNg.containsKey(str)) {
            ab.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", str);
            b bVar = (b) qNg.get(str);
            if (!(bVar == null || bVar.qNi != -1 || bVar.startTime == -1)) {
                bVar.qNi = 1;
                bVar.qNl = bVar.fjN;
                bVar.endTime = System.currentTimeMillis();
                bVar.qNk = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.qNm.values()) {
                    aVar.qNi = 1;
                }
            }
        }
        AppMethodBeat.o(36677);
    }

    public final void a(String str, TimeLineObject timeLineObject) {
        AppMethodBeat.i(36678);
        if (!qNg.containsKey(str)) {
            if (ae.giZ) {
                ab.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", str);
            }
            if (timeLineObject != null && timeLineObject.xfI != null && timeLineObject.xfI.wbJ == 1 && timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0) {
                b bVar = new b();
                bVar.fjN = timeLineObject.xfI.wbK.size();
                bVar.qNl = 0;
                bVar.qNm = new HashMap();
                Iterator it = timeLineObject.xfI.wbK.iterator();
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    a aVar = new a();
                    aVar.cHr = bau.Id;
                    bVar.qNm.put(bau.Id, aVar);
                    qNh.put(bau.Id, new WeakReference(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                qNg.put(str, bVar);
                AppMethodBeat.o(36678);
                return;
            } else if (ae.giZ) {
                ab.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
        AppMethodBeat.o(36678);
    }

    public final void XJ(String str) {
        AppMethodBeat.i(36679);
        if (qNg.containsKey(str)) {
            if (ae.giZ) {
                ab.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", str);
            }
            b bVar = (b) qNg.get(str);
            if (!(bVar == null || bVar.startTime == -1 || bVar.qNi != -1)) {
                bVar.endTime = System.currentTimeMillis();
                bVar.qNk = bVar.endTime - bVar.startTime;
                if (bVar.qNl == bVar.fjN) {
                    bVar.qNi = 1;
                    AppMethodBeat.o(36679);
                    return;
                }
                bVar.qNi = 2;
            }
        }
        AppMethodBeat.o(36679);
    }

    public final void cmU() {
        AppMethodBeat.i(36680);
        ab.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", Integer.valueOf(qNg.size()));
        int cms = i.cms();
        for (String str : qNg.keySet()) {
            b bVar = (b) qNg.get(str);
            if (bVar != null && bVar.nnR) {
                if (bVar.qNk == -1 || bVar.qNi == -1 || bVar.startTime == -1) {
                    if (bVar.startTime != -1) {
                        bVar.endTime = System.currentTimeMillis();
                        bVar.qNk = bVar.endTime - bVar.startTime;
                        if (bVar.fjN == bVar.qNl) {
                            bVar.qNi = 1;
                        } else {
                            bVar.qNi = 2;
                        }
                    }
                }
                ab.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", Integer.valueOf(bVar.fjN), Long.valueOf(bVar.qNi), Long.valueOf(bVar.qNk), Integer.valueOf(bVar.qNl), Integer.valueOf(cms));
                h.pYm.e(11600, Integer.valueOf(bVar.fjN), Long.valueOf(bVar.qNi), Long.valueOf(bVar.qNk), Integer.valueOf(bVar.qNl), Integer.valueOf(cms));
            }
        }
        qNg.clear();
        qNh.clear();
        AppMethodBeat.o(36680);
    }
}
