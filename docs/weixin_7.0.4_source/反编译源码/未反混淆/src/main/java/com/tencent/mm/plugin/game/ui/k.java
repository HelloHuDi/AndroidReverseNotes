package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k implements OnClickListener, OnItemClickListener {
    protected int mXC = 0;

    public final void setSourceScene(int i) {
        this.mXC = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(112006);
        Object item = adapterView.getAdapter().getItem(i);
        if (item == null || !(item instanceof c)) {
            AppMethodBeat.o(112006);
            return;
        }
        c cVar = (c) item;
        if (bo.isNullOrNil(cVar.field_appId)) {
            AppMethodBeat.o(112006);
            return;
        }
        a(view.getContext(), cVar);
        AppMethodBeat.o(112006);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112007);
        if (view.getTag() == null || !(view.getTag() instanceof c)) {
            AppMethodBeat.o(112007);
            return;
        }
        a(view.getContext(), (c) view.getTag());
        AppMethodBeat.o(112007);
    }

    private void a(Context context, c cVar) {
        AppMethodBeat.i(112008);
        int i = 0;
        if (cVar.type == 1) {
            i = com.tencent.mm.plugin.game.f.c.ax(context, cVar.mVm);
        } else if (cVar.type == 0) {
            if (cVar.bDP() && !bo.isNullOrNil(cVar.mVF.mZj) && !g.a(context, (f) cVar)) {
                i = com.tencent.mm.plugin.game.f.c.ax(context, cVar.mVF.mZj);
            } else if (bo.isNullOrNil(cVar.dng) || cVar.dnj != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", cVar.field_appId);
                if (cVar.cKG == 1601) {
                    bundle.putInt("game_report_from_scene", this.mXC);
                } else {
                    bundle.putInt("game_report_from_scene", cVar.cKG);
                }
                i = com.tencent.mm.plugin.game.f.c.b(context, cVar.field_appId, cVar.mVm, bundle);
            } else {
                ab.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                q.by(context, cVar.dng);
                i = 25;
            }
        }
        a(context, cVar, i);
        AppMethodBeat.o(112008);
    }

    private void a(Context context, c cVar, int i) {
        AppMethodBeat.i(112009);
        b.a(context, cVar.scene, cVar.cKG, cVar.position, i, cVar.field_appId, this.mXC, cVar.ctu, cVar.mVB);
        AppMethodBeat.o(112009);
    }
}
