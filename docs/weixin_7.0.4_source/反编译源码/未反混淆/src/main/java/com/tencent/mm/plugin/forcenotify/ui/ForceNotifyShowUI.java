package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.ad;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0014J\b\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "finish", "", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
public final class ForceNotifyShowUI extends BaseForceNotifyShowUI {
    private AudioManager euK;
    private Vibrator iVt;
    private MediaPlayer mtv;
    private Runnable mtw;
    private OnAudioFocusChangeListener mtx;
    private final ak mty = new ak(Looper.getMainLooper());
    private com.tencent.mm.plugin.forcenotify.c.b mtz = new com.tencent.mm.plugin.forcenotify.c.b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "onAudioFocusChange"})
    static final class a implements OnAudioFocusChangeListener {
        public static final a mtA = new a();

        static {
            AppMethodBeat.i(51084);
            AppMethodBeat.o(51084);
        }

        a() {
        }

        public final void onAudioFocusChange(int i) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ForceNotifyShowUI mtB;

        b(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.i(51085);
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            AppCompatActivity dxU = this.mtB.dxU();
            j.o(dxU, "context");
            if (!com.tencent.mm.plugin.forcenotify.b.c.isSilentMode(dxU)) {
                this.mtB.mtv = ay.a(this.mtB.dxU(), R.string.g7j, com.tencent.mm.sdk.platformtools.ay.b.NOTSET, 2, true, null);
            }
            cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            dxU = this.mtB.dxU();
            j.o(dxU, "context");
            if (com.tencent.mm.plugin.forcenotify.b.c.dT(dxU)) {
                Vibrator b = this.mtB.iVt;
                if (b == null) {
                    j.dWJ();
                }
                b.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
            }
            AppMethodBeat.o(51085);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ ForceNotifyShowUI mtB;

        d(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.i(51087);
            try {
                Vibrator b = this.mtB.iVt;
                if (b != null) {
                    b.cancel();
                }
                MediaPlayer a = this.mtB.mtv;
                if (a != null) {
                    a.stop();
                }
                Window window = this.mtB.getWindow();
                j.o(window, "window");
                View decorView = window.getDecorView();
                j.o(decorView, "window.decorView");
                decorView.setKeepScreenOn(false);
                AppMethodBeat.o(51087);
            } catch (Exception e) {
                AppMethodBeat.o(51087);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ ForceNotifyShowUI mtB;

        c(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51086);
            if (this.mtB.mtz.field_CreateTime > 0) {
                ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).b(this.mtB.username, String.valueOf(this.mtB.mtz.field_CreateTime / 1000) + this.mtB.mtz.field_UserName, 2, cb.aaE() / 1000);
            }
            this.mtB.finish();
            this.mtB.overridePendingTransition(0, R.anim.ce);
            AppMethodBeat.o(51086);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyShowUI() {
        AppMethodBeat.i(51095);
        AppMethodBeat.o(51095);
    }

    public final int getLayoutId() {
        return R.layout.a0j;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(51088);
        super.onCreate(bundle);
        this.mtz.field_UserName = this.username;
        com.tencent.mm.plugin.forcenotify.d.a.mth.b((com.tencent.mm.sdk.e.c) this.mtz, new String[0]);
        Object systemService = getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        v vVar;
        if (systemService == null) {
            vVar = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(51088);
            throw vVar;
        }
        this.euK = (AudioManager) systemService;
        systemService = dxU().getSystemService("vibrator");
        if (systemService == null) {
            vVar = new v("null cannot be cast to non-null type android.os.Vibrator");
            AppMethodBeat.o(51088);
            throw vVar;
        }
        Integer valueOf;
        Integer valueOf2;
        Object valueOf3;
        int i;
        this.iVt = (Vibrator) systemService;
        AudioManager audioManager = this.euK;
        Integer valueOf4 = audioManager != null ? Integer.valueOf(audioManager.getVibrateSetting(1)) : null;
        AudioManager audioManager2 = this.euK;
        if (audioManager2 != null) {
            valueOf = Integer.valueOf(audioManager2.getVibrateSetting(0));
        } else {
            valueOf = null;
        }
        AudioManager audioManager3 = this.euK;
        if (audioManager3 != null) {
            valueOf2 = Integer.valueOf(audioManager3.getRingerMode());
        } else {
            valueOf2 = null;
        }
        ab.i(this.TAG, "V:%s V1:%s  R:%s", valueOf4, valueOf, valueOf2);
        this.mtx = a.mtA;
        audioManager = this.euK;
        if (audioManager != null) {
            valueOf3 = Integer.valueOf(audioManager.requestAudioFocus(this.mtx, 3, 2));
        } else {
            valueOf3 = null;
        }
        this.mty.postDelayed(new b(this), 1000);
        Window window = getWindow();
        j.o(window, "window");
        View decorView = window.getDecorView();
        j.o(decorView, "window.decorView");
        decorView.setKeepScreenOn(true);
        j.o(findViewById(R.id.m5), "findViewById(R.id.content)");
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pb)));
        ab.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", this.username, valueOf3);
        TextView textView = (TextView) findViewById(R.id.b6e);
        ImageView imageView = (ImageView) findViewById(R.id.qk);
        findViewById(R.id.bvm).setOnClickListener(new c(this));
        this.mtw = new d(this);
        this.mty.postDelayed(this.mtw, 60000);
        com.tencent.mm.plugin.forcenotify.c.b bVar = this.mtz;
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        bVar.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(this.username);
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, this.mtz.field_UserName, 0.1f);
        j.o(textView, "titleView");
        Context baseContext = getBaseContext();
        ad adVar = this.mtz.ehM;
        textView.setText(com.tencent.mm.pluginsdk.ui.e.j.a(baseContext, adVar != null ? adVar.Oj() : null, (int) textView.getTextSize(), 0, null, null));
        com.tencent.mm.plugin.forcenotify.a.a aVar = (com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class);
        String str = this.username;
        com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
        AppCompatActivity dxU = dxU();
        j.o(dxU, "context");
        if (com.tencent.mm.plugin.forcenotify.b.c.isSilentMode(dxU)) {
            cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            dxU = dxU();
            j.o(dxU, "context");
            i = com.tencent.mm.plugin.forcenotify.b.c.dT((Context) dxU) ? 1 : 4;
        } else {
            cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            dxU = dxU();
            j.o(dxU, "context");
            i = com.tencent.mm.plugin.forcenotify.b.c.dT((Context) dxU) ? 3 : 2;
        }
        aVar.d(str, i, cb.aaE() / 1000);
        if (this.username != null) {
            com.tencent.mm.plugin.forcenotify.d.a aVar2 = com.tencent.mm.plugin.forcenotify.d.a.mth;
            String str2 = this.username;
            if (str2 == null) {
                j.dWJ();
            }
            aVar2.pI(str2);
        }
        AppMethodBeat.o(51088);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(51089);
        super.onBackPressed();
        ab.i(this.TAG, "[onBackPressed]");
        ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).b(this.username, String.valueOf(this.mtz.field_CreateTime / 1000) + this.mtz.field_UserName, 8, cb.aaE() / 1000);
        AppMethodBeat.o(51089);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(51090);
        j.p(keyEvent, "event");
        switch (i) {
            case 24:
                reset();
                AppMethodBeat.o(51090);
                return true;
            case 25:
                reset();
                AppMethodBeat.o(51090);
                return true;
            default:
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                AppMethodBeat.o(51090);
                return onKeyDown;
        }
    }

    public final void onStop() {
        AppMethodBeat.i(51091);
        super.onStop();
        reset();
        AppMethodBeat.o(51091);
    }

    public final void onDestroy() {
        AppMethodBeat.i(51092);
        super.onDestroy();
        reset();
        AppMethodBeat.o(51092);
    }

    public final void finish() {
        AppMethodBeat.i(51093);
        super.finish();
        reset();
        AppMethodBeat.o(51093);
    }

    private final void reset() {
        AppMethodBeat.i(51094);
        Window window = getWindow();
        j.o(window, "window");
        View decorView = window.getDecorView();
        j.o(decorView, "window.decorView");
        decorView.setKeepScreenOn(false);
        this.mty.removeCallbacksAndMessages(null);
        Vibrator vibrator = this.iVt;
        if (vibrator != null) {
            vibrator.cancel();
        }
        AudioManager audioManager = this.euK;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.mtx);
        }
        try {
            window = getWindow();
            j.o(window, "window");
            window.getDecorView().removeCallbacks(this.mtw);
            this.mtw = null;
            MediaPlayer mediaPlayer = this.mtv;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
            mediaPlayer = this.mtv;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = this.mtv;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                AppMethodBeat.o(51094);
                return;
            }
            AppMethodBeat.o(51094);
        } catch (IllegalStateException e) {
            AppMethodBeat.o(51094);
        }
    }
}
