package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28231e;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.model.C43192o;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameMessageBubbleView */
public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private boolean mHasInit = false;
    View nle;
    private TextView nlf;
    private ImageView nlg;
    private C28229n nlh;
    private final long nli = 500;
    private long nlj = 0;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112084);
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.nlg = (ImageView) findViewById(2131824335);
            this.nlf = (TextView) findViewById(2131824336);
            this.nle = findViewById(2131824334);
            setVisibility(8);
            this.mHasInit = true;
        }
        AppMethodBeat.m2505o(112084);
    }

    public final void bFu() {
        AppMethodBeat.m2504i(112085);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        this.nlh = C39215q.bEq();
        if (this.nlh == null) {
            this.nle.setOnClickListener(null);
            setVisibility(8);
            AppMethodBeat.m2505o(112085);
            return;
        }
        this.nlh.bEl();
        if (this.nlh.field_msgType == 100 && (C5046bo.isNullOrNil(this.nlh.mWt.eeO) || C5046bo.isNullOrNil(this.nlh.mWt.mXj) || C5046bo.isNullOrNil(this.nlh.mWt.mXk) || !this.nlh.mWu.containsKey(this.nlh.mWt.mXk))) {
            C4990ab.m7420w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.nle.setOnClickListener(null);
            setVisibility(8);
            AppMethodBeat.m2505o(112085);
            return;
        }
        this.nlf.setText(this.nlh.mWt.eeO);
        C32291o.ahp().mo43765a(this.nlh.mWt.mXj, this.nlg);
        this.nle.setOnClickListener(this);
        setVisibility(0);
        AppMethodBeat.m2505o(112085);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112086);
        if (System.currentTimeMillis() - this.nlj <= 500) {
            AppMethodBeat.m2505o(112086);
        } else if (this.nlh == null) {
            AppMethodBeat.m2505o(112086);
        } else {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEr();
            int a;
            if (this.nlh.field_msgType == 100) {
                if (!C5046bo.isNullOrNil(this.nlh.mWt.mXk)) {
                    C28231e c28231e = (C28231e) this.nlh.mWu.get(this.nlh.mWt.mXk);
                    if (c28231e != null) {
                        a = C43192o.m76770a(this.mContext, this.nlh, c28231e, this.nlh.field_appId, 1007);
                        if (a != 0) {
                            C34277b.m56210a(this.mContext, 10, 1007, 1, a, 0, this.nlh.field_appId, 0, this.nlh.mXb, this.nlh.field_gameMsgId, this.nlh.mXc, null);
                        }
                        if (c28231e.mXo != 4) {
                            this.nlh.field_isRead = true;
                            ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10103c(this.nlh, new String[0]);
                        }
                    }
                }
                this.nlj = System.currentTimeMillis();
                AppMethodBeat.m2505o(112086);
                return;
            }
            if (!(this.nlh == null || this.nlh.mWw == 3)) {
                this.nlh.field_isRead = true;
                ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10103c(this.nlh, new String[0]);
            }
            switch (this.nlh.mWw) {
                case 1:
                    String str = this.nlh.mWi;
                    if (!C5046bo.isNullOrNil(str)) {
                        a = C46001c.m85464t(this.mContext, str, "game_center_bubble");
                        break;
                    } else {
                        a = 0;
                        break;
                    }
                case 2:
                    if (!C5046bo.isNullOrNil(this.nlh.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.nlh.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        a = C46001c.m85457b(this.mContext, this.nlh.field_appId, null, bundle);
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.GameMessageHeaderView", "message type : " + this.nlh.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1007);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.nlh.mWw);
                    AppMethodBeat.m2505o(112086);
                    return;
            }
            C34277b.m56210a(this.mContext, 10, 1007, 1, a, 0, this.nlh.field_appId, 0, this.nlh.field_msgType, this.nlh.field_gameMsgId, this.nlh.mXc, null);
            this.nlj = System.currentTimeMillis();
            AppMethodBeat.m2505o(112086);
        }
    }
}
