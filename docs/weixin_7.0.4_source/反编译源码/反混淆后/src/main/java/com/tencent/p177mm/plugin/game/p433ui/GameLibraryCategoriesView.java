package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView */
public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private int mXC;
    private LinearLayout mpt;
    private int njK;
    private int njL;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView$a */
    public static class C21021a {
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
        AppMethodBeat.m2504i(112010);
        super.onFinishInflate();
        this.mpt = (LinearLayout) findViewById(2131824547);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.njK = (width * 100) / 750;
        this.njL = (width - (this.njK * 6)) / 14;
        this.mpt.setPadding(this.njL, C1338a.fromDPToPix(this.mContext, 12), this.njL, C1338a.fromDPToPix(this.mContext, 12));
        AppMethodBeat.m2505o(112010);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    public void setData(LinkedList<C21021a> linkedList) {
        AppMethodBeat.m2504i(112011);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            AppMethodBeat.m2505o(112011);
            return;
        }
        setVisibility(0);
        this.mpt.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C21021a c21021a = (C21021a) it.next();
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            C25815a ahp = C32291o.ahp();
            String str = c21021a.haO;
            C17927a c17927a = new C17927a();
            c17927a.ePG = true;
            ahp.mo43766a(str, imageView, c17927a.ahG());
            linearLayout.addView(imageView, this.njK, this.njK);
            TextView textView = new TextView(this.mContext);
            textView.setText(c21021a.njN);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(getResources().getColor(C25738R.color.f12092s0));
            textView.setSingleLine(true);
            textView.setEllipsize(TruncateAt.END);
            textView.setGravity(17);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setPadding(0, C1338a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(textView);
            linearLayout.setTag(c21021a);
            linearLayout.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.njL, 0, this.njL, 0);
            this.mpt.addView(linearLayout, layoutParams);
        }
        AppMethodBeat.m2505o(112011);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112012);
        if (view.getTag() instanceof C21021a) {
            C21021a c21021a = (C21021a) view.getTag();
            int i = 7;
            if (C5046bo.isNullOrNil(c21021a.njO)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", c21021a.njM);
                intent.putExtra("extra_category_name", c21021a.njN);
                intent.putExtra("game_report_from_scene", c21021a.njM + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                C46001c.m85455ax(this.mContext, c21021a.njO);
            }
            C34277b.m56209a(this.mContext, 11, c21021a.njM + 100, c21021a.position, i, this.mXC, null);
            AppMethodBeat.m2505o(112012);
            return;
        }
        AppMethodBeat.m2505o(112012);
    }
}
