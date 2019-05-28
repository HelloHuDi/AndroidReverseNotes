package com.tencent.mm.platformtools;

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
import android.support.v4.app.v.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.i;

public final class y {

    /* renamed from: com.tencent.mm.platformtools.y$1 */
    public static class AnonymousClass1 implements a {
        final /* synthetic */ Bundle cgJ;
        final /* synthetic */ String chV;
        final /* synthetic */ String fOH;
        final /* synthetic */ String ghE;
        final /* synthetic */ int ghF;
        final /* synthetic */ String val$jumpUrl;

        public AnonymousClass1(String str, String str2, Bundle bundle, String str3, String str4, int i) {
            this.val$jumpUrl = str;
            this.ghE = str2;
            this.cgJ = bundle;
            this.chV = str3;
            this.fOH = str4;
            this.ghF = i;
        }

        public final void onDone() {
            AppMethodBeat.i(16670);
            Time time = new Time();
            time.setToNow();
            int i = time.hour;
            int i2 = time.minute;
            ah.getContext();
            if (com.tencent.mm.m.a.bS(i, i2)) {
                try {
                    Context context = ah.getContext();
                    boolean MI = com.tencent.mm.m.a.MI();
                    boolean MG = com.tencent.mm.m.a.MG();
                    ab.d("MiroMsg.NotificationUtil", "shake " + MI + "sound " + MG);
                    if (MI) {
                        ab.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                        bo.z(context, true);
                    }
                    if (MG) {
                        Uri defaultUri;
                        String MK = com.tencent.mm.m.a.MK();
                        if (MK == i.evO) {
                            defaultUri = RingtoneManager.getDefaultUri(2);
                        } else {
                            defaultUri = Uri.parse(MK);
                        }
                        k kVar = new k();
                        try {
                            kVar.setDataSource(context, defaultUri);
                            kVar.setOnCompletionListener(new OnCompletionListener() {
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    AppMethodBeat.i(16672);
                                    try {
                                        mediaPlayer.release();
                                        AppMethodBeat.o(16672);
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                                        AppMethodBeat.o(16672);
                                    }
                                }
                            });
                            if (aw.ZL().getStreamVolume(5) != 0) {
                                if (aw.ZL().KV()) {
                                    int streamVolume = aw.ZL().getStreamVolume(8);
                                    i2 = aw.ZL().getStreamMaxVolume(8);
                                    i = aw.ZL().getStreamVolume(5);
                                    if (i <= i2) {
                                        i2 = i;
                                    }
                                    aw.ZL().bR(8, i2);
                                    kVar.setAudioStreamType(8);
                                    kVar.setLooping(true);
                                    kVar.prepare();
                                    kVar.setLooping(false);
                                    kVar.start();
                                    aw.ZL().bR(8, streamVolume);
                                    ab.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(i2));
                                } else {
                                    kVar.setAudioStreamType(5);
                                    kVar.setLooping(true);
                                    kVar.prepare();
                                    kVar.setLooping(false);
                                    kVar.start();
                                }
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                        }
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                }
            } else {
                ab.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
            }
            Intent intent = new Intent();
            intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$jumpUrl);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.setFlags(872415232);
            ab.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", this.ghE, this.cgJ);
            if (!(this.ghE == null || this.cgJ == null)) {
                intent.putExtra("bizofstartfrom", this.ghE);
                intent.putExtra("startwebviewparams", this.cgJ);
            }
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 0, intent, 134217728);
            c e3 = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(this.chV).e(this.fOH);
            e3.EI = activity;
            Notification build = e3.build();
            build.icon = com.tencent.mm.bo.a.bWV();
            build.flags |= 16;
            ((NotificationManager) ah.getContext().getSystemService("notification")).notify(this.ghF, build);
            AppMethodBeat.o(16670);
        }
    }
}
