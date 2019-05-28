package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f$e.b;
import com.tencent.mm.ui.f$e.c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.p214a.C1351a;
import com.tencent.p177mm.p213cd.p214a.C1354d;
import com.tencent.p177mm.p213cd.p214a.C37629e;
import com.tencent.p177mm.p213cd.p214a.C37631g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.f */
public abstract class C40862f<K, T extends C1351a> extends BaseAdapter {
    public String TAG;
    public Context context;
    private HashMap<K, C15880b<K, T>> events;
    private int nLf;
    private int pageSize;
    private C40866e ygA;
    public K ygB;
    protected boolean ygr;
    protected C40865c ygs;
    protected C30702a ygt;
    public int ygu;
    public int ygv;
    public boolean ygw;
    int ygx;
    private boolean ygy;
    private boolean ygz;

    /* renamed from: com.tencent.mm.ui.f$b */
    public static class C15880b<K, T> {
        public K object;
        public int ygE;
        public T ygF = null;

        public C15880b(K k, int i) {
            this.object = k;
            this.ygE = i;
        }

        public final int hashCode() {
            int i;
            AppMethodBeat.m2504i(29173);
            int i2 = (this.ygE + 31) * 31;
            if (this.object == null) {
                i = 0;
            } else {
                i = this.object.hashCode();
            }
            i += i2;
            AppMethodBeat.m2505o(29173);
            return i;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(29174);
            if (this == obj) {
                AppMethodBeat.m2505o(29174);
                return true;
            } else if (obj == null) {
                AppMethodBeat.m2505o(29174);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(29174);
                return false;
            } else {
                C15880b c15880b = (C15880b) obj;
                if (this.ygE != c15880b.ygE) {
                    AppMethodBeat.m2505o(29174);
                    return false;
                }
                if (this.object == null) {
                    if (c15880b.object != null) {
                        AppMethodBeat.m2505o(29174);
                        return false;
                    }
                } else if (!this.object.equals(c15880b.object)) {
                    AppMethodBeat.m2505o(29174);
                    return false;
                }
                AppMethodBeat.m2505o(29174);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.f$a */
    public interface C30702a {
        void apt();

        void dwH();
    }

    /* renamed from: com.tencent.mm.ui.f$d */
    interface C40861d {
        void dwG();
    }

    /* renamed from: com.tencent.mm.ui.f$1 */
    class C408641 implements C40861d {
        C408641() {
        }

        public final void dwG() {
            AppMethodBeat.m2504i(29171);
            if (C40862f.m70802a(C40862f.this, C40862f.this.events)) {
                HashSet hashSet = new HashSet(C40862f.this.events.size());
                for (C15880b c15880b : C40862f.this.events.values()) {
                    hashSet.add(c15880b.object);
                }
                C4990ab.m7416i(C40862f.this.TAG, "newcursor all event is delete");
                C40862f.this.ygs.mo60457c(hashSet.toArray(), null);
            } else if (C40862f.this.events.containsKey(C40862f.this.ygB)) {
                long currentTimeMillis = System.currentTimeMillis();
                C40862f.this.m70798a(new C40865c(C40862f.this.dwz()), true, false);
                C4990ab.m7417i(C40862f.this.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                SparseArray[] dwA = C40862f.this.dwA();
                SparseArray[] a = C40862f.this.mo28033a(new HashSet(C40862f.this.events.values()), dwA);
                int length = dwA.length;
                if (length > 1) {
                    for (int i = 0; i < length; i++) {
                        C4990ab.m7417i(C40862f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(dwA[i].size()), Integer.valueOf(a[i].size()));
                    }
                } else {
                    C4990ab.m7417i(C40862f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(dwA[0].size()), Integer.valueOf(a[0].size()));
                }
                for (C15880b c15880b2 : C40862f.this.events.values()) {
                    if (c15880b2 != null) {
                        if (c15880b2.ygF != null) {
                            C4990ab.m7417i(C40862f.this.TAG, "newcursor notify cache update : key : %s ", c15880b2.object);
                        }
                        C40862f.this.ygs.mo60457c(c15880b2.object, (C1351a) c15880b2.ygF);
                    } else {
                        C4990ab.m7412e(C40862f.this.TAG, "newcursor event is null ! ");
                    }
                }
                C40862f.this.mo64392a(a);
                C4990ab.m7417i(C40862f.this.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(C40862f.this.ygs.dvp()[0].size()));
            }
            C40862f.this.events.clear();
            AppMethodBeat.m2505o(29171);
        }
    }

    /* renamed from: com.tencent.mm.ui.f$c */
    class C40865c extends C37631g<K, T> {
        public C40865c(C1354d<K> c1354d) {
            super(c1354d, C40862f.this.pageSize);
            AppMethodBeat.m2504i(29175);
            AppMethodBeat.m2505o(29175);
        }

        public final T dvB() {
            AppMethodBeat.m2504i(29176);
            C1351a dvz = C40862f.this.dvz();
            AppMethodBeat.m2505o(29176);
            return dvz;
        }

        /* renamed from: ao */
        public final ArrayList<T> mo60456ao(ArrayList arrayList) {
            AppMethodBeat.m2504i(29177);
            ArrayList ao = C40862f.this.mo28034ao(arrayList);
            AppMethodBeat.m2505o(29177);
            return ao;
        }
    }

    /* renamed from: com.tencent.mm.ui.f$e */
    class C40866e {
        b ygG;
        private c ygH;
        LinkedList<Integer> ygI;
        int ygJ;

        /* renamed from: com.tencent.mm.ui.f$e$a */
        class C15881a {
            int ygK;

            public C15881a(int i) {
                this.ygK = i;
            }
        }

        /* renamed from: com.tencent.mm.ui.f$e$c */
        class C40867c extends C7306ak {
            long lastUpdateTime;
            long ygP;
            final int ygQ = (hashCode() | 1910);
            final int ygR = (hashCode() | 1914);

            public C40867c(Looper looper) {
                super(looper);
                AppMethodBeat.m2504i(29179);
                C40866e.this.ygI = new LinkedList();
                AppMethodBeat.m2505o(29179);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(29180);
                super.handleMessage(message);
                if (message.what == this.ygR) {
                    removeMessages(this.ygQ);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.ygP > ((long) C40862f.this.ygu) || currentTimeMillis - this.ygP < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) C40862f.this.ygv)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        C40866e.m70817a(C40866e.this);
                    } else {
                        sendEmptyMessageDelayed(this.ygQ, (long) C40862f.this.ygu);
                    }
                    this.ygP = currentTimeMillis;
                    AppMethodBeat.m2505o(29180);
                    return;
                }
                if (message.what == this.ygQ) {
                    C40866e.m70817a(C40866e.this);
                }
                AppMethodBeat.m2505o(29180);
            }
        }

        /* renamed from: com.tencent.mm.ui.f$e$b */
        class C40868b extends C7306ak {
            boolean ygM;
            public final int ygN = 1;
            public final int ygO = 2;

            public C40868b(Looper looper) {
                super(looper);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(29178);
                super.handleMessage(message);
                if (this.ygM) {
                    AppMethodBeat.m2505o(29178);
                    return;
                }
                synchronized (C40866e.this) {
                    try {
                        C40866e.this.ygJ = C40866e.this.dwL();
                        C4990ab.m7417i(C40862f.this.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(C40866e.this.ygJ));
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(29178);
                    }
                }
                if (message.what == 1) {
                    C40862f.this.dwF();
                    return;
                }
                if (message.what == 2) {
                    C40862f.this.m70798a((C40865c) message.obj, false, true);
                }
                AppMethodBeat.m2505o(29178);
            }
        }

        public C40866e() {
            AppMethodBeat.m2504i(29181);
            dwI();
            AppMethodBeat.m2505o(29181);
        }

        private void dwI() {
            AppMethodBeat.m2504i(29182);
            this.ygG = new C40868b(Looper.getMainLooper());
            this.ygH = new C40867c(C9638aw.m17180RS().oAl.getLooper());
            AppMethodBeat.m2505o(29182);
        }

        private void dwJ() {
            AppMethodBeat.m2504i(29183);
            C40867c c40867c = this.ygH;
            c40867c.removeMessages(c40867c.ygQ);
            c40867c.removeMessages(c40867c.ygR);
            C40868b c40868b = this.ygG;
            c40868b.ygM = true;
            c40868b.removeMessages(1);
            c40868b.removeMessages(2);
            this.ygI.clear();
            this.ygJ = 0;
            AppMethodBeat.m2505o(29183);
        }

        public final synchronized void dwK() {
            AppMethodBeat.m2504i(29184);
            C4990ab.m7416i(C40862f.this.TAG, "newcursor resetQueue ");
            dwJ();
            dwI();
            AppMethodBeat.m2505o(29184);
        }

        public final synchronized void quit() {
            AppMethodBeat.m2504i(29185);
            C4990ab.m7416i(C40862f.this.TAG, "newcursor quit ");
            dwJ();
            AppMethodBeat.m2505o(29185);
        }

        /* Access modifiers changed, original: final */
        public final int dwL() {
            int i = 0;
            AppMethodBeat.m2504i(29186);
            if (this.ygI.size() > 1) {
                i = 2;
            } else if (this.ygI.size() == 1) {
                i = ((Integer) this.ygI.get(0)).intValue();
            }
            AppMethodBeat.m2505o(29186);
            return i;
        }

        public final synchronized boolean dwM() {
            return this.ygJ != 0;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void dwN() {
            AppMethodBeat.m2504i(29187);
            this.ygH.lastUpdateTime = System.currentTimeMillis();
            AppMethodBeat.m2505o(29187);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized int dwO() {
            return this.ygJ;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: MR */
        public final synchronized void mo64402MR(int i) {
            AppMethodBeat.m2504i(29188);
            if (!this.ygI.contains(Integer.valueOf(i))) {
                this.ygI.add(Integer.valueOf(i));
            }
            this.ygJ = dwL();
            C40867c c40867c = this.ygH;
            c40867c.sendEmptyMessage(c40867c.ygR);
            AppMethodBeat.m2505o(29188);
        }

        /* renamed from: a */
        static /* synthetic */ void m70817a(C40866e c40866e) {
            int dwL;
            AppMethodBeat.m2504i(29189);
            synchronized (c40866e) {
                try {
                    dwL = c40866e.dwL();
                    c40866e.ygI.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(29189);
                }
            }
            C15881a c15881a = new C15881a(dwL);
            if (c15881a.ygK == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                C40865c c40865c = new C40865c(C40862f.this.dwz());
                dwL = c40865c.getCount();
                C4990ab.m7417i(C40862f.this.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(dwL));
                C40868b c40868b = C40866e.this.ygG;
                Message obtain = Message.obtain();
                obtain.obj = c40865c;
                obtain.what = 2;
                c40868b.sendMessage(obtain);
                return;
            }
            C40866e.this.ygG.sendEmptyMessage(1);
            AppMethodBeat.m2505o(29189);
        }
    }

    /* renamed from: a */
    public abstract SparseArray<K>[] mo28033a(HashSet<C15880b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    /* renamed from: ao */
    public abstract ArrayList<T> mo28034ao(ArrayList<K> arrayList);

    public abstract T dvz();

    public abstract C1354d<K> dwz();

    /* renamed from: a */
    public final void mo64391a(C30702a c30702a) {
        this.ygt = c30702a;
    }

    public final void dww() {
        this.ygt = null;
    }

    public C40862f(Context context) {
        this(context, (byte) 0);
        this.pageSize = 5000;
        C4990ab.m7417i(this.TAG, "newCursor setPageSize %d", Integer.valueOf(5000));
    }

    private C40862f(Context context, byte b) {
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

    private C40862f(Context context, char c) {
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

    public C40862f(Context context, short s) {
        this(context, 0);
    }

    /* renamed from: a */
    private void m70797a(C40865c c40865c) {
        mo64400pB(false);
        this.ygs = c40865c;
        this.ygs.getCount();
        dwx();
    }

    /* renamed from: a */
    private void m70796a(C1354d<K> c1354d) {
        mo64400pB(true);
        if (this.ygs == null || this.ygs.ycB != c1354d) {
            if (!(this.ygs == null || this.ygs.isClosed())) {
                this.ygs.close();
                this.ygs = null;
            }
            this.ygs = new C40865c(c1354d);
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
                    m70798a(new C40865c(dwz()), true, false);
                }
                C4990ab.m7417i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i));
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
            m70796a(dwz());
            C4990ab.m7417i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        m70805cb("getcount", false);
        return this.ygs.getCount();
    }

    public final int dwy() {
        if (this.ygs == null) {
            return 0;
        }
        C1354d c1354d = this.ygs.ycB;
        if (c1354d == null) {
            return 0;
        }
        if (c1354d instanceof C37629e) {
            return ((C37629e) c1354d).ycs[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    /* renamed from: cb */
    private void m70805cb(String str, boolean z) {
        if (!dwE() && (this.ygw | z) != 0) {
            if (!z) {
                C4990ab.m7417i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.ygw), str, C5046bo.dpG());
            }
            mo64399pA(false);
        }
    }

    /* renamed from: MG */
    public final T getItem(int i) {
        if (this.ygs == null) {
            m70796a(dwz());
        }
        m70805cb("getItem", false);
        this.ygs.ycB.moveToPosition(i);
        C1351a MG = this.ygs.ycB.mo4715MG(i);
        if (MG != null) {
            MG.drw();
        } else {
            C4990ab.m7413e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i));
        }
        return MG;
    }

    public long getItemId(int i) {
        return 0;
    }

    /* renamed from: cL */
    public final T mo64393cL(K k) {
        if (this.ygs == null) {
            return null;
        }
        return this.ygs.ycB.mo4720cL(k);
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

    /* renamed from: pA */
    public final void mo64399pA(boolean z) {
        if (this.ygz || z) {
            dwC();
        } else {
            int changeType = getChangeType();
            if (changeType == 0) {
                C4990ab.m7416i(this.TAG, "newcursor need not change ");
                return;
            }
            if (changeType == 2) {
                C4990ab.m7416i(this.TAG, "newcursor enqueueMessage resetcursor ");
                this.events.clear();
            }
            if (this.ygA == null) {
                this.ygA = new C40866e();
            }
            this.ygA.mo64402MR(changeType);
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
    /* renamed from: j */
    public void mo28048j(K k, int i) {
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
                    this.events.put(k, new C15880b(k, i));
                }
                C4990ab.m7417i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", Integer.valueOf(i));
                i2 = 1;
            } else if (containsKey) {
                C4990ab.m7416i(this.TAG, "newcursor need reset ,return ");
                return;
            } else if (this.ygx != 1) {
                dwB();
                i2 = 0;
            } else if (this.ygs.mo60458cK(k) || i == 2) {
                HashMap hashMap = this.events;
                C15880b c15880b = new C15880b(k, i);
                if (c15880b.ygE == 2 && this.ygs.mo60458cK(c15880b.object)) {
                    c15880b.ygE = 3;
                }
                C15880b c15880b2 = (C15880b) hashMap.get(k);
                if ((c15880b2 != null ? 1 : 0) != 0) {
                    hashMap.remove(c15880b2);
                    switch (c15880b.ygE) {
                        case 2:
                            switch (c15880b2.ygE) {
                                case 2:
                                    C4990ab.m7416i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                                    c15880b.ygE = 2;
                                    break;
                                case 5:
                                    c15880b.ygE = 3;
                                    break;
                                default:
                                    C4990ab.m7416i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                                    c15880b.ygE = 2;
                                    break;
                            }
                        case 5:
                            switch (c15880b2.ygE) {
                                case 2:
                                    break;
                                case 5:
                                    C4990ab.m7416i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                                    c15880b.ygE = 5;
                                    break;
                                default:
                                    c15880b.ygE = 5;
                                    break;
                            }
                        default:
                            switch (c15880b2.ygE) {
                                case 2:
                                    c15880b.ygE = 2;
                                    break;
                                case 5:
                                    C4990ab.m7416i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                                    break;
                            }
                            c15880b.ygE = 3;
                            break;
                    }
                }
                hashMap.put(k, c15880b);
                if (!this.ygs.ycB.mo4714MF(hashMap.size())) {
                    C4990ab.m7417i(this.TAG, "newcursor events size exceed limit :size is :  %d", Integer.valueOf(hashMap.size()));
                    hashMap.clear();
                    hashMap.put(this.ygB, null);
                }
                C4990ab.m7417i(this.TAG, "newcursor add event events size %d", Integer.valueOf(this.events.size()));
                i2 = 0;
            } else {
                C4990ab.m7416i(this.TAG, "newcursor event pass ");
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
            C4990ab.m7417i(str, str2, objArr);
            if (i2 != 0) {
                C4990ab.m7416i(this.TAG, "newcursor event is refresh sync ");
                mo64399pA(true);
            } else if (this.ygr && this.ygw) {
                mo64399pA(false);
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
                C4990ab.m7417i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", Integer.valueOf(dwO));
                if (dwO != 0) {
                    this.ygA.dwK();
                }
            }
            dwO = changeType;
            C4990ab.m7417i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", Integer.valueOf(dwO));
            this.nLf = 0;
            if (dwO == 2) {
                m70798a(new C40865c(dwz()), true, true);
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
        C4990ab.m7416i(this.TAG, "newcursor resume ");
        this.ygr = true;
        m70805cb("resume", true);
    }

    public void pause() {
        this.ygr = false;
        C4990ab.m7416i(this.TAG, "new cursor pasue");
    }

    /* renamed from: a */
    private void m70799a(C40861d c40861d) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ygt != null) {
            this.ygt.dwH();
        }
        c40861d.dwG();
        notifyDataSetChanged();
        if (this.ygt != null) {
            this.ygt.apt();
        }
        if (this.ygA != null) {
            this.ygA.dwN();
        }
        C4990ab.m7417i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void dwF() {
        if (this.ygs == null || this.ygs.isClosed() || this.events.size() != 0) {
            m70799a(new C408641());
        } else {
            C4990ab.m7416i(this.TAG, "events size is 0  ");
        }
    }

    /* renamed from: a */
    private void m70798a(final C40865c c40865c, boolean z, boolean z2) {
        if (z) {
            if (this.ygA != null && this.ygA.dwM()) {
                this.ygA.dwK();
            }
            if (this.events != null) {
                this.events.clear();
            }
        }
        if (z2) {
            m70799a(new C40861d() {
                public final void dwG() {
                    AppMethodBeat.m2504i(29172);
                    C40862f.this.m70797a(c40865c);
                    AppMethodBeat.m2505o(29172);
                }
            });
        } else {
            m70797a((C40865c) c40865c);
        }
    }

    /* renamed from: a */
    public final void mo64392a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] dvp = this.ygs.dvp();
        for (int i = 0; i < dvp.length; i++) {
            dvp[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                dvp[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    /* renamed from: pB */
    public final void mo64400pB(boolean z) {
        if (this.ygs != null) {
            this.ygs.close();
            this.ygs = null;
        }
        if (z && this.ygA != null) {
            this.ygA.quit();
            this.ygA = null;
            if (this.events != null) {
                this.events.clear();
                C4990ab.m7416i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.nLf = 0;
        this.ygx = 0;
    }
}
