package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C41971bv;
import com.tencent.p177mm.p230g.p231a.C9453qw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5620a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.lucky.p1299ui.C29040a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C31413au;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13342g;
import com.tencent.p177mm.plugin.sns.p516g.C31408b;
import com.tencent.p177mm.plugin.sns.p517i.C43548b;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au.C291949;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentFooter.C35017b;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C136946;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C13695a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C13697b;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C29247a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.i */
public final class C29220i {
    public static List<C13699k> rhw = new LinkedList();
    Context context;
    String ecX;
    ClipboardManager mmO;
    public ListView nDp;
    FrameLayout qOM;
    public C46251au qPr;
    public C22089b rhA;
    C44275p rhB = null;
    C4884c rhC = new C292152();
    C4884c rhD = new C221233();
    OnLongClickListener rhE = new C292256();
    public C13342g rhm;
    public C31413au rhn;
    boolean rho;
    boolean rhp = false;
    SnsCommentFooter rhq;
    C39839be rhr;
    C22062an rhs;
    private boolean rht = false;
    String rhu = "";
    private boolean rhv = false;
    C46256bd rhx;
    C4045b rhy;
    C31408b rhz;

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$5 */
    class C136815 implements C5620a {
        C136815() {
        }

        public final void bMu() {
            AppMethodBeat.m2504i(38182);
            if (C29220i.this.rhq.getVisibility() == 0) {
                C29220i.this.rhq.setVisibility(8);
                AppMethodBeat.m2505o(38182);
                return;
            }
            ((Activity) C29220i.this.context).finish();
            AppMethodBeat.m2505o(38182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$3 */
    class C221233 extends C4884c<C9453qw> {
        C221233() {
            AppMethodBeat.m2504i(38179);
            this.xxI = C9453qw.class.getName().hashCode();
            AppMethodBeat.m2505o(38179);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38180);
            C9453qw c9453qw = (C9453qw) c4883b;
            if ((c9453qw instanceof C9453qw) && C29220i.this.nDp != null) {
                boolean z;
                ListView listView = C29220i.this.nDp;
                if (c9453qw.cNc.enable) {
                    z = false;
                } else {
                    z = true;
                }
                listView.requestDisallowInterceptTouchEvent(z);
            }
            AppMethodBeat.m2505o(38180);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$2 */
    class C292152 extends C4884c<C41971bv> {
        C292152() {
            AppMethodBeat.m2504i(38177);
            this.xxI = C41971bv.class.getName().hashCode();
            AppMethodBeat.m2505o(38177);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38178);
            if (C29220i.this.rhx != null) {
                C29220i.this.rhx.crO();
            }
            AppMethodBeat.m2505o(38178);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$4 */
    class C292164 implements C35017b {
        C292164() {
        }

        /* renamed from: Zr */
        public final void mo8842Zr(String str) {
            AppMethodBeat.m2504i(38181);
            C46236n c46236n = (C46236n) C29220i.this.rhq.getTag();
            C4990ab.m7410d("MicroMsg.BaseTimeLine", "onCommentSend click");
            if (str == null || str.trim().equals("")) {
                C4990ab.m7412e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                AppMethodBeat.m2505o(38181);
                return;
            }
            cat commentInfo = C29220i.this.rhq.getCommentInfo();
            cbf q = C34955aj.m57409q(c46236n);
            int i = (commentInfo.wZG == 0 && commentInfo.wZJ == 0) ? 708 : 709;
            C37952b lY = C37952b.m64170lY(i);
            if (lY.opType == 708) {
                lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32)).mo60722tx(c46236n.crc()).mo60722tx(c46236n.field_userName).mo60720mb(q.xao).mo60720mb(q.xar);
            } else {
                String str2;
                C37952b tx = lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32)).mo60722tx(c46236n.crc()).mo60722tx(commentInfo.vHl);
                if (commentInfo.wZG == 0) {
                    str2 = commentInfo.wZJ;
                } else {
                    str2 = commentInfo.wZG;
                }
                tx.mo60722tx(str2).mo60720mb(q.xao).mo60720mb(q.xar);
            }
            lY.ajK();
            if (C29220i.this.rhn != null) {
                C29220i.this.rhn.qMn.mo69121w(c46236n);
            }
            int commentFlag = C29220i.this.rhq.getCommentFlag();
            C4990ab.m7417i("MicroMsg.BaseTimeLine", "onCommentSend click %s", Integer.valueOf(commentFlag));
            if (C39851d.m68264fF(commentFlag, 8)) {
                String substring = str.substring(C29220i.this.rhq.getCommentAtPrefix().length());
                C4990ab.m7416i("MicroMsg.BaseTimeLine", "send atFriend ad timeline comment");
                C3890a.m6183a(c46236n, 16, substring, C29220i.this.rhq.getCommentInfo(), commentFlag, 0);
            } else {
                C4990ab.m7416i("MicroMsg.BaseTimeLine", "send timeline comment");
                if (c46236n.mo74253DI(32)) {
                    i = 8;
                } else {
                    i = 2;
                }
                C3890a.m6183a(c46236n, i, str, C29220i.this.rhq.getCommentInfo(), commentFlag, 0);
            }
            C29220i.this.qPr.mo74341Z(C29220i.this.rhr.rDS);
            C29220i.this.crD();
            if (!C5046bo.isNullOrNil(C29220i.this.rhu)) {
                for (C13699k c13699k : C29220i.rhw) {
                    if (C29220i.this.rhu.equals(c13699k.key)) {
                        C4990ab.m7410d("MicroMsg.BaseTimeLine", "remove ct");
                        C29220i.rhw.remove(c13699k);
                        AppMethodBeat.m2505o(38181);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(38181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$a */
    public class C29224a implements OnClickListener {
        private String eoz;
        private cat qJj;
        private BaseViewHolder rgW;
        private CharSequence rhM = "";

        /* renamed from: com.tencent.mm.plugin.sns.ui.i$a$1 */
        class C292171 implements OnCreateContextMenuListener {
            C292171() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(38184);
                if (!(C29224a.this.qJj == null || C39851d.m68264fF(C29224a.this.qJj.wZL, 16))) {
                    contextMenu.add(0, 0, 0, C29220i.this.context.getString(C25738R.string.f9082oy));
                }
                contextMenu.add(1, 1, 0, C29220i.this.context.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(38184);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.i$a$2 */
        class C292182 implements C5279d {
            C292182() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2 = 4;
                AppMethodBeat.m2504i(38186);
                switch (menuItem.getItemId()) {
                    case 0:
                        C29220i.this.mmO.setText(C29224a.this.rhM);
                        C30379h.m48465bQ(C29220i.this.context, C29220i.this.context.getString(C25738R.string.f9083oz));
                        if (C29224a.this.qJj != null) {
                            String mz = C5046bo.m7581mz(C35002v.m57483Zm(C29224a.this.rgW.cFc));
                            C21734a c21734a = C21734a.qjm;
                            C21734a.m33275h(4, mz + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C29224a.this.qJj.wZG, C5046bo.ana(C29224a.this.rhM.toString()));
                            AppMethodBeat.m2505o(38186);
                            return;
                        }
                        break;
                    case 1:
                        C4990ab.m7412e("MicroMsg.BaseTimeLine", "del snsId:" + C29224a.this.rgW.cFc + " commentId:" + C29224a.this.qJj);
                        long Zm = C35002v.m57483Zm(C29224a.this.rgW.cFc);
                        if (C35002v.m57482Zl(C29224a.this.rgW.cFc)) {
                            i2 = 6;
                        }
                        final C1207m c46224r = new C46224r(Zm, i2, C29224a.this.qJj);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                        C29220i c29220i = C29220i.this;
                        Context c = C29220i.this.context;
                        C29220i.this.context.getString(C25738R.string.f9238tz);
                        c29220i.rhB = C30379h.m48458b(c, C29220i.this.context.getString(C25738R.string.ek6), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(38185);
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14547c(c46224r);
                                AppMethodBeat.m2505o(38185);
                            }
                        });
                        break;
                }
                AppMethodBeat.m2505o(38186);
            }
        }

        public C29224a(cat cat, String str, CharSequence charSequence, BaseViewHolder baseViewHolder) {
            this.eoz = str;
            this.qJj = cat;
            this.rgW = baseViewHolder;
            this.rhM = charSequence;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38187);
            if (C35002v.m57485Zo(this.rgW.cFc)) {
                this.rgW.rHN = view;
                if (this.qJj == null || this.qJj.vHl == null || !this.qJj.vHl.equals(C29220i.this.ecX)) {
                    C46236n c46236n = new C46236n();
                    C46236n DP = C29220i.this.qPr.mo74340DP(this.rgW.position);
                    if (DP.cnn()) {
                        AppMethodBeat.m2505o(38187);
                        return;
                    } else if (C39742m.m67970k(DP)) {
                        C37952b lY = C37952b.m64170lY(742);
                        cbf q = C34955aj.m57409q(DP);
                        lY.mo60722tx(C29036i.m46115j(DP)).mo60720mb(DP.field_type).mo60718cS(DP.mo74253DI(32)).mo60722tx(DP.crc()).mo60722tx(this.qJj.wZG == 0 ? this.qJj.wZJ : this.qJj.wZG).mo60722tx(this.qJj.vHl).mo60720mb(q == null ? 0 : q.xao).mo60720mb(q == null ? 0 : q.xar);
                        lY.ajK();
                        C29220i c29220i = C29220i.this;
                        BaseViewHolder baseViewHolder = this.rgW;
                        String str = C29220i.this.context.getString(C25738R.string.env) + this.eoz;
                        cat cat = this.qJj;
                        String str2 = baseViewHolder.cFc + str;
                        c29220i.rhu = str2;
                        C4990ab.m7416i("MicroMsg.BaseTimeLine", "[performCommentClick] onCommentClick:  commentkey " + c29220i.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        c29220i.rhq.setTag(DP);
                        c29220i.crC();
                        c29220i.rhq.setVisibility(0);
                        c29220i.rhq.rrt = C29220i.m46395di(str2, 0);
                        c29220i.rhq.setCommentHint(str + c29220i.context.getString(C25738R.string.ejk));
                        c29220i.rhq.setCommentInfo(cat);
                        c29220i.rhq.mo55632g(C29220i.rhw, str2);
                        c29220i.rhq.mo55637lk(false);
                        c29220i.mo47388c(baseViewHolder);
                        AppMethodBeat.m2505o(38187);
                        return;
                    } else {
                        C29040a.m46131f(this.rgW.rHT.getContext(), this.rgW.rHT.mo8755DT(0));
                        AppMethodBeat.m2505o(38187);
                        return;
                    }
                }
                if (C29220i.this.rhr.rDP) {
                    C29220i.this.crD();
                    C29220i.this.rhr.rDP = false;
                }
                C24088a c24088a = new C24088a(C29220i.this.context);
                C292171 c292171 = new C292171();
                C292182 c292182 = new C292182();
                int[] iArr = new int[2];
                if (view.getTag(2131820679) instanceof int[]) {
                    iArr = (int[]) view.getTag(2131820679);
                }
                c24088a.mo39886a(view, c292171, c292182, iArr[0], iArr[1]);
                AppMethodBeat.m2505o(38187);
                return;
            }
            AppMethodBeat.m2505o(38187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.i$6 */
    class C292256 implements OnLongClickListener {
        C292256() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(38183);
            C1720g.m3537RQ();
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(7490, Boolean.TRUE)).booleanValue()) {
                C29220i.this.context.startActivity(new Intent().setClass(C29220i.this.context, SnsLongMsgUI.class));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7490, Boolean.FALSE);
            } else {
                Intent intent = new Intent();
                intent.setClass(C29220i.this.context, SnsCommentUI.class);
                intent.putExtra("sns_comment_type", 1);
                ((MMActivity) C29220i.this.context).startActivityForResult(intent, 9);
            }
            AppMethodBeat.m2505o(38183);
            return true;
        }
    }

    public C29220i(Context context, int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(38188);
        this.context = context;
        this.ecX = C1853r.m3846Yz();
        this.rhn = new C31413au();
        this.rhn.qMn = new C43548b(i, str, i2, str2);
        this.rhA = new C22089b((Activity) context, this.rhn) {
            /* renamed from: b */
            public final void mo17688b(View view, int i, int i2, int i3) {
                AppMethodBeat.m2504i(38167);
                if (i2 >= 0) {
                    AppMethodBeat.m2505o(38167);
                    return;
                }
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final View view2 = view;
                new Runnable() {
                    int count = 20;

                    public final void run() {
                        AppMethodBeat.m2504i(38164);
                        C29220i.this.nDp.setSelectionFromTop(i4 + C29220i.this.nDp.getHeaderViewsCount(), i5 + i6);
                        this.count--;
                        C4990ab.m7411d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", Integer.valueOf(this.count), Integer.valueOf(Math.abs(view2.getTop() - (i5 + i6))));
                        if (this.count <= 0 || Math.abs(view2.getTop() - (i5 + i6)) < 5) {
                            C4990ab.m7411d("MicroMsg.TimelineClickListener", "count: %s", Integer.valueOf(this.count));
                            C29220i.this.qPr.notifyDataSetChanged();
                            AppMethodBeat.m2505o(38164);
                            return;
                        }
                        new C7306ak().postDelayed(this, 5);
                        AppMethodBeat.m2505o(38164);
                    }
                }.run();
                AppMethodBeat.m2505o(38167);
            }

            /* renamed from: cp */
            public final void mo17689cp(Object obj) {
                AppMethodBeat.m2504i(38168);
                C29220i.this.rhs.mo37616a((View) obj, 1, 0, C29220i.this.rhn);
                AppMethodBeat.m2505o(38168);
            }

            public final void crE() {
                AppMethodBeat.m2504i(38169);
                if (C29220i.this.qPr != null) {
                    C29220i.this.qPr.cua();
                }
                AppMethodBeat.m2505o(38169);
            }

            /* renamed from: dG */
            public final void mo17692dG(View view) {
                AppMethodBeat.m2504i(38170);
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                if (C29220i.this.qPr.ctX() == null) {
                    AppMethodBeat.m2505o(38170);
                    return;
                }
                C29220i.this.qPr.ctX().crO();
                C46236n c46236n = new C46236n();
                C46236n DP = C29220i.this.qPr.mo74340DP(baseViewHolder.position);
                if (DP.isValid()) {
                    C37952b lY = C37952b.m64170lY(741);
                    cbf q = C34955aj.m57409q(DP);
                    lY.mo60722tx(C29036i.m46115j(DP)).mo60720mb(DP.field_type).mo60718cS(DP.mo74253DI(32)).mo60722tx(DP.crc()).mo60722tx(DP.field_userName).mo60720mb(q == null ? 0 : q.xao).mo60720mb(q == null ? 0 : q.xar);
                    lY.ajK();
                    C29220i c29220i;
                    cat cat;
                    if (!DP.mo74253DI(32) || (DP.cqu().xfI.wbL & 8) == 0) {
                        c29220i = C29220i.this;
                        cat = new cat();
                        String str = baseViewHolder.cFc;
                        c29220i.rhu = str;
                        C4990ab.m7416i("MicroMsg.BaseTimeLine", "[performCommentIconClick] onCommentClick:  commentkey " + c29220i.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        c29220i.rhq.setTag(DP);
                        c29220i.crC();
                        c29220i.rhq.setVisibility(0);
                        c29220i.rhq.rrt = C29220i.m46395di(str, 0);
                        c29220i.rhq.setCommentInfo(cat);
                        c29220i.rhq.setCommentHint(c29220i.context.getString(C25738R.string.eq9));
                        c29220i.rhq.mo55632g(C29220i.rhw, str);
                        c29220i.rhq.mo55637lk(false);
                        c29220i.mo47388c(baseViewHolder);
                        AppMethodBeat.m2505o(38170);
                        return;
                    }
                    c29220i = C29220i.this;
                    cat = new cat();
                    c29220i.rhu = null;
                    C4990ab.m7416i("MicroMsg.BaseTimeLine", "[performAdAtFriendClick] onCommentClick:  commentkey " + c29220i.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                    c29220i.rhq.setTag(DP);
                    c29220i.crC();
                    c29220i.rhq.setVisibility(0);
                    c29220i.rhq.setCommentFlag(0);
                    c29220i.rhq.setCommentHint("");
                    c29220i.rhq.setCommentInfo(cat);
                    c29220i.rhq.mo55637lk(true);
                    c29220i.rhq.mo55632g(C29220i.rhw, "");
                    c29220i.mo47388c(baseViewHolder);
                    AppMethodBeat.m2505o(38170);
                    return;
                }
                AppMethodBeat.m2505o(38170);
            }

            /* renamed from: dH */
            public final void mo17693dH(View view) {
                AppMethodBeat.m2504i(38171);
                if (view.getTag() instanceof BaseViewHolder) {
                    BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                    if (C29220i.this.qPr.ctX() == null) {
                        AppMethodBeat.m2505o(38171);
                        return;
                    }
                    C29220i.this.qPr.ctX().crO();
                    C46236n c46236n = new C46236n();
                    C46236n DP = C29220i.this.qPr.mo74340DP(baseViewHolder.position);
                    if (DP.isValid()) {
                        C37952b lY = C37952b.m64170lY(741);
                        cbf q = C34955aj.m57409q(DP);
                        lY.mo60722tx(C29036i.m46115j(DP)).mo60720mb(DP.field_type).mo60718cS(DP.mo74253DI(32)).mo60722tx(DP.crc()).mo60722tx(DP.field_userName).mo60720mb(q == null ? 0 : q.xao).mo60720mb(q == null ? 0 : q.xar);
                        lY.ajK();
                        C29220i c29220i = C29220i.this;
                        cat cat = new cat();
                        String str = baseViewHolder.cFc + "@boss";
                        c29220i.rhu = str;
                        C4990ab.m7416i("MicroMsg.BaseTimeLine", "[performAdAtBossClick] onCommentClick:  commentkey " + c29220i.rhu + " " + baseViewHolder.cFc + " position:" + baseViewHolder.position);
                        C1720g.m3537RQ();
                        String Oj = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(DP.field_userName).mo16707Oj();
                        c29220i.rhq.setTag(DP);
                        c29220i.crC();
                        c29220i.rhq.setVisibility(0);
                        c29220i.rhq.setCommentFlag(C29220i.m46395di(str, 1));
                        c29220i.rhq.setCommentHint(Oj);
                        c29220i.rhq.setCommentInfo(cat);
                        c29220i.rhq.mo55632g(C29220i.rhw, str);
                        c29220i.mo47388c(baseViewHolder);
                    } else {
                        AppMethodBeat.m2505o(38171);
                        return;
                    }
                }
                AppMethodBeat.m2505o(38171);
            }

            /* renamed from: dI */
            public final void mo17694dI(View view) {
                AppMethodBeat.m2504i(38172);
                if (C29220i.this.qPr != null) {
                    C29220i.this.qPr.mo74350dO(view);
                }
                AppMethodBeat.m2505o(38172);
            }

            /* JADX WARNING: Removed duplicated region for block: B:28:0x010f  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x019a  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x0161  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: dJ */
            public final void mo17695dJ(View view) {
                AppMethodBeat.m2504i(38173);
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                C46236n YT = C13373af.cnF().mo62918YT(baseViewHolder.cwT);
                if (YT == null || YT.cnn() || C29220i.this.rhp) {
                    AppMethodBeat.m2505o(38173);
                    return;
                }
                int i = 0;
                if (YT.mo74253DI(32) && YT.cqu().xfI.wbJ == 27 && (baseViewHolder.rIu instanceof C13690i)) {
                    C13690i c13690i = (C13690i) baseViewHolder.rIu;
                    C13695a c13695a = ((C13697b) baseViewHolder).rJh;
                    if (c13695a.rJe != null) {
                        C13697b c13697b = c13695a.rJd;
                        C46236n c46236n = c13695a.ros;
                        TimeLineObject timeLineObject = c13697b.timeLineObject;
                        c13697b = c13697b;
                        C13695a c13695a2 = c13697b.rJh;
                        if (timeLineObject.xfI.wbJ == 27 && timeLineObject.xfI.wbK.size() >= 2) {
                            int i2;
                            int i3;
                            int i4 = 0;
                            if (c46236n.field_likeFlag == 1) {
                                i4 = 1;
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            bau bau = (bau) timeLineObject.xfI.wbK.get(i4);
                            timeLineObject.xfI.wbK.get(i2);
                            View view2 = c13697b.rJf;
                            View u = C13690i.m21891u(c13697b.rJf, i4, bau.jCt);
                            View u2 = C13690i.m21891u(c13697b.rJf, i2, 2);
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            view2.setPivotY((float) ((c13690i.mScreenHeight / 2) - iArr[1]));
                            view2.setCameraDistance(8000.0f);
                            float width = ((float) view2.getWidth()) / 2.0f;
                            float height = ((float) view2.getHeight()) / 2.0f;
                            if (c46236n.field_likeFlag == 1) {
                                i3 = -90;
                                i4 = 90;
                            } else {
                                i3 = 90;
                                i4 = -90;
                            }
                            C29247a c29247a = new C29247a(view2.getContext(), 0.0f, (float) i4, width, height, true);
                            c29247a.setDuration(187);
                            c29247a.setInterpolator(new AccelerateInterpolator());
                            c29247a.setAnimationListener(new C136946(u2, u, c13695a2, view2, i3, width, height));
                            view2.startAnimation(c29247a);
                            i = 374;
                            if (YT.field_likeFlag == 0) {
                                C29220i.this.rhm.mo25440jP(baseViewHolder.rHt);
                            }
                            if (YT.cqu().xfI.wbK.size() > ((C13697b) baseViewHolder).rJh.index && ((bau) YT.cqu().xfI.wbK.get(((C13697b) baseViewHolder).rJh.index)).jCt == 6) {
                                C29220i.this.rhm.mo25448x(baseViewHolder.rHt, ((C13697b) baseViewHolder).rJh.index <= 0);
                            }
                            C29220i.this.rhp = true;
                        }
                    }
                    i = 0;
                    if (YT.field_likeFlag == 0) {
                    }
                    if (((C13697b) baseViewHolder).rJh.index <= 0) {
                    }
                    C29220i.this.rhm.mo25448x(baseViewHolder.rHt, ((C13697b) baseViewHolder).rJh.index <= 0);
                    C29220i.this.rhp = true;
                }
                final C46236n c46236n2 = YT;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                final View view3 = view;
                new C7306ak().postDelayed(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.i$1$2$1 */
                    class C136801 implements Runnable {
                        C136801() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(38165);
                            C29220i.this.rhp = false;
                            AppMethodBeat.m2505o(38165);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(38166);
                        if (C29220i.this.rhn != null) {
                            C29220i.this.rhn.qMn.mo69121w(c46236n2);
                        }
                        if (baseViewHolder2.rHu == 0) {
                            cbf q = C34955aj.m57409q(c46236n2);
                            C37952b lY = C37952b.m64170lY(707);
                            lY.mo60722tx(C29036i.m46115j(c46236n2)).mo60720mb(c46236n2.field_type).mo60718cS(c46236n2.mo74253DI(32)).mo60722tx(c46236n2.crc()).mo60722tx(c46236n2.field_userName).mo60720mb(q.xao).mo60720mb(q.xar);
                            lY.ajK();
                            StrictMode.allowThreadDiskReads();
                            baseViewHolder2.rHu = 1;
                            c46236n2.field_likeFlag = baseViewHolder2.rHu;
                            C21990h.m33617a(c46236n2.cqA(), c46236n2);
                            ((TextView) view3.findViewById(2131827696)).setText(C25738R.string.el4);
                            C3890a.m6182a(c46236n2, c46236n2.mo74253DI(32) ? 7 : 1, "", 0);
                        } else {
                            baseViewHolder2.rHu = 0;
                            c46236n2.field_likeFlag = baseViewHolder2.rHu;
                            C21990h.m33617a(c46236n2.cqA(), c46236n2);
                            ((TextView) view3.findViewById(2131827696)).setText(C25738R.string.em5);
                            C3890a.m6181Yd(c46236n2.cqA());
                        }
                        C46251au c46251au = C29220i.this.qPr;
                        LinearLayout linearLayout = (LinearLayout) view3;
                        C136801 c136801 = new C136801();
                        ImageView imageView = (ImageView) linearLayout.findViewById(2131827695);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setStartOffset(100);
                        scaleAnimation.setRepeatCount(0);
                        imageView.clearAnimation();
                        imageView.startAnimation(scaleAnimation);
                        scaleAnimation.setAnimationListener(new C291949(linearLayout, c136801));
                        AppMethodBeat.m2505o(38166);
                    }
                }, (long) i);
                AppMethodBeat.m2505o(38173);
            }

            /* renamed from: dK */
            public final void mo17696dK(View view) {
                AppMethodBeat.m2504i(38174);
                C29220i.this.rhx.crO();
                C29220i.this.rhy.iXr = true;
                C29220i.this.rhy.mo8900dF(view);
                AppMethodBeat.m2505o(38174);
            }

            public final void crF() {
                AppMethodBeat.m2504i(38175);
                C29220i.this.rhy.crv();
                AppMethodBeat.m2505o(38175);
            }

            /* renamed from: dL */
            public final void mo17697dL(View view) {
                AppMethodBeat.m2504i(38176);
                C29220i.this.rhy.cox();
                if (view.getTag() != null) {
                    C34935b c34935b = (C34935b) view.getTag();
                    C29220i.this.rhm.mo25437j(c34935b.position, c34935b.cwT, 1);
                }
                AppMethodBeat.m2505o(38176);
            }
        };
        this.rhA.bIB();
        C4879a.xxA.mo10052c(this.rhC);
        C4879a.xxA.mo10052c(this.rhD);
        AppMethodBeat.m2505o(38188);
    }

    static {
        AppMethodBeat.m2504i(38193);
        AppMethodBeat.m2505o(38193);
    }

    /* Access modifiers changed, original: final */
    public final void crC() {
        AppMethodBeat.m2504i(38189);
        if (this.rht) {
            AppMethodBeat.m2505o(38189);
            return;
        }
        this.rht = true;
        this.rhq.setAfterEditAction(this.rhr.rDS);
        this.rhq.setOnCommentSendImp(new C292164());
        SnsCommentFooter snsCommentFooter = this.rhq;
        C136815 c136815 = new C136815();
        if (snsCommentFooter.oij != null) {
            snsCommentFooter.oij.setBackListener(c136815);
        }
        AppMethodBeat.m2505o(38189);
    }

    /* Access modifiers changed, original: final */
    public final void crD() {
        AppMethodBeat.m2504i(38190);
        if (this.rht) {
            if (this.rhq.getVisibility() != 8) {
                this.rhq.setVisibility(8);
            }
            C46251au c46251au = this.qPr;
            if (c46251au.rxS != null) {
                c46251au.rxS.setVisibility(8);
            }
            c46251au.rxS = null;
            AppMethodBeat.m2505o(38190);
            return;
        }
        AppMethodBeat.m2505o(38190);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo47388c(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(38191);
        int fromDPToPix = C1338a.fromDPToPix(this.context, 8);
        if (baseViewHolder.rHN != null) {
            fromDPToPix += baseViewHolder.rHP.getHeight() - baseViewHolder.rHN.getBottom();
            C4990ab.m7416i("MicroMsg.BaseTimeLine", "comment item bottom = " + baseViewHolder.rHN.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.rhr.position = baseViewHolder.position;
        this.rhr.rDM = baseViewHolder.mRR.getHeight() - fromDPToPix;
        baseViewHolder.rHN = null;
        this.rhr.rDN = baseViewHolder.mRR.getTop();
        this.rhr.rpW = this.nDp.getBottom();
        C4990ab.m7412e("MicroMsg.BaseTimeLine", "originalTop:" + this.rhr.rDN);
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).mController.ymc == 1) {
            this.rhr.cuK();
            AppMethodBeat.m2505o(38191);
            return;
        }
        this.rho = true;
        AppMethodBeat.m2505o(38191);
    }

    /* renamed from: di */
    static int m46395di(String str, int i) {
        AppMethodBeat.m2504i(38192);
        for (C13699k c13699k : rhw) {
            if (C5046bo.isEqual(c13699k.key, str)) {
                i = c13699k.bJt;
                break;
            }
        }
        AppMethodBeat.m2505o(38192);
        return i;
    }
}
