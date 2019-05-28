package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements OnClickListener {
    private String appId = "";
    private int lTe = -1;
    private Context mContext;
    private int nja = 0;
    private int nkE;
    private LinkedList<String> nkF;

    public static class a {
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

    public void setMediaList(LinkedList<a> linkedList) {
        AppMethodBeat.i(112065);
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            AppMethodBeat.o(112065);
            return;
        }
        this.nkF = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            a aVar = (a) linkedList.get(i);
            if (!bo.isNullOrNil(aVar.url) && aVar.type == 0) {
                this.nkF.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar2 = (a) linkedList.get(i2);
            if (!bo.isNullOrNil(aVar2.nkG)) {
                View inflate = layoutInflater.inflate(this.nkE, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.akx);
                com.tencent.mm.at.a.a ahp = o.ahp();
                String str = aVar2.nkG;
                com.tencent.mm.at.a.a.c.a aVar3 = new com.tencent.mm.at.a.a.c.a();
                aVar3.ePG = true;
                ahp.a(str, imageView, aVar3.ahG());
                if (aVar2.type == 1) {
                    inflate.findViewById(R.id.c7m).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
        AppMethodBeat.o(112065);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112066);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            ab.i("MicroMsg.GameMediaList", "Invalid tag");
            AppMethodBeat.o(112066);
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.nkF.indexOf(aVar.url);
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
                c.ax(getContext(), aVar.url);
                b.a(this.mContext, this.lTe, 1202, 1, 13, this.appId, this.nja, null);
                AppMethodBeat.o(112066);
                return;
        }
        AppMethodBeat.o(112066);
    }

    public final void l(Context context, String str, int i) {
        this.appId = str;
        this.lTe = 12;
        this.nja = i;
        this.mContext = context;
    }
}
