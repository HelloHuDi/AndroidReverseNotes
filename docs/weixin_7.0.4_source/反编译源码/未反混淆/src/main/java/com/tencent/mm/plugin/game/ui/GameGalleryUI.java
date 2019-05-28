package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI extends MMActivity implements OnPageChangeListener {
    private String appId = "";
    private MMDotView jiG;
    private int lTe = -1;
    private int nja = 0;
    private ViewPager sq;

    static class a extends p {
        Context mContext;
        private String[] njb = new String[0];
        private View[] njc;

        public a(Context context, String[] strArr) {
            AppMethodBeat.i(111964);
            this.mContext = context;
            if (strArr != null) {
                this.njb = strArr;
            }
            this.njc = new View[this.njb.length];
            AppMethodBeat.o(111964);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(111965);
            View view = this.njc[i];
            if (view == null) {
                View inflate = View.inflate(this.mContext, R.layout.a43, null);
                this.njc[i] = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.c68);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.c69);
                progressBar.setVisibility(0);
                com.tencent.mm.at.a.a ahp = o.ahp();
                String str = this.njb[i];
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePG = true;
                ahp.a(str, imageView, aVar.ahG(), new g() {
                    public final void sH(String str) {
                    }

                    public final Bitmap a(String str, View view, b bVar) {
                        return null;
                    }

                    public final void b(String str, View view, b bVar) {
                        AppMethodBeat.i(111962);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111961);
                                progressBar.setVisibility(8);
                                AppMethodBeat.o(111961);
                            }
                        });
                        AppMethodBeat.o(111962);
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(111963);
                    ((MMActivity) a.this.mContext).finish();
                    AppMethodBeat.o(111963);
                }
            });
            AppMethodBeat.o(111965);
            return view;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(111966);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(111966);
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
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111967);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sq = (ViewPager) findViewById(R.id.c66);
        this.jiG = (MMDotView) findViewById(R.id.c67);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            AppMethodBeat.o(111967);
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.lTe = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.nja = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.sq.setAdapter(new a(this, stringArrayExtra));
        this.sq.setOnPageChangeListener(this);
        this.sq.setCurrentItem(intExtra, false);
        this.jiG.setInvertedStyle(true);
        this.jiG.setDotCount(stringArrayExtra.length);
        this.jiG.setSelectedDot(intExtra);
        if (intExtra == 0) {
            com.tencent.mm.plugin.game.e.b.a(this, this.lTe, 1202, 1, 12, this.appId, this.nja, null);
        }
        AppMethodBeat.o(111967);
    }

    public final int getLayoutId() {
        return R.layout.a42;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(111968);
        this.jiG.setSelectedDot(i);
        com.tencent.mm.plugin.game.e.b.a(this, this.lTe, 1202, i + 1, 12, this.appId, this.nja, null);
        AppMethodBeat.o(111968);
    }

    public void onPageScrollStateChanged(int i) {
    }
}
