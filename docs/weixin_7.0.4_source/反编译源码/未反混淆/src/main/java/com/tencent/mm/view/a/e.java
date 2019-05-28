package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.by.a.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public final class e extends a {
    private int Abi;
    ArrayList<EmojiInfo> lbH;
    int scene;

    class a {
        View Abk;
        View Abl;
        View Abm;
        TextView Abp;
        TextView gnC;
        ImageView iqT;

        public a(View view) {
            AppMethodBeat.i(62981);
            this.iqT = (ImageView) view.findViewById(R.id.yw);
            this.gnC = (TextView) view.findViewById(R.id.ee5);
            this.Abp = (TextView) view.findViewById(R.id.ee6);
            this.Abp.setTextSize(1, 12.0f);
            this.Abk = view.findViewById(R.id.bet);
            this.Abl = view.findViewById(R.id.beu);
            this.Abm = view.findViewById(R.id.bev);
            AppMethodBeat.o(62981);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(62986);
        EmojiInfo uf = uf(i);
        AppMethodBeat.o(62986);
        return uf;
    }

    public e(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
        AppMethodBeat.i(62982);
        this.Abi = com.tencent.mm.emoji.e.a.y(context, R.attr.s);
        this.scene = aVar.gOW;
        AppMethodBeat.o(62982);
    }

    public final int getCount() {
        if (this.Abe != this.Aab - 1) {
            return this.Abd;
        }
        int i = this.emW - (this.Abe * this.Abd);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public final boolean ui(int i) {
        AppMethodBeat.i(62984);
        if (!com.tencent.mm.view.f.a.QM(this.Aal.gOW) || (this.zZZ == 25 && this.Abe == 0 && i == 0)) {
            AppMethodBeat.o(62984);
            return false;
        }
        AppMethodBeat.o(62984);
        return true;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(62985);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atl, null);
            view.setLayoutParams(new LayoutParams(this.Aal.getColumnWidth(), this.Aal.Aeb));
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.zZZ == 25 && this.Abe == 0 && i == 0 && com.tencent.mm.view.f.a.QM(this.Aal.gOW)) {
            int i2;
            aVar.iqT.setImageResource(R.raw.emoji_add_custom);
            aVar.iqT.setContentDescription(view.getContext().getString(R.string.e6o));
            int y = ((d) g.M(d.class)).getProvider().y(false, true);
            com.tencent.mm.by.a.dmE();
            c cVar = com.tencent.mm.by.a.xun;
            if (((h) g.RM().Rn()).SG()) {
                i2 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("CustomEmojiMaxSize"), 300);
            } else {
                i2 = cVar.getInt("EmotionRecommandCount", 3);
            }
            if (y > i2) {
                aVar.Abp.setVisibility(0);
                aVar.Abp.setText(R.string.b_l);
            } else {
                aVar.Abp.setVisibility(8);
            }
        } else {
            aVar.Abp.setVisibility(8);
            EmojiInfo uf = uf(i);
            if (uf == null) {
                ab.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.iqT.setVisibility(8);
                aVar.gnC.setVisibility(8);
                aVar.iqT.setImageDrawable(null);
            } else {
                aVar.iqT.setVisibility(0);
                String Jh = ((d) g.M(d.class)).getProvider().Jh(uf.Aq());
                if (bo.isNullOrNil(Jh) || this.zZZ != 23) {
                    aVar.gnC.setVisibility(8);
                } else {
                    aVar.gnC.setText(Jh);
                    aVar.gnC.setVisibility(0);
                }
                aVar.iqT.setBackgroundResource(this.Abi);
                if (this.zZZ == 25) {
                    if (uf.field_catalog != EmojiGroupInfo.yas && uf.field_catalog != EmojiInfo.yaA && uf.field_catalog != EmojiInfo.yaz) {
                        switch (uf.duZ()) {
                            case STATUS_SUCCESS:
                                aVar.Abk.setVisibility(8);
                                break;
                            case STATUS_MIXING:
                            case STATUS_UPLOADING:
                                aVar.Abk.setVisibility(0);
                                aVar.Abl.setVisibility(0);
                                aVar.Abm.setVisibility(8);
                                break;
                            case STATUS_MIX_FAIL:
                            case STATUS_UPLOAD_FAIL:
                                aVar.Abk.setVisibility(0);
                                aVar.Abl.setVisibility(8);
                                aVar.Abm.setVisibility(0);
                                break;
                        }
                    }
                    Jh = uf.getName();
                    if (bo.isNullOrNil(Jh)) {
                        ab.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                    } else if (Jh.equalsIgnoreCase("dice")) {
                        aVar.iqT.setContentDescription(view.getContext().getString(R.string.b_5));
                    } else if (Jh.equalsIgnoreCase("jsb")) {
                        aVar.iqT.setContentDescription(view.getContext().getString(R.string.b_d));
                    }
                }
                com.tencent.mm.emoji.loader.a aVar3 = com.tencent.mm.emoji.loader.a.exs;
                com.tencent.mm.emoji.loader.a.a(uf, aVar.iqT);
            }
        }
        AppMethodBeat.o(62985);
        return view;
    }

    private EmojiInfo uf(int i) {
        AppMethodBeat.i(62983);
        int i2 = (this.Abe * this.Abd) + i;
        if (this.zZZ == 25 && com.tencent.mm.view.f.a.QM(this.Aal.gOW)) {
            i2--;
        }
        if (this.lbH == null || i2 < 0 || i2 >= this.lbH.size()) {
            AppMethodBeat.o(62983);
            return null;
        }
        EmojiInfo emojiInfo = (EmojiInfo) this.lbH.get(i2);
        AppMethodBeat.o(62983);
        return emojiInfo;
    }
}
