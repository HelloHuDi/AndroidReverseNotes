package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelappbrand.C42202a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p230g.p231a.C45360qp;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p1551c.C39154b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C12061i;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C28140h;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39152n;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.j */
public final class C34231j extends C12067d implements C39133b {
    private boolean iVX;
    private C7306ak mHE = new C7306ak(Looper.getMainLooper());
    int mHU = 1;
    boolean mIF;
    boolean mIO;
    private List<C45970e> mIR;
    C39154b mIS = new C39154b();
    private C34233b mIT = null;
    private long mIU;
    private long mIV;
    private long mIW;
    private long mIX;
    private C7306ak mIY = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(61850);
            switch (message.what) {
                case 1:
                    if (!C34231j.this.iVX && C34231j.this.getCount() > 0) {
                        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
                        C21877n.qFx.start();
                        C34231j.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.m2505o(61850);
        }
    };
    private int mIZ = -1;
    boolean mJa;
    private boolean mJb;

    /* renamed from: com.tencent.mm.plugin.fts.ui.j$a */
    class C34232a implements Runnable {
        private C45970e mJd;
        private String query;

        C34232a(C45970e c45970e, String str) {
            this.query = str;
            this.mJd = c45970e;
        }

        public final void run() {
            int i;
            AppMethodBeat.m2504i(61851);
            if (!C34231j.this.mJa && ((C45970e) C34231j.this.mIR.get(C34231j.this.mIR.size() - 1)).getType() == this.mJd.getType()) {
                C34231j.this.mJa = true;
            }
            int i2 = 0;
            Iterator it = C34231j.this.mIR.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((C45970e) it.next()).mo51308vY(i);
            }
            C34231j.this.setCount(i);
            C34231j.this.notifyDataSetChanged();
            C34231j c34231j = C34231j.this;
            c34231j.mo23894T(i, c34231j.mJa);
            if (C34231j.this.mJa) {
                C34231j.this.mIS.mLr = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(61851);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.j$b */
    public interface C34233b {
        void bAY();

        void bAZ();

        void bBa();
    }

    /* JADX WARNING: Missing block: B:7:0x00ac, code skipped:
            if (r2.cMI.cMK != false) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C34231j(C28149e c28149e, int i, C34233b c34233b) {
        int i2 = 1;
        super(c28149e);
        AppMethodBeat.m2504i(61852);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(16));
        hashSet.add(Integer.valueOf(32));
        hashSet.add(Integer.valueOf(48));
        hashSet.add(Integer.valueOf(64));
        hashSet.add(Integer.valueOf(128));
        hashSet.add(Integer.valueOf(96));
        hashSet.add(Integer.valueOf(112));
        if (C1720g.m3531RK()) {
            C45360qp c45360qp = new C45360qp();
            C4879a.xxA.mo10055m(c45360qp);
            C5141c ll = C18624c.abi().mo17131ll("100193");
            if (ll.isValid()) {
                if ("1".equals(ll.dru().get("isOpenLocalSearch"))) {
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            hashSet.add(Integer.valueOf(144));
        }
        if (C42202a.abu()) {
            hashSet.add(Integer.valueOf(208));
        }
        this.mIR = ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnitList(hashSet, getContext(), this, i);
        this.mIT = c34233b;
        AppMethodBeat.m2505o(61852);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61853);
        C3154a c3154a = null;
        for (C45970e vZ : this.mIR) {
            c3154a = vZ.mo62055vZ(i);
            if (c3154a != null) {
                break;
            }
        }
        C3154a c3154a2 = c3154a;
        if (c3154a2 != null) {
            int i2;
            LinkedList linkedList = new LinkedList();
            for (C45970e vZ2 : this.mIR) {
                linkedList.addAll(vZ2.bAs());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i2 = i - size;
                    break;
                }
            }
            i2 = i;
            c3154a2.mFm = i2;
            c3154a2.pageType = 1;
        }
        if (c3154a2 == null) {
            C4990ab.m7413e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", Integer.valueOf(getCount()), Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(61853);
        return c3154a2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61854);
        this.mIF = false;
        this.mIO = false;
        this.mIZ = -1;
        this.mJa = false;
        C34234k.m56144a(this.mIS);
        this.mIS.reset();
        this.mIS.query = this.query;
        this.mHU = 1;
        this.mIU = 0;
        this.mIV = 0;
        this.mIW = 0;
        this.mIX = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean Ze = C1853r.m3851Ze();
        if (!Ze) {
            Ze = C5046bo.getInt(C26373g.m41964Nu().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Ze) {
            C4990ab.m7416i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        if (!C42202a.abu()) {
            hashSet.add("61");
        }
        hashSet.add("62");
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            C4990ab.m7416i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
            hashSet.add("65");
        }
        if (((C20023b) C1720g.m3528K(C20023b.class)).aVO()) {
            hashSet.add("63");
        } else {
            hashSet.add("67");
        }
        C4990ab.m7411d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", Integer.valueOf(hashSet.size()));
        m56131c(hashSet);
        AppMethodBeat.m2505o(61854);
    }

    public final void finish() {
        AppMethodBeat.m2504i(61855);
        if (!this.mIF) {
            this.mIF = true;
            if (!this.mIO) {
                C34234k.m56146a(this.query, false, bAt(), 0, this.mIS);
            }
        }
        if (!(this.mIO || this.mJb)) {
            C14423an.m22656l(this.query, this.mHU, 3, 3);
        }
        this.mIS.reset();
        super.finish();
        AppMethodBeat.m2505o(61855);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clearCache() {
        AppMethodBeat.m2504i(61856);
        super.clearCache();
        for (C45970e c45970e : this.mIR) {
            c45970e.bAr();
            c45970e.clearData();
        }
        AppMethodBeat.m2505o(61856);
    }

    public final void stopSearch() {
        AppMethodBeat.m2504i(61857);
        this.mIY.removeMessages(1);
        super.stopSearch();
        AppMethodBeat.m2505o(61857);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(61858);
        for (C45970e a : this.mIR) {
            z = a.mo7424a(view, c3154a, z);
            if (z) {
                break;
            }
        }
        if (!(this.mIF || (c3154a instanceof C39152n))) {
            C34234k.m56146a(this.query, true, bAt(), 0, this.mIS);
            this.mIF = true;
        }
        if (c3154a.mFt) {
            this.mJb = true;
            C4990ab.m7411d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(c3154a.mFl), Integer.valueOf(c3154a.mFa), Integer.valueOf(c3154a.mFm), Integer.valueOf(c3154a.mFn), c3154a.mFo, Long.valueOf(c3154a.mFp));
            if (!C5046bo.isNullOrNil(this.query)) {
                C14423an.m22656l(this.query, this.mHU, 1, 3);
            }
            this.mIS.mLE = m56136wc(c3154a.position);
            C34234k.m56143a(c3154a, this.mIS);
            AppMethodBeat.m2505o(61858);
            return true;
        }
        if (c3154a instanceof C28140h) {
            this.mIO = true;
            if (!C5046bo.isNullOrNil(this.query)) {
                C14423an.m22656l(this.query, this.mHU, 1, 3);
            }
            this.mIS.mLE = m56136wc(c3154a.position);
            C34234k.m56143a(c3154a, this.mIS);
        } else if (c3154a instanceof C12061i) {
            this.mIS.mLE = m56136wc(c3154a.position);
            C34234k.m56143a(c3154a, this.mIS);
        }
        AppMethodBeat.m2505o(61858);
        return false;
    }

    /* renamed from: wc */
    private int m56136wc(int i) {
        AppMethodBeat.m2504i(61859);
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        for (C45970e bAs : this.mIR) {
            arrayList.addAll(bAs.bAs());
        }
        int size = arrayList.size() - 1;
        while (size >= 0) {
            int i3;
            if (i >= ((Integer) arrayList.get(size)).intValue()) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            size--;
            i2 = i3;
        }
        AppMethodBeat.m2505o(61859);
        return i2;
    }

    public final int getBlockCount() {
        AppMethodBeat.m2504i(61860);
        ArrayList arrayList = new ArrayList();
        for (C45970e bAs : this.mIR) {
            arrayList.addAll(bAs.bAs());
        }
        int size = arrayList.size();
        AppMethodBeat.m2505o(61860);
        return size;
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61861);
        C39153a c39153a = (C39153a) c45970e;
        if (str.equals(this.query)) {
            m56131c(c39153a.mEu);
        }
        if (c39153a.bAK() > 0 && this.mIU == 0) {
            this.mIU = System.currentTimeMillis() - this.mIl;
            C34234k.m56141M(9, this.mIU);
            C4990ab.m7417i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", Long.valueOf(this.mIU));
        }
        switch (c39153a.getType()) {
            case 16:
                if (this.mIV == 0) {
                    this.mIV = System.currentTimeMillis() - this.mIl;
                    C4990ab.m7417i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", Long.valueOf(this.mIV));
                    C34234k.m56141M(0, this.mIV);
                    break;
                }
                break;
            case 32:
                if (this.mIW == 0) {
                    this.mIW = System.currentTimeMillis() - this.mIl;
                    C4990ab.m7417i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", Long.valueOf(this.mIW));
                    C34234k.m56141M(3, this.mIW);
                    break;
                }
                break;
            case 48:
                if (this.mIX == 0) {
                    this.mIX = System.currentTimeMillis() - this.mIl;
                    C4990ab.m7417i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", Long.valueOf(this.mIX));
                    C34234k.m56141M(6, this.mIX);
                    break;
                }
                break;
        }
        C39154b c39154b = this.mIS;
        for (C34203a c34203a : c39153a.mHp) {
            switch (c34203a.businessType) {
                case -15:
                    c39154b.mLB = c34203a.mFf.size();
                    break;
                case -13:
                    c39154b.mLD = c34203a.mFf.size();
                    break;
                case -11:
                    c39154b.mLC = c34203a.mFf.size();
                    break;
                case -8:
                    c39154b.mLt = c34203a.mFf.size();
                    break;
                case -7:
                    c39154b.mLw = c34203a.mFf.size();
                    break;
                case -6:
                    c39154b.mLy = c34203a.mFf.size();
                    break;
                case -5:
                    c39154b.mLA = c34203a.mFf.size();
                    break;
                case -4:
                    c39154b.mLu = c34203a.mFf.size();
                    break;
                case -3:
                    c39154b.mLv = c34203a.mFf.size();
                    break;
                case -2:
                    c39154b.mLx = c34203a.mFf.size();
                    break;
                case -1:
                    c39154b.mLz = c34203a.mFf.size();
                    break;
                default:
                    break;
            }
        }
        new C34232a(c45970e, str).run();
        AppMethodBeat.m2505o(61861);
    }

    /* renamed from: c */
    private void m56131c(HashSet<String> hashSet) {
        AppMethodBeat.m2504i(61862);
        this.mIZ++;
        if (this.mIZ < this.mIR.size()) {
            ((C45970e) this.mIR.get(this.mIZ)).mo62049a(this.query, this.mHE, (HashSet) hashSet);
        }
        AppMethodBeat.m2505o(61862);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(61863);
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.mJa) {
            this.mHU = 2;
            if (this.mIT != null) {
                this.mIT.bAY();
                this.mIT.bAZ();
                AppMethodBeat.m2505o(61863);
                return;
            }
        } else if (this.mIT != null) {
            this.mIT.bBa();
        }
        AppMethodBeat.m2505o(61863);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(61864);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iVX = true;
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzW();
            C21877n.qFx.pause();
            AppMethodBeat.m2505o(61864);
            return;
        }
        this.iVX = false;
        if (!((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzX()) {
            this.mIY.removeMessages(1);
            this.mIY.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.m2505o(61864);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(61865);
        int i = 0;
        Iterator it = this.mIR.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((C45970e) it.next()).bAt() + i2;
            } else {
                AppMethodBeat.m2505o(61865);
                return i2;
            }
        }
    }

    /* renamed from: wd */
    public final void mo54795wd(int i) {
        this.mIS.mLF = i;
    }
}
