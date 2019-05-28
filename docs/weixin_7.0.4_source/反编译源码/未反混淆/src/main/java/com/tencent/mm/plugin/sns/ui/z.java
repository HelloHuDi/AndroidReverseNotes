package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class z implements y {
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
    private int h = -1;
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
    private b rim = null;
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
    private b rjN = null;
    private int rjO = 0;
    private String rjP = "";
    private String rjQ = "";
    private int rjR = 0;
    private String rjS = "";
    private String rjT = "";
    String rjU = "";
    private String title = "";
    private String videoUrl = "";
    private int w = -1;

    public z(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38276);
        this.rim = b.u(this.crP.getIntent());
        this.rjO = this.crP.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.rjR = this.crP.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.rjS = bo.bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.rjT = bo.bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.fiM = bo.bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.fiN = bo.bc(this.crP.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.crP.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.crP.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rjC = bo.bc(this.crP.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.link = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rid = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.rie = this.crP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.rie == null && this.rjH != null && this.rjH.mediaObject != null && (this.rjH.mediaObject instanceof WXImageObject)) {
            this.rie = ((WXImageObject) this.rjH.mediaObject).imageData;
        }
        this.mog = this.crP.getIntent().getBooleanExtra("ksnsis_video", false);
        this.rjD = this.crP.getIntent().getBooleanExtra("ksnsis_music", false);
        this.rjE = this.crP.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.cMg = bo.bc(this.crP.getIntent().getStringExtra("src_username"), "");
        this.rif = bo.bc(this.crP.getIntent().getStringExtra("src_displayname"), "");
        this.appId = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rjK = bo.bc(this.crP.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.rjL = bo.bc(this.crP.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.cMl = bo.bc(this.crP.getIntent().getStringExtra("JsAppId"), "");
        this.cMm = bo.bc(this.crP.getIntent().getStringExtra("KPublisherId"), "");
        this.hcl = bo.bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
        this.rjM = this.crP.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.rjU = this.crP.getIntent().getStringExtra("fav_note_xml");
        this.rjP = bo.bc(this.crP.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.rjQ = bo.bc(this.crP.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.rjB = bo.bc(this.crP.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.rjB.startsWith("http://mmsns.qpic.cn") || this.rjB.startsWith("https://mmsns.qpic.cn")) {
            this.rid = this.rjB;
            this.rie = null;
            ab.i("MicroMsg.LinkWidget", "get thumb url %s", this.rjB);
        }
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
            if (bo.isNullOrNil(this.title)) {
                this.title = this.rjH.title;
            }
            if (bo.isNullOrNil(this.rjJ)) {
                this.rjJ = this.rjH.description;
            }
            if (bo.cb(this.rie)) {
                this.rie = this.rjH.thumbData;
            }
        }
        byte[] byteArrayExtra = this.crP.getIntent().getByteArrayExtra("KWebSearchInfo");
        if (byteArrayExtra != null) {
            this.qNQ = new cvi();
            try {
                this.qNQ.parseFrom(byteArrayExtra);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.LinkWidget", e, "parse web search info failed", new Object[0]);
                this.qNQ = null;
            }
        }
        String stringExtra = this.crP.getIntent().getStringExtra("KSnsStrId");
        n YT = af.cnF().YT(bo.bc(this.crP.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!bo.isNullOrNil(stringExtra)) {
            this.rjN = b.lY(706);
            this.rjN.mc(this.rjN.fQh).ty(System.currentTimeMillis()).mc(this.rjN.fQi).mc(1).ty(stringExtra);
            if (YT != null) {
                this.rjN.mb(YT.field_type);
                this.rjN.cS(YT.DI(32)).tx(YT.crc()).tx(this.link);
            }
            h.qTp.b(this.rjN);
        }
        AppMethodBeat.o(38276);
    }

    public final void N(Bundle bundle) {
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
        AppMethodBeat.i(38277);
        this.jAp = v.hu(this.crP).inflate(R.layout.b12, null);
        if (!bo.isNullOrNil(this.link)) {
            this.jAp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38275);
                    if (bo.isNullOrNil(z.this.rjU)) {
                        Intent intent;
                        com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y(z.this.hcl, true);
                        if (y.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) {
                            int i = y.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                            int i2 = y.getInt("_DATA_SHOW_NATIVE_PAGE", -1);
                            if (i == 5 && i2 == 1) {
                                ab.i("MicroMsg.LinkWidget", "goto native video");
                                intent = new Intent();
                                intent.putExtras(z.this.crP.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
                                View findViewById = view.findViewById(R.id.d11);
                                if (findViewById != null) {
                                    int width = findViewById.getWidth();
                                    int height = findViewById.getHeight();
                                    int[] iArr = new int[2];
                                    findViewById.getLocationInWindow(iArr);
                                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                }
                                intent.addFlags(268435456);
                                d.b(ah.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent);
                                AppMethodBeat.o(38275);
                                return;
                            }
                        }
                        ab.i("MicroMsg.LinkWidget", "adlink url " + z.this.link);
                        intent = new Intent();
                        intent.putExtra("rawUrl", z.this.link);
                        a.gkE.i(intent, z.this.crP);
                        AppMethodBeat.o(38275);
                        return;
                    }
                    AppMethodBeat.o(38275);
                }
            });
        }
        this.rih = (CdnImageView) this.jAp.findViewById(R.id.d11);
        this.gne = (TextView) this.jAp.findViewById(R.id.d13);
        this.rii = (TextView) this.jAp.findViewById(R.id.d14);
        if (!(this.mog || this.rjD)) {
            boolean z;
            if (this.qNQ == null || bo.isNullOrNil(this.qNQ.uaa)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.jAp.findViewById(R.id.c9m).setVisibility(8);
                if (bo.isNullOrNil(this.title)) {
                    this.gne.setText(this.title);
                } else {
                    this.gne.setText(au.ZI(this.link));
                }
                if (bo.isNullOrNil(this.rid)) {
                    this.rih.setVisibility(0);
                    this.rih.setUrl(this.rid);
                } else if (!bo.cb(this.rie)) {
                    this.rih.setVisibility(0);
                    this.fru = com.tencent.mm.sdk.platformtools.d.bQ(this.rie);
                    this.rih.setImageBitmap(this.fru);
                    this.rjA = true;
                } else if (bo.isNullOrNil(this.rjU)) {
                    this.rih.setImageResource(R.raw.app_attach_file_icon_webpage);
                    this.rih.setVisibility(0);
                } else {
                    this.rih.setImageResource(R.raw.note_sns_link_default);
                    this.rih.setVisibility(0);
                }
                i.b(this.rih, this.crP);
                view = this.jAp;
                AppMethodBeat.o(38277);
                return view;
            }
        }
        this.jAp.findViewById(R.id.c9m).setVisibility(0);
        if (bo.isNullOrNil(this.title)) {
        }
        if (bo.isNullOrNil(this.rid)) {
        }
        i.b(this.rih, this.crP);
        view = this.jAp;
        AppMethodBeat.o(38277);
        return view;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ax axVar;
        String str3;
        AppMethodBeat.i(38278);
        if (this.rjD) {
            axVar = new ax(4);
        } else if (this.mog) {
            axVar = new ax(5);
        } else if (this.rjE) {
            axVar = new ax(25);
            axVar.qNK.xfO.username = this.rjP;
            axVar.qNK.xfO.path = this.rjQ;
        } else if (this.rjO == 11) {
            axVar = new ax(18);
            cfg cfg = new cfg();
            cfg.fiJ = this.rjS;
            cfg.fiI = this.title;
            cfg.fiG = this.link;
            cfg.fiK = this.rjT;
            cfg.fiH = this.rjR;
            cfg.fiL = this.rid;
            cfg.fiM = this.fiM;
            cfg.fiN = this.fiN;
            axVar.qNP = cfg;
            axVar.qNK.xfN = cfg;
        } else if (this.rjO == 15) {
            axVar = new ax(26);
            axVar.qNK.xfI.wbM = this.rjU;
        } else if (this.rjO != 16 || this.qNQ == null) {
            axVar = new ax(3);
        } else {
            axVar = new ax(3);
            cvi cvi = this.qNQ;
            if (cvi != null) {
                axVar.qNQ = cvi;
            }
        }
        pInt.value = axVar.aPA;
        if (i3 > a.qFE) {
            axVar.Dd(4);
        }
        if (this.rie == null) {
            o.ahk();
            Bitmap kR = c.kR(this.rid);
            if (!(kR == null || kR.isRecycled())) {
                ab.i("MicroMsg.LinkWidget", "create bitmap %d %d", Integer.valueOf(com.tencent.mm.sdk.platformtools.d.a(kR, 150, 150, false, false).getHeight()), Integer.valueOf(com.tencent.mm.sdk.platformtools.d.a(kR, 150, 150, false, false).getWidth()));
                this.rie = com.tencent.mm.sdk.platformtools.d.ai(kR);
            }
        }
        axVar.Yr(this.title).Yp(this.link).Yq(this.link).Ym(str);
        if (this.rjO == 15) {
            axVar.Yp(bo.bc(this.crP.getIntent().getStringExtra("fav_note_link_description"), ""));
        }
        if (this.rjD) {
            if (!axVar.a(this.rie, this.link, this.link, this.link, 3, "", "")) {
            }
        } else if (this.mog) {
            WXVideoObject wXVideoObject;
            if (this.rjH != null) {
                wXVideoObject = (WXVideoObject) this.rjH.mediaObject;
            } else {
                wXVideoObject = null;
            }
            axVar.a(this.rie, this.link, wXVideoObject == null ? this.link : bo.bc(wXVideoObject.videoLowBandUrl, this.link), wXVideoObject == null ? this.link : bo.bc(wXVideoObject.videoUrl, this.link), 4, bo.bc(this.title, ""), bo.bc(this.rjJ, ""));
        } else if (!bo.isNullOrNil(this.rjB)) {
            str3 = this.rjB;
            String str4 = "";
            String str5 = "";
            int i6 = this.w;
            int i7 = this.h;
            bau ag = ax.ag("", str3, str3);
            if (ag == null) {
                ab.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            } else {
                ag.Desc = str4;
                if (i6 > 0 && i7 > 0) {
                    baw baw = new baw();
                    baw.wFy = (float) i7;
                    baw.wFx = (float) i6;
                    ag.wEK = baw;
                }
                if (!bo.isNullOrNil(str5)) {
                    ag.Title = str5;
                }
                if (!bo.isNullOrNil(str4)) {
                    ag.Desc = str4;
                }
                axVar.qNK.xfI.wbK.add(ag);
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
                    ab.i("MicroMsg.LinkWidget", "isPngThumbData");
                    byte[] bj = e.bj(this.rie);
                    if (bj != null && bj.length > 0) {
                        ab.i("MicroMsg.LinkWidget", "use covert data");
                        this.rie = e.bj(bj);
                    }
                }
            }
            axVar.b(this.rie, "", "");
        }
        axVar.Dh(this.rig);
        axVar.Yu(this.cMg);
        axVar.Yv(this.rif);
        axVar.qNK.rjC = bo.nullAsNil(this.rjC);
        ab.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", str3);
        axVar.Df(i);
        if (z) {
            axVar.Di(1);
        } else {
            axVar.Di(0);
        }
        axVar.dg(list2);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List Zn = t.Zn();
            for (String str32 : list) {
                if (!Zn.contains(str32)) {
                    cco cco = new cco();
                    cco.jBB = str32;
                    linkedList.add(cco);
                }
            }
        }
        if (iVar != null) {
            axVar.gc(iVar.token, iVar.wFn);
        }
        axVar.ar(linkedList);
        if (!bo.isNullOrNil(this.appId)) {
            axVar.Ys(this.appId);
        }
        if (!bo.isNullOrNil(this.appName)) {
            axVar.Yt(bo.bc(this.appName, ""));
        }
        if (this.rjF) {
            axVar.Dh(5);
        }
        axVar.a(ayt);
        if (this.rjG && this.rjH != null) {
            axVar.Yn(this.rjH.mediaTagName);
            axVar.af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
        }
        axVar.Yo(str2);
        axVar.g(this.rjK, this.rjL, this.cMl, i4, i5);
        axVar.qNL.cMm = this.cMm;
        axVar.setSessionId(this.hcl);
        axVar.qNK.fgt = this.rjM;
        int commit = axVar.commit();
        if (this.rim != null) {
            this.rim.ma(commit);
            g.qTp.c(this.rim);
        }
        if (this.rjN != null) {
            this.rjN.ma(commit);
            h.qTp.c(this.rjN);
            this.rjN.ajK();
        }
        af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.o(38278);
        return false;
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38279);
        if (!(this.fru == null || this.fru.isRecycled() || !this.rjA)) {
            this.fru.recycle();
        }
        AppMethodBeat.o(38279);
        return false;
    }
}
