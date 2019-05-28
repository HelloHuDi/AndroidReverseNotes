package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;

public class FTSDetailUI extends FTSBaseUI {
    private int mFa;
    private int mFl;
    private i mIQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61845);
        super.onCreate(bundle);
        ((n) g.M(n.class)).getFTSImageLoader().bzY();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.query = stringExtra;
        this.mIr.getFtsEditText().n(stringExtra, null);
        ab.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", this.query, Integer.valueOf(this.mFl), Integer.valueOf(this.mFa));
        bAM();
        AppMethodBeat.o(61845);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61846);
        this.mFl = getIntent().getIntExtra("detail_type", 0);
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.o(61846);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61847);
        if (this.mIQ == null) {
            this.mIQ = new i(eVar, this.mFl, this.mFa);
        }
        i iVar = this.mIQ;
        AppMethodBeat.o(61847);
        return iVar;
    }

    public final void a(a aVar) {
    }

    public final int getLayoutId() {
        return R.layout.a1c;
    }

    public void onDestroy() {
        AppMethodBeat.i(61848);
        this.mIQ.finish();
        ((n) g.M(n.class)).getFTSImageLoader().bzV();
        super.onDestroy();
        AppMethodBeat.o(61848);
    }

    public final String getHint() {
        AppMethodBeat.i(61849);
        String wf = m.wf(this.mFl);
        if (wf == null) {
            wf = getString(R.string.te);
            AppMethodBeat.o(61849);
            return wf;
        }
        AppMethodBeat.o(61849);
        return wf;
    }
}
