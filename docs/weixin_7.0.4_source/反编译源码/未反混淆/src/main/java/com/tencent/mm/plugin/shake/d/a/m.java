package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m {

    public static class b {
        public String pdz;
        public String qtZ;
        public String thumbUrl;
        public String title;

        private b() {
        }

        public static b WH(String str) {
            b bVar;
            AppMethodBeat.i(24672);
            Map z = br.z(str, "nativepay");
            if (z != null) {
                try {
                    b bVar2 = new b();
                    bVar2.title = bo.nullAsNil((String) z.get(".nativepay.title"));
                    bVar2.thumbUrl = bo.nullAsNil((String) z.get(".nativepay.thumburl"));
                    bVar2.qtZ = bo.nullAsNil((String) z.get(".nativepay.wx_pay_url"));
                    bVar2.pdz = bo.nullAsNil((String) z.get(".nativepay.price"));
                    bVar = bVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    bVar = null;
                }
            } else {
                bVar = null;
            }
            AppMethodBeat.o(24672);
            return bVar;
        }
    }

    public static class a {
        public String path;
        public String thumbUrl;
        public String title;
        public String username;
        public int version;

        private a() {
        }

        public static a WG(String str) {
            a aVar;
            AppMethodBeat.i(24671);
            Map z = br.z(str, "program");
            if (z != null) {
                try {
                    a aVar2 = new a();
                    aVar2.title = bo.nullAsNil((String) z.get(".program.title"));
                    aVar2.thumbUrl = bo.nullAsNil((String) z.get(".program.thumburl"));
                    aVar2.username = bo.nullAsNil((String) z.get(".program.username"));
                    aVar2.path = bo.nullAsNil((String) z.get(".program.path"));
                    aVar2.version = bo.getInt((String) z.get(".program.version"), 0);
                    aVar = aVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            AppMethodBeat.o(24671);
            return aVar;
        }
    }

    public static class e {
        public String cIe;
        public String link;
        public String thumbUrl;
        public String title;

        private e() {
        }

        public static e WK(String str) {
            e eVar;
            AppMethodBeat.i(24675);
            Map z = br.z(str, "h5url");
            if (z != null) {
                try {
                    e eVar2 = new e();
                    eVar2.title = bo.nullAsNil((String) z.get(".h5url.title"));
                    eVar2.thumbUrl = bo.nullAsNil((String) z.get(".h5url.thumburl"));
                    eVar2.link = bo.nullAsNil((String) z.get(".h5url.link"));
                    eVar2.cIe = bo.nullAsNil((String) z.get(".h5url.username"));
                    eVar = eVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    eVar = null;
                }
            } else {
                eVar = null;
            }
            AppMethodBeat.o(24675);
            return eVar;
        }
    }

    public static class c {
        public String id;
        public String thumbUrl;
        public String title;

        private c() {
        }

        public static c WI(String str) {
            c cVar;
            AppMethodBeat.i(24673);
            Map z = br.z(str, "product");
            if (z != null) {
                try {
                    c cVar2 = new c();
                    cVar2.title = bo.nullAsNil((String) z.get(".product.title"));
                    cVar2.thumbUrl = bo.nullAsNil((String) z.get(".product.thumburl"));
                    cVar2.id = bo.nullAsNil((String) z.get(".product.product_id"));
                    cVar = cVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    cVar = null;
                }
            } else {
                cVar = null;
            }
            AppMethodBeat.o(24673);
            return cVar;
        }
    }

    public static class d {
        public String qub;
        public String thumbUrl;
        public String title;
        public String username;

        private d() {
        }

        public static d WJ(String str) {
            d dVar;
            AppMethodBeat.i(24674);
            Map z = br.z(str, "tempsession");
            if (z != null) {
                try {
                    d dVar2 = new d();
                    dVar2.title = bo.nullAsNil((String) z.get(".tempsession.title"));
                    dVar2.thumbUrl = bo.nullAsNil((String) z.get(".tempsession.thumburl"));
                    dVar2.username = bo.nullAsNil((String) z.get(".tempsession.username"));
                    dVar2.qub = bo.nullAsNil((String) z.get(".tempsession.deeplinkjumpurl"));
                    dVar = dVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    dVar = null;
                }
            } else {
                dVar = null;
            }
            AppMethodBeat.o(24674);
            return dVar;
        }
    }

    public static class f {
        public String bCu;
        public String quc;
        public String userName;

        private f() {
        }

        public static f WL(String str) {
            f fVar;
            AppMethodBeat.i(24676);
            Map z = br.z(str, "bizprofile");
            if (z != null) {
                try {
                    f fVar2 = new f();
                    fVar2.bCu = bo.nullAsNil((String) z.get(".bizprofile.nickname"));
                    fVar2.userName = bo.nullAsNil((String) z.get(".bizprofile.username"));
                    fVar2.quc = bo.nullAsNil((String) z.get(".bizprofile.showchat"));
                    fVar = fVar2;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                    fVar = null;
                }
            } else {
                fVar = null;
            }
            AppMethodBeat.o(24676);
            return fVar;
        }
    }
}
