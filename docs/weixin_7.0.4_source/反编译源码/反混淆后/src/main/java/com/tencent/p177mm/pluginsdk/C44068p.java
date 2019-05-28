package com.tencent.p177mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C43536g;
import com.tencent.p177mm.pluginsdk.p1336a.C23232c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.pluginsdk.p */
public interface C44068p {

    /* renamed from: com.tencent.mm.pluginsdk.p$a */
    public static class C14896a {
        public static C30087b vav;

        public static C30087b dgQ() {
            AppMethodBeat.m2504i(27227);
            if (vav == null) {
                C4990ab.m7420w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
                vav = new C23232c();
            }
            C30087b c30087b = vav;
            AppMethodBeat.m2505o(27227);
            return c30087b;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.p$d */
    public static class C14898d {
        public static C43536g dgR() {
            return C21877n.qFD;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.p$b */
    public interface C30087b {
        int cjL();

        void cjM();

        boolean cjN();

        void cjO();

        void cjP();

        boolean cjQ();
    }

    /* renamed from: com.tencent.mm.pluginsdk.p$c */
    public interface C30088c {

        /* renamed from: com.tencent.mm.pluginsdk.p$c$a */
        public interface C14897a {
            String cUp();

            void cUq();

            boolean cUr();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.p$e */
    public static class C30089e {
        public static C14897a vaw;
    }
}
