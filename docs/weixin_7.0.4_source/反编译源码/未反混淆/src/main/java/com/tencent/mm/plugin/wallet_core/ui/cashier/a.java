package com.tencent.mm.plugin.wallet_core.ui.cashier;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.cashier.b.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends i {
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
    a tLG;
    b tLH = new b() {
        public final void cSa() {
            AppMethodBeat.i(47736);
            ab.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
            a.this.dismiss();
            AppMethodBeat.o(47736);
        }
    };
    private ImageView tLy;
    ViewGroup tLz;
    com.tencent.mm.plugin.wallet_core.utils.a tln;
    FavorPayInfo toH;
    /* renamed from: try */
    Bankcard f0try;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$5 */
    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ Bankcard tgn;

        AnonymousClass5(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(47740);
            Intent intent = new Intent();
            ab.i("MicroMsg.WcPayCashierBankcardDialog", "go to url %s", this.tgn.field_forbid_url);
            intent.putExtra("rawUrl", this.tgn.field_forbid_url);
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("pay_channel", 1);
            d.b(a.this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 1);
            AppMethodBeat.o(47740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$6 */
    class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ Bankcard tgn;

        AnonymousClass6(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(47741);
            ab.d("MicroMsg.WcPayCashierBankcardDialog", "click bankcard: %s", this.tgn.field_bindSerial);
            a.a(a.this, view);
            a.this.dismiss();
            if (a.this.tLG != null) {
                a.this.tLG.i(this.tgn);
            }
            AppMethodBeat.o(47741);
        }
    }

    public interface a {
        void cMN();

        void i(Bankcard bankcard);

        void onCancel();
    }

    public a(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(47743);
        this.mContext = context;
        this.ius = (ViewGroup) View.inflate(getContext(), R.layout.b6s, null);
        this.tLy = (ImageView) this.ius.findViewById(R.id.fi7);
        this.tLz = (ViewGroup) this.ius.findViewById(R.id.fi9);
        this.tLA = (TextView) this.ius.findViewById(R.id.fi8);
        ImageView imageView = this.tLy;
        int i = b.tLO;
        int i2 = b.tLO;
        bo.n(imageView, i, i, i2, i2);
        this.tLy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47739);
                a.this.cancel();
                AppMethodBeat.o(47739);
            }
        });
        setContentView(this.ius);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47737);
                if (a.this.tLG != null) {
                    a.this.tLG.onCancel();
                }
                AppMethodBeat.o(47737);
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(47738);
                a.this.tln.destory();
                AppMethodBeat.o(47738);
            }
        });
        this.tln = new com.tencent.mm.plugin.wallet_core.utils.a();
        AppMethodBeat.o(47743);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(47744);
        super.onCreate(bundle);
        if (this.pVL == null) {
            ab.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
            dismiss();
        }
        z.hL(7, 0);
        AppMethodBeat.o(47744);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(47745);
        bVar.tMB.remove(this.tLH);
        AppMethodBeat.o(47745);
    }

    /* Access modifiers changed, original: final */
    public final LinkedList<String> g(Bankcard bankcard) {
        AppMethodBeat.i(47746);
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
            Iterator it = this.pWy.tAr.tnf.tmA.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.pbo.equals(bankcard.field_bindSerial)) {
                    it = cVar.tmL.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((com.tencent.mm.plugin.wallet.a.d) it.next()).pOz);
                    }
                    AppMethodBeat.o(47746);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(47746);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    public final LinkedList<String> cRZ() {
        AppMethodBeat.i(47747);
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
            n nVar = this.pWy.tAr.tnf.tmB;
            if (nVar != null) {
                Iterator it = nVar.tns.iterator();
                while (it.hasNext()) {
                    linkedList.add(((o) it.next()).pOz);
                }
                AppMethodBeat.o(47747);
                return linkedList;
            }
        }
        AppMethodBeat.o(47747);
        return linkedList;
    }

    static /* synthetic */ void a(a aVar, View view) {
        AppMethodBeat.i(47748);
        for (View view2 : aVar.tLB) {
            if (view2 == view) {
                view2.tLL.setChecked(true);
            } else {
                view2.tLL.setChecked(false);
            }
        }
        AppMethodBeat.o(47748);
    }
}
