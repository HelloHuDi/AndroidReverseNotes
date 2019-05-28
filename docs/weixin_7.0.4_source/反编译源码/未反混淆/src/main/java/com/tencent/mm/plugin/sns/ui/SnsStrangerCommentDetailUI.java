package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.p;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements b {
    private static int rxv = 4;
    private long cND;
    private int cvd;
    private ImageView gvq;
    private TextView jWY;
    private View omD;
    private an rhs;
    private n ros;
    private int rpW = -1;
    private com.tencent.mm.sdk.e.k.a rtZ = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(39318);
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39317);
                    ab.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
                    SnsStrangerCommentDetailUI.this.rxr.a(null, null);
                    if (SnsStrangerCommentDetailUI.this.rxt) {
                        SnsStrangerCommentDetailUI.this.rxt = false;
                        af.bCo().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(39319);
                                SnsStrangerCommentDetailUI.this.rxn.setSelection(SnsStrangerCommentDetailUI.this.rxr.getCount() - 1);
                                AppMethodBeat.o(39319);
                            }
                        }, 10);
                    }
                    AppMethodBeat.o(39317);
                }
            });
            AppMethodBeat.o(39318);
        }
    };
    private ListView rxn;
    private SnsCommentFooter rxo;
    private LinearLayout rxp;
    private List<View> rxq;
    private a rxr;
    private boolean rxs = false;
    private boolean rxt = false;
    private ad rxu;
    private String talker;

    class a extends p<j> {
        private Activity czX;
        private OnClickListener jNC = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39322);
                String str = (String) view.getTag();
                ab.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.gkE.c(intent, a.this.czX);
                AppMethodBeat.o(39322);
            }
        };

        class a {
            ImageView ejo;
            TextView gKl;
            TextView pnE;
            TextView qeX;
            ImageView rxz;
            TextView timeTv;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(39328);
            j jVar = (j) obj;
            if (jVar == null) {
                jVar = new j();
            }
            jVar.d(cursor);
            AppMethodBeat.o(39328);
            return jVar;
        }

        public a(Activity activity) {
            super(activity, new j());
            AppMethodBeat.i(39324);
            this.czX = activity;
            AppMethodBeat.o(39324);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(39325);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.czX, R.layout.awe, null);
                aVar2.ejo = (ImageView) view.findViewById(R.id.elq);
                aVar2.gKl = (TextView) view.findViewById(R.id.els);
                aVar2.pnE = (TextView) view.findViewById(R.id.elr);
                aVar2.qeX = (TextView) view.findViewById(R.id.elu);
                aVar2.timeTv = (TextView) view.findViewById(R.id.elv);
                aVar2.rxz = (ImageView) view.findViewById(R.id.elt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            j jVar = (j) getItem(i);
            try {
                CharSequence charSequence;
                can can = (can) new can().parseFrom(jVar.field_curActionBuf);
                com.tencent.mm.pluginsdk.ui.a.b.t(aVar.ejo, can.wPm);
                aVar.ejo.setTag(can.wPm);
                aVar.ejo.setOnClickListener(this.jNC);
                if (can.wZD != null) {
                    charSequence = can.wZD;
                } else {
                    charSequence = ((j) this.ylb).field_talker;
                }
                aVar.pnE.setTag(can.wPm);
                SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(this.czX, charSequence, aVar.pnE.getTextSize());
                b.setSpan(new o(can.wPm) {
                    public final void onClick(View view) {
                        AppMethodBeat.i(39323);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", view.getTag().toString());
                        com.tencent.mm.plugin.sns.c.a.gkE.c(intent, a.this.czX);
                        AppMethodBeat.o(39323);
                    }
                }, 0, charSequence.length(), 33);
                aVar.pnE.setText(b, BufferType.SPANNABLE);
                aVar.pnE.setOnTouchListener(new aa());
                if (jVar.field_type == 3) {
                    aVar.gKl.setVisibility(0);
                    aVar.rxz.setVisibility(8);
                    ab.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + can.vFH + "  time:" + can.pcX + " timeFormatted:" + aw.l(this.czX, ((long) can.pcX) * 1000));
                    aVar.gKl.setText(can.ncM + " ");
                    com.tencent.mm.pluginsdk.ui.e.j.h(aVar.gKl, 2);
                    aVar.gKl.setVisibility(0);
                } else {
                    aVar.gKl.setVisibility(8);
                    aVar.rxz.setVisibility(0);
                }
                if (!r.Yz().equals(can.wPm)) {
                    aVar.qeX.setVisibility(0);
                    TextView textView = aVar.qeX;
                    switch (can.vFH) {
                        case 18:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.eku));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this.czX, R.drawable.al5), null);
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        case 29:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.ekw));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this.czX, R.drawable.al7), null);
                            break;
                        case 25:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.ekt));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this.czX, R.drawable.al3), null);
                            break;
                        case 30:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.ekv));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this.czX, R.drawable.al4), null);
                            break;
                        default:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.ekx));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this.czX, R.drawable.al6), null);
                            break;
                    }
                }
                aVar.qeX.setVisibility(8);
                aVar.timeTv.setText(aw.l(this.czX, ((long) can.pcX) * 1000));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
            }
            AppMethodBeat.o(39325);
            return view;
        }

        public final void KC() {
            AppMethodBeat.i(39326);
            k cnK = af.cnK();
            String l = SnsStrangerCommentDetailUI.this.talker;
            l = k.cqE() + " where talker = " + h.escape(l) + " and  snsID = " + SnsStrangerCommentDetailUI.this.cND + " and ( type = 3 or type = 5 )";
            ab.v("MicroMsg.SnsCommentStorage", "comment sql:".concat(String.valueOf(l)));
            setCursor(cnK.fni.a(l, null, 0));
            AppMethodBeat.o(39326);
        }

        public final void KD() {
            AppMethodBeat.i(39327);
            KC();
            AppMethodBeat.o(39327);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsStrangerCommentDetailUI() {
        AppMethodBeat.i(39329);
        AppMethodBeat.o(39329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39330);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ek2);
        this.cND = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.talker = getIntent().getStringExtra("INTENT_TALKER");
        this.ros = af.cnF().kD(this.cND);
        this.cvd = getIntent().getIntExtra("INTENT_SOURCE", -1);
        g.RQ();
        this.rxu = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.talker);
        if (this.ros == null || this.talker == null) {
            finish();
            AppMethodBeat.o(39330);
            return;
        }
        this.rhs = new an(this);
        af.cnK().c(this.rtZ);
        initView();
        AppMethodBeat.o(39330);
    }

    public void onResume() {
        AppMethodBeat.i(39331);
        af.cnA().a((b) this);
        super.onResume();
        AppMethodBeat.o(39331);
    }

    public void onPause() {
        AppMethodBeat.i(39332);
        af.cnA().b((b) this);
        super.onPause();
        AppMethodBeat.o(39332);
    }

    public void onDestroy() {
        AppMethodBeat.i(39333);
        af.cnK().d(this.rtZ);
        af.cnC().ab(this);
        if (this.rxr != null) {
            this.rxr.bIf();
        }
        super.onDestroy();
        AppMethodBeat.o(39333);
    }

    public final void initView() {
        AppMethodBeat.i(39334);
        this.rxn = (ListView) findViewById(R.id.ehm);
        this.rxo = (SnsCommentFooter) findViewById(R.id.avz);
        this.omD = View.inflate(this, R.layout.awd, null);
        ctP();
        ctS();
        ctT();
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39311);
                c.a(SnsStrangerCommentDetailUI.this.rxn);
                AppMethodBeat.o(39311);
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39314);
                SnsStrangerCommentDetailUI.this.finish();
                AppMethodBeat.o(39314);
                return true;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39315);
                SnsStrangerCommentDetailUI.b(SnsStrangerCommentDetailUI.this);
                AppMethodBeat.o(39315);
                return true;
            }
        });
        AppMethodBeat.o(39334);
    }

    private void ctP() {
        AppMethodBeat.i(39335);
        this.rxp = (LinearLayout) this.omD.findViewById(R.id.elp);
        this.gvq = (ImageView) this.omD.findViewById(R.id.ehn);
        this.jWY = (TextView) this.omD.findViewById(R.id.elo);
        com.tencent.mm.pluginsdk.ui.a.b.t(this.gvq, this.ros.field_userName);
        this.jWY.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(this.ros.field_userName), this.jWY.getTextSize()));
        ctQ();
        ctR();
        AppMethodBeat.o(39335);
    }

    private void ctQ() {
        AppMethodBeat.i(39336);
        this.rxp.removeAllViews();
        int b = BackwardSupportUtil.b.b((Context) this, (float) rxv);
        LinkedList linkedList = this.ros.cqu().xfI.wbK;
        this.rxq = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                MMImageView mMImageView = new MMImageView(this);
                mMImageView.setPadding(b, b, b, b);
                this.rxp.addView(mMImageView, new LayoutParams(-2, -2));
                Bitmap Xh = af.cnC().a((bau) linkedList.get(i2), (ImageView) mMImageView, hashCode(), az.xYU).Xh();
                if (Xh == null) {
                    a(this.ros.field_type, mMImageView);
                } else {
                    mMImageView.setImageBitmap(Xh);
                }
                this.rxq.add(mMImageView);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(39336);
                return;
            }
        }
    }

    private void ctR() {
        AppMethodBeat.i(39337);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rxq.size()) {
                ao aoVar = new ao();
                aoVar.czD = this.ros.cqU();
                aoVar.index = i2;
                aoVar.rsl = this.rxq;
                ((View) this.rxq.get(i2)).setTag(aoVar);
                ((View) this.rxq.get(i2)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(39320);
                        if (view.getTag() instanceof ao) {
                            SnsStrangerCommentDetailUI.this.rhs.t(view, 2, 1);
                        }
                        AppMethodBeat.o(39320);
                    }
                });
                i = i2 + 1;
            } else {
                AppMethodBeat.o(39337);
                return;
            }
        }
    }

    private void ctS() {
        AppMethodBeat.i(39338);
        this.rxn.addHeaderView(this.omD);
        this.rxr = new a(this);
        this.rxn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39321);
                SnsStrangerCommentDetailUI.this.rpW = SnsStrangerCommentDetailUI.this.rxn.getBottom();
                ab.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.this.rpW);
                AppMethodBeat.o(39321);
            }
        });
        this.rxn.setAdapter(this.rxr);
        this.rxn.setOnScrollListener(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }
        });
        AppMethodBeat.o(39338);
    }

    private void ctT() {
        AppMethodBeat.i(39339);
        this.rxo.setAfterEditAction(new Runnable() {
            int rro = -1;
            int rrp = 10;

            public final void run() {
                AppMethodBeat.i(39312);
                if (!SnsStrangerCommentDetailUI.this.rxs) {
                    this.rrp = 10;
                }
                SnsStrangerCommentDetailUI.this.rxs = true;
                ab.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.this.rxn.getBottom() + " footer.top" + SnsStrangerCommentDetailUI.this.rxn.getTop());
                int top = SnsStrangerCommentDetailUI.this.rxo.getTop();
                int i = this.rrp;
                this.rrp = i - 1;
                if (i > 0 && (this.rro != top || SnsStrangerCommentDetailUI.this.rxn.getBottom() == SnsStrangerCommentDetailUI.this.rpW)) {
                    new ak().postDelayed(this, 30);
                }
                this.rro = top;
                c.b(SnsStrangerCommentDetailUI.this.rxn, SnsStrangerCommentDetailUI.this.rxn.getCount() - 1);
                AppMethodBeat.o(39312);
            }
        });
        this.rxo.ctf();
        this.rxo.setOnCommentSendImp(new b() {
            public final void Zr(String str) {
                AppMethodBeat.i(39313);
                ab.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
                SnsStrangerCommentDetailUI.this.rxt = true;
                SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, SnsStrangerCommentDetailUI.this.ros, str);
                AppMethodBeat.o(39313);
            }
        });
        this.rxo.setCommentHint(getString(R.string.env) + this.talker + getString(R.string.ejk));
        AppMethodBeat.o(39339);
    }

    public final int getLayoutId() {
        return R.layout.av0;
    }

    private static void a(int i, MMImageView mMImageView) {
        int i2 = R.raw.app_attach_file_icon_webpage;
        AppMethodBeat.i(39340);
        switch (i) {
            case 1:
                i2 = R.drawable.avp;
                break;
            case 2:
                mMImageView.setImageDrawable(null);
                i2 = 0;
                break;
            case 4:
                i2 = R.raw.app_attach_file_icon_music;
                break;
            case 5:
                i2 = R.raw.app_attach_file_icon_video;
                break;
            case 6:
                i2 = R.raw.app_attach_file_icon_location;
                break;
            case 7:
                i2 = R.drawable.avp;
                break;
            case 8:
                mMImageView.setImageDrawable(null);
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            mMImageView.setImageResource(i2);
        }
        AppMethodBeat.o(39340);
    }

    public final void Xw(String str) {
        AppMethodBeat.i(39341);
        ctQ();
        AppMethodBeat.o(39341);
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39342);
        ab.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(39342);
            return;
        }
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
        AppMethodBeat.o(39342);
    }

    public final void bk(String str, boolean z) {
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        AppMethodBeat.i(39343);
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.rxu == null) {
            snsStrangerCommentDetailUI.rxu = new ad();
            AppMethodBeat.o(39343);
            return;
        }
        if (!com.tencent.mm.n.a.jh(snsStrangerCommentDetailUI.rxu.field_type)) {
            t.f(snsStrangerCommentDetailUI.rxu);
        }
        if (snsStrangerCommentDetailUI.rxu.Oa()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(R.string.ay6);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(R.string.ay1);
        }
        com.tencent.mm.ui.base.h.a((Context) snsStrangerCommentDetailUI, "", strArr, "", false, new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(39316);
                switch (i) {
                    case 0:
                        if (!SnsStrangerCommentDetailUI.this.rxu.Oa()) {
                            t.i(SnsStrangerCommentDetailUI.this.rxu);
                            SnsStrangerCommentDetailUI.this.rxu.ND();
                            com.tencent.mm.plugin.sns.c.a.gkF.BS();
                            break;
                        }
                        t.j(SnsStrangerCommentDetailUI.this.rxu);
                        SnsStrangerCommentDetailUI.this.rxu.NE();
                        com.tencent.mm.plugin.sns.c.a.gkF.BS();
                        AppMethodBeat.o(39316);
                        return;
                }
                AppMethodBeat.o(39316);
            }
        });
        AppMethodBeat.o(39343);
    }

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, n nVar, String str) {
        AppMethodBeat.i(39344);
        if (str == null || str.trim().equals("")) {
            AppMethodBeat.o(39344);
            return;
        }
        com.tencent.mm.plugin.sns.model.am.a.a(snsStrangerCommentDetailUI.talker, 3, str, nVar, snsStrangerCommentDetailUI.cvd);
        AppMethodBeat.o(39344);
    }
}
