package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.d;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class IPCallShareCouponCardUI extends MMActivity implements f, a, b {
    private String eeO = null;
    private ProgressDialog ehJ = null;
    private int mFrom = 0;
    private String mTitle = null;
    private ProgressDialog nBv = null;
    private TextView nED;
    private TextView nEE;
    private TextView nEF;
    private TextView nEG;
    private Button nEH;
    private ImageView nEI;
    private com.tencent.mm.ui.i.a nEJ = new com.tencent.mm.ui.i.a();
    private ProgressDialog nEK = null;
    private i nEL = null;
    private ImageView nEM = null;
    private ProgressBar nEN = null;
    private e nEO = new e();
    private String nEP = null;
    private String nEQ = null;
    private String nER = null;
    private String nES = null;
    private String nET = null;
    private String nEU = null;
    private String nEV = null;
    private String nEW = null;
    private String nEX = null;
    private csc nEY = null;
    private String nEZ = null;
    private View nFa;
    private View qQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallShareCouponCardUI() {
        AppMethodBeat.i(22297);
        AppMethodBeat.o(22297);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22298);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cjq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22283);
                IPCallShareCouponCardUI.this.finish();
                AppMethodBeat.o(22283);
                return true;
            }
        });
        this.qQ = findViewById(R.id.bz0);
        this.nED = (TextView) findViewById(R.id.cjm);
        this.nEE = (TextView) findViewById(R.id.cjn);
        this.nEF = (TextView) findViewById(R.id.cjp);
        this.nEG = (TextView) findViewById(R.id.cjq);
        this.nEH = (Button) findViewById(R.id.cjr);
        this.nEI = (ImageView) findViewById(R.id.ms);
        this.qQ.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.nEI, r.Yz(), 0.5f, false);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.nBv = h.b(context, getString(R.string.ch0), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22291);
                try {
                    IPCallShareCouponCardUI.this.finish();
                    AppMethodBeat.o(22291);
                } catch (Exception e) {
                    ab.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", e.getMessage());
                    AppMethodBeat.o(22291);
                }
            }
        });
        com.tencent.mm.plugin.ipcall.a.f.b.bHU().it(false);
        this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        aw.Rg().a((int) d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        aw.Rg().a(1804, (f) this);
        AppMethodBeat.o(22298);
    }

    public void onResume() {
        AppMethodBeat.i(22299);
        super.onResume();
        AppMethodBeat.o(22299);
    }

    public void onDestroy() {
        AppMethodBeat.i(22300);
        super.onDestroy();
        aw.Rg().b((int) d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        aw.Rg().b(1804, (f) this);
        AppMethodBeat.o(22300);
    }

    public final int getLayoutId() {
        return R.layout.a8l;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22301);
        if (mVar instanceof g) {
            if (i == 0 && i2 == 0) {
                this.qQ.setVisibility(0);
                aqq bIU = c.bIU();
                if (bIU != null) {
                    this.nEP = bIU.wut;
                    this.eeO = bIU.Desc;
                    this.nEQ = bIU.wuu;
                    this.mTitle = bIU.Title;
                    this.nER = bIU.nzz;
                    this.nES = bIU.wuv;
                    this.nEU = bIU.wuw;
                    this.nEV = bIU.wux;
                    this.nEW = bIU.wuy;
                    this.nEX = bIU.wuA;
                    this.nEY = bIU.wuz;
                    this.nEZ = bIU.wuB;
                }
                this.nED.setText(this.nEX);
                this.nEE.setText(String.format(this.mController.ylL.getString(R.string.cjj), new Object[]{this.nEP}));
                this.nEH.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(22293);
                        IPCallShareCouponCardUI.a(IPCallShareCouponCardUI.this);
                        AppMethodBeat.o(22293);
                    }
                });
                this.nEF.setText(String.format(getString(R.string.cjl), new Object[]{this.nEX}));
                TextView textView = this.nEG;
                String format = String.format(getString(R.string.cjk), new Object[]{this.nEX});
                final String string = getString(R.string.cjp);
                if (bo.isNullOrNil(string)) {
                    textView.setText(format);
                } else {
                    String concat;
                    String string2 = getString(R.string.cjs);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int gd = com.tencent.mm.bz.a.gd(this.mController.ylL) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) gd)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) gd)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        concat = IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(string2));
                    } else {
                        concat = string2;
                    }
                    textView.setGravity(17);
                    Spannable newSpannable = Factory.getInstance().newSpannable(format + concat);
                    newSpannable.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(22287);
                            ((TextView) view).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(R.color.a3p));
                            com.tencent.mm.plugin.report.service.h.pYm.e(13340, Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1));
                            h.b(IPCallShareCouponCardUI.this.mController.ylL, string, IPCallShareCouponCardUI.this.getString(R.string.cjt), true).a((int) R.string.cgc, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(22287);
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.i(22288);
                            textPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(R.color.t7));
                            textPaint.setUnderlineText(false);
                            AppMethodBeat.o(22288);
                        }
                    }, format.length(), concat.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                AppMethodBeat.o(22301);
                return;
            } else if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
                h.a(this.mController.ylL, getString(R.string.cgy), getString(R.string.cgr), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22292);
                        IPCallShareCouponCardUI.this.finish();
                        AppMethodBeat.o(22292);
                    }
                });
                AppMethodBeat.o(22301);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.modelmulti.g) {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (com.tencent.mm.plugin.subapp.b.gkF.b(this.mController.ylL, i, i2, str)) {
                AppMethodBeat.o(22301);
                return;
            } else if (i == 0 && i2 == 0) {
                h.bQ(this, getResources().getString(R.string.ate));
                AppMethodBeat.o(22301);
                return;
            } else {
                h.g(this.mController.ylL, R.string.e3n, R.string.tz);
                AppMethodBeat.o(22301);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.bb.a) {
            if (i != 0 || i2 != 0) {
                AppMethodBeat.o(22301);
                return;
            } else if (this.nEM != null) {
                if (this.nEN != null) {
                    this.nEN.setVisibility(8);
                }
                this.nEM.setImageBitmap(bIu());
            }
        }
        AppMethodBeat.o(22301);
    }

    public static void a(Context context, int i, TextView textView, ImageView imageView) {
        AppMethodBeat.i(22302);
        String Q = Q(context, i);
        if (Q != null) {
            textView.setText(Q);
        }
        int xu = xu(i);
        if (xu != -1) {
            imageView.setImageResource(xu);
        }
        AppMethodBeat.o(22302);
    }

    public static String Q(Context context, int i) {
        AppMethodBeat.i(22303);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(R.string.chr));
        hashMap.put(Integer.valueOf(0), context.getString(R.string.g0j));
        hashMap.put(Integer.valueOf(1), context.getString(R.string.chw));
        hashMap.put(Integer.valueOf(3), context.getString(R.string.chs));
        hashMap.put(Integer.valueOf(2), context.getString(R.string.chv));
        hashMap.put(Integer.valueOf(5), context.getString(R.string.chx));
        hashMap.put(Integer.valueOf(4), context.getString(R.string.chy));
        hashMap.put(Integer.valueOf(6), context.getString(R.string.chu));
        hashMap.put(Integer.valueOf(7), context.getString(R.string.cht));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            String str = (String) hashMap.get(Integer.valueOf(i));
            AppMethodBeat.o(22303);
            return str;
        }
        AppMethodBeat.o(22303);
        return null;
    }

    public static int xu(int i) {
        AppMethodBeat.i(22304);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(R.raw.bottomsheet_copy));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(R.raw.bottomsheet_repost));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(R.raw.bottomsheet_moment));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(R.raw.bottomsheet_email));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(R.raw.bottomsheet_sms));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(R.raw.bottomsheet_twitter));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(R.raw.bottomsheet_whatsapp));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(R.raw.bottomsheet_facebook));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(R.raw.bottomsheet_messenger));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
            AppMethodBeat.o(22304);
            return intValue;
        }
        AppMethodBeat.o(22304);
        return -1;
    }

    private static boolean aD(Context context, String str) {
        AppMethodBeat.i(22305);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22305);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            AppMethodBeat.o(22305);
            return true;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(22305);
            return false;
        }
    }

    public final void a(com.tencent.mm.ui.i.a.c cVar) {
        AppMethodBeat.i(22306);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (cVar) {
            case Finished:
                xv(R.string.ey2);
                AppMethodBeat.o(22306);
                return;
            case Canceled:
                AppMethodBeat.o(22306);
                return;
            case Failed:
                xv(R.string.ey1);
                break;
        }
        AppMethodBeat.o(22306);
    }

    public final void b(com.tencent.mm.ui.i.a.c cVar) {
    }

    private static Bitmap bIu() {
        AppMethodBeat.i(22308);
        byte[] Pj = Pj(r.Yz());
        if (Pj == null) {
            AppMethodBeat.o(22308);
            return null;
        }
        Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(Pj);
        AppMethodBeat.o(22308);
        return bQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063 A:{SYNTHETIC, Splitter:B:15:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A:{SYNTHETIC, Splitter:B:21:0x006e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] Pj(String str) {
        Throwable e;
        AppMethodBeat.i(22309);
        aw.ZK();
        String XW = com.tencent.mm.model.c.XW();
        aw.ZK();
        XW = j.g(XW, com.tencent.mm.model.c.XX(), "qr_", com.tencent.mm.a.g.x(str.getBytes()), ".png");
        if (bo.isNullOrNil(XW)) {
            ab.e("MicroMsg.IPCallShareCouponCardUI", "filename is null");
            AppMethodBeat.o(22309);
            return null;
        }
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(XW, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(22309);
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(22309);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(22309);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            ab.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(22309);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.o(22309);
            throw e;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22311);
        if (i == 1 && intent != null) {
            final String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bo.isNullOrNil(stringExtra)) {
                com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, this.mTitle, this.nEQ, this.eeO, true, getResources().getString(R.string.tf), new q.a() {
                    public final void a(boolean z, String str, int i) {
                        AppMethodBeat.i(22289);
                        if (z) {
                            com.tencent.mm.af.j.b bVar = new com.tencent.mm.af.j.b();
                            bVar.title = IPCallShareCouponCardUI.this.mTitle;
                            bVar.url = IPCallShareCouponCardUI.this.nES;
                            bVar.description = IPCallShareCouponCardUI.this.eeO;
                            bVar.thumburl = IPCallShareCouponCardUI.this.nEQ;
                            bVar.type = 5;
                            l.a(bVar, null, null, stringExtra, "", null, null);
                            if (!bo.isNullOrNil(str)) {
                                qb qbVar = new qb();
                                qbVar.cMq.cMr = stringExtra;
                                qbVar.cMq.content = str;
                                qbVar.cMq.type = t.nK(stringExtra);
                                qbVar.cMq.flags = 0;
                                com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                            }
                            h.bQ(IPCallShareCouponCardUI.this.mController.ylL, IPCallShareCouponCardUI.this.getResources().getString(R.string.to));
                            AppMethodBeat.o(22289);
                            return;
                        }
                        AppMethodBeat.o(22289);
                    }
                });
            }
        }
        AppMethodBeat.o(22311);
    }

    private void xv(int i) {
        AppMethodBeat.i(22307);
        h.a(this.mController.ylL, i, (int) R.string.tz, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(22307);
    }

    private void w(final int i, final String str, String str2) {
        AppMethodBeat.i(22310);
        this.nFa = View.inflate(this.mController.ylL, R.layout.pn, null);
        final EditText editText = (EditText) this.nFa.findViewById(R.id.b09);
        this.nEM = (ImageView) this.nFa.findViewById(R.id.b08);
        this.nEN = (ProgressBar) this.nFa.findViewById(R.id.a1n);
        editText.setText(str);
        Bitmap bIu = bIu();
        if (bIu == null) {
            String Yz = r.Yz();
            aw.ZK();
            aw.Rg().a(new com.tencent.mm.bb.a(Yz, bo.h((Integer) com.tencent.mm.model.c.Ry().get(66561, null))), 0);
            this.nEN.setVisibility(0);
        } else if (this.nEM != null) {
            this.nEM.setImageBitmap(bIu);
        }
        com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, str2, this.nFa, getResources().getString(R.string.tf), new q.b() {
            public final void iw(boolean z) {
                AppMethodBeat.i(22286);
                if (z) {
                    String str;
                    if (editText == null) {
                        str = str;
                    } else {
                        str = editText.getText().toString();
                    }
                    final m gVar = new com.tencent.mm.modelmulti.g(i, str);
                    IPCallShareCouponCardUI iPCallShareCouponCardUI = IPCallShareCouponCardUI.this;
                    Context context = IPCallShareCouponCardUI.this;
                    IPCallShareCouponCardUI.this.getString(R.string.tz);
                    iPCallShareCouponCardUI.ehJ = h.b(context, IPCallShareCouponCardUI.this.getString(R.string.th), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(22285);
                            aw.Rg().c(gVar);
                            AppMethodBeat.o(22285);
                        }
                    });
                    aw.Rg().a(gVar, 0);
                    AppMethodBeat.o(22286);
                    return;
                }
                AppMethodBeat.o(22286);
            }
        });
        AppMethodBeat.o(22310);
    }
}
