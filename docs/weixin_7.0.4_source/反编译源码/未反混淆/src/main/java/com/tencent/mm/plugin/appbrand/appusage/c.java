package com.tencent.mm.plugin.appbrand.appusage;

import a.aa;
import a.f.b.j;
import a.l;
import a.y;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J=\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
@com.tencent.mm.kernel.b.e(com.tencent.mm.plugin.appbrand.a.c.class)
public final class c implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b {
    public static final a gYK = new a();
    private final LinkedList<cdb> gYI = new LinkedList();
    private final ap gYJ = new ap(Looper.getMainLooper(), new d(this), false);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
    public interface b {
        void b(LocalUsageInfo localUsageInfo);

        void c(LocalUsageInfo localUsageInfo);

        void d(LocalUsageInfo localUsageInfo);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
    public static final class c implements android.support.v7.h.d {
        final /* synthetic */ c gYL;
        final /* synthetic */ android.support.v7.h.c.b gYM;
        final /* synthetic */ PInt gYN;
        final /* synthetic */ List gYO;
        final /* synthetic */ b gYP;
        final /* synthetic */ ArrayList gYQ;

        c(c cVar, android.support.v7.h.c.b bVar, PInt pInt, List list, b bVar2, ArrayList arrayList) {
            this.gYL = cVar;
            this.gYM = bVar;
            this.gYN = pInt;
            this.gYO = list;
            this.gYP = bVar2;
            this.gYQ = arrayList;
        }

        public final void G(int i, int i2) {
            LocalUsageInfo localUsageInfo;
            AppMethodBeat.i(134491);
            PInt pInt = this.gYN;
            pInt.value += i2;
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + i + " count=" + i2);
            if (i + i2 == this.gYO.size()) {
                localUsageInfo = null;
            } else {
                localUsageInfo = (LocalUsageInfo) this.gYO.get(i + i2);
            }
            int i3 = (i + i2) - 1;
            if (i <= i3) {
                while (true) {
                    LocalUsageInfo localUsageInfo2;
                    LocalUsageInfo localUsageInfo3 = (LocalUsageInfo) this.gYO.get(i);
                    if (i == 0) {
                        localUsageInfo2 = null;
                    } else {
                        localUsageInfo2 = (LocalUsageInfo) this.gYO.get(i - 1);
                    }
                    b bVar = this.gYP;
                    if (bVar != null) {
                        bVar.b(localUsageInfo3);
                    }
                    c cVar = this.gYL;
                    com.tencent.mm.plugin.appbrand.appusage.z.a aVar = z.hax;
                    cda a = c.a(localUsageInfo3);
                    if (a == null) {
                        j.dWJ();
                    }
                    c.a(cVar, com.tencent.mm.plugin.appbrand.appusage.z.a.a(a, c.a(localUsageInfo2), c.a(localUsageInfo)));
                    if (i == i3) {
                        break;
                    }
                    i++;
                }
            }
            AppMethodBeat.o(134491);
        }

        public final void H(int i, int i2) {
            AppMethodBeat.i(134492);
            PInt pInt = this.gYN;
            pInt.value += i2;
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + i + " count=" + i2);
            int i3 = (i + i2) - 1;
            if (i <= i3) {
                int i4 = i;
                while (true) {
                    LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.gYQ.remove(i);
                    b bVar = this.gYP;
                    if (bVar != null) {
                        j.o(localUsageInfo, "info");
                        bVar.d(localUsageInfo);
                    }
                    c cVar = this.gYL;
                    com.tencent.mm.plugin.appbrand.appusage.z.a aVar = z.hax;
                    cda a = c.a(localUsageInfo);
                    if (a == null) {
                        j.dWJ();
                    }
                    c.a(cVar, com.tencent.mm.plugin.appbrand.appusage.z.a.b(a));
                    if (i4 == i3) {
                        break;
                    }
                    i4++;
                }
            }
            AppMethodBeat.o(134492);
        }

        public final void I(int i, int i2) {
            LocalUsageInfo localUsageInfo;
            LocalUsageInfo localUsageInfo2 = null;
            AppMethodBeat.i(134493);
            PInt pInt = this.gYN;
            pInt.value++;
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + i + " to " + i2);
            this.gYQ.add(i2, (LocalUsageInfo) this.gYQ.remove(i));
            Object obj = this.gYQ.get(i2);
            j.o(obj, "tempList[toPosition]");
            LocalUsageInfo localUsageInfo3 = (LocalUsageInfo) obj;
            if (i2 == 0) {
                localUsageInfo = null;
            } else {
                localUsageInfo = (LocalUsageInfo) this.gYQ.get(i2 - 1);
            }
            if (i2 + 1 != this.gYQ.size()) {
                localUsageInfo2 = (LocalUsageInfo) this.gYQ.get(i2 + 1);
            }
            b bVar = this.gYP;
            if (bVar != null) {
                bVar.c(localUsageInfo3);
            }
            c cVar = this.gYL;
            com.tencent.mm.plugin.appbrand.appusage.z.a aVar = z.hax;
            cda a = c.a(localUsageInfo3);
            if (a == null) {
                j.dWJ();
            }
            cda a2 = c.a(localUsageInfo);
            cda a3 = c.a(localUsageInfo2);
            j.p(a, "self");
            if (com.tencent.mm.plugin.appbrand.appusage.z.a.axN()) {
                if (a2 == null && a3 == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (aa.AUz && r0 == null) {
                    Throwable assertionError = new AssertionError("Assertion failed");
                    AppMethodBeat.o(134493);
                    throw assertionError;
                }
            }
            cdb cdb = new cdb();
            cdb.xcI = a;
            cdb.xcL = 3;
            cdb.xcJ = a2;
            cdb.xcK = a3;
            c.a(cVar, cdb);
            AppMethodBeat.o(134493);
        }

        public final void a(int i, int i2, Object obj) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    static final class d implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ c gYL;

        d(c cVar) {
            this.gYL = cVar;
        }

        public final boolean BI() {
            AppMethodBeat.i(134494);
            this.gYL.a(com.tencent.mm.plugin.appbrand.appusage.z.b.Timeout);
            AppMethodBeat.o(134494);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c gYL;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.appusage.z.b gYR;
        final /* synthetic */ LinkedList gYS;

        e(c cVar, com.tencent.mm.plugin.appbrand.appusage.z.b bVar, LinkedList linkedList) {
            this.gYL = cVar;
            this.gYR = bVar;
            this.gYS = linkedList;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134495);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "], cgi=[" + com.tencent.mm.plugin.appbrand.k.a.c(aVar) + ']');
            if (com.tencent.mm.plugin.appbrand.k.a.b(aVar)) {
                if (((ckl) aVar.fsy).vXT != null) {
                    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "], ErrCode=" + ((ckl) aVar.fsy).vXT.luT);
                    switch (((ckl) aVar.fsy).vXT.luT) {
                        case 0:
                            break;
                        case 10001:
                            c.a(this.gYL, (List) this.gYS);
                            break;
                        default:
                            com.tencent.mm.plugin.appbrand.appusage.ae.a aVar2 = ae.haH;
                            com.tencent.mm.plugin.appbrand.appusage.ae.a.cQ(0, 3);
                            break;
                    }
                }
                ab.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "] NULL wxa_resp");
            } else {
                c.a(this.gYL, (List) this.gYS);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134495);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(134503);
        AppMethodBeat.o(134503);
    }

    public c() {
        AppMethodBeat.i(134502);
        AppMethodBeat.o(134502);
    }

    public final boolean a(android.support.v7.h.c.b bVar, List<? extends LocalUsageInfo> list, List<? extends LocalUsageInfo> list2, b bVar2) {
        AppMethodBeat.i(134498);
        j.p(bVar, "diff");
        j.p(list, "oldList");
        j.p(list2, "newList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        PInt pInt = new PInt(0);
        synchronized (this.gYI) {
            try {
                bVar.a((android.support.v7.h.d) new c(this, bVar, pInt, list2, bVar2, arrayList));
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(134498);
            }
        }
        if (pInt.value > 0) {
            return true;
        }
        AppMethodBeat.o(134498);
        return false;
    }

    public final void a(cdb cdb, com.tencent.mm.plugin.appbrand.appusage.z.b bVar) {
        AppMethodBeat.i(134499);
        j.p(cdb, "op");
        j.p(bVar, "reason");
        synchronized (this.gYI) {
            try {
                this.gYI.addLast(cdb);
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(134499);
            }
        }
        switch (d.eQZ[bVar.ordinal()]) {
            case 1:
                this.gYJ.ms(30000);
                AppMethodBeat.o(134499);
                return;
            default:
                a(bVar);
                break;
        }
        AppMethodBeat.o(134499);
    }

    public final void a(com.tencent.mm.plugin.appbrand.appusage.z.b bVar) {
        AppMethodBeat.i(134501);
        j.p(bVar, "reason");
        ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + bVar.name());
        this.gYJ.stopTimer();
        LinkedList linkedList = new LinkedList();
        synchronized (this.gYI) {
            try {
                linkedList.addAll(this.gYI);
                this.gYI.clear();
                y yVar = y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.o(134501);
            }
        }
        if (linkedList.isEmpty()) {
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + bVar.intValue + "], queue empty");
            if (bVar == com.tencent.mm.plugin.appbrand.appusage.z.b.ClosePullDown || bVar == com.tencent.mm.plugin.appbrand.appusage.z.b.CloseCollectionList) {
                com.tencent.mm.plugin.appbrand.appusage.ae.a aVar = ae.haH;
                com.tencent.mm.plugin.appbrand.appusage.ae.a.cQ(2, 2);
            }
            AppMethodBeat.o(134501);
            return;
        }
        ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + bVar.intValue + "], queue_size=" + linkedList.size());
        new z(linkedList, bVar.intValue).acy().j(new e(this, bVar, linkedList));
        AppMethodBeat.o(134501);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void SH() {
        AppMethodBeat.i(134496);
        byte[] DH = f.auZ().DH("AppBrandCollectionModifyQueue");
        if (DH != null) {
            if ((DH.length == 0 ? 1 : null) == null) {
                f.auZ().clear("AppBrandCollectionModifyQueue");
                try {
                    dk dkVar = new dk();
                    dkVar.parseFrom(DH);
                    synchronized (this.gYI) {
                        this.gYI.addAll(dkVar.eow);
                    }
                    AppMethodBeat.o(134496);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(e)));
                } catch (Throwable th) {
                    AppMethodBeat.o(134496);
                }
            }
            AppMethodBeat.o(134496);
            return;
        }
        AppMethodBeat.o(134496);
    }

    public final void SI() {
        AppMethodBeat.i(134497);
        dk dkVar = new dk();
        synchronized (this.gYI) {
            try {
                dkVar.eow.addAll(this.gYI);
            } finally {
                AppMethodBeat.o(134497);
            }
        }
        if (!dkVar.eow.isEmpty()) {
            try {
                f.auZ().s("AppBrandCollectionModifyQueue", dkVar.toByteArray());
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "serializeToDisk, write kv failed, e = ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.o(134497);
    }
}
