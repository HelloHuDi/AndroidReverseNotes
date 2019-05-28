package com.tencent.mm.plugin.u.a;

import android.os.Looper;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements com.tencent.mm.plugin.u.a.a.a {
    public Map<String, List<a>> ce = new HashMap();
    public List<String> fGz = new LinkedList();
    public ak iGP = new ak(Looper.getMainLooper());
    public Map<String, Set<Integer>> pAo = new HashMap();
    String pAp;
    a pAq;

    public interface a {
        void Vv(String str);

        void a(String str, String str2, byte[] bArr, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.u.a.b$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String pAr;
        final /* synthetic */ a pAs;

        public AnonymousClass2(String str, a aVar) {
            this.pAr = str;
            this.pAs = aVar;
        }

        public final void run() {
            AppMethodBeat.i(80751);
            b bVar = b.this;
            String str = this.pAr;
            a aVar = this.pAs;
            List<a> list = (List) bVar.ce.get(str);
            if (list != null) {
                for (a aVar2 : list) {
                    if (aVar2 != null && aVar2 == aVar) {
                        list.remove(aVar2);
                        break;
                    }
                }
            } else {
                ab.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
            }
            if (list != null && list.isEmpty()) {
                bVar.ce.remove(str);
                bVar.fGz.remove(str);
                bVar.pAo.remove(str);
                if (bVar.pAp != null && bVar.pAp.equals(str)) {
                    a aVar3 = bVar.pAq;
                    ab.i("MicroMsg.scanner.DecodeFile", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                    aVar3.mCancelled = true;
                    bVar.pAq = null;
                }
                bVar.cdv();
            }
            AppMethodBeat.o(80751);
        }
    }

    public b() {
        AppMethodBeat.i(80753);
        AppMethodBeat.o(80753);
    }

    public final void a(final String str, final a aVar, final Set<Integer> set) {
        AppMethodBeat.i(80754);
        ab.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", str, Integer.valueOf(aVar.hashCode()));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
            AppMethodBeat.o(80754);
            return;
        }
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80750);
                b bVar = b.this;
                String str = str;
                a aVar = aVar;
                bVar.pAo.put(str, set);
                if (bVar.ce.containsKey(str)) {
                    List<a> list = (List) bVar.ce.get(str);
                    if (list != null) {
                        if (list != null) {
                            Object obj;
                            if (list != null && list.size() != 0) {
                                for (a aVar2 : list) {
                                    if (aVar2 != null && aVar2 == aVar) {
                                        obj = 1;
                                        break;
                                    }
                                }
                            } else {
                                ab.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                            }
                            obj = null;
                            if (obj == null) {
                                list.add(aVar);
                            }
                        }
                        ab.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                    }
                    bVar.cdv();
                    AppMethodBeat.o(80750);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(aVar);
                bVar.ce.put(str, linkedList);
                bVar.fGz.add(str);
                bVar.cdv();
                AppMethodBeat.o(80750);
            }
        });
        AppMethodBeat.o(80754);
    }

    /* Access modifiers changed, original: final */
    public final void cdv() {
        AppMethodBeat.i(80755);
        if (this.pAq != null) {
            ab.d("MicroMsg.FileScanQueueService", "it is scanning");
            AppMethodBeat.o(80755);
        } else if (this.ce.isEmpty()) {
            ab.d("MicroMsg.FileScanQueueService", "queue is empty");
            AppMethodBeat.o(80755);
        } else {
            this.pAp = (String) this.fGz.get(0);
            this.fGz.remove(0);
            this.pAq = new a();
            this.pAq.cJV = (Set) this.pAo.get(this.pAp);
            a aVar = this.pAq;
            String str = this.pAp;
            ab.i("MicroMsg.scanner.DecodeFile", "start decode file: ".concat(String.valueOf(str)));
            aVar.pAl = this;
            al.d(new com.tencent.mm.plugin.u.a.a.AnonymousClass1(str));
            AppMethodBeat.o(80755);
        }
    }

    public final int a(final d dVar) {
        AppMethodBeat.i(80756);
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80752);
                b bVar = b.this;
                d dVar = dVar;
                ab.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", bVar.pAp, dVar);
                List<a> list = (List) bVar.ce.get(bVar.pAp);
                if (list != null && dVar != null) {
                    ab.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", Integer.valueOf(list.size()));
                    for (a a : list) {
                        a.a(bVar.pAp, dVar.result, dVar.rawData, dVar.cvn, dVar.cvo);
                    }
                } else if (list != null) {
                    for (a a2 : list) {
                        a2.Vv(bVar.pAp);
                    }
                }
                bVar.ce.remove(bVar.pAp);
                bVar.pAo.remove(bVar.pAp);
                bVar.pAp = null;
                bVar.pAq = null;
                bVar.cdv();
                AppMethodBeat.o(80752);
            }
        });
        AppMethodBeat.o(80756);
        return 0;
    }
}
