package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.d.i;

public final class ag extends a {
    private String appId;
    private String appName;
    MMActivity crP;
    private String hcl;
    private int rig;
    private com.tencent.mm.modelsns.b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkC;
    private boolean rkD = false;
    b rlP = new b();
    v rlQ;
    Map<String, com.tencent.mm.compatible.util.Exif.a> rlR = new HashMap();
    private Map<String, cbv> rlS = new HashMap();
    private int rlT = 0;
    private boolean rlU = false;
    ayt rlV;

    class b {
        ArrayList<String> rma = new ArrayList();
        Map<String, Boolean> rmb = new HashMap();
        Map<String, Integer> rmc = new HashMap();

        b() {
            AppMethodBeat.i(38488);
            AppMethodBeat.o(38488);
        }

        public final b q(String str, int i, boolean z) {
            AppMethodBeat.i(38489);
            this.rma.add(str);
            this.rmc.put(str, Integer.valueOf(i));
            this.rmb.put(str, Boolean.valueOf(z));
            AppMethodBeat.o(38489);
            return this;
        }

        public final void S(ArrayList<String> arrayList) {
            AppMethodBeat.i(38490);
            this.rmb.clear();
            if (arrayList == null) {
                this.rma = new ArrayList();
                AppMethodBeat.o(38490);
                return;
            }
            this.rma = arrayList;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.rmb.put((String) it.next(), Boolean.FALSE);
            }
            AppMethodBeat.o(38490);
        }

        public final String toString() {
            AppMethodBeat.i(38491);
            String str = "";
            Iterator it = this.rma.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = (String) it.next();
                    int i = 0;
                    if (this.rmc != null) {
                        i = ((Integer) this.rmc.get(str)).intValue();
                    }
                    str = str2 + str + "," + i + ";";
                } else {
                    AppMethodBeat.o(38491);
                    return str2;
                }
            }
        }

        public final b ZC(String str) {
            AppMethodBeat.i(38492);
            try {
                for (String split : str.split(";")) {
                    String[] split2 = split.split(",");
                    this.rma.add(split2[0]);
                    this.rmc.put(split2[0], Integer.valueOf(bo.getInt(split2[1], 0)));
                }
            } catch (Exception e) {
            }
            AppMethodBeat.o(38492);
            return this;
        }
    }

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog ehJ = null;
        private ax rkO;
        private List<com.tencent.mm.plugin.sns.data.h> rlX;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(38486);
            super.onPostExecute((Boolean) obj);
            this.ehJ.dismiss();
            ag.this.a(this.rkO);
            AppMethodBeat.o(38486);
        }

        public a(ax axVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            AppMethodBeat.i(38484);
            this.rkO = axVar;
            this.rlX = list;
            Context context = ag.this.crP;
            ag.this.crP.getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b(context, ag.this.crP.getString(R.string.re), false, new OnCancelListener(ag.this) {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(38484);
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(38485);
            com.tencent.mm.sdk.g.b.a cns = af.cns();
            AppMethodBeat.o(38485);
            return cns;
        }

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(38487);
            long currentTimeMillis = System.currentTimeMillis();
            ax axVar = this.rkO;
            axVar.dh(this.rlX);
            this.rkO = axVar;
            ab.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(38487);
            return bool;
        }
    }

    public ag(MMActivity mMActivity) {
        AppMethodBeat.i(38493);
        this.crP = mMActivity;
        AppMethodBeat.o(38493);
    }

    public final void M(Bundle bundle) {
        String str;
        AppMethodBeat.i(38494);
        this.rim = com.tencent.mm.modelsns.b.u(this.crP.getIntent());
        this.rkD = this.crP.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rlU = this.crP.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hcl = bo.bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
        this.rkC = this.crP.getIntent().getStringExtra("KSessionID");
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
        }
        String stringExtra = this.crP.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.crP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.rjH != null && this.rjH.mediaObject != null && (this.rjH.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.rjH.mediaObject).imageData;
        }
        if (!bo.isNullOrNil(stringExtra) || bo.cb(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = af.getAccSnsTmpPath() + g.x((" " + System.currentTimeMillis()).getBytes());
            e.deleteFile(stringExtra);
            e.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.crP.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        O(bundle);
        boolean O = O(this.crP.getIntent().getExtras());
        this.rlT = 0;
        if (bo.isNullOrNil(stringExtra)) {
            ArrayList stringArrayListExtra = this.crP.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            com.tencent.mm.compatible.util.Exif.a location;
            if (bo.ek(stringArrayListExtra)) {
                if (!bo.isNullOrNil(str)) {
                    int i;
                    String str2 = af.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.x(str.getBytes());
                    e.tf(e.atb(str2));
                    e.y(str, str2);
                    if (intExtra == -1) {
                        i = 0;
                    } else {
                        i = intExtra;
                    }
                    this.rlP.q(str2, i, this.rkD);
                    if (!O) {
                        location = Exif.fromFile(str).getLocation();
                        if (location != null) {
                            this.rlR.put(str2, location);
                        }
                    }
                    try {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                        cbv cbv = new cbv();
                        cbv.xbo = this.rkD ? 1 : 2;
                        cbv.xbq = bVar.lastModified() / 1000;
                        cbv.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rlS.put(str2, cbv);
                        AppMethodBeat.o(38494);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
                AppMethodBeat.o(38494);
                return;
            }
            Iterator it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                ab.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(str)));
                this.rlP.q(str, intExtra, false);
                if (!O) {
                    location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rlR.put(str, location);
                    }
                }
                try {
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str);
                    cbv cbv2 = new cbv();
                    cbv2.xbo = this.rkD ? 1 : 2;
                    cbv2.xbq = bVar2.lastModified() / 1000;
                    cbv2.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                    this.rlS.put(str, cbv2);
                } catch (Exception e2) {
                    ab.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
                }
            }
            AppMethodBeat.o(38494);
            return;
        }
        this.rlP.ZC(stringExtra);
        AppMethodBeat.o(38494);
    }

    public final int css() {
        AppMethodBeat.i(38495);
        int size = this.rlP.rma.size();
        AppMethodBeat.o(38495);
        return size;
    }

    private boolean O(Bundle bundle) {
        AppMethodBeat.i(38496);
        if (bundle == null) {
            AppMethodBeat.o(38496);
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            AppMethodBeat.o(38496);
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split(IOUtils.LINE_SEPARATOR_UNIX);
            if (3 != split.length) {
                ab.e("MicroMsg.PicWidget", "invalid params");
                AppMethodBeat.o(38496);
                return true;
            }
            try {
                this.rlR.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(bo.getDouble(split[1], 0.0d), bo.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.PicWidget", e.toString());
            }
        }
        AppMethodBeat.o(38496);
        return true;
    }

    public final void N(Bundle bundle) {
        AppMethodBeat.i(38497);
        bundle.putString("sns_kemdia_path_list", this.rlP.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.rlR.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
        AppMethodBeat.o(38497);
    }

    public final boolean crG() {
        AppMethodBeat.i(38498);
        if (this.rlP != null) {
            boolean z;
            b bVar = this.rlP;
            if (bVar.rma == null || bVar.rma.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(38498);
                return true;
            }
        }
        AppMethodBeat.o(38498);
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        AppMethodBeat.i(38499);
        if (this.rlQ == null) {
            boolean z;
            MMActivity mMActivity = this.crP;
            ArrayList arrayList = this.rlP.rma;
            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.sns.ui.v.a() {
                public final void DO(int i) {
                    AppMethodBeat.i(38476);
                    ab.d("MicroMsg.PicWidget", "I click");
                    if (i < 0) {
                        ag.this.cst();
                        AppMethodBeat.o(38476);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(ag.this.crP, SnsUploadBrowseUI.class);
                    intent.putExtra("sns_gallery_position", i);
                    intent.putExtra("sns_gallery_temp_paths", ag.this.rlP.rma);
                    ag.this.crP.startActivityForResult(intent, 7);
                    AppMethodBeat.o(38476);
                }
            };
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a() {
                public final void fu(int i, int i2) {
                    AppMethodBeat.i(38477);
                    b bVar = ag.this.rlP;
                    if (i != i2 && bVar.rma.size() > i) {
                        String str = (String) bVar.rma.remove(i);
                        if (i2 < bVar.rma.size()) {
                            bVar.rma.add(i2, str);
                        } else {
                            bVar.rma.add(str);
                        }
                    }
                    ag.this.crP.getIntent().putExtra("sns_kemdia_path_list", ag.this.rlP.rma);
                    AppMethodBeat.o(38477);
                }

                public final void removeItem(int i) {
                    AppMethodBeat.i(38478);
                    b bVar = ag.this.rlP;
                    if (bVar.rma.size() > i) {
                        bVar.rma.remove(i);
                    }
                    if (ag.this.crP instanceof SnsUploadUI) {
                        ((SnsUploadUI) ag.this.crP).cuE();
                    }
                    ag.this.crP.getIntent().putExtra("sns_kemdia_path_list", ag.this.rlP.rma);
                    ((com.tencent.mm.plugin.sns.ui.previewimageview.e) ag.this.rlQ).Eu(ag.this.rlP.rma.size());
                    AppMethodBeat.o(38478);
                }
            };
            if (this.rlU) {
                z = false;
            } else {
                z = true;
            }
            this.rlQ = new com.tencent.mm.plugin.sns.ui.previewimageview.e(view, view2, view3, mMActivity, arrayList, dynamicGridView, anonymousClass1, anonymousClass2, z);
        } else {
            this.rlQ.setList$22875ea3(this.rlP.rma);
        }
        View view4 = this.rlQ.getView();
        AppMethodBeat.o(38499);
        return view4;
    }

    public final View crH() {
        AppMethodBeat.i(38500);
        this.rlQ = new PreviewImageView(this.crP);
        if (this.rlU) {
            this.rlQ.setIsShowAddImage(false);
        }
        this.rlQ.setImageClick(new com.tencent.mm.plugin.sns.ui.v.a() {
            public final void DO(int i) {
                AppMethodBeat.i(38479);
                ab.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    ag.this.cst();
                    AppMethodBeat.o(38479);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(ag.this.crP, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", ag.this.rlP.rma);
                ag.this.crP.startActivityForResult(intent, 7);
                AppMethodBeat.o(38479);
            }
        });
        this.rlQ.setList$22875ea3(this.rlP.rma);
        View view = this.rlQ.getView();
        AppMethodBeat.o(38500);
        return view;
    }

    private static ax a(ax axVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        AppMethodBeat.i(38501);
        axVar.dh(list);
        AppMethodBeat.o(38501);
        return axVar;
    }

    /* Access modifiers changed, original: final */
    public final void a(ax axVar) {
        AppMethodBeat.i(38502);
        int commit = axVar.commit();
        if (this.rim != null) {
            this.rim.ma(commit);
            com.tencent.mm.plugin.sns.i.g.qTp.c(this.rim);
        }
        if (!(this.rlP == null || this.rlP.rma == null || !s.crt())) {
            com.tencent.mm.plugin.report.service.h.pYm.e(12834, Integer.valueOf(this.rlP.rma.size()));
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.crP.setResult(-1, intent);
        this.crP.finish();
        AppMethodBeat.o(38502);
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        String str3;
        AppMethodBeat.i(38503);
        LinkedList<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.rlP.rma.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            boolean z2;
            str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.qFY = i;
            if (i6 == 0) {
                hVar.qFX = i2;
                if (iVar != null) {
                    hVar.qFZ = iVar.token;
                    hVar.qGa = iVar.wFn;
                }
            } else {
                hVar.qFX = 0;
            }
            int i7 = i6 + 1;
            b bVar = this.rlP;
            if (bVar.rmc.containsKey(str3)) {
                i6 = ((Integer) bVar.rmc.get(str3)).intValue();
            } else {
                i6 = 0;
            }
            hVar.filterId = i6;
            hVar.desc = str;
            bVar = this.rlP;
            if (bo.isNullOrNil(str3) || !bVar.rmb.containsKey(str3)) {
                z2 = false;
            } else {
                z2 = ((Boolean) bVar.rmb.get(str3)).booleanValue();
            }
            hVar.qGc = z2;
            linkedList.add(hVar);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List Zn = t.Zn();
            for (String str32 : list) {
                if (!Zn.contains(str32)) {
                    cco cco = new cco();
                    cco.jBB = str32;
                    linkedList2.add(cco);
                }
            }
        }
        ax axVar = new ax(1);
        pInt.value = axVar.aPA;
        if (iVar != null) {
            axVar.gc(iVar.token, iVar.wFn);
        }
        if (i3 > com.tencent.mm.plugin.sns.c.a.qFE) {
            axVar.Dd(3);
        }
        axVar.Ym(str).a(ayt).ar(linkedList2).Df(i).Dg(i2);
        if (z) {
            axVar.Di(1);
        } else {
            axVar.Di(0);
        }
        if (!bo.isNullOrNil(this.appId)) {
            axVar.Ys(this.appId);
        }
        if (!bo.isNullOrNil(this.appName)) {
            axVar.Yt(bo.bc(this.appName, ""));
        }
        axVar.Dh(this.rig);
        if (this.rjF) {
            axVar.Dh(5);
        }
        if (this.rjG && this.rjH != null) {
            axVar.Yn(this.rjH.mediaTagName);
            axVar.af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
        }
        axVar.g(null, null, null, i4, i5);
        axVar.dg(list2);
        axVar.setSessionId(this.hcl);
        if (!(ayt == null || ayt.score == 0)) {
            i6 = ayt.score;
            String str4 = ayt.wCC;
            axVar.qNL.wFw = new cap();
            axVar.qNL.wFw.wZS = i6;
            axVar.qNL.wFw.wZP = str4;
        }
        ab.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.rlT));
        com.tencent.mm.plugin.report.service.h.pYm.e(11602, Integer.valueOf(this.rlT), Integer.valueOf(linkedList.size()));
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            ab.i("MicroMsg.PicWidget", "commit path  %s len: %d", hVar2.path, Long.valueOf(e.asZ(hVar2.path)));
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            cbv cbv;
            String str5 = hVar22.path;
            cbv cbv2 = (cbv) this.rlS.get(str5);
            if (cbv2 == null) {
                cbv = new cbv();
            } else {
                cbv = cbv2;
            }
            if (this.rlV == null || (this.rlV.vRq == 0.0f && this.rlV.vRp == 0.0f)) {
                cbv.xbm = -1000.0f;
                cbv.xbn = -1000.0f;
            } else {
                cbv.xbm = this.rlV.vRq;
                cbv.xbn = this.rlV.vRp;
                cbv.rkk = this.rlV.rkk;
                cbv.bEJ = this.rlV.bEJ;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.rlR.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                cbv.xbk = -1000.0f;
                cbv.xbl = -1000.0f;
            } else {
                cbv.xbk = (float) aVar.latitude;
                cbv.xbl = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + axVar.qNL.wFr.size());
            stringBuffer.append("||item poi lat " + cbv.xbm + " " + cbv.xbn);
            stringBuffer.append("||item pic lat " + cbv.xbk + " " + cbv.xbl);
            stringBuffer.append("||item exitime:" + cbv.xbp + " filetime: " + cbv.xbq);
            stringBuffer.append("||item source: " + cbv.xbo);
            ab.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            axVar.qNL.wFr.add(cbv);
        }
        if (linkedList.size() <= 1) {
            a(axVar, linkedList);
            a(axVar);
        } else {
            new a(axVar, linkedList).u("");
        }
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38480);
                long currentTimeMillis = System.currentTimeMillis();
                for (String str : ag.this.rlP.rma) {
                    int i;
                    Exif fromFile = Exif.fromFile(str);
                    int i2 = (fromFile.latitude < 0.0d || fromFile.longitude < 0.0d) ? 0 : 1;
                    String str2 = fromFile.model;
                    int i3 = fromFile.imageWidth;
                    int i4 = fromFile.imageHeight;
                    if (i3 <= 0 || i4 <= 0) {
                        Options options = new Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(str, options);
                        i4 = options.outWidth;
                        i = options.outHeight;
                        i3 = i4;
                    } else {
                        i = i4;
                    }
                    i4 = (int) fromFile.getUxtimeDatatimeOriginal();
                    com.tencent.mm.plugin.report.service.h.pYm.e(15523, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4));
                }
                ab.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(38480);
            }
        });
        AppMethodBeat.o(38503);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cst() {
        AppMethodBeat.i(38504);
        com.tencent.mm.kernel.g.RQ();
        if (!com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            com.tencent.mm.ui.base.t.hO(this.crP);
            AppMethodBeat.o(38504);
            return false;
        } else if (this.rlP.rma.size() >= 9) {
            com.tencent.mm.ui.base.h.g(this.crP, R.string.eqf, R.string.tz);
            AppMethodBeat.o(38504);
            return false;
        } else {
            try {
                ax axVar = new ax(this.crP);
                axVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(38481);
                        if (!ae.gjt) {
                            lVar.e(0, ag.this.crP.getString(R.string.q4));
                        }
                        lVar.e(1, ag.this.crP.getString(R.string.qa));
                        AppMethodBeat.o(38481);
                    }
                };
                axVar.rBm = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(38482);
                        int size;
                        switch (menuItem.getItemId()) {
                            case 0:
                                ag agVar = ag.this;
                                size = 9 - agVar.rlP.rma.size();
                                if (size <= 0) {
                                    ab.e("MicroMsg.PicWidget", "has select the max image count");
                                    AppMethodBeat.o(38482);
                                    return;
                                }
                                if (size < 9) {
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2));
                                    n.a(agVar.crP, 11, new Intent(), 2, 2);
                                } else {
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2));
                                    n.a(agVar.crP, 11, new Intent(), 2, 0);
                                }
                                agVar.DR(1);
                                AppMethodBeat.o(38482);
                                return;
                            case 1:
                                size = 9 - ag.this.rlP.rma.size();
                                if (size > 0) {
                                    String string = ag.this.crP.getSharedPreferences(ah.doA(), 0).getString("gallery", "1");
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(2), Integer.valueOf(2));
                                    if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        n.aj(ag.this.crP);
                                    } else if (size < 9) {
                                        n.a(ag.this.crP, 9, size, 4, 1, null);
                                    } else {
                                        n.a(ag.this.crP, 9, size, 4, 3, null);
                                    }
                                    ag.this.DR(2);
                                    break;
                                }
                                ab.e("MicroMsg.PicWidget", "has select the max image count");
                                AppMethodBeat.o(38482);
                                return;
                        }
                        AppMethodBeat.o(38482);
                    }
                };
                axVar.cuu();
            } catch (Exception e) {
            }
            AppMethodBeat.o(38504);
            return true;
        }
    }

    public final boolean d(List<String> list, int i, boolean z) {
        AppMethodBeat.i(38505);
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.PicWidget", "no image selected");
            AppMethodBeat.o(38505);
            return true;
        } else if (this.rlP.rma.size() >= 9) {
            AppMethodBeat.o(38505);
            return true;
        } else {
            for (String str : list) {
                if (e.ct(str)) {
                    String str2 = "pre_temp_sns_pic" + g.x((str + System.currentTimeMillis()).getBytes());
                    s.aj(af.getAccSnsTmpPath(), str, str2);
                    ab.d("MicroMsg.PicWidget", "newPath " + af.getAccSnsTmpPath() + str2);
                    this.rlP.q(af.getAccSnsTmpPath() + str2, i, z);
                    ((com.tencent.mm.plugin.sns.ui.previewimageview.e) this.rlQ).Eu(this.rlP.rma.size());
                    this.rlQ.setList$22875ea3(this.rlP.rma);
                    this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                    try {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                        cbv cbv = new cbv();
                        cbv.xbo = z ? 1 : 2;
                        cbv.xbq = bVar.lastModified() / 1000;
                        cbv.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rlS.put(af.getAccSnsTmpPath() + str2, cbv);
                    } catch (Exception e) {
                        ab.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rlR.put(af.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
            AppMethodBeat.o(38505);
            return true;
        }
    }

    public final boolean f(int i, Intent intent) {
        AppMethodBeat.i(38506);
        String h;
        String x;
        boolean d;
        String stringExtra;
        String cz;
        switch (i) {
            case 2:
                ab.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    AppMethodBeat.o(38506);
                    return false;
                }
                ab.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.gkE.a(this.crP, intent, intent2, af.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a() {
                    public final String ZB(String str) {
                        AppMethodBeat.i(38483);
                        String str2 = af.getAccSnsTmpPath() + g.x((str + System.currentTimeMillis()).getBytes());
                        AppMethodBeat.o(38483);
                        return str2;
                    }
                });
                AppMethodBeat.o(38506);
                return true;
            case 3:
                ab.d("MicroMsg.PicWidget", "onActivityResult 2");
                h = n.h(this.crP.getApplicationContext(), intent, af.getAccSnsTmpPath());
                if (h == null) {
                    AppMethodBeat.o(38506);
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", h);
                x = g.x((h + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", af.getAccSnsTmpPath() + x);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(h).getLocation();
                if (location != null) {
                    this.rlR.put(af.getAccSnsTmpPath() + x, location);
                    ab.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", Double.valueOf(location.latitude), Double.valueOf(location.longitude));
                }
                cbv cbv = new cbv();
                cbv.xbo = 1;
                cbv.xbq = System.currentTimeMillis();
                cbv.xbp = bo.anl(Exif.fromFile(h).dateTime);
                this.rlS.put(af.getAccSnsTmpPath() + x, cbv);
                com.tencent.mm.plugin.sns.c.a.gkE.a(this.crP, intent3, 4);
                this.rkD = true;
                AppMethodBeat.o(38506);
                return true;
            case 4:
                ab.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    AppMethodBeat.o(38506);
                    return true;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                ab.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath ".concat(String.valueOf(h)));
                if (h == null) {
                    AppMethodBeat.o(38506);
                    return true;
                } else if (!e.ct(h)) {
                    AppMethodBeat.o(38506);
                    return true;
                } else if (this.rlP.rma.size() >= 9) {
                    AppMethodBeat.o(38506);
                    return true;
                } else {
                    int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                    x = "pre_temp_sns_pic" + g.x((h + System.currentTimeMillis()).getBytes());
                    ab.i("MicroMsg.PicWidget", "onactivity result " + e.asZ(h) + " " + h);
                    e.y(h, af.getAccSnsTmpPath() + x);
                    if (this.rlR.containsKey(h)) {
                        this.rlR.put(af.getAccSnsTmpPath() + x, this.rlR.get(h));
                    }
                    h = af.getAccSnsTmpPath() + x;
                    ab.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(h)));
                    this.rlP.q(h, intExtra, false);
                    this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                    ((com.tencent.mm.plugin.sns.ui.previewimageview.e) this.rlQ).Eu(this.rlP.rma.size());
                    this.rlQ.setList$22875ea3(this.rlP.rma);
                    AppMethodBeat.o(38506);
                    return true;
                }
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(38506);
                    return true;
                }
                this.rlP.S(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                ((com.tencent.mm.plugin.sns.ui.previewimageview.e) this.rlQ).Eu(this.rlP.rma.size());
                this.rlQ.setList$22875ea3(this.rlP.rma);
                this.rlT = intent.getIntExtra("sns_update_preview_image_count", 0);
                AppMethodBeat.o(38506);
                return true;
            case 9:
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                    d = d(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
                    AppMethodBeat.o(38506);
                    return d;
                }
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                x = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (bo.isNullOrNil(x) || !e.ct(x)) {
                    x = af.getAccSnsTmpPath() + g.cz(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            ab.e("MicroMsg.PicWidget", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        }
                        ab.i("MicroMsg.PicWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, x, true);
                        Options amj = com.tencent.mm.sdk.platformtools.d.amj(x);
                        ab.i("MicroMsg.PicWidget", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        ab.e("MicroMsg.PicWidget", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.o(38506);
                    }
                }
                ab.i("MicroMsg.PicWidget", "video path %s thumb path %s and %s %s ", stringExtra, x, Long.valueOf(e.asZ(stringExtra)), Long.valueOf(e.asZ(x)));
                cz = g.cz(stringExtra);
                if (this.crP instanceof SnsUploadUI) {
                    ((SnsUploadUI) this.crP).a(stringExtra, x, cz, null, false);
                    ((SnsUploadUI) this.crP).cuF();
                }
                AppMethodBeat.o(38506);
                return true;
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        h = sightCaptureResult.osI;
                        if (!bo.isNullOrNil(h)) {
                            d = d(Collections.singletonList(h), 0, true);
                            AppMethodBeat.o(38506);
                            return d;
                        }
                    }
                    stringExtra = sightCaptureResult.osC;
                    x = sightCaptureResult.osD;
                    byte[] bArr = null;
                    this.crP.getIntent().putExtra("KSightThumbPath", sightCaptureResult.osD);
                    if (bo.isNullOrNil(sightCaptureResult.osF)) {
                        cz = g.cz(stringExtra);
                    } else {
                        cz = sightCaptureResult.osF;
                    }
                    try {
                        bArr = sightCaptureResult.osH.toByteArray();
                    } catch (Exception e32) {
                        ab.i("MicroMsg.PicWidget", "put sight extinfo to snsuploadui error: %s", e32.getMessage());
                    }
                    if (this.crP instanceof SnsUploadUI) {
                        ((SnsUploadUI) this.crP).a(stringExtra, x, cz, bArr, true);
                        ((SnsUploadUI) this.crP).cuF();
                    }
                    AppMethodBeat.o(38506);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(38506);
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38507);
        if (this.rlQ != null) {
            this.rlQ.clean();
        }
        this.rlR.clear();
        this.rlS.clear();
        AppMethodBeat.o(38507);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void DR(int i) {
        AppMethodBeat.i(38508);
        com.tencent.mm.g.b.a.ag Fr = new com.tencent.mm.g.b.a.ag().Fr();
        Fr.cYH = (long) i;
        Fr.fj(this.rkC).ajK();
        AppMethodBeat.o(38508);
    }
}
