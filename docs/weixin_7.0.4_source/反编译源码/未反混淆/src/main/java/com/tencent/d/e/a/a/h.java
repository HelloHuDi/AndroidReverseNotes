package com.tencent.d.e.a.a;

import android.content.Context;
import com.qq.taf.jce.JceInputStream;
import com.tencent.d.f.b;
import com.tencent.d.f.c;
import com.tencent.d.f.f;
import com.tencent.d.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {
    private static final j<h> Atp = new j<h>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(114562);
            h hVar = new h();
            AppMethodBeat.o(114562);
            return hVar;
        }
    };
    public Context mContext;
    public boolean mInit = false;

    public static class a {
        public com.tencent.d.e.a.b.a AtS;
        public List<String> AtT;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(114568);
        AppMethodBeat.o(114568);
    }

    public static h dQz() {
        AppMethodBeat.i(114563);
        h hVar = (h) Atp.get();
        AppMethodBeat.o(114563);
        return hVar;
    }

    public final void init(Context context) {
        this.mContext = context;
        this.mInit = true;
    }

    public final String hT(int i, int i2) {
        AppMethodBeat.i(114564);
        String hU = hU(i, i2);
        File dir = this.mContext.getDir("turingmm", 0);
        String str;
        if (dir == null) {
            str = "";
            AppMethodBeat.o(114564);
            return str;
        }
        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            str = "";
            AppMethodBeat.o(114564);
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
            AppMethodBeat.o(114564);
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
            AppMethodBeat.o(114564);
            return str;
        }
        Collections.sort(arrayList2);
        str = dir.getAbsolutePath() + File.separator + hU + "_" + arrayList2.get(0);
        AppMethodBeat.o(114564);
        return str;
    }

    public final Map<String, com.tencent.d.e.a.b.a> dQA() {
        AppMethodBeat.i(114565);
        HashMap hashMap = new HashMap();
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir == null) {
            AppMethodBeat.o(114565);
        } else {
            File[] listFiles = dir.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(114565);
            } else {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    try {
                        Object obj;
                        byte[] n = c.n(f.ah(new File(file.getAbsolutePath())), c.dQC());
                        if (n == null) {
                            obj = null;
                        } else {
                            byte[] cl = b.cl(n);
                            if (cl == null) {
                                obj = null;
                            } else {
                                obj = new com.tencent.d.e.a.b.a();
                                obj.readFrom(new JceInputStream(cl));
                            }
                        }
                        if (obj == null) {
                            NullPointerException nullPointerException = new NullPointerException("csGroupRecord is null.");
                            AppMethodBeat.o(114565);
                            throw nullPointerException;
                        }
                        hashMap.put(file.getAbsolutePath(), obj);
                        i++;
                    } catch (Throwable th) {
                        file.deleteOnExit();
                    }
                }
                AppMethodBeat.o(114565);
            }
        }
        return hashMap;
    }

    public static a e(Map<String, com.tencent.d.e.a.b.a> map, int i) {
        AppMethodBeat.i(114566);
        if (map == null) {
            AppMethodBeat.o(114566);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.d.e.a.b.a aVar = null;
        for (String str : map.keySet()) {
            com.tencent.d.e.a.b.a aVar2 = (com.tencent.d.e.a.b.a) map.get(str);
            if (aVar2 != null && aVar2.requestType == i) {
                arrayList.add(str);
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    aVar.Aub.addAll(aVar2.Aub);
                }
            }
        }
        if (aVar != null) {
            a aVar3 = new a();
            aVar3.AtS = aVar;
            aVar3.AtT = arrayList;
            AppMethodBeat.o(114566);
            return aVar3;
        }
        AppMethodBeat.o(114566);
        return null;
    }

    public static String hU(int i, int i2) {
        AppMethodBeat.i(114567);
        String str = i + "00" + i2;
        AppMethodBeat.o(114567);
        return str;
    }
}
