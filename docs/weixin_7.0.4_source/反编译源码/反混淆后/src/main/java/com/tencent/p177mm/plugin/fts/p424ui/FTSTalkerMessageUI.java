package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI */
public class FTSTalkerMessageUI extends FTSBaseUI {
    private String mEq;
    private int mFa;
    private C3200l mJM;
    private String query;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI$a */
    class C16766a implements C12071b {
        private String eoz;

        private C16766a() {
        }

        /* synthetic */ C16766a(FTSTalkerMessageUI fTSTalkerMessageUI, byte b) {
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
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61950);
        super.onCreate(bundle);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
        C16766a c16766a = new C16766a(this, (byte) 0);
        c16766a.eoz = this.mEq;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c16766a);
        mo68643l(this.query, arrayList);
        bAM();
        AppMethodBeat.m2505o(61950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61951);
        super.bAQ();
        this.mEq = getIntent().getStringExtra("key_talker_query");
        this.query = getIntent().getStringExtra("key_query");
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        C4990ab.m7417i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", this.query, this.mEq);
        AppMethodBeat.m2505o(61951);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61952);
        if (this.mJM == null) {
            this.mJM = new C3200l(this, this.mEq, this.mFa);
        }
        C3200l c3200l = this.mJM;
        AppMethodBeat.m2505o(61952);
        return c3200l;
    }

    public final int getLayoutId() {
        return 2130969639;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61953);
        this.mJM.finish();
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzW();
        super.onDestroy();
        AppMethodBeat.m2505o(61953);
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(61954);
        super.mo6403a(str2, str2, list, c20890b);
        AppMethodBeat.m2505o(61954);
    }
}
