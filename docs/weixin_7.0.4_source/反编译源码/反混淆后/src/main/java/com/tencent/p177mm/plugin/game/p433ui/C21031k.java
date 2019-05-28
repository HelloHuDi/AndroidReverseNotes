package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.k */
public final class C21031k implements OnClickListener, OnItemClickListener {
    protected int mXC = 0;

    public final void setSourceScene(int i) {
        this.mXC = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(112006);
        Object item = adapterView.getAdapter().getItem(i);
        if (item == null || !(item instanceof C20992c)) {
            AppMethodBeat.m2505o(112006);
            return;
        }
        C20992c c20992c = (C20992c) item;
        if (C5046bo.isNullOrNil(c20992c.field_appId)) {
            AppMethodBeat.m2505o(112006);
            return;
        }
        m32335a(view.getContext(), c20992c);
        AppMethodBeat.m2505o(112006);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112007);
        if (view.getTag() == null || !(view.getTag() instanceof C20992c)) {
            AppMethodBeat.m2505o(112007);
            return;
        }
        m32335a(view.getContext(), (C20992c) view.getTag());
        AppMethodBeat.m2505o(112007);
    }

    /* renamed from: a */
    private void m32335a(Context context, C20992c c20992c) {
        AppMethodBeat.m2504i(112008);
        int i = 0;
        if (c20992c.type == 1) {
            i = C46001c.m85455ax(context, c20992c.mVm);
        } else if (c20992c.type == 0) {
            if (c20992c.bDP() && !C5046bo.isNullOrNil(c20992c.mVF.mZj) && !C46494g.m87726a(context, (C40439f) c20992c)) {
                i = C46001c.m85455ax(context, c20992c.mVF.mZj);
            } else if (C5046bo.isNullOrNil(c20992c.dng) || c20992c.dnj != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", c20992c.field_appId);
                if (c20992c.cKG == 1601) {
                    bundle.putInt("game_report_from_scene", this.mXC);
                } else {
                    bundle.putInt("game_report_from_scene", c20992c.cKG);
                }
                i = C46001c.m85457b(context, c20992c.field_appId, c20992c.mVm, bundle);
            } else {
                C4990ab.m7416i("MicroMsg.GameItemClickListener", "Download via Google Play");
                C35800q.m58699by(context, c20992c.dng);
                i = 25;
            }
        }
        m32336a(context, c20992c, i);
        AppMethodBeat.m2505o(112008);
    }

    /* renamed from: a */
    private void m32336a(Context context, C20992c c20992c, int i) {
        AppMethodBeat.m2504i(112009);
        C34277b.m56212a(context, c20992c.scene, c20992c.cKG, c20992c.position, i, c20992c.field_appId, this.mXC, c20992c.ctu, c20992c.mVB);
        AppMethodBeat.m2505o(112009);
    }
}
