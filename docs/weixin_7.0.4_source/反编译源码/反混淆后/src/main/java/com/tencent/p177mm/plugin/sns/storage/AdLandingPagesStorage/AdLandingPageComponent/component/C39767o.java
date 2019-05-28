package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.p520ui.C43590al;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13472y;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21967k;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C34986x;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C3947z;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39779l;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39781u;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46232m;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46233o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
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

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o */
public final class C39767o extends C3910a {
    private static final Map<String, Bitmap> rao = new WeakHashMap();
    ViewPager rap;
    C3902a raq;
    AdLandingControlView rar;
    private int ras = 0;
    private int rat = 0;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o$a */
    static class C3902a extends C25365p {
        int backgroundColor;
        int ieu;
        int iev;
        Context mContext;
        LayoutInflater mLayoutInflater;
        HashMap<Integer, View> raA = new HashMap();
        HashMap<Integer, C3903a> raB = new HashMap();
        Set<String> raC = new HashSet();
        C34986x raw;
        private int rax = 600;
        int ray = 700;
        int raz = 250;

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o$a$a */
        public class C3903a {
            public LinkedList<C13437h> raI = new LinkedList();

            public C3903a() {
                AppMethodBeat.m2504i(37169);
                AppMethodBeat.m2505o(37169);
            }
        }

        public C3902a(Context context, LayoutInflater layoutInflater, C34986x c34986x, int i) {
            AppMethodBeat.m2504i(37170);
            this.mContext = context;
            this.mLayoutInflater = layoutInflater;
            this.raw = c34986x;
            this.backgroundColor = i;
            int[] eP = C29064ad.m46206eP(context);
            this.ieu = eP[0];
            this.iev = eP[1];
            AppMethodBeat.m2505o(37170);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(37171);
            int size = this.raw.qWB.size();
            AppMethodBeat.m2505o(37171);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(37172);
            super.setPrimaryItem((View) viewGroup, i, obj);
            AppMethodBeat.m2505o(37172);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(37173);
            C4990ab.m7411d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", Integer.valueOf(i));
            if (this.raA.containsKey(Integer.valueOf(i))) {
                Object obj = this.raA.get(Integer.valueOf(i));
                AppMethodBeat.m2505o(37173);
                return obj;
            }
            C4990ab.m7411d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", Integer.valueOf(i));
            View inflate = this.mLayoutInflater.inflate(2130970731, viewGroup, false);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131827648);
            linearLayout.setBackgroundColor(this.backgroundColor);
            C3903a c3903a = (C3903a) this.raB.get(Integer.valueOf(i));
            LinkedList linkedList = ((C39779l) this.raw.qWB.get(i)).qWB;
            if (c3903a == null || c3903a.raI.size() == 0) {
                C3903a c3903a2 = new C3903a();
                if (linkedList != null) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= linkedList.size()) {
                            break;
                        }
                        C4990ab.m7417i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", ((C29086r) linkedList.get(i3)).qWO);
                        c3903a2.raI.add(C43590al.m77980a(this.mContext, r1, linearLayout, this.backgroundColor));
                        i2 = i3 + 1;
                    }
                }
                this.raB.put(Integer.valueOf(i), c3903a2);
                c3903a = c3903a2;
            }
            Iterator it = c3903a.raI.iterator();
            while (it.hasNext()) {
                View view = ((C13437h) it.next()).getView();
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                linearLayout.addView(view);
            }
            ImageView imageView = (ImageView) inflate.findViewById(2131827649);
            TextView textView = (TextView) inflate.findViewById(2131827650);
            if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(C1338a.m2864g(this.mContext, C25738R.drawable.be3));
            } else {
                imageView.setImageDrawable(C1338a.m2864g(this.mContext, C25738R.drawable.be4));
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
            AppMethodBeat.m2505o(37173);
            return inflate;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(37174);
            viewGroup.removeView((View) obj);
            this.raA.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(37174);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.m2504i(37175);
            for (Integer intValue : this.raA.keySet()) {
                int intValue2 = intValue.intValue();
                if (this.raA.get(Integer.valueOf(intValue2)) == obj) {
                    AppMethodBeat.m2505o(37175);
                    return intValue2;
                }
            }
            AppMethodBeat.m2505o(37175);
            return -2;
        }

        /* renamed from: i */
        private void m6201i(final ImageView imageView) {
            AppMethodBeat.m2504i(37176);
            if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                imageView.setTag("1");
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                alphaAnimation.setDuration((long) this.rax);
                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                alphaAnimation.setAnimationListener(new AnimationListener() {

                    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o$a$2$1 */
                    class C39081 implements Runnable {
                        C39081() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(37167);
                            C3902a.m6200a(C3902a.this, imageView);
                            AppMethodBeat.m2505o(37167);
                        }
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(37168);
                        new C7306ak().postDelayed(new C39081(), 200);
                        AppMethodBeat.m2505o(37168);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                imageView.startAnimation(alphaAnimation);
                AppMethodBeat.m2505o(37176);
                return;
            }
            AppMethodBeat.m2505o(37176);
        }

        /* renamed from: Dn */
        public final void mo8636Dn(int i) {
            AppMethodBeat.m2504i(37177);
            View view = (View) this.raA.get(String.valueOf(i));
            if (view == null) {
                AppMethodBeat.m2505o(37177);
                return;
            }
            ImageView imageView = (ImageView) view.findViewById(2131827649);
            if (imageView != null && imageView.getVisibility() == 0) {
                m6201i(imageView);
            }
            AppMethodBeat.m2505o(37177);
        }

        /* renamed from: Do */
        public final void mo8637Do(int i) {
            AppMethodBeat.m2504i(37178);
            for (Integer num : this.raB.keySet()) {
                C3903a c3903a = (C3903a) this.raB.get(num);
                if (!(c3903a == null || c3903a.raI.size() == 0)) {
                    int i2;
                    C13437h c13437h;
                    if (num.intValue() == i) {
                        for (i2 = 0; i2 < c3903a.raI.size(); i2++) {
                            c13437h = (C13437h) c3903a.raI.get(i2);
                            if (c13437h.cpx()) {
                                c13437h.cpa();
                                c13437h.cpc();
                                this.raC.add(c13437h.cpy());
                            } else if (this.raC.contains(c13437h.cpy())) {
                                c13437h.cpb();
                                this.raC.remove(c13437h.cpy());
                            }
                        }
                    } else {
                        for (i2 = 0; i2 < c3903a.raI.size(); i2++) {
                            c13437h = (C13437h) c3903a.raI.get(i2);
                            if (this.raC.contains(c13437h.cpy())) {
                                c13437h.cpb();
                                this.raC.remove(c13437h.cpy());
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(37178);
        }

        public final List<C13437h> cpM() {
            AppMethodBeat.m2504i(37179);
            ArrayList arrayList = new ArrayList();
            for (C3903a c3903a : this.raB.values()) {
                arrayList.addAll(c3903a.raI);
            }
            AppMethodBeat.m2505o(37179);
            return arrayList;
        }

        /* renamed from: a */
        static /* synthetic */ void m6200a(C3902a c3902a, final ImageView imageView) {
            AppMethodBeat.m2504i(37180);
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) c3902a.ray);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.3f);
            alphaAnimation.setDuration((long) c3902a.ray);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(new AnimationListener() {

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o$a$1$1 */
                class C39051 implements AnimationListener {

                    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o$a$1$1$1 */
                    class C39061 implements AnimationListener {
                        C39061() {
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(37164);
                            imageView.setAlpha(0.0f);
                            AppMethodBeat.m2505o(37164);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    }

                    C39051() {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(37165);
                        long longValue = new BigInteger((String) imageView.getTag()).longValue();
                        if (longValue >= 3) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                            alphaAnimation.setDuration((long) C3902a.this.raz);
                            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                            alphaAnimation.setAnimationListener(new C39061());
                            imageView.startAnimation(alphaAnimation);
                            AppMethodBeat.m2505o(37165);
                            return;
                        }
                        imageView.setTag(String.valueOf(longValue + 1));
                        C3902a.m6200a(C3902a.this, imageView);
                        AppMethodBeat.m2505o(37165);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(37166);
                    AnimationSet animationSet = new AnimationSet(true);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) C3902a.this.ray);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) C3902a.this.ray);
                    animationSet.addAnimation(translateAnimation);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 0.8f);
                    alphaAnimation.setDuration((long) C3902a.this.ray);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    alphaAnimation.setStartTime((long) C3902a.this.ray);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setAnimationListener(new C39051());
                    imageView.startAnimation(animationSet);
                    AppMethodBeat.m2505o(37166);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
            AppMethodBeat.m2505o(37180);
        }
    }

    static {
        AppMethodBeat.m2504i(37191);
        AppMethodBeat.m2505o(37191);
    }

    public C39767o(Context context, C34986x c34986x, ViewGroup viewGroup) {
        super(context, c34986x, viewGroup);
        AppMethodBeat.m2504i(37181);
        this.rar = new AdLandingControlView(context);
        AppMethodBeat.m2505o(37181);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37182);
        this.raq.mo8636Dn(this.rat);
        this.raq.mo8637Do(this.rat);
        super.cpa();
        AppMethodBeat.m2505o(37182);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37183);
        this.raq.mo8637Do(-1);
        super.cpb();
        AppMethodBeat.m2505o(37183);
    }

    public final void cps() {
        AppMethodBeat.m2504i(37184);
        this.raq.mo8637Do(this.rat);
        AppMethodBeat.m2505o(37184);
    }

    /* renamed from: ae */
    public final void mo25536ae(Map<String, Object> map) {
        AppMethodBeat.m2504i(37185);
        super.mo25536ae(map);
        if (map.containsKey("startIndex")) {
            try {
                this.ras = ((Integer) map.get("startIndex")).intValue();
                this.rap.setCurrentItem(this.ras, false);
                AppMethodBeat.m2505o(37185);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(37185);
    }

    public final void cpA() {
        AppMethodBeat.m2504i(37186);
        super.cpA();
        this.rap.setCurrentItem(this.ras, false);
        AppMethodBeat.m2505o(37186);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        C3902a c3902a;
        AppMethodBeat.m2504i(37187);
        int i = (this.ieu - ((int) ((C34986x) this.qZo).qWS)) - ((int) ((C34986x) this.qZo).qWT);
        int i2 = this.iev;
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.rap.getAdapter() == null) {
            final C3902a c3902a2 = new C3902a(this.context, layoutInflater, (C34986x) this.qZo, this.backgroundColor);
            this.rap.setOnPageChangeListener(new OnPageChangeListener() {
                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    AppMethodBeat.m2504i(37163);
                    C4990ab.m7417i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", Integer.valueOf(i));
                    C39767o.this.rar.setPage(i);
                    C39767o.this.rat = i;
                    if (C39767o.this.qZr) {
                        c3902a2.mo8636Dn(i);
                        c3902a2.mo8637Do(i);
                    }
                    AppMethodBeat.m2505o(37163);
                }

                public final void onPageScrollStateChanged(int i) {
                }
            });
            this.rap.setAdapter(c3902a2);
            c3902a = c3902a2;
        } else {
            C3902a c3902a3 = (C3902a) this.rap.getAdapter();
            c3902a3.raw = (C34986x) this.qZo;
            c3902a = c3902a3;
        }
        this.rar.mo69952hj(((C34986x) this.qZo).qWB.size(), 0);
        if (((C34986x) this.qZo).iXr) {
            this.rap.setLayoutParams(new LayoutParams(i, i2));
        } else if (((C34986x) this.qZo).qWB.size() > 0) {
            C39779l c39779l = (C39779l) ((C34986x) this.qZo).qWB.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i3 = 0;
            Iterator it = c39779l.qWB.iterator();
            while (it.hasNext()) {
                C29086r c29086r = (C29086r) it.next();
                int i4 = (int) (((float) i3) + c29086r.qWQ);
                if (c29086r instanceof C39781u) {
                    C39781u c39781u = (C39781u) c29086r;
                    View inflate = layoutInflater.inflate(2130970730, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(2131827647)).setText(c39781u.qXk);
                    ((TextView) inflate.findViewById(2131827647)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i3 = ((TextView) inflate.findViewById(2131827647)).getPaddingBottom() + ((i4 + ((TextView) inflate.findViewById(2131827647)).getPaddingTop()) + ((TextView) inflate.findViewById(2131827647)).getHeight());
                } else if (c29086r instanceof C21967k) {
                    Button button = (Button) layoutInflater.inflate(2130970720, null).findViewById(2131827628);
                    button.setText(((C21967k) c29086r).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i4;
                    if (c29086r.qWV > 0.0f && ((int) c29086r.qWV) != BaseClientBuilder.API_PRIORITY_OTHER) {
                        paddingTop = (int) (((float) paddingTop) + c29086r.qWV);
                    } else if (c29086r.height <= 0.0f || ((int) c29086r.height) == BaseClientBuilder.API_PRIORITY_OTHER) {
                        paddingTop += button.getHeight();
                    } else {
                        paddingTop = (int) (((float) paddingTop) + c29086r.height);
                    }
                    i3 = button.getPaddingBottom() + paddingTop;
                } else if (c29086r instanceof C39780n) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = c29086r.qWQ;
                    float f4 = c29086r.qWR;
                    if (c29086r instanceof C39780n) {
                        C39780n c39780n = (C39780n) c29086r;
                        f = c39780n.height;
                        f2 = c39780n.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i3 = i4 + i2;
                    } else {
                        i3 = (int) (((f * ((float) i)) / f2) + ((float) i4));
                    }
                    i3 = (int) (((float) ((int) (((float) i3) + f3))) + f4);
                } else if (c29086r instanceof C46232m) {
                    i3 = i4 + i2;
                } else if (c29086r instanceof C46233o) {
                    C46233o c46233o = (C46233o) c29086r;
                    if (c46233o.qWL == 1) {
                        i3 = i4 + i2;
                    } else if (((int) c46233o.width) > 0) {
                        i3 = ((((int) c46233o.height) * i) / ((int) c46233o.width)) + i4;
                    } else {
                        i3 = (int) (c46233o.height + ((float) i4));
                    }
                } else if (c29086r instanceof C3947z) {
                    C3947z c3947z = (C3947z) c29086r;
                    if (c3947z.qXw != 1) {
                        i3 = i4 + i2;
                    } else if (((int) c3947z.width) > 0) {
                        i3 = ((((int) c3947z.height) * i) / ((int) c3947z.width)) + i4;
                    } else {
                        i3 = (int) (c3947z.height + ((float) i4));
                    }
                } else if (c29086r instanceof C13472y) {
                    i3 = i4 + i2;
                } else {
                    i3 = i4;
                }
                i3 = (int) (c29086r.qWR + ((float) i3));
            }
            LayoutParams layoutParams = new LayoutParams(i, i3);
            layoutParams.leftMargin = (int) ((C34986x) this.qZo).qWS;
            layoutParams.rightMargin = (int) ((C34986x) this.qZo).qWT;
            this.rap.setLayoutParams(layoutParams);
        }
        this.raq = c3902a;
        c3902a.notifyDataSetChanged();
        AppMethodBeat.m2505o(37187);
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37188);
        View view = this.contentView;
        this.rap = (ViewPager) view.findViewById(2131827651);
        this.rar = (AdLandingControlView) view.findViewById(2131827652);
        AppMethodBeat.m2505o(37188);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970732;
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37189);
        if (super.mo15456al(jSONObject)) {
            AppMethodBeat.m2505o(37189);
            return true;
        }
        AppMethodBeat.m2505o(37189);
        return false;
    }

    public final List<C13437h> cpt() {
        AppMethodBeat.m2504i(37190);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((C3902a) this.rap.getAdapter()).cpM());
        AppMethodBeat.m2505o(37190);
        return arrayList;
    }
}
