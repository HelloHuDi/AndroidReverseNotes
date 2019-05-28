package com.tencent.toybrick.p682e;

import android.os.Handler;
import android.os.Looper;
import android.support.p069v7.p075h.C0595c;
import android.support.p069v7.p075h.C0595c.C0601b;
import android.support.p069v7.widget.RecyclerView.C41523a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.p1354b.C46820b;
import com.tencent.toybrick.p1633a.C44558a;
import com.tencent.toybrick.p680c.C44830g;
import com.tencent.toybrick.p680c.C44830g.C36554b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.toybrick.e.b */
public final class C36557b {
    WeakReference<C46820b> AGX;
    public Runnable AGY;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.toybrick.e.b$a */
    class C5973a {
        public C0601b AHa;
        public ArrayList<C44830g> AHb;
        public HashMap<C44830g, Integer> AHc;

        private C5973a() {
        }

        /* synthetic */ C5973a(C36557b c36557b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.toybrick.e.b$b */
    class C36555b implements Runnable {
        boolean AGR;
        private LinkedList<C44830g> AHd;
        private ArrayList<C44830g> AHe;

        public C36555b(boolean z, LinkedList<C44830g> linkedList, ArrayList<C44830g> arrayList) {
            AppMethodBeat.m2504i(113230);
            this.AGR = z;
            this.AHd = new LinkedList(linkedList);
            this.AHe = new ArrayList(arrayList);
            AppMethodBeat.m2505o(113230);
        }

        public final void run() {
            AppMethodBeat.m2504i(113231);
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            m60591a(arrayList, hashMap);
            C0601b a = C0595c.m1289a(new C44558a(this.AHe, arrayList), true);
            final C5973a c5973a = new C5973a(C36557b.this, (byte) 0);
            c5973a.AHc = hashMap;
            c5973a.AHa = a;
            c5973a.AHb = arrayList;
            C36557b.this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(113229);
                    C41523a c41523a = (C46820b) C36557b.this.AGX.get();
                    if (c41523a != null) {
                        c41523a.AFO = c5973a.AHb;
                        c41523a.AFQ = c5973a.AHc;
                        c5973a.AHa.mo1480a(c41523a);
                    }
                    AppMethodBeat.m2505o(113229);
                }
            });
            AppMethodBeat.m2505o(113231);
        }

        /* renamed from: a */
        private void m60591a(List<C44830g> list, HashMap<C44830g, Integer> hashMap) {
            C44830g c44830g;
            AppMethodBeat.m2504i(113232);
            list.clear();
            Iterator it = this.AHd.iterator();
            while (it.hasNext()) {
                c44830g = (C44830g) it.next();
                if (c44830g.isVisible) {
                    list.add(c44830g);
                }
                hashMap.put(c44830g, Integer.valueOf(hashMap.size()));
            }
            Collections.sort(list);
            if (this.AGR) {
                c44830g = null;
                Iterator it2 = list.iterator();
                int i = 0;
                while (true) {
                    C44830g c44830g2 = c44830g;
                    if (!it2.hasNext()) {
                        break;
                    }
                    c44830g = (C44830g) it2.next();
                    if (c44830g.dSy() == C36554b.HINT) {
                        c44830g.AGG = false;
                        if (c44830g2 != null) {
                            c44830g2.AGG = false;
                        }
                    }
                    if (i == list.size() - 1) {
                        c44830g.AGG = false;
                    }
                    i++;
                }
            }
            AppMethodBeat.m2505o(113232);
        }
    }

    /* renamed from: com.tencent.toybrick.e.b$1 */
    public class C365581 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(113228);
            C46820b c46820b = (C46820b) C36557b.this.AGX.get();
            if (c46820b != null) {
                C5972a.dSz().execute(new C36555b(c46820b.AFT.AGR, c46820b.AFP, c46820b.AFO));
            }
            AppMethodBeat.m2505o(113228);
        }
    }

    public C36557b(C46820b c46820b) {
        AppMethodBeat.m2504i(113233);
        this.AGX = new WeakReference(c46820b);
        AppMethodBeat.m2505o(113233);
    }
}
