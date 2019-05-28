package com.tencent.mm.ca;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class f {
    private static final List<String> xuJ = Arrays.asList(new String[]{"zh_CN", "en"});
    private static f xuK;
    private static g xuL;
    private static c xuM;
    private static e xuN;
    private static String xuO = "";
    private static boolean xuP = false;
    private static boolean xuQ = true;
    private static ArrayList<Integer> xuR = new ArrayList();

    static {
        AppMethodBeat.i(105933);
        AppMethodBeat.o(105933);
    }

    public static f dmU() {
        f fVar;
        AppMethodBeat.i(105919);
        synchronized (f.class) {
            try {
                if (xuK == null) {
                    xuK = new f();
                }
                fVar = xuK;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105919);
            }
        }
        return fVar;
    }

    private f() {
    }

    private static boolean alX(String str) {
        AppMethodBeat.i(105920);
        if (xuJ.contains(str)) {
            AppMethodBeat.o(105920);
            return false;
        }
        AppMethodBeat.o(105920);
        return true;
    }

    private static void clean() {
        AppMethodBeat.i(105921);
        if (xuL != null) {
            g gVar = xuL;
            if (gVar.xuS != null) {
                gVar.xuS.clear();
            }
            if (gVar.xuT != null) {
                gVar.xuT = null;
            }
        }
        if (xuM != null) {
            c cVar = xuM;
            if (cVar.xuC != null) {
                cVar.xuC.clear();
            }
            if (cVar.mData != null) {
                cVar.mData = null;
            }
        }
        if (xuN != null) {
            e eVar = xuN;
            if (eVar.xuH != null) {
                eVar.xuH.clear();
            }
            if (eVar.mData != null) {
                eVar.mData = null;
            }
        }
        AppMethodBeat.o(105921);
    }

    public static f gf(Context context) {
        AppMethodBeat.i(105922);
        f bG = bG(context, aa.g(context.getSharedPreferences(ah.doA(), 0)));
        AppMethodBeat.o(105922);
        return bG;
    }

    public static f bG(Context context, String str) {
        AppMethodBeat.i(105923);
        if (context.getResources() == null) {
            ab.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            AppMethodBeat.o(105923);
            return null;
        }
        AssetManager assets = context.getAssets();
        if (assets != null) {
            dmU();
            a(assets);
        }
        if (assets != null) {
            dmU();
            if (xuQ) {
                Locale locale;
                if (bo.isNullOrNil(str) || str.equalsIgnoreCase("language_default")) {
                    locale = Locale.getDefault();
                    aa.a(context, locale);
                } else {
                    locale = aa.amw(str);
                }
                String locale2 = locale.toString();
                dmU();
                boolean alX = alX(locale2);
                xuP = alX;
                if (alX) {
                    dmU();
                    c(assets, locale2);
                    f dmU = dmU();
                    AppMethodBeat.o(105923);
                    return dmU;
                }
                clean();
                xuO = locale2;
                AppMethodBeat.o(105923);
                return null;
            }
        }
        AppMethodBeat.o(105923);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca A:{SYNTHETIC, Splitter:B:30:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf A:{SYNTHETIC, Splitter:B:33:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff A:{SYNTHETIC, Splitter:B:42:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A:{SYNTHETIC, Splitter:B:45:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff A:{SYNTHETIC, Splitter:B:42:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A:{SYNTHETIC, Splitter:B:45:0x0104} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(AssetManager assetManager) {
        DataInputStream dataInputStream;
        Throwable th;
        DataInputStream dataInputStream2;
        AppMethodBeat.i(105924);
        ab.i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
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
                    ab.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                    if (open != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    ab.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(105924);
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (open != null) {
                    }
                    if (dataInputStream2 != null) {
                    }
                    AppMethodBeat.o(105924);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e2));
                    }
                }
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e22) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e22));
                    }
                }
                AppMethodBeat.o(105924);
                throw th;
            }
            try {
                ab.d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream.readInt()));
                for (int i = 0; i < r3.intValue(); i++) {
                    xuR.add(Integer.valueOf(dataInputStream.readInt()));
                    ab.d("MicroMsg.language.StringResouces", "encrypt string id is %d", r4);
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e3) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e3));
                    }
                }
                try {
                    dataInputStream.close();
                } catch (IOException e222) {
                    ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e222));
                }
            } catch (IOException e4) {
                ab.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e32) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e32));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2222) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e2222));
                    }
                }
                ab.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(105924);
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
            AppMethodBeat.o(105924);
            throw th;
        }
        ab.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(105924);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01c8 A:{SYNTHETIC, Splitter:B:48:0x01c8} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cd A:{SYNTHETIC, Splitter:B:51:0x01cd} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ff A:{SYNTHETIC, Splitter:B:60:0x01ff} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0204 A:{SYNTHETIC, Splitter:B:63:0x0204} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(AssetManager assetManager, String str) {
        Throwable e;
        AppMethodBeat.i(105925);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.language.StringResouces", "local is null.");
            AppMethodBeat.o(105925);
        } else if (str.equals(xuO)) {
            ab.i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
            AppMethodBeat.o(105925);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    ab.d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            clean();
            xuO = str;
            ab.i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
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
                    ab.i("MicroMsg.language.StringResouces", "string count".concat(String.valueOf(readInt)));
                    SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                    int readInt2 = dataInputStream.readInt();
                    indexOf = 0;
                    for (i = 0; i < readInt; i++) {
                        readInt2 += dataInputStream.readShort();
                        sparseIntArray.append(readInt2, indexOf);
                        indexOf += dataInputStream.readShort();
                    }
                    xuL = g.a(sparseIntArray, dataInputStream, indexOf);
                    readInt = dataInputStream.readInt();
                    ab.i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                    if (readInt > 0) {
                        SparseArray sparseArray = new SparseArray(readInt);
                        readInt2 = dataInputStream.readInt();
                        i = 0;
                        for (indexOf = 0; indexOf < readInt; indexOf++) {
                            readInt2 += dataInputStream.readInt();
                            i += a(dataInputStream, sparseArray, readInt2, i);
                        }
                        xuM = c.a(sparseArray, dataInputStream, i);
                    }
                    int readInt3 = dataInputStream.readInt();
                    indexOf = dataInputStream.readInt();
                    ab.i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
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
                            sparseArray2.append(readInt2, new a(readInt2, iArr));
                            readInt++;
                            indexOf = readInt2;
                        }
                        xuN = e.b(sparseArray2, dataInputStream, i);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e2));
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException e22) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e22));
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.language.StringResouces", e, "[cpan] local :%s file can not be find. use default.", str);
                        if (inputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        ab.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(105925);
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        AppMethodBeat.o(105925);
                        throw e;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                dataInputStream = null;
                ab.printErrStackTrace("MicroMsg.language.StringResouces", e, "[cpan] local :%s file can not be find. use default.", str);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e222) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e222));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2222) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e2222));
                    }
                }
                ab.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(105925);
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e5));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e6) {
                        ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e6));
                    }
                }
                AppMethodBeat.o(105925);
                throw e;
            }
            ab.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(105925);
        }
    }

    public static boolean dmV() {
        AppMethodBeat.i(105926);
        if (!(xuQ && xuP)) {
            boolean z;
            if (xuR == null || xuR.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(105926);
                return false;
            }
        }
        AppMethodBeat.o(105926);
        return true;
    }

    public static boolean dmT() {
        return xuQ;
    }

    public static String getString(int i) {
        AppMethodBeat.i(105927);
        if (xuL == null) {
            AppMethodBeat.o(105927);
            return null;
        }
        String string = xuL.getString(i);
        AppMethodBeat.o(105927);
        return string;
    }

    public static String getQuantityString(int i, int i2) {
        AppMethodBeat.i(105928);
        if (xuM == null) {
            AppMethodBeat.o(105928);
            return null;
        }
        String quantityString = xuM.getQuantityString(i, i2, new Object[0]);
        AppMethodBeat.o(105928);
        return quantityString;
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        AppMethodBeat.i(105929);
        if (xuM == null) {
            AppMethodBeat.o(105929);
            return null;
        }
        String quantityString = xuM.getQuantityString(i, i2, objArr);
        AppMethodBeat.o(105929);
        return quantityString;
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        AppMethodBeat.i(105930);
        if (xuN == null) {
            AppMethodBeat.o(105930);
            return null;
        }
        e eVar = xuN;
        int indexOfKey = eVar.xuH.indexOfKey(i);
        if (indexOfKey < 0) {
            AppMethodBeat.o(105930);
            return null;
        }
        int i3;
        String[] strArr;
        if (indexOfKey < eVar.xuH.size() - 1) {
            i3 = ((a) eVar.xuH.valueAt(indexOfKey + 1)).xuI[0];
        } else {
            i3 = eVar.mData.length;
        }
        a aVar = (a) eVar.xuH.valueAt(indexOfKey);
        indexOfKey = aVar.xuI.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(eVar.mData, aVar.xuI[i2], aVar.xuI[i2 + 1] - aVar.xuI[i2]);
                } else {
                    strArr2[i2] = new String(eVar.mData, aVar.xuI[i2], i3 - aVar.xuI[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        AppMethodBeat.o(105930);
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<a> sparseArray, int i, int i2) {
        AppMethodBeat.i(105931);
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                AppMethodBeat.o(105931);
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
            sparseArray.append(i, new a(i, iArr, iArr2));
            AppMethodBeat.o(105931);
            return i3;
        } catch (IOException e) {
            ab.e("MicroMsg.language.StringResouces", "exception:%s", bo.l(e));
            AppMethodBeat.o(105931);
            return 0;
        }
    }

    public static CharSequence d(int i, CharSequence charSequence) {
        AppMethodBeat.i(105932);
        if (charSequence == null) {
            AppMethodBeat.o(105932);
            return charSequence;
        } else if (xuR == null || xuR.isEmpty()) {
            AppMethodBeat.o(105932);
            return charSequence;
        } else if (xuR.contains(Integer.valueOf(i))) {
            charSequence = a.x(charSequence.toString(), g.x("lucky".getBytes()).substring(0, 16));
            AppMethodBeat.o(105932);
            return charSequence;
        } else {
            AppMethodBeat.o(105932);
            return charSequence;
        }
    }
}
