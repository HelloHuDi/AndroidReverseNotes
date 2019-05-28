package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C39211a;
import com.tencent.p177mm.plugin.game.model.C39211a.C3243a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameInfoViewForeign */
public class GameInfoViewForeign extends RelativeLayout {
    private int edE = 0;
    private Context mContext;
    private int mXC = 0;
    private TextView njq;
    private int njr = 2;
    private OnClickListener njs = new C121841();

    /* renamed from: com.tencent.mm.plugin.game.ui.GameInfoViewForeign$1 */
    class C121841 implements OnClickListener {
        C121841() {
        }

        public final void onClick(View view) {
            int t;
            AppMethodBeat.m2504i(111992);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                C3243a bDN = C39211a.bDN();
                if (bDN.bJt == 2) {
                    t = C46001c.m85464t(GameInfoViewForeign.this.mContext, bDN.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameInfoViewForeign.this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameInfoViewForeign.this.mContext.startActivity(intent);
                    t = 6;
                }
            } else {
                t = C46001c.m85464t(GameInfoViewForeign.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            C34277b.m56210a(GameInfoViewForeign.this.mContext, 10, 1001, GameInfoViewForeign.this.njr, t, 0, null, GameInfoViewForeign.this.mXC, 0, null, null, C34277b.m56213eA("resource", "5"));
            AppMethodBeat.m2505o(111992);
        }
    }

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111993);
        this.mContext = context;
        AppMethodBeat.m2505o(111993);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111994);
        super.onFinishInflate();
        setOnClickListener(this.njs);
        this.njq = (TextView) findViewById(2131824385);
        bFo();
        C4990ab.m7416i("MicroMsg.GameInfoViewForeign", "initView finished");
        AppMethodBeat.m2505o(111994);
    }

    public final void bFo() {
        AppMethodBeat.m2504i(111995);
        this.edE = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEw();
        if (this.edE > 0 && this.edE <= 99) {
            this.njq.setVisibility(0);
            this.njq.setText(this.edE);
            AppMethodBeat.m2505o(111995);
        } else if (this.edE > 99) {
            this.njq.setVisibility(0);
            this.njq.setText("99+");
            this.njq.setTextSize(1, 9.0f);
            AppMethodBeat.m2505o(111995);
        } else {
            this.njq.setVisibility(4);
            AppMethodBeat.m2505o(111995);
        }
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }
}
