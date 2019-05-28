package com.tencent.mm.plugin.emojicapture.e;

import a.l;
import a.v;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorOutsideView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0017\u0018\u0000 G2\u00020\u0001:\u0001GB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J7\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020$\u0018\u00010*H\u0002J2\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\t02j\b\u0012\u0004\u0012\u00020\t`3H\u0002J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020\u0014H\u0016J\u0012\u00109\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010:\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020\u0014H\u0016J\u0006\u0010=\u001a\u00020$J\b\u0010>\u001a\u00020$H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020\u0014H\u0002J\"\u0010C\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0014H\u0016J\"\u0010F\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0014H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c implements com.tencent.mm.plugin.emojicapture.c.b.a {
    public static final a lkx = new a();
    private Context context;
    private final com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(this.context);
    private final String eyL;
    private final EmojiCaptureReporter lha;
    private boolean liA;
    private String ljP;
    private com.tencent.mm.plugin.emojicapture.model.a.a ljQ = new com.tencent.mm.plugin.emojicapture.model.a.a();
    private com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b ljV;
    private String lko;
    private boolean lkp;
    private boolean lkq;
    private boolean lkr;
    private final CgiEmojiTextSpamProxy lks = new CgiEmojiTextSpamProxy(this.ext);
    private com.tencent.mm.plugin.emojicapture.model.b.d lkt;
    private final e lku = new e(this);
    private final Runnable lkv = new c(this);
    private com.tencent.mm.plugin.emojicapture.c.b.b lkw;
    private int textColor;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ c lkA;
        final /* synthetic */ String lkC;

        f(c cVar, String str) {
            this.lkA = cVar;
            this.lkC = str;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2771);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i("MicroMsg.EditorPresenter", "voice text block ".concat(String.valueOf(booleanValue)));
            this.lkA.lkp = true;
            if (booleanValue) {
                t.makeText(this.lkA.context, R.string.bcv, 0).show();
            } else {
                this.lkA.ljP = this.lkC;
            }
            c.d(this.lkA);
            y yVar = y.AUy;
            AppMethodBeat.o(2771);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class d implements OnDismissListener {
        final /* synthetic */ c lkA;

        d(c cVar) {
            this.lkA = cVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(2768);
            c.k(this.lkA);
            AppMethodBeat.o(2768);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ c lkA;

        g(c cVar) {
            this.lkA = cVar;
        }

        public final void run() {
            AppMethodBeat.i(2772);
            if (this.lkA.lkp && this.lkA.lkq) {
                EmojiVideoPlayTextureView videoPlayView = this.lkA.lkw.getVideoPlayView();
                if (videoPlayView != null) {
                    EmojiVideoPlayTextureView.a(videoPlayView, this.lkA.liA);
                }
                this.lkA.lkw.bmA();
                this.lkA.ljV.bnO();
                c.a(this.lkA, this.lkA.ljP, this.lkA.textColor, true);
                this.lkA.lkq = false;
                this.lkA.lkp = false;
            }
            AppMethodBeat.o(2772);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
    public static final class e implements com.tencent.mm.emoji.d.a {
        final /* synthetic */ c lkA;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ boolean eyb;
            final /* synthetic */ String ezX;
            final /* synthetic */ e lkB;

            a(e eVar, boolean z, String str) {
                this.lkB = eVar;
                this.eyb = z;
                this.ezX = str;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(2769);
                al.af(this.lkB.lkA.lkv);
                this.lkB.lkA.ljV.bnP();
                if (this.eyb) {
                    this.lkB.lkA.ljV.k(true, this.ezX);
                } else {
                    t.makeText(this.lkB.lkA.context, R.string.b_8, 0).show();
                    this.lkB.lkA.resume();
                }
                y yVar = y.AUy;
                AppMethodBeat.o(2769);
                return yVar;
            }
        }

        e(c cVar) {
            this.lkA = cVar;
        }

        public final void a(long j, boolean z, String str) {
            AppMethodBeat.i(2770);
            com.tencent.mm.ab.b.a(new a(this, z, str));
            AppMethodBeat.o(2770);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ a.f.a.b exI;

        b(a.f.a.b bVar) {
            this.exI = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2766);
            final boolean booleanValue = ((Boolean) obj).booleanValue();
            al.d(new Runnable(this) {
                final /* synthetic */ b lky;

                public final void run() {
                    AppMethodBeat.i(2765);
                    a.f.a.b bVar = this.lky.exI;
                    if (bVar != null) {
                        bVar.am(Boolean.valueOf(booleanValue));
                        AppMethodBeat.o(2765);
                        return;
                    }
                    AppMethodBeat.o(2765);
                }
            });
            y yVar = y.AUy;
            AppMethodBeat.o(2766);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ c lkA;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$h$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ h lkD;

            AnonymousClass1(h hVar) {
                this.lkD = hVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(2773);
                ab.i("MicroMsg.EditorPresenter", "remove bg callback");
                this.lkD.lkA.lkq = true;
                c.d(this.lkD.lkA);
                y yVar = y.AUy;
                AppMethodBeat.o(2773);
                return yVar;
            }
        }

        h(c cVar) {
            this.lkA = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2774);
            EmojiVideoPlayTextureView videoPlayView = this.lkA.lkw.getVideoPlayView();
            if (videoPlayView != null) {
                videoPlayView.b(this.lkA.liA, (a.f.a.a) new AnonymousClass1(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2774);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ com.tencent.mm.plugin.emojicapture.model.a.a lkE;

        i(com.tencent.mm.plugin.emojicapture.model.a.a aVar) {
            this.lkE = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2775);
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(this.lkE.videoPath);
            if (WR != null) {
                EmojiCaptureReporter.up(34);
                EmojiCaptureReporter.dU(35, WR.eWK);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2775);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements OnClickListener {
        final /* synthetic */ c lkA;
        final /* synthetic */ a.f.b.u.c lkI;

        k(c cVar, a.f.b.u.c cVar2) {
            this.lkA = cVar;
            this.lkI = cVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(2777);
            this.lkA.lkw.a(true, ((TextEditorItemView) this.lkI.AVE).getText(), ((TextEditorItemView) this.lkI.AVE).getTextColor());
            EmojiCaptureReporter.a(13, this.lkA.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lkA.lha.scene);
            AppMethodBeat.o(2777);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ c lkA;

        c(c cVar) {
            this.lkA = cVar;
        }

        public final void run() {
            AppMethodBeat.i(2767);
            this.lkA.ljV.bnP();
            t.makeText(this.lkA.context, R.string.b_8, 0).show();
            this.lkA.resume();
            AppMethodBeat.o(2767);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    static final class j extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ p iyc;
        final /* synthetic */ c lkA;
        final /* synthetic */ String lkF;
        final /* synthetic */ int lkG;
        final /* synthetic */ boolean lkH;

        j(c cVar, p pVar, String str, int i, boolean z) {
            this.lkA = cVar;
            this.iyc = pVar;
            this.lkF = str;
            this.lkG = i;
            this.lkH = z;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2776);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.iyc.dismiss();
            if (booleanValue) {
                t.makeText(this.lkA.context, R.string.bcv, 0).show();
            } else {
                c.a(this.lkA, this.lkF, this.lkG, this.lkH);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2776);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(2794);
        AppMethodBeat.o(2794);
    }

    public c(Context context, com.tencent.mm.plugin.emojicapture.c.b.b bVar, com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b bVar2, String str, EmojiCaptureReporter emojiCaptureReporter) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(bVar, "view");
        a.f.b.j.p(bVar2, "uiNavigation");
        a.f.b.j.p(emojiCaptureReporter, "reporter");
        AppMethodBeat.i(2793);
        this.context = context;
        this.lkw = bVar;
        this.ljV = bVar2;
        this.eyL = str;
        this.lha = emojiCaptureReporter;
        AppMethodBeat.o(2793);
    }

    public static final /* synthetic */ void k(c cVar) {
        AppMethodBeat.i(2797);
        cVar.bnK();
        AppMethodBeat.o(2797);
    }

    public final void b(com.tencent.mm.plugin.emojicapture.model.a.a aVar) {
        AppMethodBeat.i(2778);
        a.f.b.j.p(aVar, "emojiCaptureInfo");
        ab.i("MicroMsg.EditorPresenter", "setup");
        this.ljQ = aVar;
        this.lko = aVar.videoPath;
        this.liA = aVar.lgS;
        this.textColor = aVar.lhJ;
        this.lkw.a(aVar, aVar.videoPath, aVar.lhK, this.liA, new h(this));
        com.tencent.mm.ab.b.a("EditorPresenter_setup", (a.f.a.a) new i(aVar));
        AppMethodBeat.o(2778);
    }

    public final void JZ(String str) {
        AppMethodBeat.i(2779);
        ab.i("MicroMsg.EditorPresenter", "voice text callback");
        b(str, (a.f.a.b) new f(this, str));
        AppMethodBeat.o(2779);
    }

    public final boolean bmx() {
        boolean z = true;
        AppMethodBeat.i(2780);
        ab.i("MicroMsg.EditorPresenter", "removeBg " + this.liA);
        if (this.ljQ.lhK) {
            EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
            if (videoPlayView == null || !videoPlayView.isPlaying()) {
                AppMethodBeat.o(2780);
                return false;
            }
            if (this.liA) {
                z = false;
            }
            this.liA = z;
            EmojiVideoPlayTextureView videoPlayView2 = this.lkw.getVideoPlayView();
            if (videoPlayView2 != null) {
                EmojiVideoPlayTextureView.a(videoPlayView2, this.liA);
            }
            boolean z2 = this.liA;
            AppMethodBeat.o(2780);
            return z2;
        }
        AppMethodBeat.o(2780);
        return false;
    }

    public final boolean bmy() {
        AppMethodBeat.i(2781);
        ab.i("MicroMsg.EditorPresenter", "speedUp " + this.lkr);
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView == null || videoPlayView.getPlayRate() != 1.0f) {
            EmojiVideoPlayTextureView videoPlayView2 = this.lkw.getVideoPlayView();
            if (videoPlayView2 != null) {
                videoPlayView2.setPlayRate(1.0f);
            }
            this.lkr = false;
            AppMethodBeat.o(2781);
            return false;
        }
        EmojiVideoPlayTextureView videoPlayView3 = this.lkw.getVideoPlayView();
        if (videoPlayView3 != null) {
            videoPlayView3.setPlayRate(2.0f);
        }
        this.lkr = true;
        AppMethodBeat.o(2781);
        return true;
    }

    public final void c(com.tencent.mm.api.k kVar) {
        AppMethodBeat.i(2782);
        a.f.b.j.p(kVar, "emojiInfo");
        if (kVar instanceof EmojiInfo) {
            if (this.lkw.getItemContainer().getAllEmojiMd5().size() >= 8) {
                t.makeText(this.context, R.string.b98, 0).show();
                AppMethodBeat.o(2782);
                return;
            }
            com.tencent.mm.plugin.emojicapture.ui.editor.a emojiEditorItemView = new EmojiEditorItemView(this.context);
            ((EmojiEditorItemView) emojiEditorItemView).setEmojiInfo((EmojiInfo) kVar);
            emojiEditorItemView.resume();
            EditorItemContainer itemContainer = this.lkw.getItemContainer();
            a.f.b.j.p(emojiEditorItemView, "itemView");
            itemContainer.lnI.addView((View) emojiEditorItemView, new LayoutParams(-1, -1));
            RectF validRect = itemContainer.getValidRect();
            Context context = itemContainer.getContext();
            a.f.b.j.o(context, "context");
            emojiEditorItemView.a(validRect, context.getResources().getDimension(R.dimen.f));
            itemContainer.setEditing(emojiEditorItemView);
            itemContainer.lnI.bringChildToFront(itemContainer.getTextItem());
        }
        AppMethodBeat.o(2782);
    }

    public final void n(String str, int i, boolean z) {
        AppMethodBeat.i(2783);
        ab.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(str)));
        b(str, (a.f.a.b) new j(this, p.b(this.context, this.context.getString(R.string.cn5), true, null), str, i, z));
        AppMethodBeat.o(2783);
    }

    public final void bmz() {
        AppMethodBeat.i(2784);
        if (!bo.isNullOrNil(this.eyL)) {
            com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class);
            a.f.b.j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            if (!((Boolean) ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().c(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                new com.tencent.mm.ui.widget.a.c.a(this.context).PZ(R.string.b5y).Qc(R.string.b5x).a((OnDismissListener) new d(this)).show();
                M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class);
                a.f.b.j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().d(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.o(2784);
                return;
            }
        }
        bnK();
        AppMethodBeat.o(2784);
    }

    private final void bnK() {
        String str;
        AppMethodBeat.i(2785);
        String str2 = "MicroMsg.EditorPresenter";
        StringBuilder stringBuilder = new StringBuilder("start mix ");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        ab.i(str2, stringBuilder.append(videoPlayView != null ? videoPlayView.getVideoPath() : null).toString());
        com.tencent.mm.plugin.emojicapture.model.b.a aVar = new com.tencent.mm.plugin.emojicapture.model.b.a(this.lkw.getItemContainer().getValidRect());
        List<com.tencent.mm.plugin.emojicapture.ui.editor.a> allItemViews = this.lkw.getItemContainer().getAllItemViews();
        ArrayList allEmojiMd5 = this.lkw.getItemContainer().getAllEmojiMd5();
        TextEditorItemView textItem = this.lkw.getItemContainer().getTextItem();
        int textColor = textItem != null ? textItem.getTextColor() : 0;
        String attachedText = this.lkw.getItemContainer().getAttachedText();
        for (com.tencent.mm.plugin.emojicapture.ui.editor.a UI : allItemViews) {
            aVar.a(UI.UI());
        }
        EmojiInfo a;
        com.tencent.mm.plugin.emojicapture.model.b.e eVar;
        long j;
        if (this.lkt == null) {
            this.lha.eyJ = this.lkw.getItemContainer().getAttachedText();
            this.lha.textColor = textColor;
            this.lha.lgS = this.liA;
            this.lha.lgT = this.lkr;
            this.lha.lgU = allEmojiMd5.size();
            this.lha.ckF = System.currentTimeMillis() - this.lha.ezZ;
            EmojiCaptureReporter emojiCaptureReporter = this.lha;
            com.tencent.mm.plugin.emojicapture.model.a.b bVar = this.ljQ.lhH;
            if (bVar != null) {
                str = bVar.lgY;
            } else {
                str = null;
            }
            emojiCaptureReporter.lgY = str;
            this.lha.bmv();
            a = a(attachedText, textColor, allEmojiMd5);
            eVar = com.tencent.mm.plugin.emojicapture.model.b.e.liH;
            textColor = this.ljQ.scene;
            j = a.field_captureEnterTime;
            attachedText = this.ljQ.videoPath;
            videoPlayView = this.lkw.getVideoPlayView();
            this.lkt = com.tencent.mm.plugin.emojicapture.model.b.e.a(textColor, j, attachedText, aVar, videoPlayView != null ? (int) videoPlayView.getPlayRate() : 1, this.liA, this.ljQ.lhH != null, a);
        } else {
            com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.lkM;
            EmojiCaptureProxy.lkL.deleteEmojiInfoByEnterTime(this.lha.ezZ);
            a = a(attachedText, textColor, allEmojiMd5);
            eVar = com.tencent.mm.plugin.emojicapture.model.b.e.liH;
            textColor = this.ljQ.scene;
            j = a.field_captureEnterTime;
            attachedText = this.ljQ.videoPath;
            videoPlayView = this.lkw.getVideoPlayView();
            this.lkt = com.tencent.mm.plugin.emojicapture.model.b.e.a(textColor, j, attachedText, aVar, videoPlayView != null ? (int) videoPlayView.getPlayRate() : 1, this.liA, this.ljQ.lhH != null, a);
        }
        pause();
        if (com.tencent.mm.plugin.emojicapture.ui.a.uC(this.ljQ.scene)) {
            al.af(this.lkv);
            al.n(this.lkv, 60000);
            com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b bVar2 = this.ljV;
            Context context = this.context;
            str = this.context.getString(R.string.b_9);
            a.f.b.j.o(str, "context.getString(R.string.emoji_generating)");
            com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a.a(bVar2, context, str);
            com.tencent.mm.emoji.d.b bVar3 = com.tencent.mm.emoji.d.b.ezV;
            com.tencent.mm.emoji.d.b.a(this.ljQ.ezZ, this.lku);
            AppMethodBeat.o(2785);
            return;
        }
        com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a.a(this.ljV, true);
        AppMethodBeat.o(2785);
    }

    private final EmojiInfo a(String str, int i, ArrayList<String> arrayList) {
        AppMethodBeat.i(2786);
        String str2 = this.ljQ.thumbPath;
        String atg = com.tencent.mm.vfs.e.atg(str2);
        EmojiInfo emojiInfo = new EmojiInfo();
        String str3 = EmojiInfo.dvg() + atg;
        if (!com.tencent.mm.a.e.ct(str3)) {
            com.tencent.mm.vfs.e.y(str2, str3);
        }
        ab.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + atg + " outputPath: " + str3);
        emojiInfo.vS(atg);
        emojiInfo.asX("capture");
        emojiInfo.Vp(EmojiInfo.yau);
        emojiInfo.field_attachedText = str;
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        emojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.c.lhv;
        aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        emojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.c.lhv;
        emojiInfo.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_MIXING);
        emojiInfo.al(arrayList);
        emojiInfo.field_imitateMd5 = this.eyL;
        emojiInfo.field_captureEnterTime = this.lha.ezZ;
        com.tencent.mm.plugin.emojicapture.model.a.b bVar = this.ljQ.lhH;
        if (bVar != null) {
            str2 = bVar.lgY;
        } else {
            str2 = null;
        }
        emojiInfo.field_lensId = str2;
        aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        emojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.c.a.ut(i);
        emojiInfo.field_captureScene = this.lha.scene;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.lkM;
        EmojiCaptureProxy.lkL.createEmojiInfo(emojiInfo);
        AppMethodBeat.o(2786);
        return emojiInfo;
    }

    private final void b(String str, a.f.a.b<? super Boolean, y> bVar) {
        AppMethodBeat.i(2787);
        if (bo.isNullOrNil(str)) {
            bVar.am(Boolean.FALSE);
            AppMethodBeat.o(2787);
            return;
        }
        this.lks.cgiEmojiTextSpam(str, new b(bVar));
        AppMethodBeat.o(2787);
    }

    private final void gE(boolean z) {
        AppMethodBeat.i(2788);
        ab.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(z)));
        if (this.context instanceof Activity) {
            Context context = this.context;
            if (context == null) {
                v vVar = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(2788);
                throw vVar;
            }
            Activity activity = (Activity) context;
            if (z) {
                activity.getWindow().clearFlags(16);
                AppMethodBeat.o(2788);
                return;
            }
            activity.getWindow().addFlags(16);
        }
        AppMethodBeat.o(2788);
    }

    public final boolean Ab() {
        AppMethodBeat.i(2789);
        ab.i("MicroMsg.EditorPresenter", "onBack: " + this.lkw.aFF() + ' ' + this.lkw.bmB() + ' ' + this.lkw.bmC());
        if (!this.lkw.aFF()) {
            AppMethodBeat.o(2789);
            return false;
        } else if (this.lkw.bmB()) {
            this.lkw.a(false, null, 0);
            AppMethodBeat.o(2789);
            return true;
        } else if (this.lkw.bmC()) {
            this.lkw.gC(false);
            AppMethodBeat.o(2789);
            return true;
        } else {
            this.liA = false;
            this.lkr = false;
            this.ljP = null;
            this.lkp = false;
            this.lkq = false;
            EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
            com.tencent.mm.vfs.e.deleteFile(videoPlayView != null ? videoPlayView.getVideoPath() : null);
            this.lkw.reset();
            EditorItemContainer itemContainer = this.lkw.getItemContainer();
            itemContainer.pause();
            itemContainer.lnI.removeAllViews();
            this.lkt = null;
            gE(true);
            this.ljV.bnN();
            EmojiCaptureReporter.a(9, this.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lha.scene);
            AppMethodBeat.o(2789);
            return true;
        }
    }

    public final void pause() {
        AppMethodBeat.i(2790);
        ab.i("MicroMsg.EditorPresenter", "pause");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null && videoPlayView.isPlaying()) {
            videoPlayView = this.lkw.getVideoPlayView();
            if (videoPlayView != null) {
                videoPlayView.pause();
            }
        }
        this.lkw.getItemContainer().pause();
        gE(false);
        AppMethodBeat.o(2790);
    }

    public final void resume() {
        AppMethodBeat.i(2791);
        ab.i("MicroMsg.EditorPresenter", "resume");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.start();
        }
        EditorItemContainer itemContainer = this.lkw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof com.tencent.mm.plugin.emojicapture.ui.editor.a) {
                ((com.tencent.mm.plugin.emojicapture.ui.editor.a) childAt).resume();
            }
        }
        gE(true);
        AppMethodBeat.o(2791);
    }

    public final void destroy() {
        AppMethodBeat.i(2792);
        ab.i("MicroMsg.EditorPresenter", "destroy");
        EmojiVideoPlayTextureView videoPlayView = this.lkw.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.stop();
        }
        this.lkw.getItemContainer().pause();
        this.lkw.destroy();
        this.ext.release();
        this.lks.setCallback(null);
        com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.ezV;
        com.tencent.mm.emoji.d.b.b(this.ljQ.ezZ, this.lku);
        AppMethodBeat.o(2792);
    }

    public static final /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(2795);
        al.d(new g(cVar));
        AppMethodBeat.o(2795);
    }

    public static final /* synthetic */ void a(c cVar, String str, int i, boolean z) {
        AppMethodBeat.i(2796);
        a.f.b.u.c cVar2 = new a.f.b.u.c();
        cVar2.AVE = cVar.lkw.getItemContainer().getTextItem();
        if (((TextEditorItemView) cVar2.AVE) == null) {
            EditorItemContainer itemContainer = cVar.lkw.getItemContainer();
            TextEditorItemView textEditorItemView = new TextEditorItemView(itemContainer.getContext());
            itemContainer.lnI.addView(textEditorItemView, new LayoutParams(-1, -1));
            RectF validRect = itemContainer.getValidRect();
            Context context = itemContainer.getContext();
            a.f.b.j.o(context, "context");
            textEditorItemView.a(validRect, context.getResources().getDimension(R.dimen.f));
            EditorOutsideView editorOutsideView = itemContainer.lnJ;
            RectF validRect2 = itemContainer.getValidRect();
            Context context2 = itemContainer.getContext();
            a.f.b.j.o(context2, "context");
            float dimension = context2.getResources().getDimension(R.dimen.f);
            a.f.b.j.p(validRect2, "bounds");
            editorOutsideView.lkh.reset();
            editorOutsideView.lkh.addRoundRect(new RectF(validRect2.left, validRect2.top, validRect2.right, validRect2.bottom), dimension, dimension, Direction.CW);
            editorOutsideView.postInvalidate();
            cVar2.AVE = textEditorItemView;
            ((TextEditorItemView) cVar2.AVE).setOnClickListener(new k(cVar, cVar2));
        }
        ((TextEditorItemView) cVar2.AVE).a(str, i, z);
        cVar.lkw.getItemContainer().setEditing((TextEditorItemView) cVar2.AVE);
        AppMethodBeat.o(2796);
    }
}
