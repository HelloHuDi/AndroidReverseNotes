package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI */
public class FTSConvTalkerMessageUI extends FTSBaseUI {
    private String mEp;
    private String mEq;
    private int mFa;
    private C41282h mIJ;
    private String query;
    private int showType;
    private String talker;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI$a */
    class C39144a implements C12071b {
        private String eoz;

        private C39144a() {
        }

        /* synthetic */ C39144a(FTSConvTalkerMessageUI fTSConvTalkerMessageUI, byte b) {
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
        AppMethodBeat.m2504i(61831);
        super.onCreate(bundle);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
        C39144a c39144a = new C39144a(this, (byte) 0);
        c39144a.eoz = this.mEq;
        C39144a c39144a2 = new C39144a(this, (byte) 0);
        c39144a2.eoz = ">";
        C39144a c39144a3 = new C39144a(this, (byte) 0);
        c39144a3.eoz = C3161d.m5401LC(this.mEp);
        ArrayList arrayList = new ArrayList();
        if (this.showType == 2) {
            arrayList.add(c39144a);
            arrayList.add(c39144a2);
            arrayList.add(c39144a3);
        } else {
            arrayList.add(c39144a3);
            arrayList.add(c39144a2);
            arrayList.add(c39144a);
        }
        mo68643l(this.query, arrayList);
        bAM();
        AppMethodBeat.m2505o(61831);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61832);
        super.bAQ();
        this.mEp = getIntent().getStringExtra("key_conv");
        this.talker = getIntent().getStringExtra("key_talker");
        this.query = getIntent().getStringExtra("key_query");
        this.mEq = getIntent().getStringExtra("key_talker_query");
        this.showType = getIntent().getIntExtra("detail_type", 1);
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        C4990ab.m7417i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", this.query, this.talker, this.mEp, Integer.valueOf(this.showType));
        AppMethodBeat.m2505o(61832);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61833);
        if (this.mIJ == null) {
            this.mIJ = new C41282h(this, this.talker, this.mEq, this.mEp, this.mFa, this.showType);
        }
        C41282h c41282h = this.mIJ;
        AppMethodBeat.m2505o(61833);
        return c41282h;
    }

    public final int getLayoutId() {
        return 2130969639;
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(61834);
        super.mo6403a(str2, str2, list, c20890b);
        AppMethodBeat.m2505o(61834);
    }
}
