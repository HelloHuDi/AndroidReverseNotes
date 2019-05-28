package com.tencent.p177mm.plugin.story.p536ui.p1037a;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C0884v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.p536ui.view.AudioWaveView;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.MusicLrcView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00071234567B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 J\u0014\u0010!\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\nJ\b\u0010#\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0006\u0010%\u001a\u00020\nJ\u001c\u0010&\u001a\u00020\u000f2\n\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0016J\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0015J\u0015\u0010.\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000RL\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.a.e */
public final class C29320e extends C41523a<C29321a> {
    private static final String TAG = TAG;
    public static final C29323b sfx = new C29323b();
    public int llU = -1;
    public C31591m<? super Integer, ? super AudioCacheInfo, C37091y> llV;
    public final ArrayList<AudioCacheInfo> sfu = new ArrayList();
    public String sfv;
    private C0884v sfw;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$e */
    public final class C22256e extends C29321a {
        final /* synthetic */ C29320e sfy;

        public C22256e(C29320e c29320e, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(c29320e, view);
            AppMethodBeat.m2504i(110107);
            AppMethodBeat.m2505o(110107);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchTipView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "searchresultIcon", "Landroid/widget/ImageView;", "getSearchresultIcon", "()Landroid/widget/ImageView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$g */
    public final class C22257g extends C29321a {
        private final ImageView sfD;
        private final TextView sfE;
        private final MusicLrcView sfF;
        final /* synthetic */ C29320e sfy;

        public C22257g(C29320e c29320e, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(c29320e, view);
            AppMethodBeat.m2504i(110110);
            View findViewById = view.findViewById(2131828172);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…audio_search_result_icon)");
            this.sfD = (ImageView) findViewById;
            findViewById = view.findViewById(2131828173);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…udio_search_result_title)");
            this.sfE = (TextView) findViewById;
            findViewById = view.findViewById(2131828174);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…_audio_search_result_tip)");
            this.sfF = (MusicLrcView) findViewById;
            AppMethodBeat.m2505o(110110);
        }

        /* renamed from: a */
        public final void mo37784a(int i, AudioCacheInfo audioCacheInfo) {
            CharSequence charSequence;
            AppMethodBeat.m2504i(110109);
            C25052j.m39376p(audioCacheInfo, "info");
            boolean z = i == this.sfy.llU;
            View view = this.apJ;
            C25052j.m39375o(view, "itemView");
            view.setSelected(z);
            ImageView imageView = this.sfD;
            view = this.apJ;
            C25052j.m39375o(view, "itemView");
            imageView.setImageDrawable(C5225ah.m7962f(view.getContext(), C1318a.icons_filled_music, z ? WebView.NIGHT_MODE_COLOR : -1));
            TextView textView = this.sfE;
            if (audioCacheInfo.rTY.isEmpty()) {
                charSequence = audioCacheInfo.rUa;
            } else {
                charSequence = audioCacheInfo.rUa + " - " + C5046bo.m7536c((List) audioCacheInfo.rTY, ",");
            }
            textView.setText(charSequence);
            this.sfF.setShow(z);
            this.sfF.setPlayer(this.sfy.sfw);
            this.sfF.mo69296f(audioCacheInfo.rTX, this.sfy.sfv);
            AppMethodBeat.m2505o(110109);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$d */
    public final class C29318d extends C29321a {
        private final ImageView nmi;
        private final View sfA;
        private final MusicLrcView sfB;
        private final AudioWaveView sfC;
        final /* synthetic */ C29320e sfy;

        public C29318d(C29320e c29320e, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(c29320e, view);
            AppMethodBeat.m2504i(110106);
            View findViewById = view.findViewById(2131828114);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…story_item_audio_loading)");
            this.sfA = findViewById;
            findViewById = view.findViewById(2131828165);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…story_item_audio_preview)");
            this.nmi = (ImageView) findViewById;
            findViewById = view.findViewById(2131828167);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.id.story_item_audio_title)");
            this.sfB = (MusicLrcView) findViewById;
            findViewById = view.findViewById(2131828166);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.id.waveView)");
            this.sfC = (AudioWaveView) findViewById;
            AppMethodBeat.m2505o(110106);
        }

        /* renamed from: a */
        public final void mo37784a(int i, AudioCacheInfo audioCacheInfo) {
            boolean z = true;
            int i2 = WebView.NIGHT_MODE_COLOR;
            AppMethodBeat.m2504i(110105);
            C25052j.m39376p(audioCacheInfo, "info");
            View view = this.apJ;
            C25052j.m39375o(view, "itemView");
            view.setEnabled(true);
            if (i != this.sfy.llU) {
                z = false;
            }
            view = this.apJ;
            C25052j.m39375o(view, "itemView");
            view.setSelected(z);
            C4990ab.m7416i(C29320e.TAG, "LogStory: ".concat(String.valueOf(z)));
            ImageView imageView = this.nmi;
            view = this.apJ;
            C25052j.m39375o(view, "itemView");
            imageView.setImageDrawable(C5225ah.m7962f(view.getContext(), C1318a.icons_filled_music, z ? WebView.NIGHT_MODE_COLOR : -1));
            this.nmi.setVisibility(0);
            this.sfC.setVisibility(0);
            this.sfC.setShow(z);
            this.sfC.setPlayer(this.sfy.sfw);
            this.sfB.setShow(z);
            MusicLrcView musicLrcView = this.sfB;
            if (!z) {
                i2 = -1;
            }
            musicLrcView.setTextColor(i2);
            this.sfB.setPlayer(this.sfy.sfw);
            MusicLrcView.m78192a(this.sfB, audioCacheInfo.rTX);
            this.sfB.setVisibility(0);
            this.sfA.setVisibility(8);
            AppMethodBeat.m2505o(110105);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$f */
    public final class C29319f extends C29321a {
        final /* synthetic */ C29320e sfy;

        public C29319f(C29320e c29320e, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(c29320e, view);
            AppMethodBeat.m2504i(110108);
            AppMethodBeat.m2505o(110108);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$a */
    public class C29321a extends C41531v {
        final /* synthetic */ C29320e sfy;

        public C29321a(C29320e c29320e, final View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(view);
            AppMethodBeat.m2504i(110103);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C29321a sfz;

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(110101);
                    int kj = this.sfz.mo66454kj();
                    AudioCacheInfo Fg = this.sfz.sfy.mo47522Fg(kj);
                    if (Fg != null) {
                        C31591m c31591m = this.sfz.sfy.llV;
                        if (c31591m != null) {
                            c31591m.mo212m(Integer.valueOf(kj), Fg);
                        }
                    }
                    view.requestFocus();
                    AppMethodBeat.m2505o(110101);
                }
            });
            AppMethodBeat.m2505o(110103);
        }

        /* renamed from: a */
        public void mo37784a(int i, AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.m2504i(110102);
            C25052j.m39376p(audioCacheInfo, "info");
            AppMethodBeat.m2505o(110102);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$c */
    public final class C29322c extends C29321a {
        final /* synthetic */ C29320e sfy;

        public C29322c(C29320e c29320e, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfy = c29320e;
            super(c29320e, view);
            AppMethodBeat.m2504i(110104);
            AppMethodBeat.m2505o(110104);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.e$b */
    public static final class C29323b {
        private C29323b() {
        }

        public /* synthetic */ C29323b(byte b) {
            this();
        }
    }

    public C29320e() {
        AppMethodBeat.m2504i(110120);
        AppMethodBeat.m2505o(110120);
    }

    static {
        AppMethodBeat.m2504i(110121);
        AppMethodBeat.m2505o(110121);
    }

    /* renamed from: dG */
    public final void mo47523dG(List<AudioCacheInfo> list) {
        AppMethodBeat.m2504i(110111);
        C25052j.m39376p(list, "audios");
        this.sfu.clear();
        this.sfu.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(110111);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dH */
    public final void mo47524dH(List<AudioCacheInfo> list) {
        AudioCacheInfo audioCacheInfo;
        Object obj;
        AppMethodBeat.m2504i(110112);
        C25052j.m39376p(list, "audios");
        int size = this.sfu.size();
        List list2 = this.sfu;
        ListIterator listIterator = list2.listIterator(list2.size());
        while (listIterator.hasPrevious()) {
            Object previous = listIterator.previous();
            audioCacheInfo = (AudioCacheInfo) previous;
            int i = audioCacheInfo.type;
            C4123a c4123a = AudioCacheInfo.rUj;
            if (i != AudioCacheInfo.rUf) {
                i = audioCacheInfo.type;
                c4123a = AudioCacheInfo.rUj;
                if (i != AudioCacheInfo.rUg) {
                    int i2 = audioCacheInfo.type;
                    C4123a c4123a2 = AudioCacheInfo.rUj;
                    if (i2 != AudioCacheInfo.rUd) {
                        obj = null;
                        continue;
                        if (obj != null) {
                            obj = previous;
                            break;
                        }
                    }
                }
            }
            obj = 1;
            continue;
            if (obj != null) {
            }
        }
        obj = null;
        audioCacheInfo = (AudioCacheInfo) obj;
        if (audioCacheInfo != null) {
            this.sfu.remove(audioCacheInfo);
        }
        int size2 = this.sfu.size();
        if (size == size2) {
            this.sfu.addAll(list);
            mo66310at(size, list.size());
            AppMethodBeat.m2505o(110112);
            return;
        }
        this.sfu.addAll(list);
        mo66316cg(size2);
        mo66310at(size, list.size() - 1);
        AppMethodBeat.m2505o(110112);
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.m2504i(110113);
        if (num == null) {
            mo66316cg(this.llU);
            this.llU = -1;
            mo66316cg(this.llU);
            AppMethodBeat.m2505o(110113);
            return;
        }
        mo66316cg(this.llU);
        this.llU = num.intValue();
        mo66316cg(this.llU);
        AppMethodBeat.m2505o(110113);
    }

    public final void setMusicPlayer(C0884v c0884v) {
        AppMethodBeat.m2504i(110114);
        C25052j.m39376p(c0884v, "player");
        this.sfw = c0884v;
        AppMethodBeat.m2505o(110114);
    }

    /* renamed from: Fg */
    public final AudioCacheInfo mo47522Fg(int i) {
        AppMethodBeat.m2504i(110115);
        AudioCacheInfo audioCacheInfo = (AudioCacheInfo) C25035t.m39361x(this.sfu, i);
        AppMethodBeat.m2505o(110115);
        return audioCacheInfo;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(110116);
        int size = this.sfu.size();
        AppMethodBeat.m2505o(110116);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(110117);
        AudioCacheInfo Fg = mo47522Fg(i);
        int i2;
        if (Fg != null) {
            i2 = Fg.type;
            AppMethodBeat.m2505o(110117);
            return i2;
        }
        C4123a c4123a = AudioCacheInfo.rUj;
        i2 = AudioCacheInfo.rUc;
        AppMethodBeat.m2505o(110117);
        return i2;
    }
}
