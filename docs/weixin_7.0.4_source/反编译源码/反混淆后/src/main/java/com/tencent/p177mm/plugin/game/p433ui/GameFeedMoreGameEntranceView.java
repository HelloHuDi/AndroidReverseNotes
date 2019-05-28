package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView */
public class GameFeedMoreGameEntranceView extends RelativeLayout implements OnClickListener {
    private C28226d neV;
    /* renamed from: sW */
    private TextView f1265sW;

    public GameFeedMoreGameEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111939);
        super.onFinishInflate();
        this.f1265sW = (TextView) findViewById(2131824299);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111939);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111940);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naI == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111940);
            return;
        }
        this.neV = c28226d;
        setVisibility(0);
        this.f1265sW.setText(c28226d.mVH.naI.Desc);
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111940);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111941);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.m2505o(111941);
            return;
        }
        if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.m2505o(111941);
    }
}
