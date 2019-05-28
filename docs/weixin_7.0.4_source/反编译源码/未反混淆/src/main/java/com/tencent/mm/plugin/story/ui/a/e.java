package com.tencent.mm.plugin.story.ui.a;

import a.a.t;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.ui.view.AudioWaveView;
import com.tencent.mm.plugin.story.ui.view.editor.item.MusicLrcView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00071234567B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 J\u0014\u0010!\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\nJ\b\u0010#\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0006\u0010%\u001a\u00020\nJ\u001c\u0010&\u001a\u00020\u000f2\n\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0016J\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0015J\u0015\u0010.\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000RL\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-story_release"})
public final class e extends android.support.v7.widget.RecyclerView.a<a> {
    private static final String TAG = TAG;
    public static final b sfx = new b();
    public int llU = -1;
    public m<? super Integer, ? super AudioCacheInfo, y> llV;
    public final ArrayList<AudioCacheInfo> sfu = new ArrayList();
    public String sfv;
    private v sfw;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    public final class e extends a {
        final /* synthetic */ e sfy;

        public e(e eVar, View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(eVar, view);
            AppMethodBeat.i(110107);
            AppMethodBeat.o(110107);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchTipView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "searchresultIcon", "Landroid/widget/ImageView;", "getSearchresultIcon", "()Landroid/widget/ImageView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    public final class g extends a {
        private final ImageView sfD;
        private final TextView sfE;
        private final MusicLrcView sfF;
        final /* synthetic */ e sfy;

        public g(e eVar, View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(eVar, view);
            AppMethodBeat.i(110110);
            View findViewById = view.findViewById(R.id.eu7);
            j.o(findViewById, "itemView.findViewById(R.…audio_search_result_icon)");
            this.sfD = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.eu8);
            j.o(findViewById, "itemView.findViewById(R.…udio_search_result_title)");
            this.sfE = (TextView) findViewById;
            findViewById = view.findViewById(R.id.eu9);
            j.o(findViewById, "itemView.findViewById(R.…_audio_search_result_tip)");
            this.sfF = (MusicLrcView) findViewById;
            AppMethodBeat.o(110110);
        }

        public final void a(int i, AudioCacheInfo audioCacheInfo) {
            CharSequence charSequence;
            AppMethodBeat.i(110109);
            j.p(audioCacheInfo, "info");
            boolean z = i == this.sfy.llU;
            View view = this.apJ;
            j.o(view, "itemView");
            view.setSelected(z);
            ImageView imageView = this.sfD;
            view = this.apJ;
            j.o(view, "itemView");
            imageView.setImageDrawable(ah.f(view.getContext(), R.raw.icons_filled_music, z ? WebView.NIGHT_MODE_COLOR : -1));
            TextView textView = this.sfE;
            if (audioCacheInfo.rTY.isEmpty()) {
                charSequence = audioCacheInfo.rUa;
            } else {
                charSequence = audioCacheInfo.rUa + " - " + bo.c((List) audioCacheInfo.rTY, ",");
            }
            textView.setText(charSequence);
            this.sfF.setShow(z);
            this.sfF.setPlayer(this.sfy.sfw);
            this.sfF.f(audioCacheInfo.rTX, this.sfy.sfv);
            AppMethodBeat.o(110109);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    public final class d extends a {
        private final ImageView nmi;
        private final View sfA;
        private final MusicLrcView sfB;
        private final AudioWaveView sfC;
        final /* synthetic */ e sfy;

        public d(e eVar, View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(eVar, view);
            AppMethodBeat.i(110106);
            View findViewById = view.findViewById(R.id.esm);
            j.o(findViewById, "itemView.findViewById(R.…story_item_audio_loading)");
            this.sfA = findViewById;
            findViewById = view.findViewById(R.id.eu0);
            j.o(findViewById, "itemView.findViewById(R.…story_item_audio_preview)");
            this.nmi = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.eu2);
            j.o(findViewById, "itemView.findViewById(R.id.story_item_audio_title)");
            this.sfB = (MusicLrcView) findViewById;
            findViewById = view.findViewById(R.id.eu1);
            j.o(findViewById, "itemView.findViewById(R.id.waveView)");
            this.sfC = (AudioWaveView) findViewById;
            AppMethodBeat.o(110106);
        }

        public final void a(int i, AudioCacheInfo audioCacheInfo) {
            boolean z = true;
            int i2 = WebView.NIGHT_MODE_COLOR;
            AppMethodBeat.i(110105);
            j.p(audioCacheInfo, "info");
            View view = this.apJ;
            j.o(view, "itemView");
            view.setEnabled(true);
            if (i != this.sfy.llU) {
                z = false;
            }
            view = this.apJ;
            j.o(view, "itemView");
            view.setSelected(z);
            ab.i(e.TAG, "LogStory: ".concat(String.valueOf(z)));
            ImageView imageView = this.nmi;
            view = this.apJ;
            j.o(view, "itemView");
            imageView.setImageDrawable(ah.f(view.getContext(), R.raw.icons_filled_music, z ? WebView.NIGHT_MODE_COLOR : -1));
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
            MusicLrcView.a(this.sfB, audioCacheInfo.rTX);
            this.sfB.setVisibility(0);
            this.sfA.setVisibility(8);
            AppMethodBeat.o(110105);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    public final class f extends a {
        final /* synthetic */ e sfy;

        public f(e eVar, View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(eVar, view);
            AppMethodBeat.i(110108);
            AppMethodBeat.o(110108);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    public class a extends RecyclerView.v {
        final /* synthetic */ e sfy;

        public a(e eVar, final View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(view);
            AppMethodBeat.i(110103);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a sfz;

                public final void onClick(View view) {
                    AppMethodBeat.i(110101);
                    int kj = this.sfz.kj();
                    AudioCacheInfo Fg = this.sfz.sfy.Fg(kj);
                    if (Fg != null) {
                        m mVar = this.sfz.sfy.llV;
                        if (mVar != null) {
                            mVar.m(Integer.valueOf(kj), Fg);
                        }
                    }
                    view.requestFocus();
                    AppMethodBeat.o(110101);
                }
            });
            AppMethodBeat.o(110103);
        }

        public void a(int i, AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(110102);
            j.p(audioCacheInfo, "info");
            AppMethodBeat.o(110102);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
    public final class c extends a {
        final /* synthetic */ e sfy;

        public c(e eVar, View view) {
            j.p(view, "itemView");
            this.sfy = eVar;
            super(eVar, view);
            AppMethodBeat.i(110104);
            AppMethodBeat.o(110104);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public e() {
        AppMethodBeat.i(110120);
        AppMethodBeat.o(110120);
    }

    static {
        AppMethodBeat.i(110121);
        AppMethodBeat.o(110121);
    }

    public final void dG(List<AudioCacheInfo> list) {
        AppMethodBeat.i(110111);
        j.p(list, "audios");
        this.sfu.clear();
        this.sfu.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(110111);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dH(List<AudioCacheInfo> list) {
        AudioCacheInfo audioCacheInfo;
        Object obj;
        AppMethodBeat.i(110112);
        j.p(list, "audios");
        int size = this.sfu.size();
        List list2 = this.sfu;
        ListIterator listIterator = list2.listIterator(list2.size());
        while (listIterator.hasPrevious()) {
            Object previous = listIterator.previous();
            audioCacheInfo = (AudioCacheInfo) previous;
            int i = audioCacheInfo.type;
            com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
            if (i != AudioCacheInfo.rUf) {
                i = audioCacheInfo.type;
                aVar = AudioCacheInfo.rUj;
                if (i != AudioCacheInfo.rUg) {
                    int i2 = audioCacheInfo.type;
                    com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar2 = AudioCacheInfo.rUj;
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
            at(size, list.size());
            AppMethodBeat.o(110112);
            return;
        }
        this.sfu.addAll(list);
        cg(size2);
        at(size, list.size() - 1);
        AppMethodBeat.o(110112);
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.i(110113);
        if (num == null) {
            cg(this.llU);
            this.llU = -1;
            cg(this.llU);
            AppMethodBeat.o(110113);
            return;
        }
        cg(this.llU);
        this.llU = num.intValue();
        cg(this.llU);
        AppMethodBeat.o(110113);
    }

    public final void setMusicPlayer(v vVar) {
        AppMethodBeat.i(110114);
        j.p(vVar, "player");
        this.sfw = vVar;
        AppMethodBeat.o(110114);
    }

    public final AudioCacheInfo Fg(int i) {
        AppMethodBeat.i(110115);
        AudioCacheInfo audioCacheInfo = (AudioCacheInfo) t.x(this.sfu, i);
        AppMethodBeat.o(110115);
        return audioCacheInfo;
    }

    public final int getItemCount() {
        AppMethodBeat.i(110116);
        int size = this.sfu.size();
        AppMethodBeat.o(110116);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(110117);
        AudioCacheInfo Fg = Fg(i);
        int i2;
        if (Fg != null) {
            i2 = Fg.type;
            AppMethodBeat.o(110117);
            return i2;
        }
        com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a aVar = AudioCacheInfo.rUj;
        i2 = AudioCacheInfo.rUc;
        AppMethodBeat.o(110117);
        return i2;
    }
}
