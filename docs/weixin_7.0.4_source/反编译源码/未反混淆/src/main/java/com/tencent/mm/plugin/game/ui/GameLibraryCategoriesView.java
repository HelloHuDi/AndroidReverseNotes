package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private int mXC;
    private LinearLayout mpt;
    private int njK;
    private int njL;

    public static class a {
        public String haO;
        public int njM;
        public String njN;
        public String njO;
        public int position;
    }

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112010);
        super.onFinishInflate();
        this.mpt = (LinearLayout) findViewById(R.id.c77);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.njK = (width * 100) / 750;
        this.njL = (width - (this.njK * 6)) / 14;
        this.mpt.setPadding(this.njL, com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12), this.njL, com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12));
        AppMethodBeat.o(112010);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    public void setData(LinkedList<a> linkedList) {
        AppMethodBeat.i(112011);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            AppMethodBeat.o(112011);
            return;
        }
        setVisibility(0);
        this.mpt.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.at.a.a ahp = o.ahp();
            String str = aVar.haO;
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePG = true;
            ahp.a(str, imageView, aVar2.ahG());
            linearLayout.addView(imageView, this.njK, this.njK);
            TextView textView = new TextView(this.mContext);
            textView.setText(aVar.njN);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(getResources().getColor(R.color.s0));
            textView.setSingleLine(true);
            textView.setEllipsize(TruncateAt.END);
            textView.setGravity(17);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(textView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.njL, 0, this.njL, 0);
            this.mpt.addView(linearLayout, layoutParams);
        }
        AppMethodBeat.o(112011);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112012);
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (bo.isNullOrNil(aVar.njO)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.njM);
                intent.putExtra("extra_category_name", aVar.njN);
                intent.putExtra("game_report_from_scene", aVar.njM + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                c.ax(this.mContext, aVar.njO);
            }
            b.a(this.mContext, 11, aVar.njM + 100, aVar.position, i, this.mXC, null);
            AppMethodBeat.o(112012);
            return;
        }
        AppMethodBeat.o(112012);
    }
}
