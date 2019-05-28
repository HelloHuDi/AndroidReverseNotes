package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.e */
public final class C45520e extends C1812ai {
    @Deprecated
    public static final C19103a gYT = new C19103a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.e$a */
    static final class C19103a {
        private C19103a() {
        }

        public /* synthetic */ C19103a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(134508);
        AppMethodBeat.m2505o(134508);
    }

    public final String getTag() {
        return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(134506);
        try {
            C42340f.auL().auM().mo10108hY("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.m2505o(134506);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", th, "transfer failed", new Object[0]);
            AppMethodBeat.m2505o(134506);
        }
    }

    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        AppMethodBeat.m2504i(134507);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        boolean z = RP.mo5239Ry().getBoolean(C5127a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, false);
        C4990ab.m7410d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(z)));
        if (z) {
            AppMethodBeat.m2505o(134507);
            return false;
        }
        AppMethodBeat.m2505o(134507);
        return true;
    }
}
