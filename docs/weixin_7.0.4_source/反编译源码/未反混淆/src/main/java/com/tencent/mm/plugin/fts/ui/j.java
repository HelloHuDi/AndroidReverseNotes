package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends d implements com.tencent.mm.plugin.fts.a.d.e.b {
    private boolean iVX;
    private ak mHE = new ak(Looper.getMainLooper());
    int mHU = 1;
    boolean mIF;
    boolean mIO;
    private List<e> mIR;
    com.tencent.mm.plugin.fts.ui.c.b mIS = new com.tencent.mm.plugin.fts.ui.c.b();
    private b mIT = null;
    private long mIU;
    private long mIV;
    private long mIW;
    private long mIX;
    private ak mIY = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(61850);
            switch (message.what) {
                case 1:
                    if (!j.this.iVX && j.this.getCount() > 0) {
                        ((n) g.M(n.class)).getFTSImageLoader().bzY();
                        com.tencent.mm.plugin.sns.b.n.qFx.start();
                        j.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.o(61850);
        }
    };
    private int mIZ = -1;
    boolean mJa;
    private boolean mJb;

    class a implements Runnable {
        private e mJd;
        private String query;

        a(e eVar, String str) {
            this.query = str;
            this.mJd = eVar;
        }

        public final void run() {
            int i;
            AppMethodBeat.i(61851);
            if (!j.this.mJa && ((e) j.this.mIR.get(j.this.mIR.size() - 1)).getType() == this.mJd.getType()) {
                j.this.mJa = true;
            }
            int i2 = 0;
            Iterator it = j.this.mIR.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((e) it.next()).vY(i);
            }
            j.this.setCount(i);
            j.this.notifyDataSetChanged();
            j jVar = j.this;
            jVar.T(i, jVar.mJa);
            if (j.this.mJa) {
                j.this.mIS.mLr = System.currentTimeMillis();
            }
            AppMethodBeat.o(61851);
        }
    }

    public interface b {
        void bAY();

        void bAZ();

        void bBa();
    }

    /* JADX WARNING: Missing block: B:7:0x00ac, code skipped:
            if (r2.cMI.cMK != false) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(e eVar, int i, b bVar) {
        int i2 = 1;
        super(eVar);
        AppMethodBeat.i(61852);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(16));
        hashSet.add(Integer.valueOf(32));
        hashSet.add(Integer.valueOf(48));
        hashSet.add(Integer.valueOf(64));
        hashSet.add(Integer.valueOf(128));
        hashSet.add(Integer.valueOf(96));
        hashSet.add(Integer.valueOf(112));
        if (g.RK()) {
            qp qpVar = new qp();
            com.tencent.mm.sdk.b.a.xxA.m(qpVar);
            c ll = com.tencent.mm.model.c.c.abi().ll("100193");
            if (ll.isValid()) {
                if ("1".equals(ll.dru().get("isOpenLocalSearch"))) {
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            hashSet.add(Integer.valueOf(144));
        }
        if (com.tencent.mm.modelappbrand.a.abu()) {
            hashSet.add(Integer.valueOf(208));
        }
        this.mIR = ((n) g.M(n.class)).createFTSUIUnitList(hashSet, getContext(), this, i);
        this.mIT = bVar;
        AppMethodBeat.o(61852);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.fts.a.d.a.a vZ(int i) {
        AppMethodBeat.i(61853);
        com.tencent.mm.plugin.fts.a.d.a.a aVar = null;
        for (e vZ : this.mIR) {
            aVar = vZ.vZ(i);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = aVar;
        if (aVar2 != null) {
            int i2;
            LinkedList linkedList = new LinkedList();
            for (e vZ2 : this.mIR) {
                linkedList.addAll(vZ2.bAs());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i2 = i - size;
                    break;
                }
            }
            i2 = i;
            aVar2.mFm = i2;
            aVar2.pageType = 1;
        }
        if (aVar2 == null) {
            ab.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", Integer.valueOf(getCount()), Integer.valueOf(i));
        }
        AppMethodBeat.o(61853);
        return aVar2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61854);
        this.mIF = false;
        this.mIO = false;
        this.mIZ = -1;
        this.mJa = false;
        k.a(this.mIS);
        this.mIS.reset();
        this.mIS.query = this.query;
        this.mHU = 1;
        this.mIU = 0;
        this.mIV = 0;
        this.mIW = 0;
        this.mIX = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean Ze = r.Ze();
        if (!Ze) {
            Ze = bo.getInt(com.tencent.mm.m.g.Nu().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Ze) {
            ab.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        if (!com.tencent.mm.modelappbrand.a.abu()) {
            hashSet.add("61");
        }
        hashSet.add("62");
        if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            ab.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
            hashSet.add("65");
        }
        if (((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVO()) {
            hashSet.add("63");
        } else {
            hashSet.add("67");
        }
        ab.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", Integer.valueOf(hashSet.size()));
        c(hashSet);
        AppMethodBeat.o(61854);
    }

    public final void finish() {
        AppMethodBeat.i(61855);
        if (!this.mIF) {
            this.mIF = true;
            if (!this.mIO) {
                k.a(this.query, false, bAt(), 0, this.mIS);
            }
        }
        if (!(this.mIO || this.mJb)) {
            an.l(this.query, this.mHU, 3, 3);
        }
        this.mIS.reset();
        super.finish();
        AppMethodBeat.o(61855);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clearCache() {
        AppMethodBeat.i(61856);
        super.clearCache();
        for (e eVar : this.mIR) {
            eVar.bAr();
            eVar.clearData();
        }
        AppMethodBeat.o(61856);
    }

    public final void stopSearch() {
        AppMethodBeat.i(61857);
        this.mIY.removeMessages(1);
        super.stopSearch();
        AppMethodBeat.o(61857);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(61858);
        for (e a : this.mIR) {
            z = a.a(view, aVar, z);
            if (z) {
                break;
            }
        }
        if (!(this.mIF || (aVar instanceof com.tencent.mm.plugin.fts.ui.a.n))) {
            k.a(this.query, true, bAt(), 0, this.mIS);
            this.mIF = true;
        }
        if (aVar.mFt) {
            this.mJb = true;
            ab.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(aVar.mFl), Integer.valueOf(aVar.mFa), Integer.valueOf(aVar.mFm), Integer.valueOf(aVar.mFn), aVar.mFo, Long.valueOf(aVar.mFp));
            if (!bo.isNullOrNil(this.query)) {
                an.l(this.query, this.mHU, 1, 3);
            }
            this.mIS.mLE = wc(aVar.position);
            k.a(aVar, this.mIS);
            AppMethodBeat.o(61858);
            return true;
        }
        if (aVar instanceof h) {
            this.mIO = true;
            if (!bo.isNullOrNil(this.query)) {
                an.l(this.query, this.mHU, 1, 3);
            }
            this.mIS.mLE = wc(aVar.position);
            k.a(aVar, this.mIS);
        } else if (aVar instanceof i) {
            this.mIS.mLE = wc(aVar.position);
            k.a(aVar, this.mIS);
        }
        AppMethodBeat.o(61858);
        return false;
    }

    private int wc(int i) {
        AppMethodBeat.i(61859);
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        for (e bAs : this.mIR) {
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
        AppMethodBeat.o(61859);
        return i2;
    }

    public final int getBlockCount() {
        AppMethodBeat.i(61860);
        ArrayList arrayList = new ArrayList();
        for (e bAs : this.mIR) {
            arrayList.addAll(bAs.bAs());
        }
        int size = arrayList.size();
        AppMethodBeat.o(61860);
        return size;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61861);
        a aVar = (a) eVar;
        if (str.equals(this.query)) {
            c(aVar.mEu);
        }
        if (aVar.bAK() > 0 && this.mIU == 0) {
            this.mIU = System.currentTimeMillis() - this.mIl;
            k.M(9, this.mIU);
            ab.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", Long.valueOf(this.mIU));
        }
        switch (aVar.getType()) {
            case 16:
                if (this.mIV == 0) {
                    this.mIV = System.currentTimeMillis() - this.mIl;
                    ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", Long.valueOf(this.mIV));
                    k.M(0, this.mIV);
                    break;
                }
                break;
            case 32:
                if (this.mIW == 0) {
                    this.mIW = System.currentTimeMillis() - this.mIl;
                    ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", Long.valueOf(this.mIW));
                    k.M(3, this.mIW);
                    break;
                }
                break;
            case 48:
                if (this.mIX == 0) {
                    this.mIX = System.currentTimeMillis() - this.mIl;
                    ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", Long.valueOf(this.mIX));
                    k.M(6, this.mIX);
                    break;
                }
                break;
        }
        com.tencent.mm.plugin.fts.ui.c.b bVar = this.mIS;
        for (com.tencent.mm.plugin.fts.a.d.e.a aVar2 : aVar.mHp) {
            switch (aVar2.businessType) {
                case -15:
                    bVar.mLB = aVar2.mFf.size();
                    break;
                case -13:
                    bVar.mLD = aVar2.mFf.size();
                    break;
                case -11:
                    bVar.mLC = aVar2.mFf.size();
                    break;
                case -8:
                    bVar.mLt = aVar2.mFf.size();
                    break;
                case -7:
                    bVar.mLw = aVar2.mFf.size();
                    break;
                case -6:
                    bVar.mLy = aVar2.mFf.size();
                    break;
                case -5:
                    bVar.mLA = aVar2.mFf.size();
                    break;
                case -4:
                    bVar.mLu = aVar2.mFf.size();
                    break;
                case -3:
                    bVar.mLv = aVar2.mFf.size();
                    break;
                case -2:
                    bVar.mLx = aVar2.mFf.size();
                    break;
                case -1:
                    bVar.mLz = aVar2.mFf.size();
                    break;
                default:
                    break;
            }
        }
        new a(eVar, str).run();
        AppMethodBeat.o(61861);
    }

    private void c(HashSet<String> hashSet) {
        AppMethodBeat.i(61862);
        this.mIZ++;
        if (this.mIZ < this.mIR.size()) {
            ((e) this.mIR.get(this.mIZ)).a(this.query, this.mHE, (HashSet) hashSet);
        }
        AppMethodBeat.o(61862);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(61863);
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.mJa) {
            this.mHU = 2;
            if (this.mIT != null) {
                this.mIT.bAY();
                this.mIT.bAZ();
                AppMethodBeat.o(61863);
                return;
            }
        } else if (this.mIT != null) {
            this.mIT.bBa();
        }
        AppMethodBeat.o(61863);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(61864);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iVX = true;
            ((n) g.M(n.class)).getFTSImageLoader().bzW();
            com.tencent.mm.plugin.sns.b.n.qFx.pause();
            AppMethodBeat.o(61864);
            return;
        }
        this.iVX = false;
        if (!((n) g.M(n.class)).getFTSImageLoader().bzX()) {
            this.mIY.removeMessages(1);
            this.mIY.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.o(61864);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(61865);
        int i = 0;
        Iterator it = this.mIR.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((e) it.next()).bAt() + i2;
            } else {
                AppMethodBeat.o(61865);
                return i2;
            }
        }
    }

    public final void wd(int i) {
        this.mIS.mLF = i;
    }
}
