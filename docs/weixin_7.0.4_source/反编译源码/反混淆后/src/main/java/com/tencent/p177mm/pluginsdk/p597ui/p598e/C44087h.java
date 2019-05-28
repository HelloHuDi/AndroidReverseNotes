package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44079c;
import com.tencent.p177mm.pluginsdk.p597ui.p1669d.C46504a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C40487b.C4758a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.h */
public class C44087h {
    String hcl;
    Context mContext;
    private int tuT = 500;
    private long tuU = 0;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo23045a(View view, C14932m c14932m) {
        AppMethodBeat.m2504i(79817);
        if (System.currentTimeMillis() - this.tuU <= ((long) this.tuT)) {
            C4990ab.m7412e("MicroMsg.MMSpanClickListener", "process pass");
            AppMethodBeat.m2505o(79817);
            return;
        }
        this.tuU = System.currentTimeMillis();
        if (c14932m == null) {
            C4990ab.m7412e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
            AppMethodBeat.m2505o(79817);
            return;
        }
        C4990ab.m7411d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(c14932m.type));
        if (this.mContext == null) {
            C4990ab.m7412e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
            AppMethodBeat.m2505o(79817);
            return;
        }
        C44086g c44086g;
        String str;
        if (C44089j.vrX == null || C44089j.vrX.size() <= 0) {
            c44086g = null;
        } else {
            int size = C44089j.vrX.size();
            C44086g c44086g2 = (C44086g) C44089j.vrX.getLast();
            C4990ab.m7411d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
            c44086g = c44086g2;
        }
        if (view != null && (view.getTag() instanceof C44079c)) {
            C7620bi c7620bi = ((C44079c) view.getTag()).cKd;
            if (c7620bi != null) {
                str = c7620bi.field_talker;
                if (C1855t.m3901mN(str)) {
                    str = C1829bf.m3762oy(c7620bi.field_content);
                }
                c14932m.username = str;
                if (!TextUtils.isEmpty(this.hcl)) {
                    c14932m.hcl = this.hcl;
                }
                C4758a.vrC.mo4552a(this.mContext, c14932m, c44086g);
                c14932m.hcl = null;
                AppMethodBeat.m2505o(79817);
            }
        }
        str = (view == null || !(view.getTag() instanceof C46504a)) ? null : ((C46504a) view.getTag()).getUserName();
        c14932m.username = str;
        if (TextUtils.isEmpty(this.hcl)) {
        }
        C4758a.vrC.mo4552a(this.mContext, c14932m, c44086g);
        c14932m.hcl = null;
        AppMethodBeat.m2505o(79817);
    }
}
