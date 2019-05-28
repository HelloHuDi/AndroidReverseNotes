package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

interface e {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static class a {
        static final Map<String, e> hJH;

        static void init() {
        }

        static {
            AppMethodBeat.i(102775);
            HashMap hashMap = new HashMap();
            hJH = hashMap;
            hashMap.put("ascii", new e() {
                private final Charset wu = Charset.forName("US-ASCII");

                {
                    AppMethodBeat.i(102759);
                    AppMethodBeat.o(102759);
                }

                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102760);
                    String str = new String(d.q(byteBuffer), this.wu);
                    AppMethodBeat.o(102760);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102761);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.wu));
                    AppMethodBeat.o(102761);
                    return wrap;
                }
            });
            hJH.put("base64", new e() {
                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102762);
                    String str = new String(Base64.encode(d.q(byteBuffer), 2), UTF_8);
                    AppMethodBeat.o(102762);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102763);
                    ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(str.getBytes(UTF_8), 2));
                    AppMethodBeat.o(102763);
                    return wrap;
                }
            });
            hJH.put("hex", new e() {
                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102764);
                    String bigInteger = new BigInteger(1, d.q(byteBuffer)).toString(16);
                    AppMethodBeat.o(102764);
                    return bigInteger;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102765);
                    ByteBuffer wrap = ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
                    AppMethodBeat.o(102765);
                    return wrap;
                }
            });
            final Charset forName = Charset.forName("ISO-10646-UCS-2");
            AnonymousClass4 anonymousClass4 = new e() {
                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102766);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(d.q(byteBuffer), forName);
                    AppMethodBeat.o(102766);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102767);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.o(102767);
                    return order;
                }
            };
            hJH.put("ucs2", anonymousClass4);
            hJH.put("ucs-2", anonymousClass4);
            forName = Charset.forName("UTF-16LE");
            AnonymousClass5 anonymousClass5 = new e() {
                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102768);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(d.q(byteBuffer), forName);
                    AppMethodBeat.o(102768);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102769);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.o(102769);
                    return order;
                }
            };
            hJH.put("utf16le", anonymousClass5);
            hJH.put("utf-16le", anonymousClass5);
            AnonymousClass6 anonymousClass6 = new e() {
                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102770);
                    String str = new String(d.q(byteBuffer), UTF_8);
                    AppMethodBeat.o(102770);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102771);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(UTF_8));
                    AppMethodBeat.o(102771);
                    return wrap;
                }
            };
            hJH.put("utf8", anonymousClass6);
            hJH.put(ProtocolPackage.ServerEncoding, anonymousClass6);
            AnonymousClass7 anonymousClass7 = new e() {
                private final Charset hJK = Charset.forName("ISO-8859-1");

                {
                    AppMethodBeat.i(102772);
                    AppMethodBeat.o(102772);
                }

                public final String o(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(102773);
                    String str = new String(d.q(byteBuffer), this.hJK);
                    AppMethodBeat.o(102773);
                    return str;
                }

                public final ByteBuffer AY(String str) {
                    AppMethodBeat.i(102774);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.hJK));
                    AppMethodBeat.o(102774);
                    return wrap;
                }
            };
            hJH.put("latin1", anonymousClass7);
            hJH.put("binary", anonymousClass7);
            AppMethodBeat.o(102775);
        }
    }

    ByteBuffer AY(String str);

    String o(ByteBuffer byteBuffer);
}
