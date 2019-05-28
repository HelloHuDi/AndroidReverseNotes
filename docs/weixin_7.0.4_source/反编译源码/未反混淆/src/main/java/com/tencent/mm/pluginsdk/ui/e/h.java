package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.pluginsdk.ui.e.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

public class h {
    String hcl;
    Context mContext;
    private int tuT = 500;
    private long tuU = 0;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(View view, m mVar) {
        AppMethodBeat.i(79817);
        if (System.currentTimeMillis() - this.tuU <= ((long) this.tuT)) {
            ab.e("MicroMsg.MMSpanClickListener", "process pass");
            AppMethodBeat.o(79817);
            return;
        }
        this.tuU = System.currentTimeMillis();
        if (mVar == null) {
            ab.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
            AppMethodBeat.o(79817);
            return;
        }
        ab.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(mVar.type));
        if (this.mContext == null) {
            ab.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
            AppMethodBeat.o(79817);
            return;
        }
        g gVar;
        String str;
        if (j.vrX == null || j.vrX.size() <= 0) {
            gVar = null;
        } else {
            int size = j.vrX.size();
            g gVar2 = (g) j.vrX.getLast();
            ab.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
            gVar = gVar2;
        }
        if (view != null && (view.getTag() instanceof c)) {
            bi biVar = ((c) view.getTag()).cKd;
            if (biVar != null) {
                str = biVar.field_talker;
                if (t.mN(str)) {
                    str = bf.oy(biVar.field_content);
                }
                mVar.username = str;
                if (!TextUtils.isEmpty(this.hcl)) {
                    mVar.hcl = this.hcl;
                }
                a.vrC.a(this.mContext, mVar, gVar);
                mVar.hcl = null;
                AppMethodBeat.o(79817);
            }
        }
        str = (view == null || !(view.getTag() instanceof com.tencent.mm.pluginsdk.ui.d.a)) ? null : ((com.tencent.mm.pluginsdk.ui.d.a) view.getTag()).getUserName();
        mVar.username = str;
        if (TextUtils.isEmpty(this.hcl)) {
        }
        a.vrC.a(this.mContext, mVar, gVar);
        mVar.hcl = null;
        AppMethodBeat.o(79817);
    }
}
