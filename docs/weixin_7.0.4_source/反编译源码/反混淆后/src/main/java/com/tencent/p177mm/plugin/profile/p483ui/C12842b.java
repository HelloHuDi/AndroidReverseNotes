package com.tencent.p177mm.plugin.profile.p483ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.p625a.C46673d;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.b */
public final class C12842b extends C36877m {
    private C7616ad ehM;
    private C7306ak handler = new C7306ak();
    private C28106a mEx;
    private List<C45966l> mFf;
    private C28114l plf = new C128431();
    private String query;

    /* renamed from: com.tencent.mm.plugin.profile.ui.b$1 */
    class C128431 implements C28114l {
        C128431() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(23334);
            if (c28109j.bFZ == 0) {
                C12842b.this.mFf = c28109j.mEy;
                if (C12842b.this.zmU != null) {
                    C12842b.this.zmU.mo28008w(c28109j.mAJ.query, C12842b.this.mFf.size(), true);
                }
            }
            C12842b.this.clearCache();
            C12842b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(23334);
        }
    }

    public C12842b(C36251l c36251l, int i, C7616ad c7616ad) {
        super(c36251l, false, i);
        AppMethodBeat.m2504i(23335);
        this.ehM = c7616ad;
        AppMethodBeat.m2505o(23335);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(23336);
        C46673d c46673d = new C46673d(i, this.ehM);
        C9638aw.m17190ZK();
        c46673d.ehM = C18628c.m29078XM().aoO(((C45966l) this.mFf.get(i)).mDx);
        AppMethodBeat.m2505o(23336);
        return c46673d;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(23337);
        if (this.mFf == null) {
            AppMethodBeat.m2505o(23337);
            return 0;
        }
        int size = this.mFf.size();
        AppMethodBeat.m2505o(23337);
        return size;
    }

    /* renamed from: a */
    public final void mo24874a(String str, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(23338);
        this.query = str;
        C20846i c20846i = new C20846i();
        c20846i.query = str;
        c20846i.handler = this.handler;
        c20846i.mEw = this.plf;
        c20846i.mEp = this.ehM.field_username;
        c20846i.hbo = 7;
        this.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(23338);
    }

    public final void clearData() {
        AppMethodBeat.m2504i(23339);
        this.query = null;
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
        }
        AppMethodBeat.m2505o(23339);
    }
}
