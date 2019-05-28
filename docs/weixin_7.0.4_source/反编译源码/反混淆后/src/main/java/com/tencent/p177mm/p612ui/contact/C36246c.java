package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C46674k;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.c */
public final class C36246c extends C40845o implements C4937b {
    private Cursor gnQ;
    private int pUv;
    private C30666a zkH;
    private int zkI;
    private int zkJ;
    private int zkK;
    private int zkL;
    private int zkM;
    private int zkN;
    private HashMap<String, Integer> zkO;
    private SparseArray<String> zkP;

    /* renamed from: com.tencent.mm.ui.contact.c$a */
    public static class C30666a {
        public String zjx = "@all.contact.without.chatroom";
        public boolean zkQ = false;
        public boolean zkR = false;
        public boolean zkS = false;
        public boolean zkT = false;
        public boolean zkU = false;
        public boolean zkV = false;
        public String zkW;
        public String zkX;
        public boolean zkY = false;
        public String zkZ = "";
        public String zla = "";
    }

    public C36246c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, C30666a c30666a, boolean z3) {
        super((C36251l) mMBaseSelectContactUI, (List) list, z, z2, z3);
        AppMethodBeat.m2504i(105190);
        this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkM = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkO = null;
        this.zkP = null;
        C4990ab.m7416i("MicroMsg.AlphabetContactAdapter", "create!");
        if (c30666a != null) {
            this.zkH = c30666a;
        } else {
            this.zkH = new C30666a();
        }
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        m59661Km();
        AppMethodBeat.m2505o(105190);
    }

    public C36246c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, C30666a c30666a) {
        this(mMBaseSelectContactUI, list, true, z, c30666a, false);
    }

    /* renamed from: Km */
    private void m59661Km() {
        AppMethodBeat.m2504i(105191);
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
        if (this.zkO != null) {
            this.zkO.clear();
        } else {
            this.zkO = new HashMap();
        }
        if (this.zkP != null) {
            this.zkP.clear();
        } else {
            this.zkP = new SparseArray();
        }
        ArrayList arrayList = new ArrayList();
        int count;
        int i;
        Object eB;
        String[] W;
        if (this.zkH.zkU) {
            C1720g.m3537RQ();
            Cursor k = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15762k(C5046bo.m7508P(this.zkH.zkX.split(",")), false);
            arrayList.add(k);
            count = k.getCount();
            C4990ab.m7411d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", Integer.valueOf(count));
            if (count > 0) {
                this.zkN = 0;
                count = (count + 1) + 0;
                m59662bM(this.zkN, "☆");
                i = count;
            } else {
                this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
                i = 0;
            }
            if (this.zkH.zjx == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                C1720g.m3537RQ();
                eB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15752eB(C5046bo.m7508P(this.zkH.zkW.split(",")));
            } else {
                C1720g.m3537RQ();
                eB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15751eA(C5046bo.m7508P(this.zkH.zkW.split(",")));
            }
            arrayList.add(eB);
            count = eB.getCount();
            if (count > 0) {
                this.zkJ = i;
                i += count + 1;
                m59662bM(this.zkJ, "☆");
            } else {
                this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            ArrayList P = C5046bo.m7508P(this.zkH.zkW.split(","));
            C1720g.m3537RQ();
            arrayList.add(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15762k(P, true));
            W = C1855t.m3870W(P);
            int[] V = C1855t.m3869V(P);
            if (!(W == null || V == null)) {
                for (count = 0; count < W.length; count++) {
                    if (count < V.length) {
                        m59662bM(V[count] + i, W[count]);
                        i++;
                    }
                }
                k.getCount();
            }
        } else {
            Cursor ew;
            if (this.zkH.zkV) {
                this.zkM = 0;
                m59662bM(this.zkM, "nonLimit");
                i = 1;
            } else {
                i = 0;
            }
            if (this.zkH.zkY && this.zkH.zkZ != null && !C5046bo.isNullOrNil(this.zkH.zkZ)) {
                ArrayList P2 = C5046bo.m7508P(this.zkH.zkZ.split(";"));
                C1720g.m3537RQ();
                ew = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15760ew(P2);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.zkI = i;
                    i += count + 1;
                    m59662bM(this.zkI, "↑");
                } else {
                    this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            } else if (this.zkH.zkQ) {
                ew = C5450g.m8254fm(this.elZ);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.pUv = i;
                    i += count + 1;
                    m59662bM(this.pUv, "↑");
                } else {
                    this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            if (this.zkH.zkR) {
                if (this.zkH.zjx == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                    C1720g.m3537RQ();
                    eB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15754eD(this.elZ);
                } else {
                    C1720g.m3537RQ();
                    eB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15753eC(this.elZ);
                }
                arrayList.add(eB);
                count = eB.getCount();
                if (count > 0) {
                    this.zkJ = i;
                    i += count + 1;
                    m59662bM(this.zkJ, "☆");
                } else {
                    this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            C1720g.m3537RQ();
            Cursor b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15726b(this.zkH.zjx, "", this.elZ);
            arrayList.add(b);
            W = C1855t.m3884a(this.zkH.zjx, "", "", this.elZ);
            int[] a = C1855t.m3882a(this.zkH.zjx, "", this.elZ, "");
            if (!(W == null || a == null)) {
                int i2 = i;
                for (count = 0; count < W.length; count++) {
                    if (count < a.length) {
                        m59662bM(a[count] + i2, W[count]);
                        i2++;
                    }
                }
                i += b.getCount() + W.length;
            }
            if (this.zkH.zkS) {
                C1720g.m3537RQ();
                ew = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15734c("@all.chatroom.contact", "", this.elZ);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.zkK = i;
                    i += count + 1;
                    m59662bM(this.zkK, this.zmV.getActivity().getString(C25738R.string.f8738dl));
                } else {
                    this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            if (this.zkH.zkT) {
                C1720g.m3537RQ();
                ew = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15734c("@verify.contact", "", this.elZ);
                arrayList.add(ew);
                if (ew.getCount() > 0) {
                    this.zkL = i;
                    m59662bM(this.zkL, this.zmV.getActivity().getString(C25738R.string.e1p));
                } else {
                    this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
        }
        C4990ab.m7411d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", this.zkO.toString());
        this.gnQ = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.m2505o(105191);
    }

    /* renamed from: bM */
    private void m59662bM(int i, String str) {
        AppMethodBeat.m2504i(105192);
        this.zkO.put(str, Integer.valueOf(i));
        this.zkP.put(i, str);
        AppMethodBeat.m2505o(105192);
    }

    public final int arM(String str) {
        AppMethodBeat.m2504i(105193);
        if (str.equals("↑")) {
            AppMethodBeat.m2505o(105193);
            return 0;
        } else if (this.zkO == null) {
            AppMethodBeat.m2505o(105193);
            return -1;
        } else if (this.zkO.containsKey(str)) {
            int intValue = ((Integer) this.zkO.get(str)).intValue() + this.zmV.getContentLV().getHeaderViewsCount();
            AppMethodBeat.m2505o(105193);
            return intValue;
        } else {
            AppMethodBeat.m2505o(105193);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(105194);
        int size = (this.zkO == null ? 0 : this.zkO.size()) + this.gnQ.getCount();
        AppMethodBeat.m2505o(105194);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(105195);
        C5445a bN;
        if (i == this.zkN) {
            bN = C36246c.m59663bN(i, this.zmV.getActivity().getString(C25738R.string.e1r));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.zkI) {
            bN = C36246c.m59663bN(i, this.zkH.zla);
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.pUv) {
            bN = C36246c.m59663bN(i, this.zmV.getActivity().getString(C25738R.string.e1j));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.zkJ) {
            bN = C36246c.m59663bN(i, this.zmV.getActivity().getString(C25738R.string.e1d));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.zkK) {
            bN = C36246c.m59663bN(i, this.zmV.getActivity().getString(C25738R.string.f8738dl));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.zkL) {
            bN = C36246c.m59663bN(i, this.zmV.getActivity().getString(C25738R.string.e1p));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (i == this.zkM) {
            bN = new C46674k(i);
            AppMethodBeat.m2505o(105195);
            return bN;
        } else if (this.zkP.indexOfKey(i) >= 0) {
            bN = C36246c.m59663bN(i, (String) this.zkP.get(i));
            AppMethodBeat.m2505o(105195);
            return bN;
        } else {
            int i2 = i;
            int i3 = 0;
            while (i3 <= this.zkP.size()) {
                if (this.zkP.indexOfKey(i2) >= 0) {
                    i3++;
                }
                i2--;
                if (i2 < 0) {
                    break;
                }
            }
            if (this.gnQ.moveToPosition(i - i3)) {
                C4990ab.m7411d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(this.gnQ);
                bN = new C40843e(i);
                bN.ehM = c7616ad;
                bN.zmW = clI();
                bN.zmX = this.zmX;
                AppMethodBeat.m2505o(105195);
                return bN;
            }
            C4990ab.m7417i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
            AppMethodBeat.m2505o(105195);
            return null;
        }
    }

    /* renamed from: bN */
    private static C5445a m59663bN(int i, String str) {
        AppMethodBeat.m2504i(105196);
        C15819h c15819h = new C15819h(i);
        c15819h.mKQ = str;
        AppMethodBeat.m2505o(105196);
        return c15819h;
    }

    public final void finish() {
        AppMethodBeat.m2504i(105197);
        super.finish();
        C4990ab.m7416i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        AppMethodBeat.m2505o(105197);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(105198);
        m59661Km();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(105198);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final boolean mo39696c(C5445a c5445a) {
        AppMethodBeat.m2504i(105199);
        int i = c5445a.position + 1;
        int[] iArr = new int[]{this.zkN, this.zkI, this.pUv, this.zkJ, this.zkK, this.zkL};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                AppMethodBeat.m2505o(105199);
                return true;
            }
        }
        if (this.zkP.indexOfKey(i) >= 0) {
            AppMethodBeat.m2505o(105199);
            return true;
        }
        AppMethodBeat.m2505o(105199);
        return false;
    }
}
