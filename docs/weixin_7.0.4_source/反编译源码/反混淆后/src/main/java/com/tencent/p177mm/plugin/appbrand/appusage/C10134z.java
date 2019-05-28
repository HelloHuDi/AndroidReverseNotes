package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cda;
import com.tencent.p177mm.protocal.protobuf.cdb;
import com.tencent.p177mm.protocal.protobuf.ckk;
import com.tencent.p177mm.protocal.protobuf.ckl;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.util.List;
import p000a.C0220l;
import p000a.C44847aa;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u001d\b\u0010\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.z */
public final class C10134z extends C37440a<ckl> {
    private static final int[] haw = new int[]{1, 2, 3, 4};
    public static final C10135a hax = new C10135a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.z$b */
    public enum C10133b {
        None(0),
        Timeout(1),
        ClosePullDown(2),
        CloseCollectionList(3),
        History(4);
        
        final int intValue;

        private C10133b(int i) {
            this.intValue = i;
        }

        static {
            AppMethodBeat.m2505o(134547);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.z$a */
    public static final class C10135a {
        private C10135a() {
        }

        public /* synthetic */ C10135a(byte b) {
            this();
        }

        static boolean axN() {
            return C5058f.IS_FLAVOR_RED;
        }

        /* renamed from: a */
        public static cdb m17748a(cda cda, cda cda2, cda cda3) {
            AppMethodBeat.m2504i(134544);
            C25052j.m39376p(cda, "self");
            cdb a = C10135a.m17747a(1, cda, cda2, cda3);
            AppMethodBeat.m2505o(134544);
            return a;
        }

        /* renamed from: a */
        private static cdb m17747a(int i, cda cda, cda cda2, cda cda3) {
            AppMethodBeat.m2504i(134546);
            cdb cdb = new cdb();
            cdb.xcI = cda;
            cdb.xcL = i;
            cdb.xcJ = cda2;
            cdb.xcK = cda3;
            AppMethodBeat.m2505o(134546);
            return cdb;
        }

        /* renamed from: b */
        public static cdb m17749b(cda cda) {
            AppMethodBeat.m2504i(134545);
            C25052j.m39376p(cda, "self");
            cdb a = C10135a.m17747a(2, cda, null, null);
            AppMethodBeat.m2505o(134545);
            return a;
        }
    }

    /* renamed from: b */
    public static final cdb m17746b(cda cda) {
        AppMethodBeat.m2504i(134553);
        cdb b = C10135a.m17749b(cda);
        AppMethodBeat.m2505o(134553);
        return b;
    }

    public C10134z(List<? extends cdb> list, int i) {
        C25052j.m39376p(list, "opList");
        AppMethodBeat.m2504i(134550);
        if (C10135a.axN()) {
            Object obj = (list.isEmpty() || !C36913i.contains(haw, i)) ? null : 1;
            if (C44847aa.AUz && obj == null) {
                Throwable assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.m2505o(134550);
                throw assertionError;
            }
        }
        C1196a c1196a = new C1196a();
        c1196a.mo4446b(new ckl());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
        c1196a.mo4447kU(1839);
        ckk ckk = new ckk();
        ckk.xip.addAll(list);
        ckk.boZ = i;
        c1196a.mo4444a(ckk);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134550);
    }

    static {
        AppMethodBeat.m2504i(134551);
        AppMethodBeat.m2505o(134551);
    }

    /* renamed from: a */
    public static final cdb m17745a(cda cda) {
        AppMethodBeat.m2504i(134552);
        cdb a = C10135a.m17748a(cda, null, null);
        AppMethodBeat.m2505o(134552);
        return a;
    }
}
