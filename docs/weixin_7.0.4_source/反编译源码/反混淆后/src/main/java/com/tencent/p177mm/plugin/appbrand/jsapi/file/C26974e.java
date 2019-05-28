package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e */
interface C26974e {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a */
    public static class C10390a {
        static final Map<String, C26974e> hJH;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a$3 */
        static class C103883 implements C26974e {
            C103883() {
            }

            /* renamed from: o */
            public final String mo21865o(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(102764);
                String bigInteger = new BigInteger(1, C45672d.m84374q(byteBuffer)).toString(16);
                AppMethodBeat.m2505o(102764);
                return bigInteger;
            }

            /* renamed from: AY */
            public final ByteBuffer mo21864AY(String str) {
                AppMethodBeat.m2504i(102765);
                ByteBuffer wrap = ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
                AppMethodBeat.m2505o(102765);
                return wrap;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a$2 */
        static class C103912 implements C26974e {
            C103912() {
            }

            /* renamed from: o */
            public final String mo21865o(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(102762);
                String str = new String(Base64.encode(C45672d.m84374q(byteBuffer), 2), UTF_8);
                AppMethodBeat.m2505o(102762);
                return str;
            }

            /* renamed from: AY */
            public final ByteBuffer mo21864AY(String str) {
                AppMethodBeat.m2504i(102763);
                ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(str.getBytes(UTF_8), 2));
                AppMethodBeat.m2505o(102763);
                return wrap;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a$1 */
        static class C103921 implements C26974e {
            /* renamed from: wu */
            private final Charset f2873wu = Charset.forName("US-ASCII");

            C103921() {
                AppMethodBeat.m2504i(102759);
                AppMethodBeat.m2505o(102759);
            }

            /* renamed from: o */
            public final String mo21865o(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(102760);
                String str = new String(C45672d.m84374q(byteBuffer), this.f2873wu);
                AppMethodBeat.m2505o(102760);
                return str;
            }

            /* renamed from: AY */
            public final ByteBuffer mo21864AY(String str) {
                AppMethodBeat.m2504i(102761);
                ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.f2873wu));
                AppMethodBeat.m2505o(102761);
                return wrap;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a$7 */
        static class C103947 implements C26974e {
            private final Charset hJK = Charset.forName("ISO-8859-1");

            C103947() {
                AppMethodBeat.m2504i(102772);
                AppMethodBeat.m2505o(102772);
            }

            /* renamed from: o */
            public final String mo21865o(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(102773);
                String str = new String(C45672d.m84374q(byteBuffer), this.hJK);
                AppMethodBeat.m2505o(102773);
                return str;
            }

            /* renamed from: AY */
            public final ByteBuffer mo21864AY(String str) {
                AppMethodBeat.m2504i(102774);
                ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.hJK));
                AppMethodBeat.m2505o(102774);
                return wrap;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.e$a$6 */
        static class C103956 implements C26974e {
            C103956() {
            }

            /* renamed from: o */
            public final String mo21865o(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(102770);
                String str = new String(C45672d.m84374q(byteBuffer), UTF_8);
                AppMethodBeat.m2505o(102770);
                return str;
            }

            /* renamed from: AY */
            public final ByteBuffer mo21864AY(String str) {
                AppMethodBeat.m2504i(102771);
                ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(UTF_8));
                AppMethodBeat.m2505o(102771);
                return wrap;
            }
        }

        static void init() {
        }

        static {
            AppMethodBeat.m2504i(102775);
            HashMap hashMap = new HashMap();
            hJH = hashMap;
            hashMap.put("ascii", new C103921());
            hJH.put("base64", new C103912());
            hJH.put("hex", new C103883());
            final Charset forName = Charset.forName("ISO-10646-UCS-2");
            C103934 c103934 = new C26974e() {
                /* renamed from: o */
                public final String mo21865o(ByteBuffer byteBuffer) {
                    AppMethodBeat.m2504i(102766);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(C45672d.m84374q(byteBuffer), forName);
                    AppMethodBeat.m2505o(102766);
                    return str;
                }

                /* renamed from: AY */
                public final ByteBuffer mo21864AY(String str) {
                    AppMethodBeat.m2504i(102767);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.m2505o(102767);
                    return order;
                }
            };
            hJH.put("ucs2", c103934);
            hJH.put("ucs-2", c103934);
            forName = Charset.forName("UTF-16LE");
            C103895 c103895 = new C26974e() {
                /* renamed from: o */
                public final String mo21865o(ByteBuffer byteBuffer) {
                    AppMethodBeat.m2504i(102768);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(C45672d.m84374q(byteBuffer), forName);
                    AppMethodBeat.m2505o(102768);
                    return str;
                }

                /* renamed from: AY */
                public final ByteBuffer mo21864AY(String str) {
                    AppMethodBeat.m2504i(102769);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.m2505o(102769);
                    return order;
                }
            };
            hJH.put("utf16le", c103895);
            hJH.put("utf-16le", c103895);
            C103956 c103956 = new C103956();
            hJH.put("utf8", c103956);
            hJH.put(ProtocolPackage.ServerEncoding, c103956);
            C103947 c103947 = new C103947();
            hJH.put("latin1", c103947);
            hJH.put("binary", c103947);
            AppMethodBeat.m2505o(102775);
        }
    }

    /* renamed from: AY */
    ByteBuffer mo21864AY(String str);

    /* renamed from: o */
    String mo21865o(ByteBuffer byteBuffer);
}
