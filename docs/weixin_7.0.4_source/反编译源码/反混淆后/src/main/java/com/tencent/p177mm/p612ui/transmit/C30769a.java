package com.tencent.p177mm.p612ui.transmit;

import android.os.Looper;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C15821j;
import com.tencent.p177mm.p612ui.contact.p625a.C30659i;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.transmit.a */
public final class C30769a extends C40845o {
    private int count = 0;
    HashSet<String> gnG;
    C7306ak handler = new C7306ak(Looper.getMainLooper());
    C28114l plf = new C307701();
    List<String> zID;
    List<C28106a> zIE;
    List<C30768a> zIF;

    /* renamed from: com.tencent.mm.ui.transmit.a$a */
    class C30768a {
        C20840g mDz;
        List<C45966l> mEy;
        int mFb;
        int mFd;
        boolean mFg;
        String query;
        String zII;

        private C30768a() {
            this.mFb = BaseClientBuilder.API_PRIORITY_OTHER;
            this.mFd = BaseClientBuilder.API_PRIORITY_OTHER;
            this.mFg = true;
        }

        /* synthetic */ C30768a(C30769a c30769a, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.a$1 */
    class C307701 implements C28114l {
        C307701() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(35023);
            C30768a c30768a = new C30768a(C30769a.this, (byte) 0);
            c30768a.query = c28109j.mAJ.query;
            c30768a.mDz = c28109j.mDz;
            c30768a.mEy = c28109j.mEy;
            if (c30768a.mEy == null || c30768a.mEy.size() == 0) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = "no_result​";
                c30768a.mEy = new ArrayList();
                c30768a.mEy.add(c45966l);
            }
            C30769a.this.zIF.add(c30768a);
            C30769a.m49108b(C30769a.this);
            AppMethodBeat.m2505o(35023);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.a$2 */
    class C307712 implements Runnable {
        final /* synthetic */ int zIH;

        C307712(int i) {
            this.zIH = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(35024);
            C30769a.m49107a(C30769a.this, this.zIH);
            AppMethodBeat.m2505o(35024);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m49107a(C30769a c30769a, int i) {
        AppMethodBeat.m2504i(35033);
        boolean PN = c30769a.m49105PN(i);
        AppMethodBeat.m2505o(35033);
        return PN;
    }

    /* renamed from: b */
    static /* synthetic */ void m49108b(C30769a c30769a) {
        AppMethodBeat.m2504i(35032);
        c30769a.dKd();
        AppMethodBeat.m2505o(35032);
    }

    public C30769a(C36251l c36251l, List<String> list, int i) {
        super(c36251l, null, true, true, i);
        AppMethodBeat.m2504i(35025);
        this.zID = list;
        this.zIF = new ArrayList();
        this.gnG = new HashSet();
        AppMethodBeat.m2505o(35025);
    }

    public final void finish() {
        AppMethodBeat.m2504i(35026);
        super.finish();
        for (C28106a cancelSearchTask : this.zIE) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(cancelSearchTask);
        }
        AppMethodBeat.m2505o(35026);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        C5445a c15819h;
        AppMethodBeat.m2504i(35027);
        C5445a c5445a = null;
        int size = this.zIF.size() - 1;
        while (size >= 0) {
            C30768a c30768a = (C30768a) this.zIF.get(size);
            if (c30768a.mFb == i) {
                c15819h = new C15819h(i);
                c15819h.mKQ = this.zmV.getActivity().getString(C25738R.string.e1x, new Object[]{c30768a.query});
            } else if (c30768a.mFd == i) {
                c15819h = new C15821j(i);
                c15819h.resId = C25738R.string.c1k;
                c15819h.mJY = c30768a.mFg;
            } else if (i > c30768a.mFb) {
                int i2 = (i - c30768a.mFb) - 1;
                C45966l c45966l = (C45966l) c30768a.mEy.get(i2);
                if (c45966l.mDx.equals("no_result​")) {
                    c15819h = new C30659i(i);
                } else {
                    c5445a = new C40843e(i);
                    c5445a.hpS = c45966l;
                    c5445a.mDz = c30768a.mDz;
                    c5445a.eDk = true;
                    c5445a.mFm = i2 + 1;
                    c5445a.mo11085ej(c5445a.hpS.type, c5445a.hpS.mDw);
                    c15819h = c5445a;
                }
            } else {
                c15819h = c5445a;
            }
            if (c15819h != null) {
                c15819h.query = c30768a.query;
                c15819h.scene = this.scene;
                c15819h.zmW = true;
                break;
            }
            size--;
            c5445a = c15819h;
        }
        c15819h = c5445a;
        AppMethodBeat.m2505o(35027);
        return c15819h;
    }

    /* Access modifiers changed, original: final */
    public final void dKd() {
        AppMethodBeat.m2504i(35028);
        int i = 0;
        Iterator it = this.zIF.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C30768a c30768a = (C30768a) it.next();
                if (c30768a.mEy.size() > 0) {
                    c30768a.mFb = i2;
                    i2++;
                    if (c30768a.mEy.size() > 3) {
                        if (c30768a.mFg) {
                            i2 += 3;
                        } else {
                            i2 += c30768a.mEy.size();
                        }
                        c30768a.mFd = i2;
                        i = i2 + 1;
                    } else {
                        i = c30768a.mEy.size() + i2;
                    }
                } else {
                    i = i2;
                }
            } else {
                this.count = i2;
                clearCache();
                notifyDataSetChanged();
                AppMethodBeat.m2505o(35028);
                return;
            }
        }
    }

    public final int getCount() {
        return this.count;
    }

    /* renamed from: Po */
    public final boolean mo39695Po(int i) {
        AppMethodBeat.m2504i(35029);
        boolean PN = m49105PN(i);
        AppMethodBeat.m2505o(35029);
        return PN;
    }

    public final List<String> dKe() {
        AppMethodBeat.m2504i(35031);
        HashSet hashSet = new HashSet();
        for (C30768a c30768a : this.zIF) {
            if (!C42252ah.isNullOrNil(c30768a.zII)) {
                hashSet.add(c30768a.zII);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        AppMethodBeat.m2505o(35031);
        return arrayList;
    }

    /* renamed from: PN */
    private boolean m49105PN(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(35030);
        int headerViewsCount = i - this.zmV.getContentLV().getHeaderViewsCount();
        int size = this.zIF.size() - 1;
        while (size >= 0) {
            C30768a c30768a = (C30768a) this.zIF.get(size);
            if (c30768a.mFd == headerViewsCount) {
                if (c30768a.mFg) {
                    size = this.zmV.getContentLV().getSelectedItemPosition();
                    c30768a.mFg = false;
                    dKd();
                    this.zmV.getContentLV().setSelection(size);
                } else {
                    Object obj;
                    c30768a.mFg = true;
                    headerViewsCount = 0;
                    while (headerViewsCount < c30768a.mEy.size()) {
                        obj = (C45966l) c30768a.mEy.get(headerViewsCount);
                        if (obj.mDx.equals(c30768a.zII) && headerViewsCount > 2) {
                            break;
                        }
                        headerViewsCount++;
                    }
                    obj = null;
                    headerViewsCount = 0;
                    if (obj != null) {
                        c30768a.mEy.remove(headerViewsCount);
                        c30768a.mEy.add(0, obj);
                    }
                    dKd();
                    this.zmV.getContentLV().setSelection(i);
                }
                notifyDataSetChanged();
                z = true;
            } else if (headerViewsCount == c30768a.mFb) {
                z = true;
                break;
            } else if (i > c30768a.mFb) {
                C45966l c45966l = (C45966l) c30768a.mEy.get((headerViewsCount - c30768a.mFb) - 1);
                if (!c45966l.mDx.equals("no_result​")) {
                    MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.zmV;
                    if (C42252ah.isNullOrNil(c30768a.zII)) {
                        if (!this.gnG.contains(c45966l.mDx)) {
                            mMCreateChatroomUI.opo.mo69767bU(c45966l.mDx, false);
                            c30768a.zII = c45966l.mDx;
                            this.gnG.add(c30768a.zII);
                        }
                    } else if (c30768a.zII.equals(c45966l.mDx)) {
                        mMCreateChatroomUI.opo.ajr(c30768a.zII);
                        this.gnG.remove(c30768a.zII);
                        c30768a.zII = null;
                    } else if (!this.gnG.contains(c45966l.mDx)) {
                        this.gnG.remove(c30768a.zII);
                        mMCreateChatroomUI.opo.ajr(c30768a.zII);
                        c30768a.zII = c45966l.mDx;
                        mMCreateChatroomUI.opo.mo69767bU(c30768a.zII, false);
                        this.gnG.add(c30768a.zII);
                    }
                    mMCreateChatroomUI.mo64497Kt();
                    notifyDataSetChanged();
                    z = true;
                }
                z = true;
            } else {
                size--;
            }
        }
        AppMethodBeat.m2505o(35030);
        return z;
    }
}
