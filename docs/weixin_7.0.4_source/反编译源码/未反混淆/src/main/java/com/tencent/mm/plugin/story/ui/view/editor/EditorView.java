package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.k.u;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005*\u0001C\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0002yzB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010M\u001a\u00020(H\u0016J\b\u0010N\u001a\u00020LH\u0002J\b\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020LH\u0016J\b\u0010R\u001a\u00020+H\u0016J\b\u0010S\u001a\u00020AH\u0016J\u0012\u0010T\u001a\u00020L2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020\rH\u0016J\b\u0010X\u001a\u00020IH\u0016J\b\u0010Y\u001a\u00020LH\u0002J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0002J\b\u0010\\\u001a\u00020(H\u0016J\b\u0010]\u001a\u00020(H\u0002J\b\u0010^\u001a\u00020(H\u0016J\b\u0010_\u001a\u00020(H\u0016J\"\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010c\u001a\u00020L2\b\u0010d\u001a\u0004\u0018\u00010AH\u0002J\b\u0010e\u001a\u00020LH\u0016J\b\u0010f\u001a\u00020LH\u0002J\u0010\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020LH\u0002J\u0010\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020\nH\u0016J0\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\r2\u0006\u0010p\u001a\u00020\r2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0016J\u0010\u0010q\u001a\u00020L2\u0006\u0010r\u001a\u00020(H\u0002J\u0010\u0010s\u001a\u00020L2\u0006\u0010r\u001a\u00020(H\u0016J*\u0010t\u001a\u00020L2\u0006\u0010r\u001a\u00020(2\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010<\u001a\b\u0018\u00010=R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0004¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010E\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CLICK_LIMIT_TIME", "", "DEFAULT_NOTIFY_MOMENT_DURATION", "TAG", "", "addAudioCheckView", "Landroid/widget/ImageView;", "addAudioView", "addEmojiView", "addLocation", "addLocationCheckView", "addTextView", "audioPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "blueCheckDrawable", "Landroid/graphics/drawable/Drawable;", "blueColor", "clickTime", "controlGroupPanel", "Landroid/view/ViewGroup;", "controlPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "emojiPanel", "Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "favoriteTip", "inputPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "isNotifyMoment", "", "isSetFavorite", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "mixView", "Landroid/view/View;", "moreBtn", "navigationBarHeight", "pendingTextItem", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "poiService", "Lcom/tencent/mm/plugin/story/api/ICheckLifePoi;", "presenter", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;)V", "reportArg", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$ReportInfo;", "showLocation", "snsTip", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "videoCallBack", "com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1;", "videoLoopEndTime", "", "videoLoopStartTime", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "videoPreparedCallback", "Lkotlin/Function0;", "", "back", "checkFavorite", "checkLocation", "checkMoment", "destroy", "getItemContainer", "getLocation", "getLocationResult", "data", "Landroid/content/Intent;", "getMusicRequestId", "getVideoPlayView", "initAudioPanel", "initSafeArea", "initSmileyPanel", "isShow", "isShowAudioPanel", "isShowSmileyPanel", "isShowTextEditor", "onActivityResult", "requestCode", "resultCode", "reportDirectly", "location", "reset", "setFavStory", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setNotifySns", "setVisibility", "visibility", "setup", "videoPath", "startTime", "endTime", "toggleAudioPanel", "show", "toggleSmileyPanel", "toggleTextEditor", "text", "", "textColor", "textBgColor", "Companion", "ReportInfo", "plugin-story_release"})
public final class EditorView extends RelativeLayout implements com.tencent.mm.plugin.story.d.b.b {
    public static final a smv = new a();
    public final String TAG;
    private boolean hNp;
    private long iBO;
    private a.f.a.a<y> lnp;
    private final VideoPlayerTextureView oxL;
    private boolean rYq;
    private final ImageView rnO;
    public com.tencent.mm.plugin.story.d.b.a slS;
    private final View slT;
    private final ImageView slU;
    private final ImageView slV;
    private final ImageView slW;
    private final ImageView slX;
    private final ViewGroup slY;
    private final ImageView slZ;
    private final ImageView sma;
    private final EditorControlPanel smb;
    public final EditorItemContainer smc;
    private final EditorInputView smd;
    private final com.tencent.mm.media.editor.b.a sme;
    private final EditorAudioView smf;
    private final ImageView smg;
    private final ImageView smh;
    private double smi;
    private double smj;
    public final cei smk;
    private final int sml;
    private final Drawable smm;
    private final long smn;
    private final long smo;
    private com.tencent.mm.plugin.story.ui.view.editor.item.f smp;
    private boolean smq;
    private int smr;
    private c sms;
    public b smt;
    private final i smu;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$10 */
    static final class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass10(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110579);
            if (System.currentTimeMillis() - this.smw.iBO <= this.smw.smo) {
                ab.i(this.smw.TAG, "onclick pass " + this.smw.iBO + " now: " + System.currentTimeMillis() + " notifySns:" + this.smw.rYq);
                AppMethodBeat.o(110579);
                return;
            }
            com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("mixView");
            this.smw.iBO = System.currentTimeMillis();
            this.smw.getPresenter().cxp();
            this.smw.getPresenter().bmz();
            EditorView.a(this.smw, this.smw.smk);
            com.tencent.mm.plugin.story.g.e eVar = com.tencent.mm.plugin.story.g.e.sbS;
            com.tencent.mm.plugin.story.g.e.lC(this.smw.smq);
            eVar = com.tencent.mm.plugin.story.g.e.sbS;
            com.tencent.mm.plugin.story.g.e.lE(this.smw.rYq);
            ab.i(this.smw.TAG, "onclick " + aVar.eOm.Mr());
            AppMethodBeat.o(110579);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$9 */
    static final class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass9(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110578);
            this.smw.cCA();
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(10);
            AppMethodBeat.o(110578);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initAudioPanel$2", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "pauseAudio", "toggleOrigin", "remove", "", "plugin-story_release"})
    public static final class d implements com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.a {
        final /* synthetic */ EditorView smw;

        d(EditorView editorView) {
            this.smw = editorView;
        }

        public final void pauseAudio() {
            AppMethodBeat.i(110583);
            this.smw.getPresenter().pauseAudio();
            AppMethodBeat.o(110583);
        }

        public final void d(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(110584);
            if (audioCacheInfo != null) {
                int i = audioCacheInfo.type;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUd) {
                    this.smw.getPresenter().pauseAudio();
                    AppMethodBeat.o(110584);
                    return;
                }
            }
            this.smw.getPresenter().a(audioCacheInfo);
            AppMethodBeat.o(110584);
        }

        public final void lO(boolean z) {
            AppMethodBeat.i(110585);
            this.smw.getPresenter().lt(z);
            AppMethodBeat.o(110585);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initSmileyPanel$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-story_release"})
    public static final class f implements com.tencent.mm.api.t.a {
        final /* synthetic */ EditorView smw;

        f(EditorView editorView) {
            this.smw = editorView;
        }

        public final void a(k kVar) {
            AppMethodBeat.i(110587);
            j.p(kVar, "emojiInfo");
            ab.i(this.smw.TAG, "[onSelectedEmoji] emojiInfo:%s", kVar);
            EditorItemContainer c = this.smw.smc;
            EmojiInfo emojiInfo = (EmojiInfo) kVar;
            j.p(emojiInfo, "emojiInfo");
            com.tencent.mm.plugin.story.ui.view.editor.item.b bVar = new com.tencent.mm.plugin.story.ui.view.editor.item.b(c.getContext(), false);
            c.lnI.addView(bVar, new LayoutParams(-1, -1));
            com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
            bVar.setSafeArea(com.tencent.mm.plugin.story.f.l.czI());
            bVar.setValidArea(c.smH);
            bVar.setStateResolve(c.smU);
            bVar.setEmojiInfo(emojiInfo);
            bVar.resume();
            c.r(bVar, true);
            c.removeCallbacks(c.lnN);
            c.postDelayed(c.lnN, 1500);
            onHide();
            AppMethodBeat.o(110587);
        }

        public final void onHide() {
            AppMethodBeat.i(110588);
            this.smw.gC(false);
            AppMethodBeat.o(110588);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.a<y> {
        public static final g smy = new g();

        static {
            AppMethodBeat.i(110589);
            AppMethodBeat.o(110589);
        }

        g() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$12", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$4 */
    public static final class AnonymousClass4 implements com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.a {
        final /* synthetic */ EditorView smw;

        AnonymousClass4(EditorView editorView) {
            this.smw = editorView;
        }

        public final void e(CharSequence charSequence, int i, int i2) {
            AppMethodBeat.i(138928);
            if (this.smw.smp != null) {
                com.tencent.mm.plugin.story.ui.view.editor.item.f e = this.smw.smp;
                if (e != null) {
                    e.setVisibility(0);
                }
                e = this.smw.smp;
                if (e != null) {
                    e.setText(charSequence, i, i2);
                }
                this.smw.smp = null;
            } else {
                EditorItemContainer c = this.smw.smc;
                int i3 = (charSequence == null || u.ar(charSequence)) ? true : 0;
                if (i3 == 0) {
                    com.tencent.mm.plugin.story.ui.view.editor.item.f fVar = new com.tencent.mm.plugin.story.ui.view.editor.item.f(c.getContext());
                    c.lnI.addView(fVar, new LayoutParams(-1, -1));
                    com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
                    fVar.setSafeArea(com.tencent.mm.plugin.story.f.l.czI());
                    fVar.setValidArea(c.smH);
                    fVar.setStateResolve(c.smU);
                    fVar.setText(charSequence, i, i2);
                    fVar.setOnClickListener(c.smT);
                    c.r(fVar, true);
                    c.removeCallbacks(c.lnN);
                    c.postDelayed(c.lnN, 1500);
                }
            }
            this.smw.a(false, null, 0, 0);
            AppMethodBeat.o(138928);
        }

        public final void onCancel() {
            AppMethodBeat.i(138929);
            com.tencent.mm.plugin.story.ui.view.editor.item.f e = this.smw.smp;
            if (e != null) {
                e.setVisibility(0);
            }
            this.smw.smp = null;
            this.smw.a(false, null, 0, 0);
            AppMethodBeat.o(138929);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$2 */
    static final class AnonymousClass2 extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ EditorView smw;

        AnonymousClass2(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110571);
            if (((Boolean) obj).booleanValue()) {
                this.smw.smb.setShow(false);
            } else {
                this.smw.smb.setShow(true);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110571);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$3 */
    static final class AnonymousClass3 extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ EditorView smw;

        AnonymousClass3(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(138927);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.smw.smb.requestLayout();
            this.smw.smb.setShow(!booleanValue);
            if (!booleanValue) {
                com.tencent.mm.plugin.story.ui.view.editor.item.f e = this.smw.smp;
                if (e != null) {
                    e.setVisibility(0);
                }
                this.smw.smp = null;
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138927);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ EditorView smw;

        e(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110586);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            EditorControlPanel a = this.smw.smb;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            a.setShow(booleanValue);
            y yVar = y.AUy;
            AppMethodBeat.o(110586);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<y> {
        public static final h smz = new h();

        static {
            AppMethodBeat.i(110590);
            AppMethodBeat.o(110590);
        }

        h() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$11 */
    static final class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass11(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110580);
            this.smw.getPresenter().Ab();
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(12);
            AppMethodBeat.o(110580);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass1(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110570);
            this.smw.gC(!this.smw.bmC());
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(6);
            AppMethodBeat.o(110570);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    public static final class i implements com.tencent.mm.pluginsdk.ui.tools.e.a {
        final /* synthetic */ EditorView smw;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        static final class a implements com.tencent.mm.pluginsdk.ui.tools.e.e {
            final /* synthetic */ i smA;

            a(i iVar) {
                this.smA = iVar;
            }

            public final void bQL() {
                AppMethodBeat.i(110591);
                this.smA.smw.oxL.setVisibility(0);
                a.f.a.a o = this.smA.smw.lnp;
                if (o != null) {
                    o.invoke();
                }
                this.smA.smw.oxL.setAlpha(1.0f);
                AppMethodBeat.o(110591);
            }
        }

        i(EditorView editorView) {
            this.smw = editorView;
        }

        public final void pL() {
            AppMethodBeat.i(110592);
            this.smw.oxL.setOneTimeVideoTextureUpdateCallback(new a(this));
            double p = this.smw.smi >= 0.0d ? this.smw.smi : 0.0d;
            ab.i(this.smw.TAG, "onPrepared, startTime:".concat(String.valueOf(p)));
            if (p > 0.0d) {
                this.smw.oxL.d(p * 1000.0d, true);
                AppMethodBeat.o(110592);
                return;
            }
            this.smw.oxL.start();
            AppMethodBeat.o(110592);
        }

        public final void EA() {
            double d = 0.0d;
            AppMethodBeat.i(110593);
            if (this.smw.smi >= 0.0d) {
                d = this.smw.smi;
            }
            ab.i(this.smw.TAG, "onCompletion, seekTo startTime: " + this.smw.smi);
            this.smw.oxL.d(d * 1000.0d, true);
            this.smw.getPresenter();
            AppMethodBeat.o(110593);
        }

        public final int dG(int i, int i2) {
            double d = 0.0d;
            AppMethodBeat.i(110594);
            if (this.smw.smj > 0.0d && ((double) i) >= this.smw.smj * 1000.0d) {
                if (this.smw.smi >= 0.0d) {
                    d = this.smw.smi;
                }
                ab.i(this.smw.TAG, "onPlayTime, reach loop endtime:" + this.smw.smj + ", startTime:" + d);
                this.smw.oxL.d(d * 1000.0d, true);
            }
            AppMethodBeat.o(110594);
            return 0;
        }

        public final void dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass5(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110574);
            EditorView editorView = this.smw;
            CharSequence charSequence = "";
            com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.b bVar = EditorInputView.slG;
            int cCy = EditorInputView.slE;
            com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.b bVar2 = EditorInputView.slG;
            editorView.a(true, charSequence, cCy, EditorInputView.slF);
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(8);
            AppMethodBeat.o(110574);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$6 */
    static final class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass6(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110575);
            EditorView.d(this.smw);
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(5);
            AppMethodBeat.o(110575);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$7 */
    static final class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass7(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110576);
            this.smw.cCA();
            AppMethodBeat.o(110576);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$ReportInfo;", "", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;)V", "entryTime", "", "getEntryTime", "()I", "setEntryTime", "(I)V", "firstStartStamp", "", "getFirstStartStamp", "()J", "setFirstStartStamp", "(J)V", "firstSuccStamp", "getFirstSuccStamp", "setFirstSuccStamp", "index", "getIndex", "setIndex", "lastSuccStamp", "getLastSuccStamp", "setLastSuccStamp", "reqLoadCnt", "getReqLoadCnt", "setReqLoadCnt", "searchId", "", "getSearchId", "()Ljava/lang/String;", "setSearchId", "(Ljava/lang/String;)V", "feed", "", "data", "Landroid/content/Intent;", "plugin-story_release"})
    public final class b {
        public String hlm = "";
        public int index;
        public int nPQ;
        public long oRM = -1;
        public long oRN = -1;
        public long oRO = -1;
        public int oRP;
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$8 */
    static final class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        AnonymousClass8(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            View view2;
            AppMethodBeat.i(110577);
            EditorView editorView = this.smw;
            if (view instanceof com.tencent.mm.plugin.story.ui.view.editor.item.f) {
                view2 = view;
            } else {
                view2 = null;
            }
            editorView.smp = (com.tencent.mm.plugin.story.ui.view.editor.item.f) view2;
            com.tencent.mm.plugin.story.ui.view.editor.item.f e = this.smw.smp;
            if (e != null) {
                e.setVisibility(8);
                this.smw.a(true, e.getText(), e.getColor(), e.getTextBg());
                AppMethodBeat.o(110577);
                return;
            }
            AppMethodBeat.o(110577);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$Companion;", "", "()V", "PanelAudio", "", "PanelControl", "PanelEmoji", "PanelInput", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ EditorView smw;

        c(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110582);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            EditorControlPanel a = this.smw.smb;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            a.setShow(booleanValue);
            y yVar = y.AUy;
            AppMethodBeat.o(110582);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(110612);
        AppMethodBeat.o(110612);
    }

    public EditorView(final Context context, AttributeSet attributeSet, int i) {
        int i2;
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110610);
        this.TAG = "MicroMsg.EditorView";
        this.smk = new cei();
        this.hNp = true;
        this.smn = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.smo = 3000;
        this.rYq = true;
        View.inflate(context, R.layout.ayg, this);
        this.sml = getResources().getColor(R.color.a7);
        this.smm = context.getResources().getDrawable(R.raw.popvideo_post_selected);
        View findViewById = findViewById(R.id.eta);
        j.o(findViewById, "findViewById(R.id.editor_video_play_view)");
        this.oxL = (VideoPlayerTextureView) findViewById;
        findViewById = findViewById(R.id.etb);
        j.o(findViewById, "findViewById(R.id.story_editor_control_panel)");
        this.smb = (EditorControlPanel) findViewById;
        findViewById = findViewById(R.id.esz);
        j.o(findViewById, "findViewById(R.id.story_editor_add_emoji)");
        this.slU = (ImageView) findViewById;
        findViewById = findViewById(R.id.et0);
        j.o(findViewById, "findViewById(R.id.story_editor_add_text)");
        this.slV = (ImageView) findViewById;
        findViewById = findViewById(R.id.et1);
        j.o(findViewById, "findViewById(R.id.story_editor_add_audio)");
        this.slW = (ImageView) findViewById;
        findViewById = findViewById(R.id.et3);
        j.o(findViewById, "findViewById(R.id.story_editor_add_location)");
        this.slX = (ImageView) findViewById;
        findViewById = findViewById(R.id.et2);
        j.o(findViewById, "findViewById(R.id.story_editor_add_audio_check)");
        this.slZ = (ImageView) findViewById;
        findViewById = findViewById(R.id.et4);
        j.o(findViewById, "findViewById(R.id.story_editor_add_location_check)");
        this.sma = (ImageView) findViewById;
        findViewById = findViewById(R.id.esw);
        j.o(findViewById, "findViewById(R.id.story_editor_control_layout)");
        this.slY = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.esx);
        j.o(findViewById, "findViewById(R.id.editor_mix)");
        this.slT = findViewById;
        findViewById = findViewById(R.id.bdp);
        j.o(findViewById, "findViewById(R.id.editor_item_container)");
        this.smc = (EditorItemContainer) findViewById;
        findViewById = findViewById(R.id.bc_);
        j.o(findViewById, "findViewById(R.id.change_text_root)");
        this.smd = (EditorInputView) findViewById;
        findViewById = findViewById(R.id.etc);
        j.o(findViewById, "findViewById(R.id.story_editor_audio_panel)");
        this.smf = (EditorAudioView) findViewById;
        findViewById = findViewById(R.id.ess);
        j.o(findViewById, "findViewById(R.id.story_editor_more)");
        this.rnO = (ImageView) findViewById;
        findViewById = findViewById(R.id.est);
        j.o(findViewById, "findViewById(R.id.story_editor_fav_tip)");
        this.smg = (ImageView) findViewById;
        findViewById = findViewById(R.id.esu);
        j.o(findViewById, "findViewById(R.id.story_editor_sns_tip)");
        this.smh = (ImageView) findViewById;
        this.smg.setImageDrawable(ah.f(context, R.raw.icons_filled_star, -1));
        this.smh.setImageDrawable(ah.f(context, R.raw.icons_filled_moment_off, -1));
        this.rnO.setImageDrawable(ah.f(context, R.raw.icons_filled_more, -1));
        if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxh() || com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            this.rnO.setVisibility(0);
        } else {
            this.rnO.setVisibility(8);
        }
        ImageView imageView = this.slW;
        if (((com.tencent.mm.plugin.story.c.a.a.a) com.tencent.mm.plugin.story.c.a.a.rQZ.Uw()).rRg) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.slU.setOnClickListener(new AnonymousClass1(this));
        this.slV.setOnClickListener(new AnonymousClass5(this));
        this.slW.setOnClickListener(new AnonymousClass6(this));
        this.smc.setOnLocationClick(new AnonymousClass7(this));
        this.smc.setOnTextClick(new AnonymousClass8(this));
        this.slX.setOnClickListener(new AnonymousClass9(this));
        this.slT.setOnClickListener(new AnonymousClass10(this));
        ImageView imageView2 = (ImageView) findViewById(R.id.esr);
        imageView2.setOnClickListener(new AnonymousClass11(this));
        this.rnO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EditorView smw;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$12$2 */
            static final class AnonymousClass2 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass12 smx;

                AnonymousClass2(AnonymousClass12 anonymousClass12) {
                    this.smx = anonymousClass12;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138931);
                    EditorView.m(this.smx.smw);
                    y yVar = y.AUy;
                    AppMethodBeat.o(138931);
                    return yVar;
                }
            }

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$12$1 */
            static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass12 smx;

                AnonymousClass1(AnonymousClass12 anonymousClass12) {
                    this.smx = anonymousClass12;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138930);
                    EditorView.l(this.smx.smw);
                    y yVar = y.AUy;
                    AppMethodBeat.o(138930);
                    return yVar;
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138932);
                c k = this.smw.sms;
                if (k != null) {
                    k.dismiss();
                }
                this.smw.sms = new c(context);
                k = this.smw.sms;
                if (k != null) {
                    k.slQ = this.smw.rYq;
                }
                k = this.smw.sms;
                if (k != null) {
                    k.rYr = this.smw.smq;
                }
                c k2 = this.smw.sms;
                if (k2 != null) {
                    k2.slP = new AnonymousClass1(this);
                }
                k2 = this.smw.sms;
                if (k2 != null) {
                    k2.slO = new AnonymousClass2(this);
                }
                k = this.smw.sms;
                if (k != null) {
                    k.show();
                    AppMethodBeat.o(138932);
                    return;
                }
                AppMethodBeat.o(138932);
            }
        });
        this.smc.setDeleteStateListener(new AnonymousClass2(this));
        this.smd.setOnVisibleChangeCallback(new AnonymousClass3(this));
        this.smd.setCallback(new AnonymousClass4(this));
        this.sme = new com.tencent.mm.media.editor.b.a(context, this);
        this.sme.eUw = new e(this);
        com.tencent.mm.media.editor.b.a aVar = this.sme;
        com.tencent.mm.api.t.a fVar = new f(this);
        j.p(fVar, "callback");
        t AH = com.tencent.mm.api.u.AH();
        j.o(AH, "callbackWrapper");
        AH.a(fVar);
        aVar.eAk.setCallback(AH);
        this.smf.setOnVisibleChangeCallback(new c(this));
        this.smf.setCallback(new d(this));
        this.slU.setImageDrawable(ah.f(context, R.raw.icons_filled_sticker, -1));
        this.slV.setImageDrawable(ah.f(context, R.raw.icons_filled_text, -1));
        this.slW.setImageDrawable(ah.f(context, R.raw.icons_filled_music, -1));
        this.slX.setImageDrawable(ah.f(context, R.raw.icons_filled_location, -1));
        imageView2.setImageDrawable(ah.f(context, R.raw.icons_filled_previous2, -1));
        this.sma.setImageDrawable(this.smm);
        this.slZ.setImageDrawable(this.smm);
        this.sma.setVisibility(8);
        this.slZ.setVisibility(8);
        this.smr = ak.fr(context);
        Point hy = ak.hy(getContext());
        int i3 = hy.y;
        i2 = hy.x;
        float f = ((float) i3) / ((float) i2);
        float f2 = (float) i3;
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        f2 /= com.tencent.mm.plugin.story.h.a.sdg;
        float f3 = (((float) i2) - f2) / 2.0f;
        float f4 = (float) i2;
        com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
        f4 *= com.tencent.mm.plugin.story.h.a.sdf;
        float f5 = (((float) i3) - f4) / 2.0f;
        aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
        if (f <= com.tencent.mm.plugin.story.h.a.sdf) {
            this.smd.bd(f3);
            this.smc.ac(f2, f3);
        } else {
            aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
            if (f >= com.tencent.mm.plugin.story.h.a.sdg) {
                this.smc.ad(f4, f5);
            } else {
                this.smd.bd(f3);
                this.smc.ac(f2, f3);
                this.smc.ad(f4, f5);
            }
        }
        this.smu = new i(this);
        AppMethodBeat.o(110610);
    }

    public EditorView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110611);
        AppMethodBeat.o(110611);
    }

    public final com.tencent.mm.plugin.story.d.b.a getPresenter() {
        AppMethodBeat.i(110595);
        com.tencent.mm.plugin.story.d.b.a aVar = this.slS;
        if (aVar == null) {
            j.avw("presenter");
        }
        AppMethodBeat.o(110595);
        return aVar;
    }

    public final void setPresenter(com.tencent.mm.plugin.story.d.b.a aVar) {
        AppMethodBeat.i(110596);
        j.p(aVar, "<set-?>");
        this.slS = aVar;
        AppMethodBeat.o(110596);
    }

    public final void setMusicPlayer(v vVar) {
        AppMethodBeat.i(110597);
        j.p(vVar, "player");
        this.smf.setMusicPlayer(vVar);
        AppMethodBeat.o(110597);
    }

    public final void cCA() {
        AppMethodBeat.i(110598);
        Intent intent = new Intent();
        if (this.smc.cCB()) {
            intent.putExtra("get_poi_classify_id", this.smk.wCC);
        }
        intent.putExtra("get_poi_from_scene", "story");
        intent.putExtra("poi_show_none", false);
        intent.putExtra("select_radio_icon_color", "#0E9CE6");
        com.tencent.mm.bp.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 1003);
        AppMethodBeat.o(110598);
    }

    public final cei getLocation() {
        AppMethodBeat.i(110599);
        cei cei;
        if (this.hNp) {
            cei = this.smk;
            AppMethodBeat.o(110599);
            return cei;
        }
        cei = new cei();
        AppMethodBeat.o(110599);
        return cei;
    }

    public final void a(String str, long j, long j2, a.f.a.a<y> aVar) {
        AppMethodBeat.i(110600);
        j.p(str, "videoPath");
        this.oxL.setVideoCallback(this.smu);
        this.oxL.setVideoPath(str);
        this.oxL.setAlpha(0.0f);
        this.lnp = aVar;
        this.smi = ((double) j) / 1000.0d;
        this.smj = ((double) j2) / 1000.0d;
        EditorAudioView editorAudioView = this.smf;
        j.p(str, "videoPath");
        editorAudioView.sle = false;
        editorAudioView.sld = new com.tencent.mm.plugin.story.model.audio.f(str, j, j2);
        com.tencent.mm.plugin.story.model.audio.f fVar = editorAudioView.sld;
        if (fVar != null) {
            fVar.exD = new g(editorAudioView);
        }
        editorAudioView.slb.setSelection(Integer.valueOf(-1));
        ArrayList arrayList = new ArrayList();
        if (editorAudioView.slb.llU != 0) {
            editorAudioView.slb.setSelection(Integer.valueOf(-1));
        }
        com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2 = AudioCacheInfo.rUj;
        AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
        audioCacheInfo.type = AudioCacheInfo.rUf;
        arrayList.add(audioCacheInfo);
        editorAudioView.slb.dG(arrayList);
        this.hNp = false;
        this.smc.f((a.f.a.a) h.smz);
        AppMethodBeat.o(110600);
    }

    public final VideoPlayerTextureView getVideoPlayView() {
        return this.oxL;
    }

    public final EditorItemContainer getItemContainer() {
        return this.smc;
    }

    public final boolean aFF() {
        AppMethodBeat.i(110601);
        if (getVisibility() == 0) {
            AppMethodBeat.o(110601);
            return true;
        }
        AppMethodBeat.o(110601);
        return false;
    }

    public final void a(boolean z, CharSequence charSequence, int i, int i2) {
        boolean z2 = true;
        AppMethodBeat.i(110602);
        if (z) {
            this.smd.setShow(true);
            EditorInputView editorInputView = this.smd;
            editorInputView.slx.setText(charSequence);
            if (charSequence != null) {
                editorInputView.slx.setSelection(charSequence.length());
            }
            if (i2 == 0) {
                z2 = false;
            }
            editorInputView.slB = z2;
            if (editorInputView.slB) {
                i = i2 | (EditorInputView.slD ^ -1);
            }
            editorInputView.setSelectedIndex(a.a.i.k(EditorInputView.sjN, i));
            editorInputView.lnw.setSelected(editorInputView.biG);
            editorInputView.lnD = false;
            editorInputView.slz.setActivated(editorInputView.slB);
            editorInputView.cCx();
            AppMethodBeat.o(110602);
            return;
        }
        this.smd.setShow(false);
        AppMethodBeat.o(110602);
    }

    public final boolean bmC() {
        AppMethodBeat.i(110603);
        if (this.sme.eAj.getVisibility() == 0) {
            AppMethodBeat.o(110603);
            return true;
        }
        AppMethodBeat.o(110603);
        return false;
    }

    public final void gC(boolean z) {
        AppMethodBeat.i(110604);
        if (z) {
            this.sme.setShow(true);
            AppMethodBeat.o(110604);
            return;
        }
        this.sme.setShow(false);
        AppMethodBeat.o(110604);
    }

    public final void reset() {
        AppMethodBeat.i(110606);
        this.rYq = true;
        this.smq = false;
        EditorItemContainer editorItemContainer = this.smc;
        editorItemContainer.lnI.removeAllViews();
        editorItemContainer.gI(false);
        EditorAudioView editorAudioView = this.smf;
        editorAudioView.rYp = false;
        editorAudioView.slf = true;
        editorAudioView.skW.setImageDrawable(ah.f(editorAudioView.getContext(), R.raw.ui_rescoures_checkbox_selected, -1));
        editorAudioView.skX.setImageDrawable(ah.f(editorAudioView.getContext(), R.raw.ui_rescoures_checkbox_selected, -1));
        editorAudioView.sla.reset();
        this.hNp = false;
        this.sma.setVisibility(8);
        this.slZ.setVisibility(8);
        this.smh.setVisibility(8);
        this.smg.setVisibility(8);
        this.smc.f((a.f.a.a) g.smy);
        AppMethodBeat.o(110606);
    }

    public final void destroy() {
        AppMethodBeat.i(110607);
        this.oxL.stop();
        this.sme.eAk.destroy();
        AppMethodBeat.o(110607);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(110608);
        super.setVisibility(i);
        this.oxL.setVisibility(i);
        AppMethodBeat.o(110608);
    }

    public final long getMusicRequestId() {
        AppMethodBeat.i(110609);
        long musicRequestId = this.smf.getMusicRequestId();
        AppMethodBeat.o(110609);
        return musicRequestId;
    }

    public final boolean cxq() {
        int i;
        CharSequence charSequence = null;
        AppMethodBeat.i(110605);
        if (this.smd.getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            a(false, null, 0, 0);
            AppMethodBeat.o(110605);
            return true;
        } else if (bmC()) {
            gC(false);
            AppMethodBeat.o(110605);
            return true;
        } else if (this.smf.aFF()) {
            int i2;
            EditorAudioView editorAudioView = this.smf;
            EditorAudioSearchView editorAudioSearchView = editorAudioView.sla;
            if (editorAudioSearchView.getVisibility() == 0) {
                EditText editText = editorAudioSearchView.skC;
                if (editText != null) {
                    charSequence = editText.getText();
                }
                if (bo.ac(charSequence)) {
                    editorAudioSearchView.cCr();
                } else {
                    editorAudioSearchView.cCu();
                    com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.rUw.cH(1);
                    aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.a.cyU();
                    editorAudioSearchView.reset();
                    com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.a aVar2 = editorAudioSearchView.skP;
                    if (aVar2 != null) {
                        aVar2.cCv();
                    }
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                editorAudioView.setShow(false);
            }
            AppMethodBeat.o(110605);
            return true;
        } else {
            AppMethodBeat.o(110605);
            return false;
        }
    }

    public static final /* synthetic */ void d(EditorView editorView) {
        AppMethodBeat.i(110613);
        editorView.smf.setShow(true);
        AppMethodBeat.o(110613);
    }

    public static final /* synthetic */ void l(EditorView editorView) {
        boolean z;
        AppMethodBeat.i(138933);
        if (editorView.smq) {
            z = false;
        } else {
            z = true;
        }
        editorView.smq = z;
        com.tencent.mm.plugin.story.d.b.a aVar = editorView.slS;
        if (aVar == null) {
            j.avw("presenter");
        }
        aVar.lv(editorView.smq);
        if (editorView.smq) {
            editorView.smg.setVisibility(0);
            AppMethodBeat.o(138933);
            return;
        }
        editorView.smg.setVisibility(8);
        AppMethodBeat.o(138933);
    }

    public static final /* synthetic */ void m(EditorView editorView) {
        boolean z;
        AppMethodBeat.i(138934);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.EU(16);
        if (editorView.rYq) {
            z = false;
        } else {
            z = true;
        }
        editorView.rYq = z;
        com.tencent.mm.plugin.story.d.b.a aVar = editorView.slS;
        if (aVar == null) {
            j.avw("presenter");
        }
        aVar.lu(editorView.rYq);
        if (editorView.rYq) {
            editorView.smh.setVisibility(8);
            AppMethodBeat.o(138934);
            return;
        }
        editorView.smh.setVisibility(0);
        AppMethodBeat.o(138934);
    }
}
