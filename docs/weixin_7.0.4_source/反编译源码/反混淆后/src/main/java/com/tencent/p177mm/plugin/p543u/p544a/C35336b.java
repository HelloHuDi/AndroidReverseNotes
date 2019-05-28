package com.tencent.p177mm.plugin.p543u.p544a;

import android.os.Looper;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p543u.p544a.C35333a.C14011a;
import com.tencent.p177mm.plugin.p543u.p544a.C35333a.C353321;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.u.a.b */
public final class C35336b implements C14011a {
    /* renamed from: ce */
    public Map<String, List<C4254a>> f15068ce = new HashMap();
    public List<String> fGz = new LinkedList();
    public C7306ak iGP = new C7306ak(Looper.getMainLooper());
    public Map<String, Set<Integer>> pAo = new HashMap();
    String pAp;
    C35333a pAq;

    /* renamed from: com.tencent.mm.plugin.u.a.b$a */
    public interface C4254a {
        /* renamed from: Vv */
        void mo9236Vv(String str);

        /* renamed from: a */
        void mo9237a(String str, String str2, byte[] bArr, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.u.a.b$2 */
    public class C353352 implements Runnable {
        final /* synthetic */ String pAr;
        final /* synthetic */ C4254a pAs;

        public C353352(String str, C4254a c4254a) {
            this.pAr = str;
            this.pAs = c4254a;
        }

        public final void run() {
            AppMethodBeat.m2504i(80751);
            C35336b c35336b = C35336b.this;
            String str = this.pAr;
            C4254a c4254a = this.pAs;
            List<C4254a> list = (List) c35336b.f15068ce.get(str);
            if (list != null) {
                for (C4254a c4254a2 : list) {
                    if (c4254a2 != null && c4254a2 == c4254a) {
                        list.remove(c4254a2);
                        break;
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
            }
            if (list != null && list.isEmpty()) {
                c35336b.f15068ce.remove(str);
                c35336b.fGz.remove(str);
                c35336b.pAo.remove(str);
                if (c35336b.pAp != null && c35336b.pAp.equals(str)) {
                    C35333a c35333a = c35336b.pAq;
                    C4990ab.m7416i("MicroMsg.scanner.DecodeFile", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                    c35333a.mCancelled = true;
                    c35336b.pAq = null;
                }
                c35336b.cdv();
            }
            AppMethodBeat.m2505o(80751);
        }
    }

    public C35336b() {
        AppMethodBeat.m2504i(80753);
        AppMethodBeat.m2505o(80753);
    }

    /* renamed from: a */
    public final void mo56082a(final String str, final C4254a c4254a, final Set<Integer> set) {
        AppMethodBeat.m2504i(80754);
        C4990ab.m7417i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", str, Integer.valueOf(c4254a.hashCode()));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
            AppMethodBeat.m2505o(80754);
            return;
        }
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80750);
                C35336b c35336b = C35336b.this;
                String str = str;
                C4254a c4254a = c4254a;
                c35336b.pAo.put(str, set);
                if (c35336b.f15068ce.containsKey(str)) {
                    List<C4254a> list = (List) c35336b.f15068ce.get(str);
                    if (list != null) {
                        if (list != null) {
                            Object obj;
                            if (list != null && list.size() != 0) {
                                for (C4254a c4254a2 : list) {
                                    if (c4254a2 != null && c4254a2 == c4254a) {
                                        obj = 1;
                                        break;
                                    }
                                }
                            } else {
                                C4990ab.m7412e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                            }
                            obj = null;
                            if (obj == null) {
                                list.add(c4254a);
                            }
                        }
                        C4990ab.m7412e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                    }
                    c35336b.cdv();
                    AppMethodBeat.m2505o(80750);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(c4254a);
                c35336b.f15068ce.put(str, linkedList);
                c35336b.fGz.add(str);
                c35336b.cdv();
                AppMethodBeat.m2505o(80750);
            }
        });
        AppMethodBeat.m2505o(80754);
    }

    /* Access modifiers changed, original: final */
    public final void cdv() {
        AppMethodBeat.m2504i(80755);
        if (this.pAq != null) {
            C4990ab.m7410d("MicroMsg.FileScanQueueService", "it is scanning");
            AppMethodBeat.m2505o(80755);
        } else if (this.f15068ce.isEmpty()) {
            C4990ab.m7410d("MicroMsg.FileScanQueueService", "queue is empty");
            AppMethodBeat.m2505o(80755);
        } else {
            this.pAp = (String) this.fGz.get(0);
            this.fGz.remove(0);
            this.pAq = new C35333a();
            this.pAq.cJV = (Set) this.pAo.get(this.pAp);
            C35333a c35333a = this.pAq;
            String str = this.pAp;
            C4990ab.m7416i("MicroMsg.scanner.DecodeFile", "start decode file: ".concat(String.valueOf(str)));
            c35333a.pAl = this;
            C5004al.m7441d(new C353321(str));
            AppMethodBeat.m2505o(80755);
        }
    }

    /* renamed from: a */
    public final int mo26244a(final C4264d c4264d) {
        AppMethodBeat.m2504i(80756);
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80752);
                C35336b c35336b = C35336b.this;
                C4264d c4264d = c4264d;
                C4990ab.m7417i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", c35336b.pAp, c4264d);
                List<C4254a> list = (List) c35336b.f15068ce.get(c35336b.pAp);
                if (list != null && c4264d != null) {
                    C4990ab.m7411d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", Integer.valueOf(list.size()));
                    for (C4254a a : list) {
                        a.mo9237a(c35336b.pAp, c4264d.result, c4264d.rawData, c4264d.cvn, c4264d.cvo);
                    }
                } else if (list != null) {
                    for (C4254a a2 : list) {
                        a2.mo9236Vv(c35336b.pAp);
                    }
                }
                c35336b.f15068ce.remove(c35336b.pAp);
                c35336b.pAo.remove(c35336b.pAp);
                c35336b.pAp = null;
                c35336b.pAq = null;
                c35336b.cdv();
                AppMethodBeat.m2505o(80752);
            }
        });
        AppMethodBeat.m2505o(80756);
        return 0;
    }
}
