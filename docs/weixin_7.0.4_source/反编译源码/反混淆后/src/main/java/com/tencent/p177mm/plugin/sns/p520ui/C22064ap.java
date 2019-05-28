package com.tencent.p177mm.plugin.sns.p520ui;

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

/* renamed from: com.tencent.mm.plugin.sns.ui.ap */
public final class C22064ap extends C16004a {
    public static int[] rtD = new int[]{C25738R.string.ely, C25738R.string.elw, C25738R.string.els, C25738R.string.ell};
    public static int[] rth = new int[]{C25738R.string.elx, C25738R.string.elv, C25738R.string.elr, C25738R.string.elk};
    private Context mContext;
    private LayoutInflater mInflater;
    ArrayList<String> rtE;
    public int rtF = 0;
    public boolean rtG = false;
    public ArrayList<String> rtH = new ArrayList();
    public ArrayList<String> rtI = new ArrayList();
    public ArrayList<String> rtJ = new ArrayList();
    public ArrayList<String> rtK = new ArrayList();
    C22063b rtL = null;
    public int style;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ap$1 */
    class C136281 implements OnClickListener {
        C136281() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39049);
            C22065c c22065c = (view.getTag() == null || !(view.getTag() instanceof C22065c)) ? null : (C22065c) view.getTag();
            if (c22065c == null) {
                C4990ab.m7420w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
                AppMethodBeat.m2505o(39049);
                return;
            }
            if (C22064ap.this.rtL != null) {
                C22064ap.this.rtL.mo37618a(c22065c);
            }
            AppMethodBeat.m2505o(39049);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ap$b */
    public interface C22063b {
        /* renamed from: a */
        void mo37618a(C22065c c22065c);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ap$c */
    class C22065c {
        public int rtQ;
        public int rtR;

        C22065c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ap$a */
    class C22066a {
        TextView nQl;
        ImageView olR;
        TextView rtN;
        TextView rtO;
        ImageView rtP;
        TextView titleView;

        private C22066a() {
        }

        /* synthetic */ C22066a(C22064ap c22064ap, byte b) {
            this();
        }
    }

    public C22064ap(Context context) {
        AppMethodBeat.m2504i(39050);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.m2505o(39050);
    }

    public final Object getChild(int i, int i2) {
        AppMethodBeat.m2504i(39051);
        Object obj = this.rtE.get(i2);
        AppMethodBeat.m2505o(39051);
        return obj;
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    /* renamed from: T */
    public final void mo37619T(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(39052);
        List<String> ctC = C22064ap.ctC();
        List arrayList2 = new ArrayList();
        if (!(ctC == null || arrayList == null)) {
            for (String str : ctC) {
                if (C22064ap.m33686h(arrayList, str)) {
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
        AppMethodBeat.m2505o(39052);
    }

    private static List<String> ctC() {
        AppMethodBeat.m2504i(39053);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(335875, null);
        C4990ab.m7411d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(39053);
            return null;
        }
        List<String> P = C5046bo.m7508P(str.split(","));
        AppMethodBeat.m2505o(39053);
        return P;
    }

    /* renamed from: ZF */
    public static void m33683ZF(String str) {
        AppMethodBeat.m2504i(39054);
        C4990ab.m7411d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", str);
        if (C22064ap.ctC() != null) {
            List arrayList = new ArrayList(C22064ap.ctC());
            if (!C22064ap.m33686h(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                Object c = C5046bo.m7536c(arrayList, ",");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(335875, c);
            }
            AppMethodBeat.m2505o(39054);
            return;
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(335875, (Object) str);
        AppMethodBeat.m2505o(39054);
    }

    /* renamed from: h */
    private static boolean m33686h(List<String> list, String str) {
        AppMethodBeat.m2504i(39055);
        for (String equals : list) {
            if (equals.equals(str)) {
                AppMethodBeat.m2505o(39055);
                return true;
            }
        }
        AppMethodBeat.m2505o(39055);
        return false;
    }

    /* renamed from: bg */
    private boolean m33685bg(int i, String str) {
        AppMethodBeat.m2504i(39056);
        boolean h;
        if (i == 1) {
            h = C22064ap.m33686h(this.rtH, str);
            AppMethodBeat.m2505o(39056);
            return h;
        }
        h = C22064ap.m33686h(this.rtI, str);
        AppMethodBeat.m2505o(39056);
        return h;
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C22066a c22066a;
        AppMethodBeat.m2504i(39057);
        if (view == null || !(view.getTag() instanceof C22066a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(2130970771, null);
            } else {
                inflate = this.mInflater.inflate(2130970770, null);
            }
            C22066a c22066a2 = new C22066a(this, (byte) 0);
            c22066a2.titleView = (TextView) inflate.findViewById(2131827789);
            c22066a2.olR = (ImageView) inflate.findViewById(2131827787);
            c22066a2.nQl = (TextView) inflate.findViewById(2131827790);
            inflate.setTag(c22066a2);
            view = inflate;
            c22066a = c22066a2;
        } else {
            c22066a = (C22066a) view.getTag();
        }
        c22066a.titleView.setText(rth[i]);
        c22066a.nQl.setText(rtD[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.rtF == i) {
                    c22066a.olR.setImageResource(C1318a.radio_on);
                    c22066a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
                    break;
                }
                c22066a.olR.setImageResource(C1318a.radio_off);
                break;
            case 2:
                if (this.rtF == i) {
                    c22066a.olR.setImageResource(C1318a.radio_on);
                    c22066a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
                    break;
                }
                c22066a.olR.setImageResource(C1318a.radio_off);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.rtF == i) {
                        c22066a.olR.setImageResource(C1318a.radio_on_red);
                        c22066a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
                        break;
                    }
                    c22066a.olR.setImageResource(C1318a.radio_off);
                    break;
                } else if (this.rtF == i) {
                    c22066a.olR.setImageResource(C1318a.round_selector_checked_orange);
                    c22066a.olR.setContentDescription(this.mContext.getString(C25738R.string.e2_));
                    break;
                } else {
                    c22066a.olR.setImageResource(C1318a.radio_off);
                    break;
                }
        }
        if (this.rtG && i == 1) {
            view = new View(this.mContext);
            view.setVisibility(8);
            AppMethodBeat.m2505o(39057);
            return view;
        }
        AppMethodBeat.m2505o(39057);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    /* renamed from: O */
    private static List<String> m33682O(List<String> list) {
        AppMethodBeat.m2504i(39058);
        LinkedList linkedList = new LinkedList();
        C1720g.m3537RQ();
        if (!C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(39058);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(39058);
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
            AppMethodBeat.m2505o(39058);
            return linkedList;
        }
    }

    /* renamed from: d */
    public final View mo28313d(int i, int i2, View view) {
        C22066a c22066a;
        AppMethodBeat.m2504i(39059);
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(2130970769, null);
            } else {
                inflate = this.mInflater.inflate(2130970768, null);
            }
            C22066a c22066a2 = new C22066a(this, (byte) 0);
            c22066a2.titleView = (TextView) inflate.findViewById(2131827789);
            c22066a2.nQl = (TextView) inflate.findViewById(2131827790);
            c22066a2.rtN = (TextView) inflate.findViewById(2131827791);
            c22066a2.rtO = (TextView) inflate.findViewById(2131827792);
            c22066a2.olR = (ImageView) inflate.findViewById(2131827787);
            c22066a2.rtP = (ImageView) inflate.findViewById(2131827788);
            c22066a2.rtP.setOnClickListener(new C136281());
            inflate.setTag(c22066a2);
            c22066a = c22066a2;
            view = inflate;
        } else {
            c22066a = (C22066a) view.getTag();
        }
        ImageView imageView = c22066a.rtP;
        Object tag = imageView.getTag();
        if (tag == null || !(tag instanceof C22065c)) {
            C22065c c22065c = new C22065c();
            c22065c.rtQ = i;
            c22065c.rtR = i2;
            imageView.setTag(c22065c);
        } else {
            C22065c c22065c2 = (C22065c) imageView.getTag();
            c22065c2.rtQ = i;
            c22065c2.rtR = i2;
        }
        if (i2 == this.rtE.size()) {
            c22066a.titleView.setVisibility(8);
            c22066a.nQl.setVisibility(8);
            c22066a.olR.setVisibility(8);
            c22066a.rtP.setVisibility(8);
            c22066a.rtN.setVisibility(0);
            c22066a.rtO.setVisibility(0);
            if (i == 3) {
                if (this.rtK.size() > 0) {
                    c22066a.rtO.setText("√".concat(String.valueOf(C5046bo.m7536c(C22064ap.m33682O(this.rtK), ","))));
                    c22066a.rtO.setVisibility(0);
                    c22066a.rtO.setTextColor(this.mContext.getResources().getColor(C25738R.color.a0z));
                } else {
                    c22066a.rtO.setText("");
                    c22066a.rtO.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.rtJ.size() > 0) {
                    c22066a.rtO.setText("√".concat(String.valueOf(C5046bo.m7536c(C22064ap.m33682O(this.rtJ), ","))));
                    c22066a.rtO.setVisibility(0);
                    c22066a.rtO.setTextColor(this.mContext.getResources().getColor(C25738R.color.a0y));
                } else {
                    c22066a.rtO.setText("");
                    c22066a.rtO.setVisibility(8);
                }
            }
        } else {
            CharSequence charSequence;
            c22066a.titleView.setVisibility(0);
            c22066a.nQl.setVisibility(0);
            c22066a.olR.setVisibility(0);
            c22066a.rtP.setVisibility(0);
            c22066a.rtN.setVisibility(8);
            c22066a.rtO.setVisibility(8);
            CharSequence charSequence2 = (String) this.rtE.get(i2);
            c22066a.titleView.setText(C44089j.m79292b(this.mContext, charSequence2));
            TextView textView = c22066a.nQl;
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
            c22066a.rtP.setImageResource(C1318a.sns_label_more_btn);
            if (this.style == 1) {
                if (i == 2) {
                    if (m33685bg(1, charSequence2)) {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_selected);
                    } else {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_unselected);
                    }
                } else if (i == 3) {
                    if (this.rtF != i) {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_unselected_red);
                    } else {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_selected_red);
                    }
                    if (m33685bg(2, charSequence2)) {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_selected_red);
                    } else {
                        c22066a.olR.setImageResource(C1318a.sight_list_checkbox_unselected_red);
                    }
                }
            } else if (i == 2) {
                if (m33685bg(1, charSequence2)) {
                    c22066a.olR.setImageResource(C1318a.checkbox_selected);
                } else {
                    c22066a.olR.setImageResource(C1318a.checkbox_unselected);
                }
            } else if (i == 3) {
                if (m33685bg(2, charSequence2)) {
                    c22066a.olR.setImageResource(C1318a.checkbox_selected_red);
                } else {
                    c22066a.olR.setImageResource(C1318a.checkbox_unselected);
                }
            }
        }
        AppMethodBeat.m2505o(39059);
        return view;
    }

    /* renamed from: Ec */
    public final int mo28311Ec(int i) {
        AppMethodBeat.m2504i(39060);
        if (i <= 1 || this.rtE == null) {
            AppMethodBeat.m2505o(39060);
            return 0;
        }
        int size = this.rtE.size() + 1;
        AppMethodBeat.m2505o(39060);
        return size;
    }
}
