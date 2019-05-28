package com.tencent.p177mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p854d.C32714e;
import com.tencent.p177mm.ipcinvoker.p854d.C37867c;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ipcinvoker.d */
public final class C26330d {
    public String eFV;

    /* renamed from: com.tencent.mm.ipcinvoker.d$c */
    static abstract class C26328c implements C32714e {
        String token;

        C26328c(String str) {
            this.token = str;
            Assert.assertNotNull(str);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C26328c)) {
                return false;
            }
            return this.token.equals(((C26328c) obj).token);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.d$b */
    public static class C26331b implements C37866a<Bundle, Bundle> {
        private C26331b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(114019);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("Token");
            C37867c.m63901PT().mo60590b(bundle.getString("Event"), new C26328c(string) {
                /* renamed from: ao */
                public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
                }
            });
            AppMethodBeat.m2505o(114019);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.d$a */
    public static class C26333a implements C37866a<Bundle, Bundle> {
        private C26333a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(114018);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("Token");
            C37867c.m63901PT().mo60589a(bundle.getString("Event"), new C26328c(string) {
                /* renamed from: ao */
                public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(114017);
                    c18507c.mo5960ao((Bundle) obj);
                    AppMethodBeat.m2505o(114017);
                }
            });
            AppMethodBeat.m2505o(114018);
        }
    }

    public C26330d(String str) {
        this.eFV = str;
    }

    /* renamed from: ap */
    public static String m41900ap(Object obj) {
        AppMethodBeat.m2504i(114020);
        String str = "Token#IPCObserver#" + obj.hashCode();
        AppMethodBeat.m2505o(114020);
        return str;
    }
}
