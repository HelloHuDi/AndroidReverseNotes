package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p1551c.C45977a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C28140h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.i */
public final class C34230i extends C12067d implements C39133b {
    private boolean gxV;
    private boolean iVX;
    private int mFl;
    private C7306ak mHE = new C7306ak(Looper.getMainLooper());
    private boolean mIF;
    private C45970e mIL;
    private C45977a mIM;
    private C7306ak mIN = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(61835);
            switch (message.what) {
                case 1:
                    C4990ab.m7410d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!C34230i.this.iVX && C34230i.this.getCount() > 0) {
                        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
                        C21877n.qFx.start();
                        C34230i.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.m2505o(61835);
        }
    };
    private boolean mIO;

    public C34230i(C28149e c28149e, int i, int i2) {
        super(c28149e);
        AppMethodBeat.m2504i(61836);
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
        C4990ab.m7417i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", Integer.valueOf(i3), Integer.valueOf(i3));
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.mIL = (C45970e) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnitList(hashSet, context, this, i2).get(0);
        this.mIM = new C45977a();
        AppMethodBeat.m2505o(61836);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61837);
        C3154a vZ = this.mIL.mo62055vZ(i);
        if (vZ != null) {
            vZ.mFm = i;
            vZ.pageType = 2;
        }
        AppMethodBeat.m2505o(61837);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61838);
        this.gxV = true;
        this.mIF = false;
        this.mIM.reset();
        this.mIL.mo62049a(this.query, this.mHE, new HashSet());
        AppMethodBeat.m2505o(61838);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clearCache() {
        AppMethodBeat.m2504i(61839);
        super.clearCache();
        this.mIL.clearData();
        this.mIL.bAr();
        this.mIN.removeMessages(1);
        AppMethodBeat.m2505o(61839);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(61840);
        this.mIL.mo7424a(view, c3154a, z);
        if (c3154a.mFt) {
            C4990ab.m7411d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(c3154a.mFl), Integer.valueOf(c3154a.mFa), Integer.valueOf(c3154a.mFm), Integer.valueOf(c3154a.mFn), c3154a.mFo, Long.valueOf(c3154a.mFp));
            if (!this.mIF) {
                C34234k.m56147c(this.query, true, bAt(), c3154a.mFl);
                this.mIF = true;
            }
            C34234k.m56142a(c3154a, this.mIM);
        } else if (c3154a instanceof C28140h) {
            this.mIO = true;
            C34234k.m56142a(c3154a, this.mIM);
        }
        AppMethodBeat.m2505o(61840);
        return false;
    }

    public final void finish() {
        AppMethodBeat.m2504i(61841);
        if (!this.mIF) {
            this.mIF = true;
            if (!this.mIO) {
                C34234k.m56147c(this.query, false, bAt(), this.mFl);
            }
        }
        this.mIM.reset();
        super.finish();
        AppMethodBeat.m2505o(61841);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(61843);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iVX = true;
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzW();
            C21877n.qFx.pause();
            C4990ab.m7410d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            AppMethodBeat.m2505o(61843);
            return;
        }
        this.iVX = false;
        if (!((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzX()) {
            this.mIN.removeMessages(1);
            this.mIN.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.m2505o(61843);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(61844);
        int bAt = this.mIL.bAt();
        AppMethodBeat.m2505o(61844);
        return bAt;
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61842);
        if (str.equals(this.query)) {
            this.gxV = false;
        }
        setCount(c45970e.mo51308vY(0));
        notifyDataSetChanged();
        mo23894T(getCount(), true);
        this.mIM.mLr = System.currentTimeMillis();
        C45977a c45977a = this.mIM;
        for (C34203a c34203a : ((C39153a) c45970e).mHp) {
            c45977a.mLs = c34203a.mFf.size() + c45977a.mLs;
        }
        AppMethodBeat.m2505o(61842);
    }
}
