package com.tencent.p139g.p809a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.g.a.a */
public final class C37343a {
    private HashMap<String, Object> AHN = new HashMap();
    C8787c AHO;
    private Object xHI = new Object();

    public C37343a() {
        AppMethodBeat.m2504i(127742);
        AppMethodBeat.m2505o(127742);
    }

    /* renamed from: a */
    public final void mo60055a(C25636d c25636d, String[] strArr) {
        AppMethodBeat.m2504i(127743);
        if (strArr == null) {
            AppMethodBeat.m2505o(127743);
            return;
        }
        synchronized (this.xHI) {
            try {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.AHN.get(obj);
                        if (obj2 == null) {
                            this.AHN.put(obj, c25636d);
                        } else if (obj2 instanceof C25636d) {
                            C25636d c25636d2 = (C25636d) obj2;
                            if (c25636d2 != c25636d) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(c25636d2);
                                linkedList.add(c25636d);
                                this.AHN.put(obj, linkedList);
                            }
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(c25636d) >= 0) {
                                AppMethodBeat.m2505o(127743);
                                return;
                            }
                            linkedList2.add(c25636d);
                        } else {
                            continue;
                        }
                    }
                }
                AppMethodBeat.m2505o(127743);
            } finally {
                AppMethodBeat.m2505o(127743);
            }
        }
    }

    /* renamed from: c */
    public final void mo60056c(String str, int i, Object obj) {
        AppMethodBeat.m2504i(127744);
        C8788e c8788e = (C8788e) this.AHO.dSE();
        c8788e.cFW = str;
        c8788e.AHQ = i;
        c8788e.arg1 = 0;
        c8788e.arg2 = 0;
        c8788e.obj = obj;
        m62726a(c8788e);
        AppMethodBeat.m2505o(127744);
    }

    /* renamed from: a */
    private void m62726a(C8788e c8788e) {
        AppMethodBeat.m2504i(127745);
        if (!(c8788e == null || c8788e.cFW == null)) {
            LinkedList linkedList;
            C25636d c25636d;
            System.currentTimeMillis();
            String str = c8788e.cFW;
            synchronized (this.xHI) {
                try {
                    Object obj = this.AHN.get(str);
                    if (obj != null) {
                        if (obj instanceof C25636d) {
                            linkedList = null;
                            c25636d = (C25636d) obj;
                        } else if (obj instanceof List) {
                            linkedList = (LinkedList) ((LinkedList) obj).clone();
                            c25636d = null;
                        }
                    }
                    linkedList = null;
                    c25636d = null;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(127745);
                }
            }
            if (c25636d != null) {
                c25636d.mo41164eR(str, c8788e.AHQ);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((C25636d) it.next()).mo41164eR(str, c8788e.AHQ);
                }
            }
            this.AHO.mo52709a(c8788e);
        }
        AppMethodBeat.m2505o(127745);
    }
}
