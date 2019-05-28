package com.tencent.p177mm.plugin.story.p536ui.view.editor;

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
import com.google.android.exoplayer2.C0884v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.media.editor.p1202b.C18590a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.model.audio.C22219b;
import com.tencent.p177mm.plugin.story.model.audio.C22219b.C13771a;
import com.tencent.p177mm.plugin.story.model.audio.C22222f;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a.C13738a;
import com.tencent.p177mm.plugin.story.p1034d.C43629b.C13742b;
import com.tencent.p177mm.plugin.story.p1034d.C43629b.C29280a;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorAudioSearchView.C29347a;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorAudioView.C24836g;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorAudioView.C29359a;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorInputView.C22301b;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorInputView.C4164a;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C39930f;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C46925b;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005*\u0001C\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0002yzB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010M\u001a\u00020(H\u0016J\b\u0010N\u001a\u00020LH\u0002J\b\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020LH\u0016J\b\u0010R\u001a\u00020+H\u0016J\b\u0010S\u001a\u00020AH\u0016J\u0012\u0010T\u001a\u00020L2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020\rH\u0016J\b\u0010X\u001a\u00020IH\u0016J\b\u0010Y\u001a\u00020LH\u0002J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0002J\b\u0010\\\u001a\u00020(H\u0016J\b\u0010]\u001a\u00020(H\u0002J\b\u0010^\u001a\u00020(H\u0016J\b\u0010_\u001a\u00020(H\u0016J\"\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010c\u001a\u00020L2\b\u0010d\u001a\u0004\u0018\u00010AH\u0002J\b\u0010e\u001a\u00020LH\u0016J\b\u0010f\u001a\u00020LH\u0002J\u0010\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020LH\u0002J\u0010\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020\nH\u0016J0\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\r2\u0006\u0010p\u001a\u00020\r2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0016J\u0010\u0010q\u001a\u00020L2\u0006\u0010r\u001a\u00020(H\u0002J\u0010\u0010s\u001a\u00020L2\u0006\u0010r\u001a\u00020(H\u0016J*\u0010t\u001a\u00020L2\u0006\u0010r\u001a\u00020(2\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010<\u001a\b\u0018\u00010=R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0004¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010E\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CLICK_LIMIT_TIME", "", "DEFAULT_NOTIFY_MOMENT_DURATION", "TAG", "", "addAudioCheckView", "Landroid/widget/ImageView;", "addAudioView", "addEmojiView", "addLocation", "addLocationCheckView", "addTextView", "audioPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "blueCheckDrawable", "Landroid/graphics/drawable/Drawable;", "blueColor", "clickTime", "controlGroupPanel", "Landroid/view/ViewGroup;", "controlPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "emojiPanel", "Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "favoriteTip", "inputPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "isNotifyMoment", "", "isSetFavorite", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "mixView", "Landroid/view/View;", "moreBtn", "navigationBarHeight", "pendingTextItem", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "poiService", "Lcom/tencent/mm/plugin/story/api/ICheckLifePoi;", "presenter", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;)V", "reportArg", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$ReportInfo;", "showLocation", "snsTip", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "videoCallBack", "com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1;", "videoLoopEndTime", "", "videoLoopStartTime", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "videoPreparedCallback", "Lkotlin/Function0;", "", "back", "checkFavorite", "checkLocation", "checkMoment", "destroy", "getItemContainer", "getLocation", "getLocationResult", "data", "Landroid/content/Intent;", "getMusicRequestId", "getVideoPlayView", "initAudioPanel", "initSafeArea", "initSmileyPanel", "isShow", "isShowAudioPanel", "isShowSmileyPanel", "isShowTextEditor", "onActivityResult", "requestCode", "resultCode", "reportDirectly", "location", "reset", "setFavStory", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setNotifySns", "setVisibility", "visibility", "setup", "videoPath", "startTime", "endTime", "toggleAudioPanel", "show", "toggleSmileyPanel", "toggleTextEditor", "text", "", "textColor", "textBgColor", "Companion", "ReportInfo", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView */
public final class EditorView extends RelativeLayout implements C13742b {
    public static final C16893a smv = new C16893a();
    public final String TAG;
    private boolean hNp;
    private long iBO;
    private C31214a<C37091y> lnp;
    private final VideoPlayerTextureView oxL;
    private boolean rYq;
    private final ImageView rnO;
    public C29280a slS;
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
    private final C18590a sme;
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
    private C39930f smp;
    private boolean smq;
    private int smr;
    private C29362c sms;
    public C16891b smt;
    private final C16886i smu;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$10 */
    static final class C416510 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C416510(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110579);
            if (System.currentTimeMillis() - this.smw.iBO <= this.smw.smo) {
                C4990ab.m7416i(this.smw.TAG, "onclick pass " + this.smw.iBO + " now: " + System.currentTimeMillis() + " notifySns:" + this.smw.rYq);
                AppMethodBeat.m2505o(110579);
                return;
            }
            C8901a c8901a = new C8901a("mixView");
            this.smw.iBO = System.currentTimeMillis();
            this.smw.getPresenter().cxp();
            this.smw.getPresenter().bmz();
            EditorView.m26035a(this.smw, this.smw.smk);
            C46273e c46273e = C46273e.sbS;
            C46273e.m86709lC(this.smw.smq);
            c46273e = C46273e.sbS;
            C46273e.m86711lE(this.smw.rYq);
            C4990ab.m7416i(this.smw.TAG, "onclick " + c8901a.eOm.mo4908Mr());
            AppMethodBeat.m2505o(110579);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$9 */
    static final class C138709 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C138709(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110578);
            this.smw.cCA();
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(10);
            AppMethodBeat.m2505o(110578);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initAudioPanel$2", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "pauseAudio", "toggleOrigin", "remove", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$d */
    public static final class C13871d implements C29359a {
        final /* synthetic */ EditorView smw;

        C13871d(EditorView editorView) {
            this.smw = editorView;
        }

        public final void pauseAudio() {
            AppMethodBeat.m2504i(110583);
            this.smw.getPresenter().pauseAudio();
            AppMethodBeat.m2505o(110583);
        }

        /* renamed from: d */
        public final void mo26043d(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.m2504i(110584);
            if (audioCacheInfo != null) {
                int i = audioCacheInfo.type;
                C4123a c4123a = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUd) {
                    this.smw.getPresenter().pauseAudio();
                    AppMethodBeat.m2505o(110584);
                    return;
                }
            }
            this.smw.getPresenter().mo47475a(audioCacheInfo);
            AppMethodBeat.m2505o(110584);
        }

        /* renamed from: lO */
        public final void mo26044lO(boolean z) {
            AppMethodBeat.m2504i(110585);
            this.smw.getPresenter().mo47478lt(z);
            AppMethodBeat.m2505o(110585);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initSmileyPanel$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$f */
    public static final class C13872f implements C17917a {
        final /* synthetic */ EditorView smw;

        C13872f(EditorView editorView) {
            this.smw = editorView;
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(110587);
            C25052j.m39376p(c8955k, "emojiInfo");
            C4990ab.m7417i(this.smw.TAG, "[onSelectedEmoji] emojiInfo:%s", c8955k);
            EditorItemContainer c = this.smw.smc;
            EmojiInfo emojiInfo = (EmojiInfo) c8955k;
            C25052j.m39376p(emojiInfo, "emojiInfo");
            C46925b c46925b = new C46925b(c.getContext(), false);
            c.lnI.addView(c46925b, new LayoutParams(-1, -1));
            C22210l c22210l = C22210l.sac;
            c46925b.setSafeArea(C22210l.czI());
            c46925b.setValidArea(c.smH);
            c46925b.setStateResolve(c.smU);
            c46925b.setEmojiInfo(emojiInfo);
            c46925b.resume();
            c.mo37837r(c46925b, true);
            c.removeCallbacks(c.lnN);
            c.postDelayed(c.lnN, 1500);
            onHide();
            AppMethodBeat.m2505o(110587);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(110588);
            this.smw.mo30862gC(false);
            AppMethodBeat.m2505o(110588);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$g */
    static final class C13873g extends C25053k implements C31214a<C37091y> {
        public static final C13873g smy = new C13873g();

        static {
            AppMethodBeat.m2504i(110589);
            AppMethodBeat.m2505o(110589);
        }

        C13873g() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$12", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$4 */
    public static final class C168764 implements C4164a {
        final /* synthetic */ EditorView smw;

        C168764(EditorView editorView) {
            this.smw = editorView;
        }

        /* renamed from: e */
        public final void mo9049e(CharSequence charSequence, int i, int i2) {
            AppMethodBeat.m2504i(138928);
            if (this.smw.smp != null) {
                C39930f e = this.smw.smp;
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
                int i3 = (charSequence == null || C6163u.m9837ar(charSequence)) ? true : 0;
                if (i3 == 0) {
                    C39930f c39930f = new C39930f(c.getContext());
                    c.lnI.addView(c39930f, new LayoutParams(-1, -1));
                    C22210l c22210l = C22210l.sac;
                    c39930f.setSafeArea(C22210l.czI());
                    c39930f.setValidArea(c.smH);
                    c39930f.setStateResolve(c.smU);
                    c39930f.setText(charSequence, i, i2);
                    c39930f.setOnClickListener(c.smT);
                    c.mo37837r(c39930f, true);
                    c.removeCallbacks(c.lnN);
                    c.postDelayed(c.lnN, 1500);
                }
            }
            this.smw.mo30859a(false, null, 0, 0);
            AppMethodBeat.m2505o(138928);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(138929);
            C39930f e = this.smw.smp;
            if (e != null) {
                e.setVisibility(0);
            }
            this.smw.smp = null;
            this.smw.mo30859a(false, null, 0, 0);
            AppMethodBeat.m2505o(138929);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$2 */
    static final class C168772 extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ EditorView smw;

        C168772(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110571);
            if (((Boolean) obj).booleanValue()) {
                this.smw.smb.setShow(false);
            } else {
                this.smw.smb.setShow(true);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110571);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$3 */
    static final class C168783 extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ EditorView smw;

        C168783(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(138927);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.smw.smb.requestLayout();
            this.smw.smb.setShow(!booleanValue);
            if (!booleanValue) {
                C39930f e = this.smw.smp;
                if (e != null) {
                    e.setVisibility(0);
                }
                this.smw.smp = null;
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138927);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$e */
    static final class C16879e extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ EditorView smw;

        C16879e(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110586);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            EditorControlPanel a = this.smw.smb;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            a.setShow(booleanValue);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110586);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$h */
    static final class C16880h extends C25053k implements C31214a<C37091y> {
        public static final C16880h smz = new C16880h();

        static {
            AppMethodBeat.m2504i(110590);
            AppMethodBeat.m2505o(110590);
        }

        C16880h() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$11 */
    static final class C1688111 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C1688111(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110580);
            this.smw.getPresenter().mo47474Ab();
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(12);
            AppMethodBeat.m2505o(110580);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$1 */
    static final class C168851 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C168851(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110570);
            this.smw.mo30862gC(!this.smw.bmC());
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(6);
            AppMethodBeat.m2505o(110570);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$i */
    public static final class C16886i implements C14981a {
        final /* synthetic */ EditorView smw;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$i$a */
        static final class C16887a implements C14980e {
            final /* synthetic */ C16886i smA;

            C16887a(C16886i c16886i) {
                this.smA = c16886i;
            }

            public final void bQL() {
                AppMethodBeat.m2504i(110591);
                this.smA.smw.oxL.setVisibility(0);
                C31214a o = this.smA.smw.lnp;
                if (o != null) {
                    o.invoke();
                }
                this.smA.smw.oxL.setAlpha(1.0f);
                AppMethodBeat.m2505o(110591);
            }
        }

        C16886i(EditorView editorView) {
            this.smw = editorView;
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(110592);
            this.smw.oxL.setOneTimeVideoTextureUpdateCallback(new C16887a(this));
            double p = this.smw.smi >= 0.0d ? this.smw.smi : 0.0d;
            C4990ab.m7416i(this.smw.TAG, "onPrepared, startTime:".concat(String.valueOf(p)));
            if (p > 0.0d) {
                this.smw.oxL.mo27356d(p * 1000.0d, true);
                AppMethodBeat.m2505o(110592);
                return;
            }
            this.smw.oxL.start();
            AppMethodBeat.m2505o(110592);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            double d = 0.0d;
            AppMethodBeat.m2504i(110593);
            if (this.smw.smi >= 0.0d) {
                d = this.smw.smi;
            }
            C4990ab.m7416i(this.smw.TAG, "onCompletion, seekTo startTime: " + this.smw.smi);
            this.smw.oxL.mo27356d(d * 1000.0d, true);
            this.smw.getPresenter();
            AppMethodBeat.m2505o(110593);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            double d = 0.0d;
            AppMethodBeat.m2504i(110594);
            if (this.smw.smj > 0.0d && ((double) i) >= this.smw.smj * 1000.0d) {
                if (this.smw.smi >= 0.0d) {
                    d = this.smw.smi;
                }
                C4990ab.m7416i(this.smw.TAG, "onPlayTime, reach loop endtime:" + this.smw.smj + ", startTime:" + d);
                this.smw.oxL.mo27356d(d * 1000.0d, true);
            }
            AppMethodBeat.m2505o(110594);
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$5 */
    static final class C168885 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C168885(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110574);
            EditorView editorView = this.smw;
            CharSequence charSequence = "";
            C22301b c22301b = EditorInputView.slG;
            int cCy = EditorInputView.slE;
            C22301b c22301b2 = EditorInputView.slG;
            editorView.mo30859a(true, charSequence, cCy, EditorInputView.slF);
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(8);
            AppMethodBeat.m2505o(110574);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$6 */
    static final class C168896 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C168896(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110575);
            EditorView.m26038d(this.smw);
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(5);
            AppMethodBeat.m2505o(110575);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$7 */
    static final class C168907 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C168907(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110576);
            this.smw.cCA();
            AppMethodBeat.m2505o(110576);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$ReportInfo;", "", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;)V", "entryTime", "", "getEntryTime", "()I", "setEntryTime", "(I)V", "firstStartStamp", "", "getFirstStartStamp", "()J", "setFirstStartStamp", "(J)V", "firstSuccStamp", "getFirstSuccStamp", "setFirstSuccStamp", "index", "getIndex", "setIndex", "lastSuccStamp", "getLastSuccStamp", "setLastSuccStamp", "reqLoadCnt", "getReqLoadCnt", "setReqLoadCnt", "searchId", "", "getSearchId", "()Ljava/lang/String;", "setSearchId", "(Ljava/lang/String;)V", "feed", "", "data", "Landroid/content/Intent;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$b */
    public final class C16891b {
        public String hlm = "";
        public int index;
        public int nPQ;
        public long oRM = -1;
        public long oRN = -1;
        public long oRO = -1;
        public int oRP;
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$8 */
    static final class C168928 implements OnClickListener {
        final /* synthetic */ EditorView smw;

        C168928(EditorView editorView) {
            this.smw = editorView;
        }

        public final void onClick(View view) {
            View view2;
            AppMethodBeat.m2504i(110577);
            EditorView editorView = this.smw;
            if (view instanceof C39930f) {
                view2 = view;
            } else {
                view2 = null;
            }
            editorView.smp = (C39930f) view2;
            C39930f e = this.smw.smp;
            if (e != null) {
                e.setVisibility(8);
                this.smw.mo30859a(true, e.getText(), e.getColor(), e.getTextBg());
                AppMethodBeat.m2505o(110577);
                return;
            }
            AppMethodBeat.m2505o(110577);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$Companion;", "", "()V", "PanelAudio", "", "PanelControl", "PanelEmoji", "PanelInput", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$a */
    public static final class C16893a {
        private C16893a() {
        }

        public /* synthetic */ C16893a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$c */
    static final class C16894c extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ EditorView smw;

        C16894c(EditorView editorView) {
            this.smw = editorView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110582);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            EditorControlPanel a = this.smw.smb;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            a.setShow(booleanValue);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110582);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(110612);
        AppMethodBeat.m2505o(110612);
    }

    public EditorView(final Context context, AttributeSet attributeSet, int i) {
        int i2;
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110610);
        this.TAG = "MicroMsg.EditorView";
        this.smk = new cei();
        this.hNp = true;
        this.smn = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.smo = 3000;
        this.rYq = true;
        View.inflate(context, 2130970880, this);
        this.sml = getResources().getColor(C25738R.color.f11644a7);
        this.smm = context.getResources().getDrawable(C1318a.popvideo_post_selected);
        View findViewById = findViewById(2131828139);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_video_play_view)");
        this.oxL = (VideoPlayerTextureView) findViewById;
        findViewById = findViewById(2131828140);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_control_panel)");
        this.smb = (EditorControlPanel) findViewById;
        findViewById = findViewById(2131828127);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_emoji)");
        this.slU = (ImageView) findViewById;
        findViewById = findViewById(2131828128);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_text)");
        this.slV = (ImageView) findViewById;
        findViewById = findViewById(2131828129);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_audio)");
        this.slW = (ImageView) findViewById;
        findViewById = findViewById(2131828131);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_location)");
        this.slX = (ImageView) findViewById;
        findViewById = findViewById(2131828130);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_audio_check)");
        this.slZ = (ImageView) findViewById;
        findViewById = findViewById(2131828132);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_add_location_check)");
        this.sma = (ImageView) findViewById;
        findViewById = findViewById(2131828124);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_control_layout)");
        this.slY = (ViewGroup) findViewById;
        findViewById = findViewById(2131828125);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_mix)");
        this.slT = findViewById;
        findViewById = findViewById(2131823456);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_item_container)");
        this.smc = (EditorItemContainer) findViewById;
        findViewById = findViewById(2131823403);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_root)");
        this.smd = (EditorInputView) findViewById;
        findViewById = findViewById(2131828141);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_audio_panel)");
        this.smf = (EditorAudioView) findViewById;
        findViewById = findViewById(2131828120);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_more)");
        this.rnO = (ImageView) findViewById;
        findViewById = findViewById(2131828121);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_fav_tip)");
        this.smg = (ImageView) findViewById;
        findViewById = findViewById(2131828122);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_sns_tip)");
        this.smh = (ImageView) findViewById;
        this.smg.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_star, -1));
        this.smh.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_moment_off, -1));
        this.rnO.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_more, -1));
        if (C29274a.rQZ.cxh() || C29274a.rQZ.cwU()) {
            this.rnO.setVisibility(0);
        } else {
            this.rnO.setVisibility(8);
        }
        ImageView imageView = this.slW;
        if (((C13738a) C29274a.rQZ.mo53288Uw()).rRg) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.slU.setOnClickListener(new C168851(this));
        this.slV.setOnClickListener(new C168885(this));
        this.slW.setOnClickListener(new C168896(this));
        this.smc.setOnLocationClick(new C168907(this));
        this.smc.setOnTextClick(new C168928(this));
        this.slX.setOnClickListener(new C138709(this));
        this.slT.setOnClickListener(new C416510(this));
        ImageView imageView2 = (ImageView) findViewById(2131828119);
        imageView2.setOnClickListener(new C1688111(this));
        this.rnO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EditorView smw;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$12$2 */
            static final class C168832 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C1688212 smx;

                C168832(C1688212 c1688212) {
                    this.smx = c1688212;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138931);
                    EditorView.m26047m(this.smx.smw);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138931);
                    return c37091y;
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorView$12$1 */
            static final class C168841 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C1688212 smx;

                C168841(C1688212 c1688212) {
                    this.smx = c1688212;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138930);
                    EditorView.m26046l(this.smx.smw);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138930);
                    return c37091y;
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138932);
                C29362c k = this.smw.sms;
                if (k != null) {
                    k.dismiss();
                }
                this.smw.sms = new C29362c(context);
                k = this.smw.sms;
                if (k != null) {
                    k.slQ = this.smw.rYq;
                }
                k = this.smw.sms;
                if (k != null) {
                    k.rYr = this.smw.smq;
                }
                C29362c k2 = this.smw.sms;
                if (k2 != null) {
                    k2.slP = new C168841(this);
                }
                k2 = this.smw.sms;
                if (k2 != null) {
                    k2.slO = new C168832(this);
                }
                k = this.smw.sms;
                if (k != null) {
                    k.show();
                    AppMethodBeat.m2505o(138932);
                    return;
                }
                AppMethodBeat.m2505o(138932);
            }
        });
        this.smc.setDeleteStateListener(new C168772(this));
        this.smd.setOnVisibleChangeCallback(new C168783(this));
        this.smd.setCallback(new C168764(this));
        this.sme = new C18590a(context, this);
        this.sme.eUw = new C16879e(this);
        C18590a c18590a = this.sme;
        C17917a c13872f = new C13872f(this);
        C25052j.m39376p(c13872f, "callback");
        C17918t AH = C41757u.m73611AH();
        C25052j.m39375o(AH, "callbackWrapper");
        AH.mo33431a(c13872f);
        c18590a.eAk.setCallback(AH);
        this.smf.setOnVisibleChangeCallback(new C16894c(this));
        this.smf.setCallback(new C13871d(this));
        this.slU.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_sticker, -1));
        this.slV.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_text, -1));
        this.slW.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_music, -1));
        this.slX.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_location, -1));
        imageView2.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_previous2, -1));
        this.sma.setImageDrawable(this.smm);
        this.slZ.setImageDrawable(this.smm);
        this.sma.setVisibility(8);
        this.slZ.setVisibility(8);
        this.smr = C5230ak.m7988fr(context);
        Point hy = C5230ak.m7993hy(getContext());
        int i3 = hy.y;
        i2 = hy.x;
        float f = ((float) i3) / ((float) i2);
        float f2 = (float) i3;
        C35184a c35184a = C35183a.sdm;
        f2 /= C35183a.sdg;
        float f3 = (((float) i2) - f2) / 2.0f;
        float f4 = (float) i2;
        C35184a c35184a2 = C35183a.sdm;
        f4 *= C35183a.sdf;
        float f5 = (((float) i3) - f4) / 2.0f;
        c35184a2 = C35183a.sdm;
        if (f <= C35183a.sdf) {
            this.smd.mo37813bd(f3);
            this.smc.mo37827ac(f2, f3);
        } else {
            c35184a2 = C35183a.sdm;
            if (f >= C35183a.sdg) {
                this.smc.mo37828ad(f4, f5);
            } else {
                this.smd.mo37813bd(f3);
                this.smc.mo37827ac(f2, f3);
                this.smc.mo37828ad(f4, f5);
            }
        }
        this.smu = new C16886i(this);
        AppMethodBeat.m2505o(110610);
    }

    public EditorView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110611);
        AppMethodBeat.m2505o(110611);
    }

    public final C29280a getPresenter() {
        AppMethodBeat.m2504i(110595);
        C29280a c29280a = this.slS;
        if (c29280a == null) {
            C25052j.avw("presenter");
        }
        AppMethodBeat.m2505o(110595);
        return c29280a;
    }

    public final void setPresenter(C29280a c29280a) {
        AppMethodBeat.m2504i(110596);
        C25052j.m39376p(c29280a, "<set-?>");
        this.slS = c29280a;
        AppMethodBeat.m2505o(110596);
    }

    public final void setMusicPlayer(C0884v c0884v) {
        AppMethodBeat.m2504i(110597);
        C25052j.m39376p(c0884v, "player");
        this.smf.setMusicPlayer(c0884v);
        AppMethodBeat.m2505o(110597);
    }

    public final void cCA() {
        AppMethodBeat.m2504i(110598);
        Intent intent = new Intent();
        if (this.smc.cCB()) {
            intent.putExtra("get_poi_classify_id", this.smk.wCC);
        }
        intent.putExtra("get_poi_from_scene", "story");
        intent.putExtra("poi_show_none", false);
        intent.putExtra("select_radio_icon_color", "#0E9CE6");
        C25985d.m41468b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 1003);
        AppMethodBeat.m2505o(110598);
    }

    public final cei getLocation() {
        AppMethodBeat.m2504i(110599);
        cei cei;
        if (this.hNp) {
            cei = this.smk;
            AppMethodBeat.m2505o(110599);
            return cei;
        }
        cei = new cei();
        AppMethodBeat.m2505o(110599);
        return cei;
    }

    /* renamed from: a */
    public final void mo25946a(String str, long j, long j2, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(110600);
        C25052j.m39376p(str, "videoPath");
        this.oxL.setVideoCallback(this.smu);
        this.oxL.setVideoPath(str);
        this.oxL.setAlpha(0.0f);
        this.lnp = c31214a;
        this.smi = ((double) j) / 1000.0d;
        this.smj = ((double) j2) / 1000.0d;
        EditorAudioView editorAudioView = this.smf;
        C25052j.m39376p(str, "videoPath");
        editorAudioView.sle = false;
        editorAudioView.sld = new C22222f(str, j, j2);
        C22222f c22222f = editorAudioView.sld;
        if (c22222f != null) {
            c22222f.exD = new C24836g(editorAudioView);
        }
        editorAudioView.slb.setSelection(Integer.valueOf(-1));
        ArrayList arrayList = new ArrayList();
        if (editorAudioView.slb.llU != 0) {
            editorAudioView.slb.setSelection(Integer.valueOf(-1));
        }
        C4123a c4123a = AudioCacheInfo.rUj;
        AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
        audioCacheInfo.type = AudioCacheInfo.rUf;
        arrayList.add(audioCacheInfo);
        editorAudioView.slb.mo47523dG(arrayList);
        this.hNp = false;
        this.smc.mo37831f((C31214a) C16880h.smz);
        AppMethodBeat.m2505o(110600);
    }

    public final VideoPlayerTextureView getVideoPlayView() {
        return this.oxL;
    }

    public final EditorItemContainer getItemContainer() {
        return this.smc;
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(110601);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(110601);
            return true;
        }
        AppMethodBeat.m2505o(110601);
        return false;
    }

    /* renamed from: a */
    public final void mo30859a(boolean z, CharSequence charSequence, int i, int i2) {
        boolean z2 = true;
        AppMethodBeat.m2504i(110602);
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
            editorInputView.setSelectedIndex(C36913i.m61701k(EditorInputView.sjN, i));
            editorInputView.lnw.setSelected(editorInputView.biG);
            editorInputView.lnD = false;
            editorInputView.slz.setActivated(editorInputView.slB);
            editorInputView.cCx();
            AppMethodBeat.m2505o(110602);
            return;
        }
        this.smd.setShow(false);
        AppMethodBeat.m2505o(110602);
    }

    public final boolean bmC() {
        AppMethodBeat.m2504i(110603);
        if (this.sme.eAj.getVisibility() == 0) {
            AppMethodBeat.m2505o(110603);
            return true;
        }
        AppMethodBeat.m2505o(110603);
        return false;
    }

    /* renamed from: gC */
    public final void mo30862gC(boolean z) {
        AppMethodBeat.m2504i(110604);
        if (z) {
            this.sme.setShow(true);
            AppMethodBeat.m2505o(110604);
            return;
        }
        this.sme.setShow(false);
        AppMethodBeat.m2505o(110604);
    }

    public final void reset() {
        AppMethodBeat.m2504i(110606);
        this.rYq = true;
        this.smq = false;
        EditorItemContainer editorItemContainer = this.smc;
        editorItemContainer.lnI.removeAllViews();
        editorItemContainer.mo37832gI(false);
        EditorAudioView editorAudioView = this.smf;
        editorAudioView.rYp = false;
        editorAudioView.slf = true;
        editorAudioView.skW.setImageDrawable(C5225ah.m7962f(editorAudioView.getContext(), C1318a.ui_rescoures_checkbox_selected, -1));
        editorAudioView.skX.setImageDrawable(C5225ah.m7962f(editorAudioView.getContext(), C1318a.ui_rescoures_checkbox_selected, -1));
        editorAudioView.sla.reset();
        this.hNp = false;
        this.sma.setVisibility(8);
        this.slZ.setVisibility(8);
        this.smh.setVisibility(8);
        this.smg.setVisibility(8);
        this.smc.mo37831f((C31214a) C13873g.smy);
        AppMethodBeat.m2505o(110606);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(110607);
        this.oxL.stop();
        this.sme.eAk.destroy();
        AppMethodBeat.m2505o(110607);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(110608);
        super.setVisibility(i);
        this.oxL.setVisibility(i);
        AppMethodBeat.m2505o(110608);
    }

    public final long getMusicRequestId() {
        AppMethodBeat.m2504i(110609);
        long musicRequestId = this.smf.getMusicRequestId();
        AppMethodBeat.m2505o(110609);
        return musicRequestId;
    }

    public final boolean cxq() {
        int i;
        CharSequence charSequence = null;
        AppMethodBeat.m2504i(110605);
        if (this.smd.getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            mo30859a(false, null, 0, 0);
            AppMethodBeat.m2505o(110605);
            return true;
        } else if (bmC()) {
            mo30862gC(false);
            AppMethodBeat.m2505o(110605);
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
                if (C5046bo.m7519ac(charSequence)) {
                    editorAudioSearchView.cCr();
                } else {
                    editorAudioSearchView.cCu();
                    C13771a c13771a = C22219b.rUx;
                    C22219b.rUw.mo33694cH(1);
                    c13771a = C22219b.rUx;
                    C13771a.cyU();
                    editorAudioSearchView.reset();
                    C29347a c29347a = editorAudioSearchView.skP;
                    if (c29347a != null) {
                        c29347a.cCv();
                    }
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                editorAudioView.setShow(false);
            }
            AppMethodBeat.m2505o(110605);
            return true;
        } else {
            AppMethodBeat.m2505o(110605);
            return false;
        }
    }

    /* renamed from: d */
    public static final /* synthetic */ void m26038d(EditorView editorView) {
        AppMethodBeat.m2504i(110613);
        editorView.smf.setShow(true);
        AppMethodBeat.m2505o(110613);
    }

    /* renamed from: l */
    public static final /* synthetic */ void m26046l(EditorView editorView) {
        boolean z;
        AppMethodBeat.m2504i(138933);
        if (editorView.smq) {
            z = false;
        } else {
            z = true;
        }
        editorView.smq = z;
        C29280a c29280a = editorView.slS;
        if (c29280a == null) {
            C25052j.avw("presenter");
        }
        c29280a.mo47480lv(editorView.smq);
        if (editorView.smq) {
            editorView.smg.setVisibility(0);
            AppMethodBeat.m2505o(138933);
            return;
        }
        editorView.smg.setVisibility(8);
        AppMethodBeat.m2505o(138933);
    }

    /* renamed from: m */
    public static final /* synthetic */ void m26047m(EditorView editorView) {
        boolean z;
        AppMethodBeat.m2504i(138934);
        C22212h c22212h = C22212h.scu;
        C22212h.m33887EU(16);
        if (editorView.rYq) {
            z = false;
        } else {
            z = true;
        }
        editorView.rYq = z;
        C29280a c29280a = editorView.slS;
        if (c29280a == null) {
            C25052j.avw("presenter");
        }
        c29280a.mo47479lu(editorView.rYq);
        if (editorView.rYq) {
            editorView.smh.setVisibility(8);
            AppMethodBeat.m2505o(138934);
            return;
        }
        editorView.smh.setVisibility(0);
        AppMethodBeat.m2505o(138934);
    }
}
