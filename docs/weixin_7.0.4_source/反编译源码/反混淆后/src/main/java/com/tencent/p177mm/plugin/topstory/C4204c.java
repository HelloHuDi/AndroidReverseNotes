package com.tencent.p177mm.plugin.topstory;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.topstory.p539a.C43692f;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C39960b;
import com.tencent.p177mm.plugin.topstory.p539a.p540a.C4202a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.topstory.c */
public final class C4204c implements C43692f {
    C7306ak sAv = new C7306ak(new C5004al("TopStoryReportExposeTask").oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(65492);
            switch (message.what) {
                case 0:
                    ((C4205a) message.obj).run();
                    break;
            }
            AppMethodBeat.m2505o(65492);
        }
    };
    Map<Long, C4205a> sAw = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.topstory.c$a */
    class C4205a implements Runnable {
        long createTime;
        HashSet<C39960b> sAy;
        chv sAz;

        private C4205a() {
            AppMethodBeat.m2504i(65494);
            this.sAy = new HashSet();
            AppMethodBeat.m2505o(65494);
        }

        /* synthetic */ C4205a(C4204c c4204c, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(65495);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
            C4204c.this.sAw.remove(Long.valueOf(this.sAz.xgG));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.sAy);
            int i = 0;
            while (true) {
                List subList;
                int i2 = i + 20;
                if (i2 >= arrayList.size()) {
                    subList = arrayList.subList(i, arrayList.size());
                } else {
                    subList = arrayList.subList(i, i2);
                }
                String a = C4205a.m6552a(subList, this.sAz);
                if (!C5046bo.isNullOrNil(a)) {
                    final bsj bsj = new bsj();
                    bsj.wUu = a;
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", Integer.valueOf(subList.size()), bsj.wUu);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(65493);
                            C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
                            AppMethodBeat.m2505o(65493);
                        }
                    });
                }
                if (i2 >= arrayList.size()) {
                    AppMethodBeat.m2505o(65495);
                    return;
                }
                i = i2;
            }
        }

        /* renamed from: a */
        private static String m6552a(List<C39960b> list, chv chv) {
            AppMethodBeat.m2504i(65496);
            if (list.size() == 0) {
                AppMethodBeat.m2505o(65496);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("isexpose=1&content=");
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (C39960b c39960b : list) {
                chw chw = c39960b.sAX;
                stringBuilder2.append(chw.ctk);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(chw.ubA);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(c39960b.mLr);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(chw.xgV);
                stringBuilder2.append(";");
            }
            try {
                stringBuilder.append(C18178q.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e, "", new Object[0]);
            }
            try {
                chw chw2;
                stringBuilder.append("&resulttype=");
                for (C39960b c39960b2 : list) {
                    chw2 = c39960b2.sAX;
                    stringBuilder.append(chw2.ctk);
                    stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder.append(chw2.xgZ);
                    stringBuilder.append(";");
                }
                stringBuilder.append("&expand=");
                stringBuilder2 = new StringBuilder("");
                for (C39960b c39960b22 : list) {
                    chw2 = c39960b22.sAX;
                    stringBuilder2.append(chw2.ctk);
                    stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder2.append(chw2.xgX);
                    stringBuilder2.append(";");
                }
                try {
                    stringBuilder.append(C18178q.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
                } catch (UnsupportedEncodingException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e2, "", new Object[0]);
                }
                stringBuilder.append("&itemtype=");
                stringBuilder2 = new StringBuilder("");
                for (C39960b c39960b222 : list) {
                    stringBuilder2.append(c39960b222.sAX.xgW);
                    stringBuilder2.append(";");
                }
                stringBuilder.append(stringBuilder2);
                if (chv != null) {
                    stringBuilder.append("&");
                    stringBuilder.append("searchid=");
                    stringBuilder.append(chv.hlm);
                    stringBuilder.append("&");
                    stringBuilder.append("query=");
                    try {
                        stringBuilder.append(C18178q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e3, "", new Object[0]);
                    }
                    stringBuilder.append("&");
                    stringBuilder.append("ishomepage=0");
                    stringBuilder.append("&");
                    stringBuilder.append("sessionid=");
                    stringBuilder.append(C46400aa.m87299HP(chv.scene));
                    stringBuilder.append("&");
                    stringBuilder.append("scene=");
                    stringBuilder.append(chv.scene);
                    stringBuilder.append("&rec_category=");
                    stringBuilder.append(chv.xgG);
                }
                String stringBuilder3 = stringBuilder.toString();
                AppMethodBeat.m2505o(65496);
                return stringBuilder3;
            } catch (Exception e32) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e32, "build14057VideoInfoExposeString error: %s", e32.getMessage());
                AppMethodBeat.m2505o(65496);
                return null;
            }
        }
    }

    public C4204c() {
        AppMethodBeat.m2504i(65497);
        AppMethodBeat.m2505o(65497);
    }

    /* renamed from: a */
    public final void mo9125a(chv chv, HashSet<C39960b> hashSet) {
        AppMethodBeat.m2504i(65498);
        if (hashSet.size() == 0) {
            AppMethodBeat.m2505o(65498);
            return;
        }
        C4205a c4205a = (C4205a) this.sAw.get(Long.valueOf(chv.xgG));
        Iterator it;
        if (c4205a == null || !this.sAv.hasMessages(0)) {
            if (c4205a != null) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", c4205a, Integer.valueOf(c4205a.sAy.size()));
            }
            C4205a c4205a2 = new C4205a(this, (byte) 0);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", Integer.valueOf(hashSet.size()), c4205a2);
            c4205a2.createTime = System.currentTimeMillis();
            it = hashSet.iterator();
            while (it.hasNext()) {
                c4205a2.sAy.add((C39960b) it.next());
            }
            c4205a2.sAz = chv;
            if (c4205a2.sAy.size() > 0) {
                this.sAv.removeMessages(0);
                this.sAv.sendMessageDelayed(this.sAv.obtainMessage(0, c4205a2), 5000);
                this.sAw.put(Long.valueOf(chv.xgG), c4205a2);
            }
            AppMethodBeat.m2505o(65498);
            return;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", Integer.valueOf(c4205a.sAy.size()), Integer.valueOf(hashSet.size()));
        it = hashSet.iterator();
        while (it.hasNext()) {
            c4205a.sAy.add((C39960b) it.next());
        }
        AppMethodBeat.m2505o(65498);
    }

    /* renamed from: a */
    public static void m6547a(chv chv, chw chw, C29428a c29428a) {
        AppMethodBeat.m2504i(65499);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", chw, c29428a);
        if (!(chw == null || c29428a == null)) {
            c29428a.sAF = System.currentTimeMillis();
            c29428a.sAG = c29428a.sAF - c29428a.sAE;
            String b = C4204c.m6549b(chv, chw, c29428a);
            if (!C5046bo.isNullOrNil(b)) {
                bsj bsj = new bsj();
                bsj.wUu = b;
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", bsj.wUu);
                C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(chv.scene), chw.xgS, Long.valueOf(chw.xha), "mp4", Integer.valueOf(chw.xgR), Integer.valueOf(0), Long.valueOf(c29428a.sAE), Long.valueOf(c29428a.sAF), Long.valueOf(c29428a.sAH), Long.valueOf(c29428a.sAG), Long.valueOf(c29428a.sAJ), Long.valueOf(c29428a.sAK), Long.valueOf(c29428a.sAL), Long.valueOf(c29428a.sAM), Long.valueOf(c29428a.sAP), Long.valueOf(c29428a.sAQ), Long.valueOf(c29428a.sAI), Long.valueOf(c29428a.sAR), Long.valueOf(c29428a.sAS), Long.valueOf(c29428a.sAU), Long.valueOf(c29428a.sAV), c29428a.fjS, Long.valueOf(c29428a.position), C46400aa.bVP(), Long.valueOf(c29428a.sAT), Long.valueOf(c29428a.sAW), Long.valueOf(c29428a.sAN), Long.valueOf(c29428a.sAO), chv.xgj}));
            C7053e.pXa.mo8374X(15414, b);
            C4202a.m6546a(c29428a);
        }
        AppMethodBeat.m2505o(65499);
    }

    /* renamed from: a */
    public final void mo9124a(chv chv, chw chw, int i, int i2, String str) {
        AppMethodBeat.m2504i(65500);
        String b = C4204c.m6548b(chv, chw, i, i2, str);
        if (!C5046bo.isNullOrNil(b)) {
            bsj bsj = new bsj();
            bsj.wUu = b;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", bsj.wUu);
            C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        }
        AppMethodBeat.m2505o(65500);
    }

    /* renamed from: b */
    private static String m6548b(chv chv, chw chw, int i, int i2, String str) {
        AppMethodBeat.m2504i(65501);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("scene=");
        stringBuilder.append(chv.scene);
        stringBuilder.append("&");
        stringBuilder.append("businesstype=3");
        stringBuilder.append("&");
        stringBuilder.append("mediatype=2");
        stringBuilder.append("&");
        stringBuilder.append("docid=");
        stringBuilder.append(chw.ubA);
        stringBuilder.append("&");
        stringBuilder.append("typepos=");
        stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuilder.append("&");
        stringBuilder.append("docpos=");
        stringBuilder.append(i + 1);
        stringBuilder.append("&");
        stringBuilder.append("searchid=");
        stringBuilder.append(chv.hlm);
        stringBuilder.append("&");
        stringBuilder.append("ishomepage=");
        stringBuilder.append(0);
        stringBuilder.append("&rec_category=");
        stringBuilder.append(chw.xgT);
        stringBuilder.append("&");
        stringBuilder.append("timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("&");
        stringBuilder.append("clicktype=");
        stringBuilder.append(i2);
        stringBuilder.append("&");
        stringBuilder.append("clickcontent=");
        try {
            stringBuilder.append(C18178q.encode(str, ProtocolPackage.ServerEncoding));
        } catch (Exception e) {
        }
        try {
            stringBuilder.append("&");
            stringBuilder.append("clicksource=");
            stringBuilder.append("4");
            stringBuilder.append("&");
            stringBuilder.append("sceneactiontype=");
            stringBuilder.append(1);
            stringBuilder.append("&");
            stringBuilder.append("query=");
            try {
                stringBuilder.append(C18178q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
            }
            stringBuilder.append("&");
            stringBuilder.append("resulttype=");
            stringBuilder.append(chw.xgZ);
            stringBuilder.append("&");
            stringBuilder.append("sessionid=");
            stringBuilder.append(C46400aa.m87299HP(chv.scene));
            stringBuilder.append("&");
            stringBuilder.append("expand=");
            try {
                stringBuilder.append(C18178q.encode(chw.xgV, ProtocolPackage.ServerEncoding));
            } catch (Exception e3) {
            }
            stringBuilder.append("&");
            stringBuilder.append("title=");
            try {
                stringBuilder.append(C18178q.encode(chw.title, ProtocolPackage.ServerEncoding));
            } catch (Exception e4) {
            }
            stringBuilder.append("&");
            stringBuilder.append("nettype=");
            if (C5023at.isWifi(C4996ah.getContext())) {
                stringBuilder.append("wifi");
            } else if (C5023at.is4G(C4996ah.getContext())) {
                stringBuilder.append("4g");
            } else {
                stringBuilder.append("3g");
            }
            stringBuilder.append("&");
            stringBuilder.append("itemtype=");
            stringBuilder.append(chw.xgW);
        } catch (Exception e5) {
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(65501);
        return stringBuilder2;
    }

    /* renamed from: b */
    private static String m6549b(chv chv, chw chw, C29428a c29428a) {
        AppMethodBeat.m2504i(65502);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("ismediaplay=1");
        stringBuilder.append("&searchid=");
        stringBuilder.append(chv.hlm);
        stringBuilder.append("&scene=");
        stringBuilder.append(chv.scene);
        stringBuilder.append("&businesstype=3");
        stringBuilder.append("&mediatype=2");
        stringBuilder.append("&rec_category=");
        stringBuilder.append(chv.xgG);
        stringBuilder.append("&docid=");
        stringBuilder.append(chw.ubA);
        try {
            stringBuilder.append("&expand1=").append(C18178q.encode(chw.xgV, ProtocolPackage.ServerEncoding));
        } catch (Exception e) {
        }
        stringBuilder.append("&query=");
        try {
            stringBuilder.append(C18178q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
        } catch (Exception e2) {
        }
        stringBuilder.append("&title=");
        try {
            stringBuilder.append(C18178q.encode(chw.title, ProtocolPackage.ServerEncoding));
        } catch (Exception e3) {
        }
        stringBuilder.append("&duration=");
        stringBuilder.append(chw.xgR * 1000);
        stringBuilder.append("&mediaid=");
        stringBuilder.append(chw.xgS);
        if (c29428a != null) {
            stringBuilder.append("&startplaytime=");
            stringBuilder.append(c29428a.sAE);
            stringBuilder.append("&endplaytime=");
            stringBuilder.append(c29428a.sAF);
            stringBuilder.append("&playtime=");
            stringBuilder.append(c29428a.sAG);
            stringBuilder.append("&lastplayms=");
            stringBuilder.append(c29428a.sAH);
            stringBuilder.append("&autoplay=");
            stringBuilder.append(c29428a.sAL);
            stringBuilder.append("&hasplayended=");
            stringBuilder.append(c29428a.sAI);
            stringBuilder.append("&hasquickplay=");
            stringBuilder.append(c29428a.sAJ);
            stringBuilder.append("&hasfullscreen=");
            stringBuilder.append(c29428a.sAK);
            stringBuilder.append("&hitpreload=");
            stringBuilder.append(c29428a.sAM);
            stringBuilder.append("&firstloadtime=");
            stringBuilder.append(c29428a.sAP);
            stringBuilder.append("&downloadfinishtime=");
            stringBuilder.append(c29428a.sAQ);
            stringBuilder.append("&firstmoovreadytime=");
            stringBuilder.append(c29428a.sAR);
            stringBuilder.append("&firstdataavailabletime=");
            stringBuilder.append(c29428a.sAU);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(65502);
        return stringBuilder2;
    }
}
