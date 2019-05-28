package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.C8695a;
import com.google.android.exoplayer2.metadata.id3.C41620a;
import com.google.android.exoplayer2.metadata.scte35.C8702a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.metadata.c */
public interface C37266c {
    public static final C37266c beX = new C176801();

    /* renamed from: com.google.android.exoplayer2.metadata.c$1 */
    static class C176801 implements C37266c {
        C176801() {
        }

        /* renamed from: g */
        public final boolean mo32377g(Format format) {
            AppMethodBeat.m2504i(95347);
            String str = format.aOd;
            if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
                AppMethodBeat.m2505o(95347);
                return true;
            }
            AppMethodBeat.m2505o(95347);
            return false;
        }

        /* renamed from: h */
        public final C17679a mo32378h(Format format) {
            AppMethodBeat.m2504i(95348);
            String str = format.aOd;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1248341703:
                    if (str.equals("application/id3")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            C17679a c8695a;
            switch (obj) {
                case null:
                    C41620a c41620a = new C41620a();
                    AppMethodBeat.m2505o(95348);
                    return c41620a;
                case 1:
                    c8695a = new C8695a();
                    AppMethodBeat.m2505o(95348);
                    return c8695a;
                case 2:
                    c8695a = new C8702a();
                    AppMethodBeat.m2505o(95348);
                    return c8695a;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.m2505o(95348);
                    throw illegalArgumentException;
            }
        }
    }

    /* renamed from: g */
    boolean mo32377g(Format format);

    /* renamed from: h */
    C17679a mo32378h(Format format);
}
