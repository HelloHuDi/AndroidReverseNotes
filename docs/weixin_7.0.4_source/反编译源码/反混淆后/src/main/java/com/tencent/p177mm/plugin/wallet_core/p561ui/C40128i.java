package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.p748a.C29527o;
import com.tencent.p177mm.plugin.wallet.p748a.C35391c;
import com.tencent.p177mm.plugin.wallet.p748a.C35392d;
import com.tencent.p177mm.plugin.wallet.p748a.C35396n;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletChangeBankcardUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.FavourLayout;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.i */
public class C40128i extends BaseAdapter {
    private Context mContext;
    private Orders pWy = null;
    private int tGK = -1;
    public String tGL = "";
    public boolean tGM = true;
    private boolean tGN = false;
    protected ArrayList<Bankcard> tgB;
    private C40141a tln;
    private int toE;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.i$a */
    class C4453a {
        public TextView gne;
        public TextView pnu;
        public FavourLayout tGP;
        public CheckedTextView tGQ;
        public CdnImageView tGR;

        C4453a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.i$1 */
    class C401291 implements OnClickListener {
        C401291() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47312);
            if (view.getTag() instanceof String) {
                Intent intent = new Intent();
                C4990ab.m7417i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", (String) view.getTag());
                intent.putExtra("rawUrl", r0);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                intent.putExtra("pay_channel", 1);
                C25985d.m41468b(C40128i.this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.toB);
            }
            AppMethodBeat.m2505o(47312);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(47320);
        Bankcard Hd = mo63458Hd(i);
        AppMethodBeat.m2505o(47320);
        return Hd;
    }

    public C40128i(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        AppMethodBeat.m2504i(47313);
        this.mContext = context;
        this.tgB = arrayList;
        this.toE = i;
        this.pWy = orders;
        this.tln = new C40141a();
        this.tln.mo63494b(this.mContext, this.tgB);
        if (orders != null && orders.tAy == 1) {
            this.tGN = true;
        }
        AppMethodBeat.m2505o(47313);
    }

    public int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(47314);
        if (!this.tGN) {
            if (this.pWy == null || !this.pWy.tAm.equals("CFT")) {
                i = 1;
            }
            if (this.tgB != null) {
                i += this.tgB.size();
                AppMethodBeat.m2505o(47314);
                return i;
            }
            AppMethodBeat.m2505o(47314);
            return i;
        } else if (this.tgB == null) {
            AppMethodBeat.m2505o(47314);
            return 0;
        } else {
            i = this.tgB.size();
            AppMethodBeat.m2505o(47314);
            return i;
        }
    }

    /* renamed from: Hd */
    public Bankcard mo63458Hd(int i) {
        AppMethodBeat.m2504i(47315);
        Bankcard bankcard;
        if (this.tGN) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.m2505o(47315);
            return bankcard;
        }
        int count = getCount();
        if (this.pWy == null || !this.pWy.tAm.equals("CFT")) {
            count--;
        }
        if (i < count) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.m2505o(47315);
            return bankcard;
        }
        AppMethodBeat.m2505o(47315);
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        AppMethodBeat.m2504i(47316);
        Bankcard Hd = mo63458Hd(i);
        if (Hd == null) {
            AppMethodBeat.m2505o(47316);
            return true;
        } else if (Hd.mo69481a(this.toE, this.pWy) != 0) {
            AppMethodBeat.m2505o(47316);
            return false;
        } else {
            AppMethodBeat.m2505o(47316);
            return true;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4453a c4453a;
        AppMethodBeat.m2504i(47317);
        if (view == null) {
            view = View.inflate(this.mContext, 2130971080, null);
            c4453a = new C4453a();
            c4453a.gne = (TextView) view.findViewById(2131820678);
            c4453a.pnu = (TextView) view.findViewById(2131821841);
            c4453a.tGQ = (CheckedTextView) view.findViewById(2131826057);
            c4453a.tGR = (CdnImageView) view.findViewById(2131828647);
            c4453a.tGP = (FavourLayout) view.findViewById(2131828748);
            c4453a.pnu.setText("");
            view.setTag(c4453a);
        } else {
            c4453a = (C4453a) view.getTag();
        }
        c4453a.pnu.setTextColor(C4996ah.getResources().getColor(C25738R.color.f12092s0));
        c4453a.tGP.setVisibility(8);
        Bankcard Hd = mo63458Hd(i);
        LinkedList linkedList;
        if (Hd == null) {
            c4453a.tGQ.setVisibility(4);
            c4453a.pnu.setVisibility(8);
            c4453a.gne.setText(C25738R.string.fnt);
            c4453a.tGR.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
                C35396n c35396n = this.pWy.tAr.tnf.tmB;
                if (c35396n != null) {
                    Iterator it = c35396n.tns.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((C29527o) it.next()).pOz);
                    }
                    linkedList = linkedList2;
                    if (this.tGM && linkedList.size() > 0) {
                        c4453a.tGP.setVisibility(0);
                        c4453a.pnu.setVisibility(8);
                        c4453a.tGP.setWording(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            c4453a.tGP.setVisibility(0);
            c4453a.pnu.setVisibility(8);
            c4453a.tGP.setWording(linkedList);
        } else {
            c4453a.tGR.setVisibility(0);
            c4453a.tGQ.setVisibility(0);
            c4453a.pnu.setVisibility(0);
            c4453a.pnu.setText("");
            if (Hd.cPg()) {
                c4453a.gne.setText(C44089j.m79293b(this.mContext, Hd.field_desc, c4453a.gne.getTextSize()));
            } else {
                c4453a.gne.setText(Hd.field_desc);
            }
            Bankcard bankcard;
            if (Hd.cPc()) {
                bankcard = C14241r.cPI().thy;
                if (!C5046bo.isNullOrNil(bankcard.twT)) {
                    c4453a.gne.setText(bankcard.twT);
                } else if (bankcard.twS >= 0.0d) {
                    c4453a.gne.setText(this.mContext.getString(C44423ae.dOh(), new Object[]{C36391e.m59972G(bankcard.twS)}));
                } else {
                    c4453a.gne.setText(this.mContext.getText(C25738R.string.fg1));
                }
            } else if (Hd.cPd()) {
                bankcard = C14241r.cPI().tCZ;
                if (!C5046bo.isNullOrNil(bankcard.twT)) {
                    c4453a.gne.setText(bankcard.twT);
                } else if (bankcard.twS >= 0.0d) {
                    c4453a.gne.setText(this.mContext.getString(C25738R.string.fhz, new Object[]{C36391e.m59972G(bankcard.twS)}));
                } else {
                    c4453a.gne.setText(this.mContext.getText(C25738R.string.fg1));
                }
            }
            c4453a.pnu.setVisibility(0);
            switch (Hd.mo69481a(this.toE, this.pWy)) {
                case 1:
                    c4453a.pnu.setText(C25738R.string.fnz);
                    break;
                case 2:
                    c4453a.pnu.setText(C25738R.string.fo5);
                    break;
                case 3:
                    c4453a.pnu.setText(C25738R.string.fo_);
                    break;
                case 4:
                    c4453a.pnu.setText(C25738R.string.fo1);
                    break;
                case 5:
                    c4453a.pnu.setText(C25738R.string.fnx);
                    break;
                case 6:
                    c4453a.pnu.setText(C25738R.string.fo3);
                    break;
                case 7:
                    c4453a.pnu.setText(C25738R.string.fo8);
                    break;
                case 8:
                    c4453a.pnu.setText(Hd.field_forbidWord);
                    break;
                default:
                    if (!C5046bo.isNullOrNil(Hd.field_tips)) {
                        c4453a.pnu.setText(Hd.field_tips);
                        break;
                    }
                    c4453a.pnu.setVisibility(8);
                    break;
            }
            String charSequence = c4453a.pnu.getText().toString();
            c4453a.gne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
            if (this.tGL.equalsIgnoreCase(Hd.field_bindSerial)) {
                c4453a.tGQ.setChecked(true);
                c4453a.tGQ.setEnabled(true);
            } else if (isEnabled(i)) {
                c4453a.tGQ.setChecked(false);
                c4453a.tGQ.setEnabled(true);
            } else {
                c4453a.tGQ.setEnabled(false);
                c4453a.tGQ.setChecked(false);
                c4453a.gne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12092s0));
            }
            c4453a.tGR.setTag(2131820688, null);
            c4453a.tGR.setTag(null);
            c4453a.tGR.setImageDrawable(null);
            c4453a.pnu.setOnClickListener(null);
            if (Hd.cPc()) {
                C40141a.m68840j(c4453a.tGR);
            } else if (Hd.cPd()) {
                this.tln.mo63493a(Hd, c4453a.tGR);
            } else if (Hd.cPg()) {
                c4453a.tGR.setImageDrawable(C5147a.m7837f(C4996ah.getResources(), C1318a.honey_pay_bank_logo));
                if (!C5046bo.isNullOrNil(Hd.txk)) {
                    c4453a.tGR.setUseSdcardCache(true);
                    c4453a.tGR.setImgSavedPath(C46362b.cRb());
                    c4453a.tGR.mo38952eb(Hd.txk, C1318a.honey_pay_bank_logo);
                }
            } else {
                this.tln.mo63491a(this.mContext, Hd, c4453a.tGR);
            }
            if (!C5046bo.isNullOrNil(Hd.field_forbid_title) && !C5046bo.isNullOrNil(Hd.field_forbid_url)) {
                charSequence = charSequence + "  ";
                SpannableString spannableString = new SpannableString(charSequence + Hd.field_forbid_title);
                c4453a.pnu.setOnClickListener(new C401291());
                spannableString.setSpan(new ForegroundColorSpan(C4996ah.getResources().getColor(C25738R.color.a4f)), charSequence.length(), charSequence.length() + Hd.field_forbid_title.length(), 34);
                c4453a.pnu.setText(spannableString);
                c4453a.pnu.setTag(Hd.field_forbid_url);
            } else if (this.tGM && C5046bo.isNullOrNil(Hd.field_forbidWord) && C5046bo.isNullOrNil(charSequence)) {
                linkedList = m68795g(Hd);
                if (linkedList.size() > 0) {
                    c4453a.tGP.setVisibility(0);
                    c4453a.pnu.setVisibility(8);
                    c4453a.tGP.setWording(linkedList);
                }
            }
        }
        AppMethodBeat.m2505o(47317);
        return view;
    }

    /* renamed from: g */
    private LinkedList<String> m68795g(Bankcard bankcard) {
        AppMethodBeat.m2504i(47318);
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
            Iterator it = this.pWy.tAr.tnf.tmA.iterator();
            while (it.hasNext()) {
                C35391c c35391c = (C35391c) it.next();
                if (c35391c.pbo.equals(bankcard.field_bindSerial)) {
                    it = c35391c.tmL.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((C35392d) it.next()).pOz);
                    }
                    AppMethodBeat.m2505o(47318);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.m2505o(47318);
        return linkedList;
    }

    /* renamed from: f */
    public final void mo63459f(ArrayList<Bankcard> arrayList, boolean z) {
        AppMethodBeat.m2504i(47319);
        if (arrayList == null) {
            this.tgB = new ArrayList();
        } else {
            this.tgB = arrayList;
        }
        this.tGM = z;
        if (this.tgB.size() > 0) {
            this.tln.mo63494b(this.mContext, this.tgB);
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(47319);
    }
}
