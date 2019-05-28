package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedAddTopicView extends LinearLayout implements OnClickListener {
    private d neV;
    private GameFeedTitleDescView nim;
    private TextView nin;

    public GameFeedAddTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111922);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(R.id.c5d);
        this.nin = (TextView) findViewById(R.id.c5e);
        setOnClickListener(this);
        AppMethodBeat.o(111922);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111923);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naH == null) {
            setVisibility(8);
            AppMethodBeat.o(111923);
            return;
        }
        this.neV = dVar;
        setVisibility(0);
        this.nim.b(dVar.mVH.naH.Title, dVar.mVH.naH.Desc, null);
        this.nin.setText(dVar.mVH.naH.mZY);
        if (!this.neV.mVJ) {
            a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111923);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111924);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.o(111924);
            return;
        }
        if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.o(111924);
    }
}
