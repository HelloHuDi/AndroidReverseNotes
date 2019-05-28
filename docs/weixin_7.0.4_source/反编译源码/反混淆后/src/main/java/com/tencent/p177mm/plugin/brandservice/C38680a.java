package com.tencent.p177mm.plugin.brandservice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.a */
public final class C38680a implements C44041a {
    private static final String jKe = jKe;
    public static final C38681a jKf = new C38681a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "init", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.a$a */
    public static final class C38681a {
        private C38681a() {
        }

        public /* synthetic */ C38681a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(14760);
        if (strArr != null && C25052j.m39373j(jKe, strArr[0])) {
            C5018as eg;
            if (C25052j.m39373j("openbiztimeline", strArr[1]) && strArr.length > 2) {
                eg = C5018as.m7465eg("brandService", 1);
                eg.encode("BizTimeLineOpenStatus", C5046bo.getInt(strArr[2], -1));
                eg.apply();
                AppMethodBeat.m2505o(14760);
                return true;
            } else if (C25052j.m39373j("deleteolddata", strArr[1]) && strArr.length > 2) {
                eg = C5018as.m7465eg("brandService", 1);
                eg.encode("BizTimeLineDeleteOldData", C5046bo.getInt(strArr[2], -1));
                eg.apply();
                AppMethodBeat.m2505o(14760);
                return true;
            }
        }
        AppMethodBeat.m2505o(14760);
        return false;
    }

    static {
        AppMethodBeat.m2504i(14761);
        AppMethodBeat.m2505o(14761);
    }
}
