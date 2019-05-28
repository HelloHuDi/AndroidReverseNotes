package com.tencent.mm.x;

import android.os.Looper;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a eEQ;
    public b eER = new b();
    ArrayList<WeakReference<a>> eES = new ArrayList();
    private final int eET = 0;
    private final int eEU = 1;
    private ak handler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(77701);
            if (message.what == 0 && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                if (bVar.eEX != null) {
                    a aVar = a.this;
                    com.tencent.mm.storage.ac.a aVar2 = bVar.eEX;
                    ArrayList arrayList = null;
                    Iterator it = aVar.eES.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference == null || weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        } else {
                            ((a) weakReference.get()).b(aVar2);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            aVar.eES.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                    AppMethodBeat.o(77701);
                    return;
                }
                a.a(a.this, bVar.eEW, bVar.value);
            }
            AppMethodBeat.o(77701);
        }
    };
    public boolean initialized = false;

    public interface a {
        void b(com.tencent.mm.storage.ac.a aVar);

        void p(int i, String str);
    }

    class b {
        int eEW;
        com.tencent.mm.storage.ac.a eEX;
        int type;
        String value;

        public b(int i, int i2, String str) {
            this.eEW = i;
            this.type = i2;
            this.value = str;
        }

        public b(com.tencent.mm.storage.ac.a aVar, int i, String str) {
            this.eEX = aVar;
            this.type = i;
            this.value = str;
        }
    }

    class c {
        int eEW;
        com.tencent.mm.storage.ac.a eEX;
        int eEY;
        com.tencent.mm.storage.ac.a eEZ;

        public c(int i, int i2) {
            this.eEY = i;
            this.eEW = i2;
        }

        public c(com.tencent.mm.storage.ac.a aVar, com.tencent.mm.storage.ac.a aVar2) {
            this.eEZ = aVar;
            this.eEX = aVar2;
        }

        public c(int i, com.tencent.mm.storage.ac.a aVar) {
            this.eEY = i;
            this.eEX = aVar;
        }
    }

    public a() {
        AppMethodBeat.i(77702);
        AppMethodBeat.o(77702);
    }

    public final void init() {
        AppMethodBeat.i(77703);
        this.initialized = true;
        this.eER.eFf = g.RP().Ry();
        AppMethodBeat.o(77703);
    }

    public final void x(int i, boolean z) {
        AppMethodBeat.i(77704);
        e(i, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(77704);
    }

    public final void a(com.tencent.mm.storage.ac.a aVar, boolean z) {
        AppMethodBeat.i(77705);
        a(aVar, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(77705);
    }

    public final void y(int i, boolean z) {
        AppMethodBeat.i(77706);
        e(i, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(77706);
    }

    public final void b(com.tencent.mm.storage.ac.a aVar, boolean z) {
        AppMethodBeat.i(77707);
        a(aVar, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(77707);
    }

    private void e(int i, int i2, String str) {
        AppMethodBeat.i(77708);
        if (this.initialized) {
            this.eER.f(i, i2, str);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(i, i2, str)));
            AppMethodBeat.o(77708);
            return;
        }
        ab.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
        AppMethodBeat.o(77708);
    }

    private void a(com.tencent.mm.storage.ac.a aVar, int i, String str) {
        AppMethodBeat.i(77709);
        if (this.initialized) {
            this.eER.b(aVar, i, str);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(aVar, i, str)));
            AppMethodBeat.o(77709);
            return;
        }
        ab.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
        AppMethodBeat.o(77709);
    }

    public final boolean bX(int i, int i2) {
        AppMethodBeat.i(77710);
        if (this.initialized) {
            com.tencent.mm.x.b.a F = this.eER.F(i, i2, 1);
            if (F == null) {
                AppMethodBeat.o(77710);
                return false;
            } else if (parseInt(F.value) == 0) {
                AppMethodBeat.o(77710);
                return false;
            } else {
                AppMethodBeat.o(77710);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        AppMethodBeat.o(77710);
        return false;
    }

    public final boolean a(com.tencent.mm.storage.ac.a aVar, com.tencent.mm.storage.ac.a aVar2) {
        AppMethodBeat.i(77711);
        if (this.initialized) {
            com.tencent.mm.x.b.a a = this.eER.a(aVar, aVar2, 1);
            if (a == null) {
                AppMethodBeat.o(77711);
                return false;
            } else if (parseInt(a.value) == 0) {
                AppMethodBeat.o(77711);
                return false;
            } else {
                AppMethodBeat.o(77711);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        AppMethodBeat.o(77711);
        return false;
    }

    public final boolean bY(int i, int i2) {
        AppMethodBeat.i(77712);
        if (this.initialized) {
            com.tencent.mm.x.b.a F = this.eER.F(i, i2, 2);
            if (F == null) {
                AppMethodBeat.o(77712);
                return false;
            } else if (parseInt(F.value) == 0) {
                AppMethodBeat.o(77712);
                return false;
            } else {
                AppMethodBeat.o(77712);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.o(77712);
        return false;
    }

    public final boolean b(com.tencent.mm.storage.ac.a aVar, com.tencent.mm.storage.ac.a aVar2) {
        AppMethodBeat.i(77713);
        if (this.initialized) {
            com.tencent.mm.x.b.a a = this.eER.a(aVar, aVar2, 2);
            if (a == null) {
                AppMethodBeat.o(77713);
                return false;
            } else if (parseInt(a.value) == 0) {
                AppMethodBeat.o(77713);
                return false;
            } else {
                AppMethodBeat.o(77713);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.o(77713);
        return false;
    }

    public final boolean a(com.tencent.mm.storage.ac.a aVar, int i) {
        AppMethodBeat.i(77714);
        if (this.initialized) {
            com.tencent.mm.x.b.a aVar2;
            b bVar = this.eER;
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", aVar, Integer.valueOf(i), Integer.valueOf(2));
            com.tencent.mm.x.b.a f = bVar.f(aVar);
            if (f == null) {
                ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
                aVar2 = null;
            } else if ((f.type & 2) == 0) {
                ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
                aVar2 = null;
            } else {
                com.tencent.mm.x.b.b jy = bVar.jy(i);
                if (jy != null) {
                    String str = (String) jy.eFj.get(aVar.name());
                    if (str == null || !str.equals(f.cxb)) {
                        if (str == null) {
                            jy.eFj.put(aVar.name(), bVar.PI());
                            bVar.a(jy);
                        }
                        aVar2 = f;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                    aVar2 = null;
                }
            }
            if (aVar2 == null) {
                AppMethodBeat.o(77714);
                return false;
            } else if (parseInt(aVar2.value) == 0) {
                AppMethodBeat.o(77714);
                return false;
            } else {
                AppMethodBeat.o(77714);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        AppMethodBeat.o(77714);
        return false;
    }

    public final void bZ(int i, int i2) {
        AppMethodBeat.i(77715);
        if (this.initialized) {
            b bVar = this.eER;
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.x.b.a jx = bVar.jx(i);
            if (jx == null) {
                ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.x.b.b jy = bVar.jy(i2);
                if (jy == null) {
                    ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    jy = bVar.jw(i2);
                    bVar.eFc.put(i2, jy);
                }
                jy.eFi.put(i, jx.cxb);
                bVar.a(jy);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(i2, i)));
            AppMethodBeat.o(77715);
            return;
        }
        ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.o(77715);
    }

    public final void c(com.tencent.mm.storage.ac.a aVar, com.tencent.mm.storage.ac.a aVar2) {
        AppMethodBeat.i(77716);
        if (this.initialized) {
            b bVar = this.eER;
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", aVar, aVar2);
            com.tencent.mm.x.b.a f = bVar.f(aVar);
            if (f == null) {
                ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.x.b.b g = bVar.g(aVar2);
                if (g == null) {
                    ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    g = bVar.e(aVar2);
                    bVar.eFd.put(aVar2, g);
                }
                g.eFj.put(aVar.name(), f.cxb);
                bVar.a(g);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(aVar2, aVar)));
            AppMethodBeat.o(77716);
            return;
        }
        ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.o(77716);
    }

    public final void b(com.tencent.mm.storage.ac.a aVar, int i) {
        AppMethodBeat.i(77717);
        if (this.initialized) {
            b bVar = this.eER;
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", aVar, Integer.valueOf(i));
            com.tencent.mm.x.b.a f = bVar.f(aVar);
            if (f == null) {
                ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.x.b.b jy = bVar.jy(i);
                if (jy == null) {
                    ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    jy = bVar.jw(i);
                    bVar.eFc.put(i, jy);
                }
                jy.eFj.put(aVar.name(), f.cxb);
                bVar.a(jy);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(i, aVar)));
            AppMethodBeat.o(77717);
            return;
        }
        ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
        AppMethodBeat.o(77717);
    }

    public final boolean a(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77718);
        if (this.initialized) {
            com.tencent.mm.x.b.a f = this.eER.f(aVar);
            if (f == null) {
                AppMethodBeat.o(77718);
                return false;
            } else if (parseInt(f.value) == 0) {
                AppMethodBeat.o(77718);
                return false;
            } else {
                AppMethodBeat.o(77718);
                return true;
            }
        }
        ab.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
        AppMethodBeat.o(77718);
        return false;
    }

    public static int parseInt(String str) {
        AppMethodBeat.i(77719);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77719);
            return 0;
        }
        int ank = bo.ank(str);
        AppMethodBeat.o(77719);
        return ank;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(77720);
        if (this.initialized) {
            this.eES.add(new WeakReference(aVar));
            AppMethodBeat.o(77720);
            return;
        }
        ab.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        AppMethodBeat.o(77720);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(77721);
        if (this.initialized) {
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eES.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) this.eES.get(i2);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
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
            AppMethodBeat.o(77721);
            return;
        }
        ab.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
        AppMethodBeat.o(77721);
    }
}
