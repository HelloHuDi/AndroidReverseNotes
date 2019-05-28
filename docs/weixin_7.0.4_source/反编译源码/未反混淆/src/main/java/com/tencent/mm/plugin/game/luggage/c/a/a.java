package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.ui.base.l;

public abstract class a {
    int id;

    public abstract void a(Context context, d dVar, bbb bbb);

    public a(int i) {
        this.id = i;
    }

    public void a(d dVar, l lVar, bbb bbb) {
        lVar.e(bbb.wkB, bbb.Title + "__" + bbb.ThumbUrl);
    }
}
