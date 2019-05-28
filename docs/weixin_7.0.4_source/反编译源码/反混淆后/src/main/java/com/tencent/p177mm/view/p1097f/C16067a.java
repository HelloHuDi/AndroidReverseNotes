package com.tencent.p177mm.view.p1097f;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C1336b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37799sq;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.protocal.protobuf.cac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.emotion.C15438t;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.view.p1627c.C44418a;
import com.tencent.p177mm.view.p646e.C17070a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.view.f.a */
public final class C16067a {
    private int Aav;
    public int AdY;
    public int AdZ;
    public boolean AeA;
    public int[] AeB;
    public boolean AeC;
    public boolean AeD;
    public ArrayList<C44418a> AeE;
    private HashMap<String, Integer> AeF;
    public List<C15438t> AeG;
    public C4884c AeH;
    public volatile boolean AeI;
    private int Aea;
    public int Aeb;
    public int Aec;
    public int Aed;
    public int Aee;
    public int Aef;
    private int Aeg;
    private int Aeh;
    public int Aei;
    private int Aej;
    private int Aek;
    public int Ael;
    private int Aem;
    private int Aen;
    private int Aeo;
    private int Aep;
    public String Aeq;
    public int Aer;
    public boolean Aes;
    public boolean Aet;
    public boolean Aeu;
    public boolean Aev;
    public boolean Aew;
    public boolean Aex;
    public boolean Aey;
    public boolean Aez;
    /* renamed from: Gn */
    public Context f3007Gn;
    private final String TAG;
    public int gOW;
    public int jiL;
    public int jiM;
    public int lfN;
    private int mOrientation;
    private int moz;
    public String vmL;
    public boolean zRn;
    public int zyD;

    /* renamed from: com.tencent.mm.view.f.a$a */
    public enum C16066a {
        RECOMMEND,
        DEFAULT,
        CUSTOM,
        CAPTURE,
        STORE;

        static {
            AppMethodBeat.m2505o(63077);
        }
    }

    /* renamed from: com.tencent.mm.view.f.a$1 */
    public class C160681 extends C4884c<C37799sq> {
        public C160681() {
            AppMethodBeat.m2504i(63073);
            this.xxI = C37799sq.class.getName().hashCode();
            AppMethodBeat.m2505o(63073);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(63074);
            C37799sq c37799sq = (C37799sq) c4883b;
            C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "kv stat update click cell item");
            C7060h.pYm.mo8374X(11076, "1," + c37799sq.cOO.cwg);
            C16067a.this.dNu();
            AppMethodBeat.m2505o(63074);
            return true;
        }
    }

    public C16067a() {
        AppMethodBeat.m2504i(63078);
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.zyD = 0;
        this.Aeh = 0;
        this.mOrientation = 0;
        this.moz = 0;
        this.Aeq = "";
        this.Aer = 0;
        this.Aeu = true;
        this.Aez = false;
        this.AeA = false;
        this.AeE = new ArrayList();
        this.AeF = new HashMap();
        this.AeG = new ArrayList();
        this.AeI = false;
        this.f3007Gn = C4996ah.getContext();
        this.AdY = this.f3007Gn.getResources().getDimensionPixelSize(C25738R.dimen.a15);
        this.lfN = this.f3007Gn.getResources().getDimensionPixelSize(C25738R.dimen.a19);
        this.AdZ = this.f3007Gn.getResources().getDimensionPixelSize(C25738R.dimen.a18);
        this.Aee = C1338a.fromDPToPix(this.f3007Gn, 48);
        this.Aef = C1338a.fromDPToPix(this.f3007Gn, 43);
        this.Aeb = C1338a.fromDPToPix(this.f3007Gn, 86);
        this.Aec = C1338a.fromDPToPix(this.f3007Gn, 90);
        this.Aed = C1338a.fromDPToPix(this.f3007Gn, 65);
        this.Aea = C1338a.m2856al(this.f3007Gn, C25738R.dimen.f9723do);
        this.Aej = C1338a.fromDPToPix(this.f3007Gn, 6);
        this.Aeq = "TAG_DEFAULT_TAB";
        this.Aer = 0;
        this.Aav = C1338a.m2856al(this.f3007Gn, C25738R.dimen.a8q);
        this.Aeg = C1338a.m2856al(this.f3007Gn, C25738R.dimen.f9723do);
        this.Aek = C1338a.m2856al(this.f3007Gn, C25738R.dimen.a8r);
        this.Ael = C1338a.m2856al(this.f3007Gn, C25738R.dimen.a8s);
        this.Aem = C1338a.fromDPToPix(this.f3007Gn, 12);
        this.Aen = this.Aek;
        this.Aeo = C1338a.fromDPToPix(this.f3007Gn, 8);
        this.Aep = C1338a.fromDPToPix(this.f3007Gn, 16);
        dNv();
        dNm();
        dNy();
        AppMethodBeat.m2505o(63078);
    }

    public static boolean dNi() {
        boolean LR;
        boolean LR2;
        Exception e;
        boolean z;
        AppMethodBeat.m2504i(63081);
        try {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                C45274a.dmE();
                C1336b c1336b = C45274a.xum;
                LR = C1336b.m2854LR(208913);
                try {
                    C45274a.dmE();
                    C1336b c1336b2 = C45274a.xum;
                    LR2 = C1336b.m2854LR(208899);
                } catch (Exception e2) {
                    e = e2;
                    z = LR;
                }
            } else {
                LR = false;
                LR2 = false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            C4990ab.m7413e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            LR = z;
            LR2 = false;
            if (!LR2) {
            }
            AppMethodBeat.m2505o(63081);
            return true;
        }
        if (LR2 || LR) {
            AppMethodBeat.m2505o(63081);
            return true;
        }
        AppMethodBeat.m2505o(63081);
        return false;
    }

    public static boolean dNj() {
        boolean bX;
        Exception e;
        AppMethodBeat.m2504i(63082);
        boolean bX2;
        try {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                bX = C16112c.m24429PK().mo28551bX(262147, 266244);
                try {
                    bX2 = C16112c.m24429PK().mo28551bX(262149, 266244);
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                bX2 = false;
                bX = false;
            }
        } catch (Exception e3) {
            e = e3;
            bX = false;
            C4990ab.m7413e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            bX2 = false;
            if (!bX) {
            }
            AppMethodBeat.m2505o(63082);
            return true;
        }
        if (bX || bX2) {
            AppMethodBeat.m2505o(63082);
            return true;
        }
        AppMethodBeat.m2505o(63082);
        return false;
    }

    public final int dNk() {
        return this.Aeb;
    }

    /* renamed from: QH */
    public final void mo28455QH(int i) {
        AppMethodBeat.m2504i(63084);
        this.jiL = i;
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", Integer.valueOf(i), Integer.valueOf(this.jiL));
        AppMethodBeat.m2505o(63084);
    }

    public final int aRB() {
        AppMethodBeat.m2504i(63085);
        if (this.jiM <= 1) {
            this.jiM = aMw()[0];
        }
        int i = this.jiM;
        AppMethodBeat.m2505o(63085);
        return i;
    }

    public final void setShowProductId(String str) {
        AppMethodBeat.m2504i(63086);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63086);
            return;
        }
        this.Aeq = str;
        AppMethodBeat.m2505o(63086);
    }

    /* renamed from: eI */
    public final void mo28478eI(String str, int i) {
        AppMethodBeat.m2504i(63087);
        this.AeF.put(str, Integer.valueOf(i));
        AppMethodBeat.m2505o(63087);
    }

    public final boolean atk(String str) {
        AppMethodBeat.m2504i(63088);
        if (this.Aeq.equals(str)) {
            AppMethodBeat.m2505o(63088);
            return true;
        }
        AppMethodBeat.m2505o(63088);
        return false;
    }

    public final void dNl() {
        AppMethodBeat.m2504i(63089);
        if (C5046bo.isNullOrNil(this.Aeq)) {
            AppMethodBeat.m2505o(63089);
        } else if (this.Aes) {
            AppMethodBeat.m2505o(63089);
        } else {
            C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", this.Aeq, Integer.valueOf(this.Aer));
            C45274a.dmE();
            C1336b c1336b = C45274a.xum;
            C1336b.alW(this.Aeq);
            AppMethodBeat.m2505o(63089);
        }
    }

    public final int dNn() {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(63091);
        if (ChatFooterPanel.vhl == this.gOW) {
            z = true;
        } else {
            z = false;
        }
        ArrayList bY = C32497a.m53203OB().mo53136bY(z);
        if (C5046bo.isNullOrNil(this.vmL) || !(C7616ad.aox(this.vmL) || C1855t.m3903mP(this.vmL))) {
            i = bY.size();
        } else {
            Iterator it = bY.iterator();
            while (it.hasNext()) {
                EmojiInfo emojiInfo = (EmojiInfo) it.next();
                if (emojiInfo != null && emojiInfo.field_catalog == EmojiGroupInfo.yat) {
                    i++;
                }
            }
        }
        if (C16067a.m24370QM(this.gOW)) {
            i++;
        }
        AppMethodBeat.m2505o(63091);
        return i;
    }

    public static EmojiGroupInfo dNo() {
        AppMethodBeat.m2504i(63092);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
        AppMethodBeat.m2505o(63092);
        return emojiGroupInfo;
    }

    public static EmojiGroupInfo dNp() {
        AppMethodBeat.m2504i(63093);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.yas);
        AppMethodBeat.m2505o(63093);
        return emojiGroupInfo;
    }

    /* renamed from: e */
    public static boolean m24373e(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.m2504i(63094);
        if (emojiGroupInfo == null || (C2933b.m5219JX(emojiGroupInfo.field_productID) && emojiGroupInfo.field_packStatus != 1)) {
            AppMethodBeat.m2505o(63094);
            return false;
        }
        AppMethodBeat.m2505o(63094);
        return true;
    }

    public final boolean dNq() {
        AppMethodBeat.m2504i(63095);
        C45274a.dmE();
        C1336b c1336b = C45274a.xum;
        if (!C1336b.m2854LR(66832) || this.Aey) {
            AppMethodBeat.m2505o(63095);
            return false;
        }
        AppMethodBeat.m2505o(63095);
        return true;
    }

    public final C44418a atl(String str) {
        AppMethodBeat.m2504i(63096);
        if (this.AeE == null || str == null) {
            C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            AppMethodBeat.m2505o(63096);
            return null;
        }
        Iterator it = this.AeE.iterator();
        while (it.hasNext()) {
            C44418a c44418a = (C44418a) it.next();
            if (c44418a == null) {
                C4990ab.m7412e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (c44418a.kWz == null) {
                C4990ab.m7412e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (c44418a.kWz.equals(str)) {
                AppMethodBeat.m2505o(63096);
                return c44418a;
            }
        }
        AppMethodBeat.m2505o(63096);
        return null;
    }

    /* renamed from: QI */
    public final C44418a mo28456QI(int i) {
        AppMethodBeat.m2504i(63097);
        if (this.AeE == null) {
            AppMethodBeat.m2505o(63097);
            return null;
        }
        C44418a c44418a = (C44418a) this.AeE.get(mo28457QJ(i));
        AppMethodBeat.m2505o(63097);
        return c44418a;
    }

    /* renamed from: QJ */
    public final int mo28457QJ(int i) {
        if (this.AeB == null || i >= this.AeB.length || i <= 0) {
            return 0;
        }
        return this.AeB[i];
    }

    /* renamed from: a */
    public final void mo28458a(EmojiGroupInfo emojiGroupInfo, C17070a c17070a, boolean z) {
        AppMethodBeat.m2504i(63099);
        if (this.AeE == null) {
            this.AeE = new ArrayList();
        }
        this.AeE.add(m24372b(emojiGroupInfo, c17070a, z));
        AppMethodBeat.m2505o(63099);
    }

    /* renamed from: b */
    private C44418a m24372b(EmojiGroupInfo emojiGroupInfo, C17070a c17070a, boolean z) {
        AppMethodBeat.m2504i(63100);
        int size = this.AeE.size();
        C44418a a = m24371a(emojiGroupInfo, c17070a, z, size <= 0 ? null : (C44418a) this.AeE.get(size - 1), C5046bo.m7512a((Integer) this.AeF.get(emojiGroupInfo.field_productID), 0));
        AppMethodBeat.m2505o(63100);
        return a;
    }

    /* renamed from: a */
    private C44418a m24371a(EmojiGroupInfo emojiGroupInfo, C17070a c17070a, boolean z, C44418a c44418a, int i) {
        AppMethodBeat.m2504i(63101);
        C44418a c44418a2 = new C44418a(emojiGroupInfo, c44418a == null ? 0 : c44418a.jis + c44418a.dMX(), i, this, c17070a, z);
        AppMethodBeat.m2505o(63101);
        return c44418a2;
    }

    public final void dNt() {
        AppMethodBeat.m2504i(63103);
        this.moz = 0;
        if (this.AeE == null) {
            AppMethodBeat.m2505o(63103);
            return;
        }
        C44418a c44418a;
        Iterator it = this.AeE.iterator();
        while (it.hasNext()) {
            c44418a = (C44418a) it.next();
            this.moz = c44418a.dMX() + this.moz;
        }
        if (this.AeE != null) {
            try {
                this.AeB = new int[this.moz];
                int i = 0;
                loop1:
                for (int i2 = 0; i2 < this.AeE.size(); i2++) {
                    c44418a = (C44418a) this.AeE.get(i2);
                    int i3 = 0;
                    while (i3 < c44418a.dMX()) {
                        if (i >= this.moz) {
                            break loop1;
                        }
                        int i4 = i + 1;
                        this.AeB[i] = i2;
                        i3++;
                        i = i4;
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
            }
        }
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", Integer.valueOf(this.moz));
        AppMethodBeat.m2505o(63103);
    }

    public static boolean isSDCardAvailable() {
        AppMethodBeat.m2504i(63105);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C1720g.m3537RQ();
            boolean isSDCardAvailable = C1720g.m3536RP().isSDCardAvailable();
            AppMethodBeat.m2505o(63105);
            return isSDCardAvailable;
        }
        AppMethodBeat.m2505o(63105);
        return true;
    }

    private int[] aMw() {
        AppMethodBeat.m2504i(63106);
        int[] iArr = new int[2];
        if (this.f3007Gn instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.f3007Gn).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.f3007Gn.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.m2505o(63106);
        return iArr;
    }

    public final void dNu() {
        AppMethodBeat.m2504i(63107);
        if (this.AeH != null) {
            C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            C4879a.xxA.mo10053d(this.AeH);
            this.AeH = null;
        }
        AppMethodBeat.m2505o(63107);
    }

    public final int getColumnWidth() {
        int i = 4;
        AppMethodBeat.m2504i(63108);
        if (this.zyD == 0) {
            int aRB = aRB() / this.Aec;
            if (!C40619x.m70075gu(this.f3007Gn)) {
                i = aRB;
            } else if (aRB <= 4) {
                i = aRB;
            }
            if (i <= 0) {
                i = 1;
            }
            this.zyD = aRB() / i;
        }
        i = this.zyD;
        AppMethodBeat.m2505o(63108);
        return i;
    }

    public final void dNv() {
        AppMethodBeat.m2504i(63109);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.AeF == null) {
            this.AeF = new HashMap();
        }
        this.AeF.clear();
        cab bjU = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjU();
        if (!(bjU == null || bjU.wZl == null || bjU.wZl.isEmpty())) {
            Iterator it = bjU.wZl.iterator();
            while (it.hasNext()) {
                cac cac = (cac) it.next();
                this.AeF.put(cac.ProductID, Integer.valueOf(cac.vKj));
            }
        }
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(63109);
    }

    public final void dNw() {
        AppMethodBeat.m2504i(63110);
        long currentTimeMillis = System.currentTimeMillis();
        cab cab = new cab();
        if (!(this.AeF == null || this.AeF.isEmpty())) {
            for (String str : this.AeF.keySet()) {
                cac cac = new cac();
                cac.ProductID = str;
                cac.vKj = ((Integer) this.AeF.get(str)).intValue();
                cab.wZl.add(cac);
            }
            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35619a(cab);
        }
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(63110);
    }

    public final boolean dNx() {
        AppMethodBeat.m2504i(63111);
        if (this.AeG == null || this.AeG.size() < 3) {
            AppMethodBeat.m2505o(63111);
            return false;
        }
        AppMethodBeat.m2505o(63111);
        return true;
    }

    public final void dNy() {
        AppMethodBeat.m2504i(63112);
        this.AeG = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjY();
        AppMethodBeat.m2505o(63112);
    }

    public final boolean dNz() {
        AppMethodBeat.m2504i(139078);
        boolean QL = C16067a.m24369QL(this.gOW);
        AppMethodBeat.m2505o(139078);
        return QL;
    }

    /* renamed from: QK */
    public static int m24368QK(int i) {
        if (i == ChatFooterPanel.vhi) {
            return 2;
        }
        if (i == ChatFooterPanel.vhn) {
            return 3;
        }
        if (i == ChatFooterPanel.vho) {
            return 4;
        }
        if (i == ChatFooterPanel.vhp) {
            return 5;
        }
        return 2;
    }

    /* renamed from: QL */
    public static boolean m24369QL(int i) {
        AppMethodBeat.m2504i(63114);
        if (((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35614OT() && (i == ChatFooterPanel.vhi || i == ChatFooterPanel.vhn || i == ChatFooterPanel.vho || i == ChatFooterPanel.vhp)) {
            AppMethodBeat.m2505o(63114);
            return true;
        }
        AppMethodBeat.m2505o(63114);
        return false;
    }

    /* renamed from: QM */
    public static boolean m24370QM(int i) {
        return i == ChatFooterPanel.vhi;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(63079);
        this.zRn = false;
        dNl();
        dNw();
        dNu();
        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjZ();
        AppMethodBeat.m2505o(63079);
    }

    public static int ati(String str) {
        AppMethodBeat.m2504i(63080);
        if (str.equals("TAG_DEFAULT_TAB")) {
            AppMethodBeat.m2505o(63080);
            return 20;
        } else if (str.equals(String.valueOf(EmojiGroupInfo.yas))) {
            AppMethodBeat.m2505o(63080);
            return 25;
        } else if (str.equals("capture")) {
            AppMethodBeat.m2505o(63080);
            return 26;
        } else {
            AppMethodBeat.m2505o(63080);
            return 23;
        }
    }

    public final int atj(String str) {
        AppMethodBeat.m2504i(63083);
        int i;
        if ("TAG_DEFAULT_TAB".equals(str)) {
            i = this.Aee;
            AppMethodBeat.m2505o(63083);
            return i;
        }
        i = this.Aeb;
        AppMethodBeat.m2505o(63083);
        return i;
    }

    public final void dNm() {
        AppMethodBeat.m2504i(63090);
        if (this.Aes) {
            if (!this.Aeq.equals("TAG_DEFAULT_TAB")) {
                this.Aeq = "TAG_DEFAULT_TAB";
                this.Aer = C5046bo.m7512a((Integer) this.AeF.get(this.Aeq), 0);
            }
            AppMethodBeat.m2505o(63090);
            return;
        }
        C45274a.dmE();
        C1336b c1336b = C45274a.xum;
        this.Aeq = C1336b.m2855bJ(-29414086, "TAG_DEFAULT_TAB");
        this.Aer = C5046bo.m7512a((Integer) this.AeF.get(this.Aeq), 0);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", this.Aeq, Integer.valueOf(this.Aer));
        AppMethodBeat.m2505o(63090);
    }

    public final C44418a dNr() {
        AppMethodBeat.m2504i(63098);
        C44418a atl = atl(this.Aeq);
        AppMethodBeat.m2505o(63098);
        return atl;
    }

    public final int dNs() {
        AppMethodBeat.m2504i(63102);
        int dMX;
        if (this.Aes) {
            dMX = atl("TAG_DEFAULT_TAB").dMX();
            AppMethodBeat.m2505o(63102);
            return dMX;
        }
        dMX = this.moz;
        AppMethodBeat.m2505o(63102);
        return dMX;
    }

    /* renamed from: a */
    public final void mo28459a(C44418a c44418a) {
        int i;
        int i2;
        AppMethodBeat.m2504i(63104);
        String str = c44418a.kWz;
        if (str.equals("TAG_DEFAULT_TAB")) {
            i = this.Aek;
            i2 = this.Ael;
        } else {
            i = this.Aem;
            i2 = this.Aem;
        }
        int i3 = c44418a.tVA;
        int atj = (this.jiL - (i * 2)) - (atj(str) * i3);
        if (atj >= this.Aep) {
            i2 = (atj - this.Aep) / (i3 + 1);
            c44418a.Adl = i + i2;
            if (i3 == 1) {
                c44418a.Adk = 0;
                AppMethodBeat.m2505o(63104);
                return;
            }
            c44418a.Adk = i2;
            AppMethodBeat.m2505o(63104);
        } else if (atj >= this.Aeo) {
            c44418a.Adl = i;
            c44418a.Adk = 0;
            AppMethodBeat.m2505o(63104);
        } else {
            if (C40619x.m70075gu(this.f3007Gn)) {
                atj = (atj - this.Aeo) / (i3 + 1);
            } else {
                atj /= i3 + 1;
            }
            i += atj;
            if (i < i2) {
                c44418a.Adl = i2;
            } else {
                c44418a.Adl = i;
            }
            c44418a.Adk = atj;
            AppMethodBeat.m2505o(63104);
        }
    }
}
