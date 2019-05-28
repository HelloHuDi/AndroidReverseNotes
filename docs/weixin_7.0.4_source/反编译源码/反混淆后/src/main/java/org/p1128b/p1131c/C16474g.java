package org.p1128b.p1131c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p1128b.p1130b.C36641b;
import org.p1128b.p1132d.C41173i;
import org.p1128b.p1134g.C36644c;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.c.g */
public final class C16474g implements C44623a, C31205f {
    private static final Pattern BYK = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern BYL = Pattern.compile("oauth_token_secret=([^&]*)");

    static {
        AppMethodBeat.m2504i(77238);
        AppMethodBeat.m2505o(77238);
    }

    public final C41173i awU(String str) {
        AppMethodBeat.m2504i(77239);
        C46862d.m89099jn(str, "Response body is incorrect. Can't extract a token from an empty string");
        C41173i c41173i = new C41173i(C16474g.m25281f(str, BYK), C16474g.m25281f(str, BYL), str);
        AppMethodBeat.m2505o(77239);
        return c41173i;
    }

    /* renamed from: f */
    private static String m25281f(String str, Pattern pattern) {
        AppMethodBeat.m2504i(77240);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            C36641b c36641b = new C36641b("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
            AppMethodBeat.m2505o(77240);
            throw c36641b;
        }
        String decode = C36644c.decode(matcher.group(1));
        AppMethodBeat.m2505o(77240);
        return decode;
    }
}
