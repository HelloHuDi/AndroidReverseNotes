package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1760a;

/* renamed from: com.tencent.mm.sdk.platformtools.f */
public final class C5058f {
    public static String BUILD_TAG;
    public static String CLIENT_VERSION;
    public static String COMMAND;
    public static boolean DEBUG;
    public static boolean ENABLE_FPS_ANALYSE;
    public static boolean ENABLE_MATRIX;
    public static boolean ENABLE_MATRIX_TRACE;
    public static boolean EX_DEVICE_LOGIN;
    public static String HOSTNAME;
    public static boolean IS_FLAVOR_PURPLE;
    public static boolean IS_FLAVOR_RED;
    public static String OWNER;
    public static boolean PRE_RELEASE;
    public static boolean REDESIGN_ENTRANCE;
    public static String REV;
    public static String SVNPATH;
    public static String TIME;
    public static int xxY;
    public static final C5064s xxZ = new C5064s();

    /* renamed from: com.tencent.mm.sdk.platformtools.f$a */
    static class C5057a {
        /* renamed from: hP */
        public static String m7670hP(String str, String str2) {
            AppMethodBeat.m2504i(115167);
            if (str == null) {
                AppMethodBeat.m2505o(115167);
                return null;
            }
            int indexOf = str.indexOf(str2);
            if (indexOf < 0) {
                AppMethodBeat.m2505o(115167);
                return str;
            }
            str = str.substring(indexOf);
            AppMethodBeat.m2505o(115167);
            return str;
        }

        /* renamed from: hQ */
        public static String m7671hQ(String str, String str2) {
            AppMethodBeat.m2504i(115168);
            if (str == null) {
                AppMethodBeat.m2505o(115168);
                return null;
            } else if (str.equals(str2)) {
                AppMethodBeat.m2505o(115168);
                return str;
            } else {
                str = String.format("%s(%s)", new Object[]{str, str2});
                AppMethodBeat.m2505o(115168);
                return str;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(115170);
        AppMethodBeat.m2505o(115170);
    }

    public static String aZm() {
        AppMethodBeat.m2504i(115169);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{C5057a.m7671hQ(CLIENT_VERSION, C1760a.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{C5057a.m7671hQ(BUILD_TAG, C1760a.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{C5057a.m7671hQ(OWNER, C1760a.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{C5057a.m7671hQ(HOSTNAME, C1760a.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{C5057a.m7671hQ(TIME, C1760a.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{C5057a.m7671hQ(COMMAND, C1760a.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{C5057a.m7671hQ(C5057a.m7670hP(SVNPATH, "MicroMsg_proj"), C5057a.m7670hP(C1760a.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{C5057a.m7671hQ(REV, C1760a.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = C1760a.m3623Um() ? C1760a.m3621Uk() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        stringBuilder.append(String.format("[feature_id] %s\n", new Object[]{xxZ.getString("FEATURE_ID")}));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(115169);
        return stringBuilder2;
    }
}
