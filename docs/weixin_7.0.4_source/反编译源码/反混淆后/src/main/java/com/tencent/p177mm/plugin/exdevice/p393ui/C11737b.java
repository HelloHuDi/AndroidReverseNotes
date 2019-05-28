package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.plugin.exdevice.p393ui.C45897e.C45896a;
import com.tencent.p177mm.plugin.exdevice.p393ui.ExdeviceLikeView.C11708a;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.b */
public final class C11737b extends BaseAdapter {
    private String igi = C1853r.m3846Yz();
    List<C45897e> lCD;
    Map<String, String> lCE;
    String lCF;
    C34068d lCG;
    private String lCH;
    private boolean lCI = false;
    private C45896a lCJ = new C45896a();
    private OnClickListener lCK = new C117412();
    private OnClickListener lCL = new C117423();
    private OnClickListener lCM = new C117384();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$b */
    static final class C11736b {
        public View gbS;
        public View jOT;
        public ImageView lCP;
        public NoMeasuredTextView lCQ;
        public TextView lCR;
        public TextView lCS;
        public ExdeviceLikeView lCT;
        public View lCU;
        public View lCV;
        public View lCW;
        public TextView lCX;
        public TextView ltX;

        C11736b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$4 */
    class C117384 implements OnClickListener {
        C117384() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20096);
            C11737b.this.lCG.bqa();
            AppMethodBeat.m2505o(20096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$a */
    static final class C11739a {
        public View goc;

        C11739a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$2 */
    class C117412 implements OnClickListener {
        C117412() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20094);
            C4990ab.m7416i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            C11737b.this.lCG.mo30741KI(C11737b.this.mo23502uU(((Integer) view.getTag()).intValue()).lFy.field_username);
            AppMethodBeat.m2505o(20094);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$3 */
    class C117423 implements OnClickListener {
        C117423() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20095);
            C11737b.this.lCG.mo30741KI(C11737b.this.igi);
            AppMethodBeat.m2505o(20095);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(20108);
        C45897e uU = mo23502uU(i);
        AppMethodBeat.m2505o(20108);
        return uU;
    }

    public C11737b(Context context, String str) {
        AppMethodBeat.m2504i(20097);
        this.mContext = context;
        this.lCH = str;
        AppMethodBeat.m2505o(20097);
    }

    /* renamed from: d */
    private static void m19536d(LinkedList<C34028c> linkedList, String str) {
        AppMethodBeat.m2504i(20098);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((C34028c) it.next()).field_username.equalsIgnoreCase(str)) {
                C4990ab.m7411d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", ((C34028c) it.next()).toString());
                it.remove();
            }
        }
        AppMethodBeat.m2505o(20098);
    }

    /* renamed from: e */
    private static boolean m19537e(LinkedList<C34028c> linkedList, String str) {
        AppMethodBeat.m2504i(20099);
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((C34028c) it.next()).field_username.equalsIgnoreCase(str)) {
                    AppMethodBeat.m2505o(20099);
                    return true;
                }
            }
            AppMethodBeat.m2505o(20099);
            return false;
        } catch (Exception e) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankAdapter", e.toString());
            AppMethodBeat.m2505o(20099);
            return false;
        }
    }

    /* renamed from: a */
    private List<C45897e> m19534a(ArrayList<C34028c> arrayList, ArrayList<C34029d> arrayList2, boolean z) {
        C45896a c45896a;
        AppMethodBeat.m2504i(20100);
        LinkedList linkedList = new LinkedList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        C34029d h = C11737b.m19538h(this.igi, arrayList2);
        if (h != null) {
            C45896a c45896a2 = this.lCJ;
            c45896a2.lFy = h;
            c45896a2.lFz = 3;
            if (h.field_score == 0) {
                ((C39858b) C1720g.m3528K(C39858b.class)).mo63056d((Activity) this.mContext, this.igi);
            }
        } else {
            c45896a = this.lCJ;
            c45896a.lFy = null;
            c45896a.lCH = this.lCH;
            c45896a.username = this.igi;
            c45896a.lFz = 7;
        }
        if (z) {
            this.lCJ.auo = 2;
        } else {
            this.lCJ.auo = 1;
        }
        arrayList3.add(this.lCJ.bqg());
        c45896a = this.lCJ;
        c45896a.auo = 0;
        arrayList3.add(c45896a.bqg());
        C11737b.m19536d(linkedList, this.igi);
        ArrayList arrayList4 = new ArrayList();
        C4990ab.m7411d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            h = (C34029d) it.next();
            C45896a c45896a3 = this.lCJ;
            c45896a3.lFy = h;
            c45896a3.auo = 1;
            c45896a3.lFz = 4;
            arrayList4.add(c45896a3.bqg());
            if (linkedList.size() > 0 && C11737b.m19537e(linkedList, h.field_username)) {
                c45896a3 = this.lCJ;
                c45896a3.lFy = h;
                c45896a3.auo = 1;
                c45896a3.lFz = 2;
                arrayList3.add(c45896a3.bqg());
                C11737b.m19536d(linkedList, h.field_username);
            }
        }
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                C34028c c34028c = (C34028c) it.next();
                C45896a c45896a4 = this.lCJ;
                c45896a4.username = c34028c.field_username;
                c45896a4.lCH = this.lCH;
                c45896a4.lFy = null;
                c45896a4.auo = 1;
                c45896a4.lFz = 6;
                arrayList3.add(c45896a4.bqg());
            }
        }
        if (arrayList3.size() > 2) {
            ((C45897e) arrayList3.get(arrayList3.size() - 1)).lFz = (((C45897e) arrayList3.get(arrayList3.size() - 1)).lFz | 2) | 1;
            c45896a = this.lCJ;
            c45896a.auo = 0;
            c45896a.lFy = null;
            arrayList3.add(c45896a.bqg());
        }
        if (arrayList4.size() > 1) {
            ((C45897e) arrayList4.get(arrayList4.size() - 1)).lFz = 5;
        }
        arrayList3.addAll(arrayList4);
        C4990ab.m7411d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", Integer.valueOf(arrayList2.size()), arrayList2.toString());
        C4990ab.m7411d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", Integer.valueOf(arrayList3.size()), arrayList3.toString());
        AppMethodBeat.m2505o(20100);
        return arrayList3;
    }

    /* renamed from: b */
    public final List<C45897e> mo23494b(ArrayList<C34028c> arrayList, ArrayList<C34029d> arrayList2, boolean z) {
        ArrayList arrayList3;
        ArrayList arrayList22;
        AppMethodBeat.m2504i(20101);
        if (arrayList3 == null) {
            try {
                arrayList3 = new ArrayList();
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                List<C45897e> arrayList4 = new ArrayList();
                AppMethodBeat.m2505o(20101);
                return arrayList4;
            }
        }
        if (arrayList22 == null) {
            arrayList22 = new ArrayList();
        }
        List a = m19534a(arrayList3, arrayList22, z);
        AppMethodBeat.m2505o(20101);
        return a;
    }

    /* renamed from: h */
    public static C34029d m19538h(String str, ArrayList<C34029d> arrayList) {
        AppMethodBeat.m2504i(20102);
        if (arrayList == null) {
            AppMethodBeat.m2505o(20102);
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C34029d c34029d = (C34029d) it.next();
            if (str.equalsIgnoreCase(c34029d.field_username)) {
                AppMethodBeat.m2505o(20102);
                return c34029d;
            }
        }
        AppMethodBeat.m2505o(20102);
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(20103);
        if (this.lCD == null) {
            AppMethodBeat.m2505o(20103);
            return 0;
        }
        int size = this.lCD.size();
        AppMethodBeat.m2505o(20103);
        return size;
    }

    /* renamed from: uU */
    public final C45897e mo23502uU(int i) {
        AppMethodBeat.m2504i(20104);
        C45897e c45897e = (C45897e) this.lCD.get(i);
        AppMethodBeat.m2505o(20104);
        return c45897e;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(20105);
        int i2 = mo23502uU(i).auo;
        AppMethodBeat.m2505o(20105);
        return i2;
    }

    public static void finish() {
        AppMethodBeat.m2504i(20106);
        ((C39858b) C1720g.m3528K(C39858b.class)).cwa();
        AppMethodBeat.m2505o(20106);
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x026c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C11736b c11736b;
        AppMethodBeat.m2504i(20107);
        final C34029d c34029d = mo23502uU(i).lFy;
        C45897e uU = mo23502uU(i);
        int itemViewType = getItemViewType(i);
        int i2 = uU.lFz;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    c11736b = (C11736b) view.getTag();
                    break;
                default:
                    c11736b = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(2130969445, viewGroup, false);
                C11739a c11739a = new C11739a();
                c11739a.goc = view.findViewById(2131823725);
                view.setTag(c11739a);
                c11736b = null;
                break;
            case 1:
                view = from.inflate(2130969444, viewGroup, false);
                c11736b = new C11736b();
                c11736b.lCR = (TextView) view.findViewById(2131823724);
                break;
            case 2:
                view = from.inflate(2130969446, viewGroup, false);
                c11736b = new C11736b();
                break;
            default:
                c11736b = null;
                break;
        }
        if (c11736b != null) {
            c11736b.gbS = view.findViewById(2131821064);
            c11736b.jOT = view.findViewById(2131823475);
            c11736b.ltX = (TextView) view.findViewById(2131823719);
            c11736b.lCP = (ImageView) view.findViewById(2131823720);
            c11736b.lCQ = (NoMeasuredTextView) view.findViewById(2131823723);
            c11736b.lCS = (TextView) view.findViewById(2131823673);
            c11736b.lCT = (ExdeviceLikeView) view.findViewById(2131823722);
            c11736b.lCU = view.findViewById(2131823725);
            c11736b.lCW = view.findViewById(2131823721);
            c11736b.lCV = view.findViewById(2131823717);
            c11736b.lCX = (TextView) view.findViewById(2131823726);
            if (c11736b.lCQ != null) {
                c11736b.lCQ.setTextSize(0, this.mContext.getResources().getDimension(C25738R.dimen.f9835h9));
                c11736b.lCQ.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11976nq));
                c11736b.lCQ.setSingleLine(true);
                c11736b.lCQ.setShouldEllipsize(true);
            }
            view.setTag(c11736b);
        }
        if (!(c34029d == null || c11736b == null)) {
            if (this.igi.equalsIgnoreCase(c34029d.field_username)) {
                this.lCI = true;
            } else {
                this.lCI = false;
            }
            if (itemViewType == 2) {
                c11736b.ltX.setText(String.valueOf(c34029d.field_ranknum));
                c11736b.lCS.setText(String.valueOf(c34029d.field_score));
                C40460b.m69437r(c11736b.lCP, c34029d.field_username);
                c11736b.gbS.setOnClickListener(this.lCL);
                c11736b.lCX.setOnClickListener(this.lCM);
            } else {
                if (c11736b.lCR != null) {
                    if ((i2 & 4) != 4) {
                        c11736b.lCR.setVisibility(0);
                        c11736b.lCR.setText(this.mContext.getResources().getString(C25738R.string.bhn, new Object[]{Integer.valueOf(c34029d.field_ranknum)}));
                    } else {
                        c11736b.lCR.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !c34029d.field_username.equalsIgnoreCase(this.lCF) || this.igi.equalsIgnoreCase(this.lCF)) {
                    c11736b.jOT.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f11970nj));
                } else {
                    c11736b.jOT.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f11971nk));
                }
                if ((i2 & 1) == 1) {
                    c11736b.lCU.setVisibility(8);
                } else {
                    c11736b.lCU.setVisibility(0);
                }
                if (c34029d.field_ranknum >= 100) {
                    c11736b.ltX.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9837ha));
                } else {
                    c11736b.ltX.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9836h_));
                }
                if ((i2 & 2) == 2) {
                    c11736b.ltX.setText("");
                } else {
                    c11736b.ltX.setText(c34029d.field_ranknum);
                }
                if (c34029d.field_score >= Downloads.MIN_WAIT_FOR_NETWORK) {
                    c11736b.lCS.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11975np));
                } else {
                    c11736b.lCS.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11974no));
                }
                c11736b.lCS.setText(String.valueOf(c34029d.field_score));
                C40460b.m69437r(c11736b.lCP, c34029d.field_username);
                if (!this.lCI) {
                    C9638aw.m17190ZK();
                    if (!(C18628c.m29078XM().aoJ(c34029d.field_username) || this.lCE == null || C5046bo.isNullOrNil((String) this.lCE.get(c34029d.field_username)))) {
                        c11736b.lCQ.setText(C44089j.m79293b(this.mContext, (CharSequence) this.lCE.get(c34029d.field_username), c11736b.lCQ.getTextSize()));
                        c11736b.lCT.setLikeNum(c34029d.field_likecount);
                        if (this.lCI) {
                            c11736b.lCT.setSelfLikeState(c34029d.field_selfLikeState);
                        } else if (c34029d.field_likecount != 0) {
                            c11736b.lCT.setSelfLikeState(1);
                        } else {
                            c11736b.lCT.setSelfLikeState(0);
                        }
                        if (c34029d.field_score <= 0 || this.lCI) {
                            c11736b.lCT.setClickable(true);
                            c11736b.lCT.setOnLikeViewClickListener(new C11708a() {
                                /* renamed from: iE */
                                public final void mo23468iE(int i) {
                                    AppMethodBeat.m2504i(20092);
                                    C4990ab.m7417i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", Integer.valueOf(i));
                                    if (C11737b.this.lCG != null) {
                                        C11737b.this.lCG.mo30746cd(c34029d.field_username, i);
                                    }
                                    AppMethodBeat.m2505o(20092);
                                }

                                public final boolean bpL() {
                                    AppMethodBeat.m2504i(20093);
                                    if (C11737b.this.lCG != null) {
                                        boolean KJ = C11737b.this.lCG.mo30742KJ(c34029d.field_username);
                                        AppMethodBeat.m2505o(20093);
                                        return KJ;
                                    }
                                    AppMethodBeat.m2505o(20093);
                                    return true;
                                }
                            });
                        } else {
                            c11736b.lCT.setClickable(false);
                        }
                        c11736b.lCV.setTag(Integer.valueOf(i));
                        c11736b.lCV.setOnClickListener(this.lCK);
                        c11736b.lCW.setTag(Integer.valueOf(i));
                        c11736b.lCW.setOnClickListener(this.lCK);
                    }
                }
                c11736b.lCQ.setText(C44089j.m79293b(this.mContext, C1854s.m3866mJ(c34029d.field_username), c11736b.lCQ.getTextSize()));
                c11736b.lCT.setLikeNum(c34029d.field_likecount);
                if (this.lCI) {
                }
                if (c34029d.field_score <= 0) {
                }
                c11736b.lCT.setClickable(true);
                c11736b.lCT.setOnLikeViewClickListener(/* anonymous class already generated */);
                c11736b.lCV.setTag(Integer.valueOf(i));
                c11736b.lCV.setOnClickListener(this.lCK);
                c11736b.lCW.setTag(Integer.valueOf(i));
                c11736b.lCW.setOnClickListener(this.lCK);
            }
        }
        AppMethodBeat.m2505o(20107);
        return view;
    }
}
