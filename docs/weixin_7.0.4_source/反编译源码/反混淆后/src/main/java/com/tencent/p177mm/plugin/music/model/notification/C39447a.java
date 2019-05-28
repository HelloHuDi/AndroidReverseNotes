package com.tencent.p177mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.p057v4.app.C0363v.C0358c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.model.p466d.C3541d;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.plugin.music.p467ui.MusicMainUI;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.music.model.notification.a */
public final class C39447a {
    boolean bZi = false;
    MMMusicPlayerService oMK;
    NotificationManager oML;
    Runnable oMM = new C345971();
    BroadcastReceiver oMN;

    /* renamed from: com.tencent.mm.plugin.music.model.notification.a$1 */
    class C345971 implements Runnable {
        C345971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104971);
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "close");
            C5004al.m7439af(C39447a.this.oMM);
            C39447a.this.oMK.stopForeground(true);
            AppMethodBeat.m2505o(104971);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.notification.a$2 */
    class C345982 extends BroadcastReceiver {
        C345982() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(104972);
            if (intent == null || C5046bo.isNullOrNil(intent.getAction())) {
                AppMethodBeat.m2505o(104972);
                return;
            }
            String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                AppMethodBeat.m2505o(104972);
                return;
            }
            C4990ab.m7417i("MicroMsg.Music.MMMusicNotification", "action:%s", stringExtra);
            C34578d bTS = C39435k.bUf().bTS();
            if (bTS == null) {
                C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                AppMethodBeat.m2505o(104972);
                return;
            }
            C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
            if (bTU == null) {
                C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "music is null, return");
                AppMethodBeat.m2505o(104972);
            } else if (stringExtra.equals("mm_music_notification_action_play")) {
                bTS.resume();
                C3541d.m5829a(2, bTU);
                AppMethodBeat.m2505o(104972);
            } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                bTS.bSN();
                C39435k.bUh().bSK();
                C3541d.m5829a(3, bTU);
                AppMethodBeat.m2505o(104972);
            } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                if (bTU.field_musicType == 11) {
                    C39435k.bUf().mo46674ju(true);
                } else if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
                    ((C28559e) C43329b.m77295ar(C28559e.class)).bTZ();
                } else {
                    bTS.mo8037lP(0);
                    bTS.resume();
                }
                C39447a.m67400a(bTU, 13, bTS.bSO());
                C3541d.m5829a(1, bTU);
                AppMethodBeat.m2505o(104972);
            } else if (stringExtra.equals("mm_music_notification_action_next")) {
                if (bTU.field_musicType == 11) {
                    C39435k.bUf().mo46674ju(true);
                } else if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
                    ((C28559e) C43329b.m77295ar(C28559e.class)).bTY();
                } else {
                    bTS.mo8037lP(0);
                    bTS.resume();
                }
                C39447a.m67400a(bTU, 14, bTS.bSO());
                C3541d.m5829a(4, bTU);
                AppMethodBeat.m2505o(104972);
            } else {
                if (stringExtra.equals("mm_music_notification_action_close")) {
                    C5004al.m7441d(C39447a.this.oMM);
                    bTS.stopPlay();
                    C3541d.m5829a(5, bTU);
                }
                AppMethodBeat.m2505o(104972);
            }
        }
    }

    public C39447a() {
        AppMethodBeat.m2504i(104974);
        AppMethodBeat.m2505o(104974);
    }

    /* renamed from: a */
    public static void m67400a(C28575a c28575a, int i, boolean z) {
        AppMethodBeat.m2504i(104975);
        C4990ab.m7417i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", Integer.valueOf(i));
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = i;
        c37752ke.cFH.state = "";
        c37752ke.cFH.cFB = c28575a.bUw();
        c37752ke.cFH.appId = "not from app brand appid";
        c37752ke.cFH.cFJ = z;
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        AppMethodBeat.m2505o(104975);
    }

    /* renamed from: c */
    public final void mo62390c(C28575a c28575a) {
        AppMethodBeat.m2504i(104976);
        if (!this.bZi) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
            AppMethodBeat.m2505o(104976);
        } else if (this.oMK == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.m2505o(104976);
        } else {
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "play");
            C5004al.m7439af(this.oMM);
            try {
                this.oMK.startForeground(291, m67398a(this.oMK, c28575a, true));
                AppMethodBeat.m2505o(104976);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MMMusicNotification", e, "", new Object[0]);
                AppMethodBeat.m2505o(104976);
            }
        }
    }

    /* renamed from: d */
    public final void mo62392d(C28575a c28575a) {
        AppMethodBeat.m2504i(104977);
        if (!this.bZi) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
            AppMethodBeat.m2505o(104977);
        } else if (this.oMK == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.m2505o(104977);
        } else {
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "pause");
            C5004al.m7439af(this.oMM);
            this.oML.notify(291, m67398a(this.oMK, c28575a, false));
            AppMethodBeat.m2505o(104977);
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(104978);
        if (!this.bZi) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
            AppMethodBeat.m2505o(104978);
        } else if (this.oMK == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.m2505o(104978);
        } else {
            C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "close");
            C5004al.m7439af(this.oMM);
            C5004al.m7442n(this.oMM, 1000);
            AppMethodBeat.m2505o(104978);
        }
    }

    /* renamed from: a */
    private Notification m67398a(Context context, C28575a c28575a, boolean z) {
        AppMethodBeat.m2504i(104979);
        Intent intent = new Intent(context, MusicMainUI.class);
        intent.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        C0358c bt = C45186a.m83262bt(context, "reminder_channel_id");
        bt.f362EI = activity;
        Notification build = bt.mo616as(C45186a.bWV()).mo614a(m67401b(context, c28575a, z)).build();
        AppMethodBeat.m2505o(104979);
        return build;
    }

    /* renamed from: b */
    private RemoteViews m67401b(Context context, C28575a c28575a, boolean z) {
        AppMethodBeat.m2504i(104980);
        String str = c28575a.field_songName;
        String str2 = c28575a.field_songSinger;
        if (!C5046bo.isNullOrNil(c28575a.field_songAlbum)) {
            str2 = str2 + c28575a.field_songAlbum;
        }
        Bitmap e = m67402e(c28575a);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2130970521);
        if (e != null) {
            remoteViews.setImageViewBitmap(2131827138, e);
        } else {
            remoteViews.setImageViewResource(2131827138, C25738R.drawable.b27);
        }
        if (C5046bo.isNullOrNil(str)) {
            remoteViews.setViewVisibility(2131827139, 8);
        } else {
            remoteViews.setViewVisibility(2131827139, 0);
            remoteViews.setTextViewText(2131827139, str);
        }
        if (C5046bo.isNullOrNil(str2)) {
            remoteViews.setViewVisibility(2131827140, 8);
        } else {
            remoteViews.setViewVisibility(2131827140, 0);
            remoteViews.setTextViewText(2131827140, str2);
        }
        boolean zK = C39447a.m67408zK(C39447a.m67403eD(this.oMK));
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        remoteViews.setImageViewResource(2131827141, C39447a.m67404jv(zK));
        remoteViews.setOnClickPendingIntent(2131827141, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        broadcast = PendingIntent.getBroadcast(context, 1, intent, 134217728);
        remoteViews.setImageViewResource(2131827142, C39447a.m67397D(z, zK));
        remoteViews.setOnClickPendingIntent(2131827142, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        broadcast = PendingIntent.getBroadcast(context, 2, intent, 134217728);
        remoteViews.setImageViewResource(2131827143, C39447a.m67405jw(zK));
        remoteViews.setOnClickPendingIntent(2131827143, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        broadcast = PendingIntent.getBroadcast(context, 3, intent, 134217728);
        remoteViews.setImageViewResource(2131827144, C39447a.m67406jx(zK));
        remoteViews.setOnClickPendingIntent(2131827144, broadcast);
        AppMethodBeat.m2505o(104980);
        return remoteViews;
    }

    /* renamed from: e */
    private Bitmap m67402e(final C28575a c28575a) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(104981);
        if (c28575a == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            AppMethodBeat.m2505o(104981);
            return null;
        }
        C4990ab.m7417i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", Integer.valueOf(c28575a.field_musicType));
        switch (c28575a.field_musicType) {
            case 0:
            case 5:
            case 7:
            case 10:
            case 11:
                bitmap = C32291o.ahl().mo73087a(c28575a.field_songAlbumLocalPath, C1338a.getDensity(this.oMK), true);
                break;
            case 1:
            case 8:
            case 9:
                bau bau = new bau();
                bau.f17915Id = c28575a.field_songMediaId;
                bau.wEH = c28575a.field_songAlbumUrl;
                bau.wEI = c28575a.field_songAlbumType;
                bau.Url = bau.wEH;
                if (C21877n.qFx != null) {
                    bitmap = C21877n.qFx.mo37454b(bau);
                    break;
                }
                break;
            case 6:
                bitmap = C32291o.ahl().mo73104b(c28575a.field_songAlbumLocalPath, C1338a.getDensity(this.oMK), true);
                break;
        }
        if (bitmap != null) {
            bitmap = C5056d.m7617a(bitmap, false, 12.0f, false);
            AppMethodBeat.m2505o(104981);
            return bitmap;
        }
        bitmap = C32291o.ahp().mo43776sB(c28575a.field_songAlbumUrl);
        if (bitmap == null) {
            final String aY = C12673b.m20675aY(c28575a.field_musicId, false);
            C17927a c17927a = new C17927a();
            c17927a.ePJ = C12673b.m20675aY(c28575a.field_musicId, false);
            c17927a.ePH = true;
            c17927a.mo33448ct(C1338a.m2856al(this.oMK, C25738R.dimen.a6y), C1338a.m2856al(this.oMK, C25738R.dimen.a6x));
            c17927a.ePF = true;
            C32291o.ahp().mo43771a(c28575a.field_songAlbumUrl, c17927a.ahG(), new C45158c() {
                /* renamed from: a */
                public final void mo15193a(boolean z, Object... objArr) {
                    AppMethodBeat.m2504i(104973);
                    C4990ab.m7417i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", c28575a.field_songAlbumUrl, Boolean.valueOf(z));
                    if (z) {
                        Bitmap decodeFile = C5056d.decodeFile(aY, null);
                        if (decodeFile == null) {
                            C4990ab.m7412e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                            AppMethodBeat.m2505o(104973);
                            return;
                        }
                        C32291o.ahp().mo43775j(c28575a.field_songAlbumUrl, decodeFile);
                        C39447a.this.oMK.refresh();
                    }
                    AppMethodBeat.m2505o(104973);
                }
            });
        }
        bitmap = C5056d.m7617a(bitmap, false, 12.0f, false);
        AppMethodBeat.m2505o(104981);
        return bitmap;
    }

    /* renamed from: D */
    private static int m67397D(boolean z, boolean z2) {
        return z ? z2 ? C25738R.drawable.bg3 : C25738R.drawable.bg5 : z2 ? C25738R.drawable.bg7 : C25738R.drawable.bg8;
    }

    /* renamed from: jv */
    private static int m67404jv(boolean z) {
        return z ? C25738R.drawable.bg_ : C25738R.drawable.bgb;
    }

    /* renamed from: jw */
    private static int m67405jw(boolean z) {
        return z ? C25738R.drawable.bfz : C25738R.drawable.bg1;
    }

    /* renamed from: jx */
    private static int m67406jx(boolean z) {
        return z ? C25738R.drawable.bfw : C25738R.drawable.bfx;
    }

    /* renamed from: eD */
    private static int m67403eD(Context context) {
        AppMethodBeat.m2504i(104982);
        RemoteViews remoteViews = C45186a.m83262bt(context, "reminder_channel_id").build().contentView;
        if (remoteViews == null) {
            AppMethodBeat.m2505o(104982);
            return WebView.NIGHT_MODE_COLOR;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(remoteViews.getLayoutId(), null);
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        int currentTextColor;
        if (textView != null) {
            currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.m2505o(104982);
            return currentTextColor;
        }
        currentTextColor = C39447a.m67407q(viewGroup);
        AppMethodBeat.m2505o(104982);
        return currentTextColor;
    }

    /* renamed from: q */
    private static int m67407q(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104983);
        ArrayList<TextView> arrayList = new ArrayList();
        C39447a.m67399a(viewGroup, arrayList);
        TextView textView = null;
        for (TextView textView2 : arrayList) {
            TextView textView22;
            if (textView22.getTextSize() <= -1.0f) {
                textView22 = textView;
            }
            textView = textView22;
        }
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.m2505o(104983);
            return currentTextColor;
        }
        AppMethodBeat.m2505o(104983);
        return WebView.NIGHT_MODE_COLOR;
    }

    /* renamed from: a */
    private static void m67399a(View view, List<TextView> list) {
        AppMethodBeat.m2504i(104984);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                C39447a.m67399a(viewGroup.getChildAt(i), list);
            }
            AppMethodBeat.m2505o(104984);
            return;
        }
        if (view instanceof TextView) {
            list.add((TextView) view);
        }
        AppMethodBeat.m2505o(104984);
    }

    /* renamed from: zK */
    private static boolean m67408zK(int i) {
        AppMethodBeat.m2504i(104985);
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        int red = Color.red(WebView.NIGHT_MODE_COLOR) - Color.red(i2);
        int green = Color.green(WebView.NIGHT_MODE_COLOR) - Color.green(i2);
        i2 = Color.blue(WebView.NIGHT_MODE_COLOR) - Color.blue(i2);
        if (Math.sqrt((double) ((i2 * i2) + ((red * red) + (green * green)))) < 180.0d) {
            AppMethodBeat.m2505o(104985);
            return true;
        }
        AppMethodBeat.m2505o(104985);
        return false;
    }
}
