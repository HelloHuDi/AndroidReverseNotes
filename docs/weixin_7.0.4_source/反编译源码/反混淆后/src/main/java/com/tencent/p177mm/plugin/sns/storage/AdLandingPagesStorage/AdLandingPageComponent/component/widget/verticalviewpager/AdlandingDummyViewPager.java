package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager */
public class AdlandingDummyViewPager extends DummyViewPager {
    private C21962a rcQ = new C21962a(this, (byte) 0);
    public Set<OnPageChangeListener> rcR = new HashSet();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager$a */
    class C21962a implements OnPageChangeListener {
        private C21962a() {
        }

        /* synthetic */ C21962a(AdlandingDummyViewPager adlandingDummyViewPager, byte b) {
            this();
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.m2504i(37589);
            for (OnPageChangeListener onPageScrolled : AdlandingDummyViewPager.this.rcR) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
            AppMethodBeat.m2505o(37589);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(37590);
            for (OnPageChangeListener onPageSelected : AdlandingDummyViewPager.this.rcR) {
                onPageSelected.onPageSelected(i);
            }
            AppMethodBeat.m2505o(37590);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(37591);
            if (i == 0) {
                AdlandingDummyViewPager.this.rcT = AdlandingDummyViewPager.this.getScrollX();
            }
            for (OnPageChangeListener onPageScrollStateChanged : AdlandingDummyViewPager.this.rcR) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
            AppMethodBeat.m2505o(37591);
        }
    }

    public AdlandingDummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(37592);
        setOnPageChangeListener(this.rcQ);
        AppMethodBeat.m2505o(37592);
    }
}
