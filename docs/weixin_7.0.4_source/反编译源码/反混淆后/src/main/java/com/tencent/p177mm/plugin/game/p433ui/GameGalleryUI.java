package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.sdk.platformtools.C5004al;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.game.ui.GameGalleryUI */
public class GameGalleryUI extends MMActivity implements OnPageChangeListener {
    private String appId = "";
    private MMDotView jiG;
    private int lTe = -1;
    private int nja = 0;
    /* renamed from: sq */
    private ViewPager f17201sq;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameGalleryUI$a */
    static class C21019a extends C25365p {
        Context mContext;
        private String[] njb = new String[0];
        private View[] njc;

        /* renamed from: com.tencent.mm.plugin.game.ui.GameGalleryUI$a$2 */
        class C32562 implements OnClickListener {
            C32562() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(111963);
                ((MMActivity) C21019a.this.mContext).finish();
                AppMethodBeat.m2505o(111963);
            }
        }

        public C21019a(Context context, String[] strArr) {
            AppMethodBeat.m2504i(111964);
            this.mContext = context;
            if (strArr != null) {
                this.njb = strArr;
            }
            this.njc = new View[this.njb.length];
            AppMethodBeat.m2505o(111964);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(111965);
            View view = this.njc[i];
            if (view == null) {
                View inflate = View.inflate(this.mContext, 2130969719, null);
                this.njc[i] = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(2131824511);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131824512);
                progressBar.setVisibility(0);
                C25815a ahp = C32291o.ahp();
                String str = this.njb[i];
                C17927a c17927a = new C17927a();
                c17927a.ePG = true;
                ahp.mo43767a(str, imageView, c17927a.ahG(), new C9014g() {

                    /* renamed from: com.tencent.mm.plugin.game.ui.GameGalleryUI$a$1$1 */
                    class C32551 implements Runnable {
                        C32551() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(111961);
                            progressBar.setVisibility(8);
                            AppMethodBeat.m2505o(111961);
                        }
                    }

                    /* renamed from: sH */
                    public final void mo7596sH(String str) {
                    }

                    /* renamed from: a */
                    public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                        return null;
                    }

                    /* renamed from: b */
                    public final void mo7595b(String str, View view, C37477b c37477b) {
                        AppMethodBeat.m2504i(111962);
                        C5004al.m7441d(new C32551());
                        AppMethodBeat.m2505o(111962);
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new C32562());
            AppMethodBeat.m2505o(111965);
            return view;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(111966);
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(111966);
        }

        public final int getCount() {
            return this.njb.length;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111967);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.f17201sq = (ViewPager) findViewById(2131824509);
        this.jiG = (MMDotView) findViewById(2131824510);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            AppMethodBeat.m2505o(111967);
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.lTe = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.nja = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.f17201sq.setAdapter(new C21019a(this, stringArrayExtra));
        this.f17201sq.setOnPageChangeListener(this);
        this.f17201sq.setCurrentItem(intExtra, false);
        this.jiG.setInvertedStyle(true);
        this.jiG.setDotCount(stringArrayExtra.length);
        this.jiG.setSelectedDot(intExtra);
        if (intExtra == 0) {
            C34277b.m56211a(this, this.lTe, 1202, 1, 12, this.appId, this.nja, null);
        }
        AppMethodBeat.m2505o(111967);
    }

    public final int getLayoutId() {
        return 2130969718;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(111968);
        this.jiG.setSelectedDot(i);
        C34277b.m56211a(this, this.lTe, 1202, i + 1, 12, this.appId, this.nja, null);
        AppMethodBeat.m2505o(111968);
    }

    public void onPageScrollStateChanged(int i) {
    }
}
