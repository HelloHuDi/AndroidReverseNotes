package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
final class n extends a {
    final String hgU;

    /* JADX WARNING: Missing block: B:5:0x0016, code skipped:
            if (a.f.b.j.j(r3.hgU, ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n) r4).hgU) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(134753);
        if (this != obj) {
            if (obj instanceof n) {
            }
            AppMethodBeat.o(134753);
            return false;
        }
        AppMethodBeat.o(134753);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(134752);
        String str = this.hgU;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(134752);
            return hashCode;
        }
        AppMethodBeat.o(134752);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(134751);
        String str = "InvokeCallbackContext(transitiveData=" + this.hgU + ")";
        AppMethodBeat.o(134751);
        return str;
    }

    public n(String str) {
        super();
        this.hgU = str;
    }
}
