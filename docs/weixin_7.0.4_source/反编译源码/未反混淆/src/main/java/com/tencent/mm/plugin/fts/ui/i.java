package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class i extends d implements b {
    private boolean gxV;
    private boolean iVX;
    private int mFl;
    private ak mHE = new ak(Looper.getMainLooper());
    private boolean mIF;
    private e mIL;
    private a mIM;
    private ak mIN = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(61835);
            switch (message.what) {
                case 1:
                    ab.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!i.this.iVX && i.this.getCount() > 0) {
                        ((n) g.M(n.class)).getFTSImageLoader().bzY();
                        com.tencent.mm.plugin.sns.b.n.qFx.start();
                        i.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.o(61835);
        }
    };
    private boolean mIO;

    public i(e eVar, int i, int i2) {
        super(eVar);
        AppMethodBeat.i(61836);
        this.mFl = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case -15:
                i3 = 4240;
                break;
            case -13:
                i3 = 4224;
                break;
            case -7:
                i3 = 4208;
                break;
            case -6:
                i3 = 4160;
                break;
            case -5:
                i3 = 4144;
                break;
            case -4:
                i3 = 4112;
                break;
            case -3:
                i3 = 4128;
                break;
            case -2:
                i3 = 4176;
                break;
            case -1:
                i3 = 4192;
                break;
        }
        ab.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", Integer.valueOf(i3), Integer.valueOf(i3));
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.mIL = (e) ((n) g.M(n.class)).createFTSUIUnitList(hashSet, context, this, i2).get(0);
        this.mIM = new a();
        AppMethodBeat.o(61836);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.fts.a.d.a.a vZ(int i) {
        AppMethodBeat.i(61837);
        com.tencent.mm.plugin.fts.a.d.a.a vZ = this.mIL.vZ(i);
        if (vZ != null) {
            vZ.mFm = i;
            vZ.pageType = 2;
        }
        AppMethodBeat.o(61837);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61838);
        this.gxV = true;
        this.mIF = false;
        this.mIM.reset();
        this.mIL.a(this.query, this.mHE, new HashSet());
        AppMethodBeat.o(61838);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clearCache() {
        AppMethodBeat.i(61839);
        super.clearCache();
        this.mIL.clearData();
        this.mIL.bAr();
        this.mIN.removeMessages(1);
        AppMethodBeat.o(61839);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(61840);
        this.mIL.a(view, aVar, z);
        if (aVar.mFt) {
            ab.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(aVar.mFl), Integer.valueOf(aVar.mFa), Integer.valueOf(aVar.mFm), Integer.valueOf(aVar.mFn), aVar.mFo, Long.valueOf(aVar.mFp));
            if (!this.mIF) {
                k.c(this.query, true, bAt(), aVar.mFl);
                this.mIF = true;
            }
            k.a(aVar, this.mIM);
        } else if (aVar instanceof h) {
            this.mIO = true;
            k.a(aVar, this.mIM);
        }
        AppMethodBeat.o(61840);
        return false;
    }

    public final void finish() {
        AppMethodBeat.i(61841);
        if (!this.mIF) {
            this.mIF = true;
            if (!this.mIO) {
                k.c(this.query, false, bAt(), this.mFl);
            }
        }
        this.mIM.reset();
        super.finish();
        AppMethodBeat.o(61841);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(61843);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iVX = true;
            ((n) g.M(n.class)).getFTSImageLoader().bzW();
            com.tencent.mm.plugin.sns.b.n.qFx.pause();
            ab.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            AppMethodBeat.o(61843);
            return;
        }
        this.iVX = false;
        if (!((n) g.M(n.class)).getFTSImageLoader().bzX()) {
            this.mIN.removeMessages(1);
            this.mIN.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.o(61843);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(61844);
        int bAt = this.mIL.bAt();
        AppMethodBeat.o(61844);
        return bAt;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61842);
        if (str.equals(this.query)) {
            this.gxV = false;
        }
        setCount(eVar.vY(0));
        notifyDataSetChanged();
        T(getCount(), true);
        this.mIM.mLr = System.currentTimeMillis();
        a aVar = this.mIM;
        for (e.a aVar2 : ((a) eVar).mHp) {
            aVar.mLs = aVar2.mFf.size() + aVar.mLs;
        }
        AppMethodBeat.o(61842);
    }
}
