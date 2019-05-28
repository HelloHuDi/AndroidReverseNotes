package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C36083b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.C11208a;
import com.tencent.p177mm.protocal.protobuf.C15361mn;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.c */
public class C42811c extends C36083b {
    private int emW;
    protected int gOW;
    protected String jKW;
    protected int jKX;
    private List<C38690a> jLa = new ArrayList();
    private boolean jLb;
    protected boolean jLc;
    protected boolean jLd;
    int jLe;
    protected long[] jLf;
    protected C38691b jLg;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.c$a */
    protected static class C38690a {
        public int count;
        public long ctk;
        public List<C15361mn> elG;
        public int jLh;
        public List<String> jLi;
        public boolean jLj;
        public boolean jLk;
        public List<C35934mh> jLl;

        protected C38690a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.c$b */
    public interface C38691b {
        /* renamed from: a */
        void mo35292a(C42811c c42811c, C46635a c46635a, int i, String str, int i2, int i3);
    }

    public C42811c(Context context) {
        super(context);
        AppMethodBeat.m2504i(13886);
        mo68278v(true, true);
        this.jLb = true;
        mo68269c(1);
        AppMethodBeat.m2505o(13886);
    }

    /* renamed from: h */
    public void mo35289h(String str, List<C35934mh> list) {
        AppMethodBeat.m2504i(13887);
        this.jLa.clear();
        this.yDr.clear();
        C5004al.m7441d(this.yDs);
        this.emW = 0;
        this.jKW = str;
        if (list != null) {
            this.jLe = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                C35934mh c35934mh = (C35934mh) list.get(i);
                if (!(c35934mh == null || c35934mh.naO == null || c35934mh.naO.size() <= 0)) {
                    C38690a a = m75920a(c35934mh);
                    this.emW += C42811c.m75919a(a);
                    this.jLa.add(a);
                    C4990ab.m7417i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", Long.valueOf(a.ctk), Integer.valueOf(a.count), Integer.valueOf(this.emW));
                }
            }
            aWa();
        }
        C5004al.m7441d(this.yDs);
        AppMethodBeat.m2505o(13887);
    }

    /* renamed from: a */
    private C38690a m75920a(C35934mh c35934mh) {
        AppMethodBeat.m2504i(13888);
        C38690a c38690a = new C38690a();
        c38690a.jLl = new LinkedList();
        c38690a.jLl.add(c35934mh);
        c38690a.ctk = c35934mh.vQd;
        c38690a.count = c35934mh.naO.size();
        c38690a.jLh = c35934mh.vQe;
        c38690a.elG = new LinkedList();
        c38690a.elG.addAll(c35934mh.naO);
        c38690a.jLi = c35934mh.vQf;
        c38690a.jLj = this.jLd;
        c38690a.jLk = m75921b(c38690a);
        AppMethodBeat.m2505o(13888);
        return c38690a;
    }

    /* renamed from: a */
    public void mo35285a(C35934mh c35934mh, boolean z) {
        AppMethodBeat.m2504i(13889);
        if ((this.jLb && c35934mh == null) || c35934mh.naO == null) {
            C4990ab.m7412e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            AppMethodBeat.m2505o(13889);
            return;
        }
        if (isEmpty()) {
            this.jLe = (int) (System.currentTimeMillis() / 1000);
        }
        C38690a gD = mo68270gD(c35934mh.vQd);
        if (gD != null) {
            if (gD.elG == null) {
                gD.elG = new LinkedList();
            }
            gD.elG.addAll(c35934mh.naO);
            if (gD.jLl == null) {
                gD.jLl = new LinkedList();
            }
            gD.jLl.add(c35934mh);
            gD.count += c35934mh.naO.size();
            this.emW += c35934mh.naO.size();
        } else if (z) {
            this.jLa.add(m75920a(c35934mh));
            aWa();
        } else {
            C4990ab.m7413e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", Long.valueOf(c35934mh.vQd));
            AppMethodBeat.m2505o(13889);
            return;
        }
        C5004al.m7441d(this.yDs);
        AppMethodBeat.m2505o(13889);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gD */
    public final C38690a mo68270gD(long j) {
        AppMethodBeat.m2504i(13890);
        int gE = m75922gE(j);
        if (gE >= 0) {
            C38690a c38690a = (C38690a) this.jLa.get(gE);
            AppMethodBeat.m2505o(13890);
            return c38690a;
        }
        AppMethodBeat.m2505o(13890);
        return null;
    }

    /* renamed from: gE */
    private int m75922gE(long j) {
        AppMethodBeat.m2504i(13891);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jLa.size()) {
                AppMethodBeat.m2505o(13891);
                return -1;
            } else if (((C38690a) this.jLa.get(i2)).ctk == j) {
                AppMethodBeat.m2505o(13891);
                return i2;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: rZ */
    public final C38690a mo68273rZ(int i) {
        AppMethodBeat.m2504i(13892);
        if (i >= 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.jLa.size(); i3++) {
                C38690a c38690a = (C38690a) this.jLa.get(i3);
                i2 += C42811c.m75919a(c38690a);
                if (i < i2) {
                    AppMethodBeat.m2505o(13892);
                    return c38690a;
                }
            }
        }
        AppMethodBeat.m2505o(13892);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sa */
    public final C35934mh mo68274sa(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(13893);
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.jLa.size()) {
                C38690a c38690a = (C38690a) this.jLa.get(i3);
                int a = C42811c.m75919a(c38690a);
                i4 += a;
                if (i < i4) {
                    i4 = (c38690a.jLj ? 1 : 0) + (i4 - a);
                    while (i2 < c38690a.jLl.size()) {
                        C35934mh c35934mh = (C35934mh) c38690a.jLl.get(i2);
                        i4 += c35934mh.naO.size();
                        if (i < i4) {
                            AppMethodBeat.m2505o(13893);
                            return c35934mh;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        AppMethodBeat.m2505o(13893);
        return null;
    }

    /* renamed from: a */
    private static int m75919a(C38690a c38690a) {
        int i = 1;
        if (c38690a == null) {
            return 0;
        }
        int i2 = (c38690a.jLj ? 1 : 0) + c38690a.count;
        if (!c38690a.jLk) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void aWa() {
        boolean z = true;
        synchronized (this) {
            int i;
            C38690a c38690a;
            AppMethodBeat.m2504i(13894);
            HashMap hashMap = new HashMap();
            for (i = 0; i < this.jLa.size(); i++) {
                c38690a = (C38690a) this.jLa.get(i);
                if (c38690a != null) {
                    hashMap.put(Long.valueOf(c38690a.ctk), c38690a);
                }
            }
            this.jLa.clear();
            this.emW = 0;
            for (long valueOf : this.jLf) {
                c38690a = (C38690a) hashMap.get(Long.valueOf(valueOf));
                if (c38690a != null) {
                    this.jLa.add(c38690a);
                    this.emW = C42811c.m75919a(c38690a) + this.emW;
                }
            }
            if (this.jLa.size() > 0) {
                c38690a = (C38690a) this.jLa.get(this.jLa.size() - 1);
                if (c38690a.jLk == this.jLb) {
                    this.emW = (c38690a.jLk ? -1 : 1) + this.emW;
                    if (this.jLb) {
                        z = false;
                    }
                    c38690a.jLk = z;
                }
            }
            hashMap.clear();
            AppMethodBeat.m2505o(13894);
        }
    }

    /* renamed from: b */
    private boolean m75921b(C38690a c38690a) {
        return this.jLc && c38690a.jLh != 0;
    }

    /* renamed from: v */
    public final void mo68278v(boolean z, boolean z2) {
        this.jLd = z;
        this.jLc = z2;
    }

    public final void setScene(int i) {
        this.gOW = i;
    }

    public final void setAddContactScene(int i) {
        this.jKX = i;
    }

    /* renamed from: c */
    public final void mo68269c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.jLf = jArr;
        }
    }

    public int getCount() {
        return this.emW;
    }

    public void aWb() {
        AppMethodBeat.m2504i(13895);
        mo35289h(null, null);
        this.jLe = 0;
        AppMethodBeat.m2505o(13895);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* renamed from: sb */
    public final C46635a mo56928sb(int i) {
        C46635a c20042e;
        int i2 = 0;
        AppMethodBeat.m2504i(13896);
        int i3 = 0;
        for (int i4 = 0; i4 < this.jLa.size(); i4++) {
            C38690a c38690a = (C38690a) this.jLa.get(i4);
            int a = C42811c.m75919a(c38690a);
            i3 += a;
            if (c38690a.jLj && i == i3 - a) {
                C35934mh c35934mh = c38690a.jLl.size() == 0 ? null : (C35934mh) c38690a.jLl.get(0);
                if (c35934mh != null) {
                    C20039d c20039d = new C20039d(c35934mh.Title);
                    AppMethodBeat.m2505o(13896);
                    return c20039d;
                }
            } else if (c38690a.jLk && i == i3 - 1) {
                c20042e = new C20042e(c38690a.ctk, c38690a.count, this.jKW);
                AppMethodBeat.m2505o(13896);
                return c20042e;
            } else if (i < i3) {
                i4 = (i - i3) + c38690a.count;
                if (c38690a.jLk) {
                    i2 = 1;
                }
                i2 += i4;
                C15361mn c15361mn = (C15361mn) c38690a.elG.get(i2);
                long j = c38690a.ctk;
                C38691b c38691b = this.jLg;
                if (c15361mn == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                    AppMethodBeat.m2505o(13896);
                    return null;
                }
                if (j == 1) {
                    C4990ab.m7418v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                    c20042e = new C42806a(c15361mn);
                } else if (j == 4) {
                    c20042e = new C27515g(c15361mn);
                } else if (j == 1073741824) {
                    c20042e = new C27515g(c15361mn);
                } else {
                    c20042e = new C27515g(c15361mn);
                }
                if (c20042e instanceof C11208a) {
                    C11208a c11208a = (C11208a) c20042e;
                    c11208a.mo22910sf(i2);
                    c11208a.setPosition(i);
                    c11208a.setReporter(c38691b);
                }
                AppMethodBeat.m2505o(13896);
                return c20042e;
            }
        }
        c20042e = new C27515g(null);
        AppMethodBeat.m2505o(13896);
        return c20042e;
    }

    /* renamed from: sc */
    public Object[] mo35290sc(int i) {
        Object obj;
        AppMethodBeat.m2504i(13897);
        C38690a rZ = mo68273rZ(i);
        C35934mh sa = mo68274sa(i);
        if (sa != null) {
            obj = sa.vQg;
        } else {
            String obj2 = "";
        }
        if (rZ != null) {
            Object[] objArr = new Object[]{this, rZ.jLi, Integer.valueOf(this.jKX), obj2};
            AppMethodBeat.m2505o(13897);
            return objArr;
        }
        AppMethodBeat.m2505o(13897);
        return null;
    }

    public final void setReporter(C38691b c38691b) {
        this.jLg = c38691b;
    }
}
