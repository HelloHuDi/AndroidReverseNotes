package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements f {
    ak sAv = new ak(new al("TopStoryReportExposeTask").oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(65492);
            switch (message.what) {
                case 0:
                    ((a) message.obj).run();
                    break;
            }
            AppMethodBeat.o(65492);
        }
    };
    Map<Long, a> sAw = new ConcurrentHashMap();

    class a implements Runnable {
        long createTime;
        HashSet<b> sAy;
        chv sAz;

        private a() {
            AppMethodBeat.i(65494);
            this.sAy = new HashSet();
            AppMethodBeat.o(65494);
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(65495);
            ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
            c.this.sAw.remove(Long.valueOf(this.sAz.xgG));
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
                String a = a(subList, this.sAz);
                if (!bo.isNullOrNil(a)) {
                    final bsj bsj = new bsj();
                    bsj.wUu = a;
                    ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", Integer.valueOf(subList.size()), bsj.wUu);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(65493);
                            g.Rg().a(new w(bsj), 0);
                            AppMethodBeat.o(65493);
                        }
                    });
                }
                if (i2 >= arrayList.size()) {
                    AppMethodBeat.o(65495);
                    return;
                }
                i = i2;
            }
        }

        private static String a(List<b> list, chv chv) {
            AppMethodBeat.i(65496);
            if (list.size() == 0) {
                AppMethodBeat.o(65496);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("isexpose=1&content=");
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (b bVar : list) {
                chw chw = bVar.sAX;
                stringBuilder2.append(chw.ctk);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(chw.ubA);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(bVar.mLr);
                stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder2.append(chw.xgV);
                stringBuilder2.append(";");
            }
            try {
                stringBuilder.append(q.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e, "", new Object[0]);
            }
            try {
                chw chw2;
                stringBuilder.append("&resulttype=");
                for (b bVar2 : list) {
                    chw2 = bVar2.sAX;
                    stringBuilder.append(chw2.ctk);
                    stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder.append(chw2.xgZ);
                    stringBuilder.append(";");
                }
                stringBuilder.append("&expand=");
                stringBuilder2 = new StringBuilder("");
                for (b bVar22 : list) {
                    chw2 = bVar22.sAX;
                    stringBuilder2.append(chw2.ctk);
                    stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder2.append(chw2.xgX);
                    stringBuilder2.append(";");
                }
                try {
                    stringBuilder.append(q.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
                } catch (UnsupportedEncodingException e2) {
                    ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e2, "", new Object[0]);
                }
                stringBuilder.append("&itemtype=");
                stringBuilder2 = new StringBuilder("");
                for (b bVar222 : list) {
                    stringBuilder2.append(bVar222.sAX.xgW);
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
                        stringBuilder.append(q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e3, "", new Object[0]);
                    }
                    stringBuilder.append("&");
                    stringBuilder.append("ishomepage=0");
                    stringBuilder.append("&");
                    stringBuilder.append("sessionid=");
                    stringBuilder.append(aa.HP(chv.scene));
                    stringBuilder.append("&");
                    stringBuilder.append("scene=");
                    stringBuilder.append(chv.scene);
                    stringBuilder.append("&rec_category=");
                    stringBuilder.append(chv.xgG);
                }
                String stringBuilder3 = stringBuilder.toString();
                AppMethodBeat.o(65496);
                return stringBuilder3;
            } catch (Exception e32) {
                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e32, "build14057VideoInfoExposeString error: %s", e32.getMessage());
                AppMethodBeat.o(65496);
                return null;
            }
        }
    }

    public c() {
        AppMethodBeat.i(65497);
        AppMethodBeat.o(65497);
    }

    public final void a(chv chv, HashSet<b> hashSet) {
        AppMethodBeat.i(65498);
        if (hashSet.size() == 0) {
            AppMethodBeat.o(65498);
            return;
        }
        a aVar = (a) this.sAw.get(Long.valueOf(chv.xgG));
        Iterator it;
        if (aVar == null || !this.sAv.hasMessages(0)) {
            if (aVar != null) {
                ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", aVar, Integer.valueOf(aVar.sAy.size()));
            }
            a aVar2 = new a(this, (byte) 0);
            ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", Integer.valueOf(hashSet.size()), aVar2);
            aVar2.createTime = System.currentTimeMillis();
            it = hashSet.iterator();
            while (it.hasNext()) {
                aVar2.sAy.add((b) it.next());
            }
            aVar2.sAz = chv;
            if (aVar2.sAy.size() > 0) {
                this.sAv.removeMessages(0);
                this.sAv.sendMessageDelayed(this.sAv.obtainMessage(0, aVar2), 5000);
                this.sAw.put(Long.valueOf(chv.xgG), aVar2);
            }
            AppMethodBeat.o(65498);
            return;
        }
        ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", Integer.valueOf(aVar.sAy.size()), Integer.valueOf(hashSet.size()));
        it = hashSet.iterator();
        while (it.hasNext()) {
            aVar.sAy.add((b) it.next());
        }
        AppMethodBeat.o(65498);
    }

    public static void a(chv chv, chw chw, com.tencent.mm.plugin.topstory.a.b.a aVar) {
        AppMethodBeat.i(65499);
        ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", chw, aVar);
        if (!(chw == null || aVar == null)) {
            aVar.sAF = System.currentTimeMillis();
            aVar.sAG = aVar.sAF - aVar.sAE;
            String b = b(chv, chw, aVar);
            if (!bo.isNullOrNil(b)) {
                bsj bsj = new bsj();
                bsj.wUu = b;
                ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", bsj.wUu);
                g.Rg().a(new w(bsj), 0);
            }
            ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(chv.scene), chw.xgS, Long.valueOf(chw.xha), "mp4", Integer.valueOf(chw.xgR), Integer.valueOf(0), Long.valueOf(aVar.sAE), Long.valueOf(aVar.sAF), Long.valueOf(aVar.sAH), Long.valueOf(aVar.sAG), Long.valueOf(aVar.sAJ), Long.valueOf(aVar.sAK), Long.valueOf(aVar.sAL), Long.valueOf(aVar.sAM), Long.valueOf(aVar.sAP), Long.valueOf(aVar.sAQ), Long.valueOf(aVar.sAI), Long.valueOf(aVar.sAR), Long.valueOf(aVar.sAS), Long.valueOf(aVar.sAU), Long.valueOf(aVar.sAV), aVar.fjS, Long.valueOf(aVar.position), aa.bVP(), Long.valueOf(aVar.sAT), Long.valueOf(aVar.sAW), Long.valueOf(aVar.sAN), Long.valueOf(aVar.sAO), chv.xgj}));
            e.pXa.X(15414, b);
            com.tencent.mm.plugin.topstory.a.a.a.a(aVar);
        }
        AppMethodBeat.o(65499);
    }

    public final void a(chv chv, chw chw, int i, int i2, String str) {
        AppMethodBeat.i(65500);
        String b = b(chv, chw, i, i2, str);
        if (!bo.isNullOrNil(b)) {
            bsj bsj = new bsj();
            bsj.wUu = b;
            ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", bsj.wUu);
            g.Rg().a(new w(bsj), 0);
        }
        AppMethodBeat.o(65500);
    }

    private static String b(chv chv, chw chw, int i, int i2, String str) {
        AppMethodBeat.i(65501);
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
            stringBuilder.append(q.encode(str, ProtocolPackage.ServerEncoding));
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
                stringBuilder.append(q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
            }
            stringBuilder.append("&");
            stringBuilder.append("resulttype=");
            stringBuilder.append(chw.xgZ);
            stringBuilder.append("&");
            stringBuilder.append("sessionid=");
            stringBuilder.append(aa.HP(chv.scene));
            stringBuilder.append("&");
            stringBuilder.append("expand=");
            try {
                stringBuilder.append(q.encode(chw.xgV, ProtocolPackage.ServerEncoding));
            } catch (Exception e3) {
            }
            stringBuilder.append("&");
            stringBuilder.append("title=");
            try {
                stringBuilder.append(q.encode(chw.title, ProtocolPackage.ServerEncoding));
            } catch (Exception e4) {
            }
            stringBuilder.append("&");
            stringBuilder.append("nettype=");
            if (at.isWifi(ah.getContext())) {
                stringBuilder.append("wifi");
            } else if (at.is4G(ah.getContext())) {
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
        AppMethodBeat.o(65501);
        return stringBuilder2;
    }

    private static String b(chv chv, chw chw, com.tencent.mm.plugin.topstory.a.b.a aVar) {
        AppMethodBeat.i(65502);
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
            stringBuilder.append("&expand1=").append(q.encode(chw.xgV, ProtocolPackage.ServerEncoding));
        } catch (Exception e) {
        }
        stringBuilder.append("&query=");
        try {
            stringBuilder.append(q.encode(chv.ctj, ProtocolPackage.ServerEncoding));
        } catch (Exception e2) {
        }
        stringBuilder.append("&title=");
        try {
            stringBuilder.append(q.encode(chw.title, ProtocolPackage.ServerEncoding));
        } catch (Exception e3) {
        }
        stringBuilder.append("&duration=");
        stringBuilder.append(chw.xgR * 1000);
        stringBuilder.append("&mediaid=");
        stringBuilder.append(chw.xgS);
        if (aVar != null) {
            stringBuilder.append("&startplaytime=");
            stringBuilder.append(aVar.sAE);
            stringBuilder.append("&endplaytime=");
            stringBuilder.append(aVar.sAF);
            stringBuilder.append("&playtime=");
            stringBuilder.append(aVar.sAG);
            stringBuilder.append("&lastplayms=");
            stringBuilder.append(aVar.sAH);
            stringBuilder.append("&autoplay=");
            stringBuilder.append(aVar.sAL);
            stringBuilder.append("&hasplayended=");
            stringBuilder.append(aVar.sAI);
            stringBuilder.append("&hasquickplay=");
            stringBuilder.append(aVar.sAJ);
            stringBuilder.append("&hasfullscreen=");
            stringBuilder.append(aVar.sAK);
            stringBuilder.append("&hitpreload=");
            stringBuilder.append(aVar.sAM);
            stringBuilder.append("&firstloadtime=");
            stringBuilder.append(aVar.sAP);
            stringBuilder.append("&downloadfinishtime=");
            stringBuilder.append(aVar.sAQ);
            stringBuilder.append("&firstmoovreadytime=");
            stringBuilder.append(aVar.sAR);
            stringBuilder.append("&firstdataavailabletime=");
            stringBuilder.append(aVar.sAU);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(65502);
        return stringBuilder2;
    }
}
