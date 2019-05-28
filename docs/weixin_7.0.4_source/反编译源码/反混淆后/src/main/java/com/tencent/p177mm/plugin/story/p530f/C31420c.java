package com.tencent.p177mm.plugin.story.p530f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.C0884v;
import com.google.android.exoplayer2.C45036g;
import com.google.android.exoplayer2.p109g.C32051a.C25537a;
import com.google.android.exoplayer2.p109g.C45034c;
import com.google.android.exoplayer2.p110h.C37261k;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.source.C45052i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.media.editor.p252a.C45428h;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.p867i.C42174a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p232b.p233a.C1584ak;
import com.tencent.p177mm.p230g.p232b.p233a.C1585al;
import com.tencent.p177mm.p230g.p232b.p233a.C26274at;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.model.C13774d;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43641i;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.model.audio.C22219b;
import com.tencent.p177mm.plugin.story.model.audio.C22219b.C13771a;
import com.tencent.p177mm.plugin.story.model.audio.C29301c;
import com.tencent.p177mm.plugin.story.model.audio.C46277g;
import com.tencent.p177mm.plugin.story.model.audio.C46277g.C4125a;
import com.tencent.p177mm.plugin.story.model.p1036e.C13775a;
import com.tencent.p177mm.plugin.story.model.p1036e.C46282b;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c.C29276a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39869f.C29278a;
import com.tencent.p177mm.plugin.story.p1034d.C43629b.C13742b;
import com.tencent.p177mm.plugin.story.p1034d.C43629b.C29280a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a.C29281a;
import com.tencent.p177mm.plugin.story.p1303e.C39872a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C29292g;
import com.tencent.p177mm.plugin.story.p531g.C39877f;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.plugin.story.p536ui.StoryCaptureUI.C4149b;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C39930f;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C46289e;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C46925b;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer;
import com.tencent.p177mm.plugin.story.proxy.C39913d;
import com.tencent.p177mm.plugin.story.proxy.C39913d.C22249a;
import com.tencent.p177mm.plugin.story.proxy.C4140c;
import com.tencent.p177mm.plugin.story.proxy.C4140c.C4141a;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy.C22248a;
import com.tencent.p177mm.protocal.protobuf.bqk;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u001a\u0018\u00002\u00020\u0001:\u0001NB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%H\u0002JC\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020#0-H\u0002JW\u0010&\u001a\u00020#2\u0006\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\b\b\u0002\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020#0-H\u0002J\b\u00105\u001a\u00020#H\u0016J\u0018\u00106\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9H\u0002J \u0010:\u001a\u00020;2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9H\u0002J\b\u0010=\u001a\u00020#H\u0016J\u0010\u0010\u0018\u001a\u00020#2\u0006\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0012H\u0016J\b\u0010B\u001a\u00020\u0012H\u0016J\b\u0010C\u001a\u00020#H\u0016J\b\u0010D\u001a\u00020#H\u0016J\b\u0010E\u001a\u00020#H\u0016J\u0012\u0010F\u001a\u00020#2\b\u0010G\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020#H\u0016J\b\u0010K\u001a\u00020#H\u0002J\b\u0010L\u001a\u00020#H\u0002J\u0010\u0010M\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;)V", "TAG", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getContext", "()Landroid/content/Context;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isFavorite", "", "isNotifyMoment", "loading", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "mixAudio", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "muteOrigin", "showLoading", "com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1;", "startPerformance", "", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getView", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "checkAudioCache", "", "callback", "Lkotlin/Function0;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "mediaDes", "needExport", "resId", "destroy", "getEditorItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "getMixer", "Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "editorItems", "mix", "mute", "notifyFavorite", "notifyMoment", "isNotify", "onBack", "onPlayerRepeat", "pause", "pauseAudio", "playAudio", "info", "prepareReport", "reset", "resume", "runMix", "runMixInBackground", "setup", "StoryProgressDialog", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.c */
public final class C31420c implements C29280a {
    final String TAG = "MicroMsg.Story.EditorPresenter";
    final Context context;
    int ehv;
    C39872a rWx = new C39872a();
    private C0884v rYo;
    boolean rYp;
    boolean rYq = true;
    boolean rYr;
    AudioCacheInfo rYs;
    C13747a rYt;
    C22186j rYu = new C22186j(this);
    final C4149b rYv;
    public final C13742b rYw;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "cancel", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$a */
    public static final class C13747a {
        C44275p llm;
        C31214a<C37091y> rYx = C13748a.rYy;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$a$a */
        static final class C13748a extends C25053k implements C31214a<C37091y> {
            public static final C13748a rYy = new C13748a();

            static {
                AppMethodBeat.m2504i(109518);
                AppMethodBeat.m2505o(109518);
            }

            C13748a() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return C37091y.AUy;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$a$b */
        static final class C13749b extends C25053k implements C31214a<C37091y> {
            public static final C13749b rYz = new C13749b();

            static {
                AppMethodBeat.m2504i(109519);
                AppMethodBeat.m2505o(109519);
            }

            C13749b() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return C37091y.AUy;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$a$c */
        static final class C13750c implements OnCancelListener {
            final /* synthetic */ C13747a rYA;

            C13750c(C13747a c13747a) {
                this.rYA = c13747a;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(109520);
                this.rYA.rYx.invoke();
                AppMethodBeat.m2505o(109520);
            }
        }

        public C13747a() {
            AppMethodBeat.m2504i(109523);
            AppMethodBeat.m2505o(109523);
        }

        /* renamed from: a */
        public final void mo25965a(Context context, boolean z, C31214a<C37091y> c31214a) {
            AppMethodBeat.m2504i(109521);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(c31214a, "cancel");
            this.rYx = c31214a;
            if (this.llm == null) {
                this.llm = C44275p.m79966b(context, context.getString(C25738R.string.cn5), z, new C13750c(this));
            }
            AppMethodBeat.m2505o(109521);
        }

        public final void dismiss() {
            AppMethodBeat.m2504i(109522);
            C44275p c44275p = this.llm;
            if (c44275p != null) {
                c44275p.dismiss();
            }
            this.llm = null;
            AppMethodBeat.m2505o(109522);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$c */
    static final class C13752c extends C25053k implements C31591m<Boolean, String, C37091y> {
        final /* synthetic */ C31214a lix;
        final /* synthetic */ C31420c rYB;
        final /* synthetic */ AudioCacheInfo rYD;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$c$1 */
        static final class C137511 extends C25053k implements C31214a<C37091y> {
            public static final C137511 rYE = new C137511();

            static {
                AppMethodBeat.m2504i(109525);
                AppMethodBeat.m2505o(109525);
            }

            C137511() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return C37091y.AUy;
            }
        }

        C13752c(C31420c c31420c, AudioCacheInfo audioCacheInfo, C31214a c31214a) {
            this.rYB = c31420c;
            this.rYD = audioCacheInfo;
            this.lix = c31214a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(109526);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i(this.rYB.TAG, "cacheAudio callback success ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                this.rYD.aIM = true;
                this.lix.invoke();
                C13747a c13747a = this.rYB.rYt;
                if (c13747a != null) {
                    C31214a c31214a = C137511.rYE;
                    C25052j.m39376p(c31214a, "onCancel");
                    c13747a.rYx = c31214a;
                }
            } else {
                C23639t.makeText(this.rYB.context, C25738R.string.etd, 0).show();
                C13747a c13747a2 = this.rYB.rYt;
                if (c13747a2 != null) {
                    c13747a2.dismiss();
                }
                this.rYB.rYt = null;
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109526);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Ljava/lang/Runnable;", "run", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$j */
    public static final class C22186j implements Runnable {
        final /* synthetic */ C31420c rYB;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$j$a */
        static final class C4111a extends C25053k implements C31214a<C37091y> {
            public static final C4111a rYV = new C4111a();

            static {
                AppMethodBeat.m2504i(109538);
                AppMethodBeat.m2505o(109538);
            }

            C4111a() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return C37091y.AUy;
            }
        }

        C22186j(C31420c c31420c) {
            this.rYB = c31420c;
        }

        public final void run() {
            AppMethodBeat.m2504i(109539);
            C31420c c31420c = this.rYB;
            C13747a c13747a = new C13747a();
            c13747a.mo25965a(this.rYB.context, false, C4111a.rYV);
            c31420c.rYt = c13747a;
            AppMethodBeat.m2505o(109539);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$h */
    static final class C29287h implements Runnable {
        final /* synthetic */ C31420c rYB;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$h$1 */
        static final class C137531 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C29287h rYR;

            C137531(C29287h c29287h) {
                this.rYR = c29287h;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109535);
                C5004al.m7439af(this.rYR.rYB.rYu);
                C13747a c13747a = this.rYR.rYB.rYt;
                if (c13747a != null) {
                    c13747a.dismiss();
                }
                this.rYR.rYB.rYt = null;
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109535);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$runMixInBackground$1$1$2"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$h$b */
        static final class C22185b extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C29287h rYR;
            final /* synthetic */ cej rYS;
            final /* synthetic */ C39878d rYT;
            final /* synthetic */ C42174a rYU;

            C22185b(C29287h c29287h, cej cej, C39878d c39878d, C42174a c42174a) {
                this.rYR = c29287h;
                this.rYS = cej;
                this.rYT = c39878d;
                this.rYU = c42174a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109534);
                C5004al.m7439af(this.rYR.rYB.rYu);
                C13747a c13747a = this.rYR.rYB.rYt;
                if (c13747a != null) {
                    c13747a.dismiss();
                }
                this.rYR.rYB.rYt = null;
                this.rYR.rYB.rYv.exit();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109534);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "", "storyLocalId", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$runMixInBackground$1$1$1"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$h$a */
        static final class C29288a extends C25053k implements C17126b<Integer, C37091y> {
            final /* synthetic */ C29287h rYR;
            final /* synthetic */ cej rYS;
            final /* synthetic */ C39878d rYT;
            final /* synthetic */ C42174a rYU;

            C29288a(C29287h c29287h, cej cej, C39878d c39878d, C42174a c42174a) {
                this.rYR = c29287h;
                this.rYS = cej;
                this.rYT = c39878d;
                this.rYU = c42174a;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(109533);
                this.rYT.field_storyLocalId = ((Number) obj).intValue();
                C22210l c22210l = C22210l.sac;
                C22210l.m33872a(this.rYT.xDa, this.rYT);
                C4133a c4133a = C43644j.rST;
                C4133a.cya().czx();
                C4141a c4141a = C4140c.saU;
                C4141a.czN().czM();
                C4990ab.m7416i(this.rYR.rYB.TAG, "man reStartMixend " + this.rYU);
                C22212h c22212h = C22212h.scu;
                C22212h.m33887EU(13);
                c22212h = C22212h.scu;
                C22212h.cAm().mo4999bb(System.currentTimeMillis());
                c22212h = C22212h.scu;
                C22212h.cAn();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109533);
                return c37091y;
            }
        }

        C29287h(C31420c c31420c) {
            this.rYB = c31420c;
        }

        public final void run() {
            AppMethodBeat.m2504i(109536);
            C42174a c42174a = new C42174a("runMixInBackground");
            this.rYB.pause();
            C4990ab.m7416i(this.rYB.TAG, "man pause ".concat(String.valueOf(c42174a)));
            long aaE = C1839cb.aaE();
            C46282b U = this.rYB.mo51363U(this.rYB.czz());
            C39872a c39872a = this.rYB.rWx;
            C25052j.m39376p(c39872a, "captureInfo");
            C29292g c29292g;
            try {
                Bitmap ag;
                Bitmap bitmap;
                String str;
                String str2 = c39872a.fbU;
                int i = U.eXL;
                if (TextUtils.isEmpty(str2)) {
                    long j;
                    if (c39872a.rRG > 0) {
                        j = c39872a.rRG;
                    } else {
                        j = 0;
                    }
                    C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "create thumb bitmap : ".concat(String.valueOf(j)));
                    if (c39872a.fbV) {
                        ag = C3475d.m5772ag(c39872a.fbT, j);
                    } else {
                        Object obj;
                        int i2;
                        int i3;
                        C29276a c29276a = (C29276a) C29275c.rRk.mo53288Uw();
                        c29276a.aaa(c39872a.fbT);
                        Bitmap ag2 = C3475d.m5772ag(c39872a.fbT, j);
                        if (c29276a.eXL == 270 || c29276a.eXL == 90) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i2 = c29276a.eTj;
                        } else {
                            i2 = c29276a.eTi;
                        }
                        if (obj != null) {
                            i3 = c29276a.eTi;
                        } else {
                            i3 = c29276a.eTj;
                        }
                        ag = Bitmap.createScaledBitmap(ag2, i2, i3, true);
                        StringBuilder stringBuilder = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
                        C25052j.m39375o(ag, "thumb");
                        C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", stringBuilder.append(ag.getWidth()).append(", ").append(ag.getHeight()).append("], thumbRotate:").append(i).append(", drawingRect:").append(Arrays.toString(U.rWy)).toString());
                    }
                    C43642a c43642a = C43641i.rSv;
                    c39872a.aae(C43642a.m78108kY(C1839cb.aaE()));
                    bitmap = ag;
                    str = c39872a.fbU;
                } else {
                    Options options = new Options();
                    C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "exist thumb bitmap ");
                    options.inMutable = true;
                    bitmap = C5056d.decodeFile(str2, options);
                    str = str2;
                }
                if (bitmap == null) {
                    C4990ab.m7412e("MicroMsg.Media.StoryVideoMixer", "createGraffitiThumb thumb is null");
                    c29292g = C29292g.sbU;
                    C29292g.cAj();
                } else {
                    Point fL = C46282b.m86779fL(bitmap.getWidth(), bitmap.getHeight());
                    C29283a c29283a = C29282c.rRS;
                    C29281a aaj = C29283a.aaj(c39872a.fbT);
                    if (c39872a.fbV || aaj == null || aaj.rRT) {
                        U.rWw = new C13775a(U.rWy, U.eWG, fL.x, fL.y, 0, 0, i);
                    } else {
                        U.rWw = new C13775a(U.rWy, U.eWG, fL.x, fL.y, aaj.width, aaj.height, i);
                    }
                    C13775a c13775a = U.rWw;
                    if (c13775a == null) {
                        C25052j.avw("frameRetriever");
                    }
                    c13775a.start();
                    ag = (Bitmap) U.eXh.mo50am(Long.valueOf(1));
                    C13775a c13775a2 = U.rWw;
                    if (c13775a2 == null) {
                        C25052j.avw("frameRetriever");
                    }
                    c13775a2.destroy();
                    if (ag != null) {
                        new Canvas(bitmap).drawBitmap(ag, 0.0f, 0.0f, null);
                    }
                    C5056d.m7625a(bitmap, 70, CompressFormat.JPEG, str, true);
                    C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "createGraffitiThumb : " + str + "   graffiti : " + (ag == null));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", e, "createGraffitiThumb error", new Object[0]);
                c29292g = C29292g.sbU;
                C29292g.cAj();
            }
            C4990ab.m7416i(this.rYB.TAG, "man createGraffitiThumb ".concat(String.valueOf(c42174a)));
            C22210l c22210l = C22210l.sac;
            cej a = C22210l.m33870a(this.rYB.rYw, this.rYB.rYs);
            c22210l = C22210l.sac;
            C39878d a2 = C22210l.m33869a(this.rYB.rYw, this.rYB.rYp, this.rYB.rYs, this.rYB.rWx, aaE, this.rYB.rYw.getLocation());
            C4990ab.m7416i(this.rYB.TAG, "man insertdone ".concat(String.valueOf(c42174a)));
            if (a2 != null) {
                C8902b.m16044a("StoryCapture_commit", (C31214a) new C31423e(this.rYB, a2, this.rYB.rWx.fbU, a, new C29288a(this, a, a2, c42174a)));
                C8902b.m16042a(new C22185b(this, a, a2, c42174a));
                AppMethodBeat.m2505o(109536);
                return;
            }
            C8902b.m16042a(new C137531(this));
            C4990ab.m7416i(this.rYB.TAG, "error when runMixInBackground");
            AppMethodBeat.m2505o(109536);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$checkAudioCache$1$1"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$b */
    static final class C31421b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31420c rYB;
        final /* synthetic */ AudioCacheInfo rYC;

        C31421b(C31420c c31420c, AudioCacheInfo audioCacheInfo) {
            this.rYB = c31420c;
            this.rYC = audioCacheInfo;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109524);
            C4990ab.m7416i(this.rYB.TAG, "checkAudioCache canceled");
            C4125a c4125a = C46277g.rUG;
            C46277g.rUF.cancelCache(this.rYC);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109524);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$i */
    static final class C31422i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31420c rYB;

        C31422i(C31420c c31420c) {
            this.rYB = c31420c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109537);
            this.rYB.rYv.bnO();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109537);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$e */
    static final class C31423e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31420c rYB;
        final /* synthetic */ String rYH;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ C17126b rYK;
        final /* synthetic */ C39878d rYL;

        C31423e(C31420c c31420c, C39878d c39878d, String str, cej cej, C17126b c17126b) {
            this.rYB = c31420c;
            this.rYL = c39878d;
            this.rYH = str;
            this.rYJ = cej;
            this.rYK = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            AppMethodBeat.m2504i(109528);
            if (this.rYB.rYq) {
                i = 0;
            } else {
                i = 1;
            }
            if (this.rYB.rYr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            C22249a c22249a = C39913d.sbf;
            int commitStory = C39913d.sbe.commitStory(this.rYL, this.rYH, this.rYB.rYw.getLocation(), this.rYB.rWx.fbV, this.rYJ, i, i2);
            C13774d c13774d = C13774d.rSg;
            C13774d.cxA();
            this.rYK.mo50am(Integer.valueOf(commitStory));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109528);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$g */
    static final class C31424g extends C25053k implements C36933q<String, String, Boolean, C37091y> {
        final /* synthetic */ C42174a fbQ;
        final /* synthetic */ C31420c rYB;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ ArrayList rYM;

        C31424g(C31420c c31420c, C42174a c42174a, ArrayList arrayList, cej cej) {
            this.rYB = c31420c;
            this.fbQ = c42174a;
            this.rYM = arrayList;
            this.rYJ = cej;
            super(3);
        }

        /* JADX WARNING: Missing block: B:16:0x00b7, code skipped:
            if (r6 < ((long) r0)) goto L_0x00b9;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            C37091y c37091y;
            boolean z = false;
            AppMethodBeat.m2504i(109532);
            final String str = (String) obj;
            String str2 = (String) obj2;
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            C25052j.m39376p(str, "mixVideoPath");
            C25052j.m39376p(str2, "mixThumbPath");
            if (this.rYB.ehv != 0) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, this.rYB.ehv);
                C4990ab.m7417i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(this.rYB.ehv));
                this.rYB.ehv = 0;
            }
            C22212h c22212h = C22212h.scu;
            C1584ak cAC = C22212h.cAC();
            long currentTimeMillis = System.currentTimeMillis();
            C22212h c22212h2 = C22212h.scu;
            cAC.mo4989aT(currentTimeMillis - C22212h.cAC().mo4987Ft());
            c22212h = C22212h.scu;
            C22212h.cAC().mo4990aU(booleanValue ? 0 : -1);
            C22212h c22212h3 = C22212h.scu;
            C22212h.cAC().mo4991aV(System.currentTimeMillis());
            this.fbQ.mo67718SW();
            C29283a c29283a = C29282c.rRS;
            C29281a aaj = C29283a.aaj(this.rYB.rWx.fbT);
            if (!this.rYB.rWx.fbV) {
                if (!this.rYB.rWx.fbV) {
                    if (this.rYM.size() <= 0) {
                        currentTimeMillis = this.rYB.rWx.rRH - this.rYB.rWx.rRG;
                        int i;
                        if (aaj != null) {
                            i = aaj.duration;
                        } else {
                            i = 0;
                        }
                    }
                }
                C8902b.m16044a("StoryCapture_commit", (C31214a) new C31425d(this.rYB, z, str, str2, "", this.rYJ, new C17126b<Integer, C37091y>(this) {
                    final /* synthetic */ C31424g rYN;

                    /* renamed from: am */
                    public final /* synthetic */ Object mo50am(Object obj) {
                        AppMethodBeat.m2504i(109531);
                        final int intValue = ((Number) obj).intValue();
                        C5004al.m7441d(new Runnable(this) {
                            final /* synthetic */ C314191 rYP;

                            public final void run() {
                                AppMethodBeat.m2504i(109530);
                                C13747a c13747a = this.rYP.rYN.rYB.rYt;
                                if (c13747a != null) {
                                    c13747a.dismiss();
                                }
                                this.rYP.rYN.rYB.rYt = null;
                                C22212h c22212h = C22212h.scu;
                                C22212h.m33895g(intValue, this.rYP.rYN.rYB.rWx.fbT, this.rYP.rYN.rYB.rWx.fbV);
                                c22212h = C22212h.scu;
                                C22212h.m33894bl(intValue, str);
                                C30379h.m48462bN(this.rYP.rYN.rYB.context, this.rYP.rYN.rYB.context.getString(C25738R.string.f9223ti));
                                this.rYP.rYN.rYB.rYv.exit();
                                AppMethodBeat.m2505o(109530);
                            }
                        });
                        C22212h c22212h = C22212h.scu;
                        C22212h.m33887EU(13);
                        c22212h = C22212h.scu;
                        C22212h.cAm().mo4999bb(System.currentTimeMillis());
                        c22212h = C22212h.scu;
                        C22212h.cAn();
                        C37091y c37091y = C37091y.AUy;
                        AppMethodBeat.m2505o(109531);
                        return c37091y;
                    }
                }));
                c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109532);
                return c37091y;
            }
            z = true;
            C8902b.m16044a("StoryCapture_commit", (C31214a) new C31425d(this.rYB, z, str, str2, "", this.rYJ, /* anonymous class already generated */));
            c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109532);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$d */
    static final class C31425d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31420c rYB;
        final /* synthetic */ boolean rYF;
        final /* synthetic */ String rYG;
        final /* synthetic */ String rYH;
        final /* synthetic */ String rYI;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ C17126b rYK;

        C31425d(C31420c c31420c, boolean z, String str, String str2, String str3, cej cej, C17126b c17126b) {
            this.rYB = c31420c;
            this.rYF = z;
            this.rYG = str;
            this.rYH = str2;
            this.rYI = str3;
            this.rYJ = cej;
            this.rYK = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            AppMethodBeat.m2504i(109527);
            if (this.rYF) {
                C29283a c29283a = C29282c.rRS;
                C29283a.aai(this.rYG);
            }
            if (this.rYB.rYq) {
                i = 0;
            } else {
                i = 1;
            }
            if (this.rYB.rYr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            C22249a c22249a = C39913d.sbf;
            int commitStory = C39913d.sbe.commitStory(this.rYG, this.rYH, this.rYI, this.rYB.rYw.getLocation(), this.rYB.rWx.fbV, this.rYJ, i, i2);
            C13774d c13774d = C13774d.rSg;
            C13774d.cxA();
            this.rYK.mo50am(Integer.valueOf(commitStory));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109527);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.c$f */
    static final class C31426f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31420c rYB;

        C31426f(C31420c c31420c) {
            this.rYB = c31420c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109529);
            C31420c c31420c = this.rYB;
            if (c31420c.rYt == null) {
                C5004al.m7442n(c31420c.rYu, 500);
            } else {
                C13747a c13747a = c31420c.rYt;
                if (c13747a != null) {
                    C44275p c44275p = c13747a.llm;
                    if (c44275p != null) {
                        c44275p.setCancelable(false);
                    }
                }
            }
            C39877f c39877f = C39877f.sbT;
            C39877f.m68290lF(c31420c.rWx.fbV);
            C7305d.xDG.execute(new C29287h(c31420c));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109529);
            return c37091y;
        }
    }

    public C31420c(Context context, C4149b c4149b, C13742b c13742b) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c4149b, "uiNavigation");
        C25052j.m39376p(c13742b, "view");
        AppMethodBeat.m2504i(109553);
        this.context = context;
        this.rYv = c4149b;
        this.rYw = c13742b;
        AppMethodBeat.m2505o(109553);
    }

    /* renamed from: a */
    public final void mo51364a(C39872a c39872a) {
        AppMethodBeat.m2504i(109540);
        C25052j.m39376p(c39872a, "captureInfo");
        this.rWx = c39872a;
        C13771a c13771a = C22219b.rUx;
        C22219b.rUt = new C22219b();
        this.rYw.mo25946a(c39872a.fbT, c39872a.rRG, c39872a.rRH, new C31422i(this));
        AppMethodBeat.m2505o(109540);
    }

    public final void pause() {
        AppMethodBeat.m2504i(109541);
        C4990ab.m7409c(this.TAG, "pause", new Object[0]);
        EditorItemContainer itemContainer = this.rYw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof C46925b) {
                ((C46925b) childAt).pause();
            }
        }
        this.rYw.getVideoPlayView().pause();
        C0884v c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.mo2618aE(false);
            AppMethodBeat.m2505o(109541);
            return;
        }
        AppMethodBeat.m2505o(109541);
    }

    public final void resume() {
        AppMethodBeat.m2504i(109542);
        C4990ab.m7409c(this.TAG, "resume", new Object[0]);
        EditorItemContainer itemContainer = this.rYw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof C46925b) {
                ((C46925b) childAt).resume();
            }
        }
        this.rYw.getVideoPlayView().start();
        C0884v c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.mo2618aE(true);
            AppMethodBeat.m2505o(109542);
            return;
        }
        AppMethodBeat.m2505o(109542);
    }

    /* renamed from: lt */
    public final void mo47478lt(boolean z) {
        AppMethodBeat.m2504i(109543);
        this.rYp = z;
        this.rYw.getVideoPlayView().setMute(this.rYp);
        AppMethodBeat.m2505o(109543);
    }

    /* renamed from: a */
    public final void mo47475a(AudioCacheInfo audioCacheInfo) {
        String str = null;
        AppMethodBeat.m2504i(109544);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("play audio ").append(audioCacheInfo != null ? Integer.valueOf(audioCacheInfo.rTW) : null).append(' ');
        if (audioCacheInfo != null) {
            str = audioCacheInfo.musicUrl;
        }
        C4990ab.m7416i(str2, append.append(str).toString());
        C22212h c22212h = C22212h.scu;
        C22212h.cAm().mo5010fn("");
        c22212h = C22212h.scu;
        C22212h.cAm().mo5004bg(0);
        c22212h = C22212h.scu;
        C22212h.cAm().mo5005bh(0);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43964cb(0);
        pauseAudio();
        this.rYs = audioCacheInfo;
        if (audioCacheInfo != null) {
            long j;
            c22212h = C22212h.scu;
            C22212h.cAm().mo5010fn(String.valueOf(audioCacheInfo.rTW));
            c22212h = C22212h.scu;
            C1585al cAm = C22212h.cAm();
            int i = audioCacheInfo.cvd;
            C4123a c4123a = AudioCacheInfo.rUj;
            if (i == AudioCacheInfo.rUi) {
                j = 0;
            } else {
                j = (long) (audioCacheInfo.position + 1);
            }
            cAm.mo5004bg(j);
            c22212h = C22212h.scu;
            C22212h.cAm().mo5005bh(audioCacheInfo.rUb);
            c22212h = C22212h.scu;
            C22212h.cAq().mo43964cb(1);
            C13771a c13771a = C22219b.rUx;
            C22219b cyS = C22219b.rUt;
            if (cyS != null) {
                int i2 = audioCacheInfo.rTW;
                int i3 = audioCacheInfo.type;
                cyS.rUp = i2;
                cyS.rUq = System.currentTimeMillis();
                cyS.rUr = true;
                cyS.cHY = false;
                cyS.cvd = i3;
            }
            C45034c c45034c = new C45034c(new C25537a(new C37261k()));
            str = C17675v.m27573i(this.context, this.context.getString(C25738R.string.f9176ru));
            this.rYo = C45036g.m82561a(this.context, c45034c);
            C4125a c4125a = C46277g.rUG;
            C25052j.m39375o(str, "userAgent");
            C45052i a = C4125a.m6450a(audioCacheInfo, str);
            C0884v c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.mo2618aE(true);
            }
            c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.mo2616a(a);
            }
            C0884v c0884v2 = this.rYo;
            if (c0884v2 != null) {
                c0884v2.setRepeatMode(2);
            }
            if (this.rYo != null) {
                C13742b c13742b = this.rYw;
                c0884v = this.rYo;
                if (c0884v == null) {
                    C25052j.dWJ();
                }
                c13742b.setMusicPlayer(c0884v);
            }
        }
        AppMethodBeat.m2505o(109544);
    }

    public final void pauseAudio() {
        AppMethodBeat.m2504i(109545);
        C0884v c0884v = this.rYo;
        if (c0884v == null || c0884v.mo2626pO() != 4) {
            C13771a c13771a = C22219b.rUx;
            C22219b cyS = C22219b.rUt;
            if (cyS != null) {
                cyS.cyQ();
            }
            c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.stop();
            }
            c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.release();
            }
            this.rYo = null;
            this.rYs = null;
        }
        AppMethodBeat.m2505o(109545);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cxp() {
        int i;
        C22212h c22212h;
        long j;
        C26274at cAq;
        long j2 = 1;
        AppMethodBeat.m2504i(109546);
        int i2 = 0;
        int i3 = 0;
        for (C45428h c45428h : this.rYw.getItemContainer().getAllItemViews()) {
            if (c45428h instanceof C46925b) {
                i3++;
            }
            if (c45428h instanceof C39930f) {
                i = i2 + 1;
            } else {
                i = i2;
            }
            if (c45428h instanceof C46289e) {
                C22212h c22212h2 = C22212h.scu;
                C22212h.cAm().mo5011fo(((C46289e) c45428h).getReportPositionString().toString());
                c22212h2 = C22212h.scu;
                C22212h.cAm().mo5012fp(String.valueOf(((C46289e) c45428h).getLatitude()));
                c22212h2 = C22212h.scu;
                C22212h.cAm().mo5013fq(String.valueOf(((C46289e) c45428h).getLongitude()));
                c22212h = C22212h.scu;
                C22212h.cAq().mo43956FX();
            }
            i2 = i;
        }
        c22212h = C22212h.scu;
        C22212h.cAm().mo5002be((long) i3);
        c22212h = C22212h.scu;
        C22212h.cAm().mo5003bf((long) i2);
        c22212h = C22212h.scu;
        C22212h.cAm().mo5008bk(this.rYq ? 1 : 0);
        c22212h = C22212h.scu;
        C1585al cAm = C22212h.cAm();
        AudioCacheInfo audioCacheInfo = this.rYs;
        if (audioCacheInfo != null) {
            i = audioCacheInfo.cvd;
            C4123a c4123a = AudioCacheInfo.rUj;
            if (i == AudioCacheInfo.rUi) {
                j = 1;
                cAm.mo5007bj(j);
                c22212h = C22212h.scu;
                cAq = C22212h.cAq();
                if (!this.rYq) {
                    j2 = 0;
                }
                cAq.mo43966cd(j2);
                c22212h = C22212h.scu;
                C22212h.cAq().mo43962bZ((long) i3);
                c22212h = C22212h.scu;
                C22212h.cAq().mo43963ca((long) i2);
                AppMethodBeat.m2505o(109546);
            }
        }
        j = 0;
        cAm.mo5007bj(j);
        c22212h = C22212h.scu;
        cAq = C22212h.cAq();
        if (this.rYq) {
        }
        cAq.mo43966cd(j2);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43962bZ((long) i3);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43963ca((long) i2);
        AppMethodBeat.m2505o(109546);
    }

    private final void czy() {
        int i;
        AppMethodBeat.m2504i(109547);
        C42174a c42174a = new C42174a("runMix");
        pause();
        C13747a c13747a = new C13747a();
        Context context = this.context;
        C25052j.m39376p(context, "context");
        c13747a.mo25965a(context, true, C13749b.rYz);
        this.rYt = c13747a;
        if (this.rYp) {
            if (this.rYs == null) {
                i = 0;
            } else {
                i = 2;
            }
        } else if (this.rYs == null) {
            i = 1;
        } else {
            i = 3;
        }
        this.rWx.rRI = i;
        this.rWx.rRJ = this.rYs;
        ArrayList czz = czz();
        C46282b U = mo51363U(czz);
        C22210l c22210l = C22210l.sac;
        cej a = C22210l.m33870a(this.rYw, this.rYs);
        this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.Media.StoryVideoMixer");
        C4990ab.m7417i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(this.ehv));
        U.mo74423a((C36933q) new C31424g(this, c42174a, czz, a));
        AppMethodBeat.m2505o(109547);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: U */
    public final C46282b mo51363U(ArrayList<C9584b> arrayList) {
        AppMethodBeat.m2504i(109548);
        float[] fArr = new float[]{(float) this.rYw.getItemContainer().getLeft(), (float) this.rYw.getItemContainer().getTop(), (float) this.rYw.getItemContainer().getRight(), (float) this.rYw.getItemContainer().getBottom()};
        long aaE = C1839cb.aaE();
        C46282b c46282b = new C46282b(this.rWx, arrayList, fArr, C29309l.aau(String.valueOf(aaE)), C29309l.aav(String.valueOf(aaE)), (byte) 0);
        AppMethodBeat.m2505o(109548);
        return c46282b;
    }

    /* Access modifiers changed, original: final */
    public final ArrayList<C9584b> czz() {
        AppMethodBeat.m2504i(109549);
        ArrayList arrayList = new ArrayList();
        for (C45428h UI : this.rYw.getItemContainer().getAllItemViews()) {
            C9584b UI2 = UI.mo26048UI();
            if (UI2 != null) {
                arrayList.add(UI2);
            }
        }
        AppMethodBeat.m2505o(109549);
        return arrayList;
    }

    public final void bmz() {
        int i = 2;
        AppMethodBeat.m2504i(109550);
        C22212h c22212h = C22212h.scu;
        C22212h.cAC().mo4989aT(System.currentTimeMillis());
        C13771a c13771a = C22219b.rUx;
        C22219b cyS = C22219b.rUt;
        if (!(cyS == null || cyS.pvG == 0)) {
            int i2;
            bqk bqk = new bqk();
            bqk.wSJ = cyS.rUp;
            C4123a c4123a;
            if (cyS.rUr) {
                i2 = cyS.cvd;
                c4123a = AudioCacheInfo.rUj;
                bqk.wSK = i2 == AudioCacheInfo.rUi ? 10 : 2;
            } else {
                i2 = cyS.cvd;
                c4123a = AudioCacheInfo.rUj;
                bqk.wSK = i2 == AudioCacheInfo.rUi ? 12 : 6;
            }
            bqk.wSM = (int) C5046bo.anT();
            cyS.cyQ();
            cyS.rUs.add(bqk);
            C4990ab.m7416i(C22219b.TAG, "record send " + C29301c.m46522a(bqk));
            if (cyS.pvG != 0) {
                Context context = C4996ah.getContext();
                i2 = C5023at.isWifi(context) ? 1 : C5023at.is4G(context) ? 6 : C5023at.is3G(context) ? 5 : C5023at.is2G(context) ? 4 : C5023at.isWap(context) ? 3 : 2;
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "";
                objArr[3] = Long.valueOf(C22219b.rUu);
                objArr[4] = Long.valueOf(C22219b.rUv);
                objArr[5] = "";
                objArr[6] = Long.valueOf(cyS.pvG);
                if (!cyS.rUr) {
                    i = 1;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = Integer.valueOf(cyS.rUp);
                objArr[9] = "";
                objArr[10] = "";
                c7060h.mo8381e(16208, objArr);
            }
            cyS.cyR();
        }
        C4133a c4133a = C43644j.rST;
        C29292g c29292g;
        if (C4133a.cye() == C29278a.FORWARD) {
            c29292g = C29292g.sbU;
            C29292g.m46510lK(true);
            czy();
            AppMethodBeat.m2505o(109550);
            return;
        }
        c29292g = C29292g.sbU;
        C29292g.m46510lK(false);
        C31214a c31426f = new C31426f(this);
        AudioCacheInfo audioCacheInfo = this.rYs;
        if (audioCacheInfo == null || audioCacheInfo.aIM) {
            C4990ab.m7416i(this.TAG, "checkAudioCache done");
            c31426f.invoke();
            AppMethodBeat.m2505o(109550);
            return;
        }
        C4990ab.m7416i(this.TAG, "checkAudioCache false");
        C13747a c13747a = new C13747a();
        c13747a.mo25965a(this.context, true, new C31421b(this, audioCacheInfo));
        this.rYt = c13747a;
        C4125a c4125a = C46277g.rUG;
        C46277g.rUF.mo74419a(audioCacheInfo, new C13752c(this, audioCacheInfo, c31426f));
        AppMethodBeat.m2505o(109550);
    }

    /* renamed from: Ab */
    public final boolean mo47474Ab() {
        AppMethodBeat.m2504i(109551);
        if (this.rYw.aFF()) {
            cxp();
            if (this.rYw.cxq()) {
                AppMethodBeat.m2505o(109551);
                return true;
            }
            C13771a c13771a = C22219b.rUx;
            C22219b cyS = C22219b.rUt;
            if (!(cyS == null || cyS.pvG == 0)) {
                bqk bqk = new bqk();
                bqk.wSJ = cyS.rUp;
                int i;
                C4123a c4123a;
                if (cyS.rUr) {
                    i = cyS.cvd;
                    c4123a = AudioCacheInfo.rUj;
                    bqk.wSK = i == AudioCacheInfo.rUi ? 11 : 5;
                } else {
                    i = cyS.cvd;
                    c4123a = AudioCacheInfo.rUj;
                    bqk.wSK = i == AudioCacheInfo.rUi ? 13 : 7;
                }
                bqk.wSM = (int) C5046bo.anT();
                cyS.cyQ();
                cyS.rUs.add(bqk);
                C4990ab.m7416i(C22219b.TAG, "record cancel " + C29301c.m46522a(bqk));
                cyS.cyR();
            }
            reset();
            this.rYv.bnN();
            AppMethodBeat.m2505o(109551);
            return true;
        }
        AppMethodBeat.m2505o(109551);
        return false;
    }

    public final void reset() {
        AppMethodBeat.m2504i(109552);
        this.rYp = false;
        this.rYq = true;
        this.rYw.reset();
        this.rYw.getVideoPlayView().setMute(this.rYp);
        this.rYw.getVideoPlayView().stop();
        pauseAudio();
        this.rYs = null;
        this.rWx.reset();
        C22248a c22248a = StoryAudioManagerProxy.sas;
        StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
        AppMethodBeat.m2505o(109552);
    }

    /* renamed from: lu */
    public final void mo47479lu(boolean z) {
        this.rYq = z;
    }

    /* renamed from: lv */
    public final void mo47480lv(boolean z) {
        this.rYr = z;
    }
}
