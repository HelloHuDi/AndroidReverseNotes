package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.view.p1097f.C16067a;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.view.a.j */
public final class C16049j extends C41523a<C16048b> {
    public static final String AbP = File.separator;
    private C16067a Aaj;
    C25814c AbM = null;
    private int AbN;
    public C16050a AbO;
    public int llU;
    private Context mContext;
    public ArrayList<EmojiGroupInfo> mData = new ArrayList();

    /* renamed from: com.tencent.mm.view.a.j$b */
    class C16048b extends C41531v implements OnClickListener {
        ImageView AbQ;
        ImageView cAw;

        public C16048b(View view) {
            super(view);
            AppMethodBeat.m2504i(63007);
            this.cAw = (ImageView) view.findViewById(2131827584);
            this.AbQ = (ImageView) view.findViewById(2131827585);
            view.setOnClickListener(this);
            AppMethodBeat.m2505o(63007);
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(63008);
            if (C16049j.this.AbO != null) {
                C16049j.this.AbO.mo28419f(mo66454kj(), view);
            }
            AppMethodBeat.m2505o(63008);
        }
    }

    /* renamed from: com.tencent.mm.view.a.j$a */
    public interface C16050a {
        /* renamed from: f */
        void mo28419f(int i, View view);
    }

    public C16049j(Context context, C16067a c16067a) {
        AppMethodBeat.m2504i(63009);
        this.mContext = context;
        this.AbN = C41953a.m74099y(context, C25738R.attr.f5474r);
        this.Aaj = c16067a;
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.fHe = 4;
        c17927a.ePV = this.AbN;
        c17927a.ePN = this.Aaj.AdZ;
        c17927a.ePN = this.Aaj.AdZ;
        this.AbM = c17927a.ahG();
        AppMethodBeat.m2505o(63009);
    }

    /* renamed from: QE */
    public final EmojiGroupInfo mo28417QE(int i) {
        AppMethodBeat.m2504i(63010);
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i || i < 0) {
            AppMethodBeat.m2505o(63010);
            return null;
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) this.mData.get(i);
        AppMethodBeat.m2505o(63010);
        return emojiGroupInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(63011);
        if (this.mData == null) {
            AppMethodBeat.m2505o(63011);
            return 0;
        }
        int size = this.mData.size();
        AppMethodBeat.m2505o(63011);
        return size;
    }

    /* renamed from: K */
    private static String m24354K(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.m2504i(63012);
        if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3)) {
            C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
            AppMethodBeat.m2505o(63012);
        } else {
            String str5;
            if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3)) {
                C4990ab.m7412e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
                str5 = null;
            } else if (C5046bo.isNullOrNil(str3)) {
                str5 = C1178g.m2591x(str2.getBytes());
            } else {
                str5 = C1178g.m2591x(str3.getBytes());
            }
            if (!C5046bo.isNullOrNil(str5)) {
                if (C5046bo.isNullOrNil(str2)) {
                    str4 = str + str5;
                } else {
                    str4 = str + str2 + AbP + str5;
                }
            }
            AppMethodBeat.m2505o(63012);
        }
        return str4;
    }
}
