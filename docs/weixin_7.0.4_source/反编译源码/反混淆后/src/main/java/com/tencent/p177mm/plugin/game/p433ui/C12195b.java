package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.b */
public abstract class C12195b implements OnClickListener {
    protected int lSl = 1301;
    protected Context mContext;
    protected int mXC;

    public C12195b(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    /* renamed from: a */
    protected static int m20128a(Context context, C28229n c28229n) {
        if (c28229n == null) {
            C4990ab.m7412e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (C5046bo.isNullOrNil(c28229n.field_appId)) {
            C4990ab.m7412e("MicroMsg.GameMessageOnClickListener", "message type : " + c28229n.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", c28229n.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return C46001c.m85457b(context, c28229n.field_appId, null, bundle);
        }
    }
}
