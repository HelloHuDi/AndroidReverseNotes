package com.tencent.p177mm.plugin.emojicapture.p389ui.p1396a;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.C37881e;
import com.tencent.p177mm.loader.p244a.C42151b;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 $2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004#$%&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u001c\u0010\u0019\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\"RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0013j\b\u0012\u0004\u0012\u00020\n`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "audios", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a */
public final class C45871a extends C41523a<C42979a> {
    public static final String TAG = TAG;
    private static final int llW = 1;
    private static final int llX = 2;
    public static final C42980b llY = new C42980b();
    public final ArrayList<C42971b> llT = new ArrayList();
    public int llU = -1;
    public C31591m<? super Integer, ? super C42971b, C37091y> llV;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a$a */
    public abstract class C42979a extends C41531v {
        final TextView gHg;
        final ImageView iNr;
        final /* synthetic */ C45871a llZ;

        /* renamed from: b */
        public abstract void mo68523b(C42971b c42971b);

        public C42979a(C45871a c45871a, final View view) {
            C25052j.m39376p(view, "itemView");
            this.llZ = c45871a;
            super(view);
            this.iNr = (ImageView) view.findViewById(2131823441);
            this.gHg = (TextView) view.findViewById(2131823442);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C42979a lma;

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(2933);
                    int kj = this.lma.mo66454kj();
                    C42971b uE = this.lma.llZ.mo73685uE(kj);
                    if (uE != null) {
                        C31591m c31591m = this.lma.llZ.llV;
                        if (c31591m != null) {
                            c31591m.mo212m(Integer.valueOf(kj), uE);
                        }
                    }
                    view.requestFocus();
                    AppMethodBeat.m2505o(2933);
                }
            });
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEmpty", "", "getViewTypeEmpty", "()I", "ViewTypeNormal", "getViewTypeNormal", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a$b */
    public static final class C42980b {
        private C42980b() {
        }

        public /* synthetic */ C42980b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a$c */
    public final class C44734c extends C42979a {
        final /* synthetic */ C45871a llZ;

        public C44734c(C45871a c45871a, View view) {
            C25052j.m39376p(view, "itemView");
            this.llZ = c45871a;
            super(c45871a, view);
            AppMethodBeat.m2504i(2935);
            AppMethodBeat.m2505o(2935);
        }

        /* renamed from: b */
        public final void mo68523b(C42971b c42971b) {
            AppMethodBeat.m2504i(2934);
            C25052j.m39376p(c42971b, "info");
            ImageView imageView = this.iNr;
            C25052j.m39375o(imageView, "icon");
            ImageView imageView2 = this.iNr;
            C25052j.m39375o(imageView2, "icon");
            C20443a.m31591a(imageView, C20443a.m31592dg(imageView2));
            AppMethodBeat.m2505o(2934);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a$d */
    public final class C45870d extends C42979a {
        final /* synthetic */ C45871a llZ;

        public C45870d(C45871a c45871a, View view) {
            C25052j.m39376p(view, "itemView");
            this.llZ = c45871a;
            super(c45871a, view);
            AppMethodBeat.m2504i(2937);
            AppMethodBeat.m2505o(2937);
        }

        /* renamed from: b */
        public final void mo68523b(C42971b c42971b) {
            AppMethodBeat.m2504i(2936);
            C25052j.m39376p(c42971b, "info");
            C37881e c37881e = C37881e.eOD;
            C42151b lR = C37881e.m63942Tb().mo41564lR(c42971b.hNN);
            ImageView imageView = this.iNr;
            C25052j.m39375o(imageView, "icon");
            lR.mo44153d(imageView);
            TextView textView = this.gHg;
            C25052j.m39375o(textView, "text");
            textView.setText(c42971b.name);
            AppMethodBeat.m2505o(2936);
        }
    }

    public C45871a() {
        AppMethodBeat.m2504i(2942);
        AppMethodBeat.m2505o(2942);
    }

    static {
        AppMethodBeat.m2504i(2943);
        AppMethodBeat.m2505o(2943);
    }

    /* renamed from: uE */
    public final C42971b mo73685uE(int i) {
        AppMethodBeat.m2504i(2938);
        C42971b c42971b = (C42971b) C25035t.m39361x(this.llT, i);
        AppMethodBeat.m2505o(2938);
        return c42971b;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(2939);
        int size = this.llT.size();
        AppMethodBeat.m2505o(2939);
        return size;
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return llX;
        }
        return llW;
    }
}
