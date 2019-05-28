package com.tencent.p177mm.p612ui.conversation.p626a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6510kr;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.ui.conversation.a.o */
public final class C46679o extends C14933b {
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
    C7564ap zxd;
    C4884c<C6510kr> zxe;
    boolean zxf = false;

    /* renamed from: com.tencent.mm.ui.conversation.a.o$1 */
    class C306891 extends C4884c<C6510kr> {

        /* renamed from: com.tencent.mm.ui.conversation.a.o$1$2 */
        class C306902 implements Runnable {
            C306902() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34708);
                C46679o.this.aMN();
                AppMethodBeat.m2505o(34708);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.a.o$1$1 */
        class C306911 implements Runnable {
            C306911() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34707);
                C4990ab.m7417i("MicroMsg.NetWarnView", "curr top activity is: %s", C40618o.m70060cc((Context) C46679o.this.vlu.get()));
                if (!C40618o.m70060cc((Context) C46679o.this.vlu.get()).endsWith("NetworkDiagnoseAllInOneUI")) {
                    int i;
                    if (C46679o.this.zwZ) {
                        i = 2;
                    } else if (C46679o.this.zxa) {
                        i = 4;
                    } else if (C46679o.this.zxb) {
                        i = 5;
                    } else {
                        i = 3;
                    }
                    C46679o.m88405a(C46679o.this, i);
                }
                AppMethodBeat.m2505o(34707);
            }
        }

        C306891() {
            AppMethodBeat.m2504i(34709);
            this.xxI = C6510kr.class.getName().hashCode();
            AppMethodBeat.m2505o(34709);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(34710);
            C6510kr c6510kr = (C6510kr) c4883b;
            C4990ab.m7419v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", Integer.valueOf(c6510kr.cGB.cGC), Integer.valueOf(c6510kr.cGB.status));
            C46679o c46679o;
            if (c6510kr.cGB.cGC == 0) {
                C46679o.this.zwY = 33;
                c46679o = C46679o.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                c46679o.zwZ = z;
            } else if (c6510kr.cGB.cGC == 1) {
                C46679o.this.zwY = 66;
                c46679o = C46679o.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                c46679o.zxa = z;
            } else if (c6510kr.cGB.cGC == 2) {
                c46679o = C46679o.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                c46679o.zxb = z;
            }
            if (c6510kr.cGB.cGD) {
                C46679o.this.zwY = 0;
                C46679o.this.sIN = 0;
                C46679o.this.zxc = c6510kr.cGB.cGE;
                C46679o.this.dJb();
                C5004al.m7441d(new C306911());
            }
            C5004al.m7441d(new C306902());
            AppMethodBeat.m2505o(34710);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.o$4 */
    class C362644 implements OnClickListener {
        C362644() {
        }

        public final void onClick(View view) {
            C46679o c46679o;
            AppMethodBeat.m2504i(34713);
            C46679o.m88405a(C46679o.this, C46679o.this.sIN);
            C46679o.this.sIN = 1;
            if (C46679o.this.zxe == null) {
                c46679o = C46679o.this;
                c46679o.zxe = new C306891();
                C4879a.xxA.mo10051b(c46679o.zxe);
            }
            if (C46679o.this.zxd == null) {
                c46679o = C46679o.this;
                c46679o.zxd = new C7564ap(new C408512(), true);
                c46679o.zxd.mo16770ae(1000, 1000);
            }
            AppMethodBeat.m2505o(34713);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.o$2 */
    class C408512 implements C5015a {
        C408512() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(34711);
            C46679o.this.zwY++;
            C4990ab.m7419v("MicroMsg.NetWarnView", "timer fired, percent:%d", Integer.valueOf(C46679o.this.zwY));
            if (C46679o.this.zwY > 99) {
                AppMethodBeat.m2505o(34711);
                return false;
            }
            if (C46679o.this.sIN == 1) {
                C46679o.this.gnB.setText(((Context) C46679o.this.vlu.get()).getResources().getString(C25738R.string.d5k, new Object[]{Integer.valueOf(C46679o.this.zwY)}));
            }
            AppMethodBeat.m2505o(34711);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.o$3 */
    class C408523 implements OnClickListener {
        C408523() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34712);
            Intent intent = new Intent();
            intent.putExtra("title", ((Context) C46679o.this.vlu.get()).getString(C25738R.string.d5l));
            intent.putExtra("rawUrl", ((Context) C46679o.this.vlu.get()).getString(C25738R.string.d5i));
            intent.putExtra("showShare", false);
            C25985d.m41467b((Context) C46679o.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(34712);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.o$5 */
    class C408535 implements OnClickListener {
        C408535() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34714);
            if (!C42252ah.m74604M((Context) C46679o.this.vlu.get(), C46679o.this.zwW)) {
                Intent intent = new Intent();
                intent.putExtra("title", ((Context) C46679o.this.vlu.get()).getString(C25738R.string.d5o));
                intent.putExtra("rawUrl", ((Context) C46679o.this.vlu.get()).getString(C25738R.string.d5i));
                intent.putExtra("showShare", false);
                C25985d.m41467b((Context) C46679o.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(34714);
        }
    }

    public C46679o(Context context) {
        super(context);
        AppMethodBeat.m2504i(34719);
        initialize();
        AppMethodBeat.m2505o(34719);
    }

    public final int getLayoutId() {
        return 2130970293;
    }

    private void initialize() {
        AppMethodBeat.m2504i(34720);
        if (!(this.zwX || this.view == null)) {
            this.jAp = this.view.findViewById(2131826313);
            this.gnB = (TextView) this.view.findViewById(2131826314);
            this.gnC = (TextView) this.view.findViewById(2131826315);
            this.gDQ = (TextView) this.view.findViewById(2131826316);
            this.zwQ = (TextView) this.view.findViewById(2131824112);
            this.zwV = (ProgressBar) this.view.findViewById(2131826317);
            this.iqT = (ImageView) this.view.findViewById(2131824111);
            this.zwS = (ImageView) this.view.findViewById(2131822694);
            this.zwT = (ImageView) this.view.findViewById(2131826320);
            this.zwU = (ImageView) this.view.findViewById(2131826319);
            this.zwR = (TextView) this.view.findViewById(2131826318);
            this.zwS.setVisibility(8);
            this.zwX = true;
        }
        AppMethodBeat.m2505o(34720);
    }

    /* Access modifiers changed, original: final */
    public final void dJb() {
        AppMethodBeat.m2504i(34721);
        if (this.zxd != null) {
            this.zxd.stopTimer();
            this.zxd = null;
        }
        AppMethodBeat.m2505o(34721);
    }

    public final boolean aMN() {
        boolean z;
        boolean z2 = true;
        int i = 0;
        AppMethodBeat.m2504i(34722);
        int acS = C9638aw.m17182Rg().acS();
        String networkServerIp = C9638aw.m17182Rg().getNetworkServerIp();
        this.zwW = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(C7243d.vxo), C7243d.eSg, C1853r.m3846Yz(), networkServerIp, C4988aa.dor()});
        initialize();
        C4990ab.m7417i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(acS));
        switch (acS) {
            case 0:
                this.gnB.setText(C25738R.string.d5l);
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new C408523());
                z = true;
                break;
            case 2:
                if (this.sIN == 1) {
                    this.gnB.setText(((Context) this.vlu.get()).getResources().getString(C25738R.string.d5k, new Object[]{Integer.valueOf(this.zwY)}));
                } else {
                    this.gnB.setText(C25738R.string.d5j);
                }
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new C362644());
                z = true;
                break;
            case 3:
                this.gnB.setText(C25738R.string.d5h);
                this.gnC.setVisibility(8);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(0);
                this.iqT.setVisibility(0);
                z = true;
                break;
            case 5:
                this.gnB.setText(C25738R.string.d5m);
                this.gnC.setText(((Context) this.vlu.get()).getString(C25738R.string.d5n));
                this.gnC.setVisibility(0);
                this.zwQ.setVisibility(8);
                this.zwV.setVisibility(8);
                this.iqT.setVisibility(0);
                this.jAp.setOnClickListener(new C408535());
                z = true;
                break;
            default:
                z = false;
                break;
        }
        ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_);
        if (z) {
            this.gDQ.setVisibility(8);
            this.gnB.setVisibility(0);
            this.jAp.setBackgroundResource(C25738R.drawable.a3g);
            LayoutParams layoutParams = new LayoutParams(this.iqT.getLayoutParams());
            layoutParams.setMargins(C1338a.fromDPToPix((Context) this.vlu.get(), 28), 0, C1338a.fromDPToPix((Context) this.vlu.get(), 24), 0);
            this.iqT.setLayoutParams(layoutParams);
            if (C46679o.m88406k(this.iqT.getTag(), C1318a.icons_filled_error)) {
                this.iqT.setTag(Integer.valueOf(C1318a.icons_filled_error));
                this.iqT.setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_filled_error, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.f11671ct)));
            }
            this.zwT.setVisibility(8);
            this.zwU.setVisibility(8);
            this.zwR.setVisibility(8);
        }
        if (!z) {
            this.zwS.setVisibility(8);
            if (C1947ae.ghT) {
                final int backgroundLimitType = C5023at.getBackgroundLimitType((Context) this.vlu.get());
                if (!C5023at.isLimited(backgroundLimitType) || this.zxf) {
                    this.zwS.setVisibility(8);
                    z2 = z;
                } else {
                    this.gnB.setText(((Context) this.vlu.get()).getString(C25738R.string.der));
                    this.gnC.setText(((Context) this.vlu.get()).getString(C25738R.string.deq));
                    this.gnC.setVisibility(0);
                    this.zwQ.setVisibility(8);
                    this.zwV.setVisibility(8);
                    this.iqT.setVisibility(0);
                    this.zwS.setVisibility(0);
                    this.jAp.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34715);
                            try {
                                C5023at.startSettingItent((Context) C46679o.this.vlu.get(), backgroundLimitType);
                                AppMethodBeat.m2505o(34715);
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                AppMethodBeat.m2505o(34715);
                            }
                        }
                    });
                    this.zwS.setOnClickListener(new OnClickListener() {

                        /* renamed from: com.tencent.mm.ui.conversation.a.o$7$2 */
                        class C239692 implements DialogInterface.OnClickListener {
                            C239692() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(34717);
                                C46679o.this.jAp.setVisibility(8);
                                C46679o.this.zxf = true;
                                AppMethodBeat.m2505o(34717);
                            }
                        }

                        /* renamed from: com.tencent.mm.ui.conversation.a.o$7$1 */
                        class C239711 implements DialogInterface.OnClickListener {
                            C239711() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(34716);
                                try {
                                    C46679o.this.jAp.setVisibility(8);
                                    C46679o.this.zxf = true;
                                    C5023at.startSettingItent((Context) C46679o.this.vlu.get(), backgroundLimitType);
                                    AppMethodBeat.m2505o(34716);
                                } catch (Exception e) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                    AppMethodBeat.m2505o(34716);
                                }
                            }
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34718);
                            MMAppMgr.m7897a((Context) C46679o.this.vlu.get(), backgroundLimitType, new C239711(), new C239692());
                            AppMethodBeat.m2505o(34718);
                        }
                    });
                }
                z = z2;
            }
        }
        if (C46679o.m88406k(this.zwU.getTag(), C1318a.chat_mute_notify_normal)) {
            this.zwU.setTag(Integer.valueOf(C1318a.chat_mute_notify_normal));
            this.zwU.setImageResource(C1318a.chat_mute_notify_normal);
        }
        if (C46679o.m88406k(this.zwS.getTag(), C1318a.chat_mute_notify_normal)) {
            this.zwS.setTag(Integer.valueOf(C1318a.chat_mute_notify_normal));
            this.zwS.setImageResource(C25738R.drawable.f6471f8);
        }
        View view = this.jAp;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        AppMethodBeat.m2505o(34722);
        return z;
    }

    /* renamed from: k */
    private static boolean m88406k(Object obj, int i) {
        AppMethodBeat.m2504i(34723);
        if (obj == null) {
            AppMethodBeat.m2505o(34723);
            return true;
        } else if (((Integer) obj).intValue() != i) {
            AppMethodBeat.m2505o(34723);
            return true;
        } else {
            AppMethodBeat.m2505o(34723);
            return false;
        }
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34724);
        dJb();
        if (this.zxe != null) {
            C4879a.xxA.mo10053d(this.zxe);
        }
        AppMethodBeat.m2505o(34724);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(34725);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.m2505o(34725);
    }

    public final int getOrder() {
        return 4;
    }

    /* renamed from: a */
    static /* synthetic */ void m88405a(C46679o c46679o, int i) {
        AppMethodBeat.m2504i(34726);
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i);
        intent.putExtra("diagnose_percent", c46679o.zwY);
        intent.putExtra("diagnose_kvInfo", c46679o.zxc);
        C4990ab.m7417i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", Integer.valueOf(i), Integer.valueOf(c46679o.zwY), c46679o.zxc);
        C25985d.m41467b((Context) c46679o.vlu.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
        AppMethodBeat.m2505o(34726);
    }
}
