package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32651uu;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C37805ul;
import com.tencent.p177mm.p230g.p231a.C9493vd;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.p748a.C7176h;
import com.tencent.p177mm.plugin.wallet.pay.C14167b;
import com.tencent.p177mm.plugin.wallet.pay.C31458a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C35446d;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C40071a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C46349b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1047b.C43765b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C22530f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C24859d;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C24860e;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C24861g;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C24862h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43767a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43768b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43769c;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43770i;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43771j;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C43772k;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.C14196a.C14198a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.plugin.wallet_core.model.C43809g;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22624d;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29666c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29674l;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29674l.C22625b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C29682c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b.C4438a;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p649c.C24147k;
import com.tencent.p177mm.wallet_core.p649c.C36377e;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI */
public class WalletPayUI extends WalletBaseUI implements C14198a {
    private static boolean tpr = false;
    private static List<C24879b> tps = new ArrayList();
    public String TAG = "MicroMsg.WalletPayUI";
    public String gHr = null;
    protected int mCount = 0;
    protected C40052a pQU = null;
    private String pRx;
    protected Button pTi;
    private C4884c pUc = new C2488112();
    protected PayInfo pVL = null;
    protected Orders pWy = null;
    protected ArrayList<Bankcard> tgB = null;
    protected Bankcard tgC = null;
    public FavorPayInfo toH = null;
    private C14196a toI;
    C22624d toJ;
    private boolean toK = false;
    private C35446d tou = null;
    protected String tpA = "";
    protected boolean tpB = false;
    public Bundle tpC = null;
    protected boolean tpD = false;
    protected TextView tpE;
    protected TextView tpF;
    private TextView tpG;
    protected TextView tpH;
    protected TextView tpI;
    protected TextView tpJ;
    protected ImageView tpK;
    private TextView tpL;
    private TextView tpM;
    protected LinearLayout tpN;
    protected C24878a tpO;
    public Dialog tpP;
    private long tpQ = 0;
    private TextView tpR;
    private LinearLayout tpS;
    private boolean tpT = true;
    private boolean tpU = false;
    private boolean tpV = false;
    private boolean tpW = false;
    private boolean tpX = false;
    private int tpY = -1;
    private boolean tpZ = false;
    private C22530f tpt = null;
    protected C22621b tpu = null;
    private boolean tpv = false;
    private boolean tpw = false;
    protected boolean tpx = false;
    private C30857a tpy;
    protected boolean tpz = false;
    private boolean tqa = false;
    private C22530f tqb;
    private boolean tqc = false;
    private boolean tqd = false;
    private int tqe = 0;
    private Runnable tqf = new C141891();
    private C24879b tqg;
    private long tqh = 0;
    private boolean tqi;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$23 */
    class C437423 implements OnClickListener {
        C437423() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46061);
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46061);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$9 */
    class C43759 implements View.OnClickListener {
        C43759() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46044);
            C4990ab.m7417i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", C5046bo.dpG().toString());
            WalletPayUI.this.toH = (FavorPayInfo) view.getTag();
            if (WalletPayUI.this.toH != null) {
                WalletPayUI.this.toH.tzf = "";
            }
            WalletPayUI.this.mo41721c(false, 0, "");
            WalletPayUI.this.tpP.dismiss();
            WalletPayUI.this.gHr = null;
            WalletPayUI.this.tpP = null;
            WalletPayUI.this.toJ = null;
            AppMethodBeat.m2505o(46044);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$18 */
    class C1418818 implements OnClickListener {
        C1418818() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46056);
            if (WalletPayUI.this.bwP()) {
                WalletPayUI.this.finish();
            }
            AppMethodBeat.m2505o(46056);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$1 */
    class C141891 implements Runnable {
        C141891() {
        }

        public final void run() {
            AppMethodBeat.m2504i(46034);
            C4990ab.m7416i(WalletPayUI.this.TAG, "auto reset create flag");
            WalletPayUI.tpr = false;
            AppMethodBeat.m2505o(46034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$29 */
    class C1419029 extends C24019s {
        C1419029() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(46067);
            C46332s.cNC();
            if (!C46332s.cND().cQh()) {
                C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 6, "");
            }
            WalletPayUI.this.cOd();
            AppMethodBeat.m2505o(46067);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$20 */
    class C2253420 implements OnClickListener {
        C2253420() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46058);
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46058);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$3 */
    class C225353 implements View.OnClickListener {
        C225353() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46036);
            WalletPayUI.this.cOd();
            AppMethodBeat.m2505o(46036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$15 */
    class C2486715 implements OnClickListener {
        C2486715() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46051);
            if (WalletPayUI.this.bwP()) {
                WalletPayUI.this.finish();
            }
            AppMethodBeat.m2505o(46051);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$17 */
    class C2486817 implements OnClickListener {
        C2486817() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46055);
            WalletPayUI.this.tpC.putInt("key_pay_flag", 3);
            WalletPayUI.this.mo41717Q(WalletPayUI.this.tpC);
            AppMethodBeat.m2505o(46055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$28 */
    class C2486928 implements View.OnClickListener {
        C2486928() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46066);
            if (WalletPayUI.this.tpB) {
                WalletPayUI.this.tpK.setImageResource(C25738R.drawable.f6953wn);
                WalletPayUI.this.tpB = false;
            } else {
                WalletPayUI.this.tpK.setImageResource(C25738R.drawable.f6954wo);
                WalletPayUI.this.tpB = true;
            }
            WalletPayUI.this.tpO.notifyDataSetChanged();
            AppMethodBeat.m2505o(46066);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$2 */
    class C248702 implements View.OnClickListener {
        C248702() {
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(46035);
            C46332s.cNC();
            if (C46332s.cND().cQh()) {
                C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 6, "");
            }
            if (WalletPayUI.this.pWy.tAs == 1) {
                C46332s.cNC();
                if (C46332s.cND().cQh()) {
                    if (WalletPayUI.this.pVL != null) {
                        i = WalletPayUI.this.pVL.cIf;
                    }
                    C44422ad.m80306e(i, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 5, "");
                }
                WalletPayUI.m38844f(WalletPayUI.this);
                AppMethodBeat.m2505o(46035);
                return;
            }
            C4990ab.m7416i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
            C46332s.cNC();
            if (C46332s.cND().cQh()) {
                C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 5, "");
            }
            WalletPayUI.this.mo41720b(false, 0, "");
            AppMethodBeat.m2505o(46035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$4 */
    class C248714 implements OnClickListener {
        C248714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46037);
            C4990ab.m7416i(WalletPayUI.this.TAG, "click continue pay");
            if (!(WalletPayUI.this.pVL == null || WalletPayUI.this.pWy == null || WalletPayUI.this.pWy.tAq == null || WalletPayUI.this.pWy.tAq.size() <= 0)) {
                if (WalletPayUI.this.pVL.cIf == 8) {
                    C7060h.pYm.mo8381e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                } else {
                    C7060h.pYm.mo8381e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                }
            }
            WalletPayUI.m38845g(WalletPayUI.this);
            AppMethodBeat.m2505o(46037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$26 */
    class C2487326 implements C30857a {
        C2487326() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(46064);
            C4990ab.m7416i(WalletPayUI.this.TAG, "pay process end");
            WalletPayUI.this.tpx = false;
            Intent intent = new Intent();
            AppMethodBeat.m2505o(46064);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$5 */
    class C248745 implements OnClickListener {
        C248745() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46038);
            C4990ab.m7416i(WalletPayUI.this.TAG, "click cancel pay");
            if (!(WalletPayUI.this.pVL == null || WalletPayUI.this.pWy == null || WalletPayUI.this.pWy.tAq == null || WalletPayUI.this.pWy.tAq.size() <= 0)) {
                if (WalletPayUI.this.pVL.cIf == 8) {
                    C7060h.pYm.mo8381e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                } else {
                    C7060h.pYm.mo8381e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                }
            }
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$6 */
    class C248756 implements OnClickListener {
        C248756() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46039);
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$7 */
    class C248767 implements C4438a {
        C248767() {
        }

        /* renamed from: a */
        public final void mo9483a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
            AppMethodBeat.m2504i(46040);
            if (WalletPayUI.this.toK) {
                C4990ab.m7420w(WalletPayUI.this.TAG, "has received canceled");
                C7060h.pYm.mo15419k(965, 3, 1);
                AppMethodBeat.m2505o(46040);
                return;
            }
            WalletPayUI.this.tqi = true;
            WalletPayUI.this.aqX();
            WalletPayUI.this.toH = favorPayInfo;
            WalletPayUI.this.tgC = bankcard;
            String str2 = WalletPayUI.this.TAG;
            String str3 = "WalletPwdDialog showAlert with favinfo %s";
            Object[] objArr = new Object[1];
            objArr[0] = WalletPayUI.this.toH == null ? "" : WalletPayUI.this.toH.toString();
            C4990ab.m7417i(str2, str3, objArr);
            if (!C5046bo.isNullOrNil(str)) {
                C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 9, "");
            }
            WalletPayUI.this.gHr = str;
            WalletPayUI.this.mo41734na(false);
            C40148d.cSP();
            AppMethodBeat.m2505o(46040);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(46041);
            C4990ab.m7416i(WalletPayUI.this.TAG, "cashier dialog canceled");
            WalletPayUI.this.toK = true;
            C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 10, "");
            if (WalletPayUI.this.bwP()) {
                WalletPayUI.this.finish();
            }
            AppMethodBeat.m2505o(46041);
        }

        public final void cMN() {
            AppMethodBeat.m2504i(46042);
            C4990ab.m7416i(WalletPayUI.this.TAG, "click add new bankcard");
            C43809g cPl = C43809g.cPl();
            if (cPl.aFF()) {
                C30379h.m48461b(WalletPayUI.this.mController.ylL, cPl.pbp, WalletPayUI.this.getString(C25738R.string.f9238tz), true);
                AppMethodBeat.m2505o(46042);
                return;
            }
            C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 14, "");
            WalletPayUI.this.cOg();
            AppMethodBeat.m2505o(46042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$8 */
    class C248778 implements C29682c {
        C248778() {
        }

        /* renamed from: a */
        public final void mo9392a(String str, FavorPayInfo favorPayInfo, boolean z) {
            AppMethodBeat.m2504i(46043);
            if (WalletPayUI.this.toK) {
                C4990ab.m7420w(WalletPayUI.this.TAG, "has received canceled");
                C7060h.pYm.mo15419k(965, 3, 1);
                AppMethodBeat.m2505o(46043);
                return;
            }
            WalletPayUI.this.tqi = true;
            WalletPayUI.this.aqX();
            WalletPayUI.this.toH = favorPayInfo;
            String str2 = WalletPayUI.this.TAG;
            String str3 = "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s";
            Object[] objArr = new Object[2];
            objArr[0] = WalletPayUI.this.toH == null ? "" : WalletPayUI.this.toH.toString();
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            if (WalletPayUI.this.toH != null && z) {
                WalletPayUI.this.mo41718ap(-100, true);
            }
            if (!C5046bo.isNullOrNil(str)) {
                C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 9, "");
            }
            WalletPayUI.this.gHr = str;
            WalletPayUI.this.mo41734na(false);
            C40148d.cSP();
            WalletPayUI.this.toJ = null;
            AppMethodBeat.m2505o(46043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$a */
    protected class C24878a {
        protected C24878a() {
        }

        public final void notifyDataSetChanged() {
            int i;
            AppMethodBeat.m2504i(46075);
            WalletPayUI.this.tpN.removeAllViews();
            if (WalletPayUI.this.mCount == 0) {
                i = 0;
            } else if (WalletPayUI.this.tpB) {
                i = WalletPayUI.this.mCount;
            } else {
                i = 1;
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            for (int i2 = 0; i2 < i; i2++) {
                View inflate = ((LayoutInflater) WalletPayUI.this.getSystemService("layout_inflater")).inflate(2130971146, null);
                TextView textView = (TextView) inflate.findViewById(2131828930);
                TextView textView2 = (TextView) inflate.findViewById(2131828923);
                Commodity commodity = (Commodity) WalletPayUI.this.pWy.tAq.get(i2);
                String str = "";
                if (WalletPayUI.this.pVL != null && (WalletPayUI.this.pVL.cIf == 32 || WalletPayUI.this.pVL.cIf == 33 || WalletPayUI.this.pVL.cIf == 31 || WalletPayUI.this.pVL.cIf == 48)) {
                    String string = WalletPayUI.this.pVL.vwh.getString("extinfo_key_1", "");
                    if (C5046bo.isNullOrNil(string)) {
                        C4990ab.m7412e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    } else {
                        C1720g.m3537RQ();
                        C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(string);
                        if (aoM != null) {
                            str = aoM.mo16707Oj();
                        } else {
                            C4990ab.m7412e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(string)));
                        }
                    }
                }
                if (commodity != null) {
                    if (!C5046bo.isNullOrNil(str)) {
                        textView2.setText(str);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(2131828983)).setVisibility(0);
                    } else if (C5046bo.isNullOrNil(commodity.pca)) {
                        ((TextView) inflate.findViewById(2131828983)).setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(commodity.pca);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(2131828983)).setVisibility(0);
                    }
                    if (C5046bo.isNullOrNil(commodity.desc)) {
                        ((TextView) inflate.findViewById(2131828929)).setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(2131828929)).setVisibility(8);
                    }
                    if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(commodity.pca)) {
                        inflate.setVisibility(8);
                    } else {
                        inflate.setVisibility(0);
                    }
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                WalletPayUI.this.tpN.addView(inflate);
            }
            AppMethodBeat.m2505o(46075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$b */
    class C24879b {
        int aBR;
        long timestamp;
        WeakReference<WalletPayUI> tqs;

        private C24879b() {
        }

        /* synthetic */ C24879b(WalletPayUI walletPayUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$11 */
    class C2488011 implements OnClickListener {
        C2488011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46046);
            WalletPayUI.this.cOg();
            AppMethodBeat.m2505o(46046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$12 */
    class C2488112 extends C4884c<C9493vd> {
        C2488112() {
            AppMethodBeat.m2504i(46047);
            this.xxI = C9493vd.class.getName().hashCode();
            AppMethodBeat.m2505o(46047);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46048);
            C4990ab.m7417i(WalletPayUI.this.TAG, "WalletRealNameResultNotifyMoreEvent %s", Integer.valueOf(((C9493vd) c4883b).cSa.result));
            if (((C9493vd) c4883b).cSa.result == -1) {
                WalletPayUI.this.tqc = true;
                WalletPayUI.this.tqd = true;
                WalletPayUI.this.cNX();
            }
            AppMethodBeat.m2505o(46048);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$24 */
    class C2488324 implements OnClickListener {
        C2488324() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46062);
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46062);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$27 */
    class C2488427 extends C24019s {
        C2488427() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(46065);
            WalletPayUI.this.mo41720b(false, 0, "");
            AppMethodBeat.m2505o(46065);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$13 */
    class C2488513 implements OnClickListener {
        C2488513() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46049);
            if (WalletPayUI.this.bwP()) {
                WalletPayUI.this.finish();
            }
            AppMethodBeat.m2505o(46049);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$19 */
    class C2488619 implements OnClickListener {
        C2488619() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46057);
            WalletPayUI.this.finish();
            AppMethodBeat.m2505o(46057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$10 */
    class C2488810 implements OnCancelListener {
        C2488810() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            int i = 0;
            AppMethodBeat.m2504i(46045);
            C4990ab.m7417i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", C5046bo.dpG().toString());
            WalletPayUI.this.Ahw = 4;
            WalletPayUI.this.toK = true;
            if (WalletPayUI.this.pVL != null) {
                i = WalletPayUI.this.pVL.cIf;
            }
            C44422ad.m80306e(i, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 10, "");
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            WalletPayUI.this.gHr = null;
            WalletPayUI.this.tpP = null;
            if (WalletPayUI.this.bwP()) {
                WalletPayUI.this.finish();
            }
            WalletPayUI.this.toJ = null;
            AppMethodBeat.m2505o(46045);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$30 */
    class C2488930 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$30$1 */
        class C141911 implements C22625b {

            /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$30$1$2 */
            class C141922 implements View.OnClickListener {
                C141922() {
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46069);
                    C4990ab.m7416i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                    WalletPayUI.this.mo41720b(false, 0, "");
                    AppMethodBeat.m2505o(46069);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$30$1$1 */
            class C141931 implements View.OnClickListener {
                C141931() {
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46068);
                    C4990ab.m7416i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                    WalletPayUI.this.mo41720b(false, 0, "");
                    AppMethodBeat.m2505o(46068);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI$30$1$3 */
            class C141943 implements View.OnClickListener {
                C141943() {
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46070);
                    WalletPayUI.this.cOd();
                    AppMethodBeat.m2505o(46070);
                }
            }

            C141911() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:24:0x00f9  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x011b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final void mo9492a(FavorPayInfo favorPayInfo) {
                int i = 1;
                AppMethodBeat.m2504i(46071);
                WalletPayUI.this.toH = favorPayInfo;
                String str = WalletPayUI.this.TAG;
                String str2 = "WalletFavorDialog onSelectionDone %s";
                Object[] objArr = new Object[1];
                objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
                C4990ab.m7417i(str, str2, objArr);
                if (WalletPayUI.this.toH != null) {
                    int i2;
                    boolean z;
                    if (WalletPayUI.this.pVL == null) {
                        i2 = 0;
                    } else {
                        i2 = WalletPayUI.this.pVL.cIf;
                    }
                    if (WalletPayUI.this.pVL == null) {
                        str = "";
                    } else {
                        str = WalletPayUI.this.pVL.czZ;
                    }
                    C44422ad.m80306e(i2, str, 15, WalletPayUI.this.toH.tzb);
                    if (WalletPayUI.this.tgC == null || C22621b.m34307a(WalletPayUI.this.toH, WalletPayUI.this.tgC)) {
                        WalletPayUI.this.tpJ.setVisibility(8);
                        WalletPayUI.this.pTi.setOnClickListener(new C141931());
                        z = true;
                    } else {
                        C46330j acU = WalletPayUI.this.tpu.acU(WalletPayUI.this.toH.tzb);
                        if (acU != null && WalletPayUI.this.tgC.cPc()) {
                            C46332s.cNC();
                            Bankcard bankcard = C46332s.cND().thy;
                            double d = acU.tmT;
                            if (bankcard != null && bankcard.twS < d) {
                                C4990ab.m7416i(WalletPayUI.this.TAG, "balance not meet");
                                WalletPayUI.this.tpJ.setVisibility(8);
                                WalletPayUI.this.pTi.setOnClickListener(new C141922());
                                z = true;
                            }
                        }
                        z = false;
                    }
                    C4990ab.m7417i(WalletPayUI.this.TAG, "needBindBankCard %s", Boolean.valueOf(z));
                    WalletPayUI.this.tpS.setVisibility(0);
                    WalletPayUI.this.tpR.setVisibility(0);
                    if (WalletPayUI.this.toH != null) {
                        WalletPayUI.this.tpu = C29666c.tDU.mo47919a(WalletPayUI.this.pWy);
                        C46330j acU2 = WalletPayUI.this.tpu.acU(WalletPayUI.this.toH.tzb);
                        if (acU2 != null && acU2.tmT == 0.0d) {
                            WalletPayUI.this.tpS.setVisibility(8);
                            WalletPayUI.this.tpR.setVisibility(8);
                            z = false;
                            if (!z) {
                                WalletPayUI.this.tpI.setVisibility(8);
                                WalletPayUI.this.tpJ.setVisibility(0);
                                WalletPayUI.this.pTi.setOnClickListener(new C141943());
                            }
                            if (i != 0) {
                                WalletPayUI.this.tpJ.setVisibility(8);
                            }
                            WalletPayUI.this.cOa();
                        }
                    }
                    i = 0;
                    if (z) {
                    }
                    if (i != 0) {
                    }
                    WalletPayUI.this.cOa();
                }
                AppMethodBeat.m2505o(46071);
            }
        }

        C2488930() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46072);
            C44422ad.m80306e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 12, "");
            C29674l.m47060a(WalletPayUI.this.mController.ylL, WalletPayUI.this.pWy, WalletPayUI.this.toH.tzb, new C141911(), null);
            AppMethodBeat.m2505o(46072);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletPayUI() {
        AppMethodBeat.m2504i(46076);
        AppMethodBeat.m2505o(46076);
    }

    /* renamed from: e */
    static /* synthetic */ void m38842e(WalletPayUI walletPayUI) {
        AppMethodBeat.m2504i(46122);
        walletPayUI.cNZ();
        AppMethodBeat.m2505o(46122);
    }

    /* renamed from: g */
    static /* synthetic */ void m38845g(WalletPayUI walletPayUI) {
        AppMethodBeat.m2504i(46124);
        walletPayUI.cOe();
        AppMethodBeat.m2505o(46124);
    }

    /* renamed from: l */
    static /* synthetic */ boolean m38851l(WalletPayUI walletPayUI) {
        AppMethodBeat.m2504i(138088);
        boolean cNG = walletPayUI.cNG();
        AppMethodBeat.m2505o(138088);
        return cNG;
    }

    static {
        AppMethodBeat.m2504i(46126);
        AppMethodBeat.m2505o(46126);
    }

    /* renamed from: Hg */
    private void m38832Hg(int i) {
        AppMethodBeat.m2504i(46077);
        this.tqe = i;
        C4990ab.m7417i(this.TAG, "markForceFinish errorType %s %s", Integer.valueOf(i), C5046bo.dpG().toString());
        AppMethodBeat.m2505o(46077);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46078);
        super.onCreate(bundle);
        this.TAG = "MicroMsg.WalletPayUI@" + hashCode();
        if (tpr) {
            C4990ab.m7420w(this.TAG, "has Undestory WalletPayUI!");
            C7060h.pYm.mo15419k(965, 1, 1);
            m38832Hg(2);
            finish();
            AppMethodBeat.m2505o(46078);
            return;
        }
        tpr = true;
        long currentTimeMillis = System.currentTimeMillis();
        int intExtra = getIntent().getIntExtra("key_context_hashcode", -1);
        C24879b[] c24879bArr = new C24879b[tps.size()];
        C4990ab.m7417i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", Integer.valueOf(tps.size()), Integer.valueOf(hashCode()), Integer.valueOf(intExtra));
        for (C24879b c24879b : (C24879b[]) tps.toArray(c24879bArr)) {
            WalletPayUI walletPayUI = (WalletPayUI) c24879b.tqs.get();
            if (walletPayUI != null) {
                C4990ab.m7421w(this.TAG, "has old payui, both finish %s", Integer.valueOf(walletPayUI.hashCode()));
                if (intExtra != c24879b.aBR || intExtra == -1) {
                    walletPayUI.m38832Hg(1);
                    C7060h.pYm.mo15419k(965, 40, 1);
                } else {
                    walletPayUI.m38832Hg(2);
                    C7060h.pYm.mo15419k(965, 41, 1);
                }
                tps.remove(c24879b);
                walletPayUI.finish();
            }
        }
        this.tqg = new C24879b(this, (byte) 0);
        this.tqg.timestamp = currentTimeMillis;
        this.tqg.aBR = intExtra;
        this.tqg.tqs = new WeakReference(this);
        tps.add(this.tqg);
        if (C1720g.m3531RK()) {
            getWindow().getDecorView().postDelayed(this.tqf, 5000);
            this.tqh = C5046bo.anU();
            C4879a.xxA.mo10052c(this.pUc);
            C22594k.m34292Hp(5);
            this.pQU = C40052a.m68624at(getIntent());
            setMMTitle((int) C25738R.string.fp2);
            this.pVL = cOl();
            this.tpz = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.tpA = C5046bo.m7532bc(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.pRx = getIntent().getStringExtra("key_receiver_true_name");
            if (this.pVL == null || this.pVL.vwj == 0) {
                this.tpQ = System.currentTimeMillis();
            } else {
                this.tpQ = this.pVL.vwj;
            }
            C46332s.cNC();
            if (!C46332s.cND().cQg()) {
                C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 1, "");
            }
            if (cNW()) {
                C4990ab.m7416i(this.TAG, "hy: pay end on create. finish");
                finish();
            } else {
                C4990ab.m7410d(this.TAG, "PayInfo = " + this.pVL);
                if (this.pVL == null || C5046bo.isNullOrNil(this.pVL.czZ)) {
                    String string;
                    if (this.pVL == null || C5046bo.isNullOrNil(this.pVL.aIm)) {
                        string = getString(C25738R.string.fov);
                    } else {
                        string = this.pVL.aIm;
                    }
                    C30379h.m48448a((Context) this, string, null, false, new C437423());
                } else {
                    cNX();
                }
                initView();
            }
            if (this.pVL != null) {
                C46349b.acn(this.pVL.vwp);
            }
            AppMethodBeat.m2505o(46078);
            return;
        }
        C4990ab.m7412e(this.TAG, "hy: account not ready. finish now");
        finish();
        AppMethodBeat.m2505o(46078);
    }

    private boolean cNW() {
        AppMethodBeat.m2504i(46079);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            C4990ab.m7416i(this.TAG, "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                C4990ab.m7410d(this.TAG, "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                C4990ab.m7410d(this.TAG, "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                C4990ab.m7410d(this.TAG, "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                m38846h(-1, getIntent());
                this.tpw = true;
            } else {
                C4990ab.m7410d(this.TAG, "pay cancel");
                m38846h(0, getIntent());
                this.tpw = false;
            }
            AppMethodBeat.m2505o(46079);
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            C4990ab.m7416i(this.TAG, "hy: pay not end");
            AppMethodBeat.m2505o(46079);
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    AppMethodBeat.m2505o(46079);
                    return true;
                default:
                    AppMethodBeat.m2505o(46079);
                    return false;
            }
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46080);
        if (this.toI != null) {
            this.toI.cNM();
            this.toI.release();
        }
        C4879a.xxA.mo10053d(this.pUc);
        this.toJ = null;
        getWindow().getDecorView().removeCallbacks(this.tqf);
        tps.remove(this.tqg);
        tpr = false;
        long currentTimeMillis = System.currentTimeMillis();
        for (C24879b c24879b : (C24879b[]) tps.toArray(new C24879b[tps.size()])) {
            WalletPayUI walletPayUI = (WalletPayUI) c24879b.tqs.get();
            if (walletPayUI != null && currentTimeMillis - c24879b.timestamp > 600000) {
                C4990ab.m7420w(this.TAG, "has old payui, both finish");
                C7060h.pYm.mo15419k(965, 2, 1);
                tps.remove(c24879b);
                walletPayUI.m38832Hg(1);
                walletPayUI.finish();
            }
        }
        if (this.pVL != null) {
            C46349b.aco(this.pVL.vwp);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(46080);
    }

    /* Access modifiers changed, original: protected */
    public void cNX() {
        C36378u c36378u;
        int i = 2;
        AppMethodBeat.m2504i(46081);
        C7060h.pYm.mo8381e(11850, Integer.valueOf(2), Integer.valueOf(this.pVL.cIf));
        if (this.pVL.cIf == 11) {
            i = 3;
        }
        PayInfo payInfo = this.pVL;
        if (payInfo == null || C5046bo.isNullOrNil(payInfo.czZ)) {
            C4990ab.m7416i("MicroMsg.CgiManager", "no payInfo or reqKey");
            c36378u = null;
        } else {
            String str = payInfo.czZ;
            C4990ab.m7417i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", str);
            C4990ab.m7416i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            if (str.startsWith("sns_aa_")) {
                c36378u = new C43767a(payInfo, i);
            } else if (str.startsWith("sns_tf_")) {
                c36378u = new C43771j(payInfo, i);
            } else if (str.startsWith("sns_ff_")) {
                c36378u = new C43769c(payInfo, i);
            } else if (str.startsWith("ts_")) {
                c36378u = new C24859d(payInfo, i);
            } else if (str.startsWith("sns_")) {
                c36378u = new C24862h(payInfo, i);
            } else if (str.startsWith("offline_")) {
                c36378u = new C24860e(payInfo, i);
            } else if (str.startsWith("up_")) {
                c36378u = new C43772k(payInfo, i);
            } else if (str.startsWith("seb_ff_")) {
                c36378u = new C24861g(payInfo, i);
            } else if (str.startsWith("tax_")) {
                c36378u = new C43770i(payInfo, i);
            } else if (str.startsWith("dc_")) {
                c36378u = new C43768b(payInfo, i);
            } else {
                c36378u = new C22530f(payInfo, i);
            }
        }
        if (c36378u != null) {
            c36378u.eHT = "PayProcess";
            c36378u.hbj = this.tpQ;
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                c36378u.gOW = 100;
            } else {
                c36378u.gOW = this.pVL.cIf;
            }
            mo39970a((C1207m) c36378u, true, this.pVL.vwf);
        }
        AppMethodBeat.m2505o(46081);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46082);
        C4990ab.m7417i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", Boolean.valueOf(this.tqc));
        if (!this.Ahr.bLA()) {
            if (!C5046bo.isNullOrNil(this.tpA)) {
                this.tgC = cOh();
            } else if (this.tgC == null) {
                C46332s.cNC();
                this.tgC = C46332s.cND().mo38130a(null, null, cOk(), false);
            } else {
                C46332s.cNC();
                this.tgC = C46332s.cND().mo38130a(null, this.tgC.field_bindSerial, cOk(), false);
            }
        }
        if (this.tqd) {
            C4990ab.m7416i(this.TAG, "onResume isResumePassFinish");
            this.tqd = false;
        } else if (this.tpx && this.mController.contentView.getVisibility() != 0 && (this.tpP == null || !this.tpP.isShowing())) {
            C4990ab.m7416i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.toJ != null) {
            this.toJ.cRm();
        }
        super.onResume();
        AppMethodBeat.m2505o(46082);
    }

    public final int getLayoutId() {
        return 2130971150;
    }

    public void finish() {
        AppMethodBeat.m2504i(46083);
        C4990ab.m7417i(this.TAG, "finish %s %s mPayResultType:%s", Integer.valueOf(hashCode()), C5046bo.dpG().toString(), Integer.valueOf(this.Ahw));
        dOy();
        if (!(this.pWy == null || this.pWy.tAq.isEmpty())) {
            getIntent().putExtra("key_trans_id", ((Commodity) this.pWy.tAq.get(0)).cAa);
        }
        if (this.pVL != null) {
            getIntent().putExtra("key_reqKey", this.pVL.czZ);
        }
        if (this.tpw) {
            if (this.pWy != null) {
                getIntent().putExtra("key_total_fee", this.pWy.pTN);
            }
            getIntent().putExtra("key_pay_reslut_type", 1);
            m38846h(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.pVL == null || this.pVL.cIf != 8 || this.pWy == null)) {
                this.pVL.vwn = 0;
                mo39970a(C40071a.m68666a(cOb(), this.pWy, true), false, false);
                if (this.pVL.vwh != null) {
                    long j = this.pVL.vwh.getLong("extinfo_key_9");
                    C7060h.pYm.mo8381e(13956, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j));
                }
            }
            m38846h(0, getIntent());
            getIntent().putExtra("key_pay_reslut_type", this.Ahw);
            if (this.tqe == 1) {
                getIntent().putExtra("key_pay_reslut_type", 1000);
            } else if (this.tqe == 2) {
                getIntent().putExtra("key_pay_reslut_type", 1001);
            }
            setResult(0, getIntent());
            C46332s.cNC();
            if (C46332s.cND().cQi()) {
                C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 18, "");
            } else {
                C46332s.cNC();
                if (C46332s.cND().cQh()) {
                    C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 4, "");
                } else {
                    C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 7, "");
                }
            }
            for (C40931c c40931c : C24143a.atm("PayProcess")) {
                c40931c.mo64557F("specEndProcessWithoutFinish");
                if (c40931c.mqu != null) {
                    c40931c.mqu.clear();
                }
                C24143a.remove(c40931c.getClass().hashCode());
                c40931c.cNF();
            }
        }
        C40931c dOD = dOD();
        if (dOD != null && this == ((Context) dOD.AeT.get())) {
            C4990ab.m7416i(this.TAG, "remove process end callback to prevent ui leak");
            dOD.dND();
        }
        super.finish();
        AppMethodBeat.m2505o(46083);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(46084);
        if (i != 4) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(46084);
            return onKeyUp;
        } else if (this.tqi) {
            C4990ab.m7420w(this.TAG, "block when authening");
            AppMethodBeat.m2505o(46084);
            return true;
        } else {
            if (this.tpP == null || this.pVL == null || !this.pVL.mXg || this.Ahr.bLA()) {
                aqX();
                showDialog(1000);
            } else {
                finish();
            }
            AppMethodBeat.m2505o(46084);
            return true;
        }
    }

    public void onNewIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(46085);
        C4990ab.m7416i(this.TAG, "onNewIntent");
        setIntent(intent);
        if (!cNW()) {
            C4990ab.m7420w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            if (intent.getBooleanExtra("send_cancel_event", true)) {
                m38846h(0, getIntent());
            }
            this.tpw = false;
        }
        if (intent.getBooleanExtra("direc_change_bankcard", false)) {
            mo41733mZ(true);
            AppMethodBeat.m2505o(46085);
            return;
        }
        boolean z2;
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z2 = false;
        } else {
            this.tpU = true;
            z2 = true;
        }
        if (z2) {
            C4990ab.m7416i(this.TAG, "isFromBindCard is true");
            cNX();
            AppMethodBeat.m2505o(46085);
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z = false;
        } else {
            this.tpV = true;
        }
        if (z) {
            C4990ab.m7416i(this.TAG, "isFromRealNameVerify is true");
            finish();
        } else {
            C4990ab.m7412e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
        AppMethodBeat.m2505o(46085);
    }

    /* renamed from: h */
    private void m38846h(int i, Intent intent) {
        AppMethodBeat.m2504i(46086);
        if (!(this.pVL == null || this.pVL.cIf != 46 || this.pWy == null)) {
            intent.putExtra("key_total_fee", this.pWy.pTN);
            C4990ab.m7417i(this.TAG, "sentCancelEvent set fee:%s", Double.valueOf(this.pWy.pTN));
        }
        C32652uv c32652uv = new C32652uv();
        c32652uv.cRF.intent = intent;
        if (this.tqe == 1) {
            c32652uv.cRF.cRG = 1000;
        } else if (this.tqe == 2) {
            c32652uv.cRF.cRG = 1001;
        }
        c32652uv.cRF.result = i;
        c32652uv.cRF.czZ = this.pVL == null ? "" : this.pVL.czZ;
        c32652uv.cRF.cRH = 1;
        if (this.pVL != null && i == 0) {
            C43765b.m78447ak(this.pVL.czZ, this.pVL.cIf, this.pVL.cIb);
        }
        C4879a.xxA.mo10055m(c32652uv);
        AppMethodBeat.m2505o(46086);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46087);
        C5222ae.m7935a(getWindow());
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131823366);
        mMScrollView.mo28524a(mMScrollView, mMScrollView);
        this.pTi = (Button) findViewById(2131829010);
        this.pTi.setClickable(false);
        this.pTi.setEnabled(false);
        this.tpE = (TextView) findViewById(2131828925);
        this.tpF = (TextView) findViewById(2131828989);
        this.tpH = (TextView) findViewById(2131828990);
        this.tpM = (TextView) findViewById(2131828995);
        this.tpG = (TextView) findViewById(2131828991);
        this.tpL = (TextView) findViewById(2131829009);
        this.tpG.getPaint().setFlags(16);
        this.tpI = (TextView) findViewById(2131829012);
        this.tpJ = (TextView) findViewById(2131829011);
        this.tpJ.setOnClickListener(new C2488427());
        this.tpK = (ImageView) findViewById(2131828996);
        this.tpK.setOnClickListener(new C2486928());
        this.tpN = (LinearLayout) findViewById(2131828992);
        this.tpO = new C24878a();
        this.pTi.setOnClickListener(new C1419029());
        this.pTi.setText(C25738R.string.fnr);
        this.tpR = (TextView) findViewById(2131828997);
        this.tpS = (LinearLayout) findViewById(2131828998);
        mo41731cu();
        AppMethodBeat.m2505o(46087);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cu */
    public final void mo41731cu() {
        int i;
        LinearLayout linearLayout;
        AppMethodBeat.m2504i(46088);
        if (!(this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
            this.tpE.setText(C36391e.m59971F(this.pWy.pTN));
            this.tpH.setText(C36391e.atr(this.pWy.pcl));
            this.tpO.notifyDataSetChanged();
            if (this.pWy.tAq.size() > 1) {
                this.tpK.setVisibility(0);
                this.tpF.setText(getString(C25738R.string.fp3, new Object[]{((Commodity) this.pWy.tAq.get(0)).desc, this.pWy.tAq.size()}));
            } else {
                this.tpF.setText(((Commodity) this.pWy.tAq.get(0)).desc);
                this.tpK.setVisibility(8);
            }
            this.tpB = false;
        }
        if (this.pVL != null && this.pVL.cIf == 48) {
            this.tpF.setText(C25738R.string.dfl);
        }
        this.tpI.setVisibility(8);
        this.tpJ.setVisibility(8);
        this.tpR.setVisibility(8);
        this.tpS.setVisibility(8);
        this.pTi.setText(C25738R.string.fnr);
        if (this.tgC == null || !this.tgC.cPc()) {
            C46332s.cNC();
            if (C46332s.cND().cQi()) {
                cNY();
            }
        } else if (C5046bo.isNullOrNil(this.tgC.field_forbidWord)) {
            C46332s.cNC();
            if (C46332s.cND().cQh()) {
                cNY();
            }
        } else {
            this.tpI.setText(this.tgC.field_forbidWord);
            this.tpI.setVisibility(4);
            this.tpJ.setVisibility(8);
            C46332s.cNC();
            if (C46332s.cND().cQh()) {
                cNY();
            }
        }
        C46332s.cNC();
        if (!C46332s.cND().cQh()) {
            C46332s.cNC();
            if (!C46332s.cND().cQi()) {
                i = 0;
                linearLayout = (LinearLayout) findViewById(2131828993);
                if (i != 0 || this.toH == null || this.tpu == null || !this.tpv || this.pWy == null) {
                    linearLayout.setVisibility(8);
                } else {
                    cOa();
                    this.tpM.setOnClickListener(new C2488930());
                    linearLayout.setVisibility(0);
                }
                if (this.pWy != null || this.tgB == null || this.pVL == null) {
                    this.pTi.setClickable(false);
                    this.pTi.setEnabled(false);
                } else {
                    this.pTi.setClickable(true);
                    this.pTi.setEnabled(true);
                }
                if (this.pWy == null) {
                    this.tpJ.setVisibility(8);
                }
                AppMethodBeat.m2505o(46088);
            }
        }
        i = 1;
        linearLayout = (LinearLayout) findViewById(2131828993);
        if (i != 0) {
        }
        linearLayout.setVisibility(8);
        if (this.pWy != null) {
        }
        this.pTi.setClickable(false);
        this.pTi.setEnabled(false);
        if (this.pWy == null) {
        }
        AppMethodBeat.m2505o(46088);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cNY() {
        AppMethodBeat.m2504i(46089);
        if (this.pWy == null) {
            C4990ab.m7412e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
            AppMethodBeat.m2505o(46089);
            return;
        }
        boolean z;
        this.tpJ.setVisibility(8);
        this.tpI.setVisibility(8);
        this.pTi.setText(C25738R.string.fnr);
        this.tpR.setVisibility(0);
        this.tpS.setVisibility(0);
        View findViewById = this.tpS.findViewById(2131828999);
        View findViewById2 = this.tpS.findViewById(2131829003);
        if ("CFT".equals(this.pWy.tAm)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        final CheckedTextView checkedTextView = (CheckedTextView) this.tpS.findViewById(2131829002);
        final CheckedTextView checkedTextView2 = (CheckedTextView) this.tpS.findViewById(2131829008);
        findViewById.setEnabled(true);
        boolean z2;
        if (this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0) {
            z2 = false;
        } else if (this.pWy.tAb == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.tgC == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46073);
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    WalletPayUI.this.tpT = false;
                    WalletPayUI.m38842e(WalletPayUI.this);
                    AppMethodBeat.m2505o(46073);
                }
            });
        }
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(46074);
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                WalletPayUI.this.tpT = true;
                WalletPayUI.m38842e(WalletPayUI.this);
                AppMethodBeat.m2505o(46074);
            }
        });
        this.tpR.setVisibility(0);
        this.tpS.setVisibility(0);
        if (this.toH != null) {
            this.tpu = C29666c.tDU.mo47919a(this.pWy);
            C46330j acU = this.tpu.acU(this.toH.tzb);
            if (acU != null && acU.tmT == 0.0d) {
                this.tpS.setVisibility(8);
                this.tpR.setVisibility(8);
                z = true;
                this.tpT = true;
                if (z) {
                    this.tpT = false;
                }
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                C4990ab.m7416i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pWy.tAs);
                if (this.pWy.tAs != 1) {
                    this.tpS.findViewById(2131829005).setVisibility(0);
                    ((TextView) this.tpS.findViewById(2131829006)).setText(this.pWy.tAt);
                    if (TextUtils.isEmpty(this.pWy.tAu)) {
                        ((TextView) this.tpS.findViewById(2131829007)).setText("");
                    } else {
                        ((TextView) this.tpS.findViewById(2131829007)).setText(" (" + this.pWy.tAu + ")");
                    }
                    if (!(this.tgC == null || !this.tgC.cPc() || TextUtils.isEmpty(this.tgC.field_forbidWord))) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.tpS.findViewById(2131829001)).setText(this.tgC.field_forbidWord);
                    }
                } else {
                    this.tpS.findViewById(2131829005).setVisibility(8);
                    if (this.tgC != null && this.tgC.cPc() && !TextUtils.isEmpty(this.tgC.field_forbidWord)) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.tpS.findViewById(2131829001)).setText(this.tgC.field_forbidWord);
                    } else if (this.tgC != null && this.tgC.cPc() && TextUtils.isEmpty(this.tgC.field_forbidWord) && !z2) {
                        checkedTextView.setChecked(true);
                        checkedTextView2.setChecked(false);
                        this.tpT = false;
                    }
                }
                cNZ();
                AppMethodBeat.m2505o(46089);
            }
        }
        z = false;
        this.tpT = true;
        if (z) {
        }
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        C4990ab.m7416i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pWy.tAs);
        if (this.pWy.tAs != 1) {
        }
        cNZ();
        AppMethodBeat.m2505o(46089);
    }

    private void cNZ() {
        AppMethodBeat.m2504i(46090);
        if (this.tpT) {
            this.pTi.setOnClickListener(new C248702());
            AppMethodBeat.m2505o(46090);
            return;
        }
        this.pTi.setOnClickListener(new C225353());
        AppMethodBeat.m2505o(46090);
    }

    public final void cOa() {
        double d;
        int i;
        AppMethodBeat.m2504i(46091);
        C46330j acU = this.tpu.acU(this.toH.tzb);
        List cRl = this.tpu.cRl();
        C7176h c7176h = this.tpu.tDO;
        String str = "";
        if (acU != null) {
            d = acU.tnb;
            if (d > 0.0d) {
                str = acU.tnd;
                i = 1;
                if (!C5046bo.isNullOrNil(acU.tne)) {
                    str = str + "," + acU.tne;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && cRl.size() > 0) {
            str = str + this.mController.ylL.getString(C25738R.string.fq0);
        }
        if (d <= 0.0d || c7176h == null || c7176h.tmX != 0) {
            this.tpE.setText(C36391e.m59971F(this.pWy.pTN));
            this.tpH.setText(C36391e.atr(this.pWy.pcl));
            this.tpG.setVisibility(8);
        } else {
            if (acU != null) {
                this.tpE.setText(C36391e.m59971F(acU.tna));
            }
            this.tpH.setText(C36391e.atr(this.pWy.pcl));
            this.tpG.setText(C36391e.m60006e(this.pWy.pTN, this.pWy.pcl));
            this.tpG.setVisibility(0);
        }
        if (!C5046bo.isNullOrNil(str)) {
            this.tpM.setText(str);
        }
        AppMethodBeat.m2505o(46091);
    }

    /* Access modifiers changed, original: protected|final */
    public final Authen cOb() {
        AppMethodBeat.m2504i(46092);
        Authen authen = new Authen();
        if (cOc()) {
            authen.bJt = 3;
        } else {
            authen.bJt = 6;
        }
        if (!C5046bo.isNullOrNil(this.gHr)) {
            authen.twc = this.gHr;
        }
        if (this.tgC != null) {
            authen.pbo = this.tgC.field_bindSerial;
            authen.pbn = this.tgC.field_bankcardType;
        }
        if (!(this.toH == null || this.tpu == null || !this.tpu.cRi())) {
            authen.two = this.toH.tzb;
            authen.twn = this.toH.tze;
        }
        authen.pGr = this.pVL;
        AppMethodBeat.m2505o(46092);
        return authen;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cOc() {
        AppMethodBeat.m2504i(46093);
        if (this.tgC == null || this.pWy == null || this.pWy.tuo != 3) {
            if (this.pWy == null || Bankcard.m78501Ho(this.pWy.tuo)) {
                AppMethodBeat.m2505o(46093);
                return false;
            }
            AppMethodBeat.m2505o(46093);
            return true;
        } else if (this.tgC.cPf()) {
            AppMethodBeat.m2505o(46093);
            return true;
        } else {
            AppMethodBeat.m2505o(46093);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cOd() {
        AppMethodBeat.m2504i(46094);
        mo41732mY(true);
        AppMethodBeat.m2505o(46094);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: mY */
    public final void mo41732mY(boolean z) {
        AppMethodBeat.m2504i(46095);
        if (!z || cOj()) {
            int i;
            if (this.toH != null) {
                this.tpu = C29666c.tDU.mo47919a(this.pWy);
                C46330j acU = this.tpu.acU(this.toH.tzb);
                if (acU != null && acU.tmT == 0.0d) {
                    i = 1;
                    if (this.tqb != null) {
                        if (this.tqb.tot == 0) {
                            C4990ab.m7416i(this.TAG, "need real name,stop");
                            m38838b(this.tqb);
                            AppMethodBeat.m2505o(46095);
                            return;
                        } else if (this.tqb.tot == 1 && i != 0) {
                            C4990ab.m7416i(this.TAG, "need real name, zero stop");
                            m38838b(this.tqb);
                        }
                    }
                    if (this.tou != null) {
                        if (this.tou.tob == 1 && !C5046bo.isNullOrNil(this.tou.nZb) && !C5046bo.isNullOrNil(this.tou.nZc) && !C5046bo.isNullOrNil(this.tou.toc)) {
                            if (!(this.pVL == null || this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
                                if (this.pVL.cIf == 8) {
                                    C7060h.pYm.mo8381e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                } else {
                                    C7060h.pYm.mo8381e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                }
                            }
                            C30379h.m48445a(this.mController.ylL, this.tou.toc, "", this.tou.nZc, this.tou.nZb, false, new C248714(), new C248745());
                            AppMethodBeat.m2505o(46095);
                            return;
                        } else if (!(this.tou.tob != 2 || C5046bo.isNullOrNil(this.tou.toc) || C5046bo.isNullOrNil(this.tou.tod))) {
                            C4990ab.m7416i(this.TAG, "pay has been blocked");
                            if (!(this.pVL == null || this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
                                if (this.pVL.cIf == 8) {
                                    C7060h.pYm.mo8381e(15368, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                } else {
                                    C7060h.pYm.mo8381e(15368, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                }
                            }
                            C30379h.m48447a(this.mController.ylL, this.tou.toc, "", this.tou.tod, false, new C248756());
                            AppMethodBeat.m2505o(46095);
                            return;
                        }
                    }
                    cOe();
                    AppMethodBeat.m2505o(46095);
                    return;
                }
            }
            i = 0;
            if (this.tqb != null) {
            }
            if (this.tou != null) {
            }
            cOe();
            AppMethodBeat.m2505o(46095);
            return;
        }
        AppMethodBeat.m2505o(46095);
    }

    /* JADX WARNING: Missing block: B:12:0x0080, code skipped:
            if (r2.tmT == 0.0d) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cOe() {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(46096);
        C7060h.pYm.mo8381e(13958, Integer.valueOf(1));
        if (this.pVL != null && 8 == this.pVL.cIf) {
            C7060h.pYm.mo8381e(13955, Integer.valueOf(2));
            if (this.pVL.vwh != null) {
                long j = this.pVL.vwh.getLong("extinfo_key_9");
                C7060h.pYm.mo8381e(13956, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - j));
            }
        }
        if (this.toH != null) {
            this.tpu = C29666c.tDU.mo47919a(this.pWy);
            C46330j acU = this.tpu.acU(this.toH.tzb);
            if (acU != null) {
            }
        }
        i = 0;
        if (i != 0) {
            C46332s.cNC();
            if (C46332s.cND().cQh()) {
                C4990ab.m7416i(this.TAG, "payWithoutPassword zeroPay");
                if (this.pVL != null) {
                    i2 = this.pVL.cIf;
                }
                C44422ad.m80306e(i2, this.pVL == null ? "" : this.pVL.czZ, 3, "");
                cOf();
                AppMethodBeat.m2505o(46096);
                return;
            }
            C4990ab.m7416i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
            cNQ();
            AppMethodBeat.m2505o(46096);
        } else if (this.tpz) {
            C4990ab.m7416i(this.TAG, "hy: start do pay with force use given bankcard");
            if (C5046bo.isNullOrNil(this.tpA)) {
                C46332s.cNC();
                if (C46332s.cND().cQi()) {
                    C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 17, "");
                } else {
                    C46332s.cNC();
                    if (C46332s.cND().cQh()) {
                        C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 5, "");
                    }
                }
                mo41720b(false, 0, "");
                AppMethodBeat.m2505o(46096);
                return;
            }
            this.tgC = cOh();
            cNQ();
            AppMethodBeat.m2505o(46096);
        } else {
            String bc = C5046bo.m7532bc(getIntent().getStringExtra("key_is_use_default_card"), "");
            if (!C5046bo.isNullOrNil(bc)) {
                this.tgC = acu(bc);
            }
            if (this.tgC != null) {
                i = this.tgC.mo69481a(this.pWy.tuo, this.pWy);
                if (this.pQU != null) {
                    this.pQU.mo63379bs(10002, "");
                }
                if (i != 0) {
                    C4990ab.m7416i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
                    mo41721c(false, i, "");
                    AppMethodBeat.m2505o(46096);
                    return;
                }
                C46332s.cNC();
                if (C46332s.cND().cQh()) {
                    C4990ab.m7416i(this.TAG, "payWithoutPassword");
                    if (this.pVL != null) {
                        i2 = this.pVL.cIf;
                    }
                    C44422ad.m80306e(i2, this.pVL == null ? "" : this.pVL.czZ, 3, "");
                    cOf();
                    AppMethodBeat.m2505o(46096);
                    return;
                }
                C4990ab.m7416i(this.TAG, "has useful bankcard ! payWithOldBankcard");
                cNQ();
                AppMethodBeat.m2505o(46096);
            } else if (this.tgB == null || this.tgB.size() <= 0) {
                C4990ab.m7416i(this.TAG, "default bankcard not found! payWithNewBankcard");
                C46332s.cNC();
                if (C46332s.cND().cQi()) {
                    C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 17, "");
                } else {
                    C46332s.cNC();
                    if (C46332s.cND().cQh()) {
                        C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 5, "");
                    }
                }
                mo41720b(false, 0, "");
                AppMethodBeat.m2505o(46096);
            } else {
                C4990ab.m7416i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
                mo41721c(false, 8, "");
                AppMethodBeat.m2505o(46096);
            }
        }
    }

    private void cOf() {
        AppMethodBeat.m2504i(46097);
        mo41734na(true);
        C40148d.cSP();
        AppMethodBeat.m2505o(46097);
    }

    private boolean cNG() {
        AppMethodBeat.m2504i(138087);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(0))).intValue();
        if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
            intValue = 1;
        }
        if (intValue == 1 || (this.pWy != null && this.pWy.tAN == 1)) {
            AppMethodBeat.m2505o(138087);
            return true;
        }
        AppMethodBeat.m2505o(138087);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cNQ() {
        AppMethodBeat.m2504i(46098);
        mo41733mZ(false);
        AppMethodBeat.m2505o(46098);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mZ */
    public final void mo41733mZ(boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(46099);
        if (arW()) {
            int i;
            String str;
            this.toK = false;
            C4990ab.m7417i(this.TAG, "pay with old bankcard! from statck %s", C5046bo.dpG().toString());
            if (this.pVL == null) {
                i = 0;
            } else {
                i = this.pVL.cIf;
            }
            if (this.pVL == null) {
                str = "";
            } else {
                str = this.pVL.czZ;
            }
            C44422ad.m80306e(i, str, 8, "");
            if (this.tpP != null) {
                C4990ab.m7420w(this.TAG, "close previous cashier dialog");
                this.tpP.dismiss();
            }
            this.toK = false;
            if (cNG()) {
                this.tpP = new C4432b(this.mController.ylL);
                C4432b c4432b = (C4432b) this.tpP;
                PayInfo payInfo = this.pVL;
                Orders orders = this.pWy;
                FavorPayInfo favorPayInfo = this.toH;
                Bankcard bankcard = this.tgC;
                if (!this.tpz) {
                    z2 = true;
                }
                c4432b.mo9472a(payInfo, orders, favorPayInfo, bankcard, z2, z);
                c4432b.tMA = new C248767();
                c4432b.show();
                addDialog(c4432b);
                AppMethodBeat.m2505o(46099);
                return;
            }
            boolean z3;
            if (this.tpz) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.tpP = C40131q.m68803a(this, z3, this.pWy, this.toH, this.tgC, this.pVL, this.pRx, new C248778(), new C43759(), new C2488810());
            this.toJ = (C22624d) this.tpP;
            AppMethodBeat.m2505o(46099);
            return;
        }
        AppMethodBeat.m2505o(46099);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo41720b(boolean z, int i, String str) {
        AppMethodBeat.m2504i(46100);
        String str2 = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        C46332s.cNC();
        C4990ab.m7410d(str2, stringBuilder.append(C46332s.cND().cQg()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String Y;
            if (C5046bo.isNullOrNil(str)) {
                Y = Bankcard.m78502Y(this, i);
            } else {
                Y = str;
            }
            C30379h.m48466d(this, Y, "", getString(C25738R.string.fnt), getString(C25738R.string.f9076or), new C2488011(), new C2488513());
            AppMethodBeat.m2505o(46100);
            return;
        }
        cOg();
        AppMethodBeat.m2505o(46100);
    }

    /* renamed from: c */
    public final void mo41721c(boolean z, final int i, String str) {
        AppMethodBeat.m2504i(46101);
        C4990ab.m7410d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(z)));
        if (z) {
            String Y;
            if (C5046bo.isNullOrNil(str)) {
                Y = Bankcard.m78502Y(this, i);
            } else {
                Y = str;
            }
            C30379h.m48466d(this, Y, "", getString(C25738R.string.fob), getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46050);
                    if (WalletPayUI.m38851l(WalletPayUI.this)) {
                        WalletPayUI.this.mo41733mZ(true);
                        AppMethodBeat.m2505o(46050);
                        return;
                    }
                    WalletPayUI.this.mo41718ap(i, false);
                    AppMethodBeat.m2505o(46050);
                }
            }, new C2486715());
            AppMethodBeat.m2505o(46101);
        } else if (cNG()) {
            mo41733mZ(true);
            AppMethodBeat.m2505o(46101);
        } else {
            mo41718ap(i, false);
            AppMethodBeat.m2505o(46101);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cOg() {
        AppMethodBeat.m2504i(46102);
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        C46332s.cNC();
        extras.putInt(str, C46332s.cND().cQg() ? 2 : 1);
        extras.putParcelable("key_orders", this.pWy);
        extras.putParcelable("key_pay_info", this.pVL);
        extras.putParcelable("key_favor_pay_info", this.toH);
        mo41717Q(extras);
        AppMethodBeat.m2505o(46102);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ap */
    public final void mo41718ap(int i, boolean z) {
        String str;
        int i2 = 0;
        AppMethodBeat.m2504i(46103);
        C7060h.pYm.mo8381e(13958, Integer.valueOf(2));
        C7060h.pYm.mo8381e(13955, Integer.valueOf(4));
        if (this.pVL != null) {
            i2 = this.pVL.cIf;
        }
        if (this.pVL == null) {
            str = "";
        } else {
            str = this.pVL.czZ;
        }
        C44422ad.m80306e(i2, str, 11, "");
        Bundle bundle = this.mBundle;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.pWy);
        bundle.putParcelable("key_pay_info", this.pVL);
        bundle.putParcelable("key_authen", cOb());
        bundle.putString("key_pwd1", this.gHr);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.toH);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.tgC != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.tgC.field_bindSerial);
        }
        mo41717Q(bundle);
        AppMethodBeat.m2505o(46103);
    }

    /* renamed from: a */
    private void m38834a(C22530f c22530f) {
        C7060h c7060h;
        Object[] objArr;
        AppMethodBeat.m2504i(46104);
        C4990ab.m7417i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", c22530f.cRb, Integer.valueOf(c22530f.tot));
        if ("1".equals(c22530f.cRb) || "2".equals(c22530f.cRb)) {
            this.tqb = c22530f;
        } else {
            this.tqb = null;
        }
        this.tou = c22530f.tou;
        this.tpZ = true;
        this.pWy = c22530f.pWy;
        this.mCount = this.pWy != null ? this.pWy.tAq.size() : 0;
        C4990ab.m7410d(this.TAG, "get mOrders! bankcardTag : " + (this.pWy != null ? Integer.valueOf(this.pWy.tuo) : ""));
        arW();
        if (!(this.pWy == null || this.pWy.tAr == null)) {
            this.tpu = C29666c.tDU.mo47919a(this.pWy);
            if (this.tpu != null) {
                if (this.tpu.cRl().size() > 0) {
                    this.tpv = true;
                }
                this.toH = this.tpu.acX(this.pWy.tAr.tmU);
                this.toH.tzb = this.tpu.acY(this.toH.tzb);
                C4990ab.m7417i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", this.pWy.tAr.tmU, this.toH.tzb, this.toH.tzb, this.toH.toString());
            }
        }
        if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
            C40148d.m68848a(this.pVL, this.pWy);
            c7060h = C7060h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.pVL.cIf);
            objArr[1] = Integer.valueOf(0);
            C46332s.cNC();
            objArr[2] = Integer.valueOf(C46332s.cND().cQg() ? 2 : 1);
            objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
            objArr[4] = this.pWy.pcl;
            c7060h.mo8381e(10690, objArr);
        }
        if (!(this.pWy == null || this.pWy.tAq == null)) {
            LinkedList linkedList = new LinkedList();
            for (Commodity commodity : this.pWy.tAq) {
                linkedList.add(commodity.cAa);
            }
            if (linkedList.size() > 0) {
                C32651uu c32651uu = new C32651uu();
                c32651uu.cRC.cRE = linkedList;
                C4879a.xxA.mo10055m(c32651uu);
                if (this.pQU != null) {
                    this.pQU.mo63379bs(10001, (String) linkedList.get(0));
                }
            }
        }
        if (!(this.pWy == null || this.pWy.tAO == null || this.pWy.tAO.tBL != 1 || C5046bo.isNullOrNil(this.pWy.tAO.pbo))) {
            this.tpz = true;
            this.tpA = this.pWy.tAO.pbo;
        }
        C46332s.cNC();
        this.tgB = C46332s.cND().mo38172ng(cOk());
        if (C5046bo.isNullOrNil(this.tpA)) {
            C46332s.cNC();
            this.tgC = C46332s.cND().mo38130a(null, null, cOk(), false);
        } else {
            this.tgC = cOh();
        }
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("key_is_use_default_card"), "");
        if (!C5046bo.isNullOrNil(bc)) {
            this.tgC = acu(bc);
        }
        this.pTi.setClickable(true);
        if (C5046bo.isNullOrNil(C14241r.cPI().tDg)) {
            this.tpL.setVisibility(8);
            this.tpL.setText("");
        } else {
            this.tpL.setVisibility(0);
            this.tpL.setText(C14241r.cPI().tDg);
        }
        if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
            C40148d.m68848a(this.pVL, this.pWy);
            c7060h = C7060h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.pVL.cIf);
            objArr[1] = Integer.valueOf(0);
            C46332s.cNC();
            objArr[2] = Integer.valueOf(C46332s.cND().cQg() ? 2 : 1);
            objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
            objArr[4] = this.pWy.pcl;
            c7060h.mo8381e(10690, objArr);
        }
        if (this.tpU) {
            mo41718ap(0, false);
        }
        long j = cOl().vwh == null ? 0 : cOl().vwh.getLong("wallet_pay_key_check_time");
        if (j > 0) {
            C7060h.pYm.mo8378a(641, 4, 1, true);
            C7060h.pYm.mo8378a(641, 5, C5046bo.m7566gb(j), true);
        }
        if (this.tqh > 0) {
            C7060h.pYm.mo8378a(641, 7, 1, true);
            C7060h.pYm.mo8378a(641, 8, C5046bo.m7566gb(this.tqh), true);
        }
        AppMethodBeat.m2505o(46104);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46105);
        C4990ab.m7417i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        C14157b c14157b;
        Bundle bundle;
        Bundle bundle2;
        boolean z;
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C22530f) {
                this.Ahw = 1;
                this.tpt = (C22530f) c1207m;
                final C22530f c22530f = (C22530f) c1207m;
                if (c22530f.bLD()) {
                    final C24147k c24147k = c22530f.nYe;
                    c24147k.mo39945a((Activity) this, new C36377e() {
                        public final void onCancel() {
                            AppMethodBeat.m2504i(46052);
                            if (c24147k.dNM()) {
                                WalletPayUI.m38835a(WalletPayUI.this, c22530f);
                                AppMethodBeat.m2505o(46052);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.m2505o(46052);
                        }

                        public final void cMX() {
                            AppMethodBeat.m2504i(46053);
                            if (c24147k.dNM()) {
                                WalletPayUI.m38835a(WalletPayUI.this, c22530f);
                                AppMethodBeat.m2505o(46053);
                                return;
                            }
                            WalletPayUI.this.cNX();
                            AppMethodBeat.m2505o(46053);
                        }

                        public final void cMY() {
                            AppMethodBeat.m2504i(46054);
                            if (c24147k.dNM()) {
                                WalletPayUI.m38835a(WalletPayUI.this, c22530f);
                                AppMethodBeat.m2505o(46054);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.m2505o(46054);
                        }
                    });
                    AppMethodBeat.m2505o(46105);
                    return true;
                }
                m38834a(c22530f);
            } else if (c1207m instanceof C14157b) {
                this.Ahw = 1;
                c14157b = (C14157b) c1207m;
                this.tqi = false;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!C5046bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", c14157b.token);
                bundle.putParcelable("key_authen", c14157b.toh);
                bundle.putBoolean("key_need_verify_sms", !c14157b.tof);
                bundle.putInt("key_can_verify_tail", c14157b.tol);
                bundle.putString("key_verify_tail_wording", c14157b.tom);
                bundle2 = this.mBundle;
                String str2 = "key_block_bind_new_card";
                if (c14157b.ton == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bundle2.putBoolean(str2, z);
                if (C5046bo.isNullOrNil(c14157b.toi)) {
                    bundle.putString("key_mobile", this.tgC.field_mobile);
                } else {
                    bundle.putString("key_mobile", c14157b.toi);
                }
                bundle.putString("key_QADNA_URL", c14157b.toj);
                if (c14157b.tpw) {
                    if (this.pQU != null) {
                        this.pQU.mo63379bs(10003, "");
                        C40052a c40052a = this.pQU;
                        C7060h.pYm.mo8381e(13455, c40052a.teR, Long.valueOf(System.currentTimeMillis()), c40052a.teS);
                    }
                    bundle.putParcelable("key_orders", c14157b.tog);
                    if (this.pVL != null) {
                        C4990ab.m7417i(this.TAG, "payscene %d", Integer.valueOf(this.pVL.cIf));
                        if (8 == this.pVL.cIf) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.pWy);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.gHr);
                C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
                int i3 = 0;
                if (c30052l.bxe()) {
                    i3 = 1;
                } else if (c30052l.bxh()) {
                    i3 = 2;
                }
                bundle3.putInt("key_open_biometric_type", i3);
                c30052l.mo48287a(c14157b.cNJ(), true, bundle3);
                bundle.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                mo41717Q(bundle);
                AppMethodBeat.m2505o(46105);
                return true;
            }
            mo41731cu();
            AppMethodBeat.m2505o(46105);
            return true;
        }
        if (c1207m instanceof C14157b) {
            this.tqi = false;
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            ((C30052l) C1720g.m3528K(C30052l.class)).mo48287a(this.pVL.tKd == 1, false, bundle);
            if (i2 == -1 || i2 == -500) {
                this.Ahw = 3;
            } else {
                this.Ahw = 2;
            }
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    c14157b = (C14157b) c1207m;
                    this.tpC = this.mBundle;
                    this.tpC.putParcelable("key_pay_info", this.pVL);
                    this.tpC.putParcelable("key_bankcard", this.tgC);
                    if (!C5046bo.isNullOrNil(this.gHr)) {
                        this.tpC.putString("key_pwd1", this.gHr);
                    }
                    this.tpC.putString("kreq_token", c14157b.token);
                    this.tpC.putParcelable("key_authen", c14157b.toh);
                    this.tpC.putBoolean("key_need_verify_sms", !c14157b.tof);
                    this.tpC.putString("key_mobile", this.tgC.field_mobile);
                    this.tpC.putInt("key_err_code", i2);
                    this.tpC.putParcelable("key_orders", this.pWy);
                    if (C5046bo.isNullOrNil(str)) {
                        string = getString(C25738R.string.fp0, new Object[]{this.tgC.field_desc, this.tgC.field_mobile});
                    } else {
                        string = str;
                    }
                    C30379h.m48466d(this, string, "", getString(C25738R.string.foz), getString(C25738R.string.f9076or), new C2486817(), new C1418818());
                    AppMethodBeat.m2505o(46105);
                    return true;
                case 404:
                    if (!(this.tgC == null || this.pWy == null)) {
                        this.tgC.twR = this.pWy.czZ;
                        if (this.tgB == null || this.tgB.size() <= 1) {
                            mo41720b(true, 4, str);
                        } else {
                            mo41721c(true, 4, str);
                        }
                        AppMethodBeat.m2505o(46105);
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.pVL.vwi = i2;
                    cNQ();
                    AppMethodBeat.m2505o(46105);
                    return true;
                case 100100:
                case 100101:
                    this.pVL.vwi = i2;
                    z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.toI == null) {
                        this.toI = new C14196a(this, this);
                    }
                    this.toI.mo26486a(z, this.pVL.cBS, this.pVL.czZ);
                    C4990ab.m7416i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z)));
                    AppMethodBeat.m2505o(46105);
                    return true;
            }
        } else if (c1207m instanceof C22530f) {
            this.tpZ = true;
            cOi();
            if (i2 == 416) {
                C4990ab.m7412e(this.TAG, "errCode is 416 need real name verify!");
                this.Ahw = 2;
                this.tpW = true;
                bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle2.putString("realname_verify_process_jump_plugin", "wallet");
                z = C43795a.m78490a((Activity) this, i2, c1207m, bundle2, this.pVL != null ? this.pVL.cIf : 0);
                AppMethodBeat.m2505o(46105);
                return z;
            }
            this.Ahw = 3;
            C4990ab.m7417i(this.TAG, "errCode is %d , not need real name verify!", Integer.valueOf(i2));
        }
        AppMethodBeat.m2505o(46105);
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean arW() {
        AppMethodBeat.m2504i(46106);
        String string;
        if (this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0) {
            C4990ab.m7420w(this.TAG, "mOrders info is Illegal!");
            if (this.tpt == null || !this.tpt.bLD()) {
                string = getString(C25738R.string.fkw);
                if (!(this.tpt == null || C5046bo.isNullOrNil(this.tpt.aIm))) {
                    string = this.tpt.aIm;
                }
                C4990ab.m7417i(this.TAG, "checkInfo() errMsg:%s", string);
                C30379h.m48438a(this.mController.ylL, string, "", new C2488619());
                AppMethodBeat.m2505o(46106);
                return false;
            }
            AppMethodBeat.m2505o(46106);
            return false;
        } else if (!this.tpz || C5046bo.isNullOrNil(this.tpA) || cOh() != null) {
            AppMethodBeat.m2505o(46106);
            return true;
        } else if (this.tpt == null || !this.tpt.bLD()) {
            C4990ab.m7420w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
            string = getString(C25738R.string.fkw);
            if (!(this.tpt == null || C5046bo.isNullOrNil(this.tpt.aIm))) {
                string = this.tpt.aIm;
            }
            C4990ab.m7417i(this.TAG, "checkInfo() errMsg:%s", string);
            C30379h.m48438a(this.mController.ylL, string, "", new C2253420());
            AppMethodBeat.m2505o(46106);
            return false;
        } else {
            AppMethodBeat.m2505o(46106);
            return false;
        }
    }

    private Bankcard cOh() {
        AppMethodBeat.m2504i(46107);
        C46332s.cNC();
        ArrayList nf = C46332s.cND().mo38171nf(true);
        if (nf.size() != 0) {
            Iterator it = nf.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (C5046bo.nullAsNil(this.tpA).equals(bankcard.field_bindSerial)) {
                    C4990ab.m7416i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.m2505o(46107);
                    return bankcard;
                }
            }
        }
        AppMethodBeat.m2505o(46107);
        return null;
    }

    private Bankcard acu(String str) {
        AppMethodBeat.m2504i(46108);
        C46332s.cNC();
        ArrayList nf = C46332s.cND().mo38171nf(true);
        if (nf.size() != 0) {
            Iterator it = nf.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (C5046bo.nullAsNil(str).equals(bankcard.field_bindSerial)) {
                    C4990ab.m7416i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.m2505o(46108);
                    return bankcard;
                }
            }
        }
        AppMethodBeat.m2505o(46108);
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46109);
        C4990ab.m7416i(this.TAG, "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.tpY = intent.getIntExtra("auto_deduct_flag", -1);
                        this.pWy.tAv.tpY = this.tpY;
                        cOl().vwk = this.tpY;
                        if (this.tpY == 1) {
                            cOl().vwl = intent.getStringExtra("deduct_bank_type");
                            cOl().vwm = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.tpX = true;
                    bwQ();
                } else {
                    finish();
                }
                C7060h.pYm.mo8381e(13958, Integer.valueOf(3));
                AppMethodBeat.m2505o(46109);
                return;
            case 1:
                this.tpP.dismiss();
                this.tpD = false;
                cNX();
                break;
        }
        AppMethodBeat.m2505o(46109);
    }

    public final boolean bwQ() {
        int i;
        boolean z = false;
        AppMethodBeat.m2504i(46110);
        C4990ab.m7417i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", Boolean.valueOf(this.tqc));
        C4879a.xxA.mo10055m(new C37805ul());
        if (this.pWy == null || this.pWy.tAv == null || this.tpX) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        if (i2 == 0 && !cOi()) {
            C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 2, "");
        }
        if (this.tqc) {
            mo41732mY(true);
            z = true;
        } else if (this.tpW) {
            z = true;
        } else if (i2 != 0) {
            Intent intent = new Intent(this, WalletPayDeductUI.class);
            intent.putExtra("orders", this.pWy);
            startActivityForResult(intent, 0);
            z = true;
        } else if (this.mController.contentView.getVisibility() != 0) {
            if (!this.tpD && arW()) {
                mo41732mY(true);
                this.tpD = true;
            }
            z = true;
        } else if (!(this.mController.contentView.getVisibility() != 0 || this.pWy == null || this.pWy.tAv == null || !this.pTi.isEnabled() || this.tqa)) {
            this.pTi.performClick();
            this.tqa = true;
        }
        AppMethodBeat.m2505o(46110);
        return z;
    }

    public final boolean bwP() {
        AppMethodBeat.m2504i(46111);
        if (this.tpZ) {
            String str = this.TAG;
            String str2 = "case 1 %s,  stack %s";
            Object[] objArr = new Object[2];
            boolean z = cOl() == null || !cOl().mXg;
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = C5046bo.dpG().toString();
            C4990ab.m7417i(str, str2, objArr);
            str = this.TAG;
            str2 = "case 2 %s,";
            objArr = new Object[1];
            C46332s.cNC();
            if (C46332s.cND().cQg()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7411d(str, str2, objArr);
            str = this.TAG;
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.tgB == null ? 0 : this.tgB.size());
            objArr[1] = this.tgC == null ? "" : this.tgC.field_forbidWord;
            C4990ab.m7411d(str, str2, objArr);
            if (cOl() == null || !cOl().mXg) {
                C4990ab.m7416i(this.TAG, "get isTransparent1");
                AppMethodBeat.m2505o(46111);
                return false;
            }
            C46332s.cNC();
            if (!C46332s.cND().cQg()) {
                C4990ab.m7416i(this.TAG, "get isTransparent2");
                AppMethodBeat.m2505o(46111);
                return false;
            } else if (this.tgB == null || (this.tgB.size() != 0 && (this.tgC == null || C5046bo.isNullOrNil(this.tgC.field_forbidWord)))) {
                C4990ab.m7416i(this.TAG, "get isTransparent4");
                AppMethodBeat.m2505o(46111);
                return true;
            } else {
                str = this.TAG;
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                if (this.tgB == null || this.tgB.size() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                z = (this.tgC == null || C5046bo.isNullOrNil(this.tgC.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                AppMethodBeat.m2505o(46111);
                return false;
            }
        }
        C4990ab.m7416i(this.TAG, "get isTransparent5");
        AppMethodBeat.m2505o(46111);
        return true;
    }

    private boolean cOi() {
        AppMethodBeat.m2504i(46112);
        if (bwP()) {
            mo9439AM(4);
            C5222ae.m7955m(this, 0);
            AppMethodBeat.m2505o(46112);
            return false;
        }
        mo9439AM(0);
        C5222ae.m7955m(this, this.mController.dyj());
        AppMethodBeat.m2505o(46112);
        return true;
    }

    public final boolean cNR() {
        return true;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(46113);
        if (i == 0) {
            if (bwP()) {
                finish();
                AppMethodBeat.m2505o(46113);
                return;
            }
        } else if (i == 1) {
            cNQ();
        }
        AppMethodBeat.m2505o(46113);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: na */
    public void mo41734na(boolean z) {
        AppMethodBeat.m2504i(46114);
        C1207m a = C40071a.m68666a(cOb(), this.pWy, z);
        if (this.pWy != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.pWy.czZ);
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", this.tpQ);
            a.eHT = "PayProcess";
            a.mBundle = bundle;
        }
        if (this.pVL != null) {
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                a.gOW = 100;
            } else {
                a.gOW = this.pVL.cIf;
            }
        }
        mo39970a(a, true, true);
        if (!(this.pVL == null || 8 != this.pVL.cIf || this.pVL.vwh == null)) {
            long j = this.pVL.vwh.getLong("extinfo_key_9");
            C7060h.pYm.mo8381e(13956, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j));
        }
        AppMethodBeat.m2505o(46114);
    }

    private boolean cOj() {
        AppMethodBeat.m2504i(46115);
        if (this.pWy != null && this.pWy.tAi) {
            C1720g.m3537RQ();
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(196614, Boolean.TRUE)).booleanValue()) {
                View inflate = getLayoutInflater().inflate(2130971149, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(2131828987);
                m38843en(inflate);
                ((TextView) inflate.findViewById(2131823800)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(46059);
                        checkBox.setChecked(!checkBox.isChecked());
                        AppMethodBeat.m2505o(46059);
                    }
                });
                final C5653c a = C30379h.m48437a((Context) this, getString(C25738R.string.foy), inflate, getString(C25738R.string.fcv), getString(C25738R.string.frg), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46060);
                        if (checkBox.isChecked()) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(196614, Boolean.FALSE);
                        }
                        WalletPayUI.this.mo41732mY(false);
                        AppMethodBeat.m2505o(46060);
                    }
                }, new C2488324());
                a.setCancelable(false);
                checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.m2504i(46063);
                        Button button = a.getButton(-2);
                        if (z) {
                            button.setEnabled(false);
                            AppMethodBeat.m2505o(46063);
                            return;
                        }
                        button.setEnabled(true);
                        AppMethodBeat.m2505o(46063);
                    }
                });
                AppMethodBeat.m2505o(46115);
                return false;
            }
        }
        AppMethodBeat.m2505o(46115);
        return true;
    }

    /* renamed from: en */
    private void m38843en(View view) {
        AppMethodBeat.m2504i(46116);
        TextView textView = (TextView) view.findViewById(2131826339);
        textView.setText(Html.fromHtml(String.format(getResources().getString(C25738R.string.fow), new Object[]{getResources().getString(C25738R.string.f87)})));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(46116);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cOk() {
        return (this.pVL == null || this.pVL.cIf == 11) ? false : true;
    }

    /* Access modifiers changed, original: protected|final */
    public final PayInfo cOl() {
        AppMethodBeat.m2504i(46117);
        if (this.pVL == null) {
            this.pVL = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        PayInfo payInfo = this.pVL;
        AppMethodBeat.m2505o(46117);
        return payInfo;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Q */
    public void mo41717Q(Bundle bundle) {
        AppMethodBeat.m2504i(46118);
        this.tpx = true;
        if (this.pWy != null) {
            bundle.putInt("key_support_bankcard", this.pWy.tuo);
            bundle.putString("key_reqKey", this.pWy.czZ);
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", this.tpQ);
        }
        if (this.pVL != null) {
            bundle.putInt("key_scene", this.pVL.cIf);
        }
        bundle.putBoolean("key_is_oversea", !cOc());
        bundle.putInt("is_deduct_open", this.tpY);
        this.tpy = new C2487326();
        C24143a.m37106a((Activity) this, C14167b.class, bundle, this.tpy);
        AppMethodBeat.m2505o(46118);
    }

    /* renamed from: c */
    public final void mo26490c(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(46119);
        C4990ab.m7416i(this.TAG, "onGenFinish callback");
        if (z) {
            C4990ab.m7416i(this.TAG, "onGenFinish callback, result.isSuccess is true");
            this.pVL.cBU = str;
            this.pVL.cBV = str2;
            mo41734na(false);
            C40148d.cSP();
            AppMethodBeat.m2505o(46119);
            return;
        }
        C4990ab.m7412e(this.TAG, "onGenFinish callback, result.isSuccess is false");
        mo41734na(false);
        C40148d.cSP();
        AppMethodBeat.m2505o(46119);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46120);
        super.onPause();
        if (this.toJ != null) {
            this.toJ.onActivityPause();
        }
        AppMethodBeat.m2505o(46120);
    }

    /* renamed from: b */
    private boolean m38838b(C22530f c22530f) {
        int i = 0;
        AppMethodBeat.m2504i(46121);
        boolean a;
        if ("1".equals(c22530f.cRb)) {
            C4990ab.m7416i(this.TAG, "need realname verify");
            this.tpW = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            bwP();
            if (this.pVL != null) {
                i = this.pVL.cIf;
            }
            a = C43795a.m78493a(this, bundle, null, i);
            AppMethodBeat.m2505o(46121);
            return a;
        } else if ("2".equals(c22530f.cRb)) {
            C4990ab.m7416i(this.TAG, "need upload credit");
            a = C43795a.m78495a((Activity) this, c22530f.cRc, c22530f.cRf, c22530f.cRd, c22530f.cRe, bwP(), null);
            AppMethodBeat.m2505o(46121);
            return a;
        } else {
            C4990ab.m7416i(this.TAG, "realnameGuideFlag =  " + c22530f.cRb);
            AppMethodBeat.m2505o(46121);
            return false;
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m38844f(WalletPayUI walletPayUI) {
        boolean z;
        AppMethodBeat.m2504i(46123);
        Bundle bundle = new Bundle();
        if (walletPayUI.pWy != null) {
            bundle.putString("key_reqKey", walletPayUI.pWy.czZ);
            if (walletPayUI.pWy.tAq != null && walletPayUI.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", walletPayUI.tpQ);
        }
        if (walletPayUI.pVL != null) {
            bundle.putInt("key_scene", walletPayUI.pVL.cIf);
        }
        if (walletPayUI.pVL == null || walletPayUI.pVL.cIf != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        String str = "key_is_oversea";
        if (walletPayUI.cOc()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        C24143a.m37106a((Activity) walletPayUI, C31458a.class, bundle, null);
        AppMethodBeat.m2505o(46123);
    }
}
