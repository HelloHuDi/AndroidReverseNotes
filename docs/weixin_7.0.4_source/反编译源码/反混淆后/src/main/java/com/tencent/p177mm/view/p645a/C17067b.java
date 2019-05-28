package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.view.p1097f.C16067a;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;", "Lcom/tencent/mm/view/adapter/BaseSmileyAdapter;", "context", "Landroid/content/Context;", "stg", "Lcom/tencent/mm/view/storage/SmileyPanelStg;", "(Landroid/content/Context;Lcom/tencent/mm/view/storage/SmileyPanelStg;)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "itemBgId", "", "canPreview", "", "position", "getCount", "getItem", "getItemId", "", "getRealPosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "update", "", "emoji", "Companion", "ViewHolder", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.view.a.b */
public final class C17067b extends C16041a {
    public static final C17069a Abj = new C17069a();
    ArrayList<EmojiInfo> Abh = new ArrayList();
    private final int Abi;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;Landroid/view/View;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.view.a.b$b */
    public final class C17068b {
        final View Abk;
        final View Abl;
        final View Abm;
        final /* synthetic */ C17067b Abn;
        final ImageView iqT;

        public C17068b(C17067b c17067b, View view) {
            C25052j.m39376p(view, "itemView");
            this.Abn = c17067b;
            AppMethodBeat.m2504i(63327);
            View findViewById = view.findViewById(2131821503);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
            this.iqT = (ImageView) findViewById;
            findViewById = view.findViewById(2131823497);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…ji_capture_status_layout)");
            this.Abk = findViewById;
            findViewById = view.findViewById(2131823498);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…oji_capture_loading_view)");
            this.Abl = findViewById;
            findViewById = view.findViewById(2131823499);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…oji_capture_failure_view)");
            this.Abm = findViewById;
            AppMethodBeat.m2505o(63327);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.view.a.b$a */
    public static final class C17069a {
        private C17069a() {
        }

        public /* synthetic */ C17069a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(63334);
        AppMethodBeat.m2505o(63334);
    }

    public C17067b(Context context, C16067a c16067a) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c16067a, "stg");
        super(context, c16067a);
        AppMethodBeat.m2504i(63333);
        this.Abi = C41953a.m74099y(context, C25738R.attr.f5475s);
        AppMethodBeat.m2505o(63333);
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(63332);
        EmojiInfo uf = m26382uf(i);
        AppMethodBeat.m2505o(63332);
        return uf;
    }

    /* renamed from: ui */
    public final boolean mo28409ui(int i) {
        AppMethodBeat.m2504i(63329);
        C16067a c16067a = this.Aal;
        C25052j.m39375o(c16067a, "mSmileyPanelStg");
        if (!c16067a.dNz() || (this.zZZ == 26 && this.Abe == 0 && i == 0)) {
            AppMethodBeat.m2505o(63329);
            return false;
        }
        AppMethodBeat.m2505o(63329);
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C17068b c17068b;
        AppMethodBeat.m2504i(63330);
        C25052j.m39376p(viewGroup, "parent");
        if ((view != null ? view.getTag() : null) == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130969343, null);
            C25052j.m39375o(view, "LayoutInflater.from(pare…panel_item_capture, null)");
            C16067a c16067a = this.Aal;
            C25052j.m39375o(c16067a, "mSmileyPanelStg");
            int columnWidth = c16067a.getColumnWidth();
            C16067a c16067a2 = this.Aal;
            C25052j.m39375o(c16067a2, "mSmileyPanelStg");
            view.setLayoutParams(new LayoutParams(columnWidth, c16067a2.dNk()));
            C17068b c17068b2 = new C17068b(this, view);
            view.setTag(c17068b2);
            c17068b = c17068b2;
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.view.adapter.CaptureEmojiAdapter.ViewHolder");
                AppMethodBeat.m2505o(63330);
                throw c44941v;
            }
            c17068b = (C17068b) tag;
        }
        if (this.Abe == 0 && i == 0) {
            C16067a c16067a3 = this.Aal;
            C25052j.m39375o(c16067a3, "mSmileyPanelStg");
            if (c16067a3.dNz()) {
                c17068b.iqT.setImageResource(C1318a.emoji_add_capture);
                c17068b.iqT.setContentDescription(c17068b.iqT.getContext().getString(C25738R.string.ac9));
                c17068b.Abk.setVisibility(8);
                AppMethodBeat.m2505o(63330);
                return view;
            }
        }
        EmojiInfo uf = m26382uf(i);
        if (uf == null) {
            c17068b.iqT.setVisibility(8);
            c17068b.Abk.setVisibility(8);
        } else {
            c17068b.iqT.setVisibility(0);
            c17068b.iqT.setBackgroundResource(this.Abi);
            C30302a duZ = uf.duZ();
            if (duZ != null) {
                switch (C36372c.eQZ[duZ.ordinal()]) {
                    case 1:
                        c17068b.Abk.setVisibility(8);
                        break;
                    case 2:
                    case 3:
                        c17068b.Abk.setVisibility(0);
                        c17068b.Abl.setVisibility(0);
                        c17068b.Abm.setVisibility(8);
                        break;
                    case 4:
                    case 5:
                        c17068b.Abk.setVisibility(0);
                        c17068b.Abl.setVisibility(8);
                        c17068b.Abm.setVisibility(0);
                        break;
                }
            }
            C37682a c37682a = C37682a.exs;
            C37682a.m63721a(uf, c17068b.iqT);
        }
        AppMethodBeat.m2505o(63330);
        return view;
    }

    /* renamed from: uf */
    private EmojiInfo m26382uf(int i) {
        int i2;
        AppMethodBeat.m2504i(63331);
        int QC = m26381QC(i);
        C16067a c16067a = this.Aal;
        C25052j.m39375o(c16067a, "mSmileyPanelStg");
        if (c16067a.dNz()) {
            i2 = QC - 1;
        } else {
            i2 = QC;
        }
        EmojiInfo emojiInfo = (EmojiInfo) C25035t.m39361x(this.Abh, i2);
        AppMethodBeat.m2505o(63331);
        return emojiInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: QC */
    private int m26381QC(int i) {
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
