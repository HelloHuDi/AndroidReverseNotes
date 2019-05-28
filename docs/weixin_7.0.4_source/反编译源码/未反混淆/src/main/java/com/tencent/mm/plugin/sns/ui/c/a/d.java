package com.tencent.mm.plugin.sns.ui.c.a;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;

public final class d extends a {
    Context context;
    public int currentIndex;
    boolean rEC = false;
    public View rHf;
    public View rHg;
    private int[] rHh = new int[]{R.id.ena, R.id.enb};
    private final int rHi = R.id.enc;
    g rqn;

    public d(TimeLineObject timeLineObject, n nVar, b bVar, g gVar) {
        AppMethodBeat.i(40109);
        this.timeLineObject = timeLineObject;
        this.ros = nVar;
        this.rqo = bVar;
        this.rqn = gVar;
        AppMethodBeat.o(40109);
    }

    public final void g(View view, View view2) {
        AppMethodBeat.i(40110);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = ((((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - a.al(this.context, R.dimen.a94)) - a.al(this.context, R.dimen.nj)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.nc);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = this.context.getResources().getDimensionPixelOffset(R.dimen.lo);
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
            maskImageView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
        }
        View findViewById2 = view.findViewById(this.rHi);
        findViewById2.setBackground(null);
        findViewById2.setVisibility(8);
        ((ViewGroup) findViewById2).setClipChildren(false);
        this.rGD = new aj();
        this.rGD.rnt = findViewById2;
        this.rGD.rns = this.rGD.rnt;
        this.rGD.qzM = (com.tencent.mm.plugin.sight.decode.a.a) this.rGD.rnt.findViewById(R.id.bl);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(R.id.l4);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(R.id.vm);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(R.id.edy);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(R.id.edz);
        this.rGD.rnt.setTag(this);
        this.rGD.rnt.setOnClickListener(null);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(QImageView.a.CENTER_CROP);
        this.rGD.qzM.fi(min, min);
        view.setLayerType(2, null);
        this.rHg = view.findViewById(R.id.end);
        this.rHf = view.findViewById(R.id.eng);
        Eq(0);
        AppMethodBeat.o(40110);
    }

    /* Access modifiers changed, original: final */
    public final void Eq(int i) {
        AppMethodBeat.i(40111);
        if (this.rHg == null || this.rHf == null) {
            AppMethodBeat.o(40111);
            return;
        }
        this.currentIndex = i;
        this.rHg.setVisibility(8);
        this.rHf.setVisibility(8);
        ((TextView) this.contentView.findViewById(R.id.ene)).setText(null);
        ((TextView) this.contentView.findViewById(R.id.enh)).setText(null);
        ((TextView) this.contentView.findViewById(R.id.enf)).setText(null);
        ((TextView) this.contentView.findViewById(R.id.eni)).setText(null);
        int[][] iArr = new int[][]{new int[]{R.id.enh, R.id.eni}, new int[]{R.id.ene, R.id.enf}, new int[]{R.id.ene, R.id.eni}};
        com.tencent.mm.plugin.sns.storage.b cqo = this.ros.cqo();
        if (!(cqo.qUX == null || cqo.qUX.qVt == null || cqo.qUX.qVt.size() < 2)) {
            h hVar = (h) cqo.qUX.qVt.get(i);
            if (hVar.qVk >= 0 && hVar.qVk < 3) {
                int[] iArr2 = iArr[hVar.qVk];
                TextView textView = (TextView) this.contentView.findViewById(iArr2[0]);
                TextView textView2 = (TextView) this.contentView.findViewById(iArr2[1]);
                if (bo.isNullOrNil(hVar.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(hVar.title);
                }
                if (bo.isNullOrNil(hVar.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(hVar.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
        AppMethodBeat.o(40111);
    }

    public final void cuV() {
        AppMethodBeat.i(40112);
        if (this.timeLineObject.xfI.wbK.size() >= 2) {
            int i = this.ros.field_likeFlag == 1 ? 1 : 0;
            if (this.rqn != null && ((bau) this.timeLineObject.xfI.wbK.get(i)).jCt == 6) {
                this.rqn.x(this.ros.field_snsId, this.ros.field_likeFlag == 1);
            }
            if (this.rEC) {
                ab.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
                AppMethodBeat.o(40112);
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
            final View a = a((bau) this.timeLineObject.xfI.wbK.get(i3), i3, false);
            final View a2 = a(bau, i2, true);
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
            com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0f, (float) i5, width, height, true);
            aVar.setDuration(187);
            aVar.setInterpolator(new AccelerateInterpolator());
            final float f = width;
            final float f2 = height;
            aVar.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(40104);
                    a2.setVisibility(0);
                    a.setVisibility(8);
                    d.this.Eq(i2);
                    com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(d.this.context, (float) i4, 0.0f, f, f2, false);
                    aVar.setDuration(187);
                    aVar.setInterpolator(new DecelerateInterpolator());
                    d.this.contentView.startAnimation(aVar);
                    d.this.rEC = false;
                    d.this.refreshView();
                    AppMethodBeat.o(40104);
                }
            });
            this.contentView.startAnimation(aVar);
            this.rEC = true;
        }
        AppMethodBeat.o(40112);
    }

    private View a(bau bau, int i, boolean z) {
        AppMethodBeat.i(40113);
        int[] iArr = new int[]{R.id.ena, R.id.enb};
        View findViewById;
        if (z) {
            findViewById = this.contentView.findViewById(iArr[i]);
            AppMethodBeat.o(40113);
            return findViewById;
        } else if (bau.jCt == 6) {
            findViewById = this.contentView.findViewById(R.id.enc);
            AppMethodBeat.o(40113);
            return findViewById;
        } else if (bau.jCt == 2) {
            findViewById = this.contentView.findViewById(iArr[i]);
            AppMethodBeat.o(40113);
            return findViewById;
        } else {
            AppMethodBeat.o(40113);
            return null;
        }
    }

    public final void refreshView() {
        AppMethodBeat.i(40114);
        this.ros = com.tencent.mm.plugin.sns.storage.h.YS(this.ros.cqA());
        ab.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
        int width = (((((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth() - a.fromDPToPix(this.context, 50)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.nc);
        if (this.ros.cqu().xfI.wbK.size() >= 2) {
            int i;
            if (this.ros.field_likeFlag == 1) {
                i = 1;
            } else {
                i = 0;
            }
            Eq(i);
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
                com.tencent.mm.plugin.sns.model.g cnC;
                if (bau.jCt == 2) {
                    cnC = af.cnC();
                    int hashCode = hashCode();
                    az dtk = az.dtk();
                    dtk.oyB = this.timeLineObject.pcX;
                    cnC.a(bau, view, -1, hashCode, dtk, 3);
                } else {
                    cnC = af.cnC();
                    int hashCode2 = hashCode();
                    az dtk2 = az.dtk();
                    dtk2.oyB = this.timeLineObject.pcX;
                    cnC.a(bau, view, hashCode2, dtk2);
                }
                view.setScaleType(QImageView.a.CENTER_CROP);
                layoutParams.width = width;
                layoutParams.height = width;
                if (i == i3 && bau.jCt == 2) {
                    view.setVisibility(0);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(40105);
                            if (d.this.rqn != null && i > 0) {
                                d.this.rqn.jQ(d.this.ros.field_snsId);
                            }
                            d.this.rqo.rKn.onClick(view);
                            AppMethodBeat.o(40105);
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
                    this.rGD.qzM.fi(width, width);
                    this.rGD.rns.setVisibility(0);
                    af.cnC().a(this.ros, bau, this.rGD.qzM, this.context.hashCode(), 0, az.xYT, this.ros.DI(32), true);
                    this.rGD.rnw = true;
                    this.rGD.rnx = i3;
                    this.rGD.rnr = this.timeLineObject;
                    this.rGD.position = 0;
                    this.rGD.cwT = this.ros.cqU();
                    this.rGD.rnt.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(40106);
                            if (d.this.rqn != null && z) {
                                d.this.rqn.jQ(d.this.ros.field_snsId);
                            }
                            d.this.rqo.rKn.onClick(view);
                            AppMethodBeat.o(40106);
                        }
                    });
                    final long j3 = j2;
                    this.rGD.qzM.setOnCompletionListener(new e() {
                        public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                            AppMethodBeat.i(40107);
                            if (i != -1) {
                                d.this.rqn.u(j3, z);
                            }
                            AppMethodBeat.o(40107);
                        }
                    });
                    if (this.rqn != null) {
                        if (this.rqn.jO(((long) i3) + j2)) {
                            this.rqn.c(j2, bo.yz(), z);
                        } else {
                            j = j2;
                            final boolean z2 = z;
                            final int i4 = i3;
                            this.rGD.qzM.setOnDecodeDurationListener(new f() {
                                public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                    AppMethodBeat.i(40108);
                                    if (j >= 3) {
                                        int cle = (int) bVar.cle();
                                        if (d.this.rqn != null) {
                                            d.this.rqn.c(j, bo.yz(), z2);
                                            d.this.rqn.f(j, cle, z2);
                                            d.this.rqn.T(j, j + ((long) i4));
                                        }
                                        d.this.rGD.qzM.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.o(40108);
                                }
                            });
                        }
                    }
                    this.rGD.a(this.timeLineObject, 0, this.ros.cqU(), this.ros.DI(32));
                    this.rGD.raQ.setVisibility(8);
                    com.tencent.mm.plugin.sns.model.g cnC2 = af.cnC();
                    j = System.nanoTime() - System.nanoTime();
                    ab.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(bau)), Long.valueOf(j));
                    if (com.tencent.mm.plugin.sns.model.g.t(bau)) {
                        if (cnC2.u(bau)) {
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(a.g(this.context, R.raw.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                        } else if (cnC2.v(bau)) {
                            this.rGD.raP.setVisibility(8);
                            this.rGD.rnu.setVisibility(8);
                        } else if (cnC2.b(this.ros, null) <= 5) {
                            this.rGD.raP.setVisibility(8);
                            this.rGD.rnu.setVisibility(8);
                        } else {
                            cnC2.y(bau);
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(a.g(this.context, R.raw.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                        }
                        if (this.rGD.qzM.ckY()) {
                            ab.d("MicroMsg.TurnCardAdDetailItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH + " 0");
                            cnC2.y(bau);
                            this.rGD.raP.setVisibility(0);
                            this.rGD.rnu.setVisibility(8);
                            this.rGD.raP.setImageDrawable(a.g(this.context, R.raw.shortvideo_play_btn));
                            this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                        }
                    } else if (cnC2.w(bau)) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(0);
                        this.rGD.rnu.dKB();
                    } else if (cnC2.b(this.ros, null) == 5) {
                        cnC2.A(bau);
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(0);
                        this.rGD.rnu.dKB();
                    } else if (cnC2.x(bau)) {
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageResource(R.drawable.atu);
                        this.rGD.raP.setVisibility(0);
                    } else {
                        cnC2.y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(a.g(this.context, R.raw.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                        if (cnC2.b(this.ros, null) == 4) {
                            this.rGD.raQ.setVisibility(0);
                        }
                    }
                    if (this.rqn != null) {
                        if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau))) {
                            this.rqn.v(this.ros.field_snsId, true);
                        } else {
                            this.rqn.v(this.ros.field_snsId, false);
                        }
                        this.rqn.c(j2, af.cnC().b(this.ros, null) == 5, z);
                    }
                }
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(40114);
    }
}
