package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.an;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r*\u0001%\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u00101\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\u0006\u00105\u001a\u00020/J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020!H\u0016J\b\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020/J\u000e\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020BJ-\u0010C\u001a\u00020/2#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0016J\u0010\u0010F\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0002J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u0002072\u0006\u0010J\u001a\u000207J\u0010\u0010K\u001a\u00020/2\u0006\u0010E\u001a\u00020!H\u0002J\u0010\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020!H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R+\u0010*\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "audioAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "audioRecycler", "Landroid/support/v7/widget/RecyclerView;", "audioSearchPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "audioTask", "Lcom/tencent/mm/plugin/story/model/audio/GetRecommendAudioTask;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;)V", "currentMusicPostion", "iconMuteMusic", "Landroid/widget/ImageView;", "iconMuteOrigin", "muteOrigin", "", "panel", "Landroid/view/View;", "scrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1;", "searchBtn", "searchIv", "taskFinished", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "withMusic", "addAudioList", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "back", "getMusicRequestId", "", "initAudioSearchPanel", "insectBottom", "bottom", "isShow", "refreshAudioList", "reset", "selectItem", "position", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setOnVisibleChangeCallback", "setShow", "show", "setShowAudioPanel", "setup", "videoPath", "startTime", "endTime", "showSearchPanel", "updateMusicMuteStatus", "music", "AudioCallback", "plugin-story_release"})
public final class EditorAudioView extends InsectRelativeLayout {
    private final String TAG;
    private a.f.a.b<? super Boolean, y> eUw;
    boolean rYp;
    private final View skU;
    private final RecyclerView skV;
    final ImageView skW;
    final ImageView skX;
    private final ImageView skY;
    private final View skZ;
    final EditorAudioSearchView sla;
    final com.tencent.mm.plugin.story.ui.a.e slb;
    private int slc;
    com.tencent.mm.plugin.story.model.audio.f sld;
    boolean sle;
    boolean slf;
    private a slg;
    private final d slh;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$1 */
    static final class AnonymousClass1 extends k implements m<Integer, AudioCacheInfo, y> {
        final /* synthetic */ EditorAudioView sli;

        AnonymousClass1(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(110508);
            int intValue = ((Number) obj).intValue();
            AudioCacheInfo audioCacheInfo = (AudioCacheInfo) obj2;
            j.p(audioCacheInfo, "info");
            if (intValue != this.sli.slb.getItemCount()) {
                i layoutManager = this.sli.skV.getLayoutManager();
                if (layoutManager == null) {
                    v vVar = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(110508);
                    throw vVar;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iR = linearLayoutManager.iR();
                int iT = linearLayoutManager.iT();
                int i = audioCacheInfo.type;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUd) {
                    this.sli.skV.smoothScrollToPosition(intValue);
                    this.sli.Fj(intValue);
                } else if (iR <= intValue && iT >= intValue) {
                    this.sli.Fj(intValue);
                } else {
                    this.sli.skV.smoothScrollToPosition(intValue);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110508);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        AnonymousClass3(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110510);
            EditorAudioView.d(this.sli, !this.sli.slf);
            if (!this.sli.slf) {
                a callback = this.sli.getCallback();
                if (callback != null) {
                    callback.d(null);
                }
                this.sli.slb.setSelection(null);
                this.sli.sla.setSelection(null);
                com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
                if (cyS != null) {
                    cyS.rUr = false;
                    bqk bqk = new bqk();
                    bqk.wSJ = cyS.rUp;
                    bqk.wSK = 8;
                    bqk.wSM = (int) bo.anT();
                    cyS.rUs.add(bqk);
                    ab.i(com.tencent.mm.plugin.story.model.audio.b.TAG, "record no bgm " + com.tencent.mm.plugin.story.model.audio.c.a(bqk));
                    AppMethodBeat.o(110510);
                    return;
                }
                AppMethodBeat.o(110510);
            } else if (this.sli.slc != -1) {
                this.sli.Fj(this.sli.slc);
                AppMethodBeat.o(110510);
            } else {
                EditorAudioSearchView b = this.sli.sla;
                b.Fj(b.sC);
                AppMethodBeat.o(110510);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$insectBottom$1$1"})
    static final class c implements Runnable {
        final /* synthetic */ View slj;
        final /* synthetic */ int slk;

        c(View view, int i) {
            this.slj = view;
            this.slk = i;
        }

        public final void run() {
            AppMethodBeat.i(110517);
            this.slj.setPadding(this.slj.getPaddingLeft(), this.slj.getPaddingTop(), this.slj.getPaddingRight(), this.slk);
            this.slj.requestLayout();
            AppMethodBeat.o(110517);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
    public static final class d extends RecyclerView.m {
        final /* synthetic */ EditorAudioView sli;

        d(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(110518);
            j.p(recyclerView, "recyclerView");
            super.c(recyclerView, i);
            if (i == 0) {
                i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    v vVar = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(110518);
                    throw vVar;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iT = linearLayoutManager.iT();
                android.support.v7.widget.RecyclerView.a adapter = recyclerView.getAdapter();
                j.o(adapter, "recyclerView.adapter");
                if (iT == adapter.getItemCount() - 1) {
                    EditorAudioView editorAudioView = this.sli;
                    android.support.v7.widget.RecyclerView.a adapter2 = recyclerView.getAdapter();
                    j.o(adapter2, "recyclerView.adapter");
                    editorAudioView.Fj(adapter2.getItemCount() - 1);
                    AppMethodBeat.o(110518);
                    return;
                }
                this.sli.Fj((linearLayoutManager.iS() + linearLayoutManager.iQ()) / 2);
            }
            AppMethodBeat.o(110518);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ EditorAudioView sli;

        e(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.i(110519);
            this.sli.setVisibility(8);
            AppMethodBeat.o(110519);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ EditorAudioView sli;

        f(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.i(110520);
            this.sli.skU.setVisibility(8);
            AppMethodBeat.o(110520);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "invoke"})
    static final class g extends k implements a.f.a.b<LinkedList<bql>, y> {
        final /* synthetic */ EditorAudioView sli;

        g(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110522);
            final LinkedList linkedList = (LinkedList) obj;
            j.p(linkedList, "it");
            this.sli.sle = !((Collection) linkedList).isEmpty();
            if (this.sli.sle) {
                com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
                if (cyS != null) {
                    cyS.pvG = this.sli.getMusicRequestId();
                }
                this.sli.sla.setMRelatedRecId(this.sli.getMusicRequestId());
                al.d(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        AppMethodBeat.i(110521);
                        EditorAudioView.a(this.sll.sli, (List) linkedList);
                        AppMethodBeat.o(110521);
                    }
                });
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110522);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        AnonymousClass5(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110512);
            this.sli.slb.setSelection(null);
            a callback = this.sli.getCallback();
            if (callback != null) {
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
                audioCacheInfo.type = AudioCacheInfo.rUd;
                callback.d(audioCacheInfo);
            }
            EditorAudioView.b(this.sli, true);
            EditorAudioView.c(this.sli, false);
            com.tencent.mm.plugin.story.model.audio.b.a aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
            com.tencent.mm.plugin.story.model.audio.b cyS = com.tencent.mm.plugin.story.model.audio.b.rUt;
            if (cyS != null) {
                bqk bqk = new bqk();
                bqk.wSK = 14;
                bqk.wSM = (int) bo.anT();
                cyS.rUs.add(bqk);
                ab.i(com.tencent.mm.plugin.story.model.audio.b.TAG, "record enter search " + com.tencent.mm.plugin.story.model.audio.c.a(bqk));
            }
            h hVar = h.scu;
            h.cAm().Fw();
            hVar = h.scu;
            h.cAq().FY();
            hVar = h.scu;
            h.EU(17);
            AppMethodBeat.o(110512);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "pauseAudio", "toggleOrigin", "remove", "", "plugin-story_release"})
    public interface a {
        void d(AudioCacheInfo audioCacheInfo);

        void lO(boolean z);

        void pauseAudio();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$initAudioSearchPanel$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-story_release"})
    public static final class b implements com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.a {
        final /* synthetic */ EditorAudioView sli;

        b(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void cCv() {
            AppMethodBeat.i(110513);
            a callback = this.sli.getCallback();
            if (callback != null) {
                callback.pauseAudio();
                AppMethodBeat.o(110513);
                return;
            }
            AppMethodBeat.o(110513);
        }

        public final void b(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(110514);
            if (audioCacheInfo != null) {
                ArrayList arrayList = new ArrayList();
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                audioCacheInfo.type = AudioCacheInfo.rUc;
                aVar = AudioCacheInfo.rUj;
                audioCacheInfo.cvd = AudioCacheInfo.rUi;
                arrayList.add(audioCacheInfo);
                com.tencent.mm.plugin.story.ui.a.e c = this.sli.slb;
                List list = arrayList;
                j.p(list, "audios");
                c.sfu.addAll(0, list);
                c.notifyDataSetChanged();
                this.sli.skV.smoothScrollToPosition(0);
                this.sli.Fj(0);
                EditorAudioView.b(this.sli, false);
                EditorAudioView.c(this.sli, true);
                EditorAudioView.d(this.sli, true);
            }
            AppMethodBeat.o(110514);
        }

        public final void c(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(110515);
            if (audioCacheInfo != null) {
                int i = audioCacheInfo.type;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                if (i == AudioCacheInfo.rUe) {
                    a callback = this.sli.getCallback();
                    if (callback != null) {
                        callback.d(audioCacheInfo);
                        AppMethodBeat.o(110515);
                        return;
                    }
                }
                AppMethodBeat.o(110515);
                return;
            }
            AppMethodBeat.o(110515);
        }

        public final void cCw() {
            AppMethodBeat.i(110516);
            EditorAudioView.c(this.sli, true);
            EditorAudioView.b(this.sli, false);
            AppMethodBeat.o(110516);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ EditorAudioView sli;

        AnonymousClass4(EditorAudioView editorAudioView) {
            this.sli = editorAudioView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110511);
            this.sli.setShow(false);
            AppMethodBeat.o(110511);
        }
    }

    public static final /* synthetic */ void b(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.i(110534);
        editorAudioView.lN(z);
        AppMethodBeat.o(110534);
    }

    public static final /* synthetic */ void c(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.i(110535);
        editorAudioView.setShowAudioPanel(z);
        AppMethodBeat.o(110535);
    }

    public static final /* synthetic */ void d(EditorAudioView editorAudioView, boolean z) {
        AppMethodBeat.i(110536);
        editorAudioView.lM(z);
        AppMethodBeat.o(110536);
    }

    public EditorAudioView(final Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110531);
        this.TAG = "MicroMsg.EditorAudioView";
        this.slh = new d(this);
        View.inflate(context, R.layout.axu, this);
        View findViewById = findViewById(R.id.eq0);
        j.o(findViewById, "findViewById(R.id.story_audio_panel)");
        this.skU = findViewById;
        findViewById = findViewById(R.id.eq1);
        j.o(findViewById, "findViewById(R.id.story_esitor_search_btn)");
        this.skZ = findViewById;
        findViewById = findViewById(R.id.eq4);
        j.o(findViewById, "findViewById(R.id.story_editor_audio_recycler)");
        this.skV = (RecyclerView) findViewById;
        findViewById = findViewById(R.id.eqa);
        j.o(findViewById, "findViewById(R.id.story_editor_audio_search_panel)");
        this.sla = (EditorAudioSearchView) findViewById;
        findViewById = findViewById(R.id.eq2);
        j.o(findViewById, "findViewById(R.id.story_item_audio_search_icon)");
        this.skY = (ImageView) findViewById;
        this.skV.setLayoutManager(new LinearLayoutManager(0));
        this.slb = new com.tencent.mm.plugin.story.ui.a.e();
        new an().i(this.skV);
        this.skV.setAdapter(this.slb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, context.getResources().getDrawable(R.raw.icons_filled_search));
        stateListDrawable.addState(new int[0], ah.f(context, R.raw.icons_filled_search, -1));
        this.skY.setImageDrawable(stateListDrawable);
        this.slb.llV = new AnonymousClass1(this);
        this.skV.a((RecyclerView.m) this.slh);
        findViewById = findViewById(R.id.eq9);
        j.o(findViewById, "findViewById(R.id.story_…r_audio_mute_origin_icon)");
        this.skW = (ImageView) findViewById;
        this.skW.setImageDrawable(ah.f(context, R.raw.ui_rescoures_checkbox_selected, -1));
        findViewById(R.id.eq8).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EditorAudioView sli;

            public final void onClick(View view) {
                AppMethodBeat.i(110509);
                this.sli.rYp = !this.sli.rYp;
                a callback = this.sli.getCallback();
                if (callback != null) {
                    callback.lO(this.sli.rYp);
                }
                if (this.sli.rYp) {
                    this.sli.skW.setImageDrawable(ah.f(context, R.raw.ui_rescoures_checkbox_unselected, -1));
                    AppMethodBeat.o(110509);
                    return;
                }
                this.sli.skW.setImageDrawable(ah.f(context, R.raw.ui_rescoures_checkbox_selected, -1));
                AppMethodBeat.o(110509);
            }
        });
        findViewById = findViewById(R.id.eq6);
        j.o(findViewById, "findViewById(R.id.story_…or_audio_mute_music_icon)");
        this.skX = (ImageView) findViewById;
        this.skX.setImageDrawable(ah.f(context, R.raw.ui_rescoures_checkbox_selected, -1));
        findViewById(R.id.eq5).setOnClickListener(new AnonymousClass3(this));
        setOnClickListener(new AnonymousClass4(this));
        this.skZ.setOnClickListener(new AnonymousClass5(this));
        this.skU.setTranslationY(getResources().getDimension(R.dimen.a9v));
        this.sla.setCallback(new b(this));
        AppMethodBeat.o(110531);
    }

    public EditorAudioView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110532);
        AppMethodBeat.o(110532);
    }

    public final a getCallback() {
        return this.slg;
    }

    public final void setCallback(a aVar) {
        this.slg = aVar;
    }

    public final void Fj(int i) {
        AppMethodBeat.i(110523);
        if (this.slb.llU != i) {
            int i2;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar;
            a aVar2;
            AudioCacheInfo Fg = this.slb.Fg(i);
            if (Fg != null) {
                i2 = Fg.type;
                aVar = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUf) {
                    a aVar3 = this.slg;
                    if (aVar3 != null) {
                        aVar3.d(null);
                    }
                    this.slc = i;
                }
            }
            if (Fg != null) {
                i2 = Fg.type;
                aVar = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUd) {
                    this.slb.setSelection(null);
                    aVar2 = this.slg;
                    if (aVar2 != null) {
                        aVar2.d(Fg);
                    }
                    lN(true);
                    setShowAudioPanel(false);
                    this.slc = i;
                }
            }
            this.slb.setSelection(Integer.valueOf(i));
            aVar2 = this.slg;
            if (aVar2 != null) {
                aVar2.d(Fg);
            }
            lM(true);
            this.slc = i;
        }
        AppMethodBeat.o(110523);
    }

    public final void setMusicPlayer(com.google.android.exoplayer2.v vVar) {
        AppMethodBeat.i(110524);
        j.p(vVar, "player");
        this.slb.setMusicPlayer(vVar);
        this.sla.setMusicPlayer(vVar);
        AppMethodBeat.o(110524);
    }

    private final void setShowAudioPanel(boolean z) {
        AppMethodBeat.i(110525);
        if (z) {
            this.skU.setVisibility(0);
            this.skU.animate().cancel();
            this.skU.animate().translationY(0.0f).start();
            AppMethodBeat.o(110525);
            return;
        }
        this.skU.animate().cancel();
        this.skU.animate().translationY((float) this.skU.getHeight()).withEndAction(new f(this)).start();
        AppMethodBeat.o(110525);
    }

    private final void lM(boolean z) {
        AppMethodBeat.i(110526);
        if (z) {
            this.skX.setImageDrawable(ah.f(getContext(), R.raw.ui_rescoures_checkbox_selected, -1));
        } else {
            this.skX.setImageDrawable(ah.f(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
        }
        this.slf = z;
        AppMethodBeat.o(110526);
    }

    private final void lN(boolean z) {
        AppMethodBeat.i(110527);
        if (z) {
            this.sla.setShow(true);
            AppMethodBeat.o(110527);
            return;
        }
        this.sla.setShow(false);
        AppMethodBeat.o(110527);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(110528);
        a.f.a.b bVar;
        if (z) {
            setVisibility(0);
            bVar = this.eUw;
            if (bVar != null) {
                bVar.am(Boolean.TRUE);
            }
            this.skU.animate().cancel();
            this.skU.animate().translationY(0.0f).start();
            if (!this.sle) {
                com.tencent.mm.plugin.story.model.audio.f fVar = this.sld;
                if (fVar != null) {
                    ab.i(fVar.TAG, "loadMore: " + fVar.isLoading);
                    if (!fVar.isLoading) {
                        fVar.isLoading = true;
                        new com.tencent.mm.plugin.story.model.audio.d(fVar.rUA, fVar.cEB, fVar.cGm, fVar.rUB, (byte) 0).acy().b((com.tencent.mm.vending.c.a) new com.tencent.mm.plugin.story.model.audio.f.a(fVar));
                    }
                    AppMethodBeat.o(110528);
                    return;
                }
                AppMethodBeat.o(110528);
                return;
            }
        }
        bVar = this.eUw;
        if (bVar != null) {
            bVar.am(Boolean.FALSE);
        }
        this.skU.animate().cancel();
        this.skU.animate().translationY((float) this.skU.getHeight()).withEndAction(new e(this)).start();
        AppMethodBeat.o(110528);
    }

    public final void setOnVisibleChangeCallback(a.f.a.b<? super Boolean, y> bVar) {
        this.eUw = bVar;
    }

    public final boolean aFF() {
        AppMethodBeat.i(110529);
        if (getVisibility() != 0) {
            boolean z;
            if (this.sla.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(110529);
                return false;
            }
        }
        AppMethodBeat.o(110529);
        return true;
    }

    public final boolean jn(int i) {
        AppMethodBeat.i(110530);
        View view = this.skU;
        if (view.getPaddingBottom() != i) {
            view.post(new c(view, i));
        }
        AppMethodBeat.o(110530);
        return true;
    }

    public final long getMusicRequestId() {
        com.tencent.mm.plugin.story.model.audio.f fVar = this.sld;
        if (fVar != null) {
            return fVar.rUB;
        }
        return -1;
    }
}
