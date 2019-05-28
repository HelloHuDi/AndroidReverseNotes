package com.tencent.p177mm.p211cb;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p1177ao.C37462a;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.cb.f */
public final class C26005f {
    private static volatile C26005f xGd = null;
    public static Pattern xGo;
    private static final Comparator<C26004a> xGp = new C13471();
    public String[] xGe = null;
    public String[] xGf = null;
    public String[] xGg = null;
    public String[] xGh = null;
    public String[] xGi = null;
    public String[] xGj = null;
    public ArrayList<SmileyInfo> xGk;
    private ArrayList<C26004a> xGl = new ArrayList();
    private HashMap<String, SmileyInfo> xGm = new HashMap();
    private SparseArray<String> xGn = new SparseArray();

    /* renamed from: com.tencent.mm.cb.f$1 */
    static class C13471 implements Comparator<C26004a> {
        C13471() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(62675);
            C26004a c26004a = (C26004a) obj;
            C26004a c26004a2 = (C26004a) obj2;
            if (c26004a == null && c26004a2 == null) {
                AppMethodBeat.m2505o(62675);
                return 0;
            } else if (c26004a == null || C5046bo.isNullOrNil(c26004a.text)) {
                AppMethodBeat.m2505o(62675);
                return 1;
            } else if (c26004a2 == null || C5046bo.isNullOrNil(c26004a2.text)) {
                AppMethodBeat.m2505o(62675);
                return -1;
            } else {
                int compareTo = c26004a.text.compareTo(c26004a2.text);
                AppMethodBeat.m2505o(62675);
                return compareTo;
            }
        }
    }

    /* renamed from: com.tencent.mm.cb.f$a */
    public static class C26004a {
        public String name;
        public int pos;
        public String text;

        C26004a() {
        }

        C26004a(int i, String str, String str2) {
            this.pos = i;
            this.text = str;
            this.name = str2;
        }
    }

    static {
        AppMethodBeat.m2504i(62690);
        AppMethodBeat.m2505o(62690);
    }

    private C26005f(Context context) {
        AppMethodBeat.m2504i(62676);
        long currentTimeMillis = System.currentTimeMillis();
        this.xGe = context.getResources().getStringArray(C25738R.array.f12630ai);
        this.xGf = context.getResources().getStringArray(C25738R.array.f12633al);
        this.xGg = context.getResources().getStringArray(C25738R.array.f12631aj);
        this.xGh = context.getResources().getStringArray(C25738R.array.f12635an);
        this.xGi = context.getResources().getStringArray(C25738R.array.f12632ak);
        this.xGj = context.getResources().getStringArray(C25738R.array.f12634am);
        dqN();
        C4990ab.m7411d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(62676);
    }

    public static C26005f dqL() {
        AppMethodBeat.m2504i(62677);
        if (xGd == null) {
            synchronized (C26005f.class) {
                try {
                    if (xGd == null) {
                        xGd = new C26005f(C4996ah.getContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(62677);
                    }
                }
            }
        }
        C26005f c26005f = xGd;
        AppMethodBeat.m2505o(62677);
        return c26005f;
    }

    private synchronized int dqM() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(62678);
            this.xGl.clear();
            if (this.xGe == null || this.xGg == null || this.xGe.length != this.xGg.length) {
                C4990ab.m7416i("MicroMsg.QQSmileyManager", "read smiley array failed.");
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
                    this.xGl.add(new C26004a(i2, str, ""));
                    this.xGl.add(new C26004a(i2, str2, ""));
                    this.xGl.add(new C26004a(i2, str3, ""));
                    this.xGl.add(new C26004a(i2, str4, ""));
                    this.xGl.add(new C26004a(i2, str5, ""));
                    this.xGl.add(new C26004a(i2, str6, ""));
                    this.xGm.put(str, smileyInfo);
                    this.xGn.put(smileyInfo.field_eggIndex, smileyInfo.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.xGk == null || this.xGk.isEmpty()) {
                Collections.sort(this.xGl, xGp);
            }
            AppMethodBeat.m2505o(62678);
        }
        return i;
    }

    public final boolean dqN() {
        AppMethodBeat.m2504i(62679);
        C4990ab.m7416i("MicroMsg.QQSmileyManager", "checkNewEmoji");
        ArrayList bjO = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjO();
        if (bjO == null || bjO.isEmpty()) {
            dqO();
            AppMethodBeat.m2505o(62679);
            return true;
        }
        C26005f.m41504em(bjO);
        dqO();
        AppMethodBeat.m2505o(62679);
        return false;
    }

    /* renamed from: em */
    private static void m41504em(List<SmileyInfo> list) {
        boolean z;
        AppMethodBeat.m2504i(62680);
        for (SmileyInfo smileyInfo : list) {
            if (!C5730e.m8628ct(C37462a.afV() + smileyInfo.field_fileName)) {
                z = true;
                break;
            }
        }
        z = false;
        C4990ab.m7417i("MicroMsg.QQSmileyManager", "checkFile %b", Boolean.valueOf(z));
        if (z) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjT();
        }
        AppMethodBeat.m2505o(62680);
    }

    public final synchronized void dqO() {
        AppMethodBeat.m2504i(62681);
        C4990ab.m7416i("MicroMsg.QQSmileyManager", "updateSmiley " + C5046bo.dpG());
        long currentTimeMillis = System.currentTimeMillis();
        this.xGm.clear();
        this.xGn.clear();
        dqM();
        this.xGk = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getProvider().bjO();
        if (this.xGk == null || this.xGk.isEmpty()) {
            this.xGk = C41953a.m74097a(new C5728b("assets:///newemoji/newemoji-config.xml"));
        }
        if (this.xGk == null || this.xGk.isEmpty()) {
            C4990ab.m7416i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
        } else {
            Iterator it = this.xGk.iterator();
            while (it.hasNext()) {
                SmileyInfo smileyInfo = (SmileyInfo) it.next();
                this.xGm.put(smileyInfo.field_key, smileyInfo);
                this.xGn.put(smileyInfo.field_eggIndex, smileyInfo.field_key);
                this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                if (C5046bo.isNullOrNil(smileyInfo.field_cnValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_cnValue)) {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_cnValue, smileyInfo.field_fileName));
                }
                if (C5046bo.isNullOrNil(smileyInfo.field_qqValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_qqValue)) {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_qqValue, smileyInfo.field_fileName));
                }
                if (C5046bo.isNullOrNil(smileyInfo.field_twValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_twValue)) {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_twValue, smileyInfo.field_fileName));
                }
                if (C5046bo.isNullOrNil(smileyInfo.field_enValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_enValue)) {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_enValue, smileyInfo.field_fileName));
                }
                if (C5046bo.isNullOrNil(smileyInfo.field_thValue) || BuildConfig.COMMAND.equalsIgnoreCase(smileyInfo.field_thValue)) {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_key, smileyInfo.field_fileName));
                } else {
                    this.xGl.add(new C26004a(-1, smileyInfo.field_thValue, smileyInfo.field_fileName));
                }
            }
        }
        Collections.sort(this.xGl, xGp);
        C4990ab.m7417i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(62681);
    }

    public final boolean anV(String str) {
        AppMethodBeat.m2504i(62682);
        if (anW(str) != null) {
            AppMethodBeat.m2505o(62682);
            return true;
        }
        AppMethodBeat.m2505o(62682);
        return false;
    }

    public final C26004a anW(String str) {
        AppMethodBeat.m2504i(62683);
        if (this.xGl != null) {
            int i;
            int binarySearch = Collections.binarySearch(this.xGl, new C26004a(0, str, ""), xGp);
            if (binarySearch < 0) {
                i = (-binarySearch) - 2;
            } else {
                i = binarySearch;
            }
            if (i >= 0 && i < this.xGl.size()) {
                C26004a c26004a = (C26004a) this.xGl.get(i);
                if (!(c26004a == null || str == null || !str.startsWith(c26004a.text))) {
                    c26004a = (C26004a) this.xGl.get(i);
                    AppMethodBeat.m2505o(62683);
                    return c26004a;
                }
            }
        }
        AppMethodBeat.m2505o(62683);
        return null;
    }

    /* renamed from: b */
    public final SpannableString mo43882b(SpannableString spannableString, int i, int i2) {
        AppMethodBeat.m2504i(62684);
        if (spannableString == null || spannableString.length() == 0) {
            AppMethodBeat.m2505o(62684);
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
                        } else if (m41503a(i4, spannableString, i)) {
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
                        } else if (m41503a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            AppMethodBeat.m2505o(62684);
        }
        return spannableString;
    }

    /* renamed from: a */
    private boolean m41503a(int i, SpannableString spannableString, int i2) {
        AppMethodBeat.m2504i(62685);
        C26004a anW = anW(spannableString.subSequence(i, spannableString.length()));
        if (anW != null) {
            Drawable a = C26005f.m41502a(anW);
            if (a == null || i > spannableString.length() || anW.text.length() + i > spannableString.length()) {
                C4990ab.m7417i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", anW.toString());
            } else {
                C37626b.dqD().mo60450a(spannableString, a, i, i + anW.text.length(), i2);
                AppMethodBeat.m2505o(62685);
                return true;
            }
        }
        AppMethodBeat.m2505o(62685);
        return false;
    }

    /* renamed from: a */
    private static Drawable m41502a(C26004a c26004a) {
        Drawable qJ;
        AppMethodBeat.m2504i(62686);
        int i = c26004a.pos;
        if (i >= 0) {
            qJ = C37626b.dqD().mo60454qJ(i);
        } else {
            qJ = C26005f.anX(c26004a.name);
        }
        AppMethodBeat.m2505o(62686);
        return qJ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A:{SYNTHETIC, Splitter:B:31:0x00b1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static Drawable anX(String str) {
        Throwable e;
        AppMethodBeat.m2504i(62687);
        String str2 = C37462a.afV() + str;
        InputStream openRead;
        try {
            if (C5730e.m8628ct(str2)) {
                openRead = C5730e.openRead(str2);
            } else {
                C4990ab.m7421w("MicroMsg.QQSmileyManager", "[getQQSmileyDrawable] not exist! path:%s name:%s", str2, str);
                openRead = C4996ah.getContext().getAssets().open("newemoji/".concat(String.valueOf(str)));
            }
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(openRead, null, options);
                if (decodeStream == null) {
                    C4990ab.m7416i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(C4996ah.getContext().getResources(), decodeStream);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                        C4990ab.m7416i("MicroMsg.QQSmileyManager", C5046bo.m7574l(e2));
                    }
                }
                AppMethodBeat.m2505o(62687);
                return bitmapDrawable;
            } catch (IOException e3) {
                e = e3;
                try {
                    C4990ab.m7416i("MicroMsg.QQSmileyManager", C5046bo.m7574l(e));
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e4) {
                            C4990ab.m7416i("MicroMsg.QQSmileyManager", C5046bo.m7574l(e4));
                        }
                    }
                    AppMethodBeat.m2505o(62687);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (openRead != null) {
                    }
                    AppMethodBeat.m2505o(62687);
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
                    C4990ab.m7416i("MicroMsg.QQSmileyManager", C5046bo.m7574l(e22));
                }
            }
            AppMethodBeat.m2505o(62687);
            throw e;
        }
    }

    public final SmileyInfo anY(String str) {
        AppMethodBeat.m2504i(62688);
        if (this.xGm == null || !this.xGm.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", str.replace("\\", "\\\\"));
            AppMethodBeat.m2505o(62688);
            return null;
        }
        SmileyInfo smileyInfo = (SmileyInfo) this.xGm.get(str);
        AppMethodBeat.m2505o(62688);
        return smileyInfo;
    }

    public final ArrayList<String> dqP() {
        AppMethodBeat.m2504i(62689);
        ArrayList arrayList = new ArrayList();
        if (this.xGk != null) {
            Iterator it = this.xGk.iterator();
            while (it.hasNext()) {
                arrayList.add(((SmileyInfo) it.next()).field_key);
            }
        }
        AppMethodBeat.m2505o(62689);
        return arrayList;
    }
}
