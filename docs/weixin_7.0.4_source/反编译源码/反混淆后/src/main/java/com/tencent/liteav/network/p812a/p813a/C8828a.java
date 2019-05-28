package com.tencent.liteav.network.p812a.p813a;

import com.tencent.liteav.network.p812a.C17790b;
import com.tencent.liteav.network.p812a.C17791c;
import com.tencent.liteav.network.p812a.C41694d;
import com.tencent.liteav.network.p812a.C45111e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.tencent.liteav.network.a.a.a */
public final class C8828a {

    /* renamed from: com.tencent.liteav.network.a.a.a$1 */
    static class C88291 implements C17791c {
        C88291() {
        }

        /* renamed from: a */
        public final C45111e[] mo19951a(C17790b c17790b, C41694d c41694d) {
            AppMethodBeat.m2504i(67638);
            InetAddress[] b = C8828a.m15726b();
            if (b == null) {
                b = C8828a.m15725a();
            }
            if (b == null) {
                IOException iOException = new IOException("cant get local dns server");
                AppMethodBeat.m2505o(67638);
                throw iOException;
            }
            C45111e[] a = new C25661c(b[0]).mo19951a(c17790b, c41694d);
            AppMethodBeat.m2505o(67638);
            return a;
        }
    }

    /* renamed from: a */
    public static InetAddress[] m15725a() {
        AppMethodBeat.m2504i(67635);
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
                AppMethodBeat.m2505o(67635);
                return inetAddressArr;
            }
        } catch (IOException e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", e);
        }
        AppMethodBeat.m2505o(67635);
        return null;
    }

    /* renamed from: b */
    public static InetAddress[] m15726b() {
        AppMethodBeat.m2504i(67636);
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
                AppMethodBeat.m2505o(67636);
                return inetAddressArr;
            }
        } catch (Exception e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", e);
        }
        AppMethodBeat.m2505o(67636);
        return null;
    }

    /* renamed from: c */
    public static C17791c m15727c() {
        AppMethodBeat.m2504i(67637);
        C88291 c88291 = new C88291();
        AppMethodBeat.m2505o(67637);
        return c88291;
    }
}
