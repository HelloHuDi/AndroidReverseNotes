package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class d {
    protected String appId;
    protected Context context;
    protected a jDq;
    protected String openId;

    public interface a {
        void ft(boolean z);
    }

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.jDq = aVar;
    }

    public final void aVi() {
        AppMethodBeat.i(18124);
        if (this.openId == null || this.openId.length() == 0) {
            ab.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.jDq.ft(true);
            AppMethodBeat.o(18124);
            return;
        }
        f bT = g.bT(this.appId, false);
        if (bT == null) {
            ab.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.jDq.ft(true);
            AppMethodBeat.o(18124);
        } else if (ah.isNullOrNil(bT.field_openId)) {
            ab.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            ab.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            am.bYL().wy(this.appId);
            this.jDq.ft(true);
            AppMethodBeat.o(18124);
        } else if (this.openId.equalsIgnoreCase(bT.field_openId)) {
            ab.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.jDq.ft(true);
            AppMethodBeat.o(18124);
        } else {
            ab.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + bT.field_openId);
            aVh();
            AppMethodBeat.o(18124);
        }
    }

    /* Access modifiers changed, original: protected */
    public void aVh() {
        AppMethodBeat.i(18125);
        h.b(this.context, (int) R.string.daw, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18122);
                com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                if (bDb != null) {
                    bDb.m(d.this.openId, r.YC(), d.this.appId);
                }
                d.this.jDq.ft(true);
                AppMethodBeat.o(18122);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18123);
                com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                if (bDb != null) {
                    bDb.m(d.this.openId, r.YC(), d.this.appId);
                }
                d.this.jDq.ft(false);
                AppMethodBeat.o(18123);
            }
        });
        AppMethodBeat.o(18125);
    }
}
