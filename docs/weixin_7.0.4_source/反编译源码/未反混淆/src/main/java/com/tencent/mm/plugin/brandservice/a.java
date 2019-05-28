package com.tencent.mm.plugin.brandservice;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final String jKe = jKe;
    public static final a jKf = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "init", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(14760);
        if (strArr != null && j.j(jKe, strArr[0])) {
            as eg;
            if (j.j("openbiztimeline", strArr[1]) && strArr.length > 2) {
                eg = as.eg("brandService", 1);
                eg.encode("BizTimeLineOpenStatus", bo.getInt(strArr[2], -1));
                eg.apply();
                AppMethodBeat.o(14760);
                return true;
            } else if (j.j("deleteolddata", strArr[1]) && strArr.length > 2) {
                eg = as.eg("brandService", 1);
                eg.encode("BizTimeLineDeleteOldData", bo.getInt(strArr[2], -1));
                eg.apply();
                AppMethodBeat.o(14760);
                return true;
            }
        }
        AppMethodBeat.o(14760);
        return false;
    }

    static {
        AppMethodBeat.i(14761);
        AppMethodBeat.o(14761);
    }
}
