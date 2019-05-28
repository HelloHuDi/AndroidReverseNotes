package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e;
import java.lang.ref.WeakReference;

public class CategoryTipView extends RelativeLayout implements c {
    private int mStatus = 0;
    private String osR = "";
    private long qBy = 0;
    private TextView zlk = null;

    static /* synthetic */ boolean b(CategoryTipView categoryTipView) {
        AppMethodBeat.i(33558);
        boolean dHD = categoryTipView.dHD();
        AppMethodBeat.o(33558);
        return dHD;
    }

    public CategoryTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33551);
        init();
        AppMethodBeat.o(33551);
    }

    public CategoryTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(33552);
        init();
        AppMethodBeat.o(33552);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        boolean z = true;
        AppMethodBeat.i(33553);
        super.onVisibilityChanged(view, i);
        String str = "MicroMsg.CategoryTipView";
        String str2 = "visibility == View.VISIBLE : %s";
        Object[] objArr = new Object[1];
        if (i != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        if (i == 0) {
            this.osR = e.aqC("6");
        }
        AppMethodBeat.o(33553);
    }

    private void init() {
        AppMethodBeat.i(33554);
        LayoutInflater.from(getContext()).inflate(R.layout.b0, this, true);
        this.zlk = (TextView) findViewById(R.id.nb);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33549);
                if (bo.az(CategoryTipView.this.qBy) < 1000) {
                    AppMethodBeat.o(33549);
                    return;
                }
                CategoryTipView.this.qBy = bo.yz();
                if (CategoryTipView.b(CategoryTipView.this)) {
                    h hVar = h.scu;
                    h.cAs().fC(CategoryTipView.this.osR);
                    hVar = h.scu;
                    h.cAs().cYQ = 6;
                    n.a(CategoryTipView.this.getContext(), ((com.tencent.mm.plugin.story.api.e) g.M(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().cwT(), null, null);
                }
                AppMethodBeat.o(33549);
            }
        });
        ((com.tencent.mm.plugin.story.api.e) g.M(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().b(new WeakReference(this));
        AppMethodBeat.o(33554);
    }

    public final void Pm(int i) {
        AppMethodBeat.i(33555);
        this.mStatus = i;
        if (dHD()) {
            int i2 = com.tencent.mm.m.g.Nu().getInt("StoryShouldShowEntraceInFavorFriend", 1);
            Drawable drawable;
            if (i2 == 1 && (i & 1) != 0) {
                ab.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", this, Integer.valueOf(i2));
                setVisibility(0);
                this.zlk.setVisibility(0);
                drawable = getContext().getResources().getDrawable(R.raw.icon_outlined_one_day_video_blue);
                drawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
                this.zlk.setCompoundDrawables(null, null, drawable, null);
                this.zlk.invalidate();
                AppMethodBeat.o(33555);
                return;
            } else if (i2 != 1 || (i & 2) == 0) {
                setVisibility(8);
                this.zlk.setVisibility(8);
                AppMethodBeat.o(33555);
                return;
            } else {
                ab.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", this, Integer.valueOf(i2));
                setVisibility(0);
                this.zlk.setVisibility(0);
                drawable = getContext().getResources().getDrawable(R.raw.icons_outlined_one_day_video);
                drawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
                this.zlk.setCompoundDrawables(null, null, drawable, null);
                this.zlk.invalidate();
                AppMethodBeat.o(33555);
                return;
            }
        }
        setVisibility(8);
        this.zlk.setVisibility(8);
        AppMethodBeat.o(33555);
    }

    private boolean dHD() {
        boolean z;
        AppMethodBeat.i(33556);
        Object tag = getTag();
        if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == 32) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", this, Boolean.valueOf(z));
        AppMethodBeat.o(33556);
        return z;
    }

    public final void EH(final int i) {
        AppMethodBeat.i(33557);
        ab.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", this, Integer.valueOf(this.mStatus), Integer.valueOf(i));
        if (getVisibility() == 0 && dHD() && this.mStatus != i) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33550);
                    CategoryTipView.a(CategoryTipView.this, i);
                    AppMethodBeat.o(33550);
                }
            });
        }
        AppMethodBeat.o(33557);
    }
}
