package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameMediaList */
public class GameMediaList extends LinearLayout implements OnClickListener {
    private String appId = "";
    private int lTe = -1;
    private Context mContext;
    private int nja = 0;
    private int nkE;
    private LinkedList<String> nkF;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMediaList$a */
    public static class C28253a {
        public String nkG;
        public int type;
        public String url;
    }

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setItemLayout(int i) {
        this.nkE = i;
    }

    public void setMediaList(LinkedList<C28253a> linkedList) {
        AppMethodBeat.m2504i(112065);
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            AppMethodBeat.m2505o(112065);
            return;
        }
        this.nkF = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            C28253a c28253a = (C28253a) linkedList.get(i);
            if (!C5046bo.isNullOrNil(c28253a.url) && c28253a.type == 0) {
                this.nkF.add(c28253a.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            C28253a c28253a2 = (C28253a) linkedList.get(i2);
            if (!C5046bo.isNullOrNil(c28253a2.nkG)) {
                View inflate = layoutInflater.inflate(this.nkE, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(2131822355);
                C25815a ahp = C32291o.ahp();
                String str = c28253a2.nkG;
                C17927a c17927a = new C17927a();
                c17927a.ePG = true;
                ahp.mo43766a(str, imageView, c17927a.ahG());
                if (c28253a2.type == 1) {
                    inflate.findViewById(2131824563).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(c28253a2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
        AppMethodBeat.m2505o(112065);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112066);
        if (view.getTag() == null || !(view.getTag() instanceof C28253a)) {
            C4990ab.m7416i("MicroMsg.GameMediaList", "Invalid tag");
            AppMethodBeat.m2505o(112066);
            return;
        }
        C28253a c28253a = (C28253a) view.getTag();
        switch (c28253a.type) {
            case 0:
                int indexOf = this.nkF.indexOf(c28253a.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.nkF.size()];
                this.nkF.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.lTe);
                intent.putExtra("SOURCE_SCENE", this.nja);
                getContext().startActivity(intent);
                break;
            case 1:
                C46001c.m85455ax(getContext(), c28253a.url);
                C34277b.m56211a(this.mContext, this.lTe, 1202, 1, 13, this.appId, this.nja, null);
                AppMethodBeat.m2505o(112066);
                return;
        }
        AppMethodBeat.m2505o(112066);
    }

    /* renamed from: l */
    public final void mo46131l(Context context, String str, int i) {
        this.appId = str;
        this.lTe = 12;
        this.nja = i;
        this.mContext = context;
    }
}
