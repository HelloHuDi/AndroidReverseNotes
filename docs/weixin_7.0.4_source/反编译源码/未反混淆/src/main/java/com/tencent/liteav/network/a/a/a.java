package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.c;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a {
    public static InetAddress[] a() {
        AppMethodBeat.i(67635);
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    readLine = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(readLine);
                        if (byName != null) {
                            String hostAddress = byName.getHostAddress();
                            if (!(hostAddress == null || hostAddress.length() == 0)) {
                                arrayList.add(byName);
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
                AppMethodBeat.o(67635);
                return inetAddressArr;
            }
        } catch (IOException e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", e);
        }
        AppMethodBeat.o(67635);
        return null;
    }

    public static InetAddress[] b() {
        AppMethodBeat.i(67636);
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            ArrayList arrayList = new ArrayList(5);
            String[] strArr = new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, new Object[]{strArr[i]});
                if (!(str == null || str.length() == 0)) {
                    InetAddress byName = InetAddress.getByName(str);
                    if (byName != null) {
                        String hostAddress = byName.getHostAddress();
                        if (!(hostAddress == null || hostAddress.length() == 0 || arrayList.contains(byName))) {
                            arrayList.add(byName);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
                AppMethodBeat.o(67636);
                return inetAddressArr;
            }
        } catch (Exception e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", e);
        }
        AppMethodBeat.o(67636);
        return null;
    }

    public static c c() {
        AppMethodBeat.i(67637);
        AnonymousClass1 anonymousClass1 = new c() {
            public final e[] a(b bVar, d dVar) {
                AppMethodBeat.i(67638);
                InetAddress[] b = a.b();
                if (b == null) {
                    b = a.a();
                }
                if (b == null) {
                    IOException iOException = new IOException("cant get local dns server");
                    AppMethodBeat.o(67638);
                    throw iOException;
                }
                e[] a = new c(b[0]).a(bVar, dVar);
                AppMethodBeat.o(67638);
                return a;
            }
        };
        AppMethodBeat.o(67637);
        return anonymousClass1;
    }
}
