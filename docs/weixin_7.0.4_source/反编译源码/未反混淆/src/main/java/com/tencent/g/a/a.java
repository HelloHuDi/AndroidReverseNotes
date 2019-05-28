package com.tencent.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private HashMap<String, Object> AHN = new HashMap();
    c AHO;
    private Object xHI = new Object();

    public a() {
        AppMethodBeat.i(127742);
        AppMethodBeat.o(127742);
    }

    public final void a(d dVar, String[] strArr) {
        AppMethodBeat.i(127743);
        if (strArr == null) {
            AppMethodBeat.o(127743);
            return;
        }
        synchronized (this.xHI) {
            try {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.AHN.get(obj);
                        if (obj2 == null) {
                            this.AHN.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 != dVar) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(dVar2);
                                linkedList.add(dVar);
                                this.AHN.put(obj, linkedList);
                            }
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                AppMethodBeat.o(127743);
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
                AppMethodBeat.o(127743);
            } finally {
                AppMethodBeat.o(127743);
            }
        }
    }

    public final void c(String str, int i, Object obj) {
        AppMethodBeat.i(127744);
        e eVar = (e) this.AHO.dSE();
        eVar.cFW = str;
        eVar.AHQ = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        a(eVar);
        AppMethodBeat.o(127744);
    }

    private void a(e eVar) {
        AppMethodBeat.i(127745);
        if (!(eVar == null || eVar.cFW == null)) {
            LinkedList linkedList;
            d dVar;
            System.currentTimeMillis();
            String str = eVar.cFW;
            synchronized (this.xHI) {
                try {
                    Object obj = this.AHN.get(str);
                    if (obj != null) {
                        if (obj instanceof d) {
                            linkedList = null;
                            dVar = (d) obj;
                        } else if (obj instanceof List) {
                            linkedList = (LinkedList) ((LinkedList) obj).clone();
                            dVar = null;
                        }
                    }
                    linkedList = null;
                    dVar = null;
                } catch (Throwable th) {
                    AppMethodBeat.o(127745);
                }
            }
            if (dVar != null) {
                dVar.eR(str, eVar.AHQ);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).eR(str, eVar.AHQ);
                }
            }
            this.AHO.a(eVar);
        }
        AppMethodBeat.o(127745);
    }
}
