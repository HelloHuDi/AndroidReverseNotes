package com.tencent.mm.plugin.emojicapture.ui.a;

import a.a.t;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 $2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004#$%&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u001c\u0010\u0019\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\"RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0013j\b\u0012\u0004\u0012\u00020\n`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "audios", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class a extends android.support.v7.widget.RecyclerView.a<a> {
    public static final String TAG = TAG;
    private static final int llW = 1;
    private static final int llX = 2;
    public static final b llY = new b();
    public final ArrayList<com.tencent.mm.plugin.emojicapture.model.a.b> llT = new ArrayList();
    public int llU = -1;
    public m<? super Integer, ? super com.tencent.mm.plugin.emojicapture.model.a.b, y> llV;

    @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    public abstract class a extends v {
        final TextView gHg;
        final ImageView iNr;
        final /* synthetic */ a llZ;

        public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b bVar);

        public a(a aVar, final View view) {
            j.p(view, "itemView");
            this.llZ = aVar;
            super(view);
            this.iNr = (ImageView) view.findViewById(R.id.bda);
            this.gHg = (TextView) view.findViewById(R.id.bdb);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a lma;

                public final void onClick(View view) {
                    AppMethodBeat.i(2933);
                    int kj = this.lma.kj();
                    com.tencent.mm.plugin.emojicapture.model.a.b uE = this.lma.llZ.uE(kj);
                    if (uE != null) {
                        m mVar = this.lma.llZ.llV;
                        if (mVar != null) {
                            mVar.m(Integer.valueOf(kj), uE);
                        }
                    }
                    view.requestFocus();
                    AppMethodBeat.o(2933);
                }
            });
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEmpty", "", "getViewTypeEmpty", "()I", "ViewTypeNormal", "getViewTypeNormal", "plugin-emojicapture_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    public final class c extends a {
        final /* synthetic */ a llZ;

        public c(a aVar, View view) {
            j.p(view, "itemView");
            this.llZ = aVar;
            super(aVar, view);
            AppMethodBeat.i(2935);
            AppMethodBeat.o(2935);
        }

        public final void b(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
            AppMethodBeat.i(2934);
            j.p(bVar, "info");
            ImageView imageView = this.iNr;
            j.o(imageView, "icon");
            ImageView imageView2 = this.iNr;
            j.o(imageView2, "icon");
            com.tencent.mm.plugin.emojicapture.ui.a.a(imageView, com.tencent.mm.plugin.emojicapture.ui.a.dg(imageView2));
            AppMethodBeat.o(2934);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    public final class d extends a {
        final /* synthetic */ a llZ;

        public d(a aVar, View view) {
            j.p(view, "itemView");
            this.llZ = aVar;
            super(aVar, view);
            AppMethodBeat.i(2937);
            AppMethodBeat.o(2937);
        }

        public final void b(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
            AppMethodBeat.i(2936);
            j.p(bVar, "info");
            e eVar = e.eOD;
            com.tencent.mm.loader.a.b lR = e.Tb().lR(bVar.hNN);
            ImageView imageView = this.iNr;
            j.o(imageView, "icon");
            lR.d(imageView);
            TextView textView = this.gHg;
            j.o(textView, "text");
            textView.setText(bVar.name);
            AppMethodBeat.o(2936);
        }
    }

    public a() {
        AppMethodBeat.i(2942);
        AppMethodBeat.o(2942);
    }

    static {
        AppMethodBeat.i(2943);
        AppMethodBeat.o(2943);
    }

    public final com.tencent.mm.plugin.emojicapture.model.a.b uE(int i) {
        AppMethodBeat.i(2938);
        com.tencent.mm.plugin.emojicapture.model.a.b bVar = (com.tencent.mm.plugin.emojicapture.model.a.b) t.x(this.llT, i);
        AppMethodBeat.o(2938);
        return bVar;
    }

    public final int getItemCount() {
        AppMethodBeat.i(2939);
        int size = this.llT.size();
        AppMethodBeat.o(2939);
        return size;
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return llX;
        }
        return llW;
    }
}
