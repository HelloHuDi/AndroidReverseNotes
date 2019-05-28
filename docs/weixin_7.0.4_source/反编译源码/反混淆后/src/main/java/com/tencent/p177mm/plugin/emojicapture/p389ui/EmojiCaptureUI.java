package com.tencent.p177mm.plugin.emojicapture.p389ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C32304g.C32306b;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p1177ao.C25779b;
import com.tencent.p177mm.p230g.p231a.C42008in;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a.C11616a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.model.C34008e;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45864c;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a.C20425a;
import com.tencent.p177mm.plugin.emojicapture.p387e.C33989a;
import com.tencent.p177mm.plugin.emojicapture.p387e.C33995c;
import com.tencent.p177mm.plugin.emojicapture.p389ui.capture.CaptureContainer;
import com.tencent.p177mm.plugin.emojicapture.p389ui.capture.CaptureDecoration;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.CaptureEditorContainer;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27807a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C42981f;
import com.tencent.p177mm.plugin.emojicapture.p949c.C11605b.C11606a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27794a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27795b;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureReceiver;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.permission.C35807c;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoGlobalContext;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0010\u001a\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0014J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001dH\u0014J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0014J\b\u0010-\u001a\u00020\u001dH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI */
public final class EmojiCaptureUI extends MMActivity {
    public static final C34012a llj = new C34012a();
    private final String TAG = "MicroMsg.EmojiCaptureUI";
    private long ezZ;
    private final EmojiCaptureReporter lha = new EmojiCaptureReporter();
    private CaptureContainer llc;
    private CaptureEditorContainer lld;
    private C27794a lle;
    private C11606a llf;
    private EmojiCaptureReceiver llg;
    private final C27804f llh = new C27804f(this);
    private final C11621d lli = new C11621d(this);
    private int scene = 2;
    private int state;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$d */
    public static final class C11621d extends C4884c<C42008in> {
        final /* synthetic */ EmojiCaptureUI llk;

        C11621d(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(2867);
            C42008in c42008in = (C42008in) c4883b;
            C25052j.m39376p(c42008in, "event");
            if (c42008in.cDG != null) {
                C4990ab.m7417i(this.llk.TAG, "summerhardcoder system event [%s] BackCamera[%s]", Integer.valueOf(c42008in.cDG.keycode), Boolean.valueOf(EmojiCaptureUI.m55718g(this.llk).lms));
                if (c42008in.cDG.keycode == 1 && EmojiCaptureUI.m55718g(this.llk).lms) {
                    EmojiCaptureUI.m55718g(this.llk).mo45659Wg();
                }
            }
            AppMethodBeat.m2505o(2867);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$e */
    static final class C11622e implements Runnable {
        final /* synthetic */ long eYz;
        final /* synthetic */ EmojiCaptureUI llk;

        C11622e(EmojiCaptureUI emojiCaptureUI, long j) {
            this.llk = emojiCaptureUI;
            this.eYz = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(2868);
            C4990ab.m7416i(this.llk.TAG, "connect cost " + C5046bo.m7525az(this.eYz));
            EmojiCaptureUI.m55713b(this.llk);
            AppMethodBeat.m2505o(2868);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$f */
    public static final class C27804f implements C34010b {
        final /* synthetic */ EmojiCaptureUI llk;
        private C44275p llm;

        C27804f(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        /* renamed from: c */
        public final void mo45650c(C27800a c27800a) {
            AppMethodBeat.m2504i(2869);
            C25052j.m39376p(c27800a, "emojiCaptureInfo");
            C4990ab.m7416i(this.llk.TAG, "prepareEditor " + c27800a.videoPath);
            C34008e c34008e = C34008e.lhA;
            if (C34008e.m55709Kb(c27800a.videoPath)) {
                EmojiCaptureUI.m55714c(this.llk).setVisibility(0);
                EmojiCaptureUI.m55714c(this.llk).setAlpha(0.0f);
                C11606a d = this.llk.llf;
                if (d != null) {
                    d.mo23337b(c27800a);
                }
                C27794a e = this.llk.lle;
                if (e != null) {
                    e.mo45636pk();
                }
                this.llk.state = 2;
                AppMethodBeat.m2505o(2869);
                return;
            }
            EmojiCaptureReporter.m66038up(2);
            C34007d c34007d = C34007d.lhz;
            C34007d.bmV();
            AppMethodBeat.m2505o(2869);
        }

        public final void bnN() {
            AppMethodBeat.m2504i(2870);
            C4990ab.m7416i(this.llk.TAG, "go2Capture");
            EmojiCaptureUI.m55718g(this.llk).setVisibility(0);
            EmojiCaptureUI.m55714c(this.llk).setVisibility(8);
            EmojiCaptureUI.m55718g(this.llk).onResume();
            this.llk.state = 0;
            AppMethodBeat.m2505o(2870);
        }

        public final void bnO() {
            AppMethodBeat.m2504i(2871);
            C4990ab.m7416i(this.llk.TAG, "onEditorPrepared");
            if (this.llk.state == 2) {
                EmojiCaptureUI.m55714c(this.llk).setAlpha(1.0f);
                EmojiCaptureUI.m55718g(this.llk).setVisibility(8);
                bnP();
                this.llk.state = 1;
            }
            AppMethodBeat.m2505o(2871);
        }

        /* renamed from: Kc */
        public final void mo45645Kc(String str) {
            AppMethodBeat.m2504i(2872);
            C11606a d = this.llk.llf;
            if (d != null) {
                d.mo23336JZ(str);
                AppMethodBeat.m2505o(2872);
                return;
            }
            AppMethodBeat.m2505o(2872);
        }

        /* renamed from: a */
        public final void mo45646a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
            AppMethodBeat.m2504i(2873);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(charSequence, "msg");
            C44275p c44275p = this.llm;
            if (c44275p != null) {
                c44275p.dismiss();
            }
            this.llm = C44275p.m79966b(context, charSequence, z, onCancelListener);
            C4990ab.m7416i(this.llk.TAG, "showLoading: " + this.llm);
            AppMethodBeat.m2505o(2873);
        }

        public final void bnP() {
            AppMethodBeat.m2504i(2874);
            C44275p c44275p = this.llm;
            if (c44275p != null) {
                c44275p.dismiss();
            }
            C4990ab.m7416i(this.llk.TAG, "dismissLoading: " + this.llm);
            AppMethodBeat.m2505o(2874);
        }

        /* renamed from: k */
        public final void mo45651k(boolean z, String str) {
            AppMethodBeat.m2504i(2875);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("key_enter_time", this.llk.ezZ);
                intent.putExtra("gif_md5", str);
                this.llk.setResult(-1, intent);
            } else {
                this.llk.lha.ckF = System.currentTimeMillis() - this.llk.lha.ezZ;
                EmojiCaptureReporter.m66031a(6, this.llk.lha.ezZ, this.llk.lha.ckF, 0, 0, 0, 0, 0, 0, this.llk.lha.scene);
                this.llk.setResult(0);
            }
            this.llk.finish();
            AppMethodBeat.m2505o(2875);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$b */
    public interface C34010b {

        @C0220l(dWo = {1, 1, 13})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$b$a */
        public static final class C34011a {
            /* renamed from: a */
            public static /* synthetic */ void m55725a(C34010b c34010b, Context context, CharSequence charSequence) {
                AppMethodBeat.m2504i(2862);
                c34010b.mo45646a(context, charSequence, false, null);
                AppMethodBeat.m2505o(2862);
            }

            /* renamed from: a */
            public static /* synthetic */ void m55726a(C34010b c34010b, boolean z) {
                AppMethodBeat.m2504i(2863);
                c34010b.mo45651k(z, null);
                AppMethodBeat.m2505o(2863);
            }
        }

        /* renamed from: Kc */
        void mo45645Kc(String str);

        /* renamed from: a */
        void mo45646a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener);

        void bnN();

        void bnO();

        void bnP();

        /* renamed from: c */
        void mo45650c(C27800a c27800a);

        /* renamed from: k */
        void mo45651k(boolean z, String str);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$Companion;", "", "()V", "REQ_CODE_CHOOSE_IMAGE_FOR_EMOJI", "", "REQ_CODE_CROP_IMAGE_FOR_EMOJI", "REQ_CODE_SAVE_EMOJI_ALBUM", "REQ_CODE_SAVE_EMOJI_CAPTURE", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$a */
    public static final class C34012a {
        private C34012a() {
        }

        public /* synthetic */ C34012a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$c */
    static final class C34013c implements C35807c {
        final /* synthetic */ EmojiCaptureUI llk;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$c$2 */
        static final class C340142 implements OnClickListener {
            final /* synthetic */ C34013c lll;

            C340142(C34013c c34013c) {
                this.lll = c34013c;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(2865);
                C25052j.m39376p(dialogInterface, "dialog");
                dialogInterface.dismiss();
                this.lll.llk.finish();
                AppMethodBeat.m2505o(2865);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI$c$1 */
        static final class C340151 implements OnClickListener {
            final /* synthetic */ C34013c lll;

            C340151(C34013c c34013c) {
                this.lll = c34013c;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(2864);
                C25052j.m39376p(dialogInterface, "dialog");
                dialogInterface.dismiss();
                this.lll.llk.dxU().startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                AppMethodBeat.m2505o(2864);
            }
        }

        C34013c(EmojiCaptureUI emojiCaptureUI) {
            this.llk = emojiCaptureUI;
        }

        /* renamed from: r */
        public final void mo54547r(int[] iArr) {
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(2866);
            C25052j.m39375o(iArr, "grantResults");
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
                i3 = C25738R.string.dbs;
                Integer j = C36913i.m61700j(iArr, 0);
                if (j != null && j.intValue() == 0) {
                    i3 = C25738R.string.dc0;
                }
                C30379h.m48429a((Context) this.llk.dxU(), i3, (int) C25738R.string.dc8, (int) C25738R.string.ckr, (int) C25738R.string.f9076or, false, (OnClickListener) new C340151(this), (OnClickListener) new C340142(this));
            }
            AppMethodBeat.m2505o(2866);
        }
    }

    static {
        AppMethodBeat.m2504i(2885);
        AppMethodBeat.m2505o(2885);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiCaptureUI() {
        AppMethodBeat.m2504i(2884);
        AppMethodBeat.m2505o(2884);
    }

    /* renamed from: c */
    public static final /* synthetic */ CaptureEditorContainer m55714c(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.m2504i(2887);
        CaptureEditorContainer captureEditorContainer = emojiCaptureUI.lld;
        if (captureEditorContainer == null) {
            C25052j.avw("editorContainer");
        }
        AppMethodBeat.m2505o(2887);
        return captureEditorContainer;
    }

    /* renamed from: g */
    public static final /* synthetic */ CaptureContainer m55718g(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.m2504i(2888);
        CaptureContainer captureContainer = emojiCaptureUI.llc;
        if (captureContainer == null) {
            C25052j.avw("captureContainer");
        }
        AppMethodBeat.m2505o(2888);
        return captureContainer;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(2876);
        C4990ab.m7416i(this.TAG, "onCreate");
        overridePendingTransition(C25738R.anim.f8290p, -1);
        supportRequestWindowFeature(1);
        mo17375Ne(8);
        getWindow().addFlags(67109888);
        super.onCreate(bundle);
        VideoGlobalContext.setContext(C4996ah.getContext());
        this.scene = getIntent().getIntExtra("enter_scene", this.scene);
        this.ezZ = getIntent().getLongExtra("key_enter_time", 0);
        this.lha.scene = this.scene;
        this.lha.ezZ = this.ezZ;
        C12563j.bPw();
        C32306b.m52781ER();
        int intExtra = getIntent().getIntExtra("key_capture_max_duration", 5);
        String stringExtra = getIntent().getStringExtra("key_imitated_md5");
        C11617a c11617a = C34006c.lhw;
        C34006c.lhs = intExtra;
        this.lha.lgW = stringExtra;
        View findViewById = findViewById(2131823444);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_container)");
        this.llc = (CaptureContainer) findViewById;
        findViewById = findViewById(2131823445);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_container)");
        this.lld = (CaptureEditorContainer) findViewById;
        long yz = C5046bo.m7588yz();
        C20437a c20437a = EmojiCaptureProxy.lkM;
        C20437a.bnL();
        c20437a = EmojiCaptureProxy.lkM;
        C46607d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new C11622e(this, yz));
        }
        C34007d c34007d = C34007d.lhz;
        C34007d.bmP();
        VideoMemoryManager instance = VideoMemoryManager.getInstance();
        C25052j.m39375o(instance, "VideoMemoryManager.getInstance()");
        instance.setSampleSize(2);
        AppMethodBeat.m2505o(2876);
    }

    public final int getLayoutId() {
        return 2130969331;
    }

    public final int getForceOrientation() {
        AppMethodBeat.m2504i(2877);
        C20437a c20437a = EmojiCaptureProxy.lkM;
        if (EmojiCaptureProxy.lkL.getEnableAutoRotate()) {
            AppMethodBeat.m2505o(2877);
            return 7;
        }
        AppMethodBeat.m2505o(2877);
        return 1;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(2878);
        super.onPause();
        if (this.state == 0) {
            CaptureContainer captureContainer = this.llc;
            if (captureContainer == null) {
                C25052j.avw("captureContainer");
            }
            C4990ab.m7416i(captureContainer.TAG, "PauseCapture");
            CaptureDecoration decoration = captureContainer.getDecoration();
            decoration.lmz.pause();
            decoration.lmA.pause();
            captureContainer.lmr.stopPreview();
            AppMethodBeat.m2505o(2878);
            return;
        }
        C11606a c11606a = this.llf;
        if (c11606a != null) {
            c11606a.pause();
            AppMethodBeat.m2505o(2878);
            return;
        }
        AppMethodBeat.m2505o(2878);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(2879);
        super.onResume();
        if (this.state == 0) {
            if (C35805b.m58711e(this, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
                CaptureContainer captureContainer = this.llc;
                if (captureContainer == null) {
                    C25052j.avw("captureContainer");
                }
                captureContainer.onResume();
                AppMethodBeat.m2505o(2879);
                return;
            }
            C4990ab.m7416i(this.TAG, "initOnCreateAfterConnected: no permission");
            AppMethodBeat.m2505o(2879);
            return;
        }
        C11606a c11606a = this.llf;
        if (c11606a != null) {
            c11606a.resume();
            AppMethodBeat.m2505o(2879);
            return;
        }
        AppMethodBeat.m2505o(2879);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(2880);
        if (C1427q.etc.eqV == 1 && i == 700) {
            CaptureContainer captureContainer = this.llc;
            if (captureContainer == null) {
                C25052j.avw("captureContainer");
            }
            if (captureContainer.lms) {
                captureContainer = this.llc;
                if (captureContainer == null) {
                    C25052j.avw("captureContainer");
                }
                captureContainer.mo45659Wg();
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(2880);
        return onKeyDown;
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(2881);
        C11606a c11606a = this.llf;
        if (c11606a == null || !c11606a.mo23335Ab()) {
            C34011a.m55726a(this.llh, false);
        }
        AppMethodBeat.m2505o(2881);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(2882);
        C4879a.xxA.mo10053d(this.lli);
        super.onDestroy();
        C27794a c27794a = this.lle;
        if (c27794a != null) {
            c27794a.destroy();
        }
        CaptureContainer captureContainer = this.llc;
        if (captureContainer == null) {
            C25052j.avw("captureContainer");
        }
        C1786a c1786a = captureContainer.lme.eYL;
        if (c1786a != null) {
            if (c1786a instanceof C27807a) {
                ((C27807a) c1786a).loL.destroy();
            } else if (c1786a instanceof C42981f) {
                ((C42981f) c1786a).loL.destroy();
            }
        }
        C11606a c11606a = this.llf;
        if (c11606a != null) {
            c11606a.destroy();
        }
        if (this.llg != null) {
            unregisterReceiver(this.llg);
        }
        C45864c c45864c = C45864c.lhS;
        C45864c.destroy();
        C20437a c20437a = EmojiCaptureProxy.lkM;
        C20437a.bnM();
        C34007d c34007d = C34007d.lhz;
        C34007d.bmQ();
        AppMethodBeat.m2505o(2882);
    }

    public final void finish() {
        AppMethodBeat.m2504i(2883);
        super.finish();
        overridePendingTransition(-1, C25738R.anim.f8291q);
        AppMethodBeat.m2505o(2883);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m55713b(EmojiCaptureUI emojiCaptureUI) {
        AppMethodBeat.m2504i(2886);
        C11617a c11617a = C34006c.lhw;
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        C44039e provider = ((C6835d) M).getProvider();
        C25052j.m39375o(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        C34006c.lhr = provider.mo35613OS();
        C8902b.m16044a("EmojiCaptureConstants_setup", (C31214a) C11616a.lhx);
        if (C25779b.afY().agb()) {
            C7060h.pYm.mo15421z(933, 0);
        } else {
            C7060h.pYm.mo15421z(933, 1);
        }
        VideoMemoryManager instance = VideoMemoryManager.getInstance();
        C25052j.m39375o(instance, "VideoMemoryManager.getInstance()");
        instance.setSampleSize(((C20425a) C27792a.lhc.mo53288Uw()).lhf);
        C34006c.lht = ((C20425a) C27792a.lhc.mo53288Uw()).lhe;
        C45864c c45864c = C45864c.lhS;
        C45864c.init(emojiCaptureUI.scene);
        C27792a.lhc.init();
        C4990ab.m7409c(emojiCaptureUI.TAG, "onCreate useCpuCrop:".concat(String.valueOf(((C20425a) C27792a.lhc.mo53288Uw()).fau)), new Object[0]);
        VideoTransPara videoTransPara = (VideoTransPara) emojiCaptureUI.getIntent().getParcelableExtra("key_video_params");
        String stringExtra = emojiCaptureUI.getIntent().getStringExtra("key_imitated_md5");
        M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo Je = ((C6835d) M).getProvider().mo35597Je(stringExtra);
        emojiCaptureUI.lha.lgX = Je != null ? Je.field_lensId : null;
        Context context = emojiCaptureUI;
        CaptureContainer captureContainer = emojiCaptureUI.llc;
        if (captureContainer == null) {
            C25052j.avw("captureContainer");
        }
        C27795b c27795b = captureContainer;
        C25052j.m39375o(videoTransPara, "videoPara");
        emojiCaptureUI.lle = new C33989a(context, c27795b, videoTransPara, emojiCaptureUI.llh, emojiCaptureUI.lha);
        CaptureContainer captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            C25052j.avw("captureContainer");
        }
        captureContainer2.setPresenter(emojiCaptureUI.lle);
        captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            C25052j.avw("captureContainer");
        }
        captureContainer2.setReporter(emojiCaptureUI.lha);
        captureContainer2 = emojiCaptureUI.llc;
        if (captureContainer2 == null) {
            C25052j.avw("captureContainer");
        }
        captureContainer2.setup(Je);
        context = emojiCaptureUI;
        CaptureEditorContainer captureEditorContainer = emojiCaptureUI.lld;
        if (captureEditorContainer == null) {
            C25052j.avw("editorContainer");
        }
        emojiCaptureUI.llf = new C33995c(context, captureEditorContainer, emojiCaptureUI.llh, stringExtra, emojiCaptureUI.lha);
        CaptureEditorContainer captureEditorContainer2 = emojiCaptureUI.lld;
        if (captureEditorContainer2 == null) {
            C25052j.avw("editorContainer");
        }
        captureEditorContainer2.setPresenter(emojiCaptureUI.llf);
        captureEditorContainer2 = emojiCaptureUI.lld;
        if (captureEditorContainer2 == null) {
            C25052j.avw("editorContainer");
        }
        captureEditorContainer2.setReporter(emojiCaptureUI.lha);
        if (C35805b.m58711e(emojiCaptureUI, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
            captureContainer2 = emojiCaptureUI.llc;
            if (captureContainer2 == null) {
                C25052j.avw("captureContainer");
            }
            captureContainer2.onResume();
        } else {
            C35805b.m58706a((C35807c) new C34013c(emojiCaptureUI), new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
            C4990ab.m7416i(emojiCaptureUI.TAG, "initOnCreateAfterConnected: no permission");
        }
        C4879a.xxA.mo10052c(emojiCaptureUI.lli);
        emojiCaptureUI.llg = new EmojiCaptureReceiver();
        IntentFilter intentFilter = new IntentFilter("com.tencent.mm.Emoji_Capture_Res");
        intentFilter.addAction("com.tencent.mm.Emoji_Capture_Upload");
        emojiCaptureUI.registerReceiver(emojiCaptureUI.llg, intentFilter);
        EmojiCaptureReporter.m66038up(0);
        AppMethodBeat.m2505o(2886);
    }
}
