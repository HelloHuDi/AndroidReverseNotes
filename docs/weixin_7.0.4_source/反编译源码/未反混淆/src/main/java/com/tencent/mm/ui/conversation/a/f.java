package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;

public final class f extends b {
    String zwk = null;
    String zwl = null;

    public f(Context context, String str, String str2) {
        super(context);
        AppMethodBeat.i(34651);
        this.zwk = str;
        this.zwl = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(R.id.au4);
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34650);
                    Intent intent = new Intent((Context) f.this.vlu.get(), SelectContactUI.class);
                    intent.putExtra("list_attr", s.hs(s.znD, 256));
                    intent.putExtra("list_type", 10);
                    intent.putExtra("received_card_name", f.this.zwk);
                    intent.putExtra("recommend_friends", true);
                    intent.putExtra("titile", ((Context) f.this.vlu.get()).getString(R.string.eu));
                    ((Context) f.this.vlu.get()).startActivity(intent);
                    aw.ZK().Yk().oW(f.this.zwk);
                    aw.ZK().Yk().oW(f.this.zwl);
                    h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, f.this.zwk, Integer.valueOf(2), Integer.valueOf(0));
                    AppMethodBeat.o(34650);
                }
            });
            imageView.setImageBitmap(com.tencent.mm.ah.b.a(this.zwk, true, -1));
        }
        AppMethodBeat.o(34651);
    }

    public final int getLayoutId() {
        return R.layout.nx;
    }

    public final void destroy() {
    }
}
