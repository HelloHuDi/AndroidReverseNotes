package com.tencent.p177mm.p612ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.p625a.C30659i;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.transmit.b */
public final class C30772b extends C36877m {
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    C28109j mEm;
    private C28106a mEx;
    String query;
    private MMCreateChatroomUI zIJ;
    private C28114l zIK = new C159701();

    /* renamed from: com.tencent.mm.ui.transmit.b$1 */
    class C159701 implements C28114l {
        C159701() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(35034);
            if (c28109j.bFZ == 0) {
                C30772b.this.mEm = c28109j;
            } else {
                C30772b.this.mEm = null;
            }
            if (c28109j.mEy.size() == 0) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = "no_result​";
                c28109j.mEy = new ArrayList();
                c28109j.mEy.add(c45966l);
            }
            C30772b.this.clearCache();
            C30772b.this.notifyDataSetChanged();
            C30772b.this.zmU.mo28008w(c28109j.mAJ.query, c28109j.mEy.size(), true);
            AppMethodBeat.m2505o(35034);
        }
    }

    public C30772b(MMCreateChatroomUI mMCreateChatroomUI, int i) {
        super(mMCreateChatroomUI, false, i);
        AppMethodBeat.m2504i(35035);
        this.zIJ = mMCreateChatroomUI;
        AppMethodBeat.m2505o(35035);
    }

    /* renamed from: a */
    public final void mo24874a(String str, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(35036);
        this.query = str;
        C20846i c20846i = new C20846i();
        c20846i.handler = this.handler;
        c20846i.mEw = this.zIK;
        c20846i.query = str;
        c20846i.mEv = C39132b.mEV;
        c20846i.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        c20846i.mEu.add("filehelper");
        c20846i.mEu.add(C1853r.m3846Yz());
        c20846i.mEu.addAll(this.zIJ.zIN.dKe());
        this.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(35036);
    }

    public final void clearData() {
        AppMethodBeat.m2504i(35037);
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
        }
        this.query = null;
        AppMethodBeat.m2505o(35037);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        C5445a c30659i;
        AppMethodBeat.m2504i(35038);
        C45966l c45966l = (C45966l) this.mEm.mEy.get(i);
        if (c45966l.mDx.equals("no_result​")) {
            c30659i = new C30659i(i);
        } else {
            C5445a c40843e = new C40843e(i);
            c40843e.hpS = c45966l;
            c40843e.mDz = this.mEm.mDz;
            c40843e.zmW = clI();
            c40843e.eDk = true;
            c40843e.mFm = i + 1;
            c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
            c30659i = c40843e;
        }
        c30659i.query = this.query;
        c30659i.scene = this.scene;
        c30659i.zmW = false;
        AppMethodBeat.m2505o(35038);
        return c30659i;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(35039);
        if (this.mEm == null || this.mEm.mEy == null) {
            AppMethodBeat.m2505o(35039);
            return 0;
        }
        int size = this.mEm.mEy.size();
        AppMethodBeat.m2505o(35039);
        return size;
    }
}
