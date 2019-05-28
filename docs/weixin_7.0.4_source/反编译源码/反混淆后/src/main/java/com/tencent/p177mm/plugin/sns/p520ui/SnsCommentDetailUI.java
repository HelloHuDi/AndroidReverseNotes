package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26237rx;
import com.tencent.p177mm.p230g.p231a.C32566gr;
import com.tencent.p177mm.p230g.p231a.C32606oi;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C45363rm;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p230g.p231a.C9453qw;
import com.tencent.p177mm.p230g.p231a.C9459ry;
import com.tencent.p177mm.p230g.p231a.C9461rz;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5240b;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C13357a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.lucky.p1299ui.C29040a;
import com.tencent.p177mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.model.C13428m;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3884ag;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C39761q;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13341f;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13342g;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13348i;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p516g.C31408b;
import com.tencent.p177mm.plugin.sns.p520ui.C4054bc.C4063a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentFooter.C35017b;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentFooter.C3974a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentFooter.C3975c;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13655b;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13658c;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13665d;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C35118a;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAvatarImageView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@C18524i
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI */
public class SnsCommentDetailUI extends MMActivity implements C1202f, C39729a, C43559b {
    public static int rqk = 34;
    private String cFI = "";
    private String cFc;
    private String ecX;
    private C4884c hAA = new C78407();
    private boolean hOT = false;
    private int jCq = 0;
    private C24088a jMO;
    private OnClickListener jNC = new C787937();
    private int klY;
    private int mScreenHeight;
    private int mScreenWidth;
    private ClipboardManager mmO;
    private OnClickListener nij = new C78752();
    private LinearLayout qHj;
    private C44275p rhB = null;
    private C4884c rhD = new C783836();
    private boolean rho;
    private SnsCommentFooter rhq;
    private C22062an rhs;
    private C4045b rhy;
    private C31408b rhz;
    private OnTouchListener riQ = C5046bo.dpE();
    private long rpH = 0;
    private long rpI = 0;
    private View rpJ;
    private TextView rpK;
    private LinearLayout rpL;
    private SnsDetailLuckyHeader rpM;
    private ListView rpN;
    private View rpO;
    private View rpP;
    private C7842b rpQ;
    private ScaleAnimation rpR;
    private ScaleAnimation rpS;
    LinearLayout rpT;
    LinearLayout rpU;
    private LinkedList<cat> rpV;
    private int rpW = -1;
    private boolean rpX = false;
    private C22067aq rpY;
    private String rpZ;
    private C4884c rqA = new C787123();
    private C4884c rqB = new C783734();
    private C7846c rqC = new C7846c();
    private OnClickListener rqD = new C786438();
    private C4884c rqE = new C78586();
    private C4884c rqF = new C78598();
    boolean rqG = false;
    private LinearLayout rqH = null;
    private boolean rqI = false;
    PhotosContent rqJ = null;
    int rqK = 0;
    public C9636a rqL = new C786619();
    private C4052bb rqM = null;
    private C7309bd rqa;
    private int rqb = 0;
    private ImageView rqc;
    private C13698j rqd;
    private boolean rqe = false;
    private long rqf = 0;
    private C4054bc rqg;
    private boolean rqh = false;
    private int rqi;
    private int rqj = 103;
    public int rql = 210;
    private C35118a rqm;
    private C13342g rqn;
    private C22089b rqo;
    private SnsTranslateResultView rqp;
    private boolean rqq = false;
    private Dialog rqr = null;
    private boolean rqs = false;
    private boolean rqt = false;
    private String rqu = "";
    private boolean rqv = true;
    private int rqw;
    private C3884ag rqx = new C3884ag();
    private C4884c rqy = new C78701();
    private C4884c rqz = new C786912();

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$16 */
    class C783416 implements Runnable {
        C783416() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38795);
            SnsCommentDetailUI.this.aqX();
            SnsCommentDetailUI.this.rqC.itemHeight = SnsCommentDetailUI.m13908A(SnsCommentDetailUI.this);
            SnsCommentDetailUI.this.rqC.run();
            AppMethodBeat.m2505o(38795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$33 */
    class C783633 implements AnimationListener {
        C783633() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(38816);
            C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
            if (SnsCommentDetailUI.this.rpO != null) {
                SnsCommentDetailUI.this.rpO.clearAnimation();
                SnsCommentDetailUI.this.rpO.setVisibility(8);
            }
            AppMethodBeat.m2505o(38816);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$34 */
    class C783734 extends C4884c<C9362gs> {
        C783734() {
            AppMethodBeat.m2504i(38817);
            this.xxI = C9362gs.class.getName().hashCode();
            AppMethodBeat.m2505o(38817);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38818);
            C9362gs c9362gs = (C9362gs) c4883b;
            if (c9362gs instanceof C9362gs) {
                SnsCommentDetailUI.m13927a(SnsCommentDetailUI.this, c9362gs.cBr.cBu, c9362gs.cBr.cBt, c9362gs);
            }
            AppMethodBeat.m2505o(38818);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$36 */
    class C783836 extends C4884c<C9453qw> {
        C783836() {
            AppMethodBeat.m2504i(38820);
            this.xxI = C9453qw.class.getName().hashCode();
            AppMethodBeat.m2505o(38820);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38821);
            C9453qw c9453qw = (C9453qw) c4883b;
            if ((c9453qw instanceof C9453qw) && SnsCommentDetailUI.this.rpN != null) {
                boolean z;
                ListView a = SnsCommentDetailUI.this.rpN;
                if (c9453qw.cNc.enable) {
                    z = false;
                } else {
                    z = true;
                }
                a.requestDisallowInterceptTouchEvent(z);
            }
            AppMethodBeat.m2505o(38821);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$5 */
    class C78395 implements OnTouchListener {
        C78395() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(38780);
            if (SnsCommentDetailUI.this.rhy != null) {
                SnsCommentDetailUI.this.rhy.cox();
            }
            AppMethodBeat.m2505o(38780);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$7 */
    class C78407 extends C4884c<C37752ke> {
        C78407() {
            AppMethodBeat.m2504i(38783);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(38783);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38784);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (c37752ke instanceof C37752ke) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsCommentDetailUI.m13958s(SnsCommentDetailUI.this);
                        break;
                }
            }
            AppMethodBeat.m2505o(38784);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$a */
    class C7841a extends C24944o {
        C7841a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38827);
            SnsCommentDetailUI.this.rqg.rDs.onClick(view);
            AppMethodBeat.m2505o(38827);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(38828);
            int color = SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.m2505o(38828);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.m2505o(38828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$b */
    class C7842b extends BaseAdapter {
        Activity activity;
        String cwT;
        public LinkedList<cat> rrj;
        LinkedList<cat> rrk;

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$b$a */
        class C7843a {
            ImageView ejo;
            TextView gKl;
            Object info;
            TextView pnE;
            SnsTranslateResultView rrm;
            cat rrn;
            TextView timeTv;
            String userName;

            C7843a() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$b$1 */
        class C78441 implements Runnable {
            C78441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(38829);
                SnsCommentDetailUI.this.rpN.setSelection((SnsCommentDetailUI.this.rpN.getHeaderViewsCount() + C7842b.this.rrj.size()) - 1);
                AppMethodBeat.m2505o(38829);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$b$2 */
        class C78452 implements OnClickListener {
            C78452() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38830);
                C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                AppMethodBeat.m2505o(38830);
            }
        }

        public C7842b(LinkedList<cat> linkedList, LinkedList<cat> linkedList2, Activity activity, String str) {
            this.rrj = linkedList;
            this.rrk = linkedList2;
            this.activity = activity;
            this.cwT = str;
        }

        public final int getCount() {
            int i = 0;
            AppMethodBeat.m2504i(38831);
            if (this.rrk.size() > 0) {
                if (this.rrj != null) {
                    i = this.rrj.size();
                }
                i++;
                AppMethodBeat.m2505o(38831);
                return i;
            } else if (this.rrj == null) {
                AppMethodBeat.m2505o(38831);
                return 0;
            } else {
                i = this.rrj.size();
                AppMethodBeat.m2505o(38831);
                return i;
            }
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C7843a c7843a;
            CharSequence Oj;
            AppMethodBeat.m2504i(38832);
            if (this.rrk.size() > 0) {
                if (i == 0) {
                    LinearLayout H = SnsCommentDetailUI.this.qHj;
                    AppMethodBeat.m2505o(38832);
                    return H;
                }
                i--;
            }
            cat cat = (cat) this.rrj.get(i);
            if (view == null || !(view.getTag() instanceof C7843a)) {
                view = C5616v.m8409hu(this.activity).inflate(2130970754, null);
                view.setOnTouchListener(SnsCommentDetailUI.this.riQ);
                C7843a c7843a2 = new C7843a();
                c7843a2.ejo = (ImageView) view.findViewById(2131827731);
                c7843a2.ejo.setOnClickListener(SnsCommentDetailUI.this.jNC);
                c7843a2.pnE = (TextView) view.findViewById(2131827733);
                c7843a2.pnE.setOnTouchListener(new C46247aa());
                c7843a2.pnE.setOnClickListener(new C78452());
                c7843a2.timeTv = (TextView) view.findViewById(2131827732);
                c7843a2.gKl = (TextView) view.findViewById(2131827734);
                c7843a2.gKl.setOnTouchListener(new C46247aa());
                c7843a2.rrm = (SnsTranslateResultView) view.findViewById(2131827715);
                c7843a2.rrm.setVisibility(8);
                if (SnsCommentDetailUI.this.klY == 10) {
                    view.findViewById(2131827728).setBackgroundResource(C25738R.drawable.b69);
                    c7843a = c7843a2;
                } else {
                    c7843a = c7843a2;
                }
            } else {
                c7843a = (C7843a) view.getTag();
            }
            c7843a.rrn = cat;
            c7843a.userName = cat.vHl;
            ((SnsAvatarImageView) c7843a.ejo).mo55778dk(cat.vHl, 3);
            ((SnsAvatarImageView) c7843a.ejo).setWeakContext(this.activity);
            int i2 = SnsCommentDetailUI.this.klY == 10 ? 3 : 2;
            SnsCommentDetailUI.this.klY;
            C1720g.m3537RQ();
            C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(c7843a.userName);
            if (i == 0 && this.rrk.isEmpty()) {
                if (SnsCommentDetailUI.this.klY == 10) {
                    view.setBackgroundResource(C25738R.drawable.b6_);
                } else {
                    view.setBackgroundResource(C25738R.drawable.a0x);
                }
            } else if (SnsCommentDetailUI.this.klY == 10) {
                view.setBackgroundResource(C25738R.drawable.a10);
            } else {
                view.setBackgroundResource(C25738R.drawable.a0z);
            }
            if (i == 0) {
                view.findViewById(2131827730).setVisibility(0);
                view.findViewById(2131827729).setVisibility(8);
                if (SnsCommentDetailUI.this.klY == 10) {
                    ((ImageView) view.findViewById(2131827730)).setImageResource(C1318a.friendactivity_writeicon_golden);
                }
            } else {
                view.findViewById(2131827730).setVisibility(4);
                view.findViewById(2131827729).setVisibility(0);
            }
            C40460b.m69439t(c7843a.ejo, cat.vHl);
            c7843a.ejo.setTag(cat.vHl);
            if (aoM != null) {
                Oj = aoM.mo16707Oj();
            } else {
                Object Oj2 = cat.wCW != null ? cat.wCW : cat.vHl;
            }
            C46236n YS = C21990h.m33615YS(SnsCommentDetailUI.this.cFc);
            if (YS != null) {
                c7843a.gKl.setText(cat.ncM + " ");
                CharSequence a = C39851d.m68261a(SnsCommentDetailUI.this, cat, SnsCommentDetailUI.this.rqd, YS.field_type, YS.field_userName, 2);
                c7843a.pnE.setText(Oj2, BufferType.SPANNABLE);
                C44089j.m79307h(c7843a.pnE, i2);
                C44090k c44090k = new C44090k(c7843a.pnE.getText());
                C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "test %s,%s", cat.vHl, Oj2);
                c44090k.mo69792a(new C24944o(cat.vHl, SnsCommentDetailUI.this.rqd, i2), Oj2, 0);
                c7843a.pnE.setText(c44090k, BufferType.SPANNABLE);
                c7843a.timeTv.setText(C29198aw.m46377m(this.activity, ((long) cat.pcX) * 1000));
                c7843a.gKl.setText(a, BufferType.SPANNABLE);
                c7843a.gKl.setVisibility(0);
                SnsCommentDetailUI.this.jMO.mo39887c(view, SnsCommentDetailUI.this.rqo.rJU, SnsCommentDetailUI.this.rqo.rJH);
                SnsCommentDetailUI.this.jMO.mo39887c(c7843a.gKl, SnsCommentDetailUI.this.rqo.rJU, SnsCommentDetailUI.this.rqo.rJH);
                String ga = C13413ap.m21555ga(SnsCommentDetailUI.this.cFc, String.valueOf(cat.wZG != 0 ? (long) cat.wZG : cat.wZJ));
                if (C13413ap.m21551db(ga, 4) && c7843a.rrm != null) {
                    C13414b Ye = C13413ap.m21540Ye(ga);
                    if (Ye != null) {
                        c7843a.rrm.setVisibility(0);
                        if (!Ye.foa) {
                            c7843a.rrm.mo62985El(2);
                        } else if (Ye.aAR) {
                            c7843a.rrm.setVisibility(8);
                        } else {
                            c7843a.rrm.mo62986a(Ye, 2, Ye.result, Ye.fwM, Ye.qMV);
                        }
                    } else {
                        c7843a.rrm.setVisibility(8);
                    }
                }
                view.setClickable(true);
                C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "position " + cat.vHl + " self " + SnsCommentDetailUI.this.ecX + " commentid " + cat.wZG + " snsid " + SnsCommentDetailUI.this.cFc);
                if (SnsCommentDetailUI.this.ecX.equals(cat.vHl)) {
                    c7843a.info = cat;
                } else {
                    c7843a.info = new Object[]{Integer.valueOf(i), cat, cat.vHl, Oj2};
                }
                C46922l c46922l = new C46922l(SnsCommentDetailUI.this.rpZ, SnsCommentDetailUI.this.cFc, cat, cat.vHl, cat.ncM, c7843a.gKl, 2);
                c46922l.tag = c7843a;
                view.setTag(c46922l);
                c7843a.gKl.setTag(c46922l);
                view.setOnClickListener(SnsCommentDetailUI.this.nij);
                c7843a.gKl.setOnClickListener(SnsCommentDetailUI.this.nij);
            }
            AppMethodBeat.m2505o(38832);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$c */
    class C7846c implements Runnable {
        /* renamed from: Ro */
        int f2135Ro = -1;
        int itemHeight;
        private int offset = 0;
        private int rro = -1;
        private int rrp = 10;

        C7846c() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38833);
            this.rrp = 10;
            SnsCommentDetailUI.this.rpX = true;
            this.rro = SnsCommentDetailUI.this.rhq.getTop();
            int i = this.rro - this.itemHeight;
            C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", Integer.valueOf(SnsCommentDetailUI.this.rpN.getBottom()), Integer.valueOf(SnsCommentDetailUI.this.rpW), Integer.valueOf(this.rro), Integer.valueOf(SnsCommentDetailUI.this.rhq.getTop()), Integer.valueOf(i));
            if (i == this.offset) {
                SnsCommentDetailUI.this.rpN.setSelectionFromTop(SnsCommentDetailUI.this.rpN.getHeaderViewsCount() + this.f2135Ro, i);
                this.rrp = 0;
                this.offset = 0;
                AppMethodBeat.m2505o(38833);
                return;
            }
            int i2 = this.rrp;
            this.rrp = i2 - 1;
            if (i2 > 0) {
                new C7306ak().postDelayed(this, 100);
                this.offset = i;
                AppMethodBeat.m2505o(38833);
                return;
            }
            this.offset = 0;
            this.rrp = 0;
            AppMethodBeat.m2505o(38833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$14 */
    class C784714 implements C3975c {
        C784714() {
        }

        public final void onShow() {
            AppMethodBeat.m2504i(38793);
            if (SnsCommentDetailUI.this.rhq.rrw) {
                AppMethodBeat.m2505o(38793);
                return;
            }
            SnsCommentDetailUI.m13965z(SnsCommentDetailUI.this);
            AppMethodBeat.m2505o(38793);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$28 */
    class C784928 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$28$1 */
        class C78501 implements DialogInterface.OnClickListener {
            C78501() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(38810);
                C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.this.rpZ);
                C46236n YT = C21990h.m33616YT(SnsCommentDetailUI.this.rpZ);
                if (YT == null) {
                    C4990ab.m7413e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", SnsCommentDetailUI.this.rpZ);
                    AppMethodBeat.m2505o(38810);
                } else if (YT.mo74253DI(32)) {
                    AppMethodBeat.m2505o(38810);
                } else {
                    if (YT.field_snsId == 0) {
                        C13373af.cnF().mo62915DL(YT.reX);
                    } else {
                        C13373af.cnE().mo37410km(YT.field_snsId);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C46224r(YT.field_snsId, 1), 0);
                        C13373af.cnF().delete(YT.field_snsId);
                        C13373af.cnK().mo47208ky(YT.field_snsId);
                        C21991i.m33620kx(YT.field_snsId);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("sns_gallery_op_id", C35002v.m57484Zn(SnsCommentDetailUI.this.rpZ));
                    SnsCommentDetailUI.this.setResult(-1, intent);
                    if (SnsCommentDetailUI.this.hOT && !YT.isValid()) {
                        intent.putExtra("sns_gallery_force_finish", true);
                    }
                    TimeLineObject cqu = YT.cqu();
                    if (cqu != null) {
                        String str = cqu.xfH == null ? null : cqu.xfH.f17242Id;
                        if (!C5046bo.isNullOrNil(str) && C24826a.gkF.mo38866dk(str)) {
                            String df = C24826a.gkF.mo38864df(str);
                            C32606oi c32606oi = new C32606oi();
                            c32606oi.cKD.appId = str;
                            c32606oi.cKD.cKE = cqu.jBB;
                            c32606oi.cKD.ceO = df;
                            C4879a.xxA.mo10055m(c32606oi);
                        }
                    }
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.m2505o(38810);
                }
            }
        }

        C784928() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38811);
            C30379h.m48432a(SnsCommentDetailUI.this, (int) C25738R.string.epn, (int) C25738R.string.f9238tz, new C78501(), null);
            AppMethodBeat.m2505o(38811);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$29 */
    class C785129 implements OnClickListener {
        C785129() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38812);
            try {
                int intValue = ((Integer) view.getTag()).intValue();
                Intent intent = new Intent();
                intent.putExtra("sns_label_sns_info", intValue);
                C24826a.gkE.mo38936u(intent, SnsCommentDetailUI.this);
                AppMethodBeat.m2505o(38812);
            } catch (Exception e) {
                AppMethodBeat.m2505o(38812);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$17 */
    class C785517 implements OnClickListener {
        C785517() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38796);
            C4978c.m7375a(SnsCommentDetailUI.this.rpN);
            AppMethodBeat.m2505o(38796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$35 */
    class C785735 implements AnimationListener {
        boolean rrc = false;
        final /* synthetic */ LinearLayout rrd;

        C785735(LinearLayout linearLayout) {
            this.rrd = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(38819);
            if (this.rrd != null) {
                this.rrd.setPressed(false);
            }
            if (!this.rrc) {
                this.rrc = true;
                if (SnsCommentDetailUI.this.rpO != null) {
                    SnsCommentDetailUI.this.rpO.clearAnimation();
                    SnsCommentDetailUI.this.rpO.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(38819);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$6 */
    class C78586 extends C4884c<C45363rm> {
        C78586() {
            AppMethodBeat.m2504i(38781);
            this.xxI = C45363rm.class.getName().hashCode();
            AppMethodBeat.m2505o(38781);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38782);
            SnsCommentDetailUI.this.csX();
            AppMethodBeat.m2505o(38782);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$8 */
    class C78598 extends C4884c<C32566gr> {
        C78598() {
            AppMethodBeat.m2504i(38785);
            this.xxI = C32566gr.class.getName().hashCode();
            AppMethodBeat.m2505o(38785);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$18 */
    class C786218 implements OnMenuItemClickListener {
        C786218() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38797);
            if (SnsCommentDetailUI.this.rhq != null) {
                SnsCommentDetailUI.this.rhq.mo55636lj(false);
            }
            SnsCommentDetailUI.this.finish();
            AppMethodBeat.m2505o(38797);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$38 */
    class C786438 implements OnClickListener {
        C786438() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38823);
            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.m13944g(SnsCommentDetailUI.this);
            if (SnsCommentDetailUI.this.rpX) {
                SnsCommentDetailUI.m13946i(SnsCommentDetailUI.this);
                AppMethodBeat.m2505o(38823);
                return;
            }
            AppMethodBeat.m2505o(38823);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$19 */
    class C786619 implements C9636a {
        C786619() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, final boolean z) {
            AppMethodBeat.m2504i(38799);
            new C7306ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38798);
                    if (z && !SnsCommentDetailUI.this.isFinishing() && SnsCommentDetailUI.this.rqK < 5) {
                        SnsCommentDetailUI.this.csX();
                    }
                    SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                    snsCommentDetailUI.rqK++;
                    AppMethodBeat.m2505o(38798);
                }
            }, 500);
            AppMethodBeat.m2505o(38799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$10 */
    class C786710 implements Runnable {
        C786710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38787);
            SnsCommentDetailUI.this.rpW = SnsCommentDetailUI.this.rpN.getBottom();
            C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.this.rpW);
            AppMethodBeat.m2505o(38787);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$11 */
    class C786811 implements OnScrollListener {
        C786811() {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38788);
            if (i2 > 0) {
                if (i == 0 && !SnsCommentDetailUI.this.rqv) {
                    SnsCommentDetailUI.this.rqv = true;
                    if (SnsCommentDetailUI.this.rqm != null) {
                        SnsCommentDetailUI.this.rqm.refreshView();
                        AppMethodBeat.m2505o(38788);
                        return;
                    } else if (SnsCommentDetailUI.this.rpJ != null) {
                        SnsCommentDetailUI.this.csX();
                        AppMethodBeat.m2505o(38788);
                        return;
                    }
                } else if (i > 0) {
                    SnsCommentDetailUI.this.rqv = false;
                }
            }
            AppMethodBeat.m2505o(38788);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(38789);
            if (i == 1) {
                SnsCommentDetailUI.this.aqX();
                SnsCommentDetailUI.m13963x(SnsCommentDetailUI.this);
            }
            if (i == 0 && SnsCommentDetailUI.this.rqn != null) {
                SnsCommentDetailUI.this.rqn.mo25442kH(true);
            }
            AppMethodBeat.m2505o(38789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$12 */
    class C786912 extends C4884c<C9459ry> {
        C786912() {
            AppMethodBeat.m2504i(38790);
            this.xxI = C9459ry.class.getName().hashCode();
            AppMethodBeat.m2505o(38790);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38791);
            C9459ry c9459ry = (C9459ry) c4883b;
            if (c9459ry instanceof C9459ry) {
                String str = c9459ry.cNT.f2863id;
                if (c9459ry.cNT.type == 1) {
                    SnsCommentDetailUI.m13932b(SnsCommentDetailUI.this, str);
                } else if (c9459ry.cNT.type == 2) {
                    SnsCommentDetailUI.m13935c(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.m2505o(38791);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$1 */
    class C78701 extends C4884c<C26237rx> {
        C78701() {
            AppMethodBeat.m2504i(38772);
            this.xxI = C26237rx.class.getName().hashCode();
            AppMethodBeat.m2505o(38772);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38773);
            C26237rx c26237rx = (C26237rx) c4883b;
            if (c26237rx instanceof C26237rx) {
                String str = c26237rx.cNR.f13666id;
                String str2 = c26237rx.cNR.result;
                String str3 = c26237rx.cNR.cNS;
                if (c26237rx.cNR.type == 1) {
                    SnsCommentDetailUI.m13930a(SnsCommentDetailUI.this, str, str2, str3);
                } else if (c26237rx.cNR.type == 2) {
                    SnsCommentDetailUI.m13929a(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.m2505o(38773);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$23 */
    class C787123 extends C4884c<C9461rz> {
        C787123() {
            AppMethodBeat.m2504i(38804);
            this.xxI = C9461rz.class.getName().hashCode();
            AppMethodBeat.m2505o(38804);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38805);
            C9461rz c9461rz = (C9461rz) c4883b;
            if (c9461rz instanceof C9461rz) {
                String str = c9461rz.cNU.f2864id;
                if (c9461rz.cNU.type == 1) {
                    SnsCommentDetailUI.m13937d(SnsCommentDetailUI.this, str);
                } else if (c9461rz.cNU.type == 2) {
                    SnsCommentDetailUI.m13939e(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.m2505o(38805);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$2 */
    class C78752 implements OnClickListener {
        C78752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38774);
            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.m13928a(SnsCommentDetailUI.this, view);
            AppMethodBeat.m2505o(38774);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$26 */
    class C787726 implements Runnable {
        C787726() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38808);
            SnsCommentDetailUI.this.rqn.mo25442kH(false);
            AppMethodBeat.m2505o(38808);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$37 */
    class C787937 implements OnClickListener {
        C787937() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38822);
            String str = (String) view.getTag();
            C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
            Intent intent = new Intent();
            C46236n e = SnsCommentDetailUI.m13938e(SnsCommentDetailUI.this);
            if (e == null || !e.mo74253DI(32)) {
                intent.putExtra("Contact_User", str);
                C24826a.gkE.mo38912c(intent, SnsCommentDetailUI.this);
                AppMethodBeat.m2505o(38822);
                return;
            }
            C29036i.m46098a(new SnsAdClick(SnsCommentDetailUI.m13941f(SnsCommentDetailUI.this), 2, e.field_snsId, 1, 0));
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            C24826a.gkE.mo38912c(intent, SnsCommentDetailUI.this);
            AppMethodBeat.m2505o(38822);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$4 */
    class C78804 implements C4063a {
        C78804() {
        }

        public final void ctb() {
            AppMethodBeat.m2504i(38779);
            SnsCommentDetailUI.m13958s(SnsCommentDetailUI.this);
            AppMethodBeat.m2505o(38779);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsCommentDetailUI() {
        AppMethodBeat.m2504i(38834);
        AppMethodBeat.m2505o(38834);
    }

    /* renamed from: A */
    static /* synthetic */ int m13908A(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38871);
        int csV = snsCommentDetailUI.csV();
        AppMethodBeat.m2505o(38871);
        return csV;
    }

    /* renamed from: e */
    static /* synthetic */ C46236n m13938e(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38863);
        C46236n li = snsCommentDetailUI.m13951li(true);
        AppMethodBeat.m2505o(38863);
        return li;
    }

    /* renamed from: g */
    static /* synthetic */ void m13944g(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38865);
        snsCommentDetailUI.csY();
        AppMethodBeat.m2505o(38865);
    }

    /* renamed from: s */
    static /* synthetic */ void m13958s(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38868);
        snsCommentDetailUI.cta();
        AppMethodBeat.m2505o(38868);
    }

    /* renamed from: f */
    private static boolean m13943f(LinkedList<cat> linkedList, LinkedList<cat> linkedList2) {
        AppMethodBeat.m2504i(38835);
        if (linkedList == null || linkedList2 == null) {
            AppMethodBeat.m2505o(38835);
            return false;
        } else if (linkedList.size() != linkedList2.size()) {
            AppMethodBeat.m2505o(38835);
            return false;
        } else {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                if (((cat) linkedList.get(i)).vHl.equals(((cat) linkedList2.get(i)).vHl)) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(38835);
                    return false;
                }
            }
            AppMethodBeat.m2505o(38835);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    /* renamed from: lh */
    private void m13950lh(boolean z) {
        AppMethodBeat.m2504i(38836);
        this.rpX = false;
        if (this.rhq.ctd()) {
            this.rhq.rrt = 0;
            this.rhq.ctg();
            this.rhq.setCommentHint(getString(C25738R.string.eq9));
        }
        this.rhq.mo55636lj(false);
        if (z) {
            C4978c.m7375a(this.rpN);
        }
        AppMethodBeat.m2505o(38836);
    }

    /* renamed from: li */
    private C46236n m13951li(boolean z) {
        C46236n YS;
        AppMethodBeat.m2504i(38837);
        if (C5046bo.isNullOrNil(this.rpZ)) {
            YS = C21990h.m33615YS(this.cFc);
            if (YS == null) {
                finish();
                AppMethodBeat.m2505o(38837);
                return null;
            }
            this.rpZ = YS.cqU();
        } else {
            YS = C21990h.m33616YT(this.rpZ);
            if (YS == null) {
                if (z) {
                    Toast.makeText(this, C25738R.string.emz, 0).show();
                }
                finish();
                AppMethodBeat.m2505o(38837);
                return null;
            }
            this.cFc = YS.cqA();
        }
        AppMethodBeat.m2505o(38837);
        return YS;
    }

    private int getSource() {
        if (this.rqw == 16) {
            return 2;
        }
        return 1;
    }

    /* renamed from: f */
    private C21980a m13942f(C46236n c46236n) {
        AppMethodBeat.m2504i(38838);
        C21980a cqr;
        if (c46236n == null) {
            AppMethodBeat.m2505o(38838);
            return null;
        } else if (getSource() == 2) {
            cqr = c46236n.cqr();
            AppMethodBeat.m2505o(38838);
            return cqr;
        } else {
            cqr = c46236n.cqq();
            AppMethodBeat.m2505o(38838);
            return cqr;
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(38839);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        C5240b.m8009c(this, true);
        C13373af.cnv().mo8617a(5, "@__weixintimtline", this);
        this.mmO = (ClipboardManager) getApplicationContext().getSystemService("clipboard");
        Point hy = C5222ae.m7953hy(this);
        this.mScreenWidth = hy.x;
        this.mScreenHeight = hy.y;
        this.rpH = System.currentTimeMillis();
        this.jMO = new C24088a(this);
        this.rqw = getIntent().getIntExtra("INTENT_COMMENT_TYPE", 0);
        this.cFc = C5046bo.m7532bc(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (C5046bo.isNullOrNil(this.cFc)) {
            this.cFc = C35002v.m57489ao("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.rpZ = C5046bo.m7532bc(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (C5046bo.isNullOrNil(this.rpZ)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.rpZ = C35002v.m57489ao("sns_table_", (long) intExtra);
            }
        }
        this.rqo = new C22089b(getSource(), this, this.rqx) {
            /* renamed from: b */
            public final void mo17688b(View view, int i, int i2, int i3) {
            }

            /* renamed from: cp */
            public final void mo17689cp(Object obj) {
                AppMethodBeat.m2504i(38775);
                SnsCommentDetailUI.m13944g(SnsCommentDetailUI.this);
                SnsCommentDetailUI.this.rhs.mo37617t((View) obj, 2, SnsCommentDetailUI.m13941f(SnsCommentDetailUI.this));
                AppMethodBeat.m2505o(38775);
            }

            public final void crE() {
            }

            /* renamed from: dJ */
            public final void mo17695dJ(View view) {
            }

            /* renamed from: dI */
            public final void mo17694dI(View view) {
            }

            /* renamed from: dG */
            public final void mo17692dG(View view) {
            }

            /* renamed from: dH */
            public final void mo17693dH(View view) {
            }

            /* renamed from: dK */
            public final void mo17696dK(View view) {
                AppMethodBeat.m2504i(38776);
                SnsCommentDetailUI.this.rhy.mo8900dF(view);
                AppMethodBeat.m2505o(38776);
            }

            public final void crF() {
                AppMethodBeat.m2504i(38777);
                SnsCommentDetailUI.this.rhy.crv();
                AppMethodBeat.m2505o(38777);
            }

            /* renamed from: dL */
            public final void mo17697dL(View view) {
                AppMethodBeat.m2504i(38778);
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                SnsCommentDetailUI.this.setResult(-1, intent);
                if (!(view.getTag() == null || SnsCommentDetailUI.this.rqn == null)) {
                    C34935b c34935b = (C34935b) view.getTag();
                    SnsCommentDetailUI.this.rqn.mo25437j(c34935b.position, c34935b.cwT, 2);
                }
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.m2505o(38778);
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(2131822759);
        this.rhz = new C31408b(this, this.rqo, frameLayout);
        this.rhy = new C4045b(this, this.rqo, frameLayout, this.rhz);
        this.rqo.bIB();
        this.rqt = getIntent().getBooleanExtra("intent_show_collapse_info", false);
        this.rqu = getIntent().getStringExtra("intent_content_collapse_hint");
        this.rqg = new C4054bc(this, new C78804(), getSource(), this.rqx);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            TimeLineObject timeLineObject = new TimeLineObject();
            try {
                timeLineObject.parseFrom(byteArrayExtra);
                if (C13373af.cnF().mo62941kD(new BigInteger(timeLineObject.f15074Id).longValue()) == null) {
                    C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    C46236n c46236n = new C46236n();
                    c46236n.field_snsId = new BigInteger(timeLineObject.f15074Id).longValue();
                    try {
                        c46236n.field_content = timeLineObject.toByteArray();
                    } catch (Exception e) {
                    }
                    c46236n.field_createTime = timeLineObject.pcX;
                    c46236n.field_userName = timeLineObject.jBB;
                    c46236n.field_type = timeLineObject.xfI.wbJ;
                    c46236n.cqR();
                    cbf cbf = new cbf();
                    cbf.xam = new SKBuiltinBuffer_t();
                    try {
                        c46236n.field_attrBuf = cbf.toByteArray();
                    } catch (IOException e2) {
                    }
                    C13373af.cnF().mo10101b((C4925c) c46236n);
                    C4990ab.m7417i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        C46236n li = m13951li(true);
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.cFc + " localSnsId: " + this.rpZ);
        if (li != null) {
            C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", C5046bo.m7532bc(li.field_userName, ""));
        }
        if (C35002v.m57485Zo(this.cFc)) {
            if (!C35002v.m57481WT(this.cFc)) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C13428m(C35002v.m57483Zm(this.cFc), 0, m13942f(li).qTU), 0);
            } else if (li == null) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C39761q(C35002v.m57483Zm(this.cFc)), 0);
            } else if (!C1855t.m3911mX(li.field_userName)) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C39761q(C35002v.m57483Zm(this.cFc)), 0);
            }
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(210, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(218, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(213, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(682, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(214, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(683, (C1202f) this);
        this.rqa = C13373af.cnt();
        this.rhs = new C22062an(this);
        this.rpY = new C22067aq(this.mController.ylL);
        this.rqd = new C13698j(this, getSource(), this.rqx);
        if (li != null) {
            this.klY = C46251au.m86607b(li, false);
        }
        if (li != null && li.mo74253DI(32)) {
            if (this.rqw == 16) {
                this.rqn = new C13342g(2);
            } else {
                this.rqn = new C13342g(1);
            }
            this.rqn.mo25430a(this.mScreenHeight, getSupportActionBar().getCustomView(), this);
            C46251au.m86607b(li, false);
        }
        initView();
        if (li != null && li.mo74253DI(32)) {
            this.rqn.mo25431a(0, li.cqU(), li.cqQ(), this.rpJ, li.field_snsId, C34955aj.m57408p(li), this.klY, 2);
        }
        if (!(this.rpJ == null || li == null)) {
            C34915a c34915a = (C34915a) this.rpJ.findViewById(2131820629);
            if (li.cqu().xfI != null && li.cqu().xfI.wbJ == 15 && (c34915a instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) c34915a).qyA.cla();
            }
            C34927j.m57344a(li, true, z, getSource());
        }
        if (this.rpN == null) {
            AppMethodBeat.m2505o(38839);
            return;
        }
        this.rpN.setOnTouchListener(new C78395());
        C4879a.xxA.mo10052c(this.hAA);
        C4879a.xxA.mo10052c(this.rqy);
        C4879a.xxA.mo10052c(this.rqz);
        C4879a.xxA.mo10052c(this.rqA);
        C4879a.xxA.mo10052c(this.rqB);
        C4879a.xxA.mo10052c(this.rqE);
        C4879a.xxA.mo10052c(this.rqF);
        C4879a.xxA.mo10052c(this.rhD);
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(38839);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38840);
        C13373af.cnv().mo8619a(this, 5);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(210, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(218, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(213, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(214, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(683, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(682, (C1202f) this);
        C13373af.cnC().mo37452ab(this);
        C4879a.xxA.mo10053d(this.hAA);
        if (this.rqd != null) {
            this.rqd.activity = null;
        }
        C46247aa.crX();
        if (this.rhq != null) {
            this.rhq.bMO();
        }
        C46236n li = m13951li(false);
        if (li != null && li.mo74253DI(32)) {
            if (this.rqn != null) {
                this.rqn.mo25437j(0, li.cqU(), 2);
            }
            C21980a f = m13942f(li);
            String str = f == null ? "" : f.qPj;
            C13348i cnz;
            Object[] objArr;
            if (li.coX()) {
                cnz = C13373af.cnz();
                objArr = new Object[1];
                objArr[0] = C13341f.m21438a(li.field_snsId, C29036i.m46117jV(li.field_snsId), str, Long.valueOf(this.rpH), Long.valueOf(System.currentTimeMillis()));
                cnz.mo25454e(14652, objArr);
            } else {
                cnz = C13373af.cnz();
                objArr = new Object[1];
                objArr[0] = C13341f.m21438a(li.field_snsId, C29036i.m46117jV(li.field_snsId), str, Long.valueOf(this.rpH), Long.valueOf(System.currentTimeMillis()));
                cnz.mo25454e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT, objArr);
            }
            C37952b lZ = C37952b.m64171lZ(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            lZ.mo60722tx(C29036i.m46117jV(li.field_snsId)).mo60722tx(str).mo60722tx(this.rpH).mo60722tx(System.currentTimeMillis());
            lZ.ajK();
        }
        this.rqo.removeListener();
        C4879a.xxA.mo10053d(this.rqy);
        C4879a.xxA.mo10053d(this.rqz);
        C4879a.xxA.mo10053d(this.rqA);
        C4879a.xxA.mo10053d(this.rqB);
        C4879a.xxA.mo10053d(this.rqE);
        C4879a.xxA.mo10053d(this.rqF);
        C4879a.xxA.mo10053d(this.rhD);
        super.onDestroy();
        AppMethodBeat.m2505o(38840);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38841);
        C13373af.cnA().mo69136a((C43559b) this);
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.cPJ = 0;
        c6550tn.cPI.cPK = 1;
        c6550tn.cPI.cPL = 0;
        c6550tn.cPI.type = 0;
        C4879a.xxA.mo10055m(c6550tn);
        if (this.rqn != null) {
            this.rqn.onResume();
        }
        if (this.rqm != null) {
            this.rqm.refreshView();
        }
        super.onResume();
        AppMethodBeat.m2505o(38841);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38842);
        C13373af.cnA().mo69142b((C43559b) this);
        super.onPause();
        this.rhq.eAk.onPause();
        new C6550tn().cPI.type = 1;
        if (this.rqn != null) {
            this.rqn.onPause();
        }
        AppMethodBeat.m2505o(38842);
    }

    public final int getLayoutId() {
        return 2130970752;
    }

    public final void initView() {
        AppMethodBeat.m2504i(38843);
        setMMTitle((int) C25738R.string.ek2);
        C785517 c785517 = new C785517();
        setBackBtn(new C786218());
        this.ecX = C1853r.m3846Yz();
        if (C13373af.cnn()) {
            finish();
        }
        final C46236n li = m13951li(true);
        if (li == null) {
            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.cFc);
            finish();
            AppMethodBeat.m2505o(38843);
            return;
        }
        boolean z;
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.cFc + "localId " + this.rpZ + "  username:" + li.field_userName);
        TextView textView = (TextView) findViewById(2131827703);
        if (this.rqt) {
            textView.setVisibility(0);
            textView.setText(this.rqu);
        } else {
            textView.setVisibility(8);
        }
        if (!C35002v.m57485Zo(this.cFc) && li.cqW()) {
            bav cqM = li.cqM();
            findViewById(2131827704).setVisibility(0);
            textView = (TextView) findViewById(2131827705);
            switch (cqM.wFm) {
                case 201:
                    if (C5046bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(C25738R.string.enn);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(2131827706).setVisibility(8);
                    z = false;
                    break;
                case 210:
                    if (C5046bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(C25738R.string.enp);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(2131827706).setVisibility(8);
                    z = false;
                    break;
                case 211:
                    if (C5046bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(C25738R.string.eno);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(2131827706).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (C5046bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(C25738R.string.enq);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(2131827706).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(2131827704).setVisibility(8);
        z = false;
        if (z) {
            findViewById(2131827704).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(38786);
                    if (li.mo74253DI(32)) {
                        AppMethodBeat.m2505o(38786);
                        return;
                    }
                    C34955aj.m57388Da(li.reX);
                    C34955aj.m57386CY(li.reX);
                    C13373af.cnB().cmp();
                    Intent intent = new Intent();
                    SnsCommentDetailUI.this.setResult(-1, intent);
                    if (SnsCommentDetailUI.this.hOT) {
                        intent.putExtra("sns_gallery_force_finish", true);
                    }
                    SnsCommentDetailUI.this.finish();
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.m2505o(38786);
                }
            });
        }
        this.rpN = (ListView) findViewById(2131827707);
        this.rpN.post(new C786710());
        this.rpN.setOnScrollListener(new C786811());
        this.rpJ = C5616v.m8409hu(this.mController.ylL).inflate(2130970753, null);
        this.rpP = this.rpJ.findViewById(2131827716);
        this.rpJ.setOnClickListener(this.rqD);
        this.rpN.addHeaderView(this.rpJ);
        z = csX();
        if (z) {
            C46236n li2 = m13951li(false);
            if (li2 != null) {
                this.klY = C46251au.m86607b(li2, false);
            }
            if (this.klY == 10 && C1853r.m3846Yz().equals(li.field_userName)) {
                this.rpM = new SnsDetailLuckyHeader(this);
                this.rpM.setLayoutParams(new LayoutParams(-1, -2));
                this.rpM.setOnClickListener(this.rqD);
            }
            this.rpL = new LinearLayout(this.mController.ylL);
            this.rpL.setLayoutParams(new LayoutParams(-1, -2));
            this.rpL.setOnClickListener(this.rqD);
            C4977b.m7371b((Context) this, 2.0f);
            LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.mController.ylL);
            linearLayout.setBackgroundResource(C25738R.drawable.a13);
            linearLayout.setLayoutParams(layoutParams);
            this.qHj = linearLayout;
            if ((li.field_localPrivate & 1) != 0) {
                findViewById(2131822763).setVisibility(8);
                textView = new TextView(this);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setText(getString(C25738R.string.ek9));
                textView.setTextColor(getResources().getColor(C25738R.color.f11782h4));
                textView.setGravity(17);
                textView.setPadding(0, C4977b.m7371b((Context) this, 7.0f), 0, 0);
                this.rpN.addFooterView(textView);
            }
            if (this.rpM != null) {
                this.rqq = true;
                this.rpN.addHeaderView(this.rpM);
            }
            cbf p = C34955aj.m57408p(li);
            if (p == null) {
                this.rpL.setVisibility(8);
                this.rpQ = new C7842b(new LinkedList(), new LinkedList(), this, li.cqU());
            } else {
                this.rpV = p.xaq;
                m13940e(p.xaq, p.xat.isEmpty());
                if (this.rpM != null) {
                    this.rpM.mo8593a(li, this.rqo);
                }
                this.rpQ = new C7842b(p.xat, p.xaq, this, li.cqU());
            }
            this.rpN.addHeaderView(this.rpL);
            this.rpN.setAdapter(this.rpQ);
            this.rhq = (SnsCommentFooter) findViewById(2131822763);
            this.rhq.setOnEditTouchListener(new C3974a() {
                public final void ctc() {
                    AppMethodBeat.m2504i(38792);
                    if (C39742m.m67967Xx(li.cqU())) {
                        if (SnsCommentDetailUI.this.mController.ymc == 1 || SnsCommentDetailUI.this.rhq.cte()) {
                            AppMethodBeat.m2505o(38792);
                            return;
                        }
                        SnsCommentDetailUI.m13965z(SnsCommentDetailUI.this);
                        AppMethodBeat.m2505o(38792);
                    } else if (SnsCommentDetailUI.this.rqr == null || !SnsCommentDetailUI.this.rqr.isShowing()) {
                        SnsCommentDetailUI.this.rqr = C29040a.m46131f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.mo8755DT(0));
                        AppMethodBeat.m2505o(38792);
                    } else {
                        AppMethodBeat.m2505o(38792);
                    }
                }
            });
            this.rhq.setOnSmileyShowListener(new C784714());
            li2 = m13951li(true);
            if (!(li2 == null || li2.cqT())) {
                this.rhq.setVisibility(8);
            }
            this.rhq.setAfterEditAction(this.rqC);
            this.rhq.ctf();
            this.rhq.setOnCommentSendImp(new C35017b() {
                /* renamed from: Zr */
                public final void mo8842Zr(String str) {
                    int i = 8;
                    AppMethodBeat.m2504i(38794);
                    if (C39742m.m67967Xx(li.cqU())) {
                        int commentFlag;
                        if (li.mo74253DI(32)) {
                            commentFlag = SnsCommentDetailUI.this.rhq.getCommentFlag();
                        } else {
                            commentFlag = 0;
                        }
                        if (C39851d.m68264fF(commentFlag, 8)) {
                            String substring = str.substring(SnsCommentDetailUI.this.rhq.getCommentAtPrefix().length());
                            C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
                            C3890a.m6183a(li, 16, substring, SnsCommentDetailUI.this.rhq.getCommentInfo(), commentFlag, SnsCommentDetailUI.m13941f(SnsCommentDetailUI.this));
                        } else {
                            C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "send detail comment");
                            C46236n c46236n = li;
                            if (!li.mo74253DI(32)) {
                                i = 2;
                            }
                            C3890a.m6183a(c46236n, i, str, SnsCommentDetailUI.this.rhq.getCommentInfo(), commentFlag, SnsCommentDetailUI.m13941f(SnsCommentDetailUI.this));
                        }
                        SnsCommentDetailUI.this.rhq.setText("");
                        SnsCommentDetailUI.this.rhq.mo55636lj(false);
                        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                        SnsCommentDetailUI.m13963x(SnsCommentDetailUI.this);
                        AppMethodBeat.m2505o(38794);
                        return;
                    }
                    if (SnsCommentDetailUI.this.rqJ.mo8755DT(0) != null) {
                        C29040a.m46131f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.mo8755DT(0));
                    }
                    AppMethodBeat.m2505o(38794);
                }
            });
            this.rqe = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.rqe) {
                this.rqf = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.rqf == 0 || this.rpQ.rrj == null)) {
                    int i = 0;
                    while (i < this.rpQ.rrj.size()) {
                        cat cat = (cat) this.rpQ.rrj.get(i);
                        if ((cat.wZG != 0 ? (long) cat.wZG : cat.wZJ) == this.rqf) {
                            int i2;
                            this.rpN.setSelection(i);
                            C7616ad aoO = this.rqa.aoO(cat.vHl);
                            String Oj = aoO != null ? aoO.mo16707Oj() : cat.wCW != null ? cat.wCW : cat.vHl;
                            this.rhq.rrt = 0;
                            this.rhq.ctg();
                            this.rhq.setCommentHint(getString(C25738R.string.env) + Oj);
                            this.rhq.setCommentInfo(cat);
                            if (p.xaq.size() > 0) {
                                i2 = i + 1;
                                if (i2 > this.rpQ.getCount()) {
                                    i2 = this.rpQ.getCount() - 1;
                                }
                            } else {
                                i2 = i;
                            }
                            this.rqC.f2135Ro = i2;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (this.rqe) {
                new C7306ak().postDelayed(new C783416(), 100);
            }
            this.rqp = (SnsTranslateResultView) this.rpJ.findViewById(2131827715);
            this.rqp.setResultTextSize(((TextView) this.rpJ.findViewById(2131820991)).getTextSize());
            this.rqp.getResultTextView().setBackgroundResource(C25738R.drawable.a0t);
            this.rqp.getResultTextView().setTag(new C39828ar(this.cFc, li.cqU(), false, true, 2));
            this.jMO.mo39887c(this.rqp.getResultTextView(), this.rqo.rJK, this.rqo.rJH);
            if (C13413ap.m21551db(this.cFc, 4)) {
                C13414b Ye = C13413ap.m21540Ye(this.cFc);
                if (Ye == null || !Ye.foa) {
                    this.rqp.setVisibility(8);
                    AppMethodBeat.m2505o(38843);
                    return;
                }
                this.rqp.setVisibility(0);
                this.rqp.mo62986a(null, 1, Ye.result, Ye.fwM, false);
                AppMethodBeat.m2505o(38843);
                return;
            }
            this.rqp.setVisibility(8);
            AppMethodBeat.m2505o(38843);
            return;
        }
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(z)));
        finish();
        AppMethodBeat.m2505o(38843);
    }

    private int csV() {
        AppMethodBeat.m2504i(38844);
        if (this.rpN != null && this.rpN.getChildCount() > 1) {
            View childAt = this.rpN.getChildAt(0);
            if (childAt != null) {
                int height = childAt.getHeight();
                AppMethodBeat.m2505o(38844);
                return height;
            }
        }
        AppMethodBeat.m2505o(38844);
        return 0;
    }

    /* renamed from: DV */
    private LinearLayout m13912DV(int i) {
        AppMethodBeat.m2504i(38845);
        LinearLayout linearLayout;
        if (this.rqH == null) {
            this.rqH = (LinearLayout) C5616v.m8409hu(this).inflate(i, null);
            linearLayout = this.rqH;
            AppMethodBeat.m2505o(38845);
            return linearLayout;
        }
        this.rqG = true;
        linearLayout = this.rqH;
        AppMethodBeat.m2505o(38845);
        return linearLayout;
    }

    private static boolean csW() {
        AppMethodBeat.m2504i(38846);
        if ((C3890a.coe() & 1) <= 0) {
            AppMethodBeat.m2505o(38846);
            return true;
        }
        AppMethodBeat.m2505o(38846);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0d33  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0d8b  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0f30  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0dca  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0e05  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x1653  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x05ca  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x067d  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x073b  */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x1824  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0753  */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x182b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x07d0  */
    /* JADX WARNING: Removed duplicated region for block: B:496:0x1832  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0814  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x085b  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0934  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean csX() {
        AppMethodBeat.m2504i(38847);
        final C46236n li = m13951li(true);
        if (li == null) {
            AppMethodBeat.m2505o(38847);
            return false;
        }
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "setheader " + this.rpJ.toString());
        this.rqi = C13373af.cnN();
        TimeLineObject cqu = li.cqu();
        this.klY = C46251au.m86607b(li, false);
        final SnsAvatarImageView snsAvatarImageView = (SnsAvatarImageView) this.rpJ.findViewById(2131827708);
        if (snsAvatarImageView == null || li == null) {
            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (snsAvatarImageView == null) + " " + (li == null));
            AppMethodBeat.m2505o(38847);
            return false;
        }
        CharSequence charSequence;
        Object charSequence2;
        int i;
        C44090k c44090k;
        String str;
        ViewStub viewStub;
        int width;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        final C7616ad c7616ad;
        cbf p;
        ImageButton imageButton;
        C46236n li2;
        final ImageView imageView;
        final ImageView imageView2;
        final TextView textView;
        final TextView textView2;
        final C46236n c46236n;
        snsAvatarImageView.setWeakContext(this);
        snsAvatarImageView.eSe = li.cqU();
        snsAvatarImageView.setTag(li.getUserName());
        if (li.cqo() == null || !li.cqo().qVa) {
            if (!li.getUserName().endsWith("@ad")) {
                C40460b.m69439t(snsAvatarImageView, li.getUserName());
                snsAvatarImageView.mo55778dk(li.getUserName(), 2);
                C5046bo.isEqual(this.ecX, li.getUserName());
            }
        } else if (!C5046bo.isNullOrNil(li.cqo().qVc)) {
            snsAvatarImageView.setTag(2131820666, li.cqo().qVc);
            C13473h.m21620a(li.cqo().qVc, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(38800);
                    C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "download img %s", str);
                    if (!C5046bo.m7510Q((String) snsAvatarImageView.getTag(2131820666), str) && str.equals(C13473h.m21625gj("adId", (String) snsAvatarImageView.getTag(2131820666)))) {
                        Bitmap decodeFile = C5056d.decodeFile(str, null);
                        if (decodeFile != null) {
                            snsAvatarImageView.setImageBitmap(decodeFile);
                        }
                    }
                    AppMethodBeat.m2505o(38800);
                }
            });
        }
        snsAvatarImageView.setOnClickListener(this.rqo.rJI);
        TextView textView3 = (TextView) this.rpJ.findViewById(2131823149);
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(li.getUserName());
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + li.getUserName() + " " + li.cqA() + " " + li.cqN());
        if (aoO != null && aoO.mo16705Oh() == 0) {
            C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "getContact %s", li.getUserName());
            C26417a.m42064Zu().mo20966a(li.getUserName(), "", this.rqL);
        }
        String bc = C5046bo.m7532bc(aoO == null ? li.getUserName() : aoO.mo16707Oj(), "");
        if (li.mo74295sh()) {
            C21984b cqo = li.cqo();
            if (cqo != null) {
                View inflate;
                String str2;
                String string;
                Iterator it;
                C7616ad aoN;
                if (cqo.qVa) {
                    charSequence2 = cqo.qVb;
                } else if (C5046bo.isNullOrNil(bc) && !C5046bo.isNullOrNil(cqo.nickname)) {
                    charSequence2 = cqo.nickname;
                }
                charSequence2.length();
                i = this.klY != 10 ? 3 : 2;
                c44090k = new C44090k(C44089j.m79292b((Context) this, charSequence2));
                c44090k.mo69791a(new C24944o(new C13357a(li.mo74295sh(), aoO.getUsername(), li.cqU(), 2), this.rqd, i), charSequence2);
                textView3.setOnTouchListener(new C46247aa());
                textView3.setText(c44090k, BufferType.SPANNABLE);
                ((TextView) this.rpJ.findViewById(2131827711)).setText("");
                this.rqM = new C4052bb(this.rpJ);
                if (li.mo74295sh()) {
                    this.rqM.setVisibility(8);
                } else {
                    this.rqM.mo8922z(Long.valueOf(li.field_snsId), new C34935b(this.rqM, 0, this.rpZ, li.field_snsId, m13942f(li).hnw));
                    this.rqM.mo8918a(li.cqo(), m13942f(li));
                    this.rqM.mo8917a(this.rqo.rJS, this.rqo.rKg);
                    this.rqM.setVisibility(0);
                }
                str = cqu.xfF;
                this.rpK = (TextView) this.rpJ.findViewById(2131820991);
                this.rpK.setTag(new C39828ar(this.cFc, li.cqU(), true, false, 2));
                this.jMO.mo39887c(this.rpK, this.rqo.rJK, this.rqo.rJH);
                if (C5046bo.isNullOrNil(str)) {
                    this.rpK.setText(str + " ");
                    C44089j.m79307h(this.rpK, 2);
                    this.rpK.setVisibility(0);
                } else {
                    this.rpK.setVisibility(8);
                }
                viewStub = (ViewStub) this.rpJ.findViewById(2131827717);
                if (!this.rqI) {
                    viewStub.setLayoutResource(-1);
                    switch (this.klY) {
                        case 2:
                            viewStub.setLayoutResource(2130970819);
                            break;
                        case 3:
                            viewStub.setLayoutResource(2130970816);
                            break;
                        case 4:
                            viewStub.setLayoutResource(2130970817);
                            break;
                        case 5:
                            viewStub.setLayoutResource(2130970818);
                            break;
                        case 9:
                            viewStub.setLayoutResource(2130970778);
                            break;
                        case 10:
                            viewStub.setLayoutResource(2130970763);
                            break;
                        case 11:
                            viewStub.setLayoutResource(2130970822);
                            this.rqm = new C13665d(cqu, li, this.rqo, this.rqn);
                            break;
                        case 13:
                            viewStub.setLayoutResource(2130970713);
                            this.rqm = new C13655b(cqu, li, this.rqo, this.rqn);
                            break;
                        case 14:
                            viewStub.setLayoutResource(2130970812);
                            this.rqm = new C13658c(cqu, li, this.rqo, this.rqn);
                            break;
                        default:
                            viewStub.setVisibility(8);
                            break;
                    }
                    if (viewStub.getLayoutResource() != -1) {
                        inflate = viewStub.inflate();
                        if (this.rqm != null) {
                            this.rqm.mo25860g(inflate, this.rpP);
                        }
                        this.rqI = true;
                    } else {
                        viewStub.setVisibility(8);
                    }
                }
                width = ((WindowManager) dxU().getSystemService("window")).getDefaultDisplay().getWidth();
                if (this.klY != 6) {
                    TagImageView tagImageView;
                    float a;
                    float a2;
                    LinearLayout linearLayout;
                    LinearLayout.LayoutParams layoutParams;
                    bau bau;
                    View view;
                    if (this.klY == 2 || this.klY == 3 || this.klY == 4 || this.klY == 5) {
                        this.rqJ = (PhotosContent) findViewById(2131827892);
                        if (this.rqJ != null) {
                            this.rqJ.csr();
                            if (this.klY == 2) {
                                i = 1;
                            } else {
                                i = C22067aq.run[this.klY];
                            }
                            for (int i2 = 0; i2 < i; i2++) {
                                tagImageView = (TagImageView) this.rqJ.findViewById(C22067aq.rur[i2]);
                                this.rqJ.mo8756a(tagImageView);
                                tagImageView.setOnClickListener(this.rqo.rjy);
                                this.jMO.mo39887c(tagImageView, this.rqo.rJV, this.rqo.rJH);
                            }
                            this.rqJ.setImageViewWidth(this.rqi);
                            final LinkedList linkedList = new LinkedList();
                            if (li.mo74295sh() && this.klY == 2) {
                                cqo = li.cqo();
                                this.rqJ.mo8755DT(0).setScaleType(C15991a.CENTER_CROP);
                                if (cqo != null && !cqo.coP() && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                                    a = C3953i.m6289a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                                    a2 = C3953i.m6289a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                                    int al;
                                    baw baw;
                                    if (cqo.qUG == 0) {
                                        if (a >= ((float) ((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)))) {
                                            a = (float) ((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4));
                                            a2 = (float) ((int) ((cqo.qUI * a) / cqo.qUH));
                                        }
                                        baw baw2 = new baw();
                                        baw2.wFx = a;
                                        baw2.wFy = a2;
                                        baw2.wFz = baw2.wFx * baw2.wFy;
                                        linkedList.add(baw2);
                                    } else if (cqo.qUG == 1) {
                                        al = (((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                                        width = (int) ((((float) al) * cqo.qUI) / cqo.qUH);
                                        baw = new baw();
                                        if (al > 0) {
                                            a = (float) al;
                                        }
                                        baw.wFx = a;
                                        if (width > 0) {
                                            a2 = (float) width;
                                        }
                                        baw.wFy = a2;
                                        baw.wFz = baw.wFx * baw.wFy;
                                        linkedList.add(baw);
                                    } else if (cqo.qUG == 2) {
                                        al = (((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                                        width = (int) ((((float) al) * cqo.qUI) / cqo.qUH);
                                        baw = new baw();
                                        if (al > 0) {
                                            a = (float) al;
                                        }
                                        baw.wFx = a;
                                        if (width > 0) {
                                            a2 = (float) width;
                                        }
                                        baw.wFy = a2;
                                        baw.wFz = baw.wFx * baw.wFy;
                                        linkedList.add(baw);
                                    }
                                }
                                if (!C5046bo.isNullOrNil(cqo.qUM)) {
                                    final PhotosContent photosContent = this.rqJ;
                                    final TagImageView DT = this.rqJ.mo8755DT(0);
                                    C13473h.m21623c("adId", cqo.qUM, false, 41, new C3951a() {
                                        public final void cpu() {
                                        }

                                        public final void cmD() {
                                        }

                                        /* renamed from: YJ */
                                        public final void mo8627YJ(String str) {
                                            AppMethodBeat.m2504i(38801);
                                            MaskImageView maskImageView = (MaskImageView) photosContent.findViewById(2131827901);
                                            if (maskImageView != null) {
                                                maskImageView.setVisibility(0);
                                                maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
                                                float a = C3953i.m6289a((double) cqo.qUN, 1, cqo.qUJ, cqo.qUK);
                                                float a2 = C3953i.m6289a((double) cqo.qUO, 1, cqo.qUJ, cqo.qUK);
                                                float a3 = C3953i.m6289a((double) cqo.qUP, 1, cqo.qUJ, cqo.qUK);
                                                float a4 = C3953i.m6289a((double) cqo.qUQ, 1, cqo.qUJ, cqo.qUK);
                                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                                                layoutParams.setMargins((int) ((((float) DT.getRight()) - a3) - a), (int) ((((float) DT.getBottom()) - a4) - a2), 0, 0);
                                                maskImageView.setLayoutParams(layoutParams);
                                            }
                                            AppMethodBeat.m2505o(38801);
                                        }
                                    });
                                }
                            }
                            final TimeLineObject timeLineObject = cqu;
                            this.rpJ.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                                boolean rqT = false;

                                public final void onViewAttachedToWindow(View view) {
                                    AppMethodBeat.m2504i(38802);
                                    C4990ab.m7417i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", Boolean.valueOf(this.rqT));
                                    if (this.rqT) {
                                        this.rqT = false;
                                        if (timeLineObject == null) {
                                            AppMethodBeat.m2505o(38802);
                                            return;
                                        } else if (li == null) {
                                            AppMethodBeat.m2505o(38802);
                                            return;
                                        } else if (SnsCommentDetailUI.this.rqJ == null) {
                                            AppMethodBeat.m2505o(38802);
                                            return;
                                        } else {
                                            C22067aq D = SnsCommentDetailUI.this.rpY;
                                            PhotosContent photosContent = SnsCommentDetailUI.this.rqJ;
                                            TimeLineObject timeLineObject = timeLineObject;
                                            String cqU = li.cqU();
                                            SnsCommentDetailUI.this.rqo;
                                            D.mo37629a(photosContent, timeLineObject, cqU, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.this.klY, -1, li.mo74253DI(32), false, C44222az.xYT, linkedList, li.cqA());
                                            AppMethodBeat.m2505o(38802);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.m2505o(38802);
                                }

                                public final void onViewDetachedFromWindow(View view) {
                                    AppMethodBeat.m2504i(38803);
                                    C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
                                    this.rqT = true;
                                    AppMethodBeat.m2505o(38803);
                                }
                            });
                            this.rpY.mo37629a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, li.mo74253DI(32), false, C44222az.xYT, linkedList, li.cqA());
                        } else {
                            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.klY + ",stub is " + viewStub.toString());
                        }
                    } else if (this.klY == 10) {
                        this.rqJ.csr();
                        tagImageView = (TagImageView) this.rqJ.findViewById(2131827766);
                        this.rqJ.mo8756a(tagImageView);
                        tagImageView.setOnClickListener(this.rqo.rjy);
                        bc = li.cqU();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        C29190ao c29190ao = new C29190ao();
                        c29190ao.czD = bc;
                        c29190ao.index = 0;
                        c29190ao.rsl = arrayList;
                        c29190ao.rps = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(c29190ao);
                        }
                        textView3 = (TextView) this.rpJ.findViewById(2131827725);
                        if (C1853r.m3846Yz().equals(cqu.jBB)) {
                            textView3.setVisibility(8);
                        } else {
                            cbf q = C34955aj.m57409q(li);
                            if (q.xaE == null || q.xaE.xbg == 0) {
                                textView3.setVisibility(8);
                            } else {
                                textView3.setText(getString(C25738R.string.ctw, new Object[]{Integer.valueOf(q.xaE.xbg)}));
                                textView3.setVisibility(0);
                            }
                        }
                        bav cqM = li.cqM();
                        if (cqM == null) {
                            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + li.cqU());
                        } else if (C1853r.m3846Yz().equals(cqu.jBB)) {
                            this.rpY.mo37628a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, C44222az.xYT, true);
                        } else if (C39742m.m67970k(li)) {
                            this.rpY.mo37628a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, C44222az.xYT, false);
                        } else if (cqM.cRU == 0) {
                            this.rpY.mo37628a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, C44222az.xYT, true);
                        } else {
                            C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + cqM.cRU);
                        }
                    } else if (this.klY == 9) {
                        Pair create;
                        bau bau2;
                        this.rqs = true;
                        final C43589aj c43589aj = new C43589aj();
                        inflate = this.rpJ;
                        View findViewById = inflate.findViewById(2131822515);
                        C34915a c34915a = (C34915a) inflate.findViewById(2131820629);
                        c43589aj.rnt = findViewById;
                        c43589aj.raP = (ImageView) inflate.findViewById(2131820981);
                        c43589aj.rnu = (MMPinProgressBtn) inflate.findViewById(2131821370);
                        c43589aj.raQ = (TextView) inflate.findViewById(2131827572);
                        c43589aj.rnv = (TextView) inflate.findViewById(2131827571);
                        c43589aj.qzM = c34915a;
                        c43589aj.mo69200a(cqu, 0, li.cqU(), li.mo74295sh());
                        c43589aj.raQ.setVisibility(8);
                        c43589aj.qzM.setTagObject(c43589aj);
                        findViewById.setTag(c43589aj);
                        c43589aj.rnt.setOnClickListener(this.rqo.rKe);
                        if (li.coP()) {
                            this.jMO.mo39887c(findViewById, this.rqo.rJZ, this.rqo.rJH);
                        } else {
                            this.jMO.mo39887c(findViewById, this.rqo.rJX, this.rqo.rJH);
                        }
                        Pair a3 = C37953e.m64183a(cqu, c43589aj.qzM.getUIContext(), li.mo74295sh());
                        if (li.mo74295sh()) {
                            C21984b cqo2 = li.cqo();
                            if (cqo2 != null && cqo2.coP() && cqo2.qUH > 0.0f && cqo2.qUI > 0.0f) {
                                a = C3953i.m6289a((double) cqo2.qUH, 1, cqo2.qUJ, cqo2.qUK);
                                a2 = C3953i.m6289a((double) cqo2.qUI, 1, cqo2.qUJ, cqo2.qUK);
                                int al2;
                                if (cqo2.qUG == 0) {
                                    if (a >= ((float) ((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)))) {
                                        a = (float) ((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4));
                                        a2 = (float) ((int) ((cqo2.qUI * a) / cqo2.qUH));
                                    }
                                    create = Pair.create(Integer.valueOf((int) a), Integer.valueOf((int) a2));
                                } else if (cqo2.qUG == 1) {
                                    al2 = (((((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                                    create = Pair.create(Integer.valueOf(al2), Integer.valueOf((int) ((((float) al2) * cqo2.qUI) / cqo2.qUH)));
                                } else if (cqo2.qUG == 2) {
                                    al2 = (((width - C1338a.m2856al(this, C25738R.dimen.a94)) - C1338a.m2856al(this, C25738R.dimen.f10017nj)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                                    create = Pair.create(Integer.valueOf(al2), Integer.valueOf((int) ((((float) al2) * cqo2.qUI) / cqo2.qUH)));
                                }
                                if (create != null) {
                                    c34915a.mo8513fi(((Integer) create.first).intValue(), ((Integer) create.second).intValue());
                                    ViewGroup.LayoutParams layoutParams2 = c43589aj.rnv.getLayoutParams();
                                    layoutParams2.width = ((Integer) create.first).intValue();
                                    layoutParams2.height = ((Integer) create.second).intValue();
                                    c43589aj.rnv.setLayoutParams(layoutParams2);
                                }
                                if (cqu.xfI != null || cqu.xfI.wbK.size() <= 0) {
                                    bau2 = null;
                                } else {
                                    bau2 = (bau) cqu.xfI.wbK.get(0);
                                }
                                if (li.mo74295sh()) {
                                    c43589aj.qzM.setOnCompletionListener(new C13304e() {
                                        /* renamed from: c */
                                        public final void mo8940c(C13303b c13303b, int i) {
                                            AppMethodBeat.m2504i(38806);
                                            if (i != -1) {
                                                if (SnsCommentDetailUI.this.rqn == null) {
                                                    AppMethodBeat.m2505o(38806);
                                                    return;
                                                }
                                                SnsCommentDetailUI.this.rqn.mo25445u(li.field_snsId, false);
                                            }
                                            AppMethodBeat.m2505o(38806);
                                        }
                                    });
                                    if (!this.rqn.mo25439jO(li.field_snsId)) {
                                        c43589aj.qzM.setOnDecodeDurationListener(new C13325f() {
                                            /* renamed from: b */
                                            public final void mo8946b(C13303b c13303b, long j) {
                                                AppMethodBeat.m2504i(38807);
                                                if (SnsCommentDetailUI.this.rqn == null) {
                                                    AppMethodBeat.m2505o(38807);
                                                    return;
                                                }
                                                int cle = (int) c13303b.cle();
                                                SnsCommentDetailUI.this.rqn.mo25433c(li.field_snsId, C5046bo.m7588yz(), false);
                                                SnsCommentDetailUI.this.rqn.mo25436f(li.field_snsId, cle, false);
                                                if (j >= 3) {
                                                    SnsCommentDetailUI.this.rqn.mo25429T(li.field_snsId, li.field_snsId);
                                                    c43589aj.qzM.setOnDecodeDurationListener(null);
                                                }
                                                AppMethodBeat.m2505o(38807);
                                            }
                                        });
                                    }
                                }
                                if (cqu.xfI != null && cqu.xfI.wbK.size() > 0) {
                                    C13373af.cnC();
                                    if (!C21925g.m33541t(bau2)) {
                                        if (C13373af.cnC().mo37468u(bau2)) {
                                            c43589aj.raP.setVisibility(0);
                                            c43589aj.rnu.setVisibility(8);
                                            c43589aj.raP.setImageDrawable(C1338a.m2864g(this, C1318a.shortvideo_play_btn));
                                        } else if (C13373af.cnC().mo37469v(bau2)) {
                                            c43589aj.raP.setVisibility(8);
                                            c43589aj.rnu.setVisibility(8);
                                        } else if (!li.mo74295sh() || C13373af.cnC().mo37465o(li) > 5) {
                                            C13373af.cnC().mo37472y(bau2);
                                            c43589aj.raP.setVisibility(0);
                                            c43589aj.rnu.setVisibility(8);
                                            c43589aj.raP.setImageDrawable(C1338a.m2864g(this, C1318a.shortvideo_play_btn));
                                        } else {
                                            c43589aj.raP.setVisibility(8);
                                            c43589aj.rnu.setVisibility(8);
                                        }
                                        if (c43589aj.qzM.ckY()) {
                                            C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "play video error " + bau2.f17915Id + " " + bau2.Url + " " + bau2.wEH);
                                            C13373af.cnC().mo37472y(bau2);
                                            c43589aj.raP.setVisibility(0);
                                            c43589aj.rnu.setVisibility(8);
                                            c43589aj.raP.setImageDrawable(C1338a.m2864g(this, C1318a.shortvideo_play_btn));
                                        }
                                    } else if (C13373af.cnC().mo37470w(bau2)) {
                                        c43589aj.raP.setVisibility(8);
                                        c43589aj.rnu.setVisibility(0);
                                        c43589aj.rnu.dKB();
                                    } else if (li.mo74295sh() && C13373af.cnC().mo37465o(li) == 5) {
                                        C13373af.cnC().mo37428A(bau2);
                                        c43589aj.raP.setVisibility(8);
                                        c43589aj.rnu.setVisibility(0);
                                        c43589aj.rnu.dKB();
                                    } else {
                                        C13373af.cnC().mo37472y(bau2);
                                        c43589aj.raP.setVisibility(0);
                                        c43589aj.rnu.setVisibility(8);
                                        c43589aj.raP.setImageDrawable(C1338a.m2864g(this, C1318a.shortvideo_play_btn));
                                    }
                                    c34915a.setTagObject(c43589aj);
                                    C13373af.cnC().mo37448a(li, bau2, c34915a, hashCode(), 0, C44222az.xYT, li.mo74295sh());
                                    findViewById.setTag(c43589aj);
                                    if (this.rqn != null) {
                                        boolean z = li.mo74295sh() ? C13373af.cnC().mo37465o(li) == 5 : C13373af.cnC().mo37464n(li) == 5;
                                        this.rqn.mo25447w(li.field_snsId, z);
                                    }
                                }
                            }
                        }
                        create = a3;
                        if (create != null) {
                        }
                        if (cqu.xfI != null) {
                        }
                        bau2 = null;
                        if (li.mo74295sh()) {
                        }
                        C13373af.cnC();
                        if (!C21925g.m33541t(bau2)) {
                        }
                        c34915a.setTagObject(c43589aj);
                        C13373af.cnC().mo37448a(li, bau2, c34915a, hashCode(), 0, C44222az.xYT, li.mo74295sh());
                        findViewById.setTag(c43589aj);
                        if (this.rqn != null) {
                        }
                    } else if (this.klY == 0) {
                        linearLayout = (LinearLayout) this.rpJ.findViewById(2131827710);
                        LinearLayout DV = m13912DV(2130970779);
                        if (!this.rqG) {
                            linearLayout.removeView(this.rqJ);
                            linearLayout.addView(DV, 3);
                            if (DV.getLayoutParams() != null) {
                                layoutParams = new LinearLayout.LayoutParams(DV.getLayoutParams());
                            } else {
                                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams.setMargins(layoutParams.leftMargin, C1338a.fromDPToPix(this, 12), layoutParams.rightMargin, layoutParams.bottomMargin);
                            DV.setLayoutParams(layoutParams);
                        }
                        if (cqu.xfI.wbK.isEmpty()) {
                            DV.setVisibility(8);
                        } else {
                            bau = (bau) cqu.xfI.wbK.get(0);
                            view = (MMImageView) DV.findViewById(2131825687);
                            C13373af.cnC().mo37440a(bau, view, (int) C1318a.app_attach_file_icon_music, hashCode(), C44222az.xYT);
                            this.rqc = (ImageView) DV.findViewById(2131824637);
                            this.rqc.setOnTouchListener(this.riQ);
                            this.cFI = cqu.f15074Id;
                            cta();
                            view.setTag(new C13707q(cqu, this.rpZ, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            view.setOnClickListener(this.rqg.rDA);
                            str2 = bau.Desc;
                            if (!C5046bo.isNullOrNil(str2)) {
                                ((TextView) DV.findViewById(2131825690)).setText(str2);
                            }
                            bc = bau.Title;
                            if (!C5046bo.isNullOrNil(bc)) {
                                ((TextView) DV.findViewById(2131825689)).setText(new SpannableString(bc), BufferType.SPANNABLE);
                            }
                            DV.setTag(new C13707q(cqu, this.rpZ));
                            this.jMO.mo39887c(DV, this.rqo.rJW, this.rqo.rJH);
                            DV.setOnClickListener(this.rqg.rvD);
                            C29036i.m46100b(view, this);
                        }
                    } else if (this.klY == 13) {
                        this.rpK.setVisibility(8);
                        this.rpP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    } else if (!(this.klY == 11 || this.klY == 14)) {
                        Object obj;
                        Object obj2;
                        linearLayout = (LinearLayout) this.rpJ.findViewById(2131827710);
                        LinearLayout DV2 = m13912DV(2130970777);
                        view = (MMImageView) DV2.findViewById(2131825687);
                        if (!this.rqG) {
                            linearLayout.removeView(this.rqJ);
                            linearLayout.addView(DV2, 3);
                            if (DV2.getLayoutParams() != null) {
                                layoutParams = new LinearLayout.LayoutParams(DV2.getLayoutParams());
                            } else {
                                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams.setMargins(layoutParams.leftMargin, C1338a.fromDPToPix(this, 12), layoutParams.rightMargin, layoutParams.bottomMargin);
                            DV2.setLayoutParams(layoutParams);
                        }
                        Object obj3 = null;
                        if (li.mo74295sh()) {
                            if (li.cqo().coO()) {
                                obj3 = 1;
                                DV2.setTag(li);
                                DV2.setTag(2131820637, view);
                                DV2.setOnClickListener(this.rqo.rKs);
                            }
                            obj = obj3;
                            obj2 = null;
                        } else {
                            if (cqu.xfI.wbJ == 9) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDu);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 10) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDw);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 17) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDx);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 22) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDy);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 23) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDz);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 14) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDv);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 12) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDD);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 13) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDE);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 15) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new C13707q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqo.rKf);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 26) {
                                DV2.setTag(new C13707q(cqu, this.rpZ));
                                DV2.setOnClickListener(this.rqg.rDF);
                                obj = null;
                                obj2 = null;
                            } else {
                                DV2.setTag(new C13707q(cqu, this.rpZ));
                                DV2.setOnClickListener(this.rqg.rvD);
                                if ((cqu.fgt & 1) > 0) {
                                    obj = null;
                                    int obj22 = 1;
                                }
                            }
                            obj = null;
                            obj22 = null;
                        }
                        if (obj != null) {
                            this.jMO.mo39887c(DV2, this.rqo.rKa, this.rqo.rJH);
                        } else {
                            this.jMO.mo39887c(DV2, this.rqo.rJW, this.rqo.rJH);
                        }
                        String ZI = SnsCommentDetailUI.csW() ? C46251au.m86603ZI(cqu.xfI.Url) : "";
                        String str3 = cqu.xfI.Title;
                        if (obj != null) {
                            str = cqu.xfI.Desc;
                        } else {
                            str = ZI;
                        }
                        DV2.findViewById(2131824637).setVisibility(8);
                        if (!cqu.xfI.wbK.isEmpty()) {
                            view.setVisibility(0);
                            bau = (bau) cqu.xfI.wbK.get(0);
                            if (cqu.xfI.wbJ == 15) {
                                ((ImageView) DV2.findViewById(2131824637)).setImageResource(C25738R.drawable.f6932vs);
                                ((ImageView) DV2.findViewById(2131824637)).setVisibility(0);
                                C13373af.cnC().mo37440a(bau, view, (int) C1318a.app_attach_file_icon_video, hashCode(), C44222az.dtg().mo69860Mp(cqu.pcX));
                                ZI = str3;
                                bc = str;
                            } else if (cqu.xfI.wbJ == 5) {
                                str3 = C46251au.m86603ZI(bau.Url);
                                str = bau.Title;
                                DV2.findViewById(2131824637).setVisibility(0);
                                C13373af.cnC().mo37440a(bau, view, (int) C1318a.app_attach_file_icon_video, hashCode(), C44222az.xYT);
                                ZI = str;
                                bc = str3;
                            } else if (cqu.xfI.wbJ == 18) {
                                DV2.findViewById(2131824637).setVisibility(0);
                                ((ImageView) DV2.findViewById(2131824637)).setImageResource(C25738R.drawable.aql);
                                view.setVisibility(0);
                                C13373af.cnC().mo37440a(bau, view, (int) C1318a.app_attach_file_icon_video, hashCode(), C44222az.xYT);
                                ZI = str3;
                                bc = str;
                            } else {
                                C13373af.cnC().mo37455b(bau, view, hashCode(), C44222az.xYT);
                                ZI = str3;
                                bc = str;
                            }
                        } else if (cqu.xfI.wbJ == 18) {
                            ((ImageView) DV2.findViewById(2131824637)).setVisibility(0);
                            ((ImageView) DV2.findViewById(2131824637)).setImageResource(C25738R.drawable.aql);
                            view.setVisibility(0);
                            C13373af.cnC().mo37438a(view, -1, (int) C1318a.app_attach_file_icon_video, hashCode());
                            ZI = str3;
                            bc = str;
                        } else if (cqu.xfI.wbJ == 26) {
                            view.setVisibility(0);
                            C13373af.cnC().mo37438a(view, -1, (int) C1318a.note_sns_link_default, hashCode());
                            ZI = str3;
                            bc = str;
                        } else {
                            view.setVisibility(0);
                            C13373af.cnC().mo37438a(view, -1, (int) C1318a.app_attach_file_icon_webpage, hashCode());
                            ZI = str3;
                            bc = str;
                        }
                        C29036i.m46100b(view, this);
                        if (cqu.xfI.wbJ == 15) {
                            bc = "";
                            string = getString(C25738R.string.ekr);
                        } else {
                            string = ZI;
                        }
                        if (C5046bo.isNullOrNil(bc)) {
                            DV2.findViewById(2131825690).setVisibility(8);
                        } else {
                            DV2.findViewById(2131825690).setVisibility(0);
                            ((TextView) DV2.findViewById(2131825690)).setText(bc);
                        }
                        textView3 = (TextView) DV2.findViewById(2131825689);
                        if (C5046bo.isNullOrNil(string)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            if (obj22 != null) {
                                textView3.setText(C29036i.m46097a(string, dxU(), textView3));
                            } else {
                                textView3.setText(string);
                            }
                        }
                    }
                }
                textView3 = (TextView) this.rpJ.findViewById(2131827718);
                if (li.mo74295sh()) {
                    bc = cqu.xfG == null ? null : cqu.xfG.guP;
                    string = cqu.xfG == null ? null : cqu.xfG.eUu;
                    textView3.setTag(li.cqU());
                    if (C5046bo.isNullOrNil(bc) && C5046bo.isNullOrNil(string)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        if (C5046bo.isNullOrNil(string)) {
                            textView3.setText(bc);
                            textView3.setClickable(false);
                            textView3.setTextColor(-9211021);
                        } else {
                            textView3.setTextColor(-11048043);
                            textView3.setClickable(true);
                            if (li.field_snsId != 0 || C5046bo.isNullOrNil(bc)) {
                                textView3.setText(string);
                            } else {
                                textView3.setText(bc + "·" + string);
                            }
                        }
                    }
                } else {
                    C21980a f = m13942f(li);
                    if (f != null) {
                        string = f.qTD;
                        bc = f.qTE;
                        textView3.setTag(li.cqU());
                        if (!C5046bo.isNullOrNil(string)) {
                            if (C5046bo.isNullOrNil(bc)) {
                                textView3.setVisibility(0);
                            } else {
                                textView3.setVisibility(0);
                                if (!C5046bo.isNullOrNil(string)) {
                                    textView3.setTextColor(-11048043);
                                    textView3.setClickable(true);
                                    textView3.setText(string);
                                    this.rpJ.post(new C787726());
                                }
                            }
                            textView3.setText(string);
                            textView3.setClickable(false);
                            textView3.setTextColor(-9211021);
                            this.rpJ.post(new C787726());
                        }
                    }
                    textView3.setVisibility(8);
                    this.rpJ.post(new C787726());
                }
                textView3.setOnClickListener(this.rqo.rKd);
                ((TextView) this.rpJ.findViewById(2131827720)).setText(C29198aw.m46377m(dxU(), ((long) li.cqN()) * 1000));
                asyncTextView = (AsyncTextView) this.rpJ.findViewById(2131827721);
                asyncTextView.setOnClickListener(this.rqo.rKh);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.rpJ.findViewById(2131827722);
                c7616ad = aoO;
                asyncTextView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(38809);
                        C29036i.m46098a(new SnsAdClick(SnsCommentDetailUI.m13941f(SnsCommentDetailUI.this), 2, li.field_snsId, 24, 0));
                        SnsCommentDetailUI.this.rhq.setCommentFlag(1);
                        SnsCommentDetailUI.this.rhq.setCommentHint(c7616ad.mo16707Oj());
                        SnsCommentDetailUI.this.rhq.mo55636lj(true);
                        SnsCommentDetailUI.this.rpO.setVisibility(8);
                        SnsCommentDetailUI.m13965z(SnsCommentDetailUI.this);
                        AppMethodBeat.m2505o(38809);
                    }
                });
                asyncTextView2.setVisibility(8);
                if (li.mo74295sh()) {
                    C21980a f2 = m13942f(li);
                    asyncTextView.setTag(li.cqU());
                    if (f2.qTF == C21980a.qTr) {
                        if (C5046bo.isNullOrNil(f2.qTG)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            asyncTextView.setText(f2.qTG);
                            asyncTextView.setVisibility(0);
                        }
                    } else if (f2.qTF == C21980a.qTs) {
                        if (C5046bo.isNullOrNil(f2.qTG)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            str2 = "";
                            it = f2.qTI.iterator();
                            while (it.hasNext()) {
                                string = (String) it.next();
                                aoN = this.rqa.aoN(string);
                                if (aoN != null) {
                                    str = aoN.mo16707Oj();
                                    if (C5046bo.isNullOrNil(str)) {
                                        str2 = str2 + string;
                                    } else {
                                        str2 = str2 + str;
                                    }
                                } else {
                                    str2 = str2 + string;
                                }
                                if (f2.qTI.getLast() != string) {
                                    str2 = str2 + ",";
                                }
                            }
                            string = String.format(f2.qTG, new Object[]{str2});
                            asyncTextView.getTextSize();
                            C44090k c44090k2 = new C44090k(C44089j.m79298c(this, string, 1));
                            c44090k2.mo69791a(null, string);
                            TextPaint paint = asyncTextView.getPaint();
                            if (C1338a.m2859ao(this, (int) Layout.getDesiredWidth(c44090k2, 0, c44090k2.length(), paint)) > this.rql) {
                                while (str2.length() > 1) {
                                    str2 = str2.substring(0, str2.length() - 2);
                                    String format = String.format(f2.qTG, new Object[]{str2 + "..."});
                                    asyncTextView.getTextSize();
                                    C44090k c44090k3 = new C44090k(C44089j.m79298c(this, format, 1));
                                    c44090k3.mo69791a(null, format);
                                    int ao = C1338a.m2859ao(this, (int) Layout.getDesiredWidth(c44090k3, 0, c44090k3.length(), paint));
                                    asyncTextView.setText(c44090k3, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (ao <= this.rql) {
                                    }
                                }
                            } else {
                                asyncTextView.setText(c44090k2, BufferType.SPANNABLE);
                                asyncTextView.setVisibility(0);
                            }
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && C5046bo.isNullOrNil(f2.qTH)) {
                        asyncTextView.setTextColor(getResources().getColor(C25738R.color.a1a));
                        asyncTextView.setOnClickListener(null);
                    }
                    if ((li.cqu().xfI.wbL & 4) != 0) {
                        asyncTextView2.setTag(li.cqU());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{dxU().getResources().getString(C25738R.string.eiu), charSequence2, dxU().getResources().getString(C25738R.string.eiv)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView3 = (TextView) this.rpJ.findViewById(2131827724);
                textView3.setOnTouchListener(new C46247aa());
                bc = C24826a.gkF.mo38872t((Context) this, cqu.xfH.f17242Id);
                if (cqu.xfI.wbJ == 26) {
                    bc = getString(C25738R.string.bnl);
                }
                C46251au.m86605a(cqu, (Context) this);
                if (C24826a.gkF.mo38865dg(bc)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    SpannableString spannableString = new SpannableString(getString(C25738R.string.ejz) + bc);
                    spannableString.setSpan(new C7841a(), 0, spannableString.length(), 33);
                    textView3.setText(spannableString, BufferType.SPANNABLE);
                    if (cqu.xfH == null || !C46494g.aiF(cqu.xfH.f17242Id)) {
                        textView3.setTextColor(getResources().getColor(C25738R.color.a1a));
                        textView3.setOnTouchListener(null);
                    }
                    textView3.setTag(cqu);
                }
                textView3 = (TextView) this.rpJ.findViewById(2131827726);
                if (li.getUserName().equals(this.ecX)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    textView3.setTag(li.cqU() + ";" + li.cqA());
                    textView3.setOnClickListener(new C784928());
                }
                textView3 = (TextView) this.rpJ.findViewById(2131827719);
                p = C34955aj.m57408p(li);
                if (p != null) {
                    textView3.setVisibility(8);
                } else {
                    if (p.xaw.size() <= 0) {
                        textView3.setVisibility(8);
                    } else if (this.ecX.equals(p.vHl)) {
                        textView3.setVisibility(0);
                        bc = "";
                        Object obj4 = null;
                        it = p.xaw.iterator();
                        while (true) {
                            string = bc;
                            if (it.hasNext()) {
                                StringBuilder append;
                                cat cat = (cat) it.next();
                                if (obj4 == null) {
                                    obj4 = 1;
                                    string = string + "  ";
                                } else {
                                    string = string + ",  ";
                                }
                                if (cat.wCW != null) {
                                    append = new StringBuilder().append(string);
                                    bc = cat.wCW;
                                } else {
                                    aoN = this.rqa.aoO(cat.vHl);
                                    append = new StringBuilder().append(string);
                                    bc = aoN == null ? cat.vHl : aoN.mo16707Oj();
                                }
                                bc = append.append(bc).toString();
                            } else {
                                textView3.setText(C44089j.m79293b((Context) this, getString(C25738R.string.eq2, new Object[]{string}), textView3.getTextSize()));
                            }
                        }
                    } else {
                        textView3.setVisibility(8);
                        Iterator it2 = p.xaw.iterator();
                        while (it2.hasNext()) {
                            if (this.ecX.equals(((cat) it2.next()).vHl)) {
                                textView3.setVisibility(0);
                                CharSequence string2 = getString(C25738R.string.eq3);
                                textView3.setVisibility(0);
                                textView3.setText(C44089j.m79293b((Context) this, string2, textView3.getTextSize()));
                            }
                        }
                    }
                    if (p == null || this.ecX == null || !this.ecX.equals(p.vHl) || ((p.wGz != 3 || p.xaB == null) && (p.wGz != 5 || p.wFp == null))) {
                        this.rpJ.findViewById(2131827723).setVisibility(8);
                    } else {
                        this.rpJ.findViewById(2131827723).setVisibility(0);
                        this.rpJ.findViewById(2131827723).setTag(Integer.valueOf(li.reX));
                        this.rpJ.findViewById(2131827723).setOnClickListener(new C785129());
                    }
                }
                this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rpR.setDuration(150);
                this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rpS.setDuration(150);
                if (this.rpO == null) {
                    this.rpO = this.rpJ.findViewById(2131821027);
                    this.rpO.setVisibility(8);
                }
                this.rpT = (LinearLayout) this.rpJ.findViewById(2131827727);
                this.rpT.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(38813);
                        if (C39742m.m67967Xx(li.cqU())) {
                            SnsCommentDetailUI.this.rhq.setCommentInfo(null);
                            SnsCommentDetailUI.this.rhq.setCommentFlag(0);
                            SnsCommentDetailUI.this.rhq.setCommentHint(SnsCommentDetailUI.this.getString(C25738R.string.eq9));
                            SnsCommentDetailUI.this.rhq.setCommentInfo(new cat());
                            SnsCommentDetailUI.this.rhq.mo55636lj(true);
                            if (!li.mo74253DI(32) || (li.cqu().xfI.wbL & 8) == 0) {
                                SnsCommentDetailUI.this.rhq.mo55637lk(false);
                            } else {
                                SnsCommentDetailUI.this.rhq.mo55637lk(true);
                            }
                            SnsCommentDetailUI.this.rpO.setVisibility(8);
                            SnsCommentDetailUI.m13965z(SnsCommentDetailUI.this);
                            AppMethodBeat.m2505o(38813);
                            return;
                        }
                        C29040a.m46131f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.mo8755DT(0));
                        AppMethodBeat.m2505o(38813);
                    }
                });
                this.rpT.setOnTouchListener(this.riQ);
                this.rpU = (LinearLayout) this.rpJ.findViewById(2131827694);
                this.rpU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(38814);
                        if (SnsCommentDetailUI.this.rqn != null && li.field_likeFlag == 0) {
                            SnsCommentDetailUI.this.rqn.mo25440jP(li.field_snsId);
                        }
                        SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                        LinearLayout linearLayout = (LinearLayout) view;
                        ImageView imageView = (ImageView) linearLayout.findViewById(2131827695);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.5f, 0.9f, 1.5f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setStartOffset(100);
                        scaleAnimation.setRepeatCount(0);
                        imageView.clearAnimation();
                        imageView.startAnimation(scaleAnimation);
                        scaleAnimation.setAnimationListener(new C785735(linearLayout));
                        SnsCommentDetailUI.m13914F(SnsCommentDetailUI.this);
                        AppMethodBeat.m2505o(38814);
                    }
                });
                this.rpU.setOnTouchListener(this.riQ);
                imageButton = (ImageButton) this.rpJ.findViewById(2131827709);
                li2 = m13951li(true);
                if (!(li2 == null || (li2.cqP() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(li2 == null || li2.cqT())) {
                    imageButton.setVisibility(8);
                }
                imageView = (ImageView) this.rpU.findViewById(2131827695);
                imageView2 = (ImageView) this.rpT.findViewById(2131827698);
                textView = (TextView) this.rpU.findViewById(2131827696);
                textView2 = (TextView) this.rpT.findViewById(2131827697);
                if (this.klY == 10) {
                    this.rpJ.findViewById(2131821027).setBackgroundResource(C25738R.drawable.bme);
                    imageButton.setImageResource(C25738R.drawable.f6812rl);
                    imageView.setImageResource(C25738R.drawable.f6813rm);
                    imageView2.setImageResource(C25738R.drawable.f6814rn);
                    textView.setTextColor(getResources().getColor(C25738R.color.a0q));
                    textView2.setTextColor(getResources().getColor(C25738R.color.a0q));
                    this.rpU.setBackgroundResource(C25738R.drawable.f6851t5);
                    this.rpT.setBackgroundResource(C25738R.drawable.f6852t6);
                }
                c46236n = li;
                imageButton.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(38815);
                        C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.this.rpO.getVisibility());
                        TimeLineObject cqu = c46236n.cqu();
                        if (cqu != null && cqu.xfI.wbJ == 21 && !C39742m.m67967Xx(c46236n.cqU())) {
                            C29040a.m46131f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.mo8755DT(0));
                            AppMethodBeat.m2505o(38815);
                        } else if (SnsCommentDetailUI.this.rpO.getVisibility() == 0) {
                            SnsCommentDetailUI.m13944g(SnsCommentDetailUI.this);
                            AppMethodBeat.m2505o(38815);
                        } else {
                            SnsCommentDetailUI.this.rpO.setVisibility(0);
                            SnsCommentDetailUI.this.rpO.startAnimation(SnsCommentDetailUI.this.rpR);
                            if (SnsCommentDetailUI.this.klY == 10) {
                                SnsCommentDetailUI.this.rpJ.findViewById(2131821027).setBackgroundResource(C25738R.drawable.bme);
                            }
                            if (C35002v.m57485Zo(SnsCommentDetailUI.this.cFc)) {
                                SnsCommentDetailUI.this.rpT.setEnabled(true);
                                imageView.setImageResource(C25738R.drawable.f6734og);
                                SnsCommentDetailUI.this.rpU.setEnabled(true);
                                textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a69));
                                textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a69));
                                C46236n YS = C21990h.m33615YS(SnsCommentDetailUI.this.cFc);
                                if (SnsCommentDetailUI.this.klY == 10) {
                                    imageView.setImageResource(C25738R.drawable.f6813rm);
                                    imageView2.setImageResource(C25738R.drawable.f6814rn);
                                    textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a0q));
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a0q));
                                } else {
                                    imageView.setImageResource(C25738R.drawable.f6734og);
                                    textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a69));
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a69));
                                }
                                if (YS.field_likeFlag == 0) {
                                    textView.setText(SnsCommentDetailUI.this.getString(C25738R.string.em5));
                                    AppMethodBeat.m2505o(38815);
                                    return;
                                }
                                textView.setText(SnsCommentDetailUI.this.getString(C25738R.string.el4));
                                AppMethodBeat.m2505o(38815);
                                return;
                            }
                            SnsCommentDetailUI.this.rpT.setEnabled(false);
                            SnsCommentDetailUI.this.rpU.setEnabled(false);
                            textView.setText(SnsCommentDetailUI.this.getString(C25738R.string.em5));
                            textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a0h));
                            textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(C25738R.color.a0h));
                            if (SnsCommentDetailUI.this.klY == 10) {
                                imageView.setImageResource(C1318a.friendactivity_comment_likeicon_golden_normal);
                                AppMethodBeat.m2505o(38815);
                                return;
                            }
                            imageView.setImageResource(C1318a.friendactivity_comment_likeicon_normal);
                            AppMethodBeat.m2505o(38815);
                        }
                    }
                });
                AppMethodBeat.m2505o(38847);
                return true;
            }
        }
        charSequence2 = bc;
        charSequence2.length();
        if (this.klY != 10) {
        }
        c44090k = new C44090k(C44089j.m79292b((Context) this, charSequence2));
        c44090k.mo69791a(new C24944o(new C13357a(li.mo74295sh(), aoO.getUsername(), li.cqU(), 2), this.rqd, i), charSequence2);
        textView3.setOnTouchListener(new C46247aa());
        textView3.setText(c44090k, BufferType.SPANNABLE);
        ((TextView) this.rpJ.findViewById(2131827711)).setText("");
        this.rqM = new C4052bb(this.rpJ);
        if (li.mo74295sh()) {
        }
        str = cqu.xfF;
        this.rpK = (TextView) this.rpJ.findViewById(2131820991);
        this.rpK.setTag(new C39828ar(this.cFc, li.cqU(), true, false, 2));
        this.jMO.mo39887c(this.rpK, this.rqo.rJK, this.rqo.rJH);
        if (C5046bo.isNullOrNil(str)) {
        }
        viewStub = (ViewStub) this.rpJ.findViewById(2131827717);
        if (this.rqI) {
        }
        width = ((WindowManager) dxU().getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.klY != 6) {
        }
        textView3 = (TextView) this.rpJ.findViewById(2131827718);
        if (li.mo74295sh()) {
        }
        textView3.setOnClickListener(this.rqo.rKd);
        ((TextView) this.rpJ.findViewById(2131827720)).setText(C29198aw.m46377m(dxU(), ((long) li.cqN()) * 1000));
        asyncTextView = (AsyncTextView) this.rpJ.findViewById(2131827721);
        asyncTextView.setOnClickListener(this.rqo.rKh);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.rpJ.findViewById(2131827722);
        c7616ad = aoO;
        asyncTextView2.setOnClickListener(/* anonymous class already generated */);
        asyncTextView2.setVisibility(8);
        if (li.mo74295sh()) {
        }
        textView3 = (TextView) this.rpJ.findViewById(2131827724);
        textView3.setOnTouchListener(new C46247aa());
        bc = C24826a.gkF.mo38872t((Context) this, cqu.xfH.f17242Id);
        if (cqu.xfI.wbJ == 26) {
        }
        C46251au.m86605a(cqu, (Context) this);
        if (C24826a.gkF.mo38865dg(bc)) {
        }
        textView3 = (TextView) this.rpJ.findViewById(2131827726);
        if (li.getUserName().equals(this.ecX)) {
        }
        textView3 = (TextView) this.rpJ.findViewById(2131827719);
        p = C34955aj.m57408p(li);
        if (p != null) {
        }
        this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpR.setDuration(150);
        this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpS.setDuration(150);
        if (this.rpO == null) {
        }
        this.rpT = (LinearLayout) this.rpJ.findViewById(2131827727);
        this.rpT.setOnClickListener(/* anonymous class already generated */);
        this.rpT.setOnTouchListener(this.riQ);
        this.rpU = (LinearLayout) this.rpJ.findViewById(2131827694);
        this.rpU.setOnClickListener(/* anonymous class already generated */);
        this.rpU.setOnTouchListener(this.riQ);
        imageButton = (ImageButton) this.rpJ.findViewById(2131827709);
        li2 = m13951li(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView = (ImageView) this.rpU.findViewById(2131827695);
        imageView2 = (ImageView) this.rpT.findViewById(2131827698);
        textView = (TextView) this.rpU.findViewById(2131827696);
        textView2 = (TextView) this.rpT.findViewById(2131827697);
        if (this.klY == 10) {
        }
        c46236n = li;
        imageButton.setOnClickListener(/* anonymous class already generated */);
        AppMethodBeat.m2505o(38847);
        return true;
    }

    private void csY() {
        AppMethodBeat.m2504i(38848);
        if (this.rpO == null || this.rpO.getVisibility() == 8) {
            AppMethodBeat.m2505o(38848);
            return;
        }
        this.rpO.startAnimation(this.rpS);
        this.rpS.setAnimationListener(new C783633());
        AppMethodBeat.m2505o(38848);
    }

    private void cta() {
        AppMethodBeat.m2504i(38850);
        if (this.rqc == null) {
            AppMethodBeat.m2505o(38850);
            return;
        }
        this.rqc.setPressed(false);
        if (C4054bc.m6399Wi(this.cFI)) {
            this.rqc.setImageResource(C25738R.drawable.f6930vq);
            AppMethodBeat.m2505o(38850);
            return;
        }
        this.rqc.setImageResource(C25738R.drawable.f6932vs);
        AppMethodBeat.m2505o(38850);
    }

    /* renamed from: e */
    private boolean m13940e(List<cat> list, boolean z) {
        AppMethodBeat.m2504i(38851);
        int b = C4977b.m7371b((Context) this, 32.0f);
        int b2 = C4977b.m7371b((Context) this, 6.0f);
        int b3 = C4977b.m7371b((Context) this, 10.0f);
        int b4 = C4977b.m7371b((Context) this, 17.0f);
        if (this.rpL == null) {
            AppMethodBeat.m2505o(38851);
            return false;
        }
        int i;
        C4990ab.m7411d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(((WindowManager) this.mController.ylL.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(C25738R.dimen.f9979m4)));
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.rpL.getParent() != null) {
                this.rpL.setVisibility(8);
            }
            this.rpL.removeAllViews();
            this.rpL.setVisibility(8);
            this.qHj.setVisibility(8);
            AppMethodBeat.m2505o(38851);
            return false;
        }
        this.rpL.getParent();
        this.rpL.removeAllViews();
        this.rpL.setVisibility(0);
        if (this.klY != 10) {
            this.rpL.setBackgroundResource(C25738R.drawable.b68);
        } else if (this.rqq) {
            C46236n li = m13951li(false);
            if (li == null) {
                this.rpL.setBackgroundResource(C25738R.drawable.b6_);
            } else if (this.ecX.equals(li.field_userName)) {
                this.rpL.setBackgroundResource(C25738R.drawable.b6a);
            } else {
                this.rpL.setBackgroundResource(C25738R.drawable.b6_);
            }
        } else {
            this.rpL.setBackgroundResource(C25738R.drawable.b6_);
        }
        this.rpL.setPadding(0, b2, 0, b2);
        ImageView imageView = new ImageView(this.mController.ylL);
        if (this.klY == 10) {
            imageView.setImageResource(C1318a.friendactivity_likeicon_golden);
        } else {
            imageView.setImageResource(C1318a.friendactivity_likeicon);
        }
        imageView.setPadding(b3, b4, b3, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.rpL.addView(imageView);
        b3 = C1338a.fromDPToPix(this.mController.ylL, rqk);
        i = ((int) (f - ((float) b3))) / (b2 + b);
        if (((int) (f - ((float) b3))) % (b2 + b) > b) {
            i++;
        }
        C4990ab.m7411d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i));
        C13679h c13679h = new C13679h(this.mController.ylL);
        c13679h.setClipChildren(false);
        c13679h.setClipToPadding(false);
        c13679h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        c13679h.setLineMaxCounte(i);
        i = 0;
        while (true) {
            b3 = i;
            if (b3 >= list.size()) {
                break;
            }
            cat cat = (cat) list.get(b3);
            StoryTouchImageView storyTouchImageView = new StoryTouchImageView(this.mController.ylL);
            storyTouchImageView.setScaleType(ScaleType.FIT_XY);
            storyTouchImageView.setImageResource(C25738R.drawable.f6736oi);
            storyTouchImageView.rDe.mo9016dk(cat.vHl, 1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b);
            layoutParams2.setMargins(0, b2, b2, 0);
            storyTouchImageView.setLayoutParams(layoutParams2);
            storyTouchImageView.setTag(cat.vHl);
            C40460b.m69439t(storyTouchImageView, cat.vHl);
            storyTouchImageView.setOnClickListener(this.jNC);
            c13679h.addView(storyTouchImageView);
            i = b3 + 1;
        }
        this.rpL.addView(c13679h);
        this.qHj.setVisibility(z ? 8 : 0);
        AppMethodBeat.m2505o(38851);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(38852);
        super.onConfigurationChanged(configuration);
        C46236n YS = C21990h.m33615YS(this.cFc);
        cbf p = C34955aj.m57408p(YS);
        m13940e(p.xaq, p.xat.isEmpty());
        if (this.rpM != null) {
            this.rpM.mo8593a(YS, this.rqo);
        }
        if (this.rqJ != null) {
            this.rqi = C13373af.cnN();
            this.rqJ.setImageViewWidth(this.rqi);
        }
        AppMethodBeat.m2505o(38852);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38853);
        C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i == 15) {
            if (!(this.rqo == null || this.rqo.rJH == null)) {
                this.rqo.rJH.onActivityResult(i, i2, intent);
            }
            AppMethodBeat.m2505o(38853);
        } else if (i == 16) {
            C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            C32566gr c32566gr = new C32566gr();
            c32566gr.cBq.scene = 1;
            C4879a.xxA.mo10055m(c32566gr);
            AppMethodBeat.m2505o(38853);
        } else if (i == 2333) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    if (split.length > 0) {
                        this.rhq.crP.showVKB();
                        stringExtra = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(split[0]);
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            this.rhq.ctg();
                            this.rhq.setText("@" + stringExtra + " ");
                            this.rhq.setCommentAtPrefix("@" + stringExtra + " ");
                            this.rhq.setCommentInfo(new cat());
                            this.rhq.getCommentInfo().vHl = split[0];
                            this.rhq.setCommentFlag(8);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(38853);
        } else if (i2 != -1) {
            AppMethodBeat.m2505o(38853);
        } else {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(38853);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(38854);
        if (c1207m.getType() == 218 && this.rhB != null) {
            this.rhB.dismiss();
        }
        if (i == 0 && i2 == 0) {
            C46236n YS = C21990h.m33615YS(this.cFc);
            if (YS == null) {
                C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.cFc);
                finish();
                AppMethodBeat.m2505o(38854);
                return;
            }
            C4990ab.m7410d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.cFc + "  username:" + YS.field_userName);
            if (this.rpJ == null) {
                C4990ab.m7412e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                AppMethodBeat.m2505o(38854);
                return;
            }
            csX();
            cbf p = C34955aj.m57408p(YS);
            C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "onsceneend " + p.xaq.size() + " " + p.xat.size());
            if (p == null) {
                AppMethodBeat.m2505o(38854);
                return;
            }
            if (!SnsCommentDetailUI.m13943f(this.rpV, p.xaq)) {
                m13940e(p.xaq, p.xat.isEmpty());
                this.rpV = p.xaq;
            }
            if (this.rpM != null) {
                this.rpM.mo8593a(YS, this.rqo);
            }
            C7842b c7842b = this.rpQ;
            LinkedList linkedList = p.xat;
            LinkedList linkedList2 = p.xaq;
            c7842b.rrj = linkedList;
            c7842b.rrk = linkedList2;
            this.rpQ.notifyDataSetChanged();
            new C7306ak().postDelayed(new C78441(), 60);
        }
        AppMethodBeat.m2505o(38854);
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }

    private void csZ() {
        AppMethodBeat.m2504i(38849);
        if (this.mController.ymc == 1 || this.rhq.cte()) {
            this.rqC.run();
            AppMethodBeat.m2505o(38849);
            return;
        }
        this.rho = true;
        AppMethodBeat.m2505o(38849);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(38855);
        if (this.mController.ymc == 2) {
            C4990ab.m7416i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.rpX = false;
            AppMethodBeat.m2505o(38855);
            return;
        }
        if (this.mController.ymc == 1) {
            csY();
            this.rho = false;
            this.rqC.run();
        }
        AppMethodBeat.m2505o(38855);
    }

    /* renamed from: b */
    static /* synthetic */ void m13932b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.m2504i(38858);
        if (snsCommentDetailUI.m13951li(false).cqA().equals(str)) {
            snsCommentDetailUI.rqp.setVisibility(0);
            snsCommentDetailUI.rqp.mo62985El(1);
        }
        AppMethodBeat.m2505o(38858);
    }

    /* renamed from: c */
    static /* synthetic */ void m13935c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.m2504i(38859);
        C13413ap.m21549cZ(str, 4);
        if (snsCommentDetailUI.rpQ != null) {
            snsCommentDetailUI.rpQ.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(38859);
    }

    /* renamed from: d */
    static /* synthetic */ void m13937d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.m2504i(38860);
        C46236n li = snsCommentDetailUI.m13951li(false);
        if (li.cqA().equals(str)) {
            C13413ap.m21550da(str, 4);
            snsCommentDetailUI.rqp.setVisibility(8);
            snsCommentDetailUI.rpK.setTag(new C39828ar(snsCommentDetailUI.cFc, li.cqU(), true, false, 2));
        }
        AppMethodBeat.m2505o(38860);
    }

    /* renamed from: i */
    static /* synthetic */ void m13946i(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38866);
        snsCommentDetailUI.m13950lh(true);
        AppMethodBeat.m2505o(38866);
    }

    /* renamed from: x */
    static /* synthetic */ void m13963x(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.m2504i(38869);
        if (snsCommentDetailUI.rhq != null) {
            snsCommentDetailUI.rhq.mo55636lj(false);
            if (snsCommentDetailUI.rhq.ctd()) {
                snsCommentDetailUI.rhq.rrt = 0;
                snsCommentDetailUI.rhq.ctg();
                snsCommentDetailUI.rhq.setCommentHint(snsCommentDetailUI.getString(C25738R.string.eq9));
                C46236n li = snsCommentDetailUI.m13951li(true);
                if (li != null) {
                    if (!li.mo74253DI(32) || (li.cqu().xfI.wbL & 8) == 0) {
                        snsCommentDetailUI.rhq.mo55637lk(false);
                    } else {
                        snsCommentDetailUI.rhq.mo55637lk(true);
                        AppMethodBeat.m2505o(38869);
                        return;
                    }
                }
                AppMethodBeat.m2505o(38869);
                return;
            }
            snsCommentDetailUI.rhq.state = 0;
        }
        AppMethodBeat.m2505o(38869);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    static /* synthetic */ void m13965z(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        AppMethodBeat.m2504i(38870);
        int count = snsCommentDetailUI.rpQ.getCount() - 1;
        cat commentInfo = snsCommentDetailUI.rhq.getCommentInfo();
        long j = commentInfo.wZG != 0 ? (long) commentInfo.wZG : commentInfo.wZJ;
        if (commentInfo != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= snsCommentDetailUI.rpQ.rrj.size()) {
                    break;
                }
                cat cat = (cat) snsCommentDetailUI.rpQ.rrj.get(i);
                if ((cat.wZG != 0 ? (long) cat.wZG : cat.wZJ) == j) {
                    break;
                }
                i2 = i + 1;
            }
            snsCommentDetailUI.rqC.itemHeight = snsCommentDetailUI.csV();
            if (C34955aj.m57408p(C21990h.m33615YS(snsCommentDetailUI.cFc)).xaq.size() > 0) {
                i++;
                if (i > snsCommentDetailUI.rpQ.getCount()) {
                    i = snsCommentDetailUI.rpQ.getCount() - 1;
                }
            }
            snsCommentDetailUI.rqC.f2135Ro = i;
            snsCommentDetailUI.csZ();
            AppMethodBeat.m2505o(38870);
        }
        i = count;
        snsCommentDetailUI.rqC.itemHeight = snsCommentDetailUI.csV();
        if (C34955aj.m57408p(C21990h.m33615YS(snsCommentDetailUI.cFc)).xaq.size() > 0) {
        }
        snsCommentDetailUI.rqC.f2135Ro = i;
        snsCommentDetailUI.csZ();
        AppMethodBeat.m2505o(38870);
    }

    /* renamed from: F */
    static /* synthetic */ void m13914F(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        AppMethodBeat.m2504i(38872);
        if (C35002v.m57485Zo(snsCommentDetailUI.cFc)) {
            C46236n YS = C21990h.m33615YS(snsCommentDetailUI.cFc);
            if (YS.field_likeFlag == 0) {
                YS.field_likeFlag = 1;
                C21990h.m33617a(YS.cqA(), YS);
                if (YS.mo74253DI(32)) {
                    i = 7;
                }
                C3890a.m6182a(YS, i, "", snsCommentDetailUI.getSource());
                snsCommentDetailUI.rpQ.notifyDataSetChanged();
            } else {
                YS.field_likeFlag = 0;
                C21990h.m33617a(YS.cqA(), YS);
                C3890a.m6181Yd(YS.cqA());
            }
            if (snsCommentDetailUI.rqm != null && (snsCommentDetailUI.rqm instanceof C13665d)) {
                ((C13665d) snsCommentDetailUI.rqm).cuV();
            }
            cbf p = C34955aj.m57408p(C21990h.m33615YS(snsCommentDetailUI.cFc));
            if (p != null) {
                snsCommentDetailUI.rpV = p.xaq;
                snsCommentDetailUI.m13940e(p.xaq, p.xat.isEmpty());
                C7842b c7842b = snsCommentDetailUI.rpQ;
                c7842b.rrk = p.xaq;
                c7842b.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(38872);
    }
}
