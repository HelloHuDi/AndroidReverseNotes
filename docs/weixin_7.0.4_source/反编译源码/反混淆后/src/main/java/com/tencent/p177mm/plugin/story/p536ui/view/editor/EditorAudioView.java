package com.tencent.p177mm.plugin.story.p536ui.view.editor;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.p069v7.widget.C17491an;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.exoplayer2.C0884v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.view.InsectRelativeLayout;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.model.audio.C22219b;
import com.tencent.p177mm.plugin.story.model.audio.C22219b.C13771a;
import com.tencent.p177mm.plugin.story.model.audio.C22220d;
import com.tencent.p177mm.plugin.story.model.audio.C22222f;
import com.tencent.p177mm.plugin.story.model.audio.C22222f.C22223a;
import com.tencent.p177mm.plugin.story.model.audio.C29301c;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C29320e;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorAudioSearchView.C29347a;
import com.tencent.p177mm.protocal.protobuf.bqk;
import com.tencent.p177mm.protocal.protobuf.bql;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r*\u0001%\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u00101\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\u0006\u00105\u001a\u00020/J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020!H\u0016J\b\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020/J\u000e\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020BJ-\u0010C\u001a\u00020/2#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0016J\u0010\u0010F\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0002J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u0002072\u0006\u0010J\u001a\u000207J\u0010\u0010K\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0002J\u0010\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020!H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R+\u0010*\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "audioAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "audioRecycler", "Landroid/support/v7/widget/RecyclerView;", "audioSearchPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "audioTask", "Lcom/tencent/mm/plugin/story/model/audio/GetRecommendAudioTask;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;)V", "currentMusicPostion", "iconMuteMusic", "Landroid/widget/ImageView;", "iconMuteOrigin", "muteOrigin", "", "panel", "Landroid/view/View;", "scrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1;", "searchBtn", "searchIv", "taskFinished", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "withMusic", "addAudioList", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "back", "getMusicRequestId", "", "initAudioSearchPanel", "insectBottom", "bottom", "isShow", "refreshAudioList", "reset", "selectItem", "position", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setOnVisibleChangeCallback", "setShow", "show", "setShowAudioPanel", "setup", "videoPath", "startTime", "endTime", "showSearchPanel", "updateMusicMuteStatus", "music", "AudioCallback", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView */
public final class EditorAudioView extends InsectRelativeLayout {
    private final String TAG;
    private C17126b<? super Boolean, C37091y> eUw;
    boolean rYp;
    private final View skU;
    private final RecyclerView skV;
    final ImageView skW;
    final ImageView skX;
    private final ImageView skY;
    private final View skZ;
    final EditorAudioSearchView sla;
    final C29320e slb;
    private int slc;
    C22222f sld;
    boolean sle;
    boolean slf;
    private C29359a slg;
    private final C22296d slh;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$1 */
    static final class C138661 extends C25053k implements C31591m<Integer, AudioCacheInfo, C37091y> {
        final /* synthetic */ EditorAudioView sli;

        C138661(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(110508);
            int intValue = ((Number) obj).intValue();
            AudioCacheInfo audioCacheInfo = (AudioCacheInfo) obj2;
            C25052j.m39376p(audioCacheInfo, "info");
            if (intValue != this.sli.slb.getItemCount()) {
                C17480i layoutManager = this.sli.skV.getLayoutManager();
                if (layoutManager == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.m2505o(110508);
                    throw c44941v;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iR = linearLayoutManager.mo1781iR();
                int iT = linearLayoutManager.mo1783iT();
                int i = audioCacheInfo.type;
                C4123a c4123a = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUd) {
                    this.sli.skV.smoothScrollToPosition(intValue);
                    this.sli.mo47581Fj(intValue);
                } else if (iR <= intValue && iT >= intValue) {
                    this.sli.mo47581Fj(intValue);
                } else {
                    this.sli.skV.smoothScrollToPosition(intValue);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110508);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$3 */
    static final class C222943 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        C222943(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110510);
            EditorAudioView.m46610d(this.sli, !this.sli.slf);
            if (!this.sli.slf) {
                C29359a callback = this.sli.getCallback();
                if (callback != null) {
                    callback.mo26043d(null);
                }
                this.sli.slb.setSelection(null);
                this.sli.sla.setSelection(null);
                C13771a c13771a = C22219b.rUx;
                C22219b cyS = C22219b.rUt;
                if (cyS != null) {
                    cyS.rUr = false;
                    bqk bqk = new bqk();
                    bqk.wSJ = cyS.rUp;
                    bqk.wSK = 8;
                    bqk.wSM = (int) C5046bo.anT();
                    cyS.rUs.add(bqk);
                    C4990ab.m7416i(C22219b.TAG, "record no bgm " + C29301c.m46522a(bqk));
                    AppMethodBeat.m2505o(110510);
                    return;
                }
                AppMethodBeat.m2505o(110510);
            } else if (this.sli.slc != -1) {
                this.sli.mo47581Fj(this.sli.slc);
                AppMethodBeat.m2505o(110510);
            } else {
                EditorAudioSearchView b = this.sli.sla;
                b.mo47562Fj(b.f13713sC);
                AppMethodBeat.m2505o(110510);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$insectBottom$1$1"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$c */
    static final class C22295c implements Runnable {
        final /* synthetic */ View slj;
        final /* synthetic */ int slk;

        C22295c(View view, int i) {
            this.slj = view;
            this.slk = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(110517);
            this.slj.setPadding(this.slj.getPaddingLeft(), this.slj.getPaddingTop(), this.slj.getPaddingRight(), this.slk);
            this.slj.requestLayout();
            AppMethodBeat.m2505o(110517);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$d */
    public static final class C22296d extends C41530m {
        final /* synthetic */ EditorAudioView sli;

        C22296d(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(110518);
            C25052j.m39376p(recyclerView, "recyclerView");
            super.mo6643c(recyclerView, i);
            if (i == 0) {
                C17480i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.m2505o(110518);
                    throw c44941v;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iT = linearLayoutManager.mo1783iT();
                C41523a adapter = recyclerView.getAdapter();
                C25052j.m39375o(adapter, "recyclerView.adapter");
                if (iT == adapter.getItemCount() - 1) {
                    EditorAudioView editorAudioView = this.sli;
                    C41523a adapter2 = recyclerView.getAdapter();
                    C25052j.m39375o(adapter2, "recyclerView.adapter");
                    editorAudioView.mo47581Fj(adapter2.getItemCount() - 1);
                    AppMethodBeat.m2505o(110518);
                    return;
                }
                this.sli.mo47581Fj((linearLayoutManager.mo1782iS() + linearLayoutManager.mo1780iQ()) / 2);
            }
            AppMethodBeat.m2505o(110518);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$e */
    static final class C22297e implements Runnable {
        final /* synthetic */ EditorAudioView sli;

        C22297e(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110519);
            this.sli.setVisibility(8);
            AppMethodBeat.m2505o(110519);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$f */
    static final class C22298f implements Runnable {
        final /* synthetic */ EditorAudioView sli;

        C22298f(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110520);
            this.sli.skU.setVisibility(8);
            AppMethodBeat.m2505o(110520);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$g */
    static final class C24836g extends C25053k implements C17126b<LinkedList<bql>, C37091y> {
        final /* synthetic */ EditorAudioView sli;

        C24836g(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110522);
            final LinkedList linkedList = (LinkedList) obj;
            C25052j.m39376p(linkedList, "it");
            this.sli.sle = !((Collection) linkedList).isEmpty();
            if (this.sli.sle) {
                C13771a c13771a = C22219b.rUx;
                C22219b cyS = C22219b.rUt;
                if (cyS != null) {
                    cyS.pvG = this.sli.getMusicRequestId();
                }
                this.sli.sla.setMRelatedRecId(this.sli.getMusicRequestId());
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C24836g sll;

                    public final void run() {
                        AppMethodBeat.m2504i(110521);
                        EditorAudioView.m46602a(this.sll.sli, (List) linkedList);
                        AppMethodBeat.m2505o(110521);
                    }
                });
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110522);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$5 */
    static final class C293585 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        C293585(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110512);
            this.sli.slb.setSelection(null);
            C29359a callback = this.sli.getCallback();
            if (callback != null) {
                C4123a c4123a = AudioCacheInfo.rUj;
                AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
                audioCacheInfo.type = AudioCacheInfo.rUd;
                callback.mo26043d(audioCacheInfo);
            }
            EditorAudioView.m46606b(this.sli, true);
            EditorAudioView.m46608c(this.sli, false);
            C13771a c13771a = C22219b.rUx;
            C22219b cyS = C22219b.rUt;
            if (cyS != null) {
                bqk bqk = new bqk();
                bqk.wSK = 14;
                bqk.wSM = (int) C5046bo.anT();
                cyS.rUs.add(bqk);
                C4990ab.m7416i(C22219b.TAG, "record enter search " + C29301c.m46522a(bqk));
            }
            C22212h c22212h = C22212h.scu;
            C22212h.cAm().mo4994Fw();
            c22212h = C22212h.scu;
            C22212h.cAq().mo43957FY();
            c22212h = C22212h.scu;
            C22212h.m33887EU(17);
            AppMethodBeat.m2505o(110512);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "pauseAudio", "toggleOrigin", "remove", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$a */
    public interface C29359a {
        /* renamed from: d */
        void mo26043d(AudioCacheInfo audioCacheInfo);

        /* renamed from: lO */
        void mo26044lO(boolean z);

        void pauseAudio();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$initAudioSearchPanel$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$b */
    public static final class C29360b implements C29347a {
        final /* synthetic */ EditorAudioView sli;

        C29360b(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void cCv() {
            AppMethodBeat.m2504i(110513);
            C29359a callback = this.sli.getCallback();
            if (callback != null) {
                callback.pauseAudio();
                AppMethodBeat.m2505o(110513);
                return;
            }
            AppMethodBeat.m2505o(110513);
        }

        /* renamed from: b */
        public final void mo47556b(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.m2504i(110514);
            if (audioCacheInfo != null) {
                ArrayList arrayList = new ArrayList();
                C4123a c4123a = AudioCacheInfo.rUj;
                audioCacheInfo.type = AudioCacheInfo.rUc;
                c4123a = AudioCacheInfo.rUj;
                audioCacheInfo.cvd = AudioCacheInfo.rUi;
                arrayList.add(audioCacheInfo);
                C29320e c = this.sli.slb;
                List list = arrayList;
                C25052j.m39376p(list, "audios");
                c.sfu.addAll(0, list);
                c.notifyDataSetChanged();
                this.sli.skV.smoothScrollToPosition(0);
                this.sli.mo47581Fj(0);
                EditorAudioView.m46606b(this.sli, false);
                EditorAudioView.m46608c(this.sli, true);
                EditorAudioView.m46610d(this.sli, true);
            }
            AppMethodBeat.m2505o(110514);
        }

        /* renamed from: c */
        public final void mo47557c(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.m2504i(110515);
            if (audioCacheInfo != null) {
                int i = audioCacheInfo.type;
                C4123a c4123a = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUe) {
                    C29359a callback = this.sli.getCallback();
                    if (callback != null) {
                        callback.mo26043d(audioCacheInfo);
                        AppMethodBeat.m2505o(110515);
                        return;
                    }
                }
                AppMethodBeat.m2505o(110515);
                return;
            }
            AppMethodBeat.m2505o(110515);
        }

        public final void cCw() {
            AppMethodBeat.m2504i(110516);
            EditorAudioView.m46608c(this.sli, true);
            EditorAudioView.m46606b(this.sli, false);
            AppMethodBeat.m2505o(110516);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$4 */
    static final class C293614 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        C293614(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110511);
            this.sli.setShow(false);
            AppMethodBeat.m2505o(110511);
        }
    }

    /* renamed from: b */
    public static final /* synthetic */ void m46606b(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.m2504i(110534);
        editorAudioView.m46618lN(z);
        AppMethodBeat.m2505o(110534);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m46608c(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.m2504i(110535);
        editorAudioView.setShowAudioPanel(z);
        AppMethodBeat.m2505o(110535);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m46610d(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.m2504i(110536);
        editorAudioView.m46617lM(z);
        AppMethodBeat.m2505o(110536);
    }

    public EditorAudioView(final Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110531);
        this.TAG = "MicroMsg.EditorAudioView";
        this.slh = new C22296d(this);
        View.inflate(context, 2130970857, this);
        View findViewById = findViewById(2131828017);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_audio_panel)");
        this.skU = findViewById;
        findViewById = findViewById(2131828018);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_esitor_search_btn)");
        this.skZ = findViewById;
        findViewById = findViewById(2131828021);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_audio_recycler)");
        this.skV = (RecyclerView) findViewById;
        findViewById = findViewById(2131828028);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_audio_search_panel)");
        this.sla = (EditorAudioSearchView) findViewById;
        findViewById = findViewById(2131828019);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_item_audio_search_icon)");
        this.skY = (ImageView) findViewById;
        this.skV.setLayoutManager(new LinearLayoutManager(0));
        this.slb = new C29320e();
        new C17491an().mo42393i(this.skV);
        this.skV.setAdapter(this.slb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, context.getResources().getDrawable(C1318a.icons_filled_search));
        stateListDrawable.addState(new int[0], C5225ah.m7962f(context, C1318a.icons_filled_search, -1));
        this.skY.setImageDrawable(stateListDrawable);
        this.slb.llV = new C138661(this);
        this.skV.mo66332a((C41530m) this.slh);
        findViewById = findViewById(2131828026);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…r_audio_mute_origin_icon)");
        this.skW = (ImageView) findViewById;
        this.skW.setImageDrawable(C5225ah.m7962f(context, C1318a.ui_rescoures_checkbox_selected, -1));
        findViewById(2131828025).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EditorAudioView sli;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110509);
                this.sli.rYp = !this.sli.rYp;
                C29359a callback = this.sli.getCallback();
                if (callback != null) {
                    callback.mo26044lO(this.sli.rYp);
                }
                if (this.sli.rYp) {
                    this.sli.skW.setImageDrawable(C5225ah.m7962f(context, C1318a.ui_rescoures_checkbox_unselected, -1));
                    AppMethodBeat.m2505o(110509);
                    return;
                }
                this.sli.skW.setImageDrawable(C5225ah.m7962f(context, C1318a.ui_rescoures_checkbox_selected, -1));
                AppMethodBeat.m2505o(110509);
            }
        });
        findViewById = findViewById(2131828023);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…or_audio_mute_music_icon)");
        this.skX = (ImageView) findViewById;
        this.skX.setImageDrawable(C5225ah.m7962f(context, C1318a.ui_rescoures_checkbox_selected, -1));
        findViewById(2131828022).setOnClickListener(new C222943(this));
        setOnClickListener(new C293614(this));
        this.skZ.setOnClickListener(new C293585(this));
        this.skU.setTranslationY(getResources().getDimension(C25738R.dimen.a9v));
        this.sla.setCallback(new C29360b(this));
        AppMethodBeat.m2505o(110531);
    }

    public EditorAudioView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110532);
        AppMethodBeat.m2505o(110532);
    }

    public final C29359a getCallback() {
        return this.slg;
    }

    public final void setCallback(C29359a c29359a) {
        this.slg = c29359a;
    }

    /* renamed from: Fj */
    public final void mo47581Fj(int i) {
        AppMethodBeat.m2504i(110523);
        if (this.slb.llU != i) {
            int i2;
            C4123a c4123a;
            C29359a c29359a;
            AudioCacheInfo Fg = this.slb.mo47522Fg(i);
            if (Fg != null) {
                i2 = Fg.type;
                c4123a = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUf) {
                    C29359a c29359a2 = this.slg;
                    if (c29359a2 != null) {
                        c29359a2.mo26043d(null);
                    }
                    this.slc = i;
                }
            }
            if (Fg != null) {
                i2 = Fg.type;
                c4123a = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUd) {
                    this.slb.setSelection(null);
                    c29359a = this.slg;
                    if (c29359a != null) {
                        c29359a.mo26043d(Fg);
                    }
                    m46618lN(true);
                    setShowAudioPanel(false);
                    this.slc = i;
                }
            }
            this.slb.setSelection(Integer.valueOf(i));
            c29359a = this.slg;
            if (c29359a != null) {
                c29359a.mo26043d(Fg);
            }
            m46617lM(true);
            this.slc = i;
        }
        AppMethodBeat.m2505o(110523);
    }

    public final void setMusicPlayer(C0884v c0884v) {
        AppMethodBeat.m2504i(110524);
        C25052j.m39376p(c0884v, "player");
        this.slb.setMusicPlayer(c0884v);
        this.sla.setMusicPlayer(c0884v);
        AppMethodBeat.m2505o(110524);
    }

    private final void setShowAudioPanel(boolean z) {
        AppMethodBeat.m2504i(110525);
        if (z) {
            this.skU.setVisibility(0);
            this.skU.animate().cancel();
            this.skU.animate().translationY(0.0f).start();
            AppMethodBeat.m2505o(110525);
            return;
        }
        this.skU.animate().cancel();
        this.skU.animate().translationY((float) this.skU.getHeight()).withEndAction(new C22298f(this)).start();
        AppMethodBeat.m2505o(110525);
    }

    /* renamed from: lM */
    private final void m46617lM(boolean z) {
        AppMethodBeat.m2504i(110526);
        if (z) {
            this.skX.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.ui_rescoures_checkbox_selected, -1));
        } else {
            this.skX.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.ui_rescoures_checkbox_unselected, -1));
        }
        this.slf = z;
        AppMethodBeat.m2505o(110526);
    }

    /* renamed from: lN */
    private final void m46618lN(boolean z) {
        AppMethodBeat.m2504i(110527);
        if (z) {
            this.sla.setShow(true);
            AppMethodBeat.m2505o(110527);
            return;
        }
        this.sla.setShow(false);
        AppMethodBeat.m2505o(110527);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(110528);
        C17126b c17126b;
        if (z) {
            setVisibility(0);
            c17126b = this.eUw;
            if (c17126b != null) {
                c17126b.mo50am(Boolean.TRUE);
            }
            this.skU.animate().cancel();
            this.skU.animate().translationY(0.0f).start();
            if (!this.sle) {
                C22222f c22222f = this.sld;
                if (c22222f != null) {
                    C4990ab.m7416i(c22222f.TAG, "loadMore: " + c22222f.isLoading);
                    if (!c22222f.isLoading) {
                        c22222f.isLoading = true;
                        new C22220d(c22222f.rUA, c22222f.cEB, c22222f.cGm, c22222f.rUB, (byte) 0).acy().mo60487b((C5681a) new C22223a(c22222f));
                    }
                    AppMethodBeat.m2505o(110528);
                    return;
                }
                AppMethodBeat.m2505o(110528);
                return;
            }
        }
        c17126b = this.eUw;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.FALSE);
        }
        this.skU.animate().cancel();
        this.skU.animate().translationY((float) this.skU.getHeight()).withEndAction(new C22297e(this)).start();
        AppMethodBeat.m2505o(110528);
    }

    public final void setOnVisibleChangeCallback(C17126b<? super Boolean, C37091y> c17126b) {
        this.eUw = c17126b;
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(110529);
        if (getVisibility() != 0) {
            boolean z;
            if (this.sla.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.m2505o(110529);
                return false;
            }
        }
        AppMethodBeat.m2505o(110529);
        return true;
    }

    /* renamed from: jn */
    public final boolean mo20726jn(int i) {
        AppMethodBeat.m2504i(110530);
        View view = this.skU;
        if (view.getPaddingBottom() != i) {
            view.post(new C22295c(view, i));
        }
        AppMethodBeat.m2505o(110530);
        return true;
    }

    public final long getMusicRequestId() {
        C22222f c22222f = this.sld;
        if (c22222f != null) {
            return c22222f.rUB;
        }
        return -1;
    }
}
