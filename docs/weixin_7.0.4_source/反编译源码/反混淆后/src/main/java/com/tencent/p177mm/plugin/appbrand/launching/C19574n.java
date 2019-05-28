package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.protocal.protobuf.arc;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.n */
public interface C19574n {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.n$b */
    public interface C10598b {
        /* renamed from: a */
        void mo22111a(WxaPkgLoadProgress wxaPkgLoadProgress);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.n$a */
    public static class C19575a {
        /* renamed from: f */
        static C19574n m30349f(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(131817);
            if (C33097a.m54090np(i)) {
                C10602v c10602v = new C10602v(str, str2, i2);
                AppMethodBeat.m2505o(131817);
                return c10602v;
            }
            C19574n c27181w = new C27181w(str, str2, i);
            AppMethodBeat.m2505o(131817);
            return c27181w;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.n$c */
    public static abstract class C19576c {
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
        /* renamed from: c */
        public void mo34787c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        }

        /* renamed from: b */
        public void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        }

        /* renamed from: a */
        public void mo6282a(C37441a<arc> c37441a) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.n$d */
    public static class C19577d {
        /* renamed from: b */
        static C19574n m30353b(String str, String str2, int i, int i2, int i3) {
            AppMethodBeat.m2504i(131818);
            if (C33097a.m54090np(i)) {
                C10602v c10602v = new C10602v(str, str2, i2, i3);
                AppMethodBeat.m2505o(131818);
                return c10602v;
            }
            C19574n c27181w = new C27181w(str, str2, i, i3);
            AppMethodBeat.m2505o(131818);
            return c27181w;
        }
    }

    /* renamed from: a */
    void mo34781a(C10598b c10598b);

    /* renamed from: a */
    void mo34782a(C19576c c19576c);

    void prepareAsync();
}
