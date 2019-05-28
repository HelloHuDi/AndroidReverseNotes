package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bo;

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
        AppMethodBeat.i(111948);
        super.onFinishInflate();
        this.niL = (LinearLayout) findViewById(R.id.c9s);
        this.niM = (GameSmallAvatarList) findViewById(R.id.c9t);
        this.niN = (TextView) findViewById(R.id.c9u);
        this.niO = (LinearLayout) findViewById(R.id.o7);
        this.kEq = (TextView) findViewById(R.id.c9v);
        AppMethodBeat.o(111948);
    }

    public void setData(y yVar) {
        AppMethodBeat.i(111949);
        if (bo.ek(yVar.nar) && yVar.nas == null) {
            this.niL.setVisibility(8);
        } else {
            this.niL.setVisibility(0);
            this.niM.setData(yVar.nar);
            if (yVar.nas != null) {
                this.niN.setText(yVar.nas);
                this.niN.setVisibility(0);
            } else {
                this.niN.setVisibility(8);
            }
        }
        if (yVar.Desc != null) {
            this.niO.setVisibility(0);
            this.kEq.setText(yVar.Desc);
            AppMethodBeat.o(111949);
            return;
        }
        this.niO.setVisibility(8);
        AppMethodBeat.o(111949);
    }
}
