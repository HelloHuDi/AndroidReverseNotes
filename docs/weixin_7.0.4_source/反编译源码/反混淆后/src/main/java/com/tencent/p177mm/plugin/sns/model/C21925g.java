package com.tencent.p177mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.memory.p1205b.C18602a;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.memory.p259a.C26399b.C26398a;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.QDisFadeImageView;
import com.tencent.p177mm.p612ui.widget.QFadeImageView;
import com.tencent.p177mm.p612ui.widget.QImageView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C13358c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.data.C43539f;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C34943a;
import com.tencent.p177mm.plugin.sns.model.C3886al.C3885b;
import com.tencent.p177mm.plugin.sns.model.C3886al.C3888a;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43560d;
import com.tencent.p177mm.plugin.sns.p1024b.C43535f;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C43613x;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbn;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.model.g */
public final class C21925g implements C43535f {
    private static int qIq = 0;
    private Map<Integer, WeakReference<Object>> fEk = new HashMap();
    public boolean qHJ = true;
    private long qHT = 0;
    private long qHU = 0;
    C26399b<C45434n> qHV;
    private C3886al<String, WeakReference<Bitmap>> qHW;
    private Map<String, LinkedList<WeakReference<C21928c>>> qHX = new HashMap();
    private ConcurrentHashMap<Integer, String> qHY = new ConcurrentHashMap();
    private LinkedList<C21935b> qHZ = new LinkedList();
    private boolean qIa = false;
    private HashSet<C21928c> qIb = new HashSet();
    public HashMap<String, Integer> qIc = new HashMap();
    private int qId = 4;
    public C43613x qIe;
    public long qIf = 0;
    public long qIg = 0;
    private int qIh = 0;
    private int qIi = 0;
    private HashMap<Long, Integer> qIj = new HashMap();
    private HashMap<Integer, Boolean> qIk = new HashMap();
    private HashMap<Integer, Boolean> qIl = new HashMap();
    private int qIm = 0;
    private int qIn = 0;
    private HashMap<Long, Integer> qIo = new HashMap();
    protected Set<String> qIp = new HashSet();

    /* renamed from: com.tencent.mm.plugin.sns.model.g$1 */
    class C219201 implements C26398a<C45434n> {
        C219201() {
        }

        /* renamed from: aU */
        public final /* synthetic */ int mo37425aU(Object obj) {
            AppMethodBeat.m2504i(36135);
            C45434n c45434n = (C45434n) obj;
            if (c45434n == null) {
                AppMethodBeat.m2505o(36135);
                return 0;
            }
            int allocationByteCount = c45434n.getAllocationByteCount();
            AppMethodBeat.m2505o(36135);
            return allocationByteCount;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$2 */
    class C219212 implements Runnable {
        final /* synthetic */ bau qIs;

        C219212(bau bau) {
            this.qIs = bau;
        }

        public final void run() {
            AppMethodBeat.m2504i(36136);
            C21925g.m33519a(C21925g.this, 1, this.qIs);
            AppMethodBeat.m2505o(36136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$3 */
    class C219223 implements Runnable {
        final /* synthetic */ int qIt = 0;
        final /* synthetic */ String qIu;
        final /* synthetic */ C45434n qIv;

        C219223(String str, C45434n c45434n) {
            this.qIu = str;
            this.qIv = c45434n;
        }

        public final void run() {
            AppMethodBeat.m2504i(36137);
            C21925g.m33521a(C21925g.this, this.qIt + "-" + this.qIu, this.qIv);
            AppMethodBeat.m2505o(36137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$4 */
    class C219234 implements C1175b<String, C45434n> {
        C219234() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            String str;
            AppMethodBeat.m2504i(36138);
            String str2 = (String) obj;
            C45434n c45434n = (C45434n) obj2;
            C45434n c45434n2 = (C45434n) obj3;
            if (!(c45434n == null || c45434n.isRecycled() || c45434n.equals(c45434n2))) {
                c45434n.mo73231Xj();
            }
            int i = 0;
            if (c45434n2 != null) {
                i = c45434n2.getAllocationByteCount();
            }
            String str3 = "MicroMsg.LazyerImageLoader2";
            StringBuilder append = new StringBuilder(" key: ").append(str2).append(" result:").append(i).append(" ").append(c45434n.bitmap.getRowBytes() * c45434n.bitmap.getHeight()).append(" ").append(c45434n.bitmap.getWidth()).append(" ").append(c45434n.bitmap.getHeight()).append(" oldValue ");
            if (c45434n == null) {
                str = "NULL";
            } else {
                str = c45434n.mo73232Xm();
            }
            append = append.append(str).append(" newValue: ");
            if (c45434n2 == null) {
                str = "NULL";
            } else {
                str = c45434n2.mo73232Xm();
            }
            C4990ab.m7410d(str3, append.append(str).toString());
            AppMethodBeat.m2505o(36138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$5 */
    class C219245 implements C3888a {
        C219245() {
        }

        /* renamed from: cn */
        public final boolean mo8612cn(Object obj) {
            AppMethodBeat.m2504i(36139);
            String str = (String) obj;
            if (C21925g.m33520a(C21925g.this, str)) {
                boolean z;
                C3886al a = C21925g.this.qHW;
                try {
                    Bitmap bitmap;
                    Object obj2 = ((C3885b) a.qMs.get(str)).obj;
                    if (obj2 instanceof Bitmap) {
                        bitmap = (Bitmap) obj2;
                    } else {
                        WeakReference weakReference = (WeakReference) ((C3885b) a.qMs.get(str)).obj;
                        if (weakReference != null) {
                            bitmap = (Bitmap) weakReference.get();
                        } else {
                            bitmap = null;
                        }
                    }
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        C4990ab.m7410d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                        bitmap.recycle();
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsLRUMap", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
                }
                int size = a.qMs.size();
                Object remove = a.qMs.remove(str);
                String str2 = "MicroMsg.SnsLRUMap";
                StringBuilder append = new StringBuilder("internalMap ").append(a.qMs.size()).append(" bfSize :").append(size).append(" o == null ");
                if (remove != null) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7410d(str2, append.append(z).toString());
                C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + C21925g.this.qHW.qMs.size() + " listPaitSize:" + C21925g.this.qIb.size());
                AppMethodBeat.m2505o(36139);
                return true;
            }
            AppMethodBeat.m2505o(36139);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$c */
    static class C21928c {
        public int code;
        /* renamed from: id */
        public String f4395id;
        public int qIJ;
        public boolean qIK;

        public C21928c(String str, int i, int i2, boolean z) {
            this.f4395id = str;
            this.code = i;
            this.qIJ = i2;
            this.qIK = z;
        }

        public final int hashCode() {
            return this.code;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(36156);
            if (obj == null || obj.hashCode() != this.code) {
                AppMethodBeat.m2505o(36156);
                return false;
            }
            AppMethodBeat.m2505o(36156);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$8 */
    class C219328 implements Runnable {
        C219328() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36143);
            if (C21925g.this.qIa) {
                C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
                AppMethodBeat.m2505o(36143);
                return;
            }
            if (C21925g.this.qHZ.size() > 0) {
                C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + C21925g.this.qHZ.size());
                ((C21935b) C21925g.this.qHZ.removeLast()).mo62862u("");
            }
            AppMethodBeat.m2505o(36143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$a */
    public enum C21934a {
        IMG_SCENE_NONE,
        IMG_SCENE_SNSSUSER;

        static {
            AppMethodBeat.m2505o(36149);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$b */
    class C21935b extends C39759h<String, Integer, Boolean> {
        private bau cNr;
        private String fUJ;
        private C45434n feQ = null;
        String key = "";
        private String path;
        private int qII = 0;

        /* renamed from: dv */
        public final /* synthetic */ Object mo25905dv() {
            AppMethodBeat.m2504i(36155);
            Boolean cmY = cmY();
            AppMethodBeat.m2505o(36155);
            return cmY;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(36154);
            super.onPostExecute((Boolean) obj);
            C21925g.cmX();
            C21925g.this.qIp.remove(this.key);
            C21925g.this.mo37456b(this.key, this.feQ);
            C21925g.this.qIa = false;
            C21925g.m33536g(C21925g.this);
            AppMethodBeat.m2505o(36154);
        }

        public C21935b(String str, String str2, String str3, bau bau, int i) {
            AppMethodBeat.m2504i(36150);
            C21925g.this.qIp.add(str);
            this.key = str;
            this.path = str2;
            this.fUJ = str3;
            this.cNr = bau;
            this.qII = i;
            C21925g.bTr();
            C4990ab.m7411d("MicroMsg.ImageLoader", "peddingCount %d ", Integer.valueOf(C21925g.qIq));
            AppMethodBeat.m2505o(36150);
        }

        /* renamed from: ac */
        private void m33584ac(String str, String str2, String str3) {
            AppMethodBeat.m2504i(36151);
            C5730e.m8628ct(this.fUJ + str3);
            if (!C5730e.m8628ct(this.fUJ + str)) {
                if (!C5730e.m8628ct(this.fUJ + str2)) {
                    str2 = C29036i.m46122m(this.cNr);
                }
                if (!C13478s.m21641a(this.fUJ, str2, str, (float) C13373af.cnO())) {
                    C4990ab.m7417i("MicroMsg.ImageLoader", "delete %s", str2);
                    C5730e.deleteFile(this.fUJ + str2);
                }
                C4990ab.m7417i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", this.fUJ + str2, this.fUJ + str, Boolean.valueOf(r0));
            }
            C13478s.m21644b(this.fUJ, str, str3, (float) C13373af.cnN());
            AppMethodBeat.m2505o(36151);
        }

        private Boolean cmY() {
            AppMethodBeat.m2504i(36152);
            C21925g.this.qIa = true;
            Boolean bool;
            if (!C21925g.this.qHJ) {
                C4990ab.m7416i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(36152);
                return bool;
            } else if (C21925g.this.qHV.mo4405aj(this.key)) {
                C4990ab.m7416i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(36152);
                return bool;
            } else {
                C5730e.ate(this.fUJ);
                long currentTimeMillis = System.currentTimeMillis();
                if (C5730e.m8628ct(this.path)) {
                    C4990ab.m7411d("MicroMsg.ImageLoader", "doInBackground file exist:%s", this.path);
                } else {
                    m33584ac(C29036i.m46108e(this.cNr), C29036i.m46121l(this.cNr), C29036i.m46110f(this.cNr));
                }
                long yz = C5046bo.m7588yz();
                if (this.qII == 5) {
                    if (!C5730e.m8628ct(this.path)) {
                        m33584ac(C29036i.m46108e(this.cNr), C29036i.m46121l(this.cNr), C29036i.m46110f(this.cNr));
                    }
                    boolean ct = C5730e.m8628ct(this.fUJ + C29036i.m46108e(this.cNr));
                    boolean ct2 = C5730e.m8628ct(this.fUJ + C29036i.m46121l(this.cNr));
                    boolean ct3 = C5730e.m8628ct(this.fUJ + C29036i.m46110f(this.cNr));
                    this.feQ = C29036i.m46086Xi(this.path);
                    if (this.feQ == null) {
                        C4990ab.m7417i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.feQ = C34943a.m57363fV(this.fUJ + C29036i.m46110f(this.cNr), this.path);
                        C4990ab.m7416i("MicroMsg.ImageLoader", "abc a" + ct + " b" + ct2 + " c" + ct3 + " d" + C5730e.m8628ct(this.path));
                    }
                } else if (this.qII == 4) {
                    this.feQ = C29036i.m46086Xi(this.path);
                    if (this.feQ == null) {
                        C4990ab.m7417i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.feQ = C34943a.m57363fV(this.fUJ + C29036i.m46108e(this.cNr), this.path);
                    }
                } else {
                    this.feQ = C29036i.m46088Xk(this.path);
                }
                long az = C5046bo.m7525az(yz);
                int asZ = (int) C5730e.asZ(this.path);
                if (C5046bo.m7525az(C21925g.this.qHU) > 60000) {
                    C7060h.pYm.mo8381e(11696, Integer.valueOf(4), Long.valueOf(az), Integer.valueOf(asZ), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
                    C21925g.this.qHU = C5046bo.m7588yz();
                }
                if (this.feQ == null) {
                    C4990ab.m7417i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", this.cNr.f17915Id);
                    C5730e.deleteFile(this.fUJ + C29036i.m46110f(this.cNr));
                    C5730e.deleteFile(this.path);
                    C7060h.pYm.mo8378a(150, 2, 1, true);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                C7060h.pYm.mo8378a(150, 0, 1, true);
                C7060h.pYm.mo8378a(150, 1, currentTimeMillis, true);
                C4990ab.m7417i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.feQ == null) + " " + this.feQ + " %d ", this.path, Long.valueOf(System.currentTimeMillis() - yz));
                bool = Boolean.TRUE;
                AppMethodBeat.m2505o(36152);
                return bool;
            }
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(36153);
            C4946a cnq = C13373af.cnq();
            AppMethodBeat.m2505o(36153);
            return cnq;
        }
    }

    static /* synthetic */ int bTr() {
        int i = qIq;
        qIq = i + 1;
        return i;
    }

    static /* synthetic */ int cmX() {
        int i = qIq;
        qIq = i - 1;
        return i;
    }

    /* renamed from: g */
    static /* synthetic */ boolean m33536g(C21925g c21925g) {
        AppMethodBeat.m2504i(36227);
        boolean cmW = c21925g.cmW();
        AppMethodBeat.m2505o(36227);
        return cmW;
    }

    public final void start() {
        AppMethodBeat.m2504i(36157);
        this.qHJ = true;
        cmW();
        C43558b cnA = C13373af.cnA();
        cnA.qHJ = true;
        cnA.agK();
        AppMethodBeat.m2505o(36157);
    }

    public final void pause() {
        AppMethodBeat.m2504i(36158);
        this.qHJ = false;
        C43558b cnA = C13373af.cnA();
        cnA.qHJ = false;
        synchronized (cnA.eHH) {
            try {
                LinkedList linkedList = new LinkedList();
                Iterator it = cnA.eow.iterator();
                while (it.hasNext()) {
                    C43539f c43539f = (C43539f) it.next();
                    if (c43539f.requestType != 6) {
                        cnA.qHM.remove(c43539f.key);
                        linkedList.add(c43539f);
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    cnA.eow.remove((C43539f) it2.next());
                }
            } finally {
                AppMethodBeat.m2505o(36158);
            }
        }
    }

    public C21925g() {
        int i;
        AppMethodBeat.m2504i(36159);
        C26399b.m42017a(C45434n.class, new C219201());
        C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", Integer.valueOf(((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass()));
        if (((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            i = 62914560;
        } else {
            i = 31457280;
        }
        this.qHV = new C26399b(i, new C219234(), getClass());
        this.qHW = new C3886al(this.qId, new C219245());
        AppMethodBeat.m2505o(36159);
    }

    public final void cmV() {
        AppMethodBeat.m2504i(36160);
        if (this.qHV != null) {
            this.fEk.clear();
            this.qHW.qMs.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.qHV.putCount() + ";");
            stringBuffer.append("missCount:" + this.qHV.missCount() + ";");
            stringBuffer.append("hitCount:" + this.qHV.hitCount() + ";");
            stringBuffer.append("createCount:" + this.qHV.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.qHV.evictionCount() + ";");
            C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.qHV.trimToSize(-1);
        }
        this.qHW.coa();
        System.gc();
        AppMethodBeat.m2505o(36160);
    }

    /* renamed from: a */
    public final Bitmap mo37434a(bau bau, View view, int i, C44222az c44222az, boolean z) {
        AppMethodBeat.m2504i(36161);
        Bitmap a = mo37435a(bau, view, i, true, c44222az, z);
        AppMethodBeat.m2505o(36161);
        return a;
    }

    /* renamed from: ac */
    private boolean m33526ac(View view, int i) {
        AppMethodBeat.m2504i(36162);
        if (view.hashCode() == i) {
            AppMethodBeat.m2505o(36162);
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!m33526ac(viewGroup.getChildAt(childCount), i));
            AppMethodBeat.m2505o(36162);
            return true;
        }
        AppMethodBeat.m2505o(36162);
        return false;
    }

    /* renamed from: ab */
    public final void mo37452ab(Activity activity) {
        C21928c c21928c;
        AppMethodBeat.m2504i(36163);
        C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.fEk.size());
        LinkedList<Integer> linkedList = new LinkedList();
        Iterator it = this.qIb.iterator();
        while (it.hasNext()) {
            c21928c = (C21928c) it.next();
            if (m33526ac(activity.getWindow().getDecorView(), c21928c.code)) {
                linkedList.add(Integer.valueOf(c21928c.code));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.fEk.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.qIb.iterator();
            while (it2.hasNext()) {
                c21928c = (C21928c) it2.next();
                if (c21928c.code == intValue2) {
                    this.qIb.remove(c21928c);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.qIb.iterator();
        while (it.hasNext()) {
            c21928c = (C21928c) it.next();
            if (c21928c.qIJ == activity.hashCode()) {
                linkedList.add(Integer.valueOf(c21928c.code));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.fEk.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.qIb.iterator();
            while (it3.hasNext()) {
                c21928c = (C21928c) it3.next();
                if (c21928c.code == intValue4) {
                    this.qIb.remove(c21928c);
                    break;
                }
            }
        }
        this.qHW.coa();
        C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.fEk.size());
        AppMethodBeat.m2505o(36163);
    }

    /* renamed from: dz */
    public final void mo37462dz(View view) {
        AppMethodBeat.m2504i(36164);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
            AppMethodBeat.m2505o(36164);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
            AppMethodBeat.m2505o(36164);
        } else {
            AppMethodBeat.m2505o(36164);
        }
    }

    /* renamed from: b */
    public final Bitmap mo37454b(bau bau) {
        AppMethodBeat.m2504i(36165);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36165);
            return null;
        }
        String bc = C29036i.m46102bc(1, bau.f17915Id);
        C45434n XK = mo37430XK(bc);
        Bitmap Xh;
        if (C29036i.m46101b(XK)) {
            Xh = XK.mo73229Xh();
            AppMethodBeat.m2505o(36165);
            return Xh;
        }
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        fZ = fZ + C29036i.m46108e(bau);
        if (C5730e.m8628ct(fZ)) {
            if (bau.f17915Id.startsWith("pre_temp_extend_pic")) {
                XK = C45434n.m83680w(C13478s.m21634Zk(fZ));
            } else {
                XK = C29036i.m46088Xk(fZ);
            }
            if (C29036i.m46101b(XK)) {
                m33524a(bc, XK);
                Xh = XK.mo73229Xh();
                AppMethodBeat.m2505o(36165);
                return Xh;
            }
            AppMethodBeat.m2505o(36165);
            return null;
        }
        AppMethodBeat.m2505o(36165);
        return null;
    }

    /* renamed from: a */
    public final String mo37437a(bau bau) {
        AppMethodBeat.m2504i(36166);
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        fZ = fZ + C29036i.m46108e(bau);
        AppMethodBeat.m2505o(36166);
        return fZ;
    }

    /* renamed from: b */
    public final void mo37455b(bau bau, View view, int i, C44222az c44222az) {
        AppMethodBeat.m2504i(36167);
        mo37440a(bau, view, -1, i, c44222az);
        AppMethodBeat.m2505o(36167);
    }

    /* renamed from: a */
    public final void mo37441a(bau bau, View view, int i, C21934a c21934a, C44222az c44222az) {
        AppMethodBeat.m2504i(36168);
        mo37439a(bau, view, -1, i, c21934a, c44222az);
        AppMethodBeat.m2505o(36168);
    }

    /* renamed from: XK */
    public final C45434n mo37430XK(String str) {
        AppMethodBeat.m2504i(36169);
        C45434n c45434n = (C45434n) this.qHV.get(str);
        if (c45434n == null || c45434n.isRecycled()) {
            this.qHV.remove(str);
            AppMethodBeat.m2505o(36169);
            return null;
        }
        AppMethodBeat.m2505o(36169);
        return c45434n;
    }

    /* renamed from: XL */
    private C45434n m33508XL(String str) {
        AppMethodBeat.m2504i(36170);
        C45434n c45434n = (C45434n) this.qHV.get(str);
        if (c45434n == null || c45434n.isRecycled()) {
            this.qHV.remove(str);
            AppMethodBeat.m2505o(36170);
            return null;
        }
        AppMethodBeat.m2505o(36170);
        return c45434n;
    }

    /* renamed from: a */
    public final void mo37440a(bau bau, View view, int i, int i2, C44222az c44222az) {
        AppMethodBeat.m2504i(36171);
        mo37439a(bau, view, i, i2, C21934a.IMG_SCENE_NONE, c44222az);
        AppMethodBeat.m2505o(36171);
    }

    /* renamed from: a */
    public final void mo37443a(String str, SparseArray<bau> sparseArray, SparseArray<View> sparseArray2, int i, C44222az c44222az, int i2) {
        AppMethodBeat.m2504i(139037);
        C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
        if (sparseArray == null || sparseArray.size() <= 0) {
            C4990ab.m7412e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
            AppMethodBeat.m2505o(139037);
        } else if (sparseArray2 == null || sparseArray2.size() <= 0) {
            C4990ab.m7412e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
            AppMethodBeat.m2505o(139037);
        } else {
            int size = sparseArray.size();
            if (-1 == (size == sparseArray2.size() ? size : -1)) {
                C4990ab.m7413e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", Integer.valueOf(size), Integer.valueOf(sparseArray2.size()));
                AppMethodBeat.m2505o(139037);
                return;
            }
            int i3;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            SparseArray sparseArray5 = new SparseArray();
            for (i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                bau bau = (bau) sparseArray.get(keyAt);
                Object obj = (View) sparseArray2.get(keyAt);
                obj.setDrawingCacheEnabled(false);
                String bc = C29036i.m46102bc(0, bau.f17915Id);
                m33515a(obj, bc, -1, i, C21934a.IMG_SCENE_NONE);
                C45434n XK = mo37430XK(bc);
                if (C29036i.m46101b(XK)) {
                    C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
                    C21925g.m33516a(obj, bc, XK);
                } else {
                    C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
                    C21925g.m33533dA(obj);
                    if (this.qIp.contains(bc)) {
                        AppMethodBeat.m2505o(139037);
                        return;
                    }
                    sparseArray3.put(keyAt, bau);
                }
            }
            final SparseArray sparseArray6 = sparseArray3;
            final SparseArray sparseArray7 = sparseArray4;
            final SparseArray sparseArray8 = sparseArray5;
            final String str2 = str;
            final C44222az c44222az2 = c44222az;
            i3 = i2;
            C13373af.cns().execute(new Runnable() {
                public final void run() {
                    bau bau;
                    int i = 0;
                    AppMethodBeat.m2504i(36140);
                    int size = sparseArray6.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray6.keyAt(i2);
                        bau = (bau) sparseArray6.get(keyAt);
                        if (!C21925g.m33519a(C21925g.this, 0, bau)) {
                            C39731e c39731e = new C39731e(bau);
                            c39731e.qFQ = 0;
                            c39731e.nQB = bau.f17915Id;
                            sparseArray7.put(keyAt, c39731e);
                            sparseArray8.put(keyAt, bau);
                        }
                    }
                    if (sparseArray8.size() > 0) {
                        C43558b cnA = C13373af.cnA();
                        String str = str2;
                        SparseArray sparseArray = sparseArray8;
                        SparseArray sparseArray2 = sparseArray7;
                        C44222az c44222az = c44222az2;
                        int i3 = i3;
                        int size2 = sparseArray.size();
                        for (size = 0; size < size2; size++) {
                            C13417av.m21558Yi(((bau) sparseArray.valueAt(size)).f17915Id);
                        }
                        if (C29036i.m46091Xn(C13373af.getAccPath())) {
                            SparseArray sparseArray3 = new SparseArray();
                            while (i < size2) {
                                int keyAt2 = sparseArray.keyAt(i);
                                bau = (bau) sparseArray.get(keyAt2);
                                if (bau.f17915Id.startsWith("Locall_path") || bau.f17915Id.startsWith("pre_temp_sns_pic")) {
                                    sparseArray2.remove(keyAt2);
                                } else {
                                    sparseArray3.put(keyAt2, bau);
                                }
                                i++;
                            }
                            if (sparseArray3.size() <= 0) {
                                C4990ab.m7416i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
                                AppMethodBeat.m2505o(36140);
                                return;
                            }
                            String Xh = C29036i.m46085Xh(str);
                            synchronized (cnA.eHH) {
                                try {
                                    if (cnA.qHM.containsKey(Xh)) {
                                        Iterator it = cnA.eow.iterator();
                                        while (it.hasNext()) {
                                            C43539f c43539f = (C43539f) it.next();
                                            if (c43539f.key.equals(Xh)) {
                                                if (cnA.eow.remove(c43539f)) {
                                                    cnA.eow.addLast(c43539f);
                                                }
                                                C4990ab.m7416i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
                                            }
                                        }
                                    } else {
                                        C4990ab.m7417i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", str);
                                        cnA.qHM.put(Xh, new C13358c(sparseArray2));
                                        cnA.eow.add(new C43539f(str, sparseArray3, Xh, c44222az, i3));
                                    }
                                } catch (Throwable th) {
                                    AppMethodBeat.m2505o(36140);
                                }
                            }
                            if (Looper.myLooper() != null) {
                                Looper.myQueue().addIdleHandler(new C43560d());
                            } else {
                                C4990ab.m7420w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
                            }
                            cnA.cmJ();
                            cnA.cmK();
                            if (cnA.eow.size() > 0) {
                                C4990ab.m7410d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
                                cnA.agK();
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", C13373af.getAccPath(), C6457e.eSl);
                            AppMethodBeat.m2505o(36140);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(36140);
                }
            });
            AppMethodBeat.m2505o(139037);
        }
    }

    /* renamed from: a */
    public final void mo37439a(bau bau, View view, int i, int i2, C21934a c21934a, C44222az c44222az) {
        AppMethodBeat.m2504i(36173);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36173);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String bc = C29036i.m46102bc(0, bau.f17915Id);
        m33515a((Object) view, bc, i, i2, c21934a);
        C45434n XK = mo37430XK(bc);
        if (C29036i.m46101b(XK)) {
            C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
            C13373af.cnA().mo69134XH(bau.f17915Id);
            C21925g.m33516a((Object) view, bc, XK);
            AppMethodBeat.m2505o(36173);
            return;
        }
        C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
        if (i == -1) {
            C21925g.m33533dA(view);
        }
        if (this.qIp.contains(bc)) {
            AppMethodBeat.m2505o(36173);
            return;
        }
        m33518a(0, bau, c44222az);
        AppMethodBeat.m2505o(36173);
    }

    /* renamed from: b */
    private void m33529b(bau bau, View view, int i, C21934a c21934a, C44222az c44222az) {
        AppMethodBeat.m2504i(36174);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36174);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String bc = C29036i.m46102bc(5, bau.f17915Id);
        m33515a((Object) view, bc, -1, i, c21934a);
        C45434n XK = mo37430XK(bc);
        if (C29036i.m46101b(XK)) {
            C21925g.m33516a((Object) view, bc, XK);
            AppMethodBeat.m2505o(36174);
            return;
        }
        C21925g.m33533dA(view);
        if (this.qIp.contains(bc)) {
            AppMethodBeat.m2505o(36174);
            return;
        }
        m33518a(5, bau, c44222az);
        AppMethodBeat.m2505o(36174);
    }

    /* renamed from: a */
    private static void m33516a(Object obj, String str, C45434n c45434n) {
        long j = 0;
        AppMethodBeat.m2504i(36175);
        if (obj == null) {
            AppMethodBeat.m2505o(36175);
            return;
        }
        if (c45434n != null) {
            C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", obj, str, c45434n.mo73232Xm());
        }
        Drawable drawable;
        if (obj instanceof QFadeImageView) {
            long j2;
            QFadeImageView qFadeImageView = (QFadeImageView) obj;
            drawable = qFadeImageView.getDrawable();
            if (!C5046bo.isNullOrNil(qFadeImageView.getImageKey()) && qFadeImageView.getImageKey().equals(str)) {
                j = qFadeImageView.getStartTimeMillis();
            }
            if (drawable == null || !(drawable instanceof C34954ai)) {
                j2 = j;
            } else {
                j2 = ((C34954ai) drawable).mSd;
            }
            C34954ai c34954ai = new C34954ai(str, c45434n, j2);
            qFadeImageView.mo28267D(c34954ai.mSd, str);
            qFadeImageView.setImageDrawable(c34954ai);
            c34954ai.invalidateSelf();
            AppMethodBeat.m2505o(36175);
        } else if (obj instanceof QDisFadeImageView) {
            QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
            C18602a c18602a = new C18602a(str, c45434n);
            qDisFadeImageView.setImageDrawable(c18602a);
            c18602a.invalidateSelf();
            AppMethodBeat.m2505o(36175);
        } else if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C34954ai)) {
                drawable = new C34954ai(str, c45434n, 0);
            } else {
                drawable = new C34954ai(str, c45434n, ((C34954ai) drawable).mSd);
            }
            imageView.setImageDrawable(drawable);
            drawable.invalidateSelf();
            AppMethodBeat.m2505o(36175);
        } else {
            if (obj instanceof C34915a) {
                C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(str)));
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.getDrawable();
                    if (drawable == null || !(drawable instanceof C34954ai)) {
                        drawable = new C34954ai(str, c45434n, 0);
                    } else {
                        drawable = new C34954ai(str, c45434n, ((C34954ai) drawable).mSd);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
            AppMethodBeat.m2505o(36175);
        }
    }

    /* renamed from: r */
    public static String m33539r(bau bau) {
        AppMethodBeat.m2504i(36176);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36176);
            return null;
        }
        String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau);
        if (C5730e.m8628ct(str)) {
            AppMethodBeat.m2505o(36176);
            return str;
        }
        str = bau.wEH;
        AppMethodBeat.m2505o(36176);
        return str;
    }

    /* renamed from: s */
    public static String m33540s(bau bau) {
        AppMethodBeat.m2504i(36177);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36177);
            return null;
        }
        String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46105d(bau);
        if (C5730e.m8628ct(str)) {
            AppMethodBeat.m2505o(36177);
            return str;
        }
        str = bau.Url;
        AppMethodBeat.m2505o(36177);
        return str;
    }

    /* renamed from: a */
    public final void mo37442a(bau bau, View view, int i, C44222az c44222az) {
        AppMethodBeat.m2504i(36178);
        mo37457b(bau, view, -1, i, c44222az);
        AppMethodBeat.m2505o(36178);
    }

    /* renamed from: a */
    public final boolean mo37446a(C34915a c34915a, int i) {
        AppMethodBeat.m2504i(36179);
        m33514a((Object) c34915a, "", -1, i);
        c34915a.setThumbBmp(null);
        c34915a.mo8509bf(null, false);
        AppMethodBeat.m2505o(36179);
        return true;
    }

    /* renamed from: a */
    public final boolean mo37448a(C46236n c46236n, bau bau, C34915a c34915a, int i, int i2, C44222az c44222az, boolean z) {
        AppMethodBeat.m2504i(36180);
        boolean a = mo37449a(c46236n, bau, c34915a, i, i2, c44222az, z, false);
        AppMethodBeat.m2505o(36180);
        return a;
    }

    /* renamed from: a */
    public final boolean mo37449a(C46236n c46236n, bau bau, C34915a c34915a, int i, int i2, C44222az c44222az, boolean z, boolean z2) {
        AppMethodBeat.m2504i(36181);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36181);
            return false;
        }
        String bc = C29036i.m46102bc(1, bau.f17915Id);
        m33514a((Object) c34915a, bc, -1, i);
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        String e = C29036i.m46108e(bau);
        if (!C5730e.m8628ct(fZ + e)) {
            C39731e c39731e = new C39731e(bau);
            c39731e.qFQ = 1;
            c39731e.nQB = bau.f17915Id;
            C13373af.cnA().mo69138a(bau, bau.jCt == 6 ? 5 : 1, c39731e, c44222az);
        }
        String str = "";
        if (z) {
            str = m33512a(c46236n, bau, c44222az, z);
        }
        C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", bc, str, Boolean.valueOf(z));
        if (C5046bo.isNullOrNil(str) || mo37468u(bau)) {
            C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "sightPath %s", str);
            c34915a.mo8509bf(null, !this.qHJ);
            C45434n XK = mo37430XK(bc);
            C4990ab.m7419v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", Boolean.valueOf(C29036i.m46101b(XK)));
            if (C29036i.m46101b(XK)) {
                C21925g.m33516a((Object) c34915a, bc, XK);
                AppMethodBeat.m2505o(36181);
                return true;
            }
            if ((c34915a instanceof ImageView) || (c34915a instanceof QFadeImageView)) {
                C21925g.m33533dA((View) c34915a);
            } else if (c34915a instanceof C34915a) {
                c34915a.mo8509bf(null, !this.qHJ);
                c34915a.setPosition(0);
                c34915a.setThumbBmp(null);
            }
            if (this.qIp.contains(bc)) {
                AppMethodBeat.m2505o(36181);
                return false;
            }
            m33518a(1, bau, c44222az);
            AppMethodBeat.m2505o(36181);
            return false;
        }
        if (!str.equals(c34915a.getVideoPath())) {
            c34915a.setThumbBmp(z2 ? BitmapFactory.decodeFile(fZ + e) : null);
        }
        c34915a.mo8509bf(str, !this.qHJ);
        c34915a.setPosition(i2);
        AppMethodBeat.m2505o(36181);
        return true;
    }

    /* renamed from: b */
    public final boolean mo37457b(bau bau, View view, int i, int i2, C44222az c44222az) {
        AppMethodBeat.m2504i(36183);
        boolean a = mo37450a(bau, view, i, i2, c44222az, 1);
        AppMethodBeat.m2505o(36183);
        return a;
    }

    /* renamed from: a */
    public final boolean mo37450a(bau bau, View view, int i, int i2, C44222az c44222az, int i3) {
        AppMethodBeat.m2504i(36184);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36184);
            return false;
        }
        String bc = C29036i.m46102bc(i3, bau.f17915Id);
        m33514a((Object) view, bc, i, i2);
        C45434n XK = mo37430XK(bc);
        boolean b = C29036i.m46101b(XK);
        C4990ab.m7418v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b + " " + bc);
        if (b) {
            C21925g.m33516a((Object) view, bc, XK);
            AppMethodBeat.m2505o(36184);
            return true;
        }
        if (i == -1) {
            C21925g.m33533dA(view);
        }
        if (this.qIp.contains(bc)) {
            AppMethodBeat.m2505o(36184);
            return true;
        }
        m33518a(i3, bau, c44222az);
        AppMethodBeat.m2505o(36184);
        return false;
    }

    /* renamed from: dA */
    private static void m33533dA(View view) {
        AppMethodBeat.m2504i(36185);
        if (view instanceof QImageView) {
            ((QImageView) view).setImageResource(C25738R.drawable.b66);
            AppMethodBeat.m2505o(36185);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(C25738R.drawable.b66);
            AppMethodBeat.m2505o(36185);
        } else {
            AppMethodBeat.m2505o(36185);
        }
    }

    /* renamed from: a */
    private void m33513a(View view, String str, int i, C21934a c21934a) {
        AppMethodBeat.m2504i(36186);
        m33517a((Object) view, str, true, -1, i, -1, -1, c21934a);
        AppMethodBeat.m2505o(36186);
    }

    /* renamed from: a */
    private void m33514a(Object obj, String str, int i, int i2) {
        AppMethodBeat.m2504i(36187);
        m33517a(obj, str, true, i, i2, -1, -1, C21934a.IMG_SCENE_NONE);
        AppMethodBeat.m2505o(36187);
    }

    /* renamed from: a */
    private void m33515a(Object obj, String str, int i, int i2, C21934a c21934a) {
        AppMethodBeat.m2504i(36188);
        m33517a(obj, str, true, i, i2, -1, -1, c21934a);
        AppMethodBeat.m2505o(36188);
    }

    /* renamed from: a */
    private void m33517a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, C21934a c21934a) {
        AppMethodBeat.m2504i(36189);
        if (obj == null) {
            AppMethodBeat.m2505o(36189);
            return;
        }
        int hashCode = obj.hashCode();
        this.qIb.remove(new C21928c(null, hashCode, 0, false));
        C21928c c21928c = new C21928c(str, hashCode, i2, z);
        this.qIb.add(c21928c);
        LinkedList linkedList = (LinkedList) this.qHX.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.qHX.put(str, linkedList);
        }
        linkedList.add(new WeakReference(c21928c));
        String str2 = (String) ((View) obj).getTag(2130706432);
        if (str2 != null) {
            LinkedList linkedList2 = (LinkedList) this.qHX.get(str2);
            if (linkedList2 != null) {
                int i5;
                int i6 = 0;
                while (true) {
                    i5 = i6;
                    if (i5 >= linkedList2.size()) {
                        i5 = -1;
                        break;
                    }
                    C21928c c21928c2 = (C21928c) ((WeakReference) linkedList2.get(i5)).get();
                    if (c21928c2 != null && c21928c2.code == hashCode) {
                        break;
                    }
                    i6 = i5 + 1;
                }
                if (i5 != -1) {
                    C4990ab.m7419v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", str2);
                    linkedList2.remove(i5);
                }
            }
        }
        ((View) obj).setTag(2130706432, str);
        this.fEk.put(Integer.valueOf(hashCode), new WeakReference(obj));
        if (i != -1) {
            if (obj instanceof QFadeImageView) {
                ((QFadeImageView) obj).setImageResource(i);
            } else if (obj instanceof ImageView) {
                ((ImageView) obj).setImageDrawable(C1338a.m2864g(((ImageView) obj).getContext(), i));
            } else {
                ((C34915a) obj).mo8509bf(null, !this.qHJ);
            }
        }
        if (c21934a == C21934a.IMG_SCENE_SNSSUSER && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
            C46616n.m88170ci((View) obj);
            AppMethodBeat.m2505o(36189);
            return;
        }
        if (str != null && str.startsWith(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
            C46616n.m88171w((View) obj, i3, i4);
            C4990ab.m7410d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
        }
        AppMethodBeat.m2505o(36189);
    }

    /* renamed from: dB */
    public final boolean mo37461dB(View view) {
        AppMethodBeat.m2504i(36190);
        int hashCode = view.hashCode();
        Iterator it = this.qIb.iterator();
        while (it.hasNext()) {
            C21928c c21928c = (C21928c) it.next();
            if (hashCode == c21928c.code) {
                this.qIb.remove(c21928c);
                break;
            }
        }
        this.fEk.remove(Integer.valueOf(hashCode));
        AppMethodBeat.m2505o(36190);
        return true;
    }

    /* renamed from: a */
    private boolean m33525a(final List<bau> list, final C44222az c44222az) {
        AppMethodBeat.m2504i(36191);
        C13373af.cns().execute(new Runnable() {
            final /* synthetic */ int qIt = 0;

            public final void run() {
                AppMethodBeat.m2504i(36142);
                long yz = C5046bo.m7588yz();
                C39731e c39731e = new C39731e(list);
                c39731e.nQB = C29036i.m46106dc(list);
                c39731e.qFQ = this.qIt;
                int i = 0;
                int i2 = 1;
                while (i < list.size() && i < 4) {
                    bau bau = (bau) list.get(i);
                    if (C13373af.cnA().mo69131XD(bau.f17915Id)) {
                        i2 = 0;
                    } else if (!(C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau)) || C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau)) || C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46122m(bau)))) {
                        C43558b cnA = C13373af.cnA();
                        if (bau.jCt == 6) {
                            i2 = 5;
                        } else {
                            i2 = 1;
                        }
                        cnA.mo69138a(bau, i2, c39731e, c44222az);
                        i2 = 0;
                    }
                    i++;
                }
                long az = C5046bo.m7525az(yz);
                if (az > 100) {
                    C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + az + " " + Thread.currentThread().getName() + " " + C6457e.eSl + " " + C13373af.cnR() + " " + c39731e.nQB);
                }
                if (C5046bo.m7525az(C21925g.this.qHT) > 60000) {
                    C7060h.pYm.mo8381e(11696, Integer.valueOf(1), Long.valueOf(az), Integer.valueOf(0), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
                    C21925g.this.qHT = C5046bo.m7588yz();
                }
                final String dc = C29036i.m46106dc(list);
                if (i2 != 0) {
                    C13373af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(36141);
                            new C46222i(C29036i.m46102bc(0, dc), dc, list).mo62862u("");
                            AppMethodBeat.m2505o(36141);
                        }
                    });
                }
                AppMethodBeat.m2505o(36142);
            }
        });
        AppMethodBeat.m2505o(36191);
        return true;
    }

    private boolean cmW() {
        AppMethodBeat.m2504i(36192);
        if (this.qIa) {
            C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            AppMethodBeat.m2505o(36192);
            return false;
        }
        C13373af.bCo().postDelayed(new C219328(), 0);
        AppMethodBeat.m2505o(36192);
        return true;
    }

    /* renamed from: a */
    private boolean m33518a(final int i, final bau bau, final C44222az c44222az) {
        AppMethodBeat.m2504i(36193);
        if (this.qHJ) {
            C13373af.cns().execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36145);
                    if (!C21925g.m33519a(C21925g.this, i, bau)) {
                        C39731e c39731e = new C39731e(bau);
                        c39731e.qFQ = i;
                        c39731e.nQB = bau.f17915Id;
                        C13373af.cnA().mo69138a(bau, bau.jCt == 6 ? 5 : 1, c39731e, c44222az);
                    }
                    AppMethodBeat.m2505o(36145);
                }
            });
            AppMethodBeat.m2505o(36193);
            return true;
        }
        if (!(bau == null || C5046bo.isNullOrNil(bau.f17915Id))) {
            C13373af.cnA().mo69134XH(bau.f17915Id);
        }
        AppMethodBeat.m2505o(36193);
        return false;
    }

    /* renamed from: t */
    public static boolean m33541t(bau bau) {
        AppMethodBeat.m2504i(36194);
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        if (C5730e.m8628ct(fZ + C29036i.m46116j(bau))) {
            AppMethodBeat.m2505o(36194);
            return true;
        } else if (C5730e.m8628ct(fZ + C29036i.m46126p(bau)) && !C5046bo.isNullOrNil(bau.f17915Id) && bau.f17915Id.startsWith("Locall_path")) {
            AppMethodBeat.m2505o(36194);
            return true;
        } else {
            AppMethodBeat.m2505o(36194);
            return false;
        }
    }

    /* renamed from: n */
    public final int mo37464n(C46236n c46236n) {
        AppMethodBeat.m2504i(36195);
        int a = mo37433a(c46236n, null);
        AppMethodBeat.m2505o(36195);
        return a;
    }

    /* renamed from: a */
    public final int mo37433a(C46236n c46236n, int[] iArr) {
        int i;
        int i2 = 5;
        AppMethodBeat.m2504i(36196);
        if (iArr != null || C5046bo.m7525az(this.qIf) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            C37938c.afC();
            if (C37938c.m64121a(pInt, pInt2, pInt3)) {
                this.qIh = 5;
            } else {
                this.qIh = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.qIi = pInt.value;
            this.qIf = C5046bo.m7588yz();
        }
        if (this.qIi == 0 || c46236n == null) {
            i = this.qIh;
            AppMethodBeat.m2505o(36196);
            return i;
        } else if (this.qIj.containsKey(Long.valueOf(c46236n.field_snsId))) {
            i = ((Integer) this.qIj.get(Long.valueOf(c46236n.field_snsId))).intValue();
            AppMethodBeat.m2505o(36196);
            return i;
        } else {
            cbn cbn = new cbn();
            try {
                cbf cbf = (cbf) new cbf().parseFrom(c46236n.field_attrBuf);
                if (cbf.xaD == null) {
                    i = this.qIh;
                    AppMethodBeat.m2505o(36196);
                    return i;
                }
                cbn.parseFrom(cbf.xaD.getBufferToBytes());
                if (cbn.xaS == null || cbn.xaS.info == null) {
                    i = this.qIh;
                    AppMethodBeat.m2505o(36196);
                    return i;
                }
                String str = cbn.xaS.info;
                int hashCode = str.hashCode();
                if (this.qIi == 1) {
                    if (!this.qIl.containsKey(Integer.valueOf(hashCode))) {
                        this.qIl.put(Integer.valueOf(hashCode), Boolean.valueOf(C21925g.m33531cX(str, this.qIi)));
                    }
                    i = ((Boolean) this.qIl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
                } else {
                    if (!this.qIk.containsKey(Integer.valueOf(hashCode))) {
                        this.qIk.put(Integer.valueOf(hashCode), Boolean.valueOf(C21925g.m33531cX(str, this.qIi)));
                    }
                    if (!((Boolean) this.qIk.get(Integer.valueOf(hashCode))).booleanValue()) {
                        i2 = 10;
                    }
                    i = i2;
                }
                C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(c46236n.field_snsId), Integer.valueOf(i));
                this.qIj.put(Long.valueOf(c46236n.field_snsId), Integer.valueOf(i));
                AppMethodBeat.m2505o(36196);
                return i;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
                i = this.qIh;
                AppMethodBeat.m2505o(36196);
                return i;
            }
        }
    }

    /* renamed from: o */
    public final int mo37465o(C46236n c46236n) {
        AppMethodBeat.m2504i(139038);
        int b = mo37453b(c46236n, null);
        AppMethodBeat.m2505o(139038);
        return b;
    }

    /* renamed from: b */
    public final int mo37453b(C46236n c46236n, int[] iArr) {
        int i;
        int i2 = 5;
        AppMethodBeat.m2504i(36198);
        if (iArr != null || C5046bo.m7525az(this.qIg) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            C37938c.afC();
            if (C37938c.m64120a(pInt, pInt2)) {
                this.qIm = 5;
            } else {
                this.qIm = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
            }
            this.qIn = pInt.value;
            this.qIg = C5046bo.m7588yz();
        }
        if (this.qIn == 0 || c46236n == null) {
            i = this.qIm;
            AppMethodBeat.m2505o(36198);
            return i;
        } else if (this.qIo.containsKey(Long.valueOf(c46236n.field_snsId))) {
            i = ((Integer) this.qIo.get(Long.valueOf(c46236n.field_snsId))).intValue();
            AppMethodBeat.m2505o(36198);
            return i;
        } else {
            cbn cbn = new cbn();
            try {
                cbf cbf = (cbf) new cbf().parseFrom(c46236n.field_attrBuf);
                if (cbf.xaD == null) {
                    i = this.qIm;
                    AppMethodBeat.m2505o(36198);
                    return i;
                }
                cbn.parseFrom(cbf.xaD.getBufferToBytes());
                if (cbn.xaS == null || cbn.xaS.info == null) {
                    i = this.qIh;
                    AppMethodBeat.m2505o(36198);
                    return i;
                }
                String str = cbn.xaS.info;
                int hashCode = str.hashCode();
                if (this.qIn == 1) {
                    if (!this.qIl.containsKey(Integer.valueOf(hashCode))) {
                        this.qIl.put(Integer.valueOf(hashCode), Boolean.valueOf(C21925g.m33531cX(str, this.qIn)));
                    }
                    i = ((Boolean) this.qIl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
                } else {
                    if (!this.qIk.containsKey(Integer.valueOf(hashCode))) {
                        this.qIk.put(Integer.valueOf(hashCode), Boolean.valueOf(C21925g.m33531cX(str, this.qIn)));
                    }
                    if (!((Boolean) this.qIk.get(Integer.valueOf(hashCode))).booleanValue()) {
                        i2 = 10;
                    }
                    i = i2;
                }
                C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(c46236n.field_snsId), Integer.valueOf(i));
                this.qIo.put(Long.valueOf(c46236n.field_snsId), Integer.valueOf(i));
                AppMethodBeat.m2505o(36198);
                return i;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
                i = this.qIm;
                AppMethodBeat.m2505o(36198);
                return i;
            }
        }
    }

    /* renamed from: cX */
    private static boolean m33531cX(String str, int i) {
        AppMethodBeat.m2504i(36199);
        Map z = C5049br.m7595z(str, "SightDownloadControl");
        if (z == null || z.isEmpty()) {
            AppMethodBeat.m2505o(36199);
            return true;
        } else if (i == 1) {
            if (C5046bo.getInt((String) z.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1) {
                AppMethodBeat.m2505o(36199);
                return true;
            }
            AppMethodBeat.m2505o(36199);
            return false;
        } else if (C5046bo.getInt((String) z.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1) {
            AppMethodBeat.m2505o(36199);
            return true;
        } else {
            AppMethodBeat.m2505o(36199);
            return false;
        }
    }

    /* renamed from: u */
    public final boolean mo37468u(bau bau) {
        AppMethodBeat.m2504i(36200);
        if (!this.qIc.containsKey(bau.f17915Id)) {
            AppMethodBeat.m2505o(36200);
            return false;
        } else if (((Integer) this.qIc.get(bau.f17915Id)).intValue() == 1) {
            AppMethodBeat.m2505o(36200);
            return true;
        } else {
            AppMethodBeat.m2505o(36200);
            return false;
        }
    }

    /* renamed from: v */
    public final boolean mo37469v(bau bau) {
        AppMethodBeat.m2504i(36201);
        if (!this.qIc.containsKey(bau.f17915Id)) {
            AppMethodBeat.m2505o(36201);
            return false;
        } else if (((Integer) this.qIc.get(bau.f17915Id)).intValue() == 2) {
            AppMethodBeat.m2505o(36201);
            return true;
        } else {
            AppMethodBeat.m2505o(36201);
            return false;
        }
    }

    /* renamed from: w */
    public final boolean mo37470w(bau bau) {
        AppMethodBeat.m2504i(36202);
        if (!this.qIc.containsKey(bau.f17915Id)) {
            AppMethodBeat.m2505o(36202);
            return false;
        } else if (((Integer) this.qIc.get(bau.f17915Id)).intValue() == 3) {
            AppMethodBeat.m2505o(36202);
            return true;
        } else {
            AppMethodBeat.m2505o(36202);
            return false;
        }
    }

    /* renamed from: x */
    public final boolean mo37471x(bau bau) {
        AppMethodBeat.m2504i(36203);
        if (!this.qIc.containsKey(bau.f17915Id)) {
            AppMethodBeat.m2505o(36203);
            return false;
        } else if (((Integer) this.qIc.get(bau.f17915Id)).intValue() == 4) {
            AppMethodBeat.m2505o(36203);
            return true;
        } else {
            AppMethodBeat.m2505o(36203);
            return false;
        }
    }

    /* renamed from: y */
    public final void mo37472y(bau bau) {
        AppMethodBeat.m2504i(36204);
        this.qIc.put(bau.f17915Id, Integer.valueOf(1));
        AppMethodBeat.m2505o(36204);
    }

    /* renamed from: z */
    public final void mo37473z(bau bau) {
        AppMethodBeat.m2504i(36205);
        this.qIc.put(bau.f17915Id, Integer.valueOf(2));
        AppMethodBeat.m2505o(36205);
    }

    /* renamed from: A */
    public final void mo37428A(bau bau) {
        AppMethodBeat.m2504i(36206);
        this.qIc.put(bau.f17915Id, Integer.valueOf(3));
        AppMethodBeat.m2505o(36206);
    }

    /* renamed from: a */
    private String m33512a(C46236n c46236n, final bau bau, final C44222az c44222az, boolean z) {
        AppMethodBeat.m2504i(36207);
        String str;
        if (mo37468u(bau)) {
            str = "";
            AppMethodBeat.m2505o(36207);
            return str;
        }
        str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        String j = C29036i.m46116j(bau);
        if (C5730e.m8628ct(str + j)) {
            str = str + j;
            AppMethodBeat.m2505o(36207);
            return str;
        } else if (C5730e.m8628ct(str + C29036i.m46126p(bau)) && bau.f17915Id != null && bau.f17915Id.startsWith("Locall_path")) {
            str = str + C29036i.m46126p(bau);
            AppMethodBeat.m2505o(36207);
            return str;
        } else if (this.qHJ) {
            C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "push sight loader " + bau.f17915Id + " url: " + bau.Url);
            if (!z) {
                C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
            } else if (mo37453b(c46236n, null) == 5) {
                C13373af.bCo().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36146);
                        C13373af.cnA().mo69138a(bau, 4, null, c44222az);
                        AppMethodBeat.m2505o(36146);
                    }
                }, 0);
            }
            str = "";
            AppMethodBeat.m2505o(36207);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(36207);
            return str;
        }
    }

    /* renamed from: a */
    public final boolean mo37451a(String str, C45434n c45434n, int i) {
        AppMethodBeat.m2504i(36209);
        m33524a(i + "-" + str, c45434n);
        AppMethodBeat.m2505o(36209);
        return true;
    }

    /* renamed from: a */
    private boolean m33524a(String str, C45434n c45434n) {
        AppMethodBeat.m2504i(36210);
        if (!(c45434n == null || str == null)) {
            this.qHV.put(str, (Object) c45434n);
        }
        AppMethodBeat.m2505o(36210);
        return true;
    }

    /* renamed from: XM */
    public final void mo37431XM(String str) {
        AppMethodBeat.m2504i(36212);
        mo37456b(str, null);
        AppMethodBeat.m2505o(36212);
    }

    /* renamed from: XN */
    public final C45434n mo37432XN(String str) {
        AppMethodBeat.m2504i(36213);
        if (this.qHV == null) {
            AppMethodBeat.m2505o(36213);
            return null;
        }
        C45434n c45434n = (C45434n) this.qHV.get("0-".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(36213);
        return c45434n;
    }

    /* renamed from: a */
    public static Bitmap m33510a(String str, String str2, String str3, boolean z, C44222az c44222az) {
        AppMethodBeat.m2504i(36214);
        if (z || !C5046bo.isNullOrNil(str)) {
            bau a = C37953e.m64185a(str3, 2, str2, str2, 1, 1, "");
            C29036i.m46102bc(2, str3);
            Bitmap Xj;
            if (str3.equals("")) {
                Xj = C29036i.m46087Xj(str);
                if (C29036i.m46072B(Xj)) {
                    AppMethodBeat.m2505o(36214);
                    return Xj;
                }
                AppMethodBeat.m2505o(36214);
                return null;
            } else if (C29036i.m46072B(null)) {
                AppMethodBeat.m2505o(36214);
                return null;
            } else {
                Xj = C29036i.m46087Xj(C3892an.m6198fZ(C13373af.getAccSnsPath(), str3) + C29036i.m46121l(a));
                if (!C29036i.m46072B(Xj)) {
                    Xj = C29036i.m46087Xj(str);
                }
                if (Xj == null && z && !C5046bo.isNullOrNil(str2)) {
                    C13373af.cnA().mo69138a(a, 3, null, c44222az);
                }
                if (C29036i.m46072B(Xj)) {
                    AppMethodBeat.m2505o(36214);
                    return Xj;
                }
                AppMethodBeat.m2505o(36214);
                return null;
            }
        }
        AppMethodBeat.m2505o(36214);
        return null;
    }

    /* renamed from: B */
    public final boolean mo37429B(bau bau) {
        AppMethodBeat.m2504i(36215);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36215);
            return false;
        } else if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46110f(bau))) {
            AppMethodBeat.m2505o(36215);
            return true;
        } else if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau))) {
            AppMethodBeat.m2505o(36215);
            return true;
        } else {
            boolean b = C29036i.m46101b((C45434n) this.qHV.get(C29036i.m46102bc(1, bau.f17915Id)));
            AppMethodBeat.m2505o(36215);
            return b;
        }
    }

    /* renamed from: a */
    public static boolean m33523a(bau bau, C44222az c44222az, boolean z) {
        AppMethodBeat.m2504i(36216);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36216);
            return false;
        }
        String str;
        if (bau.f17915Id.startsWith("Locall_path")) {
            str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46122m(bau);
        } else {
            str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46105d(bau);
        }
        if (C5730e.m8628ct(str)) {
            AppMethodBeat.m2505o(36216);
            return true;
        }
        C13373af.cnA().mo69138a(bau, z ? 8 : 2, null, c44222az);
        AppMethodBeat.m2505o(36216);
        return false;
    }

    /* renamed from: C */
    public static String m33507C(bau bau) {
        AppMethodBeat.m2504i(36217);
        if (bau == null) {
            AppMethodBeat.m2505o(36217);
            return null;
        }
        String str;
        if (bau.f17915Id.startsWith("pre_temp_sns_pic")) {
            str = C13373af.getAccSnsTmpPath() + bau.f17915Id;
        } else if (bau.f17915Id.startsWith("Locall_path")) {
            str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46122m(bau);
        } else if (bau.f17915Id.startsWith("pre_temp_extend_pic")) {
            str = bau.f17915Id.substring(19);
        } else {
            str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46105d(bau);
        }
        AppMethodBeat.m2505o(36217);
        return str;
    }

    /* renamed from: a */
    public final Bitmap mo37435a(bau bau, View view, int i, boolean z, C44222az c44222az, boolean z2) {
        AppMethodBeat.m2504i(36218);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36218);
            return null;
        }
        String bc = C29036i.m46102bc(3, bau.f17915Id);
        String C = C21925g.m33507C(bau);
        int i2 = -1;
        int i3 = -1;
        try {
            Options amj = C5056d.amj(C);
            i2 = amj.outWidth;
            i3 = amj.outHeight;
        } catch (Exception e) {
        }
        m33517a((Object) view, bc, false, -1, i, i2, i3, C21934a.IMG_SCENE_NONE);
        if (C13373af.cnA().mo69132XE(bau.f17915Id)) {
            AppMethodBeat.m2505o(36218);
            return null;
        }
        Object obj;
        Bitmap bitmap;
        C3886al c3886al = this.qHW;
        C3885b c3885b = (C3885b) c3886al.qMs.get(bc);
        if (c3885b == null) {
            obj = null;
        } else {
            ((C3885b) c3886al.qMs.get(bc)).cob();
            obj = c3885b.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        C4990ab.m7416i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + bc + "  " + (weakReference == null));
        if (weakReference == null) {
            bitmap = null;
        } else {
            bitmap = (Bitmap) weakReference.get();
        }
        if (C29036i.m46072B(bitmap)) {
            AppMethodBeat.m2505o(36218);
            return bitmap;
        }
        Bitmap Zk;
        if (bau.f17915Id.startsWith("pre_temp_extend_pic")) {
            Zk = C13478s.m21634Zk(C);
        } else {
            Zk = C29036i.m46087Xj(C);
        }
        C3886al c3886al2 = this.qHW;
        WeakReference weakReference2 = new WeakReference(Zk);
        if (((C3885b) c3886al2.qMs.get(bc)) == null) {
            c3886al2.qMs.put(bc, new C3885b(weakReference2));
            c3886al2.coa();
        } else {
            ((C3885b) c3886al2.qMs.get(bc)).cob();
            ((C3885b) c3886al2.qMs.get(bc)).obj = weakReference2;
        }
        if (C29036i.m46072B(Zk)) {
            AppMethodBeat.m2505o(36218);
            return Zk;
        }
        if (z) {
            C13373af.cnA().mo69138a(bau, z2 ? 8 : 2, null, c44222az);
        }
        AppMethodBeat.m2505o(36218);
        return null;
    }

    /* renamed from: a */
    public final C45434n mo37436a(bau bau, ImageView imageView, int i, C44222az c44222az) {
        AppMethodBeat.m2504i(36219);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36219);
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String bc = C29036i.m46102bc(0, bau.f17915Id);
        m33514a((Object) imageView, bc, -1, i);
        C45434n XK = mo37430XK(bc);
        if (C29036i.m46101b(XK)) {
            AppMethodBeat.m2505o(36219);
            return XK;
        }
        m33518a(0, bau, c44222az);
        AppMethodBeat.m2505o(36219);
        return null;
    }

    /* renamed from: a */
    public final void mo37444a(List<bau> list, View view, int i, C21934a c21934a, C44222az c44222az) {
        AppMethodBeat.m2504i(36221);
        mo37445a((List) list, view, i, c21934a, c44222az, false);
        AppMethodBeat.m2505o(36221);
    }

    /* renamed from: a */
    public final void mo37445a(List<bau> list, View view, int i, C21934a c21934a, C44222az c44222az, boolean z) {
        AppMethodBeat.m2504i(36222);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(36222);
        } else if (list.size() != 1) {
            String bc = C29036i.m46102bc(0, C29036i.m46106dc(list));
            m33513a(view, bc, i, c21934a);
            C45434n XK = mo37430XK(bc);
            boolean b = C29036i.m46101b(XK);
            C4990ab.m7418v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(b)));
            if (b) {
                C21925g.m33516a((Object) view, bc, XK);
                AppMethodBeat.m2505o(36222);
                return;
            }
            C21925g.m33533dA(view);
            if (this.qIp.contains(bc)) {
                AppMethodBeat.m2505o(36222);
                return;
            }
            WeakReference weakReference = new WeakReference(view);
            m33525a((List) list, c44222az);
            AppMethodBeat.m2505o(36222);
        } else if (z) {
            m33529b((bau) list.get(0), view, i, C21934a.IMG_SCENE_SNSSUSER, c44222az);
            AppMethodBeat.m2505o(36222);
        } else {
            mo37455b((bau) list.get(0), view, i, c44222az);
            AppMethodBeat.m2505o(36222);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo37456b(String str, C45434n c45434n) {
        AppMethodBeat.m2504i(36223);
        if (!C29036i.m46101b(c45434n)) {
            c45434n = m33508XL(str);
        }
        if (C29036i.m46101b(c45434n)) {
            if (!(this.qHV == null || c45434n == null || str == null)) {
                this.qHV.put(str, (Object) c45434n);
            }
            LinkedList linkedList = (LinkedList) this.qHX.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C21928c c21928c = (C21928c) ((WeakReference) it.next()).get();
                    if (c21928c != null && c21928c.qIK && str != null && str.equals(c21928c.f4395id)) {
                        WeakReference weakReference = (WeakReference) this.fEk.get(Integer.valueOf(c21928c.code));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.qIe != null && (qFadeImageView instanceof TagImageView)) {
                                        int position = ((TagImageView) qFadeImageView).getPosition();
                                        if (!(position == -1 || this.qIe.mo69232DQ(position))) {
                                        }
                                    }
                                }
                                if (!C29036i.m46101b(c45434n) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(c45434n == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(C29036i.m46101b(c45434n));
                                    C4990ab.m7411d(str2, str3, objArr);
                                } else {
                                    C21925g.m33516a(obj, str, c45434n);
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(36223);
    }

    public final void cmm() {
        AppMethodBeat.m2504i(36224);
        cmV();
        this.qIf = 0;
        this.qIg = 0;
        this.qHZ.clear();
        this.qIa = false;
        AppMethodBeat.m2505o(36224);
    }

    /* renamed from: c */
    public final void mo37458c(bau bau, View view, int i, C44222az c44222az) {
        AppMethodBeat.m2504i(36182);
        if (bau == null || bau.f17915Id == null || bau.f17915Id.equals("")) {
            AppMethodBeat.m2505o(36182);
            return;
        }
        String bc = C29036i.m46102bc(4, bau.f17915Id);
        m33514a((Object) view, bc, -1, i);
        C45434n XK = mo37430XK(bc);
        boolean b = C29036i.m46101b(XK);
        C4990ab.m7418v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(b)));
        if (b) {
            C21925g.m33516a((Object) view, bc, XK);
        } else {
            C21925g.m33533dA(view);
            if (!this.qIp.contains(bc)) {
                m33518a(4, bau, c44222az);
                AppMethodBeat.m2505o(36182);
                return;
            }
        }
        AppMethodBeat.m2505o(36182);
    }

    /* renamed from: fX */
    public final boolean mo37463fX(String str, String str2) {
        AppMethodBeat.m2504i(36208);
        if (this.qIc.containsKey(str) && 3 == ((Integer) this.qIc.get(str)).intValue()) {
            this.qIc.remove(str);
        }
        String bc = C29036i.m46102bc(1, str);
        LinkedList linkedList = (LinkedList) this.qHX.get(bc);
        if (linkedList == null) {
            AppMethodBeat.m2505o(36208);
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C21928c c21928c = (C21928c) ((WeakReference) it.next()).get();
            if (c21928c != null && c21928c.qIK && bc != null && bc.equals(c21928c.f4395id)) {
                WeakReference weakReference = (WeakReference) this.fEk.get(Integer.valueOf(c21928c.code));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof C34915a)) {
                        C4990ab.m7417i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", str, str2);
                        C34915a c34915a = (C34915a) obj;
                        if (c34915a.getTagObject() instanceof C43589aj) {
                            C43589aj c43589aj = (C43589aj) c34915a.getTagObject();
                            if (c43589aj == null) {
                                c34915a.mo8509bf(str2, !this.qHJ);
                            } else if (C5730e.m8628ct(str2)) {
                                c34915a.mo8509bf(str2, !this.qHJ);
                                c34915a.setPosition(c43589aj.position);
                                c43589aj.rnu.setVisibility(8);
                                c43589aj.raP.setVisibility(8);
                                c43589aj.raQ.setVisibility(8);
                                if (this.qIc.containsKey(str) && 4 == ((Integer) this.qIc.get(str)).intValue()) {
                                    this.qIc.remove(str);
                                }
                            } else {
                                this.qIc.put(str, Integer.valueOf(4));
                                c43589aj.rnu.setVisibility(8);
                                c43589aj.raP.setImageResource(C25738R.drawable.atu);
                                c43589aj.raP.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(36208);
        return true;
    }

    /* renamed from: a */
    public final boolean mo37447a(C39731e c39731e, String str) {
        bau bau;
        String f;
        AppMethodBeat.m2504i(36211);
        bau bau2 = (bau) c39731e.list.get(0);
        for (int i = 1; i < c39731e.list.size(); i++) {
            bau bau3 = (bau) c39731e.list.get(i);
            if (str != null && str.indexOf(bau3.f17915Id) >= 0) {
                bau = bau3;
                break;
            }
        }
        bau = bau2;
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        if (c39731e.qFQ == 0) {
            f = C29036i.m46110f(bau);
        } else if (c39731e.qFQ == 4) {
            f = C29036i.m46111g(bau);
        } else if (c39731e.qFQ == 5) {
            f = C29036i.m46111g(bau);
        } else if (c39731e.qFQ == 3) {
            f = C29036i.m46121l(bau);
        } else {
            f = C29036i.m46108e(bau);
        }
        if (!this.qHV.mo4405aj(C29036i.m46102bc(c39731e.qFQ, bau.f17915Id))) {
            new C21935b(C29036i.m46102bc(c39731e.qFQ, bau.f17915Id), fZ + f, fZ, bau, c39731e.qFQ).mo62862u("");
        }
        AppMethodBeat.m2505o(36211);
        return true;
    }

    /* renamed from: a */
    public final void mo37438a(View view, int i, int i2, int i3) {
        AppMethodBeat.m2504i(36220);
        m33517a((Object) view, null, true, -1, i3, -1, -1, C21934a.IMG_SCENE_NONE);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
                AppMethodBeat.m2505o(36220);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(C1338a.m2864g(view.getContext(), i2));
                AppMethodBeat.m2505o(36220);
                return;
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(C25738R.drawable.b66);
            AppMethodBeat.m2505o(36220);
            return;
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(C25738R.drawable.b66);
        }
        AppMethodBeat.m2505o(36220);
    }
}
