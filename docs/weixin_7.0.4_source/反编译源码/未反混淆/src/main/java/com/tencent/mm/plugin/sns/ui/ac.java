package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ac implements y {
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
    private b rim = null;
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
    private c rkN = new c<qt>() {
        {
            AppMethodBeat.i(38335);
            this.xxI = qt.class.getName().hashCode();
            AppMethodBeat.o(38335);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38336);
            qt qtVar = (qt) bVar;
            ab.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(qtVar.cMT.type));
            switch (qtVar.cMT.type) {
                case 1:
                    ab.i("MicroMsg.SightWidget", "come event done");
                    ac.this.videoPath = qtVar.cMT.videoPath;
                    ac.this.cvZ = qtVar.cMT.cMW;
                    if (ac.this.ehJ != null) {
                        ac.this.ehJ.dismiss();
                    }
                    if (qtVar.cMT.cMV && ac.this.rkO != null) {
                        ac.a(ac.this);
                    }
                    ab.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(qtVar.cMT.cMV), qtVar.cMT.videoPath, Long.valueOf(e.asZ(qtVar.cMT.videoPath)), ac.this.cvZ);
                    break;
            }
            AppMethodBeat.o(38336);
            return false;
        }
    };
    ax rkO = null;
    private int rkP = 0;
    Runnable rkQ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38342);
            ac.a(ac.this);
            AppMethodBeat.o(38342);
        }
    };
    Runnable rkR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38344);
            ab.i("MicroMsg.SightWidget", "showProgress");
            ac acVar = ac.this;
            Context context = ac.this.crP;
            ac.this.crP.getString(R.string.tz);
            acVar.ehJ = h.b(context, ac.this.crP.getString(R.string.eoh), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(38343);
                    ac.this.rkO = null;
                    ac.this.rkz = false;
                    al.af(ac.this.rkQ);
                    AppMethodBeat.o(38343);
                }
            });
            AppMethodBeat.o(38344);
        }
    };
    SightPlayImageView rkx;
    private ImageView rky = null;
    boolean rkz = false;
    String thumbPath = "";
    String videoPath = "";

    public ac(MMActivity mMActivity) {
        AppMethodBeat.i(38347);
        this.crP = mMActivity;
        AppMethodBeat.o(38347);
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38348);
        this.rim = b.u(this.crP.getIntent());
        this.nuk = bo.bc(this.crP.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.fgE = bo.bc(this.crP.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rkD = this.crP.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rkM = this.crP.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hcl = bo.bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
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
                ab.i("MicroMsg.SightWidget", "error %s", e.getMessage());
            }
        }
        if (this.rkB == null) {
            this.rkB = new baa();
            this.rkB.wDP = this.rkD;
        }
        this.rkB.csB = this.hcl;
        qt qtVar = new qt();
        qtVar.cMT.type = 2;
        a.xxA.m(qtVar);
        if (bo.isNullOrNil(this.videoPath)) {
            this.videoPath = bo.bc(qtVar.cMU.cMY, "");
            ab.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.cvZ = bo.isNullOrNil(this.cvZ) ? bo.bc(qtVar.cMU.cMW, "") : this.cvZ;
        ab.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.cvZ);
        a.xxA.c(this.rkN);
        if (this.rkF == 0) {
            af.cnu();
            int screenWidth = s.getScreenWidth();
            if (screenWidth == 0) {
                AppMethodBeat.o(38348);
                return;
            }
            this.rkF = ((screenWidth - (this.crP.getResources().getDimensionPixelSize(R.dimen.a9l) * 4)) - (this.crP.getResources().getDimensionPixelSize(R.dimen.l8) * 2)) / 3;
        }
        AppMethodBeat.o(38348);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return !this.rkE;
    }

    public final View crH() {
        AppMethodBeat.i(38349);
        this.jAp = View.inflate(this.crP, R.layout.b14, null);
        this.rkx = (SightPlayImageView) this.jAp.findViewById(R.id.z4);
        this.rky = (ImageView) this.jAp.findViewById(R.id.l4);
        this.crP.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.rkI = com.tencent.mm.bz.a.fromDPToPix(this.crP, 100);
        this.rkH = com.tencent.mm.bz.a.fromDPToPix(this.crP, 100);
        try {
            boolean z;
            this.rkG.setDataSource(this.videoPath);
            this.rkJ = bo.getInt(this.rkG.extractMetadata(24), 0);
            this.rkL = this.rkG.getFrameAtTime();
            if (this.rkJ == 0 || this.rkJ == 180) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.rkI = bo.getInt(this.rkG.extractMetadata(19), com.tencent.mm.bz.a.fromDPToPix(this.crP, 100));
                this.rkH = bo.getInt(this.rkG.extractMetadata(18), com.tencent.mm.bz.a.fromDPToPix(this.crP, 100));
            } else {
                this.rkI = bo.getInt(this.rkG.extractMetadata(18), com.tencent.mm.bz.a.fromDPToPix(this.crP, 100));
                this.rkH = bo.getInt(this.rkG.extractMetadata(19), com.tencent.mm.bz.a.fromDPToPix(this.crP, 100));
            }
        } catch (Exception e) {
            ab.w("MicroMsg.SightWidget", "MetadataRetriever init fail! path:%s  exception:%s", this.videoPath, e.getMessage());
        }
        this.rkK = com.tencent.mm.modelsns.e.a(this.rkH, this.rkI, this.crP, false);
        ab.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", Integer.valueOf(this.rkH), Integer.valueOf(this.rkI), this.rkK.first, this.rkK.second, Integer.valueOf(this.rkJ));
        crZ();
        this.rkx.setScaleType(QImageView.a.CENTER_CROP);
        this.rkx.qyI = true;
        this.rkx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38339);
                if (ac.this.rkE) {
                    g.RQ();
                    if (g.RP().isSDCardAvailable()) {
                        try {
                            ax axVar = new ax(ac.this.crP);
                            axVar.rBl = new n.c() {
                                public final void a(l lVar) {
                                    AppMethodBeat.i(38337);
                                    if (!ae.gjt) {
                                        lVar.e(0, ac.this.crP.getString(R.string.q4));
                                    }
                                    lVar.e(1, ac.this.crP.getString(R.string.qa));
                                    AppMethodBeat.o(38337);
                                }
                            };
                            axVar.rBm = new d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.i(38338);
                                    switch (menuItem.getItemId()) {
                                        case 0:
                                            ac acVar = ac.this;
                                            acVar.DR(1);
                                            com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2));
                                            com.tencent.mm.pluginsdk.ui.tools.n.a(acVar.crP, 11, new Intent(), 2, 0);
                                            AppMethodBeat.o(38338);
                                            return;
                                        case 1:
                                            String string = ac.this.crP.getSharedPreferences(ah.doA(), 0).getString("gallery", "1");
                                            com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(2), Integer.valueOf(2));
                                            if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                                com.tencent.mm.pluginsdk.ui.tools.n.aj(ac.this.crP);
                                            } else {
                                                com.tencent.mm.pluginsdk.ui.tools.n.a(ac.this.crP, 9, 9, 4, 3, null);
                                            }
                                            ac.this.DR(2);
                                            break;
                                    }
                                    AppMethodBeat.o(38338);
                                }
                            };
                            axVar.cuu();
                            AppMethodBeat.o(38339);
                            return;
                        } catch (Exception e) {
                            AppMethodBeat.o(38339);
                            return;
                        }
                    }
                    t.hO(ac.this.crP);
                    AppMethodBeat.o(38339);
                } else if (e.ct(ac.this.videoPath)) {
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
                    Intent intent = new Intent(ac.this.crP, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", ac.this.videoPath);
                    intent.putExtra("intent_thumbpath", ac.this.thumbPath);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_ispreview", true);
                    intent.putExtra("KBlockAdd", ac.this.rkM);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    ac.this.crP.startActivityForResult(intent, 12);
                    ac.this.crP.overridePendingTransition(0, 0);
                    AppMethodBeat.o(38339);
                } else {
                    ab.i("MicroMsg.SightWidget", "click videopath is not exist " + ac.this.videoPath);
                    AppMethodBeat.o(38339);
                }
            }
        });
        ab.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + e.asZ(this.videoPath) + " " + e.asZ(this.thumbPath));
        if (e.ct(this.videoPath)) {
            ab.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.cvZ);
        }
        View view = this.jAp;
        AppMethodBeat.o(38349);
        return view;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(38350);
        if (!e.ct(this.videoPath)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38340);
                    t.makeText(ac.this.crP, R.string.e3n, 0).show();
                    AppMethodBeat.o(38340);
                }
            });
            AppMethodBeat.o(38350);
            return false;
        } else if (this.rkO != null) {
            AppMethodBeat.o(38350);
            return false;
        } else if (this.rkz) {
            AppMethodBeat.o(38350);
            return true;
        } else {
            this.rkz = true;
            this.desc = str;
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                LinkedList linkedList2 = new LinkedList();
                List Zn = com.tencent.mm.model.t.Zn();
                for (String str3 : list) {
                    if (!Zn.contains(str3)) {
                        cco cco = new cco();
                        cco.jBB = str3;
                        linkedList.add(cco);
                    }
                }
            }
            this.rkO = new ax(15);
            pInt.value = this.rkO.aPA;
            if (i3 > com.tencent.mm.plugin.sns.c.a.qFE) {
                this.rkO.Dd(3);
            }
            ax Ym = this.rkO.Ym(str);
            LinkedList linkedList3 = new LinkedList();
            Ym.a(ayt).ar(linkedList).Df(i).Dg(i2).dg(list2);
            if (z) {
                this.rkO.Di(1);
            } else {
                this.rkO.Di(0);
            }
            this.rkO.dg(list2);
            this.rkO.Dh(this.rig);
            this.rkO.cNJ = this.rkB;
            this.rkO.g(null, null, null, i4, i5);
            if (!bo.isNullOrNil(this.appId)) {
                this.rkO.Ys(this.appId);
            }
            if (!bo.isNullOrNil(this.appName)) {
                this.rkO.Yt(bo.bc(this.appName, ""));
            }
            if (this.rjF) {
                this.rkO.Dh(5);
            }
            if (this.rjG && this.rjH != null) {
                this.rkO.Yn(this.rjH.mediaTagName);
                this.rkO.af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
            }
            al.n(this.rkR, 700);
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38341);
                    ac acVar = ac.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(acVar.nuk) || TextUtils.isEmpty(acVar.fgE)) {
                        if (!acVar.rkO.t(acVar.videoPath, acVar.thumbPath, acVar.desc, acVar.cvZ)) {
                            ab.i("MicroMsg.SightWidget", "commitInThread videopath " + e.asZ(acVar.videoPath) + " thumb: " + e.asZ(acVar.thumbPath));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(38346);
                                    t.makeText(ac.this.crP, R.string.e3n, 0).show();
                                    AppMethodBeat.o(38346);
                                }
                            });
                        }
                        ab.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        int i;
                        ax axVar = acVar.rkO;
                        String str = acVar.videoPath;
                        String str2 = acVar.thumbPath;
                        String str3 = acVar.desc;
                        String str4 = acVar.cvZ;
                        String str5 = acVar.nuk;
                        String str6 = acVar.fgE;
                        String str7 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.x(str.getBytes());
                        ax.Yw(str7);
                        e.y(str, str7);
                        String str8 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.x(str2.getBytes());
                        e.y(str2, str8);
                        bau c = ax.c("", str7, str8, str4, str5, str6);
                        if (c == null) {
                            ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                            i = 0;
                        } else {
                            c.Desc = str3;
                            if (bo.isNullOrNil(c.Title)) {
                                c.Title = str3;
                            }
                            axVar.qNK.xfI.wbK.add(c);
                            ayq ayq = new ayq();
                            ayq.wCt = c.cNE;
                            axVar.qNL.wFf.add(ayq);
                            i = 1;
                        }
                        if (i == 0) {
                            ab.i("MicroMsg.SightWidget", "commitInThread videopath " + e.asZ(acVar.videoPath) + " thumb: " + e.asZ(acVar.thumbPath) + ",cdnUrl " + acVar.nuk + "cdnThubmUrl " + acVar.fgE);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(38345);
                                    t.makeText(ac.this.crP, R.string.e3n, 0).show();
                                    AppMethodBeat.o(38345);
                                }
                            });
                        }
                        ab.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                    ab.i("MicroMsg.SightWidget", "removeRunnable showProgress");
                    al.af(ac.this.rkR);
                    if (ac.this.rkO == null) {
                        AppMethodBeat.o(38341);
                        return;
                    }
                    al.d(ac.this.rkQ);
                    AppMethodBeat.o(38341);
                }
            }, "sight_send_ready");
            AppMethodBeat.o(38350);
            return true;
        }
    }

    private void ld(boolean z) {
        AppMethodBeat.i(38351);
        this.videoPath = "";
        this.thumbPath = "";
        this.rkE = z;
        this.rkJ = 90;
        if (com.tencent.mm.plugin.sns.data.i.B(this.rkL)) {
            this.rkL.recycle();
            this.rkL = null;
        }
        AppMethodBeat.o(38351);
    }

    public final boolean f(int i, Intent intent) {
        AppMethodBeat.i(38352);
        int intExtra;
        String stringExtra;
        switch (i) {
            case 9:
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
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
                            ((SnsUploadUI) this.crP).a(null, booleanExtra, intExtra, stringArrayListExtra2, arrayList, this.rig);
                            ((SnsUploadUI) this.crP).cuF();
                            break;
                        }
                    }
                    ab.i("MicroMsg.SightWidget", "no image selected");
                    AppMethodBeat.o(38352);
                    return false;
                }
                this.rkE = false;
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (bo.isNullOrNil(stringExtra2) || !e.ct(stringExtra2)) {
                    stringExtra2 = af.getAccSnsTmpPath() + e.atg(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            ab.e("MicroMsg.SightWidget", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        }
                        ab.i("MicroMsg.SightWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                        Options amj = com.tencent.mm.sdk.platformtools.d.amj(stringExtra2);
                        ab.i("MicroMsg.SightWidget", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        ab.e("MicroMsg.SightWidget", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.o(38352);
                    }
                }
                this.cvZ = e.atg(stringExtra);
                ab.i("MicroMsg.SightWidget", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(e.asZ(stringExtra)), Long.valueOf(e.asZ(stringExtra2)));
                if (this.crP instanceof SnsUploadUI) {
                    ((SnsUploadUI) this.crP).a(stringExtra, stringExtra2, this.cvZ, null, false);
                    ((SnsUploadUI) this.crP).cuF();
                }
                AppMethodBeat.o(38352);
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
                            ((SnsUploadUI) this.crP).a(stringExtra, true, intExtra, null, null, this.rig);
                            ((SnsUploadUI) this.crP).cuF();
                        }
                        AppMethodBeat.o(38352);
                        return true;
                    }
                    this.rkE = false;
                    this.videoPath = sightCaptureResult.osC;
                    this.thumbPath = sightCaptureResult.osD;
                    if (bo.isNullOrNil(sightCaptureResult.osF)) {
                        this.cvZ = e.atg(sightCaptureResult.osC);
                    } else {
                        this.cvZ = sightCaptureResult.osF;
                    }
                    if (this.crP instanceof SnsUploadUI) {
                        ((SnsUploadUI) this.crP).a(this.videoPath, this.thumbPath, this.cvZ, null, true);
                        ((SnsUploadUI) this.crP).cuF();
                    }
                    AppMethodBeat.o(38352);
                    return true;
                }
                break;
            case 12:
                if (intent != null) {
                    this.rkE = intent.getBooleanExtra("sns_update_preview_video_del", false);
                    if (this.rkE) {
                        csa();
                        ld(true);
                    }
                    AppMethodBeat.o(38352);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(38352);
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38353);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        a.xxA.d(this.rkN);
        if (com.tencent.mm.plugin.sns.data.i.B(this.rkA)) {
            this.rkA.recycle();
        }
        ld(false);
        AppMethodBeat.o(38353);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void DR(int i) {
        AppMethodBeat.i(38354);
        ag Fr = new ag().Fr();
        Fr.cYH = (long) i;
        Fr.fj(this.rkC).ajK();
        AppMethodBeat.o(38354);
    }

    /* Access modifiers changed, original: final */
    public final void crZ() {
        AppMethodBeat.i(38355);
        if (!(this.rkL == null || this.rkL.isRecycled())) {
            this.rkx.setImageBitmap(this.rkL);
            this.rkx.fi(((Integer) this.rkK.first).intValue(), ((Integer) this.rkK.second).intValue());
        }
        AppMethodBeat.o(38355);
    }

    /* Access modifiers changed, original: final */
    public final void csa() {
        AppMethodBeat.i(38356);
        this.rky.setVisibility(8);
        this.rkx.qyA.clear();
        this.rkx.fi(com.tencent.mm.bz.a.fromDPToPix(this.crP, 100), com.tencent.mm.bz.a.fromDPToPix(this.crP, 100));
        this.rkx.setBackgroundResource(R.color.a16);
        this.rkx.setImageResource(R.raw.album_post_add_picture_btn);
        this.rkx.setContentDescription(this.rkx.getContext().getString(R.string.ejj));
        int fromDPToPix = (com.tencent.mm.bz.a.fromDPToPix(this.crP, 100) * 35) / 100;
        this.rkx.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        AppMethodBeat.o(38356);
    }

    static /* synthetic */ void a(ac acVar) {
        AppMethodBeat.i(38357);
        if (acVar.rkO != null) {
            if (acVar.ehJ != null) {
                acVar.ehJ.dismiss();
            }
            ab.i("MicroMsg.SightWidget", "commitDone");
            qt qtVar = new qt();
            qtVar.cMT.type = 0;
            qtVar.cMT.cMV = true;
            a.xxA.m(qtVar);
            acVar.rkz = true;
            int commit = acVar.rkO.commit();
            if (acVar.rim != null) {
                acVar.rim.ma(commit);
                com.tencent.mm.plugin.sns.i.g.qTp.c(acVar.rim);
            }
            af.cnM().rmK = 0;
            if (acVar.crP.getIntent() != null && acVar.crP.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(acVar.crP, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                acVar.crP.startActivity(intent);
            }
            acVar.crP.setResult(-1);
            acVar.crP.finish();
            af.cnB().cmp();
        }
        AppMethodBeat.o(38357);
    }
}
