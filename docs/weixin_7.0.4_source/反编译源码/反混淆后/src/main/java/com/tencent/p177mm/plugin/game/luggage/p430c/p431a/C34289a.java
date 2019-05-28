package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.content.Context;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.protocal.protobuf.bbb;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.a */
public abstract class C34289a {
    /* renamed from: id */
    int f15049id;

    /* renamed from: a */
    public abstract void mo7540a(Context context, C24905d c24905d, bbb bbb);

    public C34289a(int i) {
        this.f15049id = i;
    }

    /* renamed from: a */
    public void mo54819a(C24905d c24905d, C44273l c44273l, bbb bbb) {
        c44273l.mo70068e(bbb.wkB, bbb.Title + "__" + bbb.ThumbUrl);
    }
}
