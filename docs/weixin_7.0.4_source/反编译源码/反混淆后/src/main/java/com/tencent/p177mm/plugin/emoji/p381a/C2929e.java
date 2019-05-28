package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C46623a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.a.e */
public final class C2929e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int kSe = 2130969348;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int kSf;
    public List<EmojiGroupInfo> kSg;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.emoji.a.e$a */
    class C2930a {
        TextView gnB;
        ImageView iqT;
        View kSh;
        ImageView kSi;

        public C2930a(View view) {
            AppMethodBeat.m2504i(52739);
            this.kSi = (ImageView) view.findViewById(2131823504);
            this.iqT = (ImageView) view.findViewById(2131823506);
            this.gnB = (TextView) view.findViewById(2131823507);
            this.kSh = view.findViewById(2131823505);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = C2929e.this.kSf;
                view.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(52739);
        }
    }

    public C2929e(Context context, List<EmojiGroupInfo> list) {
        super(context, kSe, list);
        AppMethodBeat.m2504i(52740);
        this.kSf = context.getResources().getDimensionPixelSize(C25738R.dimen.a0u);
        this.mContext = context;
        this.kSg = list;
        AppMethodBeat.m2505o(52740);
    }

    public final void bjz() {
        AppMethodBeat.m2504i(52741);
        if (this.kSg == null) {
            AppMethodBeat.m2505o(52741);
            return;
        }
        int size = this.kSg.size();
        for (int i = 0; i < size; i++) {
            ((EmojiGroupInfo) this.kSg.get(i)).field_idx = i;
        }
        C42952j.getEmojiStorageMgr().xYo.mo74786eI(this.kSg);
        EmojiGroupInfo bZ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(EmojiGroupInfo.yas, false);
        bZ.field_sort = this.kSg.size() + 2;
        C42952j.getEmojiStorageMgr();
        if (!C46623a.duE()) {
            C46623a c46623a = C42952j.getEmojiStorageMgr().xYo;
            if (bZ != null) {
                C4990ab.m7411d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", bZ.field_packName, Long.valueOf(bZ.field_lastUseTime), Integer.valueOf(bZ.field_sort));
                c46623a.mo10099a(bZ);
                c46623a.mo15641b("event_update_group", 0, C5046bo.dpG().toString());
            }
        }
        AppMethodBeat.m2505o(52741);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2930a c2930a;
        AppMethodBeat.m2504i(52742);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(kSe, null);
            C2930a c2930a2 = new C2930a(view);
            view.setTag(c2930a2);
            c2930a = c2930a2;
        } else {
            c2930a = (C2930a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i);
        if (C2932a.m5217b(emojiGroupInfo)) {
            c2930a.gnB.setText(C25738R.string.bca);
        } else {
            c2930a.gnB.setText(emojiGroupInfo.field_packName);
        }
        if (C2932a.m5217b(emojiGroupInfo)) {
            c2930a.iqT.setImageResource(C25738R.drawable.icon_002_cover);
        } else {
            C32291o.ahp().mo43766a(emojiGroupInfo.field_packIconUrl, c2930a.iqT, C20364g.m31459dH(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            c2930a.kSh.setBackgroundResource(C25738R.drawable.f6625k7);
        }
        view.setVisibility(0);
        AppMethodBeat.m2505o(52742);
        return view;
    }
}
