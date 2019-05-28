package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.d.a.m */
public final class C3828m {

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$b */
    public static class C3829b {
        public String pdz;
        public String qtZ;
        public String thumbUrl;
        public String title;

        private C3829b() {
        }

        /* renamed from: WH */
        public static C3829b m6123WH(String str) {
            C3829b c3829b;
            AppMethodBeat.m2504i(24672);
            Map z = C5049br.m7595z(str, "nativepay");
            if (z != null) {
                try {
                    C3829b c3829b2 = new C3829b();
                    c3829b2.title = C5046bo.nullAsNil((String) z.get(".nativepay.title"));
                    c3829b2.thumbUrl = C5046bo.nullAsNil((String) z.get(".nativepay.thumburl"));
                    c3829b2.qtZ = C5046bo.nullAsNil((String) z.get(".nativepay.wx_pay_url"));
                    c3829b2.pdz = C5046bo.nullAsNil((String) z.get(".nativepay.price"));
                    c3829b = c3829b2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3829b = null;
                }
            } else {
                c3829b = null;
            }
            AppMethodBeat.m2505o(24672);
            return c3829b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$a */
    public static class C3830a {
        public String path;
        public String thumbUrl;
        public String title;
        public String username;
        public int version;

        private C3830a() {
        }

        /* renamed from: WG */
        public static C3830a m6124WG(String str) {
            C3830a c3830a;
            AppMethodBeat.m2504i(24671);
            Map z = C5049br.m7595z(str, "program");
            if (z != null) {
                try {
                    C3830a c3830a2 = new C3830a();
                    c3830a2.title = C5046bo.nullAsNil((String) z.get(".program.title"));
                    c3830a2.thumbUrl = C5046bo.nullAsNil((String) z.get(".program.thumburl"));
                    c3830a2.username = C5046bo.nullAsNil((String) z.get(".program.username"));
                    c3830a2.path = C5046bo.nullAsNil((String) z.get(".program.path"));
                    c3830a2.version = C5046bo.getInt((String) z.get(".program.version"), 0);
                    c3830a = c3830a2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3830a = null;
                }
            } else {
                c3830a = null;
            }
            AppMethodBeat.m2505o(24671);
            return c3830a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$e */
    public static class C3831e {
        public String cIe;
        public String link;
        public String thumbUrl;
        public String title;

        private C3831e() {
        }

        /* renamed from: WK */
        public static C3831e m6125WK(String str) {
            C3831e c3831e;
            AppMethodBeat.m2504i(24675);
            Map z = C5049br.m7595z(str, "h5url");
            if (z != null) {
                try {
                    C3831e c3831e2 = new C3831e();
                    c3831e2.title = C5046bo.nullAsNil((String) z.get(".h5url.title"));
                    c3831e2.thumbUrl = C5046bo.nullAsNil((String) z.get(".h5url.thumburl"));
                    c3831e2.link = C5046bo.nullAsNil((String) z.get(".h5url.link"));
                    c3831e2.cIe = C5046bo.nullAsNil((String) z.get(".h5url.username"));
                    c3831e = c3831e2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3831e = null;
                }
            } else {
                c3831e = null;
            }
            AppMethodBeat.m2505o(24675);
            return c3831e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$c */
    public static class C3832c {
        /* renamed from: id */
        public String f1278id;
        public String thumbUrl;
        public String title;

        private C3832c() {
        }

        /* renamed from: WI */
        public static C3832c m6126WI(String str) {
            C3832c c3832c;
            AppMethodBeat.m2504i(24673);
            Map z = C5049br.m7595z(str, "product");
            if (z != null) {
                try {
                    C3832c c3832c2 = new C3832c();
                    c3832c2.title = C5046bo.nullAsNil((String) z.get(".product.title"));
                    c3832c2.thumbUrl = C5046bo.nullAsNil((String) z.get(".product.thumburl"));
                    c3832c2.f1278id = C5046bo.nullAsNil((String) z.get(".product.product_id"));
                    c3832c = c3832c2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3832c = null;
                }
            } else {
                c3832c = null;
            }
            AppMethodBeat.m2505o(24673);
            return c3832c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$d */
    public static class C3833d {
        public String qub;
        public String thumbUrl;
        public String title;
        public String username;

        private C3833d() {
        }

        /* renamed from: WJ */
        public static C3833d m6127WJ(String str) {
            C3833d c3833d;
            AppMethodBeat.m2504i(24674);
            Map z = C5049br.m7595z(str, "tempsession");
            if (z != null) {
                try {
                    C3833d c3833d2 = new C3833d();
                    c3833d2.title = C5046bo.nullAsNil((String) z.get(".tempsession.title"));
                    c3833d2.thumbUrl = C5046bo.nullAsNil((String) z.get(".tempsession.thumburl"));
                    c3833d2.username = C5046bo.nullAsNil((String) z.get(".tempsession.username"));
                    c3833d2.qub = C5046bo.nullAsNil((String) z.get(".tempsession.deeplinkjumpurl"));
                    c3833d = c3833d2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3833d = null;
                }
            } else {
                c3833d = null;
            }
            AppMethodBeat.m2505o(24674);
            return c3833d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.m$f */
    public static class C3834f {
        public String bCu;
        public String quc;
        public String userName;

        private C3834f() {
        }

        /* renamed from: WL */
        public static C3834f m6128WL(String str) {
            C3834f c3834f;
            AppMethodBeat.m2504i(24676);
            Map z = C5049br.m7595z(str, "bizprofile");
            if (z != null) {
                try {
                    C3834f c3834f2 = new C3834f();
                    c3834f2.bCu = C5046bo.nullAsNil((String) z.get(".bizprofile.nickname"));
                    c3834f2.userName = C5046bo.nullAsNil((String) z.get(".bizprofile.username"));
                    c3834f2.quc = C5046bo.nullAsNil((String) z.get(".bizprofile.showchat"));
                    c3834f = c3834f2;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    c3834f = null;
                }
            } else {
                c3834f = null;
            }
            AppMethodBeat.m2505o(24676);
            return c3834f;
        }
    }
}
