package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16018h;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C30819l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22538a;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C35449d;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C41326c;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C46354b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.C7552sy;
import com.tencent.p177mm.protocal.protobuf.bhi;
import com.tencent.p177mm.protocal.protobuf.boh;
import com.tencent.p177mm.protocal.protobuf.cjg;
import com.tencent.p177mm.protocal.protobuf.cjh;
import com.tencent.p177mm.protocal.protobuf.cji;
import com.tencent.p177mm.protocal.protobuf.ckf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI */
public class WalletUniversalPayOrderUI extends WalletBaseUI {
    private ViewGroup kox;
    private ViewGroup laj;
    private DragSortListView ttn;
    private C40090a tto;
    private TextView ttp;
    private TextView ttq;
    private TextView ttr;
    private MMSwitchBtn tts;
    private TextView ttt;
    private TextView ttu;
    private Dialog ttv;
    private boolean ttw = true;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$1 */
    class C225551 implements C16018h {
        C225551() {
        }

        /* renamed from: dm */
        public final void mo17752dm(int i, int i2) {
            AppMethodBeat.m2504i(46422);
            if (i == i2) {
                C4990ab.m7411d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", Integer.valueOf(i));
                AppMethodBeat.m2505o(46422);
                return;
            }
            WalletUniversalPayOrderUI.m78467a(WalletUniversalPayOrderUI.this, i, i2);
            C7060h.pYm.mo8381e(16343, Integer.valueOf(10));
            AppMethodBeat.m2505o(46422);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$8 */
    class C225568 implements OnCancelListener {
        C225568() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$7 */
    class C296117 implements C5681a<Object, C37441a<boh>> {
        C296117() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(46430);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (WalletUniversalPayOrderUI.this.ttv != null) {
                WalletUniversalPayOrderUI.this.ttv.dismiss();
            }
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                boh boh = (boh) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((boh) c37441a.fsy).kCl), ((boh) c37441a.fsy).kCm);
                if (boh.kCl == 0) {
                    cji cji = boh.wRh;
                    WalletUniversalPayOrderUI.m78468a(WalletUniversalPayOrderUI.this, cji);
                    WalletUniversalPayOrderUI.this.tto.khh = cji.vBz;
                    WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                } else {
                    C36391e.atC(boh.kCm);
                }
            } else {
                C36391e.m59994aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
            }
            AppMethodBeat.m2505o(46430);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$9 */
    class C296129 implements C5681a<Object, C37441a<bhi>> {
        C296129() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(46431);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (WalletUniversalPayOrderUI.this.ttv != null) {
                WalletUniversalPayOrderUI.this.ttv.dismiss();
            }
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bhi bhi = (bhi) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((bhi) c37441a.fsy).kCl), ((bhi) c37441a.fsy).kCm);
                if (bhi.kCl == 0) {
                    WalletUniversalPayOrderUI.this.tto.khh = bhi.vBz;
                    WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                    WalletUniversalPayOrderUI.m78470c(WalletUniversalPayOrderUI.this);
                } else {
                    C36391e.atC(bhi.kCm);
                    WalletUniversalPayOrderUI.this.tts.setCheck(false);
                }
            } else {
                C36391e.m59994aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                WalletUniversalPayOrderUI.this.tts.setCheck(false);
            }
            AppMethodBeat.m2505o(46431);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$b */
    static class C29613b {
        public View iym;
        public CdnImageView ttA;
        public TextView ttB;
        public ImageView ttC;

        public C29613b(View view) {
            AppMethodBeat.m2504i(46438);
            this.iym = view;
            this.ttA = (CdnImageView) view.findViewById(2131828777);
            this.ttB = (TextView) view.findViewById(2131828778);
            this.ttC = (ImageView) view.findViewById(2131828779);
            AppMethodBeat.m2505o(46438);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$11 */
    class C4008711 implements C5681a<Object, C37441a<C7552sy>> {
        C4008711() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(46432);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (WalletUniversalPayOrderUI.this.ttv != null) {
                WalletUniversalPayOrderUI.this.ttv.dismiss();
            }
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C7552sy c7552sy = (C7552sy) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((C7552sy) c37441a.fsy).kCl), ((C7552sy) c37441a.fsy).kCm);
                if (c7552sy.kCl == 0) {
                    C40090a b = WalletUniversalPayOrderUI.this.tto;
                    if (b.khh != null) {
                        b.khh.clear();
                    }
                    WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                    WalletUniversalPayOrderUI.m78470c(WalletUniversalPayOrderUI.this);
                } else {
                    C36391e.atC(c7552sy.kCm);
                    WalletUniversalPayOrderUI.this.tts.setCheck(true);
                }
            } else {
                C36391e.m59994aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                WalletUniversalPayOrderUI.this.tts.setCheck(true);
            }
            AppMethodBeat.m2505o(46432);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$6 */
    class C400896 implements OnCancelListener {
        C400896() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$a */
    static class C40090a extends BaseAdapter {
        List<cjg> khh;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(46437);
            cjg Hl = m68708Hl(i);
            AppMethodBeat.m2505o(46437);
            return Hl;
        }

        public C40090a(Context context) {
            this.mContext = context;
        }

        /* renamed from: gg */
        public final void mo63402gg(int i, int i2) {
            AppMethodBeat.m2504i(46433);
            C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.khh.add(i2, (cjg) this.khh.remove(i));
            AppMethodBeat.m2505o(46433);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(46434);
            if (this.khh == null) {
                AppMethodBeat.m2505o(46434);
                return 0;
            }
            int size = this.khh.size();
            AppMethodBeat.m2505o(46434);
            return size;
        }

        /* renamed from: Hl */
        private cjg m68708Hl(int i) {
            AppMethodBeat.m2504i(46435);
            if (this.khh == null) {
                AppMethodBeat.m2505o(46435);
                return null;
            }
            cjg cjg = (cjg) this.khh.get(i);
            AppMethodBeat.m2505o(46435);
            return cjg;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(46436);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(2130971090, viewGroup, false);
                view.setTag(new C29613b(view));
            }
            cjg Hl = m68708Hl(i);
            C29613b c29613b = (C29613b) view.getTag();
            c29613b.ttA.setImageBitmap(null);
            c29613b.ttA.mo38952eb(Hl.kbV, C25738R.drawable.a8g);
            c29613b.ttB.setText(Hl.nuL);
            AppMethodBeat.m2505o(46436);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$10 */
    class C4378210 implements OnCancelListener {
        C4378210() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$12 */
    class C4378312 implements OnCancelListener {
        C4378312() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$5 */
    class C437845 implements C30819l {
        C437845() {
        }

        public final void remove(int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971091;
    }

    public final void initView() {
        AppMethodBeat.m2504i(46440);
        this.ttn = (DragSortListView) findViewById(2131828780);
        cOP();
        bGb();
        this.tto = new C40090a(this);
        this.ttn.setAdapter(this.tto);
        this.ttn.setDropListener(new C225551());
        this.ttn.setRemoveListener(new C437845());
        AppMethodBeat.m2505o(46440);
    }

    private void cOP() {
        AppMethodBeat.m2504i(46441);
        this.laj = (ViewGroup) LayoutInflater.from(this).inflate(2130971089, null, false);
        this.ttp = (TextView) this.laj.findViewById(2131828772);
        this.ttq = (TextView) this.laj.findViewById(2131828773);
        this.ttr = (TextView) this.laj.findViewById(2131828774);
        this.tts = (MMSwitchBtn) this.laj.findViewById(2131828775);
        this.ttt = (TextView) this.laj.findViewById(2131828776);
        this.ttn.addHeaderView(this.laj, null, false);
        AppMethodBeat.m2505o(46441);
    }

    private void bGb() {
        AppMethodBeat.m2504i(46442);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(2130971088, null, false);
        this.ttu = (TextView) this.kox.findViewById(2131828771);
        this.ttn.addFooterView(this.kox, null, false);
        AppMethodBeat.m2505o(46442);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46439);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(-1);
        dyb();
        setMMTitle("");
        initView();
        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
        getString(C25738R.string.f9104pl);
        this.ttv = C30379h.m48458b((Context) this, getString(C25738R.string.fop), false, new C400896());
        new C41326c().acy().mo60487b(new C296117());
        C7060h.pYm.mo8381e(16343, Integer.valueOf(1));
        AppMethodBeat.m2505o(46439);
    }

    /* renamed from: a */
    static /* synthetic */ void m78467a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final int i, final int i2) {
        AppMethodBeat.m2504i(46443);
        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "do update unipay order");
        walletUniversalPayOrderUI.getString(C25738R.string.f9104pl);
        walletUniversalPayOrderUI.ttv = C30379h.m48458b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(C25738R.string.fop), false, new C4378312());
        walletUniversalPayOrderUI.tto.mo63402gg(i, i2);
        walletUniversalPayOrderUI.tto.notifyDataSetChanged();
        LinkedList linkedList = new LinkedList();
        if (walletUniversalPayOrderUI.tto.khh != null) {
            linkedList.addAll(walletUniversalPayOrderUI.tto.khh);
        }
        new C35449d(linkedList).acy().mo60487b(new C5681a<Object, C37441a<ckf>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(46423);
                C37441a c37441a = (C37441a) obj;
                C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                if (WalletUniversalPayOrderUI.this.ttv != null) {
                    WalletUniversalPayOrderUI.this.ttv.dismiss();
                }
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    ckf ckf = (ckf) c37441a.fsy;
                    C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((ckf) c37441a.fsy).kCl), ((ckf) c37441a.fsy).kCm);
                    if (ckf.kCl == 0) {
                        WalletUniversalPayOrderUI.m78470c(WalletUniversalPayOrderUI.this);
                    } else {
                        C36391e.atC(ckf.kCm);
                        WalletUniversalPayOrderUI.this.tto.mo63402gg(i2, i);
                        WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                    }
                } else {
                    C36391e.m59994aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                    WalletUniversalPayOrderUI.this.tto.mo63402gg(i2, i);
                    WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(46423);
                return null;
            }
        });
        AppMethodBeat.m2505o(46443);
    }

    /* renamed from: a */
    static /* synthetic */ void m78468a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final cji cji) {
        AppMethodBeat.m2504i(46444);
        if (!C5046bo.isNullOrNil(cji.title)) {
            walletUniversalPayOrderUI.ttp.setText(cji.title);
        }
        if (!C5046bo.isNullOrNil(cji.desc)) {
            walletUniversalPayOrderUI.ttq.setText(cji.desc);
        }
        if (!C5046bo.isNullOrNil(cji.xhW)) {
            walletUniversalPayOrderUI.ttr.setText(cji.xhW);
        }
        if (!C5046bo.isNullOrNil(cji.xhX)) {
            walletUniversalPayOrderUI.ttt.setText(cji.xhX);
        }
        walletUniversalPayOrderUI.tts.setCheck(cji.wRi == 1);
        walletUniversalPayOrderUI.tts.setSwitchListener(new C30795a() {

            /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$3$3 */
            class C142193 implements OnClickListener {
                C142193() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46426);
                    WalletUniversalPayOrderUI.this.tts.setCheck(true);
                    C7060h.pYm.mo8381e(16343, Integer.valueOf(8));
                    AppMethodBeat.m2505o(46426);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$3$4 */
            class C296104 implements OnClickListener {
                C296104() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46427);
                    WalletUniversalPayOrderUI.m78476i(WalletUniversalPayOrderUI.this);
                    C7060h.pYm.mo8381e(16343, Integer.valueOf(9));
                    AppMethodBeat.m2505o(46427);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$3$1 */
            class C354701 implements OnClickListener {
                C354701() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46424);
                    WalletUniversalPayOrderUI.this.tts.setCheck(false);
                    C7060h.pYm.mo8381e(16343, Integer.valueOf(4));
                    AppMethodBeat.m2505o(46424);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI$3$2 */
            class C354712 implements OnClickListener {
                C354712() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46425);
                    WalletUniversalPayOrderUI.m78473f(WalletUniversalPayOrderUI.this);
                    C7060h.pYm.mo8381e(16343, Integer.valueOf(5));
                    AppMethodBeat.m2505o(46425);
                }
            }

            /* renamed from: di */
            public final void mo6646di(boolean z) {
                AppMethodBeat.m2504i(46428);
                C4990ab.m7417i("MicroMsg.WalletUniversalPayOrderUI", "click switch: %s", Boolean.valueOf(z));
                WalletUniversalPayOrderUI.this.ttn.setDragEnabled(z);
                cjh cjh;
                C5652a c5652a;
                C5653c aMb;
                if (z) {
                    if (cji.xhZ != 1 || cji.xia == null || C5046bo.isNullOrNil(cji.xia.title)) {
                        WalletUniversalPayOrderUI.m78473f(WalletUniversalPayOrderUI.this);
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "show open dialog");
                        cjh = cji.xia;
                        c5652a = new C5652a(WalletUniversalPayOrderUI.this.mController.ylL);
                        c5652a.asD(cjh.title);
                        c5652a.asE(cjh.content);
                        c5652a.mo11482rc(false);
                        if (cjh.xhU != null) {
                            c5652a.asK(cjh.xhU.title);
                            c5652a.mo11476b(new C354701());
                        }
                        if (cjh.xhV != null) {
                            c5652a.asJ(cjh.xhV.title);
                            c5652a.mo11457a(new C354712());
                        }
                        aMb = c5652a.aMb();
                        WalletUniversalPayOrderUI.this.addDialog(aMb);
                        aMb.show();
                        C7060h.pYm.mo8381e(16343, Integer.valueOf(3));
                    }
                    C7060h.pYm.mo8381e(16343, Integer.valueOf(2));
                    AppMethodBeat.m2505o(46428);
                    return;
                }
                if (WalletUniversalPayOrderUI.this.ttw) {
                    WalletUniversalPayOrderUI.this.ttw = false;
                    if (cji.xib == null || C5046bo.isNullOrNil(cji.xib.title)) {
                        WalletUniversalPayOrderUI.m78476i(WalletUniversalPayOrderUI.this);
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "show close dialog");
                        cjh = cji.xib;
                        c5652a = new C5652a(WalletUniversalPayOrderUI.this.mController.ylL);
                        c5652a.asD(cjh.title);
                        c5652a.asE(cjh.content);
                        c5652a.mo11482rc(false);
                        if (cjh.xhU != null) {
                            c5652a.asK(cjh.xhU.title);
                            c5652a.mo11476b(new C142193());
                        }
                        if (cjh.xhV != null) {
                            c5652a.asJ(cjh.xhV.title);
                            c5652a.mo11457a(new C296104());
                        }
                        aMb = c5652a.aMb();
                        WalletUniversalPayOrderUI.this.addDialog(aMb);
                        aMb.show();
                        C7060h.pYm.mo8381e(16343, Integer.valueOf(7));
                    }
                } else {
                    WalletUniversalPayOrderUI.m78476i(WalletUniversalPayOrderUI.this);
                }
                C7060h.pYm.mo8381e(16343, Integer.valueOf(6));
                AppMethodBeat.m2505o(46428);
            }
        });
        if (cji.xhY == null || C5046bo.isNullOrNil(cji.xhY.title)) {
            walletUniversalPayOrderUI.ttu.setVisibility(8);
            AppMethodBeat.m2505o(46444);
            return;
        }
        C35503o c35503o = new C35503o(new C35502a() {
            /* renamed from: df */
            public final void mo9537df(View view) {
                AppMethodBeat.m2504i(46429);
                C36391e.m60016n(WalletUniversalPayOrderUI.this.mController.ylL, cji.xhY.url, true);
                C7060h.pYm.mo8381e(16343, Integer.valueOf(11));
                AppMethodBeat.m2505o(46429);
            }
        });
        SpannableString spannableString = new SpannableString(cji.xhY.title);
        spannableString.setSpan(c35503o, 0, spannableString.length(), 18);
        walletUniversalPayOrderUI.ttu.setOnTouchListener(new C30132m(walletUniversalPayOrderUI.mController.ylL));
        walletUniversalPayOrderUI.ttu.setClickable(true);
        walletUniversalPayOrderUI.ttu.setText(spannableString);
        walletUniversalPayOrderUI.ttu.setVisibility(0);
        AppMethodBeat.m2505o(46444);
    }

    /* renamed from: c */
    static /* synthetic */ void m78470c(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.m2504i(46445);
        walletUniversalPayOrderUI.setResult(-1);
        AppMethodBeat.m2505o(46445);
    }

    /* renamed from: f */
    static /* synthetic */ void m78473f(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.m2504i(46446);
        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "do open unipay order");
        walletUniversalPayOrderUI.getString(C25738R.string.f9104pl);
        walletUniversalPayOrderUI.ttv = C30379h.m48458b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(C25738R.string.fop), false, new C225568());
        new C46354b().acy().mo60487b(new C296129());
        AppMethodBeat.m2505o(46446);
    }

    /* renamed from: i */
    static /* synthetic */ void m78476i(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.m2504i(46447);
        C4990ab.m7416i("MicroMsg.WalletUniversalPayOrderUI", "do close unipay order");
        walletUniversalPayOrderUI.getString(C25738R.string.f9104pl);
        walletUniversalPayOrderUI.ttv = C30379h.m48458b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(C25738R.string.fop), false, new C4378210());
        new C22538a().acy().mo60487b(new C4008711());
        AppMethodBeat.m2505o(46447);
    }
}
