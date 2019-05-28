package com.tencent.p177mm.plugin.sns.p520ui.p1027a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C29220i;
import com.tencent.p177mm.plugin.sns.p520ui.C43612w;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b.C43587b;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b.C46246c;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.base.Vending;
import com.tencent.p177mm.vending.base.Vending.C24128a;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.ui.a.a */
public final class C29169a extends BaseAdapter implements C43612w {
    private static HashMap<Long, C29170a> rEE = new HashMap();
    private static boolean rEF = false;
    private boolean eJj = false;
    public C46251au rEA;
    public C43587b rEB;
    public boolean rEC;
    public C24128a rED = new C291681();

    /* renamed from: com.tencent.mm.plugin.sns.ui.a.a$1 */
    class C291681 implements C24128a {
        C291681() {
        }

        public final void cuN() {
            AppMethodBeat.m2504i(39932);
            if (!C29169a.this.rEC) {
                C29169a.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(39932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.a.a$a */
    static class C29170a {
        int fjN;
        /* renamed from: id */
        String f13704id;
        int mGJ;
        int networkType;
        HashSet<Integer> rEH;
        HashSet<Integer> rEI;
        HashSet<Integer> rEJ;
        HashSet<Integer> rEK;
        int rEL;
        long rEM;
        int rEN;
        int rEO;
        int rEP;

        C29170a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(39946);
        C46236n DP = mo47320DP(i);
        AppMethodBeat.m2505o(39946);
        return DP;
    }

    public C29169a(MMActivity mMActivity, ListView listView, C22089b c22089b, C29220i c29220i, String str, C43587b c43587b) {
        AppMethodBeat.m2504i(39933);
        this.rEA = new C46251au(mMActivity, listView, c22089b, c29220i, this);
        this.rEA.rps = true;
        if (c43587b == null) {
            c43587b = new C46246c();
        }
        this.rEB = c43587b;
        this.rEB.mo37606a(mMActivity, this.rEA, str);
        C43587b c43587b2 = this.rEB;
        C5687a.m8542i("Vending.ForwardVending", "Vending.setRangeSize(%s)", Integer.valueOf(10));
        c43587b2.f16224a = 10;
        this.rEB.addVendingDataChangedCallback(this.rED);
        AppMethodBeat.m2505o(39933);
    }

    /* renamed from: sg */
    public final void mo47329sg() {
        AppMethodBeat.m2504i(39934);
        if (this.eJj) {
            AppMethodBeat.m2505o(39934);
            return;
        }
        this.eJj = true;
        this.rEB.notifyVendingDataChangeSynchronize();
        AppMethodBeat.m2505o(39934);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(39935);
        View h = this.rEA.mo74353h(i, view);
        AppMethodBeat.m2505o(39935);
        return h;
    }

    public final int getViewTypeCount() {
        return 15;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(39936);
        int itemViewType = this.rEA.getItemViewType(i);
        AppMethodBeat.m2505o(39936);
        return itemViewType;
    }

    public final void crP() {
        AppMethodBeat.m2504i(139045);
        this.rEB.notifyVendingDataChange();
        AppMethodBeat.m2505o(139045);
    }

    /* renamed from: DP */
    public final C46236n mo47320DP(int i) {
        AppMethodBeat.m2504i(39938);
        C13633av c13633av = (C13633av) this.rEB.get(i);
        if (c13633av == null) {
            AppMethodBeat.m2505o(39938);
            return null;
        }
        C46236n c46236n = c13633av.qBY;
        AppMethodBeat.m2505o(39938);
        return c46236n;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.rEB.f16225c;
    }

    static {
        AppMethodBeat.m2504i(39947);
        AppMethodBeat.m2505o(39947);
    }

    /* renamed from: F */
    public static void m46336F(C46236n c46236n) {
        AppMethodBeat.m2504i(39939);
        if (c46236n != null) {
            long j = c46236n.field_snsId;
            if (!rEE.containsKey(Long.valueOf(j))) {
                C29170a c29170a = new C29170a();
                if (!(c46236n.cqu() == null || c46236n.cqu().xfI == null || c46236n.cqu().xfI.wbJ != 1 || c46236n.cqu().xfI.wbK == null || c46236n.cqu().xfI.wbK.size() <= 0)) {
                    c29170a.fjN = c46236n.cqu().xfI.wbK.size();
                    c29170a.rEH = new HashSet();
                    c29170a.rEI = new HashSet();
                    c29170a.rEJ = new HashSet();
                    c29170a.rEK = new HashSet();
                    c29170a.f13704id = c46236n.cqu().f15074Id;
                    c29170a.rEP = c46236n.cqu().dtW;
                    try {
                        cbf q = C34955aj.m57409q(c46236n);
                        c29170a.rEN = q.xao;
                        c29170a.rEO = q.xar;
                    } catch (Exception e) {
                        c29170a.rEN = 0;
                        c29170a.rEO = 0;
                    }
                    try {
                        C1720g.m3537RQ();
                        c29170a.mGJ = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15262Rp(c46236n.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        C1720g.m3537RQ();
                        c29170a.rEM = (currentTimeMillis - ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(c46236n.field_userName)) / 1000;
                    } catch (Exception e2) {
                        c29170a.mGJ = 0;
                        c29170a.rEM = 0;
                    }
                    rEE.put(Long.valueOf(j), c29170a);
                }
            }
        }
        AppMethodBeat.m2505o(39939);
    }

    /* renamed from: b */
    public static void m46338b(C46236n c46236n, int i) {
        AppMethodBeat.m2504i(39940);
        if (c46236n != null) {
            long j = c46236n.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                C29170a c29170a = (C29170a) rEE.get(Long.valueOf(j));
                if (c29170a.rEL == 0) {
                    c29170a.rEL = i + 1;
                }
                if (c29170a.rEH == null) {
                    c29170a.rEH = new HashSet();
                }
                c29170a.rEH.add(Integer.valueOf(i + 1));
            }
        }
        AppMethodBeat.m2505o(39940);
    }

    /* renamed from: c */
    public static void m46339c(C46236n c46236n, int i) {
        AppMethodBeat.m2504i(39941);
        if (c46236n != null) {
            long j = c46236n.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                C29170a c29170a = (C29170a) rEE.get(Long.valueOf(j));
                if (c29170a.rEI == null) {
                    c29170a.rEI = new HashSet();
                }
                if (!c29170a.rEI.contains(Integer.valueOf(i + 1))) {
                    c29170a.rEI.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.m2505o(39941);
    }

    /* renamed from: d */
    public static void m46340d(C46236n c46236n, int i) {
        AppMethodBeat.m2504i(39942);
        if (c46236n != null) {
            long j = c46236n.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                C29170a c29170a = (C29170a) rEE.get(Long.valueOf(j));
                if (c29170a.rEJ == null) {
                    c29170a.rEJ = new HashSet();
                }
                if (!c29170a.rEJ.contains(Integer.valueOf(i + 1))) {
                    c29170a.rEJ.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.m2505o(39942);
    }

    /* renamed from: e */
    public static void m46342e(C46236n c46236n, int i) {
        AppMethodBeat.m2504i(39943);
        if (c46236n != null) {
            long j = c46236n.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                C29170a c29170a = (C29170a) rEE.get(Long.valueOf(j));
                if (c29170a.rEK == null) {
                    c29170a.rEK = new HashSet();
                }
                if (!c29170a.rEK.contains(Integer.valueOf(i + 1))) {
                    c29170a.rEK.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.m2505o(39943);
    }

    public static void cuM() {
        AppMethodBeat.m2504i(39944);
        for (Entry value : rEE.entrySet()) {
            String str;
            String str2;
            String str3;
            C29170a c29170a = (C29170a) value.getValue();
            c29170a.networkType = C29036i.cms();
            C4990ab.m7411d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", Integer.valueOf(c29170a.fjN), Integer.valueOf(c29170a.rEH.size()), Integer.valueOf(c29170a.rEL), Integer.valueOf(c29170a.networkType), c29170a.f13704id);
            String str4 = "";
            Iterator it = c29170a.rEI.iterator();
            while (true) {
                str = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            str4 = "";
            Iterator it2 = c29170a.rEJ.iterator();
            while (true) {
                str2 = str4;
                if (!it2.hasNext()) {
                    break;
                }
                str4 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            str4 = "";
            Iterator it3 = c29170a.rEK.iterator();
            while (true) {
                str3 = str4;
                if (!it3.hasNext()) {
                    break;
                }
                str4 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            C7060h.pYm.mo8381e(11599, Integer.valueOf(c29170a.fjN), Integer.valueOf(c29170a.rEH.size()), Integer.valueOf(c29170a.rEL), Integer.valueOf(c29170a.networkType), Integer.valueOf(0), c29170a.f13704id, Long.valueOf(c29170a.rEM), Integer.valueOf(c29170a.mGJ), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c29170a.rEN), Integer.valueOf(c29170a.rEO), Integer.valueOf(0), str, str2, str3, Integer.valueOf(0), "", Integer.valueOf(c29170a.rEP));
        }
        rEE.clear();
        AppMethodBeat.m2505o(39944);
    }

    /* renamed from: d */
    public static void m46341d(TimeLineObject timeLineObject) {
        int i;
        AppMethodBeat.m2504i(39945);
        if (timeLineObject.xfI.wbN != null) {
            i = timeLineObject.xfI.wbN.vGc;
        } else {
            i = -1;
        }
        ((C20023b) C1720g.m3528K(C20023b.class)).mo6749a(timeLineObject.xfI.Url, i, 2, timeLineObject.f15074Id);
        if (!(rEF || i == -1 || !((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(24))) {
            rEF = true;
            ((C20023b) C1720g.m3528K(C20023b.class)).mo6759rX(2);
        }
        if (i == 5 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP() && timeLineObject.xfI.wbN != null && !C5046bo.isNullOrNil(timeLineObject.xfI.wbN.lvx)) {
            String str = timeLineObject.xfI.wbN.lvx;
            String v = C30080q.m47642v(str, 0, "@T");
            if (!C5730e.m8628ct(v)) {
                C17927a c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePJ = v;
                C32291o.ahp().mo43771a(str, c17927a.ahG(), null);
            }
        }
        AppMethodBeat.m2505o(39945);
    }

    public final /* bridge */ /* synthetic */ Vending crQ() {
        return this.rEB;
    }
}
