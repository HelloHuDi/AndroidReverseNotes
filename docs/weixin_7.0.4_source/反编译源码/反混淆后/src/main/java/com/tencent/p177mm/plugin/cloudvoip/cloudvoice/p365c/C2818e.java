package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b.C33829a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j.C33841d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e */
public final class C2818e {
    final ArrayList<C2819a> kzA = new ArrayList(2);
    Timer kzB;
    final ArrayList<C33829a> kzy = new ArrayList(10);
    ArrayList<C33829a> kzz = new ArrayList(10);

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e$a */
    interface C2819a {
        /* renamed from: v */
        void mo6938v(ArrayList<C33829a> arrayList);
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e$1 */
    class C28201 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e$1$1 */
        class C28211 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e$1$1$1 */
            class C28221 implements Comparator<C33829a> {
                C28221() {
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    C33829a c33829a = (C33829a) obj;
                    C33829a c33829a2 = (C33829a) obj2;
                    if (c33829a.kyZ > c33829a2.kyZ) {
                        return 1;
                    }
                    if (c33829a.kyZ < c33829a2.kyZ) {
                        return -1;
                    }
                    return 0;
                }
            }

            C28211() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135477);
                if (C33836j.kzW.kAb == C33841d.kBo) {
                    ArrayList arrayList = new ArrayList(5);
                    Iterator it = C2818e.this.kzy.iterator();
                    while (it.hasNext()) {
                        C33829a c33829a = (C33829a) it.next();
                        C33836j c33836j = C33836j.kzW;
                        C4990ab.m7419v("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: member %s is talking %b", c33829a, Boolean.valueOf(C33836j.m55357a(c33829a)));
                        if (C33836j.m55357a(c33829a)) {
                            arrayList.add(c33829a);
                        }
                    }
                    Collections.sort(arrayList, new C28221());
                    if (!C2818e.m5068a(C2818e.this, arrayList)) {
                        synchronized (C2818e.this.kzA) {
                            try {
                                Iterator it2 = C2818e.this.kzA.iterator();
                                while (it2.hasNext()) {
                                    ((C2819a) it2.next()).mo6938v(arrayList);
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(135477);
                            }
                        }
                    }
                    C2818e.this.kzz = arrayList;
                    AppMethodBeat.m2505o(135477);
                    return;
                }
                C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: not in room, ignore speaker change");
                AppMethodBeat.m2505o(135477);
            }
        }

        C28201() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135478);
            C33836j.kzW.mo54393R(new C28211());
            AppMethodBeat.m2505o(135478);
        }
    }

    public C2818e() {
        AppMethodBeat.m2504i(135479);
        AppMethodBeat.m2505o(135479);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m5068a(C2818e c2818e, ArrayList arrayList) {
        AppMethodBeat.m2504i(135480);
        if (c2818e.kzz == null) {
            AppMethodBeat.m2505o(135480);
            return true;
        } else if (arrayList.size() != c2818e.kzz.size()) {
            AppMethodBeat.m2505o(135480);
            return false;
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((C33829a) arrayList.get(i)).kyZ != ((C33829a) c2818e.kzz.get(i)).kyZ) {
                    AppMethodBeat.m2505o(135480);
                    return false;
                }
            }
            AppMethodBeat.m2505o(135480);
            return true;
        }
    }
}
