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
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.bh */
class C16149bh extends FrameLayout implements OnErrorListener {
    /* renamed from: a */
    private Object f3022a;
    /* renamed from: b */
    private C30948bj f3023b;
    /* renamed from: c */
    private VideoView f3024c;
    /* renamed from: d */
    private Context f3025d = null;
    /* renamed from: e */
    private String f3026e;

    public C16149bh(Context context) {
        super(context.getApplicationContext());
        AppMethodBeat.m2504i(64633);
        this.f3025d = context;
        AppMethodBeat.m2505o(64633);
    }

    /* renamed from: b */
    private void m24494b(Bundle bundle, Object obj) {
        AppMethodBeat.m2504i(64635);
        mo28963a();
        boolean z = false;
        if (mo28967b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.f3023b.mo50071a(this.f3022a, bundle, this, obj);
        }
        if (!z) {
            if (this.f3024c != null) {
                this.f3024c.stopPlayback();
            }
            if (this.f3024c == null) {
                this.f3024c = new VideoView(getContext());
            }
            this.f3026e = bundle.getString("videoUrl");
            this.f3024c.setVideoURI(Uri.parse(this.f3026e));
            this.f3024c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            applicationContext.startActivity(intent);
        }
        AppMethodBeat.m2505o(64635);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo28963a() {
        DexLoader dexLoader = null;
        AppMethodBeat.m2504i(64636);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        if (this.f3023b == null) {
            C5818o.m8863a(true).mo12196a(getContext().getApplicationContext(), false, false, null);
            C30947bi a = C5818o.m8863a(true).mo12195a();
            if (a != null) {
                dexLoader = a.mo50067b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.f3023b = new C30948bj(dexLoader);
            }
        }
        if (this.f3023b != null && this.f3022a == null) {
            this.f3022a = this.f3023b.mo50068a(getContext().getApplicationContext());
        }
        AppMethodBeat.m2505o(64636);
    }

    /* renamed from: a */
    public void mo28964a(Activity activity) {
        AppMethodBeat.m2504i(64637);
        if (!(mo28967b() || this.f3024c == null)) {
            if (this.f3024c.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                window.addFlags(128);
                frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.f3024c);
                this.f3024c.setMediaController(mediaController);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.f3024c, layoutParams);
            }
            if (VERSION.SDK_INT >= 8) {
                this.f3024c.start();
            }
        }
        AppMethodBeat.m2505o(64637);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo28965a(Activity activity, int i) {
        AppMethodBeat.m2504i(64638);
        if (!(i != 3 || mo28967b() || this.f3024c == null)) {
            this.f3024c.pause();
        }
        if (i == 4) {
            this.f3025d = null;
            if (!(mo28967b() || this.f3024c == null)) {
                this.f3024c.stopPlayback();
                this.f3024c = null;
            }
        }
        if (i == 2 && !mo28967b()) {
            this.f3025d = activity;
            mo28964a(activity);
        }
        if (mo28967b()) {
            this.f3023b.mo50070a(this.f3022a, activity, i);
        }
        AppMethodBeat.m2505o(64638);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo28966a(Bundle bundle, Object obj) {
        AppMethodBeat.m2504i(64634);
        m24494b(bundle, obj);
        AppMethodBeat.m2505o(64634);
    }

    /* renamed from: b */
    public boolean mo28967b() {
        return (this.f3023b == null || this.f3022a == null) ? false : true;
    }

    /* renamed from: c */
    public void mo28968c() {
        AppMethodBeat.m2504i(64640);
        if (mo28967b()) {
            this.f3023b.mo50069a(this.f3022a);
        }
        AppMethodBeat.m2505o(64640);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AppMethodBeat.m2504i(64639);
        try {
            if (this.f3025d instanceof Activity) {
                Activity activity = (Activity) this.f3025d;
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
                intent.setDataAndType(Uri.parse(this.f3026e), "video/*");
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(64639);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64639);
            return false;
        }
    }
}
