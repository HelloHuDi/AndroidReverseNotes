package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.by.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a {
    private int Aav;
    public int AdY;
    public int AdZ;
    public boolean AeA;
    public int[] AeB;
    public boolean AeC;
    public boolean AeD;
    public ArrayList<com.tencent.mm.view.c.a> AeE;
    private HashMap<String, Integer> AeF;
    public List<t> AeG;
    public c AeH;
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
    public Context Gn;
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

    public enum a {
        RECOMMEND,
        DEFAULT,
        CUSTOM,
        CAPTURE,
        STORE;

        static {
            AppMethodBeat.o(63077);
        }
    }

    public a() {
        AppMethodBeat.i(63078);
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
        this.Gn = ah.getContext();
        this.AdY = this.Gn.getResources().getDimensionPixelSize(R.dimen.a15);
        this.lfN = this.Gn.getResources().getDimensionPixelSize(R.dimen.a19);
        this.AdZ = this.Gn.getResources().getDimensionPixelSize(R.dimen.a18);
        this.Aee = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 48);
        this.Aef = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 43);
        this.Aeb = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 86);
        this.Aec = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 90);
        this.Aed = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 65);
        this.Aea = com.tencent.mm.bz.a.al(this.Gn, R.dimen.f15do);
        this.Aej = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 6);
        this.Aeq = "TAG_DEFAULT_TAB";
        this.Aer = 0;
        this.Aav = com.tencent.mm.bz.a.al(this.Gn, R.dimen.a8q);
        this.Aeg = com.tencent.mm.bz.a.al(this.Gn, R.dimen.f15do);
        this.Aek = com.tencent.mm.bz.a.al(this.Gn, R.dimen.a8r);
        this.Ael = com.tencent.mm.bz.a.al(this.Gn, R.dimen.a8s);
        this.Aem = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 12);
        this.Aen = this.Aek;
        this.Aeo = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 8);
        this.Aep = com.tencent.mm.bz.a.fromDPToPix(this.Gn, 16);
        dNv();
        dNm();
        dNy();
        AppMethodBeat.o(63078);
    }

    public static boolean dNi() {
        boolean LR;
        boolean LR2;
        Exception e;
        boolean z;
        AppMethodBeat.i(63081);
        try {
            if (((h) g.RM().Rn()).SG()) {
                com.tencent.mm.by.a.dmE();
                b bVar = com.tencent.mm.by.a.xum;
                LR = b.LR(208913);
                try {
                    com.tencent.mm.by.a.dmE();
                    b bVar2 = com.tencent.mm.by.a.xum;
                    LR2 = b.LR(208899);
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
            ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            LR = z;
            LR2 = false;
            if (!LR2) {
            }
            AppMethodBeat.o(63081);
            return true;
        }
        if (LR2 || LR) {
            AppMethodBeat.o(63081);
            return true;
        }
        AppMethodBeat.o(63081);
        return false;
    }

    public static boolean dNj() {
        boolean bX;
        Exception e;
        AppMethodBeat.i(63082);
        boolean bX2;
        try {
            if (((h) g.RM().Rn()).SG()) {
                bX = com.tencent.mm.x.c.PK().bX(262147, 266244);
                try {
                    bX2 = com.tencent.mm.x.c.PK().bX(262149, 266244);
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
            ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            bX2 = false;
            if (!bX) {
            }
            AppMethodBeat.o(63082);
            return true;
        }
        if (bX || bX2) {
            AppMethodBeat.o(63082);
            return true;
        }
        AppMethodBeat.o(63082);
        return false;
    }

    public final int dNk() {
        return this.Aeb;
    }

    public final void QH(int i) {
        AppMethodBeat.i(63084);
        this.jiL = i;
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", Integer.valueOf(i), Integer.valueOf(this.jiL));
        AppMethodBeat.o(63084);
    }

    public final int aRB() {
        AppMethodBeat.i(63085);
        if (this.jiM <= 1) {
            this.jiM = aMw()[0];
        }
        int i = this.jiM;
        AppMethodBeat.o(63085);
        return i;
    }

    public final void setShowProductId(String str) {
        AppMethodBeat.i(63086);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63086);
            return;
        }
        this.Aeq = str;
        AppMethodBeat.o(63086);
    }

    public final void eI(String str, int i) {
        AppMethodBeat.i(63087);
        this.AeF.put(str, Integer.valueOf(i));
        AppMethodBeat.o(63087);
    }

    public final boolean atk(String str) {
        AppMethodBeat.i(63088);
        if (this.Aeq.equals(str)) {
            AppMethodBeat.o(63088);
            return true;
        }
        AppMethodBeat.o(63088);
        return false;
    }

    public final void dNl() {
        AppMethodBeat.i(63089);
        if (bo.isNullOrNil(this.Aeq)) {
            AppMethodBeat.o(63089);
        } else if (this.Aes) {
            AppMethodBeat.o(63089);
        } else {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", this.Aeq, Integer.valueOf(this.Aer));
            com.tencent.mm.by.a.dmE();
            b bVar = com.tencent.mm.by.a.xum;
            b.alW(this.Aeq);
            AppMethodBeat.o(63089);
        }
    }

    public final int dNn() {
        boolean z;
        int i = 0;
        AppMethodBeat.i(63091);
        if (ChatFooterPanel.vhl == this.gOW) {
            z = true;
        } else {
            z = false;
        }
        ArrayList bY = com.tencent.mm.emoji.a.a.OB().bY(z);
        if (bo.isNullOrNil(this.vmL) || !(ad.aox(this.vmL) || com.tencent.mm.model.t.mP(this.vmL))) {
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
        if (QM(this.gOW)) {
            i++;
        }
        AppMethodBeat.o(63091);
        return i;
    }

    public static EmojiGroupInfo dNo() {
        AppMethodBeat.i(63092);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
        AppMethodBeat.o(63092);
        return emojiGroupInfo;
    }

    public static EmojiGroupInfo dNp() {
        AppMethodBeat.i(63093);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.yas);
        AppMethodBeat.o(63093);
        return emojiGroupInfo;
    }

    public static boolean e(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(63094);
        if (emojiGroupInfo == null || (com.tencent.mm.plugin.emoji.h.b.JX(emojiGroupInfo.field_productID) && emojiGroupInfo.field_packStatus != 1)) {
            AppMethodBeat.o(63094);
            return false;
        }
        AppMethodBeat.o(63094);
        return true;
    }

    public final boolean dNq() {
        AppMethodBeat.i(63095);
        com.tencent.mm.by.a.dmE();
        b bVar = com.tencent.mm.by.a.xum;
        if (!b.LR(66832) || this.Aey) {
            AppMethodBeat.o(63095);
            return false;
        }
        AppMethodBeat.o(63095);
        return true;
    }

    public final com.tencent.mm.view.c.a atl(String str) {
        AppMethodBeat.i(63096);
        if (this.AeE == null || str == null) {
            ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            AppMethodBeat.o(63096);
            return null;
        }
        Iterator it = this.AeE.iterator();
        while (it.hasNext()) {
            com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) it.next();
            if (aVar == null) {
                ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (aVar.kWz == null) {
                ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (aVar.kWz.equals(str)) {
                AppMethodBeat.o(63096);
                return aVar;
            }
        }
        AppMethodBeat.o(63096);
        return null;
    }

    public final com.tencent.mm.view.c.a QI(int i) {
        AppMethodBeat.i(63097);
        if (this.AeE == null) {
            AppMethodBeat.o(63097);
            return null;
        }
        com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) this.AeE.get(QJ(i));
        AppMethodBeat.o(63097);
        return aVar;
    }

    public final int QJ(int i) {
        if (this.AeB == null || i >= this.AeB.length || i <= 0) {
            return 0;
        }
        return this.AeB[i];
    }

    public final void a(EmojiGroupInfo emojiGroupInfo, com.tencent.mm.view.e.a aVar, boolean z) {
        AppMethodBeat.i(63099);
        if (this.AeE == null) {
            this.AeE = new ArrayList();
        }
        this.AeE.add(b(emojiGroupInfo, aVar, z));
        AppMethodBeat.o(63099);
    }

    private com.tencent.mm.view.c.a b(EmojiGroupInfo emojiGroupInfo, com.tencent.mm.view.e.a aVar, boolean z) {
        AppMethodBeat.i(63100);
        int size = this.AeE.size();
        com.tencent.mm.view.c.a a = a(emojiGroupInfo, aVar, z, size <= 0 ? null : (com.tencent.mm.view.c.a) this.AeE.get(size - 1), bo.a((Integer) this.AeF.get(emojiGroupInfo.field_productID), 0));
        AppMethodBeat.o(63100);
        return a;
    }

    private com.tencent.mm.view.c.a a(EmojiGroupInfo emojiGroupInfo, com.tencent.mm.view.e.a aVar, boolean z, com.tencent.mm.view.c.a aVar2, int i) {
        AppMethodBeat.i(63101);
        com.tencent.mm.view.c.a aVar3 = new com.tencent.mm.view.c.a(emojiGroupInfo, aVar2 == null ? 0 : aVar2.jis + aVar2.dMX(), i, this, aVar, z);
        AppMethodBeat.o(63101);
        return aVar3;
    }

    public final void dNt() {
        AppMethodBeat.i(63103);
        this.moz = 0;
        if (this.AeE == null) {
            AppMethodBeat.o(63103);
            return;
        }
        com.tencent.mm.view.c.a aVar;
        Iterator it = this.AeE.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.view.c.a) it.next();
            this.moz = aVar.dMX() + this.moz;
        }
        if (this.AeE != null) {
            try {
                this.AeB = new int[this.moz];
                int i = 0;
                loop1:
                for (int i2 = 0; i2 < this.AeE.size(); i2++) {
                    aVar = (com.tencent.mm.view.c.a) this.AeE.get(i2);
                    int i3 = 0;
                    while (i3 < aVar.dMX()) {
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
                ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
            }
        }
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", Integer.valueOf(this.moz));
        AppMethodBeat.o(63103);
    }

    public static boolean isSDCardAvailable() {
        AppMethodBeat.i(63105);
        if (((h) g.RM().Rn()).SG()) {
            g.RQ();
            boolean isSDCardAvailable = g.RP().isSDCardAvailable();
            AppMethodBeat.o(63105);
            return isSDCardAvailable;
        }
        AppMethodBeat.o(63105);
        return true;
    }

    private int[] aMw() {
        AppMethodBeat.i(63106);
        int[] iArr = new int[2];
        if (this.Gn instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.Gn).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.Gn.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(63106);
        return iArr;
    }

    public final void dNu() {
        AppMethodBeat.i(63107);
        if (this.AeH != null) {
            ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.b.a.xxA.d(this.AeH);
            this.AeH = null;
        }
        AppMethodBeat.o(63107);
    }

    public final int getColumnWidth() {
        int i = 4;
        AppMethodBeat.i(63108);
        if (this.zyD == 0) {
            int aRB = aRB() / this.Aec;
            if (!x.gu(this.Gn)) {
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
        AppMethodBeat.o(63108);
        return i;
    }

    public final void dNv() {
        AppMethodBeat.i(63109);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.AeF == null) {
            this.AeF = new HashMap();
        }
        this.AeF.clear();
        cab bjU = ((d) g.M(d.class)).getProvider().bjU();
        if (!(bjU == null || bjU.wZl == null || bjU.wZl.isEmpty())) {
            Iterator it = bjU.wZl.iterator();
            while (it.hasNext()) {
                cac cac = (cac) it.next();
                this.AeF.put(cac.ProductID, Integer.valueOf(cac.vKj));
            }
        }
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(63109);
    }

    public final void dNw() {
        AppMethodBeat.i(63110);
        long currentTimeMillis = System.currentTimeMillis();
        cab cab = new cab();
        if (!(this.AeF == null || this.AeF.isEmpty())) {
            for (String str : this.AeF.keySet()) {
                cac cac = new cac();
                cac.ProductID = str;
                cac.vKj = ((Integer) this.AeF.get(str)).intValue();
                cab.wZl.add(cac);
            }
            ((d) g.M(d.class)).getProvider().a(cab);
        }
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(63110);
    }

    public final boolean dNx() {
        AppMethodBeat.i(63111);
        if (this.AeG == null || this.AeG.size() < 3) {
            AppMethodBeat.o(63111);
            return false;
        }
        AppMethodBeat.o(63111);
        return true;
    }

    public final void dNy() {
        AppMethodBeat.i(63112);
        this.AeG = ((d) g.M(d.class)).getProvider().bjY();
        AppMethodBeat.o(63112);
    }

    public final boolean dNz() {
        AppMethodBeat.i(139078);
        boolean QL = QL(this.gOW);
        AppMethodBeat.o(139078);
        return QL;
    }

    public static int QK(int i) {
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

    public static boolean QL(int i) {
        AppMethodBeat.i(63114);
        if (((d) g.M(d.class)).getProvider().OT() && (i == ChatFooterPanel.vhi || i == ChatFooterPanel.vhn || i == ChatFooterPanel.vho || i == ChatFooterPanel.vhp)) {
            AppMethodBeat.o(63114);
            return true;
        }
        AppMethodBeat.o(63114);
        return false;
    }

    public static boolean QM(int i) {
        return i == ChatFooterPanel.vhi;
    }

    public final void onPause() {
        AppMethodBeat.i(63079);
        this.zRn = false;
        dNl();
        dNw();
        dNu();
        ((d) g.M(d.class)).getProvider().bjZ();
        AppMethodBeat.o(63079);
    }

    public static int ati(String str) {
        AppMethodBeat.i(63080);
        if (str.equals("TAG_DEFAULT_TAB")) {
            AppMethodBeat.o(63080);
            return 20;
        } else if (str.equals(String.valueOf(EmojiGroupInfo.yas))) {
            AppMethodBeat.o(63080);
            return 25;
        } else if (str.equals("capture")) {
            AppMethodBeat.o(63080);
            return 26;
        } else {
            AppMethodBeat.o(63080);
            return 23;
        }
    }

    public final int atj(String str) {
        AppMethodBeat.i(63083);
        int i;
        if ("TAG_DEFAULT_TAB".equals(str)) {
            i = this.Aee;
            AppMethodBeat.o(63083);
            return i;
        }
        i = this.Aeb;
        AppMethodBeat.o(63083);
        return i;
    }

    public final void dNm() {
        AppMethodBeat.i(63090);
        if (this.Aes) {
            if (!this.Aeq.equals("TAG_DEFAULT_TAB")) {
                this.Aeq = "TAG_DEFAULT_TAB";
                this.Aer = bo.a((Integer) this.AeF.get(this.Aeq), 0);
            }
            AppMethodBeat.o(63090);
            return;
        }
        com.tencent.mm.by.a.dmE();
        b bVar = com.tencent.mm.by.a.xum;
        this.Aeq = b.bJ(-29414086, "TAG_DEFAULT_TAB");
        this.Aer = bo.a((Integer) this.AeF.get(this.Aeq), 0);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", this.Aeq, Integer.valueOf(this.Aer));
        AppMethodBeat.o(63090);
    }

    public final com.tencent.mm.view.c.a dNr() {
        AppMethodBeat.i(63098);
        com.tencent.mm.view.c.a atl = atl(this.Aeq);
        AppMethodBeat.o(63098);
        return atl;
    }

    public final int dNs() {
        AppMethodBeat.i(63102);
        int dMX;
        if (this.Aes) {
            dMX = atl("TAG_DEFAULT_TAB").dMX();
            AppMethodBeat.o(63102);
            return dMX;
        }
        dMX = this.moz;
        AppMethodBeat.o(63102);
        return dMX;
    }

    public final void a(com.tencent.mm.view.c.a aVar) {
        int i;
        int i2;
        AppMethodBeat.i(63104);
        String str = aVar.kWz;
        if (str.equals("TAG_DEFAULT_TAB")) {
            i = this.Aek;
            i2 = this.Ael;
        } else {
            i = this.Aem;
            i2 = this.Aem;
        }
        int i3 = aVar.tVA;
        int atj = (this.jiL - (i * 2)) - (atj(str) * i3);
        if (atj >= this.Aep) {
            i2 = (atj - this.Aep) / (i3 + 1);
            aVar.Adl = i + i2;
            if (i3 == 1) {
                aVar.Adk = 0;
                AppMethodBeat.o(63104);
                return;
            }
            aVar.Adk = i2;
            AppMethodBeat.o(63104);
        } else if (atj >= this.Aeo) {
            aVar.Adl = i;
            aVar.Adk = 0;
            AppMethodBeat.o(63104);
        } else {
            if (x.gu(this.Gn)) {
                atj = (atj - this.Aeo) / (i3 + 1);
            } else {
                atj /= i3 + 1;
            }
            i += atj;
            if (i < i2) {
                aVar.Adl = i2;
            } else {
                aVar.Adl = i;
            }
            aVar.Adk = atj;
            AppMethodBeat.o(63104);
        }
    }
}
