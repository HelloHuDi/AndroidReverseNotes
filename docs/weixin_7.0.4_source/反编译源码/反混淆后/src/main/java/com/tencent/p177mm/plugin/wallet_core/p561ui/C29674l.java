package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MaxListView;
import com.tencent.p177mm.plugin.wallet.p748a.C43758t;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet.p748a.C7174f;
import com.tencent.p177mm.plugin.wallet.p748a.C7176h;
import com.tencent.p177mm.plugin.wallet_core.model.C40116p;
import com.tencent.p177mm.plugin.wallet_core.model.C40116p.C14238a;
import com.tencent.p177mm.plugin.wallet_core.model.C40116p.C29637b;
import com.tencent.p177mm.plugin.wallet_core.model.C40116p.C401151;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.l */
public final class C29674l extends C15532i {
    private View jcl;
    private LayoutInflater mInflater;
    private MaxListView tHB = ((MaxListView) this.jcl.findViewById(2131828792));
    private TextView tHC = ((TextView) this.jcl.findViewById(2131828791));
    private C29675a tHD = new C29675a();
    private C22625b tHE;
    private C22621b tpu;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$2 */
    class C143142 implements OnItemClickListener {
        C143142() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47378);
            C29675a b = C29674l.this.tHD;
            C40116p c40116p = b.tHJ;
            if (i < c40116p.tzD.size()) {
                C14238a c14238a = ((C29637b) c40116p.tzD.get(i)).tzL;
                C14238a c14238a2 = C14238a.CHECKED;
                for (int i2 = 0; i2 < c40116p.tzD.size(); i2++) {
                    c40116p.mo63448a(i2, C14238a.UNCHECKED);
                }
                switch (C401151.tzF[c14238a.ordinal()]) {
                    case 1:
                        c40116p.mo63448a(i, C14238a.CHECKED);
                        break;
                    case 2:
                        c40116p.mo63448a(i, C14238a.UNCHECKED);
                        break;
                }
            }
            b.notifyDataSetChanged();
            AppMethodBeat.m2505o(47378);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$b */
    public interface C22625b {
        /* renamed from: a */
        void mo9492a(FavorPayInfo favorPayInfo);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$c */
    static final class C22626c {
        TextView iDT;
        TextView kEq;
        TextView kiF;
        View tHL;
        ImageView tHM;
        CheckBox tHN;

        C22626c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$1 */
    class C296731 implements OnClickListener {
        C296731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47377);
            C29674l.m47061a(C29674l.this);
            C29674l.this.dismiss();
            AppMethodBeat.m2505o(47377);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$a */
    class C29675a extends BaseAdapter {
        int tHG = -1;
        List<C43758t> tHH = new LinkedList();
        C46330j tHI = null;
        C40116p<String> tHJ = new C296761();

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.l$a$1 */
        class C296761 extends C40116p<String> {
            C296761() {
            }

            /* renamed from: a */
            public final String mo47928a(Vector<C29637b> vector, int i) {
                AppMethodBeat.m2504i(47379);
                String str;
                if (vector == null) {
                    C4990ab.m7420w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    str = "";
                    AppMethodBeat.m2505o(47379);
                    return str;
                }
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= vector.size()) {
                        break;
                    }
                    C14238a c14238a = ((C29637b) vector.get(i3)).tzL;
                    if (i3 == i || c14238a == C14238a.CHECKED) {
                        stringBuilder.append(((String) ((C29637b) vector.get(i3)).tzK) + "-");
                    }
                    i2 = i3 + 1;
                }
                if (stringBuilder.length() == 0) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    AppMethodBeat.m2505o(47379);
                    return str;
                }
                if (stringBuilder.length() > 1) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                str = stringBuilder.toString();
                AppMethodBeat.m2505o(47379);
                return str;
            }
        }

        public C29675a() {
            AppMethodBeat.m2504i(47380);
            AppMethodBeat.m2505o(47380);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47381);
            int size = this.tHH.size();
            AppMethodBeat.m2505o(47381);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(47382);
            Object obj = this.tHH.get(i);
            AppMethodBeat.m2505o(47382);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C22626c c22626c;
            C7174f c7174f;
            String str;
            String str2;
            AppMethodBeat.m2504i(47383);
            if (view == null) {
                view = C29674l.this.mInflater.inflate(2130971085, viewGroup, false);
                C22626c c22626c2 = new C22626c();
                c22626c2.tHL = view.findViewById(2131828761);
                c22626c2.iDT = (TextView) view.findViewById(2131828763);
                c22626c2.kiF = (TextView) view.findViewById(2131828764);
                c22626c2.kEq = (TextView) view.findViewById(2131828765);
                c22626c2.tHN = (CheckBox) view.findViewById(2131828766);
                c22626c2.tHM = (ImageView) view.findViewById(2131828762);
                view.setTag(c22626c2);
                c22626c = c22626c2;
            } else {
                c22626c = (C22626c) view.getTag();
            }
            C43758t c43758t = (C43758t) getItem(i);
            if (i != this.tHG || this.tHG <= 0) {
                c22626c.tHL.setVisibility(8);
                c22626c.tHM.setVisibility(0);
            } else {
                c22626c.tHL.setVisibility(0);
                c22626c.tHM.setVisibility(8);
            }
            if (C5046bo.isNullOrNil(c43758t.tnN)) {
                c22626c.iDT.setVisibility(8);
            } else {
                c22626c.iDT.setText(c43758t.tnN);
                c22626c.iDT.setVisibility(0);
            }
            String str3 = c43758t.tmO;
            if (!(this.tHI == null || this.tHI.tnm == null)) {
                LinkedList linkedList = this.tHI.tnm;
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    if (str3.equals(((C7174f) linkedList.get(i2)).tmO)) {
                        c7174f = (C7174f) linkedList.get(i2);
                        break;
                    }
                }
            }
            c7174f = null;
            String str4 = c43758t.tmP;
            str3 = c43758t.tmQ;
            if (c7174f != null) {
                str = c7174f.tmP;
                str2 = c7174f.tmQ;
            } else {
                str = str4;
                str2 = str3;
            }
            if (C5046bo.isNullOrNil(str)) {
                c22626c.kiF.setVisibility(8);
            } else {
                c22626c.kiF.setText(str);
                c22626c.kiF.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(str2)) {
                c22626c.kEq.setVisibility(8);
            } else {
                c22626c.kEq.setText(str2);
                c22626c.kEq.setVisibility(0);
            }
            C14238a c14238a = ((C29637b) this.tHJ.tzD.get(i)).tzL;
            if (c14238a == C14238a.DISABLED) {
                c22626c.tHN.setChecked(false);
                c22626c.tHN.setEnabled(false);
            } else {
                c22626c.tHN.setEnabled(true);
                if (c14238a == C14238a.CHECKED) {
                    c22626c.tHN.setChecked(true);
                } else {
                    c22626c.tHN.setChecked(false);
                }
            }
            AppMethodBeat.m2505o(47383);
            return view;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m47061a(C29674l c29674l) {
        AppMethodBeat.m2504i(47391);
        c29674l.cRC();
        AppMethodBeat.m2505o(47391);
    }

    private C29674l(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(47384);
        this.mInflater = LayoutInflater.from(context);
        this.jcl = LayoutInflater.from(context).inflate(2130971093, null);
        this.tHB.setAdapter(this.tHD);
        this.jcl.findViewById(2131828793).setOnClickListener(new C296731());
        AppMethodBeat.m2505o(47384);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47385);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.m2505o(47385);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(47386);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(47386);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(47386);
        }
    }

    /* renamed from: a */
    public static C29674l m47060a(Context context, Orders orders, String str, C22625b c22625b, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(47387);
        C29674l c29674l = new C29674l(context);
        c29674l.setOnCancelListener(onCancelListener);
        c29674l.setCancelable(true);
        c29674l.setCanceledOnTouchOutside(false);
        c29674l.tpu = C29666c.tDU.mo47919a(orders);
        if (c29674l.tpu == null) {
            C4990ab.m7420w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            c29674l.dismiss();
        } else {
            int i;
            Object obj;
            C29675a c29675a = c29674l.tHD;
            C7176h c7176h = C29674l.this.tpu.tDO;
            String acY = C29674l.this.tpu.acY(str);
            c29675a.tHH = C29674l.this.tpu.cRl();
            c29675a.tHI = C29674l.this.tpu.acU(acY);
            c29675a.tHG = -1;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= c29675a.tHH.size()) {
                    break;
                }
                if (((C43758t) c29675a.tHH.get(i)).tnR != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    c29675a.tHG = i;
                    break;
                }
                i2 = i + 1;
            }
            LinkedList linkedList = new LinkedList();
            if (c29675a.tHH != null) {
                i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= c29675a.tHH.size()) {
                        break;
                    }
                    linkedList.add(((C43758t) c29675a.tHH.get(i)).tmO);
                    i2 = i + 1;
                }
                LinkedList linkedList2 = new LinkedList();
                if (c7176h != null && c7176h.tmV != null) {
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= c7176h.tmV.size()) {
                            break;
                        }
                        String str2 = ((C43758t) c7176h.tmV.get(i)).tmO;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                        i2 = i + 1;
                    }
                }
                LinkedList linkedList3 = new LinkedList();
                if (c7176h == null || c7176h.tmW == null || c7176h.tmW.tni == null) {
                    C4990ab.m7420w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    LinkedList linkedList4 = c7176h.tmW.tni;
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= linkedList4.size()) {
                            break;
                        }
                        String str3 = ((C46330j) linkedList4.get(i)).tnk;
                        i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= linkedList2.size()) {
                                obj = null;
                                break;
                            } else if (str3.contains((CharSequence) linkedList2.get(i3))) {
                                obj = 1;
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                        i2 = i + 1;
                    }
                    LinkedList linkedList5 = new LinkedList();
                    if (!(C5046bo.isNullOrNil(acY) || acY.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        String[] split = acY.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList5.add(add);
                            }
                        } else {
                            C4990ab.m7420w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    c29675a.tHJ.mo63449d(linkedList, linkedList5, linkedList3);
                    obj = 1;
                }
            } else {
                C4990ab.m7420w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                C4990ab.m7420w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                c29674l.dismiss();
            } else {
                c29674l.tHC.setText(C25738R.string.fes);
                c29674l.tHB.setOnItemClickListener(new C143142());
            }
        }
        c29674l.tHE = c22625b;
        c29674l.show();
        C30379h.m48455a(context, c29674l);
        AppMethodBeat.m2505o(47387);
        return c29674l;
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(47388);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.m2505o(47388);
    }

    private void cRC() {
        AppMethodBeat.m2504i(47389);
        C4990ab.m7410d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.tHD != null) {
            C40116p c40116p = this.tHD.tHJ;
            this.tHE.mo9492a(this.tpu.acX(c40116p.mo47928a(c40116p.tzD, -1)));
        }
        AppMethodBeat.m2505o(47389);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47390);
        if (i == 4) {
            cRC();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47390);
        return onKeyUp;
    }
}
