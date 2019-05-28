package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.ui.PoiHeaderView */
public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView eku;
    public String nMe = "";
    public String nMf = "";
    public SimpleImageView nMg;

    /* renamed from: com.tencent.mm.plugin.location.ui.PoiHeaderView$1 */
    class C344091 implements OnClickListener {
        C344091() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113468);
            Intent intent = new Intent();
            C4990ab.m7411d("MicroMsg.PoiHeaderView", "click url %s", C5046bo.isNullOrNil(PoiHeaderView.this.nMf) ? PoiHeaderView.this.nMe : PoiHeaderView.this.nMf);
            intent.putExtra("rawUrl", r0);
            intent.putExtra("showShare", false);
            C25985d.m41473f(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(113468);
        }
    }

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113469);
        this.context = context;
        View inflate = View.inflate(this.context, 2130970367, this);
        this.eku = (TextView) inflate.findViewById(2131826555);
        this.nMg = (SimpleImageView) inflate.findViewById(2131826556);
        this.eku.setVisibility(8);
        this.nMg.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new C344091());
        AppMethodBeat.m2505o(113469);
    }

    public void setViewUrl(String str) {
        AppMethodBeat.m2504i(113470);
        C4990ab.m7410d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(str)));
        this.nMf = str;
        AppMethodBeat.m2505o(113470);
    }
}
