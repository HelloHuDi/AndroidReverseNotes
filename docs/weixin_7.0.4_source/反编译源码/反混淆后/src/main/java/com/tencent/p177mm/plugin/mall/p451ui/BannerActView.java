package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.model.C14265u;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C14237a;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C29636b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mall.ui.BannerActView */
public class BannerActView extends LinearLayout {
    private List<C14237a> olh;
    private C14265u oli;
    private TextView olj = ((TextView) LayoutInflater.from(getContext()).inflate(2130968831, this, true).findViewById(2131821702));

    /* renamed from: com.tencent.mm.plugin.mall.ui.BannerActView$1 */
    class C345091 implements OnClickListener {
        C345091() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43127);
            BannerActView.this.setVisibility(8);
            C29636b.m47011dT(BannerActView.this.olh);
            if (BannerActView.this.olh != null && BannerActView.this.olh.size() > 0) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ((C14237a) BannerActView.this.olh.get(0)).tDk);
                C25985d.m41467b(BannerActView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(43127);
        }
    }

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43128);
        setOnClickListener(new C345091());
        AppMethodBeat.m2505o(43128);
    }

    public void setData(C14265u c14265u) {
        AppMethodBeat.m2504i(43129);
        this.oli = c14265u;
        if (this.oli != null) {
            this.olj.setText(this.oli.field_bulletin_content);
            setVisibility(0);
            AppMethodBeat.m2505o(43129);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(43129);
    }

    public void setActivityList(List<C14237a> list) {
        AppMethodBeat.m2504i(43130);
        this.olh = list;
        if (this.olh == null || this.olh.size() <= 0) {
            C4990ab.m7416i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
        } else if (C29636b.m47010dS(this.olh)) {
            this.olj.setText(((C14237a) this.olh.get(0)).tDj);
            setVisibility(0);
            AppMethodBeat.m2505o(43130);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(43130);
    }
}
