package com.tencent.p177mm.p612ui.contact;

import android.os.Looper;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.contact.p625a.C15816g;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C15821j;
import com.tencent.p177mm.p612ui.contact.p625a.C40842c;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.q */
public class C23923q extends C36877m {
    private int count = 0;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private C20840g mDz;
    private C28106a mEx;
    private List<C45966l> mGW = null;
    private List<C45966l> oov = null;
    private String query;
    private int zkK = BaseClientBuilder.API_PRIORITY_OTHER;
    private int zkL = BaseClientBuilder.API_PRIORITY_OTHER;
    private List<String> znn;
    private int zno = BaseClientBuilder.API_PRIORITY_OTHER;
    private int znp = BaseClientBuilder.API_PRIORITY_OTHER;
    private int znq = BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean znr = true;
    private int zns = BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean znt = true;
    private int znu = BaseClientBuilder.API_PRIORITY_OTHER;
    private List<C45966l> znv = null;
    private List<C45966l> znw = null;
    private List<Integer> znx;
    private C28114l zny = new C239251();
    protected C28114l znz = new C239242();

    /* renamed from: com.tencent.mm.ui.contact.q$2 */
    class C239242 implements C28114l {
        C239242() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(105232);
            switch (c28109j.bFZ) {
                case -3:
                case -2:
                case -1:
                    if (c28109j.mAJ.query.equals(C23923q.this.query)) {
                        C23923q.m36874c(C23923q.this);
                        break;
                    } else {
                        AppMethodBeat.m2505o(105232);
                        return;
                    }
                case 0:
                    if (C23923q.this.mEx != null && C23923q.this.mEx.equals(C23923q.this.mEx)) {
                        C23923q.this.mDz = c28109j.mDz;
                        C23923q.m36870a(C23923q.this, c28109j.mEy);
                        if (c28109j.mEy.size() > 0) {
                            switch (((C45966l) c28109j.mEy.get(0)).type) {
                                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                                    C23923q.this.oov = c28109j.mEy;
                                    break;
                                case 131075:
                                    C23923q.this.mGW = c28109j.mEy;
                                    break;
                                case 131076:
                                    C23923q.this.znw = c28109j.mEy;
                                    break;
                                case 131081:
                                    if (C23923q.this.oov == null) {
                                        C23923q.this.oov = c28109j.mEy;
                                        break;
                                    } else {
                                        C23923q.this.oov.addAll(c28109j.mEy);
                                        break;
                                    }
                                default:
                                    C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "not support search");
                                    break;
                            }
                        }
                        C23923q.m36869a(C23923q.this, c28109j.mAJ.query, C23923q.m36874c(C23923q.this));
                        AppMethodBeat.m2505o(105232);
                        return;
                    }
            }
            AppMethodBeat.m2505o(105232);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.q$1 */
    class C239251 implements C28114l {
        C239251() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(105231);
            switch (c28109j.bFZ) {
                case -3:
                case -2:
                case -1:
                    if (c28109j.mAJ.query.equals(C23923q.this.query)) {
                        C23923q.m36874c(C23923q.this);
                        break;
                    } else {
                        AppMethodBeat.m2505o(105231);
                        return;
                    }
                case 0:
                    if (C23923q.this.mEx == null || !C23923q.this.mEx.equals(C23923q.this.mEx)) {
                        AppMethodBeat.m2505o(105231);
                        return;
                    }
                    C23923q.m36872b(C23923q.this);
                    C23923q.this.mDz = c28109j.mDz;
                    C23923q.m36870a(C23923q.this, c28109j.mEy);
                    C23923q.this.znv = c28109j.mEy;
                    C3161d.m5412bW(c28109j.mEy);
                    C23923q.m36869a(C23923q.this, c28109j.mAJ.query, C23923q.m36874c(C23923q.this));
                    AppMethodBeat.m2505o(105231);
                    return;
            }
            AppMethodBeat.m2505o(105231);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m36872b(C23923q c23923q) {
        AppMethodBeat.m2504i(105247);
        c23923q.dIe();
        AppMethodBeat.m2505o(105247);
    }

    public C23923q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        AppMethodBeat.m2504i(105233);
        this.znn = list;
        this.znx = new ArrayList();
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "Create!");
        m36866Kh();
        AppMethodBeat.m2505o(105233);
    }

    /* renamed from: ci */
    public void mo39697ci(String str, boolean z) {
        AppMethodBeat.m2504i(105234);
        if (this.zmU != null) {
            this.zmU.mo28008w(str, getCount(), z);
        }
        AppMethodBeat.m2505o(105234);
    }

    /* renamed from: a */
    public void mo24874a(String str, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(105235);
        clearTask();
        this.query = str;
        this.znx.clear();
        for (int valueOf : iArr) {
            this.znx.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        C4990ab.m7417i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.query);
        C20846i c20846i = new C20846i();
        c20846i.query = str;
        c20846i.mEr = iArr;
        c20846i.mEt = 3;
        c20846i.mEw = this.zny;
        c20846i.handler = this.handler;
        c20846i.scene = 1;
        c20846i.mEu = hashSet;
        this.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(1, c20846i);
        AppMethodBeat.m2505o(105235);
    }

    private void clearTask() {
        AppMethodBeat.m2504i(105236);
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
            this.mEx = null;
        }
        AppMethodBeat.m2505o(105236);
    }

    private void dIe() {
        AppMethodBeat.m2504i(105237);
        this.znp = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znq = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znr = true;
        this.zns = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znt = true;
        this.znu = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znv = null;
        this.oov = null;
        this.mGW = null;
        this.znw = null;
        this.mDz = null;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(105237);
    }

    /* renamed from: Kh */
    private void m36866Kh() {
        AppMethodBeat.m2504i(105238);
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        dIe();
        clearTask();
        clearCache();
        AppMethodBeat.m2505o(105238);
    }

    public final void clearData() {
        AppMethodBeat.m2504i(105239);
        m36866Kh();
        AppMethodBeat.m2505o(105239);
    }

    /* renamed from: j */
    private void m36881j(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(105240);
        int fp = C23923q.m36879fp(this.znv);
        int fp2 = C23923q.m36879fp(this.oov);
        int fp3 = C23923q.m36879fp(this.mGW);
        int fp4 = C23923q.m36879fp(this.znw);
        if (fp > 0) {
            this.znp = 0;
            fp = (fp + 1) + 0;
        } else {
            this.znp = BaseClientBuilder.API_PRIORITY_OTHER;
            fp = 0;
        }
        if (fp2 > 0) {
            this.znq = fp;
            if (fp2 <= 3 || (fp3 <= 0 && fp4 <= 0)) {
                this.zns = BaseClientBuilder.API_PRIORITY_OTHER;
                fp += fp2 + 1;
            } else if (this.znr) {
                fp += 4;
                this.zns = fp;
                fp++;
            } else {
                fp += fp2 + 1;
                this.zns = fp;
                fp++;
            }
        } else {
            this.znq = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (this.mDz.mEa.length <= 1 || clI()) {
            this.zno = BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            this.zno = fp;
            fp++;
        }
        if (fp3 > 0) {
            this.zkK = fp;
            if (fp3 <= 3 || fp4 <= 0) {
                this.znu = BaseClientBuilder.API_PRIORITY_OTHER;
                fp += fp3 + 1;
            } else if (this.znt) {
                fp += 4;
                this.znu = fp;
                fp++;
            } else {
                fp += fp3 + 1;
                this.znu = fp;
                fp++;
            }
        } else {
            this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (fp4 > 0) {
            this.zkL = fp;
            fp += fp4 + 1;
        } else {
            this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        C4990ab.m7417i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(fp));
        this.count = fp;
        if (z2) {
            mo39697ci(str, z);
        }
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(105240);
    }

    public int getCount() {
        return this.count;
    }

    /* renamed from: fp */
    private static int m36879fp(List<? extends Object> list) {
        AppMethodBeat.m2504i(105241);
        if (list == null) {
            AppMethodBeat.m2505o(105241);
            return 0;
        }
        int size = list.size();
        AppMethodBeat.m2505o(105241);
        return size;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: mP */
    public C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(105242);
        C5445a c5445a = null;
        int i2;
        C5445a c40843e;
        if (i == this.zno) {
            c5445a = new C15816g(i);
            c5445a.eDk = true;
        } else if (i == this.znp) {
            c5445a = m36880hq(C25738R.string.c20, i);
        } else if (i == this.znq) {
            c5445a = m36880hq(C25738R.string.c1k, i);
        } else if (i == this.zkK) {
            c5445a = m36880hq(C25738R.string.c1j, i);
        } else if (i == this.zkL) {
            c5445a = m36880hq(C25738R.string.c1h, i);
        } else if (i == this.zns) {
            c5445a = C23923q.m36882y(C25738R.string.c1k, i, this.znr);
        } else if (i == this.znu) {
            c5445a = C23923q.m36882y(C25738R.string.c1j, i, this.znt);
        } else if (i > this.zkL) {
            i2 = (i - this.zkL) - 1;
            c40843e = new C40843e(i);
            c40843e.hpS = (C45966l) this.znw.get(i2);
            c40843e.zmW = clI();
            c40843e.eDk = true;
            c40843e.mFm = i2 + 1;
            c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
            c5445a = c40843e;
        } else if (i > this.zkK) {
            i2 = (i - this.zkK) - 1;
            c40843e = new C40842c(i);
            c40843e.hpS = (C45966l) this.mGW.get(i2);
            c40843e.zmW = clI();
            c40843e.eDk = true;
            c40843e.mFm = i2 + 1;
            c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
            c5445a = c40843e;
        } else if (i > this.znq) {
            i2 = (i - this.znq) - 1;
            c40843e = new C40843e(i);
            c40843e.hpS = (C45966l) this.oov.get(i2);
            c40843e.zmW = clI();
            c40843e.eDk = true;
            c40843e.mFm = i2 + 1;
            c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
            c5445a = c40843e;
        } else if (i > this.znp) {
            i2 = (i - this.znp) - 1;
            C45966l c45966l = (C45966l) this.znv.get(i2);
            if (c45966l.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || c45966l.type == 131076 || c45966l.type == 131081) {
                c40843e = new C40843e(i);
                c40843e.hpS = c45966l;
                c40843e.zmW = clI();
                c40843e.zpC = true;
                c40843e.eDk = true;
                c40843e.mFm = i2 + 1;
                c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
                c5445a = c40843e;
            } else if (c45966l.type == 131075) {
                c40843e = new C40842c(i);
                c40843e.hpS = c45966l;
                c40843e.zmW = clI();
                c40843e.zpC = true;
                c40843e.eDk = true;
                c40843e.mFm = i2 + 1;
                c40843e.mo11085ej(c40843e.hpS.type, c40843e.hpS.mDw);
                c5445a = c40843e;
            } else {
                C4990ab.m7413e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(c45966l.type));
                c5445a = null;
            }
        } else {
            C4990ab.m7413e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i));
        }
        if (c5445a != null) {
            c5445a.query = this.query;
            c5445a.mDz = this.mDz;
            c5445a.scene = this.scene;
        }
        AppMethodBeat.m2505o(105242);
        return c5445a;
    }

    /* renamed from: y */
    private static C5445a m36882y(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(105243);
        C15821j c15821j = new C15821j(i2);
        c15821j.resId = i;
        c15821j.mJY = z;
        AppMethodBeat.m2505o(105243);
        return c15821j;
    }

    /* renamed from: hq */
    private C5445a m36880hq(int i, int i2) {
        AppMethodBeat.m2504i(105244);
        C15819h c15819h = new C15819h(i2);
        c15819h.mKQ = this.zmV.getActivity().getResources().getString(i);
        AppMethodBeat.m2505o(105244);
        return c15819h;
    }

    public void finish() {
        AppMethodBeat.m2504i(105245);
        super.finish();
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "finish!");
        m36866Kh();
        AppMethodBeat.m2505o(105245);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public boolean mo39696c(C5445a c5445a) {
        int i = c5445a.position + 1;
        int[] iArr = new int[]{this.znp, this.znq, this.zkK, this.zkL};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Po */
    public final boolean mo39695Po(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(105246);
        int headerViewsCount = i - this.zmV.getContentLV().getHeaderViewsCount();
        if (headerViewsCount == this.zns) {
            if (this.znr) {
                headerViewsCount = this.zmV.getContentLV().getSelectedItemPosition();
                this.znr = false;
                m36881j(this.query, true, false);
                this.zmV.getContentLV().setSelection(headerViewsCount);
            } else {
                this.znr = true;
                m36881j(this.query, true, false);
                this.zmV.getContentLV().setSelection(this.zns);
            }
        } else if (headerViewsCount != this.znu) {
            C5445a Pn = getItem(headerViewsCount);
            if (!(Pn == null || !Pn.eDk || this.zno == BaseClientBuilder.API_PRIORITY_OTHER)) {
                if (Pn.position == this.zno) {
                    C30670y.m48900Pp(1);
                    z = false;
                } else {
                    C30670y.m48900Pp(0);
                }
            }
            z = false;
        } else if (this.znt) {
            headerViewsCount = this.zmV.getContentLV().getSelectedItemPosition();
            this.znt = false;
            m36881j(this.query, true, false);
            this.zmV.getContentLV().setSelection(headerViewsCount);
        } else {
            this.znt = true;
            m36881j(this.query, true, false);
            this.zmV.getContentLV().setSelection(this.znu);
        }
        AppMethodBeat.m2505o(105246);
        return z;
    }
}
