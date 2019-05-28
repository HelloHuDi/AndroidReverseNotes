package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e extends ai {
    @Deprecated
    public static final a gYT = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(134508);
        AppMethodBeat.o(134508);
    }

    public final String getTag() {
        return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.i(134506);
        try {
            f.auL().auM().hY("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
            com.tencent.mm.kernel.e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(134506);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", th, "transfer failed", new Object[0]);
            AppMethodBeat.o(134506);
        }
    }

    public final boolean kw(int i) {
        AppMethodBeat.i(134507);
        com.tencent.mm.kernel.e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        boolean z = RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, false);
        ab.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(z)));
        if (z) {
            AppMethodBeat.o(134507);
            return false;
        }
        AppMethodBeat.o(134507);
        return true;
    }
}
