package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.sdk.platformtools.t */
public final class C5065t {
    private static final Pattern xyp = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern xyq = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern xyr = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    static {
        AppMethodBeat.m2504i(52006);
        AppMethodBeat.m2505o(52006);
    }

    public static boolean isIPv4Address(String str) {
        AppMethodBeat.m2504i(52003);
        boolean matches = xyp.matcher(str).matches();
        AppMethodBeat.m2505o(52003);
        return matches;
    }

    public static InetAddress ams(String str) {
        AppMethodBeat.m2504i(52005);
        InetAddress byName;
        if (C5065t.isIPv4Address(str)) {
            byName = InetAddress.getByName(str);
            AppMethodBeat.m2505o(52005);
            return byName;
        } else if (C5065t.isIPv6Address(str)) {
            byName = InetAddress.getByName(str);
            AppMethodBeat.m2505o(52005);
            return byName;
        } else {
            UnknownHostException unknownHostException = new UnknownHostException("invalid ipv4 or ipv6 dotted string");
            AppMethodBeat.m2505o(52005);
            throw unknownHostException;
        }
    }

    public static boolean isIPv6Address(String str) {
        AppMethodBeat.m2504i(52004);
        if (xyq.matcher(str).matches() || xyr.matcher(str).matches()) {
            AppMethodBeat.m2505o(52004);
            return true;
        }
        AppMethodBeat.m2505o(52004);
        return false;
    }
}
