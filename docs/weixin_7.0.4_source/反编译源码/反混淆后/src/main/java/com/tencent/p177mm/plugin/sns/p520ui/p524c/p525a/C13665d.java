package com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
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
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13342g;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C29247a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C21988h;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.ui.c.a.d */
public final class C13665d extends C35118a {
    Context context;
    public int currentIndex;
    boolean rEC = false;
    public View rHf;
    public View rHg;
    private int[] rHh = new int[]{2131827917, 2131827918};
    private final int rHi = 2131827919;
    C13342g rqn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.d$1 */
    class C136671 implements OnTouchListener {
        C136671() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public C13665d(TimeLineObject timeLineObject, C46236n c46236n, C22089b c22089b, C13342g c13342g) {
        AppMethodBeat.m2504i(40109);
        this.timeLineObject = timeLineObject;
        this.ros = c46236n;
        this.rqo = c22089b;
        this.rqn = c13342g;
        AppMethodBeat.m2505o(40109);
    }

    /* renamed from: g */
    public final void mo25860g(View view, View view2) {
        AppMethodBeat.m2504i(40110);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = ((((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - C1338a.m2856al(this.context, C25738R.dimen.a94)) - C1338a.m2856al(this.context, C25738R.dimen.f10017nj)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9966lo);
        layoutParams.bottomMargin = 0;
        layoutParams.width = min;
        layoutParams.height = min;
        view.setLayoutParams(layoutParams);
        ((RoundedCornerRelativeLayout) view).setRadius(8.0f);
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
            ((ViewGroup) view.getParent()).setClipToPadding(false);
        }
        for (int findViewById : this.rHh) {
            MaskImageView maskImageView = (MaskImageView) view.findViewById(findViewById);
            maskImageView.setVisibility(8);
            maskImageView.setOnTouchListener(new C136671());
        }
        View findViewById2 = view.findViewById(this.rHi);
        findViewById2.setBackground(null);
        findViewById2.setVisibility(8);
        ((ViewGroup) findViewById2).setClipChildren(false);
        this.rGD = new C43589aj();
        this.rGD.rnt = findViewById2;
        this.rGD.rns = this.rGD.rnt;
        this.rGD.qzM = (C34915a) this.rGD.rnt.findViewById(2131820629);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(2131820981);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(2131821370);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(2131827571);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(2131827572);
        this.rGD.rnt.setTag(this);
        this.rGD.rnt.setOnClickListener(null);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(C15991a.CENTER_CROP);
        this.rGD.qzM.mo8513fi(min, min);
        view.setLayerType(2, null);
        this.rHg = view.findViewById(2131827920);
        this.rHf = view.findViewById(2131827923);
        mo25868Eq(0);
        AppMethodBeat.m2505o(40110);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Eq */
    public final void mo25868Eq(int i) {
        AppMethodBeat.m2504i(40111);
        if (this.rHg == null || this.rHf == null) {
            AppMethodBeat.m2505o(40111);
            return;
        }
        this.currentIndex = i;
        this.rHg.setVisibility(8);
        this.rHf.setVisibility(8);
        ((TextView) this.contentView.findViewById(2131827921)).setText(null);
        ((TextView) this.contentView.findViewById(2131827924)).setText(null);
        ((TextView) this.contentView.findViewById(2131827922)).setText(null);
        ((TextView) this.contentView.findViewById(2131827925)).setText(null);
        int[][] iArr = new int[][]{new int[]{2131827924, 2131827925}, new int[]{2131827921, 2131827922}, new int[]{2131827921, 2131827925}};
        C21984b cqo = this.ros.cqo();
        if (!(cqo.qUX == null || cqo.qUX.qVt == null || cqo.qUX.qVt.size() < 2)) {
            C21988h c21988h = (C21988h) cqo.qUX.qVt.get(i);
            if (c21988h.qVk >= 0 && c21988h.qVk < 3) {
                int[] iArr2 = iArr[c21988h.qVk];
                TextView textView = (TextView) this.contentView.findViewById(iArr2[0]);
                TextView textView2 = (TextView) this.contentView.findViewById(iArr2[1]);
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
        AppMethodBeat.m2505o(40111);
    }

    public final void cuV() {
        AppMethodBeat.m2504i(40112);
        if (this.timeLineObject.xfI.wbK.size() >= 2) {
            int i = this.ros.field_likeFlag == 1 ? 1 : 0;
            if (this.rqn != null && ((bau) this.timeLineObject.xfI.wbK.get(i)).jCt == 6) {
                this.rqn.mo25448x(this.ros.field_snsId, this.ros.field_likeFlag == 1);
            }
            if (this.rEC) {
                C4990ab.m7416i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
                AppMethodBeat.m2505o(40112);
                return;
            }
            int i2;
            int i3;
            int i4;
            int i5;
            if (this.ros.field_likeFlag == 1) {
                i2 = 0;
                i3 = 1;
            } else {
                i2 = 1;
                i3 = 0;
            }
            bau bau = (bau) this.timeLineObject.xfI.wbK.get(i2);
            final View a = m21881a((bau) this.timeLineObject.xfI.wbK.get(i3), i3, false);
            final View a2 = m21881a(bau, i2, true);
            i = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
            int[] iArr = new int[2];
            this.contentView.getLocationOnScreen(iArr);
            this.contentView.setPivotY((float) ((i / 2) - iArr[1]));
            this.contentView.setCameraDistance(8000.0f);
            float width = ((float) this.contentView.getWidth()) / 2.0f;
            float height = ((float) this.contentView.getHeight()) / 2.0f;
            if (this.ros.field_likeFlag == 1) {
                i4 = -90;
                i5 = 90;
            } else {
                i4 = 90;
                i5 = -90;
            }
            C29247a c29247a = new C29247a(this.context, 0.0f, (float) i5, width, height, true);
            c29247a.setDuration(187);
            c29247a.setInterpolator(new AccelerateInterpolator());
            final float f = width;
            final float f2 = height;
            c29247a.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(40104);
                    a2.setVisibility(0);
                    a.setVisibility(8);
                    C13665d.this.mo25868Eq(i2);
                    C29247a c29247a = new C29247a(C13665d.this.context, (float) i4, 0.0f, f, f2, false);
                    c29247a.setDuration(187);
                    c29247a.setInterpolator(new DecelerateInterpolator());
                    C13665d.this.contentView.startAnimation(c29247a);
                    C13665d.this.rEC = false;
                    C13665d.this.refreshView();
                    AppMethodBeat.m2505o(40104);
                }
            });
            this.contentView.startAnimation(c29247a);
            this.rEC = true;
        }
        AppMethodBeat.m2505o(40112);
    }

    /* renamed from: a */
    private View m21881a(bau bau, int i, boolean z) {
        AppMethodBeat.m2504i(40113);
        int[] iArr = new int[]{2131827917, 2131827918};
        View findViewById;
        if (z) {
            findViewById = this.contentView.findViewById(iArr[i]);
            AppMethodBeat.m2505o(40113);
            return findViewById;
        } else if (bau.jCt == 6) {
            findViewById = this.contentView.findViewById(2131827919);
            AppMethodBeat.m2505o(40113);
            return findViewById;
        } else if (bau.jCt == 2) {
            findViewById = this.contentView.findViewById(iArr[i]);
            AppMethodBeat.m2505o(40113);
            return findViewById;
        } else {
            AppMethodBeat.m2505o(40113);
            return null;
        }
    }

    public final void refreshView() {
        AppMethodBeat.m2504i(40114);
        this.ros = C21990h.m33615YS(this.ros.cqA());
        C4990ab.m7416i("MicroMsg.TurnCardAdDetailItem", "refresh view");
        int width = (((((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth() - C1338a.fromDPToPix(this.context, 50)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        if (this.ros.cqu().xfI.wbK.size() >= 2) {
            int i;
            if (this.ros.field_likeFlag == 1) {
                i = 1;
            } else {
                i = 0;
            }
            mo25868Eq(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 2) {
                    break;
                }
                bau bau = (bau) this.ros.cqu().xfI.wbK.get(i3);
                View view = (MaskImageView) this.contentView.findViewById(this.rHh[i3]);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                view.setTag(this);
                C21925g cnC;
                if (bau.jCt == 2) {
                    cnC = C13373af.cnC();
                    int hashCode = hashCode();
                    C44222az dtk = C44222az.dtk();
                    dtk.oyB = this.timeLineObject.pcX;
                    cnC.mo37450a(bau, view, -1, hashCode, dtk, 3);
                } else {
                    cnC = C13373af.cnC();
                    int hashCode2 = hashCode();
                    C44222az dtk2 = C44222az.dtk();
                    dtk2.oyB = this.timeLineObject.pcX;
                    cnC.mo37442a(bau, view, hashCode2, dtk2);
                }
                view.setScaleType(C15991a.CENTER_CROP);
                layoutParams.width = width;
                layoutParams.height = width;
                if (i == i3 && bau.jCt == 2) {
                    view.setVisibility(0);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(40105);
                            if (C13665d.this.rqn != null && i > 0) {
                                C13665d.this.rqn.mo25441jQ(C13665d.this.ros.field_snsId);
                            }
                            C13665d.this.rqo.rKn.onClick(view);
                            AppMethodBeat.m2505o(40105);
                        }
                    });
                } else {
                    view.setVisibility(8);
                    view.setOnClickListener(null);
                }
                if (bau.jCt == 6 && i == i3) {
                    final long j;
                    final boolean z = i > 0;
                    long j2 = this.ros.field_snsId;
                    ViewGroup.LayoutParams layoutParams2 = this.rGD.rns.getLayoutParams();
                    layoutParams2.width = width;
                    layoutParams2.height = width;
                    this.rGD.qzM.mo8513fi(width, width);
                    this.rGD.rns.setVisibility(0);
                    C13373af.cnC().mo37449a(this.ros, bau, this.rGD.qzM, this.context.hashCode(), 0, C44222az.xYT, this.ros.mo74253DI(32), true);
                    this.rGD.rnw = true;
                    this.rGD.rnx = i3;
                    this.rGD.rnr = this.timeLineObject;
                    this.rGD.position = 0;
                    this.rGD.cwT = this.ros.cqU();
                    this.rGD.rnt.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(40106);
                            if (C13665d.this.rqn != null && z) {
                                C13665d.this.rqn.mo25441jQ(C13665d.this.ros.field_snsId);
                            }
                            C13665d.this.rqo.rKn.onClick(view);
                            AppMethodBeat.m2505o(40106);
                        }
                    });
                    final long j3 = j2;
                    this.rGD.qzM.setOnCompletionListener(new C13304e() {
                        /* renamed from: c */
                        public final void mo8940c(C13303b c13303b, int i) {
                            AppMethodBeat.m2504i(40107);
                            if (i != -1) {
                                C13665d.this.rqn.mo25445u(j3, z);
                            }
                            AppMethodBeat.m2505o(40107);
                        }
                    });
                    if (this.rqn != null) {
                        if (this.rqn.mo25439jO(((long) i3) + j2)) {
                            this.rqn.mo25433c(j2, C5046bo.m7588yz(), z);
                        } else {
                            j = j2;
                            final boolean z2 = z;
                            final int i4 = i3;
                            this.rGD.qzM.setOnDecodeDurationListener(new C13325f() {
                                /* renamed from: b */
                                public final void mo8946b(C13303b c13303b, long j) {
                                    AppMethodBeat.m2504i(40108);
                                    if (j >= 3) {
                                        int cle = (int) c13303b.cle();
                                        if (C13665d.this.rqn != null) {
                                            C13665d.this.rqn.mo25433c(j, C5046bo.m7588yz(), z2);
                                            C13665d.this.rqn.mo25436f(j, cle, z2);
                                            C13665d.this.rqn.mo25429T(j, j + ((long) i4));
                                        }
                                        C13665d.this.rGD.qzM.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.m2505o(40108);
                                }
                            });
                        }
                    }
                    this.rGD.mo69200a(this.timeLineObject, 0, this.ros.cqU(), this.ros.mo74253DI(32));
                    this.rGD.raQ.setVisibility(8);
                    C21925g cnC2 = C13373af.cnC();
                    j = System.nanoTime() - System.nanoTime();
                    C4990ab.m7417i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(j));
                    if (C21925g.m33541t(bau)) {
                        if (cnC2.mo37468u(bau)) {
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                        } else if (cnC2.mo37469v(bau)) {
                            this.rGD.raP.setVisibility(8);
                            this.rGD.rnu.setVisibility(8);
                        } else if (cnC2.mo37453b(this.ros, null) <= 5) {
                            this.rGD.raP.setVisibility(8);
                            this.rGD.rnu.setVisibility(8);
                        } else {
                            cnC2.mo37472y(bau);
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                        }
                        if (this.rGD.qzM.ckY()) {
                            C4990ab.m7410d("MicroMsg.TurnCardAdDetailItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH + " 0");
                            cnC2.mo37472y(bau);
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                        }
                    } else if (cnC2.mo37470w(bau)) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(0);
                        this.rGD.rnu.dKB();
                    } else if (cnC2.mo37453b(this.ros, null) == 5) {
                        cnC2.mo37428A(bau);
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(0);
                        this.rGD.rnu.dKB();
                    } else if (cnC2.mo37471x(bau)) {
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageResource(C25738R.drawable.atu);
                        this.rGD.raP.setVisibility(0);
                    } else {
                        cnC2.mo37472y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                        if (cnC2.mo37453b(this.ros, null) == 4) {
                            this.rGD.raQ.setVisibility(0);
                        }
                    }
                    if (this.rqn != null) {
                        if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                            this.rqn.mo25446v(this.ros.field_snsId, true);
                        } else {
                            this.rqn.mo25446v(this.ros.field_snsId, false);
                        }
                        this.rqn.mo25434c(j2, C13373af.cnC().mo37453b(this.ros, null) == 5, z);
                    }
                }
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.m2505o(40114);
    }
}
