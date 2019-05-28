package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.FTSConvMessageUI */
public class FTSConvMessageUI extends FTSBaseUI {
    private String mEp;
    private int mFa;
    private C28150g mIG;
    private String query;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSConvMessageUI$a */
    class C20865a implements C12071b {
        private String eoz;

        private C20865a() {
        }

        /* synthetic */ C20865a(FTSConvMessageUI fTSConvMessageUI, byte b) {
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

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61818);
        super.bAQ();
        this.mEp = getIntent().getStringExtra("key_conv");
        this.query = getIntent().getStringExtra("key_query");
        this.mFa = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.m2505o(61818);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61819);
        super.onCreate(bundle);
        C20865a c20865a = new C20865a(this, (byte) 0);
        c20865a.eoz = C3161d.m5401LC(this.mEp);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c20865a);
        mo68643l(this.query, arrayList);
        bAM();
        AppMethodBeat.m2505o(61819);
    }

    public final int getLayoutId() {
        return 2130969618;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61820);
        this.mIG.finish();
        super.onDestroy();
        AppMethodBeat.m2505o(61820);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61821);
        if (this.mIG == null) {
            this.mIG = new C28150g(c28149e, this.mEp, this.mFa);
        }
        C28150g c28150g = this.mIG;
        AppMethodBeat.m2505o(61821);
        return c28150g;
    }

    public final boolean aMo() {
        return false;
    }

    public final String getHint() {
        AppMethodBeat.m2504i(61822);
        String string = getString(C25738R.string.e13);
        AppMethodBeat.m2505o(61822);
        return string;
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(61823);
        super.mo6403a(str2, str2, list, c20890b);
        AppMethodBeat.m2505o(61823);
    }
}
