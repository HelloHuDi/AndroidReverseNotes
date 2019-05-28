package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.view.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI extends MMActivity implements f {
    private String eeO = null;
    private String mTitle = null;
    private c nBm = new c<ir>() {
        {
            AppMethodBeat.i(22316);
            this.xxI = ir.class.getName().hashCode();
            AppMethodBeat.o(22316);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(22317);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22315);
                    aw.ZK();
                    if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                        IPCallShareCouponUI.this.nFm.setVisibility(0);
                    } else {
                        IPCallShareCouponUI.this.nFm.setVisibility(8);
                    }
                    aw.ZK();
                    IPCallShareCouponUI.this.nFl.setText((String) com.tencent.mm.model.c.Ry().get(a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
                    aw.ZK();
                    IPCallShareCouponUI.this.nFo.setText((String) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
                    AppMethodBeat.o(22315);
                }
            });
            AppMethodBeat.o(22317);
            return true;
        }
    };
    private ProgressDialog nBv;
    private String nEP = null;
    private String nEQ = null;
    private String nER = null;
    private String nES = null;
    private String nET = null;
    private String nEU = null;
    private String nEV = null;
    private String nEW = null;
    private ImageView nFA;
    private TextView nFB;
    private TextView nFC;
    private View nFD;
    private IPCallDynamicTextView nFE;
    private com.tencent.mm.plugin.ipcall.a.e.b nFF = new com.tencent.mm.plugin.ipcall.a.e.b();
    private LinkedList<crw> nFG = null;
    private boolean nFH = false;
    private RelativeLayout nFk;
    private TextView nFl;
    private ImageView nFm;
    private RelativeLayout nFn;
    private TextView nFo;
    private ImageView nFp;
    private LinearLayout nFq;
    private LinearLayout nFr;
    private LinearLayout nFs;
    private LinearLayout nFt;
    private ImageView nFu;
    private LinearLayout nFv;
    private ImageView nFw;
    private TextView nFx;
    private TextView nFy;
    private TextView nFz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallShareCouponUI() {
        AppMethodBeat.i(22334);
        AppMethodBeat.o(22334);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(22335);
        super.onCreate(bundle);
        aw.Rg().a((int) d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.nBm);
        setMMTitle((int) R.string.cid);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22326);
                IPCallShareCouponUI.this.finish();
                AppMethodBeat.o(22326);
                return true;
            }
        });
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                String[] strArr;
                AppMethodBeat.i(22324);
                aqq bIU = com.tencent.mm.plugin.ipcall.b.c.bIU();
                if (!(bIU == null || bo.isNullOrNil(bIU.wuD))) {
                    if ((g.Nu().getInt("WCOWebPayListSwitch", 0) > 0 ? 1 : 0) != 0) {
                        i = 1;
                        if (i == 0) {
                            strArr = new String[]{IPCallShareCouponUI.this.getString(R.string.cic), IPCallShareCouponUI.this.getString(R.string.cgt), IPCallShareCouponUI.this.getString(R.string.cg9)};
                            IPCallShareCouponUI.this.nFH = true;
                        } else {
                            strArr = new String[]{IPCallShareCouponUI.this.getString(R.string.cgt), IPCallShareCouponUI.this.getString(R.string.cg9)};
                            IPCallShareCouponUI.this.nFH = false;
                        }
                        h.a(IPCallShareCouponUI.this.mController.ylL, null, strArr, null, false, new h.c() {
                            public final void iE(int i) {
                                AppMethodBeat.i(22323);
                                if (!IPCallShareCouponUI.this.nFH) {
                                    i++;
                                }
                                switch (i) {
                                    case 0:
                                        IPCallShareCouponUI.i(IPCallShareCouponUI.this);
                                        AppMethodBeat.o(22323);
                                        return;
                                    case 1:
                                        IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                                        AppMethodBeat.o(22323);
                                        return;
                                    case 2:
                                        IPCallShareCouponUI.e(IPCallShareCouponUI.this);
                                        break;
                                }
                                AppMethodBeat.o(22323);
                            }
                        });
                        AppMethodBeat.o(22324);
                        return true;
                    }
                }
                i = 0;
                if (i == 0) {
                }
                h.a(IPCallShareCouponUI.this.mController.ylL, null, strArr, null, false, /* anonymous class already generated */);
                AppMethodBeat.o(22324);
                return true;
            }
        });
        this.nFE = (IPCallDynamicTextView) findViewById(R.id.cjs);
        this.nFk = (RelativeLayout) findViewById(R.id.cjx);
        this.nFl = (TextView) findViewById(R.id.cjy);
        this.nFm = (ImageView) findViewById(R.id.cjz);
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFm.setVisibility(0);
        }
        aw.ZK();
        this.nFl.setText((String) com.tencent.mm.model.c.Ry().get(a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
        this.nFn = (RelativeLayout) findViewById(R.id.ck0);
        this.nFo = (TextView) findViewById(R.id.ck1);
        this.nFp = (ImageView) findViewById(R.id.ck2);
        aw.ZK();
        this.nFo.setText((String) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
        this.nFB = (TextView) findViewById(R.id.cjt);
        this.nFC = (TextView) findViewById(R.id.cjv);
        this.nFD = findViewById(R.id.cju);
        this.nFq = (LinearLayout) findViewById(R.id.cka);
        this.nFA = (ImageView) findViewById(R.id.ckb);
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFA.setVisibility(0);
        }
        this.nFx = (TextView) findViewById(R.id.ckf);
        this.nFy = (TextView) findViewById(R.id.ckg);
        this.nFz = (TextView) findViewById(R.id.cke);
        this.nFr = (LinearLayout) findViewById(R.id.ck4);
        this.nFs = (LinearLayout) findViewById(R.id.ck6);
        this.nFv = (LinearLayout) findViewById(R.id.ckc);
        this.nFw = (ImageView) findViewById(R.id.ckd);
        this.nFt = (LinearLayout) findViewById(R.id.ck9);
        this.nFu = (ImageView) findViewById(R.id.ck_);
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFu.setVisibility(0);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.bIT()) {
            z = true;
        } else {
            if (g.Nu().getInt("WCOPurchaseSwitch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.nFk.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.bIT() || g.Nu().getInt("WCOPackagePurchaseSwitch", 0) == 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.nFn.setVisibility(0);
        }
        if (g.Nu().getInt("WCOAccountDetailSwitch", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.nFq.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.bIT()) {
            z = true;
        } else {
            if (g.Nu().getInt("WCOInviteFriend", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.nFr.setVisibility(8);
        }
        this.nFx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22327);
                IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                AppMethodBeat.o(22327);
            }
        });
        this.nFy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22328);
                IPCallShareCouponUI.e(IPCallShareCouponUI.this);
                AppMethodBeat.o(22328);
            }
        });
        this.nFq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22329);
                IPCallShareCouponUI.f(IPCallShareCouponUI.this);
                AppMethodBeat.o(22329);
            }
        });
        this.nFr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22330);
                com.tencent.mm.plugin.report.service.h.pYm.e(13340, Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallShareCouponCardUI.class);
                IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(22330);
            }
        });
        this.nFt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22331);
                aw.ZK();
                if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    aw.ZK();
                    i.Z(4, -1, ((Integer) com.tencent.mm.model.c.Ry().get(a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue());
                }
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                IPCallShareCouponUI.this.nFu.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallMsgUI.class);
                IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(22331);
            }
        });
        this.nFs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22332);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallMyGiftCardUI.class);
                IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(22332);
            }
        });
        this.nFk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22333);
                aw.ZK();
                if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    i.Z(3, -1, -1);
                }
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                IPCallShareCouponUI.this.nFm.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallRechargeUI.class);
                IPCallShareCouponUI.this.startActivity(intent);
                AppMethodBeat.o(22333);
            }
        });
        this.nFn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22318);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallPackageUI.class);
                IPCallShareCouponUI.this.startActivity(intent);
                AppMethodBeat.o(22318);
            }
        });
        this.nFv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22319);
                Intent intent = new Intent();
                String str = IPCallShareCouponUI.this.getString(R.string.chm) + "&usedcc=";
                List bHf = com.tencent.mm.plugin.ipcall.a.c.bHc().bHf();
                if (bHf == null || bHf.size() <= 0) {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.Pr(com.tencent.mm.plugin.ipcall.b.c.bIR());
                } else {
                    int size = bHf.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(((Integer) bHf.get(i)).toString());
                        if (bo.isNullOrNil(Pr)) {
                            Pr = str;
                        } else {
                            Pr = str + Pr + "|";
                        }
                        i++;
                        str = Pr;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(22319);
            }
        });
        aqq bIU = com.tencent.mm.plugin.ipcall.b.c.bIU();
        if (bIU != null) {
            a(bIU);
            refreshView();
        } else {
            this.nFE.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.nBv = h.b(context, getString(R.string.ch0), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(22320);
                    try {
                        IPCallShareCouponUI.this.finish();
                        AppMethodBeat.o(22320);
                    } catch (Exception e) {
                        ab.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", e.getMessage());
                        AppMethodBeat.o(22320);
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.ipcall.b.c.bIT()) {
            String string = getString(R.string.cjw);
            String str = string + getString(R.string.cjv);
            AnonymousClass5 anonymousClass5 = new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(22321);
                    ((TextView) view).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(R.color.a3p));
                    String str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
                    String gw = aa.gw(ah.getContext());
                    if (!bo.isNullOrNil(gw)) {
                        str = str + "&wechat_real_lang=" + gw;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(22321);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(22322);
                    textPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(false);
                    AppMethodBeat.o(22322);
                }
            };
            Spannable newSpannable = Factory.getInstance().newSpannable(str);
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(anonymousClass5, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(anonymousClass5, length, length2, 33);
            }
            this.nFz.setText(newSpannable);
            this.nFz.setMovementMethod(LinkMovementMethod.getInstance());
            this.nFz.setVisibility(0);
        } else {
            this.nFz.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cjw);
        if (linearLayout != null && this.nFk.getVisibility() == 8 && this.nFn.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) findViewById(R.id.ck3);
        if (linearLayout != null && this.nFr.getVisibility() == 8 && this.nFs.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        this.nFF.start();
        AppMethodBeat.o(22335);
    }

    public void onResume() {
        AppMethodBeat.i(22336);
        super.onResume();
        com.tencent.mm.plugin.ipcall.a.f.b.bHU().it(false);
        AppMethodBeat.o(22336);
    }

    public void onDestroy() {
        AppMethodBeat.i(22337);
        super.onDestroy();
        aw.Rg().b((int) d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.nBm);
        this.nFF.nyL = bo.anU();
        this.nFF.finish();
        AppMethodBeat.o(22337);
    }

    public final int getLayoutId() {
        return R.layout.a8m;
    }

    private void refreshView() {
        AppMethodBeat.i(22338);
        if (!bo.isNullOrNil(this.nEU)) {
            if (this.nET == null) {
                this.nFE.setValue(this.nEU, this.nEU);
            } else {
                this.nFE.setValue(this.nET, this.nEU);
            }
            this.nET = this.nEU;
        }
        this.nFB.getText();
        this.nFB.setText(this.nEV);
        if (bo.isNullOrNil(this.nEV)) {
            this.nFB.setVisibility(8);
        } else {
            this.nFB.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.nFG != null && this.nFG.size() > 0) {
            Iterator it = this.nFG.iterator();
            while (it.hasNext()) {
                crw crw = (crw) it.next();
                if (!(crw == null || bo.isNullOrNil(crw.xpw))) {
                    stringBuffer.append(crw.xpw).append(10);
                }
            }
        }
        if (bo.isNullOrNil(stringBuffer.toString())) {
            this.nFC.setText("");
            this.nFC.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == 10) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.nFC.setText(stringBuffer.toString());
            this.nFC.setVisibility(0);
        }
        if (this.nFB.getVisibility() == 0 && this.nFC.getVisibility() == 0) {
            this.nFD.setVisibility(0);
            AppMethodBeat.o(22338);
            return;
        }
        this.nFD.setVisibility(8);
        AppMethodBeat.o(22338);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22339);
        if (mVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) {
            if (i == 0 && i2 == 0) {
                a(((com.tencent.mm.plugin.ipcall.a.d.g) mVar).nyt);
                refreshView();
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                AppMethodBeat.o(22339);
                return;
            } else if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
                h.a(this.mController.ylL, getString(R.string.cgy), getString(R.string.cgr), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22325);
                        IPCallShareCouponUI.this.finish();
                        AppMethodBeat.o(22325);
                    }
                });
            }
        }
        AppMethodBeat.o(22339);
    }

    private void a(aqq aqq) {
        this.nEP = aqq.wut;
        this.eeO = aqq.Desc;
        this.nEQ = aqq.wuu;
        this.mTitle = aqq.Title;
        this.nER = aqq.nzz;
        this.nES = aqq.wuv;
        this.nEU = aqq.wuw;
        this.nEV = aqq.wux;
        this.nEW = aqq.wuy;
        this.nFG = aqq.wuh;
    }

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(22340);
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nFF;
        bVar.nyN++;
        com.tencent.mm.plugin.report.service.h.pYm.a(257, 2, 1, true);
        String string = ah.getContext().getString(R.string.ch4);
        try {
            com.tencent.mm.kernel.g.RN();
            int QF = com.tencent.mm.kernel.a.QF();
            String encode = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bo.dpA(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(q.LK(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.vxi, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.vxj, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(com.tencent.mm.protocal.d.vxk, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(aw.Rb(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + com.tencent.mm.protocal.d.vxo + "&lang=" + aa.gw(ah.getContext()) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bo.gS(ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", e.getMessage());
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(22340);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(22341);
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nFF;
        bVar.nyO++;
        com.tencent.mm.plugin.report.service.h.pYm.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.string.cg_));
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(22341);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(22342);
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nFF;
        bVar.nyM++;
        com.tencent.mm.plugin.report.service.h.pYm.a(257, 1, 1, true);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
        iPCallShareCouponUI.nFA.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.string.cgp));
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(22342);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(22343);
        aqq bIU = com.tencent.mm.plugin.ipcall.b.c.bIU();
        if (!(bIU == null || bo.isNullOrNil(bIU.wuD))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", bIU.wuD);
            intent.putExtra("showShare", false);
            com.tencent.mm.bp.d.b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(22343);
    }
}
