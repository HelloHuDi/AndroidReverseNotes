package com.tencent.mm.plugin.story.ui.view.editor;

import a.v;
import a.y;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ak;
import java.util.ArrayList;
import java.util.LinkedList;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001)\u0018\u00002\u00020\u0001:\u0001ZB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020;H\u0002J\u001e\u0010A\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020=H\u0002J\u0006\u0010F\u001a\u00020;J\b\u0010G\u001a\u00020=H\u0002J\u0006\u0010H\u001a\u00020=J\u000e\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020\tJ\u0006\u0010K\u001a\u00020=J\u0010\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020;H\u0002J\u000e\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020PJ\u0015\u0010Q\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010RJ\u000e\u0010S\u001a\u00020=2\u0006\u0010F\u001a\u00020;J\b\u0010T\u001a\u00020=H\u0002J\u001e\u0010U\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020 0V2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010W\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020=H\u0002J\b\u0010Y\u001a\u00020=H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-story_release"})
public final class EditorAudioSearchView extends RelativeLayout {
    private final String TAG = "MicroMsg.EditorAudioSearchView";
    private final Runnable lnE = new n(this);
    private Button nsJ;
    int sC = -1;
    private View skA;
    private TextView skB;
    EditText skC;
    private RecyclerView skD;
    private TextView skE;
    private LinearLayout skF;
    private ImageView skG;
    private ImageView skH;
    private com.tencent.mm.plugin.story.ui.a.e skI;
    private long skJ;
    private int skK;
    private String skL;
    private AudioCacheInfo skM;
    private long skN;
    private long skO;
    a skP;
    private final l skQ = new l(this);
    private int skx;
    private View sky;
    private View skz;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
    static final class h implements OnEditorActionListener {
        final /* synthetic */ EditorAudioSearchView skR;

        h(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.i(110481);
            if (3 == i) {
                CharSequence text;
                String obj;
                if (this.skR.skL != null) {
                    String h = this.skR.skL;
                    a.f.b.j.o(textView, "textView");
                    text = textView.getText();
                    if (!bo.isEqual(h, text != null ? text.toString() : null)) {
                        EditorAudioSearchView.f(this.skR);
                        com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                        com.tencent.mm.plugin.story.model.audio.b.rUw.cH(2);
                        aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                        com.tencent.mm.plugin.story.model.audio.b.a.cyU();
                        aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                        com.tencent.mm.plugin.story.model.audio.b.rUw.cK(this.skR.getMRelatedRecId());
                    }
                }
                EditorAudioSearchView editorAudioSearchView = this.skR;
                a.f.b.j.o(textView, "textView");
                text = textView.getText();
                if (text != null) {
                    obj = text.toString();
                } else {
                    obj = null;
                }
                editorAudioSearchView.skL = obj;
                if (!bo.isNullOrNil(this.skR.skL)) {
                    com.tencent.mm.plugin.story.ui.a.e c = this.skR.skI;
                    if (c != null) {
                        c.setSelection(null);
                    }
                    c = this.skR.skI;
                    if (c != null) {
                        c.setSelection(null);
                    }
                    RecyclerView i2 = this.skR.skD;
                    if (i2 != null) {
                        i2.bY(0);
                    }
                    com.tencent.mm.plugin.story.ui.a.e c2 = this.skR.skI;
                    if (c2 != null) {
                        c2.dG(new LinkedList());
                    }
                    Button j = this.skR.nsJ;
                    if (j != null) {
                        j.setEnabled(false);
                    }
                    this.skR.skJ = 0;
                    this.skR.sC = -1;
                    this.skR.skK = 0;
                    c = this.skR.skI;
                    if (c != null) {
                        c.sfv = this.skR.skL;
                    }
                    this.skR.skM = null;
                    this.skR.skN = 0;
                    EditorAudioSearchView.o(this.skR);
                    EditorAudioSearchView.b(this.skR, false);
                    a callback = this.skR.getCallback();
                    if (callback != null) {
                        callback.cCv();
                    }
                }
            }
            AppMethodBeat.o(110481);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.m<Integer, AudioCacheInfo, y> {
        final /* synthetic */ EditorAudioSearchView skR;

        i(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(110482);
            int intValue = ((Number) obj).intValue();
            a.f.b.j.p((AudioCacheInfo) obj2, "info");
            com.tencent.mm.plugin.story.ui.a.e c = this.skR.skI;
            if (c == null || intValue != c.getItemCount()) {
                this.skR.Fj(intValue);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110482);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements OnClickListener {
        public static final k skT = new k();

        static {
            AppMethodBeat.i(110484);
            AppMethodBeat.o(110484);
        }

        k() {
        }

        public final void onClick(View view) {
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BgmSearchResp;", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ EditorAudioSearchView skR;
        final /* synthetic */ boolean skS;

        b(EditorAudioSearchView editorAudioSearchView, boolean z) {
            this.skR = editorAudioSearchView;
            this.skS = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(110475);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            int i = aVar.errType;
            int i2 = aVar.errCode;
            ab.i(this.skR.TAG, "LogStory: SearchdMusic callback " + i + ' ' + i2 + ", " + aVar.aIm);
            if (i == 0 && i2 == 0) {
                jc jcVar = (jc) aVar.fsy;
                this.skR.skJ = jcVar.rUb;
                EditorAudioSearchView editorAudioSearchView = this.skR;
                editorAudioSearchView.skK = editorAudioSearchView.skK + 1;
                LinkedList linkedList = jcVar.vKY;
                EditorAudioSearchView editorAudioSearchView2 = this.skR;
                a.f.b.j.o(linkedList, "audioList");
                EditorAudioSearchView.a(editorAudioSearchView2, linkedList, this.skS);
                com.tencent.mm.plugin.story.model.audio.b.a aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
                com.tencent.mm.plugin.story.model.audio.b.rUw.cJ(this.skR.skJ);
                aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
                com.tencent.mm.plugin.story.model.audio.b.rUw.fT(this.skR.skL);
                ab.i(this.skR.TAG, "get audio list ".concat(String.valueOf(jcVar)));
                Object obj2 = com.tencent.mm.vending.c.a.zXH;
                AppMethodBeat.o(110475);
                return obj2;
            }
            if (this.skR.skK == 0) {
                EditorAudioSearchView.q(this.skR);
            }
            Void voidR = com.tencent.mm.vending.c.a.zXH;
            AppMethodBeat.o(110475);
            return voidR;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-story_release"})
    public interface a {
        void b(AudioCacheInfo audioCacheInfo);

        void c(AudioCacheInfo audioCacheInfo);

        void cCv();

        void cCw();
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        c(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110476);
            EditText a = this.skR.skC;
            if (a != null) {
                Editable text = a.getText();
                if (text != null) {
                    if ((((CharSequence) text).length() == 0 ? 1 : null) == null) {
                        a = this.skR.skC;
                        if (a != null) {
                            a.setText(null);
                            AppMethodBeat.o(110476);
                            return;
                        }
                    }
                    AppMethodBeat.o(110476);
                    return;
                }
            }
            AppMethodBeat.o(110476);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        j(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110483);
            EditorAudioSearchView.b(this.skR);
            AppMethodBeat.o(110483);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
    public static final class l extends android.support.v7.widget.RecyclerView.m {
        final /* synthetic */ EditorAudioSearchView skR;

        l(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(110485);
            a.f.b.j.p(recyclerView, "recyclerView");
            super.c(recyclerView, i);
            if (i == 0) {
                android.support.v7.widget.RecyclerView.i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    v vVar = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(110485);
                    throw vVar;
                }
                int iS = ((LinearLayoutManager) layoutManager).iS();
                com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                com.tencent.mm.plugin.story.model.audio.b.rUw.cI((long) iS);
                com.tencent.mm.plugin.story.ui.a.e c = this.skR.skI;
                if (c != null) {
                    if (iS == c.getItemCount() - 1) {
                        AudioCacheInfo Fg = c.Fg(iS);
                        if (Fg != null) {
                            iS = Fg.type;
                            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2 = AudioCacheInfo.rUj;
                            if (iS == AudioCacheInfo.rUg) {
                                EditorAudioSearchView.b(this.skR, true);
                            }
                        } else {
                            AppMethodBeat.o(110485);
                            return;
                        }
                    }
                    AppMethodBeat.o(110485);
                    return;
                }
            }
            AppMethodBeat.o(110485);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        d(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110477);
            EditorAudioSearchView.b(this.skR);
            AppMethodBeat.o(110477);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    static final class f implements OnFocusChangeListener {
        final /* synthetic */ EditorAudioSearchView skR;

        f(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(110479);
            EditorAudioSearchView.a(this.skR, z);
            AppMethodBeat.o(110479);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        final /* synthetic */ EditorAudioSearchView skR;

        m(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.i(110486);
            this.skR.setVisibility(8);
            AppMethodBeat.o(110486);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-story_release"})
    public static final class g implements TextWatcher {
        final /* synthetic */ EditorAudioSearchView skR;

        g(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(110480);
            ImageView g;
            if ((editable != null ? editable.length() : 0) > 0) {
                g = this.skR.skG;
                if (g != null) {
                    g.setVisibility(0);
                    AppMethodBeat.o(110480);
                    return;
                }
                AppMethodBeat.o(110480);
                return;
            }
            g = this.skR.skG;
            if (g != null) {
                g.setVisibility(8);
                AppMethodBeat.o(110480);
                return;
            }
            AppMethodBeat.o(110480);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        e(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110478);
            com.tencent.mm.plugin.story.ui.a.e c = this.skR.skI;
            if (c != null) {
                com.tencent.mm.plugin.story.model.audio.b.a aVar;
                if (this.skR.sC == -1 || this.skR.sC >= c.getItemCount()) {
                    a callback = this.skR.getCallback();
                    if (callback != null) {
                        callback.b(null);
                    }
                    EditorAudioSearchView.f(this.skR);
                    aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.rUw.cH(1);
                    aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.a.cyU();
                } else {
                    a callback2 = this.skR.getCallback();
                    if (callback2 != null) {
                        callback2.b(c.Fg(this.skR.sC));
                    }
                    EditorAudioSearchView.f(this.skR);
                    aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.rUw.cH(0);
                    aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                    com.tencent.mm.plugin.story.model.audio.b.a.cyU();
                }
                this.skR.reset();
            }
            EditText a = this.skR.skC;
            if (a != null) {
                a.clearFocus();
                AppMethodBeat.o(110478);
                return;
            }
            AppMethodBeat.o(110478);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ EditorAudioSearchView skR;

        n(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.i(110487);
            InputMethodManager inputMethodManager = (InputMethodManager) this.skR.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.skR.skC, 0);
                AppMethodBeat.o(110487);
                return;
            }
            AppMethodBeat.o(110487);
        }
    }

    public static final /* synthetic */ void b(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(110501);
        editorAudioSearchView.cCr();
        AppMethodBeat.o(110501);
    }

    public static final /* synthetic */ void f(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(110502);
        editorAudioSearchView.cCu();
        AppMethodBeat.o(110502);
    }

    public static final /* synthetic */ void q(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(110506);
        editorAudioSearchView.cCt();
        AppMethodBeat.o(110506);
    }

    public final long getMRelatedRecId() {
        return this.skO;
    }

    public final void setMRelatedRecId(long j) {
        this.skO = j;
    }

    public final a getCallback() {
        return this.skP;
    }

    public final void setCallback(a aVar) {
        this.skP = aVar;
    }

    public EditorAudioSearchView(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(110499);
        init();
        AppMethodBeat.o(110499);
    }

    public EditorAudioSearchView(Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(110500);
        init();
        AppMethodBeat.o(110500);
    }

    private final void init() {
        AppMethodBeat.i(110488);
        View.inflate(getContext(), R.layout.ayd, this);
        this.skB = (TextView) findViewById(R.id.esb);
        this.skC = (EditText) findViewById(R.id.esh);
        this.nsJ = (Button) findViewById(R.id.esd);
        this.skD = (RecyclerView) findViewById(R.id.eso);
        this.skE = (TextView) findViewById(R.id.esk);
        this.skF = (LinearLayout) findViewById(R.id.esl);
        this.skG = (ImageView) findViewById(R.id.esg);
        this.sky = findViewById(R.id.esi);
        this.skz = findViewById(R.id.esj);
        this.skA = findViewById(R.id.esp);
        this.skH = (ImageView) findViewById(R.id.esf);
        ImageView imageView = this.skH;
        if (imageView != null) {
            imageView.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_search, -1));
        }
        Button button = this.nsJ;
        if (button != null) {
            button.setEnabled(false);
        }
        imageView = this.skG;
        if (imageView != null) {
            imageView.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_close2, -1));
        }
        ImageView imageView2 = this.skG;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new c(this));
        }
        RecyclerView recyclerView = this.skD;
        LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        if (layoutParams == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(110488);
            throw vVar;
        }
        ((MarginLayoutParams) layoutParams).bottomMargin = ak.fr(getContext()) + com.tencent.mm.bz.a.fromDPToPix(getContext(), 16);
        RecyclerView recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager(1));
        }
        recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            recyclerView2.a((android.support.v7.widget.RecyclerView.m) this.skQ);
        }
        this.skI = new com.tencent.mm.plugin.story.ui.a.e();
        recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.skI);
        }
        TextView textView = this.skB;
        if (textView != null) {
            textView.setOnClickListener(new d(this));
        }
        Button button2 = this.nsJ;
        if (button2 != null) {
            button2.setOnClickListener(new e(this));
        }
        EditText editText = this.skC;
        if (editText != null) {
            editText.setOnFocusChangeListener(new f(this));
        }
        editText = this.skC;
        if (editText != null) {
            editText.addTextChangedListener(new g(this));
        }
        editText = this.skC;
        if (editText != null) {
            editText.setOnEditorActionListener(new h(this));
        }
        com.tencent.mm.plugin.story.ui.a.e eVar = this.skI;
        if (eVar != null) {
            eVar.llV = new i(this);
        }
        View view = this.skA;
        if (view != null) {
            view.setOnClickListener(new j(this));
        }
        setOnClickListener(k.skT);
        this.skx = ak.hy(getContext()).y;
        setTranslationY((float) this.skx);
        cCs();
        AppMethodBeat.o(110488);
    }

    public final void Fj(int i) {
        AppMethodBeat.i(110489);
        com.tencent.mm.plugin.story.ui.a.e eVar = this.skI;
        if (eVar == null || eVar.llU != i) {
            this.sC = i;
            eVar = this.skI;
            AudioCacheInfo Fg = eVar != null ? eVar.Fg(i) : null;
            if (Fg != null) {
                int i2 = Fg.type;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUf) {
                    a aVar2 = this.skP;
                    if (aVar2 != null) {
                        aVar2.c(null);
                    }
                    this.skM = Fg;
                    this.skN = System.currentTimeMillis();
                }
            }
            if (Fg != null) {
                int i3 = Fg.type;
                com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar3 = AudioCacheInfo.rUj;
                if (i3 == AudioCacheInfo.rUe) {
                    com.tencent.mm.plugin.story.ui.a.e eVar2 = this.skI;
                    if (eVar2 != null) {
                        eVar2.setSelection(Integer.valueOf(i));
                    }
                    a aVar4 = this.skP;
                    if (aVar4 != null) {
                        aVar4.c(Fg);
                    }
                    Button button = this.nsJ;
                    if (button != null) {
                        button.setEnabled(true);
                    }
                    cCu();
                }
            }
            this.skM = Fg;
            this.skN = System.currentTimeMillis();
        }
        AppMethodBeat.o(110489);
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(110490);
        if (z) {
            post(this.lnE);
            AppMethodBeat.o(110490);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(110490);
            return;
        }
        AppMethodBeat.o(110490);
    }

    /* Access modifiers changed, original: final */
    public final void cCr() {
        AppMethodBeat.i(110491);
        cCu();
        com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
        com.tencent.mm.plugin.story.model.audio.b.rUw.cH(1);
        aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
        com.tencent.mm.plugin.story.model.audio.b.a.cyU();
        reset();
        EditText editText = this.skC;
        if (editText != null) {
            editText.clearFocus();
        }
        a aVar2 = this.skP;
        if (aVar2 != null) {
            aVar2.cCv();
        }
        aVar2 = this.skP;
        if (aVar2 != null) {
            aVar2.cCw();
            AppMethodBeat.o(110491);
            return;
        }
        AppMethodBeat.o(110491);
    }

    private final void cCs() {
        AppMethodBeat.i(110492);
        View view = this.sky;
        if (view != null) {
            view.setVisibility(0);
        }
        view = this.skz;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(110492);
            return;
        }
        AppMethodBeat.o(110492);
    }

    private final void cCt() {
        AppMethodBeat.i(110493);
        LinearLayout linearLayout = this.skF;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RecyclerView recyclerView = this.skD;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        TextView textView = this.skE;
        if (textView != null) {
            textView.setVisibility(0);
            AppMethodBeat.o(110493);
            return;
        }
        AppMethodBeat.o(110493);
    }

    /* Access modifiers changed, original: final */
    public final void cCu() {
        Object obj = null;
        AppMethodBeat.i(110494);
        if (this.skM != null) {
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
            if (bo.isNullOrNil(com.tencent.mm.plugin.story.model.audio.b.rUw.Gw())) {
                AudioCacheInfo audioCacheInfo = this.skM;
                if (audioCacheInfo != null) {
                    obj = Integer.valueOf(audioCacheInfo.rTW);
                }
                stringBuilder.append(obj).append(":1:").append(System.currentTimeMillis() - this.skN);
            } else {
                StringBuilder append = stringBuilder.append(";");
                AudioCacheInfo audioCacheInfo2 = this.skM;
                if (audioCacheInfo2 != null) {
                    obj = Integer.valueOf(audioCacheInfo2.rTW);
                }
                append.append(obj).append(":1:").append(System.currentTimeMillis() - this.skN);
            }
            com.tencent.mm.plugin.story.model.audio.b.a aVar2 = com.tencent.mm.plugin.story.model.audio.b.rUx;
            bd cyT = com.tencent.mm.plugin.story.model.audio.b.rUw;
            cyT.fU(cyT.Gw() + stringBuilder.toString());
        }
        AppMethodBeat.o(110494);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(110495);
        EditText editText;
        if (z) {
            com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
            com.tencent.mm.plugin.story.model.audio.b.rUw.cK(this.skO);
            setVisibility(0);
            animate().translationY(0.0f).start();
            editText = this.skC;
            if (editText != null) {
                editText.requestFocus();
                AppMethodBeat.o(110495);
                return;
            }
            AppMethodBeat.o(110495);
            return;
        }
        animate().translationY((float) this.skx).withEndAction(new m(this)).start();
        editText = this.skC;
        if (editText != null) {
            editText.clearFocus();
            AppMethodBeat.o(110495);
            return;
        }
        AppMethodBeat.o(110495);
    }

    public final void setMusicPlayer(com.google.android.exoplayer2.v vVar) {
        AppMethodBeat.i(110496);
        a.f.b.j.p(vVar, "player");
        com.tencent.mm.plugin.story.ui.a.e eVar = this.skI;
        if (eVar != null) {
            eVar.setMusicPlayer(vVar);
            AppMethodBeat.o(110496);
            return;
        }
        AppMethodBeat.o(110496);
    }

    public final void reset() {
        AppMethodBeat.i(110497);
        this.skK = 0;
        this.sC = -1;
        this.skJ = 0;
        Button button = this.nsJ;
        if (button != null) {
            button.setEnabled(false);
        }
        EditText editText = this.skC;
        if (editText != null) {
            editText.setText(null);
        }
        com.tencent.mm.plugin.story.ui.a.e eVar = this.skI;
        if (eVar != null) {
            eVar.setSelection(null);
        }
        RecyclerView recyclerView = this.skD;
        if (recyclerView != null) {
            recyclerView.bY(0);
        }
        com.tencent.mm.plugin.story.ui.a.e eVar2 = this.skI;
        if (eVar2 != null) {
            eVar2.dG(new LinkedList());
        }
        cCs();
        this.skL = null;
        this.skM = null;
        this.skN = 0;
        AppMethodBeat.o(110497);
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.i(110498);
        com.tencent.mm.plugin.story.ui.a.e eVar = this.skI;
        if (eVar != null) {
            eVar.setSelection(num);
            AppMethodBeat.o(110498);
            return;
        }
        AppMethodBeat.o(110498);
    }

    public static final /* synthetic */ void o(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(110504);
        View view = editorAudioSearchView.sky;
        if (view != null) {
            view.setVisibility(8);
        }
        view = editorAudioSearchView.skz;
        if (view != null) {
            view.setVisibility(0);
            AppMethodBeat.o(110504);
            return;
        }
        AppMethodBeat.o(110504);
    }

    public static final /* synthetic */ void b(EditorAudioSearchView editorAudioSearchView, boolean z) {
        AppMethodBeat.i(110505);
        ab.d(editorAudioSearchView.TAG, "doSearch " + editorAudioSearchView.skL);
        if (!bo.isNullOrNil(editorAudioSearchView.skL)) {
            if (!z) {
                LinearLayout linearLayout = editorAudioSearchView.skF;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                RecyclerView recyclerView = editorAudioSearchView.skD;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                TextView textView = editorAudioSearchView.skE;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
            long j = editorAudioSearchView.skJ;
            String str = editorAudioSearchView.skL;
            if (str == null) {
                a.f.b.j.dWJ();
            }
            new com.tencent.mm.plugin.story.model.audio.e(j, str, editorAudioSearchView.skK, editorAudioSearchView.skO, (byte) 0).acy().b((com.tencent.mm.vending.c.a) new b(editorAudioSearchView, z));
        }
        AppMethodBeat.o(110505);
    }

    public static final /* synthetic */ void a(EditorAudioSearchView editorAudioSearchView, LinkedList linkedList, boolean z) {
        AudioCacheInfo a;
        AppMethodBeat.i(110507);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : linkedList) {
            int i2 = i + 1;
            if (i < 0) {
                a.a.l.dWs();
            }
            bql bql = (bql) next;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
            aVar = AudioCacheInfo.rUj;
            a = com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a.a(bql, AudioCacheInfo.rUe);
            aVar = AudioCacheInfo.rUj;
            a.cvd = AudioCacheInfo.rUi;
            a.position = 0;
            a.rUb = editorAudioSearchView.skO;
            arrayList.add(a);
            i = i2;
        }
        if (linkedList.size() == 10) {
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2 = AudioCacheInfo.rUj;
            a = new AudioCacheInfo();
            a.type = AudioCacheInfo.rUg;
            arrayList.add(a);
        }
        if (linkedList.isEmpty() && editorAudioSearchView.skK == 1) {
            editorAudioSearchView.cCt();
            AppMethodBeat.o(110507);
            return;
        }
        LinearLayout linearLayout = editorAudioSearchView.skF;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RecyclerView recyclerView = editorAudioSearchView.skD;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        TextView textView = editorAudioSearchView.skE;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (z) {
            com.tencent.mm.plugin.story.ui.a.e eVar = editorAudioSearchView.skI;
            if (eVar != null) {
                eVar.dH(arrayList);
                AppMethodBeat.o(110507);
                return;
            }
            AppMethodBeat.o(110507);
            return;
        }
        com.tencent.mm.plugin.story.ui.a.e eVar2 = editorAudioSearchView.skI;
        if (eVar2 != null) {
            eVar2.dG(arrayList);
            AppMethodBeat.o(110507);
            return;
        }
        AppMethodBeat.o(110507);
    }
}
