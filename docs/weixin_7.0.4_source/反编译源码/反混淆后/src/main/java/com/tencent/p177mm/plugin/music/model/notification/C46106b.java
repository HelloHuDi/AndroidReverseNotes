package com.tencent.p177mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.plugin.music.model.notification.MMMusicPlayerService.C21351a;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.music.model.notification.b */
public final class C46106b {
    public C4884c hAA;
    public MMMusicPlayerService oMK;
    volatile boolean oMQ = false;

    /* renamed from: com.tencent.mm.plugin.music.model.notification.b$2 */
    class C35422 implements ServiceConnection {
        C35422() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(104988);
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
            if (iBinder instanceof C21351a) {
                C46106b.this.oMQ = false;
                C46106b.this.oMK = MMMusicPlayerService.this;
                AppMethodBeat.m2505o(104988);
                return;
            }
            C4990ab.m7413e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", iBinder.getClass().getName());
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(104988);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(104989);
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
            C46106b.this.oMQ = false;
            C46106b.this.oMK = null;
            AppMethodBeat.m2505o(104989);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.notification.b$1 */
    public class C126811 extends C4884c<C37752ke> {
        public C126811() {
            AppMethodBeat.m2504i(104986);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(104986);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(104987);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (C46106b.this.oMK != null) {
                C4990ab.m7417i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", Integer.valueOf(c37752ke.cFH.action));
                C28575a bTU;
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 11:
                        if (C46106b.this.oMK != null) {
                            bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
                            if (bTU != null) {
                                C46106b.this.oMK.mo36804c(bTU);
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                            break;
                        }
                        break;
                    case 2:
                        if (!(C46106b.this.oMK == null || c37752ke.cFH.cFK)) {
                            C46106b.this.oMK.stop();
                            break;
                        }
                    case 3:
                        if (C46106b.this.oMK != null) {
                            bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
                            if (bTU != null) {
                                C46106b.this.oMK.mo36805d(bTU);
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                            break;
                        }
                        break;
                    case 4:
                        if (C46106b.this.oMK != null) {
                            C46106b.this.oMK.stop();
                            break;
                        }
                        break;
                    case 7:
                        if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 1 && C46106b.this.oMK != null) {
                            MMMusicPlayerService mMMusicPlayerService = C46106b.this.oMK;
                            C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "end");
                            C39447a c39447a = mMMusicPlayerService.oMS;
                            if (!c39447a.bZi) {
                                C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                            } else if (c39447a.oMK == null) {
                                C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                            } else {
                                C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "end");
                                C5004al.m7439af(c39447a.oMM);
                                C5004al.m7442n(c39447a.oMM, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            }
                            C5004al.m7439af(mMMusicPlayerService.oMT);
                            C5004al.m7442n(mMMusicPlayerService.oMT, 60000);
                            break;
                        }
                }
            }
            C46106b.this.bUr();
            AppMethodBeat.m2505o(104987);
            return false;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bUr() {
        AppMethodBeat.m2504i(104990);
        if (this.oMK == null || !this.oMQ) {
            this.oMQ = true;
            Intent intent = new Intent();
            intent.setClass(C4996ah.getContext(), MMMusicPlayerService.class);
            boolean bindService = C4996ah.getContext().bindService(intent, new C35422(), 1);
            C4990ab.m7417i("MicroMsg.Music.MMMusicNotificationHelper", "isOk:%b", Boolean.valueOf(bindService));
            AppMethodBeat.m2505o(104990);
        } else {
            AppMethodBeat.m2505o(104990);
        }
    }
}
