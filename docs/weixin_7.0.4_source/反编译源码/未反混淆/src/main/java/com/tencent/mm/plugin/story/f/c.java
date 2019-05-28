package com.tencent.mm.plugin.story.f;

import a.f.a.m;
import a.f.a.q;
import a.f.b.k;
import a.l;
import a.y;
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
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u001a\u0018\u00002\u00020\u0001:\u0001NB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%H\u0002JC\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020#0-H\u0002JW\u0010&\u001a\u00020#2\u0006\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\b\b\u0002\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020#0-H\u0002J\b\u00105\u001a\u00020#H\u0016J\u0018\u00106\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9H\u0002J \u0010:\u001a\u00020;2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9H\u0002J\b\u0010=\u001a\u00020#H\u0016J\u0010\u0010\u0018\u001a\u00020#2\u0006\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0012H\u0016J\b\u0010B\u001a\u00020\u0012H\u0016J\b\u0010C\u001a\u00020#H\u0016J\b\u0010D\u001a\u00020#H\u0016J\b\u0010E\u001a\u00020#H\u0016J\u0012\u0010F\u001a\u00020#2\b\u0010G\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020#H\u0016J\b\u0010K\u001a\u00020#H\u0002J\b\u0010L\u001a\u00020#H\u0002J\u0010\u0010M\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;)V", "TAG", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getContext", "()Landroid/content/Context;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isFavorite", "", "isNotifyMoment", "loading", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "mixAudio", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "muteOrigin", "showLoading", "com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1;", "startPerformance", "", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getView", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "checkAudioCache", "", "callback", "Lkotlin/Function0;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "mediaDes", "needExport", "resId", "destroy", "getEditorItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "getMixer", "Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "editorItems", "mix", "mute", "notifyFavorite", "notifyMoment", "isNotify", "onBack", "onPlayerRepeat", "pause", "pauseAudio", "playAudio", "info", "prepareReport", "reset", "resume", "runMix", "runMixInBackground", "setup", "StoryProgressDialog", "plugin-story_release"})
public final class c implements com.tencent.mm.plugin.story.d.b.a {
    final String TAG = "MicroMsg.Story.EditorPresenter";
    final Context context;
    int ehv;
    com.tencent.mm.plugin.story.e.a rWx = new com.tencent.mm.plugin.story.e.a();
    private v rYo;
    boolean rYp;
    boolean rYq = true;
    boolean rYr;
    AudioCacheInfo rYs;
    a rYt;
    j rYu = new j(this);
    final com.tencent.mm.plugin.story.ui.StoryCaptureUI.b rYv;
    public final com.tencent.mm.plugin.story.d.b.b rYw;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "cancel", "plugin-story_release"})
    public static final class a {
        p llm;
        a.f.a.a<y> rYx = a.rYy;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            public static final a rYy = new a();

            static {
                AppMethodBeat.i(109518);
                AppMethodBeat.o(109518);
            }

            a() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return y.AUy;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class b extends k implements a.f.a.a<y> {
            public static final b rYz = new b();

            static {
                AppMethodBeat.i(109519);
                AppMethodBeat.o(109519);
            }

            b() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return y.AUy;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class c implements OnCancelListener {
            final /* synthetic */ a rYA;

            c(a aVar) {
                this.rYA = aVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(109520);
                this.rYA.rYx.invoke();
                AppMethodBeat.o(109520);
            }
        }

        public a() {
            AppMethodBeat.i(109523);
            AppMethodBeat.o(109523);
        }

        public final void a(Context context, boolean z, a.f.a.a<y> aVar) {
            AppMethodBeat.i(109521);
            a.f.b.j.p(context, "context");
            a.f.b.j.p(aVar, "cancel");
            this.rYx = aVar;
            if (this.llm == null) {
                this.llm = p.b(context, context.getString(R.string.cn5), z, new c(this));
            }
            AppMethodBeat.o(109521);
        }

        public final void dismiss() {
            AppMethodBeat.i(109522);
            p pVar = this.llm;
            if (pVar != null) {
                pVar.dismiss();
            }
            this.llm = null;
            AppMethodBeat.o(109522);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    static final class c extends k implements m<Boolean, String, y> {
        final /* synthetic */ a.f.a.a lix;
        final /* synthetic */ c rYB;
        final /* synthetic */ AudioCacheInfo rYD;

        c(c cVar, AudioCacheInfo audioCacheInfo, a.f.a.a aVar) {
            this.rYB = cVar;
            this.rYD = audioCacheInfo;
            this.lix = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(109526);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i(this.rYB.TAG, "cacheAudio callback success ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                this.rYD.aIM = true;
                this.lix.invoke();
                a aVar = this.rYB.rYt;
                if (aVar != null) {
                    a.f.a.a aVar2 = AnonymousClass1.rYE;
                    a.f.b.j.p(aVar2, "onCancel");
                    aVar.rYx = aVar2;
                }
            } else {
                t.makeText(this.rYB.context, R.string.etd, 0).show();
                a aVar3 = this.rYB.rYt;
                if (aVar3 != null) {
                    aVar3.dismiss();
                }
                this.rYB.rYt = null;
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109526);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Ljava/lang/Runnable;", "run", "", "plugin-story_release"})
    public static final class j implements Runnable {
        final /* synthetic */ c rYB;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            public static final a rYV = new a();

            static {
                AppMethodBeat.i(109538);
                AppMethodBeat.o(109538);
            }

            a() {
                super(0);
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return y.AUy;
            }
        }

        j(c cVar) {
            this.rYB = cVar;
        }

        public final void run() {
            AppMethodBeat.i(109539);
            c cVar = this.rYB;
            a aVar = new a();
            aVar.a(this.rYB.context, false, a.rYV);
            cVar.rYt = aVar;
            AppMethodBeat.o(109539);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ c rYB;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.c$h$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<y> {
            final /* synthetic */ h rYR;

            AnonymousClass1(h hVar) {
                this.rYR = hVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109535);
                al.af(this.rYR.rYB.rYu);
                a aVar = this.rYR.rYB.rYt;
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.rYR.rYB.rYt = null;
                y yVar = y.AUy;
                AppMethodBeat.o(109535);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$runMixInBackground$1$1$2"})
        static final class b extends k implements a.f.a.a<y> {
            final /* synthetic */ h rYR;
            final /* synthetic */ cej rYS;
            final /* synthetic */ com.tencent.mm.plugin.story.h.d rYT;
            final /* synthetic */ com.tencent.mm.media.i.a rYU;

            b(h hVar, cej cej, com.tencent.mm.plugin.story.h.d dVar, com.tencent.mm.media.i.a aVar) {
                this.rYR = hVar;
                this.rYS = cej;
                this.rYT = dVar;
                this.rYU = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109534);
                al.af(this.rYR.rYB.rYu);
                a aVar = this.rYR.rYB.rYt;
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.rYR.rYB.rYt = null;
                this.rYR.rYB.rYv.exit();
                y yVar = y.AUy;
                AppMethodBeat.o(109534);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "", "storyLocalId", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$runMixInBackground$1$1$1"})
        static final class a extends k implements a.f.a.b<Integer, y> {
            final /* synthetic */ h rYR;
            final /* synthetic */ cej rYS;
            final /* synthetic */ com.tencent.mm.plugin.story.h.d rYT;
            final /* synthetic */ com.tencent.mm.media.i.a rYU;

            a(h hVar, cej cej, com.tencent.mm.plugin.story.h.d dVar, com.tencent.mm.media.i.a aVar) {
                this.rYR = hVar;
                this.rYS = cej;
                this.rYT = dVar;
                this.rYU = aVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(109533);
                this.rYT.field_storyLocalId = ((Number) obj).intValue();
                l lVar = l.sac;
                l.a(this.rYT.xDa, this.rYT);
                com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cya().czx();
                com.tencent.mm.plugin.story.proxy.c.a aVar2 = com.tencent.mm.plugin.story.proxy.c.saU;
                com.tencent.mm.plugin.story.proxy.c.a.czN().czM();
                ab.i(this.rYR.rYB.TAG, "man reStartMixend " + this.rYU);
                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.EU(13);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAm().bb(System.currentTimeMillis());
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAn();
                y yVar = y.AUy;
                AppMethodBeat.o(109533);
                return yVar;
            }
        }

        h(c cVar) {
            this.rYB = cVar;
        }

        public final void run() {
            AppMethodBeat.i(109536);
            com.tencent.mm.media.i.a aVar = new com.tencent.mm.media.i.a("runMixInBackground");
            this.rYB.pause();
            ab.i(this.rYB.TAG, "man pause ".concat(String.valueOf(aVar)));
            long aaE = cb.aaE();
            com.tencent.mm.plugin.story.model.e.b U = this.rYB.U(this.rYB.czz());
            com.tencent.mm.plugin.story.e.a aVar2 = this.rYB.rWx;
            a.f.b.j.p(aVar2, "captureInfo");
            com.tencent.mm.plugin.story.g.g gVar;
            try {
                Bitmap ag;
                Bitmap bitmap;
                String str;
                String str2 = aVar2.fbU;
                int i = U.eXL;
                if (TextUtils.isEmpty(str2)) {
                    long j;
                    if (aVar2.rRG > 0) {
                        j = aVar2.rRG;
                    } else {
                        j = 0;
                    }
                    ab.i("MicroMsg.Media.StoryVideoMixer", "create thumb bitmap : ".concat(String.valueOf(j)));
                    if (aVar2.fbV) {
                        ag = com.tencent.mm.plugin.mmsight.d.ag(aVar2.fbT, j);
                    } else {
                        Object obj;
                        int i2;
                        int i3;
                        com.tencent.mm.plugin.story.c.a.c.a aVar3 = (com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw();
                        aVar3.aaa(aVar2.fbT);
                        Bitmap ag2 = com.tencent.mm.plugin.mmsight.d.ag(aVar2.fbT, j);
                        if (aVar3.eXL == 270 || aVar3.eXL == 90) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i2 = aVar3.eTj;
                        } else {
                            i2 = aVar3.eTi;
                        }
                        if (obj != null) {
                            i3 = aVar3.eTi;
                        } else {
                            i3 = aVar3.eTj;
                        }
                        ag = Bitmap.createScaledBitmap(ag2, i2, i3, true);
                        StringBuilder stringBuilder = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
                        a.f.b.j.o(ag, "thumb");
                        ab.i("MicroMsg.Media.StoryVideoMixer", stringBuilder.append(ag.getWidth()).append(", ").append(ag.getHeight()).append("], thumbRotate:").append(i).append(", drawingRect:").append(Arrays.toString(U.rWy)).toString());
                    }
                    com.tencent.mm.plugin.story.model.i.a aVar4 = com.tencent.mm.plugin.story.model.i.rSv;
                    aVar2.aae(com.tencent.mm.plugin.story.model.i.a.kY(cb.aaE()));
                    bitmap = ag;
                    str = aVar2.fbU;
                } else {
                    Options options = new Options();
                    ab.i("MicroMsg.Media.StoryVideoMixer", "exist thumb bitmap ");
                    options.inMutable = true;
                    bitmap = com.tencent.mm.sdk.platformtools.d.decodeFile(str2, options);
                    str = str2;
                }
                if (bitmap == null) {
                    ab.e("MicroMsg.Media.StoryVideoMixer", "createGraffitiThumb thumb is null");
                    gVar = com.tencent.mm.plugin.story.g.g.sbU;
                    com.tencent.mm.plugin.story.g.g.cAj();
                } else {
                    Point fL = com.tencent.mm.plugin.story.model.e.b.fL(bitmap.getWidth(), bitmap.getHeight());
                    com.tencent.mm.plugin.story.e.c.a aVar5 = com.tencent.mm.plugin.story.e.c.rRS;
                    com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(aVar2.fbT);
                    if (aVar2.fbV || aaj == null || aaj.rRT) {
                        U.rWw = new com.tencent.mm.plugin.story.model.e.a(U.rWy, U.eWG, fL.x, fL.y, 0, 0, i);
                    } else {
                        U.rWw = new com.tencent.mm.plugin.story.model.e.a(U.rWy, U.eWG, fL.x, fL.y, aaj.width, aaj.height, i);
                    }
                    com.tencent.mm.plugin.story.model.e.a aVar6 = U.rWw;
                    if (aVar6 == null) {
                        a.f.b.j.avw("frameRetriever");
                    }
                    aVar6.start();
                    ag = (Bitmap) U.eXh.am(Long.valueOf(1));
                    com.tencent.mm.plugin.story.model.e.a aVar7 = U.rWw;
                    if (aVar7 == null) {
                        a.f.b.j.avw("frameRetriever");
                    }
                    aVar7.destroy();
                    if (ag != null) {
                        new Canvas(bitmap).drawBitmap(ag, 0.0f, 0.0f, null);
                    }
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 70, CompressFormat.JPEG, str, true);
                    ab.i("MicroMsg.Media.StoryVideoMixer", "createGraffitiThumb : " + str + "   graffiti : " + (ag == null));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", e, "createGraffitiThumb error", new Object[0]);
                gVar = com.tencent.mm.plugin.story.g.g.sbU;
                com.tencent.mm.plugin.story.g.g.cAj();
            }
            ab.i(this.rYB.TAG, "man createGraffitiThumb ".concat(String.valueOf(aVar)));
            l lVar = l.sac;
            cej a = l.a(this.rYB.rYw, this.rYB.rYs);
            lVar = l.sac;
            com.tencent.mm.plugin.story.h.d a2 = l.a(this.rYB.rYw, this.rYB.rYp, this.rYB.rYs, this.rYB.rWx, aaE, this.rYB.rYw.getLocation());
            ab.i(this.rYB.TAG, "man insertdone ".concat(String.valueOf(aVar)));
            if (a2 != null) {
                com.tencent.mm.ab.b.a("StoryCapture_commit", (a.f.a.a) new e(this.rYB, a2, this.rYB.rWx.fbU, a, new a(this, a, a2, aVar)));
                com.tencent.mm.ab.b.a(new b(this, a, a2, aVar));
                AppMethodBeat.o(109536);
                return;
            }
            com.tencent.mm.ab.b.a(new AnonymousClass1(this));
            ab.i(this.rYB.TAG, "error when runMixInBackground");
            AppMethodBeat.o(109536);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$checkAudioCache$1$1"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ c rYB;
        final /* synthetic */ AudioCacheInfo rYC;

        b(c cVar, AudioCacheInfo audioCacheInfo) {
            this.rYB = cVar;
            this.rYC = audioCacheInfo;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109524);
            ab.i(this.rYB.TAG, "checkAudioCache canceled");
            com.tencent.mm.plugin.story.model.audio.g.a aVar = com.tencent.mm.plugin.story.model.audio.g.rUG;
            com.tencent.mm.plugin.story.model.audio.g.rUF.cancelCache(this.rYC);
            y yVar = y.AUy;
            AppMethodBeat.o(109524);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class i extends k implements a.f.a.a<y> {
        final /* synthetic */ c rYB;

        i(c cVar) {
            this.rYB = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109537);
            this.rYB.rYv.bnO();
            y yVar = y.AUy;
            AppMethodBeat.o(109537);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ c rYB;
        final /* synthetic */ String rYH;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ a.f.a.b rYK;
        final /* synthetic */ com.tencent.mm.plugin.story.h.d rYL;

        e(c cVar, com.tencent.mm.plugin.story.h.d dVar, String str, cej cej, a.f.a.b bVar) {
            this.rYB = cVar;
            this.rYL = dVar;
            this.rYH = str;
            this.rYJ = cej;
            this.rYK = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            AppMethodBeat.i(109528);
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
            com.tencent.mm.plugin.story.proxy.d.a aVar = com.tencent.mm.plugin.story.proxy.d.sbf;
            int commitStory = com.tencent.mm.plugin.story.proxy.d.sbe.commitStory(this.rYL, this.rYH, this.rYB.rYw.getLocation(), this.rYB.rWx.fbV, this.rYJ, i, i2);
            com.tencent.mm.plugin.story.model.d dVar = com.tencent.mm.plugin.story.model.d.rSg;
            com.tencent.mm.plugin.story.model.d.cxA();
            this.rYK.am(Integer.valueOf(commitStory));
            y yVar = y.AUy;
            AppMethodBeat.o(109528);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "invoke"})
    static final class g extends k implements q<String, String, Boolean, y> {
        final /* synthetic */ com.tencent.mm.media.i.a fbQ;
        final /* synthetic */ c rYB;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ ArrayList rYM;

        g(c cVar, com.tencent.mm.media.i.a aVar, ArrayList arrayList, cej cej) {
            this.rYB = cVar;
            this.fbQ = aVar;
            this.rYM = arrayList;
            this.rYJ = cej;
            super(3);
        }

        /* JADX WARNING: Missing block: B:16:0x00b7, code skipped:
            if (r6 < ((long) r0)) goto L_0x00b9;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            y yVar;
            boolean z = false;
            AppMethodBeat.i(109532);
            final String str = (String) obj;
            String str2 = (String) obj2;
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            a.f.b.j.p(str, "mixVideoPath");
            a.f.b.j.p(str2, "mixThumbPath");
            if (this.rYB.ehv != 0) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, this.rYB.ehv);
                ab.i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(this.rYB.ehv));
                this.rYB.ehv = 0;
            }
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            ak cAC = com.tencent.mm.plugin.story.g.h.cAC();
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            cAC.aT(currentTimeMillis - com.tencent.mm.plugin.story.g.h.cAC().Ft());
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAC().aU(booleanValue ? 0 : -1);
            com.tencent.mm.plugin.story.g.h hVar3 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAC().aV(System.currentTimeMillis());
            this.fbQ.SW();
            com.tencent.mm.plugin.story.e.c.a aVar = com.tencent.mm.plugin.story.e.c.rRS;
            com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(this.rYB.rWx.fbT);
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
                com.tencent.mm.ab.b.a("StoryCapture_commit", (a.f.a.a) new d(this.rYB, z, str, str2, "", this.rYJ, new a.f.a.b<Integer, y>(this) {
                    final /* synthetic */ g rYN;

                    public final /* synthetic */ Object am(Object obj) {
                        AppMethodBeat.i(109531);
                        final int intValue = ((Number) obj).intValue();
                        al.d(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 rYP;

                            public final void run() {
                                AppMethodBeat.i(109530);
                                a aVar = this.rYP.rYN.rYB.rYt;
                                if (aVar != null) {
                                    aVar.dismiss();
                                }
                                this.rYP.rYN.rYB.rYt = null;
                                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                                com.tencent.mm.plugin.story.g.h.g(intValue, this.rYP.rYN.rYB.rWx.fbT, this.rYP.rYN.rYB.rWx.fbV);
                                hVar = com.tencent.mm.plugin.story.g.h.scu;
                                com.tencent.mm.plugin.story.g.h.bl(intValue, str);
                                com.tencent.mm.ui.base.h.bN(this.rYP.rYN.rYB.context, this.rYP.rYN.rYB.context.getString(R.string.ti));
                                this.rYP.rYN.rYB.rYv.exit();
                                AppMethodBeat.o(109530);
                            }
                        });
                        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.EU(13);
                        hVar = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.cAm().bb(System.currentTimeMillis());
                        hVar = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.cAn();
                        y yVar = y.AUy;
                        AppMethodBeat.o(109531);
                        return yVar;
                    }
                }));
                yVar = y.AUy;
                AppMethodBeat.o(109532);
                return yVar;
            }
            z = true;
            com.tencent.mm.ab.b.a("StoryCapture_commit", (a.f.a.a) new d(this.rYB, z, str, str2, "", this.rYJ, /* anonymous class already generated */));
            yVar = y.AUy;
            AppMethodBeat.o(109532);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ c rYB;
        final /* synthetic */ boolean rYF;
        final /* synthetic */ String rYG;
        final /* synthetic */ String rYH;
        final /* synthetic */ String rYI;
        final /* synthetic */ cej rYJ;
        final /* synthetic */ a.f.a.b rYK;

        d(c cVar, boolean z, String str, String str2, String str3, cej cej, a.f.a.b bVar) {
            this.rYB = cVar;
            this.rYF = z;
            this.rYG = str;
            this.rYH = str2;
            this.rYI = str3;
            this.rYJ = cej;
            this.rYK = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            AppMethodBeat.i(109527);
            if (this.rYF) {
                com.tencent.mm.plugin.story.e.c.a aVar = com.tencent.mm.plugin.story.e.c.rRS;
                com.tencent.mm.plugin.story.e.c.a.aai(this.rYG);
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
            com.tencent.mm.plugin.story.proxy.d.a aVar2 = com.tencent.mm.plugin.story.proxy.d.sbf;
            int commitStory = com.tencent.mm.plugin.story.proxy.d.sbe.commitStory(this.rYG, this.rYH, this.rYI, this.rYB.rYw.getLocation(), this.rYB.rWx.fbV, this.rYJ, i, i2);
            com.tencent.mm.plugin.story.model.d dVar = com.tencent.mm.plugin.story.model.d.rSg;
            com.tencent.mm.plugin.story.model.d.cxA();
            this.rYK.am(Integer.valueOf(commitStory));
            y yVar = y.AUy;
            AppMethodBeat.o(109527);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ c rYB;

        f(c cVar) {
            this.rYB = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109529);
            c cVar = this.rYB;
            if (cVar.rYt == null) {
                al.n(cVar.rYu, 500);
            } else {
                a aVar = cVar.rYt;
                if (aVar != null) {
                    p pVar = aVar.llm;
                    if (pVar != null) {
                        pVar.setCancelable(false);
                    }
                }
            }
            com.tencent.mm.plugin.story.g.f fVar = com.tencent.mm.plugin.story.g.f.sbT;
            com.tencent.mm.plugin.story.g.f.lF(cVar.rWx.fbV);
            com.tencent.mm.sdk.g.d.xDG.execute(new h(cVar));
            y yVar = y.AUy;
            AppMethodBeat.o(109529);
            return yVar;
        }
    }

    public c(Context context, com.tencent.mm.plugin.story.ui.StoryCaptureUI.b bVar, com.tencent.mm.plugin.story.d.b.b bVar2) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(bVar, "uiNavigation");
        a.f.b.j.p(bVar2, "view");
        AppMethodBeat.i(109553);
        this.context = context;
        this.rYv = bVar;
        this.rYw = bVar2;
        AppMethodBeat.o(109553);
    }

    public final void a(com.tencent.mm.plugin.story.e.a aVar) {
        AppMethodBeat.i(109540);
        a.f.b.j.p(aVar, "captureInfo");
        this.rWx = aVar;
        com.tencent.mm.plugin.story.model.audio.b.a aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
        com.tencent.mm.plugin.story.model.audio.b.rUt = new com.tencent.mm.plugin.story.model.audio.b();
        this.rYw.a(aVar.fbT, aVar.rRG, aVar.rRH, new i(this));
        AppMethodBeat.o(109540);
    }

    public final void pause() {
        AppMethodBeat.i(109541);
        ab.c(this.TAG, "pause", new Object[0]);
        EditorItemContainer itemContainer = this.rYw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof com.tencent.mm.plugin.story.ui.view.editor.item.b) {
                ((com.tencent.mm.plugin.story.ui.view.editor.item.b) childAt).pause();
            }
        }
        this.rYw.getVideoPlayView().pause();
        v vVar = this.rYo;
        if (vVar != null) {
            vVar.aE(false);
            AppMethodBeat.o(109541);
            return;
        }
        AppMethodBeat.o(109541);
    }

    public final void resume() {
        AppMethodBeat.i(109542);
        ab.c(this.TAG, "resume", new Object[0]);
        EditorItemContainer itemContainer = this.rYw.getItemContainer();
        int childCount = itemContainer.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = itemContainer.lnI.getChildAt(i);
            if (childAt instanceof com.tencent.mm.plugin.story.ui.view.editor.item.b) {
                ((com.tencent.mm.plugin.story.ui.view.editor.item.b) childAt).resume();
            }
        }
        this.rYw.getVideoPlayView().start();
        v vVar = this.rYo;
        if (vVar != null) {
            vVar.aE(true);
            AppMethodBeat.o(109542);
            return;
        }
        AppMethodBeat.o(109542);
    }

    public final void lt(boolean z) {
        AppMethodBeat.i(109543);
        this.rYp = z;
        this.rYw.getVideoPlayView().setMute(this.rYp);
        AppMethodBeat.o(109543);
    }

    public final void a(AudioCacheInfo audioCacheInfo) {
        String str = null;
        AppMethodBeat.i(109544);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("play audio ").append(audioCacheInfo != null ? Integer.valueOf(audioCacheInfo.rTW) : null).append(' ');
        if (audioCacheInfo != null) {
            str = audioCacheInfo.musicUrl;
        }
        ab.i(str2, append.append(str).toString());
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().fn("");
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().bg(0);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().bh(0);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAq().cb(0);
        pauseAudio();
        this.rYs = audioCacheInfo;
        if (audioCacheInfo != null) {
            long j;
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAm().fn(String.valueOf(audioCacheInfo.rTW));
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.g.b.a.al cAm = com.tencent.mm.plugin.story.g.h.cAm();
            int i = audioCacheInfo.cvd;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
            if (i == AudioCacheInfo.rUi) {
                j = 0;
            } else {
                j = (long) (audioCacheInfo.position + 1);
            }
            cAm.bg(j);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAm().bh(audioCacheInfo.rUb);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAq().cb(1);
            com.tencent.mm.plugin.story.model.audio.b.a aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
            com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
            if (cyS != null) {
                int i2 = audioCacheInfo.rTW;
                int i3 = audioCacheInfo.type;
                cyS.rUp = i2;
                cyS.rUq = System.currentTimeMillis();
                cyS.rUr = true;
                cyS.cHY = false;
                cyS.cvd = i3;
            }
            com.google.android.exoplayer2.g.c cVar = new com.google.android.exoplayer2.g.c(new com.google.android.exoplayer2.g.a.a(new com.google.android.exoplayer2.h.k()));
            str = com.google.android.exoplayer2.i.v.i(this.context, this.context.getString(R.string.ru));
            this.rYo = com.google.android.exoplayer2.g.a(this.context, cVar);
            com.tencent.mm.plugin.story.model.audio.g.a aVar3 = com.tencent.mm.plugin.story.model.audio.g.rUG;
            a.f.b.j.o(str, "userAgent");
            com.google.android.exoplayer2.source.i a = com.tencent.mm.plugin.story.model.audio.g.a.a(audioCacheInfo, str);
            v vVar = this.rYo;
            if (vVar != null) {
                vVar.aE(true);
            }
            vVar = this.rYo;
            if (vVar != null) {
                vVar.a(a);
            }
            v vVar2 = this.rYo;
            if (vVar2 != null) {
                vVar2.setRepeatMode(2);
            }
            if (this.rYo != null) {
                com.tencent.mm.plugin.story.d.b.b bVar = this.rYw;
                vVar = this.rYo;
                if (vVar == null) {
                    a.f.b.j.dWJ();
                }
                bVar.setMusicPlayer(vVar);
            }
        }
        AppMethodBeat.o(109544);
    }

    public final void pauseAudio() {
        AppMethodBeat.i(109545);
        v vVar = this.rYo;
        if (vVar == null || vVar.pO() != 4) {
            com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
            com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
            if (cyS != null) {
                cyS.cyQ();
            }
            vVar = this.rYo;
            if (vVar != null) {
                vVar.stop();
            }
            vVar = this.rYo;
            if (vVar != null) {
                vVar.release();
            }
            this.rYo = null;
            this.rYs = null;
        }
        AppMethodBeat.o(109545);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cxp() {
        int i;
        com.tencent.mm.plugin.story.g.h hVar;
        long j;
        at cAq;
        long j2 = 1;
        AppMethodBeat.i(109546);
        int i2 = 0;
        int i3 = 0;
        for (com.tencent.mm.media.editor.a.h hVar2 : this.rYw.getItemContainer().getAllItemViews()) {
            if (hVar2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.b) {
                i3++;
            }
            if (hVar2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.f) {
                i = i2 + 1;
            } else {
                i = i2;
            }
            if (hVar2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.e) {
                com.tencent.mm.plugin.story.g.h hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAm().fo(((com.tencent.mm.plugin.story.ui.view.editor.item.e) hVar2).getReportPositionString().toString());
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAm().fp(String.valueOf(((com.tencent.mm.plugin.story.ui.view.editor.item.e) hVar2).getLatitude()));
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAm().fq(String.valueOf(((com.tencent.mm.plugin.story.ui.view.editor.item.e) hVar2).getLongitude()));
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAq().FX();
            }
            i2 = i;
        }
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().be((long) i3);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().bf((long) i2);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAm().bk(this.rYq ? 1 : 0);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.g.b.a.al cAm = com.tencent.mm.plugin.story.g.h.cAm();
        AudioCacheInfo audioCacheInfo = this.rYs;
        if (audioCacheInfo != null) {
            i = audioCacheInfo.cvd;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
            if (i == AudioCacheInfo.rUi) {
                j = 1;
                cAm.bj(j);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                cAq = com.tencent.mm.plugin.story.g.h.cAq();
                if (!this.rYq) {
                    j2 = 0;
                }
                cAq.cd(j2);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAq().bZ((long) i3);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAq().ca((long) i2);
                AppMethodBeat.o(109546);
            }
        }
        j = 0;
        cAm.bj(j);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        cAq = com.tencent.mm.plugin.story.g.h.cAq();
        if (this.rYq) {
        }
        cAq.cd(j2);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAq().bZ((long) i3);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAq().ca((long) i2);
        AppMethodBeat.o(109546);
    }

    private final void czy() {
        int i;
        AppMethodBeat.i(109547);
        com.tencent.mm.media.i.a aVar = new com.tencent.mm.media.i.a("runMix");
        pause();
        a aVar2 = new a();
        Context context = this.context;
        a.f.b.j.p(context, "context");
        aVar2.a(context, true, b.rYz);
        this.rYt = aVar2;
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
        com.tencent.mm.plugin.story.model.e.b U = U(czz);
        l lVar = l.sac;
        cej a = l.a(this.rYw, this.rYs);
        this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.Media.StoryVideoMixer");
        ab.i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(this.ehv));
        U.a((q) new g(this, aVar, czz, a));
        AppMethodBeat.o(109547);
    }

    /* Access modifiers changed, original: final */
    public final com.tencent.mm.plugin.story.model.e.b U(ArrayList<com.tencent.mm.media.editor.a.b> arrayList) {
        AppMethodBeat.i(109548);
        float[] fArr = new float[]{(float) this.rYw.getItemContainer().getLeft(), (float) this.rYw.getItemContainer().getTop(), (float) this.rYw.getItemContainer().getRight(), (float) this.rYw.getItemContainer().getBottom()};
        long aaE = cb.aaE();
        com.tencent.mm.plugin.story.model.e.b bVar = new com.tencent.mm.plugin.story.model.e.b(this.rWx, arrayList, fArr, com.tencent.mm.plugin.story.model.l.aau(String.valueOf(aaE)), com.tencent.mm.plugin.story.model.l.aav(String.valueOf(aaE)), (byte) 0);
        AppMethodBeat.o(109548);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final ArrayList<com.tencent.mm.media.editor.a.b> czz() {
        AppMethodBeat.i(109549);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.media.editor.a.h UI : this.rYw.getItemContainer().getAllItemViews()) {
            com.tencent.mm.media.editor.a.b UI2 = UI.UI();
            if (UI2 != null) {
                arrayList.add(UI2);
            }
        }
        AppMethodBeat.o(109549);
        return arrayList;
    }

    public final void bmz() {
        int i = 2;
        AppMethodBeat.i(109550);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAC().aT(System.currentTimeMillis());
        com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
        com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
        if (!(cyS == null || cyS.pvG == 0)) {
            int i2;
            bqk bqk = new bqk();
            bqk.wSJ = cyS.rUp;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2;
            if (cyS.rUr) {
                i2 = cyS.cvd;
                aVar2 = AudioCacheInfo.rUj;
                bqk.wSK = i2 == AudioCacheInfo.rUi ? 10 : 2;
            } else {
                i2 = cyS.cvd;
                aVar2 = AudioCacheInfo.rUj;
                bqk.wSK = i2 == AudioCacheInfo.rUi ? 12 : 6;
            }
            bqk.wSM = (int) bo.anT();
            cyS.cyQ();
            cyS.rUs.add(bqk);
            ab.i(com.tencent.mm.plugin.story.model.audio.b.TAG, "record send " + com.tencent.mm.plugin.story.model.audio.c.a(bqk));
            if (cyS.pvG != 0) {
                Context context = ah.getContext();
                i2 = com.tencent.mm.sdk.platformtools.at.isWifi(context) ? 1 : com.tencent.mm.sdk.platformtools.at.is4G(context) ? 6 : com.tencent.mm.sdk.platformtools.at.is3G(context) ? 5 : com.tencent.mm.sdk.platformtools.at.is2G(context) ? 4 : com.tencent.mm.sdk.platformtools.at.isWap(context) ? 3 : 2;
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "";
                objArr[3] = Long.valueOf(com.tencent.mm.plugin.story.model.audio.b.rUu);
                objArr[4] = Long.valueOf(com.tencent.mm.plugin.story.model.audio.b.rUv);
                objArr[5] = "";
                objArr[6] = Long.valueOf(cyS.pvG);
                if (!cyS.rUr) {
                    i = 1;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = Integer.valueOf(cyS.rUp);
                objArr[9] = "";
                objArr[10] = "";
                hVar2.e(16208, objArr);
            }
            cyS.cyR();
        }
        com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.g.g gVar;
        if (com.tencent.mm.plugin.story.model.j.a.cye() == com.tencent.mm.plugin.story.c.a.f.a.FORWARD) {
            gVar = com.tencent.mm.plugin.story.g.g.sbU;
            com.tencent.mm.plugin.story.g.g.lK(true);
            czy();
            AppMethodBeat.o(109550);
            return;
        }
        gVar = com.tencent.mm.plugin.story.g.g.sbU;
        com.tencent.mm.plugin.story.g.g.lK(false);
        a.f.a.a fVar = new f(this);
        AudioCacheInfo audioCacheInfo = this.rYs;
        if (audioCacheInfo == null || audioCacheInfo.aIM) {
            ab.i(this.TAG, "checkAudioCache done");
            fVar.invoke();
            AppMethodBeat.o(109550);
            return;
        }
        ab.i(this.TAG, "checkAudioCache false");
        a aVar4 = new a();
        aVar4.a(this.context, true, new b(this, audioCacheInfo));
        this.rYt = aVar4;
        com.tencent.mm.plugin.story.model.audio.g.a aVar5 = com.tencent.mm.plugin.story.model.audio.g.rUG;
        com.tencent.mm.plugin.story.model.audio.g.rUF.a(audioCacheInfo, new c(this, audioCacheInfo, fVar));
        AppMethodBeat.o(109550);
    }

    public final boolean Ab() {
        AppMethodBeat.i(109551);
        if (this.rYw.aFF()) {
            cxp();
            if (this.rYw.cxq()) {
                AppMethodBeat.o(109551);
                return true;
            }
            com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
            com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
            if (!(cyS == null || cyS.pvG == 0)) {
                bqk bqk = new bqk();
                bqk.wSJ = cyS.rUp;
                int i;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2;
                if (cyS.rUr) {
                    i = cyS.cvd;
                    aVar2 = AudioCacheInfo.rUj;
                    bqk.wSK = i == AudioCacheInfo.rUi ? 11 : 5;
                } else {
                    i = cyS.cvd;
                    aVar2 = AudioCacheInfo.rUj;
                    bqk.wSK = i == AudioCacheInfo.rUi ? 13 : 7;
                }
                bqk.wSM = (int) bo.anT();
                cyS.cyQ();
                cyS.rUs.add(bqk);
                ab.i(com.tencent.mm.plugin.story.model.audio.b.TAG, "record cancel " + com.tencent.mm.plugin.story.model.audio.c.a(bqk));
                cyS.cyR();
            }
            reset();
            this.rYv.bnN();
            AppMethodBeat.o(109551);
            return true;
        }
        AppMethodBeat.o(109551);
        return false;
    }

    public final void reset() {
        AppMethodBeat.i(109552);
        this.rYp = false;
        this.rYq = true;
        this.rYw.reset();
        this.rYw.getVideoPlayView().setMute(this.rYp);
        this.rYw.getVideoPlayView().stop();
        pauseAudio();
        this.rYs = null;
        this.rWx.reset();
        com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a aVar = StoryAudioManagerProxy.sas;
        StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
        AppMethodBeat.o(109552);
    }

    public final void lu(boolean z) {
        this.rYq = z;
    }

    public final void lv(boolean z) {
        this.rYr = z;
    }
}
