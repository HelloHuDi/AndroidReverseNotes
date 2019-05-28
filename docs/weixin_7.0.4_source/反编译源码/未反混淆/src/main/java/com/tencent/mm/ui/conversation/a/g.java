package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends b {
    boolean yFW = false;
    String zwk = null;
    String zwl = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        AppMethodBeat.i(34654);
        this.zwk = str;
        this.zwl = str2;
        this.yFW = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.id.au5);
            String ao = aw.ZK().Yl().ao(this.zwk, "wording");
            String ao2 = aw.ZK().Yl().ao(this.zwl, "wording");
            if (!bo.isNullOrNil(ao)) {
                textView.setText(ao);
            } else if (!bo.isNullOrNil(ao2)) {
                textView.setText(ao2);
            }
            ao = aw.ZK().Yl().ao(this.zwk, "linkname");
            ao2 = aw.ZK().Yl().ao(this.zwk, "linksrc");
            textView = (TextView) this.view.findViewById(R.id.au6);
            if (!bo.isNullOrNil(ao)) {
                textView.setText(ao);
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34652);
                    Intent intent = new Intent();
                    intent.putExtra("k_username", g.this.zwk);
                    int i = 39;
                    if (g.this.yFW) {
                        i = 36;
                    }
                    intent.putExtra("showShare", false);
                    if (bo.isNullOrNil(ao2)) {
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                    } else {
                        intent.putExtra("rawUrl", ao2);
                    }
                    if (g.this.vlu.get() != null) {
                        d.b((Context) g.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    aw.ZK().Yl().oW(g.this.zwk);
                    aw.ZK().Yl().oW(g.this.zwl);
                    AppMethodBeat.o(34652);
                }
            });
            ((ImageView) this.view.findViewById(R.id.au7)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34653);
                    aw.ZK().Yl().oW(g.this.zwk);
                    aw.ZK().Yl().oW(g.this.zwl);
                    AppMethodBeat.o(34653);
                }
            });
        }
        AppMethodBeat.o(34654);
    }

    public final int getLayoutId() {
        return R.layout.ny;
    }

    public final void destroy() {
    }
}
