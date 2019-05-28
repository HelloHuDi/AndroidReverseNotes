package com.tencent.mm.plugin.emojicapture.ui;

import a.a.i;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.in;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoGlobalContext;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0010\u001a\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0014J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001dH\u0014J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0014J\b\u0010-\u001a\u00020\u001dH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI extends MMActivity {
    public static final a llj = new a();
    private final String TAG = "MicroMsg.EmojiCaptureUI";
    private long ezZ;
    private final EmojiCaptureReporter lha = new EmojiCaptureReporter();
    private CaptureContainer llc;
    private CaptureEditorContainer lld;
    private com.tencent.mm.plugin.emojicapture.c.a.a lle;
    private com.tencent.mm.plugin.emojicapture.c.b.a llf;
    private EmojiCaptureReceiver llg;
    private final f llh = new f(this);
    private final d lli = new d(this);
    private int scene = 2;
    private int state;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
    public static final class d extends com.tencent.mm.sdk.b.c<in> {
        final /* synthetic */ EmojiCaptureUI llk;

        d(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(2867);
            in inVar = (in) bVar;
            j.p(inVar, "event");
            if (inVar.cDG != null) {
                ab.i(this.llk.TAG, "summerhardcoder system event [%s] BackCamera[%s]", Integer.valueOf(inVar.cDG.keycode), Boolean.valueOf(EmojiCaptureUI.g(this.llk).lms));
                if (inVar.cDG.keycode == 1 && EmojiCaptureUI.g(this.llk).lms) {
                    EmojiCaptureUI.g(this.llk).Wg();
                }
            }
            AppMethodBeat.o(2867);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ long eYz;
        final /* synthetic */ EmojiCaptureUI llk;

        e(EmojiCaptureUI emojiCaptureUI, long j) {
            this.llk = emojiCaptureUI;
            this.eYz = j;
        }

        public final void run() {
            AppMethodBeat.i(2868);
            ab.i(this.llk.TAG, "connect cost " + bo.az(this.eYz));
            EmojiCaptureUI.b(this.llk);
            AppMethodBeat.o(2868);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    public static final class f implements b {
        final /* synthetic */ EmojiCaptureUI llk;
        private p llm;

        f(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        public final void c(com.tencent.mm.plugin.emojicapture.model.a.a aVar) {
            AppMethodBeat.i(2869);
            j.p(aVar, "emojiCaptureInfo");
            ab.i(this.llk.TAG, "prepareEditor " + aVar.videoPath);
            com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.lhA;
            if (com.tencent.mm.plugin.emojicapture.model.e.Kb(aVar.videoPath)) {
                EmojiCaptureUI.c(this.llk).setVisibility(0);
                EmojiCaptureUI.c(this.llk).setAlpha(0.0f);
                com.tencent.mm.plugin.emojicapture.c.b.a d = this.llk.llf;
                if (d != null) {
                    d.b(aVar);
                }
                com.tencent.mm.plugin.emojicapture.c.a.a e = this.llk.lle;
                if (e != null) {
                    e.pk();
                }
                this.llk.state = 2;
                AppMethodBeat.o(2869);
                return;
            }
            EmojiCaptureReporter.up(2);
            com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
            com.tencent.mm.plugin.emojicapture.model.d.bmV();
            AppMethodBeat.o(2869);
        }

        public final void bnN() {
            AppMethodBeat.i(2870);
            ab.i(this.llk.TAG, "go2Capture");
            EmojiCaptureUI.g(this.llk).setVisibility(0);
            EmojiCaptureUI.c(this.llk).setVisibility(8);
            EmojiCaptureUI.g(this.llk).onResume();
            this.llk.state = 0;
            AppMethodBeat.o(2870);
        }

        public final void bnO() {
            AppMethodBeat.i(2871);
            ab.i(this.llk.TAG, "onEditorPrepared");
            if (this.llk.state == 2) {
                EmojiCaptureUI.c(this.llk).setAlpha(1.0f);
                EmojiCaptureUI.g(this.llk).setVisibility(8);
                bnP();
                this.llk.state = 1;
            }
            AppMethodBeat.o(2871);
        }

        public final void Kc(String str) {
            AppMethodBeat.i(2872);
            com.tencent.mm.plugin.emojicapture.c.b.a d = this.llk.llf;
            if (d != null) {
                d.JZ(str);
                AppMethodBeat.o(2872);
                return;
            }
            AppMethodBeat.o(2872);
        }

        public final void a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
            AppMethodBeat.i(2873);
            j.p(context, "context");
            j.p(charSequence, "msg");
            p pVar = this.llm;
            if (pVar != null) {
                pVar.dismiss();
            }
            this.llm = p.b(context, charSequence, z, onCancelListener);
            ab.i(this.llk.TAG, "showLoading: " + this.llm);
            AppMethodBeat.o(2873);
        }

        public final void bnP() {
            AppMethodBeat.i(2874);
            p pVar = this.llm;
            if (pVar != null) {
                pVar.dismiss();
            }
            ab.i(this.llk.TAG, "dismissLoading: " + this.llm);
            AppMethodBeat.o(2874);
        }

        public final void k(boolean z, String str) {
            AppMethodBeat.i(2875);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("key_enter_time", this.llk.ezZ);
                intent.putExtra("gif_md5", str);
                this.llk.setResult(-1, intent);
            } else {
                this.llk.lha.ckF = System.currentTimeMillis() - this.llk.lha.ezZ;
                EmojiCaptureReporter.a(6, this.llk.lha.ezZ, this.llk.lha.ckF, 0, 0, 0, 0, 0, 0, this.llk.lha.scene);
                this.llk.setResult(0);
            }
            this.llk.finish();
            AppMethodBeat.o(2875);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    public interface b {

        @l(dWo = {1, 1, 13})
        public static final class a {
            public static /* synthetic */ void a(b bVar, Context context, CharSequence charSequence) {
                AppMethodBeat.i(2862);
                bVar.a(context, charSequence, false, null);
                AppMethodBeat.o(2862);
            }

            public static /* synthetic */ void a(b bVar, boolean z) {
                AppMethodBeat.i(2863);
                bVar.k(z, null);
                AppMethodBeat.o(2863);
            }
        }

        void Kc(String str);

        void a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener);

        void bnN();

        void bnO();

        void bnP();

        void c(com.tencent.mm.plugin.emojicapture.model.a.a aVar);

        void k(boolean z, String str);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$Companion;", "", "()V", "REQ_CODE_CHOOSE_IMAGE_FOR_EMOJI", "", "REQ_CODE_CROP_IMAGE_FOR_EMOJI", "REQ_CODE_SAVE_EMOJI_ALBUM", "REQ_CODE_SAVE_EMOJI_CAPTURE", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
    static final class c implements com.tencent.mm.pluginsdk.permission.c {
        final /* synthetic */ EmojiCaptureUI llk;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$c$2 */
        static final class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ c lll;

            AnonymousClass2(c cVar) {
                this.lll = cVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(2865);
                j.p(dialogInterface, "dialog");
                dialogInterface.dismiss();
                this.lll.llk.finish();
                AppMethodBeat.o(2865);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$c$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ c lll;

            AnonymousClass1(c cVar) {
                this.lll = cVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(2864);
                j.p(dialogInterface, "dialog");
                dialogInterface.dismiss();
                this.lll.llk.dxU().startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                AppMethodBeat.o(2864);
            }
        }

        c(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        public final void r(int[] iArr) {
            int i;
            int i2 = 1;
            AppMethodBeat.i(2866);
            j.o(iArr, "grantResults");
            for (int i3 : iArr) {
                if (i3 != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                i3 = R.string.dbs;
                Integer j = i.j(iArr, 0);
                if (j != null && j.intValue() == 0) {
                    i3 = R.string.dc0;
                }
                h.a((Context) this.llk.dxU(), i3, (int) R.string.dc8, (int) R.string.ckr, (int) R.string.or, false, (OnClickListener) new AnonymousClass1(this), (OnClickListener) new AnonymousClass2(this));
            }
            AppMethodBeat.o(2866);
        }
    }

    static {
        AppMethodBeat.i(2885);
        AppMethodBeat.o(2885);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiCaptureUI() {
        AppMethodBeat.i(2884);
        AppMethodBeat.o(2884);
    }

    public static final /* synthetic */ CaptureEditorContainer c(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.i(2887);
        CaptureEditorContainer captureEditorContainer = emojiCaptureUI.lld;
        if (captureEditorContainer == null) {
            j.avw("editorContainer");
        }
        AppMethodBeat.o(2887);
        return captureEditorContainer;
    }

    public static final /* synthetic */ CaptureContainer g(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.i(2888);
        CaptureContainer captureContainer = emojiCaptureUI.llc;
        if (captureContainer == null) {
            j.avw("captureContainer");
        }
        AppMethodBeat.o(2888);
        return captureContainer;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(2876);
        ab.i(this.TAG, "onCreate");
        overridePendingTransition(R.anim.p, -1);
        supportRequestWindowFeature(1);
        Ne(8);
        getWindow().addFlags(67109888);
        super.onCreate(bundle);
        VideoGlobalContext.setContext(ah.getContext());
        this.scene = getIntent().getIntExtra("enter_scene", this.scene);
        this.ezZ = getIntent().getLongExtra("key_enter_time", 0);
        this.lha.scene = this.scene;
        this.lha.ezZ = this.ezZ;
        com.tencent.mm.plugin.mmsight.model.j.bPw();
        com.tencent.mm.audio.b.g.b.ER();
        int intExtra = getIntent().getIntExtra("key_capture_max_duration", 5);
        String stringExtra = getIntent().getStringExtra("key_imitated_md5");
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        com.tencent.mm.plugin.emojicapture.model.c.lhs = intExtra;
        this.lha.lgW = stringExtra;
        View findViewById = findViewById(R.id.bdd);
        j.o(findViewById, "findViewById(R.id.capture_container)");
        this.llc = (CaptureContainer) findViewById;
        findViewById = findViewById(R.id.bde);
        j.o(findViewById, "findViewById(R.id.editor_container)");
        this.lld = (CaptureEditorContainer) findViewById;
        long yz = bo.yz();
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.lkM;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnL();
        aVar2 = EmojiCaptureProxy.lkM;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new e(this, yz));
        }
        com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
        com.tencent.mm.plugin.emojicapture.model.d.bmP();
        VideoMemoryManager instance = VideoMemoryManager.getInstance();
        j.o(instance, "VideoMemoryManager.getInstance()");
        instance.setSampleSize(2);
        AppMethodBeat.o(2876);
    }

    public final int getLayoutId() {
        return R.layout.tn;
    }

    public final int getForceOrientation() {
        AppMethodBeat.i(2877);
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        if (EmojiCaptureProxy.lkL.getEnableAutoRotate()) {
            AppMethodBeat.o(2877);
            return 7;
        }
        AppMethodBeat.o(2877);
        return 1;
    }

    public final void onPause() {
        AppMethodBeat.i(2878);
        super.onPause();
        if (this.state == 0) {
            CaptureContainer captureContainer = this.llc;
            if (captureContainer == null) {
                j.avw("captureContainer");
            }
            ab.i(captureContainer.TAG, "PauseCapture");
            CaptureDecoration decoration = captureContainer.getDecoration();
            decoration.lmz.pause();
            decoration.lmA.pause();
            captureContainer.lmr.stopPreview();
            AppMethodBeat.o(2878);
            return;
        }
        com.tencent.mm.plugin.emojicapture.c.b.a aVar = this.llf;
        if (aVar != null) {
            aVar.pause();
            AppMethodBeat.o(2878);
            return;
        }
        AppMethodBeat.o(2878);
    }

    public final void onResume() {
        AppMethodBeat.i(2879);
        super.onResume();
        if (this.state == 0) {
            if (com.tencent.mm.pluginsdk.permission.b.e(this, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
                CaptureContainer captureContainer = this.llc;
                if (captureContainer == null) {
                    j.avw("captureContainer");
                }
                captureContainer.onResume();
                AppMethodBeat.o(2879);
                return;
            }
            ab.i(this.TAG, "initOnCreateAfterConnected: no permission");
            AppMethodBeat.o(2879);
            return;
        }
        com.tencent.mm.plugin.emojicapture.c.b.a aVar = this.llf;
        if (aVar != null) {
            aVar.resume();
            AppMethodBeat.o(2879);
            return;
        }
        AppMethodBeat.o(2879);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(2880);
        if (q.etc.eqV == 1 && i == 700) {
            CaptureContainer captureContainer = this.llc;
            if (captureContainer == null) {
                j.avw("captureContainer");
            }
            if (captureContainer.lms) {
                captureContainer = this.llc;
                if (captureContainer == null) {
                    j.avw("captureContainer");
                }
                captureContainer.Wg();
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(2880);
        return onKeyDown;
    }

    public final void onBackPressed() {
        AppMethodBeat.i(2881);
        com.tencent.mm.plugin.emojicapture.c.b.a aVar = this.llf;
        if (aVar == null || !aVar.Ab()) {
            a.a(this.llh, false);
        }
        AppMethodBeat.o(2881);
    }

    public final void onDestroy() {
        AppMethodBeat.i(2882);
        com.tencent.mm.sdk.b.a.xxA.d(this.lli);
        super.onDestroy();
        com.tencent.mm.plugin.emojicapture.c.a.a aVar = this.lle;
        if (aVar != null) {
            aVar.destroy();
        }
        CaptureContainer captureContainer = this.llc;
        if (captureContainer == null) {
            j.avw("captureContainer");
        }
        com.tencent.mm.media.h.b.a aVar2 = captureContainer.lme.eYL;
        if (aVar2 != null) {
            if (aVar2 instanceof com.tencent.mm.plugin.emojicapture.ui.b.a) {
                ((com.tencent.mm.plugin.emojicapture.ui.b.a) aVar2).loL.destroy();
            } else if (aVar2 instanceof com.tencent.mm.plugin.emojicapture.ui.b.f) {
                ((com.tencent.mm.plugin.emojicapture.ui.b.f) aVar2).loL.destroy();
            }
        }
        com.tencent.mm.plugin.emojicapture.c.b.a aVar3 = this.llf;
        if (aVar3 != null) {
            aVar3.destroy();
        }
        if (this.llg != null) {
            unregisterReceiver(this.llg);
        }
        com.tencent.mm.plugin.emojicapture.model.a.c cVar = com.tencent.mm.plugin.emojicapture.model.a.c.lhS;
        com.tencent.mm.plugin.emojicapture.model.a.c.destroy();
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar4 = EmojiCaptureProxy.lkM;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnM();
        com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
        com.tencent.mm.plugin.emojicapture.model.d.bmQ();
        AppMethodBeat.o(2882);
    }

    public final void finish() {
        AppMethodBeat.i(2883);
        super.finish();
        overridePendingTransition(-1, R.anim.q);
        AppMethodBeat.o(2883);
    }

    public static final /* synthetic */ void b(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.i(2886);
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        com.tencent.mm.pluginsdk.a.e provider = ((com.tencent.mm.plugin.emoji.b.d) M).getProvider();
        j.o(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        com.tencent.mm.plugin.emojicapture.model.c.lhr = provider.OS();
        com.tencent.mm.ab.b.a("EmojiCaptureConstants_setup", (a.f.a.a) com.tencent.mm.plugin.emojicapture.model.c.a.a.lhx);
        if (com.tencent.mm.ao.b.afY().agb()) {
            com.tencent.mm.plugin.report.service.h.pYm.z(933, 0);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.z(933, 1);
        }
        VideoMemoryManager instance = VideoMemoryManager.getInstance();
        j.o(instance, "VideoMemoryManager.getInstance()");
        instance.setSampleSize(((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).lhf);
        com.tencent.mm.plugin.emojicapture.model.c.lht = ((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).lhe;
        com.tencent.mm.plugin.emojicapture.model.a.c cVar = com.tencent.mm.plugin.emojicapture.model.a.c.lhS;
        com.tencent.mm.plugin.emojicapture.model.a.c.init(emojiCaptureUI.scene);
        com.tencent.mm.plugin.emojicapture.b.a.lhc.init();
        ab.c(emojiCaptureUI.TAG, "onCreate useCpuCrop:".concat(String.valueOf(((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).fau)), new Object[0]);
        VideoTransPara videoTransPara = (VideoTransPara) emojiCaptureUI.getIntent().getParcelableExtra("key_video_params");
        String stringExtra = emojiCaptureUI.getIntent().getStringExtra("key_imitated_md5");
        M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo Je = ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().Je(stringExtra);
        emojiCaptureUI.lha.lgX = Je != null ? Je.field_lensId : null;
        Context context = emojiCaptureUI;
        CaptureContainer captureContainer = emojiCaptureUI.llc;
        if (captureContainer == null) {
            j.avw("captureContainer");
        }
        com.tencent.mm.plugin.emojicapture.c.a.b bVar = captureContainer;
        j.o(videoTransPara, "videoPara");
        emojiCaptureUI.lle = new com.tencent.mm.plugin.emojicapture.e.a(context, bVar, videoTransPara, emojiCaptureUI.llh, emojiCaptureUI.lha);
        CaptureContainer captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            j.avw("captureContainer");
        }
        captureContainer2.setPresenter(emojiCaptureUI.lle);
        captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            j.avw("captureContainer");
        }
        captureContainer2.setReporter(emojiCaptureUI.lha);
        captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            j.avw("captureContainer");
        }
        captureContainer2.setup(Je);
        context = emojiCaptureUI;
        CaptureEditorContainer captureEditorContainer = emojiCaptureUI.lld;
        if (captureEditorContainer == null) {
            j.avw("editorContainer");
        }
        emojiCaptureUI.llf = new com.tencent.mm.plugin.emojicapture.e.c(context, captureEditorContainer, emojiCaptureUI.llh, stringExtra, emojiCaptureUI.lha);
        CaptureEditorContainer captureEditorContainer2 = emojiCaptureUI.lld;
        if (captureEditorContainer2 == null) {
            j.avw("editorContainer");
        }
        captureEditorContainer2.setPresenter(emojiCaptureUI.llf);
        captureEditorContainer2 = emojiCaptureUI.lld;
        if (captureEditorContainer2 == null) {
            j.avw("editorContainer");
        }
        captureEditorContainer2.setReporter(emojiCaptureUI.lha);
        if (com.tencent.mm.pluginsdk.permission.b.e(emojiCaptureUI, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
            captureContainer2 = emojiCaptureUI.llc;
            if (captureContainer2 == null) {
                j.avw("captureContainer");
            }
            captureContainer2.onResume();
        } else {
            com.tencent.mm.pluginsdk.permission.b.a((com.tencent.mm.pluginsdk.permission.c) new c(emojiCaptureUI), new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
            ab.i(emojiCaptureUI.TAG, "initOnCreateAfterConnected: no permission");
        }
        com.tencent.mm.sdk.b.a.xxA.c(emojiCaptureUI.lli);
        emojiCaptureUI.llg = new EmojiCaptureReceiver();
        IntentFilter intentFilter = new IntentFilter("com.tencent.mm.Emoji_Capture_Res");
        intentFilter.addAction("com.tencent.mm.Emoji_Capture_Upload");
        emojiCaptureUI.registerReceiver(emojiCaptureUI.llg, intentFilter);
        EmojiCaptureReporter.up(0);
        AppMethodBeat.o(2886);
    }
}
