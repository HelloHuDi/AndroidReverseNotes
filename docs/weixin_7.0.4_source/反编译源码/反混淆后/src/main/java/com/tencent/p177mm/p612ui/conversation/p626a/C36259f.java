package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;

/* renamed from: com.tencent.mm.ui.conversation.a.f */
public final class C36259f extends C14933b {
    String zwk = null;
    String zwl = null;

    /* renamed from: com.tencent.mm.ui.conversation.a.f$1 */
    class C158611 implements OnClickListener {
        C158611() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34650);
            Intent intent = new Intent((Context) C36259f.this.vlu.get(), SelectContactUI.class);
            intent.putExtra("list_attr", C15830s.m24193hs(C15830s.znD, 256));
            intent.putExtra("list_type", 10);
            intent.putExtra("received_card_name", C36259f.this.zwk);
            intent.putExtra("recommend_friends", true);
            intent.putExtra("titile", ((Context) C36259f.this.vlu.get()).getString(C25738R.string.f8782eu));
            ((Context) C36259f.this.vlu.get()).startActivity(intent);
            C9638aw.m17190ZK().mo33885Yk().mo60660oW(C36259f.this.zwk);
            C9638aw.m17190ZK().mo33885Yk().mo60660oW(C36259f.this.zwl);
            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, C36259f.this.zwk, Integer.valueOf(2), Integer.valueOf(0));
            AppMethodBeat.m2505o(34650);
        }
    }

    public C36259f(Context context, String str, String str2) {
        super(context);
        AppMethodBeat.m2504i(34651);
        this.zwk = str;
        this.zwl = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(2131822695);
            this.view.setOnClickListener(new C158611());
            imageView.setImageBitmap(C41730b.m73490a(this.zwk, true, -1));
        }
        AppMethodBeat.m2505o(34651);
    }

    public final int getLayoutId() {
        return 2130969119;
    }

    public final void destroy() {
    }
}
