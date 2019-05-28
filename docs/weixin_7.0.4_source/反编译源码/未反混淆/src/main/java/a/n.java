package a;

import a.f.b.j;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"})
public final class n extends Error {
    private /* synthetic */ n() {
        this("An operation is not implemented.");
        AppMethodBeat.i(56425);
        AppMethodBeat.o(56425);
    }

    public n(String str) {
        j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        super(str);
        AppMethodBeat.i(56424);
        AppMethodBeat.o(56424);
    }
}
