package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager extends DummyViewPager {
    private a rcQ = new a(this, (byte) 0);
    public Set<OnPageChangeListener> rcR = new HashSet();

    class a implements OnPageChangeListener {
        private a() {
        }

        /* synthetic */ a(AdlandingDummyViewPager adlandingDummyViewPager, byte b) {
            this();
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.i(37589);
            for (OnPageChangeListener onPageScrolled : AdlandingDummyViewPager.this.rcR) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
            AppMethodBeat.o(37589);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.i(37590);
            for (OnPageChangeListener onPageSelected : AdlandingDummyViewPager.this.rcR) {
                onPageSelected.onPageSelected(i);
            }
            AppMethodBeat.o(37590);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.i(37591);
            if (i == 0) {
                AdlandingDummyViewPager.this.rcT = AdlandingDummyViewPager.this.getScrollX();
            }
            for (OnPageChangeListener onPageScrollStateChanged : AdlandingDummyViewPager.this.rcR) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
            AppMethodBeat.o(37591);
        }
    }

    public AdlandingDummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37592);
        setOnPageChangeListener(this.rcQ);
        AppMethodBeat.o(37592);
    }
}
