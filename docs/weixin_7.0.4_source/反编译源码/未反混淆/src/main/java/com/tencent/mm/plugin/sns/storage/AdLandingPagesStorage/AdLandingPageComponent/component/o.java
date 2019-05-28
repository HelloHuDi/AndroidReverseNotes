package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.smtt.sdk.WebView;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a {
    private static final Map<String, Bitmap> rao = new WeakHashMap();
    ViewPager rap;
    a raq;
    AdLandingControlView rar;
    private int ras = 0;
    private int rat = 0;

    static class a extends p {
        int backgroundColor;
        int ieu;
        int iev;
        Context mContext;
        LayoutInflater mLayoutInflater;
        HashMap<Integer, View> raA = new HashMap();
        HashMap<Integer, a> raB = new HashMap();
        Set<String> raC = new HashSet();
        x raw;
        private int rax = 600;
        int ray = 700;
        int raz = 250;

        public class a {
            public LinkedList<h> raI = new LinkedList();

            public a() {
                AppMethodBeat.i(37169);
                AppMethodBeat.o(37169);
            }
        }

        public a(Context context, LayoutInflater layoutInflater, x xVar, int i) {
            AppMethodBeat.i(37170);
            this.mContext = context;
            this.mLayoutInflater = layoutInflater;
            this.raw = xVar;
            this.backgroundColor = i;
            int[] eP = ad.eP(context);
            this.ieu = eP[0];
            this.iev = eP[1];
            AppMethodBeat.o(37170);
        }

        public final int getCount() {
            AppMethodBeat.i(37171);
            int size = this.raw.qWB.size();
            AppMethodBeat.o(37171);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(37172);
            super.setPrimaryItem((View) viewGroup, i, obj);
            AppMethodBeat.o(37172);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(37173);
            ab.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", Integer.valueOf(i));
            if (this.raA.containsKey(Integer.valueOf(i))) {
                Object obj = this.raA.get(Integer.valueOf(i));
                AppMethodBeat.o(37173);
                return obj;
            }
            ab.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", Integer.valueOf(i));
            View inflate = this.mLayoutInflater.inflate(R.layout.aue, viewGroup, false);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.eg1);
            linearLayout.setBackgroundColor(this.backgroundColor);
            a aVar = (a) this.raB.get(Integer.valueOf(i));
            LinkedList linkedList = ((l) this.raw.qWB.get(i)).qWB;
            if (aVar == null || aVar.raI.size() == 0) {
                a aVar2 = new a();
                if (linkedList != null) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= linkedList.size()) {
                            break;
                        }
                        ab.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", ((r) linkedList.get(i3)).qWO);
                        aVar2.raI.add(al.a(this.mContext, r1, linearLayout, this.backgroundColor));
                        i2 = i3 + 1;
                    }
                }
                this.raB.put(Integer.valueOf(i), aVar2);
                aVar = aVar2;
            }
            Iterator it = aVar.raI.iterator();
            while (it.hasNext()) {
                View view = ((h) it.next()).getView();
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                linearLayout.addView(view);
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.eg2);
            TextView textView = (TextView) inflate.findViewById(R.id.eg3);
            if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.drawable.be3));
            } else {
                imageView.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.drawable.be4));
            }
            if (this.raw.qXu == 1) {
                imageView.setVisibility(8);
                textView.setVisibility(8);
            } else {
                if (i == this.raw.qWB.size() - 1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                textView.setText((i + 1) + "/" + this.raw.qWB.size());
            }
            inflate.setLayoutParams(new LayoutParams(this.ieu, linearLayout.getMeasuredHeight()));
            inflate.setBackgroundColor(this.backgroundColor);
            viewGroup.addView(inflate);
            viewGroup.setBackgroundColor(this.backgroundColor);
            this.raA.put(Integer.valueOf(i), inflate);
            AppMethodBeat.o(37173);
            return inflate;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(37174);
            viewGroup.removeView((View) obj);
            this.raA.remove(Integer.valueOf(i));
            AppMethodBeat.o(37174);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(37175);
            for (Integer intValue : this.raA.keySet()) {
                int intValue2 = intValue.intValue();
                if (this.raA.get(Integer.valueOf(intValue2)) == obj) {
                    AppMethodBeat.o(37175);
                    return intValue2;
                }
            }
            AppMethodBeat.o(37175);
            return -2;
        }

        private void i(final ImageView imageView) {
            AppMethodBeat.i(37176);
            if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                imageView.setTag("1");
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                alphaAnimation.setDuration((long) this.rax);
                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                alphaAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(37168);
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37167);
                                a.a(a.this, imageView);
                                AppMethodBeat.o(37167);
                            }
                        }, 200);
                        AppMethodBeat.o(37168);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                imageView.startAnimation(alphaAnimation);
                AppMethodBeat.o(37176);
                return;
            }
            AppMethodBeat.o(37176);
        }

        public final void Dn(int i) {
            AppMethodBeat.i(37177);
            View view = (View) this.raA.get(String.valueOf(i));
            if (view == null) {
                AppMethodBeat.o(37177);
                return;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.eg2);
            if (imageView != null && imageView.getVisibility() == 0) {
                i(imageView);
            }
            AppMethodBeat.o(37177);
        }

        public final void Do(int i) {
            AppMethodBeat.i(37178);
            for (Integer num : this.raB.keySet()) {
                a aVar = (a) this.raB.get(num);
                if (!(aVar == null || aVar.raI.size() == 0)) {
                    int i2;
                    h hVar;
                    if (num.intValue() == i) {
                        for (i2 = 0; i2 < aVar.raI.size(); i2++) {
                            hVar = (h) aVar.raI.get(i2);
                            if (hVar.cpx()) {
                                hVar.cpa();
                                hVar.cpc();
                                this.raC.add(hVar.cpy());
                            } else if (this.raC.contains(hVar.cpy())) {
                                hVar.cpb();
                                this.raC.remove(hVar.cpy());
                            }
                        }
                    } else {
                        for (i2 = 0; i2 < aVar.raI.size(); i2++) {
                            hVar = (h) aVar.raI.get(i2);
                            if (this.raC.contains(hVar.cpy())) {
                                hVar.cpb();
                                this.raC.remove(hVar.cpy());
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(37178);
        }

        public final List<h> cpM() {
            AppMethodBeat.i(37179);
            ArrayList arrayList = new ArrayList();
            for (a aVar : this.raB.values()) {
                arrayList.addAll(aVar.raI);
            }
            AppMethodBeat.o(37179);
            return arrayList;
        }

        static /* synthetic */ void a(a aVar, final ImageView imageView) {
            AppMethodBeat.i(37180);
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) aVar.ray);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.3f);
            alphaAnimation.setDuration((long) aVar.ray);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(37166);
                    AnimationSet animationSet = new AnimationSet(true);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) a.this.ray);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) a.this.ray);
                    animationSet.addAnimation(translateAnimation);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 0.8f);
                    alphaAnimation.setDuration((long) a.this.ray);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    alphaAnimation.setStartTime((long) a.this.ray);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(37165);
                            long longValue = new BigInteger((String) imageView.getTag()).longValue();
                            if (longValue >= 3) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                                alphaAnimation.setDuration((long) a.this.raz);
                                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                                alphaAnimation.setAnimationListener(new AnimationListener() {
                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        AppMethodBeat.i(37164);
                                        imageView.setAlpha(0.0f);
                                        AppMethodBeat.o(37164);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                imageView.startAnimation(alphaAnimation);
                                AppMethodBeat.o(37165);
                                return;
                            }
                            imageView.setTag(String.valueOf(longValue + 1));
                            a.a(a.this, imageView);
                            AppMethodBeat.o(37165);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(animationSet);
                    AppMethodBeat.o(37166);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
            AppMethodBeat.o(37180);
        }
    }

    static {
        AppMethodBeat.i(37191);
        AppMethodBeat.o(37191);
    }

    public o(Context context, x xVar, ViewGroup viewGroup) {
        super(context, xVar, viewGroup);
        AppMethodBeat.i(37181);
        this.rar = new AdLandingControlView(context);
        AppMethodBeat.o(37181);
    }

    public final void cpa() {
        AppMethodBeat.i(37182);
        this.raq.Dn(this.rat);
        this.raq.Do(this.rat);
        super.cpa();
        AppMethodBeat.o(37182);
    }

    public final void cpb() {
        AppMethodBeat.i(37183);
        this.raq.Do(-1);
        super.cpb();
        AppMethodBeat.o(37183);
    }

    public final void cps() {
        AppMethodBeat.i(37184);
        this.raq.Do(this.rat);
        AppMethodBeat.o(37184);
    }

    public final void ae(Map<String, Object> map) {
        AppMethodBeat.i(37185);
        super.ae(map);
        if (map.containsKey("startIndex")) {
            try {
                this.ras = ((Integer) map.get("startIndex")).intValue();
                this.rap.setCurrentItem(this.ras, false);
                AppMethodBeat.o(37185);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(37185);
    }

    public final void cpA() {
        AppMethodBeat.i(37186);
        super.cpA();
        this.rap.setCurrentItem(this.ras, false);
        AppMethodBeat.o(37186);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        a aVar;
        AppMethodBeat.i(37187);
        int i = (this.ieu - ((int) ((x) this.qZo).qWS)) - ((int) ((x) this.qZo).qWT);
        int i2 = this.iev;
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.rap.getAdapter() == null) {
            final a aVar2 = new a(this.context, layoutInflater, (x) this.qZo, this.backgroundColor);
            this.rap.setOnPageChangeListener(new OnPageChangeListener() {
                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    AppMethodBeat.i(37163);
                    ab.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", Integer.valueOf(i));
                    o.this.rar.setPage(i);
                    o.this.rat = i;
                    if (o.this.qZr) {
                        aVar2.Dn(i);
                        aVar2.Do(i);
                    }
                    AppMethodBeat.o(37163);
                }

                public final void onPageScrollStateChanged(int i) {
                }
            });
            this.rap.setAdapter(aVar2);
            aVar = aVar2;
        } else {
            a aVar3 = (a) this.rap.getAdapter();
            aVar3.raw = (x) this.qZo;
            aVar = aVar3;
        }
        this.rar.hj(((x) this.qZo).qWB.size(), 0);
        if (((x) this.qZo).iXr) {
            this.rap.setLayoutParams(new LayoutParams(i, i2));
        } else if (((x) this.qZo).qWB.size() > 0) {
            l lVar = (l) ((x) this.qZo).qWB.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i3 = 0;
            Iterator it = lVar.qWB.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                int i4 = (int) (((float) i3) + rVar.qWQ);
                if (rVar instanceof u) {
                    u uVar = (u) rVar;
                    View inflate = layoutInflater.inflate(R.layout.aud, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(R.id.eg0)).setText(uVar.qXk);
                    ((TextView) inflate.findViewById(R.id.eg0)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i3 = ((TextView) inflate.findViewById(R.id.eg0)).getPaddingBottom() + ((i4 + ((TextView) inflate.findViewById(R.id.eg0)).getPaddingTop()) + ((TextView) inflate.findViewById(R.id.eg0)).getHeight());
                } else if (rVar instanceof k) {
                    Button button = (Button) layoutInflater.inflate(R.layout.au4, null).findViewById(R.id.efh);
                    button.setText(((k) rVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i4;
                    if (rVar.qWV > 0.0f && ((int) rVar.qWV) != BaseClientBuilder.API_PRIORITY_OTHER) {
                        paddingTop = (int) (((float) paddingTop) + rVar.qWV);
                    } else if (rVar.height <= 0.0f || ((int) rVar.height) == BaseClientBuilder.API_PRIORITY_OTHER) {
                        paddingTop += button.getHeight();
                    } else {
                        paddingTop = (int) (((float) paddingTop) + rVar.height);
                    }
                    i3 = button.getPaddingBottom() + paddingTop;
                } else if (rVar instanceof n) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = rVar.qWQ;
                    float f4 = rVar.qWR;
                    if (rVar instanceof n) {
                        n nVar = (n) rVar;
                        f = nVar.height;
                        f2 = nVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i3 = i4 + i2;
                    } else {
                        i3 = (int) (((f * ((float) i)) / f2) + ((float) i4));
                    }
                    i3 = (int) (((float) ((int) (((float) i3) + f3))) + f4);
                } else if (rVar instanceof m) {
                    i3 = i4 + i2;
                } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o oVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) rVar;
                    if (oVar.qWL == 1) {
                        i3 = i4 + i2;
                    } else if (((int) oVar.width) > 0) {
                        i3 = ((((int) oVar.height) * i) / ((int) oVar.width)) + i4;
                    } else {
                        i3 = (int) (oVar.height + ((float) i4));
                    }
                } else if (rVar instanceof z) {
                    z zVar = (z) rVar;
                    if (zVar.qXw != 1) {
                        i3 = i4 + i2;
                    } else if (((int) zVar.width) > 0) {
                        i3 = ((((int) zVar.height) * i) / ((int) zVar.width)) + i4;
                    } else {
                        i3 = (int) (zVar.height + ((float) i4));
                    }
                } else if (rVar instanceof y) {
                    i3 = i4 + i2;
                } else {
                    i3 = i4;
                }
                i3 = (int) (rVar.qWR + ((float) i3));
            }
            LayoutParams layoutParams = new LayoutParams(i, i3);
            layoutParams.leftMargin = (int) ((x) this.qZo).qWS;
            layoutParams.rightMargin = (int) ((x) this.qZo).qWT;
            this.rap.setLayoutParams(layoutParams);
        }
        this.raq = aVar;
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(37187);
    }

    public final void cpk() {
        AppMethodBeat.i(37188);
        View view = this.contentView;
        this.rap = (ViewPager) view.findViewById(R.id.eg4);
        this.rar = (AdLandingControlView) view.findViewById(R.id.eg5);
        AppMethodBeat.o(37188);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.auf;
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37189);
        if (super.al(jSONObject)) {
            AppMethodBeat.o(37189);
            return true;
        }
        AppMethodBeat.o(37189);
        return false;
    }

    public final List<h> cpt() {
        AppMethodBeat.i(37190);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((a) this.rap.getAdapter()).cpM());
        AppMethodBeat.o(37190);
        return arrayList;
    }
}
