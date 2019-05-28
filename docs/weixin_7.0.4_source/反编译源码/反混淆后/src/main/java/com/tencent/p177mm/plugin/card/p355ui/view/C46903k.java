package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.protocal.protobuf.C15395wy;

/* renamed from: com.tencent.mm.plugin.card.ui.view.k */
public final class C46903k extends C45800i {
    private View kqL;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88752);
        if (this.kqL == null) {
            this.kqL = ((ViewStub) findViewById(2131822030)).inflate();
        }
        this.kqL.setOnClickListener(this.kqK.bcz());
        C15395wy c15395wy = this.kqK.bcv().aZV().vUo;
        if (TextUtils.isEmpty(c15395wy.detail)) {
            findViewById(2131822010).setVisibility(8);
        } else {
            ((TextView) findViewById(2131822011)).setText(c15395wy.detail);
            findViewById(2131822010).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2131822009);
        if (c15395wy.wcS == null || c15395wy.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) c15395wy.wcS.get(0))) {
            imageView.setVisibility(8);
            AppMethodBeat.m2505o(88752);
            return;
        }
        String str = (String) c15395wy.wcS.get(0);
        imageView.setVisibility(0);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C6457e.eSn;
        C32291o.ahq();
        c17927a.ePY = null;
        c17927a.ePJ = C33770m.m55183Gz(str);
        c17927a.ePH = true;
        c17927a.eQf = false;
        c17927a.ePF = true;
        C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        AppMethodBeat.m2505o(88752);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88753);
        if (this.kqL != null) {
            this.kqL.setVisibility(8);
        }
        AppMethodBeat.m2505o(88753);
    }
}
