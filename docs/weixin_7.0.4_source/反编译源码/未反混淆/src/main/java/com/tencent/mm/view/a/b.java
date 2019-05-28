package com.tencent.mm.view.a;

import a.a.t;
import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;", "Lcom/tencent/mm/view/adapter/BaseSmileyAdapter;", "context", "Landroid/content/Context;", "stg", "Lcom/tencent/mm/view/storage/SmileyPanelStg;", "(Landroid/content/Context;Lcom/tencent/mm/view/storage/SmileyPanelStg;)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "itemBgId", "", "canPreview", "", "position", "getCount", "getItem", "getItemId", "", "getRealPosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "update", "", "emoji", "Companion", "ViewHolder", "plugin-emojisdk_release"})
public final class b extends a {
    public static final a Abj = new a();
    ArrayList<EmojiInfo> Abh = new ArrayList();
    private final int Abi;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;Landroid/view/View;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "plugin-emojisdk_release"})
    public final class b {
        final View Abk;
        final View Abl;
        final View Abm;
        final /* synthetic */ b Abn;
        final ImageView iqT;

        public b(b bVar, View view) {
            j.p(view, "itemView");
            this.Abn = bVar;
            AppMethodBeat.i(63327);
            View findViewById = view.findViewById(R.id.yw);
            j.o(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
            this.iqT = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.bet);
            j.o(findViewById, "itemView.findViewById(R.…ji_capture_status_layout)");
            this.Abk = findViewById;
            findViewById = view.findViewById(R.id.beu);
            j.o(findViewById, "itemView.findViewById(R.…oji_capture_loading_view)");
            this.Abl = findViewById;
            findViewById = view.findViewById(R.id.bev);
            j.o(findViewById, "itemView.findViewById(R.…oji_capture_failure_view)");
            this.Abm = findViewById;
            AppMethodBeat.o(63327);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(63334);
        AppMethodBeat.o(63334);
    }

    public b(Context context, com.tencent.mm.view.f.a aVar) {
        j.p(context, "context");
        j.p(aVar, "stg");
        super(context, aVar);
        AppMethodBeat.i(63333);
        this.Abi = com.tencent.mm.emoji.e.a.y(context, R.attr.s);
        AppMethodBeat.o(63333);
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(63332);
        EmojiInfo uf = uf(i);
        AppMethodBeat.o(63332);
        return uf;
    }

    public final boolean ui(int i) {
        AppMethodBeat.i(63329);
        com.tencent.mm.view.f.a aVar = this.Aal;
        j.o(aVar, "mSmileyPanelStg");
        if (!aVar.dNz() || (this.zZZ == 26 && this.Abe == 0 && i == 0)) {
            AppMethodBeat.o(63329);
            return false;
        }
        AppMethodBeat.o(63329);
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(63330);
        j.p(viewGroup, "parent");
        if ((view != null ? view.getTag() : null) == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tz, null);
            j.o(view, "LayoutInflater.from(pare…panel_item_capture, null)");
            com.tencent.mm.view.f.a aVar = this.Aal;
            j.o(aVar, "mSmileyPanelStg");
            int columnWidth = aVar.getColumnWidth();
            com.tencent.mm.view.f.a aVar2 = this.Aal;
            j.o(aVar2, "mSmileyPanelStg");
            view.setLayoutParams(new LayoutParams(columnWidth, aVar2.dNk()));
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.view.adapter.CaptureEmojiAdapter.ViewHolder");
                AppMethodBeat.o(63330);
                throw vVar;
            }
            bVar = (b) tag;
        }
        if (this.Abe == 0 && i == 0) {
            com.tencent.mm.view.f.a aVar3 = this.Aal;
            j.o(aVar3, "mSmileyPanelStg");
            if (aVar3.dNz()) {
                bVar.iqT.setImageResource(R.raw.emoji_add_capture);
                bVar.iqT.setContentDescription(bVar.iqT.getContext().getString(R.string.ac9));
                bVar.Abk.setVisibility(8);
                AppMethodBeat.o(63330);
                return view;
            }
        }
        EmojiInfo uf = uf(i);
        if (uf == null) {
            bVar.iqT.setVisibility(8);
            bVar.Abk.setVisibility(8);
        } else {
            bVar.iqT.setVisibility(0);
            bVar.iqT.setBackgroundResource(this.Abi);
            com.tencent.mm.storage.emotion.EmojiInfo.a duZ = uf.duZ();
            if (duZ != null) {
                switch (c.eQZ[duZ.ordinal()]) {
                    case 1:
                        bVar.Abk.setVisibility(8);
                        break;
                    case 2:
                    case 3:
                        bVar.Abk.setVisibility(0);
                        bVar.Abl.setVisibility(0);
                        bVar.Abm.setVisibility(8);
                        break;
                    case 4:
                    case 5:
                        bVar.Abk.setVisibility(0);
                        bVar.Abl.setVisibility(8);
                        bVar.Abm.setVisibility(0);
                        break;
                }
            }
            com.tencent.mm.emoji.loader.a aVar4 = com.tencent.mm.emoji.loader.a.exs;
            com.tencent.mm.emoji.loader.a.a(uf, bVar.iqT);
        }
        AppMethodBeat.o(63330);
        return view;
    }

    private EmojiInfo uf(int i) {
        int i2;
        AppMethodBeat.i(63331);
        int QC = QC(i);
        com.tencent.mm.view.f.a aVar = this.Aal;
        j.o(aVar, "mSmileyPanelStg");
        if (aVar.dNz()) {
            i2 = QC - 1;
        } else {
            i2 = QC;
        }
        EmojiInfo emojiInfo = (EmojiInfo) t.x(this.Abh, i2);
        AppMethodBeat.o(63331);
        return emojiInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int QC(int i) {
        return (this.Abe * this.Abd) + i;
    }

    public final int getCount() {
        if (this.Abe != this.Aab - 1) {
            return this.Abd;
        }
        int i = this.emW - (this.Abe * this.Abd);
        return i < 0 ? 0 : i;
    }
}
