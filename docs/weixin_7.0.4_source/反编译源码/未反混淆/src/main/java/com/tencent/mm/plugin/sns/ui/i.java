package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.StrictMode;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.au.AnonymousClass9;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.List;

public final class i {
    public static List<k> rhw = new LinkedList();
    Context context;
    String ecX;
    ClipboardManager mmO;
    public ListView nDp;
    FrameLayout qOM;
    public au qPr;
    public b rhA;
    p rhB = null;
    c rhC = new c<bv>() {
        {
            AppMethodBeat.i(38177);
            this.xxI = bv.class.getName().hashCode();
            AppMethodBeat.o(38177);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38178);
            if (i.this.rhx != null) {
                i.this.rhx.crO();
            }
            AppMethodBeat.o(38178);
            return false;
        }
    };
    c rhD = new c<qw>() {
        {
            AppMethodBeat.i(38179);
            this.xxI = qw.class.getName().hashCode();
            AppMethodBeat.o(38179);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38180);
            qw qwVar = (qw) bVar;
            if ((qwVar instanceof qw) && i.this.nDp != null) {
                boolean z;
                ListView listView = i.this.nDp;
                if (qwVar.cNc.enable) {
                    z = false;
                } else {
                    z = true;
                }
                listView.requestDisallowInterceptTouchEvent(z);
            }
            AppMethodBeat.o(38180);
            return false;
        }
    };
    OnLongClickListener rhE = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(38183);
            g.RQ();
            if (((Boolean) g.RP().Ry().get(7490, Boolean.TRUE)).booleanValue()) {
                i.this.context.startActivity(new Intent().setClass(i.this.context, SnsLongMsgUI.class));
                g.RQ();
                g.RP().Ry().set(7490, Boolean.FALSE);
            } else {
                Intent intent = new Intent();
                intent.setClass(i.this.context, SnsCommentUI.class);
                intent.putExtra("sns_comment_type", 1);
                ((MMActivity) i.this.context).startActivityForResult(intent, 9);
            }
            AppMethodBeat.o(38183);
            return true;
        }
    };
    public com.tencent.mm.plugin.sns.a.b.g rhm;
    public au rhn;
    boolean rho;
    boolean rhp = false;
    SnsCommentFooter rhq;
    be rhr;
    an rhs;
    private boolean rht = false;
    String rhu = "";
    private boolean rhv = false;
    bd rhx;
    b rhy;
    com.tencent.mm.plugin.sns.g.b rhz;

    public class a implements OnClickListener {
        private String eoz;
        private cat qJj;
        private BaseViewHolder rgW;
        private CharSequence rhM = "";

        public a(cat cat, String str, CharSequence charSequence, BaseViewHolder baseViewHolder) {
            this.eoz = str;
            this.qJj = cat;
            this.rgW = baseViewHolder;
            this.rhM = charSequence;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(38187);
            if (v.Zo(this.rgW.cFc)) {
                this.rgW.rHN = view;
                if (this.qJj == null || this.qJj.vHl == null || !this.qJj.vHl.equals(i.this.ecX)) {
                    n nVar = new n();
                    n DP = i.this.qPr.DP(this.rgW.position);
                    if (DP.cnn()) {
                        AppMethodBeat.o(38187);
                        return;
                    } else if (m.k(DP)) {
                        com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(742);
                        cbf q = aj.q(DP);
                        lY.tx(com.tencent.mm.plugin.sns.data.i.j(DP)).mb(DP.field_type).cS(DP.DI(32)).tx(DP.crc()).tx(this.qJj.wZG == 0 ? this.qJj.wZJ : this.qJj.wZG).tx(this.qJj.vHl).mb(q == null ? 0 : q.xao).mb(q == null ? 0 : q.xar);
                        lY.ajK();
                        i iVar = i.this;
                        BaseViewHolder baseViewHolder = this.rgW;
                        String str = i.this.context.getString(R.string.env) + this.eoz;
                        cat cat = this.qJj;
                        String str2 = baseViewHolder.cFc + str;
                        iVar.rhu = str2;
                        ab.i("MicroMsg.BaseTimeLine", "[performCommentClick] onCommentClick:  commentkey " + iVar.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        iVar.rhq.setTag(DP);
                        iVar.crC();
                        iVar.rhq.setVisibility(0);
                        iVar.rhq.rrt = i.di(str2, 0);
                        iVar.rhq.setCommentHint(str + iVar.context.getString(R.string.ejk));
                        iVar.rhq.setCommentInfo(cat);
                        iVar.rhq.g(i.rhw, str2);
                        iVar.rhq.lk(false);
                        iVar.c(baseViewHolder);
                        AppMethodBeat.o(38187);
                        return;
                    } else {
                        com.tencent.mm.plugin.sns.lucky.ui.a.f(this.rgW.rHT.getContext(), this.rgW.rHT.DT(0));
                        AppMethodBeat.o(38187);
                        return;
                    }
                }
                if (i.this.rhr.rDP) {
                    i.this.crD();
                    i.this.rhr.rDP = false;
                }
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(i.this.context);
                AnonymousClass1 anonymousClass1 = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(38184);
                        if (!(a.this.qJj == null || d.fF(a.this.qJj.wZL, 16))) {
                            contextMenu.add(0, 0, 0, i.this.context.getString(R.string.oy));
                        }
                        contextMenu.add(1, 1, 0, i.this.context.getString(R.string.p4));
                        AppMethodBeat.o(38184);
                    }
                };
                AnonymousClass2 anonymousClass2 = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        int i2 = 4;
                        AppMethodBeat.i(38186);
                        switch (menuItem.getItemId()) {
                            case 0:
                                i.this.mmO.setText(a.this.rhM);
                                h.bQ(i.this.context, i.this.context.getString(R.string.oz));
                                if (a.this.qJj != null) {
                                    String mz = bo.mz(v.Zm(a.this.rgW.cFc));
                                    com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                                    com.tencent.mm.plugin.secinforeport.a.a.h(4, mz + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + a.this.qJj.wZG, bo.ana(a.this.rhM.toString()));
                                    AppMethodBeat.o(38186);
                                    return;
                                }
                                break;
                            case 1:
                                ab.e("MicroMsg.BaseTimeLine", "del snsId:" + a.this.rgW.cFc + " commentId:" + a.this.qJj);
                                long Zm = v.Zm(a.this.rgW.cFc);
                                if (v.Zl(a.this.rgW.cFc)) {
                                    i2 = 6;
                                }
                                final com.tencent.mm.ai.m rVar = new r(Zm, i2, a.this.qJj);
                                g.RQ();
                                g.RO().eJo.a(rVar, 0);
                                i iVar = i.this;
                                Context c = i.this.context;
                                i.this.context.getString(R.string.tz);
                                iVar.rhB = h.b(c, i.this.context.getString(R.string.ek6), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(38185);
                                        g.RQ();
                                        g.RO().eJo.c(rVar);
                                        AppMethodBeat.o(38185);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(38186);
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(R.id.cy) instanceof int[]) {
                    iArr = (int[]) view.getTag(R.id.cy);
                }
                aVar.a(view, anonymousClass1, anonymousClass2, iArr[0], iArr[1]);
                AppMethodBeat.o(38187);
                return;
            }
            AppMethodBeat.o(38187);
        }
    }

    public i(Context context, int i, String str, int i2, String str2) {
        AppMethodBeat.i(38188);
        this.context = context;
        this.ecX = com.tencent.mm.model.r.Yz();
        this.rhn = new au();
        this.rhn.qMn = new com.tencent.mm.plugin.sns.i.b(i, str, i2, str2);
        this.rhA = new b((Activity) context, this.rhn) {
            public final void b(View view, int i, int i2, int i3) {
                AppMethodBeat.i(38167);
                if (i2 >= 0) {
                    AppMethodBeat.o(38167);
                    return;
                }
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final View view2 = view;
                new Runnable() {
                    int count = 20;

                    public final void run() {
                        AppMethodBeat.i(38164);
                        i.this.nDp.setSelectionFromTop(i4 + i.this.nDp.getHeaderViewsCount(), i5 + i6);
                        this.count--;
                        ab.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", Integer.valueOf(this.count), Integer.valueOf(Math.abs(view2.getTop() - (i5 + i6))));
                        if (this.count <= 0 || Math.abs(view2.getTop() - (i5 + i6)) < 5) {
                            ab.d("MicroMsg.TimelineClickListener", "count: %s", Integer.valueOf(this.count));
                            i.this.qPr.notifyDataSetChanged();
                            AppMethodBeat.o(38164);
                            return;
                        }
                        new ak().postDelayed(this, 5);
                        AppMethodBeat.o(38164);
                    }
                }.run();
                AppMethodBeat.o(38167);
            }

            public final void cp(Object obj) {
                AppMethodBeat.i(38168);
                i.this.rhs.a((View) obj, 1, 0, i.this.rhn);
                AppMethodBeat.o(38168);
            }

            public final void crE() {
                AppMethodBeat.i(38169);
                if (i.this.qPr != null) {
                    i.this.qPr.cua();
                }
                AppMethodBeat.o(38169);
            }

            public final void dG(View view) {
                AppMethodBeat.i(38170);
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                if (i.this.qPr.ctX() == null) {
                    AppMethodBeat.o(38170);
                    return;
                }
                i.this.qPr.ctX().crO();
                n nVar = new n();
                n DP = i.this.qPr.DP(baseViewHolder.position);
                if (DP.isValid()) {
                    com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(741);
                    cbf q = aj.q(DP);
                    lY.tx(com.tencent.mm.plugin.sns.data.i.j(DP)).mb(DP.field_type).cS(DP.DI(32)).tx(DP.crc()).tx(DP.field_userName).mb(q == null ? 0 : q.xao).mb(q == null ? 0 : q.xar);
                    lY.ajK();
                    i iVar;
                    cat cat;
                    if (!DP.DI(32) || (DP.cqu().xfI.wbL & 8) == 0) {
                        iVar = i.this;
                        cat = new cat();
                        String str = baseViewHolder.cFc;
                        iVar.rhu = str;
                        ab.i("MicroMsg.BaseTimeLine", "[performCommentIconClick] onCommentClick:  commentkey " + iVar.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        iVar.rhq.setTag(DP);
                        iVar.crC();
                        iVar.rhq.setVisibility(0);
                        iVar.rhq.rrt = i.di(str, 0);
                        iVar.rhq.setCommentInfo(cat);
                        iVar.rhq.setCommentHint(iVar.context.getString(R.string.eq9));
                        iVar.rhq.g(i.rhw, str);
                        iVar.rhq.lk(false);
                        iVar.c(baseViewHolder);
                        AppMethodBeat.o(38170);
                        return;
                    }
                    iVar = i.this;
                    cat = new cat();
                    iVar.rhu = null;
                    ab.i("MicroMsg.BaseTimeLine", "[performAdAtFriendClick] onCommentClick:  commentkey " + iVar.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                    iVar.rhq.setTag(DP);
                    iVar.crC();
                    iVar.rhq.setVisibility(0);
                    iVar.rhq.setCommentFlag(0);
                    iVar.rhq.setCommentHint("");
                    iVar.rhq.setCommentInfo(cat);
                    iVar.rhq.lk(true);
                    iVar.rhq.g(i.rhw, "");
                    iVar.c(baseViewHolder);
                    AppMethodBeat.o(38170);
                    return;
                }
                AppMethodBeat.o(38170);
            }

            public final void dH(View view) {
                AppMethodBeat.i(38171);
                if (view.getTag() instanceof BaseViewHolder) {
                    BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                    if (i.this.qPr.ctX() == null) {
                        AppMethodBeat.o(38171);
                        return;
                    }
                    i.this.qPr.ctX().crO();
                    n nVar = new n();
                    n DP = i.this.qPr.DP(baseViewHolder.position);
                    if (DP.isValid()) {
                        com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(741);
                        cbf q = aj.q(DP);
                        lY.tx(com.tencent.mm.plugin.sns.data.i.j(DP)).mb(DP.field_type).cS(DP.DI(32)).tx(DP.crc()).tx(DP.field_userName).mb(q == null ? 0 : q.xao).mb(q == null ? 0 : q.xar);
                        lY.ajK();
                        i iVar = i.this;
                        cat cat = new cat();
                        String str = baseViewHolder.cFc + "@boss";
                        iVar.rhu = str;
                        ab.i("MicroMsg.BaseTimeLine", "[performAdAtBossClick] onCommentClick:  commentkey " + iVar.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        g.RQ();
                        String Oj = ((j) g.K(j.class)).XM().aoM(DP.field_userName).Oj();
                        iVar.rhq.setTag(DP);
                        iVar.crC();
                        iVar.rhq.setVisibility(0);
                        iVar.rhq.setCommentFlag(i.di(str, 1));
                        iVar.rhq.setCommentHint(Oj);
                        iVar.rhq.setCommentInfo(cat);
                        iVar.rhq.g(i.rhw, str);
                        iVar.c(baseViewHolder);
                    } else {
                        AppMethodBeat.o(38171);
                        return;
                    }
                }
                AppMethodBeat.o(38171);
            }

            public final void dI(View view) {
                AppMethodBeat.i(38172);
                if (i.this.qPr != null) {
                    i.this.qPr.dO(view);
                }
                AppMethodBeat.o(38172);
            }

            /* JADX WARNING: Removed duplicated region for block: B:28:0x010f  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x019a  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x0161  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void dJ(View view) {
                AppMethodBeat.i(38173);
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                n YT = af.cnF().YT(baseViewHolder.cwT);
                if (YT == null || YT.cnn() || i.this.rhp) {
                    AppMethodBeat.o(38173);
                    return;
                }
                int i = 0;
                if (YT.DI(32) && YT.cqu().xfI.wbJ == 27 && (baseViewHolder.rIu instanceof com.tencent.mm.plugin.sns.ui.item.i)) {
                    com.tencent.mm.plugin.sns.ui.item.i iVar = (com.tencent.mm.plugin.sns.ui.item.i) baseViewHolder.rIu;
                    com.tencent.mm.plugin.sns.ui.item.i.a aVar = ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh;
                    if (aVar.rJe != null) {
                        com.tencent.mm.plugin.sns.ui.item.i.b bVar = aVar.rJd;
                        n nVar = aVar.ros;
                        TimeLineObject timeLineObject = bVar.timeLineObject;
                        bVar = bVar;
                        com.tencent.mm.plugin.sns.ui.item.i.a aVar2 = bVar.rJh;
                        if (timeLineObject.xfI.wbJ == 27 && timeLineObject.xfI.wbK.size() >= 2) {
                            int i2;
                            int i3;
                            int i4 = 0;
                            if (nVar.field_likeFlag == 1) {
                                i4 = 1;
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            bau bau = (bau) timeLineObject.xfI.wbK.get(i4);
                            timeLineObject.xfI.wbK.get(i2);
                            View view2 = bVar.rJf;
                            View u = com.tencent.mm.plugin.sns.ui.item.i.u(bVar.rJf, i4, bau.jCt);
                            View u2 = com.tencent.mm.plugin.sns.ui.item.i.u(bVar.rJf, i2, 2);
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            view2.setPivotY((float) ((iVar.mScreenHeight / 2) - iArr[1]));
                            view2.setCameraDistance(8000.0f);
                            float width = ((float) view2.getWidth()) / 2.0f;
                            float height = ((float) view2.getHeight()) / 2.0f;
                            if (nVar.field_likeFlag == 1) {
                                i3 = -90;
                                i4 = 90;
                            } else {
                                i3 = 90;
                                i4 = -90;
                            }
                            com.tencent.mm.plugin.sns.ui.widget.a aVar3 = new com.tencent.mm.plugin.sns.ui.widget.a(view2.getContext(), 0.0f, (float) i4, width, height, true);
                            aVar3.setDuration(187);
                            aVar3.setInterpolator(new AccelerateInterpolator());
                            aVar3.setAnimationListener(new com.tencent.mm.plugin.sns.ui.item.i.AnonymousClass6(u2, u, aVar2, view2, i3, width, height));
                            view2.startAnimation(aVar3);
                            i = 374;
                            if (YT.field_likeFlag == 0) {
                                i.this.rhm.jP(baseViewHolder.rHt);
                            }
                            if (YT.cqu().xfI.wbK.size() > ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index && ((bau) YT.cqu().xfI.wbK.get(((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index)).jCt == 6) {
                                i.this.rhm.x(baseViewHolder.rHt, ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index <= 0);
                            }
                            i.this.rhp = true;
                        }
                    }
                    i = 0;
                    if (YT.field_likeFlag == 0) {
                    }
                    if (((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index <= 0) {
                    }
                    i.this.rhm.x(baseViewHolder.rHt, ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index <= 0);
                    i.this.rhp = true;
                }
                final n nVar2 = YT;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                final View view3 = view;
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38166);
                        if (i.this.rhn != null) {
                            i.this.rhn.qMn.w(nVar2);
                        }
                        if (baseViewHolder2.rHu == 0) {
                            cbf q = aj.q(nVar2);
                            com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(707);
                            lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar2)).mb(nVar2.field_type).cS(nVar2.DI(32)).tx(nVar2.crc()).tx(nVar2.field_userName).mb(q.xao).mb(q.xar);
                            lY.ajK();
                            StrictMode.allowThreadDiskReads();
                            baseViewHolder2.rHu = 1;
                            nVar2.field_likeFlag = baseViewHolder2.rHu;
                            com.tencent.mm.plugin.sns.storage.h.a(nVar2.cqA(), nVar2);
                            ((TextView) view3.findViewById(R.id.ehb)).setText(R.string.el4);
                            com.tencent.mm.plugin.sns.model.am.a.a(nVar2, nVar2.DI(32) ? 7 : 1, "", 0);
                        } else {
                            baseViewHolder2.rHu = 0;
                            nVar2.field_likeFlag = baseViewHolder2.rHu;
                            com.tencent.mm.plugin.sns.storage.h.a(nVar2.cqA(), nVar2);
                            ((TextView) view3.findViewById(R.id.ehb)).setText(R.string.em5);
                            com.tencent.mm.plugin.sns.model.am.a.Yd(nVar2.cqA());
                        }
                        au auVar = i.this.qPr;
                        LinearLayout linearLayout = (LinearLayout) view3;
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(38165);
                                i.this.rhp = false;
                                AppMethodBeat.o(38165);
                            }
                        };
                        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.eha);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setStartOffset(100);
                        scaleAnimation.setRepeatCount(0);
                        imageView.clearAnimation();
                        imageView.startAnimation(scaleAnimation);
                        scaleAnimation.setAnimationListener(new AnonymousClass9(linearLayout, anonymousClass1));
                        AppMethodBeat.o(38166);
                    }
                }, (long) i);
                AppMethodBeat.o(38173);
            }

            public final void dK(View view) {
                AppMethodBeat.i(38174);
                i.this.rhx.crO();
                i.this.rhy.iXr = true;
                i.this.rhy.dF(view);
                AppMethodBeat.o(38174);
            }

            public final void crF() {
                AppMethodBeat.i(38175);
                i.this.rhy.crv();
                AppMethodBeat.o(38175);
            }

            public final void dL(View view) {
                AppMethodBeat.i(38176);
                i.this.rhy.cox();
                if (view.getTag() != null) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    i.this.rhm.j(bVar.position, bVar.cwT, 1);
                }
                AppMethodBeat.o(38176);
            }
        };
        this.rhA.bIB();
        com.tencent.mm.sdk.b.a.xxA.c(this.rhC);
        com.tencent.mm.sdk.b.a.xxA.c(this.rhD);
        AppMethodBeat.o(38188);
    }

    static {
        AppMethodBeat.i(38193);
        AppMethodBeat.o(38193);
    }

    /* Access modifiers changed, original: final */
    public final void crC() {
        AppMethodBeat.i(38189);
        if (this.rht) {
            AppMethodBeat.o(38189);
            return;
        }
        this.rht = true;
        this.rhq.setAfterEditAction(this.rhr.rDS);
        this.rhq.setOnCommentSendImp(new b() {
            public final void Zr(String str) {
                AppMethodBeat.i(38181);
                n nVar = (n) i.this.rhq.getTag();
                ab.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                if (str == null || str.trim().equals("")) {
                    ab.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                    AppMethodBeat.o(38181);
                    return;
                }
                cat commentInfo = i.this.rhq.getCommentInfo();
                cbf q = aj.q(nVar);
                int i = (commentInfo.wZG == 0 && commentInfo.wZJ == 0) ? 708 : 709;
                com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(i);
                if (lY.opType == 708) {
                    lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32)).tx(nVar.crc()).tx(nVar.field_userName).mb(q.xao).mb(q.xar);
                } else {
                    String str2;
                    com.tencent.mm.modelsns.b tx = lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32)).tx(nVar.crc()).tx(commentInfo.vHl);
                    if (commentInfo.wZG == 0) {
                        str2 = commentInfo.wZJ;
                    } else {
                        str2 = commentInfo.wZG;
                    }
                    tx.tx(str2).mb(q.xao).mb(q.xar);
                }
                lY.ajK();
                if (i.this.rhn != null) {
                    i.this.rhn.qMn.w(nVar);
                }
                int commentFlag = i.this.rhq.getCommentFlag();
                ab.i("MicroMsg.BaseTimeLine", "onCommentSend click %s", Integer.valueOf(commentFlag));
                if (d.fF(commentFlag, 8)) {
                    String substring = str.substring(i.this.rhq.getCommentAtPrefix().length());
                    ab.i("MicroMsg.BaseTimeLine", "send atFriend ad timeline comment");
                    com.tencent.mm.plugin.sns.model.am.a.a(nVar, 16, substring, i.this.rhq.getCommentInfo(), commentFlag, 0);
                } else {
                    ab.i("MicroMsg.BaseTimeLine", "send timeline comment");
                    if (nVar.DI(32)) {
                        i = 8;
                    } else {
                        i = 2;
                    }
                    com.tencent.mm.plugin.sns.model.am.a.a(nVar, i, str, i.this.rhq.getCommentInfo(), commentFlag, 0);
                }
                i.this.qPr.Z(i.this.rhr.rDS);
                i.this.crD();
                if (!bo.isNullOrNil(i.this.rhu)) {
                    for (k kVar : i.rhw) {
                        if (i.this.rhu.equals(kVar.key)) {
                            ab.d("MicroMsg.BaseTimeLine", "remove ct");
                            i.rhw.remove(kVar);
                            AppMethodBeat.o(38181);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(38181);
            }
        });
        SnsCommentFooter snsCommentFooter = this.rhq;
        AnonymousClass5 anonymousClass5 = new com.tencent.mm.ui.widget.MMEditText.a() {
            public final void bMu() {
                AppMethodBeat.i(38182);
                if (i.this.rhq.getVisibility() == 0) {
                    i.this.rhq.setVisibility(8);
                    AppMethodBeat.o(38182);
                    return;
                }
                ((Activity) i.this.context).finish();
                AppMethodBeat.o(38182);
            }
        };
        if (snsCommentFooter.oij != null) {
            snsCommentFooter.oij.setBackListener(anonymousClass5);
        }
        AppMethodBeat.o(38189);
    }

    /* Access modifiers changed, original: final */
    public final void crD() {
        AppMethodBeat.i(38190);
        if (this.rht) {
            if (this.rhq.getVisibility() != 8) {
                this.rhq.setVisibility(8);
            }
            au auVar = this.qPr;
            if (auVar.rxS != null) {
                auVar.rxS.setVisibility(8);
            }
            auVar.rxS = null;
            AppMethodBeat.o(38190);
            return;
        }
        AppMethodBeat.o(38190);
    }

    /* Access modifiers changed, original: final */
    public final void c(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(38191);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.context, 8);
        if (baseViewHolder.rHN != null) {
            fromDPToPix += baseViewHolder.rHP.getHeight() - baseViewHolder.rHN.getBottom();
            ab.i("MicroMsg.BaseTimeLine", "comment item bottom = " + baseViewHolder.rHN.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.rhr.position = baseViewHolder.position;
        this.rhr.rDM = baseViewHolder.mRR.getHeight() - fromDPToPix;
        baseViewHolder.rHN = null;
        this.rhr.rDN = baseViewHolder.mRR.getTop();
        this.rhr.rpW = this.nDp.getBottom();
        ab.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rhr.rDN);
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).mController.ymc == 1) {
            this.rhr.cuK();
            AppMethodBeat.o(38191);
            return;
        }
        this.rho = true;
        AppMethodBeat.o(38191);
    }

    static int di(String str, int i) {
        AppMethodBeat.i(38192);
        for (k kVar : rhw) {
            if (bo.isEqual(kVar.key, str)) {
                i = kVar.bJt;
                break;
            }
        }
        AppMethodBeat.o(38192);
        return i;
    }
}
