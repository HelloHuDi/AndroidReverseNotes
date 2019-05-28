package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C18119c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.view.p1097f.C16067a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.view.a.e */
public final class C46716e extends C16041a {
    private int Abi;
    ArrayList<EmojiInfo> lbH;
    int scene;

    /* renamed from: com.tencent.mm.view.a.e$a */
    class C30841a {
        View Abk;
        View Abl;
        View Abm;
        TextView Abp;
        TextView gnC;
        ImageView iqT;

        public C30841a(View view) {
            AppMethodBeat.m2504i(62981);
            this.iqT = (ImageView) view.findViewById(2131821503);
            this.gnC = (TextView) view.findViewById(2131827578);
            this.Abp = (TextView) view.findViewById(2131827579);
            this.Abp.setTextSize(1, 12.0f);
            this.Abk = view.findViewById(2131823497);
            this.Abl = view.findViewById(2131823498);
            this.Abm = view.findViewById(2131823499);
            AppMethodBeat.m2505o(62981);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(62986);
        EmojiInfo uf = m88540uf(i);
        AppMethodBeat.m2505o(62986);
        return uf;
    }

    public C46716e(Context context, C16067a c16067a) {
        super(context, c16067a);
        AppMethodBeat.m2504i(62982);
        this.Abi = C41953a.m74099y(context, C25738R.attr.f5475s);
        this.scene = c16067a.gOW;
        AppMethodBeat.m2505o(62982);
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

    /* renamed from: ui */
    public final boolean mo28409ui(int i) {
        AppMethodBeat.m2504i(62984);
        if (!C16067a.m24370QM(this.Aal.gOW) || (this.zZZ == 25 && this.Abe == 0 && i == 0)) {
            AppMethodBeat.m2505o(62984);
            return false;
        }
        AppMethodBeat.m2505o(62984);
        return true;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C30841a c30841a;
        AppMethodBeat.m2504i(62985);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130970701, null);
            view.setLayoutParams(new LayoutParams(this.Aal.getColumnWidth(), this.Aal.Aeb));
            C30841a c30841a2 = new C30841a(view);
            view.setTag(c30841a2);
            c30841a = c30841a2;
        } else {
            c30841a = (C30841a) view.getTag();
        }
        if (this.zZZ == 25 && this.Abe == 0 && i == 0 && C16067a.m24370QM(this.Aal.gOW)) {
            int i2;
            c30841a.iqT.setImageResource(C1318a.emoji_add_custom);
            c30841a.iqT.setContentDescription(view.getContext().getString(C25738R.string.e6o));
            int y = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35667y(false, true);
            C45274a.dmE();
            C18119c c18119c = C45274a.xun;
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                i2 = C5046bo.getInt(C26373g.m41964Nu().getValue("CustomEmojiMaxSize"), 300);
            } else {
                i2 = c18119c.getInt("EmotionRecommandCount", 3);
            }
            if (y > i2) {
                c30841a.Abp.setVisibility(0);
                c30841a.Abp.setText(C25738R.string.b_l);
            } else {
                c30841a.Abp.setVisibility(8);
            }
        } else {
            c30841a.Abp.setVisibility(8);
            EmojiInfo uf = m88540uf(i);
            if (uf == null) {
                C4990ab.m7420w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                c30841a.iqT.setVisibility(8);
                c30841a.gnC.setVisibility(8);
                c30841a.iqT.setImageDrawable(null);
            } else {
                c30841a.iqT.setVisibility(0);
                String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35600Jh(uf.mo20410Aq());
                if (C5046bo.isNullOrNil(Jh) || this.zZZ != 23) {
                    c30841a.gnC.setVisibility(8);
                } else {
                    c30841a.gnC.setText(Jh);
                    c30841a.gnC.setVisibility(0);
                }
                c30841a.iqT.setBackgroundResource(this.Abi);
                if (this.zZZ == 25) {
                    if (uf.field_catalog != EmojiGroupInfo.yas && uf.field_catalog != EmojiInfo.yaA && uf.field_catalog != EmojiInfo.yaz) {
                        switch (uf.duZ()) {
                            case STATUS_SUCCESS:
                                c30841a.Abk.setVisibility(8);
                                break;
                            case STATUS_MIXING:
                            case STATUS_UPLOADING:
                                c30841a.Abk.setVisibility(0);
                                c30841a.Abl.setVisibility(0);
                                c30841a.Abm.setVisibility(8);
                                break;
                            case STATUS_MIX_FAIL:
                            case STATUS_UPLOAD_FAIL:
                                c30841a.Abk.setVisibility(0);
                                c30841a.Abl.setVisibility(8);
                                c30841a.Abm.setVisibility(0);
                                break;
                        }
                    }
                    Jh = uf.getName();
                    if (C5046bo.isNullOrNil(Jh)) {
                        C4990ab.m7416i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                    } else if (Jh.equalsIgnoreCase("dice")) {
                        c30841a.iqT.setContentDescription(view.getContext().getString(C25738R.string.b_5));
                    } else if (Jh.equalsIgnoreCase("jsb")) {
                        c30841a.iqT.setContentDescription(view.getContext().getString(C25738R.string.b_d));
                    }
                }
                C37682a c37682a = C37682a.exs;
                C37682a.m63721a(uf, c30841a.iqT);
            }
        }
        AppMethodBeat.m2505o(62985);
        return view;
    }

    /* renamed from: uf */
    private EmojiInfo m88540uf(int i) {
        AppMethodBeat.m2504i(62983);
        int i2 = (this.Abe * this.Abd) + i;
        if (this.zZZ == 25 && C16067a.m24370QM(this.Aal.gOW)) {
            i2--;
        }
        if (this.lbH == null || i2 < 0 || i2 >= this.lbH.size()) {
            AppMethodBeat.m2505o(62983);
            return null;
        }
        EmojiInfo emojiInfo = (EmojiInfo) this.lbH.get(i2);
        AppMethodBeat.m2505o(62983);
        return emojiInfo;
    }
}
