package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.id3.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    public static final c beX = new c() {
        public final boolean g(Format format) {
            AppMethodBeat.i(95347);
            String str = format.aOd;
            if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
                AppMethodBeat.o(95347);
                return true;
            }
            AppMethodBeat.o(95347);
            return false;
        }

        public final a h(Format format) {
            AppMethodBeat.i(95348);
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
            a aVar;
            switch (obj) {
                case null:
                    a aVar2 = new a();
                    AppMethodBeat.o(95348);
                    return aVar2;
                case 1:
                    aVar = new com.google.android.exoplayer2.metadata.emsg.a();
                    AppMethodBeat.o(95348);
                    return aVar;
                case 2:
                    aVar = new com.google.android.exoplayer2.metadata.scte35.a();
                    AppMethodBeat.o(95348);
                    return aVar;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.o(95348);
                    throw illegalArgumentException;
            }
        }
    };

    boolean g(Format format);

    a h(Format format);
}
