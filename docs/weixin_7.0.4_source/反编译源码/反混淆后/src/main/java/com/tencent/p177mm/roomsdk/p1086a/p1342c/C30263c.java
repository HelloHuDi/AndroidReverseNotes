package com.tencent.p177mm.roomsdk.p1086a.p1342c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i.C3461a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C23480e;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.roomsdk.a.c.c */
public final class C30263c extends C46610a {
    C4884c ekk = new C302641();
    public C3463b xvc;
    boolean xvd = false;
    C3461a xve = new C234812();

    /* renamed from: com.tencent.mm.roomsdk.a.c.c$2 */
    class C234812 implements C3461a {
        C234812() {
        }

        /* renamed from: x */
        public final void mo7917x(int i, String str, String str2) {
            AppMethodBeat.m2504i(80265);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7919b(C30263c.this.xvc.getCmdId(), C30263c.this.xve);
            if (C30263c.this.xvd) {
                AppMethodBeat.m2505o(80265);
                return;
            }
            C30263c.this.xvd = true;
            if (C30263c.this.xva != null) {
                if (C30263c.this.xva instanceof C23480e) {
                    C23480e c23480e = (C23480e) C30263c.this.xva;
                    c23480e.ret = i;
                    c23480e.title = str;
                    c23480e.content = str2;
                }
                C30263c.this.xva.mo11081a(0, i, "", C30263c.this.xva);
            }
            if (C30263c.this.tipDialog != null) {
                C30263c.this.tipDialog.dismiss();
            }
            AppMethodBeat.m2505o(80265);
        }
    }

    /* renamed from: com.tencent.mm.roomsdk.a.c.c$1 */
    class C302641 extends C4884c<C42023mc> {
        C302641() {
            AppMethodBeat.m2504i(80263);
            this.xxI = C42023mc.class.getName().hashCode();
            AppMethodBeat.m2505o(80263);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(80264);
            final C42023mc c42023mc = (C42023mc) c4883b;
            C30263c.this.ekk.dead();
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(80262);
                    if (C30263c.this.xvd) {
                        AppMethodBeat.m2505o(80262);
                        return;
                    }
                    C30263c.this.xvd = true;
                    String str = c42023mc.cHU.cHV;
                    String str2 = c42023mc.cHU.cHW;
                    int i = c42023mc.cHU.ret;
                    if (C30263c.this.xva != null) {
                        if (C30263c.this.xva instanceof C23480e) {
                            C23480e c23480e = (C23480e) C30263c.this.xva;
                            c23480e.title = str;
                            c23480e.ret = i;
                            c23480e.content = str2;
                        }
                        C30263c.this.xva.mo11081a(0, i, "", C30263c.this.xva);
                    }
                    if (C30263c.this.tipDialog != null) {
                        C30263c.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.m2505o(80262);
                }
            });
            AppMethodBeat.m2505o(80264);
            return false;
        }
    }

    public C30263c(boolean z) {
        AppMethodBeat.m2504i(80266);
        this.xuX = z;
        AppMethodBeat.m2505o(80266);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(80267);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7921d(this.xvc);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7919b(this.xvc.getCmdId(), this.xve);
        this.ekk.dead();
        AppMethodBeat.m2505o(80267);
    }

    public final void dmX() {
        AppMethodBeat.m2504i(80268);
        C4990ab.m7417i("MicroMsg.RoomCallbackFactory", "request oplog %s", this.xvc);
        if (!(this.xuY == null && this.xuZ == null && this.xva == null)) {
            this.ekk.dnU();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7918a(this.xvc.getCmdId(), this.xve);
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(this.xvc);
        AppMethodBeat.m2505o(80268);
    }

    /* renamed from: a */
    public final void mo48450a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(80269);
        this.tipDialog = C30379h.m48458b(context, str, z, onCancelListener);
        dmX();
        AppMethodBeat.m2505o(80269);
    }
}
