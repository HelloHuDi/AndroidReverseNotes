package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.plugin.sns.p517i.C24828h;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.protocal.protobuf.cfg;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.z */
public final class C29248z implements C22150y {
    private String appId;
    private String appName;
    private String cMg;
    private String cMl;
    private String cMm;
    final MMActivity crP;
    public String fiM = "";
    public String fiN = "";
    private Bitmap fru = null;
    private TextView gne = null;
    /* renamed from: h */
    private int f13711h = -1;
    String hcl;
    private View jAp = null;
    String link = "";
    private boolean mog = false;
    private cvi qNQ = null;
    private String rid = "";
    private byte[] rie = null;
    private String rif;
    private int rig;
    private CdnImageView rih = null;
    private TextView rii = null;
    private C37952b rim = null;
    private boolean rjA = false;
    private String rjB;
    private String rjC;
    private boolean rjD = false;
    private boolean rjE = false;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rjI = "";
    private String rjJ = "";
    private String rjK;
    private String rjL;
    private int rjM = 0;
    private C37952b rjN = null;
    private int rjO = 0;
    private String rjP = "";
    private String rjQ = "";
    private int rjR = 0;
    private String rjS = "";
    private String rjT = "";
    String rjU = "";
    private String title = "";
    private String videoUrl = "";
    /* renamed from: w */
    private int f13712w = -1;

    /* renamed from: com.tencent.mm.plugin.sns.ui.z$1 */
    class C292491 implements OnClickListener {
        C292491() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38275);
            if (C5046bo.isNullOrNil(C29248z.this.rjU)) {
                Intent intent;
                C32800b y = C37922v.m64076Zp().mo60676y(C29248z.this.hcl, true);
                if (y.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) {
                    int i = y.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                    int i2 = y.getInt("_DATA_SHOW_NATIVE_PAGE", -1);
                    if (i == 5 && i2 == 1) {
                        C4990ab.m7416i("MicroMsg.LinkWidget", "goto native video");
                        intent = new Intent();
                        intent.putExtras(C29248z.this.crP.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
                        View findViewById = view.findViewById(2131825687);
                        if (findViewById != null) {
                            int width = findViewById.getWidth();
                            int height = findViewById.getHeight();
                            int[] iArr = new int[2];
                            findViewById.getLocationInWindow(iArr);
                            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                        }
                        intent.addFlags(268435456);
                        C25985d.m41467b(C4996ah.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent);
                        AppMethodBeat.m2505o(38275);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.LinkWidget", "adlink url " + C29248z.this.link);
                intent = new Intent();
                intent.putExtra("rawUrl", C29248z.this.link);
                C24826a.gkE.mo38924i(intent, C29248z.this.crP);
                AppMethodBeat.m2505o(38275);
                return;
            }
            AppMethodBeat.m2505o(38275);
        }
    }

    public C29248z(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38276);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.rjO = this.crP.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.rjR = this.crP.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.rjS = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.rjT = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.fiM = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.fiN = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.f13712w = this.crP.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.f13711h = this.crP.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rjC = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.link = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rid = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.rie = this.crP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.rie == null && this.rjH != null && this.rjH.mediaObject != null && (this.rjH.mediaObject instanceof WXImageObject)) {
            this.rie = ((WXImageObject) this.rjH.mediaObject).imageData;
        }
        this.mog = this.crP.getIntent().getBooleanExtra("ksnsis_video", false);
        this.rjD = this.crP.getIntent().getBooleanExtra("ksnsis_music", false);
        this.rjE = this.crP.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.cMg = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("src_username"), "");
        this.rif = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("src_displayname"), "");
        this.appId = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rjK = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.rjL = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.cMl = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("JsAppId"), "");
        this.cMm = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KPublisherId"), "");
        this.hcl = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
        this.rjM = this.crP.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.rjU = this.crP.getIntent().getStringExtra("fav_note_xml");
        this.rjP = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.rjQ = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.rjB = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.rjB.startsWith("http://mmsns.qpic.cn") || this.rjB.startsWith("https://mmsns.qpic.cn")) {
            this.rid = this.rjB;
            this.rie = null;
            C4990ab.m7417i("MicroMsg.LinkWidget", "get thumb url %s", this.rjB);
        }
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
            if (C5046bo.isNullOrNil(this.title)) {
                this.title = this.rjH.title;
            }
            if (C5046bo.isNullOrNil(this.rjJ)) {
                this.rjJ = this.rjH.description;
            }
            if (C5046bo.m7540cb(this.rie)) {
                this.rie = this.rjH.thumbData;
            }
        }
        byte[] byteArrayExtra = this.crP.getIntent().getByteArrayExtra("KWebSearchInfo");
        if (byteArrayExtra != null) {
            this.qNQ = new cvi();
            try {
                this.qNQ.parseFrom(byteArrayExtra);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.LinkWidget", e, "parse web search info failed", new Object[0]);
                this.qNQ = null;
            }
        }
        String stringExtra = this.crP.getIntent().getStringExtra("KSnsStrId");
        C46236n YT = C13373af.cnF().mo62918YT(C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.rjN = C37952b.m64170lY(706);
            this.rjN.mo60721mc(this.rjN.fQh).mo60723ty(System.currentTimeMillis()).mo60721mc(this.rjN.fQi).mo60721mc(1).mo60723ty(stringExtra);
            if (YT != null) {
                this.rjN.mo60720mb(YT.field_type);
                this.rjN.mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(this.link);
            }
            C24828h.qTp.mo37378b(this.rjN);
        }
        AppMethodBeat.m2505o(38276);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View crH() {
        View view;
        AppMethodBeat.m2504i(38277);
        this.jAp = C5616v.m8409hu(this.crP).inflate(2130970978, null);
        if (!C5046bo.isNullOrNil(this.link)) {
            this.jAp.setOnClickListener(new C292491());
        }
        this.rih = (CdnImageView) this.jAp.findViewById(2131825687);
        this.gne = (TextView) this.jAp.findViewById(2131825689);
        this.rii = (TextView) this.jAp.findViewById(2131825690);
        if (!(this.mog || this.rjD)) {
            boolean z;
            if (this.qNQ == null || C5046bo.isNullOrNil(this.qNQ.uaa)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.jAp.findViewById(2131824637).setVisibility(8);
                if (C5046bo.isNullOrNil(this.title)) {
                    this.gne.setText(this.title);
                } else {
                    this.gne.setText(C46251au.m86603ZI(this.link));
                }
                if (C5046bo.isNullOrNil(this.rid)) {
                    this.rih.setVisibility(0);
                    this.rih.setUrl(this.rid);
                } else if (!C5046bo.m7540cb(this.rie)) {
                    this.rih.setVisibility(0);
                    this.fru = C5056d.m7652bQ(this.rie);
                    this.rih.setImageBitmap(this.fru);
                    this.rjA = true;
                } else if (C5046bo.isNullOrNil(this.rjU)) {
                    this.rih.setImageResource(C1318a.app_attach_file_icon_webpage);
                    this.rih.setVisibility(0);
                } else {
                    this.rih.setImageResource(C1318a.note_sns_link_default);
                    this.rih.setVisibility(0);
                }
                C29036i.m46100b(this.rih, this.crP);
                view = this.jAp;
                AppMethodBeat.m2505o(38277);
                return view;
            }
        }
        this.jAp.findViewById(2131824637).setVisibility(0);
        if (C5046bo.isNullOrNil(this.title)) {
        }
        if (C5046bo.isNullOrNil(this.rid)) {
        }
        C29036i.m46100b(this.rih, this.crP);
        view = this.jAp;
        AppMethodBeat.m2505o(38277);
        return view;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        C29054ax c29054ax;
        String str3;
        AppMethodBeat.m2504i(38278);
        if (this.rjD) {
            c29054ax = new C29054ax(4);
        } else if (this.mog) {
            c29054ax = new C29054ax(5);
        } else if (this.rjE) {
            c29054ax = new C29054ax(25);
            c29054ax.qNK.xfO.username = this.rjP;
            c29054ax.qNK.xfO.path = this.rjQ;
        } else if (this.rjO == 11) {
            c29054ax = new C29054ax(18);
            cfg cfg = new cfg();
            cfg.fiJ = this.rjS;
            cfg.fiI = this.title;
            cfg.fiG = this.link;
            cfg.fiK = this.rjT;
            cfg.fiH = this.rjR;
            cfg.fiL = this.rid;
            cfg.fiM = this.fiM;
            cfg.fiN = this.fiN;
            c29054ax.qNP = cfg;
            c29054ax.qNK.xfN = cfg;
        } else if (this.rjO == 15) {
            c29054ax = new C29054ax(26);
            c29054ax.qNK.xfI.wbM = this.rjU;
        } else if (this.rjO != 16 || this.qNQ == null) {
            c29054ax = new C29054ax(3);
        } else {
            c29054ax = new C29054ax(3);
            cvi cvi = this.qNQ;
            if (cvi != null) {
                c29054ax.qNQ = cvi;
            }
        }
        pInt.value = c29054ax.aPA;
        if (i3 > C24826a.qFE) {
            c29054ax.mo47138Dd(4);
        }
        if (this.rie == null) {
            C32291o.ahk();
            Bitmap kR = C17937c.m28186kR(this.rid);
            if (!(kR == null || kR.isRecycled())) {
                C4990ab.m7417i("MicroMsg.LinkWidget", "create bitmap %d %d", Integer.valueOf(C5056d.m7615a(kR, 150, 150, false, false).getHeight()), Integer.valueOf(C5056d.m7615a(kR, 150, 150, false, false).getWidth()));
                this.rie = C5056d.m7636ai(kR);
            }
        }
        c29054ax.mo47149Yr(this.title).mo47147Yp(this.link).mo47148Yq(this.link).mo47144Ym(str);
        if (this.rjO == 15) {
            c29054ax.mo47147Yp(C5046bo.m7532bc(this.crP.getIntent().getStringExtra("fav_note_link_description"), ""));
        }
        if (this.rjD) {
            if (!c29054ax.mo47156a(this.rie, this.link, this.link, this.link, 3, "", "")) {
            }
        } else if (this.mog) {
            WXVideoObject wXVideoObject;
            if (this.rjH != null) {
                wXVideoObject = (WXVideoObject) this.rjH.mediaObject;
            } else {
                wXVideoObject = null;
            }
            c29054ax.mo47156a(this.rie, this.link, wXVideoObject == null ? this.link : C5046bo.m7532bc(wXVideoObject.videoLowBandUrl, this.link), wXVideoObject == null ? this.link : C5046bo.m7532bc(wXVideoObject.videoUrl, this.link), 4, C5046bo.m7532bc(this.title, ""), C5046bo.m7532bc(this.rjJ, ""));
        } else if (!C5046bo.isNullOrNil(this.rjB)) {
            str3 = this.rjB;
            String str4 = "";
            String str5 = "";
            int i6 = this.f13712w;
            int i7 = this.f13711h;
            bau ag = C29054ax.m46160ag("", str3, str3);
            if (ag == null) {
                C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            } else {
                ag.Desc = str4;
                if (i6 > 0 && i7 > 0) {
                    baw baw = new baw();
                    baw.wFy = (float) i7;
                    baw.wFx = (float) i6;
                    ag.wEK = baw;
                }
                if (!C5046bo.isNullOrNil(str5)) {
                    ag.Title = str5;
                }
                if (!C5046bo.isNullOrNil(str4)) {
                    ag.Desc = str4;
                }
                c29054ax.qNK.xfI.wbK.add(ag);
            }
        } else if (this.rie != null) {
            if (this.rjE) {
                Object obj;
                byte[] bArr = this.rie;
                if (bArr == null) {
                    obj = null;
                } else if (bArr.length < 4) {
                    obj = null;
                } else {
                    obj = 1;
                    byte[] bArr2 = new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71};
                    for (int i8 = 0; i8 < 4; i8++) {
                        if (bArr[i8] != bArr2[i8]) {
                            obj = null;
                        }
                    }
                }
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.LinkWidget", "isPngThumbData");
                    byte[] bj = C35123e.m57727bj(this.rie);
                    if (bj != null && bj.length > 0) {
                        C4990ab.m7416i("MicroMsg.LinkWidget", "use covert data");
                        this.rie = C35123e.m57727bj(bj);
                    }
                }
            }
            c29054ax.mo47160b(this.rie, "", "");
        }
        c29054ax.mo47142Dh(this.rig);
        c29054ax.mo47152Yu(this.cMg);
        c29054ax.mo47153Yv(this.rif);
        c29054ax.qNK.rjC = C5046bo.nullAsNil(this.rjC);
        C4990ab.m7417i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", str3);
        c29054ax.mo47140Df(i);
        if (z) {
            c29054ax.mo47143Di(1);
        } else {
            c29054ax.mo47143Di(0);
        }
        c29054ax.mo47162dg(list2);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List Zn = C1855t.m3877Zn();
            for (String str32 : list) {
                if (!Zn.contains(str32)) {
                    cco cco = new cco();
                    cco.jBB = str32;
                    linkedList.add(cco);
                }
            }
        }
        if (c41173i != null) {
            c29054ax.mo47165gc(c41173i.token, c41173i.wFn);
        }
        c29054ax.mo47158ar(linkedList);
        if (!C5046bo.isNullOrNil(this.appId)) {
            c29054ax.mo47150Ys(this.appId);
        }
        if (!C5046bo.isNullOrNil(this.appName)) {
            c29054ax.mo47151Yt(C5046bo.m7532bc(this.appName, ""));
        }
        if (this.rjF) {
            c29054ax.mo47142Dh(5);
        }
        c29054ax.mo47154a(ayt);
        if (this.rjG && this.rjH != null) {
            c29054ax.mo47145Yn(this.rjH.mediaTagName);
            c29054ax.mo47157af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
        }
        c29054ax.mo47146Yo(str2);
        c29054ax.mo47164g(this.rjK, this.rjL, this.cMl, i4, i5);
        c29054ax.qNL.cMm = this.cMm;
        c29054ax.setSessionId(this.hcl);
        c29054ax.qNK.fgt = this.rjM;
        int commit = c29054ax.commit();
        if (this.rim != null) {
            this.rim.mo60719ma(commit);
            C24827g.qTp.mo37379c(this.rim);
        }
        if (this.rjN != null) {
            this.rjN.mo60719ma(commit);
            C24828h.qTp.mo37379c(this.rjN);
            this.rjN.ajK();
        }
        C13373af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.m2505o(38278);
        return false;
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38279);
        if (!(this.fru == null || this.fru.isRecycled() || !this.rjA)) {
            this.fru.recycle();
        }
        AppMethodBeat.m2505o(38279);
        return false;
    }
}
