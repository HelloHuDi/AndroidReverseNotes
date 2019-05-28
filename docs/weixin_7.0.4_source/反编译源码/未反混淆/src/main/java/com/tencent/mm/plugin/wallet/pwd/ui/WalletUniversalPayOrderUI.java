package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet.pwd.a.d;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public class WalletUniversalPayOrderUI extends WalletBaseUI {
    private ViewGroup kox;
    private ViewGroup laj;
    private DragSortListView ttn;
    private a tto;
    private TextView ttp;
    private TextView ttq;
    private TextView ttr;
    private MMSwitchBtn tts;
    private TextView ttt;
    private TextView ttu;
    private Dialog ttv;
    private boolean ttw = true;

    static class b {
        public View iym;
        public CdnImageView ttA;
        public TextView ttB;
        public ImageView ttC;

        public b(View view) {
            AppMethodBeat.i(46438);
            this.iym = view;
            this.ttA = (CdnImageView) view.findViewById(R.id.f_j);
            this.ttB = (TextView) view.findViewById(R.id.f_k);
            this.ttC = (ImageView) view.findViewById(R.id.f_l);
            AppMethodBeat.o(46438);
        }
    }

    static class a extends BaseAdapter {
        List<cjg> khh;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(46437);
            cjg Hl = Hl(i);
            AppMethodBeat.o(46437);
            return Hl;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final void gg(int i, int i2) {
            AppMethodBeat.i(46433);
            ab.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.khh.add(i2, (cjg) this.khh.remove(i));
            AppMethodBeat.o(46433);
        }

        public final int getCount() {
            AppMethodBeat.i(46434);
            if (this.khh == null) {
                AppMethodBeat.o(46434);
                return 0;
            }
            int size = this.khh.size();
            AppMethodBeat.o(46434);
            return size;
        }

        private cjg Hl(int i) {
            AppMethodBeat.i(46435);
            if (this.khh == null) {
                AppMethodBeat.o(46435);
                return null;
            }
            cjg cjg = (cjg) this.khh.get(i);
            AppMethodBeat.o(46435);
            return cjg;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(46436);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.b41, viewGroup, false);
                view.setTag(new b(view));
            }
            cjg Hl = Hl(i);
            b bVar = (b) view.getTag();
            bVar.ttA.setImageBitmap(null);
            bVar.ttA.eb(Hl.kbV, R.drawable.a8g);
            bVar.ttB.setText(Hl.nuL);
            AppMethodBeat.o(46436);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b42;
    }

    public final void initView() {
        AppMethodBeat.i(46440);
        this.ttn = (DragSortListView) findViewById(R.id.f_m);
        cOP();
        bGb();
        this.tto = new a(this);
        this.ttn.setAdapter(this.tto);
        this.ttn.setDropListener(new h() {
            public final void dm(int i, int i2) {
                AppMethodBeat.i(46422);
                if (i == i2) {
                    ab.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", Integer.valueOf(i));
                    AppMethodBeat.o(46422);
                    return;
                }
                WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, i, i2);
                com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(10));
                AppMethodBeat.o(46422);
            }
        });
        this.ttn.setRemoveListener(new l() {
            public final void remove(int i) {
            }
        });
        AppMethodBeat.o(46440);
    }

    private void cOP() {
        AppMethodBeat.i(46441);
        this.laj = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.b40, null, false);
        this.ttp = (TextView) this.laj.findViewById(R.id.f_e);
        this.ttq = (TextView) this.laj.findViewById(R.id.f_f);
        this.ttr = (TextView) this.laj.findViewById(R.id.f_g);
        this.tts = (MMSwitchBtn) this.laj.findViewById(R.id.f_h);
        this.ttt = (TextView) this.laj.findViewById(R.id.f_i);
        this.ttn.addHeaderView(this.laj, null, false);
        AppMethodBeat.o(46441);
    }

    private void bGb() {
        AppMethodBeat.i(46442);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.b3z, null, false);
        this.ttu = (TextView) this.kox.findViewById(R.id.f_d);
        this.ttn.addFooterView(this.kox, null, false);
        AppMethodBeat.o(46442);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46439);
        this.yll = true;
        super.onCreate(bundle);
        xE(-1);
        dyb();
        setMMTitle("");
        initView();
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
        getString(R.string.pl);
        this.ttv = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.fop), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new c().acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<boh>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(46430);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (WalletUniversalPayOrderUI.this.ttv != null) {
                    WalletUniversalPayOrderUI.this.ttv.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    boh boh = (boh) aVar.fsy;
                    ab.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((boh) aVar.fsy).kCl), ((boh) aVar.fsy).kCm);
                    if (boh.kCl == 0) {
                        cji cji = boh.wRh;
                        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, cji);
                        WalletUniversalPayOrderUI.this.tto.khh = cji.vBz;
                        WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                    } else {
                        e.atC(boh.kCm);
                    }
                } else {
                    e.aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                }
                AppMethodBeat.o(46430);
                return null;
            }
        });
        com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(1));
        AppMethodBeat.o(46439);
    }

    static /* synthetic */ void a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final int i, final int i2) {
        AppMethodBeat.i(46443);
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "do update unipay order");
        walletUniversalPayOrderUI.getString(R.string.pl);
        walletUniversalPayOrderUI.ttv = com.tencent.mm.ui.base.h.b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.fop), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        walletUniversalPayOrderUI.tto.gg(i, i2);
        walletUniversalPayOrderUI.tto.notifyDataSetChanged();
        LinkedList linkedList = new LinkedList();
        if (walletUniversalPayOrderUI.tto.khh != null) {
            linkedList.addAll(walletUniversalPayOrderUI.tto.khh);
        }
        new d(linkedList).acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<ckf>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(46423);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (WalletUniversalPayOrderUI.this.ttv != null) {
                    WalletUniversalPayOrderUI.this.ttv.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    ckf ckf = (ckf) aVar.fsy;
                    ab.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((ckf) aVar.fsy).kCl), ((ckf) aVar.fsy).kCm);
                    if (ckf.kCl == 0) {
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        e.atC(ckf.kCm);
                        WalletUniversalPayOrderUI.this.tto.gg(i2, i);
                        WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                    }
                } else {
                    e.aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                    WalletUniversalPayOrderUI.this.tto.gg(i2, i);
                    WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                }
                AppMethodBeat.o(46423);
                return null;
            }
        });
        AppMethodBeat.o(46443);
    }

    static /* synthetic */ void a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final cji cji) {
        AppMethodBeat.i(46444);
        if (!bo.isNullOrNil(cji.title)) {
            walletUniversalPayOrderUI.ttp.setText(cji.title);
        }
        if (!bo.isNullOrNil(cji.desc)) {
            walletUniversalPayOrderUI.ttq.setText(cji.desc);
        }
        if (!bo.isNullOrNil(cji.xhW)) {
            walletUniversalPayOrderUI.ttr.setText(cji.xhW);
        }
        if (!bo.isNullOrNil(cji.xhX)) {
            walletUniversalPayOrderUI.ttt.setText(cji.xhX);
        }
        walletUniversalPayOrderUI.tts.setCheck(cji.wRi == 1);
        walletUniversalPayOrderUI.tts.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(46428);
                ab.i("MicroMsg.WalletUniversalPayOrderUI", "click switch: %s", Boolean.valueOf(z));
                WalletUniversalPayOrderUI.this.ttn.setDragEnabled(z);
                cjh cjh;
                com.tencent.mm.ui.widget.a.c.a aVar;
                com.tencent.mm.ui.widget.a.c aMb;
                if (z) {
                    if (cji.xhZ != 1 || cji.xia == null || bo.isNullOrNil(cji.xia.title)) {
                        WalletUniversalPayOrderUI.f(WalletUniversalPayOrderUI.this);
                    } else {
                        ab.i("MicroMsg.WalletUniversalPayOrderUI", "show open dialog");
                        cjh = cji.xia;
                        aVar = new com.tencent.mm.ui.widget.a.c.a(WalletUniversalPayOrderUI.this.mController.ylL);
                        aVar.asD(cjh.title);
                        aVar.asE(cjh.content);
                        aVar.rc(false);
                        if (cjh.xhU != null) {
                            aVar.asK(cjh.xhU.title);
                            aVar.b(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46424);
                                    WalletUniversalPayOrderUI.this.tts.setCheck(false);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(4));
                                    AppMethodBeat.o(46424);
                                }
                            });
                        }
                        if (cjh.xhV != null) {
                            aVar.asJ(cjh.xhV.title);
                            aVar.a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46425);
                                    WalletUniversalPayOrderUI.f(WalletUniversalPayOrderUI.this);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(5));
                                    AppMethodBeat.o(46425);
                                }
                            });
                        }
                        aMb = aVar.aMb();
                        WalletUniversalPayOrderUI.this.addDialog(aMb);
                        aMb.show();
                        com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(3));
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(2));
                    AppMethodBeat.o(46428);
                    return;
                }
                if (WalletUniversalPayOrderUI.this.ttw) {
                    WalletUniversalPayOrderUI.this.ttw = false;
                    if (cji.xib == null || bo.isNullOrNil(cji.xib.title)) {
                        WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                    } else {
                        ab.i("MicroMsg.WalletUniversalPayOrderUI", "show close dialog");
                        cjh = cji.xib;
                        aVar = new com.tencent.mm.ui.widget.a.c.a(WalletUniversalPayOrderUI.this.mController.ylL);
                        aVar.asD(cjh.title);
                        aVar.asE(cjh.content);
                        aVar.rc(false);
                        if (cjh.xhU != null) {
                            aVar.asK(cjh.xhU.title);
                            aVar.b(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46426);
                                    WalletUniversalPayOrderUI.this.tts.setCheck(true);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(8));
                                    AppMethodBeat.o(46426);
                                }
                            });
                        }
                        if (cjh.xhV != null) {
                            aVar.asJ(cjh.xhV.title);
                            aVar.a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46427);
                                    WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(9));
                                    AppMethodBeat.o(46427);
                                }
                            });
                        }
                        aMb = aVar.aMb();
                        WalletUniversalPayOrderUI.this.addDialog(aMb);
                        aMb.show();
                        com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(7));
                    }
                } else {
                    WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(6));
                AppMethodBeat.o(46428);
            }
        });
        if (cji.xhY == null || bo.isNullOrNil(cji.xhY.title)) {
            walletUniversalPayOrderUI.ttu.setVisibility(8);
            AppMethodBeat.o(46444);
            return;
        }
        o oVar = new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(46429);
                e.n(WalletUniversalPayOrderUI.this.mController.ylL, cji.xhY.url, true);
                com.tencent.mm.plugin.report.service.h.pYm.e(16343, Integer.valueOf(11));
                AppMethodBeat.o(46429);
            }
        });
        SpannableString spannableString = new SpannableString(cji.xhY.title);
        spannableString.setSpan(oVar, 0, spannableString.length(), 18);
        walletUniversalPayOrderUI.ttu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(walletUniversalPayOrderUI.mController.ylL));
        walletUniversalPayOrderUI.ttu.setClickable(true);
        walletUniversalPayOrderUI.ttu.setText(spannableString);
        walletUniversalPayOrderUI.ttu.setVisibility(0);
        AppMethodBeat.o(46444);
    }

    static /* synthetic */ void c(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(46445);
        walletUniversalPayOrderUI.setResult(-1);
        AppMethodBeat.o(46445);
    }

    static /* synthetic */ void f(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(46446);
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "do open unipay order");
        walletUniversalPayOrderUI.getString(R.string.pl);
        walletUniversalPayOrderUI.ttv = com.tencent.mm.ui.base.h.b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.fop), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.wallet.pwd.a.b().acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<bhi>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(46431);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (WalletUniversalPayOrderUI.this.ttv != null) {
                    WalletUniversalPayOrderUI.this.ttv.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    bhi bhi = (bhi) aVar.fsy;
                    ab.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((bhi) aVar.fsy).kCl), ((bhi) aVar.fsy).kCm);
                    if (bhi.kCl == 0) {
                        WalletUniversalPayOrderUI.this.tto.khh = bhi.vBz;
                        WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        e.atC(bhi.kCm);
                        WalletUniversalPayOrderUI.this.tts.setCheck(false);
                    }
                } else {
                    e.aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                    WalletUniversalPayOrderUI.this.tts.setCheck(false);
                }
                AppMethodBeat.o(46431);
                return null;
            }
        });
        AppMethodBeat.o(46446);
    }

    static /* synthetic */ void i(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(46447);
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "do close unipay order");
        walletUniversalPayOrderUI.getString(R.string.pl);
        walletUniversalPayOrderUI.ttv = com.tencent.mm.ui.base.h.b((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.fop), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.wallet.pwd.a.a().acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<sy>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(46432);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (WalletUniversalPayOrderUI.this.ttv != null) {
                    WalletUniversalPayOrderUI.this.ttv.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    sy syVar = (sy) aVar.fsy;
                    ab.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((sy) aVar.fsy).kCl), ((sy) aVar.fsy).kCm);
                    if (syVar.kCl == 0) {
                        a b = WalletUniversalPayOrderUI.this.tto;
                        if (b.khh != null) {
                            b.khh.clear();
                        }
                        WalletUniversalPayOrderUI.this.tto.notifyDataSetChanged();
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        e.atC(syVar.kCm);
                        WalletUniversalPayOrderUI.this.tts.setCheck(true);
                    }
                } else {
                    e.aj(WalletUniversalPayOrderUI.this.mController.ylL, "");
                    WalletUniversalPayOrderUI.this.tts.setCheck(true);
                }
                AppMethodBeat.o(46432);
                return null;
            }
        });
        AppMethodBeat.o(46447);
    }
}
