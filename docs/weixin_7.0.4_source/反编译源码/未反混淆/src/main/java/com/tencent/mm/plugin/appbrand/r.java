package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r {
    private Map<Integer, List<b>> gPL;
    private Map<Integer, Integer> gPM;

    public static class a {
        public static r gPN = new r();

        static {
            AppMethodBeat.i(86773);
            AppMethodBeat.o(86773);
        }
    }

    public interface b {
        void auh();
    }

    /* synthetic */ r(byte b) {
        this();
    }

    private r() {
        AppMethodBeat.i(86774);
        this.gPL = new HashMap();
        this.gPM = new HashMap();
        AppMethodBeat.o(86774);
    }

    private void d(int i, List<b> list) {
        int i2 = 0;
        AppMethodBeat.i(86778);
        if (this.gPM.isEmpty()) {
            AppMethodBeat.o(86778);
            return;
        }
        ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify pending : %d", Integer.valueOf(i));
        if (this.gPM.containsKey(Integer.valueOf(i))) {
            this.gPM.remove(Integer.valueOf(i));
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    ((b) list.get(i3)).auh();
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(86778);
                    return;
                }
            }
        }
        ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "not in pending notify");
        AppMethodBeat.o(86778);
    }

    public final synchronized void a(q qVar, b bVar) {
        AppMethodBeat.i(86775);
        int hashCode = qVar.hashCode();
        ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "addListener service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            list = new ArrayList();
            this.gPL.put(Integer.valueOf(hashCode), list);
        }
        list.add(bVar);
        d(hashCode, list);
        AppMethodBeat.o(86775);
    }

    public final synchronized void b(q qVar, b bVar) {
        AppMethodBeat.i(86776);
        int hashCode = qVar.hashCode();
        ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "removeListener service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            AppMethodBeat.o(86776);
        } else {
            list.remove(bVar);
            if (list.isEmpty()) {
                this.gPL.remove(Integer.valueOf(hashCode));
            }
            AppMethodBeat.o(86776);
        }
    }

    public final synchronized void a(q qVar) {
        AppMethodBeat.i(86777);
        int hashCode = qVar.hashCode();
        ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify listenerList empty");
            this.gPM.put(Integer.valueOf(hashCode), Integer.valueOf(1));
            AppMethodBeat.o(86777);
        } else {
            for (hashCode = 0; hashCode < list.size(); hashCode++) {
                ((b) list.get(hashCode)).auh();
            }
            AppMethodBeat.o(86777);
        }
    }
}
