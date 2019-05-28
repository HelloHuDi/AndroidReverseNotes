package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class f<K, T extends com.tencent.mm.cd.a.a> extends BaseAdapter {
    public String TAG;
    public Context context;
    private HashMap<K, b<K, T>> events;
    private int nLf;
    private int pageSize;
    private e ygA;
    public K ygB;
    protected boolean ygr;
    protected c ygs;
    protected a ygt;
    public int ygu;
    public int ygv;
    public boolean ygw;
    int ygx;
    private boolean ygy;
    private boolean ygz;

    public static class b<K, T> {
        public K object;
        public int ygE;
        public T ygF = null;

        public b(K k, int i) {
            this.object = k;
            this.ygE = i;
        }

        public final int hashCode() {
            int i;
            AppMethodBeat.i(29173);
            int i2 = (this.ygE + 31) * 31;
            if (this.object == null) {
                i = 0;
            } else {
                i = this.object.hashCode();
            }
            i += i2;
            AppMethodBeat.o(29173);
            return i;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(29174);
            if (this == obj) {
                AppMethodBeat.o(29174);
                return true;
            } else if (obj == null) {
                AppMethodBeat.o(29174);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.o(29174);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.ygE != bVar.ygE) {
                    AppMethodBeat.o(29174);
                    return false;
                }
                if (this.object == null) {
                    if (bVar.object != null) {
                        AppMethodBeat.o(29174);
                        return false;
                    }
                } else if (!this.object.equals(bVar.object)) {
                    AppMethodBeat.o(29174);
                    return false;
                }
                AppMethodBeat.o(29174);
                return true;
            }
        }
    }

    public interface a {
        void apt();

        void dwH();
    }

    interface d {
        void dwG();
    }

    class c extends g<K, T> {
        public c(com.tencent.mm.cd.a.d<K> dVar) {
            super(dVar, f.this.pageSize);
            AppMethodBeat.i(29175);
            AppMethodBeat.o(29175);
        }

        public final T dvB() {
            AppMethodBeat.i(29176);
            com.tencent.mm.cd.a.a dvz = f.this.dvz();
            AppMethodBeat.o(29176);
            return dvz;
        }

        public final ArrayList<T> ao(ArrayList arrayList) {
            AppMethodBeat.i(29177);
            ArrayList ao = f.this.ao(arrayList);
            AppMethodBeat.o(29177);
            return ao;
        }
    }

    class e {
        com.tencent.mm.ui.f$e.b ygG;
        private com.tencent.mm.ui.f$e.c ygH;
        LinkedList<Integer> ygI;
        int ygJ;

        class a {
            int ygK;

            public a(int i) {
                this.ygK = i;
            }
        }

        class c extends ak {
            long lastUpdateTime;
            long ygP;
            final int ygQ = (hashCode() | 1910);
            final int ygR = (hashCode() | 1914);

            public c(Looper looper) {
                super(looper);
                AppMethodBeat.i(29179);
                e.this.ygI = new LinkedList();
                AppMethodBeat.o(29179);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(29180);
                super.handleMessage(message);
                if (message.what == this.ygR) {
                    removeMessages(this.ygQ);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.ygP > ((long) f.this.ygu) || currentTimeMillis - this.ygP < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) f.this.ygv)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        e.a(e.this);
                    } else {
                        sendEmptyMessageDelayed(this.ygQ, (long) f.this.ygu);
                    }
                    this.ygP = currentTimeMillis;
                    AppMethodBeat.o(29180);
                    return;
                }
                if (message.what == this.ygQ) {
                    e.a(e.this);
                }
                AppMethodBeat.o(29180);
            }
        }

        class b extends ak {
            boolean ygM;
            public final int ygN = 1;
            public final int ygO = 2;

            public b(Looper looper) {
                super(looper);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(29178);
                super.handleMessage(message);
                if (this.ygM) {
                    AppMethodBeat.o(29178);
                    return;
                }
                synchronized (e.this) {
                    try {
                        e.this.ygJ = e.this.dwL();
                        ab.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(e.this.ygJ));
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(29178);
                    }
                }
                if (message.what == 1) {
                    f.this.dwF();
                    return;
                }
                if (message.what == 2) {
                    f.this.a((c) message.obj, false, true);
                }
                AppMethodBeat.o(29178);
            }
        }

        public e() {
            AppMethodBeat.i(29181);
            dwI();
            AppMethodBeat.o(29181);
        }

        private void dwI() {
            AppMethodBeat.i(29182);
            this.ygG = new b(Looper.getMainLooper());
            this.ygH = new c(aw.RS().oAl.getLooper());
            AppMethodBeat.o(29182);
        }

        private void dwJ() {
            AppMethodBeat.i(29183);
            c cVar = this.ygH;
            cVar.removeMessages(cVar.ygQ);
            cVar.removeMessages(cVar.ygR);
            b bVar = this.ygG;
            bVar.ygM = true;
            bVar.removeMessages(1);
            bVar.removeMessages(2);
            this.ygI.clear();
            this.ygJ = 0;
            AppMethodBeat.o(29183);
        }

        public final synchronized void dwK() {
            AppMethodBeat.i(29184);
            ab.i(f.this.TAG, "newcursor resetQueue ");
            dwJ();
            dwI();
            AppMethodBeat.o(29184);
        }

        public final synchronized void quit() {
            AppMethodBeat.i(29185);
            ab.i(f.this.TAG, "newcursor quit ");
            dwJ();
            AppMethodBeat.o(29185);
        }

        /* Access modifiers changed, original: final */
        public final int dwL() {
            int i = 0;
            AppMethodBeat.i(29186);
            if (this.ygI.size() > 1) {
                i = 2;
            } else if (this.ygI.size() == 1) {
                i = ((Integer) this.ygI.get(0)).intValue();
            }
            AppMethodBeat.o(29186);
            return i;
        }

        public final synchronized boolean dwM() {
            return this.ygJ != 0;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void dwN() {
            AppMethodBeat.i(29187);
            this.ygH.lastUpdateTime = System.currentTimeMillis();
            AppMethodBeat.o(29187);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized int dwO() {
            return this.ygJ;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void MR(int i) {
            AppMethodBeat.i(29188);
            if (!this.ygI.contains(Integer.valueOf(i))) {
                this.ygI.add(Integer.valueOf(i));
            }
            this.ygJ = dwL();
            c cVar = this.ygH;
            cVar.sendEmptyMessage(cVar.ygR);
            AppMethodBeat.o(29188);
        }

        static /* synthetic */ void a(e eVar) {
            int dwL;
            AppMethodBeat.i(29189);
            synchronized (eVar) {
                try {
                    dwL = eVar.dwL();
                    eVar.ygI.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(29189);
                }
            }
            a aVar = new a(dwL);
            if (aVar.ygK == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = new c(f.this.dwz());
                dwL = cVar.getCount();
                ab.i(f.this.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(dwL));
                b bVar = e.this.ygG;
                Message obtain = Message.obtain();
                obtain.obj = cVar;
                obtain.what = 2;
                bVar.sendMessage(obtain);
                return;
            }
            e.this.ygG.sendEmptyMessage(1);
            AppMethodBeat.o(29189);
        }
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> ao(ArrayList<K> arrayList);

    public abstract T dvz();

    public abstract com.tencent.mm.cd.a.d<K> dwz();

    public final void a(a aVar) {
        this.ygt = aVar;
    }

    public final void dww() {
        this.ygt = null;
    }

    public f(Context context) {
        this(context, (byte) 0);
        this.pageSize = 5000;
        ab.i(this.TAG, "newCursor setPageSize %d", Integer.valueOf(5000));
    }

    private f(Context context, byte b) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.ygr = true;
        this.ygu = 1000;
        this.ygv = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        this.ygw = true;
        this.nLf = 0;
        this.ygx = 0;
        this.ygB = null;
        this.context = context;
        this.ygy = true;
    }

    private f(Context context, char c) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.ygr = true;
        this.ygu = 1000;
        this.ygv = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        this.ygw = true;
        this.nLf = 0;
        this.ygx = 0;
        this.ygB = null;
        this.context = context;
        this.ygy = true;
        this.ygz = false;
        this.ygu = 800;
        this.ygv = 2000;
    }

    public f(Context context, short s) {
        this(context, 0);
    }

    private void a(c cVar) {
        pB(false);
        this.ygs = cVar;
        this.ygs.getCount();
        dwx();
    }

    private void a(com.tencent.mm.cd.a.d<K> dVar) {
        pB(true);
        if (this.ygs == null || this.ygs.ycB != dVar) {
            if (!(this.ygs == null || this.ygs.isClosed())) {
                this.ygs.close();
                this.ygs = null;
            }
            this.ygs = new c(dVar);
            this.ygs.getCount();
            dwx();
            notifyDataSetChanged();
        }
    }

    private void dwx() {
        if (this.ygy) {
            int i = this.ygs.dvr() ? 1 : 2;
            if (!(i == this.ygx || this.ygx == 0)) {
                if (this.ygA != null && this.ygA.dwM()) {
                    a(new c(dwz()), true, false);
                }
                ab.i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i));
            }
            this.ygx = i;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean dvr() {
        if (this.ygs == null) {
            return false;
        }
        return this.ygs.dvr();
    }

    public int getCount() {
        if (this.ygs == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(dwz());
            ab.i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        cb("getcount", false);
        return this.ygs.getCount();
    }

    public final int dwy() {
        if (this.ygs == null) {
            return 0;
        }
        com.tencent.mm.cd.a.d dVar = this.ygs.ycB;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof com.tencent.mm.cd.a.e) {
            return ((com.tencent.mm.cd.a.e) dVar).ycs[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    private void cb(String str, boolean z) {
        if (!dwE() && (this.ygw | z) != 0) {
            if (!z) {
                ab.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.ygw), str, bo.dpG());
            }
            pA(false);
        }
    }

    /* renamed from: MG */
    public final T getItem(int i) {
        if (this.ygs == null) {
            a(dwz());
        }
        cb("getItem", false);
        this.ygs.ycB.moveToPosition(i);
        com.tencent.mm.cd.a.a MG = this.ygs.ycB.MG(i);
        if (MG != null) {
            MG.drw();
        } else {
            ab.e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i));
        }
        return MG;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T cL(K k) {
        if (this.ygs == null) {
            return null;
        }
        return this.ygs.ycB.cL(k);
    }

    public final SparseArray<K>[] dwA() {
        if (this.ygs == null) {
            return null;
        }
        SparseArray[] dvp = this.ygs.dvp();
        SparseArray<K>[] sparseArrayArr = new SparseArray[dvp.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < dvp[i].size(); i2++) {
                sparseArrayArr[i].put(i2, dvp[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void dwB() {
        this.events.clear();
        this.events.put(this.ygB, null);
    }

    public final void pA(boolean z) {
        if (this.ygz || z) {
            dwC();
        } else {
            int changeType = getChangeType();
            if (changeType == 0) {
                ab.i(this.TAG, "newcursor need not change ");
                return;
            }
            if (changeType == 2) {
                ab.i(this.TAG, "newcursor enqueueMessage resetcursor ");
                this.events.clear();
            }
            if (this.ygA == null) {
                this.ygA = new e();
            }
            this.ygA.MR(changeType);
        }
        this.nLf = 0;
    }

    private int getChangeType() {
        if (this.events == null || this.events.size() == 0) {
            return 0;
        }
        if (this.events.containsKey(this.ygB)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: Missing block: B:42:0x00c8, code skipped:
            r4.put(r10, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(K k, int i) {
        if (this.ygs != null) {
            int i2;
            boolean z;
            if (this.events == null) {
                this.events = new HashMap();
            }
            boolean containsKey = this.events.containsKey(this.ygB);
            if (i == 5 || !this.ygy || i == 1) {
                if (i != 5) {
                    dwB();
                } else if (!containsKey) {
                    this.events.put(k, new b(k, i));
                }
                ab.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", Integer.valueOf(i));
                i2 = 1;
            } else if (containsKey) {
                ab.i(this.TAG, "newcursor need reset ,return ");
                return;
            } else if (this.ygx != 1) {
                dwB();
                i2 = 0;
            } else if (this.ygs.cK(k) || i == 2) {
                HashMap hashMap = this.events;
                b bVar = new b(k, i);
                if (bVar.ygE == 2 && this.ygs.cK(bVar.object)) {
                    bVar.ygE = 3;
                }
                b bVar2 = (b) hashMap.get(k);
                if ((bVar2 != null ? 1 : 0) != 0) {
                    hashMap.remove(bVar2);
                    switch (bVar.ygE) {
                        case 2:
                            switch (bVar2.ygE) {
                                case 2:
                                    ab.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                                    bVar.ygE = 2;
                                    break;
                                case 5:
                                    bVar.ygE = 3;
                                    break;
                                default:
                                    ab.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                                    bVar.ygE = 2;
                                    break;
                            }
                        case 5:
                            switch (bVar2.ygE) {
                                case 2:
                                    break;
                                case 5:
                                    ab.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                                    bVar.ygE = 5;
                                    break;
                                default:
                                    bVar.ygE = 5;
                                    break;
                            }
                        default:
                            switch (bVar2.ygE) {
                                case 2:
                                    bVar.ygE = 2;
                                    break;
                                case 5:
                                    ab.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                                    break;
                            }
                            bVar.ygE = 3;
                            break;
                    }
                }
                hashMap.put(k, bVar);
                if (!this.ygs.ycB.MF(hashMap.size())) {
                    ab.i(this.TAG, "newcursor events size exceed limit :size is :  %d", Integer.valueOf(hashMap.size()));
                    hashMap.clear();
                    hashMap.put(this.ygB, null);
                }
                ab.i(this.TAG, "newcursor add event events size %d", Integer.valueOf(this.events.size()));
                i2 = 0;
            } else {
                ab.i(this.TAG, "newcursor event pass ");
                i2 = 0;
            }
            this.nLf = getChangeType();
            String str = this.TAG;
            String str2 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.nLf);
            if (this.ygx == 1) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(i);
            ab.i(str, str2, objArr);
            if (i2 != 0) {
                ab.i(this.TAG, "newcursor event is refresh sync ");
                pA(true);
            } else if (this.ygr && this.ygw) {
                pA(false);
            }
        }
    }

    /* JADX WARNING: Missing block: B:7:0x002f, code skipped:
            if (r1 != 2) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dwC() {
        if (dwD()) {
            int dwO;
            int changeType = getChangeType();
            if (this.ygA != null) {
                dwO = this.ygA.dwO();
                ab.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", Integer.valueOf(dwO));
                if (dwO != 0) {
                    this.ygA.dwK();
                }
            }
            dwO = changeType;
            ab.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", Integer.valueOf(dwO));
            this.nLf = 0;
            if (dwO == 2) {
                a(new c(dwz()), true, true);
            } else {
                dwF();
            }
        }
    }

    private boolean dwD() {
        return (this.ygA != null && this.ygA.dwM()) || getChangeType() != 0;
    }

    private boolean dwE() {
        if (this.nLf == 0) {
            return true;
        }
        return false;
    }

    public final void resume() {
        ab.i(this.TAG, "newcursor resume ");
        this.ygr = true;
        cb("resume", true);
    }

    public void pause() {
        this.ygr = false;
        ab.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ygt != null) {
            this.ygt.dwH();
        }
        dVar.dwG();
        notifyDataSetChanged();
        if (this.ygt != null) {
            this.ygt.apt();
        }
        if (this.ygA != null) {
            this.ygA.dwN();
        }
        ab.i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void dwF() {
        if (this.ygs == null || this.ygs.isClosed() || this.events.size() != 0) {
            a(new d() {
                public final void dwG() {
                    AppMethodBeat.i(29171);
                    if (f.a(f.this, f.this.events)) {
                        HashSet hashSet = new HashSet(f.this.events.size());
                        for (b bVar : f.this.events.values()) {
                            hashSet.add(bVar.object);
                        }
                        ab.i(f.this.TAG, "newcursor all event is delete");
                        f.this.ygs.c(hashSet.toArray(), null);
                    } else if (f.this.events.containsKey(f.this.ygB)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        f.this.a(new c(f.this.dwz()), true, false);
                        ab.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        SparseArray[] dwA = f.this.dwA();
                        SparseArray[] a = f.this.a(new HashSet(f.this.events.values()), dwA);
                        int length = dwA.length;
                        if (length > 1) {
                            for (int i = 0; i < length; i++) {
                                ab.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(dwA[i].size()), Integer.valueOf(a[i].size()));
                            }
                        } else {
                            ab.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(dwA[0].size()), Integer.valueOf(a[0].size()));
                        }
                        for (b bVar2 : f.this.events.values()) {
                            if (bVar2 != null) {
                                if (bVar2.ygF != null) {
                                    ab.i(f.this.TAG, "newcursor notify cache update : key : %s ", bVar2.object);
                                }
                                f.this.ygs.c(bVar2.object, (com.tencent.mm.cd.a.a) bVar2.ygF);
                            } else {
                                ab.e(f.this.TAG, "newcursor event is null ! ");
                            }
                        }
                        f.this.a(a);
                        ab.i(f.this.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(f.this.ygs.dvp()[0].size()));
                    }
                    f.this.events.clear();
                    AppMethodBeat.o(29171);
                }
            });
        } else {
            ab.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.ygA != null && this.ygA.dwM()) {
                this.ygA.dwK();
            }
            if (this.events != null) {
                this.events.clear();
            }
        }
        if (z2) {
            a(new d() {
                public final void dwG() {
                    AppMethodBeat.i(29172);
                    f.this.a(cVar);
                    AppMethodBeat.o(29172);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] dvp = this.ygs.dvp();
        for (int i = 0; i < dvp.length; i++) {
            dvp[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                dvp[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void pB(boolean z) {
        if (this.ygs != null) {
            this.ygs.close();
            this.ygs = null;
        }
        if (z && this.ygA != null) {
            this.ygA.quit();
            this.ygA = null;
            if (this.events != null) {
                this.events.clear();
                ab.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.nLf = 0;
        this.ygx = 0;
    }
}
