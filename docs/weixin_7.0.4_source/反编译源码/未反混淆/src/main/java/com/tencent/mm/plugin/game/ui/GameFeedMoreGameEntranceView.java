package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedMoreGameEntranceView extends RelativeLayout implements OnClickListener {
    private d neV;
    private TextView sW;

    public GameFeedMoreGameEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111939);
        super.onFinishInflate();
        this.sW = (TextView) findViewById(R.id.c0h);
        setOnClickListener(this);
        AppMethodBeat.o(111939);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111940);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naI == null) {
            setVisibility(8);
            AppMethodBeat.o(111940);
            return;
        }
        this.neV = dVar;
        setVisibility(0);
        this.sW.setText(dVar.mVH.naI.Desc);
        if (!this.neV.mVJ) {
            a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111940);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111941);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.o(111941);
            return;
        }
        if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.o(111941);
    }
}
