package com.tencent.p177mm.p211cb;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32246d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.cb.b */
public class C37626b extends C32246d {
    public static final String xFA = (xFz + "/color_emoji");
    private static final boolean xFB = (VERSION.SDK_INT < 19);
    private static C37626b xFC;
    public static final String xFz = (C6457e.eSi + "app_font");
    private LinkedList<C45278c> jpa;
    private Context mContext = C4996ah.getContext();
    private int xFD = 0;
    private int xFE;
    private int xFF;
    private int xFG;
    public long xFH = 0;
    private C45277a xFI = new C45277a();
    private SparseArray<C45278c> xFJ = new SparseArray();
    public SparseArray<C45278c> xFK = new SparseArray();
    private SparseArray<C45278c> xFL = new SparseArray();
    private SparseArray<SparseArray<C45278c>> xFM = new SparseArray();
    private SparseArray<String> xFN = null;
    private C1177f<String, Bitmap> xFO = new C26399b(200, getClass());
    private boolean xFP = false;
    private LinkedList<C37628d> xFQ;
    private final Factory xFR = new C376271();

    /* renamed from: com.tencent.mm.cb.b$a */
    class C26002a {
        int end;
        int start;
        C45278c xFT;
        boolean xFU = false;

        public C26002a(C45278c c45278c, int i, int i2, boolean z) {
            this.xFT = c45278c;
            this.start = i;
            this.end = i2;
            this.xFU = z;
        }
    }

    /* renamed from: com.tencent.mm.cb.b$1 */
    class C376271 extends Factory {
        C376271() {
        }

        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.m2504i(62644);
            SpannableString spannableString = new SpannableString(charSequence);
            AppMethodBeat.m2505o(62644);
            return spannableString;
        }
    }

    static {
        AppMethodBeat.m2504i(62663);
        AppMethodBeat.m2505o(62663);
    }

    private C37626b() {
        AppMethodBeat.m2504i(62645);
        if (C5730e.m8628ct(xFA)) {
            C4990ab.m7416i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            C37626b.dqF();
        }
        init();
        if (C1338a.m2865ga(this.mContext)) {
            this.xFD = C1338a.fromDPToPix(this.mContext, 4);
            AppMethodBeat.m2505o(62645);
            return;
        }
        this.xFD = C1338a.fromDPToPix(this.mContext, 2);
        AppMethodBeat.m2505o(62645);
    }

    public static C37626b dqD() {
        AppMethodBeat.m2504i(62646);
        if (xFC == null) {
            synchronized (C37626b.class) {
                try {
                    xFC = new C37626b();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(62646);
                    }
                }
            }
        }
        C37626b c37626b = xFC;
        AppMethodBeat.m2505o(62646);
        return c37626b;
    }

    public static void dqE() {
        AppMethodBeat.m2504i(62647);
        C5728b c5728b = new C5728b(xFz);
        if (c5728b.isFile()) {
            c5728b.delete();
        }
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(62647);
    }

    private static void dqF() {
        AppMethodBeat.m2504i(62648);
        long currentTimeMillis = System.currentTimeMillis();
        C37626b.dqE();
        C5730e.m8644y("assets:///color_emoji", xFA);
        C4990ab.m7411d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(62648);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A:{Catch:{ IOException -> 0x00db }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A:{Catch:{ IOException -> 0x00db }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        Throwable e;
        AppMethodBeat.m2504i(62649);
        InputStream openRead;
        DataInputStream dataInputStream;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            openRead = C5730e.openRead(xFA);
            try {
                dataInputStream = new DataInputStream(openRead);
                try {
                    this.xFG = dataInputStream.readInt();
                    this.xFH = dataInputStream.readLong();
                    this.xFE = dataInputStream.readInt();
                    this.xFF = ((this.xFE + 4) + 8) + 4;
                    if (this.xFE <= 0 || this.xFE > dataInputStream.available()) {
                        C4990ab.m7421w("MicroMsg.EmojiHelper", "emoji header size error %d", Integer.valueOf(this.xFE));
                        dqH();
                    } else {
                        byte[] bArr = new byte[this.xFE];
                        dataInputStream.read(bArr);
                        this.xFI.parseFrom(bArr);
                        dqI();
                        this.xFP = true;
                    }
                    C4990ab.m7417i("MicroMsg.EmojiHelper", "init time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    try {
                        dataInputStream.close();
                        if (openRead != null) {
                            openRead.close();
                        }
                        AppMethodBeat.m2505o(62649);
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        AppMethodBeat.m2505o(62649);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                dataInputStream = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                            AppMethodBeat.m2505o(62649);
                            return;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.m2505o(62649);
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                    }
                    if (openRead != null) {
                    }
                    AppMethodBeat.m2505o(62649);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e5) {
                        C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                        AppMethodBeat.m2505o(62649);
                        throw e;
                    }
                }
                if (openRead != null) {
                    openRead.close();
                }
                AppMethodBeat.m2505o(62649);
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
            AppMethodBeat.m2505o(62649);
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
        AppMethodBeat.m2504i(62650);
        InputStream openRead;
        try {
            DataInputStream dataInputStream2;
            openRead = C5730e.openRead(str);
            try {
                dataInputStream2 = new DataInputStream(openRead);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            AppMethodBeat.m2505o(62650);
                            return 0;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.m2505o(62650);
                    return 0;
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            AppMethodBeat.m2505o(62650);
                            throw e;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.m2505o(62650);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.m2505o(62650);
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
                    C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                }
                AppMethodBeat.m2505o(62650);
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
                AppMethodBeat.m2505o(62650);
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
            AppMethodBeat.m2505o(62650);
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
        AppMethodBeat.m2504i(62651);
        InputStream openRead;
        DataInputStream dataInputStream;
        try {
            openRead = C5730e.openRead(str);
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
                        C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(62651);
                    return readInt;
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                dataInputStream = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                            AppMethodBeat.m2505o(62651);
                            return 0;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.m2505o(62651);
                    return 0;
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                            AppMethodBeat.m2505o(62651);
                            throw e;
                        }
                    }
                    if (openRead != null) {
                        openRead.close();
                    }
                    AppMethodBeat.m2505o(62651);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.m2505o(62651);
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
            AppMethodBeat.m2505o(62651);
            throw e;
        }
    }

    /* renamed from: a */
    public final SpannableString mo60449a(SpannableString spannableString, int i, PInt pInt) {
        AppMethodBeat.m2504i(62652);
        SpannableString spannableString2 = (SpannableString) mo60448a(spannableString, i, pInt, this.xFR);
        AppMethodBeat.m2505o(62652);
        return spannableString2;
    }

    /* renamed from: a */
    public final Spannable mo60448a(Spannable spannable, int i, PInt pInt, Factory factory) {
        AppMethodBeat.m2504i(62653);
        if (spannable == null || spannable.length() == 0) {
            AppMethodBeat.m2505o(62653);
            return spannable;
        }
        String obj = spannable.toString();
        LinkedList<C26002a> linkedList = new LinkedList();
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
            C45278c Mi = C37626b.dqD().mo60446Mi(codePointAt2);
            if (Mi != null) {
                linkedList.add(new C26002a(Mi, i2, i2 + 1, true));
            } else {
                Mi = C37626b.dqD().mo60452gY(codePointAt2, codePointAt);
                if (Mi != null) {
                    int charCount2;
                    if (Mi.jil != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    linkedList.add(new C26002a(Mi, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            AppMethodBeat.m2505o(62653);
            return spannable;
        }
        Spannable newSpannable;
        if (xFB) {
            StringBuilder stringBuilder = new StringBuilder(obj);
            for (C26002a c26002a : linkedList) {
                if (!c26002a.xFU) {
                    if (c26002a.xFT.jim == 0 || c26002a.end - c26002a.start != 1) {
                        stringBuilder.replace(c26002a.start, c26002a.end, "....".substring(0, c26002a.end - c26002a.start));
                    } else {
                        stringBuilder.replace(c26002a.start, c26002a.end, String.valueOf((char) c26002a.xFT.jim));
                    }
                }
            }
            newSpannable = factory.newSpannable(stringBuilder.toString());
        } else {
            newSpannable = spannable;
        }
        for (C26002a c26002a2 : linkedList) {
            mo60450a(newSpannable, C37626b.dqD().mo60447a(c26002a2.xFT, true), c26002a2.start, c26002a2.end, i);
        }
        pInt.value -= linkedList.size();
        AppMethodBeat.m2505o(62653);
        return newSpannable;
    }

    public static boolean anT(String str) {
        AppMethodBeat.m2504i(62654);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(62654);
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
            if (C37626b.dqD().mo60446Mi(codePointAt) != null) {
                AppMethodBeat.m2505o(62654);
                return true;
            } else if (C37626b.dqD().mo60452gY(codePointAt, i) != null) {
                AppMethodBeat.m2505o(62654);
                return true;
            } else {
                i = charCount;
            }
        }
        AppMethodBeat.m2505o(62654);
        return false;
    }

    public final String anU(String str) {
        AppMethodBeat.m2504i(62655);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(62655);
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
            C45278c Mi = C37626b.dqD().mo60446Mi(codePointAt2);
            String str2;
            if (Mi != null) {
                str2 = (String) this.xFN.get(Mi.jim);
                if (str2 != null) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append(this.mContext.getString(C25738R.string.f9101pi));
                }
            } else {
                Mi = C37626b.dqD().mo60452gY(codePointAt2, codePointAt);
                if (Mi != null) {
                    if (Mi.jil != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    str2 = (String) this.xFN.get(Mi.jim);
                    if (str2 != null) {
                        stringBuilder.append(str2);
                    } else {
                        stringBuilder.append(this.mContext.getString(C25738R.string.f9101pi));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(62655);
        return str;
    }

    private void dqG() {
        String[] stringArray;
        AppMethodBeat.m2504i(62656);
        Context context = C4996ah.getContext();
        String g = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        if (g.equals("zh_CN")) {
            stringArray = context.getResources().getStringArray(C25738R.array.f12609i);
        } else if (g.equals("zh_TW") || g.equals("zh_HK")) {
            stringArray = context.getResources().getStringArray(C25738R.array.f12611k);
        } else {
            stringArray = context.getResources().getStringArray(C25738R.array.f12610j);
        }
        String[] stringArray2 = context.getResources().getStringArray(C25738R.array.f12608h);
        this.xFN = new SparseArray();
        int i = 0;
        while (i < stringArray2.length && i < stringArray.length) {
            this.xFN.put(stringArray2[i].charAt(0), stringArray[i]);
            i++;
        }
        AppMethodBeat.m2505o(62656);
    }

    /* renamed from: a */
    public final void mo60450a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        AppMethodBeat.m2504i(62657);
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            C5664a c5664a = new C5664a(drawable);
            c5664a.zLT = this.xFD;
            spannable.setSpan(c5664a, i, i2, 33);
            AppMethodBeat.m2505o(62657);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(62657);
        }
    }

    /* renamed from: gY */
    public final C45278c mo60452gY(int i, int i2) {
        AppMethodBeat.m2504i(62658);
        if (this.xFQ == null || this.xFQ.isEmpty() || this.xFP) {
            this.xFQ = new LinkedList(this.xFI.xFx);
            this.xFP = false;
        }
        if (this.xFQ == null || this.xFQ.isEmpty()) {
            AppMethodBeat.m2505o(62658);
            return null;
        }
        Iterator it = this.xFQ.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            C37628d c37628d = (C37628d) it.next();
            if (i < c37628d.min || i > c37628d.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            SparseArray sparseArray = (SparseArray) this.xFM.get(i);
            C45278c c45278c;
            if (sparseArray == null) {
                AppMethodBeat.m2505o(62658);
                return null;
            } else if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
                c45278c = (C45278c) sparseArray.get(i2);
                AppMethodBeat.m2505o(62658);
                return c45278c;
            } else {
                c45278c = (C45278c) sparseArray.get(0);
                AppMethodBeat.m2505o(62658);
                return c45278c;
            }
        }
        AppMethodBeat.m2505o(62658);
        return null;
    }

    /* renamed from: Mi */
    public final C45278c mo60446Mi(int i) {
        AppMethodBeat.m2504i(62659);
        if (i < 57345 || i > 58679) {
            AppMethodBeat.m2505o(62659);
            return null;
        }
        C45278c c45278c = (C45278c) this.xFJ.get(i);
        AppMethodBeat.m2505o(62659);
        return c45278c;
    }

    /* renamed from: qJ */
    public final Drawable mo60454qJ(int i) {
        AppMethodBeat.m2504i(62660);
        Drawable a = mo60447a((C45278c) this.xFL.get(i), true);
        AppMethodBeat.m2505o(62660);
        return a;
    }

    /* renamed from: a */
    public final Drawable mo60447a(C45278c c45278c, boolean z) {
        AppMethodBeat.m2504i(62661);
        if (c45278c == null) {
            C4990ab.m7416i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            AppMethodBeat.m2505o(62661);
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.xFO.get(c45278c.coc);
            if (bitmap == null || bitmap.isRecycled()) {
                byte[] e = C5730e.m8632e(xFA, c45278c.coc + this.xFF, c45278c.size);
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length, options);
                Drawable bitmapDrawable;
                if (decodeByteArray != null) {
                    decodeByteArray.setDensity(240);
                    this.xFO.put(c45278c.coc, decodeByteArray);
                    bitmapDrawable = new BitmapDrawable(C4996ah.getContext().getResources(), decodeByteArray);
                    AppMethodBeat.m2505o(62661);
                    return bitmapDrawable;
                }
                String str = "MicroMsg.EmojiHelper";
                String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(c45278c.size);
                objArr[1] = Integer.valueOf(e == null ? 0 : e.length);
                C4990ab.m7417i(str, str2, objArr);
                if (z) {
                    C37626b.dqD();
                    int anS = C37626b.anS(xFA);
                    C37626b.dqD();
                    C4990ab.m7417i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", Integer.valueOf(this.xFG), Long.valueOf(this.xFH), Integer.valueOf(anS), Long.valueOf(C37626b.anR(xFA)));
                    if (anS != this.xFG || r4 <= this.xFH) {
                        dqH();
                        bitmapDrawable = mo60447a(c45278c, false);
                        AppMethodBeat.m2505o(62661);
                        return bitmapDrawable;
                    }
                    init();
                    bitmapDrawable = mo60447a(c45278c, false);
                    AppMethodBeat.m2505o(62661);
                    return bitmapDrawable;
                }
                AppMethodBeat.m2505o(62661);
                return null;
            }
            Drawable bitmapDrawable2 = new BitmapDrawable(C4996ah.getContext().getResources(), bitmap);
            AppMethodBeat.m2505o(62661);
            return bitmapDrawable2;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
        }
    }

    private void dqH() {
        AppMethodBeat.m2504i(138410);
        if (C4996ah.bqo()) {
            C5730e.deleteFile(xFA);
            C37626b.dqF();
            C14845c.veg.mo27152f(37, 4, -1, false);
            init();
        }
        AppMethodBeat.m2505o(138410);
    }

    private void dqI() {
        AppMethodBeat.m2504i(62662);
        this.jpa = new LinkedList(this.xFI.xFy);
        if (this.jpa == null || this.jpa.isEmpty()) {
            C4990ab.m7416i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            AppMethodBeat.m2505o(62662);
            return;
        }
        Iterator it = this.jpa.iterator();
        while (it.hasNext()) {
            C45278c c45278c = (C45278c) it.next();
            if (c45278c.jik != 0) {
                SparseArray sparseArray = (SparseArray) this.xFM.get(c45278c.jik);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.xFM.append(c45278c.jik, sparseArray);
                }
                sparseArray.put(c45278c.jil, c45278c);
                if (c45278c.jim != 0) {
                    this.xFJ.append(c45278c.jim, c45278c);
                }
                if (c45278c.xFV != -1) {
                    this.xFK.append(c45278c.xFV, c45278c);
                }
            } else {
                this.xFL.append(c45278c.xFW, c45278c);
            }
        }
        AppMethodBeat.m2505o(62662);
    }
}
