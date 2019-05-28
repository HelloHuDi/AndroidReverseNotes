package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.i */
public final class C32961i extends BaseAdapter {
    private Context context;
    public List<String[]> gsD;
    public int[] gty;
    public LinkedList<aym> gvi = new LinkedList();
    private LinkedList<aym> gvj = new LinkedList();
    private List<String[]> gvk = new LinkedList();
    private C1983a gvl;
    public C36043b gvm = new C36043b(new C329621());
    private C23577b gvn = null;
    int showType = 1;

    /* renamed from: com.tencent.mm.plugin.account.friend.a.i$a */
    public interface C1983a {
        void notifyDataSetChanged();
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.a.i$b */
    static class C1984b {
        TextView gtG;
        ImageView gvq;
        TextView gvr;
        Button gvs;
        Button gvt;
        TextView gvu;
        TextView gvv;

        C1984b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.a.i$1 */
    class C329621 implements C5234a {
        C329621() {
        }

        /* renamed from: wd */
        public final Bitmap mo10738wd(String str) {
            AppMethodBeat.m2504i(108338);
            Bitmap a = C41730b.m73490a(str, false, -1);
            AppMethodBeat.m2505o(108338);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.a.i$2 */
    class C329632 implements C23577b {
        C329632() {
        }

        /* renamed from: mW */
        public final String mo11090mW(int i) {
            AppMethodBeat.m2504i(108339);
            if (i < 0 || i >= C32961i.this.getCount()) {
                C4990ab.m7412e("MicroMsg.FriendAdapter", "pos is invalid");
                AppMethodBeat.m2505o(108339);
                return null;
            }
            aym mV = C32961i.this.mo53524mV(i);
            if (mV == null) {
                AppMethodBeat.m2505o(108339);
                return null;
            }
            String str = mV.jBB;
            AppMethodBeat.m2505o(108339);
            return str;
        }

        public final int apO() {
            AppMethodBeat.m2504i(108340);
            int count = C32961i.this.getCount();
            AppMethodBeat.m2505o(108340);
            return count;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(108355);
        aym mV = mo53524mV(i);
        AppMethodBeat.m2505o(108355);
        return mV;
    }

    public C32961i(Context context, C1983a c1983a, int i) {
        AppMethodBeat.m2504i(108344);
        this.context = context;
        this.showType = i;
        this.gvl = c1983a;
        this.gty = new int[this.gvi.size()];
        AppMethodBeat.m2505o(108344);
    }

    public final int getSelectCount() {
        int i = 0;
        for (int i2 : this.gty) {
            if (this.showType == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.showType == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean apN() {
        if (this.gty == null || this.gty.length == 0) {
            return false;
        }
        for (int i : this.gty) {
            if (this.showType == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.showType == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: mU */
    public final void mo53523mU(int i) {
        AppMethodBeat.m2504i(108345);
        if (this.showType == 1) {
            this.gty[i] = 1;
        } else if (this.showType == 2) {
            this.gty[i] = 2;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(108345);
    }

    /* renamed from: dl */
    public final void mo53517dl(boolean z) {
        AppMethodBeat.m2504i(108346);
        int i;
        int i2;
        if (this.showType == 1) {
            for (i = 0; i < this.gty.length; i++) {
                int[] iArr = this.gty;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.showType == 2) {
            for (i = 0; i < this.gty.length; i++) {
                int[] iArr2 = this.gty;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(108346);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(108347);
        super.notifyDataSetChanged();
        if (this.gvl != null) {
            this.gvl.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(108347);
    }

    /* renamed from: r */
    public final void mo53526r(LinkedList<aym> linkedList) {
        AppMethodBeat.m2504i(108348);
        if (linkedList != null) {
            this.gvj.clear();
            this.gvi.clear();
            this.gvk.clear();
            for (String[] strArr : this.gsD) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aym aym = (aym) it.next();
                    if (this.showType == 1) {
                        if ((aym.jBT == 1 || aym.jBT == 0) && !C5046bo.isNullOrNil(strArr[2]) && aym.pXM.equals(C1178g.m2591x(strArr[2].getBytes()))) {
                            m53885a(aym, strArr);
                        }
                    } else if (this.showType == 2 && aym.jBT == 2 && !C5046bo.isNullOrNil(strArr[2]) && aym.pXM.equals(C1178g.m2591x(strArr[2].getBytes()))) {
                        m53885a(aym, strArr);
                    }
                }
            }
        }
        this.gty = new int[this.gvj.size()];
        this.gvi.addAll(this.gvj);
        this.gvj.clear();
        AppMethodBeat.m2505o(108348);
    }

    /* renamed from: a */
    private void m53885a(aym aym, String[] strArr) {
        AppMethodBeat.m2504i(108349);
        Iterator it = this.gvj.iterator();
        while (it.hasNext()) {
            aym aym2 = (aym) it.next();
            if (aym2.pXM != null && aym.pXM != null && aym2.pXM.equals(aym.pXM)) {
                C4990ab.m7410d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                AppMethodBeat.m2505o(108349);
                return;
            }
        }
        this.gvj.add(aym);
        this.gvk.add(new String[]{strArr[2], strArr[1]});
        AppMethodBeat.m2505o(108349);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(108350);
        int size = this.gvi.size();
        AppMethodBeat.m2505o(108350);
        return size;
    }

    /* renamed from: mV */
    public final aym mo53524mV(int i) {
        AppMethodBeat.m2504i(108351);
        aym aym = (aym) this.gvi.get(i);
        AppMethodBeat.m2505o(108351);
        return aym;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(108352);
        long hashCode = (long) ((aym) this.gvi.get(i)).hashCode();
        AppMethodBeat.m2505o(108352);
        return hashCode;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C1984b c1984b;
        AppMethodBeat.m2504i(108353);
        if (this.showType == 1) {
            if (this.gvn == null) {
                this.gvn = new C329632();
            }
            if (this.gvm != null) {
                this.gvm.mo56803a(i, this.gvn);
            }
        }
        aym aym = (aym) this.gvi.get(i);
        if (view == null) {
            c1984b = new C1984b();
            if (this.showType == 1) {
                view = View.inflate(this.context, 2130969550, null);
                c1984b.gtG = (TextView) view.findViewById(2131824020);
                c1984b.gvr = (TextView) view.findViewById(2131824025);
                c1984b.gvs = (Button) view.findViewById(2131824023);
                c1984b.gvt = (Button) view.findViewById(2131824024);
                c1984b.gvq = (ImageView) view.findViewById(2131824019);
                c1984b.gvu = (TextView) view.findViewById(2131824021);
                c1984b.gvv = (TextView) view.findViewById(2131824022);
                view.setTag(c1984b);
            } else if (this.showType == 2) {
                view = View.inflate(this.context, 2130969551, null);
                c1984b.gtG = (TextView) view.findViewById(2131824020);
                c1984b.gvr = (TextView) view.findViewById(2131824025);
                c1984b.gvs = (Button) view.findViewById(2131824023);
                c1984b.gvt = (Button) view.findViewById(2131824024);
                c1984b.gvu = (TextView) view.findViewById(2131824021);
                c1984b.gvv = (TextView) view.findViewById(2131824022);
                view.setTag(c1984b);
            }
        } else {
            c1984b = (C1984b) view.getTag();
        }
        c1984b.gvv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(108341);
                C32961i c32961i = C32961i.this;
                int i = i;
                if (c32961i.showType == 1) {
                    c32961i.gty[i] = 0;
                } else if (c32961i.showType == 2) {
                    c32961i.gty[i] = 0;
                }
                c32961i.notifyDataSetChanged();
                AppMethodBeat.m2505o(108341);
            }
        });
        if (this.showType == 1) {
            if (!C5046bo.isNullOrNil(((String[]) this.gvk.get(i))[1])) {
                c1984b.gtG.setText(((String[]) this.gvk.get(i))[1]);
            } else if (C5046bo.isNullOrNil(aym.jCH)) {
                c1984b.gtG.setText(aym.jBB);
            } else {
                c1984b.gtG.setText(aym.jCH);
            }
            c1984b.gvs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(108342);
                    C32961i.this.mo53523mU(i);
                    AppMethodBeat.m2505o(108342);
                }
            });
            C40460b.m69434b(c1984b.gvq, aym.jBB);
        } else if (this.showType == 2) {
            c1984b.gtG.setText(((String[]) this.gvk.get(i))[1]);
            c1984b.gvt.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(108343);
                    C32961i.this.mo53523mU(i);
                    AppMethodBeat.m2505o(108343);
                }
            });
        }
        switch (this.gty[i]) {
            case 0:
                if (this.showType != 1) {
                    if (this.showType == 2) {
                        c1984b.gvr.setVisibility(8);
                        c1984b.gvs.setVisibility(8);
                        c1984b.gvt.setVisibility(0);
                        c1984b.gvu.setVisibility(8);
                        c1984b.gvv.setVisibility(8);
                        break;
                    }
                }
                c1984b.gvr.setVisibility(8);
                c1984b.gvs.setVisibility(0);
                c1984b.gvt.setVisibility(8);
                c1984b.gvu.setVisibility(8);
                c1984b.gvv.setVisibility(8);
                break;
                break;
            case 1:
                c1984b.gvs.setVisibility(8);
                c1984b.gvr.setVisibility(0);
                c1984b.gvu.setVisibility(0);
                c1984b.gvv.setVisibility(0);
                break;
            case 2:
                c1984b.gvs.setVisibility(8);
                c1984b.gvt.setVisibility(8);
                c1984b.gvr.setVisibility(0);
                c1984b.gvu.setVisibility(0);
                c1984b.gvv.setVisibility(0);
                break;
            case 3:
                c1984b.gvs.setVisibility(8);
                c1984b.gvr.setVisibility(0);
                c1984b.gvu.setVisibility(0);
                c1984b.gvv.setVisibility(0);
                break;
        }
        AppMethodBeat.m2505o(108353);
        return view;
    }

    /* renamed from: wc */
    public final void mo53527wc(String str) {
        AppMethodBeat.m2504i(108354);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gvk.size(); i++) {
            if (this.gty[i] == 2) {
                arrayList.add(((String[]) this.gvk.get(i))[0]);
            }
        }
        C1720g.m3540Rg().mo14541a(new C45495ai(str, arrayList), 0);
        AppMethodBeat.m2505o(108354);
    }
}
