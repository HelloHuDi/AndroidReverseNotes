package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class b implements OnClickListener {
    protected int lSl = 1301;
    protected Context mContext;
    protected int mXC;

    public b(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, n nVar) {
        if (nVar == null) {
            ab.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (bo.isNullOrNil(nVar.field_appId)) {
            ab.e("MicroMsg.GameMessageOnClickListener", "message type : " + nVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", nVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return c.b(context, nVar.field_appId, null, bundle);
        }
    }
}
