package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C29684b;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.a */
public class C29591a extends BaseAdapter {
    private final Context mContext;
    private int mCount = 0;
    private ArrayList<Bankcard> tll;
    private int tlm;
    C40141a tln;
    List<String> tlo;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.a$a */
    class C4361a {
        public ImageView tlA = null;
        public WalletTextView tlB = null;
        public TextView tlC = null;
        public TextView tlp = null;
        public TextView tlq = null;
        public TextView tlr = null;
        public RelativeLayout tls = null;
        public ImageView tlt = null;
        public ImageView tlu = null;
        public TextView tlv = null;
        public TextView tlw = null;
        public TextView tlx = null;
        public ImageView tly = null;
        public ImageView tlz = null;

        C4361a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(45738);
        Bankcard Hd = m46928Hd(i);
        AppMethodBeat.m2505o(45738);
        return Hd;
    }

    public C29591a(Context context, ArrayList<Bankcard> arrayList) {
        AppMethodBeat.m2504i(45732);
        this.mContext = context;
        this.tll = arrayList;
        this.tlm = 0;
        this.tln = new C40141a();
        this.tln.mo63494b(this.mContext, this.tll);
        cNr();
        AppMethodBeat.m2505o(45732);
    }

    /* renamed from: W */
    public final void mo47835W(ArrayList<Bankcard> arrayList) {
        AppMethodBeat.m2504i(45733);
        this.tll = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.tln.mo63494b(this.mContext, this.tll);
        }
        cNr();
        AppMethodBeat.m2505o(45733);
    }

    private void cNr() {
        AppMethodBeat.m2504i(45734);
        C1720g.m3537RQ();
        this.tlo = C5046bo.m7508P(((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "")).split(","));
        AppMethodBeat.m2505o(45734);
    }

    public int getCount() {
        return this.mCount;
    }

    /* renamed from: Hd */
    private Bankcard m46928Hd(int i) {
        AppMethodBeat.m2504i(45735);
        if (i < 0 || i >= this.mCount) {
            AppMethodBeat.m2505o(45735);
            return null;
        }
        Bankcard bankcard = (Bankcard) this.tll.get(i);
        AppMethodBeat.m2505o(45735);
        return bankcard;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        AppMethodBeat.m2504i(45736);
        Bankcard Hd = m46928Hd(i);
        if (Hd == null) {
            AppMethodBeat.m2505o(45736);
            return 4;
        } else if (Hd.field_bankcardState == 9) {
            if (Hd.field_wxcreditState == 0) {
                AppMethodBeat.m2505o(45736);
                return 2;
            }
            AppMethodBeat.m2505o(45736);
            return 3;
        } else if (Hd.cPb() && "CITIC_CREDIT".equals(Hd.field_bankcardType)) {
            AppMethodBeat.m2505o(45736);
            return 5;
        } else if (Hd.cPg()) {
            AppMethodBeat.m2505o(45736);
            return 6;
        } else if (!Hd.cPf() || C1853r.m3831YM()) {
            AppMethodBeat.m2505o(45736);
            return 1;
        } else {
            AppMethodBeat.m2505o(45736);
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(45737);
        Bankcard Hd = m46928Hd(i);
        if (Hd == null) {
            AppMethodBeat.m2505o(45737);
            return view;
        }
        boolean z;
        String bigDecimal;
        int itemViewType = getItemViewType(i);
        if (this.tlo == null || this.tlo.isEmpty() || Hd == null) {
            z = false;
        } else {
            for (String bigDecimal2 : this.tlo) {
                if (bigDecimal2.equals(Hd.field_bindSerial)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        C4990ab.m7419v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", Integer.valueOf(i), Hd.field_card_bottom_wording, Boolean.valueOf(z));
        C4361a c4361a;
        C4361a c4361a2;
        switch (itemViewType) {
            case 0:
                view = C29684b.m47080a(this.mContext, view, Hd, 2130971057, this.tln, z, itemViewType);
                AppMethodBeat.m2505o(45737);
                return view;
            case 1:
                view = C29684b.m47080a(this.mContext, view, Hd, 2130971064, this.tln, z, itemViewType);
                AppMethodBeat.m2505o(45737);
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, 2130971068, null);
                    c4361a = new C4361a();
                    c4361a.tlu = (ImageView) view.findViewById(2131828647);
                    c4361a.tlq = (TextView) view.findViewById(2131828648);
                    c4361a.tlx = (TextView) view.findViewById(2131828698);
                    c4361a.tly = (ImageView) view.findViewById(2131828650);
                    c4361a.tlz = (ImageView) view.findViewById(2131828651);
                    c4361a.tlA = (ImageView) view.findViewById(2131828652);
                    view.setTag(c4361a);
                    c4361a2 = c4361a;
                } else {
                    c4361a2 = (C4361a) view.getTag();
                }
                c4361a2.tlq.setText(this.mContext.getString(C25738R.string.fg8, new Object[]{Hd.field_bankName}));
                if (C22528b.m34221b(Hd)) {
                    c4361a2.tlx.setVisibility(0);
                } else {
                    c4361a2.tlx.setVisibility(8);
                }
                AppMethodBeat.m2505o(45737);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, 2130971071, null);
                    c4361a = new C4361a();
                    c4361a.tlu = (ImageView) view.findViewById(2131828647);
                    c4361a.tlq = (TextView) view.findViewById(2131828648);
                    c4361a.tlv = (TextView) view.findViewById(2131828655);
                    c4361a.tly = (ImageView) view.findViewById(2131828650);
                    c4361a.tlz = (ImageView) view.findViewById(2131828651);
                    c4361a.tlA = (ImageView) view.findViewById(2131828652);
                    view.setTag(c4361a);
                    c4361a2 = c4361a;
                } else {
                    c4361a2 = (C4361a) view.getTag();
                }
                switch (Hd.field_wxcreditState) {
                    case 1:
                        c4361a2.tlv.setBackgroundResource(C25738R.drawable.bky);
                        c4361a2.tlv.setVisibility(0);
                        break;
                    case 3:
                        c4361a2.tlv.setBackgroundResource(C25738R.drawable.bko);
                        c4361a2.tlv.setVisibility(0);
                        break;
                    default:
                        c4361a2.tlv.setVisibility(8);
                        break;
                }
                c4361a2.tlq.setText(Hd.field_bankName);
                this.tln.mo63491a(this.mContext, Hd, c4361a2.tlu);
                AppMethodBeat.m2505o(45737);
                return view;
            case 4:
                view = View.inflate(this.mContext, 2130971058, null);
                AppMethodBeat.m2505o(45737);
                return view;
            case 5:
                view = C29684b.m47080a(this.mContext, view, Hd, 2130971069, this.tln, z, itemViewType);
                AppMethodBeat.m2505o(45737);
                return view;
            case 6:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, 2130971062, null);
                    c4361a = new C4361a();
                    c4361a.tlu = (ImageView) view.findViewById(2131828647);
                    c4361a.tlq = (TextView) view.findViewById(2131828648);
                    c4361a.tlr = (TextView) view.findViewById(2131828649);
                    c4361a.tlv = (TextView) view.findViewById(2131828655);
                    c4361a.tlB = (WalletTextView) view.findViewById(2131828679);
                    c4361a.tlt = (ImageView) view.findViewById(2131828646);
                    c4361a.tlC = (TextView) view.findViewById(2131828680);
                    view.setTag(c4361a);
                } else {
                    c4361a = (C4361a) view.getTag();
                }
                c4361a.tlu.setImageDrawable(C5147a.m7837f(this.mContext.getResources(), C1318a.honey_pay_bank_logo));
                if ((c4361a.tlu instanceof CdnImageView) && !C5046bo.isNullOrNil(Hd.txk)) {
                    ((CdnImageView) c4361a.tlu).setUseSdcardCache(true);
                    ((CdnImageView) c4361a.tlu).setImgSavedPath(C46362b.cRb());
                    ((CdnImageView) c4361a.tlu).mo38952eb(Hd.txk, C1318a.honey_pay_bank_logo);
                }
                c4361a.tlq.setText(C44089j.m79293b(this.mContext, C36391e.m60007eK(C36391e.m60015mJ(Hd.txg), 10), c4361a.tlq.getTextSize()));
                c4361a.tlr.setText(Hd.txj);
                if (Hd.txh == 0) {
                    bigDecimal2 = C36391e.m59981a(Hd.txf, "100", 2, RoundingMode.HALF_UP).toString();
                    c4361a.tlB.setPrefix(C44423ae.dOd());
                    c4361a.tlB.setText(bigDecimal2);
                    c4361a.tlB.setVisibility(0);
                    c4361a.tlC.setVisibility(0);
                } else {
                    c4361a.tlB.setVisibility(4);
                    c4361a.tlC.setVisibility(4);
                }
                AppMethodBeat.m2505o(45737);
                return view;
            default:
                AppMethodBeat.m2505o(45737);
                return view;
        }
    }
}
