package com.tencent.p177mm.plugin.notification.p475a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.notification.a.a */
public final class C46114a implements C4937b {
    private final int DELAY_TIME = 50;
    private final String TAG = "MicroMsg.NotificationObserver";
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(23094);
            super.handleMessage(message);
            final String string = message.getData().getString("com.tencent.mm.notification.observer");
            C9638aw.m17180RS().mo10310m(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.m2504i(23093);
                    if (C1720g.m3534RN().mo5161QY()) {
                        final int Nr = C18559f.m28885Nr();
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(string);
                        final boolean DX = aoO == null ? false : aoO.mo16673DX();
                        if (!DX) {
                            i = C18559f.m28906kF(string);
                        }
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.notification.a.a$1$1$1$1 */
                            class C35561 implements Runnable {
                                C35561() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(23091);
                                    C9638aw.getNotification().mo41583k(Nr, string);
                                    if (C46114a.this.oVn) {
                                        C46114a.this.oVn = false;
                                        C9638aw.getNotification().mo41576bw(false);
                                    }
                                    AppMethodBeat.m2505o(23091);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(23092);
                                C9638aw.getNotification().mo41580ik(Nr);
                                if (!DX) {
                                    C9638aw.getNotification().mo41584y(string, i);
                                }
                                C4990ab.m7417i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", Integer.valueOf(Nr), Integer.valueOf(i), Boolean.valueOf(DX));
                                C7305d.post(new C35561(), "NotificationObserver");
                                AppMethodBeat.m2505o(23092);
                            }
                        });
                        AppMethodBeat.m2505o(23093);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.NotificationObserver", "account not init.");
                    AppMethodBeat.m2505o(23093);
                }
            }, 500);
            AppMethodBeat.m2505o(23094);
        }
    };
    public boolean oVn = false;

    public C46114a() {
        AppMethodBeat.m2504i(23095);
        AppMethodBeat.m2505o(23095);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23096);
        C4990ab.m7417i("MicroMsg.NotificationObserver", "event: %d", Integer.valueOf(i));
        if (!(obj instanceof String) || C5046bo.isNullOrNil((String) obj)) {
            C4990ab.m7411d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(23096);
            return;
        }
        int i2;
        if (C9638aw.m17183ZD()) {
            i2 = 0;
        } else {
            C9638aw.m17190ZK();
            i2 = (int) C18628c.m29078XM().aoM((String) obj).ewQ;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
        AppMethodBeat.m2505o(23096);
    }
}
