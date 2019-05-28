package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Gallery;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.a.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class FlipView extends LinearLayout implements OnTouchListener, b {
    Context context;
    private int cvn;
    private int cvo;
    private long eRt = 0;
    protected ak handler;
    protected int infoType = -1;
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(38230);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(38230);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38231);
            nr nrVar = (nr) bVar;
            if (!FlipView.this.rix) {
                ab.i("MicroMsg.FlipView", "no need to scan image");
                AppMethodBeat.o(38231);
            } else if (FlipView.this.riy == null || FlipView.this.riz == null) {
                ab.e("MicroMsg.FlipView", "not in recoging");
                AppMethodBeat.o(38231);
            } else if (nrVar == null || !(nrVar instanceof nr)) {
                ab.e("MicroMsg.FlipView", "receive invalid callbak");
                AppMethodBeat.o(38231);
            } else if (nrVar.cJX.filePath.equals(FlipView.this.riz)) {
                ab.i("MicroMsg.FlipView", "recog result: " + nrVar.cJX.result);
                if (!bo.isNullOrNil(nrVar.cJX.result)) {
                    FlipView.this.riC = nrVar.cJX.result;
                    FlipView.this.cvn = nrVar.cJX.cvn;
                    FlipView.this.cvo = nrVar.cJX.cvo;
                    if (!(FlipView.this.riC == null || FlipView.this.riy == null)) {
                        FlipView.this.riD = true;
                    }
                    FlipView.this.f(FlipView.this.riz, FlipView.this.riA, FlipView.this.riB, false);
                }
                FlipView.this.riz = null;
                AppMethodBeat.o(38231);
            } else {
                ab.e("MicroMsg.FlipView", "not same filepath");
                AppMethodBeat.o(38231);
            }
            return false;
        }
    };
    private String riA;
    private String riB;
    private String riC;
    private boolean riD = false;
    private a riE = new a();
    float riF = 0.0f;
    float riG = 0.0f;
    boolean riH = false;
    float riI = 1.0f;
    private c riJ = new c<kv>() {
        {
            AppMethodBeat.i(38232);
            this.xxI = kv.class.getName().hashCode();
            AppMethodBeat.o(38232);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38233);
            kv kvVar = (kv) bVar;
            if (FlipView.this.rix) {
                if (kvVar != null && (kvVar instanceof kv)) {
                    ab.i("MicroMsg.FlipView", "notify Event: %d", Integer.valueOf(kvVar.cGM.cGK));
                    if (kvVar.cGM.activity == ((Activity) FlipView.this.context) && kvVar.cGM.ctB.equals(FlipView.this.riC)) {
                        switch (kvVar.cGM.cGK) {
                            case 3:
                                ((Activity) FlipView.this.context).finish();
                                break;
                        }
                    }
                    ab.e("MicroMsg.FlipView", "not the same");
                } else {
                    ab.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
                }
            } else {
                ab.i("MicroMsg.FlipView", "no need to scan image");
            }
            AppMethodBeat.o(38233);
            return false;
        }
    };
    private double rip = 0.0d;
    private double riq = 0.0d;
    protected u rir;
    protected com.tencent.mm.plugin.sns.ui.s.a ris;
    protected int rit;
    protected int riu;
    private boolean riv = false;
    private long riw = 0;
    private boolean rix = false;
    private d riy;
    private String riz;

    class a implements Runnable {
        float x;
        float y;

        a() {
        }

        public final void run() {
        }
    }

    public abstract boolean crK();

    public abstract Gallery getGallery();

    public abstract int getPosition();

    public abstract long getSnsId();

    private void crJ() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.rit = displayMetrics.widthPixels;
        this.riu = displayMetrics.heightPixels;
    }

    public FlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlipView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.handler = new ak();
        crJ();
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        com.tencent.mm.sdk.b.a.xxA.c(this.riJ);
    }

    public void setNeedScanImage(boolean z) {
        this.rix = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ab.d("MicroMsg.FlipView", "onTouchEvent down");
            this.rip = (double) motionEvent.getX();
            this.riq = (double) motionEvent.getY();
            this.eRt = System.currentTimeMillis();
            if (f.O(motionEvent) == 1) {
                this.riv = false;
            }
        }
        if (f.O(motionEvent) > 1) {
            this.riv = true;
        }
        if (motionEvent.getAction() == 1 && !this.riv) {
            ab.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.eRt));
            long yz = bo.yz();
            ab.d("MicroMsg.FlipView", "deltTime: " + (yz - this.riw));
            if (yz - this.riw < 300) {
                this.handler.removeCallbacks(this.riE);
                this.handler.post(new Runnable() {
                    public final void run() {
                    }
                });
                return super.dispatchTouchEvent(motionEvent);
            }
            this.riw = yz;
            if (System.currentTimeMillis() - this.eRt < 500 && Math.abs(((double) motionEvent.getX()) - this.rip) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.riq) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.riu - 100))) {
                a aVar = this.riE;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.riE, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!f.dzs()) {
        }
        return false;
    }

    public final void Xw(String str) {
    }

    public void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public void bk(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void f(final String str, final String str2, final String str3, boolean z) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        n YT = af.cnF().YT(str2);
        if (YT == null) {
            ab.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (YT.field_type != 21) {
            arrayList.add(this.context.getString(R.string.ens));
            arrayList2.add(Integer.valueOf(1));
            if (com.tencent.mm.bp.d.afj("favorite")) {
                arrayList.add(this.context.getString(R.string.dcq));
                arrayList2.add(Integer.valueOf(2));
            }
            if (YT.field_type == 15 || YT.field_type == 5) {
                arrayList.add(this.context.getString(R.string.dx0));
                arrayList2.add(Integer.valueOf(0));
            } else if (YT.field_type == 1) {
                arrayList.add(this.context.getString(R.string.dwx));
                arrayList2.add(Integer.valueOf(0));
            } else {
                arrayList.add(this.context.getString(R.string.enw));
                arrayList2.add(Integer.valueOf(0));
            }
            dq dqVar = new dq();
            dqVar.cxc.cwT = str2;
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB) {
                arrayList.add(this.context.getString(R.string.s7));
                arrayList2.add(Integer.valueOf(5));
            }
            if (!v.Zl(str2) && YT.field_type == 1) {
                arrayList.add(this.context.getString(R.string.al9));
                arrayList2.add(Integer.valueOf(6));
            }
            if (this.riC != null) {
                if (com.tencent.mm.plugin.scanner.a.BR(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.eny));
                } else if (com.tencent.mm.plugin.scanner.a.ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(R.string.enz));
                } else if (com.tencent.mm.plugin.scanner.a.BQ(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.enx));
                } else {
                    arrayList.add(this.context.getString(R.string.eny));
                }
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!YT.field_userName.equals(r.Yz())) {
            arrayList.add(this.context.getString(R.string.eko));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.riy == null || !this.riD) {
            this.riy = new d(this.context, 1, false);
        } else {
            this.riD = false;
        }
        this.riy.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(38227);
                lVar.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        lVar.e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(38227);
                        return;
                    }
                }
            }
        };
        this.riy.zQf = new com.tencent.mm.ui.widget.a.d.a() {
            public final void onDismiss() {
                AppMethodBeat.i(38228);
                an anVar = new an();
                anVar.ctC.filePath = FlipView.this.riz;
                com.tencent.mm.sdk.b.a.xxA.m(anVar);
                FlipView.this.riy = null;
                FlipView.this.riz = null;
                FlipView.this.riA = "";
                FlipView.this.riB = null;
                FlipView.this.riC = null;
                FlipView.this.cvn = FlipView.this.cvo = 0;
                AppMethodBeat.o(38228);
            }
        };
        this.riy.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(38229);
                n YT = af.cnF().YT(str2);
                if (YT == null) {
                    ab.i("MicroMsg.FlipView", "error beacause info null");
                    AppMethodBeat.o(38229);
                    return;
                }
                n YT2;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (YT.field_type != 15) {
                            com.tencent.mm.pluginsdk.ui.tools.n.j(str, FlipView.this.context);
                            AppMethodBeat.o(38229);
                            return;
                        }
                        FlipView.Zt(str2);
                        AppMethodBeat.o(38229);
                        return;
                    case 1:
                        if (YT.field_type != 15) {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            if (YT != null) {
                                intent.putExtra("Retr_FromMainTimeline", FlipView.this.crK());
                                intent.putExtra("Retr_KSnsId", i.j(YT));
                            }
                            com.tencent.mm.plugin.sns.c.a.gkE.k(intent, FlipView.this.context);
                            AppMethodBeat.o(38229);
                            return;
                        }
                        new StringBuilder().append(com.tencent.mm.plugin.sns.model.an.fZ(af.getAccSnsPath(), str3)).append(i.e((bau) YT.cqu().xfI.wbK.get(0)));
                        FlipView.Zu(str2);
                        AppMethodBeat.o(38229);
                        return;
                    case 2:
                        cl clVar;
                        rb rbVar;
                        if (YT.field_type != 15) {
                            clVar = new cl();
                            String str = str2;
                            String str2 = str3;
                            if (str2 == null || bo.isNullOrNil(str)) {
                                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                                clVar.cvA.cvG = R.string.boh;
                            } else if (af.cnn()) {
                                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                                clVar.cvA.cvG = R.string.boz;
                            } else {
                                YT2 = af.cnF().YT(str);
                                if (YT2 == null) {
                                    ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                    clVar.cvA.cvG = R.string.boi;
                                } else {
                                    com.tencent.mm.plugin.sns.j.a.a(clVar, YT2, str2);
                                }
                            }
                            clVar.cvA.cvH = 13;
                            clVar.cvA.activity = (Activity) FlipView.this.context;
                            com.tencent.mm.sdk.b.a.xxA.m(clVar);
                            if (FlipView.this.crK()) {
                                rbVar = new rb();
                                rbVar.cNg.cFc = i.j(YT);
                                rbVar.cNg.cwT = YT.cqU();
                                com.tencent.mm.sdk.b.a.xxA.m(rbVar);
                            }
                            AppMethodBeat.o(38229);
                            return;
                        } else if (YT == null) {
                            AppMethodBeat.o(38229);
                            return;
                        } else {
                            if (YT.DI(32)) {
                                clVar = new cl();
                                com.tencent.mm.plugin.sns.j.a.a(clVar, YT);
                                clVar.cvA.cvH = 14;
                                clVar.cvA.activity = (Activity) FlipView.this.context;
                                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                            } else {
                                FlipView.r(FlipView.this.crK(), YT.cqU());
                            }
                            if (FlipView.this.crK()) {
                                rbVar = new rb();
                                rbVar.cNg.cFc = i.j(YT);
                                rbVar.cNg.cwT = YT.cqU();
                                com.tencent.mm.sdk.b.a.xxA.m(rbVar);
                            }
                            AppMethodBeat.o(38229);
                            return;
                        }
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_expose_msg_id", FlipView.this.getSnsId());
                        YT2 = af.cnF().kD(FlipView.this.getSnsId());
                        intent2.putExtra("k_username", YT2 == null ? "" : YT2.field_userName);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                        intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        com.tencent.mm.bp.d.b(FlipView.this.context, "webview", ".ui.tools.WebViewUI", intent2);
                        AppMethodBeat.o(38229);
                        return;
                    case 4:
                        ab.i("MicroMsg.FlipView", "request deal QBAR string");
                        cf cfVar = new cf();
                        cfVar.cvm.activity = (Activity) FlipView.this.context;
                        cfVar.cvm.ctB = FlipView.this.riC;
                        cfVar.cvm.cvn = FlipView.this.cvn;
                        cfVar.cvm.cvo = FlipView.this.cvo;
                        bau a = aj.a(YT, str3);
                        if (a != null) {
                            cfVar.cvm.imagePath = a.Url;
                            cfVar.cvm.cvr = a.wEY;
                        }
                        cfVar.cvm.scene = 38;
                        if (FlipView.this.context instanceof Activity) {
                            cfVar.cvm.cvs = ((Activity) FlipView.this.context).getIntent().getBundleExtra("_stat_obj");
                        }
                        if (FlipView.this instanceof SnsInfoFlip) {
                            SnsInfoFlip snsInfoFlip = (SnsInfoFlip) FlipView.this;
                            az fromScene = snsInfoFlip.getFromScene();
                            ab.d("MicroMsg.FlipView", "from Scene: %s", fromScene.tag);
                            if (fromScene.tag.equals(az.xYN.tag) || fromScene.tag.equals(az.xYO.tag) || fromScene.tag.equals(az.xYP.tag)) {
                                cfVar.cvm.cvp = 5;
                                if (bo.isNullOrNil(snsInfoFlip.username)) {
                                    ab.i("MicroMsg.FlipView", "empty username");
                                    snsInfoFlip.username = "";
                                }
                                cfVar.cvm.source = snsInfoFlip.username;
                            } else if (fromScene.tag.equals(az.xYM.tag)) {
                                cfVar.cvm.cvp = 3;
                            } else {
                                ab.i("MicroMsg.FlipView", "other scene_from: %s", fromScene.tag);
                            }
                        }
                        com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                        AppMethodBeat.o(38229);
                        return;
                    case 5:
                        if (YT.cqu().xfI.wbK.size() == 0) {
                            AppMethodBeat.o(38229);
                            return;
                        }
                        Intent intent3 = new Intent();
                        if (YT.field_type == 1) {
                            int position = FlipView.this.getPosition();
                            int size = YT.cqu().xfI.wbK.size();
                            if (size <= 1 || position <= 1 || position > size) {
                                position = 0;
                            } else {
                                position--;
                            }
                            String g = FlipView.g(str, FlipView.this.context);
                            if (g == null) {
                                AppMethodBeat.o(38229);
                                return;
                            } else {
                                intent3.putExtra("sns_send_data_ui_image_path", g);
                                intent3.putExtra("sns_send_data_ui_image_position", position);
                            }
                        }
                        intent3.putExtra("sns_send_data_ui_activity", true);
                        intent3.putExtra("sns_local_id", str2);
                        com.tencent.mm.bp.d.f(FlipView.this.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                        AppMethodBeat.o(38229);
                        return;
                    case 6:
                        FlipView.this.Zs(str);
                        break;
                }
                AppMethodBeat.o(38229);
            }
        };
        this.riy.cpD();
        if (this.rix && true == z) {
            g.RQ();
            if (g.RO().eJo.acS() != 0) {
                this.riz = str;
                this.riA = str2;
                this.riB = str3;
                np npVar = new np();
                npVar.cJU.filePath = str;
                com.tencent.mm.sdk.b.a.xxA.m(npVar);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x00c5=Splitter:B:32:0x00c5, B:24:0x00ad=Splitter:B:24:0x00ad} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb A:{SYNTHETIC, Splitter:B:27:0x00bb} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d3 A:{SYNTHETIC, Splitter:B:35:0x00d3} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df A:{SYNTHETIC, Splitter:B:41:0x00df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String g(String str, Context context) {
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = e.euR + String.format("%s%d.%s", new Object[]{"image", Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(ah.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (com.tencent.mm.vfs.e.y(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            OutputStream L;
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    L = com.tencent.mm.vfs.e.L(str2, false);
                    try {
                        decodeAsBitmap.compress(CompressFormat.JPEG, 80, L);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                            if (L != null) {
                                try {
                                    L.close();
                                } catch (Exception e3) {
                                }
                            }
                            com.tencent.mm.vfs.e.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.asY(str2)));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (L != null) {
                            }
                            com.tencent.mm.vfs.e.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                        if (L != null) {
                            try {
                                L.close();
                            } catch (Exception e5) {
                            }
                        }
                        com.tencent.mm.vfs.e.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.asY(str2)));
                        return str2;
                    }
                }
                L = null;
                i = 0;
                if (L != null) {
                    try {
                        L.close();
                    } catch (Exception e6) {
                    }
                }
                com.tencent.mm.vfs.e.deleteFile(absolutePath);
            } catch (FileNotFoundException e7) {
                e = e7;
                L = null;
                ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (L != null) {
                }
                com.tencent.mm.vfs.e.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.asY(str2)));
                return str2;
            } catch (OutOfMemoryError e8) {
                e = e8;
                L = null;
                ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (L != null) {
                }
                com.tencent.mm.vfs.e.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.asY(str2)));
                return str2;
            } catch (Throwable th3) {
                th = th3;
                L = null;
                if (L != null) {
                    try {
                        L.close();
                    } catch (Exception e9) {
                    }
                }
                com.tencent.mm.vfs.e.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && com.tencent.mm.vfs.e.y(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.asY(str2)));
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        this.riz = null;
        this.riA = "";
        this.riB = null;
        if (this.riC != null) {
            am amVar = new am();
            amVar.ctA.activity = (Activity) this.context;
            amVar.ctA.ctB = this.riC;
            com.tencent.mm.sdk.b.a.xxA.m(amVar);
            this.riC = null;
            this.cvo = 0;
            this.cvn = 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        com.tencent.mm.sdk.b.a.xxA.d(this.riJ);
    }

    public bau getCntMedia() {
        return null;
    }

    public final void Zs(String str) {
        if (com.tencent.mm.vfs.e.ct(str)) {
            Intent intent = new Intent();
            ab.i("MicroMsg.FlipView", "edit image path:%s", str);
            intent.putExtra("raw_photo_path", str);
            intent.putExtra("from_scene", 293);
            intent.putExtra("after_photo_edit", "");
            intent.putExtra("Retr_Compress_Type", 0);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_FromMainTimeline", crK());
            intent.setClass(this.context, MMNewPhotoEditUI.class);
            this.context.startActivity(intent);
        }
    }

    static /* synthetic */ void Zt(String str) {
        sb sbVar = new sb();
        sbVar.cNV.cAd = 3;
        sbVar.cNV.czD = str;
        com.tencent.mm.sdk.b.a.xxA.m(sbVar);
    }

    static /* synthetic */ void Zu(String str) {
        sb sbVar = new sb();
        sbVar.cNV.cAd = 1;
        sbVar.cNV.cNY = 2;
        sbVar.cNV.czD = str;
        com.tencent.mm.sdk.b.a.xxA.m(sbVar);
    }

    static /* synthetic */ void r(boolean z, String str) {
        sb sbVar = new sb();
        sbVar.cNV.cAd = 2;
        sbVar.cNV.cNW = 14;
        sbVar.cNV.cNX = z;
        sbVar.cNV.czD = str;
        com.tencent.mm.sdk.b.a.xxA.m(sbVar);
    }
}
