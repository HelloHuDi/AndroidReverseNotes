package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.app.v.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class a {
    boolean bZi = false;
    MMMusicPlayerService oMK;
    NotificationManager oML;
    Runnable oMM = new Runnable() {
        public final void run() {
            AppMethodBeat.i(104971);
            ab.i("MicroMsg.Music.MMMusicNotification", "close");
            al.af(a.this.oMM);
            a.this.oMK.stopForeground(true);
            AppMethodBeat.o(104971);
        }
    };
    BroadcastReceiver oMN;

    public a() {
        AppMethodBeat.i(104974);
        AppMethodBeat.o(104974);
    }

    public static void a(com.tencent.mm.plugin.music.model.e.a aVar, int i, boolean z) {
        AppMethodBeat.i(104975);
        ab.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", Integer.valueOf(i));
        b keVar = new ke();
        keVar.cFH.action = i;
        keVar.cFH.state = "";
        keVar.cFH.cFB = aVar.bUw();
        keVar.cFH.appId = "not from app brand appid";
        keVar.cFH.cFJ = z;
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        AppMethodBeat.o(104975);
    }

    public final void c(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(104976);
        if (!this.bZi) {
            ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
            AppMethodBeat.o(104976);
        } else if (this.oMK == null) {
            ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(104976);
        } else {
            ab.i("MicroMsg.Music.MMMusicNotification", "play");
            al.af(this.oMM);
            try {
                this.oMK.startForeground(291, a(this.oMK, aVar, true));
                AppMethodBeat.o(104976);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Music.MMMusicNotification", e, "", new Object[0]);
                AppMethodBeat.o(104976);
            }
        }
    }

    public final void d(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(104977);
        if (!this.bZi) {
            ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
            AppMethodBeat.o(104977);
        } else if (this.oMK == null) {
            ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(104977);
        } else {
            ab.i("MicroMsg.Music.MMMusicNotification", "pause");
            al.af(this.oMM);
            this.oML.notify(291, a(this.oMK, aVar, false));
            AppMethodBeat.o(104977);
        }
    }

    public final void close() {
        AppMethodBeat.i(104978);
        if (!this.bZi) {
            ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
            AppMethodBeat.o(104978);
        } else if (this.oMK == null) {
            ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(104978);
        } else {
            ab.i("MicroMsg.Music.MMMusicNotification", "close");
            al.af(this.oMM);
            al.n(this.oMM, 1000);
            AppMethodBeat.o(104978);
        }
    }

    private Notification a(Context context, com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
        AppMethodBeat.i(104979);
        Intent intent = new Intent(context, MusicMainUI.class);
        intent.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        c bt = com.tencent.mm.bo.a.bt(context, "reminder_channel_id");
        bt.EI = activity;
        Notification build = bt.as(com.tencent.mm.bo.a.bWV()).a(b(context, aVar, z)).build();
        AppMethodBeat.o(104979);
        return build;
    }

    private RemoteViews b(Context context, com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
        AppMethodBeat.i(104980);
        String str = aVar.field_songName;
        String str2 = aVar.field_songSinger;
        if (!bo.isNullOrNil(aVar.field_songAlbum)) {
            str2 = str2 + aVar.field_songAlbum;
        }
        Bitmap e = e(aVar);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.aoq);
        if (e != null) {
            remoteViews.setImageViewBitmap(R.id.e39, e);
        } else {
            remoteViews.setImageViewResource(R.id.e39, R.drawable.b27);
        }
        if (bo.isNullOrNil(str)) {
            remoteViews.setViewVisibility(R.id.e3_, 8);
        } else {
            remoteViews.setViewVisibility(R.id.e3_, 0);
            remoteViews.setTextViewText(R.id.e3_, str);
        }
        if (bo.isNullOrNil(str2)) {
            remoteViews.setViewVisibility(R.id.e3a, 8);
        } else {
            remoteViews.setViewVisibility(R.id.e3a, 0);
            remoteViews.setTextViewText(R.id.e3a, str2);
        }
        boolean zK = zK(eD(this.oMK));
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        remoteViews.setImageViewResource(R.id.e3b, jv(zK));
        remoteViews.setOnClickPendingIntent(R.id.e3b, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        broadcast = PendingIntent.getBroadcast(context, 1, intent, 134217728);
        remoteViews.setImageViewResource(R.id.e3c, D(z, zK));
        remoteViews.setOnClickPendingIntent(R.id.e3c, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        broadcast = PendingIntent.getBroadcast(context, 2, intent, 134217728);
        remoteViews.setImageViewResource(R.id.e3d, jw(zK));
        remoteViews.setOnClickPendingIntent(R.id.e3d, broadcast);
        intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        broadcast = PendingIntent.getBroadcast(context, 3, intent, 134217728);
        remoteViews.setImageViewResource(R.id.e3e, jx(zK));
        remoteViews.setOnClickPendingIntent(R.id.e3e, broadcast);
        AppMethodBeat.o(104980);
        return remoteViews;
    }

    private Bitmap e(final com.tencent.mm.plugin.music.model.e.a aVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(104981);
        if (aVar == null) {
            ab.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            AppMethodBeat.o(104981);
            return null;
        }
        ab.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", Integer.valueOf(aVar.field_musicType));
        switch (aVar.field_musicType) {
            case 0:
            case 5:
            case 7:
            case 10:
            case 11:
                bitmap = o.ahl().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bz.a.getDensity(this.oMK), true);
                break;
            case 1:
            case 8:
            case 9:
                bau bau = new bau();
                bau.Id = aVar.field_songMediaId;
                bau.wEH = aVar.field_songAlbumUrl;
                bau.wEI = aVar.field_songAlbumType;
                bau.Url = bau.wEH;
                if (n.qFx != null) {
                    bitmap = n.qFx.b(bau);
                    break;
                }
                break;
            case 6:
                bitmap = o.ahl().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bz.a.getDensity(this.oMK), true);
                break;
        }
        if (bitmap != null) {
            bitmap = d.a(bitmap, false, 12.0f, false);
            AppMethodBeat.o(104981);
            return bitmap;
        }
        bitmap = o.ahp().sB(aVar.field_songAlbumUrl);
        if (bitmap == null) {
            final String aY = com.tencent.mm.plugin.music.h.b.aY(aVar.field_musicId, false);
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePJ = com.tencent.mm.plugin.music.h.b.aY(aVar.field_musicId, false);
            aVar2.ePH = true;
            aVar2.ct(com.tencent.mm.bz.a.al(this.oMK, R.dimen.a6y), com.tencent.mm.bz.a.al(this.oMK, R.dimen.a6x));
            aVar2.ePF = true;
            o.ahp().a(aVar.field_songAlbumUrl, aVar2.ahG(), new com.tencent.mm.at.a.c.c() {
                public final void a(boolean z, Object... objArr) {
                    AppMethodBeat.i(104973);
                    ab.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", aVar.field_songAlbumUrl, Boolean.valueOf(z));
                    if (z) {
                        Bitmap decodeFile = d.decodeFile(aY, null);
                        if (decodeFile == null) {
                            ab.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                            AppMethodBeat.o(104973);
                            return;
                        }
                        o.ahp().j(aVar.field_songAlbumUrl, decodeFile);
                        a.this.oMK.refresh();
                    }
                    AppMethodBeat.o(104973);
                }
            });
        }
        bitmap = d.a(bitmap, false, 12.0f, false);
        AppMethodBeat.o(104981);
        return bitmap;
    }

    private static int D(boolean z, boolean z2) {
        return z ? z2 ? R.drawable.bg3 : R.drawable.bg5 : z2 ? R.drawable.bg7 : R.drawable.bg8;
    }

    private static int jv(boolean z) {
        return z ? R.drawable.bg_ : R.drawable.bgb;
    }

    private static int jw(boolean z) {
        return z ? R.drawable.bfz : R.drawable.bg1;
    }

    private static int jx(boolean z) {
        return z ? R.drawable.bfw : R.drawable.bfx;
    }

    private static int eD(Context context) {
        AppMethodBeat.i(104982);
        RemoteViews remoteViews = com.tencent.mm.bo.a.bt(context, "reminder_channel_id").build().contentView;
        if (remoteViews == null) {
            AppMethodBeat.o(104982);
            return WebView.NIGHT_MODE_COLOR;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(remoteViews.getLayoutId(), null);
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        int currentTextColor;
        if (textView != null) {
            currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.o(104982);
            return currentTextColor;
        }
        currentTextColor = q(viewGroup);
        AppMethodBeat.o(104982);
        return currentTextColor;
    }

    private static int q(ViewGroup viewGroup) {
        AppMethodBeat.i(104983);
        ArrayList<TextView> arrayList = new ArrayList();
        a(viewGroup, arrayList);
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
            AppMethodBeat.o(104983);
            return currentTextColor;
        }
        AppMethodBeat.o(104983);
        return WebView.NIGHT_MODE_COLOR;
    }

    private static void a(View view, List<TextView> list) {
        AppMethodBeat.i(104984);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
            AppMethodBeat.o(104984);
            return;
        }
        if (view instanceof TextView) {
            list.add((TextView) view);
        }
        AppMethodBeat.o(104984);
    }

    private static boolean zK(int i) {
        AppMethodBeat.i(104985);
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        int red = Color.red(WebView.NIGHT_MODE_COLOR) - Color.red(i2);
        int green = Color.green(WebView.NIGHT_MODE_COLOR) - Color.green(i2);
        i2 = Color.blue(WebView.NIGHT_MODE_COLOR) - Color.blue(i2);
        if (Math.sqrt((double) ((i2 * i2) + ((red * red) + (green * green)))) < 180.0d) {
            AppMethodBeat.o(104985);
            return true;
        }
        AppMethodBeat.o(104985);
        return false;
    }
}
