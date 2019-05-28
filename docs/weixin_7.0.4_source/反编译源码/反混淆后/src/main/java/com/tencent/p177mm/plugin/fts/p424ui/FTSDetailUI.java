package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.FTSDetailUI */
public class FTSDetailUI extends FTSBaseUI {
    private int mFa;
    private int mFl;
    private C34230i mIQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61845);
        super.onCreate(bundle);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.query = stringExtra;
        this.mIr.getFtsEditText().mo36173n(stringExtra, null);
        C4990ab.m7417i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", this.query, Integer.valueOf(this.mFl), Integer.valueOf(this.mFa));
        bAM();
        AppMethodBeat.m2505o(61845);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61846);
        this.mFl = getIntent().getIntExtra("detail_type", 0);
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.m2505o(61846);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61847);
        if (this.mIQ == null) {
            this.mIQ = new C34230i(c28149e, this.mFl, this.mFa);
        }
        C34230i c34230i = this.mIQ;
        AppMethodBeat.m2505o(61847);
        return c34230i;
    }

    /* renamed from: a */
    public final void mo7441a(C3154a c3154a) {
    }

    public final int getLayoutId() {
        return 2130969618;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61848);
        this.mIQ.finish();
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzV();
        super.onDestroy();
        AppMethodBeat.m2505o(61848);
    }

    public final String getHint() {
        AppMethodBeat.m2504i(61849);
        String wf = C3201m.m5505wf(this.mFl);
        if (wf == null) {
            wf = getString(C25738R.string.f9220te);
            AppMethodBeat.m2505o(61849);
            return wf;
        }
        AppMethodBeat.m2505o(61849);
        return wf;
    }
}
