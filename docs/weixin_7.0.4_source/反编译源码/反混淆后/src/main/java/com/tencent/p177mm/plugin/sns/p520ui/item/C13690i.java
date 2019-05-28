package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.p612ui.widget.RoundedCornerRelativeLayout;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C29247a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C21988h;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.i */
public final class C13690i extends BaseTimeLineItem {
    private static int[] rHh = new int[]{2131827917, 2131827918};
    private static int[] rIW = new int[]{2131827919};
    private static int[][] rIX = new int[][]{new int[]{2131827924, 2131827925}, new int[]{2131827921, 2131827922}, new int[]{2131827921, 2131827925}};
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int rIV = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.i$6 */
    public class C136946 implements AnimationListener {
        final /* synthetic */ float cjZ;
        final /* synthetic */ float cka;
        final /* synthetic */ View rHk;
        final /* synthetic */ View rHl;
        final /* synthetic */ int rHn;
        final /* synthetic */ C13695a rJa;
        final /* synthetic */ View rJb;

        public C136946(View view, View view2, C13695a c13695a, View view3, int i, float f, float f2) {
            this.rHk = view;
            this.rHl = view2;
            this.rJa = c13695a;
            this.rJb = view3;
            this.rHn = i;
            this.cjZ = f;
            this.cka = f2;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(40160);
            this.rHk.setVisibility(0);
            this.rHl.setVisibility(8);
            C13690i.m21890b(this.rJa.rJe);
            C29247a c29247a = new C29247a(this.rJb.getContext(), (float) this.rHn, 0.0f, this.cjZ, this.cka, false);
            c29247a.setDuration(187);
            c29247a.setInterpolator(new DecelerateInterpolator());
            this.rJb.startAnimation(c29247a);
            AppMethodBeat.m2505o(40160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.i$a */
    public static final class C13695a {
        public int index;
        public bau qJh;
        public View rJc;
        public C13697b rJd;
        public C13695a rJe;
        public C46236n ros;
        public View view;
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.i$4 */
    class C136964 implements OnTouchListener {
        C136964() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.i$b */
    public static class C13697b extends BaseViewHolder {
        public View rGQ;
        public View rGR;
        public View rJf;
        public boolean rJg = false;
        public C13695a rJh;
        public C43589aj rJi = new C43589aj();

        public C13697b() {
            AppMethodBeat.m2504i(40161);
            AppMethodBeat.m2505o(40161);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m21890b(C13695a c13695a) {
        AppMethodBeat.m2504i(40166);
        C13690i.m21889a(c13695a);
        AppMethodBeat.m2505o(40166);
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40162);
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.rIV = (((Math.min(this.mScreenWidth, this.mScreenHeight) - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        }
        C13697b c13697b = (C13697b) baseViewHolder;
        if (c13697b.rHC != null && !c13697b.rJg) {
            c13697b.rHC.setLayoutResource(2130970822);
            if (!c13697b.rJg) {
                c13697b.rJf = c13697b.rHC.inflate();
                c13697b.rJg = true;
            }
        } else if (!c13697b.rJg) {
            c13697b.rJf = c13697b.mRR.findViewById(2131827916);
            c13697b.rJg = true;
        }
        LayoutParams layoutParams = c13697b.rJf.getLayoutParams();
        layoutParams.width = this.rIV;
        layoutParams.height = this.rIV;
        ((RoundedCornerRelativeLayout) c13697b.rJf).setRadius(8.0f);
        C43589aj c43589aj = c13697b.rJi;
        c43589aj.rnt = C13690i.m21891u(c13697b.rJf, 0, 6);
        c43589aj.rns = c43589aj.rnt;
        c43589aj.qzM = (C34915a) c43589aj.rnt.findViewById(2131820629);
        c43589aj.raP = (ImageView) c43589aj.rnt.findViewById(2131820981);
        c43589aj.rnu = (MMPinProgressBtn) c43589aj.rnt.findViewById(2131821370);
        c43589aj.rnv = (TextView) c43589aj.rnt.findViewById(2131827571);
        c43589aj.raQ = (TextView) c43589aj.rnt.findViewById(2131827572);
        ((SightPlayImageView) c43589aj.qzM).qyI = true;
        ((SightPlayImageView) c43589aj.qzM).setScaleType(C15991a.CENTER_CROP);
        c43589aj.qzM.mo8513fi(this.rIV, this.rIV);
        c13697b.rGQ = c13697b.rJf.findViewById(2131827920);
        c13697b.rGR = c13697b.rJf.findViewById(2131827923);
        AppMethodBeat.m2505o(40162);
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40163);
        C4990ab.m7417i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            C4990ab.m7416i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
            AppMethodBeat.m2505o(40163);
            return;
        }
        int hashCode;
        View findViewById;
        C13697b c13697b = (C13697b) baseViewHolder;
        c13697b.rJf.setTag(c13697b);
        c13697b.rJf.setVisibility(0);
        c13697b.rJf.setLayerType(2, null);
        C13697b c13697b2 = c13697b;
        for (int findViewById2 : rHh) {
            findViewById = c13697b2.rJf.findViewById(findViewById2);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById instanceof MaskImageView) {
                ((MaskImageView) findViewById).setScaleType(C15991a.CENTER_CROP);
            }
        }
        for (int findViewById22 : rIW) {
            findViewById = c13697b2.rJf.findViewById(findViewById22);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setVisibility(8);
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).setClipChildren(false);
                }
            }
        }
        baseViewHolder.rHB.setLayoutParams(new LinearLayout.LayoutParams((((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc), -2));
        if (c13633av.rgZ && i2 == 11) {
            if (timeLineObject.xfI == null || timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() < 2) {
                C4990ab.m7412e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
                AppMethodBeat.m2505o(40163);
                return;
            }
            int i3;
            final C13697b c13697b3;
            if (c13697b.rHu == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            C13695a c13695a = null;
            C13695a c13695a2 = null;
            int i4 = 0;
            while (i4 < Math.min(timeLineObject.xfI.wbK.size(), 2)) {
                C13695a c13695a3;
                C13695a c13695a4;
                bau bau = (bau) timeLineObject.xfI.wbK.get(i4);
                View u = C13690i.m21891u(c13697b.rJf, i4, 2);
                u.setVisibility(4);
                if (u != null) {
                    LayoutParams layoutParams;
                    u.setTag(baseViewHolder);
                    u.setOnClickListener(c46251au.qOL.rKn);
                    C21925g cnC;
                    if (bau.jCt == 2) {
                        cnC = C13373af.cnC();
                        hashCode = this.mActivity.hashCode();
                        C44222az dtg = C44222az.dtg();
                        dtg.oyB = timeLineObject.pcX;
                        cnC.mo37450a(bau, u, -1, hashCode, dtg, 3);
                    } else {
                        cnC = C13373af.cnC();
                        int hashCode2 = this.mActivity.hashCode();
                        C44222az dtg2 = C44222az.dtg();
                        dtg2.oyB = timeLineObject.pcX;
                        cnC.mo37442a(bau, u, hashCode2, dtg2);
                    }
                    View view = null;
                    if (bau.jCt == 6 && i3 == i4) {
                        final boolean z = i3 > 0;
                        final long j = c13633av.rAt;
                        final C43589aj c43589aj = c13697b.rJi;
                        C46236n c46236n = c13633av.qBY;
                        View view2 = c43589aj.rns;
                        c43589aj.rnr = timeLineObject;
                        final C46251au c46251au2 = c46251au;
                        c43589aj.qzM.setOnCompletionListener(new C13304e() {
                            /* renamed from: c */
                            public final void mo8940c(C13303b c13303b, int i) {
                                AppMethodBeat.m2504i(40156);
                                if (i != -1) {
                                    if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                                        AppMethodBeat.m2505o(40156);
                                        return;
                                    }
                                    c46251au2.rxP.rhm.mo25445u(j, z);
                                }
                                AppMethodBeat.m2505o(40156);
                            }
                        });
                        if (!c46251au.rxP.rhm.mo25439jO(((long) i4) + j)) {
                            c46251au2 = c46251au;
                            c43589aj.qzM.setOnDecodeDurationListener(new C13325f() {
                                /* renamed from: b */
                                public final void mo8946b(C13303b c13303b, long j) {
                                    AppMethodBeat.m2504i(40157);
                                    if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                                        AppMethodBeat.m2505o(40157);
                                        return;
                                    }
                                    if (j >= 3) {
                                        int cle = (int) c13303b.cle();
                                        c46251au2.rxP.rhm.mo25433c(j, C5046bo.m7588yz(), z);
                                        c46251au2.rxP.rhm.mo25436f(j, cle, z);
                                        c46251au2.rxP.rhm.mo25429T(j, j + ((long) i4));
                                        c43589aj.qzM.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.m2505o(40157);
                                }
                            });
                        } else if (!(c46251au == null || c46251au.rxP == null || c46251au.rxP.rhm == null)) {
                            c46251au.rxP.rhm.mo25433c(j, C5046bo.m7588yz(), z);
                        }
                        c43589aj.mo69200a(timeLineObject, i, c13633av.riA, c13633av.rgZ);
                        c43589aj.raQ.setVisibility(8);
                        C21925g cnC2 = C13373af.cnC();
                        long nanoTime = System.nanoTime() - System.nanoTime();
                        C4990ab.m7417i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
                        if (C21925g.m33541t(bau)) {
                            if (cnC2.mo37468u(bau)) {
                                c43589aj.raP.setVisibility(0);
                                c43589aj.rnu.setVisibility(8);
                                c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                                c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                            } else if (cnC2.mo37469v(bau)) {
                                c43589aj.raP.setVisibility(8);
                                c43589aj.rnu.setVisibility(8);
                            } else if (cnC2.mo37453b(c46236n, null) <= 5) {
                                c43589aj.raP.setVisibility(8);
                                c43589aj.rnu.setVisibility(8);
                            } else {
                                cnC2.mo37472y(bau);
                                c43589aj.raP.setVisibility(0);
                                c43589aj.rnu.setVisibility(8);
                                c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                                c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                            }
                            if (c43589aj.qzM.ckY()) {
                                C4990ab.m7410d("MiroMsg.TurnMediaTimeLineItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH + " " + i);
                                cnC2.mo37472y(bau);
                                c43589aj.raP.setVisibility(0);
                                c43589aj.rnu.setVisibility(8);
                                c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                                c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                            }
                        } else if (cnC2.mo37470w(bau)) {
                            c43589aj.raP.setVisibility(8);
                            c43589aj.rnu.setVisibility(0);
                            c43589aj.rnu.dKB();
                        } else if (cnC2.mo37453b(c46236n, null) == 5) {
                            cnC2.mo37428A(bau);
                            c43589aj.raP.setVisibility(8);
                            c43589aj.rnu.setVisibility(0);
                            c43589aj.rnu.dKB();
                        } else if (cnC2.mo37471x(bau)) {
                            c43589aj.rnu.setVisibility(8);
                            c43589aj.raP.setImageResource(C25738R.drawable.atu);
                            c43589aj.raP.setVisibility(0);
                        } else {
                            cnC2.mo37472y(bau);
                            c43589aj.raP.setVisibility(0);
                            c43589aj.rnu.setVisibility(8);
                            c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                            c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                            if (cnC2.mo37453b(c46236n, null) == 4) {
                                c43589aj.raQ.setVisibility(0);
                            }
                        }
                        layoutParams = c43589aj.rnv.getLayoutParams();
                        layoutParams.width = this.rIV;
                        layoutParams.height = this.rIV;
                        c43589aj.rnv.setLayoutParams(layoutParams);
                        c43589aj.qzM.setTagObject(c43589aj);
                        C34915a c34915a = c43589aj.qzM;
                        int hashCode3 = this.mActivity.hashCode();
                        C44222az dtg3 = C44222az.dtg();
                        dtg3.oyB = timeLineObject.pcX;
                        cnC2.mo37449a(c46236n, bau, c34915a, hashCode3, i, dtg3, c13633av.rgZ, true);
                        view2.setVisibility(0);
                        c43589aj.rnt.setTag(baseViewHolder);
                        final int i5 = i3;
                        final C46251au c46251au3 = c46251au;
                        c13697b3 = c13697b;
                        c43589aj.rnt.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(40158);
                                if (i5 > 0) {
                                    c46251au3.rxP.rhm.mo25441jQ(c13697b3.rHt);
                                }
                                c46251au3.qOL.rKn.onClick(view);
                                AppMethodBeat.m2505o(40158);
                            }
                        });
                        if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                            c46251au.rxP.rhm.mo25432a(c13633av.rAt, 0, true, z);
                        } else {
                            c46251au.rxP.rhm.mo25432a(c13633av.rAt, 0, false, z);
                        }
                        c46251au.rxP.rhm.mo25434c(c13633av.rAt, C13373af.cnC().mo37453b(c46236n, null) == 5, z);
                        view = view2;
                    }
                    layoutParams = u.getLayoutParams();
                    layoutParams.width = this.rIV;
                    layoutParams.height = this.rIV;
                    u.setLayoutParams(layoutParams);
                    if (view != null) {
                        layoutParams = view.getLayoutParams();
                        layoutParams.width = this.rIV;
                        layoutParams.height = this.rIV;
                        view.setLayoutParams(layoutParams);
                    }
                    if (i3 == i4 && bau.jCt == 2) {
                        u.setVisibility(0);
                        u.setOnTouchListener(new C136964());
                    }
                    C13695a c13695a5 = new C13695a();
                    c13695a5.index = i4;
                    if (view == null) {
                        view = u;
                    }
                    c13695a5.view = view;
                    c13695a5.rJc = u;
                    c13695a5.rJd = c13697b;
                    c13695a5.qJh = bau;
                    c13695a5.ros = c13633av.qBY;
                    if (c13695a != null) {
                        c13695a.rJe = c13695a5;
                        c13695a3 = c13695a2;
                    } else {
                        c13695a3 = c13695a5;
                    }
                    if (i4 == timeLineObject.xfI.wbK.size() - 1) {
                        c13695a5.rJe = c13695a3;
                    }
                    if (i4 == i3) {
                        c13697b.rJh = c13695a5;
                        C13690i.m21889a(c13695a5);
                    }
                    c13695a4 = c13695a5;
                } else {
                    c13695a3 = c13695a2;
                    c13695a4 = c13695a;
                }
                i4++;
                c13695a2 = c13695a3;
                c13695a = c13695a4;
            }
            if (c13697b.mRR != null && (c13697b.mRR instanceof FrameLayout)) {
                ((FrameLayout) c13697b.mRR).setClipChildren(false);
            }
            if (c13697b.rHB != null) {
                c13697b.rHB.setClipChildren(false);
            }
            if (c13697b.rIt != null && (c13697b.rIt instanceof LinearLayout)) {
                ((LinearLayout) c13697b.rIt).setClipChildren(false);
            }
            final C46251au c46251au4 = c46251au;
            final int i6 = i3;
            c13697b3 = c13697b;
            c13697b.rJf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(40159);
                    c46251au4.qOL.rKn.onClick(view);
                    if (i6 > 0) {
                        c46251au4.rxP.rhm.mo25441jQ(c13697b3.rHt);
                    }
                    AppMethodBeat.m2505o(40159);
                }
            });
        }
        AppMethodBeat.m2505o(40163);
    }

    /* renamed from: u */
    public static View m21891u(View view, int i, int i2) {
        AppMethodBeat.m2504i(40164);
        View findViewById;
        if (i2 == 6) {
            findViewById = view.findViewById(rIW[0]);
            AppMethodBeat.m2505o(40164);
            return findViewById;
        }
        findViewById = view.findViewById(rHh[i]);
        AppMethodBeat.m2505o(40164);
        return findViewById;
    }

    /* renamed from: a */
    private static void m21889a(C13695a c13695a) {
        AppMethodBeat.m2504i(40165);
        c13695a.rJd.rGQ.setVisibility(8);
        c13695a.rJd.rGR.setVisibility(8);
        ((TextView) c13695a.rJd.rJf.findViewById(2131827921)).setText(null);
        ((TextView) c13695a.rJd.rJf.findViewById(2131827924)).setText(null);
        ((TextView) c13695a.rJd.rJf.findViewById(2131827922)).setText(null);
        ((TextView) c13695a.rJd.rJf.findViewById(2131827925)).setText(null);
        C21984b cqo = c13695a.ros.cqo();
        if (!(cqo.qUX == null || cqo.qUX.qVt == null || cqo.qUX.qVt.size() < 2)) {
            C21988h c21988h = (C21988h) cqo.qUX.qVt.get(c13695a.index);
            if (c21988h.qVk >= 0 && c21988h.qVk < rIX.length) {
                int[] iArr = rIX[c21988h.qVk];
                TextView textView = (TextView) c13695a.rJd.rJf.findViewById(iArr[0]);
                TextView textView2 = (TextView) c13695a.rJd.rJf.findViewById(iArr[1]);
                if (C5046bo.isNullOrNil(c21988h.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(c21988h.title);
                }
                if (C5046bo.isNullOrNil(c21988h.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(c21988h.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(40165);
    }
}
