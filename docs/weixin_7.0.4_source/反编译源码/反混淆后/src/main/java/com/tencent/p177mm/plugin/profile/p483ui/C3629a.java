package com.tencent.p177mm.plugin.profile.p483ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.p625a.C46673d;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.a */
public final class C3629a extends C40845o implements C28114l {
    C7616ad ehM;
    C7306ak handler = new C7306ak(Looper.getMainLooper());
    private List<C45966l> mFf;

    /* renamed from: com.tencent.mm.plugin.profile.ui.a$a */
    static class C3630a implements Comparator<C45966l> {
        private C3630a() {
        }

        /* synthetic */ C3630a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C45966l c45966l = (C45966l) obj;
            C45966l c45966l2 = (C45966l) obj2;
            if (c45966l2.timestamp > c45966l.timestamp) {
                return 1;
            }
            if (c45966l2.timestamp < c45966l.timestamp) {
                return -1;
            }
            return 0;
        }
    }

    public C3629a(C36251l c36251l, int i, C7616ad c7616ad) {
        super(c36251l, new ArrayList(), true, false, i);
        AppMethodBeat.m2504i(23330);
        this.ehM = c7616ad;
        AppMethodBeat.m2505o(23330);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(23331);
        C46673d c46673d = new C46673d(i, this.ehM);
        C9638aw.m17190ZK();
        c46673d.ehM = C18628c.m29078XM().aoO(((C45966l) this.mFf.get(i)).mDx);
        AppMethodBeat.m2505o(23331);
        return c46673d;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(23332);
        if (this.mFf == null) {
            AppMethodBeat.m2505o(23332);
            return 0;
        }
        int size = this.mFf.size();
        AppMethodBeat.m2505o(23332);
        return size;
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        AppMethodBeat.m2504i(23333);
        if (c28109j.bFZ == 0) {
            this.mFf = c28109j.mEy;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(23333);
    }
}
