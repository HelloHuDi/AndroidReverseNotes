package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.b.b.b;

public final class c {
    private static final Map<String, String> BZp;
    private static String CHARSET = "UTF-8";

    static {
        AppMethodBeat.i(77311);
        HashMap hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        BZp = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(77311);
    }

    public static String encode(String str) {
        AppMethodBeat.i(77312);
        d.r(str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, CHARSET);
            Iterator it = BZp.entrySet().iterator();
            while (true) {
                String str2 = encode;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str3 = (String) entry.getKey();
                    encode = str2.replaceAll(Pattern.quote(str3), (String) entry.getValue());
                } else {
                    AppMethodBeat.o(77312);
                    return str2;
                }
            }
        } catch (UnsupportedEncodingException e) {
            b bVar = new b("Charset not found while encoding string: " + CHARSET, e);
            AppMethodBeat.o(77312);
            throw bVar;
        }
    }

    public static String decode(String str) {
        AppMethodBeat.i(77313);
        d.r(str, "Cannot decode null object");
        try {
            String decode = URLDecoder.decode(str, CHARSET);
            AppMethodBeat.o(77313);
            return decode;
        } catch (UnsupportedEncodingException e) {
            b bVar = new b("Charset not found while decoding string: " + CHARSET, e);
            AppMethodBeat.o(77313);
            throw bVar;
        }
    }
}
