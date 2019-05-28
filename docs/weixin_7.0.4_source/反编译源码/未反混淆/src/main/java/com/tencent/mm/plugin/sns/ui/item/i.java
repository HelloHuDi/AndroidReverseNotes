package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;

public final class i extends BaseTimeLineItem {
    private static int[] rHh = new int[]{R.id.ena, R.id.enb};
    private static int[] rIW = new int[]{R.id.enc};
    private static int[][] rIX = new int[][]{new int[]{R.id.enh, R.id.eni}, new int[]{R.id.ene, R.id.enf}, new int[]{R.id.ene, R.id.eni}};
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int rIV = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.i$6 */
    public class AnonymousClass6 implements AnimationListener {
        final /* synthetic */ float cjZ;
        final /* synthetic */ float cka;
        final /* synthetic */ View rHk;
        final /* synthetic */ View rHl;
        final /* synthetic */ int rHn;
        final /* synthetic */ a rJa;
        final /* synthetic */ View rJb;

        public AnonymousClass6(View view, View view2, a aVar, View view3, int i, float f, float f2) {
            this.rHk = view;
            this.rHl = view2;
            this.rJa = aVar;
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
            AppMethodBeat.i(40160);
            this.rHk.setVisibility(0);
            this.rHl.setVisibility(8);
            i.b(this.rJa.rJe);
            com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.rJb.getContext(), (float) this.rHn, 0.0f, this.cjZ, this.cka, false);
            aVar.setDuration(187);
            aVar.setInterpolator(new DecelerateInterpolator());
            this.rJb.startAnimation(aVar);
            AppMethodBeat.o(40160);
        }
    }

    public static final class a {
        public int index;
        public bau qJh;
        public View rJc;
        public b rJd;
        public a rJe;
        public n ros;
        public View view;
    }

    public static class b extends BaseViewHolder {
        public View rGQ;
        public View rGR;
        public View rJf;
        public boolean rJg = false;
        public a rJh;
        public aj rJi = new aj();

        public b() {
            AppMethodBeat.i(40161);
            AppMethodBeat.o(40161);
        }
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(40166);
        a(aVar);
        AppMethodBeat.o(40166);
    }

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40162);
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.rIV = (((Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc);
        }
        b bVar = (b) baseViewHolder;
        if (bVar.rHC != null && !bVar.rJg) {
            bVar.rHC.setLayoutResource(R.layout.aww);
            if (!bVar.rJg) {
                bVar.rJf = bVar.rHC.inflate();
                bVar.rJg = true;
            }
        } else if (!bVar.rJg) {
            bVar.rJf = bVar.mRR.findViewById(R.id.en_);
            bVar.rJg = true;
        }
        LayoutParams layoutParams = bVar.rJf.getLayoutParams();
        layoutParams.width = this.rIV;
        layoutParams.height = this.rIV;
        ((RoundedCornerRelativeLayout) bVar.rJf).setRadius(8.0f);
        aj ajVar = bVar.rJi;
        ajVar.rnt = u(bVar.rJf, 0, 6);
        ajVar.rns = ajVar.rnt;
        ajVar.qzM = (com.tencent.mm.plugin.sight.decode.a.a) ajVar.rnt.findViewById(R.id.bl);
        ajVar.raP = (ImageView) ajVar.rnt.findViewById(R.id.l4);
        ajVar.rnu = (MMPinProgressBtn) ajVar.rnt.findViewById(R.id.vm);
        ajVar.rnv = (TextView) ajVar.rnt.findViewById(R.id.edy);
        ajVar.raQ = (TextView) ajVar.rnt.findViewById(R.id.edz);
        ((SightPlayImageView) ajVar.qzM).qyI = true;
        ((SightPlayImageView) ajVar.qzM).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        ajVar.qzM.fi(this.rIV, this.rIV);
        bVar.rGQ = bVar.rJf.findViewById(R.id.end);
        bVar.rGR = bVar.rJf.findViewById(R.id.eng);
        AppMethodBeat.o(40162);
    }

    @TargetApi(16)
    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40163);
        ab.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            ab.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
            AppMethodBeat.o(40163);
            return;
        }
        int hashCode;
        View findViewById;
        b bVar = (b) baseViewHolder;
        bVar.rJf.setTag(bVar);
        bVar.rJf.setVisibility(0);
        bVar.rJf.setLayerType(2, null);
        b bVar2 = bVar;
        for (int findViewById2 : rHh) {
            findViewById = bVar2.rJf.findViewById(findViewById2);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById instanceof MaskImageView) {
                ((MaskImageView) findViewById).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
            }
        }
        for (int findViewById22 : rIW) {
            findViewById = bVar2.rJf.findViewById(findViewById22);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setVisibility(8);
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).setClipChildren(false);
                }
            }
        }
        baseViewHolder.rHB.setLayoutParams(new LinearLayout.LayoutParams((((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc), -2));
        if (avVar.rgZ && i2 == 11) {
            if (timeLineObject.xfI == null || timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() < 2) {
                ab.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
                AppMethodBeat.o(40163);
                return;
            }
            int i3;
            final b bVar3;
            if (bVar.rHu == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            a aVar = null;
            a aVar2 = null;
            int i4 = 0;
            while (i4 < Math.min(timeLineObject.xfI.wbK.size(), 2)) {
                a aVar3;
                a aVar4;
                bau bau = (bau) timeLineObject.xfI.wbK.get(i4);
                View u = u(bVar.rJf, i4, 2);
                u.setVisibility(4);
                if (u != null) {
                    LayoutParams layoutParams;
                    u.setTag(baseViewHolder);
                    u.setOnClickListener(auVar.qOL.rKn);
                    g cnC;
                    if (bau.jCt == 2) {
                        cnC = af.cnC();
                        hashCode = this.mActivity.hashCode();
                        az dtg = az.dtg();
                        dtg.oyB = timeLineObject.pcX;
                        cnC.a(bau, u, -1, hashCode, dtg, 3);
                    } else {
                        cnC = af.cnC();
                        int hashCode2 = this.mActivity.hashCode();
                        az dtg2 = az.dtg();
                        dtg2.oyB = timeLineObject.pcX;
                        cnC.a(bau, u, hashCode2, dtg2);
                    }
                    View view = null;
                    if (bau.jCt == 6 && i3 == i4) {
                        final boolean z = i3 > 0;
                        final long j = avVar.rAt;
                        final aj ajVar = bVar.rJi;
                        n nVar = avVar.qBY;
                        View view2 = ajVar.rns;
                        ajVar.rnr = timeLineObject;
                        final au auVar2 = auVar;
                        ajVar.qzM.setOnCompletionListener(new e() {
                            public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                AppMethodBeat.i(40156);
                                if (i != -1) {
                                    if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                                        AppMethodBeat.o(40156);
                                        return;
                                    }
                                    auVar2.rxP.rhm.u(j, z);
                                }
                                AppMethodBeat.o(40156);
                            }
                        });
                        if (!auVar.rxP.rhm.jO(((long) i4) + j)) {
                            auVar2 = auVar;
                            ajVar.qzM.setOnDecodeDurationListener(new f() {
                                public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                    AppMethodBeat.i(40157);
                                    if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                                        AppMethodBeat.o(40157);
                                        return;
                                    }
                                    if (j >= 3) {
                                        int cle = (int) bVar.cle();
                                        auVar2.rxP.rhm.c(j, bo.yz(), z);
                                        auVar2.rxP.rhm.f(j, cle, z);
                                        auVar2.rxP.rhm.T(j, j + ((long) i4));
                                        ajVar.qzM.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.o(40157);
                                }
                            });
                        } else if (!(auVar == null || auVar.rxP == null || auVar.rxP.rhm == null)) {
                            auVar.rxP.rhm.c(j, bo.yz(), z);
                        }
                        ajVar.a(timeLineObject, i, avVar.riA, avVar.rgZ);
                        ajVar.raQ.setVisibility(8);
                        g cnC2 = af.cnC();
                        long nanoTime = System.nanoTime() - System.nanoTime();
                        ab.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(g.t(bau)), Long.valueOf(nanoTime));
                        if (g.t(bau)) {
                            if (cnC2.u(bau)) {
                                ajVar.raP.setVisibility(0);
                                ajVar.rnu.setVisibility(8);
                                ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                                ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                            } else if (cnC2.v(bau)) {
                                ajVar.raP.setVisibility(8);
                                ajVar.rnu.setVisibility(8);
                            } else if (cnC2.b(nVar, null) <= 5) {
                                ajVar.raP.setVisibility(8);
                                ajVar.rnu.setVisibility(8);
                            } else {
                                cnC2.y(bau);
                                ajVar.raP.setVisibility(0);
                                ajVar.rnu.setVisibility(8);
                                ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                                ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                            }
                            if (ajVar.qzM.ckY()) {
                                ab.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH + " " + i);
                                cnC2.y(bau);
                                ajVar.raP.setVisibility(0);
                                ajVar.rnu.setVisibility(8);
                                ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                                ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                            }
                        } else if (cnC2.w(bau)) {
                            ajVar.raP.setVisibility(8);
                            ajVar.rnu.setVisibility(0);
                            ajVar.rnu.dKB();
                        } else if (cnC2.b(nVar, null) == 5) {
                            cnC2.A(bau);
                            ajVar.raP.setVisibility(8);
                            ajVar.rnu.setVisibility(0);
                            ajVar.rnu.dKB();
                        } else if (cnC2.x(bau)) {
                            ajVar.rnu.setVisibility(8);
                            ajVar.raP.setImageResource(R.drawable.atu);
                            ajVar.raP.setVisibility(0);
                        } else {
                            cnC2.y(bau);
                            ajVar.raP.setVisibility(0);
                            ajVar.rnu.setVisibility(8);
                            ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                            ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                            if (cnC2.b(nVar, null) == 4) {
                                ajVar.raQ.setVisibility(0);
                            }
                        }
                        layoutParams = ajVar.rnv.getLayoutParams();
                        layoutParams.width = this.rIV;
                        layoutParams.height = this.rIV;
                        ajVar.rnv.setLayoutParams(layoutParams);
                        ajVar.qzM.setTagObject(ajVar);
                        com.tencent.mm.plugin.sight.decode.a.a aVar5 = ajVar.qzM;
                        int hashCode3 = this.mActivity.hashCode();
                        az dtg3 = az.dtg();
                        dtg3.oyB = timeLineObject.pcX;
                        cnC2.a(nVar, bau, aVar5, hashCode3, i, dtg3, avVar.rgZ, true);
                        view2.setVisibility(0);
                        ajVar.rnt.setTag(baseViewHolder);
                        final int i5 = i3;
                        final au auVar3 = auVar;
                        bVar3 = bVar;
                        ajVar.rnt.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(40158);
                                if (i5 > 0) {
                                    auVar3.rxP.rhm.jQ(bVar3.rHt);
                                }
                                auVar3.qOL.rKn.onClick(view);
                                AppMethodBeat.o(40158);
                            }
                        });
                        if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.j(bau))) {
                            auVar.rxP.rhm.a(avVar.rAt, 0, true, z);
                        } else {
                            auVar.rxP.rhm.a(avVar.rAt, 0, false, z);
                        }
                        auVar.rxP.rhm.c(avVar.rAt, af.cnC().b(nVar, null) == 5, z);
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
                        u.setOnTouchListener(new OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                return false;
                            }
                        });
                    }
                    a aVar6 = new a();
                    aVar6.index = i4;
                    if (view == null) {
                        view = u;
                    }
                    aVar6.view = view;
                    aVar6.rJc = u;
                    aVar6.rJd = bVar;
                    aVar6.qJh = bau;
                    aVar6.ros = avVar.qBY;
                    if (aVar != null) {
                        aVar.rJe = aVar6;
                        aVar3 = aVar2;
                    } else {
                        aVar3 = aVar6;
                    }
                    if (i4 == timeLineObject.xfI.wbK.size() - 1) {
                        aVar6.rJe = aVar3;
                    }
                    if (i4 == i3) {
                        bVar.rJh = aVar6;
                        a(aVar6);
                    }
                    aVar4 = aVar6;
                } else {
                    aVar3 = aVar2;
                    aVar4 = aVar;
                }
                i4++;
                aVar2 = aVar3;
                aVar = aVar4;
            }
            if (bVar.mRR != null && (bVar.mRR instanceof FrameLayout)) {
                ((FrameLayout) bVar.mRR).setClipChildren(false);
            }
            if (bVar.rHB != null) {
                bVar.rHB.setClipChildren(false);
            }
            if (bVar.rIt != null && (bVar.rIt instanceof LinearLayout)) {
                ((LinearLayout) bVar.rIt).setClipChildren(false);
            }
            final au auVar4 = auVar;
            final int i6 = i3;
            bVar3 = bVar;
            bVar.rJf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40159);
                    auVar4.qOL.rKn.onClick(view);
                    if (i6 > 0) {
                        auVar4.rxP.rhm.jQ(bVar3.rHt);
                    }
                    AppMethodBeat.o(40159);
                }
            });
        }
        AppMethodBeat.o(40163);
    }

    public static View u(View view, int i, int i2) {
        AppMethodBeat.i(40164);
        View findViewById;
        if (i2 == 6) {
            findViewById = view.findViewById(rIW[0]);
            AppMethodBeat.o(40164);
            return findViewById;
        }
        findViewById = view.findViewById(rHh[i]);
        AppMethodBeat.o(40164);
        return findViewById;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(40165);
        aVar.rJd.rGQ.setVisibility(8);
        aVar.rJd.rGR.setVisibility(8);
        ((TextView) aVar.rJd.rJf.findViewById(R.id.ene)).setText(null);
        ((TextView) aVar.rJd.rJf.findViewById(R.id.enh)).setText(null);
        ((TextView) aVar.rJd.rJf.findViewById(R.id.enf)).setText(null);
        ((TextView) aVar.rJd.rJf.findViewById(R.id.eni)).setText(null);
        com.tencent.mm.plugin.sns.storage.b cqo = aVar.ros.cqo();
        if (!(cqo.qUX == null || cqo.qUX.qVt == null || cqo.qUX.qVt.size() < 2)) {
            h hVar = (h) cqo.qUX.qVt.get(aVar.index);
            if (hVar.qVk >= 0 && hVar.qVk < rIX.length) {
                int[] iArr = rIX[hVar.qVk];
                TextView textView = (TextView) aVar.rJd.rJf.findViewById(iArr[0]);
                TextView textView2 = (TextView) aVar.rJd.rJf.findViewById(iArr[1]);
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
        AppMethodBeat.o(40165);
    }
}
