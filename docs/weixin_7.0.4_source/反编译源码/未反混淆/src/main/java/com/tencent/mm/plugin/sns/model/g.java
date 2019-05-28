package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.R;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.e;
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

public final class g implements f {
    private static int qIq = 0;
    private Map<Integer, WeakReference<Object>> fEk = new HashMap();
    public boolean qHJ = true;
    private long qHT = 0;
    private long qHU = 0;
    com.tencent.mm.memory.a.b<n> qHV;
    private al<String, WeakReference<Bitmap>> qHW;
    private Map<String, LinkedList<WeakReference<c>>> qHX = new HashMap();
    private ConcurrentHashMap<Integer, String> qHY = new ConcurrentHashMap();
    private LinkedList<b> qHZ = new LinkedList();
    private boolean qIa = false;
    private HashSet<c> qIb = new HashSet();
    public HashMap<String, Integer> qIc = new HashMap();
    private int qId = 4;
    public x qIe;
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

    /* renamed from: com.tencent.mm.plugin.sns.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ bau qIs;

        AnonymousClass2(bau bau) {
            this.qIs = bau;
        }

        public final void run() {
            AppMethodBeat.i(36136);
            g.a(g.this, 1, this.qIs);
            AppMethodBeat.o(36136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int qIt = 0;
        final /* synthetic */ String qIu;
        final /* synthetic */ n qIv;

        AnonymousClass3(String str, n nVar) {
            this.qIu = str;
            this.qIv = nVar;
        }

        public final void run() {
            AppMethodBeat.i(36137);
            g.a(g.this, this.qIt + "-" + this.qIu, this.qIv);
            AppMethodBeat.o(36137);
        }
    }

    static class c {
        public int code;
        public String id;
        public int qIJ;
        public boolean qIK;

        public c(String str, int i, int i2, boolean z) {
            this.id = str;
            this.code = i;
            this.qIJ = i2;
            this.qIK = z;
        }

        public final int hashCode() {
            return this.code;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(36156);
            if (obj == null || obj.hashCode() != this.code) {
                AppMethodBeat.o(36156);
                return false;
            }
            AppMethodBeat.o(36156);
            return true;
        }
    }

    public enum a {
        IMG_SCENE_NONE,
        IMG_SCENE_SNSSUSER;

        static {
            AppMethodBeat.o(36149);
        }
    }

    class b extends h<String, Integer, Boolean> {
        private bau cNr;
        private String fUJ;
        private n feQ = null;
        String key = "";
        private String path;
        private int qII = 0;

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(36155);
            Boolean cmY = cmY();
            AppMethodBeat.o(36155);
            return cmY;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(36154);
            super.onPostExecute((Boolean) obj);
            g.cmX();
            g.this.qIp.remove(this.key);
            g.this.b(this.key, this.feQ);
            g.this.qIa = false;
            g.g(g.this);
            AppMethodBeat.o(36154);
        }

        public b(String str, String str2, String str3, bau bau, int i) {
            AppMethodBeat.i(36150);
            g.this.qIp.add(str);
            this.key = str;
            this.path = str2;
            this.fUJ = str3;
            this.cNr = bau;
            this.qII = i;
            g.bTr();
            ab.d("MicroMsg.ImageLoader", "peddingCount %d ", Integer.valueOf(g.qIq));
            AppMethodBeat.o(36150);
        }

        private void ac(String str, String str2, String str3) {
            AppMethodBeat.i(36151);
            e.ct(this.fUJ + str3);
            if (!e.ct(this.fUJ + str)) {
                if (!e.ct(this.fUJ + str2)) {
                    str2 = i.m(this.cNr);
                }
                if (!s.a(this.fUJ, str2, str, (float) af.cnO())) {
                    ab.i("MicroMsg.ImageLoader", "delete %s", str2);
                    e.deleteFile(this.fUJ + str2);
                }
                ab.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", this.fUJ + str2, this.fUJ + str, Boolean.valueOf(r0));
            }
            s.b(this.fUJ, str, str3, (float) af.cnN());
            AppMethodBeat.o(36151);
        }

        private Boolean cmY() {
            AppMethodBeat.i(36152);
            g.this.qIa = true;
            Boolean bool;
            if (!g.this.qHJ) {
                ab.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
                bool = Boolean.FALSE;
                AppMethodBeat.o(36152);
                return bool;
            } else if (g.this.qHV.aj(this.key)) {
                ab.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
                bool = Boolean.FALSE;
                AppMethodBeat.o(36152);
                return bool;
            } else {
                e.ate(this.fUJ);
                long currentTimeMillis = System.currentTimeMillis();
                if (e.ct(this.path)) {
                    ab.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", this.path);
                } else {
                    ac(i.e(this.cNr), i.l(this.cNr), i.f(this.cNr));
                }
                long yz = bo.yz();
                if (this.qII == 5) {
                    if (!e.ct(this.path)) {
                        ac(i.e(this.cNr), i.l(this.cNr), i.f(this.cNr));
                    }
                    boolean ct = e.ct(this.fUJ + i.e(this.cNr));
                    boolean ct2 = e.ct(this.fUJ + i.l(this.cNr));
                    boolean ct3 = e.ct(this.fUJ + i.f(this.cNr));
                    this.feQ = i.Xi(this.path);
                    if (this.feQ == null) {
                        ab.i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.feQ = com.tencent.mm.plugin.sns.lucky.a.a.fV(this.fUJ + i.f(this.cNr), this.path);
                        ab.i("MicroMsg.ImageLoader", "abc a" + ct + " b" + ct2 + " c" + ct3 + " d" + e.ct(this.path));
                    }
                } else if (this.qII == 4) {
                    this.feQ = i.Xi(this.path);
                    if (this.feQ == null) {
                        ab.i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.feQ = com.tencent.mm.plugin.sns.lucky.a.a.fV(this.fUJ + i.e(this.cNr), this.path);
                    }
                } else {
                    this.feQ = i.Xk(this.path);
                }
                long az = bo.az(yz);
                int asZ = (int) e.asZ(this.path);
                if (bo.az(g.this.qHU) > 60000) {
                    h.pYm.e(11696, Integer.valueOf(4), Long.valueOf(az), Integer.valueOf(asZ), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
                    g.this.qHU = bo.yz();
                }
                if (this.feQ == null) {
                    ab.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", this.cNr.Id);
                    e.deleteFile(this.fUJ + i.f(this.cNr));
                    e.deleteFile(this.path);
                    h.pYm.a(150, 2, 1, true);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                h.pYm.a(150, 0, 1, true);
                h.pYm.a(150, 1, currentTimeMillis, true);
                ab.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.feQ == null) + " " + this.feQ + " %d ", this.path, Long.valueOf(System.currentTimeMillis() - yz));
                bool = Boolean.TRUE;
                AppMethodBeat.o(36152);
                return bool;
            }
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(36153);
            com.tencent.mm.sdk.g.b.a cnq = af.cnq();
            AppMethodBeat.o(36153);
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

    static /* synthetic */ boolean g(g gVar) {
        AppMethodBeat.i(36227);
        boolean cmW = gVar.cmW();
        AppMethodBeat.o(36227);
        return cmW;
    }

    public final void start() {
        AppMethodBeat.i(36157);
        this.qHJ = true;
        cmW();
        b cnA = af.cnA();
        cnA.qHJ = true;
        cnA.agK();
        AppMethodBeat.o(36157);
    }

    public final void pause() {
        AppMethodBeat.i(36158);
        this.qHJ = false;
        b cnA = af.cnA();
        cnA.qHJ = false;
        synchronized (cnA.eHH) {
            try {
                LinkedList linkedList = new LinkedList();
                Iterator it = cnA.eow.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) it.next();
                    if (fVar.requestType != 6) {
                        cnA.qHM.remove(fVar.key);
                        linkedList.add(fVar);
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    cnA.eow.remove((com.tencent.mm.plugin.sns.data.f) it2.next());
                }
            } finally {
                AppMethodBeat.o(36158);
            }
        }
    }

    public g() {
        int i;
        AppMethodBeat.i(36159);
        com.tencent.mm.memory.a.b.a(n.class, new com.tencent.mm.memory.a.b.a<n>() {
            public final /* synthetic */ int aU(Object obj) {
                AppMethodBeat.i(36135);
                n nVar = (n) obj;
                if (nVar == null) {
                    AppMethodBeat.o(36135);
                    return 0;
                }
                int allocationByteCount = nVar.getAllocationByteCount();
                AppMethodBeat.o(36135);
                return allocationByteCount;
            }
        });
        ab.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", Integer.valueOf(((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass()));
        if (((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            i = 62914560;
        } else {
            i = 31457280;
        }
        this.qHV = new com.tencent.mm.memory.a.b(i, new com.tencent.mm.a.f.b<String, n>() {
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                String str;
                AppMethodBeat.i(36138);
                String str2 = (String) obj;
                n nVar = (n) obj2;
                n nVar2 = (n) obj3;
                if (!(nVar == null || nVar.isRecycled() || nVar.equals(nVar2))) {
                    nVar.Xj();
                }
                int i = 0;
                if (nVar2 != null) {
                    i = nVar2.getAllocationByteCount();
                }
                String str3 = "MicroMsg.LazyerImageLoader2";
                StringBuilder append = new StringBuilder(" key: ").append(str2).append(" result:").append(i).append(" ").append(nVar.bitmap.getRowBytes() * nVar.bitmap.getHeight()).append(" ").append(nVar.bitmap.getWidth()).append(" ").append(nVar.bitmap.getHeight()).append(" oldValue ");
                if (nVar == null) {
                    str = "NULL";
                } else {
                    str = nVar.Xm();
                }
                append = append.append(str).append(" newValue: ");
                if (nVar2 == null) {
                    str = "NULL";
                } else {
                    str = nVar2.Xm();
                }
                ab.d(str3, append.append(str).toString());
                AppMethodBeat.o(36138);
            }
        }, getClass());
        this.qHW = new al(this.qId, new com.tencent.mm.plugin.sns.model.al.a() {
            public final boolean cn(Object obj) {
                AppMethodBeat.i(36139);
                String str = (String) obj;
                if (g.a(g.this, str)) {
                    boolean z;
                    al a = g.this.qHW;
                    try {
                        Bitmap bitmap;
                        Object obj2 = ((com.tencent.mm.plugin.sns.model.al.b) a.qMs.get(str)).obj;
                        if (obj2 instanceof Bitmap) {
                            bitmap = (Bitmap) obj2;
                        } else {
                            WeakReference weakReference = (WeakReference) ((com.tencent.mm.plugin.sns.model.al.b) a.qMs.get(str)).obj;
                            if (weakReference != null) {
                                bitmap = (Bitmap) weakReference.get();
                            } else {
                                bitmap = null;
                            }
                        }
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            ab.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                            bitmap.recycle();
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SnsLRUMap", e, "", new Object[0]);
                        ab.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
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
                    ab.d(str2, append.append(z).toString());
                    ab.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.this.qHW.qMs.size() + " listPaitSize:" + g.this.qIb.size());
                    AppMethodBeat.o(36139);
                    return true;
                }
                AppMethodBeat.o(36139);
                return false;
            }
        });
        AppMethodBeat.o(36159);
    }

    public final void cmV() {
        AppMethodBeat.i(36160);
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
            ab.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.qHV.trimToSize(-1);
        }
        this.qHW.coa();
        System.gc();
        AppMethodBeat.o(36160);
    }

    public final Bitmap a(bau bau, View view, int i, az azVar, boolean z) {
        AppMethodBeat.i(36161);
        Bitmap a = a(bau, view, i, true, azVar, z);
        AppMethodBeat.o(36161);
        return a;
    }

    private boolean ac(View view, int i) {
        AppMethodBeat.i(36162);
        if (view.hashCode() == i) {
            AppMethodBeat.o(36162);
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!ac(viewGroup.getChildAt(childCount), i));
            AppMethodBeat.o(36162);
            return true;
        }
        AppMethodBeat.o(36162);
        return false;
    }

    public final void ab(Activity activity) {
        c cVar;
        AppMethodBeat.i(36163);
        ab.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.fEk.size());
        LinkedList<Integer> linkedList = new LinkedList();
        Iterator it = this.qIb.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (ac(activity.getWindow().getDecorView(), cVar.code)) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.fEk.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.qIb.iterator();
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.code == intValue2) {
                    this.qIb.remove(cVar);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.qIb.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.qIJ == activity.hashCode()) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.fEk.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.qIb.iterator();
            while (it3.hasNext()) {
                cVar = (c) it3.next();
                if (cVar.code == intValue4) {
                    this.qIb.remove(cVar);
                    break;
                }
            }
        }
        this.qHW.coa();
        ab.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.fEk.size());
        AppMethodBeat.o(36163);
    }

    public final void dz(View view) {
        AppMethodBeat.i(36164);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
            AppMethodBeat.o(36164);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
            AppMethodBeat.o(36164);
        } else {
            AppMethodBeat.o(36164);
        }
    }

    public final Bitmap b(bau bau) {
        AppMethodBeat.i(36165);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36165);
            return null;
        }
        String bc = i.bc(1, bau.Id);
        n XK = XK(bc);
        Bitmap Xh;
        if (i.b(XK)) {
            Xh = XK.Xh();
            AppMethodBeat.o(36165);
            return Xh;
        }
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        fZ = fZ + i.e(bau);
        if (e.ct(fZ)) {
            if (bau.Id.startsWith("pre_temp_extend_pic")) {
                XK = n.w(s.Zk(fZ));
            } else {
                XK = i.Xk(fZ);
            }
            if (i.b(XK)) {
                a(bc, XK);
                Xh = XK.Xh();
                AppMethodBeat.o(36165);
                return Xh;
            }
            AppMethodBeat.o(36165);
            return null;
        }
        AppMethodBeat.o(36165);
        return null;
    }

    public final String a(bau bau) {
        AppMethodBeat.i(36166);
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        fZ = fZ + i.e(bau);
        AppMethodBeat.o(36166);
        return fZ;
    }

    public final void b(bau bau, View view, int i, az azVar) {
        AppMethodBeat.i(36167);
        a(bau, view, -1, i, azVar);
        AppMethodBeat.o(36167);
    }

    public final void a(bau bau, View view, int i, a aVar, az azVar) {
        AppMethodBeat.i(36168);
        a(bau, view, -1, i, aVar, azVar);
        AppMethodBeat.o(36168);
    }

    public final n XK(String str) {
        AppMethodBeat.i(36169);
        n nVar = (n) this.qHV.get(str);
        if (nVar == null || nVar.isRecycled()) {
            this.qHV.remove(str);
            AppMethodBeat.o(36169);
            return null;
        }
        AppMethodBeat.o(36169);
        return nVar;
    }

    private n XL(String str) {
        AppMethodBeat.i(36170);
        n nVar = (n) this.qHV.get(str);
        if (nVar == null || nVar.isRecycled()) {
            this.qHV.remove(str);
            AppMethodBeat.o(36170);
            return null;
        }
        AppMethodBeat.o(36170);
        return nVar;
    }

    public final void a(bau bau, View view, int i, int i2, az azVar) {
        AppMethodBeat.i(36171);
        a(bau, view, i, i2, a.IMG_SCENE_NONE, azVar);
        AppMethodBeat.o(36171);
    }

    public final void a(String str, SparseArray<bau> sparseArray, SparseArray<View> sparseArray2, int i, az azVar, int i2) {
        AppMethodBeat.i(139037);
        ab.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
        if (sparseArray == null || sparseArray.size() <= 0) {
            ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
            AppMethodBeat.o(139037);
        } else if (sparseArray2 == null || sparseArray2.size() <= 0) {
            ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
            AppMethodBeat.o(139037);
        } else {
            int size = sparseArray.size();
            if (-1 == (size == sparseArray2.size() ? size : -1)) {
                ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", Integer.valueOf(size), Integer.valueOf(sparseArray2.size()));
                AppMethodBeat.o(139037);
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
                String bc = i.bc(0, bau.Id);
                a(obj, bc, -1, i, a.IMG_SCENE_NONE);
                n XK = XK(bc);
                if (i.b(XK)) {
                    ab.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
                    a(obj, bc, XK);
                } else {
                    ab.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
                    dA(obj);
                    if (this.qIp.contains(bc)) {
                        AppMethodBeat.o(139037);
                        return;
                    }
                    sparseArray3.put(keyAt, bau);
                }
            }
            final SparseArray sparseArray6 = sparseArray3;
            final SparseArray sparseArray7 = sparseArray4;
            final SparseArray sparseArray8 = sparseArray5;
            final String str2 = str;
            final az azVar2 = azVar;
            i3 = i2;
            af.cns().execute(new Runnable() {
                public final void run() {
                    bau bau;
                    int i = 0;
                    AppMethodBeat.i(36140);
                    int size = sparseArray6.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray6.keyAt(i2);
                        bau = (bau) sparseArray6.get(keyAt);
                        if (!g.a(g.this, 0, bau)) {
                            com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(bau);
                            eVar.qFQ = 0;
                            eVar.nQB = bau.Id;
                            sparseArray7.put(keyAt, eVar);
                            sparseArray8.put(keyAt, bau);
                        }
                    }
                    if (sparseArray8.size() > 0) {
                        b cnA = af.cnA();
                        String str = str2;
                        SparseArray sparseArray = sparseArray8;
                        SparseArray sparseArray2 = sparseArray7;
                        az azVar = azVar2;
                        int i3 = i3;
                        int size2 = sparseArray.size();
                        for (size = 0; size < size2; size++) {
                            av.Yi(((bau) sparseArray.valueAt(size)).Id);
                        }
                        if (i.Xn(af.getAccPath())) {
                            SparseArray sparseArray3 = new SparseArray();
                            while (i < size2) {
                                int keyAt2 = sparseArray.keyAt(i);
                                bau = (bau) sparseArray.get(keyAt2);
                                if (bau.Id.startsWith("Locall_path") || bau.Id.startsWith("pre_temp_sns_pic")) {
                                    sparseArray2.remove(keyAt2);
                                } else {
                                    sparseArray3.put(keyAt2, bau);
                                }
                                i++;
                            }
                            if (sparseArray3.size() <= 0) {
                                ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
                                AppMethodBeat.o(36140);
                                return;
                            }
                            String Xh = i.Xh(str);
                            synchronized (cnA.eHH) {
                                try {
                                    if (cnA.qHM.containsKey(Xh)) {
                                        Iterator it = cnA.eow.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) it.next();
                                            if (fVar.key.equals(Xh)) {
                                                if (cnA.eow.remove(fVar)) {
                                                    cnA.eow.addLast(fVar);
                                                }
                                                ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
                                            }
                                        }
                                    } else {
                                        ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", str);
                                        cnA.qHM.put(Xh, new com.tencent.mm.plugin.sns.data.c(sparseArray2));
                                        cnA.eow.add(new com.tencent.mm.plugin.sns.data.f(str, sparseArray3, Xh, azVar, i3));
                                    }
                                } catch (Throwable th) {
                                    AppMethodBeat.o(36140);
                                }
                            }
                            if (Looper.myLooper() != null) {
                                Looper.myQueue().addIdleHandler(new d());
                            } else {
                                ab.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
                            }
                            cnA.cmJ();
                            cnA.cmK();
                            if (cnA.eow.size() > 0) {
                                ab.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
                                cnA.agK();
                            }
                        } else {
                            ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", af.getAccPath(), com.tencent.mm.compatible.util.e.eSl);
                            AppMethodBeat.o(36140);
                            return;
                        }
                    }
                    AppMethodBeat.o(36140);
                }
            });
            AppMethodBeat.o(139037);
        }
    }

    public final void a(bau bau, View view, int i, int i2, a aVar, az azVar) {
        AppMethodBeat.i(36173);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36173);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String bc = i.bc(0, bau.Id);
        a((Object) view, bc, i, i2, aVar);
        n XK = XK(bc);
        if (i.b(XK)) {
            ab.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
            af.cnA().XH(bau.Id);
            a((Object) view, bc, XK);
            AppMethodBeat.o(36173);
            return;
        }
        ab.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
        if (i == -1) {
            dA(view);
        }
        if (this.qIp.contains(bc)) {
            AppMethodBeat.o(36173);
            return;
        }
        a(0, bau, azVar);
        AppMethodBeat.o(36173);
    }

    private void b(bau bau, View view, int i, a aVar, az azVar) {
        AppMethodBeat.i(36174);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36174);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String bc = i.bc(5, bau.Id);
        a((Object) view, bc, -1, i, aVar);
        n XK = XK(bc);
        if (i.b(XK)) {
            a((Object) view, bc, XK);
            AppMethodBeat.o(36174);
            return;
        }
        dA(view);
        if (this.qIp.contains(bc)) {
            AppMethodBeat.o(36174);
            return;
        }
        a(5, bau, azVar);
        AppMethodBeat.o(36174);
    }

    private static void a(Object obj, String str, n nVar) {
        long j = 0;
        AppMethodBeat.i(36175);
        if (obj == null) {
            AppMethodBeat.o(36175);
            return;
        }
        if (nVar != null) {
            ab.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", obj, str, nVar.Xm());
        }
        Drawable drawable;
        if (obj instanceof QFadeImageView) {
            long j2;
            QFadeImageView qFadeImageView = (QFadeImageView) obj;
            drawable = qFadeImageView.getDrawable();
            if (!bo.isNullOrNil(qFadeImageView.getImageKey()) && qFadeImageView.getImageKey().equals(str)) {
                j = qFadeImageView.getStartTimeMillis();
            }
            if (drawable == null || !(drawable instanceof ai)) {
                j2 = j;
            } else {
                j2 = ((ai) drawable).mSd;
            }
            ai aiVar = new ai(str, nVar, j2);
            qFadeImageView.D(aiVar.mSd, str);
            qFadeImageView.setImageDrawable(aiVar);
            aiVar.invalidateSelf();
            AppMethodBeat.o(36175);
        } else if (obj instanceof QDisFadeImageView) {
            QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
            com.tencent.mm.memory.b.a aVar = new com.tencent.mm.memory.b.a(str, nVar);
            qDisFadeImageView.setImageDrawable(aVar);
            aVar.invalidateSelf();
            AppMethodBeat.o(36175);
        } else if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof ai)) {
                drawable = new ai(str, nVar, 0);
            } else {
                drawable = new ai(str, nVar, ((ai) drawable).mSd);
            }
            imageView.setImageDrawable(drawable);
            drawable.invalidateSelf();
            AppMethodBeat.o(36175);
        } else {
            if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                ab.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(str)));
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.getDrawable();
                    if (drawable == null || !(drawable instanceof ai)) {
                        drawable = new ai(str, nVar, 0);
                    } else {
                        drawable = new ai(str, nVar, ((ai) drawable).mSd);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
            AppMethodBeat.o(36175);
        }
    }

    public static String r(bau bau) {
        AppMethodBeat.i(36176);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36176);
            return null;
        }
        String str = an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau);
        if (e.ct(str)) {
            AppMethodBeat.o(36176);
            return str;
        }
        str = bau.wEH;
        AppMethodBeat.o(36176);
        return str;
    }

    public static String s(bau bau) {
        AppMethodBeat.i(36177);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36177);
            return null;
        }
        String str = an.fZ(af.getAccSnsPath(), bau.Id) + i.d(bau);
        if (e.ct(str)) {
            AppMethodBeat.o(36177);
            return str;
        }
        str = bau.Url;
        AppMethodBeat.o(36177);
        return str;
    }

    public final void a(bau bau, View view, int i, az azVar) {
        AppMethodBeat.i(36178);
        b(bau, view, -1, i, azVar);
        AppMethodBeat.o(36178);
    }

    public final boolean a(com.tencent.mm.plugin.sight.decode.a.a aVar, int i) {
        AppMethodBeat.i(36179);
        a((Object) aVar, "", -1, i);
        aVar.setThumbBmp(null);
        aVar.bf(null, false);
        AppMethodBeat.o(36179);
        return true;
    }

    public final boolean a(com.tencent.mm.plugin.sns.storage.n nVar, bau bau, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, az azVar, boolean z) {
        AppMethodBeat.i(36180);
        boolean a = a(nVar, bau, aVar, i, i2, azVar, z, false);
        AppMethodBeat.o(36180);
        return a;
    }

    public final boolean a(com.tencent.mm.plugin.sns.storage.n nVar, bau bau, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, az azVar, boolean z, boolean z2) {
        AppMethodBeat.i(36181);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36181);
            return false;
        }
        String bc = i.bc(1, bau.Id);
        a((Object) aVar, bc, -1, i);
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        String e = i.e(bau);
        if (!e.ct(fZ + e)) {
            com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(bau);
            eVar.qFQ = 1;
            eVar.nQB = bau.Id;
            af.cnA().a(bau, bau.jCt == 6 ? 5 : 1, eVar, azVar);
        }
        String str = "";
        if (z) {
            str = a(nVar, bau, azVar, z);
        }
        ab.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", bc, str, Boolean.valueOf(z));
        if (bo.isNullOrNil(str) || u(bau)) {
            ab.i("MicroMsg.LazyerImageLoader2", "sightPath %s", str);
            aVar.bf(null, !this.qHJ);
            n XK = XK(bc);
            ab.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", Boolean.valueOf(i.b(XK)));
            if (i.b(XK)) {
                a((Object) aVar, bc, XK);
                AppMethodBeat.o(36181);
                return true;
            }
            if ((aVar instanceof ImageView) || (aVar instanceof QFadeImageView)) {
                dA((View) aVar);
            } else if (aVar instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                aVar.bf(null, !this.qHJ);
                aVar.setPosition(0);
                aVar.setThumbBmp(null);
            }
            if (this.qIp.contains(bc)) {
                AppMethodBeat.o(36181);
                return false;
            }
            a(1, bau, azVar);
            AppMethodBeat.o(36181);
            return false;
        }
        if (!str.equals(aVar.getVideoPath())) {
            aVar.setThumbBmp(z2 ? BitmapFactory.decodeFile(fZ + e) : null);
        }
        aVar.bf(str, !this.qHJ);
        aVar.setPosition(i2);
        AppMethodBeat.o(36181);
        return true;
    }

    public final boolean b(bau bau, View view, int i, int i2, az azVar) {
        AppMethodBeat.i(36183);
        boolean a = a(bau, view, i, i2, azVar, 1);
        AppMethodBeat.o(36183);
        return a;
    }

    public final boolean a(bau bau, View view, int i, int i2, az azVar, int i3) {
        AppMethodBeat.i(36184);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36184);
            return false;
        }
        String bc = i.bc(i3, bau.Id);
        a((Object) view, bc, i, i2);
        n XK = XK(bc);
        boolean b = i.b(XK);
        ab.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b + " " + bc);
        if (b) {
            a((Object) view, bc, XK);
            AppMethodBeat.o(36184);
            return true;
        }
        if (i == -1) {
            dA(view);
        }
        if (this.qIp.contains(bc)) {
            AppMethodBeat.o(36184);
            return true;
        }
        a(i3, bau, azVar);
        AppMethodBeat.o(36184);
        return false;
    }

    private static void dA(View view) {
        AppMethodBeat.i(36185);
        if (view instanceof QImageView) {
            ((QImageView) view).setImageResource(R.drawable.b66);
            AppMethodBeat.o(36185);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(R.drawable.b66);
            AppMethodBeat.o(36185);
        } else {
            AppMethodBeat.o(36185);
        }
    }

    private void a(View view, String str, int i, a aVar) {
        AppMethodBeat.i(36186);
        a((Object) view, str, true, -1, i, -1, -1, aVar);
        AppMethodBeat.o(36186);
    }

    private void a(Object obj, String str, int i, int i2) {
        AppMethodBeat.i(36187);
        a(obj, str, true, i, i2, -1, -1, a.IMG_SCENE_NONE);
        AppMethodBeat.o(36187);
    }

    private void a(Object obj, String str, int i, int i2, a aVar) {
        AppMethodBeat.i(36188);
        a(obj, str, true, i, i2, -1, -1, aVar);
        AppMethodBeat.o(36188);
    }

    private void a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, a aVar) {
        AppMethodBeat.i(36189);
        if (obj == null) {
            AppMethodBeat.o(36189);
            return;
        }
        int hashCode = obj.hashCode();
        this.qIb.remove(new c(null, hashCode, 0, false));
        c cVar = new c(str, hashCode, i2, z);
        this.qIb.add(cVar);
        LinkedList linkedList = (LinkedList) this.qHX.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.qHX.put(str, linkedList);
        }
        linkedList.add(new WeakReference(cVar));
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
                    c cVar2 = (c) ((WeakReference) linkedList2.get(i5)).get();
                    if (cVar2 != null && cVar2.code == hashCode) {
                        break;
                    }
                    i6 = i5 + 1;
                }
                if (i5 != -1) {
                    ab.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", str2);
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
                ((ImageView) obj).setImageDrawable(com.tencent.mm.bz.a.g(((ImageView) obj).getContext(), i));
            } else {
                ((com.tencent.mm.plugin.sight.decode.a.a) obj).bf(null, !this.qHJ);
            }
        }
        if (aVar == a.IMG_SCENE_SNSSUSER && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
            com.tencent.mm.sdk.platformtools.n.ci((View) obj);
            AppMethodBeat.o(36189);
            return;
        }
        if (str != null && str.startsWith(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
            com.tencent.mm.sdk.platformtools.n.w((View) obj, i3, i4);
            ab.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
        }
        AppMethodBeat.o(36189);
    }

    public final boolean dB(View view) {
        AppMethodBeat.i(36190);
        int hashCode = view.hashCode();
        Iterator it = this.qIb.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (hashCode == cVar.code) {
                this.qIb.remove(cVar);
                break;
            }
        }
        this.fEk.remove(Integer.valueOf(hashCode));
        AppMethodBeat.o(36190);
        return true;
    }

    private boolean a(final List<bau> list, final az azVar) {
        AppMethodBeat.i(36191);
        af.cns().execute(new Runnable() {
            final /* synthetic */ int qIt = 0;

            public final void run() {
                AppMethodBeat.i(36142);
                long yz = bo.yz();
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(list);
                eVar.nQB = i.dc(list);
                eVar.qFQ = this.qIt;
                int i = 0;
                int i2 = 1;
                while (i < list.size() && i < 4) {
                    bau bau = (bau) list.get(i);
                    if (af.cnA().XD(bau.Id)) {
                        i2 = 0;
                    } else if (!(e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau)) || e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau)) || e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.m(bau)))) {
                        b cnA = af.cnA();
                        if (bau.jCt == 6) {
                            i2 = 5;
                        } else {
                            i2 = 1;
                        }
                        cnA.a(bau, i2, eVar, azVar);
                        i2 = 0;
                    }
                    i++;
                }
                long az = bo.az(yz);
                if (az > 100) {
                    ab.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + az + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.eSl + " " + af.cnR() + " " + eVar.nQB);
                }
                if (bo.az(g.this.qHT) > 60000) {
                    h.pYm.e(11696, Integer.valueOf(1), Long.valueOf(az), Integer.valueOf(0), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
                    g.this.qHT = bo.yz();
                }
                final String dc = i.dc(list);
                if (i2 != 0) {
                    af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(36141);
                            new i(i.bc(0, dc), dc, list).u("");
                            AppMethodBeat.o(36141);
                        }
                    });
                }
                AppMethodBeat.o(36142);
            }
        });
        AppMethodBeat.o(36191);
        return true;
    }

    private boolean cmW() {
        AppMethodBeat.i(36192);
        if (this.qIa) {
            ab.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            AppMethodBeat.o(36192);
            return false;
        }
        af.bCo().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36143);
                if (g.this.qIa) {
                    ab.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
                    AppMethodBeat.o(36143);
                    return;
                }
                if (g.this.qHZ.size() > 0) {
                    ab.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.this.qHZ.size());
                    ((b) g.this.qHZ.removeLast()).u("");
                }
                AppMethodBeat.o(36143);
            }
        }, 0);
        AppMethodBeat.o(36192);
        return true;
    }

    private boolean a(final int i, final bau bau, final az azVar) {
        AppMethodBeat.i(36193);
        if (this.qHJ) {
            af.cns().execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36145);
                    if (!g.a(g.this, i, bau)) {
                        com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(bau);
                        eVar.qFQ = i;
                        eVar.nQB = bau.Id;
                        af.cnA().a(bau, bau.jCt == 6 ? 5 : 1, eVar, azVar);
                    }
                    AppMethodBeat.o(36145);
                }
            });
            AppMethodBeat.o(36193);
            return true;
        }
        if (!(bau == null || bo.isNullOrNil(bau.Id))) {
            af.cnA().XH(bau.Id);
        }
        AppMethodBeat.o(36193);
        return false;
    }

    public static boolean t(bau bau) {
        AppMethodBeat.i(36194);
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        if (e.ct(fZ + i.j(bau))) {
            AppMethodBeat.o(36194);
            return true;
        } else if (e.ct(fZ + i.p(bau)) && !bo.isNullOrNil(bau.Id) && bau.Id.startsWith("Locall_path")) {
            AppMethodBeat.o(36194);
            return true;
        } else {
            AppMethodBeat.o(36194);
            return false;
        }
    }

    public final int n(com.tencent.mm.plugin.sns.storage.n nVar) {
        AppMethodBeat.i(36195);
        int a = a(nVar, null);
        AppMethodBeat.o(36195);
        return a;
    }

    public final int a(com.tencent.mm.plugin.sns.storage.n nVar, int[] iArr) {
        int i;
        int i2 = 5;
        AppMethodBeat.i(36196);
        if (iArr != null || bo.az(this.qIf) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            com.tencent.mm.modelcontrol.c.afC();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2, pInt3)) {
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
            this.qIf = bo.yz();
        }
        if (this.qIi == 0 || nVar == null) {
            i = this.qIh;
            AppMethodBeat.o(36196);
            return i;
        } else if (this.qIj.containsKey(Long.valueOf(nVar.field_snsId))) {
            i = ((Integer) this.qIj.get(Long.valueOf(nVar.field_snsId))).intValue();
            AppMethodBeat.o(36196);
            return i;
        } else {
            cbn cbn = new cbn();
            try {
                cbf cbf = (cbf) new cbf().parseFrom(nVar.field_attrBuf);
                if (cbf.xaD == null) {
                    i = this.qIh;
                    AppMethodBeat.o(36196);
                    return i;
                }
                cbn.parseFrom(cbf.xaD.getBufferToBytes());
                if (cbn.xaS == null || cbn.xaS.info == null) {
                    i = this.qIh;
                    AppMethodBeat.o(36196);
                    return i;
                }
                String str = cbn.xaS.info;
                int hashCode = str.hashCode();
                if (this.qIi == 1) {
                    if (!this.qIl.containsKey(Integer.valueOf(hashCode))) {
                        this.qIl.put(Integer.valueOf(hashCode), Boolean.valueOf(cX(str, this.qIi)));
                    }
                    i = ((Boolean) this.qIl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
                } else {
                    if (!this.qIk.containsKey(Integer.valueOf(hashCode))) {
                        this.qIk.put(Integer.valueOf(hashCode), Boolean.valueOf(cX(str, this.qIi)));
                    }
                    if (!((Boolean) this.qIk.get(Integer.valueOf(hashCode))).booleanValue()) {
                        i2 = 10;
                    }
                    i = i2;
                }
                ab.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
                this.qIj.put(Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
                AppMethodBeat.o(36196);
                return i;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
                i = this.qIh;
                AppMethodBeat.o(36196);
                return i;
            }
        }
    }

    public final int o(com.tencent.mm.plugin.sns.storage.n nVar) {
        AppMethodBeat.i(139038);
        int b = b(nVar, null);
        AppMethodBeat.o(139038);
        return b;
    }

    public final int b(com.tencent.mm.plugin.sns.storage.n nVar, int[] iArr) {
        int i;
        int i2 = 5;
        AppMethodBeat.i(36198);
        if (iArr != null || bo.az(this.qIg) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            com.tencent.mm.modelcontrol.c.afC();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2)) {
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
            this.qIg = bo.yz();
        }
        if (this.qIn == 0 || nVar == null) {
            i = this.qIm;
            AppMethodBeat.o(36198);
            return i;
        } else if (this.qIo.containsKey(Long.valueOf(nVar.field_snsId))) {
            i = ((Integer) this.qIo.get(Long.valueOf(nVar.field_snsId))).intValue();
            AppMethodBeat.o(36198);
            return i;
        } else {
            cbn cbn = new cbn();
            try {
                cbf cbf = (cbf) new cbf().parseFrom(nVar.field_attrBuf);
                if (cbf.xaD == null) {
                    i = this.qIm;
                    AppMethodBeat.o(36198);
                    return i;
                }
                cbn.parseFrom(cbf.xaD.getBufferToBytes());
                if (cbn.xaS == null || cbn.xaS.info == null) {
                    i = this.qIh;
                    AppMethodBeat.o(36198);
                    return i;
                }
                String str = cbn.xaS.info;
                int hashCode = str.hashCode();
                if (this.qIn == 1) {
                    if (!this.qIl.containsKey(Integer.valueOf(hashCode))) {
                        this.qIl.put(Integer.valueOf(hashCode), Boolean.valueOf(cX(str, this.qIn)));
                    }
                    i = ((Boolean) this.qIl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
                } else {
                    if (!this.qIk.containsKey(Integer.valueOf(hashCode))) {
                        this.qIk.put(Integer.valueOf(hashCode), Boolean.valueOf(cX(str, this.qIn)));
                    }
                    if (!((Boolean) this.qIk.get(Integer.valueOf(hashCode))).booleanValue()) {
                        i2 = 10;
                    }
                    i = i2;
                }
                ab.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
                this.qIo.put(Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
                AppMethodBeat.o(36198);
                return i;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
                i = this.qIm;
                AppMethodBeat.o(36198);
                return i;
            }
        }
    }

    private static boolean cX(String str, int i) {
        AppMethodBeat.i(36199);
        Map z = br.z(str, "SightDownloadControl");
        if (z == null || z.isEmpty()) {
            AppMethodBeat.o(36199);
            return true;
        } else if (i == 1) {
            if (bo.getInt((String) z.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1) {
                AppMethodBeat.o(36199);
                return true;
            }
            AppMethodBeat.o(36199);
            return false;
        } else if (bo.getInt((String) z.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1) {
            AppMethodBeat.o(36199);
            return true;
        } else {
            AppMethodBeat.o(36199);
            return false;
        }
    }

    public final boolean u(bau bau) {
        AppMethodBeat.i(36200);
        if (!this.qIc.containsKey(bau.Id)) {
            AppMethodBeat.o(36200);
            return false;
        } else if (((Integer) this.qIc.get(bau.Id)).intValue() == 1) {
            AppMethodBeat.o(36200);
            return true;
        } else {
            AppMethodBeat.o(36200);
            return false;
        }
    }

    public final boolean v(bau bau) {
        AppMethodBeat.i(36201);
        if (!this.qIc.containsKey(bau.Id)) {
            AppMethodBeat.o(36201);
            return false;
        } else if (((Integer) this.qIc.get(bau.Id)).intValue() == 2) {
            AppMethodBeat.o(36201);
            return true;
        } else {
            AppMethodBeat.o(36201);
            return false;
        }
    }

    public final boolean w(bau bau) {
        AppMethodBeat.i(36202);
        if (!this.qIc.containsKey(bau.Id)) {
            AppMethodBeat.o(36202);
            return false;
        } else if (((Integer) this.qIc.get(bau.Id)).intValue() == 3) {
            AppMethodBeat.o(36202);
            return true;
        } else {
            AppMethodBeat.o(36202);
            return false;
        }
    }

    public final boolean x(bau bau) {
        AppMethodBeat.i(36203);
        if (!this.qIc.containsKey(bau.Id)) {
            AppMethodBeat.o(36203);
            return false;
        } else if (((Integer) this.qIc.get(bau.Id)).intValue() == 4) {
            AppMethodBeat.o(36203);
            return true;
        } else {
            AppMethodBeat.o(36203);
            return false;
        }
    }

    public final void y(bau bau) {
        AppMethodBeat.i(36204);
        this.qIc.put(bau.Id, Integer.valueOf(1));
        AppMethodBeat.o(36204);
    }

    public final void z(bau bau) {
        AppMethodBeat.i(36205);
        this.qIc.put(bau.Id, Integer.valueOf(2));
        AppMethodBeat.o(36205);
    }

    public final void A(bau bau) {
        AppMethodBeat.i(36206);
        this.qIc.put(bau.Id, Integer.valueOf(3));
        AppMethodBeat.o(36206);
    }

    private String a(com.tencent.mm.plugin.sns.storage.n nVar, final bau bau, final az azVar, boolean z) {
        AppMethodBeat.i(36207);
        String str;
        if (u(bau)) {
            str = "";
            AppMethodBeat.o(36207);
            return str;
        }
        str = an.fZ(af.getAccSnsPath(), bau.Id);
        String j = i.j(bau);
        if (e.ct(str + j)) {
            str = str + j;
            AppMethodBeat.o(36207);
            return str;
        } else if (e.ct(str + i.p(bau)) && bau.Id != null && bau.Id.startsWith("Locall_path")) {
            str = str + i.p(bau);
            AppMethodBeat.o(36207);
            return str;
        } else if (this.qHJ) {
            ab.i("MicroMsg.LazyerImageLoader2", "push sight loader " + bau.Id + " url: " + bau.Url);
            if (!z) {
                ab.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
            } else if (b(nVar, null) == 5) {
                af.bCo().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36146);
                        af.cnA().a(bau, 4, null, azVar);
                        AppMethodBeat.o(36146);
                    }
                }, 0);
            }
            str = "";
            AppMethodBeat.o(36207);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(36207);
            return str;
        }
    }

    public final boolean a(String str, n nVar, int i) {
        AppMethodBeat.i(36209);
        a(i + "-" + str, nVar);
        AppMethodBeat.o(36209);
        return true;
    }

    private boolean a(String str, n nVar) {
        AppMethodBeat.i(36210);
        if (!(nVar == null || str == null)) {
            this.qHV.put(str, (Object) nVar);
        }
        AppMethodBeat.o(36210);
        return true;
    }

    public final void XM(String str) {
        AppMethodBeat.i(36212);
        b(str, null);
        AppMethodBeat.o(36212);
    }

    public final n XN(String str) {
        AppMethodBeat.i(36213);
        if (this.qHV == null) {
            AppMethodBeat.o(36213);
            return null;
        }
        n nVar = (n) this.qHV.get("0-".concat(String.valueOf(str)));
        AppMethodBeat.o(36213);
        return nVar;
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, az azVar) {
        AppMethodBeat.i(36214);
        if (z || !bo.isNullOrNil(str)) {
            bau a = com.tencent.mm.modelsns.e.a(str3, 2, str2, str2, 1, 1, "");
            i.bc(2, str3);
            Bitmap Xj;
            if (str3.equals("")) {
                Xj = i.Xj(str);
                if (i.B(Xj)) {
                    AppMethodBeat.o(36214);
                    return Xj;
                }
                AppMethodBeat.o(36214);
                return null;
            } else if (i.B(null)) {
                AppMethodBeat.o(36214);
                return null;
            } else {
                Xj = i.Xj(an.fZ(af.getAccSnsPath(), str3) + i.l(a));
                if (!i.B(Xj)) {
                    Xj = i.Xj(str);
                }
                if (Xj == null && z && !bo.isNullOrNil(str2)) {
                    af.cnA().a(a, 3, null, azVar);
                }
                if (i.B(Xj)) {
                    AppMethodBeat.o(36214);
                    return Xj;
                }
                AppMethodBeat.o(36214);
                return null;
            }
        }
        AppMethodBeat.o(36214);
        return null;
    }

    public final boolean B(bau bau) {
        AppMethodBeat.i(36215);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36215);
            return false;
        } else if (e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.f(bau))) {
            AppMethodBeat.o(36215);
            return true;
        } else if (e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau))) {
            AppMethodBeat.o(36215);
            return true;
        } else {
            boolean b = i.b((n) this.qHV.get(i.bc(1, bau.Id)));
            AppMethodBeat.o(36215);
            return b;
        }
    }

    public static boolean a(bau bau, az azVar, boolean z) {
        AppMethodBeat.i(36216);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36216);
            return false;
        }
        String str;
        if (bau.Id.startsWith("Locall_path")) {
            str = an.fZ(af.getAccSnsPath(), bau.Id) + i.m(bau);
        } else {
            str = an.fZ(af.getAccSnsPath(), bau.Id) + i.d(bau);
        }
        if (e.ct(str)) {
            AppMethodBeat.o(36216);
            return true;
        }
        af.cnA().a(bau, z ? 8 : 2, null, azVar);
        AppMethodBeat.o(36216);
        return false;
    }

    public static String C(bau bau) {
        AppMethodBeat.i(36217);
        if (bau == null) {
            AppMethodBeat.o(36217);
            return null;
        }
        String str;
        if (bau.Id.startsWith("pre_temp_sns_pic")) {
            str = af.getAccSnsTmpPath() + bau.Id;
        } else if (bau.Id.startsWith("Locall_path")) {
            str = an.fZ(af.getAccSnsPath(), bau.Id) + i.m(bau);
        } else if (bau.Id.startsWith("pre_temp_extend_pic")) {
            str = bau.Id.substring(19);
        } else {
            str = an.fZ(af.getAccSnsPath(), bau.Id) + i.d(bau);
        }
        AppMethodBeat.o(36217);
        return str;
    }

    public final Bitmap a(bau bau, View view, int i, boolean z, az azVar, boolean z2) {
        AppMethodBeat.i(36218);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36218);
            return null;
        }
        String bc = i.bc(3, bau.Id);
        String C = C(bau);
        int i2 = -1;
        int i3 = -1;
        try {
            Options amj = d.amj(C);
            i2 = amj.outWidth;
            i3 = amj.outHeight;
        } catch (Exception e) {
        }
        a((Object) view, bc, false, -1, i, i2, i3, a.IMG_SCENE_NONE);
        if (af.cnA().XE(bau.Id)) {
            AppMethodBeat.o(36218);
            return null;
        }
        Object obj;
        Bitmap bitmap;
        al alVar = this.qHW;
        com.tencent.mm.plugin.sns.model.al.b bVar = (com.tencent.mm.plugin.sns.model.al.b) alVar.qMs.get(bc);
        if (bVar == null) {
            obj = null;
        } else {
            ((com.tencent.mm.plugin.sns.model.al.b) alVar.qMs.get(bc)).cob();
            obj = bVar.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        ab.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + bc + "  " + (weakReference == null));
        if (weakReference == null) {
            bitmap = null;
        } else {
            bitmap = (Bitmap) weakReference.get();
        }
        if (i.B(bitmap)) {
            AppMethodBeat.o(36218);
            return bitmap;
        }
        Bitmap Zk;
        if (bau.Id.startsWith("pre_temp_extend_pic")) {
            Zk = s.Zk(C);
        } else {
            Zk = i.Xj(C);
        }
        al alVar2 = this.qHW;
        WeakReference weakReference2 = new WeakReference(Zk);
        if (((com.tencent.mm.plugin.sns.model.al.b) alVar2.qMs.get(bc)) == null) {
            alVar2.qMs.put(bc, new com.tencent.mm.plugin.sns.model.al.b(weakReference2));
            alVar2.coa();
        } else {
            ((com.tencent.mm.plugin.sns.model.al.b) alVar2.qMs.get(bc)).cob();
            ((com.tencent.mm.plugin.sns.model.al.b) alVar2.qMs.get(bc)).obj = weakReference2;
        }
        if (i.B(Zk)) {
            AppMethodBeat.o(36218);
            return Zk;
        }
        if (z) {
            af.cnA().a(bau, z2 ? 8 : 2, null, azVar);
        }
        AppMethodBeat.o(36218);
        return null;
    }

    public final n a(bau bau, ImageView imageView, int i, az azVar) {
        AppMethodBeat.i(36219);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36219);
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String bc = i.bc(0, bau.Id);
        a((Object) imageView, bc, -1, i);
        n XK = XK(bc);
        if (i.b(XK)) {
            AppMethodBeat.o(36219);
            return XK;
        }
        a(0, bau, azVar);
        AppMethodBeat.o(36219);
        return null;
    }

    public final void a(List<bau> list, View view, int i, a aVar, az azVar) {
        AppMethodBeat.i(36221);
        a((List) list, view, i, aVar, azVar, false);
        AppMethodBeat.o(36221);
    }

    public final void a(List<bau> list, View view, int i, a aVar, az azVar, boolean z) {
        AppMethodBeat.i(36222);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(36222);
        } else if (list.size() != 1) {
            String bc = i.bc(0, i.dc(list));
            a(view, bc, i, aVar);
            n XK = XK(bc);
            boolean b = i.b(XK);
            ab.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(b)));
            if (b) {
                a((Object) view, bc, XK);
                AppMethodBeat.o(36222);
                return;
            }
            dA(view);
            if (this.qIp.contains(bc)) {
                AppMethodBeat.o(36222);
                return;
            }
            WeakReference weakReference = new WeakReference(view);
            a((List) list, azVar);
            AppMethodBeat.o(36222);
        } else if (z) {
            b((bau) list.get(0), view, i, a.IMG_SCENE_SNSSUSER, azVar);
            AppMethodBeat.o(36222);
        } else {
            b((bau) list.get(0), view, i, azVar);
            AppMethodBeat.o(36222);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(String str, n nVar) {
        AppMethodBeat.i(36223);
        if (!i.b(nVar)) {
            nVar = XL(str);
        }
        if (i.b(nVar)) {
            if (!(this.qHV == null || nVar == null || str == null)) {
                this.qHV.put(str, (Object) nVar);
            }
            LinkedList linkedList = (LinkedList) this.qHX.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((WeakReference) it.next()).get();
                    if (cVar != null && cVar.qIK && str != null && str.equals(cVar.id)) {
                        WeakReference weakReference = (WeakReference) this.fEk.get(Integer.valueOf(cVar.code));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.qIe != null && (qFadeImageView instanceof TagImageView)) {
                                        int position = ((TagImageView) qFadeImageView).getPosition();
                                        if (!(position == -1 || this.qIe.DQ(position))) {
                                        }
                                    }
                                }
                                if (!i.b(nVar) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(nVar == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(i.b(nVar));
                                    ab.d(str2, str3, objArr);
                                } else {
                                    a(obj, str, nVar);
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(36223);
    }

    public final void cmm() {
        AppMethodBeat.i(36224);
        cmV();
        this.qIf = 0;
        this.qIg = 0;
        this.qHZ.clear();
        this.qIa = false;
        AppMethodBeat.o(36224);
    }

    public final void c(bau bau, View view, int i, az azVar) {
        AppMethodBeat.i(36182);
        if (bau == null || bau.Id == null || bau.Id.equals("")) {
            AppMethodBeat.o(36182);
            return;
        }
        String bc = i.bc(4, bau.Id);
        a((Object) view, bc, -1, i);
        n XK = XK(bc);
        boolean b = i.b(XK);
        ab.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(b)));
        if (b) {
            a((Object) view, bc, XK);
        } else {
            dA(view);
            if (!this.qIp.contains(bc)) {
                a(4, bau, azVar);
                AppMethodBeat.o(36182);
                return;
            }
        }
        AppMethodBeat.o(36182);
    }

    public final boolean fX(String str, String str2) {
        AppMethodBeat.i(36208);
        if (this.qIc.containsKey(str) && 3 == ((Integer) this.qIc.get(str)).intValue()) {
            this.qIc.remove(str);
        }
        String bc = i.bc(1, str);
        LinkedList linkedList = (LinkedList) this.qHX.get(bc);
        if (linkedList == null) {
            AppMethodBeat.o(36208);
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && cVar.qIK && bc != null && bc.equals(cVar.id)) {
                WeakReference weakReference = (WeakReference) this.fEk.get(Integer.valueOf(cVar.code));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        ab.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", str, str2);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.getTagObject() instanceof aj) {
                            aj ajVar = (aj) aVar.getTagObject();
                            if (ajVar == null) {
                                aVar.bf(str2, !this.qHJ);
                            } else if (e.ct(str2)) {
                                aVar.bf(str2, !this.qHJ);
                                aVar.setPosition(ajVar.position);
                                ajVar.rnu.setVisibility(8);
                                ajVar.raP.setVisibility(8);
                                ajVar.raQ.setVisibility(8);
                                if (this.qIc.containsKey(str) && 4 == ((Integer) this.qIc.get(str)).intValue()) {
                                    this.qIc.remove(str);
                                }
                            } else {
                                this.qIc.put(str, Integer.valueOf(4));
                                ajVar.rnu.setVisibility(8);
                                ajVar.raP.setImageResource(R.drawable.atu);
                                ajVar.raP.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(36208);
        return true;
    }

    public final boolean a(com.tencent.mm.plugin.sns.data.e eVar, String str) {
        bau bau;
        String f;
        AppMethodBeat.i(36211);
        bau bau2 = (bau) eVar.list.get(0);
        for (int i = 1; i < eVar.list.size(); i++) {
            bau bau3 = (bau) eVar.list.get(i);
            if (str != null && str.indexOf(bau3.Id) >= 0) {
                bau = bau3;
                break;
            }
        }
        bau = bau2;
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        if (eVar.qFQ == 0) {
            f = i.f(bau);
        } else if (eVar.qFQ == 4) {
            f = i.g(bau);
        } else if (eVar.qFQ == 5) {
            f = i.g(bau);
        } else if (eVar.qFQ == 3) {
            f = i.l(bau);
        } else {
            f = i.e(bau);
        }
        if (!this.qHV.aj(i.bc(eVar.qFQ, bau.Id))) {
            new b(i.bc(eVar.qFQ, bau.Id), fZ + f, fZ, bau, eVar.qFQ).u("");
        }
        AppMethodBeat.o(36211);
        return true;
    }

    public final void a(View view, int i, int i2, int i3) {
        AppMethodBeat.i(36220);
        a((Object) view, null, true, -1, i3, -1, -1, a.IMG_SCENE_NONE);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
                AppMethodBeat.o(36220);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.bz.a.g(view.getContext(), i2));
                AppMethodBeat.o(36220);
                return;
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(R.drawable.b66);
            AppMethodBeat.o(36220);
            return;
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(R.drawable.b66);
        }
        AppMethodBeat.o(36220);
    }
}
