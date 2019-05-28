package com.tencent.p177mm.platformtools;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.p057v4.app.C0363v.C0358c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.C5510e.C5502i;
import com.tencent.p177mm.p842bp.C41909a;
import com.tencent.p177mm.p842bp.C41910b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.platformtools.y */
public final class C42253y {

    /* renamed from: com.tencent.mm.platformtools.y$2 */
    public static class C379882 implements C41910b {
        /* renamed from: e */
        public final void mo43868e(Exception exception) {
            AppMethodBeat.m2504i(16671);
            C4990ab.m7412e("MiroMsg.NotificationUtil", "Load plugin failed");
            AppMethodBeat.m2505o(16671);
        }
    }

    /* renamed from: com.tencent.mm.platformtools.y$1 */
    public static class C422541 implements C41909a {
        final /* synthetic */ Bundle cgJ;
        final /* synthetic */ String chV;
        final /* synthetic */ String fOH;
        final /* synthetic */ String ghE;
        final /* synthetic */ int ghF;
        final /* synthetic */ String val$jumpUrl;

        public C422541(String str, String str2, Bundle bundle, String str3, String str4, int i) {
            this.val$jumpUrl = str;
            this.ghE = str2;
            this.cgJ = bundle;
            this.chV = str3;
            this.fOH = str4;
            this.ghF = i;
        }

        public final void onDone() {
            AppMethodBeat.m2504i(16670);
            Time time = new Time();
            time.setToNow();
            int i = time.hour;
            int i2 = time.minute;
            C4996ah.getContext();
            if (C37885a.m63972bS(i, i2)) {
                try {
                    Context context = C4996ah.getContext();
                    boolean MI = C37885a.m63956MI();
                    boolean MG = C37885a.m63954MG();
                    C4990ab.m7410d("MiroMsg.NotificationUtil", "shake " + MI + "sound " + MG);
                    if (MI) {
                        C4990ab.m7416i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                        C5046bo.m7589z(context, true);
                    }
                    if (MG) {
                        Uri defaultUri;
                        String MK = C37885a.m63958MK();
                        if (MK == C5502i.evO) {
                            defaultUri = RingtoneManager.getDefaultUri(2);
                        } else {
                            defaultUri = Uri.parse(MK);
                        }
                        C45289k c45289k = new C45289k();
                        try {
                            c45289k.setDataSource(context, defaultUri);
                            c45289k.setOnCompletionListener(new C422553());
                            if (C9638aw.m17191ZL().getStreamVolume(5) != 0) {
                                if (C9638aw.m17191ZL().mo4822KV()) {
                                    int streamVolume = C9638aw.m17191ZL().getStreamVolume(8);
                                    i2 = C9638aw.m17191ZL().getStreamMaxVolume(8);
                                    i = C9638aw.m17191ZL().getStreamVolume(5);
                                    if (i <= i2) {
                                        i2 = i;
                                    }
                                    C9638aw.m17191ZL().mo4833bR(8, i2);
                                    c45289k.setAudioStreamType(8);
                                    c45289k.setLooping(true);
                                    c45289k.prepare();
                                    c45289k.setLooping(false);
                                    c45289k.start();
                                    C9638aw.m17191ZL().mo4833bR(8, streamVolume);
                                    C4990ab.m7411d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(i2));
                                } else {
                                    c45289k.setAudioStreamType(5);
                                    c45289k.setLooping(true);
                                    c45289k.prepare();
                                    c45289k.setLooping(false);
                                    c45289k.start();
                                }
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                        }
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                }
            } else {
                C4990ab.m7416i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
            }
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$jumpUrl);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.setFlags(872415232);
            C4990ab.m7411d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", this.ghE, this.cgJ);
            if (!(this.ghE == null || this.cgJ == null)) {
                intent.putExtra("bizofstartfrom", this.ghE);
                intent.putExtra("startwebviewparams", this.cgJ);
            }
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 0, intent, 134217728);
            C0358c e3 = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(this.chV).mo623e(this.fOH);
            e3.f362EI = activity;
            Notification build = e3.build();
            build.icon = C45186a.bWV();
            build.flags |= 16;
            ((NotificationManager) C4996ah.getContext().getSystemService("notification")).notify(this.ghF, build);
            AppMethodBeat.m2505o(16670);
        }
    }

    /* renamed from: com.tencent.mm.platformtools.y$3 */
    static class C422553 implements OnCompletionListener {
        C422553() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(16672);
            try {
                mediaPlayer.release();
                AppMethodBeat.m2505o(16672);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(16672);
            }
        }
    }
}
