package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.p069v7.p075h.C0595c.C0601b;
import android.support.p069v7.p075h.C44964d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1679e;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10133b;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10135a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26766ae.C26764a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38095c;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.C40511dk;
import com.tencent.p177mm.protocal.protobuf.cda;
import com.tencent.p177mm.protocal.protobuf.cdb;
import com.tencent.p177mm.protocal.protobuf.ckl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J=\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
@C1679e(C38095c.class)
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.c */
public final class C10120c implements C1694a, C1695b {
    public static final C10121a gYK = new C10121a();
    private final LinkedList<cdb> gYI = new LinkedList();
    private final C7564ap gYJ = new C7564ap(Looper.getMainLooper(), new C10124d(this), false);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$a */
    public static final class C10121a {
        private C10121a() {
        }

        public /* synthetic */ C10121a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$b */
    public interface C10122b {
        /* renamed from: b */
        void mo21481b(LocalUsageInfo localUsageInfo);

        /* renamed from: c */
        void mo21482c(LocalUsageInfo localUsageInfo);

        /* renamed from: d */
        void mo21483d(LocalUsageInfo localUsageInfo);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$c */
    public static final class C10123c implements C44964d {
        final /* synthetic */ C10120c gYL;
        final /* synthetic */ C0601b gYM;
        final /* synthetic */ PInt gYN;
        final /* synthetic */ List gYO;
        final /* synthetic */ C10122b gYP;
        final /* synthetic */ ArrayList gYQ;

        C10123c(C10120c c10120c, C0601b c0601b, PInt pInt, List list, C10122b c10122b, ArrayList arrayList) {
            this.gYL = c10120c;
            this.gYM = c0601b;
            this.gYN = pInt;
            this.gYO = list;
            this.gYP = c10122b;
            this.gYQ = arrayList;
        }

        /* renamed from: G */
        public final void mo1469G(int i, int i2) {
            LocalUsageInfo localUsageInfo;
            AppMethodBeat.m2504i(134491);
            PInt pInt = this.gYN;
            pInt.value += i2;
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + i + " count=" + i2);
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
                    C10122b c10122b = this.gYP;
                    if (c10122b != null) {
                        c10122b.mo21481b(localUsageInfo3);
                    }
                    C10120c c10120c = this.gYL;
                    C10135a c10135a = C10134z.hax;
                    cda a = C10120c.m17724a(localUsageInfo3);
                    if (a == null) {
                        C25052j.dWJ();
                    }
                    C10120c.m17725a(c10120c, C10135a.m17748a(a, C10120c.m17724a(localUsageInfo2), C10120c.m17724a(localUsageInfo)));
                    if (i == i3) {
                        break;
                    }
                    i++;
                }
            }
            AppMethodBeat.m2505o(134491);
        }

        /* renamed from: H */
        public final void mo1470H(int i, int i2) {
            AppMethodBeat.m2504i(134492);
            PInt pInt = this.gYN;
            pInt.value += i2;
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + i + " count=" + i2);
            int i3 = (i + i2) - 1;
            if (i <= i3) {
                int i4 = i;
                while (true) {
                    LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.gYQ.remove(i);
                    C10122b c10122b = this.gYP;
                    if (c10122b != null) {
                        C25052j.m39375o(localUsageInfo, "info");
                        c10122b.mo21483d(localUsageInfo);
                    }
                    C10120c c10120c = this.gYL;
                    C10135a c10135a = C10134z.hax;
                    cda a = C10120c.m17724a(localUsageInfo);
                    if (a == null) {
                        C25052j.dWJ();
                    }
                    C10120c.m17725a(c10120c, C10135a.m17749b(a));
                    if (i4 == i3) {
                        break;
                    }
                    i4++;
                }
            }
            AppMethodBeat.m2505o(134492);
        }

        /* renamed from: I */
        public final void mo1471I(int i, int i2) {
            LocalUsageInfo localUsageInfo;
            LocalUsageInfo localUsageInfo2 = null;
            AppMethodBeat.m2504i(134493);
            PInt pInt = this.gYN;
            pInt.value++;
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + i + " to " + i2);
            this.gYQ.add(i2, (LocalUsageInfo) this.gYQ.remove(i));
            Object obj = this.gYQ.get(i2);
            C25052j.m39375o(obj, "tempList[toPosition]");
            LocalUsageInfo localUsageInfo3 = (LocalUsageInfo) obj;
            if (i2 == 0) {
                localUsageInfo = null;
            } else {
                localUsageInfo = (LocalUsageInfo) this.gYQ.get(i2 - 1);
            }
            if (i2 + 1 != this.gYQ.size()) {
                localUsageInfo2 = (LocalUsageInfo) this.gYQ.get(i2 + 1);
            }
            C10122b c10122b = this.gYP;
            if (c10122b != null) {
                c10122b.mo21482c(localUsageInfo3);
            }
            C10120c c10120c = this.gYL;
            C10135a c10135a = C10134z.hax;
            cda a = C10120c.m17724a(localUsageInfo3);
            if (a == null) {
                C25052j.dWJ();
            }
            cda a2 = C10120c.m17724a(localUsageInfo);
            cda a3 = C10120c.m17724a(localUsageInfo2);
            C25052j.m39376p(a, "self");
            if (C10135a.axN()) {
                if (a2 == null && a3 == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (C44847aa.AUz && r0 == null) {
                    Throwable assertionError = new AssertionError("Assertion failed");
                    AppMethodBeat.m2505o(134493);
                    throw assertionError;
                }
            }
            cdb cdb = new cdb();
            cdb.xcI = a;
            cdb.xcL = 3;
            cdb.xcJ = a2;
            cdb.xcK = a3;
            C10120c.m17725a(c10120c, cdb);
            AppMethodBeat.m2505o(134493);
        }

        /* renamed from: a */
        public final void mo1472a(int i, int i2, Object obj) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$d */
    static final class C10124d implements C5015a {
        final /* synthetic */ C10120c gYL;

        C10124d(C10120c c10120c) {
            this.gYL = c10120c;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(134494);
            this.gYL.mo21478a(C10133b.Timeout);
            AppMethodBeat.m2505o(134494);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$e */
    static final class C10125e<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C10120c gYL;
        final /* synthetic */ C10133b gYR;
        final /* synthetic */ LinkedList gYS;

        C10125e(C10120c c10120c, C10133b c10133b, LinkedList linkedList) {
            this.gYL = c10120c;
            this.gYR = c10133b;
            this.gYS = linkedList;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134495);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "], cgi=[" + C42597a.m75416c(c37441a) + ']');
            if (C42597a.m75415b(c37441a)) {
                if (((ckl) c37441a.fsy).vXT != null) {
                    C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "], ErrCode=" + ((ckl) c37441a.fsy).vXT.luT);
                    switch (((ckl) c37441a.fsy).vXT.luT) {
                        case 0:
                            break;
                        case 10001:
                            C10120c.m17726a(this.gYL, (List) this.gYS);
                            break;
                        default:
                            C26764a c26764a = C26766ae.haH;
                            C26764a.m42597cQ(0, 3);
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.gYR.intValue + "] NULL wxa_resp");
            } else {
                C10120c.m17726a(this.gYL, (List) this.gYS);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134495);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(134503);
        AppMethodBeat.m2505o(134503);
    }

    public C10120c() {
        AppMethodBeat.m2504i(134502);
        AppMethodBeat.m2505o(134502);
    }

    /* renamed from: a */
    public final boolean mo21480a(C0601b c0601b, List<? extends LocalUsageInfo> list, List<? extends LocalUsageInfo> list2, C10122b c10122b) {
        AppMethodBeat.m2504i(134498);
        C25052j.m39376p(c0601b, "diff");
        C25052j.m39376p(list, "oldList");
        C25052j.m39376p(list2, "newList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        PInt pInt = new PInt(0);
        synchronized (this.gYI) {
            try {
                c0601b.mo1479a((C44964d) new C10123c(this, c0601b, pInt, list2, c10122b, arrayList));
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(134498);
            }
        }
        if (pInt.value > 0) {
            return true;
        }
        AppMethodBeat.m2505o(134498);
        return false;
    }

    /* renamed from: a */
    public final void mo21479a(cdb cdb, C10133b c10133b) {
        AppMethodBeat.m2504i(134499);
        C25052j.m39376p(cdb, "op");
        C25052j.m39376p(c10133b, "reason");
        synchronized (this.gYI) {
            try {
                this.gYI.addLast(cdb);
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(134499);
            }
        }
        switch (C10126d.eQZ[c10133b.ordinal()]) {
            case 1:
                this.gYJ.mo16773ms(30000);
                AppMethodBeat.m2505o(134499);
                return;
            default:
                mo21478a(c10133b);
                break;
        }
        AppMethodBeat.m2505o(134499);
    }

    /* renamed from: a */
    public final void mo21478a(C10133b c10133b) {
        AppMethodBeat.m2504i(134501);
        C25052j.m39376p(c10133b, "reason");
        C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + c10133b.name());
        this.gYJ.stopTimer();
        LinkedList linkedList = new LinkedList();
        synchronized (this.gYI) {
            try {
                linkedList.addAll(this.gYI);
                this.gYI.clear();
                C37091y c37091y = C37091y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134501);
            }
        }
        if (linkedList.isEmpty()) {
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + c10133b.intValue + "], queue empty");
            if (c10133b == C10133b.ClosePullDown || c10133b == C10133b.CloseCollectionList) {
                C26764a c26764a = C26766ae.haH;
                C26764a.m42597cQ(2, 2);
            }
            AppMethodBeat.m2505o(134501);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + c10133b.intValue + "], queue_size=" + linkedList.size());
        new C10134z(linkedList, c10133b.intValue).acy().mo60494j(new C10125e(this, c10133b, linkedList));
        AppMethodBeat.m2505o(134501);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: SH */
    public final void mo5202SH() {
        AppMethodBeat.m2504i(134496);
        byte[] DH = C42340f.auZ().mo34911DH("AppBrandCollectionModifyQueue");
        if (DH != null) {
            if ((DH.length == 0 ? 1 : null) == null) {
                C42340f.auZ().clear("AppBrandCollectionModifyQueue");
                try {
                    C40511dk c40511dk = new C40511dk();
                    c40511dk.parseFrom(DH);
                    synchronized (this.gYI) {
                        this.gYI.addAll(c40511dk.eow);
                    }
                    AppMethodBeat.m2505o(134496);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(e)));
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(134496);
                }
            }
            AppMethodBeat.m2505o(134496);
            return;
        }
        AppMethodBeat.m2505o(134496);
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        AppMethodBeat.m2504i(134497);
        C40511dk c40511dk = new C40511dk();
        synchronized (this.gYI) {
            try {
                c40511dk.eow.addAll(this.gYI);
            } finally {
                AppMethodBeat.m2505o(134497);
            }
        }
        if (!c40511dk.eow.isEmpty()) {
            try {
                C42340f.auZ().mo34914s("AppBrandCollectionModifyQueue", c40511dk.toByteArray());
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "serializeToDisk, write kv failed, e = ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.m2505o(134497);
    }
}
