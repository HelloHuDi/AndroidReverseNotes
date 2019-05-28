package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c eGt;
    Map<String, List<e>> eGu = new ConcurrentHashMap();

    public static c PT() {
        AppMethodBeat.i(114073);
        if (eGt == null) {
            synchronized (c.class) {
                try {
                    if (eGt == null) {
                        eGt = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114073);
                    }
                }
            }
        }
        c cVar = eGt;
        AppMethodBeat.o(114073);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(114074);
        AppMethodBeat.o(114074);
    }

    public final boolean k(String str, Bundle bundle) {
        AppMethodBeat.i(114075);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114075);
            return false;
        }
        List list = (List) this.eGu.get(str);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(114075);
            return true;
        }
        synchronized (list) {
            try {
                ArrayList<e> arrayList = new ArrayList(list);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114075);
            }
        }
        for (e ao : arrayList) {
            ao.ao(bundle);
        }
        return true;
    }

    public final boolean a(String str, e eVar) {
        AppMethodBeat.i(114076);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114076);
            return false;
        }
        List list = (List) this.eGu.get(str);
        if (list == null) {
            list = new LinkedList();
            this.eGu.put(str, list);
        }
        if (list.contains(eVar)) {
            AppMethodBeat.o(114076);
            return false;
        }
        boolean add;
        synchronized (list) {
            try {
                add = list.add(eVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114076);
            }
        }
        return add;
    }

    public final boolean b(String str, e eVar) {
        AppMethodBeat.i(114077);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114077);
            return false;
        }
        boolean z;
        List list = (List) this.eGu.get(str);
        if (list != null) {
            boolean remove;
            synchronized (list) {
                try {
                    remove = list.remove(eVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114077);
                    }
                }
            }
            if (list.isEmpty()) {
                this.eGu.remove(str);
            }
            z = remove;
        } else {
            z = false;
        }
        AppMethodBeat.o(114077);
        return z;
    }
}
