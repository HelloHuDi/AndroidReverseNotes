package org.p1128b.p1134g;

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
import org.p1128b.p1130b.C36641b;

/* renamed from: org.b.g.c */
public final class C36644c {
    private static final Map<String, String> BZp;
    private static String CHARSET = "UTF-8";

    static {
        AppMethodBeat.m2504i(77311);
        HashMap hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        BZp = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.m2505o(77311);
    }

    public static String encode(String str) {
        AppMethodBeat.m2504i(77312);
        C46862d.m89100r(str, "Cannot encode null object");
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
                    AppMethodBeat.m2505o(77312);
                    return str2;
                }
            }
        } catch (UnsupportedEncodingException e) {
            C36641b c36641b = new C36641b("Charset not found while encoding string: " + CHARSET, e);
            AppMethodBeat.m2505o(77312);
            throw c36641b;
        }
    }

    public static String decode(String str) {
        AppMethodBeat.m2504i(77313);
        C46862d.m89100r(str, "Cannot decode null object");
        try {
            String decode = URLDecoder.decode(str, CHARSET);
            AppMethodBeat.m2505o(77313);
            return decode;
        } catch (UnsupportedEncodingException e) {
            C36641b c36641b = new C36641b("Charset not found while decoding string: " + CHARSET, e);
            AppMethodBeat.m2505o(77313);
            throw c36641b;
        }
    }
}
