package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static final HashMap<String, String> mCH = new HashMap();
    private static String[] mCI = new String[]{"wxid_", "wx_", "gh_"};

    public static String MZ(String str) {
        AppMethodBeat.i(114189);
        if (t.mN(str)) {
            AppMethodBeat.o(114189);
            return str;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(114189);
            return str;
        } else if (!bo.isNullOrNil(aoO.field_conRemarkPYFull)) {
            str = aoO.field_conRemarkPYFull;
            AppMethodBeat.o(114189);
            return str;
        } else if (!bo.isNullOrNil(aoO.Hu())) {
            str = aoO.Hu();
            AppMethodBeat.o(114189);
            return str;
        } else if (bo.isNullOrNil(aoO.Hq())) {
            AppMethodBeat.o(114189);
            return str;
        } else {
            str = aoO.Hq();
            AppMethodBeat.o(114189);
            return str;
        }
    }

    static {
        AppMethodBeat.i(114209);
        AppMethodBeat.o(114209);
    }

    public static final HashMap<String, String> bAi() {
        AppMethodBeat.i(114190);
        HashMap hashMap = new HashMap();
        for (Entry entry : mCH.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(114190);
        return hashMap;
    }

    public static final void bW(List<l> list) {
        AppMethodBeat.i(114191);
        mCH.clear();
        for (l lVar : list) {
            if (lVar.userData instanceof String) {
                mCH.put(lVar.mDx, (String) lVar.userData);
            } else {
                mCH.put(lVar.mDx, "");
            }
        }
        AppMethodBeat.o(114191);
    }

    public static String t(int[] iArr) {
        AppMethodBeat.i(114192);
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(114192);
        return stringBuilder2;
    }

    public static final String B(String[] strArr) {
        AppMethodBeat.i(114193);
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str : strArr) {
            Object obj;
            stringBuilder.append("\"");
            stringBuilder.append(str);
            char charAt = str.charAt(str.length() - 1);
            int obj2;
            if (charAt >= '0' && charAt <= '9') {
                obj2 = 1;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                obj2 = 1;
            } else if (charAt < 'a' || charAt > 'z') {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                stringBuilder.append("\"* ");
            } else {
                stringBuilder.append("\" ");
            }
        }
        String str2 = stringBuilder.toString().trim();
        AppMethodBeat.o(114193);
        return str2;
    }

    public static int f(int[] iArr, int i, int i2) {
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        if (i == i2) {
            return 0;
        }
        int i4 = i >= iArr.length ? BaseClientBuilder.API_PRIORITY_OTHER : iArr[i];
        if (i2 < iArr.length) {
            i3 = iArr[i2];
        }
        return i4 - i3;
    }

    public static int a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        AppMethodBeat.i(114194);
        if (i == i2) {
            AppMethodBeat.o(114194);
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? BaseClientBuilder.API_PRIORITY_OTHER : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        int i4 = intValue - i3;
        AppMethodBeat.o(114194);
        return i4;
    }

    public static List<l> a(List<l> list, final Map<Integer, Integer> map) {
        int i;
        int i2;
        AppMethodBeat.i(114195);
        AnonymousClass1 anonymousClass1 = new Comparator<l>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(114188);
                int a = d.a(map, ((l) obj).type, ((l) obj2).type);
                AppMethodBeat.o(114188);
                return a;
            }
        };
        l lVar = new l();
        lVar.type = 131073;
        int binarySearch = Collections.binarySearch(list, lVar, anonymousClass1);
        lVar.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, lVar, anonymousClass1);
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((l) list.get(i2)).type != 131073) {
                    i = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i = i2 + 1;
        }
        if (binarySearch2 < 0) {
            binarySearch = (-binarySearch2) - 1;
        } else {
            int size = list.size();
            i2 = binarySearch2 + 1;
            while (i2 < size && ((l) list.get(i2)).type == 131074) {
                i2++;
            }
            binarySearch = i2;
        }
        List subList = list.subList(i, binarySearch);
        AppMethodBeat.o(114195);
        return subList;
    }

    public static final String Na(String str) {
        AppMethodBeat.i(114196);
        if (str == null) {
            AppMethodBeat.o(114196);
            return null;
        }
        String Nf = g.Nf(((a) g.K(a.class)).dE(str.trim(), " "));
        AppMethodBeat.o(114196);
        return Nf;
    }

    public static final String Nb(String str) {
        AppMethodBeat.i(114197);
        String Nf = g.Nf(str.toLowerCase());
        AppMethodBeat.o(114197);
        return Nf;
    }

    public static final String Nc(String str) {
        AppMethodBeat.i(114198);
        if (str != null) {
            String trim = str.replace('*', ' ').trim();
            AppMethodBeat.o(114198);
            return trim;
        }
        AppMethodBeat.o(114198);
        return null;
    }

    public static String eu(String str, String str2) {
        AppMethodBeat.i(114199);
        if (str2 == null || str2.length() <= 0) {
            for (String startsWith : mCI) {
                if (str.startsWith(startsWith)) {
                    AppMethodBeat.o(114199);
                    return null;
                }
            }
            if (str.indexOf(64) >= 0) {
                AppMethodBeat.o(114199);
                return null;
            }
            AppMethodBeat.o(114199);
            return str;
        }
        AppMethodBeat.o(114199);
        return str2;
    }

    public static String aL(String str, boolean z) {
        AppMethodBeat.i(114200);
        if (str == null) {
            AppMethodBeat.o(114200);
            return null;
        }
        String toLowerCase = Na(str).toLowerCase();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < toLowerCase.length(); i2++) {
            char charAt = toLowerCase.charAt(i2);
            if (g.t(charAt)) {
                String[] strArr = (String[]) g.mDn.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(" ");
                } else {
                    List arrayList2 = new ArrayList();
                    for (i = 0; i < strArr.length; i++) {
                        Object substring;
                        if (z) {
                            substring = strArr[i].substring(0, 1);
                        } else {
                            substring = strArr[i];
                        }
                        if (!arrayList2.contains(substring)) {
                            arrayList2.add(substring);
                        }
                    }
                    arrayList.add(bo.c(arrayList2, "‏"));
                    i = 1;
                }
            } else {
                arrayList.add(" ");
            }
        }
        if (i != 0) {
            String c = bo.c(arrayList, "‍");
            AppMethodBeat.o(114200);
            return c;
        }
        AppMethodBeat.o(114200);
        return null;
    }

    public static String C(String[] strArr) {
        AppMethodBeat.i(114201);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(114201);
        return stringBuilder2;
    }

    public static boolean h(int[] iArr, int i) {
        AppMethodBeat.i(114202);
        if (Arrays.binarySearch(iArr, i) >= 0) {
            AppMethodBeat.o(114202);
            return true;
        }
        AppMethodBeat.o(114202);
        return false;
    }

    public static boolean Nd(String str) {
        AppMethodBeat.i(114203);
        if (str == null) {
            AppMethodBeat.o(114203);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[0-9]+$")) {
            AppMethodBeat.o(114203);
            return false;
        } else {
            AppMethodBeat.o(114203);
            return true;
        }
    }

    public static boolean Ne(String str) {
        AppMethodBeat.i(114204);
        if (str == null) {
            AppMethodBeat.o(114204);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[A-Za-z0-9\\-_]+$")) {
            AppMethodBeat.o(114204);
            return false;
        } else {
            AppMethodBeat.o(114204);
            return true;
        }
    }

    public static boolean e(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean L(long j, long j2) {
        AppMethodBeat.i(114205);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (timeInMillis == instance.getTimeInMillis()) {
            AppMethodBeat.o(114205);
            return true;
        }
        AppMethodBeat.o(114205);
        return false;
    }

    public static String LC(String str) {
        AppMethodBeat.i(114206);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(114206);
            return str;
        } else if (!bo.isNullOrNil(aoO.field_conRemark)) {
            str = aoO.field_conRemark;
            AppMethodBeat.o(114206);
            return str;
        } else if (bo.isNullOrNil(aoO.field_nickname)) {
            if (t.mN(aoO.field_username)) {
                str = ((c) g.K(c.class)).XV().mJ(str);
                if (!bo.isNullOrNil(str)) {
                    AppMethodBeat.o(114206);
                    return str;
                }
            }
            str = aoO.field_username;
            AppMethodBeat.o(114206);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.o(114206);
            return str;
        }
    }

    public static void c(Context context, String str, Intent intent) {
        AppMethodBeat.i(114207);
        try {
            String str2 = ah.doz() + ".plugin.fts";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                AppMethodBeat.o(114207);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.o(114207);
        } catch (Exception e) {
            ab.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.o(114207);
        }
    }

    public static void b(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(114208);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                ab.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.o(114208);
                return;
            }
        }
        String str2 = ah.doz() + ".plugin.fts";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.o(114208);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.o(114208);
    }
}
