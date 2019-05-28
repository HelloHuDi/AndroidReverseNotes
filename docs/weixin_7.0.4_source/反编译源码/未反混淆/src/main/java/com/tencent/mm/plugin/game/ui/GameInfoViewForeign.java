package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class GameInfoViewForeign extends RelativeLayout {
    private int edE = 0;
    private Context mContext;
    private int mXC = 0;
    private TextView njq;
    private int njr = 2;
    private OnClickListener njs = new OnClickListener() {
        public final void onClick(View view) {
            int t;
            AppMethodBeat.i(111992);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a bDN = com.tencent.mm.plugin.game.model.a.bDN();
                if (bDN.bJt == 2) {
                    t = c.t(GameInfoViewForeign.this.mContext, bDN.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameInfoViewForeign.this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameInfoViewForeign.this.mContext.startActivity(intent);
                    t = 6;
                }
            } else {
                t = c.t(GameInfoViewForeign.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            b.a(GameInfoViewForeign.this.mContext, 10, 1001, GameInfoViewForeign.this.njr, t, 0, null, GameInfoViewForeign.this.mXC, 0, null, null, b.eA("resource", "5"));
            AppMethodBeat.o(111992);
        }
    };

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111993);
        this.mContext = context;
        AppMethodBeat.o(111993);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111994);
        super.onFinishInflate();
        setOnClickListener(this.njs);
        this.njq = (TextView) findViewById(R.id.c2t);
        bFo();
        ab.i("MicroMsg.GameInfoViewForeign", "initView finished");
        AppMethodBeat.o(111994);
    }

    public final void bFo() {
        AppMethodBeat.i(111995);
        this.edE = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().bEw();
        if (this.edE > 0 && this.edE <= 99) {
            this.njq.setVisibility(0);
            this.njq.setText(this.edE);
            AppMethodBeat.o(111995);
        } else if (this.edE > 99) {
            this.njq.setVisibility(0);
            this.njq.setText("99+");
            this.njq.setTextSize(1, 9.0f);
            AppMethodBeat.o(111995);
        } else {
            this.njq.setVisibility(4);
            AppMethodBeat.o(111995);
        }
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }
}
