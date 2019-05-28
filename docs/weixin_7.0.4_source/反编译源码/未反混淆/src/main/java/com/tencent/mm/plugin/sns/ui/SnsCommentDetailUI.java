package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@i
public class SnsCommentDetailUI extends MMActivity implements f, com.tencent.mm.plugin.sns.b.h.a, com.tencent.mm.plugin.sns.model.b.b {
    public static int rqk = 34;
    private String cFI = "";
    private String cFc;
    private String ecX;
    private com.tencent.mm.sdk.b.c hAA = new com.tencent.mm.sdk.b.c<ke>() {
        {
            AppMethodBeat.i(38783);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(38783);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38784);
            ke keVar = (ke) bVar;
            if (keVar instanceof ke) {
                switch (keVar.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsCommentDetailUI.s(SnsCommentDetailUI.this);
                        break;
                }
            }
            AppMethodBeat.o(38784);
            return false;
        }
    };
    private boolean hOT = false;
    private int jCq = 0;
    private com.tencent.mm.ui.widget.b.a jMO;
    private OnClickListener jNC = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(38822);
            String str = (String) view.getTag();
            ab.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
            Intent intent = new Intent();
            n e = SnsCommentDetailUI.e(SnsCommentDetailUI.this);
            if (e == null || !e.DI(32)) {
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.gkE.c(intent, SnsCommentDetailUI.this);
                AppMethodBeat.o(38822);
                return;
            }
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(SnsCommentDetailUI.f(SnsCommentDetailUI.this), 2, e.field_snsId, 1, 0));
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            com.tencent.mm.plugin.sns.c.a.gkE.c(intent, SnsCommentDetailUI.this);
            AppMethodBeat.o(38822);
        }
    };
    private int klY;
    private int mScreenHeight;
    private int mScreenWidth;
    private ClipboardManager mmO;
    private OnClickListener nij = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(38774);
            ab.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, view);
            AppMethodBeat.o(38774);
        }
    };
    private LinearLayout qHj;
    private p rhB = null;
    private com.tencent.mm.sdk.b.c rhD = new com.tencent.mm.sdk.b.c<qw>() {
        {
            AppMethodBeat.i(38820);
            this.xxI = qw.class.getName().hashCode();
            AppMethodBeat.o(38820);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38821);
            qw qwVar = (qw) bVar;
            if ((qwVar instanceof qw) && SnsCommentDetailUI.this.rpN != null) {
                boolean z;
                ListView a = SnsCommentDetailUI.this.rpN;
                if (qwVar.cNc.enable) {
                    z = false;
                } else {
                    z = true;
                }
                a.requestDisallowInterceptTouchEvent(z);
            }
            AppMethodBeat.o(38821);
            return false;
        }
    };
    private boolean rho;
    private SnsCommentFooter rhq;
    private an rhs;
    private b rhy;
    private com.tencent.mm.plugin.sns.g.b rhz;
    private OnTouchListener riQ = bo.dpE();
    private long rpH = 0;
    private long rpI = 0;
    private View rpJ;
    private TextView rpK;
    private LinearLayout rpL;
    private SnsDetailLuckyHeader rpM;
    private ListView rpN;
    private View rpO;
    private View rpP;
    private b rpQ;
    private ScaleAnimation rpR;
    private ScaleAnimation rpS;
    LinearLayout rpT;
    LinearLayout rpU;
    private LinkedList<cat> rpV;
    private int rpW = -1;
    private boolean rpX = false;
    private aq rpY;
    private String rpZ;
    private com.tencent.mm.sdk.b.c rqA = new com.tencent.mm.sdk.b.c<rz>() {
        {
            AppMethodBeat.i(38804);
            this.xxI = rz.class.getName().hashCode();
            AppMethodBeat.o(38804);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38805);
            rz rzVar = (rz) bVar;
            if (rzVar instanceof rz) {
                String str = rzVar.cNU.id;
                if (rzVar.cNU.type == 1) {
                    SnsCommentDetailUI.d(SnsCommentDetailUI.this, str);
                } else if (rzVar.cNU.type == 2) {
                    SnsCommentDetailUI.e(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(38805);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rqB = new com.tencent.mm.sdk.b.c<gs>() {
        {
            AppMethodBeat.i(38817);
            this.xxI = gs.class.getName().hashCode();
            AppMethodBeat.o(38817);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38818);
            gs gsVar = (gs) bVar;
            if (gsVar instanceof gs) {
                SnsCommentDetailUI.a(SnsCommentDetailUI.this, gsVar.cBr.cBu, gsVar.cBr.cBt, gsVar);
            }
            AppMethodBeat.o(38818);
            return false;
        }
    };
    private c rqC = new c();
    private OnClickListener rqD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(38823);
            ab.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.g(SnsCommentDetailUI.this);
            if (SnsCommentDetailUI.this.rpX) {
                SnsCommentDetailUI.i(SnsCommentDetailUI.this);
                AppMethodBeat.o(38823);
                return;
            }
            AppMethodBeat.o(38823);
        }
    };
    private com.tencent.mm.sdk.b.c rqE = new com.tencent.mm.sdk.b.c<rm>() {
        {
            AppMethodBeat.i(38781);
            this.xxI = rm.class.getName().hashCode();
            AppMethodBeat.o(38781);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38782);
            SnsCommentDetailUI.this.csX();
            AppMethodBeat.o(38782);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rqF = new com.tencent.mm.sdk.b.c<gr>() {
        {
            AppMethodBeat.i(38785);
            this.xxI = gr.class.getName().hashCode();
            AppMethodBeat.o(38785);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return false;
        }
    };
    boolean rqG = false;
    private LinearLayout rqH = null;
    private boolean rqI = false;
    PhotosContent rqJ = null;
    int rqK = 0;
    public com.tencent.mm.model.ao.b.a rqL = new com.tencent.mm.model.ao.b.a() {
        public final void o(String str, final boolean z) {
            AppMethodBeat.i(38799);
            new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38798);
                    if (z && !SnsCommentDetailUI.this.isFinishing() && SnsCommentDetailUI.this.rqK < 5) {
                        SnsCommentDetailUI.this.csX();
                    }
                    SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                    snsCommentDetailUI.rqK++;
                    AppMethodBeat.o(38798);
                }
            }, 500);
            AppMethodBeat.o(38799);
        }
    };
    private bb rqM = null;
    private bd rqa;
    private int rqb = 0;
    private ImageView rqc;
    private j rqd;
    private boolean rqe = false;
    private long rqf = 0;
    private bc rqg;
    private boolean rqh = false;
    private int rqi;
    private int rqj = 103;
    public int rql = 210;
    private com.tencent.mm.plugin.sns.ui.c.a.a rqm;
    private g rqn;
    private com.tencent.mm.plugin.sns.ui.d.b rqo;
    private SnsTranslateResultView rqp;
    private boolean rqq = false;
    private Dialog rqr = null;
    private boolean rqs = false;
    private boolean rqt = false;
    private String rqu = "";
    private boolean rqv = true;
    private int rqw;
    private ag rqx = new ag();
    private com.tencent.mm.sdk.b.c rqy = new com.tencent.mm.sdk.b.c<rx>() {
        {
            AppMethodBeat.i(38772);
            this.xxI = rx.class.getName().hashCode();
            AppMethodBeat.o(38772);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38773);
            rx rxVar = (rx) bVar;
            if (rxVar instanceof rx) {
                String str = rxVar.cNR.id;
                String str2 = rxVar.cNR.result;
                String str3 = rxVar.cNR.cNS;
                if (rxVar.cNR.type == 1) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str, str2, str3);
                } else if (rxVar.cNR.type == 2) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(38773);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rqz = new com.tencent.mm.sdk.b.c<ry>() {
        {
            AppMethodBeat.i(38790);
            this.xxI = ry.class.getName().hashCode();
            AppMethodBeat.o(38790);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38791);
            ry ryVar = (ry) bVar;
            if (ryVar instanceof ry) {
                String str = ryVar.cNT.id;
                if (ryVar.cNT.type == 1) {
                    SnsCommentDetailUI.b(SnsCommentDetailUI.this, str);
                } else if (ryVar.cNT.type == 2) {
                    SnsCommentDetailUI.c(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(38791);
            return false;
        }
    };

    class a extends o {
        a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(38827);
            SnsCommentDetailUI.this.rqg.rDs.onClick(view);
            AppMethodBeat.o(38827);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(38828);
            int color = SnsCommentDetailUI.this.getResources().getColor(R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.o(38828);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.o(38828);
        }
    }

    class b extends BaseAdapter {
        Activity activity;
        String cwT;
        public LinkedList<cat> rrj;
        LinkedList<cat> rrk;

        class a {
            ImageView ejo;
            TextView gKl;
            Object info;
            TextView pnE;
            SnsTranslateResultView rrm;
            cat rrn;
            TextView timeTv;
            String userName;

            a() {
            }
        }

        public b(LinkedList<cat> linkedList, LinkedList<cat> linkedList2, Activity activity, String str) {
            this.rrj = linkedList;
            this.rrk = linkedList2;
            this.activity = activity;
            this.cwT = str;
        }

        public final int getCount() {
            int i = 0;
            AppMethodBeat.i(38831);
            if (this.rrk.size() > 0) {
                if (this.rrj != null) {
                    i = this.rrj.size();
                }
                i++;
                AppMethodBeat.o(38831);
                return i;
            } else if (this.rrj == null) {
                AppMethodBeat.o(38831);
                return 0;
            } else {
                i = this.rrj.size();
                AppMethodBeat.o(38831);
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
            a aVar;
            CharSequence Oj;
            AppMethodBeat.i(38832);
            if (this.rrk.size() > 0) {
                if (i == 0) {
                    LinearLayout H = SnsCommentDetailUI.this.qHj;
                    AppMethodBeat.o(38832);
                    return H;
                }
                i--;
            }
            cat cat = (cat) this.rrj.get(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = v.hu(this.activity).inflate(R.layout.av2, null);
                view.setOnTouchListener(SnsCommentDetailUI.this.riQ);
                a aVar2 = new a();
                aVar2.ejo = (ImageView) view.findViewById(R.id.ei_);
                aVar2.ejo.setOnClickListener(SnsCommentDetailUI.this.jNC);
                aVar2.pnE = (TextView) view.findViewById(R.id.eib);
                aVar2.pnE.setOnTouchListener(new aa());
                aVar2.pnE.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(38830);
                        ab.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                        AppMethodBeat.o(38830);
                    }
                });
                aVar2.timeTv = (TextView) view.findViewById(R.id.eia);
                aVar2.gKl = (TextView) view.findViewById(R.id.eic);
                aVar2.gKl.setOnTouchListener(new aa());
                aVar2.rrm = (SnsTranslateResultView) view.findViewById(R.id.ehu);
                aVar2.rrm.setVisibility(8);
                if (SnsCommentDetailUI.this.klY == 10) {
                    view.findViewById(R.id.ei7).setBackgroundResource(R.drawable.b69);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                aVar = (a) view.getTag();
            }
            aVar.rrn = cat;
            aVar.userName = cat.vHl;
            ((SnsAvatarImageView) aVar.ejo).dk(cat.vHl, 3);
            ((SnsAvatarImageView) aVar.ejo).setWeakContext(this.activity);
            int i2 = SnsCommentDetailUI.this.klY == 10 ? 3 : 2;
            SnsCommentDetailUI.this.klY;
            com.tencent.mm.kernel.g.RQ();
            ad aoM = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoM(aVar.userName);
            if (i == 0 && this.rrk.isEmpty()) {
                if (SnsCommentDetailUI.this.klY == 10) {
                    view.setBackgroundResource(R.drawable.b6_);
                } else {
                    view.setBackgroundResource(R.drawable.a0x);
                }
            } else if (SnsCommentDetailUI.this.klY == 10) {
                view.setBackgroundResource(R.drawable.a10);
            } else {
                view.setBackgroundResource(R.drawable.a0z);
            }
            if (i == 0) {
                view.findViewById(R.id.ei9).setVisibility(0);
                view.findViewById(R.id.ei8).setVisibility(8);
                if (SnsCommentDetailUI.this.klY == 10) {
                    ((ImageView) view.findViewById(R.id.ei9)).setImageResource(R.raw.friendactivity_writeicon_golden);
                }
            } else {
                view.findViewById(R.id.ei9).setVisibility(4);
                view.findViewById(R.id.ei8).setVisibility(0);
            }
            com.tencent.mm.pluginsdk.ui.a.b.t(aVar.ejo, cat.vHl);
            aVar.ejo.setTag(cat.vHl);
            if (aoM != null) {
                Oj = aoM.Oj();
            } else {
                Object Oj2 = cat.wCW != null ? cat.wCW : cat.vHl;
            }
            n YS = h.YS(SnsCommentDetailUI.this.cFc);
            if (YS != null) {
                aVar.gKl.setText(cat.ncM + " ");
                CharSequence a = d.a(SnsCommentDetailUI.this, cat, SnsCommentDetailUI.this.rqd, YS.field_type, YS.field_userName, 2);
                aVar.pnE.setText(Oj2, BufferType.SPANNABLE);
                com.tencent.mm.pluginsdk.ui.e.j.h(aVar.pnE, i2);
                k kVar = new k(aVar.pnE.getText());
                ab.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", cat.vHl, Oj2);
                kVar.a(new o(cat.vHl, SnsCommentDetailUI.this.rqd, i2), Oj2, 0);
                aVar.pnE.setText(kVar, BufferType.SPANNABLE);
                aVar.timeTv.setText(aw.m(this.activity, ((long) cat.pcX) * 1000));
                aVar.gKl.setText(a, BufferType.SPANNABLE);
                aVar.gKl.setVisibility(0);
                SnsCommentDetailUI.this.jMO.c(view, SnsCommentDetailUI.this.rqo.rJU, SnsCommentDetailUI.this.rqo.rJH);
                SnsCommentDetailUI.this.jMO.c(aVar.gKl, SnsCommentDetailUI.this.rqo.rJU, SnsCommentDetailUI.this.rqo.rJH);
                String ga = ap.ga(SnsCommentDetailUI.this.cFc, String.valueOf(cat.wZG != 0 ? (long) cat.wZG : cat.wZJ));
                if (ap.db(ga, 4) && aVar.rrm != null) {
                    com.tencent.mm.plugin.sns.model.ap.b Ye = ap.Ye(ga);
                    if (Ye != null) {
                        aVar.rrm.setVisibility(0);
                        if (!Ye.foa) {
                            aVar.rrm.El(2);
                        } else if (Ye.aAR) {
                            aVar.rrm.setVisibility(8);
                        } else {
                            aVar.rrm.a(Ye, 2, Ye.result, Ye.fwM, Ye.qMV);
                        }
                    } else {
                        aVar.rrm.setVisibility(8);
                    }
                }
                view.setClickable(true);
                ab.d("MicroMsg.SnsCommentDetailUI", "position " + cat.vHl + " self " + SnsCommentDetailUI.this.ecX + " commentid " + cat.wZG + " snsid " + SnsCommentDetailUI.this.cFc);
                if (SnsCommentDetailUI.this.ecX.equals(cat.vHl)) {
                    aVar.info = cat;
                } else {
                    aVar.info = new Object[]{Integer.valueOf(i), cat, cat.vHl, Oj2};
                }
                l lVar = new l(SnsCommentDetailUI.this.rpZ, SnsCommentDetailUI.this.cFc, cat, cat.vHl, cat.ncM, aVar.gKl, 2);
                lVar.tag = aVar;
                view.setTag(lVar);
                aVar.gKl.setTag(lVar);
                view.setOnClickListener(SnsCommentDetailUI.this.nij);
                aVar.gKl.setOnClickListener(SnsCommentDetailUI.this.nij);
            }
            AppMethodBeat.o(38832);
            return view;
        }
    }

    class c implements Runnable {
        int Ro = -1;
        int itemHeight;
        private int offset = 0;
        private int rro = -1;
        private int rrp = 10;

        c() {
        }

        public final void run() {
            AppMethodBeat.i(38833);
            this.rrp = 10;
            SnsCommentDetailUI.this.rpX = true;
            this.rro = SnsCommentDetailUI.this.rhq.getTop();
            int i = this.rro - this.itemHeight;
            ab.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", Integer.valueOf(SnsCommentDetailUI.this.rpN.getBottom()), Integer.valueOf(SnsCommentDetailUI.this.rpW), Integer.valueOf(this.rro), Integer.valueOf(SnsCommentDetailUI.this.rhq.getTop()), Integer.valueOf(i));
            if (i == this.offset) {
                SnsCommentDetailUI.this.rpN.setSelectionFromTop(SnsCommentDetailUI.this.rpN.getHeaderViewsCount() + this.Ro, i);
                this.rrp = 0;
                this.offset = 0;
                AppMethodBeat.o(38833);
                return;
            }
            int i2 = this.rrp;
            this.rrp = i2 - 1;
            if (i2 > 0) {
                new ak().postDelayed(this, 100);
                this.offset = i;
                AppMethodBeat.o(38833);
                return;
            }
            this.offset = 0;
            this.rrp = 0;
            AppMethodBeat.o(38833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$35 */
    class AnonymousClass35 implements AnimationListener {
        boolean rrc = false;
        final /* synthetic */ LinearLayout rrd;

        AnonymousClass35(LinearLayout linearLayout) {
            this.rrd = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(38819);
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
            AppMethodBeat.o(38819);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsCommentDetailUI() {
        AppMethodBeat.i(38834);
        AppMethodBeat.o(38834);
    }

    static /* synthetic */ int A(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38871);
        int csV = snsCommentDetailUI.csV();
        AppMethodBeat.o(38871);
        return csV;
    }

    static /* synthetic */ n e(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38863);
        n li = snsCommentDetailUI.li(true);
        AppMethodBeat.o(38863);
        return li;
    }

    static /* synthetic */ void g(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38865);
        snsCommentDetailUI.csY();
        AppMethodBeat.o(38865);
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38868);
        snsCommentDetailUI.cta();
        AppMethodBeat.o(38868);
    }

    private static boolean f(LinkedList<cat> linkedList, LinkedList<cat> linkedList2) {
        AppMethodBeat.i(38835);
        if (linkedList == null || linkedList2 == null) {
            AppMethodBeat.o(38835);
            return false;
        } else if (linkedList.size() != linkedList2.size()) {
            AppMethodBeat.o(38835);
            return false;
        } else {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                if (((cat) linkedList.get(i)).vHl.equals(((cat) linkedList2.get(i)).vHl)) {
                    i++;
                } else {
                    AppMethodBeat.o(38835);
                    return false;
                }
            }
            AppMethodBeat.o(38835);
            return true;
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    private void lh(boolean z) {
        AppMethodBeat.i(38836);
        this.rpX = false;
        if (this.rhq.ctd()) {
            this.rhq.rrt = 0;
            this.rhq.ctg();
            this.rhq.setCommentHint(getString(R.string.eq9));
        }
        this.rhq.lj(false);
        if (z) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.rpN);
        }
        AppMethodBeat.o(38836);
    }

    private n li(boolean z) {
        n YS;
        AppMethodBeat.i(38837);
        if (bo.isNullOrNil(this.rpZ)) {
            YS = h.YS(this.cFc);
            if (YS == null) {
                finish();
                AppMethodBeat.o(38837);
                return null;
            }
            this.rpZ = YS.cqU();
        } else {
            YS = h.YT(this.rpZ);
            if (YS == null) {
                if (z) {
                    Toast.makeText(this, R.string.emz, 0).show();
                }
                finish();
                AppMethodBeat.o(38837);
                return null;
            }
            this.cFc = YS.cqA();
        }
        AppMethodBeat.o(38837);
        return YS;
    }

    private int getSource() {
        if (this.rqw == 16) {
            return 2;
        }
        return 1;
    }

    private com.tencent.mm.plugin.sns.storage.a f(n nVar) {
        AppMethodBeat.i(38838);
        com.tencent.mm.plugin.sns.storage.a cqr;
        if (nVar == null) {
            AppMethodBeat.o(38838);
            return null;
        } else if (getSource() == 2) {
            cqr = nVar.cqr();
            AppMethodBeat.o(38838);
            return cqr;
        } else {
            cqr = nVar.cqq();
            AppMethodBeat.o(38838);
            return cqr;
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(38839);
        com.tencent.mm.pluginsdk.f.m(this);
        super.onCreate(bundle);
        com.tencent.mm.ui.b.c(this, true);
        af.cnv().a(5, "@__weixintimtline", this);
        this.mmO = (ClipboardManager) getApplicationContext().getSystemService("clipboard");
        Point hy = ae.hy(this);
        this.mScreenWidth = hy.x;
        this.mScreenHeight = hy.y;
        this.rpH = System.currentTimeMillis();
        this.jMO = new com.tencent.mm.ui.widget.b.a(this);
        this.rqw = getIntent().getIntExtra("INTENT_COMMENT_TYPE", 0);
        this.cFc = bo.bc(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (bo.isNullOrNil(this.cFc)) {
            this.cFc = com.tencent.mm.plugin.sns.storage.v.ao("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.rpZ = bo.bc(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (bo.isNullOrNil(this.rpZ)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.rpZ = com.tencent.mm.plugin.sns.storage.v.ao("sns_table_", (long) intExtra);
            }
        }
        this.rqo = new com.tencent.mm.plugin.sns.ui.d.b(getSource(), this, this.rqx) {
            public final void b(View view, int i, int i2, int i3) {
            }

            public final void cp(Object obj) {
                AppMethodBeat.i(38775);
                SnsCommentDetailUI.g(SnsCommentDetailUI.this);
                SnsCommentDetailUI.this.rhs.t((View) obj, 2, SnsCommentDetailUI.f(SnsCommentDetailUI.this));
                AppMethodBeat.o(38775);
            }

            public final void crE() {
            }

            public final void dJ(View view) {
            }

            public final void dI(View view) {
            }

            public final void dG(View view) {
            }

            public final void dH(View view) {
            }

            public final void dK(View view) {
                AppMethodBeat.i(38776);
                SnsCommentDetailUI.this.rhy.dF(view);
                AppMethodBeat.o(38776);
            }

            public final void crF() {
                AppMethodBeat.i(38777);
                SnsCommentDetailUI.this.rhy.crv();
                AppMethodBeat.o(38777);
            }

            public final void dL(View view) {
                AppMethodBeat.i(38778);
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                SnsCommentDetailUI.this.setResult(-1, intent);
                if (!(view.getTag() == null || SnsCommentDetailUI.this.rqn == null)) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    SnsCommentDetailUI.this.rqn.j(bVar.position, bVar.cwT, 2);
                }
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(38778);
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.avv);
        this.rhz = new com.tencent.mm.plugin.sns.g.b(this, this.rqo, frameLayout);
        this.rhy = new b(this, this.rqo, frameLayout, this.rhz);
        this.rqo.bIB();
        this.rqt = getIntent().getBooleanExtra("intent_show_collapse_info", false);
        this.rqu = getIntent().getStringExtra("intent_content_collapse_hint");
        this.rqg = new bc(this, new com.tencent.mm.plugin.sns.ui.bc.a() {
            public final void ctb() {
                AppMethodBeat.i(38779);
                SnsCommentDetailUI.s(SnsCommentDetailUI.this);
                AppMethodBeat.o(38779);
            }
        }, getSource(), this.rqx);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            TimeLineObject timeLineObject = new TimeLineObject();
            try {
                timeLineObject.parseFrom(byteArrayExtra);
                if (af.cnF().kD(new BigInteger(timeLineObject.Id).longValue()) == null) {
                    ab.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    n nVar = new n();
                    nVar.field_snsId = new BigInteger(timeLineObject.Id).longValue();
                    try {
                        nVar.field_content = timeLineObject.toByteArray();
                    } catch (Exception e) {
                    }
                    nVar.field_createTime = timeLineObject.pcX;
                    nVar.field_userName = timeLineObject.jBB;
                    nVar.field_type = timeLineObject.xfI.wbJ;
                    nVar.cqR();
                    cbf cbf = new cbf();
                    cbf.xam = new SKBuiltinBuffer_t();
                    try {
                        nVar.field_attrBuf = cbf.toByteArray();
                    } catch (IOException e2) {
                    }
                    af.cnF().b((com.tencent.mm.sdk.e.c) nVar);
                    ab.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    ab.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        n li = li(true);
        ab.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.cFc + " localSnsId: " + this.rpZ);
        if (li != null) {
            ab.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", bo.bc(li.field_userName, ""));
        }
        if (com.tencent.mm.plugin.sns.storage.v.Zo(this.cFc)) {
            if (!com.tencent.mm.plugin.sns.storage.v.WT(this.cFc)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new m(com.tencent.mm.plugin.sns.storage.v.Zm(this.cFc), 0, f(li).qTU), 0);
            } else if (li == null) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new q(com.tencent.mm.plugin.sns.storage.v.Zm(this.cFc)), 0);
            } else if (!t.mX(li.field_userName)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new q(com.tencent.mm.plugin.sns.storage.v.Zm(this.cFc)), 0);
            }
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(210, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(218, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(213, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(682, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(214, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(683, (f) this);
        this.rqa = af.cnt();
        this.rhs = new an(this);
        this.rpY = new aq(this.mController.ylL);
        this.rqd = new j(this, getSource(), this.rqx);
        if (li != null) {
            this.klY = au.b(li, false);
        }
        if (li != null && li.DI(32)) {
            if (this.rqw == 16) {
                this.rqn = new g(2);
            } else {
                this.rqn = new g(1);
            }
            this.rqn.a(this.mScreenHeight, getSupportActionBar().getCustomView(), this);
            au.b(li, false);
        }
        initView();
        if (li != null && li.DI(32)) {
            this.rqn.a(0, li.cqU(), li.cqQ(), this.rpJ, li.field_snsId, aj.p(li), this.klY, 2);
        }
        if (!(this.rpJ == null || li == null)) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.rpJ.findViewById(R.id.bl);
            if (li.cqu().xfI != null && li.cqu().xfI.wbJ == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).qyA.cla();
            }
            com.tencent.mm.plugin.sns.a.b.j.a(li, true, z, getSource());
        }
        if (this.rpN == null) {
            AppMethodBeat.o(38839);
            return;
        }
        this.rpN.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38780);
                if (SnsCommentDetailUI.this.rhy != null) {
                    SnsCommentDetailUI.this.rhy.cox();
                }
                AppMethodBeat.o(38780);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqy);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqz);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqA);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqB);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqE);
        com.tencent.mm.sdk.b.a.xxA.c(this.rqF);
        com.tencent.mm.sdk.b.a.xxA.c(this.rhD);
        com.tencent.mm.pluginsdk.f.n(this);
        AppMethodBeat.o(38839);
    }

    public void onDestroy() {
        AppMethodBeat.i(38840);
        af.cnv().a(this, 5);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(210, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(218, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(213, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(214, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(683, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(682, (f) this);
        af.cnC().ab(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        if (this.rqd != null) {
            this.rqd.activity = null;
        }
        aa.crX();
        if (this.rhq != null) {
            this.rhq.bMO();
        }
        n li = li(false);
        if (li != null && li.DI(32)) {
            if (this.rqn != null) {
                this.rqn.j(0, li.cqU(), 2);
            }
            com.tencent.mm.plugin.sns.storage.a f = f(li);
            String str = f == null ? "" : f.qPj;
            com.tencent.mm.plugin.sns.a.b.i cnz;
            Object[] objArr;
            if (li.coX()) {
                cnz = af.cnz();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(li.field_snsId, com.tencent.mm.plugin.sns.data.i.jV(li.field_snsId), str, Long.valueOf(this.rpH), Long.valueOf(System.currentTimeMillis()));
                cnz.e(14652, objArr);
            } else {
                cnz = af.cnz();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(li.field_snsId, com.tencent.mm.plugin.sns.data.i.jV(li.field_snsId), str, Long.valueOf(this.rpH), Long.valueOf(System.currentTimeMillis()));
                cnz.e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT, objArr);
            }
            com.tencent.mm.modelsns.b lZ = com.tencent.mm.modelsns.b.lZ(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            lZ.tx(com.tencent.mm.plugin.sns.data.i.jV(li.field_snsId)).tx(str).tx(this.rpH).tx(System.currentTimeMillis());
            lZ.ajK();
        }
        this.rqo.removeListener();
        com.tencent.mm.sdk.b.a.xxA.d(this.rqy);
        com.tencent.mm.sdk.b.a.xxA.d(this.rqz);
        com.tencent.mm.sdk.b.a.xxA.d(this.rqA);
        com.tencent.mm.sdk.b.a.xxA.d(this.rqB);
        com.tencent.mm.sdk.b.a.xxA.d(this.rqE);
        com.tencent.mm.sdk.b.a.xxA.d(this.rqF);
        com.tencent.mm.sdk.b.a.xxA.d(this.rhD);
        super.onDestroy();
        AppMethodBeat.o(38840);
    }

    public void onResume() {
        AppMethodBeat.i(38841);
        af.cnA().a((com.tencent.mm.plugin.sns.model.b.b) this);
        tn tnVar = new tn();
        tnVar.cPI.cPJ = 0;
        tnVar.cPI.cPK = 1;
        tnVar.cPI.cPL = 0;
        tnVar.cPI.type = 0;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        if (this.rqn != null) {
            this.rqn.onResume();
        }
        if (this.rqm != null) {
            this.rqm.refreshView();
        }
        super.onResume();
        AppMethodBeat.o(38841);
    }

    public void onPause() {
        AppMethodBeat.i(38842);
        af.cnA().b((com.tencent.mm.plugin.sns.model.b.b) this);
        super.onPause();
        this.rhq.eAk.onPause();
        new tn().cPI.type = 1;
        if (this.rqn != null) {
            this.rqn.onPause();
        }
        AppMethodBeat.o(38842);
    }

    public final int getLayoutId() {
        return R.layout.av0;
    }

    public final void initView() {
        AppMethodBeat.i(38843);
        setMMTitle((int) R.string.ek2);
        AnonymousClass17 anonymousClass17 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38796);
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(SnsCommentDetailUI.this.rpN);
                AppMethodBeat.o(38796);
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38797);
                if (SnsCommentDetailUI.this.rhq != null) {
                    SnsCommentDetailUI.this.rhq.lj(false);
                }
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(38797);
                return true;
            }
        });
        this.ecX = r.Yz();
        if (af.cnn()) {
            finish();
        }
        final n li = li(true);
        if (li == null) {
            ab.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.cFc);
            finish();
            AppMethodBeat.o(38843);
            return;
        }
        boolean z;
        ab.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.cFc + "localId " + this.rpZ + "  username:" + li.field_userName);
        TextView textView = (TextView) findViewById(R.id.ehi);
        if (this.rqt) {
            textView.setVisibility(0);
            textView.setText(this.rqu);
        } else {
            textView.setVisibility(8);
        }
        if (!com.tencent.mm.plugin.sns.storage.v.Zo(this.cFc) && li.cqW()) {
            bav cqM = li.cqM();
            findViewById(R.id.ehj).setVisibility(0);
            textView = (TextView) findViewById(R.id.ehk);
            switch (cqM.wFm) {
                case 201:
                    if (bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(R.string.enn);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(R.id.ehl).setVisibility(8);
                    z = false;
                    break;
                case 210:
                    if (bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(R.string.enp);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(R.id.ehl).setVisibility(8);
                    z = false;
                    break;
                case 211:
                    if (bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(R.string.eno);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(R.id.ehl).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (bo.isNullOrNil(cqM.wFu)) {
                        textView.setText(R.string.enq);
                    } else {
                        textView.setText(cqM.wFu);
                    }
                    findViewById(R.id.ehl).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(R.id.ehj).setVisibility(8);
        z = false;
        if (z) {
            findViewById(R.id.ehj).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38786);
                    if (li.DI(32)) {
                        AppMethodBeat.o(38786);
                        return;
                    }
                    aj.Da(li.reX);
                    aj.CY(li.reX);
                    af.cnB().cmp();
                    Intent intent = new Intent();
                    SnsCommentDetailUI.this.setResult(-1, intent);
                    if (SnsCommentDetailUI.this.hOT) {
                        intent.putExtra("sns_gallery_force_finish", true);
                    }
                    SnsCommentDetailUI.this.finish();
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.o(38786);
                }
            });
        }
        this.rpN = (ListView) findViewById(R.id.ehm);
        this.rpN.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38787);
                SnsCommentDetailUI.this.rpW = SnsCommentDetailUI.this.rpN.getBottom();
                ab.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.this.rpW);
                AppMethodBeat.o(38787);
            }
        });
        this.rpN.setOnScrollListener(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(38788);
                if (i2 > 0) {
                    if (i == 0 && !SnsCommentDetailUI.this.rqv) {
                        SnsCommentDetailUI.this.rqv = true;
                        if (SnsCommentDetailUI.this.rqm != null) {
                            SnsCommentDetailUI.this.rqm.refreshView();
                            AppMethodBeat.o(38788);
                            return;
                        } else if (SnsCommentDetailUI.this.rpJ != null) {
                            SnsCommentDetailUI.this.csX();
                            AppMethodBeat.o(38788);
                            return;
                        }
                    } else if (i > 0) {
                        SnsCommentDetailUI.this.rqv = false;
                    }
                }
                AppMethodBeat.o(38788);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(38789);
                if (i == 1) {
                    SnsCommentDetailUI.this.aqX();
                    SnsCommentDetailUI.x(SnsCommentDetailUI.this);
                }
                if (i == 0 && SnsCommentDetailUI.this.rqn != null) {
                    SnsCommentDetailUI.this.rqn.kH(true);
                }
                AppMethodBeat.o(38789);
            }
        });
        this.rpJ = v.hu(this.mController.ylL).inflate(R.layout.av1, null);
        this.rpP = this.rpJ.findViewById(R.id.ehv);
        this.rpJ.setOnClickListener(this.rqD);
        this.rpN.addHeaderView(this.rpJ);
        z = csX();
        if (z) {
            n li2 = li(false);
            if (li2 != null) {
                this.klY = au.b(li2, false);
            }
            if (this.klY == 10 && r.Yz().equals(li.field_userName)) {
                this.rpM = new SnsDetailLuckyHeader(this);
                this.rpM.setLayoutParams(new LayoutParams(-1, -2));
                this.rpM.setOnClickListener(this.rqD);
            }
            this.rpL = new LinearLayout(this.mController.ylL);
            this.rpL.setLayoutParams(new LayoutParams(-1, -2));
            this.rpL.setOnClickListener(this.rqD);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 2.0f);
            LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.mController.ylL);
            linearLayout.setBackgroundResource(R.drawable.a13);
            linearLayout.setLayoutParams(layoutParams);
            this.qHj = linearLayout;
            if ((li.field_localPrivate & 1) != 0) {
                findViewById(R.id.avz).setVisibility(8);
                textView = new TextView(this);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setText(getString(R.string.ek9));
                textView.setTextColor(getResources().getColor(R.color.h4));
                textView.setGravity(17);
                textView.setPadding(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 7.0f), 0, 0);
                this.rpN.addFooterView(textView);
            }
            if (this.rpM != null) {
                this.rqq = true;
                this.rpN.addHeaderView(this.rpM);
            }
            cbf p = aj.p(li);
            if (p == null) {
                this.rpL.setVisibility(8);
                this.rpQ = new b(new LinkedList(), new LinkedList(), this, li.cqU());
            } else {
                this.rpV = p.xaq;
                e(p.xaq, p.xat.isEmpty());
                if (this.rpM != null) {
                    this.rpM.a(li, this.rqo);
                }
                this.rpQ = new b(p.xat, p.xaq, this, li.cqU());
            }
            this.rpN.addHeaderView(this.rpL);
            this.rpN.setAdapter(this.rpQ);
            this.rhq = (SnsCommentFooter) findViewById(R.id.avz);
            this.rhq.setOnEditTouchListener(new a() {
                public final void ctc() {
                    AppMethodBeat.i(38792);
                    if (com.tencent.mm.plugin.sns.lucky.a.m.Xx(li.cqU())) {
                        if (SnsCommentDetailUI.this.mController.ymc == 1 || SnsCommentDetailUI.this.rhq.cte()) {
                            AppMethodBeat.o(38792);
                            return;
                        }
                        SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                        AppMethodBeat.o(38792);
                    } else if (SnsCommentDetailUI.this.rqr == null || !SnsCommentDetailUI.this.rqr.isShowing()) {
                        SnsCommentDetailUI.this.rqr = com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.DT(0));
                        AppMethodBeat.o(38792);
                    } else {
                        AppMethodBeat.o(38792);
                    }
                }
            });
            this.rhq.setOnSmileyShowListener(new c() {
                public final void onShow() {
                    AppMethodBeat.i(38793);
                    if (SnsCommentDetailUI.this.rhq.rrw) {
                        AppMethodBeat.o(38793);
                        return;
                    }
                    SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                    AppMethodBeat.o(38793);
                }
            });
            li2 = li(true);
            if (!(li2 == null || li2.cqT())) {
                this.rhq.setVisibility(8);
            }
            this.rhq.setAfterEditAction(this.rqC);
            this.rhq.ctf();
            this.rhq.setOnCommentSendImp(new b() {
                public final void Zr(String str) {
                    int i = 8;
                    AppMethodBeat.i(38794);
                    if (com.tencent.mm.plugin.sns.lucky.a.m.Xx(li.cqU())) {
                        int commentFlag;
                        if (li.DI(32)) {
                            commentFlag = SnsCommentDetailUI.this.rhq.getCommentFlag();
                        } else {
                            commentFlag = 0;
                        }
                        if (d.fF(commentFlag, 8)) {
                            String substring = str.substring(SnsCommentDetailUI.this.rhq.getCommentAtPrefix().length());
                            ab.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
                            com.tencent.mm.plugin.sns.model.am.a.a(li, 16, substring, SnsCommentDetailUI.this.rhq.getCommentInfo(), commentFlag, SnsCommentDetailUI.f(SnsCommentDetailUI.this));
                        } else {
                            ab.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
                            n nVar = li;
                            if (!li.DI(32)) {
                                i = 2;
                            }
                            com.tencent.mm.plugin.sns.model.am.a.a(nVar, i, str, SnsCommentDetailUI.this.rhq.getCommentInfo(), commentFlag, SnsCommentDetailUI.f(SnsCommentDetailUI.this));
                        }
                        SnsCommentDetailUI.this.rhq.setText("");
                        SnsCommentDetailUI.this.rhq.lj(false);
                        ab.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                        SnsCommentDetailUI.x(SnsCommentDetailUI.this);
                        AppMethodBeat.o(38794);
                        return;
                    }
                    if (SnsCommentDetailUI.this.rqJ.DT(0) != null) {
                        com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.DT(0));
                    }
                    AppMethodBeat.o(38794);
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
                            ad aoO = this.rqa.aoO(cat.vHl);
                            String Oj = aoO != null ? aoO.Oj() : cat.wCW != null ? cat.wCW : cat.vHl;
                            this.rhq.rrt = 0;
                            this.rhq.ctg();
                            this.rhq.setCommentHint(getString(R.string.env) + Oj);
                            this.rhq.setCommentInfo(cat);
                            if (p.xaq.size() > 0) {
                                i2 = i + 1;
                                if (i2 > this.rpQ.getCount()) {
                                    i2 = this.rpQ.getCount() - 1;
                                }
                            } else {
                                i2 = i;
                            }
                            this.rqC.Ro = i2;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (this.rqe) {
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38795);
                        SnsCommentDetailUI.this.aqX();
                        SnsCommentDetailUI.this.rqC.itemHeight = SnsCommentDetailUI.A(SnsCommentDetailUI.this);
                        SnsCommentDetailUI.this.rqC.run();
                        AppMethodBeat.o(38795);
                    }
                }, 100);
            }
            this.rqp = (SnsTranslateResultView) this.rpJ.findViewById(R.id.ehu);
            this.rqp.setResultTextSize(((TextView) this.rpJ.findViewById(R.id.ld)).getTextSize());
            this.rqp.getResultTextView().setBackgroundResource(R.drawable.a0t);
            this.rqp.getResultTextView().setTag(new ar(this.cFc, li.cqU(), false, true, 2));
            this.jMO.c(this.rqp.getResultTextView(), this.rqo.rJK, this.rqo.rJH);
            if (ap.db(this.cFc, 4)) {
                com.tencent.mm.plugin.sns.model.ap.b Ye = ap.Ye(this.cFc);
                if (Ye == null || !Ye.foa) {
                    this.rqp.setVisibility(8);
                    AppMethodBeat.o(38843);
                    return;
                }
                this.rqp.setVisibility(0);
                this.rqp.a(null, 1, Ye.result, Ye.fwM, false);
                AppMethodBeat.o(38843);
                return;
            }
            this.rqp.setVisibility(8);
            AppMethodBeat.o(38843);
            return;
        }
        ab.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(z)));
        finish();
        AppMethodBeat.o(38843);
    }

    private int csV() {
        AppMethodBeat.i(38844);
        if (this.rpN != null && this.rpN.getChildCount() > 1) {
            View childAt = this.rpN.getChildAt(0);
            if (childAt != null) {
                int height = childAt.getHeight();
                AppMethodBeat.o(38844);
                return height;
            }
        }
        AppMethodBeat.o(38844);
        return 0;
    }

    private LinearLayout DV(int i) {
        AppMethodBeat.i(38845);
        LinearLayout linearLayout;
        if (this.rqH == null) {
            this.rqH = (LinearLayout) v.hu(this).inflate(i, null);
            linearLayout = this.rqH;
            AppMethodBeat.o(38845);
            return linearLayout;
        }
        this.rqG = true;
        linearLayout = this.rqH;
        AppMethodBeat.o(38845);
        return linearLayout;
    }

    private static boolean csW() {
        AppMethodBeat.i(38846);
        if ((com.tencent.mm.plugin.sns.model.am.a.coe() & 1) <= 0) {
            AppMethodBeat.o(38846);
            return true;
        }
        AppMethodBeat.o(38846);
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
        AppMethodBeat.i(38847);
        final n li = li(true);
        if (li == null) {
            AppMethodBeat.o(38847);
            return false;
        }
        ab.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.rpJ.toString());
        this.rqi = af.cnN();
        TimeLineObject cqu = li.cqu();
        this.klY = au.b(li, false);
        final SnsAvatarImageView snsAvatarImageView = (SnsAvatarImageView) this.rpJ.findViewById(R.id.ehn);
        if (snsAvatarImageView == null || li == null) {
            ab.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (snsAvatarImageView == null) + " " + (li == null));
            AppMethodBeat.o(38847);
            return false;
        }
        CharSequence charSequence;
        Object charSequence2;
        int i;
        k kVar;
        String str;
        ViewStub viewStub;
        int width;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        final ad adVar;
        cbf p;
        ImageButton imageButton;
        n li2;
        final ImageView imageView;
        final ImageView imageView2;
        final TextView textView;
        final TextView textView2;
        final n nVar;
        snsAvatarImageView.setWeakContext(this);
        snsAvatarImageView.eSe = li.cqU();
        snsAvatarImageView.setTag(li.getUserName());
        if (li.cqo() == null || !li.cqo().qVa) {
            if (!li.getUserName().endsWith("@ad")) {
                com.tencent.mm.pluginsdk.ui.a.b.t(snsAvatarImageView, li.getUserName());
                snsAvatarImageView.dk(li.getUserName(), 2);
                bo.isEqual(this.ecX, li.getUserName());
            }
        } else if (!bo.isNullOrNil(li.cqo().qVc)) {
            snsAvatarImageView.setTag(R.id.cl, li.cqo().qVc);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(li.cqo().qVc, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(38800);
                    ab.i("MicroMsg.SnsCommentDetailUI", "download img %s", str);
                    if (!bo.Q((String) snsAvatarImageView.getTag(R.id.cl), str) && str.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gj("adId", (String) snsAvatarImageView.getTag(R.id.cl)))) {
                        Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                        if (decodeFile != null) {
                            snsAvatarImageView.setImageBitmap(decodeFile);
                        }
                    }
                    AppMethodBeat.o(38800);
                }
            });
        }
        snsAvatarImageView.setOnClickListener(this.rqo.rJI);
        TextView textView3 = (TextView) this.rpJ.findViewById(R.id.b6e);
        com.tencent.mm.kernel.g.RQ();
        ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(li.getUserName());
        ab.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + li.getUserName() + " " + li.cqA() + " " + li.cqN());
        if (aoO != null && aoO.Oh() == 0) {
            ab.i("MicroMsg.SnsCommentDetailUI", "getContact %s", li.getUserName());
            com.tencent.mm.model.ao.a.Zu().a(li.getUserName(), "", this.rqL);
        }
        String bc = bo.bc(aoO == null ? li.getUserName() : aoO.Oj(), "");
        if (li.sh()) {
            com.tencent.mm.plugin.sns.storage.b cqo = li.cqo();
            if (cqo != null) {
                View inflate;
                String str2;
                String string;
                Iterator it;
                ad aoN;
                if (cqo.qVa) {
                    charSequence2 = cqo.qVb;
                } else if (bo.isNullOrNil(bc) && !bo.isNullOrNil(cqo.nickname)) {
                    charSequence2 = cqo.nickname;
                }
                charSequence2.length();
                i = this.klY != 10 ? 3 : 2;
                kVar = new k(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, charSequence2));
                kVar.a(new o(new com.tencent.mm.plugin.sns.data.a(li.sh(), aoO.getUsername(), li.cqU(), 2), this.rqd, i), charSequence2);
                textView3.setOnTouchListener(new aa());
                textView3.setText(kVar, BufferType.SPANNABLE);
                ((TextView) this.rpJ.findViewById(R.id.ehq)).setText("");
                this.rqM = new bb(this.rpJ);
                if (li.sh()) {
                    this.rqM.setVisibility(8);
                } else {
                    this.rqM.z(Long.valueOf(li.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rqM, 0, this.rpZ, li.field_snsId, f(li).hnw));
                    this.rqM.a(li.cqo(), f(li));
                    this.rqM.a(this.rqo.rJS, this.rqo.rKg);
                    this.rqM.setVisibility(0);
                }
                str = cqu.xfF;
                this.rpK = (TextView) this.rpJ.findViewById(R.id.ld);
                this.rpK.setTag(new ar(this.cFc, li.cqU(), true, false, 2));
                this.jMO.c(this.rpK, this.rqo.rJK, this.rqo.rJH);
                if (bo.isNullOrNil(str)) {
                    this.rpK.setText(str + " ");
                    com.tencent.mm.pluginsdk.ui.e.j.h(this.rpK, 2);
                    this.rpK.setVisibility(0);
                } else {
                    this.rpK.setVisibility(8);
                }
                viewStub = (ViewStub) this.rpJ.findViewById(R.id.ehw);
                if (!this.rqI) {
                    viewStub.setLayoutResource(-1);
                    switch (this.klY) {
                        case 2:
                            viewStub.setLayoutResource(R.layout.awt);
                            break;
                        case 3:
                            viewStub.setLayoutResource(R.layout.awq);
                            break;
                        case 4:
                            viewStub.setLayoutResource(R.layout.awr);
                            break;
                        case 5:
                            viewStub.setLayoutResource(R.layout.aws);
                            break;
                        case 9:
                            viewStub.setLayoutResource(R.layout.avp);
                            break;
                        case 10:
                            viewStub.setLayoutResource(R.layout.ava);
                            break;
                        case 11:
                            viewStub.setLayoutResource(R.layout.aww);
                            this.rqm = new com.tencent.mm.plugin.sns.ui.c.a.d(cqu, li, this.rqo, this.rqn);
                            break;
                        case 13:
                            viewStub.setLayoutResource(R.layout.atx);
                            this.rqm = new com.tencent.mm.plugin.sns.ui.c.a.b(cqu, li, this.rqo, this.rqn);
                            break;
                        case 14:
                            viewStub.setLayoutResource(R.layout.awm);
                            this.rqm = new com.tencent.mm.plugin.sns.ui.c.a.c(cqu, li, this.rqo, this.rqn);
                            break;
                        default:
                            viewStub.setVisibility(8);
                            break;
                    }
                    if (viewStub.getLayoutResource() != -1) {
                        inflate = viewStub.inflate();
                        if (this.rqm != null) {
                            this.rqm.g(inflate, this.rpP);
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
                        this.rqJ = (PhotosContent) findViewById(R.id.emm);
                        if (this.rqJ != null) {
                            this.rqJ.csr();
                            if (this.klY == 2) {
                                i = 1;
                            } else {
                                i = aq.run[this.klY];
                            }
                            for (int i2 = 0; i2 < i; i2++) {
                                tagImageView = (TagImageView) this.rqJ.findViewById(aq.rur[i2]);
                                this.rqJ.a(tagImageView);
                                tagImageView.setOnClickListener(this.rqo.rjy);
                                this.jMO.c(tagImageView, this.rqo.rJV, this.rqo.rJH);
                            }
                            this.rqJ.setImageViewWidth(this.rqi);
                            final LinkedList linkedList = new LinkedList();
                            if (li.sh() && this.klY == 2) {
                                cqo = li.cqo();
                                this.rqJ.DT(0).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
                                if (cqo != null && !cqo.coP() && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                                    a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                                    a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                                    int al;
                                    baw baw;
                                    if (cqo.qUG == 0) {
                                        if (a >= ((float) ((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4)))) {
                                            a = (float) ((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4));
                                            a2 = (float) ((int) ((cqo.qUI * a) / cqo.qUH));
                                        }
                                        baw baw2 = new baw();
                                        baw2.wFx = a;
                                        baw2.wFy = a2;
                                        baw2.wFz = baw2.wFx * baw2.wFy;
                                        linkedList.add(baw2);
                                    } else if (cqo.qUG == 1) {
                                        al = (((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4);
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
                                        al = (((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4);
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
                                if (!bo.isNullOrNil(cqo.qUM)) {
                                    final PhotosContent photosContent = this.rqJ;
                                    final TagImageView DT = this.rqJ.DT(0);
                                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", cqo.qUM, false, 41, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                                        public final void cpu() {
                                        }

                                        public final void cmD() {
                                        }

                                        public final void YJ(String str) {
                                            AppMethodBeat.i(38801);
                                            MaskImageView maskImageView = (MaskImageView) photosContent.findViewById(R.id.emv);
                                            if (maskImageView != null) {
                                                maskImageView.setVisibility(0);
                                                maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
                                                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUN, 1, cqo.qUJ, cqo.qUK);
                                                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUO, 1, cqo.qUJ, cqo.qUK);
                                                float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUP, 1, cqo.qUJ, cqo.qUK);
                                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo.qUQ, 1, cqo.qUJ, cqo.qUK);
                                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                                                layoutParams.setMargins((int) ((((float) DT.getRight()) - a3) - a), (int) ((((float) DT.getBottom()) - a4) - a2), 0, 0);
                                                maskImageView.setLayoutParams(layoutParams);
                                            }
                                            AppMethodBeat.o(38801);
                                        }
                                    });
                                }
                            }
                            final TimeLineObject timeLineObject = cqu;
                            this.rpJ.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                                boolean rqT = false;

                                public final void onViewAttachedToWindow(View view) {
                                    AppMethodBeat.i(38802);
                                    ab.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", Boolean.valueOf(this.rqT));
                                    if (this.rqT) {
                                        this.rqT = false;
                                        if (timeLineObject == null) {
                                            AppMethodBeat.o(38802);
                                            return;
                                        } else if (li == null) {
                                            AppMethodBeat.o(38802);
                                            return;
                                        } else if (SnsCommentDetailUI.this.rqJ == null) {
                                            AppMethodBeat.o(38802);
                                            return;
                                        } else {
                                            aq D = SnsCommentDetailUI.this.rpY;
                                            PhotosContent photosContent = SnsCommentDetailUI.this.rqJ;
                                            TimeLineObject timeLineObject = timeLineObject;
                                            String cqU = li.cqU();
                                            SnsCommentDetailUI.this.rqo;
                                            D.a(photosContent, timeLineObject, cqU, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.this.klY, -1, li.DI(32), false, az.xYT, linkedList, li.cqA());
                                            AppMethodBeat.o(38802);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.o(38802);
                                }

                                public final void onViewDetachedFromWindow(View view) {
                                    AppMethodBeat.i(38803);
                                    ab.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
                                    this.rqT = true;
                                    AppMethodBeat.o(38803);
                                }
                            });
                            this.rpY.a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, li.DI(32), false, az.xYT, linkedList, li.cqA());
                        } else {
                            ab.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.klY + ",stub is " + viewStub.toString());
                        }
                    } else if (this.klY == 10) {
                        this.rqJ.csr();
                        tagImageView = (TagImageView) this.rqJ.findViewById(R.id.ej8);
                        this.rqJ.a(tagImageView);
                        tagImageView.setOnClickListener(this.rqo.rjy);
                        bc = li.cqU();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        ao aoVar = new ao();
                        aoVar.czD = bc;
                        aoVar.index = 0;
                        aoVar.rsl = arrayList;
                        aoVar.rps = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(aoVar);
                        }
                        textView3 = (TextView) this.rpJ.findViewById(R.id.ei4);
                        if (r.Yz().equals(cqu.jBB)) {
                            textView3.setVisibility(8);
                        } else {
                            cbf q = aj.q(li);
                            if (q.xaE == null || q.xaE.xbg == 0) {
                                textView3.setVisibility(8);
                            } else {
                                textView3.setText(getString(R.string.ctw, new Object[]{Integer.valueOf(q.xaE.xbg)}));
                                textView3.setVisibility(0);
                            }
                        }
                        bav cqM = li.cqM();
                        if (cqM == null) {
                            ab.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + li.cqU());
                        } else if (r.Yz().equals(cqu.jBB)) {
                            this.rpY.a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, az.xYT, true);
                        } else if (com.tencent.mm.plugin.sns.lucky.a.m.k(li)) {
                            this.rpY.a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, az.xYT, false);
                        } else if (cqM.cRU == 0) {
                            this.rpY.a(this.rqJ, cqu, li.cqU(), hashCode(), this.klY, -1, false, az.xYT, true);
                        } else {
                            ab.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + cqM.cRU);
                        }
                    } else if (this.klY == 9) {
                        Pair create;
                        bau bau2;
                        this.rqs = true;
                        final aj ajVar = new aj();
                        inflate = this.rpJ;
                        View findViewById = inflate.findViewById(R.id.ap9);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.id.bl);
                        ajVar.rnt = findViewById;
                        ajVar.raP = (ImageView) inflate.findViewById(R.id.l4);
                        ajVar.rnu = (MMPinProgressBtn) inflate.findViewById(R.id.vm);
                        ajVar.raQ = (TextView) inflate.findViewById(R.id.edz);
                        ajVar.rnv = (TextView) inflate.findViewById(R.id.edy);
                        ajVar.qzM = aVar;
                        ajVar.a(cqu, 0, li.cqU(), li.sh());
                        ajVar.raQ.setVisibility(8);
                        ajVar.qzM.setTagObject(ajVar);
                        findViewById.setTag(ajVar);
                        ajVar.rnt.setOnClickListener(this.rqo.rKe);
                        if (li.coP()) {
                            this.jMO.c(findViewById, this.rqo.rJZ, this.rqo.rJH);
                        } else {
                            this.jMO.c(findViewById, this.rqo.rJX, this.rqo.rJH);
                        }
                        Pair a3 = e.a(cqu, ajVar.qzM.getUIContext(), li.sh());
                        if (li.sh()) {
                            com.tencent.mm.plugin.sns.storage.b cqo2 = li.cqo();
                            if (cqo2 != null && cqo2.coP() && cqo2.qUH > 0.0f && cqo2.qUI > 0.0f) {
                                a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo2.qUH, 1, cqo2.qUJ, cqo2.qUK);
                                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((double) cqo2.qUI, 1, cqo2.qUJ, cqo2.qUK);
                                int al2;
                                if (cqo2.qUG == 0) {
                                    if (a >= ((float) ((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4)))) {
                                        a = (float) ((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4));
                                        a2 = (float) ((int) ((cqo2.qUI * a) / cqo2.qUH));
                                    }
                                    create = Pair.create(Integer.valueOf((int) a), Integer.valueOf((int) a2));
                                } else if (cqo2.qUG == 1) {
                                    al2 = (((((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4);
                                    create = Pair.create(Integer.valueOf(al2), Integer.valueOf((int) ((((float) al2) * cqo2.qUI) / cqo2.qUH)));
                                } else if (cqo2.qUG == 2) {
                                    al2 = (((width - com.tencent.mm.bz.a.al(this, R.dimen.a94)) - com.tencent.mm.bz.a.al(this, R.dimen.nj)) - getResources().getDimensionPixelSize(R.dimen.m4)) - getResources().getDimensionPixelSize(R.dimen.m4);
                                    create = Pair.create(Integer.valueOf(al2), Integer.valueOf((int) ((((float) al2) * cqo2.qUI) / cqo2.qUH)));
                                }
                                if (create != null) {
                                    aVar.fi(((Integer) create.first).intValue(), ((Integer) create.second).intValue());
                                    ViewGroup.LayoutParams layoutParams2 = ajVar.rnv.getLayoutParams();
                                    layoutParams2.width = ((Integer) create.first).intValue();
                                    layoutParams2.height = ((Integer) create.second).intValue();
                                    ajVar.rnv.setLayoutParams(layoutParams2);
                                }
                                if (cqu.xfI != null || cqu.xfI.wbK.size() <= 0) {
                                    bau2 = null;
                                } else {
                                    bau2 = (bau) cqu.xfI.wbK.get(0);
                                }
                                if (li.sh()) {
                                    ajVar.qzM.setOnCompletionListener(new com.tencent.mm.plugin.sight.decode.a.b.e() {
                                        public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                            AppMethodBeat.i(38806);
                                            if (i != -1) {
                                                if (SnsCommentDetailUI.this.rqn == null) {
                                                    AppMethodBeat.o(38806);
                                                    return;
                                                }
                                                SnsCommentDetailUI.this.rqn.u(li.field_snsId, false);
                                            }
                                            AppMethodBeat.o(38806);
                                        }
                                    });
                                    if (!this.rqn.jO(li.field_snsId)) {
                                        ajVar.qzM.setOnDecodeDurationListener(new com.tencent.mm.plugin.sight.decode.a.b.f() {
                                            public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                                AppMethodBeat.i(38807);
                                                if (SnsCommentDetailUI.this.rqn == null) {
                                                    AppMethodBeat.o(38807);
                                                    return;
                                                }
                                                int cle = (int) bVar.cle();
                                                SnsCommentDetailUI.this.rqn.c(li.field_snsId, bo.yz(), false);
                                                SnsCommentDetailUI.this.rqn.f(li.field_snsId, cle, false);
                                                if (j >= 3) {
                                                    SnsCommentDetailUI.this.rqn.T(li.field_snsId, li.field_snsId);
                                                    ajVar.qzM.setOnDecodeDurationListener(null);
                                                }
                                                AppMethodBeat.o(38807);
                                            }
                                        });
                                    }
                                }
                                if (cqu.xfI != null && cqu.xfI.wbK.size() > 0) {
                                    af.cnC();
                                    if (!com.tencent.mm.plugin.sns.model.g.t(bau2)) {
                                        if (af.cnC().u(bau2)) {
                                            ajVar.raP.setVisibility(0);
                                            ajVar.rnu.setVisibility(8);
                                            ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.shortvideo_play_btn));
                                        } else if (af.cnC().v(bau2)) {
                                            ajVar.raP.setVisibility(8);
                                            ajVar.rnu.setVisibility(8);
                                        } else if (!li.sh() || af.cnC().o(li) > 5) {
                                            af.cnC().y(bau2);
                                            ajVar.raP.setVisibility(0);
                                            ajVar.rnu.setVisibility(8);
                                            ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.shortvideo_play_btn));
                                        } else {
                                            ajVar.raP.setVisibility(8);
                                            ajVar.rnu.setVisibility(8);
                                        }
                                        if (ajVar.qzM.ckY()) {
                                            ab.d("MicroMsg.SnsCommentDetailUI", "play video error " + bau2.Id + " " + bau2.Url + " " + bau2.wEH);
                                            af.cnC().y(bau2);
                                            ajVar.raP.setVisibility(0);
                                            ajVar.rnu.setVisibility(8);
                                            ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.shortvideo_play_btn));
                                        }
                                    } else if (af.cnC().w(bau2)) {
                                        ajVar.raP.setVisibility(8);
                                        ajVar.rnu.setVisibility(0);
                                        ajVar.rnu.dKB();
                                    } else if (li.sh() && af.cnC().o(li) == 5) {
                                        af.cnC().A(bau2);
                                        ajVar.raP.setVisibility(8);
                                        ajVar.rnu.setVisibility(0);
                                        ajVar.rnu.dKB();
                                    } else {
                                        af.cnC().y(bau2);
                                        ajVar.raP.setVisibility(0);
                                        ajVar.rnu.setVisibility(8);
                                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.shortvideo_play_btn));
                                    }
                                    aVar.setTagObject(ajVar);
                                    af.cnC().a(li, bau2, aVar, hashCode(), 0, az.xYT, li.sh());
                                    findViewById.setTag(ajVar);
                                    if (this.rqn != null) {
                                        boolean z = li.sh() ? af.cnC().o(li) == 5 : af.cnC().n(li) == 5;
                                        this.rqn.w(li.field_snsId, z);
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
                        if (li.sh()) {
                        }
                        af.cnC();
                        if (!com.tencent.mm.plugin.sns.model.g.t(bau2)) {
                        }
                        aVar.setTagObject(ajVar);
                        af.cnC().a(li, bau2, aVar, hashCode(), 0, az.xYT, li.sh());
                        findViewById.setTag(ajVar);
                        if (this.rqn != null) {
                        }
                    } else if (this.klY == 0) {
                        linearLayout = (LinearLayout) this.rpJ.findViewById(R.id.ehp);
                        LinearLayout DV = DV(R.layout.avq);
                        if (!this.rqG) {
                            linearLayout.removeView(this.rqJ);
                            linearLayout.addView(DV, 3);
                            if (DV.getLayoutParams() != null) {
                                layoutParams = new LinearLayout.LayoutParams(DV.getLayoutParams());
                            } else {
                                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams.setMargins(layoutParams.leftMargin, com.tencent.mm.bz.a.fromDPToPix(this, 12), layoutParams.rightMargin, layoutParams.bottomMargin);
                            DV.setLayoutParams(layoutParams);
                        }
                        if (cqu.xfI.wbK.isEmpty()) {
                            DV.setVisibility(8);
                        } else {
                            bau = (bau) cqu.xfI.wbK.get(0);
                            view = (MMImageView) DV.findViewById(R.id.d11);
                            af.cnC().a(bau, view, (int) R.raw.app_attach_file_icon_music, hashCode(), az.xYT);
                            this.rqc = (ImageView) DV.findViewById(R.id.c9m);
                            this.rqc.setOnTouchListener(this.riQ);
                            this.cFI = cqu.Id;
                            cta();
                            view.setTag(new q(cqu, this.rpZ, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            view.setOnClickListener(this.rqg.rDA);
                            str2 = bau.Desc;
                            if (!bo.isNullOrNil(str2)) {
                                ((TextView) DV.findViewById(R.id.d14)).setText(str2);
                            }
                            bc = bau.Title;
                            if (!bo.isNullOrNil(bc)) {
                                ((TextView) DV.findViewById(R.id.d13)).setText(new SpannableString(bc), BufferType.SPANNABLE);
                            }
                            DV.setTag(new q(cqu, this.rpZ));
                            this.jMO.c(DV, this.rqo.rJW, this.rqo.rJH);
                            DV.setOnClickListener(this.rqg.rvD);
                            com.tencent.mm.plugin.sns.data.i.b(view, this);
                        }
                    } else if (this.klY == 13) {
                        this.rpK.setVisibility(8);
                        this.rpP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    } else if (!(this.klY == 11 || this.klY == 14)) {
                        Object obj;
                        Object obj2;
                        linearLayout = (LinearLayout) this.rpJ.findViewById(R.id.ehp);
                        LinearLayout DV2 = DV(R.layout.avo);
                        view = (MMImageView) DV2.findViewById(R.id.d11);
                        if (!this.rqG) {
                            linearLayout.removeView(this.rqJ);
                            linearLayout.addView(DV2, 3);
                            if (DV2.getLayoutParams() != null) {
                                layoutParams = new LinearLayout.LayoutParams(DV2.getLayoutParams());
                            } else {
                                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams.setMargins(layoutParams.leftMargin, com.tencent.mm.bz.a.fromDPToPix(this, 12), layoutParams.rightMargin, layoutParams.bottomMargin);
                            DV2.setLayoutParams(layoutParams);
                        }
                        Object obj3 = null;
                        if (li.sh()) {
                            if (li.cqo().coO()) {
                                obj3 = 1;
                                DV2.setTag(li);
                                DV2.setTag(R.id.bt, view);
                                DV2.setOnClickListener(this.rqo.rKs);
                            }
                            obj = obj3;
                            obj2 = null;
                        } else {
                            if (cqu.xfI.wbJ == 9) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDu);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 10) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDw);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 17) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDx);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 22) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDy);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 23) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDz);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 14) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDv);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 12) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDD);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 13) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqg.rDE);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 15) {
                                if (cqu.xfI.wbK.size() > 0) {
                                    DV2.setTag(new q(cqu, this.rpZ));
                                    DV2.setOnClickListener(this.rqo.rKf);
                                    obj = null;
                                    obj2 = null;
                                }
                            } else if (cqu.xfI.wbJ == 26) {
                                DV2.setTag(new q(cqu, this.rpZ));
                                DV2.setOnClickListener(this.rqg.rDF);
                                obj = null;
                                obj2 = null;
                            } else {
                                DV2.setTag(new q(cqu, this.rpZ));
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
                            this.jMO.c(DV2, this.rqo.rKa, this.rqo.rJH);
                        } else {
                            this.jMO.c(DV2, this.rqo.rJW, this.rqo.rJH);
                        }
                        String ZI = csW() ? au.ZI(cqu.xfI.Url) : "";
                        String str3 = cqu.xfI.Title;
                        if (obj != null) {
                            str = cqu.xfI.Desc;
                        } else {
                            str = ZI;
                        }
                        DV2.findViewById(R.id.c9m).setVisibility(8);
                        if (!cqu.xfI.wbK.isEmpty()) {
                            view.setVisibility(0);
                            bau = (bau) cqu.xfI.wbK.get(0);
                            if (cqu.xfI.wbJ == 15) {
                                ((ImageView) DV2.findViewById(R.id.c9m)).setImageResource(R.drawable.vs);
                                ((ImageView) DV2.findViewById(R.id.c9m)).setVisibility(0);
                                af.cnC().a(bau, view, (int) R.raw.app_attach_file_icon_video, hashCode(), az.dtg().Mp(cqu.pcX));
                                ZI = str3;
                                bc = str;
                            } else if (cqu.xfI.wbJ == 5) {
                                str3 = au.ZI(bau.Url);
                                str = bau.Title;
                                DV2.findViewById(R.id.c9m).setVisibility(0);
                                af.cnC().a(bau, view, (int) R.raw.app_attach_file_icon_video, hashCode(), az.xYT);
                                ZI = str;
                                bc = str3;
                            } else if (cqu.xfI.wbJ == 18) {
                                DV2.findViewById(R.id.c9m).setVisibility(0);
                                ((ImageView) DV2.findViewById(R.id.c9m)).setImageResource(R.drawable.aql);
                                view.setVisibility(0);
                                af.cnC().a(bau, view, (int) R.raw.app_attach_file_icon_video, hashCode(), az.xYT);
                                ZI = str3;
                                bc = str;
                            } else {
                                af.cnC().b(bau, view, hashCode(), az.xYT);
                                ZI = str3;
                                bc = str;
                            }
                        } else if (cqu.xfI.wbJ == 18) {
                            ((ImageView) DV2.findViewById(R.id.c9m)).setVisibility(0);
                            ((ImageView) DV2.findViewById(R.id.c9m)).setImageResource(R.drawable.aql);
                            view.setVisibility(0);
                            af.cnC().a(view, -1, (int) R.raw.app_attach_file_icon_video, hashCode());
                            ZI = str3;
                            bc = str;
                        } else if (cqu.xfI.wbJ == 26) {
                            view.setVisibility(0);
                            af.cnC().a(view, -1, (int) R.raw.note_sns_link_default, hashCode());
                            ZI = str3;
                            bc = str;
                        } else {
                            view.setVisibility(0);
                            af.cnC().a(view, -1, (int) R.raw.app_attach_file_icon_webpage, hashCode());
                            ZI = str3;
                            bc = str;
                        }
                        com.tencent.mm.plugin.sns.data.i.b(view, this);
                        if (cqu.xfI.wbJ == 15) {
                            bc = "";
                            string = getString(R.string.ekr);
                        } else {
                            string = ZI;
                        }
                        if (bo.isNullOrNil(bc)) {
                            DV2.findViewById(R.id.d14).setVisibility(8);
                        } else {
                            DV2.findViewById(R.id.d14).setVisibility(0);
                            ((TextView) DV2.findViewById(R.id.d14)).setText(bc);
                        }
                        textView3 = (TextView) DV2.findViewById(R.id.d13);
                        if (bo.isNullOrNil(string)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            if (obj22 != null) {
                                textView3.setText(com.tencent.mm.plugin.sns.data.i.a(string, dxU(), textView3));
                            } else {
                                textView3.setText(string);
                            }
                        }
                    }
                }
                textView3 = (TextView) this.rpJ.findViewById(R.id.ehx);
                if (li.sh()) {
                    bc = cqu.xfG == null ? null : cqu.xfG.guP;
                    string = cqu.xfG == null ? null : cqu.xfG.eUu;
                    textView3.setTag(li.cqU());
                    if (bo.isNullOrNil(bc) && bo.isNullOrNil(string)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        if (bo.isNullOrNil(string)) {
                            textView3.setText(bc);
                            textView3.setClickable(false);
                            textView3.setTextColor(-9211021);
                        } else {
                            textView3.setTextColor(-11048043);
                            textView3.setClickable(true);
                            if (li.field_snsId != 0 || bo.isNullOrNil(bc)) {
                                textView3.setText(string);
                            } else {
                                textView3.setText(bc + "·" + string);
                            }
                        }
                    }
                } else {
                    com.tencent.mm.plugin.sns.storage.a f = f(li);
                    if (f != null) {
                        string = f.qTD;
                        bc = f.qTE;
                        textView3.setTag(li.cqU());
                        if (!bo.isNullOrNil(string)) {
                            if (bo.isNullOrNil(bc)) {
                                textView3.setVisibility(0);
                            } else {
                                textView3.setVisibility(0);
                                if (!bo.isNullOrNil(string)) {
                                    textView3.setTextColor(-11048043);
                                    textView3.setClickable(true);
                                    textView3.setText(string);
                                    this.rpJ.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(38808);
                                            SnsCommentDetailUI.this.rqn.kH(false);
                                            AppMethodBeat.o(38808);
                                        }
                                    });
                                }
                            }
                            textView3.setText(string);
                            textView3.setClickable(false);
                            textView3.setTextColor(-9211021);
                            this.rpJ.post(/* anonymous class already generated */);
                        }
                    }
                    textView3.setVisibility(8);
                    this.rpJ.post(/* anonymous class already generated */);
                }
                textView3.setOnClickListener(this.rqo.rKd);
                ((TextView) this.rpJ.findViewById(R.id.ehz)).setText(aw.m(dxU(), ((long) li.cqN()) * 1000));
                asyncTextView = (AsyncTextView) this.rpJ.findViewById(R.id.ei0);
                asyncTextView.setOnClickListener(this.rqo.rKh);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.rpJ.findViewById(R.id.ei1);
                adVar = aoO;
                asyncTextView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(38809);
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(SnsCommentDetailUI.f(SnsCommentDetailUI.this), 2, li.field_snsId, 24, 0));
                        SnsCommentDetailUI.this.rhq.setCommentFlag(1);
                        SnsCommentDetailUI.this.rhq.setCommentHint(adVar.Oj());
                        SnsCommentDetailUI.this.rhq.lj(true);
                        SnsCommentDetailUI.this.rpO.setVisibility(8);
                        SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                        AppMethodBeat.o(38809);
                    }
                });
                asyncTextView2.setVisibility(8);
                if (li.sh()) {
                    com.tencent.mm.plugin.sns.storage.a f2 = f(li);
                    asyncTextView.setTag(li.cqU());
                    if (f2.qTF == com.tencent.mm.plugin.sns.storage.a.qTr) {
                        if (bo.isNullOrNil(f2.qTG)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            asyncTextView.setText(f2.qTG);
                            asyncTextView.setVisibility(0);
                        }
                    } else if (f2.qTF == com.tencent.mm.plugin.sns.storage.a.qTs) {
                        if (bo.isNullOrNil(f2.qTG)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            str2 = "";
                            it = f2.qTI.iterator();
                            while (it.hasNext()) {
                                string = (String) it.next();
                                aoN = this.rqa.aoN(string);
                                if (aoN != null) {
                                    str = aoN.Oj();
                                    if (bo.isNullOrNil(str)) {
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
                            k kVar2 = new k(com.tencent.mm.pluginsdk.ui.e.j.c(this, string, 1));
                            kVar2.a(null, string);
                            TextPaint paint = asyncTextView.getPaint();
                            if (com.tencent.mm.bz.a.ao(this, (int) Layout.getDesiredWidth(kVar2, 0, kVar2.length(), paint)) > this.rql) {
                                while (str2.length() > 1) {
                                    str2 = str2.substring(0, str2.length() - 2);
                                    String format = String.format(f2.qTG, new Object[]{str2 + "..."});
                                    asyncTextView.getTextSize();
                                    k kVar3 = new k(com.tencent.mm.pluginsdk.ui.e.j.c(this, format, 1));
                                    kVar3.a(null, format);
                                    int ao = com.tencent.mm.bz.a.ao(this, (int) Layout.getDesiredWidth(kVar3, 0, kVar3.length(), paint));
                                    asyncTextView.setText(kVar3, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (ao <= this.rql) {
                                    }
                                }
                            } else {
                                asyncTextView.setText(kVar2, BufferType.SPANNABLE);
                                asyncTextView.setVisibility(0);
                            }
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && bo.isNullOrNil(f2.qTH)) {
                        asyncTextView.setTextColor(getResources().getColor(R.color.a1a));
                        asyncTextView.setOnClickListener(null);
                    }
                    if ((li.cqu().xfI.wbL & 4) != 0) {
                        asyncTextView2.setTag(li.cqU());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{dxU().getResources().getString(R.string.eiu), charSequence2, dxU().getResources().getString(R.string.eiv)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView3 = (TextView) this.rpJ.findViewById(R.id.ei3);
                textView3.setOnTouchListener(new aa());
                bc = com.tencent.mm.plugin.sns.c.a.gkF.t((Context) this, cqu.xfH.Id);
                if (cqu.xfI.wbJ == 26) {
                    bc = getString(R.string.bnl);
                }
                au.a(cqu, (Context) this);
                if (com.tencent.mm.plugin.sns.c.a.gkF.dg(bc)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    SpannableString spannableString = new SpannableString(getString(R.string.ejz) + bc);
                    spannableString.setSpan(new a(), 0, spannableString.length(), 33);
                    textView3.setText(spannableString, BufferType.SPANNABLE);
                    if (cqu.xfH == null || !com.tencent.mm.pluginsdk.model.app.g.aiF(cqu.xfH.Id)) {
                        textView3.setTextColor(getResources().getColor(R.color.a1a));
                        textView3.setOnTouchListener(null);
                    }
                    textView3.setTag(cqu);
                }
                textView3 = (TextView) this.rpJ.findViewById(R.id.ei5);
                if (li.getUserName().equals(this.ecX)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    textView3.setTag(li.cqU() + ";" + li.cqA());
                    textView3.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(38811);
                            com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, (int) R.string.epn, (int) R.string.tz, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(38810);
                                    ab.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.this.rpZ);
                                    n YT = h.YT(SnsCommentDetailUI.this.rpZ);
                                    if (YT == null) {
                                        ab.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", SnsCommentDetailUI.this.rpZ);
                                        AppMethodBeat.o(38810);
                                    } else if (YT.DI(32)) {
                                        AppMethodBeat.o(38810);
                                    } else {
                                        if (YT.field_snsId == 0) {
                                            af.cnF().DL(YT.reX);
                                        } else {
                                            af.cnE().km(YT.field_snsId);
                                            com.tencent.mm.kernel.g.RQ();
                                            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.sns.model.r(YT.field_snsId, 1), 0);
                                            af.cnF().delete(YT.field_snsId);
                                            af.cnK().ky(YT.field_snsId);
                                            com.tencent.mm.plugin.sns.storage.i.kx(YT.field_snsId);
                                        }
                                        Intent intent = new Intent();
                                        intent.putExtra("sns_gallery_op_id", com.tencent.mm.plugin.sns.storage.v.Zn(SnsCommentDetailUI.this.rpZ));
                                        SnsCommentDetailUI.this.setResult(-1, intent);
                                        if (SnsCommentDetailUI.this.hOT && !YT.isValid()) {
                                            intent.putExtra("sns_gallery_force_finish", true);
                                        }
                                        TimeLineObject cqu = YT.cqu();
                                        if (cqu != null) {
                                            String str = cqu.xfH == null ? null : cqu.xfH.Id;
                                            if (!bo.isNullOrNil(str) && com.tencent.mm.plugin.sns.c.a.gkF.dk(str)) {
                                                String df = com.tencent.mm.plugin.sns.c.a.gkF.df(str);
                                                oi oiVar = new oi();
                                                oiVar.cKD.appId = str;
                                                oiVar.cKD.cKE = cqu.jBB;
                                                oiVar.cKD.ceO = df;
                                                com.tencent.mm.sdk.b.a.xxA.m(oiVar);
                                            }
                                        }
                                        SnsCommentDetailUI.this.finish();
                                        AppMethodBeat.o(38810);
                                    }
                                }
                            }, null);
                            AppMethodBeat.o(38811);
                        }
                    });
                }
                textView3 = (TextView) this.rpJ.findViewById(R.id.ehy);
                p = aj.p(li);
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
                                    bc = aoN == null ? cat.vHl : aoN.Oj();
                                }
                                bc = append.append(bc).toString();
                            } else {
                                textView3.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, getString(R.string.eq2, new Object[]{string}), textView3.getTextSize()));
                            }
                        }
                    } else {
                        textView3.setVisibility(8);
                        Iterator it2 = p.xaw.iterator();
                        while (it2.hasNext()) {
                            if (this.ecX.equals(((cat) it2.next()).vHl)) {
                                textView3.setVisibility(0);
                                CharSequence string2 = getString(R.string.eq3);
                                textView3.setVisibility(0);
                                textView3.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, string2, textView3.getTextSize()));
                            }
                        }
                    }
                    if (p == null || this.ecX == null || !this.ecX.equals(p.vHl) || ((p.wGz != 3 || p.xaB == null) && (p.wGz != 5 || p.wFp == null))) {
                        this.rpJ.findViewById(R.id.ei2).setVisibility(8);
                    } else {
                        this.rpJ.findViewById(R.id.ei2).setVisibility(0);
                        this.rpJ.findViewById(R.id.ei2).setTag(Integer.valueOf(li.reX));
                        this.rpJ.findViewById(R.id.ei2).setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(38812);
                                try {
                                    int intValue = ((Integer) view.getTag()).intValue();
                                    Intent intent = new Intent();
                                    intent.putExtra("sns_label_sns_info", intValue);
                                    com.tencent.mm.plugin.sns.c.a.gkE.u(intent, SnsCommentDetailUI.this);
                                    AppMethodBeat.o(38812);
                                } catch (Exception e) {
                                    AppMethodBeat.o(38812);
                                }
                            }
                        });
                    }
                }
                this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rpR.setDuration(150);
                this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rpS.setDuration(150);
                if (this.rpO == null) {
                    this.rpO = this.rpJ.findViewById(R.id.mc);
                    this.rpO.setVisibility(8);
                }
                this.rpT = (LinearLayout) this.rpJ.findViewById(R.id.ei6);
                this.rpT.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(38813);
                        if (com.tencent.mm.plugin.sns.lucky.a.m.Xx(li.cqU())) {
                            SnsCommentDetailUI.this.rhq.setCommentInfo(null);
                            SnsCommentDetailUI.this.rhq.setCommentFlag(0);
                            SnsCommentDetailUI.this.rhq.setCommentHint(SnsCommentDetailUI.this.getString(R.string.eq9));
                            SnsCommentDetailUI.this.rhq.setCommentInfo(new cat());
                            SnsCommentDetailUI.this.rhq.lj(true);
                            if (!li.DI(32) || (li.cqu().xfI.wbL & 8) == 0) {
                                SnsCommentDetailUI.this.rhq.lk(false);
                            } else {
                                SnsCommentDetailUI.this.rhq.lk(true);
                            }
                            SnsCommentDetailUI.this.rpO.setVisibility(8);
                            SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                            AppMethodBeat.o(38813);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.DT(0));
                        AppMethodBeat.o(38813);
                    }
                });
                this.rpT.setOnTouchListener(this.riQ);
                this.rpU = (LinearLayout) this.rpJ.findViewById(R.id.eh_);
                this.rpU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(38814);
                        if (SnsCommentDetailUI.this.rqn != null && li.field_likeFlag == 0) {
                            SnsCommentDetailUI.this.rqn.jP(li.field_snsId);
                        }
                        SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                        LinearLayout linearLayout = (LinearLayout) view;
                        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.eha);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.5f, 0.9f, 1.5f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setStartOffset(100);
                        scaleAnimation.setRepeatCount(0);
                        imageView.clearAnimation();
                        imageView.startAnimation(scaleAnimation);
                        scaleAnimation.setAnimationListener(new AnonymousClass35(linearLayout));
                        SnsCommentDetailUI.F(SnsCommentDetailUI.this);
                        AppMethodBeat.o(38814);
                    }
                });
                this.rpU.setOnTouchListener(this.riQ);
                imageButton = (ImageButton) this.rpJ.findViewById(R.id.eho);
                li2 = li(true);
                if (!(li2 == null || (li2.cqP() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(li2 == null || li2.cqT())) {
                    imageButton.setVisibility(8);
                }
                imageView = (ImageView) this.rpU.findViewById(R.id.eha);
                imageView2 = (ImageView) this.rpT.findViewById(R.id.ehd);
                textView = (TextView) this.rpU.findViewById(R.id.ehb);
                textView2 = (TextView) this.rpT.findViewById(R.id.ehc);
                if (this.klY == 10) {
                    this.rpJ.findViewById(R.id.mc).setBackgroundResource(R.drawable.bme);
                    imageButton.setImageResource(R.drawable.rl);
                    imageView.setImageResource(R.drawable.rm);
                    imageView2.setImageResource(R.drawable.rn);
                    textView.setTextColor(getResources().getColor(R.color.a0q));
                    textView2.setTextColor(getResources().getColor(R.color.a0q));
                    this.rpU.setBackgroundResource(R.drawable.t5);
                    this.rpT.setBackgroundResource(R.drawable.t6);
                }
                nVar = li;
                imageButton.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(38815);
                        ab.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.this.rpO.getVisibility());
                        TimeLineObject cqu = nVar.cqu();
                        if (cqu != null && cqu.xfI.wbJ == 21 && !com.tencent.mm.plugin.sns.lucky.a.m.Xx(nVar.cqU())) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.mController.ylL, SnsCommentDetailUI.this.rqJ.DT(0));
                            AppMethodBeat.o(38815);
                        } else if (SnsCommentDetailUI.this.rpO.getVisibility() == 0) {
                            SnsCommentDetailUI.g(SnsCommentDetailUI.this);
                            AppMethodBeat.o(38815);
                        } else {
                            SnsCommentDetailUI.this.rpO.setVisibility(0);
                            SnsCommentDetailUI.this.rpO.startAnimation(SnsCommentDetailUI.this.rpR);
                            if (SnsCommentDetailUI.this.klY == 10) {
                                SnsCommentDetailUI.this.rpJ.findViewById(R.id.mc).setBackgroundResource(R.drawable.bme);
                            }
                            if (com.tencent.mm.plugin.sns.storage.v.Zo(SnsCommentDetailUI.this.cFc)) {
                                SnsCommentDetailUI.this.rpT.setEnabled(true);
                                imageView.setImageResource(R.drawable.og);
                                SnsCommentDetailUI.this.rpU.setEnabled(true);
                                textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a69));
                                textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a69));
                                n YS = h.YS(SnsCommentDetailUI.this.cFc);
                                if (SnsCommentDetailUI.this.klY == 10) {
                                    imageView.setImageResource(R.drawable.rm);
                                    imageView2.setImageResource(R.drawable.rn);
                                    textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a0q));
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a0q));
                                } else {
                                    imageView.setImageResource(R.drawable.og);
                                    textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a69));
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a69));
                                }
                                if (YS.field_likeFlag == 0) {
                                    textView.setText(SnsCommentDetailUI.this.getString(R.string.em5));
                                    AppMethodBeat.o(38815);
                                    return;
                                }
                                textView.setText(SnsCommentDetailUI.this.getString(R.string.el4));
                                AppMethodBeat.o(38815);
                                return;
                            }
                            SnsCommentDetailUI.this.rpT.setEnabled(false);
                            SnsCommentDetailUI.this.rpU.setEnabled(false);
                            textView.setText(SnsCommentDetailUI.this.getString(R.string.em5));
                            textView.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a0h));
                            textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(R.color.a0h));
                            if (SnsCommentDetailUI.this.klY == 10) {
                                imageView.setImageResource(R.raw.friendactivity_comment_likeicon_golden_normal);
                                AppMethodBeat.o(38815);
                                return;
                            }
                            imageView.setImageResource(R.raw.friendactivity_comment_likeicon_normal);
                            AppMethodBeat.o(38815);
                        }
                    }
                });
                AppMethodBeat.o(38847);
                return true;
            }
        }
        charSequence2 = bc;
        charSequence2.length();
        if (this.klY != 10) {
        }
        kVar = new k(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, charSequence2));
        kVar.a(new o(new com.tencent.mm.plugin.sns.data.a(li.sh(), aoO.getUsername(), li.cqU(), 2), this.rqd, i), charSequence2);
        textView3.setOnTouchListener(new aa());
        textView3.setText(kVar, BufferType.SPANNABLE);
        ((TextView) this.rpJ.findViewById(R.id.ehq)).setText("");
        this.rqM = new bb(this.rpJ);
        if (li.sh()) {
        }
        str = cqu.xfF;
        this.rpK = (TextView) this.rpJ.findViewById(R.id.ld);
        this.rpK.setTag(new ar(this.cFc, li.cqU(), true, false, 2));
        this.jMO.c(this.rpK, this.rqo.rJK, this.rqo.rJH);
        if (bo.isNullOrNil(str)) {
        }
        viewStub = (ViewStub) this.rpJ.findViewById(R.id.ehw);
        if (this.rqI) {
        }
        width = ((WindowManager) dxU().getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.klY != 6) {
        }
        textView3 = (TextView) this.rpJ.findViewById(R.id.ehx);
        if (li.sh()) {
        }
        textView3.setOnClickListener(this.rqo.rKd);
        ((TextView) this.rpJ.findViewById(R.id.ehz)).setText(aw.m(dxU(), ((long) li.cqN()) * 1000));
        asyncTextView = (AsyncTextView) this.rpJ.findViewById(R.id.ei0);
        asyncTextView.setOnClickListener(this.rqo.rKh);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.rpJ.findViewById(R.id.ei1);
        adVar = aoO;
        asyncTextView2.setOnClickListener(/* anonymous class already generated */);
        asyncTextView2.setVisibility(8);
        if (li.sh()) {
        }
        textView3 = (TextView) this.rpJ.findViewById(R.id.ei3);
        textView3.setOnTouchListener(new aa());
        bc = com.tencent.mm.plugin.sns.c.a.gkF.t((Context) this, cqu.xfH.Id);
        if (cqu.xfI.wbJ == 26) {
        }
        au.a(cqu, (Context) this);
        if (com.tencent.mm.plugin.sns.c.a.gkF.dg(bc)) {
        }
        textView3 = (TextView) this.rpJ.findViewById(R.id.ei5);
        if (li.getUserName().equals(this.ecX)) {
        }
        textView3 = (TextView) this.rpJ.findViewById(R.id.ehy);
        p = aj.p(li);
        if (p != null) {
        }
        this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpR.setDuration(150);
        this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpS.setDuration(150);
        if (this.rpO == null) {
        }
        this.rpT = (LinearLayout) this.rpJ.findViewById(R.id.ei6);
        this.rpT.setOnClickListener(/* anonymous class already generated */);
        this.rpT.setOnTouchListener(this.riQ);
        this.rpU = (LinearLayout) this.rpJ.findViewById(R.id.eh_);
        this.rpU.setOnClickListener(/* anonymous class already generated */);
        this.rpU.setOnTouchListener(this.riQ);
        imageButton = (ImageButton) this.rpJ.findViewById(R.id.eho);
        li2 = li(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView = (ImageView) this.rpU.findViewById(R.id.eha);
        imageView2 = (ImageView) this.rpT.findViewById(R.id.ehd);
        textView = (TextView) this.rpU.findViewById(R.id.ehb);
        textView2 = (TextView) this.rpT.findViewById(R.id.ehc);
        if (this.klY == 10) {
        }
        nVar = li;
        imageButton.setOnClickListener(/* anonymous class already generated */);
        AppMethodBeat.o(38847);
        return true;
    }

    private void csY() {
        AppMethodBeat.i(38848);
        if (this.rpO == null || this.rpO.getVisibility() == 8) {
            AppMethodBeat.o(38848);
            return;
        }
        this.rpO.startAnimation(this.rpS);
        this.rpS.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(38816);
                ab.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
                if (SnsCommentDetailUI.this.rpO != null) {
                    SnsCommentDetailUI.this.rpO.clearAnimation();
                    SnsCommentDetailUI.this.rpO.setVisibility(8);
                }
                AppMethodBeat.o(38816);
            }
        });
        AppMethodBeat.o(38848);
    }

    private void cta() {
        AppMethodBeat.i(38850);
        if (this.rqc == null) {
            AppMethodBeat.o(38850);
            return;
        }
        this.rqc.setPressed(false);
        if (bc.Wi(this.cFI)) {
            this.rqc.setImageResource(R.drawable.vq);
            AppMethodBeat.o(38850);
            return;
        }
        this.rqc.setImageResource(R.drawable.vs);
        AppMethodBeat.o(38850);
    }

    private boolean e(List<cat> list, boolean z) {
        AppMethodBeat.i(38851);
        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 32.0f);
        int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 6.0f);
        int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 10.0f);
        int b4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 17.0f);
        if (this.rpL == null) {
            AppMethodBeat.o(38851);
            return false;
        }
        int i;
        ab.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(((WindowManager) this.mController.ylL.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(R.dimen.m4)));
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.rpL.getParent() != null) {
                this.rpL.setVisibility(8);
            }
            this.rpL.removeAllViews();
            this.rpL.setVisibility(8);
            this.qHj.setVisibility(8);
            AppMethodBeat.o(38851);
            return false;
        }
        this.rpL.getParent();
        this.rpL.removeAllViews();
        this.rpL.setVisibility(0);
        if (this.klY != 10) {
            this.rpL.setBackgroundResource(R.drawable.b68);
        } else if (this.rqq) {
            n li = li(false);
            if (li == null) {
                this.rpL.setBackgroundResource(R.drawable.b6_);
            } else if (this.ecX.equals(li.field_userName)) {
                this.rpL.setBackgroundResource(R.drawable.b6a);
            } else {
                this.rpL.setBackgroundResource(R.drawable.b6_);
            }
        } else {
            this.rpL.setBackgroundResource(R.drawable.b6_);
        }
        this.rpL.setPadding(0, b2, 0, b2);
        ImageView imageView = new ImageView(this.mController.ylL);
        if (this.klY == 10) {
            imageView.setImageResource(R.raw.friendactivity_likeicon_golden);
        } else {
            imageView.setImageResource(R.raw.friendactivity_likeicon);
        }
        imageView.setPadding(b3, b4, b3, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.rpL.addView(imageView);
        b3 = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, rqk);
        i = ((int) (f - ((float) b3))) / (b2 + b);
        if (((int) (f - ((float) b3))) % (b2 + b) > b) {
            i++;
        }
        ab.d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i));
        h hVar = new h(this.mController.ylL);
        hVar.setClipChildren(false);
        hVar.setClipToPadding(false);
        hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        hVar.setLineMaxCounte(i);
        i = 0;
        while (true) {
            b3 = i;
            if (b3 >= list.size()) {
                break;
            }
            cat cat = (cat) list.get(b3);
            StoryTouchImageView storyTouchImageView = new StoryTouchImageView(this.mController.ylL);
            storyTouchImageView.setScaleType(ScaleType.FIT_XY);
            storyTouchImageView.setImageResource(R.drawable.oi);
            storyTouchImageView.rDe.dk(cat.vHl, 1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b);
            layoutParams2.setMargins(0, b2, b2, 0);
            storyTouchImageView.setLayoutParams(layoutParams2);
            storyTouchImageView.setTag(cat.vHl);
            com.tencent.mm.pluginsdk.ui.a.b.t(storyTouchImageView, cat.vHl);
            storyTouchImageView.setOnClickListener(this.jNC);
            hVar.addView(storyTouchImageView);
            i = b3 + 1;
        }
        this.rpL.addView(hVar);
        this.qHj.setVisibility(z ? 8 : 0);
        AppMethodBeat.o(38851);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38852);
        super.onConfigurationChanged(configuration);
        n YS = h.YS(this.cFc);
        cbf p = aj.p(YS);
        e(p.xaq, p.xat.isEmpty());
        if (this.rpM != null) {
            this.rpM.a(YS, this.rqo);
        }
        if (this.rqJ != null) {
            this.rqi = af.cnN();
            this.rqJ.setImageViewWidth(this.rqi);
        }
        AppMethodBeat.o(38852);
    }

    public final void Xw(String str) {
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38853);
        ab.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i == 15) {
            if (!(this.rqo == null || this.rqo.rJH == null)) {
                this.rqo.rJH.onActivityResult(i, i2, intent);
            }
            AppMethodBeat.o(38853);
        } else if (i == 16) {
            ab.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            gr grVar = new gr();
            grVar.cBq.scene = 1;
            com.tencent.mm.sdk.b.a.xxA.m(grVar);
            AppMethodBeat.o(38853);
        } else if (i == 2333) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!bo.isNullOrNil(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    if (split.length > 0) {
                        this.rhq.crP.showVKB();
                        stringExtra = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(split[0]);
                        if (!bo.isNullOrNil(stringExtra)) {
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
            AppMethodBeat.o(38853);
        } else if (i2 != -1) {
            AppMethodBeat.o(38853);
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
            AppMethodBeat.o(38853);
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(38854);
        if (mVar.getType() == 218 && this.rhB != null) {
            this.rhB.dismiss();
        }
        if (i == 0 && i2 == 0) {
            n YS = h.YS(this.cFc);
            if (YS == null) {
                ab.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.cFc);
                finish();
                AppMethodBeat.o(38854);
                return;
            }
            ab.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.cFc + "  username:" + YS.field_userName);
            if (this.rpJ == null) {
                ab.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                AppMethodBeat.o(38854);
                return;
            }
            csX();
            cbf p = aj.p(YS);
            ab.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + p.xaq.size() + " " + p.xat.size());
            if (p == null) {
                AppMethodBeat.o(38854);
                return;
            }
            if (!f(this.rpV, p.xaq)) {
                e(p.xaq, p.xat.isEmpty());
                this.rpV = p.xaq;
            }
            if (this.rpM != null) {
                this.rpM.a(YS, this.rqo);
            }
            b bVar = this.rpQ;
            LinkedList linkedList = p.xat;
            LinkedList linkedList2 = p.xaq;
            bVar.rrj = linkedList;
            bVar.rrk = linkedList2;
            this.rpQ.notifyDataSetChanged();
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38829);
                    SnsCommentDetailUI.this.rpN.setSelection((SnsCommentDetailUI.this.rpN.getHeaderViewsCount() + b.this.rrj.size()) - 1);
                    AppMethodBeat.o(38829);
                }
            }, 60);
        }
        AppMethodBeat.o(38854);
    }

    public final void bk(String str, boolean z) {
    }

    private void csZ() {
        AppMethodBeat.i(38849);
        if (this.mController.ymc == 1 || this.rhq.cte()) {
            this.rqC.run();
            AppMethodBeat.o(38849);
            return;
        }
        this.rho = true;
        AppMethodBeat.o(38849);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(38855);
        if (this.mController.ymc == 2) {
            ab.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.rpX = false;
            AppMethodBeat.o(38855);
            return;
        }
        if (this.mController.ymc == 1) {
            csY();
            this.rho = false;
            this.rqC.run();
        }
        AppMethodBeat.o(38855);
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(38858);
        if (snsCommentDetailUI.li(false).cqA().equals(str)) {
            snsCommentDetailUI.rqp.setVisibility(0);
            snsCommentDetailUI.rqp.El(1);
        }
        AppMethodBeat.o(38858);
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(38859);
        ap.cZ(str, 4);
        if (snsCommentDetailUI.rpQ != null) {
            snsCommentDetailUI.rpQ.notifyDataSetChanged();
        }
        AppMethodBeat.o(38859);
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(38860);
        n li = snsCommentDetailUI.li(false);
        if (li.cqA().equals(str)) {
            ap.da(str, 4);
            snsCommentDetailUI.rqp.setVisibility(8);
            snsCommentDetailUI.rpK.setTag(new ar(snsCommentDetailUI.cFc, li.cqU(), true, false, 2));
        }
        AppMethodBeat.o(38860);
    }

    static /* synthetic */ void i(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38866);
        snsCommentDetailUI.lh(true);
        AppMethodBeat.o(38866);
    }

    static /* synthetic */ void x(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(38869);
        if (snsCommentDetailUI.rhq != null) {
            snsCommentDetailUI.rhq.lj(false);
            if (snsCommentDetailUI.rhq.ctd()) {
                snsCommentDetailUI.rhq.rrt = 0;
                snsCommentDetailUI.rhq.ctg();
                snsCommentDetailUI.rhq.setCommentHint(snsCommentDetailUI.getString(R.string.eq9));
                n li = snsCommentDetailUI.li(true);
                if (li != null) {
                    if (!li.DI(32) || (li.cqu().xfI.wbL & 8) == 0) {
                        snsCommentDetailUI.rhq.lk(false);
                    } else {
                        snsCommentDetailUI.rhq.lk(true);
                        AppMethodBeat.o(38869);
                        return;
                    }
                }
                AppMethodBeat.o(38869);
                return;
            }
            snsCommentDetailUI.rhq.state = 0;
        }
        AppMethodBeat.o(38869);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void z(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        AppMethodBeat.i(38870);
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
            if (aj.p(h.YS(snsCommentDetailUI.cFc)).xaq.size() > 0) {
                i++;
                if (i > snsCommentDetailUI.rpQ.getCount()) {
                    i = snsCommentDetailUI.rpQ.getCount() - 1;
                }
            }
            snsCommentDetailUI.rqC.Ro = i;
            snsCommentDetailUI.csZ();
            AppMethodBeat.o(38870);
        }
        i = count;
        snsCommentDetailUI.rqC.itemHeight = snsCommentDetailUI.csV();
        if (aj.p(h.YS(snsCommentDetailUI.cFc)).xaq.size() > 0) {
        }
        snsCommentDetailUI.rqC.Ro = i;
        snsCommentDetailUI.csZ();
        AppMethodBeat.o(38870);
    }

    static /* synthetic */ void F(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        AppMethodBeat.i(38872);
        if (com.tencent.mm.plugin.sns.storage.v.Zo(snsCommentDetailUI.cFc)) {
            n YS = h.YS(snsCommentDetailUI.cFc);
            if (YS.field_likeFlag == 0) {
                YS.field_likeFlag = 1;
                h.a(YS.cqA(), YS);
                if (YS.DI(32)) {
                    i = 7;
                }
                com.tencent.mm.plugin.sns.model.am.a.a(YS, i, "", snsCommentDetailUI.getSource());
                snsCommentDetailUI.rpQ.notifyDataSetChanged();
            } else {
                YS.field_likeFlag = 0;
                h.a(YS.cqA(), YS);
                com.tencent.mm.plugin.sns.model.am.a.Yd(YS.cqA());
            }
            if (snsCommentDetailUI.rqm != null && (snsCommentDetailUI.rqm instanceof com.tencent.mm.plugin.sns.ui.c.a.d)) {
                ((com.tencent.mm.plugin.sns.ui.c.a.d) snsCommentDetailUI.rqm).cuV();
            }
            cbf p = aj.p(h.YS(snsCommentDetailUI.cFc));
            if (p != null) {
                snsCommentDetailUI.rpV = p.xaq;
                snsCommentDetailUI.e(p.xaq, p.xat.isEmpty());
                b bVar = snsCommentDetailUI.rpQ;
                bVar.rrk = p.xaq;
                bVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(38872);
    }
}
