package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C28229n.C28231e;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.model.o */
public final class C43192o implements OnClickListener {
    private Context mContext;
    public int mXC;

    /* renamed from: com.tencent.mm.plugin.game.model.o$a */
    public static class C12173a {
        public int cKG = 1301;
        public C28229n mXD;
        public String mXx;
        public int position;

        public C12173a(C28229n c28229n, String str, int i) {
            this.mXD = c28229n;
            this.mXx = str;
            this.position = i;
        }
    }

    public C43192o(Context context) {
        this.mContext = context;
    }

    public C43192o(Context context, int i) {
        this.mContext = context;
        this.mXC = i;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(111292);
        if (view.getTag() == null || !(view.getTag() instanceof C12173a)) {
            C4990ab.m7412e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            AppMethodBeat.m2505o(111292);
            return;
        }
        C12173a c12173a = (C12173a) view.getTag();
        if (c12173a.mXD == null) {
            C4990ab.m7412e("MicroMsg.GameMessageClickListener", "message is null");
            AppMethodBeat.m2505o(111292);
        } else if (c12173a.mXx == null) {
            C4990ab.m7412e("MicroMsg.GameMessageClickListener", "jumpId is null");
            AppMethodBeat.m2505o(111292);
        } else {
            C28231e c28231e = (C28231e) c12173a.mXD.mWu.get(c12173a.mXx);
            if (c28231e == null) {
                C4990ab.m7412e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                AppMethodBeat.m2505o(111292);
                return;
            }
            int a = C43192o.m76770a(this.mContext, c12173a.mXD, c28231e, c12173a.mXD.field_appId, c12173a.cKG);
            if (a != 0) {
                C34277b.m56210a(this.mContext, 13, c12173a.cKG, c12173a.position, a, 0, c12173a.mXD.field_appId, this.mXC, c12173a.mXD.mXb, c12173a.mXD.field_gameMsgId, c12173a.mXD.mXc, null);
            }
            AppMethodBeat.m2505o(111292);
        }
    }

    /* renamed from: a */
    public static int m76770a(Context context, C28229n c28229n, C28231e c28231e, String str, int i) {
        AppMethodBeat.m2504i(111293);
        int i2 = 0;
        switch (c28231e.mXo) {
            case 1:
                i2 = C43192o.m76773i(context, str, i);
                break;
            case 2:
                i2 = C43192o.m76771au(context, str);
                break;
            case 3:
                i2 = C43192o.m76774j(context, str, i);
                break;
            case 4:
                i2 = C43192o.m76769a(context, c28229n, i);
                break;
            case 5:
                i2 = C43192o.m76772av(context, c28231e.lAF);
                break;
            default:
                C4990ab.m7416i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + c28231e.mXo);
                break;
        }
        AppMethodBeat.m2505o(111293);
        return i2;
    }

    /* renamed from: au */
    private static int m76771au(Context context, String str) {
        AppMethodBeat.m2504i(111294);
        if (C46494g.m87757u(context, str)) {
            C20993e.m32265ak(context, str);
            AppMethodBeat.m2505o(111294);
            return 3;
        }
        AppMethodBeat.m2505o(111294);
        return 0;
    }

    /* renamed from: i */
    private static int m76773i(Context context, String str, int i) {
        AppMethodBeat.m2504i(111295);
        if (C46494g.m87757u(context, str)) {
            C20993e.m32265ak(context, str);
            AppMethodBeat.m2505o(111295);
            return 3;
        }
        int j = C43192o.m76774j(context, str, i);
        AppMethodBeat.m2505o(111295);
        return j;
    }

    /* renamed from: j */
    private static int m76774j(Context context, String str, int i) {
        AppMethodBeat.m2504i(111296);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111296);
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        int b = C46001c.m85457b(context, str, null, bundle);
        AppMethodBeat.m2505o(111296);
        return b;
    }

    /* renamed from: a */
    private static int m76769a(Context context, C28229n c28229n, int i) {
        AppMethodBeat.m2504i(111297);
        if (c28229n != null) {
            c28229n.field_isRead = true;
            ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10103c(c28229n, new String[0]);
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameMessageUI");
        intent.putExtra("game_report_from_scene", i);
        context.startActivity(intent);
        AppMethodBeat.m2505o(111297);
        return 6;
    }

    /* renamed from: av */
    private static int m76772av(Context context, String str) {
        AppMethodBeat.m2504i(111298);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111298);
            return 0;
        }
        int ax = C46001c.m85455ax(context, str);
        AppMethodBeat.m2505o(111298);
        return ax;
    }
}
