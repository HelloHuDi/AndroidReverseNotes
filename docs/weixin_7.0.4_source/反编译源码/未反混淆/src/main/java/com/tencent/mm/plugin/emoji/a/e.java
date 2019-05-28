package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int kSe = R.layout.u4;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int kSf;
    public List<EmojiGroupInfo> kSg;
    private Context mContext;

    class a {
        TextView gnB;
        ImageView iqT;
        View kSh;
        ImageView kSi;

        public a(View view) {
            AppMethodBeat.i(52739);
            this.kSi = (ImageView) view.findViewById(R.id.bf0);
            this.iqT = (ImageView) view.findViewById(R.id.bf2);
            this.gnB = (TextView) view.findViewById(R.id.bf3);
            this.kSh = view.findViewById(R.id.bf1);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = e.this.kSf;
                view.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(52739);
        }
    }

    public e(Context context, List<EmojiGroupInfo> list) {
        super(context, kSe, list);
        AppMethodBeat.i(52740);
        this.kSf = context.getResources().getDimensionPixelSize(R.dimen.a0u);
        this.mContext = context;
        this.kSg = list;
        AppMethodBeat.o(52740);
    }

    public final void bjz() {
        AppMethodBeat.i(52741);
        if (this.kSg == null) {
            AppMethodBeat.o(52741);
            return;
        }
        int size = this.kSg.size();
        for (int i = 0; i < size; i++) {
            ((EmojiGroupInfo) this.kSg.get(i)).field_idx = i;
        }
        j.getEmojiStorageMgr().xYo.eI(this.kSg);
        EmojiGroupInfo bZ = j.getEmojiStorageMgr().xYo.bZ(EmojiGroupInfo.yas, false);
        bZ.field_sort = this.kSg.size() + 2;
        j.getEmojiStorageMgr();
        if (!com.tencent.mm.storage.emotion.a.duE()) {
            com.tencent.mm.storage.emotion.a aVar = j.getEmojiStorageMgr().xYo;
            if (bZ != null) {
                ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", bZ.field_packName, Long.valueOf(bZ.field_lastUseTime), Integer.valueOf(bZ.field_sort));
                aVar.a(bZ);
                aVar.b("event_update_group", 0, bo.dpG().toString());
            }
        }
        AppMethodBeat.o(52741);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(52742);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(kSe, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.gnB.setText(R.string.bca);
        } else {
            aVar.gnB.setText(emojiGroupInfo.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.iqT.setImageResource(R.drawable.icon_002_cover);
        } else {
            o.ahp().a(emojiGroupInfo.field_packIconUrl, aVar.iqT, g.dH(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.kSh.setBackgroundResource(R.drawable.k7);
        }
        view.setVisibility(0);
        AppMethodBeat.o(52742);
        return view;
    }
}
