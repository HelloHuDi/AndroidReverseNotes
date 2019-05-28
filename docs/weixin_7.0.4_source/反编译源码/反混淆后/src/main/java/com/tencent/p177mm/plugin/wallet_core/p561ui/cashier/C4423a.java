package com.tencent.p177mm.plugin.wallet_core.p561ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.p748a.C29527o;
import com.tencent.p177mm.plugin.wallet.p748a.C35391c;
import com.tencent.p177mm.plugin.wallet.p748a.C35392d;
import com.tencent.p177mm.plugin.wallet.p748a.C35396n;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b.C4449b;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a */
public final class C4423a extends C15532i {
    private ViewGroup ius;
    private Context mContext;
    PayInfo pVL = new PayInfo();
    Orders pWy = new Orders();
    TextView tLA;
    List<WcPayCashierBankcardItemLayout> tLB = new ArrayList();
    int tLC;
    boolean tLD;
    int tLE;
    boolean tLF = true;
    C4428a tLG;
    C4449b tLH = new C44311();
    private ImageView tLy;
    ViewGroup tLz;
    C40141a tln;
    FavorPayInfo toH;
    /* renamed from: try */
    Bankcard f1287try;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$4 */
    class C44244 implements OnClickListener {
        C44244() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47739);
            C4423a.this.cancel();
            AppMethodBeat.m2505o(47739);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$5 */
    class C44255 implements OnClickListener {
        final /* synthetic */ Bankcard tgn;

        C44255(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47740);
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.WcPayCashierBankcardDialog", "go to url %s", this.tgn.field_forbid_url);
            intent.putExtra("rawUrl", this.tgn.field_forbid_url);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("pay_channel", 1);
            C25985d.m41468b(C4423a.this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 1);
            AppMethodBeat.m2505o(47740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$6 */
    class C44266 implements OnClickListener {
        final /* synthetic */ Bankcard tgn;

        C44266(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47741);
            C4990ab.m7411d("MicroMsg.WcPayCashierBankcardDialog", "click bankcard: %s", this.tgn.field_bindSerial);
            C4423a.m6772a(C4423a.this, view);
            C4423a.this.dismiss();
            if (C4423a.this.tLG != null) {
                C4423a.this.tLG.mo9467i(this.tgn);
            }
            AppMethodBeat.m2505o(47741);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$7 */
    class C44277 implements OnClickListener {
        C44277() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47742);
            C4990ab.m7410d("MicroMsg.WcPayCashierBankcardDialog", "click bind new card");
            C4423a.this.dismiss();
            if (C4423a.this.tLG != null) {
                C4423a.this.tLG.cMN();
            }
            AppMethodBeat.m2505o(47742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$a */
    public interface C4428a {
        void cMN();

        /* renamed from: i */
        void mo9467i(Bankcard bankcard);

        void onCancel();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$2 */
    class C44292 implements OnCancelListener {
        C44292() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47737);
            if (C4423a.this.tLG != null) {
                C4423a.this.tLG.onCancel();
            }
            AppMethodBeat.m2505o(47737);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$3 */
    class C44303 implements OnDismissListener {
        C44303() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47738);
            C4423a.this.tln.destory();
            AppMethodBeat.m2505o(47738);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$1 */
    class C44311 implements C4449b {
        C44311() {
        }

        public final void cSa() {
            AppMethodBeat.m2504i(47736);
            C4990ab.m7416i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
            C4423a.this.dismiss();
            AppMethodBeat.m2505o(47736);
        }
    }

    public C4423a(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(47743);
        this.mContext = context;
        this.ius = (ViewGroup) View.inflate(getContext(), 2130971192, null);
        this.tLy = (ImageView) this.ius.findViewById(2131829097);
        this.tLz = (ViewGroup) this.ius.findViewById(2131829099);
        this.tLA = (TextView) this.ius.findViewById(2131829098);
        ImageView imageView = this.tLy;
        int i = C4432b.tLO;
        int i2 = C4432b.tLO;
        C5046bo.m7582n(imageView, i, i, i2, i2);
        this.tLy.setOnClickListener(new C44244());
        setContentView(this.ius);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new C44292());
        setOnDismissListener(new C44303());
        this.tln = new C40141a();
        AppMethodBeat.m2505o(47743);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47744);
        super.onCreate(bundle);
        if (this.pVL == null) {
            C4990ab.m7420w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
            dismiss();
        }
        C36381z.m59954hL(7, 0);
        AppMethodBeat.m2505o(47744);
    }

    /* renamed from: a */
    public final void mo9458a(C4432b c4432b) {
        AppMethodBeat.m2504i(47745);
        c4432b.tMB.remove(this.tLH);
        AppMethodBeat.m2505o(47745);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final LinkedList<String> mo9460g(Bankcard bankcard) {
        AppMethodBeat.m2504i(47746);
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
                    AppMethodBeat.m2505o(47746);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.m2505o(47746);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    public final LinkedList<String> cRZ() {
        AppMethodBeat.m2504i(47747);
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
            C35396n c35396n = this.pWy.tAr.tnf.tmB;
            if (c35396n != null) {
                Iterator it = c35396n.tns.iterator();
                while (it.hasNext()) {
                    linkedList.add(((C29527o) it.next()).pOz);
                }
                AppMethodBeat.m2505o(47747);
                return linkedList;
            }
        }
        AppMethodBeat.m2505o(47747);
        return linkedList;
    }

    /* renamed from: a */
    static /* synthetic */ void m6772a(C4423a c4423a, View view) {
        AppMethodBeat.m2504i(47748);
        for (View view2 : c4423a.tLB) {
            if (view2 == view) {
                view2.tLL.setChecked(true);
            } else {
                view2.tLL.setChecked(false);
            }
        }
        AppMethodBeat.m2505o(47748);
    }
}
