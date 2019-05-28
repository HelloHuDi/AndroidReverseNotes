package com.tencent.p177mm.p211cb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C40628r;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.vfs.C5728b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.cb.e */
public class C26003e {
    private static C26003e xFX = null;
    private String country;
    private String[] xFY;
    private String[] xFZ;
    private String[] xGa;
    private ArrayList<C40628r> xGb = new ArrayList();
    private SparseArray<C40628r> xGc = new SparseArray();

    public C26003e(Context context) {
        AppMethodBeat.m2504i(62666);
        this.xFY = context.getResources().getStringArray(C25738R.array.f12621a2);
        this.xFZ = context.getResources().getStringArray(C25738R.array.f12622a3);
        this.xGa = context.getResources().getStringArray(C25738R.array.f12623a4);
        this.xGb.clear();
        this.xGc.clear();
        dqJ();
        this.country = C4988aa.dor();
        AppMethodBeat.m2505o(62666);
    }

    private void dqJ() {
        int i = 0;
        AppMethodBeat.m2504i(62667);
        if (!(this.xFY == null || this.xGa == null)) {
            int length = this.xFY.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                C40628r c40628r = new C40628r(i3, this.xFY[i2]);
                this.xGb.add(c40628r);
                this.xGc.put(i3, c40628r);
                i2++;
                i3++;
            }
            i2 = this.xGa.length;
            while (i < i2) {
                C40628r c40628r2 = new C40628r(i3, this.xGa[i]);
                this.xGb.add(c40628r2);
                this.xGc.put(i3, c40628r2);
                i++;
                i3++;
            }
        }
        AppMethodBeat.m2505o(62667);
    }

    public int aRs() {
        ArrayList b;
        int i;
        AppMethodBeat.m2504i(62668);
        C4990ab.m7416i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + C5046bo.dpG());
        this.xGb.clear();
        ArrayList bjP = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().bjP();
        if (bjP == null || bjP.isEmpty()) {
            b = C41953a.m74098b(new C5728b("assets:///panel/".concat(String.valueOf(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjS()))));
        } else {
            b = bjP;
        }
        if (b == null || b.isEmpty()) {
            dqJ();
            C4990ab.m7416i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            i = -1;
        } else {
            ArrayList dqP = C26005f.dqL().dqP();
            int size = b.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                C40628r c40628r = (C40628r) b.get(i2);
                String str = c40628r.field_key;
                if (!str.startsWith("[") || dqP.contains(str)) {
                    this.xGb.add(c40628r);
                    this.xGc.put(i3, c40628r);
                    i = i3 + 1;
                } else {
                    C4990ab.m7417i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            i = 0;
        }
        AppMethodBeat.m2505o(62668);
        return i;
    }

    public int aRt() {
        AppMethodBeat.m2504i(62669);
        if (this.xGb == null) {
            AppMethodBeat.m2505o(62669);
            return 0;
        }
        int size = this.xGb.size();
        AppMethodBeat.m2505o(62669);
        return size;
    }

    public static C26003e dqK() {
        AppMethodBeat.m2504i(62670);
        if (xFX == null) {
            synchronized (C26003e.class) {
                try {
                    xFX = new C26003e(C4996ah.getContext());
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(62670);
                    }
                }
            }
        }
        C26003e c26003e = xFX;
        AppMethodBeat.m2505o(62670);
        return c26003e;
    }

    /* renamed from: qJ */
    public Drawable mo43876qJ(int i) {
        AppMethodBeat.m2504i(62671);
        if (this.xGc == null) {
            C4990ab.m7416i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            AppMethodBeat.m2505o(62671);
            return null;
        }
        C40628r c40628r = (C40628r) this.xGc.get(i);
        if (c40628r == null) {
            C4990ab.m7416i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            AppMethodBeat.m2505o(62671);
            return null;
        }
        Drawable qJ;
        SmileyInfo anY = C26005f.dqL().anY(c40628r.field_key);
        int i2;
        if (anY != null) {
            C26005f.dqL();
            i2 = anY.field_position;
            if (i2 >= 0) {
                qJ = C37626b.dqD().mo60454qJ(i2);
            } else {
                qJ = C26005f.anX(anY.field_fileName);
            }
        } else {
            C45278c c45278c;
            C37626b dqD = C37626b.dqD();
            String str = c40628r.field_key;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                c45278c = null;
            } else {
                i2 = str.codePointAt(0);
                if (dqD.mo60446Mi(i2) != null) {
                    c45278c = dqD.mo60446Mi(i2);
                } else {
                    c45278c = dqD.mo60452gY(i2, 0);
                }
            }
            qJ = C37626b.dqD().mo60447a(c45278c, true);
        }
        AppMethodBeat.m2505o(62671);
        return qJ;
    }

    public String getText(int i) {
        AppMethodBeat.m2504i(62672);
        String str;
        if (i < 0 || i >= this.xGb.size()) {
            C4990ab.m7420w("MicroMsg.MergerSmileyManager", "get text, error index");
            str = "";
            AppMethodBeat.m2505o(62672);
            return str;
        }
        C40628r c40628r = (C40628r) this.xGb.get(i);
        if (c40628r != null) {
            SmileyInfo anY = C26005f.dqL().anY(c40628r.field_key);
            if (anY == null) {
                str = c40628r.field_key;
                AppMethodBeat.m2505o(62672);
                return str;
            } else if (this.country.equals("zh_CN") && !C5046bo.isNullOrNil(anY.field_cnValue)) {
                str = anY.field_cnValue;
                AppMethodBeat.m2505o(62672);
                return str;
            } else if ((this.country.equals("zh_TW") || this.country.equals("zh_HK")) && !C5046bo.isNullOrNil(anY.field_twValue)) {
                str = anY.field_twValue;
                AppMethodBeat.m2505o(62672);
                return str;
            } else {
                str = anY.field_enValue;
                AppMethodBeat.m2505o(62672);
                return str;
            }
        }
        str = "";
        AppMethodBeat.m2505o(62672);
        return str;
    }

    /* renamed from: qL */
    public String mo43878qL(int i) {
        AppMethodBeat.m2504i(62673);
        String str;
        if (i < 0) {
            C4990ab.m7420w("MicroMsg.MergerSmileyManager", "get text, error index");
            str = "";
            AppMethodBeat.m2505o(62673);
            return str;
        }
        C40628r c40628r = (C40628r) this.xGb.get(i);
        if (c40628r != null) {
            str = c40628r.field_key;
            AppMethodBeat.m2505o(62673);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(62673);
        return str;
    }

    /* renamed from: qK */
    public String mo43877qK(int i) {
        AppMethodBeat.m2504i(62674);
        String str;
        if (i < 0) {
            C4990ab.m7420w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            str = "";
            AppMethodBeat.m2505o(62674);
            return str;
        }
        String[] split = C26003e.dqK().xGa[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(62674);
        return str;
    }
}
