package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI extends FTSBaseUI {
    private String mEp;
    private int mFa;
    private g mIG;
    private String query;

    class a implements b {
        private String eoz;

        private a() {
        }

        /* synthetic */ a(FTSConvMessageUI fTSConvMessageUI, byte b) {
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

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61818);
        super.bAQ();
        this.mEp = getIntent().getStringExtra("key_conv");
        this.query = getIntent().getStringExtra("key_query");
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.o(61818);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61819);
        super.onCreate(bundle);
        a aVar = new a(this, (byte) 0);
        aVar.eoz = d.LC(this.mEp);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        l(this.query, arrayList);
        bAM();
        AppMethodBeat.o(61819);
    }

    public final int getLayoutId() {
        return R.layout.a1c;
    }

    public void onDestroy() {
        AppMethodBeat.i(61820);
        this.mIG.finish();
        super.onDestroy();
        AppMethodBeat.o(61820);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61821);
        if (this.mIG == null) {
            this.mIG = new g(eVar, this.mEp, this.mFa);
        }
        g gVar = this.mIG;
        AppMethodBeat.o(61821);
        return gVar;
    }

    public final boolean aMo() {
        return false;
    }

    public final String getHint() {
        AppMethodBeat.i(61822);
        String string = getString(R.string.e13);
        AppMethodBeat.o(61822);
        return string;
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(61823);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(61823);
    }
}
