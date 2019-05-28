package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI extends FTSBaseUI {
    private String mEp;
    private String mEq;
    private int mFa;
    private h mIJ;
    private String query;
    private int showType;
    private String talker;

    class a implements b {
        private String eoz;

        private a() {
        }

        /* synthetic */ a(FTSConvTalkerMessageUI fTSConvTalkerMessageUI, byte b) {
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
        AppMethodBeat.i(61831);
        super.onCreate(bundle);
        ((n) g.M(n.class)).getFTSImageLoader().bzY();
        a aVar = new a(this, (byte) 0);
        aVar.eoz = this.mEq;
        a aVar2 = new a(this, (byte) 0);
        aVar2.eoz = ">";
        a aVar3 = new a(this, (byte) 0);
        aVar3.eoz = d.LC(this.mEp);
        ArrayList arrayList = new ArrayList();
        if (this.showType == 2) {
            arrayList.add(aVar);
            arrayList.add(aVar2);
            arrayList.add(aVar3);
        } else {
            arrayList.add(aVar3);
            arrayList.add(aVar2);
            arrayList.add(aVar);
        }
        l(this.query, arrayList);
        bAM();
        AppMethodBeat.o(61831);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61832);
        super.bAQ();
        this.mEp = getIntent().getStringExtra("key_conv");
        this.talker = getIntent().getStringExtra("key_talker");
        this.query = getIntent().getStringExtra("key_query");
        this.mEq = getIntent().getStringExtra("key_talker_query");
        this.showType = getIntent().getIntExtra("detail_type", 1);
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        ab.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", this.query, this.talker, this.mEp, Integer.valueOf(this.showType));
        AppMethodBeat.o(61832);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61833);
        if (this.mIJ == null) {
            this.mIJ = new h(this, this.talker, this.mEq, this.mEp, this.mFa, this.showType);
        }
        h hVar = this.mIJ;
        AppMethodBeat.o(61833);
        return hVar;
    }

    public final int getLayoutId() {
        return R.layout.a1x;
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(61834);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(61834);
    }
}
