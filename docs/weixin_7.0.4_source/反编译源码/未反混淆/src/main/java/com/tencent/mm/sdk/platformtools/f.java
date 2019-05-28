package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
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
    public static final s xxZ = new s();

    static class a {
        public static String hP(String str, String str2) {
            AppMethodBeat.i(115167);
            if (str == null) {
                AppMethodBeat.o(115167);
                return null;
            }
            int indexOf = str.indexOf(str2);
            if (indexOf < 0) {
                AppMethodBeat.o(115167);
                return str;
            }
            str = str.substring(indexOf);
            AppMethodBeat.o(115167);
            return str;
        }

        public static String hQ(String str, String str2) {
            AppMethodBeat.i(115168);
            if (str == null) {
                AppMethodBeat.o(115168);
                return null;
            } else if (str.equals(str2)) {
                AppMethodBeat.o(115168);
                return str;
            } else {
                str = String.format("%s(%s)", new Object[]{str, str2});
                AppMethodBeat.o(115168);
                return str;
            }
        }
    }

    static {
        AppMethodBeat.i(115170);
        AppMethodBeat.o(115170);
    }

    public static String aZm() {
        AppMethodBeat.i(115169);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.hQ(CLIENT_VERSION, com.tencent.mm.loader.j.a.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.hQ(BUILD_TAG, com.tencent.mm.loader.j.a.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.hQ(OWNER, com.tencent.mm.loader.j.a.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.hQ(HOSTNAME, com.tencent.mm.loader.j.a.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.hQ(TIME, com.tencent.mm.loader.j.a.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.hQ(COMMAND, com.tencent.mm.loader.j.a.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.hQ(a.hP(SVNPATH, "MicroMsg_proj"), a.hP(com.tencent.mm.loader.j.a.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.hQ(REV, com.tencent.mm.loader.j.a.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = com.tencent.mm.loader.j.a.Um() ? com.tencent.mm.loader.j.a.Uk() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        stringBuilder.append(String.format("[feature_id] %s\n", new Object[]{xxZ.getString("FEATURE_ID")}));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(115169);
        return stringBuilder2;
    }
}
