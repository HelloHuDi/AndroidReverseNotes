package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18379qt;
import com.tencent.p177mm.p230g.p232b.p233a.C32660ag;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayq;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ac */
public final class C46249ac implements C22150y {
    private String appId;
    private String appName;
    MMActivity crP;
    String cvZ = "";
    private boolean cwB = false;
    String desc = "";
    ProgressDialog ehJ = null;
    String fgE;
    private String hcl;
    private View jAp = null;
    String nuk;
    private int rig;
    private C37952b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private Bitmap rkA = null;
    private baa rkB = new baa();
    private String rkC;
    private boolean rkD = false;
    boolean rkE = false;
    private int rkF = 0;
    private MediaMetadataRetriever rkG = new MediaMetadataRetriever();
    private int rkH = 0;
    private int rkI = 0;
    private int rkJ = 90;
    private Pair<Integer, Integer> rkK = null;
    private Bitmap rkL = null;
    boolean rkM = false;
    private C4884c rkN = new C350881();
    C29054ax rkO = null;
    private int rkP = 0;
    Runnable rkQ = new C291745();
    Runnable rkR = new C136216();
    SightPlayImageView rkx;
    private ImageView rky = null;
    boolean rkz = false;
    String thumbPath = "";
    String videoPath = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$6 */
    class C136216 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.ui.ac$6$1 */
        class C136221 implements OnCancelListener {
            C136221() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(38343);
                C46249ac.this.rkO = null;
                C46249ac.this.rkz = false;
                C5004al.m7439af(C46249ac.this.rkQ);
                AppMethodBeat.m2505o(38343);
            }
        }

        C136216() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38344);
            C4990ab.m7416i("MicroMsg.SightWidget", "showProgress");
            C46249ac c46249ac = C46249ac.this;
            Context context = C46249ac.this.crP;
            C46249ac.this.crP.getString(C25738R.string.f9238tz);
            c46249ac.ehJ = C30379h.m48458b(context, C46249ac.this.crP.getString(C25738R.string.eoh), false, new C136221());
            AppMethodBeat.m2505o(38344);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$5 */
    class C291745 implements Runnable {
        C291745() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38342);
            C46249ac.m86584a(C46249ac.this);
            AppMethodBeat.m2505o(38342);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$7 */
    class C291757 implements Runnable {
        C291757() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38345);
            C23639t.makeText(C46249ac.this.crP, C25738R.string.e3n, 0).show();
            AppMethodBeat.m2505o(38345);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$8 */
    class C291768 implements Runnable {
        C291768() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38346);
            C23639t.makeText(C46249ac.this.crP, C25738R.string.e3n, 0).show();
            AppMethodBeat.m2505o(38346);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$1 */
    class C350881 extends C4884c<C18379qt> {
        C350881() {
            AppMethodBeat.m2504i(38335);
            this.xxI = C18379qt.class.getName().hashCode();
            AppMethodBeat.m2505o(38335);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38336);
            C18379qt c18379qt = (C18379qt) c4883b;
            C4990ab.m7417i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(c18379qt.cMT.type));
            switch (c18379qt.cMT.type) {
                case 1:
                    C4990ab.m7416i("MicroMsg.SightWidget", "come event done");
                    C46249ac.this.videoPath = c18379qt.cMT.videoPath;
                    C46249ac.this.cvZ = c18379qt.cMT.cMW;
                    if (C46249ac.this.ehJ != null) {
                        C46249ac.this.ehJ.dismiss();
                    }
                    if (c18379qt.cMT.cMV && C46249ac.this.rkO != null) {
                        C46249ac.m86584a(C46249ac.this);
                    }
                    C4990ab.m7417i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(c18379qt.cMT.cMV), c18379qt.cMT.videoPath, Long.valueOf(C5730e.asZ(c18379qt.cMT.videoPath)), C46249ac.this.cvZ);
                    break;
            }
            AppMethodBeat.m2505o(38336);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$2 */
    class C350892 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.ac$2$1 */
        class C220541 implements C36073c {
            C220541() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(38337);
                if (!C1947ae.gjt) {
                    c44273l.mo70068e(0, C46249ac.this.crP.getString(C25738R.string.f9121q4));
                }
                c44273l.mo70068e(1, C46249ac.this.crP.getString(C25738R.string.f9126qa));
                AppMethodBeat.m2505o(38337);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.ac$2$2 */
        class C291732 implements C5279d {
            C291732() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(38338);
                switch (menuItem.getItemId()) {
                    case 0:
                        C46249ac c46249ac = C46249ac.this;
                        c46249ac.mo74326DR(1);
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2));
                        C14987n.m23302a(c46249ac.crP, 11, new Intent(), 2, 0);
                        AppMethodBeat.m2505o(38338);
                        return;
                    case 1:
                        String string = C46249ac.this.crP.getSharedPreferences(C4996ah.doA(), 0).getString("gallery", "1");
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(2), Integer.valueOf(2));
                        if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            C14987n.m23306aj(C46249ac.this.crP);
                        } else {
                            C14987n.m23295a(C46249ac.this.crP, 9, 9, 4, 3, null);
                        }
                        C46249ac.this.mo74326DR(2);
                        break;
                }
                AppMethodBeat.m2505o(38338);
            }
        }

        C350892() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38339);
            if (C46249ac.this.rkE) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    try {
                        C29199ax c29199ax = new C29199ax(C46249ac.this.crP);
                        c29199ax.rBl = new C220541();
                        c29199ax.rBm = new C291732();
                        c29199ax.cuu();
                        AppMethodBeat.m2505o(38339);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(38339);
                        return;
                    }
                }
                C23639t.m36492hO(C46249ac.this.crP);
                AppMethodBeat.m2505o(38339);
            } else if (C5730e.m8628ct(C46249ac.this.videoPath)) {
                int width;
                int height;
                int[] iArr = new int[2];
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    width = view.getWidth();
                    height = view.getHeight();
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent(C46249ac.this.crP, SnsOnlineVideoActivity.class);
                intent.putExtra("intent_videopath", C46249ac.this.videoPath);
                intent.putExtra("intent_thumbpath", C46249ac.this.thumbPath);
                intent.putExtra("intent_isad", false);
                intent.putExtra("intent_ispreview", true);
                intent.putExtra("KBlockAdd", C46249ac.this.rkM);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                C46249ac.this.crP.startActivityForResult(intent, 12);
                C46249ac.this.crP.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(38339);
            } else {
                C4990ab.m7416i("MicroMsg.SightWidget", "click videopath is not exist " + C46249ac.this.videoPath);
                AppMethodBeat.m2505o(38339);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$4 */
    class C398254 implements Runnable {
        C398254() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38341);
            C46249ac c46249ac = C46249ac.this;
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(c46249ac.nuk) || TextUtils.isEmpty(c46249ac.fgE)) {
                if (!c46249ac.rkO.mo47168t(c46249ac.videoPath, c46249ac.thumbPath, c46249ac.desc, c46249ac.cvZ)) {
                    C4990ab.m7416i("MicroMsg.SightWidget", "commitInThread videopath " + C5730e.asZ(c46249ac.videoPath) + " thumb: " + C5730e.asZ(c46249ac.thumbPath));
                    C5004al.m7441d(new C291768());
                }
                C4990ab.m7417i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } else {
                int i;
                C29054ax c29054ax = c46249ac.rkO;
                String str = c46249ac.videoPath;
                String str2 = c46249ac.thumbPath;
                String str3 = c46249ac.desc;
                String str4 = c46249ac.cvZ;
                String str5 = c46249ac.nuk;
                String str6 = c46249ac.fgE;
                String str7 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str.getBytes());
                C29054ax.m46159Yw(str7);
                C5730e.m8644y(str, str7);
                String str8 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str2.getBytes());
                C5730e.m8644y(str2, str8);
                bau c = C29054ax.m46161c("", str7, str8, str4, str5, str6);
                if (c == null) {
                    C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                    i = 0;
                } else {
                    c.Desc = str3;
                    if (C5046bo.isNullOrNil(c.Title)) {
                        c.Title = str3;
                    }
                    c29054ax.qNK.xfI.wbK.add(c);
                    ayq ayq = new ayq();
                    ayq.wCt = c.cNE;
                    c29054ax.qNL.wFf.add(ayq);
                    i = 1;
                }
                if (i == 0) {
                    C4990ab.m7416i("MicroMsg.SightWidget", "commitInThread videopath " + C5730e.asZ(c46249ac.videoPath) + " thumb: " + C5730e.asZ(c46249ac.thumbPath) + ",cdnUrl " + c46249ac.nuk + "cdnThubmUrl " + c46249ac.fgE);
                    C5004al.m7441d(new C291757());
                }
                C4990ab.m7417i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            C4990ab.m7416i("MicroMsg.SightWidget", "removeRunnable showProgress");
            C5004al.m7439af(C46249ac.this.rkR);
            if (C46249ac.this.rkO == null) {
                AppMethodBeat.m2505o(38341);
                return;
            }
            C5004al.m7441d(C46249ac.this.rkQ);
            AppMethodBeat.m2505o(38341);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ac$3 */
    class C462483 implements Runnable {
        C462483() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38340);
            C23639t.makeText(C46249ac.this.crP, C25738R.string.e3n, 0).show();
            AppMethodBeat.m2505o(38340);
        }
    }

    public C46249ac(MMActivity mMActivity) {
        AppMethodBeat.m2504i(38347);
        this.crP = mMActivity;
        AppMethodBeat.m2505o(38347);
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38348);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.nuk = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.fgE = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rkD = this.crP.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rkM = this.crP.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hcl = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
        this.rkC = this.crP.getIntent().getStringExtra("KSessionID");
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
        }
        this.thumbPath = this.crP.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.crP.getIntent().getStringExtra("KSightPath");
        this.cvZ = this.crP.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.crP.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.rkB.parseFrom(byteArrayExtra);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.SightWidget", "error %s", e.getMessage());
            }
        }
        if (this.rkB == null) {
            this.rkB = new baa();
            this.rkB.wDP = this.rkD;
        }
        this.rkB.csB = this.hcl;
        C18379qt c18379qt = new C18379qt();
        c18379qt.cMT.type = 2;
        C4879a.xxA.mo10055m(c18379qt);
        if (C5046bo.isNullOrNil(this.videoPath)) {
            this.videoPath = C5046bo.m7532bc(c18379qt.cMU.cMY, "");
            C4990ab.m7413e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.cvZ = C5046bo.isNullOrNil(this.cvZ) ? C5046bo.m7532bc(c18379qt.cMU.cMW, "") : this.cvZ;
        C4990ab.m7417i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.cvZ);
        C4879a.xxA.mo10052c(this.rkN);
        if (this.rkF == 0) {
            C13373af.cnu();
            int screenWidth = C13478s.getScreenWidth();
            if (screenWidth == 0) {
                AppMethodBeat.m2505o(38348);
                return;
            }
            this.rkF = ((screenWidth - (this.crP.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 4)) - (this.crP.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8) * 2)) / 3;
        }
        AppMethodBeat.m2505o(38348);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return !this.rkE;
    }

    public final View crH() {
        AppMethodBeat.m2504i(38349);
        this.jAp = View.inflate(this.crP, 2130970980, null);
        this.rkx = (SightPlayImageView) this.jAp.findViewById(2131821511);
        this.rky = (ImageView) this.jAp.findViewById(2131820981);
        this.crP.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.rkI = C1338a.fromDPToPix(this.crP, 100);
        this.rkH = C1338a.fromDPToPix(this.crP, 100);
        try {
            boolean z;
            this.rkG.setDataSource(this.videoPath);
            this.rkJ = C5046bo.getInt(this.rkG.extractMetadata(24), 0);
            this.rkL = this.rkG.getFrameAtTime();
            if (this.rkJ == 0 || this.rkJ == 180) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.rkI = C5046bo.getInt(this.rkG.extractMetadata(19), C1338a.fromDPToPix(this.crP, 100));
                this.rkH = C5046bo.getInt(this.rkG.extractMetadata(18), C1338a.fromDPToPix(this.crP, 100));
            } else {
                this.rkI = C5046bo.getInt(this.rkG.extractMetadata(18), C1338a.fromDPToPix(this.crP, 100));
                this.rkH = C5046bo.getInt(this.rkG.extractMetadata(19), C1338a.fromDPToPix(this.crP, 100));
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.SightWidget", "MetadataRetriever init fail! path:%s  exception:%s", this.videoPath, e.getMessage());
        }
        this.rkK = C37953e.m64182a(this.rkH, this.rkI, this.crP, false);
        C4990ab.m7411d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", Integer.valueOf(this.rkH), Integer.valueOf(this.rkI), this.rkK.first, this.rkK.second, Integer.valueOf(this.rkJ));
        crZ();
        this.rkx.setScaleType(C15991a.CENTER_CROP);
        this.rkx.qyI = true;
        this.rkx.setOnClickListener(new C350892());
        C4990ab.m7416i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + C5730e.asZ(this.videoPath) + " " + C5730e.asZ(this.thumbPath));
        if (C5730e.m8628ct(this.videoPath)) {
            C4990ab.m7417i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.cvZ);
        }
        View view = this.jAp;
        AppMethodBeat.m2505o(38349);
        return view;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(38350);
        if (!C5730e.m8628ct(this.videoPath)) {
            C5004al.m7441d(new C462483());
            AppMethodBeat.m2505o(38350);
            return false;
        } else if (this.rkO != null) {
            AppMethodBeat.m2505o(38350);
            return false;
        } else if (this.rkz) {
            AppMethodBeat.m2505o(38350);
            return true;
        } else {
            this.rkz = true;
            this.desc = str;
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                LinkedList linkedList2 = new LinkedList();
                List Zn = C1855t.m3877Zn();
                for (String str3 : list) {
                    if (!Zn.contains(str3)) {
                        cco cco = new cco();
                        cco.jBB = str3;
                        linkedList.add(cco);
                    }
                }
            }
            this.rkO = new C29054ax(15);
            pInt.value = this.rkO.aPA;
            if (i3 > C24826a.qFE) {
                this.rkO.mo47138Dd(3);
            }
            C29054ax Ym = this.rkO.mo47144Ym(str);
            LinkedList linkedList3 = new LinkedList();
            Ym.mo47154a(ayt).mo47158ar(linkedList).mo47140Df(i).mo47141Dg(i2).mo47162dg(list2);
            if (z) {
                this.rkO.mo47143Di(1);
            } else {
                this.rkO.mo47143Di(0);
            }
            this.rkO.mo47162dg(list2);
            this.rkO.mo47142Dh(this.rig);
            this.rkO.cNJ = this.rkB;
            this.rkO.mo47164g(null, null, null, i4, i5);
            if (!C5046bo.isNullOrNil(this.appId)) {
                this.rkO.mo47150Ys(this.appId);
            }
            if (!C5046bo.isNullOrNil(this.appName)) {
                this.rkO.mo47151Yt(C5046bo.m7532bc(this.appName, ""));
            }
            if (this.rjF) {
                this.rkO.mo47142Dh(5);
            }
            if (this.rjG && this.rjH != null) {
                this.rkO.mo47145Yn(this.rjH.mediaTagName);
                this.rkO.mo47157af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
            }
            C5004al.m7442n(this.rkR, 700);
            C7305d.post(new C398254(), "sight_send_ready");
            AppMethodBeat.m2505o(38350);
            return true;
        }
    }

    /* renamed from: ld */
    private void m86585ld(boolean z) {
        AppMethodBeat.m2504i(38351);
        this.videoPath = "";
        this.thumbPath = "";
        this.rkE = z;
        this.rkJ = 90;
        if (C29036i.m46072B(this.rkL)) {
            this.rkL.recycle();
            this.rkL = null;
        }
        AppMethodBeat.m2505o(38351);
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        AppMethodBeat.m2504i(38352);
        int intExtra;
        String stringExtra;
        switch (i) {
            case 9:
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && C5046bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                    this.rkE = true;
                    ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra2 != null && stringArrayListExtra2.size() != 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = stringArrayListExtra2.iterator();
                        while (it.hasNext()) {
                            if (Exif.fromFile((String) it.next()).getLocation() != null) {
                                arrayList.add(String.format("%s\n%f\n%f", new Object[]{(String) it.next(), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().latitude), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().longitude)}));
                            }
                        }
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        intExtra = intent.getIntExtra("CropImage_filterId", 0);
                        if (this.crP instanceof SnsUploadUI) {
                            ((SnsUploadUI) this.crP).mo25789a(null, booleanExtra, intExtra, stringArrayListExtra2, arrayList, this.rig);
                            ((SnsUploadUI) this.crP).cuF();
                            break;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.SightWidget", "no image selected");
                    AppMethodBeat.m2505o(38352);
                    return false;
                }
                this.rkE = false;
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (C5046bo.isNullOrNil(stringExtra2) || !C5730e.m8628ct(stringExtra2)) {
                    stringExtra2 = C13373af.getAccSnsTmpPath() + C5730e.atg(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            C4990ab.m7412e("MicroMsg.SightWidget", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.SightWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        C5056d.m7625a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                        Options amj = C5056d.amj(stringExtra2);
                        C4990ab.m7417i("MicroMsg.SightWidget", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.SightWidget", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.m2505o(38352);
                    }
                }
                this.cvZ = C5730e.atg(stringExtra);
                C4990ab.m7417i("MicroMsg.SightWidget", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(C5730e.asZ(stringExtra)), Long.valueOf(C5730e.asZ(stringExtra2)));
                if (this.crP instanceof SnsUploadUI) {
                    ((SnsUploadUI) this.crP).mo25788a(stringExtra, stringExtra2, this.cvZ, null, false);
                    ((SnsUploadUI) this.crP).cuF();
                }
                AppMethodBeat.m2505o(38352);
                return true;
                break;
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        this.rkE = true;
                        intExtra = intent.getIntExtra("CropImage_filterId", 0);
                        stringExtra = sightCaptureResult.osI;
                        if (this.crP instanceof SnsUploadUI) {
                            ((SnsUploadUI) this.crP).mo25789a(stringExtra, true, intExtra, null, null, this.rig);
                            ((SnsUploadUI) this.crP).cuF();
                        }
                        AppMethodBeat.m2505o(38352);
                        return true;
                    }
                    this.rkE = false;
                    this.videoPath = sightCaptureResult.osC;
                    this.thumbPath = sightCaptureResult.osD;
                    if (C5046bo.isNullOrNil(sightCaptureResult.osF)) {
                        this.cvZ = C5730e.atg(sightCaptureResult.osC);
                    } else {
                        this.cvZ = sightCaptureResult.osF;
                    }
                    if (this.crP instanceof SnsUploadUI) {
                        ((SnsUploadUI) this.crP).mo25788a(this.videoPath, this.thumbPath, this.cvZ, null, true);
                        ((SnsUploadUI) this.crP).cuF();
                    }
                    AppMethodBeat.m2505o(38352);
                    return true;
                }
                break;
            case 12:
                if (intent != null) {
                    this.rkE = intent.getBooleanExtra("sns_update_preview_video_del", false);
                    if (this.rkE) {
                        csa();
                        m86585ld(true);
                    }
                    AppMethodBeat.m2505o(38352);
                    return true;
                }
                break;
        }
        AppMethodBeat.m2505o(38352);
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38353);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        C4879a.xxA.mo10053d(this.rkN);
        if (C29036i.m46072B(this.rkA)) {
            this.rkA.recycle();
        }
        m86585ld(false);
        AppMethodBeat.m2505o(38353);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DR */
    public final void mo74326DR(int i) {
        AppMethodBeat.m2504i(38354);
        C32660ag Fr = new C32660ag().mo53148Fr();
        Fr.cYH = (long) i;
        Fr.mo53149fj(this.rkC).ajK();
        AppMethodBeat.m2505o(38354);
    }

    /* Access modifiers changed, original: final */
    public final void crZ() {
        AppMethodBeat.m2504i(38355);
        if (!(this.rkL == null || this.rkL.isRecycled())) {
            this.rkx.setImageBitmap(this.rkL);
            this.rkx.mo8513fi(((Integer) this.rkK.first).intValue(), ((Integer) this.rkK.second).intValue());
        }
        AppMethodBeat.m2505o(38355);
    }

    /* Access modifiers changed, original: final */
    public final void csa() {
        AppMethodBeat.m2504i(38356);
        this.rky.setVisibility(8);
        this.rkx.qyA.clear();
        this.rkx.mo8513fi(C1338a.fromDPToPix(this.crP, 100), C1338a.fromDPToPix(this.crP, 100));
        this.rkx.setBackgroundResource(C25738R.color.a16);
        this.rkx.setImageResource(C1318a.album_post_add_picture_btn);
        this.rkx.setContentDescription(this.rkx.getContext().getString(C25738R.string.ejj));
        int fromDPToPix = (C1338a.fromDPToPix(this.crP, 100) * 35) / 100;
        this.rkx.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        AppMethodBeat.m2505o(38356);
    }

    /* renamed from: a */
    static /* synthetic */ void m86584a(C46249ac c46249ac) {
        AppMethodBeat.m2504i(38357);
        if (c46249ac.rkO != null) {
            if (c46249ac.ehJ != null) {
                c46249ac.ehJ.dismiss();
            }
            C4990ab.m7416i("MicroMsg.SightWidget", "commitDone");
            C18379qt c18379qt = new C18379qt();
            c18379qt.cMT.type = 0;
            c18379qt.cMT.cMV = true;
            C4879a.xxA.mo10055m(c18379qt);
            c46249ac.rkz = true;
            int commit = c46249ac.rkO.commit();
            if (c46249ac.rim != null) {
                c46249ac.rim.mo60719ma(commit);
                C24827g.qTp.mo37379c(c46249ac.rim);
            }
            C13373af.cnM().rmK = 0;
            if (c46249ac.crP.getIntent() != null && c46249ac.crP.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(c46249ac.crP, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                c46249ac.crP.startActivity(intent);
            }
            c46249ac.crP.setResult(-1);
            c46249ac.crP.finish();
            C13373af.cnB().cmp();
        }
        AppMethodBeat.m2505o(38357);
    }
}
