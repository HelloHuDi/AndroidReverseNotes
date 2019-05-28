package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C32626rb;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9463sb;
import com.tencent.p177mm.p612ui.MMNewPhotoEditUI;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C46631f;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.ui.FlipView */
public abstract class FlipView extends LinearLayout implements OnTouchListener, C43559b {
    Context context;
    private int cvn;
    private int cvo;
    private long eRt = 0;
    protected C7306ak handler;
    protected int infoType = -1;
    private C4884c mip = new C350055();
    private String riA;
    private String riB;
    private String riC;
    private boolean riD = false;
    private C35006a riE = new C35006a();
    float riF = 0.0f;
    float riG = 0.0f;
    boolean riH = false;
    float riI = 1.0f;
    private C4884c riJ = new C397916();
    private double rip = 0.0d;
    private double riq = 0.0d;
    protected C43610u rir;
    protected C29239a ris;
    protected int rit;
    protected int riu;
    private boolean riv = false;
    private long riw = 0;
    private boolean rix = false;
    private C36356d riy;
    private String riz;

    /* renamed from: com.tencent.mm.plugin.sns.ui.FlipView$3 */
    class C291093 implements C15994a {
        C291093() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(38228);
            C37691an c37691an = new C37691an();
            c37691an.ctC.filePath = FlipView.this.riz;
            C4879a.xxA.mo10055m(c37691an);
            FlipView.this.riy = null;
            FlipView.this.riz = null;
            FlipView.this.riA = "";
            FlipView.this.riB = null;
            FlipView.this.riC = null;
            FlipView.this.cvn = FlipView.this.cvo = 0;
            AppMethodBeat.m2505o(38228);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.FlipView$5 */
    class C350055 extends C4884c<C18346nr> {
        C350055() {
            AppMethodBeat.m2504i(38230);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(38230);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38231);
            C18346nr c18346nr = (C18346nr) c4883b;
            if (!FlipView.this.rix) {
                C4990ab.m7416i("MicroMsg.FlipView", "no need to scan image");
                AppMethodBeat.m2505o(38231);
            } else if (FlipView.this.riy == null || FlipView.this.riz == null) {
                C4990ab.m7412e("MicroMsg.FlipView", "not in recoging");
                AppMethodBeat.m2505o(38231);
            } else if (c18346nr == null || !(c18346nr instanceof C18346nr)) {
                C4990ab.m7412e("MicroMsg.FlipView", "receive invalid callbak");
                AppMethodBeat.m2505o(38231);
            } else if (c18346nr.cJX.filePath.equals(FlipView.this.riz)) {
                C4990ab.m7416i("MicroMsg.FlipView", "recog result: " + c18346nr.cJX.result);
                if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                    FlipView.this.riC = c18346nr.cJX.result;
                    FlipView.this.cvn = c18346nr.cJX.cvn;
                    FlipView.this.cvo = c18346nr.cJX.cvo;
                    if (!(FlipView.this.riC == null || FlipView.this.riy == null)) {
                        FlipView.this.riD = true;
                    }
                    FlipView.this.mo76141f(FlipView.this.riz, FlipView.this.riA, FlipView.this.riB, false);
                }
                FlipView.this.riz = null;
                AppMethodBeat.m2505o(38231);
            } else {
                C4990ab.m7412e("MicroMsg.FlipView", "not same filepath");
                AppMethodBeat.m2505o(38231);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.FlipView$a */
    class C35006a implements Runnable {
        /* renamed from: x */
        float f15063x;
        /* renamed from: y */
        float f15064y;

        C35006a() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.FlipView$6 */
    class C397916 extends C4884c<C42019kv> {
        C397916() {
            AppMethodBeat.m2504i(38232);
            this.xxI = C42019kv.class.getName().hashCode();
            AppMethodBeat.m2505o(38232);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38233);
            C42019kv c42019kv = (C42019kv) c4883b;
            if (FlipView.this.rix) {
                if (c42019kv != null && (c42019kv instanceof C42019kv)) {
                    C4990ab.m7417i("MicroMsg.FlipView", "notify Event: %d", Integer.valueOf(c42019kv.cGM.cGK));
                    if (c42019kv.cGM.activity == ((Activity) FlipView.this.context) && c42019kv.cGM.ctB.equals(FlipView.this.riC)) {
                        switch (c42019kv.cGM.cGK) {
                            case 3:
                                ((Activity) FlipView.this.context).finish();
                                break;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.FlipView", "not the same");
                } else {
                    C4990ab.m7412e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
                }
            } else {
                C4990ab.m7416i("MicroMsg.FlipView", "no need to scan image");
            }
            AppMethodBeat.m2505o(38233);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.FlipView$1 */
    class C435751 implements Runnable {
        C435751() {
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
        this.handler = new C7306ak();
        crJ();
        C4879a.xxA.mo10052c(this.mip);
        C4879a.xxA.mo10052c(this.riJ);
    }

    public void setNeedScanImage(boolean z) {
        this.rix = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.FlipView", "onTouchEvent down");
            this.rip = (double) motionEvent.getX();
            this.riq = (double) motionEvent.getY();
            this.eRt = System.currentTimeMillis();
            if (C46631f.m88232O(motionEvent) == 1) {
                this.riv = false;
            }
        }
        if (C46631f.m88232O(motionEvent) > 1) {
            this.riv = true;
        }
        if (motionEvent.getAction() == 1 && !this.riv) {
            C4990ab.m7410d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.eRt));
            long yz = C5046bo.m7588yz();
            C4990ab.m7410d("MicroMsg.FlipView", "deltTime: " + (yz - this.riw));
            if (yz - this.riw < 300) {
                this.handler.removeCallbacks(this.riE);
                this.handler.post(new C435751());
                return super.dispatchTouchEvent(motionEvent);
            }
            this.riw = yz;
            if (System.currentTimeMillis() - this.eRt < 500 && Math.abs(((double) motionEvent.getX()) - this.rip) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.riq) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.riu - 100))) {
                C35006a c35006a = this.riE;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                c35006a.f15063x = x;
                c35006a.f15064y = y;
                this.handler.postDelayed(this.riE, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!C46631f.dzs()) {
        }
        return false;
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bj */
    public void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    /* renamed from: bk */
    public void mo8772bk(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final void mo76141f(final String str, final String str2, final String str3, boolean z) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        C46236n YT = C13373af.cnF().mo62918YT(str2);
        if (YT == null) {
            C4990ab.m7412e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (YT.field_type != 21) {
            arrayList.add(this.context.getString(C25738R.string.ens));
            arrayList2.add(Integer.valueOf(1));
            if (C25985d.afj("favorite")) {
                arrayList.add(this.context.getString(C25738R.string.dcq));
                arrayList2.add(Integer.valueOf(2));
            }
            if (YT.field_type == 15 || YT.field_type == 5) {
                arrayList.add(this.context.getString(C25738R.string.dx0));
                arrayList2.add(Integer.valueOf(0));
            } else if (YT.field_type == 1) {
                arrayList.add(this.context.getString(C25738R.string.dwx));
                arrayList2.add(Integer.valueOf(0));
            } else {
                arrayList.add(this.context.getString(C25738R.string.enw));
                arrayList2.add(Integer.valueOf(0));
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cwT = str2;
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB) {
                arrayList.add(this.context.getString(C25738R.string.f9188s7));
                arrayList2.add(Integer.valueOf(5));
            }
            if (!C35002v.m57482Zl(str2) && YT.field_type == 1) {
                arrayList.add(this.context.getString(C25738R.string.al9));
                arrayList2.add(Integer.valueOf(6));
            }
            if (this.riC != null) {
                if (C13119a.m21149BR(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.eny));
                } else if (C13119a.m21150ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(C25738R.string.enz));
                } else if (C13119a.m21148BQ(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.enx));
                } else {
                    arrayList.add(this.context.getString(C25738R.string.eny));
                }
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!YT.field_userName.equals(C1853r.m3846Yz())) {
            arrayList.add(this.context.getString(C25738R.string.eko));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.riy == null || !this.riD) {
            this.riy = new C36356d(this.context, 1, false);
        } else {
            this.riD = false;
        }
        this.riy.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(38227);
                c44273l.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        c44273l.mo70068e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(38227);
                        return;
                    }
                }
            }
        };
        this.riy.zQf = new C291093();
        this.riy.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(38229);
                C46236n YT = C13373af.cnF().mo62918YT(str2);
                if (YT == null) {
                    C4990ab.m7416i("MicroMsg.FlipView", "error beacause info null");
                    AppMethodBeat.m2505o(38229);
                    return;
                }
                C46236n YT2;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (YT.field_type != 15) {
                            C14987n.m23321j(str, FlipView.this.context);
                            AppMethodBeat.m2505o(38229);
                            return;
                        }
                        FlipView.m89478Zt(str2);
                        AppMethodBeat.m2505o(38229);
                        return;
                    case 1:
                        if (YT.field_type != 15) {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            if (YT != null) {
                                intent.putExtra("Retr_FromMainTimeline", FlipView.this.crK());
                                intent.putExtra("Retr_KSnsId", C29036i.m46115j(YT));
                            }
                            C24826a.gkE.mo38926k(intent, FlipView.this.context);
                            AppMethodBeat.m2505o(38229);
                            return;
                        }
                        new StringBuilder().append(C3892an.m6198fZ(C13373af.getAccSnsPath(), str3)).append(C29036i.m46108e((bau) YT.cqu().xfI.wbK.get(0)));
                        FlipView.m89479Zu(str2);
                        AppMethodBeat.m2505o(38229);
                        return;
                    case 2:
                        C45316cl c45316cl;
                        C32626rb c32626rb;
                        if (YT.field_type != 15) {
                            c45316cl = new C45316cl();
                            String str = str2;
                            String str2 = str3;
                            if (str2 == null || C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                                c45316cl.cvA.cvG = C25738R.string.boh;
                            } else if (C13373af.cnn()) {
                                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                                c45316cl.cvA.cvG = C25738R.string.boz;
                            } else {
                                YT2 = C13373af.cnF().mo62918YT(str);
                                if (YT2 == null) {
                                    C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                    c45316cl.cvA.cvG = C25738R.string.boi;
                                } else {
                                    C39739a.m67959a(c45316cl, YT2, str2);
                                }
                            }
                            c45316cl.cvA.cvH = 13;
                            c45316cl.cvA.activity = (Activity) FlipView.this.context;
                            C4879a.xxA.mo10055m(c45316cl);
                            if (FlipView.this.crK()) {
                                c32626rb = new C32626rb();
                                c32626rb.cNg.cFc = C29036i.m46115j(YT);
                                c32626rb.cNg.cwT = YT.cqU();
                                C4879a.xxA.mo10055m(c32626rb);
                            }
                            AppMethodBeat.m2505o(38229);
                            return;
                        } else if (YT == null) {
                            AppMethodBeat.m2505o(38229);
                            return;
                        } else {
                            if (YT.mo74253DI(32)) {
                                c45316cl = new C45316cl();
                                C39739a.m67958a(c45316cl, YT);
                                c45316cl.cvA.cvH = 14;
                                c45316cl.cvA.activity = (Activity) FlipView.this.context;
                                C4879a.xxA.mo10055m(c45316cl);
                            } else {
                                FlipView.m89498r(FlipView.this.crK(), YT.cqU());
                            }
                            if (FlipView.this.crK()) {
                                c32626rb = new C32626rb();
                                c32626rb.cNg.cFc = C29036i.m46115j(YT);
                                c32626rb.cNg.cwT = YT.cqU();
                                C4879a.xxA.mo10055m(c32626rb);
                            }
                            AppMethodBeat.m2505o(38229);
                            return;
                        }
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_expose_msg_id", FlipView.this.getSnsId());
                        YT2 = C13373af.cnF().mo62941kD(FlipView.this.getSnsId());
                        intent2.putExtra("k_username", YT2 == null ? "" : YT2.field_userName);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                        intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        C25985d.m41467b(FlipView.this.context, "webview", ".ui.tools.WebViewUI", intent2);
                        AppMethodBeat.m2505o(38229);
                        return;
                    case 4:
                        C4990ab.m7416i("MicroMsg.FlipView", "request deal QBAR string");
                        C26102cf c26102cf = new C26102cf();
                        c26102cf.cvm.activity = (Activity) FlipView.this.context;
                        c26102cf.cvm.ctB = FlipView.this.riC;
                        c26102cf.cvm.cvn = FlipView.this.cvn;
                        c26102cf.cvm.cvo = FlipView.this.cvo;
                        bau a = C34955aj.m57395a(YT, str3);
                        if (a != null) {
                            c26102cf.cvm.imagePath = a.Url;
                            c26102cf.cvm.cvr = a.wEY;
                        }
                        c26102cf.cvm.scene = 38;
                        if (FlipView.this.context instanceof Activity) {
                            c26102cf.cvm.cvs = ((Activity) FlipView.this.context).getIntent().getBundleExtra("_stat_obj");
                        }
                        if (FlipView.this instanceof SnsInfoFlip) {
                            SnsInfoFlip snsInfoFlip = (SnsInfoFlip) FlipView.this;
                            C44222az fromScene = snsInfoFlip.getFromScene();
                            C4990ab.m7411d("MicroMsg.FlipView", "from Scene: %s", fromScene.tag);
                            if (fromScene.tag.equals(C44222az.xYN.tag) || fromScene.tag.equals(C44222az.xYO.tag) || fromScene.tag.equals(C44222az.xYP.tag)) {
                                c26102cf.cvm.cvp = 5;
                                if (C5046bo.isNullOrNil(snsInfoFlip.username)) {
                                    C4990ab.m7416i("MicroMsg.FlipView", "empty username");
                                    snsInfoFlip.username = "";
                                }
                                c26102cf.cvm.source = snsInfoFlip.username;
                            } else if (fromScene.tag.equals(C44222az.xYM.tag)) {
                                c26102cf.cvm.cvp = 3;
                            } else {
                                C4990ab.m7417i("MicroMsg.FlipView", "other scene_from: %s", fromScene.tag);
                            }
                        }
                        C4879a.xxA.mo10055m(c26102cf);
                        AppMethodBeat.m2505o(38229);
                        return;
                    case 5:
                        if (YT.cqu().xfI.wbK.size() == 0) {
                            AppMethodBeat.m2505o(38229);
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
                            String g = FlipView.m89491g(str, FlipView.this.context);
                            if (g == null) {
                                AppMethodBeat.m2505o(38229);
                                return;
                            } else {
                                intent3.putExtra("sns_send_data_ui_image_path", g);
                                intent3.putExtra("sns_send_data_ui_image_position", position);
                            }
                        }
                        intent3.putExtra("sns_send_data_ui_activity", true);
                        intent3.putExtra("sns_local_id", str2);
                        C25985d.m41473f(FlipView.this.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                        AppMethodBeat.m2505o(38229);
                        return;
                    case 6:
                        FlipView.this.mo76139Zs(str);
                        break;
                }
                AppMethodBeat.m2505o(38229);
            }
        };
        this.riy.cpD();
        if (this.rix && true == z) {
            C1720g.m3537RQ();
            if (C1720g.m3535RO().eJo.acS() != 0) {
                this.riz = str;
                this.riA = str2;
                this.riB = str3;
                C45347np c45347np = new C45347np();
                c45347np.cJU.filePath = str;
                C4879a.xxA.mo10055m(c45347np);
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
    /* renamed from: g */
    public static String m89491g(String str, Context context) {
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = C6457e.euR + String.format("%s%d.%s", new Object[]{"image", Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(C4996ah.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (C5730e.m8644y(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            OutputStream L;
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    L = C5730e.m8617L(str2, false);
                    try {
                        decodeAsBitmap.compress(CompressFormat.JPEG, 80, L);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                            if (L != null) {
                                try {
                                    L.close();
                                } catch (Exception e3) {
                                }
                            }
                            C5730e.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str2)));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (L != null) {
                            }
                            C5730e.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        C4990ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                        if (L != null) {
                            try {
                                L.close();
                            } catch (Exception e5) {
                            }
                        }
                        C5730e.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str2)));
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
                C5730e.deleteFile(absolutePath);
            } catch (FileNotFoundException e7) {
                e = e7;
                L = null;
                C4990ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (L != null) {
                }
                C5730e.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str2)));
                return str2;
            } catch (OutOfMemoryError e8) {
                e = e8;
                L = null;
                C4990ab.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (L != null) {
                }
                C5730e.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str2)));
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
                C5730e.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && C5730e.m8644y(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str2)));
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        this.riz = null;
        this.riA = "";
        this.riB = null;
        if (this.riC != null) {
            C41964am c41964am = new C41964am();
            c41964am.ctA.activity = (Activity) this.context;
            c41964am.ctA.ctB = this.riC;
            C4879a.xxA.mo10055m(c41964am);
            this.riC = null;
            this.cvo = 0;
            this.cvn = 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        C4879a.xxA.mo10053d(this.mip);
        C4879a.xxA.mo10053d(this.riJ);
    }

    public bau getCntMedia() {
        return null;
    }

    /* renamed from: Zs */
    public final void mo76139Zs(String str) {
        if (C5730e.m8628ct(str)) {
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.FlipView", "edit image path:%s", str);
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

    /* renamed from: Zt */
    static /* synthetic */ void m89478Zt(String str) {
        C9463sb c9463sb = new C9463sb();
        c9463sb.cNV.cAd = 3;
        c9463sb.cNV.czD = str;
        C4879a.xxA.mo10055m(c9463sb);
    }

    /* renamed from: Zu */
    static /* synthetic */ void m89479Zu(String str) {
        C9463sb c9463sb = new C9463sb();
        c9463sb.cNV.cAd = 1;
        c9463sb.cNV.cNY = 2;
        c9463sb.cNV.czD = str;
        C4879a.xxA.mo10055m(c9463sb);
    }

    /* renamed from: r */
    static /* synthetic */ void m89498r(boolean z, String str) {
        C9463sb c9463sb = new C9463sb();
        c9463sb.cNV.cAd = 2;
        c9463sb.cNV.cNW = 14;
        c9463sb.cNV.cNX = z;
        c9463sb.cNV.czD = str;
        C4879a.xxA.mo10055m(c9463sb);
    }
}
