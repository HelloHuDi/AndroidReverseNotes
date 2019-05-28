package com.tencent.p177mm.plugin.story.p536ui.view.editor;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41530m;
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
import com.google.android.exoplayer2.C0884v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C18438bd;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.model.audio.C22219b;
import com.tencent.p177mm.plugin.story.model.audio.C22219b.C13771a;
import com.tencent.p177mm.plugin.story.model.audio.C22221e;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C29320e;
import com.tencent.p177mm.protocal.protobuf.C30194jc;
import com.tencent.p177mm.protocal.protobuf.bql;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001)\u0018\u00002\u00020\u0001:\u0001ZB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020;H\u0002J\u001e\u0010A\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020=H\u0002J\u0006\u0010F\u001a\u00020;J\b\u0010G\u001a\u00020=H\u0002J\u0006\u0010H\u001a\u00020=J\u000e\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020\tJ\u0006\u0010K\u001a\u00020=J\u0010\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020;H\u0002J\u000e\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020PJ\u0015\u0010Q\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010RJ\u000e\u0010S\u001a\u00020=2\u0006\u0010F\u001a\u00020;J\b\u0010T\u001a\u00020=H\u0002J\u001e\u0010U\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020 0V2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010W\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020=H\u0002J\b\u0010Y\u001a\u00020=H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView */
public final class EditorAudioSearchView extends RelativeLayout {
    private final String TAG = "MicroMsg.EditorAudioSearchView";
    private final Runnable lnE = new C29356n(this);
    private Button nsJ;
    /* renamed from: sC */
    int f13713sC = -1;
    private View skA;
    private TextView skB;
    EditText skC;
    private RecyclerView skD;
    private TextView skE;
    private LinearLayout skF;
    private ImageView skG;
    private ImageView skH;
    private C29320e skI;
    private long skJ;
    private int skK;
    private String skL;
    private AudioCacheInfo skM;
    private long skN;
    private long skO;
    C29347a skP;
    private final C29350l skQ = new C29350l(this);
    private int skx;
    private View sky;
    private View skz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$h */
    static final class C13863h implements OnEditorActionListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C13863h(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(110481);
            if (3 == i) {
                CharSequence text;
                String obj;
                if (this.skR.skL != null) {
                    String h = this.skR.skL;
                    C25052j.m39375o(textView, "textView");
                    text = textView.getText();
                    if (!C5046bo.isEqual(h, text != null ? text.toString() : null)) {
                        EditorAudioSearchView.m46589f(this.skR);
                        C13771a c13771a = C22219b.rUx;
                        C22219b.rUw.mo33694cH(2);
                        c13771a = C22219b.rUx;
                        C13771a.cyU();
                        c13771a = C22219b.rUx;
                        C22219b.rUw.mo33697cK(this.skR.getMRelatedRecId());
                    }
                }
                EditorAudioSearchView editorAudioSearchView = this.skR;
                C25052j.m39375o(textView, "textView");
                text = textView.getText();
                if (text != null) {
                    obj = text.toString();
                } else {
                    obj = null;
                }
                editorAudioSearchView.skL = obj;
                if (!C5046bo.isNullOrNil(this.skR.skL)) {
                    C29320e c = this.skR.skI;
                    if (c != null) {
                        c.setSelection(null);
                    }
                    c = this.skR.skI;
                    if (c != null) {
                        c.setSelection(null);
                    }
                    RecyclerView i2 = this.skR.skD;
                    if (i2 != null) {
                        i2.mo61465bY(0);
                    }
                    C29320e c2 = this.skR.skI;
                    if (c2 != null) {
                        c2.mo47523dG(new LinkedList());
                    }
                    Button j = this.skR.nsJ;
                    if (j != null) {
                        j.setEnabled(false);
                    }
                    this.skR.skJ = 0;
                    this.skR.f13713sC = -1;
                    this.skR.skK = 0;
                    c = this.skR.skI;
                    if (c != null) {
                        c.sfv = this.skR.skL;
                    }
                    this.skR.skM = null;
                    this.skR.skN = 0;
                    EditorAudioSearchView.m46598o(this.skR);
                    EditorAudioSearchView.m46585b(this.skR, false);
                    C29347a callback = this.skR.getCallback();
                    if (callback != null) {
                        callback.cCv();
                    }
                }
            }
            AppMethodBeat.m2505o(110481);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$i */
    static final class C13864i extends C25053k implements C31591m<Integer, AudioCacheInfo, C37091y> {
        final /* synthetic */ EditorAudioSearchView skR;

        C13864i(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(110482);
            int intValue = ((Number) obj).intValue();
            C25052j.m39376p((AudioCacheInfo) obj2, "info");
            C29320e c = this.skR.skI;
            if (c == null || intValue != c.getItemCount()) {
                this.skR.mo47562Fj(intValue);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110482);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$k */
    static final class C13865k implements OnClickListener {
        public static final C13865k skT = new C13865k();

        static {
            AppMethodBeat.m2504i(110484);
            AppMethodBeat.m2505o(110484);
        }

        C13865k() {
        }

        public final void onClick(View view) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BgmSearchResp;", "call"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$b */
    static final class C22293b<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ EditorAudioSearchView skR;
        final /* synthetic */ boolean skS;

        C22293b(EditorAudioSearchView editorAudioSearchView, boolean z) {
            this.skR = editorAudioSearchView;
            this.skS = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(110475);
            C37441a c37441a = (C37441a) obj;
            int i = c37441a.errType;
            int i2 = c37441a.errCode;
            C4990ab.m7416i(this.skR.TAG, "LogStory: SearchdMusic callback " + i + ' ' + i2 + ", " + c37441a.aIm);
            if (i == 0 && i2 == 0) {
                C30194jc c30194jc = (C30194jc) c37441a.fsy;
                this.skR.skJ = c30194jc.rUb;
                EditorAudioSearchView editorAudioSearchView = this.skR;
                editorAudioSearchView.skK = editorAudioSearchView.skK + 1;
                LinkedList linkedList = c30194jc.vKY;
                EditorAudioSearchView editorAudioSearchView2 = this.skR;
                C25052j.m39375o(linkedList, "audioList");
                EditorAudioSearchView.m46582a(editorAudioSearchView2, linkedList, this.skS);
                C13771a c13771a = C22219b.rUx;
                C22219b.rUw.mo33696cJ(this.skR.skJ);
                c13771a = C22219b.rUx;
                C22219b.rUw.mo33698fT(this.skR.skL);
                C4990ab.m7416i(this.skR.TAG, "get audio list ".concat(String.valueOf(c30194jc)));
                Object obj2 = C5681a.zXH;
                AppMethodBeat.m2505o(110475);
                return obj2;
            }
            if (this.skR.skK == 0) {
                EditorAudioSearchView.m46600q(this.skR);
            }
            Void voidR = C5681a.zXH;
            AppMethodBeat.m2505o(110475);
            return voidR;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$a */
    public interface C29347a {
        /* renamed from: b */
        void mo47556b(AudioCacheInfo audioCacheInfo);

        /* renamed from: c */
        void mo47557c(AudioCacheInfo audioCacheInfo);

        void cCv();

        void cCw();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$c */
    static final class C29348c implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C29348c(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110476);
            EditText a = this.skR.skC;
            if (a != null) {
                Editable text = a.getText();
                if (text != null) {
                    if ((((CharSequence) text).length() == 0 ? 1 : null) == null) {
                        a = this.skR.skC;
                        if (a != null) {
                            a.setText(null);
                            AppMethodBeat.m2505o(110476);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(110476);
                    return;
                }
            }
            AppMethodBeat.m2505o(110476);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$j */
    static final class C29349j implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C29349j(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110483);
            EditorAudioSearchView.m46584b(this.skR);
            AppMethodBeat.m2505o(110483);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$l */
    public static final class C29350l extends C41530m {
        final /* synthetic */ EditorAudioSearchView skR;

        C29350l(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(110485);
            C25052j.m39376p(recyclerView, "recyclerView");
            super.mo6643c(recyclerView, i);
            if (i == 0) {
                C17480i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.m2505o(110485);
                    throw c44941v;
                }
                int iS = ((LinearLayoutManager) layoutManager).mo1782iS();
                C13771a c13771a = C22219b.rUx;
                C22219b.rUw.mo33695cI((long) iS);
                C29320e c = this.skR.skI;
                if (c != null) {
                    if (iS == c.getItemCount() - 1) {
                        AudioCacheInfo Fg = c.mo47522Fg(iS);
                        if (Fg != null) {
                            iS = Fg.type;
                            C4123a c4123a = AudioCacheInfo.rUj;
                            if (iS == AudioCacheInfo.rUg) {
                                EditorAudioSearchView.m46585b(this.skR, true);
                            }
                        } else {
                            AppMethodBeat.m2505o(110485);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(110485);
                    return;
                }
            }
            AppMethodBeat.m2505o(110485);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$d */
    static final class C29351d implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C29351d(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110477);
            EditorAudioSearchView.m46584b(this.skR);
            AppMethodBeat.m2505o(110477);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$f */
    static final class C29352f implements OnFocusChangeListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C29352f(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(110479);
            EditorAudioSearchView.m46583a(this.skR, z);
            AppMethodBeat.m2505o(110479);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$m */
    static final class C29353m implements Runnable {
        final /* synthetic */ EditorAudioSearchView skR;

        C29353m(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110486);
            this.skR.setVisibility(8);
            AppMethodBeat.m2505o(110486);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$g */
    public static final class C29354g implements TextWatcher {
        final /* synthetic */ EditorAudioSearchView skR;

        C29354g(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(110480);
            ImageView g;
            if ((editable != null ? editable.length() : 0) > 0) {
                g = this.skR.skG;
                if (g != null) {
                    g.setVisibility(0);
                    AppMethodBeat.m2505o(110480);
                    return;
                }
                AppMethodBeat.m2505o(110480);
                return;
            }
            g = this.skR.skG;
            if (g != null) {
                g.setVisibility(8);
                AppMethodBeat.m2505o(110480);
                return;
            }
            AppMethodBeat.m2505o(110480);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$e */
    static final class C29355e implements OnClickListener {
        final /* synthetic */ EditorAudioSearchView skR;

        C29355e(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110478);
            C29320e c = this.skR.skI;
            if (c != null) {
                C13771a c13771a;
                if (this.skR.f13713sC == -1 || this.skR.f13713sC >= c.getItemCount()) {
                    C29347a callback = this.skR.getCallback();
                    if (callback != null) {
                        callback.mo47556b(null);
                    }
                    EditorAudioSearchView.m46589f(this.skR);
                    c13771a = C22219b.rUx;
                    C22219b.rUw.mo33694cH(1);
                    c13771a = C22219b.rUx;
                    C13771a.cyU();
                } else {
                    C29347a callback2 = this.skR.getCallback();
                    if (callback2 != null) {
                        callback2.mo47556b(c.mo47522Fg(this.skR.f13713sC));
                    }
                    EditorAudioSearchView.m46589f(this.skR);
                    c13771a = C22219b.rUx;
                    C22219b.rUw.mo33694cH(0);
                    c13771a = C22219b.rUx;
                    C13771a.cyU();
                }
                this.skR.reset();
            }
            EditText a = this.skR.skC;
            if (a != null) {
                a.clearFocus();
                AppMethodBeat.m2505o(110478);
                return;
            }
            AppMethodBeat.m2505o(110478);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView$n */
    static final class C29356n implements Runnable {
        final /* synthetic */ EditorAudioSearchView skR;

        C29356n(EditorAudioSearchView editorAudioSearchView) {
            this.skR = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110487);
            InputMethodManager inputMethodManager = (InputMethodManager) this.skR.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.skR.skC, 0);
                AppMethodBeat.m2505o(110487);
                return;
            }
            AppMethodBeat.m2505o(110487);
        }
    }

    /* renamed from: b */
    public static final /* synthetic */ void m46584b(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.m2504i(110501);
        editorAudioSearchView.cCr();
        AppMethodBeat.m2505o(110501);
    }

    /* renamed from: f */
    public static final /* synthetic */ void m46589f(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.m2504i(110502);
        editorAudioSearchView.cCu();
        AppMethodBeat.m2505o(110502);
    }

    /* renamed from: q */
    public static final /* synthetic */ void m46600q(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.m2504i(110506);
        editorAudioSearchView.cCt();
        AppMethodBeat.m2505o(110506);
    }

    public final long getMRelatedRecId() {
        return this.skO;
    }

    public final void setMRelatedRecId(long j) {
        this.skO = j;
    }

    public final C29347a getCallback() {
        return this.skP;
    }

    public final void setCallback(C29347a c29347a) {
        this.skP = c29347a;
    }

    public EditorAudioSearchView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110499);
        init();
        AppMethodBeat.m2505o(110499);
    }

    public EditorAudioSearchView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110500);
        init();
        AppMethodBeat.m2505o(110500);
    }

    private final void init() {
        AppMethodBeat.m2504i(110488);
        View.inflate(getContext(), 2130970877, this);
        this.skB = (TextView) findViewById(2131828103);
        this.skC = (EditText) findViewById(2131828109);
        this.nsJ = (Button) findViewById(2131828105);
        this.skD = (RecyclerView) findViewById(2131828116);
        this.skE = (TextView) findViewById(2131828112);
        this.skF = (LinearLayout) findViewById(2131828113);
        this.skG = (ImageView) findViewById(2131828108);
        this.sky = findViewById(2131828110);
        this.skz = findViewById(2131828111);
        this.skA = findViewById(2131828117);
        this.skH = (ImageView) findViewById(2131828107);
        ImageView imageView = this.skH;
        if (imageView != null) {
            imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_search, -1));
        }
        Button button = this.nsJ;
        if (button != null) {
            button.setEnabled(false);
        }
        imageView = this.skG;
        if (imageView != null) {
            imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_close2, -1));
        }
        ImageView imageView2 = this.skG;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new C29348c(this));
        }
        RecyclerView recyclerView = this.skD;
        LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        if (layoutParams == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.m2505o(110488);
            throw c44941v;
        }
        ((MarginLayoutParams) layoutParams).bottomMargin = C5230ak.m7988fr(getContext()) + C1338a.fromDPToPix(getContext(), 16);
        RecyclerView recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager(1));
        }
        recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            recyclerView2.mo66332a((C41530m) this.skQ);
        }
        this.skI = new C29320e();
        recyclerView2 = this.skD;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.skI);
        }
        TextView textView = this.skB;
        if (textView != null) {
            textView.setOnClickListener(new C29351d(this));
        }
        Button button2 = this.nsJ;
        if (button2 != null) {
            button2.setOnClickListener(new C29355e(this));
        }
        EditText editText = this.skC;
        if (editText != null) {
            editText.setOnFocusChangeListener(new C29352f(this));
        }
        editText = this.skC;
        if (editText != null) {
            editText.addTextChangedListener(new C29354g(this));
        }
        editText = this.skC;
        if (editText != null) {
            editText.setOnEditorActionListener(new C13863h(this));
        }
        C29320e c29320e = this.skI;
        if (c29320e != null) {
            c29320e.llV = new C13864i(this);
        }
        View view = this.skA;
        if (view != null) {
            view.setOnClickListener(new C29349j(this));
        }
        setOnClickListener(C13865k.skT);
        this.skx = C5230ak.m7993hy(getContext()).y;
        setTranslationY((float) this.skx);
        cCs();
        AppMethodBeat.m2505o(110488);
    }

    /* renamed from: Fj */
    public final void mo47562Fj(int i) {
        AppMethodBeat.m2504i(110489);
        C29320e c29320e = this.skI;
        if (c29320e == null || c29320e.llU != i) {
            this.f13713sC = i;
            c29320e = this.skI;
            AudioCacheInfo Fg = c29320e != null ? c29320e.mo47522Fg(i) : null;
            if (Fg != null) {
                int i2 = Fg.type;
                C4123a c4123a = AudioCacheInfo.rUj;
                if (i2 == AudioCacheInfo.rUf) {
                    C29347a c29347a = this.skP;
                    if (c29347a != null) {
                        c29347a.mo47557c(null);
                    }
                    this.skM = Fg;
                    this.skN = System.currentTimeMillis();
                }
            }
            if (Fg != null) {
                int i3 = Fg.type;
                C4123a c4123a2 = AudioCacheInfo.rUj;
                if (i3 == AudioCacheInfo.rUe) {
                    C29320e c29320e2 = this.skI;
                    if (c29320e2 != null) {
                        c29320e2.setSelection(Integer.valueOf(i));
                    }
                    C29347a c29347a2 = this.skP;
                    if (c29347a2 != null) {
                        c29347a2.mo47557c(Fg);
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
        AppMethodBeat.m2505o(110489);
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.m2504i(110490);
        if (z) {
            post(this.lnE);
            AppMethodBeat.m2505o(110490);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.m2505o(110490);
            return;
        }
        AppMethodBeat.m2505o(110490);
    }

    /* Access modifiers changed, original: final */
    public final void cCr() {
        AppMethodBeat.m2504i(110491);
        cCu();
        C13771a c13771a = C22219b.rUx;
        C22219b.rUw.mo33694cH(1);
        c13771a = C22219b.rUx;
        C13771a.cyU();
        reset();
        EditText editText = this.skC;
        if (editText != null) {
            editText.clearFocus();
        }
        C29347a c29347a = this.skP;
        if (c29347a != null) {
            c29347a.cCv();
        }
        c29347a = this.skP;
        if (c29347a != null) {
            c29347a.cCw();
            AppMethodBeat.m2505o(110491);
            return;
        }
        AppMethodBeat.m2505o(110491);
    }

    private final void cCs() {
        AppMethodBeat.m2504i(110492);
        View view = this.sky;
        if (view != null) {
            view.setVisibility(0);
        }
        view = this.skz;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.m2505o(110492);
            return;
        }
        AppMethodBeat.m2505o(110492);
    }

    private final void cCt() {
        AppMethodBeat.m2504i(110493);
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
            AppMethodBeat.m2505o(110493);
            return;
        }
        AppMethodBeat.m2505o(110493);
    }

    /* Access modifiers changed, original: final */
    public final void cCu() {
        Object obj = null;
        AppMethodBeat.m2504i(110494);
        if (this.skM != null) {
            StringBuilder stringBuilder = new StringBuilder();
            C13771a c13771a = C22219b.rUx;
            if (C5046bo.isNullOrNil(C22219b.rUw.mo33693Gw())) {
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
            C13771a c13771a2 = C22219b.rUx;
            C18438bd cyT = C22219b.rUw;
            cyT.mo33699fU(cyT.mo33693Gw() + stringBuilder.toString());
        }
        AppMethodBeat.m2505o(110494);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(110495);
        EditText editText;
        if (z) {
            C13771a c13771a = C22219b.rUx;
            C22219b.rUw.mo33697cK(this.skO);
            setVisibility(0);
            animate().translationY(0.0f).start();
            editText = this.skC;
            if (editText != null) {
                editText.requestFocus();
                AppMethodBeat.m2505o(110495);
                return;
            }
            AppMethodBeat.m2505o(110495);
            return;
        }
        animate().translationY((float) this.skx).withEndAction(new C29353m(this)).start();
        editText = this.skC;
        if (editText != null) {
            editText.clearFocus();
            AppMethodBeat.m2505o(110495);
            return;
        }
        AppMethodBeat.m2505o(110495);
    }

    public final void setMusicPlayer(C0884v c0884v) {
        AppMethodBeat.m2504i(110496);
        C25052j.m39376p(c0884v, "player");
        C29320e c29320e = this.skI;
        if (c29320e != null) {
            c29320e.setMusicPlayer(c0884v);
            AppMethodBeat.m2505o(110496);
            return;
        }
        AppMethodBeat.m2505o(110496);
    }

    public final void reset() {
        AppMethodBeat.m2504i(110497);
        this.skK = 0;
        this.f13713sC = -1;
        this.skJ = 0;
        Button button = this.nsJ;
        if (button != null) {
            button.setEnabled(false);
        }
        EditText editText = this.skC;
        if (editText != null) {
            editText.setText(null);
        }
        C29320e c29320e = this.skI;
        if (c29320e != null) {
            c29320e.setSelection(null);
        }
        RecyclerView recyclerView = this.skD;
        if (recyclerView != null) {
            recyclerView.mo61465bY(0);
        }
        C29320e c29320e2 = this.skI;
        if (c29320e2 != null) {
            c29320e2.mo47523dG(new LinkedList());
        }
        cCs();
        this.skL = null;
        this.skM = null;
        this.skN = 0;
        AppMethodBeat.m2505o(110497);
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.m2504i(110498);
        C29320e c29320e = this.skI;
        if (c29320e != null) {
            c29320e.setSelection(num);
            AppMethodBeat.m2505o(110498);
            return;
        }
        AppMethodBeat.m2505o(110498);
    }

    /* renamed from: o */
    public static final /* synthetic */ void m46598o(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.m2504i(110504);
        View view = editorAudioSearchView.sky;
        if (view != null) {
            view.setVisibility(8);
        }
        view = editorAudioSearchView.skz;
        if (view != null) {
            view.setVisibility(0);
            AppMethodBeat.m2505o(110504);
            return;
        }
        AppMethodBeat.m2505o(110504);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m46585b(EditorAudioSearchView editorAudioSearchView, boolean z) {
        AppMethodBeat.m2504i(110505);
        C4990ab.m7410d(editorAudioSearchView.TAG, "doSearch " + editorAudioSearchView.skL);
        if (!C5046bo.isNullOrNil(editorAudioSearchView.skL)) {
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
                C25052j.dWJ();
            }
            new C22221e(j, str, editorAudioSearchView.skK, editorAudioSearchView.skO, (byte) 0).acy().mo60487b((C5681a) new C22293b(editorAudioSearchView, z));
        }
        AppMethodBeat.m2505o(110505);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m46582a(EditorAudioSearchView editorAudioSearchView, LinkedList linkedList, boolean z) {
        AudioCacheInfo a;
        AppMethodBeat.m2504i(110507);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : linkedList) {
            int i2 = i + 1;
            if (i < 0) {
                C7987l.dWs();
            }
            bql bql = (bql) next;
            C4123a c4123a = AudioCacheInfo.rUj;
            c4123a = AudioCacheInfo.rUj;
            a = C4123a.m6449a(bql, AudioCacheInfo.rUe);
            c4123a = AudioCacheInfo.rUj;
            a.cvd = AudioCacheInfo.rUi;
            a.position = 0;
            a.rUb = editorAudioSearchView.skO;
            arrayList.add(a);
            i = i2;
        }
        if (linkedList.size() == 10) {
            C4123a c4123a2 = AudioCacheInfo.rUj;
            a = new AudioCacheInfo();
            a.type = AudioCacheInfo.rUg;
            arrayList.add(a);
        }
        if (linkedList.isEmpty() && editorAudioSearchView.skK == 1) {
            editorAudioSearchView.cCt();
            AppMethodBeat.m2505o(110507);
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
            C29320e c29320e = editorAudioSearchView.skI;
            if (c29320e != null) {
                c29320e.mo47524dH(arrayList);
                AppMethodBeat.m2505o(110507);
                return;
            }
            AppMethodBeat.m2505o(110507);
            return;
        }
        C29320e c29320e2 = editorAudioSearchView.skI;
        if (c29320e2 != null) {
            c29320e2.mo47523dG(arrayList);
            AppMethodBeat.m2505o(110507);
            return;
        }
        AppMethodBeat.m2505o(110507);
    }
}
