package com.tencent.p177mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;
import com.tencent.p177mm.plugin.readerapp.p490ui.C12948b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.readerapp.Plugin */
public final class Plugin implements C40415c {
    private C44040b jJC = new C347801();

    /* renamed from: com.tencent.mm.plugin.readerapp.Plugin$1 */
    class C347801 implements C44040b {
        C347801() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            AppMethodBeat.m2504i(76736);
            C4990ab.m7417i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", str);
            if ("widget_type_news".equals(str)) {
                C12948b c12948b = new C12948b(context);
                AppMethodBeat.m2505o(76736);
                return c12948b;
            }
            AppMethodBeat.m2505o(76736);
            return null;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(76737);
        AppMethodBeat.m2505o(76737);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(76738);
        C46155a c46155a = new C46155a();
        AppMethodBeat.m2505o(76738);
        return c46155a;
    }

    public final C44040b getContactWidgetFactory() {
        return this.jJC;
    }

    public final C1816at createSubCore() {
        return null;
    }
}
