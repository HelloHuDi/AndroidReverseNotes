package com.tencent.p177mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C13358c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.data.C43539f;
import com.tencent.p177mm.plugin.sns.data.C43540g;
import com.tencent.p177mm.plugin.sns.model.C21925g.C219212;
import com.tencent.p177mm.plugin.sns.model.p519a.C16865e;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.plugin.sns.model.p519a.C3881d;
import com.tencent.p177mm.plugin.sns.model.p519a.C3882g;
import com.tencent.p177mm.plugin.sns.model.p519a.C39746i;
import com.tencent.p177mm.plugin.sns.model.p519a.C46216a;
import com.tencent.p177mm.plugin.sns.model.p519a.C46217h;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5141c;
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

/* renamed from: com.tencent.mm.plugin.sns.model.b */
public final class C43558b implements C1202f, C34949a {
    static int qHB = 0;
    private static final int qHC = (VERSION.SDK_INT >= 14 ? 100 : 25);
    public final byte[] eHH;
    LinkedList<C43539f> eow;
    Set<C43559b> epg;
    private C7306ak handler;
    private long qHD;
    private int qHE;
    private int qHF;
    private LinkedList<C43540g> qHG;
    public HashMap<String, Long> qHH;
    HashMap<String, String> qHI;
    public boolean qHJ;
    public Set<C13424a> qHK;
    private Map<String, Long> qHL;
    Map<String, C13358c> qHM;
    public ConcurrentHashMap<String, C39758c> qHN;
    public CopyOnWriteArrayList<String> qHO;

    /* renamed from: com.tencent.mm.plugin.sns.model.b$a */
    public interface C13424a {
        /* renamed from: fW */
        void mo17712fW(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$3 */
    public class C219173 implements Runnable {
        /* renamed from: IN */
        final /* synthetic */ String f4394IN;
        final /* synthetic */ String bSt;

        public C219173(String str, String str2) {
            this.f4394IN = str;
            this.bSt = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(36101);
            if (C43558b.this.qHK != null) {
                for (C13424a c13424a : C43558b.this.qHK) {
                    if (c13424a != null) {
                        c13424a.mo17712fW(this.f4394IN, this.bSt);
                    }
                }
            }
            AppMethodBeat.m2505o(36101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$4 */
    class C290564 implements Runnable {
        C290564() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36102);
            C43558b.m77894a(C43558b.this);
            AppMethodBeat.m2505o(36102);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$c */
    public static class C39758c {
        final String cFc;
        private final byte[] eMl = new byte[0];
        boolean eTM;
        private int fjN;
        public boolean qHS;
        long startTime;

        public C39758c(String str, int i) {
            AppMethodBeat.m2504i(36104);
            this.cFc = str;
            this.fjN = i;
            this.startTime = -1;
            this.qHS = false;
            this.eTM = false;
            C4990ab.m7411d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", str, Integer.valueOf(i), this);
            AppMethodBeat.m2505o(36104);
        }

        public final void setStartTime(long j) {
            AppMethodBeat.m2504i(138245);
            if (this.qHS) {
                AppMethodBeat.m2505o(138245);
                return;
            }
            synchronized (this.eMl) {
                try {
                    if (!this.qHS) {
                        this.qHS = true;
                        this.startTime = j;
                        C4990ab.m7411d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", this.cFc, Long.valueOf(this.startTime), this);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(138245);
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

    /* renamed from: com.tencent.mm.plugin.sns.model.b$b */
    public interface C43559b {
        /* renamed from: Xw */
        void mo17655Xw(String str);

        /* renamed from: bj */
        void mo8771bj(String str, boolean z);

        /* renamed from: bk */
        void mo8772bk(String str, boolean z);

        void cmu();
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$d */
    class C43560d implements IdleHandler {
        C43560d() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(36105);
            C4990ab.m7410d("MicroMsg.DownloadManager", "I run idleHandler ");
            C43558b.this.qHD = C5046bo.anT();
            boolean a = C43558b.m77894a(C43558b.this);
            AppMethodBeat.m2505o(36105);
            return a;
        }
    }

    /* renamed from: aa */
    public final void mo69140aa(int i, boolean z) {
        AppMethodBeat.m2504i(36106);
        this.qHF = i;
        try {
            String value;
            String str;
            if (C5023at.isWifi(C4996ah.getContext())) {
                value = C26373g.m41964Nu().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = C26373g.m41964Nu().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (C5046bo.isNullOrNil(value) && C4872b.dnO()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!C5046bo.isNullOrNil(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = (C5046bo.ank(split[1]) + (C5046bo.ank(split[0]) * 60)) - ((((int) C29036i.afB()) - 8) * 60);
                if (ank < 0) {
                    i2 = ank + 1440;
                } else if (ank >= 1440) {
                    i2 = ank - 1440;
                } else {
                    i2 = ank;
                }
                String[] split2 = str.split(";");
                for (int i3 = 0; i3 < split2.length; i3++) {
                    if (!C5046bo.isNullOrNil(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            C4990ab.m7413e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", Integer.valueOf(i3), str);
                        } else {
                            String[] split3 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            int ank2 = C5046bo.ank(split3[1]) + (C5046bo.ank(split3[0]) * 60);
                            String[] split4 = split[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            C4990ab.m7417i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", Integer.valueOf(i3), Integer.valueOf(ank2), Integer.valueOf(C5046bo.ank(split4[1]) + (C5046bo.ank(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]);
                            if (i2 <= C5046bo.ank(split4[1]) + (C5046bo.ank(split4[0]) * 60) && i2 > ank2) {
                                ank = C5046bo.ank(z ? split[2] : split[3]);
                                if (ank > 0) {
                                    this.qHF = ank;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.DownloadManager", "setMaxThread :%s", C5046bo.m7574l(e));
        }
        C4990ab.m7417i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", Integer.valueOf(this.qHF));
        AppMethodBeat.m2505o(36106);
    }

    public C43558b() {
        AppMethodBeat.m2504i(36107);
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
        this.handler = C13373af.bCo();
        cmH();
        AppMethodBeat.m2505o(36107);
    }

    private void cmH() {
        AppMethodBeat.m2504i(36108);
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
                AppMethodBeat.m2505o(36108);
            }
        }
    }

    private boolean cmI() {
        AppMethodBeat.m2504i(36109);
        synchronized (this.eHH) {
            try {
                if (this.qHG == null || this.qHG.size() <= 0) {
                    AppMethodBeat.m2505o(36109);
                    return false;
                }
                C43540g c43540g = (C43540g) this.qHG.remove();
                new C46221as().mo38881u(c43540g);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36109);
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo69136a(final C43559b c43559b) {
        AppMethodBeat.m2504i(36110);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36099);
                C1202f c1202f = C43558b.this;
                c1202f.epg.add(c43559b);
                int i = C43558b.qHB + 1;
                C43558b.qHB = i;
                if (i <= 1) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14539a(208, c1202f);
                }
                AppMethodBeat.m2505o(36099);
            }
        });
        AppMethodBeat.m2505o(36110);
    }

    /* renamed from: b */
    public final void mo69142b(final C43559b c43559b) {
        AppMethodBeat.m2504i(36111);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36100);
                C1202f c1202f = C43558b.this;
                c1202f.epg.remove(c43559b);
                int i = C43558b.qHB - 1;
                C43558b.qHB = i;
                if (i <= 0) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14546b(208, c1202f);
                }
                AppMethodBeat.m2505o(36100);
            }
        });
        AppMethodBeat.m2505o(36111);
    }

    /* renamed from: a */
    private boolean m77895a(bau bau, int i, C39731e c39731e, C44222az c44222az, String str, String str2) {
        AppMethodBeat.m2504i(36112);
        if (!C29036i.m46091Xn(C13373af.getAccPath())) {
            C4990ab.m7417i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", C13373af.getAccPath(), C6457e.eSl);
            AppMethodBeat.m2505o(36112);
            return false;
        } else if (bau.f17915Id.startsWith("Locall_path") || bau.f17915Id.startsWith("pre_temp_sns_pic")) {
            C4990ab.m7410d("MicroMsg.DownloadManager", "is a local img not need download");
            AppMethodBeat.m2505o(36112);
            return false;
        } else {
            String bd = C29036i.m46103bd(i, bau.f17915Id);
            synchronized (this.eHH) {
                try {
                    if (this.qHM.containsKey(bd)) {
                        Iterator it = this.eow.iterator();
                        while (it.hasNext()) {
                            C43539f c43539f = (C43539f) it.next();
                            if (c43539f.cNr != null && c43539f.cNr.f17915Id.equals(bau.f17915Id) && c43539f.requestType == i) {
                                if (this.eow.remove(c43539f)) {
                                    this.eow.addLast(c43539f);
                                }
                                C4990ab.m7418v("MicroMsg.DownloadManager", "update the donwload list ");
                            }
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.DownloadManager", "add list %s", bau.f17915Id);
                        this.qHM.put(bd, new C13358c(c39731e, i));
                        this.eow.add(new C43539f(bau, i, bd, c44222az, str, str2));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(36112);
                }
            }
            C4990ab.m7411d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", Integer.valueOf(C13373af.cnE().cni()), Integer.valueOf(this.qHL.size()));
            C4990ab.m7419v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", Integer.valueOf(this.qHM.size()), Integer.valueOf(this.qHM.size()), Integer.valueOf(this.qHG.size()));
            if (Looper.myLooper() != null) {
                Looper.myQueue().addIdleHandler(new C43560d());
            } else {
                C4990ab.m7420w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
            }
            cmJ();
            cmK();
            if (this.eow.size() > 0) {
                agK();
            }
            AppMethodBeat.m2505o(36112);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo69138a(bau bau, int i, C39731e c39731e, C44222az c44222az) {
        AppMethodBeat.m2504i(36113);
        if (bau == null) {
            C4990ab.m7412e("MicroMsg.DownloadManager", "unknow case media is null " + C5046bo.dpG().toString());
            AppMethodBeat.m2505o(36113);
            return false;
        }
        synchronized (this.eHH) {
            try {
                C13417av.m21558Yi(bau.f17915Id);
                m77895a(bau, i, c39731e, c44222az, null, null);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36113);
            }
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo69139a(bau bau, C39731e c39731e, C44222az c44222az, String str, String str2) {
        AppMethodBeat.m2504i(36114);
        if (bau == null) {
            C4990ab.m7412e("MicroMsg.DownloadManager", "unknow case media is null " + C5046bo.dpG().toString());
            AppMethodBeat.m2505o(36114);
            return false;
        }
        synchronized (this.eHH) {
            try {
                C13417av.m21558Yi(bau.f17915Id);
                m77895a(bau, 8, c39731e, c44222az, str, str2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36114);
            }
        }
        return true;
    }

    /* renamed from: XC */
    public static void m77890XC(String str) {
        AppMethodBeat.m2504i(36115);
        C37961o.alm().mo73064m(str, null);
        AppMethodBeat.m2505o(36115);
    }

    /* Access modifiers changed, original: final */
    public final void cmJ() {
        AppMethodBeat.m2504i(36116);
        if (m77889Iv()) {
            this.handler.postDelayed(new C290564(), 500);
        }
        AppMethodBeat.m2505o(36116);
    }

    /* Access modifiers changed, original: final */
    public final void cmK() {
        AppMethodBeat.m2504i(36117);
        LinkedList<String> linkedList = new LinkedList();
        synchronized (this.eHH) {
            try {
                for (Entry key : this.qHL.entrySet()) {
                    linkedList.add(key.getKey());
                }
                for (String str : linkedList) {
                    if (this.qHL.containsKey(str) && C5046bo.m7549fp(((Long) this.qHL.get(str)).longValue()) * 1000 > 300000) {
                        C4990ab.m7410d("MicroMsg.DownloadManager", "too long to download");
                        this.qHL.remove(str);
                        this.qHM.remove(str);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(36117);
            }
        }
    }

    /* renamed from: Iv */
    private boolean m77889Iv() {
        AppMethodBeat.m2504i(36118);
        if (C5046bo.m7549fp(this.qHD) * 1000 > 300000) {
            AppMethodBeat.m2505o(36118);
            return true;
        }
        AppMethodBeat.m2505o(36118);
        return false;
    }

    /* renamed from: XD */
    public final boolean mo69131XD(String str) {
        AppMethodBeat.m2504i(36119);
        synchronized (this.eHH) {
            try {
                if (this.qHL.containsKey(C29036i.m46103bd(1, str))) {
                } else if (this.qHL.containsKey(C29036i.m46103bd(5, str))) {
                    AppMethodBeat.m2505o(36119);
                    return true;
                } else {
                    AppMethodBeat.m2505o(36119);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36119);
            }
        }
        return true;
    }

    /* renamed from: XE */
    public final boolean mo69132XE(String str) {
        AppMethodBeat.m2504i(36120);
        synchronized (this.eHH) {
            try {
                if (!this.qHL.containsKey(C29036i.m46103bd(2, str)) && !this.qHL.containsKey(C29036i.m46103bd(8, str))) {
                    AppMethodBeat.m2505o(36120);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36120);
            }
        }
        return true;
    }

    /* renamed from: p */
    public final void mo69145p(String str, int i, boolean z) {
        AppMethodBeat.m2504i(36121);
        synchronized (this.eHH) {
            try {
                C4990ab.m7411d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", Long.valueOf(Thread.currentThread().getId()), str, Boolean.valueOf(z));
                C13358c c13358c = (C13358c) this.qHM.get(str);
                if (c13358c != null) {
                    C39731e c39731e;
                    if (9 == c13358c.requestType) {
                        c39731e = (C39731e) c13358c.qFK.get(i);
                        if (c39731e != null) {
                            C13373af.cnC().mo37447a(c39731e, str);
                        }
                    } else {
                        c39731e = c13358c.qFJ;
                        if (c39731e != null) {
                            C13373af.cnC().mo37447a(c39731e, str);
                        }
                    }
                }
                if (z) {
                    this.qHM.remove(str);
                }
            } finally {
                AppMethodBeat.m2505o(36121);
            }
        }
    }

    /* renamed from: XF */
    private static boolean m77891XF(String str) {
        AppMethodBeat.m2504i(36122);
        if (str == null || str.equals("")) {
            C4990ab.m7410d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(36122);
            return false;
        }
        AppMethodBeat.m2505o(36122);
        return true;
    }

    /* JADX WARNING: Missing block: B:77:0x01d7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(36123);
     */
    /* JADX WARNING: Missing block: B:167:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void agK() {
        AppMethodBeat.m2504i(36123);
        if (!this.qHJ) {
            AppMethodBeat.m2505o(36123);
        } else if (C13373af.cnn()) {
            cmH();
            AppMethodBeat.m2505o(36123);
        } else if (C29036i.m46091Xn(C13373af.getAccPath())) {
            int i = this.qHF;
            if (C1947ae.gie > 0) {
                i = C1947ae.gie;
            }
            synchronized (this.eHH) {
                try {
                    if (this.eow.size() > 0 && C13373af.cnE().cni() + this.qHL.size() <= i) {
                        C4990ab.m7417i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", Integer.valueOf(C13373af.cnE().cni()), Integer.valueOf(this.qHL.size()), Integer.valueOf(this.eow.size()), Integer.valueOf(this.qHF));
                        C43539f c43539f = (C43539f) this.eow.removeLast();
                        if (c43539f == null) {
                        } else {
                            bau bau = c43539f.cNr;
                            int i2 = c43539f.requestType;
                            String str = c43539f.key;
                            String str2 = c43539f.qFR;
                            String str3 = c43539f.qFS;
                            String str4 = c43539f.cFc;
                            SparseArray sparseArray = c43539f.qFU;
                            if (!this.qHM.containsKey(str) || this.qHM.get(str) == null) {
                                this.qHM.remove(str);
                                AppMethodBeat.m2505o(36123);
                                return;
                            }
                            boolean z;
                            String str5;
                            int i3;
                            C39731e c39731e = ((C13358c) this.qHM.get(str)).qFJ;
                            SparseArray sparseArray2 = ((C13358c) this.qHM.get(str)).qFK;
                            if (i2 == 1 && bau.qFG) {
                                i2 = 8;
                            }
                            if (i2 == 1 || i2 == 5 || i2 == 7) {
                                z = true;
                                str5 = bau.wEH;
                                if (i2 == 7 && !C5046bo.isNullOrNil(bau.wER)) {
                                    str5 = bau.wER;
                                }
                                i3 = bau.wEI;
                                if (C5046bo.isNullOrNil(str5) && bau.jCt == 2) {
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
                                if (C5046bo.isNullOrNil(str6) && bau2.jCt == 2) {
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
                            if (!C43558b.m77891XF(str5)) {
                                this.qHM.remove(str);
                                AppMethodBeat.m2505o(36123);
                            } else if (i3 == 2) {
                                if (!C13373af.cnE().isDownloading(str)) {
                                    C4990ab.m7410d("MicroMsg.DownloadManager", "to downLoad scene " + bau.f17915Id + "  " + str5);
                                    C1720g.m3537RQ();
                                    C1720g.m3535RO().eJo.mo14541a(new C29058p(bau, bau.f17915Id, str5, bau.jCt, z, i2, str), 0);
                                    C13373af.cnE().mo37399XU(str);
                                }
                            } else if (i3 == 1 || i3 == 0) {
                                if (i3 == 0) {
                                    C4990ab.m7412e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str5 + " isThumb :" + z);
                                }
                                if (!this.qHL.containsKey(str)) {
                                    C46216a c46216a;
                                    if (i2 == 9) {
                                        C4990ab.m7417i("MicroMsg.DownloadManager", "batch download, snsId: %s.", str4);
                                    } else {
                                        C4990ab.m7416i("MicroMsg.DownloadManager", "to downLoad cdn " + bau.f17915Id + "  " + str5);
                                    }
                                    if ((bau != null || (sparseArray != null && sparseArray.size() > 0)) && i2 != 6 && i2 != 8 && this.qHH.containsKey(str)) {
                                        long longValue = ((Long) this.qHH.get(str)).longValue();
                                        if (System.currentTimeMillis() - longValue < 300000) {
                                            this.qHM.remove(str);
                                            C4990ab.m7416i("MicroMsg.DownloadManager", "no need download. lastTime: " + longValue + " url: " + str5 + " id: " + (bau == null ? str4 : bau.f17915Id));
                                            AppMethodBeat.m2505o(36123);
                                            return;
                                        }
                                    }
                                    this.qHL.put(str, Long.valueOf(C5046bo.anT()));
                                    if (i2 == 2 || i2 == 8) {
                                        C1720g.m3537RQ();
                                        i3 = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68391, null), 0);
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(68391, Integer.valueOf(i3 + 1));
                                    }
                                    if (i2 == 9) {
                                        c46216a = new C46216a(str4, sparseArray, sparseArray2, c43539f.size);
                                    } else {
                                        c46216a = new C46216a(bau.f17915Id);
                                        c46216a.qJh = bau;
                                        c46216a.qFJ = c39731e;
                                    }
                                    c46216a.qNW = c43539f.qFT;
                                    if (i2 == 4) {
                                        c46216a.qNU = true;
                                    } else {
                                        c46216a.qNU = false;
                                    }
                                    c46216a.qNT = z;
                                    c46216a.qNV = i2;
                                    c46216a.qJg = str;
                                    c46216a.url = str5;
                                    c46216a.mo74233gf(str2, str3);
                                    C34950c c34950c = null;
                                    if (i2 == 1 || i2 == 5 || i2 == 7 || i2 == 9) {
                                        C4990ab.m7410d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
                                        c34950c = new C39746i(this, c46216a);
                                    } else if (i2 == 4) {
                                        C4990ab.m7420w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                                        C5141c ll = C18624c.abi().mo17131ll("100438");
                                        boolean z2 = false;
                                        if (ll.isValid()) {
                                            z2 = C5046bo.getInt((String) ll.dru().get("CDNDownload"), 0) != 0;
                                        }
                                        C4990ab.m7417i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", Boolean.valueOf(bau.qFG), Boolean.valueOf(z2));
                                        if (!bau.qFG || z2) {
                                            c34950c = new C3882g(this, c46216a);
                                        } else {
                                            c34950c = new C46217h(this, c46216a);
                                        }
                                    } else if (i2 == 2 || i2 == 8 || i2 == 3) {
                                        c34950c = new C16865e(this, c46216a);
                                    } else if (i2 == 6) {
                                        c46216a.url = bau.wEO;
                                        c46216a.cvZ = bau.wEQ;
                                        c34950c = new C3881d(this, c46216a);
                                    }
                                    c34950c.mo38881u("");
                                }
                            } else {
                                this.qHM.remove(str);
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(36123);
                }
            }
        } else {
            AppMethodBeat.m2505o(36123);
        }
    }

    /* renamed from: a */
    public final void mo55533a(int i, bau bau, int i2, boolean z, String str, int i3, int i4, boolean z2) {
        AppMethodBeat.m2504i(36124);
        String str2 = "MicroMsg.DownloadManager";
        String str3 = "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bau == null ? Integer.valueOf(-1) : bau.f17915Id;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = str;
        objArr[5] = Integer.valueOf(i3);
        C4990ab.m7417i(str2, str3, objArr);
        if (!C13373af.cnn()) {
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                if (i != 2) {
                    this.qHE += i3;
                }
                synchronized (this.eHH) {
                    try {
                        if (this.qHE > 512000 && this.eow.size() == 0) {
                            C4990ab.m7411d("MicroMsg.DownloadManager", "netSizeAdd %s", Integer.valueOf(this.qHE));
                            C26417a.flv.mo44184cm(this.qHE, 0);
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
                        AppMethodBeat.m2505o(36124);
                    }
                }
                if (!(i == 3 || i != 1 || i2 == 3 || bau == null)) {
                    C21925g cnC = C13373af.cnC();
                    C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "updateCache " + bau.f17915Id);
                    C45434n c45434n = (C45434n) cnC.qHV.get(C29036i.m46102bc(1, bau.f17915Id));
                    if (C29036i.m46101b(c45434n)) {
                        c45434n.mo73231Xj();
                        C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "force update");
                        C13373af.cns().execute(new C219212(bau));
                    }
                }
                for (C43559b c43559b : this.epg) {
                    if (c43559b != null) {
                        if (i == 2 || bau == null) {
                            if ((i2 == 2 || i2 == 8) && bau != null) {
                                c43559b.mo8771bj(bau.f17915Id, false);
                            } else if ((i2 == 4 || i2 == 6) && bau != null) {
                                c43559b.mo8772bk(bau.f17915Id, false);
                            }
                        } else if (i2 == 3) {
                            c43559b.cmu();
                        } else if (i2 == 1 || i2 == 9 || i2 == 5 || i2 == 7) {
                            c43559b.mo17655Xw(bau.f17915Id);
                        } else if (i2 == 2 || i2 == 8) {
                            c43559b.mo8771bj(bau.f17915Id, true);
                        } else if (i2 == 4 || i2 == 6) {
                            c43559b.mo8772bk(bau.f17915Id, true);
                        }
                    }
                }
                synchronized (this.eHH) {
                    try {
                        C4990ab.m7411d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, batchDownloaded %s.", str, Boolean.valueOf(z2));
                        if (z2) {
                            this.qHL.remove(str);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(36124);
                        }
                    }
                }
                agK();
                mo69145p(str, i4, z2);
                synchronized (this.eHH) {
                    if (bau != null) {
                        try {
                            C39758c XH = mo69134XH(bau.f17915Id);
                            if (XH != null && XH.eTM && XH.eTM) {
                                C4990ab.m7411d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", XH.cFc, Long.valueOf(XH.startTime), Long.valueOf(C5046bo.m7566gb(XH.startTime)), XH);
                                C7060h.pYm.mo15419k(1040, 0, r10);
                                C7060h.pYm.mo15419k(1040, 1, 1);
                            }
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(36124);
                            }
                        }
                    }
                }
                return;
            }
        }
        cmH();
        AppMethodBeat.m2505o(36124);
    }

    /* renamed from: XG */
    public final void mo69133XG(final String str) {
        AppMethodBeat.m2504i(36125);
        C13373af.bCo().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36103);
                C43558b.m77893a(C43558b.this, str);
                C43558b.this.mo69145p(str, -1, true);
                AppMethodBeat.m2505o(36103);
            }
        });
        AppMethodBeat.m2505o(36125);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(36126);
        C4990ab.m7416i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType() + " @" + hashCode());
        if (c1207m.getType() != 208) {
            AppMethodBeat.m2505o(36126);
            return;
        }
        C29058p c29058p = (C29058p) c1207m;
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 208) {
                for (C43559b c43559b : this.epg) {
                    if (c43559b != null) {
                        if (c29058p.qJe == 3) {
                            c43559b.cmu();
                        } else if (c29058p.qJe == 1 || c29058p.qJe == 5 || c29058p.qJe == 7) {
                            c43559b.mo17655Xw(c29058p.cHr);
                        } else if (c29058p.qJe == 2 || c29058p.qJe == 8) {
                            c43559b.mo8771bj(c29058p.cHr, true);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(36126);
            return;
        }
        if (c29058p.qJe == 2 || c29058p.qJe == 8) {
            for (C43559b c43559b2 : this.epg) {
                if (c43559b2 != null) {
                    c43559b2.mo8771bj(c29058p.cHr, false);
                }
            }
        }
        AppMethodBeat.m2505o(36126);
    }

    /* renamed from: a */
    public final void mo69137a(String str, C39758c c39758c) {
        AppMethodBeat.m2504i(36127);
        if (!(C5046bo.isNullOrNil(str) || c39758c == null)) {
            C39758c c39758c2 = (C39758c) this.qHN.get(str);
            if (c39758c2 == null || !c39758c2.cFc.equals(c39758c.cFc)) {
                this.qHN.put(str, c39758c);
            }
        }
        AppMethodBeat.m2505o(36127);
    }

    /* renamed from: XH */
    public final C39758c mo69134XH(String str) {
        AppMethodBeat.m2504i(36128);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36128);
            return null;
        }
        C39758c c39758c = (C39758c) this.qHN.remove(str);
        if (c39758c != null) {
            c39758c.cmL();
        }
        AppMethodBeat.m2505o(36128);
        return c39758c;
    }

    /* renamed from: XI */
    public final void mo69135XI(String str) {
        AppMethodBeat.m2504i(36129);
        this.qHO.add(str);
        AppMethodBeat.m2505o(36129);
    }
}
