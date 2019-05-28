package p000a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"})
/* renamed from: a.n */
public final class C31825n extends Error {
    private /* synthetic */ C31825n() {
        this("An operation is not implemented.");
        AppMethodBeat.m2504i(56425);
        AppMethodBeat.m2505o(56425);
    }

    public C31825n(String str) {
        C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        super(str);
        AppMethodBeat.m2504i(56424);
        AppMethodBeat.m2505o(56424);
    }
}
