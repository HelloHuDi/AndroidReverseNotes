package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a implements f {
    Activity czX;
    p mzU;
    b ppH;
    private ap ppI = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(23796);
            if (!a.this.czX.isFinishing()) {
                a aVar = a.this;
                Context context = a.this.czX;
                a.this.czX.getString(R.string.tz);
                aVar.mzU = h.b(context, a.this.czX.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(23795);
                        aw.Rg().c(a.this.ppH);
                        a.this.mzU = null;
                        AppMethodBeat.o(23795);
                    }
                });
            }
            AppMethodBeat.o(23796);
            return false;
        }
    }, false);

    public a(Activity activity) {
        AppMethodBeat.i(23797);
        this.czX = activity;
        AppMethodBeat.o(23797);
    }

    public final void fF(String str, String str2) {
        AppMethodBeat.i(23798);
        if (str == null) {
            ab.e("MicroMsg.ViewTWeibo", "null weibo id");
            AppMethodBeat.o(23798);
            return;
        }
        aw.Rg().a(205, (f) this);
        this.ppH = new b(bo.nullAsNil(str).replace("http://t.qq.com/", "").trim(), str2);
        aw.Rg().a(this.ppH, 0);
        this.ppI.ae(3000, 3000);
        AppMethodBeat.o(23798);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23799);
        aw.Rg().b(205, (f) this);
        b bVar = (b) mVar;
        if (i == 0 && i2 == 0) {
            UW(bVar.getURL());
            AppMethodBeat.o(23799);
            return;
        }
        if (i != 4) {
            ab.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        UW("http://t.qq.com/" + bVar.pkH);
        AppMethodBeat.o(23799);
    }

    private void UW(String str) {
        AppMethodBeat.i(23800);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.czX.getString(R.string.b2a));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        d.b(this.czX, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23800);
    }
}
