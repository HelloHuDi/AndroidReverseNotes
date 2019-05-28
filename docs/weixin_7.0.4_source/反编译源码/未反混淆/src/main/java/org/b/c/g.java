package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.b.b.b;
import org.b.d.i;
import org.b.g.c;
import org.b.g.d;

public final class g implements a, f {
    private static final Pattern BYK = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern BYL = Pattern.compile("oauth_token_secret=([^&]*)");

    static {
        AppMethodBeat.i(77238);
        AppMethodBeat.o(77238);
    }

    public final i awU(String str) {
        AppMethodBeat.i(77239);
        d.jn(str, "Response body is incorrect. Can't extract a token from an empty string");
        i iVar = new i(f(str, BYK), f(str, BYL), str);
        AppMethodBeat.o(77239);
        return iVar;
    }

    private static String f(String str, Pattern pattern) {
        AppMethodBeat.i(77240);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            b bVar = new b("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
            AppMethodBeat.o(77240);
            throw bVar;
        }
        String decode = c.decode(matcher.group(1));
        AppMethodBeat.o(77240);
        return decode;
    }
}
