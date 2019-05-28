package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.c.a;
import com.google.android.exoplayer2.f.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface g {
    public static final g bld = new g() {
        public final boolean g(Format format) {
            AppMethodBeat.i(95654);
            String str = format.aOd;
            if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str)) {
                AppMethodBeat.o(95654);
                return true;
            }
            AppMethodBeat.o(95654);
            return false;
        }

        public final e k(Format format) {
            AppMethodBeat.i(95655);
            String str = format.aOd;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        obj = 9;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        obj = null;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            e aVar;
            switch (obj) {
                case null:
                    com.google.android.exoplayer2.f.g.g gVar = new com.google.android.exoplayer2.f.g.g();
                    AppMethodBeat.o(95655);
                    return gVar;
                case 1:
                    aVar = new a(format.aOf);
                    AppMethodBeat.o(95655);
                    return aVar;
                case 2:
                    aVar = new b();
                    AppMethodBeat.o(95655);
                    return aVar;
                case 3:
                    aVar = new com.google.android.exoplayer2.f.e.a();
                    AppMethodBeat.o(95655);
                    return aVar;
                case 4:
                    aVar = new com.google.android.exoplayer2.f.d.a();
                    AppMethodBeat.o(95655);
                    return aVar;
                case 5:
                    aVar = new com.google.android.exoplayer2.f.f.a(format.aOf);
                    AppMethodBeat.o(95655);
                    return aVar;
                case 6:
                case 7:
                    aVar = new com.google.android.exoplayer2.f.a.a(format.aOd, format.aOu);
                    AppMethodBeat.o(95655);
                    return aVar;
                case 8:
                    aVar = new c(format.aOu);
                    AppMethodBeat.o(95655);
                    return aVar;
                case 9:
                    aVar = new com.google.android.exoplayer2.f.b.a(format.aOf);
                    AppMethodBeat.o(95655);
                    return aVar;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.o(95655);
                    throw illegalArgumentException;
            }
        }
    };

    boolean g(Format format);

    e k(Format format);
}
