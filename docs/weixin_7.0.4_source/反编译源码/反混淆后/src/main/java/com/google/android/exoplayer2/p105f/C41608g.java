package com.google.android.exoplayer2.p105f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p105f.p106b.C17657a;
import com.google.android.exoplayer2.p105f.p107f.C0856a;
import com.google.android.exoplayer2.p105f.p108g.C25536g;
import com.google.android.exoplayer2.p105f.p108g.C32048b;
import com.google.android.exoplayer2.p105f.p1371d.C37252a;
import com.google.android.exoplayer2.p105f.p1586c.C41604a;
import com.google.android.exoplayer2.p105f.p798a.C36686c;
import com.google.android.exoplayer2.p105f.p798a.C8669a;
import com.google.android.exoplayer2.p105f.p799e.C16512a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.g */
public interface C41608g {
    public static final C41608g bld = new C416091();

    /* renamed from: com.google.android.exoplayer2.f.g$1 */
    static class C416091 implements C41608g {
        C416091() {
        }

        /* renamed from: g */
        public final boolean mo66737g(Format format) {
            AppMethodBeat.m2504i(95654);
            String str = format.aOd;
            if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str)) {
                AppMethodBeat.m2505o(95654);
                return true;
            }
            AppMethodBeat.m2505o(95654);
            return false;
        }

        /* renamed from: k */
        public final C41606e mo66738k(Format format) {
            AppMethodBeat.m2504i(95655);
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
            C41606e c41604a;
            switch (obj) {
                case null:
                    C25536g c25536g = new C25536g();
                    AppMethodBeat.m2505o(95655);
                    return c25536g;
                case 1:
                    c41604a = new C41604a(format.aOf);
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 2:
                    c41604a = new C32048b();
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 3:
                    c41604a = new C16512a();
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 4:
                    c41604a = new C37252a();
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 5:
                    c41604a = new C0856a(format.aOf);
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 6:
                case 7:
                    c41604a = new C8669a(format.aOd, format.aOu);
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 8:
                    c41604a = new C36686c(format.aOu);
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                case 9:
                    c41604a = new C17657a(format.aOf);
                    AppMethodBeat.m2505o(95655);
                    return c41604a;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.m2505o(95655);
                    throw illegalArgumentException;
            }
        }
    }

    /* renamed from: g */
    boolean mo66737g(Format format);

    /* renamed from: k */
    C41606e mo66738k(Format format);
}
