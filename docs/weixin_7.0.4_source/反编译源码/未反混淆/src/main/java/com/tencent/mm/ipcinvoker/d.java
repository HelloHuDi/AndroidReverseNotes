package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class d {
    public String eFV;

    static abstract class c implements e {
        String token;

        c(String str) {
            this.token = str;
            Assert.assertNotNull(str);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.token.equals(((c) obj).token);
        }
    }

    public static class b implements a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(114019);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("Token");
            com.tencent.mm.ipcinvoker.d.c.PT().b(bundle.getString("Event"), new c(string) {
                public final /* bridge */ /* synthetic */ void ao(Object obj) {
                }
            });
            AppMethodBeat.o(114019);
        }
    }

    public static class a implements a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(114018);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("Token");
            com.tencent.mm.ipcinvoker.d.c.PT().a(bundle.getString("Event"), new c(string) {
                public final /* bridge */ /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(114017);
                    cVar.ao((Bundle) obj);
                    AppMethodBeat.o(114017);
                }
            });
            AppMethodBeat.o(114018);
        }
    }

    public d(String str) {
        this.eFV = str;
    }

    public static String ap(Object obj) {
        AppMethodBeat.i(114020);
        String str = "Token#IPCObserver#" + obj.hashCode();
        AppMethodBeat.o(114020);
        return str;
    }
}
