package com.tencent.p177mm.plugin.forcenotify.p415ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.support.p069v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1263b.C43100c;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C23497b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0014J\b\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "finish", "", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI */
public final class ForceNotifyShowUI extends BaseForceNotifyShowUI {
    private AudioManager euK;
    private Vibrator iVt;
    private MediaPlayer mtv;
    private Runnable mtw;
    private OnAudioFocusChangeListener mtx;
    private final C7306ak mty = new C7306ak(Looper.getMainLooper());
    private C43101b mtz = new C43101b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "onAudioFocusChange"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI$a */
    static final class C11945a implements OnAudioFocusChangeListener {
        public static final C11945a mtA = new C11945a();

        static {
            AppMethodBeat.m2504i(51084);
            AppMethodBeat.m2505o(51084);
        }

        C11945a() {
        }

        public final void onAudioFocusChange(int i) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI$b */
    static final class C11946b implements Runnable {
        final /* synthetic */ ForceNotifyShowUI mtB;

        C11946b(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(51085);
            C43100c c43100c = C43100c.mtf;
            AppCompatActivity dxU = this.mtB.dxU();
            C25052j.m39375o(dxU, "context");
            if (!C43100c.isSilentMode(dxU)) {
                this.mtB.mtv = C35988ay.m59197a(this.mtB.dxU(), C25738R.string.g7j, C23497b.NOTSET, 2, true, null);
            }
            c43100c = C43100c.mtf;
            dxU = this.mtB.dxU();
            C25052j.m39375o(dxU, "context");
            if (C43100c.m76620dT(dxU)) {
                Vibrator b = this.mtB.iVt;
                if (b == null) {
                    C25052j.dWJ();
                }
                b.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
            }
            AppMethodBeat.m2505o(51085);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI$d */
    static final class C11947d implements Runnable {
        final /* synthetic */ ForceNotifyShowUI mtB;

        C11947d(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(51087);
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
                C25052j.m39375o(window, "window");
                View decorView = window.getDecorView();
                C25052j.m39375o(decorView, "window.decorView");
                decorView.setKeepScreenOn(false);
                AppMethodBeat.m2505o(51087);
            } catch (Exception e) {
                AppMethodBeat.m2505o(51087);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI$c */
    static final class C11948c implements OnClickListener {
        final /* synthetic */ ForceNotifyShowUI mtB;

        C11948c(ForceNotifyShowUI forceNotifyShowUI) {
            this.mtB = forceNotifyShowUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(51086);
            if (this.mtB.mtz.field_CreateTime > 0) {
                ((C28062a) C1720g.m3528K(C28062a.class)).mo36076b(this.mtB.username, String.valueOf(this.mtB.mtz.field_CreateTime / 1000) + this.mtB.mtz.field_UserName, 2, C1839cb.aaE() / 1000);
            }
            this.mtB.finish();
            this.mtB.overridePendingTransition(0, C25738R.anim.f8373ce);
            AppMethodBeat.m2505o(51086);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ForceNotifyShowUI() {
        AppMethodBeat.m2504i(51095);
        AppMethodBeat.m2505o(51095);
    }

    public final int getLayoutId() {
        return 2130969588;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(51088);
        super.onCreate(bundle);
        this.mtz.field_UserName = this.username;
        C45947a.mth.mo10102b((C4925c) this.mtz, new String[0]);
        Object systemService = getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        C44941v c44941v;
        if (systemService == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.m2505o(51088);
            throw c44941v;
        }
        this.euK = (AudioManager) systemService;
        systemService = dxU().getSystemService("vibrator");
        if (systemService == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.os.Vibrator");
            AppMethodBeat.m2505o(51088);
            throw c44941v;
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
        C4990ab.m7417i(this.TAG, "V:%s V1:%s  R:%s", valueOf4, valueOf, valueOf2);
        this.mtx = C11945a.mtA;
        audioManager = this.euK;
        if (audioManager != null) {
            valueOf3 = Integer.valueOf(audioManager.requestAudioFocus(this.mtx, 3, 2));
        } else {
            valueOf3 = null;
        }
        this.mty.postDelayed(new C11946b(this), 1000);
        Window window = getWindow();
        C25052j.m39375o(window, "window");
        View decorView = window.getDecorView();
        C25052j.m39375o(decorView, "window.decorView");
        decorView.setKeepScreenOn(true);
        C25052j.m39375o(findViewById(2131821019), "findViewById(R.id.content)");
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.f12009pb)));
        C4990ab.m7417i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", this.username, valueOf3);
        TextView textView = (TextView) findViewById(2131823149);
        ImageView imageView = (ImageView) findViewById(2131821183);
        findViewById(2131824119).setOnClickListener(new C11948c(this));
        this.mtw = new C11947d(this);
        this.mty.postDelayed(this.mtw, 60000);
        C43101b c43101b = this.mtz;
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        c43101b.ehM = ((C6982j) K).mo15369XM().aoO(this.username);
        C40460b.m69435b(imageView, this.mtz.field_UserName, 0.1f);
        C25052j.m39375o(textView, "titleView");
        Context baseContext = getBaseContext();
        C7616ad c7616ad = this.mtz.ehM;
        textView.setText(C44089j.m79283a(baseContext, c7616ad != null ? c7616ad.mo16707Oj() : null, (int) textView.getTextSize(), 0, null, null));
        C28062a c28062a = (C28062a) C1720g.m3528K(C28062a.class);
        String str = this.username;
        C43100c c43100c = C43100c.mtf;
        AppCompatActivity dxU = dxU();
        C25052j.m39375o(dxU, "context");
        if (C43100c.isSilentMode(dxU)) {
            c43100c = C43100c.mtf;
            dxU = dxU();
            C25052j.m39375o(dxU, "context");
            i = C43100c.m76620dT((Context) dxU) ? 1 : 4;
        } else {
            c43100c = C43100c.mtf;
            dxU = dxU();
            C25052j.m39375o(dxU, "context");
            i = C43100c.m76620dT((Context) dxU) ? 3 : 2;
        }
        c28062a.mo36077d(str, i, C1839cb.aaE() / 1000);
        if (this.username != null) {
            C45947a c45947a = C45947a.mth;
            String str2 = this.username;
            if (str2 == null) {
                C25052j.dWJ();
            }
            c45947a.mo73804pI(str2);
        }
        AppMethodBeat.m2505o(51088);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(51089);
        super.onBackPressed();
        C4990ab.m7416i(this.TAG, "[onBackPressed]");
        ((C28062a) C1720g.m3528K(C28062a.class)).mo36076b(this.username, String.valueOf(this.mtz.field_CreateTime / 1000) + this.mtz.field_UserName, 8, C1839cb.aaE() / 1000);
        AppMethodBeat.m2505o(51089);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(51090);
        C25052j.m39376p(keyEvent, "event");
        switch (i) {
            case 24:
                reset();
                AppMethodBeat.m2505o(51090);
                return true;
            case 25:
                reset();
                AppMethodBeat.m2505o(51090);
                return true;
            default:
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                AppMethodBeat.m2505o(51090);
                return onKeyDown;
        }
    }

    public final void onStop() {
        AppMethodBeat.m2504i(51091);
        super.onStop();
        reset();
        AppMethodBeat.m2505o(51091);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(51092);
        super.onDestroy();
        reset();
        AppMethodBeat.m2505o(51092);
    }

    public final void finish() {
        AppMethodBeat.m2504i(51093);
        super.finish();
        reset();
        AppMethodBeat.m2505o(51093);
    }

    private final void reset() {
        AppMethodBeat.m2504i(51094);
        Window window = getWindow();
        C25052j.m39375o(window, "window");
        View decorView = window.getDecorView();
        C25052j.m39375o(decorView, "window.decorView");
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
            C25052j.m39375o(window, "window");
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
                AppMethodBeat.m2505o(51094);
                return;
            }
            AppMethodBeat.m2505o(51094);
        } catch (IllegalStateException e) {
            AppMethodBeat.m2505o(51094);
        }
    }
}
