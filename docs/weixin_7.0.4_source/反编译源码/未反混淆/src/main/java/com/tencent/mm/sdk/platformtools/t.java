package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public final class t {
    private static final Pattern xyp = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern xyq = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern xyr = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    static {
        AppMethodBeat.i(52006);
        AppMethodBeat.o(52006);
    }

    public static boolean isIPv4Address(String str) {
        AppMethodBeat.i(52003);
        boolean matches = xyp.matcher(str).matches();
        AppMethodBeat.o(52003);
        return matches;
    }

    public static InetAddress ams(String str) {
        AppMethodBeat.i(52005);
        InetAddress byName;
        if (isIPv4Address(str)) {
            byName = InetAddress.getByName(str);
            AppMethodBeat.o(52005);
            return byName;
        } else if (isIPv6Address(str)) {
            byName = InetAddress.getByName(str);
            AppMethodBeat.o(52005);
            return byName;
        } else {
            UnknownHostException unknownHostException = new UnknownHostException("invalid ipv4 or ipv6 dotted string");
            AppMethodBeat.o(52005);
            throw unknownHostException;
        }
    }

    public static boolean isIPv6Address(String str) {
        AppMethodBeat.i(52004);
        if (xyq.matcher(str).matches() || xyr.matcher(str).matches()) {
            AppMethodBeat.o(52004);
            return true;
        }
        AppMethodBeat.o(52004);
        return false;
    }
}
