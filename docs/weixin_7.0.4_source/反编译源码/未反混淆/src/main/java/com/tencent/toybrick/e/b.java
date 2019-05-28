package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    WeakReference<com.tencent.toybrick.b.b> AGX;
    public Runnable AGY;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    class a {
        public android.support.v7.h.c.b AHa;
        public ArrayList<g> AHb;
        public HashMap<g, Integer> AHc;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    class b implements Runnable {
        boolean AGR;
        private LinkedList<g> AHd;
        private ArrayList<g> AHe;

        public b(boolean z, LinkedList<g> linkedList, ArrayList<g> arrayList) {
            AppMethodBeat.i(113230);
            this.AGR = z;
            this.AHd = new LinkedList(linkedList);
            this.AHe = new ArrayList(arrayList);
            AppMethodBeat.o(113230);
        }

        public final void run() {
            AppMethodBeat.i(113231);
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            a(arrayList, hashMap);
            android.support.v7.h.c.b a = c.a(new com.tencent.toybrick.a.a(this.AHe, arrayList), true);
            final a aVar = new a(b.this, (byte) 0);
            aVar.AHc = hashMap;
            aVar.AHa = a;
            aVar.AHb = arrayList;
            b.this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113229);
                    android.support.v7.widget.RecyclerView.a aVar = (com.tencent.toybrick.b.b) b.this.AGX.get();
                    if (aVar != null) {
                        aVar.AFO = aVar.AHb;
                        aVar.AFQ = aVar.AHc;
                        aVar.AHa.a(aVar);
                    }
                    AppMethodBeat.o(113229);
                }
            });
            AppMethodBeat.o(113231);
        }

        private void a(List<g> list, HashMap<g, Integer> hashMap) {
            g gVar;
            AppMethodBeat.i(113232);
            list.clear();
            Iterator it = this.AHd.iterator();
            while (it.hasNext()) {
                gVar = (g) it.next();
                if (gVar.isVisible) {
                    list.add(gVar);
                }
                hashMap.put(gVar, Integer.valueOf(hashMap.size()));
            }
            Collections.sort(list);
            if (this.AGR) {
                gVar = null;
                Iterator it2 = list.iterator();
                int i = 0;
                while (true) {
                    g gVar2 = gVar;
                    if (!it2.hasNext()) {
                        break;
                    }
                    gVar = (g) it2.next();
                    if (gVar.dSy() == com.tencent.toybrick.c.g.b.HINT) {
                        gVar.AGG = false;
                        if (gVar2 != null) {
                            gVar2.AGG = false;
                        }
                    }
                    if (i == list.size() - 1) {
                        gVar.AGG = false;
                    }
                    i++;
                }
            }
            AppMethodBeat.o(113232);
        }
    }

    public b(com.tencent.toybrick.b.b bVar) {
        AppMethodBeat.i(113233);
        this.AGX = new WeakReference(bVar);
        AppMethodBeat.o(113233);
    }
}
