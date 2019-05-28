package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMAppMgr;

public final class o extends b {
    private ProgressDialog ehJ = null;
    private boolean fIa = false;
    private TextView gDQ;
    TextView gnB;
    private TextView gnC;
    private ImageView iqT;
    View jAp = null;
    int sIN = 0;
    private TextView zwQ;
    private TextView zwR;
    private ImageView zwS;
    private ImageView zwT;
    private ImageView zwU;
    private ProgressBar zwV;
    String zwW;
    private boolean zwX = false;
    int zwY;
    boolean zwZ;
    boolean zxa;
    boolean zxb;
    String zxc;
    ap zxd;
    c<kr> zxe;
    boolean zxf = false;

    public o(Context context) {
        super(context);
        AppMethodBeat.i(34719);
        initialize();
        AppMethodBeat.o(34719);
    }

    public final int getLayoutId() {
        return R.layout.ail;
    }

    private void initialize() {
        AppMethodBeat.i(34720);
        if (!(this.zwX || this.view == null)) {
            this.jAp = this.view.findViewById(R.id.dgy);
            this.gnB = (TextView) this.view.findViewById(R.id.dgz);
            this.gnC = (TextView) this.view.findViewById(R.id.dh0);
            this.gDQ = (TextView) this.view.findViewById(R.id.dh1);
            this.zwQ = (TextView) this.view.findViewById(R.id.bvf);
            this.zwV = (ProgressBar) this.view.findViewById(R.id.dh2);
            this.iqT = (ImageView) this.view.findViewById(R.id.bve);
            this.zwS = (ImageView) this.view.findViewById(R.id.au3);
            this.zwT = (ImageView) this.view.findViewById(R.id.dh5);
            this.zwU = (ImageView) this.view.findViewById(R.id.dh4);
            this.zwR = (TextView) this.view.findViewById(R.id.dh3);
            this.zwS.setVisibility(8);
            this.zwX = true;
        }
        AppMethodBeat.o(34720);
    }

    /* Access modifiers changed, original: final */
    public final void dJb() {
        AppMethodBeat.i(34721);
        if (this.zxd != null) {
            this.zxd.stopTimer();
            this.zxd = null;
        }
        AppMethodBeat.o(34721);
    }

    public final boolean aMN() {
        boolean z;
        boolean z2 = true;
        int i = 0;
        AppMethodBeat.i(34722);
        int acS = aw.Rg().acS();
        String networkServerIp = aw.Rg().getNetworkServerIp();
        this.zwW = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(d.vxo), d.eSg, r.Yz(), networkServerIp, aa.dor()});
        initialize();
        ab.i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(acS));
        switch (acS) {
            case 0:
                this.gnB.setText(R.string.d5l);
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(34712);
                        Intent intent = new Intent();
                        intent.putExtra("title", ((Context) o.this.vlu.get()).getString(R.string.d5l));
                        intent.putExtra("rawUrl", ((Context) o.this.vlu.get()).getString(R.string.d5i));
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bp.d.b((Context) o.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(34712);
                    }
                });
                z = true;
                break;
            case 2:
                if (this.sIN == 1) {
                    this.gnB.setText(((Context) this.vlu.get()).getResources().getString(R.string.d5k, new Object[]{Integer.valueOf(this.zwY)}));
                } else {
                    this.gnB.setText(R.string.d5j);
                }
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        o oVar;
                        AppMethodBeat.i(34713);
                        o.a(o.this, o.this.sIN);
                        o.this.sIN = 1;
                        if (o.this.zxe == null) {
                            oVar = o.this;
                            oVar.zxe = new c<kr>() {
                                {
                                    AppMethodBeat.i(34709);
                                    this.xxI = kr.class.getName().hashCode();
                                    AppMethodBeat.o(34709);
                                }

                                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                    boolean z = true;
                                    AppMethodBeat.i(34710);
                                    kr krVar = (kr) bVar;
                                    ab.v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", Integer.valueOf(krVar.cGB.cGC), Integer.valueOf(krVar.cGB.status));
                                    o oVar;
                                    if (krVar.cGB.cGC == 0) {
                                        o.this.zwY = 33;
                                        oVar = o.this;
                                        if (krVar.cGB.status != 0) {
                                            z = false;
                                        }
                                        oVar.zwZ = z;
                                    } else if (krVar.cGB.cGC == 1) {
                                        o.this.zwY = 66;
                                        oVar = o.this;
                                        if (krVar.cGB.status != 0) {
                                            z = false;
                                        }
                                        oVar.zxa = z;
                                    } else if (krVar.cGB.cGC == 2) {
                                        oVar = o.this;
                                        if (krVar.cGB.status != 0) {
                                            z = false;
                                        }
                                        oVar.zxb = z;
                                    }
                                    if (krVar.cGB.cGD) {
                                        o.this.zwY = 0;
                                        o.this.sIN = 0;
                                        o.this.zxc = krVar.cGB.cGE;
                                        o.this.dJb();
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(34707);
                                                ab.i("MicroMsg.NetWarnView", "curr top activity is: %s", com.tencent.mm.sdk.platformtools.o.cc((Context) o.this.vlu.get()));
                                                if (!com.tencent.mm.sdk.platformtools.o.cc((Context) o.this.vlu.get()).endsWith("NetworkDiagnoseAllInOneUI")) {
                                                    int i;
                                                    if (o.this.zwZ) {
                                                        i = 2;
                                                    } else if (o.this.zxa) {
                                                        i = 4;
                                                    } else if (o.this.zxb) {
                                                        i = 5;
                                                    } else {
                                                        i = 3;
                                                    }
                                                    o.a(o.this, i);
                                                }
                                                AppMethodBeat.o(34707);
                                            }
                                        });
                                    }
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(34708);
                                            o.this.aMN();
                                            AppMethodBeat.o(34708);
                                        }
                                    });
                                    AppMethodBeat.o(34710);
                                    return false;
                                }
                            };
                            a.xxA.b(oVar.zxe);
                        }
                        if (o.this.zxd == null) {
                            oVar = o.this;
                            oVar.zxd = new ap(new ap.a() {
                                public final boolean BI() {
                                    AppMethodBeat.i(34711);
                                    o.this.zwY++;
                                    ab.v("MicroMsg.NetWarnView", "timer fired, percent:%d", Integer.valueOf(o.this.zwY));
                                    if (o.this.zwY > 99) {
                                        AppMethodBeat.o(34711);
                                        return false;
                                    }
                                    if (o.this.sIN == 1) {
                                        o.this.gnB.setText(((Context) o.this.vlu.get()).getResources().getString(R.string.d5k, new Object[]{Integer.valueOf(o.this.zwY)}));
                                    }
                                    AppMethodBeat.o(34711);
                                    return true;
                                }
                            }, true);
                            oVar.zxd.ae(1000, 1000);
                        }
                        AppMethodBeat.o(34713);
                    }
                });
                z = true;
                break;
            case 3:
                this.gnB.setText(R.string.d5h);
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(0);
                this.iqT.setVisibility(0);
                z = true;
                break;
            case 5:
                this.gnB.setText(R.string.d5m);
                this.gnC.setText(((Context) this.vlu.get()).getString(R.string.d5n));
                this.gnC.setVisibility(0);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(34714);
                        if (!ah.M((Context) o.this.vlu.get(), o.this.zwW)) {
                            Intent intent = new Intent();
                            intent.putExtra("title", ((Context) o.this.vlu.get()).getString(R.string.d5o));
                            intent.putExtra("rawUrl", ((Context) o.this.vlu.get()).getString(R.string.d5i));
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bp.d.b((Context) o.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                        AppMethodBeat.o(34714);
                    }
                });
                z = true;
                break;
            default:
                z = false;
                break;
        }
        ((Context) this.vlu.get()).getResources().getColor(R.color.a3_);
        if (z) {
            this.gDQ.setVisibility(8);
            this.gnB.setVisibility(0);
            this.jAp.setBackgroundResource(R.drawable.a3g);
            LayoutParams layoutParams = new LayoutParams(this.iqT.getLayoutParams());
            layoutParams.setMargins(com.tencent.mm.bz.a.fromDPToPix((Context) this.vlu.get(), 28), 0, com.tencent.mm.bz.a.fromDPToPix((Context) this.vlu.get(), 24), 0);
            this.iqT.setLayoutParams(layoutParams);
            if (k(this.iqT.getTag(), R.raw.icons_filled_error)) {
                this.iqT.setTag(Integer.valueOf(R.raw.icons_filled_error));
                this.iqT.setImageDrawable(com.tencent.mm.ui.ah.f((Context) this.vlu.get(), R.raw.icons_filled_error, ((Context) this.vlu.get()).getResources().getColor(R.color.ct)));
            }
            this.zwT.setVisibility(8);
            this.zwU.setVisibility(8);
            this.zwR.setVisibility(8);
        }
        if (!z) {
            this.zwS.setVisibility(8);
            if (ae.ghT) {
                final int backgroundLimitType = at.getBackgroundLimitType((Context) this.vlu.get());
                if (!at.isLimited(backgroundLimitType) || this.zxf) {
                    this.zwS.setVisibility(8);
                    z2 = z;
                } else {
                    this.gnB.setText(((Context) this.vlu.get()).getString(R.string.der));
                    this.gnC.setText(((Context) this.vlu.get()).getString(R.string.deq));
                    this.gnC.setVisibility(0);
                    this.zwQ.setVisibility(8);
                    this.zwV.setVisibility(8);
                    this.iqT.setVisibility(0);
                    this.zwS.setVisibility(0);
                    this.jAp.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34715);
                            try {
                                at.startSettingItent((Context) o.this.vlu.get(), backgroundLimitType);
                                AppMethodBeat.o(34715);
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                AppMethodBeat.o(34715);
                            }
                        }
                    });
                    this.zwS.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34718);
                            MMAppMgr.a((Context) o.this.vlu.get(), backgroundLimitType, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(34716);
                                    try {
                                        o.this.jAp.setVisibility(8);
                                        o.this.zxf = true;
                                        at.startSettingItent((Context) o.this.vlu.get(), backgroundLimitType);
                                        AppMethodBeat.o(34716);
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                        AppMethodBeat.o(34716);
                                    }
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(34717);
                                    o.this.jAp.setVisibility(8);
                                    o.this.zxf = true;
                                    AppMethodBeat.o(34717);
                                }
                            });
                            AppMethodBeat.o(34718);
                        }
                    });
                }
                z = z2;
            }
        }
        if (k(this.zwU.getTag(), R.raw.chat_mute_notify_normal)) {
            this.zwU.setTag(Integer.valueOf(R.raw.chat_mute_notify_normal));
            this.zwU.setImageResource(R.raw.chat_mute_notify_normal);
        }
        if (k(this.zwS.getTag(), R.raw.chat_mute_notify_normal)) {
            this.zwS.setTag(Integer.valueOf(R.raw.chat_mute_notify_normal));
            this.zwS.setImageResource(R.drawable.f8);
        }
        View view = this.jAp;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        AppMethodBeat.o(34722);
        return z;
    }

    private static boolean k(Object obj, int i) {
        AppMethodBeat.i(34723);
        if (obj == null) {
            AppMethodBeat.o(34723);
            return true;
        } else if (((Integer) obj).intValue() != i) {
            AppMethodBeat.o(34723);
            return true;
        } else {
            AppMethodBeat.o(34723);
            return false;
        }
    }

    public final void destroy() {
        AppMethodBeat.i(34724);
        dJb();
        if (this.zxe != null) {
            a.xxA.d(this.zxe);
        }
        AppMethodBeat.o(34724);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(34725);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.o(34725);
    }

    public final int getOrder() {
        return 4;
    }

    static /* synthetic */ void a(o oVar, int i) {
        AppMethodBeat.i(34726);
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i);
        intent.putExtra("diagnose_percent", oVar.zwY);
        intent.putExtra("diagnose_kvInfo", oVar.zxc);
        ab.i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", Integer.valueOf(i), Integer.valueOf(oVar.zwY), oVar.zxc);
        com.tencent.mm.bp.d.b((Context) oVar.vlu.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
        AppMethodBeat.o(34726);
    }
}
