package com.tencent.mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g {
    public static final boolean wY = F(System.getProperty("java.vm.version"));

    static {
        AppMethodBeat.i(114827);
        AppMethodBeat.o(114827);
    }

    private static boolean F(String str) {
        boolean z = false;
        AppMethodBeat.i(114826);
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        ab.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.o(114826);
        return z;
    }
}
