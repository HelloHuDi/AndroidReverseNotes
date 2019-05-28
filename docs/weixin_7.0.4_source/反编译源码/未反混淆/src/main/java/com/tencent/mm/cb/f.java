package com.tencent.mm.cb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class f {
    private static volatile f xGd = null;
    public static Pattern xGo;
    private static final Comparator<a> xGp = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(62675);
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                AppMethodBeat.o(62675);
                return 0;
            } else if (aVar == null || bo.isNullOrNil(aVar.text)) {
                AppMethodBeat.o(62675);
                return 1;
            } else if (aVar2 == null || bo.isNullOrNil(aVar2.text)) {
                AppMethodBeat.o(62675);
                return -1;
            } else {
                int compareTo = aVar.text.compareTo(aVar2.text);
                AppMethodBeat.o(62675);
                return compareTo;
            }
        }
    };
    public String[] xGe = null;
    public String[] xGf = null;
    public String[] xGg = null;
    public String[] xGh = null;
    public String[] xGi = null;
    public String[] xGj = null;
    public ArrayList<SmileyInfo> xGk;
    private ArrayList<a> xGl = new ArrayList();
    private HashMap<String, SmileyInfo> xGm = new HashMap();
    private SparseArray<String> xGn = new SparseArray();

    public static class a {
        public String name;
        public int pos;
        public String text;

        a() {
        }

        a(int i, String str, String str2) {
            this.pos = i;
            this.text = str;
            this.name = str2;
        }
    }

    static {
        AppMethodBeat.i(62690);
        AppMethodBeat.o(62690);
    }

    private f(Context context) {
        AppMethodBeat.i(62676);
        long currentTimeMillis = System.currentTimeMillis();
        this.xGe = context.getResources().getStringArray(R.array.ai);
        this.xGf = context.getResources().getStringArray(R.array.al);
        this.xGg = context.getResources().getStringArray(R.array.aj);
        this.xGh = context.getResources().getStringArray(R.array.an);
        this.xGi = context.getResources().getStringArray(R.array.ak);
        this.xGj = context.getResources().getStringArray(R.array.am);
        dqN();
        ab.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(62676);
    }

    public static f dqL() {
        AppMethodBeat.i(62677);
        if (xGd == null) {
            synchronized (f.class) {
                try {
                    if (xGd == null) {
                        xGd = new f(ah.getContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(62677);
                    }
                }
            }
        }
        f fVar = xGd;
        AppMethodBeat.o(62677);
        return fVar;
    }

    private synchronized int dqM() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(62678);
            this.xGl.clear();
            if (this.xGe == null || this.xGg == null || this.xGe.length != this.xGg.length) {
                ab.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
            } else {
                int length = this.xGe.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = this.xGe[i2];
                    String str2 = this.xGg[i2];
                    String str3 = (this.xGf == null || this.xGf.length <= i2) ? "" : this.xGf[i2];
                    String str4 = (this.xGh == null || this.xGh.length <= i2) ? "" : this.xGh[i2];
                    String str5 = (this.xGi == null || this.xGi.length <= i2) ? "" : this.xGi[i2];
                    String str6 = (this.xGj == null || this.xGj.length <= i2) ? "" : this.xGj[i2];
                    SmileyInfo smileyInfo = new SmileyInfo(str, str3, str2, str4, str5, str6, i2);
                    this.xGl.add(new a(i2, str, ""));
                    this.xGl.add(new a(i2, str2, ""));
                    this.xGl.add(new a(i2, str3, ""));
                    this.xGl.add(new a(i2, str4, ""));
                    this.xGl.add(new a(i2, str5, ""));
                    this.xGl.add(new a(i2, str6, ""));
                    this.xGm.put(str, smileyInfo);
                    this.xGn.put(smileyInfo.field_eggIndex, smileyInfo.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.xGk == null || this.xGk.isEmpty()) {
                Collections.sort(this.xGl, xGp);
            }
            AppMethodBeat.o(62678);
        }
        return i;
    }

    public final boolean dqN() {
        AppMethodBeat.i(62679);
        ab.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
        ArrayList bjO = ((d) g.M(d.class)).getProvider().bjO();
        if (bjO == null || bjO.isEmpty()) {
            dqO();
            AppMethodBeat.o(62679);
            return true;
        }
        em(bjO);
        dqO();
        AppMethodBeat.o(62679);
        return false;
    }

    private static void em(List<SmileyInfo> list) {
        boolean z;
        AppMethodBeat.i(62680);
        for (SmileyInfo smileyInfo : list) {
            if (!e.ct(com.tencent.mm.ao.a.afV() + smileyInfo.field_fileName)) {
                z = true;
                break;
            }
        }
        z = false;
        ab.i("MicroMsg.QQSmileyManager", "checkFile %b", Boolean.valueOf(z));
        if (z) {
            ((d) g.M(d.class)).getProvider().bjT();
        }
        AppMethodBeat.o(62680);
    }

    public final synchronized void dqO() {
        AppMethodBeat.i(62681);
        ab.i("MicroMsg.QQSmileyManager", "updateSmiley " + bo.dpG());
        long currentTimeMillis = System.currentTimeMillis();
        this.xGm.clear();
        this.xGn.clear();
        dqM();
        this.xGk = ((PluginEmoji) g.M(PluginEmoji.class)).getProvider().bjO();
        if (this.xGk == null || this.xGk.isEmpty()) {
            this.xGk = com.tencent.mm.emoji.e.a.a(new b("assets:///newemoji/newemoji-config.xml"));
        }
        if (this.xGk == null || this.xGk.isEmpty()) {
            ab.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
        } else {
            Iterator it = this.xGk.iterator();
            while (it.hasNext()) {
                SmileyInfo smileyInfo = (SmileyInfo) it.next();
                this.xGm.put(smileyInfo.field_key, smileyInfo);
                this.xGn.put(smileyInfo.field_eggIndex, smileyInfo.field_key);
                this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                if (bo.isNullOrNil(smileyInfo.field_cnValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_cnValue)) {
                    this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new a(-1, smileyInfo.field_cnValue, smileyInfo.field_fileName));
                }
                if (bo.isNullOrNil(smileyInfo.field_qqValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_qqValue)) {
                    this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new a(-1, smileyInfo.field_qqValue, smileyInfo.field_fileName));
                }
                if (bo.isNullOrNil(smileyInfo.field_twValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_twValue)) {
                    this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new a(-1, smileyInfo.field_twValue, smileyInfo.field_fileName));
                }
                if (bo.isNullOrNil(smileyInfo.field_enValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_enValue)) {
                    this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new a(-1, smileyInfo.field_enValue, smileyInfo.field_fileName));
                }
                if (bo.isNullOrNil(smileyInfo.field_thValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_thValue)) {
                    this.xGl.add(new a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new a(-1, smileyInfo.field_thValue, smileyInfo.field_fileName));
                }
            }
        }
        Collections.sort(this.xGl, xGp);
        ab.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(62681);
    }

    public final boolean anV(String str) {
        AppMethodBeat.i(62682);
        if (anW(str) != null) {
            AppMethodBeat.o(62682);
            return true;
        }
        AppMethodBeat.o(62682);
        return false;
    }

    public final a anW(String str) {
        AppMethodBeat.i(62683);
        if (this.xGl != null) {
            int i;
            int binarySearch = Collections.binarySearch(this.xGl, new a(0, str, ""), xGp);
            if (binarySearch < 0) {
                i = (-binarySearch) - 2;
            } else {
                i = binarySearch;
            }
            if (i >= 0 && i < this.xGl.size()) {
                a aVar = (a) this.xGl.get(i);
                if (!(aVar == null || str == null || !str.startsWith(aVar.text))) {
                    aVar = (a) this.xGl.get(i);
                    AppMethodBeat.o(62683);
                    return aVar;
                }
            }
        }
        AppMethodBeat.o(62683);
        return null;
    }

    public final SpannableString b(SpannableString spannableString, int i, int i2) {
        AppMethodBeat.i(62684);
        if (spannableString == null || spannableString.length() == 0) {
            AppMethodBeat.o(62684);
        } else {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            AppMethodBeat.o(62684);
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        AppMethodBeat.i(62685);
        a anW = anW(spannableString.subSequence(i, spannableString.length()));
        if (anW != null) {
            Drawable a = a(anW);
            if (a == null || i > spannableString.length() || anW.text.length() + i > spannableString.length()) {
                ab.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", anW.toString());
            } else {
                b.dqD().a(spannableString, a, i, i + anW.text.length(), i2);
                AppMethodBeat.o(62685);
                return true;
            }
        }
        AppMethodBeat.o(62685);
        return false;
    }

    private static Drawable a(a aVar) {
        Drawable qJ;
        AppMethodBeat.i(62686);
        int i = aVar.pos;
        if (i >= 0) {
            qJ = b.dqD().qJ(i);
        } else {
            qJ = anX(aVar.name);
        }
        AppMethodBeat.o(62686);
        return qJ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A:{SYNTHETIC, Splitter:B:31:0x00b1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static Drawable anX(String str) {
        Throwable e;
        AppMethodBeat.i(62687);
        String str2 = com.tencent.mm.ao.a.afV() + str;
        InputStream openRead;
        try {
            if (e.ct(str2)) {
                openRead = e.openRead(str2);
            } else {
                ab.w("MicroMsg.QQSmileyManager", "[getQQSmileyDrawable] not exist! path:%s name:%s", str2, str);
                openRead = ah.getContext().getAssets().open("newemoji/".concat(String.valueOf(str)));
            }
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(openRead, null, options);
                if (decodeStream == null) {
                    ab.i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ah.getContext().getResources(), decodeStream);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                        ab.i("MicroMsg.QQSmileyManager", bo.l(e2));
                    }
                }
                AppMethodBeat.o(62687);
                return bitmapDrawable;
            } catch (IOException e3) {
                e = e3;
                try {
                    ab.i("MicroMsg.QQSmileyManager", bo.l(e));
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e4) {
                            ab.i("MicroMsg.QQSmileyManager", bo.l(e4));
                        }
                    }
                    AppMethodBeat.o(62687);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (openRead != null) {
                    }
                    AppMethodBeat.o(62687);
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            openRead = null;
        } catch (Throwable th2) {
            e = th2;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e22) {
                    ab.i("MicroMsg.QQSmileyManager", bo.l(e22));
                }
            }
            AppMethodBeat.o(62687);
            throw e;
        }
    }

    public final SmileyInfo anY(String str) {
        AppMethodBeat.i(62688);
        if (this.xGm == null || !this.xGm.containsKey(str)) {
            ab.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", str.replace("\\", "\\\\"));
            AppMethodBeat.o(62688);
            return null;
        }
        SmileyInfo smileyInfo = (SmileyInfo) this.xGm.get(str);
        AppMethodBeat.o(62688);
        return smileyInfo;
    }

    public final ArrayList<String> dqP() {
        AppMethodBeat.i(62689);
        ArrayList arrayList = new ArrayList();
        if (this.xGk != null) {
            Iterator it = this.xGk.iterator();
            while (it.hasNext()) {
                arrayList.add(((SmileyInfo) it.next()).field_key);
            }
        }
        AppMethodBeat.o(62689);
        return arrayList;
    }
}
