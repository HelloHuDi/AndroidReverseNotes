package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private boolean mHasInit = false;
    View nle;
    private TextView nlf;
    private ImageView nlg;
    private n nlh;
    private final long nli = 500;
    private long nlj = 0;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112084);
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.nlg = (ImageView) findViewById(R.id.c1g);
            this.nlf = (TextView) findViewById(R.id.c1h);
            this.nle = findViewById(R.id.c1f);
            setVisibility(8);
            this.mHasInit = true;
        }
        AppMethodBeat.o(112084);
    }

    public final void bFu() {
        AppMethodBeat.i(112085);
        ((b) g.K(b.class)).bCX();
        this.nlh = q.bEq();
        if (this.nlh == null) {
            this.nle.setOnClickListener(null);
            setVisibility(8);
            AppMethodBeat.o(112085);
            return;
        }
        this.nlh.bEl();
        if (this.nlh.field_msgType == 100 && (bo.isNullOrNil(this.nlh.mWt.eeO) || bo.isNullOrNil(this.nlh.mWt.mXj) || bo.isNullOrNil(this.nlh.mWt.mXk) || !this.nlh.mWu.containsKey(this.nlh.mWt.mXk))) {
            ab.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.nle.setOnClickListener(null);
            setVisibility(8);
            AppMethodBeat.o(112085);
            return;
        }
        this.nlf.setText(this.nlh.mWt.eeO);
        o.ahp().a(this.nlh.mWt.mXj, this.nlg);
        this.nle.setOnClickListener(this);
        setVisibility(0);
        AppMethodBeat.o(112085);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112086);
        if (System.currentTimeMillis() - this.nlj <= 500) {
            AppMethodBeat.o(112086);
        } else if (this.nlh == null) {
            AppMethodBeat.o(112086);
        } else {
            ((b) g.K(b.class)).bCX();
            q.bEr();
            int a;
            if (this.nlh.field_msgType == 100) {
                if (!bo.isNullOrNil(this.nlh.mWt.mXk)) {
                    e eVar = (e) this.nlh.mWu.get(this.nlh.mWt.mXk);
                    if (eVar != null) {
                        a = com.tencent.mm.plugin.game.model.o.a(this.mContext, this.nlh, eVar, this.nlh.field_appId, 1007);
                        if (a != 0) {
                            com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1007, 1, a, 0, this.nlh.field_appId, 0, this.nlh.mXb, this.nlh.field_gameMsgId, this.nlh.mXc, null);
                        }
                        if (eVar.mXo != 4) {
                            this.nlh.field_isRead = true;
                            ((c) g.K(c.class)).bCY().c(this.nlh, new String[0]);
                        }
                    }
                }
                this.nlj = System.currentTimeMillis();
                AppMethodBeat.o(112086);
                return;
            }
            if (!(this.nlh == null || this.nlh.mWw == 3)) {
                this.nlh.field_isRead = true;
                ((c) g.K(c.class)).bCY().c(this.nlh, new String[0]);
            }
            switch (this.nlh.mWw) {
                case 1:
                    String str = this.nlh.mWi;
                    if (!bo.isNullOrNil(str)) {
                        a = com.tencent.mm.plugin.game.f.c.t(this.mContext, str, "game_center_bubble");
                        break;
                    } else {
                        a = 0;
                        break;
                    }
                case 2:
                    if (!bo.isNullOrNil(this.nlh.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.nlh.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        a = com.tencent.mm.plugin.game.f.c.b(this.mContext, this.nlh.field_appId, null, bundle);
                        break;
                    }
                    ab.e("MicroMsg.GameMessageHeaderView", "message type : " + this.nlh.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1007);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    ab.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.nlh.mWw);
                    AppMethodBeat.o(112086);
                    return;
            }
            com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1007, 1, a, 0, this.nlh.field_appId, 0, this.nlh.field_msgType, this.nlh.field_gameMsgId, this.nlh.mXc, null);
            this.nlj = System.currentTimeMillis();
            AppMethodBeat.o(112086);
        }
    }
}
