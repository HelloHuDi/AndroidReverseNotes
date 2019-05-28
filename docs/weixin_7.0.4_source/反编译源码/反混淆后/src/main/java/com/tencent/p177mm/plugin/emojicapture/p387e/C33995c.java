package com.tencent.p177mm.plugin.emojicapture.p387e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.emoji.p228d.C26074a;
import com.tencent.p177mm.emoji.p228d.C41949b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.p388b.C11615d;
import com.tencent.p177mm.plugin.emojicapture.model.p388b.C20429e;
import com.tencent.p177mm.plugin.emojicapture.model.p388b.C42972a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureUI.C34010b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureUI.C34010b.C34011a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiVideoPlayTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.C38926a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorItemContainer;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorOutsideView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EmojiEditorItemView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.TextEditorItemView;
import com.tencent.p177mm.plugin.emojicapture.p949c.C11605b.C11606a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C11605b.C11607b;
import com.tencent.p177mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0017\u0018\u0000 G2\u00020\u0001:\u0001GB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J7\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020$\u0018\u00010*H\u0002J2\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\t02j\b\u0012\u0004\u0012\u00020\t`3H\u0002J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020\u0014H\u0016J\u0012\u00109\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010:\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020\u0014H\u0016J\u0006\u0010=\u001a\u00020$J\b\u0010>\u001a\u00020$H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020\u0014H\u0002J\"\u0010C\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0014H\u0016J\"\u0010F\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0014H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.e.c */
public final class C33995c implements C11606a {
    public static final C34000a lkx = new C34000a();
    private Context context;
    private final C46607d ext = new C46607d(this.context);
    private final String eyL;
    private final EmojiCaptureReporter lha;
    private boolean liA;
    private String ljP;
    private C27800a ljQ = new C27800a();
    private C34010b ljV;
    private String lko;
    private boolean lkp;
    private boolean lkq;
    private boolean lkr;
    private final CgiEmojiTextSpamProxy lks = new CgiEmojiTextSpamProxy(this.ext);
    private C11615d lkt;
    private final C31351e lku = new C31351e(this);
    private final Runnable lkv = new C34001c(this);
    private C11607b lkw;
    private int textColor;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$f */
    static final class C11608f extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C33995c lkA;
        final /* synthetic */ String lkC;

        C11608f(C33995c c33995c, String str) {
            this.lkA = c33995c;
            this.lkC = str;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2771);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i("MicroMsg.EditorPresenter", "voice text block ".concat(String.valueOf(booleanValue)));
            this.lkA.lkp = true;
            if (booleanValue) {
                C23639t.makeText(this.lkA.context, C25738R.string.bcv, 0).show();
            } else {
                this.lkA.ljP = this.lkC;
            }
            C33995c.m55685d(this.lkA);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2771);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$d */
    static final class C20426d implements OnDismissListener {
        final /* synthetic */ C33995c lkA;

        C20426d(C33995c c33995c) {
            this.lkA = c33995c;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(2768);
            C33995c.m55693k(this.lkA);
            AppMethodBeat.m2505o(2768);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$g */
    static final class C27799g implements Runnable {
        final /* synthetic */ C33995c lkA;

        C27799g(C33995c c33995c) {
            this.lkA = c33995c;
        }

        public final void run() {
            AppMethodBeat.m2504i(2772);
            if (this.lkA.lkp && this.lkA.lkq) {
                EmojiVideoPlayTextureView videoPlayView = this.lkA.lkw.getVideoPlayView();
                if (videoPlayView != null) {
                    EmojiVideoPlayTextureView.m76311a(videoPlayView, this.lkA.liA);
                }
                this.lkA.lkw.bmA();
                this.lkA.ljV.bnO();
                C33995c.m55679a(this.lkA, this.lkA.ljP, this.lkA.textColor, true);
                this.lkA.lkq = false;
                this.lkA.lkp = false;
            }
            AppMethodBeat.m2505o(2772);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$e */
    public static final class C31351e implements C26074a {
        final /* synthetic */ C33995c lkA;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$e$a */
        static final class C31352a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ boolean eyb;
            final /* synthetic */ String ezX;
            final /* synthetic */ C31351e lkB;

            C31352a(C31351e c31351e, boolean z, String str) {
                this.lkB = c31351e;
                this.eyb = z;
                this.ezX = str;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(2769);
                C5004al.m7439af(this.lkB.lkA.lkv);
                this.lkB.lkA.ljV.bnP();
                if (this.eyb) {
                    this.lkB.lkA.ljV.mo45651k(true, this.ezX);
                } else {
                    C23639t.makeText(this.lkB.lkA.context, C25738R.string.b_8, 0).show();
                    this.lkB.lkA.resume();
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2769);
                return c37091y;
            }
        }

        C31351e(C33995c c33995c) {
            this.lkA = c33995c;
        }

        /* renamed from: a */
        public final void mo43943a(long j, boolean z, String str) {
            AppMethodBeat.m2504i(2770);
            C8902b.m16042a(new C31352a(this, z, str));
            AppMethodBeat.m2505o(2770);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$b */
    static final class C33996b extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C17126b exI;

        C33996b(C17126b c17126b) {
            this.exI = c17126b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2766);
            final boolean booleanValue = ((Boolean) obj).booleanValue();
            C5004al.m7441d(new Runnable(this) {
                final /* synthetic */ C33996b lky;

                public final void run() {
                    AppMethodBeat.m2504i(2765);
                    C17126b c17126b = this.lky.exI;
                    if (c17126b != null) {
                        c17126b.mo50am(Boolean.valueOf(booleanValue));
                        AppMethodBeat.m2505o(2765);
                        return;
                    }
                    AppMethodBeat.m2505o(2765);
                }
            });
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2766);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$h */
    static final class C33997h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C33995c lkA;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$h$1 */
        static final class C339941 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C33997h lkD;

            C339941(C33997h c33997h) {
                this.lkD = c33997h;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(2773);
                C4990ab.m7416i("MicroMsg.EditorPresenter", "remove bg callback");
                this.lkD.lkA.lkq = true;
                C33995c.m55685d(this.lkD.lkA);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2773);
                return c37091y;
            }
        }

        C33997h(C33995c c33995c) {
            this.lkA = c33995c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2774);
            EmojiVideoPlayTextureView videoPlayView = this.lkA.lkw.getVideoPlayView();
            if (videoPlayView != null) {
                videoPlayView.mo68506b(this.lkA.liA, (C31214a) new C339941(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2774);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$i */
    static final class C33998i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C27800a lkE;

        C33998i(C27800a c27800a) {
            this.lkE = c27800a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2775);
            C43528a WR = C21846d.m33388WR(this.lkE.videoPath);
            if (WR != null) {
                EmojiCaptureReporter.m66038up(34);
                EmojiCaptureReporter.m66034dU(35, WR.eWK);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2775);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$k */
    static final class C33999k implements OnClickListener {
        final /* synthetic */ C33995c lkA;
        final /* synthetic */ C31596c lkI;

        C33999k(C33995c c33995c, C31596c c31596c) {
            this.lkA = c33995c;
            this.lkI = c31596c;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2777);
            this.lkA.lkw.mo23347a(true, ((TextEditorItemView) this.lkI.AVE).getText(), ((TextEditorItemView) this.lkI.AVE).getTextColor());
            EmojiCaptureReporter.m66031a(13, this.lkA.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lkA.lha.scene);
            AppMethodBeat.m2505o(2777);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$a */
    public static final class C34000a {
        private C34000a() {
        }

        public /* synthetic */ C34000a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$c */
    static final class C34001c implements Runnable {
        final /* synthetic */ C33995c lkA;

        C34001c(C33995c c33995c) {
            this.lkA = c33995c;
        }

        public final void run() {
            AppMethodBeat.m2504i(2767);
            this.lkA.ljV.bnP();
            C23639t.makeText(this.lkA.context, C25738R.string.b_8, 0).show();
            this.lkA.resume();
            AppMethodBeat.m2505o(2767);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$j */
    static final class C34002j extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C44275p iyc;
        final /* synthetic */ C33995c lkA;
        final /* synthetic */ String lkF;
        final /* synthetic */ int lkG;
        final /* synthetic */ boolean lkH;

        C34002j(C33995c c33995c, C44275p c44275p, String str, int i, boolean z) {
            this.lkA = c33995c;
            this.iyc = c44275p;
            this.lkF = str;
            this.lkG = i;
            this.lkH = z;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2776);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.iyc.dismiss();
            if (booleanValue) {
                C23639t.makeText(this.lkA.context, C25738R.string.bcv, 0).show();
            } else {
                C33995c.m55679a(this.lkA, this.lkF, this.lkG, this.lkH);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2776);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(2794);
        AppMethodBeat.m2505o(2794);
    }

    public C33995c(Context context, C11607b c11607b, C34010b c34010b, String str, EmojiCaptureReporter emojiCaptureReporter) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c11607b, "view");
        C25052j.m39376p(c34010b, "uiNavigation");
        C25052j.m39376p(emojiCaptureReporter, "reporter");
        AppMethodBeat.m2504i(2793);
        this.context = context;
        this.lkw = c11607b;
        this.ljV = c34010b;
        this.eyL = str;
        this.lha = emojiCaptureReporter;
        AppMethodBeat.m2505o(2793);
    }

    /* renamed from: k */
    public static final /* synthetic */ void m55693k(C33995c c33995c) {
        AppMethodBeat.m2504i(2797);
        c33995c.bnK();
        AppMethodBeat.m2505o(2797);
    }

    /* renamed from: b */
    public final void mo23337b(C27800a c27800a) {
        AppMethodBeat.m2504i(2778);
        C25052j.m39376p(c27800a, "emojiCaptureInfo");
        C4990ab.m7416i("MicroMsg.EditorPresenter", "setup");
        this.ljQ = c27800a;
        this.lko = c27800a.videoPath;
        this.liA = c27800a.lgS;
        this.textColor = c27800a.lhJ;
        this.lkw.mo23346a(c27800a, c27800a.videoPath, c27800a.lhK, this.liA, new C33997h(this));
        C8902b.m16044a("EditorPresenter_setup", (C31214a) new C33998i(c27800a));
        AppMethodBeat.m2505o(2778);
    }

    /* renamed from: JZ */
    public final void mo23336JZ(String str) {
        AppMethodBeat.m2504i(2779);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "voice text callback");
        m55682b(str, (C17126b) new C11608f(this, str));
        AppMethodBeat.m2505o(2779);
    }

    public final boolean bmx() {
        boolean z = true;
        AppMethodBeat.m2504i(2780);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "removeBg " + this.liA);
        if (this.ljQ.lhK) {
            EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
            if (videoPlayView == null || !videoPlayView.isPlaying()) {
                AppMethodBeat.m2505o(2780);
                return false;
            }
            if (this.liA) {
                z = false;
            }
            this.liA = z;
            EmojiVideoPlayTextureView videoPlayView2 = this.lkw.getVideoPlayView();
            if (videoPlayView2 != null) {
                EmojiVideoPlayTextureView.m76311a(videoPlayView2, this.liA);
            }
            boolean z2 = this.liA;
            AppMethodBeat.m2505o(2780);
            return z2;
        }
        AppMethodBeat.m2505o(2780);
        return false;
    }

    public final boolean bmy() {
        AppMethodBeat.m2504i(2781);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "speedUp " + this.lkr);
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView == null || videoPlayView.getPlayRate() != 1.0f) {
            EmojiVideoPlayTextureView videoPlayView2 = this.lkw.getVideoPlayView();
            if (videoPlayView2 != null) {
                videoPlayView2.setPlayRate(1.0f);
            }
            this.lkr = false;
            AppMethodBeat.m2505o(2781);
            return false;
        }
        EmojiVideoPlayTextureView videoPlayView3 = this.lkw.getVideoPlayView();
        if (videoPlayView3 != null) {
            videoPlayView3.setPlayRate(2.0f);
        }
        this.lkr = true;
        AppMethodBeat.m2505o(2781);
        return true;
    }

    /* renamed from: c */
    public final void mo23341c(C8955k c8955k) {
        AppMethodBeat.m2504i(2782);
        C25052j.m39376p(c8955k, "emojiInfo");
        if (c8955k instanceof EmojiInfo) {
            if (this.lkw.getItemContainer().getAllEmojiMd5().size() >= 8) {
                C23639t.makeText(this.context, C25738R.string.b98, 0).show();
                AppMethodBeat.m2505o(2782);
                return;
            }
            C38926a emojiEditorItemView = new EmojiEditorItemView(this.context);
            ((EmojiEditorItemView) emojiEditorItemView).setEmojiInfo((EmojiInfo) c8955k);
            emojiEditorItemView.resume();
            EditorItemContainer itemContainer = this.lkw.getItemContainer();
            C25052j.m39376p(emojiEditorItemView, "itemView");
            itemContainer.lnI.addView((View) emojiEditorItemView, new LayoutParams(-1, -1));
            RectF validRect = itemContainer.getValidRect();
            Context context = itemContainer.getContext();
            C25052j.m39375o(context, "context");
            emojiEditorItemView.mo35774a(validRect, context.getResources().getDimension(C25738R.dimen.f9629f));
            itemContainer.setEditing(emojiEditorItemView);
            itemContainer.lnI.bringChildToFront(itemContainer.getTextItem());
        }
        AppMethodBeat.m2505o(2782);
    }

    /* renamed from: n */
    public final void mo23343n(String str, int i, boolean z) {
        AppMethodBeat.m2504i(2783);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(str)));
        m55682b(str, (C17126b) new C34002j(this, C44275p.m79966b(this.context, this.context.getString(C25738R.string.cn5), true, null), str, i, z));
        AppMethodBeat.m2505o(2783);
    }

    public final void bmz() {
        AppMethodBeat.m2504i(2784);
        if (!C5046bo.isNullOrNil(this.eyL)) {
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            if (!((Boolean) ((C6835d) M).getProvider().mo35641c(C5127a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                new C5652a(this.context).mo11450PZ(C25738R.string.b5y).mo11453Qc(C25738R.string.b5x).mo11458a((OnDismissListener) new C20426d(this)).show();
                M = C1720g.m3530M(C6835d.class);
                C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((C6835d) M).getProvider().mo35644d(C5127a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.m2505o(2784);
                return;
            }
        }
        bnK();
        AppMethodBeat.m2505o(2784);
    }

    private final void bnK() {
        String str;
        AppMethodBeat.m2504i(2785);
        String str2 = "MicroMsg.EditorPresenter";
        StringBuilder stringBuilder = new StringBuilder("start mix ");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        C4990ab.m7416i(str2, stringBuilder.append(videoPlayView != null ? videoPlayView.getVideoPath() : null).toString());
        C42972a c42972a = new C42972a(this.lkw.getItemContainer().getValidRect());
        List<C38926a> allItemViews = this.lkw.getItemContainer().getAllItemViews();
        ArrayList allEmojiMd5 = this.lkw.getItemContainer().getAllEmojiMd5();
        TextEditorItemView textItem = this.lkw.getItemContainer().getTextItem();
        int textColor = textItem != null ? textItem.getTextColor() : 0;
        String attachedText = this.lkw.getItemContainer().getAttachedText();
        for (C38926a UI : allItemViews) {
            c42972a.mo68503a(UI.mo26048UI());
        }
        EmojiInfo a;
        C20429e c20429e;
        long j;
        if (this.lkt == null) {
            this.lha.eyJ = this.lkw.getItemContainer().getAttachedText();
            this.lha.textColor = textColor;
            this.lha.lgS = this.liA;
            this.lha.lgT = this.lkr;
            this.lha.lgU = allEmojiMd5.size();
            this.lha.ckF = System.currentTimeMillis() - this.lha.ezZ;
            EmojiCaptureReporter emojiCaptureReporter = this.lha;
            C42971b c42971b = this.ljQ.lhH;
            if (c42971b != null) {
                str = c42971b.lgY;
            } else {
                str = null;
            }
            emojiCaptureReporter.lgY = str;
            this.lha.bmv();
            a = m55677a(attachedText, textColor, allEmojiMd5);
            c20429e = C20429e.liH;
            textColor = this.ljQ.scene;
            j = a.field_captureEnterTime;
            attachedText = this.ljQ.videoPath;
            videoPlayView = this.lkw.getVideoPlayView();
            this.lkt = C20429e.m31584a(textColor, j, attachedText, c42972a, videoPlayView != null ? (int) videoPlayView.getPlayRate() : 1, this.liA, this.ljQ.lhH != null, a);
        } else {
            C20437a c20437a = EmojiCaptureProxy.lkM;
            EmojiCaptureProxy.lkL.deleteEmojiInfoByEnterTime(this.lha.ezZ);
            a = m55677a(attachedText, textColor, allEmojiMd5);
            c20429e = C20429e.liH;
            textColor = this.ljQ.scene;
            j = a.field_captureEnterTime;
            attachedText = this.ljQ.videoPath;
            videoPlayView = this.lkw.getVideoPlayView();
            this.lkt = C20429e.m31584a(textColor, j, attachedText, c42972a, videoPlayView != null ? (int) videoPlayView.getPlayRate() : 1, this.liA, this.ljQ.lhH != null, a);
        }
        pause();
        if (C20443a.m31596uC(this.ljQ.scene)) {
            C5004al.m7439af(this.lkv);
            C5004al.m7442n(this.lkv, 60000);
            C34010b c34010b = this.ljV;
            Context context = this.context;
            str = this.context.getString(C25738R.string.b_9);
            C25052j.m39375o(str, "context.getString(R.string.emoji_generating)");
            C34011a.m55725a(c34010b, context, str);
            C41949b c41949b = C41949b.ezV;
            C41949b.m74082a(this.ljQ.ezZ, this.lku);
            AppMethodBeat.m2505o(2785);
            return;
        }
        C34011a.m55726a(this.ljV, true);
        AppMethodBeat.m2505o(2785);
    }

    /* renamed from: a */
    private final EmojiInfo m55677a(String str, int i, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(2786);
        String str2 = this.ljQ.thumbPath;
        String atg = C5730e.atg(str2);
        EmojiInfo emojiInfo = new EmojiInfo();
        String str3 = EmojiInfo.dvg() + atg;
        if (!C1173e.m2561ct(str3)) {
            C5730e.m8644y(str2, str3);
        }
        C4990ab.m7416i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + atg + " outputPath: " + str3);
        emojiInfo.mo48550vS(atg);
        emojiInfo.asX("capture");
        emojiInfo.mo48509Vp(EmojiInfo.yau);
        emojiInfo.field_attachedText = str;
        C11617a c11617a = C34006c.lhw;
        emojiInfo.field_width = C34006c.lhv;
        c11617a = C34006c.lhw;
        emojiInfo.field_height = C34006c.lhv;
        emojiInfo.mo48510a(C30302a.STATUS_MIXING);
        emojiInfo.mo48512al(arrayList);
        emojiInfo.field_imitateMd5 = this.eyL;
        emojiInfo.field_captureEnterTime = this.lha.ezZ;
        C42971b c42971b = this.ljQ.lhH;
        if (c42971b != null) {
            str2 = c42971b.lgY;
        } else {
            str2 = null;
        }
        emojiInfo.field_lensId = str2;
        c11617a = C34006c.lhw;
        emojiInfo.field_attachTextColor = C11617a.m19437ut(i);
        emojiInfo.field_captureScene = this.lha.scene;
        C20437a c20437a = EmojiCaptureProxy.lkM;
        EmojiCaptureProxy.lkL.createEmojiInfo(emojiInfo);
        AppMethodBeat.m2505o(2786);
        return emojiInfo;
    }

    /* renamed from: b */
    private final void m55682b(String str, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(2787);
        if (C5046bo.isNullOrNil(str)) {
            c17126b.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(2787);
            return;
        }
        this.lks.cgiEmojiTextSpam(str, new C33996b(c17126b));
        AppMethodBeat.m2505o(2787);
    }

    /* renamed from: gE */
    private final void m55689gE(boolean z) {
        AppMethodBeat.m2504i(2788);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(z)));
        if (this.context instanceof Activity) {
            Context context = this.context;
            if (context == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(2788);
                throw c44941v;
            }
            Activity activity = (Activity) context;
            if (z) {
                activity.getWindow().clearFlags(16);
                AppMethodBeat.m2505o(2788);
                return;
            }
            activity.getWindow().addFlags(16);
        }
        AppMethodBeat.m2505o(2788);
    }

    /* renamed from: Ab */
    public final boolean mo23335Ab() {
        AppMethodBeat.m2504i(2789);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "onBack: " + this.lkw.aFF() + ' ' + this.lkw.bmB() + ' ' + this.lkw.bmC());
        if (!this.lkw.aFF()) {
            AppMethodBeat.m2505o(2789);
            return false;
        } else if (this.lkw.bmB()) {
            this.lkw.mo23347a(false, null, 0);
            AppMethodBeat.m2505o(2789);
            return true;
        } else if (this.lkw.bmC()) {
            this.lkw.mo23353gC(false);
            AppMethodBeat.m2505o(2789);
            return true;
        } else {
            this.liA = false;
            this.lkr = false;
            this.ljP = null;
            this.lkp = false;
            this.lkq = false;
            EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
            C5730e.deleteFile(videoPlayView != null ? videoPlayView.getVideoPath() : null);
            this.lkw.reset();
            EditorItemContainer itemContainer = this.lkw.getItemContainer();
            itemContainer.pause();
            itemContainer.lnI.removeAllViews();
            this.lkt = null;
            m55689gE(true);
            this.ljV.bnN();
            EmojiCaptureReporter.m66031a(9, this.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lha.scene);
            AppMethodBeat.m2505o(2789);
            return true;
        }
    }

    public final void pause() {
        AppMethodBeat.m2504i(2790);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "pause");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null && videoPlayView.isPlaying()) {
            videoPlayView = this.lkw.getVideoPlayView();
            if (videoPlayView != null) {
                videoPlayView.pause();
            }
        }
        this.lkw.getItemContainer().pause();
        m55689gE(false);
        AppMethodBeat.m2505o(2790);
    }

    public final void resume() {
        AppMethodBeat.m2504i(2791);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "resume");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.start();
        }
        EditorItemContainer itemContainer = this.lkw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof C38926a) {
                ((C38926a) childAt).resume();
            }
        }
        m55689gE(true);
        AppMethodBeat.m2505o(2791);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(2792);
        C4990ab.m7416i("MicroMsg.EditorPresenter", "destroy");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.stop();
        }
        this.lkw.getItemContainer().pause();
        this.lkw.destroy();
        this.ext.release();
        this.lks.setCallback(null);
        C41949b c41949b = C41949b.ezV;
        C41949b.m74083b(this.ljQ.ezZ, this.lku);
        AppMethodBeat.m2505o(2792);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m55685d(C33995c c33995c) {
        AppMethodBeat.m2504i(2795);
        C5004al.m7441d(new C27799g(c33995c));
        AppMethodBeat.m2505o(2795);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m55679a(C33995c c33995c, String str, int i, boolean z) {
        AppMethodBeat.m2504i(2796);
        C31596c c31596c = new C31596c();
        c31596c.AVE = c33995c.lkw.getItemContainer().getTextItem();
        if (((TextEditorItemView) c31596c.AVE) == null) {
            EditorItemContainer itemContainer = c33995c.lkw.getItemContainer();
            TextEditorItemView textEditorItemView = new TextEditorItemView(itemContainer.getContext());
            itemContainer.lnI.addView(textEditorItemView, new LayoutParams(-1, -1));
            RectF validRect = itemContainer.getValidRect();
            Context context = itemContainer.getContext();
            C25052j.m39375o(context, "context");
            textEditorItemView.mo35774a(validRect, context.getResources().getDimension(C25738R.dimen.f9629f));
            EditorOutsideView editorOutsideView = itemContainer.lnJ;
            RectF validRect2 = itemContainer.getValidRect();
            Context context2 = itemContainer.getContext();
            C25052j.m39375o(context2, "context");
            float dimension = context2.getResources().getDimension(C25738R.dimen.f9629f);
            C25052j.m39376p(validRect2, "bounds");
            editorOutsideView.lkh.reset();
            editorOutsideView.lkh.addRoundRect(new RectF(validRect2.left, validRect2.top, validRect2.right, validRect2.bottom), dimension, dimension, Direction.CW);
            editorOutsideView.postInvalidate();
            c31596c.AVE = textEditorItemView;
            ((TextEditorItemView) c31596c.AVE).setOnClickListener(new C33999k(c33995c, c31596c));
        }
        ((TextEditorItemView) c31596c.AVE).mo35775a(str, i, z);
        c33995c.lkw.getItemContainer().setEditing((TextEditorItemView) c31596c.AVE);
        AppMethodBeat.m2505o(2796);
    }
}
