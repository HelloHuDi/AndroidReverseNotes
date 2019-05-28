package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.export.external.DexLoader;

class bh extends FrameLayout implements OnErrorListener {
    private Object a;
    private bj b;
    private VideoView c;
    private Context d = null;
    private String e;

    public bh(Context context) {
        super(context.getApplicationContext());
        AppMethodBeat.i(64633);
        this.d = context;
        AppMethodBeat.o(64633);
    }

    private void b(Bundle bundle, Object obj) {
        AppMethodBeat.i(64635);
        a();
        boolean z = false;
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.b.a(this.a, bundle, this, obj);
        }
        if (!z) {
            if (this.c != null) {
                this.c.stopPlayback();
            }
            if (this.c == null) {
                this.c = new VideoView(getContext());
            }
            this.e = bundle.getString("videoUrl");
            this.c.setVideoURI(Uri.parse(this.e));
            this.c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            applicationContext.startActivity(intent);
        }
        AppMethodBeat.o(64635);
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        DexLoader dexLoader = null;
        AppMethodBeat.i(64636);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        if (this.b == null) {
            o.a(true).a(getContext().getApplicationContext(), false, false, null);
            bi a = o.a(true).a();
            if (a != null) {
                dexLoader = a.b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new bj(dexLoader);
            }
        }
        if (this.b != null && this.a == null) {
            this.a = this.b.a(getContext().getApplicationContext());
        }
        AppMethodBeat.o(64636);
    }

    public void a(Activity activity) {
        AppMethodBeat.i(64637);
        if (!(b() || this.c == null)) {
            if (this.c.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                window.addFlags(128);
                frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.c);
                this.c.setMediaController(mediaController);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.c, layoutParams);
            }
            if (VERSION.SDK_INT >= 8) {
                this.c.start();
            }
        }
        AppMethodBeat.o(64637);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Activity activity, int i) {
        AppMethodBeat.i(64638);
        if (!(i != 3 || b() || this.c == null)) {
            this.c.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!(b() || this.c == null)) {
                this.c.stopPlayback();
                this.c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.a, activity, i);
        }
        AppMethodBeat.o(64638);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Bundle bundle, Object obj) {
        AppMethodBeat.i(64634);
        b(bundle, obj);
        AppMethodBeat.o(64634);
    }

    public boolean b() {
        return (this.b == null || this.a == null) ? false : true;
    }

    public void c() {
        AppMethodBeat.i(64640);
        if (b()) {
            this.b.a(this.a);
        }
        AppMethodBeat.o(64640);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AppMethodBeat.i(64639);
        try {
            if (this.d instanceof Activity) {
                Activity activity = (Activity) this.d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                context = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.e), "video/*");
                context.startActivity(intent);
            }
            AppMethodBeat.o(64639);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(64639);
            return false;
        }
    }
}
