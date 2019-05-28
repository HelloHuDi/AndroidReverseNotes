package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o implements OnClickListener {
    private Context mContext;
    public int mXC;

    public static class a {
        public int cKG = 1301;
        public n mXD;
        public String mXx;
        public int position;

        public a(n nVar, String str, int i) {
            this.mXD = nVar;
            this.mXx = str;
            this.position = i;
        }
    }

    public o(Context context) {
        this.mContext = context;
    }

    public o(Context context, int i) {
        this.mContext = context;
        this.mXC = i;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(111292);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            ab.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            AppMethodBeat.o(111292);
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.mXD == null) {
            ab.e("MicroMsg.GameMessageClickListener", "message is null");
            AppMethodBeat.o(111292);
        } else if (aVar.mXx == null) {
            ab.e("MicroMsg.GameMessageClickListener", "jumpId is null");
            AppMethodBeat.o(111292);
        } else {
            e eVar = (e) aVar.mXD.mWu.get(aVar.mXx);
            if (eVar == null) {
                ab.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                AppMethodBeat.o(111292);
                return;
            }
            int a = a(this.mContext, aVar.mXD, eVar, aVar.mXD.field_appId, aVar.cKG);
            if (a != 0) {
                b.a(this.mContext, 13, aVar.cKG, aVar.position, a, 0, aVar.mXD.field_appId, this.mXC, aVar.mXD.mXb, aVar.mXD.field_gameMsgId, aVar.mXD.mXc, null);
            }
            AppMethodBeat.o(111292);
        }
    }

    public static int a(Context context, n nVar, e eVar, String str, int i) {
        AppMethodBeat.i(111293);
        int i2 = 0;
        switch (eVar.mXo) {
            case 1:
                i2 = i(context, str, i);
                break;
            case 2:
                i2 = au(context, str);
                break;
            case 3:
                i2 = j(context, str, i);
                break;
            case 4:
                i2 = a(context, nVar, i);
                break;
            case 5:
                i2 = av(context, eVar.lAF);
                break;
            default:
                ab.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + eVar.mXo);
                break;
        }
        AppMethodBeat.o(111293);
        return i2;
    }

    private static int au(Context context, String str) {
        AppMethodBeat.i(111294);
        if (g.u(context, str)) {
            e.ak(context, str);
            AppMethodBeat.o(111294);
            return 3;
        }
        AppMethodBeat.o(111294);
        return 0;
    }

    private static int i(Context context, String str, int i) {
        AppMethodBeat.i(111295);
        if (g.u(context, str)) {
            e.ak(context, str);
            AppMethodBeat.o(111295);
            return 3;
        }
        int j = j(context, str, i);
        AppMethodBeat.o(111295);
        return j;
    }

    private static int j(Context context, String str, int i) {
        AppMethodBeat.i(111296);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111296);
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        int b = c.b(context, str, null, bundle);
        AppMethodBeat.o(111296);
        return b;
    }

    private static int a(Context context, n nVar, int i) {
        AppMethodBeat.i(111297);
        if (nVar != null) {
            nVar.field_isRead = true;
            ((com.tencent.mm.plugin.game.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().c(nVar, new String[0]);
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameMessageUI");
        intent.putExtra("game_report_from_scene", i);
        context.startActivity(intent);
        AppMethodBeat.o(111297);
        return 6;
    }

    private static int av(Context context, String str) {
        AppMethodBeat.i(111298);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111298);
            return 0;
        }
        int ax = c.ax(context, str);
        AppMethodBeat.o(111298);
        return ax;
    }
}
