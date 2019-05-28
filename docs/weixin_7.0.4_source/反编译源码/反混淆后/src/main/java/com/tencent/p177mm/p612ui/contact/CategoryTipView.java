package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5510e;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C4108c;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.contact.CategoryTipView */
public class CategoryTipView extends RelativeLayout implements C4108c {
    private int mStatus = 0;
    private String osR = "";
    private long qBy = 0;
    private TextView zlk = null;

    /* renamed from: com.tencent.mm.ui.contact.CategoryTipView$1 */
    class C157871 implements OnClickListener {
        C157871() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33549);
            if (C5046bo.m7525az(CategoryTipView.this.qBy) < 1000) {
                AppMethodBeat.m2505o(33549);
                return;
            }
            CategoryTipView.this.qBy = C5046bo.m7588yz();
            if (CategoryTipView.m24152b(CategoryTipView.this)) {
                C22212h c22212h = C22212h.scu;
                C22212h.cAs().mo20757fC(CategoryTipView.this.osR);
                c22212h = C22212h.scu;
                C22212h.cAs().cYQ = 6;
                C46270n.m86705a(CategoryTipView.this.getContext(), ((C35168e) C1720g.m3530M(C35168e.class)).getFavourUserChecker().cwT(), null, null);
            }
            AppMethodBeat.m2505o(33549);
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m24152b(CategoryTipView categoryTipView) {
        AppMethodBeat.m2504i(33558);
        boolean dHD = categoryTipView.dHD();
        AppMethodBeat.m2505o(33558);
        return dHD;
    }

    public CategoryTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(33551);
        init();
        AppMethodBeat.m2505o(33551);
    }

    public CategoryTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(33552);
        init();
        AppMethodBeat.m2505o(33552);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(33553);
        super.onVisibilityChanged(view, i);
        String str = "MicroMsg.CategoryTipView";
        String str2 = "visibility == View.VISIBLE : %s";
        Object[] objArr = new Object[1];
        if (i != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        if (i == 0) {
            this.osR = C5510e.aqC("6");
        }
        AppMethodBeat.m2505o(33553);
    }

    private void init() {
        AppMethodBeat.m2504i(33554);
        LayoutInflater.from(getContext()).inflate(2130968639, this, true);
        this.zlk = (TextView) findViewById(2131821063);
        setOnClickListener(new C157871());
        ((C35168e) C1720g.m3530M(C35168e.class)).getFavourUserChecker().mo8979b(new WeakReference(this));
        AppMethodBeat.m2505o(33554);
    }

    /* renamed from: Pm */
    public final void mo27997Pm(int i) {
        AppMethodBeat.m2504i(33555);
        this.mStatus = i;
        if (dHD()) {
            int i2 = C26373g.m41964Nu().getInt("StoryShouldShowEntraceInFavorFriend", 1);
            Drawable drawable;
            if (i2 == 1 && (i & 1) != 0) {
                C4990ab.m7417i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", this, Integer.valueOf(i2));
                setVisibility(0);
                this.zlk.setVisibility(0);
                drawable = getContext().getResources().getDrawable(C1318a.icon_outlined_one_day_video_blue);
                drawable.setBounds(0, 0, C1338a.fromDPToPix(getContext(), 20), C1338a.fromDPToPix(getContext(), 20));
                this.zlk.setCompoundDrawables(null, null, drawable, null);
                this.zlk.invalidate();
                AppMethodBeat.m2505o(33555);
                return;
            } else if (i2 != 1 || (i & 2) == 0) {
                setVisibility(8);
                this.zlk.setVisibility(8);
                AppMethodBeat.m2505o(33555);
                return;
            } else {
                C4990ab.m7417i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", this, Integer.valueOf(i2));
                setVisibility(0);
                this.zlk.setVisibility(0);
                drawable = getContext().getResources().getDrawable(C1318a.icons_outlined_one_day_video);
                drawable.setBounds(0, 0, C1338a.fromDPToPix(getContext(), 20), C1338a.fromDPToPix(getContext(), 20));
                this.zlk.setCompoundDrawables(null, null, drawable, null);
                this.zlk.invalidate();
                AppMethodBeat.m2505o(33555);
                return;
            }
        }
        setVisibility(8);
        this.zlk.setVisibility(8);
        AppMethodBeat.m2505o(33555);
    }

    private boolean dHD() {
        boolean z;
        AppMethodBeat.m2504i(33556);
        Object tag = getTag();
        if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == 32) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", this, Boolean.valueOf(z));
        AppMethodBeat.m2505o(33556);
        return z;
    }

    /* renamed from: EH */
    public final void mo8984EH(final int i) {
        AppMethodBeat.m2504i(33557);
        C4990ab.m7411d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", this, Integer.valueOf(this.mStatus), Integer.valueOf(i));
        if (getVisibility() == 0 && dHD() && this.mStatus != i) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33550);
                    CategoryTipView.m24151a(CategoryTipView.this, i);
                    AppMethodBeat.m2505o(33550);
                }
            });
        }
        AppMethodBeat.m2505o(33557);
    }
}
