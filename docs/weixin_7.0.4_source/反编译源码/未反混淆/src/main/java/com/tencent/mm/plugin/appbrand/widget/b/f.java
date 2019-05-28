package com.tencent.mm.plugin.appbrand.widget.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class f {
    public static final String TAG = ("MicroMsg.AppBrand.Evaluate." + f.class.getSimpleName());
    public String appId;
    public String csu;
    public String cvF;
    public Dialog dialog;
    public boolean jcd = false;
    private int jce = 0;
    public TextView jcf;
    public RatingBar jcg;
    public TextView jch;
    public FrameLayout jci;
    public LinearLayout jcj;
    public int scene;
    public String userName;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$5 */
    public class AnonymousClass5 implements OnDismissListener {
        final /* synthetic */ Runnable val$runnable;

        public AnonymousClass5(Runnable runnable) {
            this.val$runnable = runnable;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(134257);
            ab.i(f.TAG, "user dismiss evaluate dialog");
            if (!f.this.jcd) {
                f.b(f.this);
            }
            f.P(this.val$runnable);
            AppMethodBeat.o(134257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$6 */
    public class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ Context val$context;

        public AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134258);
            if (f.this.jcg != null) {
                f.a(f.this, (int) f.this.jcg.getRating());
                Toast.makeText(this.val$context, this.val$context.getString(R.string.ie), 0).show();
                f.this.jcd = true;
                f.this.dismiss();
            }
            AppMethodBeat.o(134258);
        }
    }

    static /* synthetic */ void a(f fVar, int i, int i2) {
        AppMethodBeat.i(134273);
        fVar.dp(i, i2);
        AppMethodBeat.o(134273);
    }

    static {
        AppMethodBeat.i(134274);
        AppMethodBeat.o(134274);
    }

    private void a(cki cki) {
        AppMethodBeat.i(134265);
        a aVar = new a();
        aVar.fsI = 2521;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        aVar.fsJ = cki;
        aVar.fsK = new ckj();
        b.a(aVar.acD(), new b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(134263);
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof ckj)) {
                    ab.i(f.TAG, "updateEvaluateCgi, request success");
                    if (f.this.jcd) {
                        f.a(f.this, 3, 1);
                        AppMethodBeat.o(134263);
                        return;
                    }
                    f.a(f.this, 2, 1);
                    AppMethodBeat.o(134263);
                    return;
                }
                ab.e(f.TAG, "updateEvaluateCgi, request fail");
                if (f.this.jcd) {
                    f.a(f.this, 3, 2);
                    AppMethodBeat.o(134263);
                    return;
                }
                f.a(f.this, 2, 2);
                AppMethodBeat.o(134263);
            }
        });
        AppMethodBeat.o(134265);
    }

    private void qw(int i) {
        int i2 = R.string.ii;
        AppMethodBeat.i(134266);
        switch (i) {
            case 2:
                i2 = R.string.ik;
                break;
            case 3:
                i2 = R.string.ij;
                break;
            case 4:
                i2 = R.string.ih;
                break;
            case 5:
                i2 = R.string.ig;
                break;
        }
        this.jch.setText(i2);
        AppMethodBeat.o(134266);
    }

    public final void dismiss() {
        AppMethodBeat.i(134267);
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog = null;
        }
        AppMethodBeat.o(134267);
    }

    public final void dp(int i, int i2) {
        AppMethodBeat.i(134268);
        if (bo.isNullOrNil(this.appId)) {
            ab.e(TAG, "operateReport, no app id");
            AppMethodBeat.o(134268);
            return;
        }
        ab.i(TAG, "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", this.appId, Integer.valueOf(i), this.cvF, Integer.valueOf(this.jce), Integer.valueOf(this.scene), Integer.valueOf(i2), this.csu);
        h.pYm.e(16176, this.appId, Integer.valueOf(i), Long.valueOf(bo.anT()), Integer.valueOf(this.jce), this.cvF, this.csu, Integer.valueOf(this.scene), Integer.valueOf(i2));
        AppMethodBeat.o(134268);
    }

    static /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(134269);
        cki cki = new cki();
        cki.username = fVar.userName;
        cki.xin = 4;
        ab.i(TAG, "reportSkipEvaluate, userName:%s", fVar.userName);
        fVar.a(cki);
        AppMethodBeat.o(134269);
    }

    static /* synthetic */ void P(Runnable runnable) {
        AppMethodBeat.i(134270);
        if (runnable != null) {
            al.n(runnable, 100);
        }
        AppMethodBeat.o(134270);
    }
}
