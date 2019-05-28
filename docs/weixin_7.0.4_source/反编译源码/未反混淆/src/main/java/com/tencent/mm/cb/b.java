package com.tencent.mm.cb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.api.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class b extends d {
    public static final String xFA = (xFz + "/color_emoji");
    private static final boolean xFB = (VERSION.SDK_INT < 19);
    private static b xFC;
    public static final String xFz = (e.eSi + "app_font");
    private LinkedList<c> jpa;
    private Context mContext = ah.getContext();
    private int xFD = 0;
    private int xFE;
    private int xFF;
    private int xFG;
    public long xFH = 0;
    private a xFI = new a();
    private SparseArray<c> xFJ = new SparseArray();
    public SparseArray<c> xFK = new SparseArray();
    private SparseArray<c> xFL = new SparseArray();
    private SparseArray<SparseArray<c>> xFM = new SparseArray();
    private SparseArray<String> xFN = null;
    private f<String, Bitmap> xFO = new com.tencent.mm.memory.a.b(200, getClass());
    private boolean xFP = false;
    private LinkedList<d> xFQ;
    private final Factory xFR = new Factory() {
        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.i(62644);
            SpannableString spannableString = new SpannableString(charSequence);
            AppMethodBeat.o(62644);
            return spannableString;
        }
    };

    class a {
        int end;
        int start;
        c xFT;
        boolean xFU = false;

        public a(c cVar, int i, int i2, boolean z) {
            this.xFT = cVar;
            this.start = i;
            this.end = i2;
            this.xFU = z;
        }
    }

    static {
        AppMethodBeat.i(62663);
        AppMethodBeat.o(62663);
    }

    private b() {
        AppMethodBeat.i(62645);
        if (com.tencent.mm.vfs.e.ct(xFA)) {
            ab.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            dqF();
        }
        init();
        if (com.tencent.mm.bz.a.ga(this.mContext)) {
            this.xFD = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 4);
            AppMethodBeat.o(62645);
            return;
        }
        this.xFD = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 2);
        AppMethodBeat.o(62645);
    }

    public static b dqD() {
        AppMethodBeat.i(62646);
        if (xFC == null) {
            synchronized (b.class) {
                try {
                    xFC = new b();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(62646);
                    }
                }
            }
        }
        b bVar = xFC;
        AppMethodBeat.o(62646);
        return bVar;
    }

    public static void dqE() {
        AppMethodBeat.i(62647);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(xFz);
        if (bVar.isFile()) {
            bVar.delete();
        }
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(62647);
    }

    private static void dqF() {
        AppMethodBeat.i(62648);
        long currentTimeMillis = System.currentTimeMillis();
        dqE();
        com.tencent.mm.vfs.e.y("assets:///color_emoji", xFA);
        ab.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(62648);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A:{Catch:{ IOException -> 0x00db }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A:{Catch:{ IOException -> 0x00db }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        Throwable e;
        AppMethodBeat.i(62649);
        InputStream openRead;
        DataInputStream dataInputStream;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            openRead = com.tencent.mm.vfs.e.openRead(xFA);
            try {
                dataInputStream = new DataInputStream(openRead);
                try {
                    this.xFG = dataInputStream.readInt();
                    this.xFH = dataInputStream.readLong();
                    this.xFE = dataInputStream.readInt();
                    this.xFF = ((this.xFE + 4) + 8) + 4;
                    if (this.xFE <= 0 || this.xFE > dataInputStream.available()) {
                        ab.w("MicroMsg.EmojiHelper", "emoji header size error %d", Integer.valueOf(this.xFE));
                        dqH();
                    } else {
                        byte[] bArr = new byte[this.xFE];
                        dataInputStream.read(bArr);
                        this.xFI.parseFrom(bArr);
                        dqI();
                        this.xFP = true;
                    }
                    ab.i("MicroMsg.EmojiHelper", "init time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    try {
                        dataInputStream.close();
                        if (openRead != null) {
                            openRead.close();
                        }
                        AppMethodBeat.o(62649);
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        AppMethodBeat.o(62649);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                dataInputStream = null;
                try {
                    ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                            AppMethodBeat.o(62649);
                            return;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.o(62649);
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                    }
                    if (openRead != null) {
                    }
                    AppMethodBeat.o(62649);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e5) {
                        ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                        AppMethodBeat.o(62649);
                        throw e;
                    }
                }
                if (openRead != null) {
                    openRead.close();
                }
                AppMethodBeat.o(62649);
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            dataInputStream = null;
            openRead = null;
        } catch (Throwable th3) {
            e = th3;
            dataInputStream = null;
            openRead = null;
            if (dataInputStream != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.o(62649);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A:{SYNTHETIC, Splitter:B:29:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A:{Catch:{ IOException -> 0x006e }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A:{SYNTHETIC, Splitter:B:29:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A:{Catch:{ IOException -> 0x006e }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A:{SYNTHETIC, Splitter:B:29:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A:{Catch:{ IOException -> 0x006e }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long anR(String str) {
        Throwable e;
        DataInputStream dataInputStream;
        AppMethodBeat.i(62650);
        InputStream openRead;
        try {
            DataInputStream dataInputStream2;
            openRead = com.tencent.mm.vfs.e.openRead(str);
            try {
                dataInputStream2 = new DataInputStream(openRead);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                try {
                    ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            AppMethodBeat.o(62650);
                            return 0;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.o(62650);
                    return 0;
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e4) {
                            ab.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            AppMethodBeat.o(62650);
                            throw e;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.o(62650);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.o(62650);
                throw e;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    if (openRead != null) {
                        openRead.close();
                    }
                } catch (IOException e5) {
                    ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                }
                AppMethodBeat.o(62650);
                return readLong;
            } catch (IOException e6) {
                e = e6;
                dataInputStream = dataInputStream2;
            } catch (Throwable th3) {
                e = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.o(62650);
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            dataInputStream = null;
            openRead = null;
        } catch (Throwable th4) {
            e = th4;
            dataInputStream = null;
            openRead = null;
            if (dataInputStream != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.o(62650);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A:{SYNTHETIC, Splitter:B:29:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063 A:{Catch:{ IOException -> 0x006a }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A:{SYNTHETIC, Splitter:B:29:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063 A:{Catch:{ IOException -> 0x006a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int anS(String str) {
        Throwable e;
        AppMethodBeat.i(62651);
        InputStream openRead;
        DataInputStream dataInputStream;
        try {
            openRead = com.tencent.mm.vfs.e.openRead(str);
            try {
                dataInputStream = new DataInputStream(openRead);
                try {
                    int readInt = dataInputStream.readInt();
                    try {
                        dataInputStream.close();
                        if (openRead != null) {
                            openRead.close();
                        }
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(62651);
                    return readInt;
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                dataInputStream = null;
                try {
                    ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                            ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                            AppMethodBeat.o(62651);
                            return 0;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.o(62651);
                    return 0;
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                            AppMethodBeat.o(62651);
                            throw e;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.o(62651);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.o(62651);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            dataInputStream = null;
            openRead = null;
        } catch (Throwable th3) {
            e = th3;
            dataInputStream = null;
            openRead = null;
            if (dataInputStream != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.o(62651);
            throw e;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        AppMethodBeat.i(62652);
        SpannableString spannableString2 = (SpannableString) a(spannableString, i, pInt, this.xFR);
        AppMethodBeat.o(62652);
        return spannableString2;
    }

    public final Spannable a(Spannable spannable, int i, PInt pInt, Factory factory) {
        AppMethodBeat.i(62653);
        if (spannable == null || spannable.length() == 0) {
            AppMethodBeat.o(62653);
            return spannable;
        }
        String obj = spannable.toString();
        LinkedList<a> linkedList = new LinkedList();
        int length = obj.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = obj.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = obj.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c Mi = dqD().Mi(codePointAt2);
            if (Mi != null) {
                linkedList.add(new a(Mi, i2, i2 + 1, true));
            } else {
                Mi = dqD().gY(codePointAt2, codePointAt);
                if (Mi != null) {
                    int charCount2;
                    if (Mi.jil != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    linkedList.add(new a(Mi, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            AppMethodBeat.o(62653);
            return spannable;
        }
        Spannable newSpannable;
        if (xFB) {
            StringBuilder stringBuilder = new StringBuilder(obj);
            for (a aVar : linkedList) {
                if (!aVar.xFU) {
                    if (aVar.xFT.jim == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.xFT.jim));
                    }
                }
            }
            newSpannable = factory.newSpannable(stringBuilder.toString());
        } else {
            newSpannable = spannable;
        }
        for (a aVar2 : linkedList) {
            a(newSpannable, dqD().a(aVar2.xFT, true), aVar2.start, aVar2.end, i);
        }
        pInt.value -= linkedList.size();
        AppMethodBeat.o(62653);
        return newSpannable;
    }

    public static boolean anT(String str) {
        AppMethodBeat.i(62654);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(62654);
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (dqD().Mi(codePointAt) != null) {
                AppMethodBeat.o(62654);
                return true;
            } else if (dqD().gY(codePointAt, i) != null) {
                AppMethodBeat.o(62654);
                return true;
            } else {
                i = charCount;
            }
        }
        AppMethodBeat.o(62654);
        return false;
    }

    public final String anU(String str) {
        AppMethodBeat.i(62655);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(62655);
            return str;
        }
        if (this.xFN == null) {
            dqG();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c Mi = dqD().Mi(codePointAt2);
            String str2;
            if (Mi != null) {
                str2 = (String) this.xFN.get(Mi.jim);
                if (str2 != null) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append(this.mContext.getString(R.string.pi));
                }
            } else {
                Mi = dqD().gY(codePointAt2, codePointAt);
                if (Mi != null) {
                    if (Mi.jil != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    str2 = (String) this.xFN.get(Mi.jim);
                    if (str2 != null) {
                        stringBuilder.append(str2);
                    } else {
                        stringBuilder.append(this.mContext.getString(R.string.pi));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(62655);
        return str;
    }

    private void dqG() {
        String[] stringArray;
        AppMethodBeat.i(62656);
        Context context = ah.getContext();
        String g = aa.g(context.getSharedPreferences(ah.doA(), 0));
        if (g.equals("zh_CN")) {
            stringArray = context.getResources().getStringArray(R.array.i);
        } else if (g.equals("zh_TW") || g.equals("zh_HK")) {
            stringArray = context.getResources().getStringArray(R.array.k);
        } else {
            stringArray = context.getResources().getStringArray(R.array.j);
        }
        String[] stringArray2 = context.getResources().getStringArray(R.array.h);
        this.xFN = new SparseArray();
        int i = 0;
        while (i < stringArray2.length && i < stringArray.length) {
            this.xFN.put(stringArray2[i].charAt(0), stringArray[i]);
            i++;
        }
        AppMethodBeat.o(62656);
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        AppMethodBeat.i(62657);
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
            aVar.zLT = this.xFD;
            spannable.setSpan(aVar, i, i2, 33);
            AppMethodBeat.o(62657);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
            AppMethodBeat.o(62657);
        }
    }

    public final c gY(int i, int i2) {
        AppMethodBeat.i(62658);
        if (this.xFQ == null || this.xFQ.isEmpty() || this.xFP) {
            this.xFQ = new LinkedList(this.xFI.xFx);
            this.xFP = false;
        }
        if (this.xFQ == null || this.xFQ.isEmpty()) {
            AppMethodBeat.o(62658);
            return null;
        }
        Iterator it = this.xFQ.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.min || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            SparseArray sparseArray = (SparseArray) this.xFM.get(i);
            c cVar;
            if (sparseArray == null) {
                AppMethodBeat.o(62658);
                return null;
            } else if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
                cVar = (c) sparseArray.get(i2);
                AppMethodBeat.o(62658);
                return cVar;
            } else {
                cVar = (c) sparseArray.get(0);
                AppMethodBeat.o(62658);
                return cVar;
            }
        }
        AppMethodBeat.o(62658);
        return null;
    }

    public final c Mi(int i) {
        AppMethodBeat.i(62659);
        if (i < 57345 || i > 58679) {
            AppMethodBeat.o(62659);
            return null;
        }
        c cVar = (c) this.xFJ.get(i);
        AppMethodBeat.o(62659);
        return cVar;
    }

    public final Drawable qJ(int i) {
        AppMethodBeat.i(62660);
        Drawable a = a((c) this.xFL.get(i), true);
        AppMethodBeat.o(62660);
        return a;
    }

    public final Drawable a(c cVar, boolean z) {
        AppMethodBeat.i(62661);
        if (cVar == null) {
            ab.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            AppMethodBeat.o(62661);
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.xFO.get(cVar.coc);
            if (bitmap == null || bitmap.isRecycled()) {
                byte[] e = com.tencent.mm.vfs.e.e(xFA, cVar.coc + this.xFF, cVar.size);
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length, options);
                Drawable bitmapDrawable;
                if (decodeByteArray != null) {
                    decodeByteArray.setDensity(240);
                    this.xFO.put(cVar.coc, decodeByteArray);
                    bitmapDrawable = new BitmapDrawable(ah.getContext().getResources(), decodeByteArray);
                    AppMethodBeat.o(62661);
                    return bitmapDrawable;
                }
                String str = "MicroMsg.EmojiHelper";
                String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(cVar.size);
                objArr[1] = Integer.valueOf(e == null ? 0 : e.length);
                ab.i(str, str2, objArr);
                if (z) {
                    dqD();
                    int anS = anS(xFA);
                    dqD();
                    ab.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", Integer.valueOf(this.xFG), Long.valueOf(this.xFH), Integer.valueOf(anS), Long.valueOf(anR(xFA)));
                    if (anS != this.xFG || r4 <= this.xFH) {
                        dqH();
                        bitmapDrawable = a(cVar, false);
                        AppMethodBeat.o(62661);
                        return bitmapDrawable;
                    }
                    init();
                    bitmapDrawable = a(cVar, false);
                    AppMethodBeat.o(62661);
                    return bitmapDrawable;
                }
                AppMethodBeat.o(62661);
                return null;
            }
            Drawable bitmapDrawable2 = new BitmapDrawable(ah.getContext().getResources(), bitmap);
            AppMethodBeat.o(62661);
            return bitmapDrawable2;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
        }
    }

    private void dqH() {
        AppMethodBeat.i(138410);
        if (ah.bqo()) {
            com.tencent.mm.vfs.e.deleteFile(xFA);
            dqF();
            c.veg.f(37, 4, -1, false);
            init();
        }
        AppMethodBeat.o(138410);
    }

    private void dqI() {
        AppMethodBeat.i(62662);
        this.jpa = new LinkedList(this.xFI.xFy);
        if (this.jpa == null || this.jpa.isEmpty()) {
            ab.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            AppMethodBeat.o(62662);
            return;
        }
        Iterator it = this.jpa.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.jik != 0) {
                SparseArray sparseArray = (SparseArray) this.xFM.get(cVar.jik);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.xFM.append(cVar.jik, sparseArray);
                }
                sparseArray.put(cVar.jil, cVar);
                if (cVar.jim != 0) {
                    this.xFJ.append(cVar.jim, cVar);
                }
                if (cVar.xFV != -1) {
                    this.xFK.append(cVar.xFV, cVar);
                }
            } else {
                this.xFL.append(cVar.xFW, cVar);
            }
        }
        AppMethodBeat.o(62662);
    }
}
