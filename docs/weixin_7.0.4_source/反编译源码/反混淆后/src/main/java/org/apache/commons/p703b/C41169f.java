package org.apache.commons.p703b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.BuildConfig;
import java.util.ArrayList;

/* renamed from: org.apache.commons.b.f */
public final class C41169f {
    public static final String AbP = C41169f.getSystemProperty("file.separator");
    public static final String BXA = C41169f.getSystemProperty("java.version");
    public static final String BXB = C41169f.getSystemProperty("java.vm.info");
    public static final String BXC = C41169f.getSystemProperty("java.vm.name");
    public static final String BXD = C41169f.getSystemProperty("java.vm.specification.name");
    public static final String BXE = C41169f.getSystemProperty("java.vm.specification.vendor");
    public static final String BXF = C41169f.getSystemProperty("java.vm.specification.version");
    public static final String BXG = C41169f.getSystemProperty("java.vm.vendor");
    public static final String BXH = C41169f.getSystemProperty("java.vm.version");
    public static final String BXI = C41169f.getSystemProperty("os.arch");
    public static final String BXJ = C41169f.getSystemProperty("path.separator");
    public static final String BXK;
    public static final String BXL = C41169f.getSystemProperty("user.dir");
    public static final String BXM = C41169f.getSystemProperty("user.home");
    public static final String BXN = C41169f.getSystemProperty("user.language");
    public static final String BXO = C41169f.getSystemProperty("user.timezone");
    public static final String BXP;
    public static final float BXQ = C41169f.m71625M(C41169f.awO(BXA));
    public static final int BXR;
    public static final boolean BXS = C41169f.awM(BuildConfig.VERSION_NAME);
    public static final boolean BXT = C41169f.awM("1.2");
    public static final boolean BXU = C41169f.awM("1.3");
    public static final boolean BXV = C41169f.awM("1.4");
    public static final boolean BXW = C41169f.awM("1.5");
    public static final boolean BXX = C41169f.awM("1.6");
    public static final boolean BXY = C41169f.awM("1.7");
    public static final boolean BXZ = C41169f.awN("AIX");
    public static final String BXe = C41169f.getSystemProperty("awt.toolkit");
    public static final String BXf = C41169f.getSystemProperty("file.encoding");
    public static final String BXg = C41169f.getSystemProperty("java.awt.fonts");
    public static final String BXh = C41169f.getSystemProperty("java.awt.graphicsenv");
    public static final String BXi = C41169f.getSystemProperty("java.awt.headless");
    public static final String BXj = C41169f.getSystemProperty("java.awt.printerjob");
    public static final String BXk = C41169f.getSystemProperty("java.class.path");
    public static final String BXl = C41169f.getSystemProperty("java.class.version");
    public static final String BXm = C41169f.getSystemProperty("java.compiler");
    public static final String BXn = C41169f.getSystemProperty("java.endorsed.dirs");
    public static final String BXo = C41169f.getSystemProperty("java.ext.dirs");
    public static final String BXp = C41169f.getSystemProperty("java.home");
    public static final String BXq = C41169f.getSystemProperty("java.io.tmpdir");
    public static final String BXr = C41169f.getSystemProperty("java.library.path");
    public static final String BXs = C41169f.getSystemProperty("java.runtime.name");
    public static final String BXt = C41169f.getSystemProperty("java.runtime.version");
    public static final String BXu = C41169f.getSystemProperty("java.specification.name");
    public static final String BXv = C41169f.getSystemProperty("java.specification.vendor");
    public static final String BXw = C41169f.getSystemProperty("java.specification.version");
    public static final String BXx = C41169f.getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String BXy = C41169f.getSystemProperty("java.vendor");
    public static final String BXz = C41169f.getSystemProperty("java.vendor.url");
    public static final boolean BYa = C41169f.awN("HP-UX");
    public static final boolean BYb = C41169f.awN("Irix");
    public static final boolean BYc;
    public static final boolean BYd = C41169f.awN("Mac");
    public static final boolean BYe = C41169f.awN("Mac OS X");
    public static final boolean BYf = C41169f.awN("OS/2");
    public static final boolean BYg = C41169f.awN("Solaris");
    public static final boolean BYh = C41169f.awN("SunOS");
    public static final boolean BYi;
    public static final boolean BYj = C41169f.awN("Windows");
    public static final boolean BYk = C41169f.m71626jk("Windows", "5.0");
    public static final boolean BYl = C41169f.m71626jk("Windows 9", "4.0");
    public static final boolean BYm = C41169f.m71626jk("Windows 9", "4.1");
    public static final boolean BYn = C41169f.m71626jk("Windows", "4.9");
    public static final boolean BYo = C41169f.awN("Windows NT");
    public static final boolean BYp = C41169f.m71626jk("Windows", "5.1");
    public static final boolean BYq = C41169f.m71626jk("Windows", "6.0");
    public static final boolean BYr = C41169f.m71626jk("Windows", "6.1");
    public static final String LINE_SEPARATOR = C41169f.getSystemProperty("line.separator");
    public static final String bIL = C41169f.getSystemProperty("user.name");
    public static final String vxl = C41169f.getSystemProperty("os.name");
    public static final String vxm = C41169f.getSystemProperty("os.version");

    static {
        String systemProperty;
        int i;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(116964);
        if (C41169f.getSystemProperty("user.country") == null) {
            systemProperty = C41169f.getSystemProperty("user.region");
        } else {
            systemProperty = C41169f.getSystemProperty("user.country");
        }
        BXK = systemProperty;
        if (BXA != null) {
            for (i = 0; i < BXA.length(); i++) {
                char charAt = BXA.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    systemProperty = BXA.substring(i);
                    break;
                }
            }
        }
        systemProperty = null;
        BXP = systemProperty;
        int[] awO = C41169f.awO(BXA);
        if (awO == null) {
            i = 0;
        } else {
            int length = awO.length;
            if (length > 0) {
                i = awO[0] * 100;
            } else {
                i = 0;
            }
            if (length >= 2) {
                i += awO[1] * 10;
            }
            if (length >= 3) {
                i += awO[2];
            }
        }
        BXR = i;
        if (C41169f.awN("Linux") || C41169f.awN("LINUX")) {
            z = true;
        } else {
            z = false;
        }
        BYc = z;
        if (BXZ || BYa || BYb || BYc || BYe || BYg || BYh) {
            z2 = true;
        }
        BYi = z2;
        AppMethodBeat.m2505o(116964);
    }

    private static boolean awM(String str) {
        AppMethodBeat.m2504i(116958);
        String str2 = BXP;
        if (str2 == null) {
            AppMethodBeat.m2505o(116958);
            return false;
        }
        boolean startsWith = str2.startsWith(str);
        AppMethodBeat.m2505o(116958);
        return startsWith;
    }

    /* renamed from: jk */
    private static boolean m71626jk(String str, String str2) {
        AppMethodBeat.m2504i(116959);
        String str3 = vxl;
        String str4 = vxm;
        if (str3 == null || str4 == null) {
            AppMethodBeat.m2505o(116959);
            return false;
        } else if (str3.startsWith(str) && str4.startsWith(str2)) {
            AppMethodBeat.m2505o(116959);
            return true;
        } else {
            AppMethodBeat.m2505o(116959);
            return false;
        }
    }

    private static boolean awN(String str) {
        AppMethodBeat.m2504i(116960);
        String str2 = vxl;
        if (str2 == null) {
            AppMethodBeat.m2505o(116960);
            return false;
        }
        boolean startsWith = str2.startsWith(str);
        AppMethodBeat.m2505o(116960);
        return startsWith;
    }

    private static String getSystemProperty(String str) {
        AppMethodBeat.m2504i(116961);
        try {
            String property = System.getProperty(str);
            AppMethodBeat.m2505o(116961);
            return property;
        } catch (SecurityException e) {
            System.err.println(new StringBuffer("Caught a SecurityException reading the system property '").append(str).append("'; the SystemUtils property value will default to null.").toString());
            AppMethodBeat.m2505o(116961);
            return null;
        }
    }

    private static int[] awO(String str) {
        AppMethodBeat.m2504i(116962);
        int[] iArr;
        if (str == null) {
            iArr = C16470a.bxu;
            AppMethodBeat.m2505o(116962);
            return iArr;
        }
        String[] strArr;
        int length;
        int i;
        String str2 = "._- ";
        if (str == null) {
            strArr = null;
        } else {
            length = str.length();
            if (length == 0) {
                strArr = C16470a.EMPTY_STRING_ARRAY;
            } else {
                int i2;
                ArrayList arrayList = new ArrayList();
                int i3;
                int i4;
                int i5;
                int i6;
                if (str2.length() == 1) {
                    char charAt = str2.charAt(0);
                    i = 0;
                    i3 = 0;
                    i2 = 0;
                    i4 = 1;
                    while (i2 < length) {
                        if (str.charAt(i2) == charAt) {
                            if (i != 0) {
                                i5 = i4 + 1;
                                if (i4 == -1) {
                                    i2 = length;
                                }
                                arrayList.add(str.substring(i3, i2));
                                i = 0;
                            } else {
                                i5 = i4;
                            }
                            i6 = i2 + 1;
                            i3 = i6;
                            i2 = i6;
                            i4 = i5;
                        } else {
                            i2++;
                            i = 1;
                        }
                    }
                    length = i3;
                } else {
                    i = 0;
                    i3 = 0;
                    i2 = 0;
                    i4 = 1;
                    while (i2 < length) {
                        if (str2.indexOf(str.charAt(i2)) >= 0) {
                            if (i != 0) {
                                i5 = i4 + 1;
                                if (i4 == -1) {
                                    i2 = length;
                                }
                                arrayList.add(str.substring(i3, i2));
                                i = 0;
                            } else {
                                i5 = i4;
                            }
                            i6 = i2 + 1;
                            i3 = i6;
                            i2 = i6;
                            i4 = i5;
                        } else {
                            i2++;
                            i = 1;
                        }
                    }
                    length = i3;
                }
                if (i != 0) {
                    arrayList.add(str.substring(length, i2));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        int[] iArr2 = new int[Math.min(3, strArr.length)];
        i = 0;
        for (length = 0; length < strArr.length && i < 3; length++) {
            String str3 = strArr[length];
            if (str3.length() > 0) {
                try {
                    iArr2[i] = Integer.parseInt(str3);
                    i++;
                } catch (Exception e) {
                }
            }
        }
        if (iArr2.length > i) {
            iArr = new int[i];
            System.arraycopy(iArr2, 0, iArr, 0, i);
        } else {
            iArr = iArr2;
        }
        AppMethodBeat.m2505o(116962);
        return iArr;
    }

    /* renamed from: M */
    private static float m71625M(int[] iArr) {
        int i = 1;
        AppMethodBeat.m2504i(116963);
        float f;
        if (iArr == null || iArr.length == 0) {
            AppMethodBeat.m2505o(116963);
            return 0.0f;
        } else if (iArr.length == 1) {
            f = (float) iArr[0];
            AppMethodBeat.m2505o(116963);
            return f;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iArr[0]);
            stringBuffer.append('.');
            while (i < iArr.length) {
                stringBuffer.append(iArr[i]);
                i++;
            }
            try {
                f = Float.parseFloat(stringBuffer.toString());
                AppMethodBeat.m2505o(116963);
                return f;
            } catch (Exception e) {
                AppMethodBeat.m2505o(116963);
                return 0.0f;
            }
        }
    }
}
