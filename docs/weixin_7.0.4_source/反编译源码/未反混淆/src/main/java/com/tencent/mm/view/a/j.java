package com.tencent.mm.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;
import java.util.ArrayList;

public final class j extends android.support.v7.widget.RecyclerView.a<b> {
    public static final String AbP = File.separator;
    private com.tencent.mm.view.f.a Aaj;
    c AbM = null;
    private int AbN;
    public a AbO;
    public int llU;
    private Context mContext;
    public ArrayList<EmojiGroupInfo> mData = new ArrayList();

    class b extends v implements OnClickListener {
        ImageView AbQ;
        ImageView cAw;

        public b(View view) {
            super(view);
            AppMethodBeat.i(63007);
            this.cAw = (ImageView) view.findViewById(R.id.eea);
            this.AbQ = (ImageView) view.findViewById(R.id.eeb);
            view.setOnClickListener(this);
            AppMethodBeat.o(63007);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(63008);
            if (j.this.AbO != null) {
                j.this.AbO.f(kj(), view);
            }
            AppMethodBeat.o(63008);
        }
    }

    public interface a {
        void f(int i, View view);
    }

    public j(Context context, com.tencent.mm.view.f.a aVar) {
        AppMethodBeat.i(63009);
        this.mContext = context;
        this.AbN = com.tencent.mm.emoji.e.a.y(context, R.attr.r);
        this.Aaj = aVar;
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePF = true;
        aVar2.fHe = 4;
        aVar2.ePV = this.AbN;
        aVar2.ePN = this.Aaj.AdZ;
        aVar2.ePN = this.Aaj.AdZ;
        this.AbM = aVar2.ahG();
        AppMethodBeat.o(63009);
    }

    public final EmojiGroupInfo QE(int i) {
        AppMethodBeat.i(63010);
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i || i < 0) {
            AppMethodBeat.o(63010);
            return null;
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) this.mData.get(i);
        AppMethodBeat.o(63010);
        return emojiGroupInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        AppMethodBeat.i(63011);
        if (this.mData == null) {
            AppMethodBeat.o(63011);
            return 0;
        }
        int size = this.mData.size();
        AppMethodBeat.o(63011);
        return size;
    }

    private static String K(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(63012);
        if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
            ab.w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
            AppMethodBeat.o(63012);
        } else {
            String str5;
            if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
                ab.e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
                str5 = null;
            } else if (bo.isNullOrNil(str3)) {
                str5 = g.x(str2.getBytes());
            } else {
                str5 = g.x(str3.getBytes());
            }
            if (!bo.isNullOrNil(str5)) {
                if (bo.isNullOrNil(str2)) {
                    str4 = str + str5;
                } else {
                    str4 = str + str2 + AbP + str5;
                }
            }
            AppMethodBeat.o(63012);
        }
        return str4;
    }
}
