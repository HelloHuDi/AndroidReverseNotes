package com.tencent.p177mm.p210ca;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1168a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p210ca.C1341c.C1340a;
import com.tencent.p177mm.p210ca.C1343e.C1342a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.ca.f */
public class C1344f {
    private static final List<String> xuJ = Arrays.asList(new String[]{"zh_CN", "en"});
    private static C1344f xuK;
    private static C1345g xuL;
    private static C1341c xuM;
    private static C1343e xuN;
    private static String xuO = "";
    private static boolean xuP = false;
    private static boolean xuQ = true;
    private static ArrayList<Integer> xuR = new ArrayList();

    static {
        AppMethodBeat.m2504i(105933);
        AppMethodBeat.m2505o(105933);
    }

    public static C1344f dmU() {
        C1344f c1344f;
        AppMethodBeat.m2504i(105919);
        synchronized (C1344f.class) {
            try {
                if (xuK == null) {
                    xuK = new C1344f();
                }
                c1344f = xuK;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105919);
            }
        }
        return c1344f;
    }

    private C1344f() {
    }

    private static boolean alX(String str) {
        AppMethodBeat.m2504i(105920);
        if (xuJ.contains(str)) {
            AppMethodBeat.m2505o(105920);
            return false;
        }
        AppMethodBeat.m2505o(105920);
        return true;
    }

    private static void clean() {
        AppMethodBeat.m2504i(105921);
        if (xuL != null) {
            C1345g c1345g = xuL;
            if (c1345g.xuS != null) {
                c1345g.xuS.clear();
            }
            if (c1345g.xuT != null) {
                c1345g.xuT = null;
            }
        }
        if (xuM != null) {
            C1341c c1341c = xuM;
            if (c1341c.xuC != null) {
                c1341c.xuC.clear();
            }
            if (c1341c.mData != null) {
                c1341c.mData = null;
            }
        }
        if (xuN != null) {
            C1343e c1343e = xuN;
            if (c1343e.xuH != null) {
                c1343e.xuH.clear();
            }
            if (c1343e.mData != null) {
                c1343e.mData = null;
            }
        }
        AppMethodBeat.m2505o(105921);
    }

    /* renamed from: gf */
    public static C1344f m2882gf(Context context) {
        AppMethodBeat.m2504i(105922);
        C1344f bG = C1344f.m2879bG(context, C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0)));
        AppMethodBeat.m2505o(105922);
        return bG;
    }

    /* renamed from: bG */
    public static C1344f m2879bG(Context context, String str) {
        AppMethodBeat.m2504i(105923);
        if (context.getResources() == null) {
            C4990ab.m7412e("MicroMsg.language.StringResouces", "the resource is null! why?");
            AppMethodBeat.m2505o(105923);
            return null;
        }
        AssetManager assets = context.getAssets();
        if (assets != null) {
            C1344f.dmU();
            C1344f.m2878a(assets);
        }
        if (assets != null) {
            C1344f.dmU();
            if (xuQ) {
                Locale locale;
                if (C5046bo.isNullOrNil(str) || str.equalsIgnoreCase("language_default")) {
                    locale = Locale.getDefault();
                    C4988aa.m7399a(context, locale);
                } else {
                    locale = C4988aa.amw(str);
                }
                String locale2 = locale.toString();
                C1344f.dmU();
                boolean alX = C1344f.alX(locale2);
                xuP = alX;
                if (alX) {
                    C1344f.dmU();
                    C1344f.m2880c(assets, locale2);
                    C1344f dmU = C1344f.dmU();
                    AppMethodBeat.m2505o(105923);
                    return dmU;
                }
                C1344f.clean();
                xuO = locale2;
                AppMethodBeat.m2505o(105923);
                return null;
            }
        }
        AppMethodBeat.m2505o(105923);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca A:{SYNTHETIC, Splitter:B:30:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf A:{SYNTHETIC, Splitter:B:33:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff A:{SYNTHETIC, Splitter:B:42:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A:{SYNTHETIC, Splitter:B:45:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff A:{SYNTHETIC, Splitter:B:42:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A:{SYNTHETIC, Splitter:B:45:0x0104} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m2878a(AssetManager assetManager) {
        DataInputStream dataInputStream;
        Throwable th;
        DataInputStream dataInputStream2;
        AppMethodBeat.m2504i(105924);
        C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
        if (xuR == null) {
            xuR = new ArrayList();
        }
        xuR.clear();
        long currentTimeMillis = System.currentTimeMillis();
        InputStream open;
        try {
            open = assetManager.open("estrings/encrypt.mmstrid");
            try {
                dataInputStream = new DataInputStream(open);
            } catch (IOException e) {
                dataInputStream = null;
                try {
                    C4990ab.m7420w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                    if (open != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(105924);
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (open != null) {
                    }
                    if (dataInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(105924);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e2));
                    }
                }
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e22));
                    }
                }
                AppMethodBeat.m2505o(105924);
                throw th;
            }
            try {
                C4990ab.m7411d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream.readInt()));
                for (int i = 0; i < r3.intValue(); i++) {
                    xuR.add(Integer.valueOf(dataInputStream.readInt()));
                    C4990ab.m7411d("MicroMsg.language.StringResouces", "encrypt string id is %d", r4);
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e3) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e3));
                    }
                }
                try {
                    dataInputStream.close();
                } catch (IOException e222) {
                    C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e222));
                }
            } catch (IOException e4) {
                C4990ab.m7420w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e32) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e32));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2222) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e2222));
                    }
                }
                C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(105924);
            }
        } catch (IOException e5) {
            dataInputStream = null;
            open = null;
        } catch (Throwable th32) {
            th = th32;
            dataInputStream2 = null;
            open = null;
            if (open != null) {
            }
            if (dataInputStream2 != null) {
            }
            AppMethodBeat.m2505o(105924);
            throw th;
        }
        C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(105924);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01c8 A:{SYNTHETIC, Splitter:B:48:0x01c8} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cd A:{SYNTHETIC, Splitter:B:51:0x01cd} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ff A:{SYNTHETIC, Splitter:B:60:0x01ff} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0204 A:{SYNTHETIC, Splitter:B:63:0x0204} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private static void m2880c(AssetManager assetManager, String str) {
        Throwable e;
        AppMethodBeat.m2504i(105925);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.language.StringResouces", "local is null.");
            AppMethodBeat.m2505o(105925);
        } else if (str.equals(xuO)) {
            C4990ab.m7417i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
            AppMethodBeat.m2505o(105925);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    C4990ab.m7411d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            C1344f.clean();
            xuO = str;
            C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream = null;
            DataInputStream dataInputStream;
            try {
                inputStream = assetManager.open("strings/" + str + ".mmstr");
                dataInputStream = new DataInputStream(inputStream);
                try {
                    int i;
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    int readInt = dataInputStream.readInt();
                    C4990ab.m7416i("MicroMsg.language.StringResouces", "string count".concat(String.valueOf(readInt)));
                    SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                    int readInt2 = dataInputStream.readInt();
                    indexOf = 0;
                    for (i = 0; i < readInt; i++) {
                        readInt2 += dataInputStream.readShort();
                        sparseIntArray.append(readInt2, indexOf);
                        indexOf += dataInputStream.readShort();
                    }
                    xuL = C1345g.m2883a(sparseIntArray, dataInputStream, indexOf);
                    readInt = dataInputStream.readInt();
                    C4990ab.m7417i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                    if (readInt > 0) {
                        SparseArray sparseArray = new SparseArray(readInt);
                        readInt2 = dataInputStream.readInt();
                        i = 0;
                        for (indexOf = 0; indexOf < readInt; indexOf++) {
                            readInt2 += dataInputStream.readInt();
                            i += C1344f.m2877a(dataInputStream, sparseArray, readInt2, i);
                        }
                        xuM = C1341c.m2875a(sparseArray, dataInputStream, i);
                    }
                    int readInt3 = dataInputStream.readInt();
                    indexOf = dataInputStream.readInt();
                    C4990ab.m7417i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
                    if (readInt3 > 0) {
                        SparseArray sparseArray2 = new SparseArray(readInt3);
                        i = 0;
                        readInt = 0;
                        while (readInt < readInt3) {
                            readInt2 = dataInputStream.readInt() + indexOf;
                            int readInt4 = dataInputStream.readInt();
                            int[] iArr = new int[readInt4];
                            for (indexOf = 0; indexOf < readInt4; indexOf++) {
                                iArr[indexOf] = i;
                                i += dataInputStream.readShort();
                            }
                            sparseArray2.append(readInt2, new C1342a(readInt2, iArr));
                            readInt++;
                            indexOf = readInt2;
                        }
                        xuN = C1343e.m2876b(sparseArray2, dataInputStream, i);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e2));
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e22));
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.language.StringResouces", e, "[cpan] local :%s file can not be find. use default.", str);
                        if (inputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(105925);
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        AppMethodBeat.m2505o(105925);
                        throw e;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                dataInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.language.StringResouces", e, "[cpan] local :%s file can not be find. use default.", str);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e222) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e222));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2222) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e2222));
                    }
                }
                C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(105925);
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e5));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e6) {
                        C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e6));
                    }
                }
                AppMethodBeat.m2505o(105925);
                throw e;
            }
            C4990ab.m7416i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(105925);
        }
    }

    public static boolean dmV() {
        AppMethodBeat.m2504i(105926);
        if (!(xuQ && xuP)) {
            boolean z;
            if (xuR == null || xuR.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.m2505o(105926);
                return false;
            }
        }
        AppMethodBeat.m2505o(105926);
        return true;
    }

    public static boolean dmT() {
        return xuQ;
    }

    public static String getString(int i) {
        AppMethodBeat.m2504i(105927);
        if (xuL == null) {
            AppMethodBeat.m2505o(105927);
            return null;
        }
        String string = xuL.getString(i);
        AppMethodBeat.m2505o(105927);
        return string;
    }

    public static String getQuantityString(int i, int i2) {
        AppMethodBeat.m2504i(105928);
        if (xuM == null) {
            AppMethodBeat.m2505o(105928);
            return null;
        }
        String quantityString = xuM.getQuantityString(i, i2, new Object[0]);
        AppMethodBeat.m2505o(105928);
        return quantityString;
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        AppMethodBeat.m2504i(105929);
        if (xuM == null) {
            AppMethodBeat.m2505o(105929);
            return null;
        }
        String quantityString = xuM.getQuantityString(i, i2, objArr);
        AppMethodBeat.m2505o(105929);
        return quantityString;
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(105930);
        if (xuN == null) {
            AppMethodBeat.m2505o(105930);
            return null;
        }
        C1343e c1343e = xuN;
        int indexOfKey = c1343e.xuH.indexOfKey(i);
        if (indexOfKey < 0) {
            AppMethodBeat.m2505o(105930);
            return null;
        }
        int i3;
        String[] strArr;
        if (indexOfKey < c1343e.xuH.size() - 1) {
            i3 = ((C1342a) c1343e.xuH.valueAt(indexOfKey + 1)).xuI[0];
        } else {
            i3 = c1343e.mData.length;
        }
        C1342a c1342a = (C1342a) c1343e.xuH.valueAt(indexOfKey);
        indexOfKey = c1342a.xuI.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(c1343e.mData, c1342a.xuI[i2], c1342a.xuI[i2 + 1] - c1342a.xuI[i2]);
                } else {
                    strArr2[i2] = new String(c1343e.mData, c1342a.xuI[i2], i3 - c1342a.xuI[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        AppMethodBeat.m2505o(105930);
        return strArr;
    }

    /* renamed from: a */
    private static int m2877a(DataInputStream dataInputStream, SparseArray<C1340a> sparseArray, int i, int i2) {
        AppMethodBeat.m2504i(105931);
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                AppMethodBeat.m2505o(105931);
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                iArr[b] = dataInputStream.readByte();
                iArr2[b] = i2;
                short readShort = dataInputStream.readShort();
                i3 += readShort;
                i2 += readShort;
            }
            sparseArray.append(i, new C1340a(i, iArr, iArr2));
            AppMethodBeat.m2505o(105931);
            return i3;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.language.StringResouces", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(105931);
            return 0;
        }
    }

    /* renamed from: d */
    public static CharSequence m2881d(int i, CharSequence charSequence) {
        AppMethodBeat.m2504i(105932);
        if (charSequence == null) {
            AppMethodBeat.m2505o(105932);
            return charSequence;
        } else if (xuR == null || xuR.isEmpty()) {
            AppMethodBeat.m2505o(105932);
            return charSequence;
        } else if (xuR.contains(Integer.valueOf(i))) {
            charSequence = C1168a.m2551x(charSequence.toString(), C1178g.m2591x("lucky".getBytes()).substring(0, 16));
            AppMethodBeat.m2505o(105932);
            return charSequence;
        } else {
            AppMethodBeat.m2505o(105932);
            return charSequence;
        }
    }
}
