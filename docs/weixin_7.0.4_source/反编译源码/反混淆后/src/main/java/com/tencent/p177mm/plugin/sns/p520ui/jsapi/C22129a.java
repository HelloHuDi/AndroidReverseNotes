package com.tencent.p177mm.plugin.sns.p520ui.jsapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.listview.AnimatedExpandableListView.C16004a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a */
public final class C22129a extends C16004a {
    private Context mContext;
    private LayoutInflater mInflater;
    public int rJl = 0;
    public int rJm = 1;
    public int rJn = 2;
    public int rJo = 3;
    int rJu = 4;
    List<String> rJv;
    C4085b rJw = null;
    boolean rJx = true;
    public int[] rtD = new int[]{C25738R.string.ely, C25738R.string.elw, C25738R.string.els, C25738R.string.ell};
    ArrayList<String> rtE;
    public int rtF = 0;
    public boolean rtG = false;
    public ArrayList<String> rtH = new ArrayList();
    public ArrayList<String> rtI = new ArrayList();
    public ArrayList<String> rtJ = new ArrayList();
    public ArrayList<String> rtK = new ArrayList();
    public int[] rth = new int[]{C25738R.string.elx, C25738R.string.elv, C25738R.string.elr, C25738R.string.elk};
    public int style;

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a$b */
    public interface C4085b {
        /* renamed from: a */
        void mo8948a(C4086c c4086c);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a$c */
    class C4086c {
        public int rtQ;
        public int rtR;

        C4086c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a$1 */
    class C221301 implements OnClickListener {
        C221301() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40217);
            C4086c c4086c = (view.getTag() == null || !(view.getTag() instanceof C4086c)) ? null : (C4086c) view.getTag();
            if (c4086c == null) {
                C4990ab.m7420w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
                AppMethodBeat.m2505o(40217);
                return;
            }
            if (C22129a.this.rJw != null) {
                C22129a.this.rJw.mo8948a(c4086c);
            }
            AppMethodBeat.m2505o(40217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a$a */
    class C22131a {
        TextView nQl;
        ImageView olR;
        TextView rtN;
        TextView rtO;
        ImageView rtP;
        TextView titleView;

        private C22131a() {
        }

        /* synthetic */ C22131a(C22129a c22129a, byte b) {
            this();
        }
    }

    public C22129a(Context context) {
        AppMethodBeat.m2504i(40218);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.m2505o(40218);
    }

    public final Object getChild(int i, int i2) {
        AppMethodBeat.m2504i(40219);
        Object obj = this.rtE.get(i2);
        AppMethodBeat.m2505o(40219);
        return obj;
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    /* renamed from: T */
    public final void mo37677T(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(40220);
        List<String> ctC = C22129a.ctC();
        List arrayList2 = new ArrayList();
        if (!(ctC == null || arrayList == null)) {
            for (String str : ctC) {
                if (C22129a.m33748h(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            Object c = C5046bo.m7536c(arrayList2, ",");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(335875, c);
        }
        this.rtE = arrayList;
        AppMethodBeat.m2505o(40220);
    }

    private static List<String> ctC() {
        AppMethodBeat.m2504i(40221);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(335875, null);
        C4990ab.m7411d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(40221);
            return null;
        }
        List<String> P = C5046bo.m7508P(str.split(","));
        AppMethodBeat.m2505o(40221);
        return P;
    }

    /* renamed from: ZF */
    public static void m33745ZF(String str) {
        AppMethodBeat.m2504i(40222);
        C4990ab.m7411d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", str);
        if (C22129a.ctC() != null) {
            List arrayList = new ArrayList(C22129a.ctC());
            if (!C22129a.m33748h(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                Object c = C5046bo.m7536c(arrayList, ",");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(335875, c);
            }
            AppMethodBeat.m2505o(40222);
            return;
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(335875, (Object) str);
        AppMethodBeat.m2505o(40222);
    }

    /* renamed from: h */
    private static boolean m33748h(List<String> list, String str) {
        AppMethodBeat.m2504i(40223);
        for (String equals : list) {
            if (equals.equals(str)) {
                AppMethodBeat.m2505o(40223);
                return true;
            }
        }
        AppMethodBeat.m2505o(40223);
        return false;
    }

    /* renamed from: bg */
    private boolean m33747bg(int i, String str) {
        AppMethodBeat.m2504i(40224);
        boolean h;
        if (i == 1) {
            h = C22129a.m33748h(this.rtH, str);
            AppMethodBeat.m2505o(40224);
            return h;
        }
        h = C22129a.m33748h(this.rtI, str);
        AppMethodBeat.m2505o(40224);
        return h;
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return this.rJu;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C22131a c22131a;
        AppMethodBeat.m2504i(40225);
        if (view == null || !(view.getTag() instanceof C22131a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(2130970771, null);
            } else {
                inflate = this.mInflater.inflate(2130970770, null);
            }
            C22131a c22131a2 = new C22131a(this, (byte) 0);
            c22131a2.titleView = (TextView) inflate.findViewById(2131827789);
            c22131a2.olR = (ImageView) inflate.findViewById(2131827787);
            c22131a2.nQl = (TextView) inflate.findViewById(2131827790);
            inflate.setTag(c22131a2);
            view = inflate;
            c22131a = c22131a2;
        } else {
            c22131a = (C22131a) view.getTag();
        }
        c22131a.titleView.setText(this.rth[i]);
        c22131a.nQl.setText(this.rtD[i]);
        if (i == this.rJm || i == this.rJl) {
            if (this.rtF != i) {
                c22131a.olR.setImageResource(C1318a.radio_off);
            } else {
                c22131a.olR.setImageResource(C1318a.radio_on);
                c22131a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
            }
        } else if (i == this.rJn) {
            if (this.rtF != i) {
                c22131a.olR.setImageResource(C1318a.radio_off);
            } else {
                c22131a.olR.setImageResource(C1318a.radio_on);
                c22131a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
            }
        } else if (i == this.rJo) {
            if (this.style == 1) {
                if (this.rtF != i) {
                    c22131a.olR.setImageResource(C1318a.radio_off);
                } else {
                    c22131a.olR.setImageResource(C1318a.round_selector_checked_orange);
                    c22131a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
                }
            } else if (this.rtF != i) {
                c22131a.olR.setImageResource(C1318a.radio_off);
            } else {
                c22131a.olR.setImageResource(C1318a.radio_on_red);
                c22131a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
            }
        }
        if (this.rtG && i == this.rJm) {
            view = new View(this.mContext);
            view.setVisibility(8);
            AppMethodBeat.m2505o(40225);
            return view;
        }
        AppMethodBeat.m2505o(40225);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    /* renamed from: O */
    private static List<String> m33744O(List<String> list) {
        AppMethodBeat.m2504i(40226);
        LinkedList linkedList = new LinkedList();
        C1720g.m3537RQ();
        if (!C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(40226);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(40226);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(40226);
            return linkedList;
        }
    }

    /* renamed from: d */
    public final View mo28313d(int i, int i2, View view) {
        C22131a c22131a;
        AppMethodBeat.m2504i(40227);
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(2130970769, null);
            } else {
                inflate = this.mInflater.inflate(2130970768, null);
            }
            C22131a c22131a2 = new C22131a(this, (byte) 0);
            c22131a2.titleView = (TextView) inflate.findViewById(2131827789);
            c22131a2.nQl = (TextView) inflate.findViewById(2131827790);
            c22131a2.rtN = (TextView) inflate.findViewById(2131827791);
            c22131a2.rtO = (TextView) inflate.findViewById(2131827792);
            c22131a2.olR = (ImageView) inflate.findViewById(2131827787);
            c22131a2.rtP = (ImageView) inflate.findViewById(2131827788);
            c22131a2.rtP.setOnClickListener(new C221301());
            inflate.setTag(c22131a2);
            c22131a = c22131a2;
            view = inflate;
        } else {
            c22131a = (C22131a) view.getTag();
        }
        ImageView imageView = c22131a.rtP;
        Object tag = imageView.getTag();
        if (tag == null || !(tag instanceof C4086c)) {
            C4086c c4086c = new C4086c();
            c4086c.rtQ = i;
            c4086c.rtR = i2;
            imageView.setTag(c4086c);
        } else {
            C4086c c4086c2 = (C4086c) imageView.getTag();
            c4086c2.rtQ = i;
            c4086c2.rtR = i2;
        }
        if (i2 == this.rtE.size()) {
            c22131a.titleView.setVisibility(8);
            c22131a.nQl.setVisibility(8);
            c22131a.olR.setVisibility(8);
            c22131a.rtP.setVisibility(8);
            c22131a.rtN.setVisibility(0);
            c22131a.rtO.setVisibility(0);
            if (i == this.rJo) {
                if (this.rtK.size() > 0) {
                    c22131a.rtO.setText("√".concat(String.valueOf(C5046bo.m7536c(C22129a.m33744O(this.rtK), ","))));
                    c22131a.rtO.setVisibility(0);
                    c22131a.rtO.setTextColor(this.mContext.getResources().getColor(C25738R.color.a0z));
                } else {
                    c22131a.rtO.setText("");
                    c22131a.rtO.setVisibility(8);
                }
            } else if (i == this.rJn) {
                if (this.rtJ.size() > 0) {
                    c22131a.rtO.setText("√".concat(String.valueOf(C5046bo.m7536c(C22129a.m33744O(this.rtJ), ","))));
                    c22131a.rtO.setVisibility(0);
                    c22131a.rtO.setTextColor(this.mContext.getResources().getColor(C25738R.color.a0y));
                } else {
                    c22131a.rtO.setText("");
                    c22131a.rtO.setVisibility(8);
                }
            }
        } else {
            CharSequence charSequence;
            c22131a.titleView.setVisibility(0);
            c22131a.nQl.setVisibility(0);
            c22131a.olR.setVisibility(0);
            c22131a.rtP.setVisibility(4);
            c22131a.rtN.setVisibility(8);
            c22131a.rtO.setVisibility(8);
            CharSequence charSequence2 = (String) this.rtE.get(i2);
            c22131a.titleView.setText(C44089j.m79292b(this.mContext, charSequence2));
            TextView textView = c22131a.nQl;
            List<String> PH = C21156a.bJa().mo41635PH(C21156a.bJa().mo41632PE(charSequence2));
            if (PH == null || PH.size() == 0) {
                charSequence = "";
            } else {
                List arrayList = new ArrayList(PH.size());
                for (String mJ : PH) {
                    arrayList.add(((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(mJ));
                }
                charSequence = C44089j.m79292b(this.mContext, C5046bo.m7536c(arrayList, ","));
            }
            textView.setText(charSequence);
            c22131a.rtP.setImageResource(C1318a.sns_label_more_btn);
            if (this.style == 1) {
                if (i == this.rJn) {
                    if (m33747bg(1, charSequence2)) {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_selected);
                    } else {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_unselected);
                    }
                } else if (i == this.rJo) {
                    if (this.rtF != i) {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_unselected_red);
                    } else {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_selected_red);
                    }
                    if (m33747bg(2, charSequence2)) {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_selected_red);
                    } else {
                        c22131a.olR.setImageResource(C1318a.sight_list_checkbox_unselected_red);
                    }
                }
            } else if (i == this.rJn) {
                if (m33747bg(1, charSequence2)) {
                    c22131a.olR.setImageResource(C1318a.checkbox_selected);
                } else {
                    c22131a.olR.setImageResource(C1318a.checkbox_unselected);
                }
            } else if (i == this.rJo) {
                if (m33747bg(2, charSequence2)) {
                    c22131a.olR.setImageResource(C1318a.checkbox_selected_red);
                } else {
                    c22131a.olR.setImageResource(C1318a.checkbox_unselected);
                }
            }
        }
        AppMethodBeat.m2505o(40227);
        return view;
    }

    /* renamed from: Ec */
    public final int mo28311Ec(int i) {
        AppMethodBeat.m2504i(40228);
        if (("visible".equals(this.rJv.get(i)) || "invisible".equals(this.rJv.get(i))) && this.rtE != null) {
            int size = this.rtE.size() + 1;
            AppMethodBeat.m2505o(40228);
            return size;
        }
        AppMethodBeat.m2505o(40228);
        return 0;
    }
}
