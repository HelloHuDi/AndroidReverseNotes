package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C39211a;
import com.tencent.p177mm.plugin.game.model.C39211a.C3243a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;

/* renamed from: com.tencent.mm.plugin.game.ui.GameIndexSearchView */
public class GameIndexSearchView extends LinearLayout {
    private Context mContext;
    LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexSearchView$1 */
    class C32571 implements OnClickListener {
        final /* synthetic */ int nfb;

        C32571(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            int t;
            AppMethodBeat.m2504i(111986);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                C3243a bDN = C39211a.bDN();
                if (bDN.bJt == 2) {
                    t = C46001c.m85464t(GameIndexSearchView.this.mContext, bDN.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameIndexSearchView.this.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameIndexSearchView.this.mContext.startActivity(intent);
                    t = 6;
                }
            } else {
                t = C46001c.m85464t(GameIndexSearchView.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            C34277b.m56210a(GameIndexSearchView.this.mContext, 14, 1401, 1, t, 0, null, this.nfb, 0, null, null, null);
            AppMethodBeat.m2505o(111986);
        }
    }

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111987);
        setOrientation(0);
        this.mContext = context;
        AppMethodBeat.m2505o(111987);
    }
}
