package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.protocal.protobuf.arc;

public interface n {

    public interface b {
        void a(WxaPkgLoadProgress wxaPkgLoadProgress);
    }

    public static class a {
        static n f(String str, String str2, int i, int i2) {
            AppMethodBeat.i(131817);
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
                v vVar = new v(str, str2, i2);
                AppMethodBeat.o(131817);
                return vVar;
            }
            n wVar = new w(str, str2, i);
            AppMethodBeat.o(131817);
            return wVar;
        }
    }

    public static abstract class c {
        /* Access modifiers changed, original: 0000 */
        public void aHm() {
        }

        /* Access modifiers changed, original: 0000 */
        public void aHn() {
        }

        /* Access modifiers changed, original: 0000 */
        public void aHo() {
        }

        /* Access modifiers changed, original: 0000 */
        public void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        }

        public void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        }

        public void a(com.tencent.mm.ai.a.a<arc> aVar) {
        }
    }

    public static class d {
        static n b(String str, String str2, int i, int i2, int i3) {
            AppMethodBeat.i(131818);
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
                v vVar = new v(str, str2, i2, i3);
                AppMethodBeat.o(131818);
                return vVar;
            }
            n wVar = new w(str, str2, i, i3);
            AppMethodBeat.o(131818);
            return wVar;
        }
    }

    void a(b bVar);

    void a(c cVar);

    void prepareAsync();
}
