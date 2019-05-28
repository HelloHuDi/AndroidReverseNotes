package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p731d.C12123y;
import com.tencent.p177mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView */
public class GameFeedSocialInfoView extends LinearLayout {
    private TextView kEq;
    private LinearLayout niL;
    private GameSmallAvatarList niM;
    private TextView niN;
    private LinearLayout niO;

    public GameFeedSocialInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111948);
        super.onFinishInflate();
        this.niL = (LinearLayout) findViewById(2131824643);
        this.niM = (GameSmallAvatarList) findViewById(2131824644);
        this.niN = (TextView) findViewById(2131824645);
        this.niO = (LinearLayout) findViewById(2131821095);
        this.kEq = (TextView) findViewById(2131824646);
        AppMethodBeat.m2505o(111948);
    }

    public void setData(C12123y c12123y) {
        AppMethodBeat.m2504i(111949);
        if (C5046bo.m7548ek(c12123y.nar) && c12123y.nas == null) {
            this.niL.setVisibility(8);
        } else {
            this.niL.setVisibility(0);
            this.niM.setData(c12123y.nar);
            if (c12123y.nas != null) {
                this.niN.setText(c12123y.nas);
                this.niN.setVisibility(0);
            } else {
                this.niN.setVisibility(8);
            }
        }
        if (c12123y.Desc != null) {
            this.niO.setVisibility(0);
            this.kEq.setText(c12123y.Desc);
            AppMethodBeat.m2505o(111949);
            return;
        }
        this.niO.setVisibility(8);
        AppMethodBeat.m2505o(111949);
    }
}
