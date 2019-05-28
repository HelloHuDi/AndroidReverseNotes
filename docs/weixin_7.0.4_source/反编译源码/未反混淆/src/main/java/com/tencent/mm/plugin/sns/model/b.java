package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.h;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b implements f, com.tencent.mm.plugin.sns.model.a.c.a {
    static int qHB = 0;
    private static final int qHC = (VERSION.SDK_INT >= 14 ? 100 : 25);
    public final byte[] eHH;
    LinkedList<com.tencent.mm.plugin.sns.data.f> eow;
    Set<b> epg;
    private ak handler;
    private long qHD;
    private int qHE;
    private int qHF;
    private LinkedList<g> qHG;
    public HashMap<String, Long> qHH;
    HashMap<String, String> qHI;
    public boolean qHJ;
    public Set<a> qHK;
    private Map<String, Long> qHL;
    Map<String, com.tencent.mm.plugin.sns.data.c> qHM;
    public ConcurrentHashMap<String, c> qHN;
    public CopyOnWriteArrayList<String> qHO;

    public interface a {
        void fW(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String IN;
        final /* synthetic */ String bSt;

        public AnonymousClass3(String str, String str2) {
            this.IN = str;
            this.bSt = str2;
        }

        public final void run() {
            AppMethodBeat.i(36101);
            if (b.this.qHK != null) {
                for (a aVar : b.this.qHK) {
                    if (aVar != null) {
                        aVar.fW(this.IN, this.bSt);
                    }
                }
            }
            AppMethodBeat.o(36101);
        }
    }

    public static class c {
        final String cFc;
        private final byte[] eMl = new byte[0];
        boolean eTM;
        private int fjN;
        public boolean qHS;
        long startTime;

        public c(String str, int i) {
            AppMethodBeat.i(36104);
            this.cFc = str;
            this.fjN = i;
            this.startTime = -1;
            this.qHS = false;
            this.eTM = false;
            ab.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", str, Integer.valueOf(i), this);
            AppMethodBeat.o(36104);
        }

        public final void setStartTime(long j) {
            AppMethodBeat.i(138245);
            if (this.qHS) {
                AppMethodBeat.o(138245);
                return;
            }
            synchronized (this.eMl) {
                try {
                    if (!this.qHS) {
                        this.qHS = true;
                        this.startTime = j;
                        ab.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", this.cFc, Long.valueOf(this.startTime), this);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(138245);
                }
            }
        }

        public final void cmL() {
            synchronized (this.eMl) {
                if (this.fjN > 0) {
                    this.fjN--;
                }
                if (this.fjN == 0) {
                    this.eTM = true;
                }
            }
        }
    }

    public interface b {
        void Xw(String str);

        void bj(String str, boolean z);

        void bk(String str, boolean z);

        void cmu();
    }

    class d implements IdleHandler {
        d() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(36105);
            ab.d("MicroMsg.DownloadManager", "I run idleHandler ");
            b.this.qHD = bo.anT();
            boolean a = b.a(b.this);
            AppMethodBeat.o(36105);
            return a;
        }
    }

    public final void aa(int i, boolean z) {
        AppMethodBeat.i(36106);
        this.qHF = i;
        try {
            String value;
            String str;
            if (at.isWifi(ah.getContext())) {
                value = com.tencent.mm.m.g.Nu().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = com.tencent.mm.m.g.Nu().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (bo.isNullOrNil(value) && com.tencent.mm.sdk.a.b.dnO()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!bo.isNullOrNil(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = (bo.ank(split[1]) + (bo.ank(split[0]) * 60)) - ((((int) i.afB()) - 8) * 60);
                if (ank < 0) {
                    i2 = ank + 1440;
                } else if (ank >= 1440) {
                    i2 = ank - 1440;
                } else {
                    i2 = ank;
                }
                String[] split2 = str.split(";");
                for (int i3 = 0; i3 < split2.length; i3++) {
                    if (!bo.isNullOrNil(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            ab.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", Integer.valueOf(i3), str);
                        } else {
                            String[] split3 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            int ank2 = bo.ank(split3[1]) + (bo.ank(split3[0]) * 60);
                            String[] split4 = split[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            ab.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", Integer.valueOf(i3), Integer.valueOf(ank2), Integer.valueOf(bo.ank(split4[1]) + (bo.ank(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]);
                            if (i2 <= bo.ank(split4[1]) + (bo.ank(split4[0]) * 60) && i2 > ank2) {
                                ank = bo.ank(z ? split[2] : split[3]);
                                if (ank > 0) {
                                    this.qHF = ank;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.DownloadManager", "setMaxThread :%s", bo.l(e));
        }
        ab.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", Integer.valueOf(this.qHF));
        AppMethodBeat.o(36106);
    }

    public b() {
        AppMethodBeat.i(36107);
        this.handler = null;
        this.qHD = 0;
        this.qHE = 0;
        this.qHF = 2;
        this.qHG = new LinkedList();
        this.qHH = new HashMap();
        this.eHH = new byte[0];
        this.qHI = new HashMap();
        this.qHJ = true;
        this.epg = new HashSet();
        this.qHK = new HashSet();
        this.eow = new LinkedList();
        this.qHL = new ConcurrentHashMap();
        this.qHM = new HashMap();
        this.qHN = new ConcurrentHashMap();
        this.qHO = new CopyOnWriteArrayList();
        this.handler = af.bCo();
        cmH();
        AppMethodBeat.o(36107);
    }

    private void cmH() {
        AppMethodBeat.i(36108);
        synchronized (this.eHH) {
            try {
                this.eow.clear();
                this.qHM.clear();
                this.qHL.clear();
                this.qHG.clear();
                this.qHH.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36108);
            }
        }
    }

    private boolean cmI() {
        AppMethodBeat.i(36109);
        synchronized (this.eHH) {
            try {
                if (this.qHG == null || this.qHG.size() <= 0) {
                    AppMethodBeat.o(36109);
                    return false;
                }
                g gVar = (g) this.qHG.remove();
                new as().u(gVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36109);
            }
        }
        return true;
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(36110);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36099);
                f fVar = b.this;
                fVar.epg.add(bVar);
                int i = b.qHB + 1;
                b.qHB = i;
                if (i <= 1) {
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(208, fVar);
                }
                AppMethodBeat.o(36099);
            }
        });
        AppMethodBeat.o(36110);
    }

    public final void b(final b bVar) {
        AppMethodBeat.i(36111);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36100);
                f fVar = b.this;
                fVar.epg.remove(bVar);
                int i = b.qHB - 1;
                b.qHB = i;
                if (i <= 0) {
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.b(208, fVar);
                }
                AppMethodBeat.o(36100);
            }
        });
        AppMethodBeat.o(36111);
    }

    private boolean a(bau bau, int i, e eVar, az azVar, String str, String str2) {
        AppMethodBeat.i(36112);
        if (!i.Xn(af.getAccPath())) {
            ab.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", af.getAccPath(), com.tencent.mm.compatible.util.e.eSl);
            AppMethodBeat.o(36112);
            return false;
        } else if (bau.Id.startsWith("Locall_path") || bau.Id.startsWith("pre_temp_sns_pic")) {
            ab.d("MicroMsg.DownloadManager", "is a local img not need download");
            AppMethodBeat.o(36112);
            return false;
        } else {
            String bd = i.bd(i, bau.Id);
            synchronized (this.eHH) {
                try {
                    if (this.qHM.containsKey(bd)) {
                        Iterator it = this.eow.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) it.next();
                            if (fVar.cNr != null && fVar.cNr.Id.equals(bau.Id) && fVar.requestType == i) {
                                if (this.eow.remove(fVar)) {
                                    this.eow.addLast(fVar);
                                }
                                ab.v("MicroMsg.DownloadManager", "update the donwload list ");
                            }
                        }
                    } else {
                        ab.i("MicroMsg.DownloadManager", "add list %s", bau.Id);
                        this.qHM.put(bd, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                        this.eow.add(new com.tencent.mm.plugin.sns.data.f(bau, i, bd, azVar, str, str2));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(36112);
                }
            }
            ab.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", Integer.valueOf(af.cnE().cni()), Integer.valueOf(this.qHL.size()));
            ab.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", Integer.valueOf(this.qHM.size()), Integer.valueOf(this.qHM.size()), Integer.valueOf(this.qHG.size()));
            if (Looper.myLooper() != null) {
                Looper.myQueue().addIdleHandler(new d());
            } else {
                ab.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
            }
            cmJ();
            cmK();
            if (this.eow.size() > 0) {
                agK();
            }
            AppMethodBeat.o(36112);
            return true;
        }
    }

    public final boolean a(bau bau, int i, e eVar, az azVar) {
        AppMethodBeat.i(36113);
        if (bau == null) {
            ab.e("MicroMsg.DownloadManager", "unknow case media is null " + bo.dpG().toString());
            AppMethodBeat.o(36113);
            return false;
        }
        synchronized (this.eHH) {
            try {
                av.Yi(bau.Id);
                a(bau, i, eVar, azVar, null, null);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36113);
            }
        }
        return true;
    }

    public final boolean a(bau bau, e eVar, az azVar, String str, String str2) {
        AppMethodBeat.i(36114);
        if (bau == null) {
            ab.e("MicroMsg.DownloadManager", "unknow case media is null " + bo.dpG().toString());
            AppMethodBeat.o(36114);
            return false;
        }
        synchronized (this.eHH) {
            try {
                av.Yi(bau.Id);
                a(bau, 8, eVar, azVar, str, str2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36114);
            }
        }
        return true;
    }

    public static void XC(String str) {
        AppMethodBeat.i(36115);
        o.alm().m(str, null);
        AppMethodBeat.o(36115);
    }

    /* Access modifiers changed, original: final */
    public final void cmJ() {
        AppMethodBeat.i(36116);
        if (Iv()) {
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36102);
                    b.a(b.this);
                    AppMethodBeat.o(36102);
                }
            }, 500);
        }
        AppMethodBeat.o(36116);
    }

    /* Access modifiers changed, original: final */
    public final void cmK() {
        AppMethodBeat.i(36117);
        LinkedList<String> linkedList = new LinkedList();
        synchronized (this.eHH) {
            try {
                for (Entry key : this.qHL.entrySet()) {
                    linkedList.add(key.getKey());
                }
                for (String str : linkedList) {
                    if (this.qHL.containsKey(str) && bo.fp(((Long) this.qHL.get(str)).longValue()) * 1000 > 300000) {
                        ab.d("MicroMsg.DownloadManager", "too long to download");
                        this.qHL.remove(str);
                        this.qHM.remove(str);
                    }
                }
            } finally {
                AppMethodBeat.o(36117);
            }
        }
    }

    private boolean Iv() {
        AppMethodBeat.i(36118);
        if (bo.fp(this.qHD) * 1000 > 300000) {
            AppMethodBeat.o(36118);
            return true;
        }
        AppMethodBeat.o(36118);
        return false;
    }

    public final boolean XD(String str) {
        AppMethodBeat.i(36119);
        synchronized (this.eHH) {
            try {
                if (this.qHL.containsKey(i.bd(1, str))) {
                } else if (this.qHL.containsKey(i.bd(5, str))) {
                    AppMethodBeat.o(36119);
                    return true;
                } else {
                    AppMethodBeat.o(36119);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36119);
            }
        }
        return true;
    }

    public final boolean XE(String str) {
        AppMethodBeat.i(36120);
        synchronized (this.eHH) {
            try {
                if (!this.qHL.containsKey(i.bd(2, str)) && !this.qHL.containsKey(i.bd(8, str))) {
                    AppMethodBeat.o(36120);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36120);
            }
        }
        return true;
    }

    public final void p(String str, int i, boolean z) {
        AppMethodBeat.i(36121);
        synchronized (this.eHH) {
            try {
                ab.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", Long.valueOf(Thread.currentThread().getId()), str, Boolean.valueOf(z));
                com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.qHM.get(str);
                if (cVar != null) {
                    e eVar;
                    if (9 == cVar.requestType) {
                        eVar = (e) cVar.qFK.get(i);
                        if (eVar != null) {
                            af.cnC().a(eVar, str);
                        }
                    } else {
                        eVar = cVar.qFJ;
                        if (eVar != null) {
                            af.cnC().a(eVar, str);
                        }
                    }
                }
                if (z) {
                    this.qHM.remove(str);
                }
            } finally {
                AppMethodBeat.o(36121);
            }
        }
    }

    private static boolean XF(String str) {
        AppMethodBeat.i(36122);
        if (str == null || str.equals("")) {
            ab.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(str)));
            AppMethodBeat.o(36122);
            return false;
        }
        AppMethodBeat.o(36122);
        return true;
    }

    /* JADX WARNING: Missing block: B:77:0x01d7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(36123);
     */
    /* JADX WARNING: Missing block: B:167:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void agK() {
        AppMethodBeat.i(36123);
        if (!this.qHJ) {
            AppMethodBeat.o(36123);
        } else if (af.cnn()) {
            cmH();
            AppMethodBeat.o(36123);
        } else if (i.Xn(af.getAccPath())) {
            int i = this.qHF;
            if (ae.gie > 0) {
                i = ae.gie;
            }
            synchronized (this.eHH) {
                try {
                    if (this.eow.size() > 0 && af.cnE().cni() + this.qHL.size() <= i) {
                        ab.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", Integer.valueOf(af.cnE().cni()), Integer.valueOf(this.qHL.size()), Integer.valueOf(this.eow.size()), Integer.valueOf(this.qHF));
                        com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) this.eow.removeLast();
                        if (fVar == null) {
                        } else {
                            bau bau = fVar.cNr;
                            int i2 = fVar.requestType;
                            String str = fVar.key;
                            String str2 = fVar.qFR;
                            String str3 = fVar.qFS;
                            String str4 = fVar.cFc;
                            SparseArray sparseArray = fVar.qFU;
                            if (!this.qHM.containsKey(str) || this.qHM.get(str) == null) {
                                this.qHM.remove(str);
                                AppMethodBeat.o(36123);
                                return;
                            }
                            boolean z;
                            String str5;
                            int i3;
                            e eVar = ((com.tencent.mm.plugin.sns.data.c) this.qHM.get(str)).qFJ;
                            SparseArray sparseArray2 = ((com.tencent.mm.plugin.sns.data.c) this.qHM.get(str)).qFK;
                            if (i2 == 1 && bau.qFG) {
                                i2 = 8;
                            }
                            if (i2 == 1 || i2 == 5 || i2 == 7) {
                                z = true;
                                str5 = bau.wEH;
                                if (i2 == 7 && !bo.isNullOrNil(bau.wER)) {
                                    str5 = bau.wER;
                                }
                                i3 = bau.wEI;
                                if (bo.isNullOrNil(str5) && bau.jCt == 2) {
                                    str5 = bau.Url;
                                    i3 = bau.wEG;
                                }
                            } else if (i2 == 6) {
                                z = false;
                                str5 = bau.wEO;
                                i3 = bau.wEG;
                            } else if (i2 == 9) {
                                bau bau2 = (bau) sparseArray.valueAt(0);
                                z = true;
                                String str6 = bau2.wEH;
                                int i4 = bau2.wEI;
                                if (bo.isNullOrNil(str6) && bau2.jCt == 2) {
                                    str5 = bau2.Url;
                                    i3 = bau2.wEG;
                                    str6 = str5;
                                } else {
                                    i3 = i4;
                                }
                                str5 = str6;
                            } else {
                                z = false;
                                str5 = bau.Url;
                                i3 = bau.wEG;
                            }
                            if (!XF(str5)) {
                                this.qHM.remove(str);
                                AppMethodBeat.o(36123);
                            } else if (i3 == 2) {
                                if (!af.cnE().isDownloading(str)) {
                                    ab.d("MicroMsg.DownloadManager", "to downLoad scene " + bau.Id + "  " + str5);
                                    com.tencent.mm.kernel.g.RQ();
                                    com.tencent.mm.kernel.g.RO().eJo.a(new p(bau, bau.Id, str5, bau.jCt, z, i2, str), 0);
                                    af.cnE().XU(str);
                                }
                            } else if (i3 == 1 || i3 == 0) {
                                if (i3 == 0) {
                                    ab.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str5 + " isThumb :" + z);
                                }
                                if (!this.qHL.containsKey(str)) {
                                    com.tencent.mm.plugin.sns.model.a.a aVar;
                                    if (i2 == 9) {
                                        ab.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", str4);
                                    } else {
                                        ab.i("MicroMsg.DownloadManager", "to downLoad cdn " + bau.Id + "  " + str5);
                                    }
                                    if ((bau != null || (sparseArray != null && sparseArray.size() > 0)) && i2 != 6 && i2 != 8 && this.qHH.containsKey(str)) {
                                        long longValue = ((Long) this.qHH.get(str)).longValue();
                                        if (System.currentTimeMillis() - longValue < 300000) {
                                            this.qHM.remove(str);
                                            ab.i("MicroMsg.DownloadManager", "no need download. lastTime: " + longValue + " url: " + str5 + " id: " + (bau == null ? str4 : bau.Id));
                                            AppMethodBeat.o(36123);
                                            return;
                                        }
                                    }
                                    this.qHL.put(str, Long.valueOf(bo.anT()));
                                    if (i2 == 2 || i2 == 8) {
                                        com.tencent.mm.kernel.g.RQ();
                                        i3 = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68391, null), 0);
                                        com.tencent.mm.kernel.g.RQ();
                                        com.tencent.mm.kernel.g.RP().Ry().set(68391, Integer.valueOf(i3 + 1));
                                    }
                                    if (i2 == 9) {
                                        aVar = new com.tencent.mm.plugin.sns.model.a.a(str4, sparseArray, sparseArray2, fVar.size);
                                    } else {
                                        aVar = new com.tencent.mm.plugin.sns.model.a.a(bau.Id);
                                        aVar.qJh = bau;
                                        aVar.qFJ = eVar;
                                    }
                                    aVar.qNW = fVar.qFT;
                                    if (i2 == 4) {
                                        aVar.qNU = true;
                                    } else {
                                        aVar.qNU = false;
                                    }
                                    aVar.qNT = z;
                                    aVar.qNV = i2;
                                    aVar.qJg = str;
                                    aVar.url = str5;
                                    aVar.gf(str2, str3);
                                    com.tencent.mm.plugin.sns.model.a.c cVar = null;
                                    if (i2 == 1 || i2 == 5 || i2 == 7 || i2 == 9) {
                                        ab.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
                                        cVar = new com.tencent.mm.plugin.sns.model.a.i(this, aVar);
                                    } else if (i2 == 4) {
                                        ab.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                                        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100438");
                                        boolean z2 = false;
                                        if (ll.isValid()) {
                                            z2 = bo.getInt((String) ll.dru().get("CDNDownload"), 0) != 0;
                                        }
                                        ab.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", Boolean.valueOf(bau.qFG), Boolean.valueOf(z2));
                                        if (!bau.qFG || z2) {
                                            cVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                                        } else {
                                            cVar = new h(this, aVar);
                                        }
                                    } else if (i2 == 2 || i2 == 8 || i2 == 3) {
                                        cVar = new com.tencent.mm.plugin.sns.model.a.e(this, aVar);
                                    } else if (i2 == 6) {
                                        aVar.url = bau.wEO;
                                        aVar.cvZ = bau.wEQ;
                                        cVar = new com.tencent.mm.plugin.sns.model.a.d(this, aVar);
                                    }
                                    cVar.u("");
                                }
                            } else {
                                this.qHM.remove(str);
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(36123);
                }
            }
        } else {
            AppMethodBeat.o(36123);
        }
    }

    public final void a(int i, bau bau, int i2, boolean z, String str, int i3, int i4, boolean z2) {
        AppMethodBeat.i(36124);
        String str2 = "MicroMsg.DownloadManager";
        String str3 = "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bau == null ? Integer.valueOf(-1) : bau.Id;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = str;
        objArr[5] = Integer.valueOf(i3);
        ab.i(str2, str3, objArr);
        if (!af.cnn()) {
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RN().QY()) {
                if (i != 2) {
                    this.qHE += i3;
                }
                synchronized (this.eHH) {
                    try {
                        if (this.qHE > 512000 && this.eow.size() == 0) {
                            ab.d("MicroMsg.DownloadManager", "netSizeAdd %s", Integer.valueOf(this.qHE));
                            com.tencent.mm.model.ao.a.flv.cm(this.qHE, 0);
                            this.qHE = 0;
                        }
                        if (9 == i2) {
                            if ((i == 1 || i == 3) && z2) {
                                this.qHH.put(str, Long.valueOf(System.currentTimeMillis()));
                            }
                        } else if (i == 1 || i == 3) {
                            this.qHH.put(str, Long.valueOf(System.currentTimeMillis()));
                        }
                    } finally {
                        AppMethodBeat.o(36124);
                    }
                }
                if (!(i == 3 || i != 1 || i2 == 3 || bau == null)) {
                    g cnC = af.cnC();
                    ab.d("MicroMsg.LazyerImageLoader2", "updateCache " + bau.Id);
                    n nVar = (n) cnC.qHV.get(i.bc(1, bau.Id));
                    if (i.b(nVar)) {
                        nVar.Xj();
                        ab.d("MicroMsg.LazyerImageLoader2", "force update");
                        af.cns().execute(new com.tencent.mm.plugin.sns.model.g.AnonymousClass2(bau));
                    }
                }
                for (b bVar : this.epg) {
                    if (bVar != null) {
                        if (i == 2 || bau == null) {
                            if ((i2 == 2 || i2 == 8) && bau != null) {
                                bVar.bj(bau.Id, false);
                            } else if ((i2 == 4 || i2 == 6) && bau != null) {
                                bVar.bk(bau.Id, false);
                            }
                        } else if (i2 == 3) {
                            bVar.cmu();
                        } else if (i2 == 1 || i2 == 9 || i2 == 5 || i2 == 7) {
                            bVar.Xw(bau.Id);
                        } else if (i2 == 2 || i2 == 8) {
                            bVar.bj(bau.Id, true);
                        } else if (i2 == 4 || i2 == 6) {
                            bVar.bk(bau.Id, true);
                        }
                    }
                }
                synchronized (this.eHH) {
                    try {
                        ab.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, batchDownloaded %s.", str, Boolean.valueOf(z2));
                        if (z2) {
                            this.qHL.remove(str);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(36124);
                        }
                    }
                }
                agK();
                p(str, i4, z2);
                synchronized (this.eHH) {
                    if (bau != null) {
                        try {
                            c XH = XH(bau.Id);
                            if (XH != null && XH.eTM && XH.eTM) {
                                ab.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", XH.cFc, Long.valueOf(XH.startTime), Long.valueOf(bo.gb(XH.startTime)), XH);
                                com.tencent.mm.plugin.report.service.h.pYm.k(1040, 0, r10);
                                com.tencent.mm.plugin.report.service.h.pYm.k(1040, 1, 1);
                            }
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(36124);
                            }
                        }
                    }
                }
                return;
            }
        }
        cmH();
        AppMethodBeat.o(36124);
    }

    public final void XG(final String str) {
        AppMethodBeat.i(36125);
        af.bCo().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36103);
                b.a(b.this, str);
                b.this.p(str, -1, true);
                AppMethodBeat.o(36103);
            }
        });
        AppMethodBeat.o(36125);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(36126);
        ab.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType() + " @" + hashCode());
        if (mVar.getType() != 208) {
            AppMethodBeat.o(36126);
            return;
        }
        p pVar = (p) mVar;
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 208) {
                for (b bVar : this.epg) {
                    if (bVar != null) {
                        if (pVar.qJe == 3) {
                            bVar.cmu();
                        } else if (pVar.qJe == 1 || pVar.qJe == 5 || pVar.qJe == 7) {
                            bVar.Xw(pVar.cHr);
                        } else if (pVar.qJe == 2 || pVar.qJe == 8) {
                            bVar.bj(pVar.cHr, true);
                        }
                    }
                }
            }
            AppMethodBeat.o(36126);
            return;
        }
        if (pVar.qJe == 2 || pVar.qJe == 8) {
            for (b bVar2 : this.epg) {
                if (bVar2 != null) {
                    bVar2.bj(pVar.cHr, false);
                }
            }
        }
        AppMethodBeat.o(36126);
    }

    public final void a(String str, c cVar) {
        AppMethodBeat.i(36127);
        if (!(bo.isNullOrNil(str) || cVar == null)) {
            c cVar2 = (c) this.qHN.get(str);
            if (cVar2 == null || !cVar2.cFc.equals(cVar.cFc)) {
                this.qHN.put(str, cVar);
            }
        }
        AppMethodBeat.o(36127);
    }

    public final c XH(String str) {
        AppMethodBeat.i(36128);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36128);
            return null;
        }
        c cVar = (c) this.qHN.remove(str);
        if (cVar != null) {
            cVar.cmL();
        }
        AppMethodBeat.o(36128);
        return cVar;
    }

    public final void XI(String str) {
        AppMethodBeat.i(36129);
        this.qHO.add(str);
        AppMethodBeat.o(36129);
    }
}
