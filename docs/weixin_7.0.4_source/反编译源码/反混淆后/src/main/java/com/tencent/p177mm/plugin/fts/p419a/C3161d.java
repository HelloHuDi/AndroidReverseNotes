package com.tencent.p177mm.plugin.fts.p419a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.fts.a.d */
public final class C3161d {
    private static final HashMap<String, String> mCH = new HashMap();
    private static String[] mCI = new String[]{"wxid_", "wx_", "gh_"};

    /* renamed from: MZ */
    public static String m5402MZ(String str) {
        AppMethodBeat.m2504i(114189);
        if (C1855t.m3901mN(str)) {
            AppMethodBeat.m2505o(114189);
            return str;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(114189);
            return str;
        } else if (!C5046bo.isNullOrNil(aoO.field_conRemarkPYFull)) {
            str = aoO.field_conRemarkPYFull;
            AppMethodBeat.m2505o(114189);
            return str;
        } else if (!C5046bo.isNullOrNil(aoO.mo14677Hu())) {
            str = aoO.mo14677Hu();
            AppMethodBeat.m2505o(114189);
            return str;
        } else if (C5046bo.isNullOrNil(aoO.mo14673Hq())) {
            AppMethodBeat.m2505o(114189);
            return str;
        } else {
            str = aoO.mo14673Hq();
            AppMethodBeat.m2505o(114189);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(114209);
        AppMethodBeat.m2505o(114209);
    }

    public static final HashMap<String, String> bAi() {
        AppMethodBeat.m2504i(114190);
        HashMap hashMap = new HashMap();
        for (Entry entry : mCH.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.m2505o(114190);
        return hashMap;
    }

    /* renamed from: bW */
    public static final void m5412bW(List<C45966l> list) {
        AppMethodBeat.m2504i(114191);
        mCH.clear();
        for (C45966l c45966l : list) {
            if (c45966l.userData instanceof String) {
                mCH.put(c45966l.mDx, (String) c45966l.userData);
            } else {
                mCH.put(c45966l.mDx, "");
            }
        }
        AppMethodBeat.m2505o(114191);
    }

    /* renamed from: t */
    public static String m5418t(int[] iArr) {
        AppMethodBeat.m2504i(114192);
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(114192);
        return stringBuilder2;
    }

    /* renamed from: B */
    public static final String m5398B(String[] strArr) {
        AppMethodBeat.m2504i(114193);
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
        AppMethodBeat.m2505o(114193);
        return str2;
    }

    /* renamed from: f */
    public static int m5416f(int[] iArr, int i, int i2) {
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

    /* renamed from: a */
    public static int m5408a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        AppMethodBeat.m2504i(114194);
        if (i == i2) {
            AppMethodBeat.m2505o(114194);
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? BaseClientBuilder.API_PRIORITY_OTHER : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        int i4 = intValue - i3;
        AppMethodBeat.m2505o(114194);
        return i4;
    }

    /* renamed from: a */
    public static List<C45966l> m5409a(List<C45966l> list, final Map<Integer, Integer> map) {
        int i;
        int i2;
        AppMethodBeat.m2504i(114195);
        C31621 c31621 = new Comparator<C45966l>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(114188);
                int a = C3161d.m5408a(map, ((C45966l) obj).type, ((C45966l) obj2).type);
                AppMethodBeat.m2505o(114188);
                return a;
            }
        };
        C45966l c45966l = new C45966l();
        c45966l.type = 131073;
        int binarySearch = Collections.binarySearch(list, c45966l, c31621);
        c45966l.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, c45966l, c31621);
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((C45966l) list.get(i2)).type != 131073) {
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
            while (i2 < size && ((C45966l) list.get(i2)).type == 131074) {
                i2++;
            }
            binarySearch = i2;
        }
        List subList = list.subList(i, binarySearch);
        AppMethodBeat.m2505o(114195);
        return subList;
    }

    /* renamed from: Na */
    public static final String m5403Na(String str) {
        AppMethodBeat.m2504i(114196);
        if (str == null) {
            AppMethodBeat.m2505o(114196);
            return null;
        }
        String Nf = C34205g.m56096Nf(((C45845a) C1720g.m3528K(C45845a.class)).mo68464dE(str.trim(), " "));
        AppMethodBeat.m2505o(114196);
        return Nf;
    }

    /* renamed from: Nb */
    public static final String m5404Nb(String str) {
        AppMethodBeat.m2504i(114197);
        String Nf = C34205g.m56096Nf(str.toLowerCase());
        AppMethodBeat.m2505o(114197);
        return Nf;
    }

    /* renamed from: Nc */
    public static final String m5405Nc(String str) {
        AppMethodBeat.m2504i(114198);
        if (str != null) {
            String trim = str.replace('*', ' ').trim();
            AppMethodBeat.m2505o(114198);
            return trim;
        }
        AppMethodBeat.m2505o(114198);
        return null;
    }

    /* renamed from: eu */
    public static String m5415eu(String str, String str2) {
        AppMethodBeat.m2504i(114199);
        if (str2 == null || str2.length() <= 0) {
            for (String startsWith : mCI) {
                if (str.startsWith(startsWith)) {
                    AppMethodBeat.m2505o(114199);
                    return null;
                }
            }
            if (str.indexOf(64) >= 0) {
                AppMethodBeat.m2505o(114199);
                return null;
            }
            AppMethodBeat.m2505o(114199);
            return str;
        }
        AppMethodBeat.m2505o(114199);
        return str2;
    }

    /* renamed from: aL */
    public static String m5410aL(String str, boolean z) {
        AppMethodBeat.m2504i(114200);
        if (str == null) {
            AppMethodBeat.m2505o(114200);
            return null;
        }
        String toLowerCase = C3161d.m5403Na(str).toLowerCase();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < toLowerCase.length(); i2++) {
            char charAt = toLowerCase.charAt(i2);
            if (C34205g.m56097t(charAt)) {
                String[] strArr = (String[]) C34205g.mDn.get(String.valueOf(charAt));
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
                    arrayList.add(C5046bo.m7536c(arrayList2, "‏"));
                    i = 1;
                }
            } else {
                arrayList.add(" ");
            }
        }
        if (i != 0) {
            String c = C5046bo.m7536c(arrayList, "‍");
            AppMethodBeat.m2505o(114200);
            return c;
        }
        AppMethodBeat.m2505o(114200);
        return null;
    }

    /* renamed from: C */
    public static String m5399C(String[] strArr) {
        AppMethodBeat.m2504i(114201);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(114201);
        return stringBuilder2;
    }

    /* renamed from: h */
    public static boolean m5417h(int[] iArr, int i) {
        AppMethodBeat.m2504i(114202);
        if (Arrays.binarySearch(iArr, i) >= 0) {
            AppMethodBeat.m2505o(114202);
            return true;
        }
        AppMethodBeat.m2505o(114202);
        return false;
    }

    /* renamed from: Nd */
    public static boolean m5406Nd(String str) {
        AppMethodBeat.m2504i(114203);
        if (str == null) {
            AppMethodBeat.m2505o(114203);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[0-9]+$")) {
            AppMethodBeat.m2505o(114203);
            return false;
        } else {
            AppMethodBeat.m2505o(114203);
            return true;
        }
    }

    /* renamed from: Ne */
    public static boolean m5407Ne(String str) {
        AppMethodBeat.m2504i(114204);
        if (str == null) {
            AppMethodBeat.m2505o(114204);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[A-Za-z0-9\\-_]+$")) {
            AppMethodBeat.m2505o(114204);
            return false;
        } else {
            AppMethodBeat.m2505o(114204);
            return true;
        }
    }

    /* renamed from: e */
    public static boolean m5414e(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: L */
    public static boolean m5400L(long j, long j2) {
        AppMethodBeat.m2504i(114205);
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
            AppMethodBeat.m2505o(114205);
            return true;
        }
        AppMethodBeat.m2505o(114205);
        return false;
    }

    /* renamed from: LC */
    public static String m5401LC(String str) {
        AppMethodBeat.m2504i(114206);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(114206);
            return str;
        } else if (!C5046bo.isNullOrNil(aoO.field_conRemark)) {
            str = aoO.field_conRemark;
            AppMethodBeat.m2505o(114206);
            return str;
        } else if (C5046bo.isNullOrNil(aoO.field_nickname)) {
            if (C1855t.m3901mN(aoO.field_username)) {
                str = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14883mJ(str);
                if (!C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(114206);
                    return str;
                }
            }
            str = aoO.field_username;
            AppMethodBeat.m2505o(114206);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.m2505o(114206);
            return str;
        }
    }

    /* renamed from: c */
    public static void m5413c(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(114207);
        try {
            String str2 = C4996ah.doz() + ".plugin.fts";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(C4996ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                AppMethodBeat.m2505o(114207);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.m2505o(114207);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.m2505o(114207);
        }
    }

    /* renamed from: b */
    public static void m5411b(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(114208);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e);
                AppMethodBeat.m2505o(114208);
                return;
            }
        }
        String str2 = C4996ah.doz() + ".plugin.fts";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(C4996ah.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.m2505o(114208);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.m2505o(114208);
    }
}
