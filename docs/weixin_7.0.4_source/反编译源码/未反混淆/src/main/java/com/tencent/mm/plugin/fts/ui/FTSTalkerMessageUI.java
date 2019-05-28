package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI extends FTSBaseUI {
    private String mEq;
    private int mFa;
    private l mJM;
    private String query;

    class a implements b {
        private String eoz;

        private a() {
        }

        /* synthetic */ a(FTSTalkerMessageUI fTSTalkerMessageUI, byte b) {
            this();
        }

        public final String getTagName() {
            return this.eoz;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61950);
        super.onCreate(bundle);
        ((n) g.M(n.class)).getFTSImageLoader().bzY();
        a aVar = new a(this, (byte) 0);
        aVar.eoz = this.mEq;
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        l(this.query, arrayList);
        bAM();
        AppMethodBeat.o(61950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61951);
        super.bAQ();
        this.mEq = getIntent().getStringExtra("key_talker_query");
        this.query = getIntent().getStringExtra("key_query");
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        ab.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", this.query, this.mEq);
        AppMethodBeat.o(61951);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61952);
        if (this.mJM == null) {
            this.mJM = new l(this, this.mEq, this.mFa);
        }
        l lVar = this.mJM;
        AppMethodBeat.o(61952);
        return lVar;
    }

    public final int getLayoutId() {
        return R.layout.a1x;
    }

    public void onDestroy() {
        AppMethodBeat.i(61953);
        this.mJM.finish();
        ((n) g.M(n.class)).getFTSImageLoader().bzW();
        super.onDestroy();
        AppMethodBeat.o(61953);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(61954);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(61954);
    }
}
