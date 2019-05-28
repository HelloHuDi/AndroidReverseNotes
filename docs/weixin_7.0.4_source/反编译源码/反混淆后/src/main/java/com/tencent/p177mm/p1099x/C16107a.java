package com.tencent.p177mm.p1099x;

import android.os.Looper;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C30903b.C30902a;
import com.tencent.p177mm.p1099x.C30903b.C30904b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.x.a */
public final class C16107a {
    static C16107a eEQ;
    public C30903b eER = new C30903b();
    ArrayList<WeakReference<C16108a>> eES = new ArrayList();
    private final int eET = 0;
    private final int eEU = 1;
    private C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(77701);
            if (message.what == 0 && (message.obj instanceof C16109b)) {
                C16109b c16109b = (C16109b) message.obj;
                if (c16109b.eEX != null) {
                    C16107a c16107a = C16107a.this;
                    C5127a c5127a = c16109b.eEX;
                    ArrayList arrayList = null;
                    Iterator it = c16107a.eES.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference == null || weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        } else {
                            ((C16108a) weakReference.get()).mo25291b(c5127a);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            c16107a.eES.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                    AppMethodBeat.m2505o(77701);
                    return;
                }
                C16107a.m24409a(C16107a.this, c16109b.eEW, c16109b.value);
            }
            AppMethodBeat.m2505o(77701);
        }
    };
    public boolean initialized = false;

    /* renamed from: com.tencent.mm.x.a$a */
    public interface C16108a {
        /* renamed from: b */
        void mo25291b(C5127a c5127a);

        /* renamed from: p */
        void mo25292p(int i, String str);
    }

    /* renamed from: com.tencent.mm.x.a$b */
    class C16109b {
        int eEW;
        C5127a eEX;
        int type;
        String value;

        public C16109b(int i, int i2, String str) {
            this.eEW = i;
            this.type = i2;
            this.value = str;
        }

        public C16109b(C5127a c5127a, int i, String str) {
            this.eEX = c5127a;
            this.type = i;
            this.value = str;
        }
    }

    /* renamed from: com.tencent.mm.x.a$c */
    class C16110c {
        int eEW;
        C5127a eEX;
        int eEY;
        C5127a eEZ;

        public C16110c(int i, int i2) {
            this.eEY = i;
            this.eEW = i2;
        }

        public C16110c(C5127a c5127a, C5127a c5127a2) {
            this.eEZ = c5127a;
            this.eEX = c5127a2;
        }

        public C16110c(int i, C5127a c5127a) {
            this.eEY = i;
            this.eEX = c5127a;
        }
    }

    public C16107a() {
        AppMethodBeat.m2504i(77702);
        AppMethodBeat.m2505o(77702);
    }

    public final void init() {
        AppMethodBeat.m2504i(77703);
        this.initialized = true;
        this.eER.eFf = C1720g.m3536RP().mo5239Ry();
        AppMethodBeat.m2505o(77703);
    }

    /* renamed from: x */
    public final void mo28556x(int i, boolean z) {
        AppMethodBeat.m2504i(77704);
        m24410e(i, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.m2505o(77704);
    }

    /* renamed from: a */
    public final void mo28542a(C5127a c5127a, boolean z) {
        AppMethodBeat.m2504i(77705);
        m24408a(c5127a, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.m2505o(77705);
    }

    /* renamed from: y */
    public final void mo28557y(int i, boolean z) {
        AppMethodBeat.m2504i(77706);
        m24410e(i, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.m2505o(77706);
    }

    /* renamed from: b */
    public final void mo28548b(C5127a c5127a, boolean z) {
        AppMethodBeat.m2504i(77707);
        m24408a(c5127a, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.m2505o(77707);
    }

    /* renamed from: e */
    private void m24410e(int i, int i2, String str) {
        AppMethodBeat.m2504i(77708);
        if (this.initialized) {
            this.eER.mo49435f(i, i2, str);
            this.handler.sendMessage(this.handler.obtainMessage(0, new C16109b(i, i2, str)));
            AppMethodBeat.m2505o(77708);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
        AppMethodBeat.m2505o(77708);
    }

    /* renamed from: a */
    private void m24408a(C5127a c5127a, int i, String str) {
        AppMethodBeat.m2504i(77709);
        if (this.initialized) {
            this.eER.mo49432b(c5127a, i, str);
            this.handler.sendMessage(this.handler.obtainMessage(0, new C16109b(c5127a, i, str)));
            AppMethodBeat.m2505o(77709);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
        AppMethodBeat.m2505o(77709);
    }

    /* renamed from: bX */
    public final boolean mo28551bX(int i, int i2) {
        AppMethodBeat.m2504i(77710);
        if (this.initialized) {
            C30902a F = this.eER.mo49428F(i, i2, 1);
            if (F == null) {
                AppMethodBeat.m2505o(77710);
                return false;
            } else if (C16107a.parseInt(F.value) == 0) {
                AppMethodBeat.m2505o(77710);
                return false;
            } else {
                AppMethodBeat.m2505o(77710);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        AppMethodBeat.m2505o(77710);
        return false;
    }

    /* renamed from: a */
    public final boolean mo28546a(C5127a c5127a, C5127a c5127a2) {
        AppMethodBeat.m2504i(77711);
        if (this.initialized) {
            C30902a a = this.eER.mo49430a(c5127a, c5127a2, 1);
            if (a == null) {
                AppMethodBeat.m2505o(77711);
                return false;
            } else if (C16107a.parseInt(a.value) == 0) {
                AppMethodBeat.m2505o(77711);
                return false;
            } else {
                AppMethodBeat.m2505o(77711);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        AppMethodBeat.m2505o(77711);
        return false;
    }

    /* renamed from: bY */
    public final boolean mo28552bY(int i, int i2) {
        AppMethodBeat.m2504i(77712);
        if (this.initialized) {
            C30902a F = this.eER.mo49428F(i, i2, 2);
            if (F == null) {
                AppMethodBeat.m2505o(77712);
                return false;
            } else if (C16107a.parseInt(F.value) == 0) {
                AppMethodBeat.m2505o(77712);
                return false;
            } else {
                AppMethodBeat.m2505o(77712);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.m2505o(77712);
        return false;
    }

    /* renamed from: b */
    public final boolean mo28550b(C5127a c5127a, C5127a c5127a2) {
        AppMethodBeat.m2504i(77713);
        if (this.initialized) {
            C30902a a = this.eER.mo49430a(c5127a, c5127a2, 2);
            if (a == null) {
                AppMethodBeat.m2505o(77713);
                return false;
            } else if (C16107a.parseInt(a.value) == 0) {
                AppMethodBeat.m2505o(77713);
                return false;
            } else {
                AppMethodBeat.m2505o(77713);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.m2505o(77713);
        return false;
    }

    /* renamed from: a */
    public final boolean mo28545a(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(77714);
        if (this.initialized) {
            C30902a c30902a;
            C30903b c30903b = this.eER;
            C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", c5127a, Integer.valueOf(i), Integer.valueOf(2));
            C30902a f = c30903b.mo49434f(c5127a);
            if (f == null) {
                C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
                c30902a = null;
            } else if ((f.type & 2) == 0) {
                C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
                c30902a = null;
            } else {
                C30904b jy = c30903b.mo49439jy(i);
                if (jy != null) {
                    String str = (String) jy.eFj.get(c5127a.name());
                    if (str == null || !str.equals(f.cxb)) {
                        if (str == null) {
                            jy.eFj.put(c5127a.name(), c30903b.mo49429PI());
                            c30903b.mo49431a(jy);
                        }
                        c30902a = f;
                    } else {
                        c30902a = null;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                    c30902a = null;
                }
            }
            if (c30902a == null) {
                AppMethodBeat.m2505o(77714);
                return false;
            } else if (C16107a.parseInt(c30902a.value) == 0) {
                AppMethodBeat.m2505o(77714);
                return false;
            } else {
                AppMethodBeat.m2505o(77714);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.m2505o(77714);
        return false;
    }

    /* renamed from: bZ */
    public final void mo28553bZ(int i, int i2) {
        AppMethodBeat.m2504i(77715);
        if (this.initialized) {
            C30903b c30903b = this.eER;
            C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i), Integer.valueOf(i2));
            C30902a jx = c30903b.mo49438jx(i);
            if (jx == null) {
                C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                C30904b jy = c30903b.mo49439jy(i2);
                if (jy == null) {
                    C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    jy = c30903b.mo49437jw(i2);
                    c30903b.eFc.put(i2, jy);
                }
                jy.eFi.put(i, jx.cxb);
                c30903b.mo49431a(jy);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new C16110c(i2, i)));
            AppMethodBeat.m2505o(77715);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.m2505o(77715);
    }

    /* renamed from: c */
    public final void mo28554c(C5127a c5127a, C5127a c5127a2) {
        AppMethodBeat.m2504i(77716);
        if (this.initialized) {
            C30903b c30903b = this.eER;
            C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", c5127a, c5127a2);
            C30902a f = c30903b.mo49434f(c5127a);
            if (f == null) {
                C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                C30904b g = c30903b.mo49436g(c5127a2);
                if (g == null) {
                    C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    g = c30903b.mo49433e(c5127a2);
                    c30903b.eFd.put(c5127a2, g);
                }
                g.eFj.put(c5127a.name(), f.cxb);
                c30903b.mo49431a(g);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new C16110c(c5127a2, c5127a)));
            AppMethodBeat.m2505o(77716);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.m2505o(77716);
    }

    /* renamed from: b */
    public final void mo28547b(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(77717);
        if (this.initialized) {
            C30903b c30903b = this.eER;
            C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", c5127a, Integer.valueOf(i));
            C30902a f = c30903b.mo49434f(c5127a);
            if (f == null) {
                C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                C30904b jy = c30903b.mo49439jy(i);
                if (jy == null) {
                    C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    jy = c30903b.mo49437jw(i);
                    c30903b.eFc.put(i, jy);
                }
                jy.eFj.put(c5127a.name(), f.cxb);
                c30903b.mo49431a(jy);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new C16110c(i, c5127a)));
            AppMethodBeat.m2505o(77717);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.m2505o(77717);
    }

    /* renamed from: a */
    public final boolean mo28544a(C5127a c5127a) {
        AppMethodBeat.m2504i(77718);
        if (this.initialized) {
            C30902a f = this.eER.mo49434f(c5127a);
            if (f == null) {
                AppMethodBeat.m2505o(77718);
                return false;
            } else if (C16107a.parseInt(f.value) == 0) {
                AppMethodBeat.m2505o(77718);
                return false;
            } else {
                AppMethodBeat.m2505o(77718);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
        AppMethodBeat.m2505o(77718);
        return false;
    }

    public static int parseInt(String str) {
        AppMethodBeat.m2504i(77719);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77719);
            return 0;
        }
        int ank = C5046bo.ank(str);
        AppMethodBeat.m2505o(77719);
        return ank;
    }

    /* renamed from: a */
    public final void mo28543a(C16108a c16108a) {
        AppMethodBeat.m2504i(77720);
        if (this.initialized) {
            this.eES.add(new WeakReference(c16108a));
            AppMethodBeat.m2505o(77720);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        AppMethodBeat.m2505o(77720);
    }

    /* renamed from: b */
    public final void mo28549b(C16108a c16108a) {
        AppMethodBeat.m2504i(77721);
        if (this.initialized) {
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eES.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) this.eES.get(i2);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == c16108a) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
                i = i2 + 1;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.eES.remove((WeakReference) it.next());
                }
                arrayList.clear();
            }
            AppMethodBeat.m2505o(77721);
            return;
        }
        C4990ab.m7420w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
        AppMethodBeat.m2505o(77721);
    }
}
