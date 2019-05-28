package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.a.a;

public class GameIndexSearchView extends LinearLayout {
    private Context mContext;
    LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexSearchView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nfb;

        AnonymousClass1(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            int t;
            AppMethodBeat.i(111986);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a bDN = com.tencent.mm.plugin.game.model.a.bDN();
                if (bDN.bJt == 2) {
                    t = c.t(GameIndexSearchView.this.mContext, bDN.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameIndexSearchView.this.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameIndexSearchView.this.mContext.startActivity(intent);
                    t = 6;
                }
            } else {
                t = c.t(GameIndexSearchView.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            b.a(GameIndexSearchView.this.mContext, 14, 1401, 1, t, 0, null, this.nfb, 0, null, null, null);
            AppMethodBeat.o(111986);
        }
    }

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111987);
        setOrientation(0);
        this.mContext = context;
        AppMethodBeat.o(111987);
    }
}
