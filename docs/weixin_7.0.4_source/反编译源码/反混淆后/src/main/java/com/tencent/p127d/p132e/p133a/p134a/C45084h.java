package com.tencent.p127d.p132e.p133a.p134a;

import android.content.Context;
import com.p123qq.taf.jce.JceInputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p1165b.C17729a;
import com.tencent.p127d.p135f.C32113f;
import com.tencent.p127d.p135f.C37322j;
import com.tencent.p127d.p135f.C41670b;
import com.tencent.p127d.p135f.C8768c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.d.e.a.a.h */
public final class C45084h {
    private static final C37322j<C45084h> Atp = new C87631();
    public Context mContext;
    public boolean mInit = false;

    /* renamed from: com.tencent.d.e.a.a.h$1 */
    static class C87631 extends C37322j<C45084h> {
        C87631() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo19824mG() {
            AppMethodBeat.m2504i(114562);
            C45084h c45084h = new C45084h();
            AppMethodBeat.m2505o(114562);
            return c45084h;
        }
    }

    /* renamed from: com.tencent.d.e.a.a.h$a */
    public static class C37320a {
        public C17729a AtS;
        public List<String> AtT;

        private C37320a() {
        }

        /* synthetic */ C37320a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(114568);
        AppMethodBeat.m2505o(114568);
    }

    public static C45084h dQz() {
        AppMethodBeat.m2504i(114563);
        C45084h c45084h = (C45084h) Atp.get();
        AppMethodBeat.m2505o(114563);
        return c45084h;
    }

    public final void init(Context context) {
        this.mContext = context;
        this.mInit = true;
    }

    /* renamed from: hT */
    public final String mo72859hT(int i, int i2) {
        AppMethodBeat.m2504i(114564);
        String hU = C45084h.m82709hU(i, i2);
        File dir = this.mContext.getDir("turingmm", 0);
        String str;
        if (dir == null) {
            str = "";
            AppMethodBeat.m2505o(114564);
            return str;
        }
        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            str = "";
            AppMethodBeat.m2505o(114564);
            return str;
        }
        ArrayList<File> arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getName().startsWith(hU)) {
                arrayList.add(file);
            }
        }
        if (arrayList.size() <= 2) {
            str = "";
            AppMethodBeat.m2505o(114564);
            return str;
        }
        ArrayList arrayList2 = new ArrayList();
        for (File name : arrayList) {
            String[] split = name.getName().split("_");
            if (split.length == 2 && split[0].equals(hU)) {
                arrayList2.add(Long.valueOf(Long.parseLong(split[1])));
            }
        }
        if (arrayList2.size() <= 2) {
            str = "";
            AppMethodBeat.m2505o(114564);
            return str;
        }
        Collections.sort(arrayList2);
        str = dir.getAbsolutePath() + File.separator + hU + "_" + arrayList2.get(0);
        AppMethodBeat.m2505o(114564);
        return str;
    }

    public final Map<String, C17729a> dQA() {
        AppMethodBeat.m2504i(114565);
        HashMap hashMap = new HashMap();
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir == null) {
            AppMethodBeat.m2505o(114565);
        } else {
            File[] listFiles = dir.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(114565);
            } else {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    try {
                        Object obj;
                        byte[] n = C8768c.m15599n(C32113f.m52251ah(new File(file.getAbsolutePath())), C8768c.dQC());
                        if (n == null) {
                            obj = null;
                        } else {
                            byte[] cl = C41670b.m73072cl(n);
                            if (cl == null) {
                                obj = null;
                            } else {
                                obj = new C17729a();
                                obj.readFrom(new JceInputStream(cl));
                            }
                        }
                        if (obj == null) {
                            NullPointerException nullPointerException = new NullPointerException("csGroupRecord is null.");
                            AppMethodBeat.m2505o(114565);
                            throw nullPointerException;
                        }
                        hashMap.put(file.getAbsolutePath(), obj);
                        i++;
                    } catch (Throwable th) {
                        file.deleteOnExit();
                    }
                }
                AppMethodBeat.m2505o(114565);
            }
        }
        return hashMap;
    }

    /* renamed from: e */
    public static C37320a m82708e(Map<String, C17729a> map, int i) {
        AppMethodBeat.m2504i(114566);
        if (map == null) {
            AppMethodBeat.m2505o(114566);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        C17729a c17729a = null;
        for (String str : map.keySet()) {
            C17729a c17729a2 = (C17729a) map.get(str);
            if (c17729a2 != null && c17729a2.requestType == i) {
                arrayList.add(str);
                if (c17729a == null) {
                    c17729a = c17729a2;
                } else {
                    c17729a.Aub.addAll(c17729a2.Aub);
                }
            }
        }
        if (c17729a != null) {
            C37320a c37320a = new C37320a();
            c37320a.AtS = c17729a;
            c37320a.AtT = arrayList;
            AppMethodBeat.m2505o(114566);
            return c37320a;
        }
        AppMethodBeat.m2505o(114566);
        return null;
    }

    /* renamed from: hU */
    public static String m82709hU(int i, int i2) {
        AppMethodBeat.m2504i(114567);
        String str = i + "00" + i2;
        AppMethodBeat.m2505o(114567);
        return str;
    }
}
