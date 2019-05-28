package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.compatible.util.Exif.C1440a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p232b.p233a.C32660ag;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C36338a.C15946a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C21881h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.model.C39759h;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.plugin.sns.p520ui.C43611v.C22145a;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.C13702c.C4087a;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.C4088e;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.DynamicGridView;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cap;
import com.tencent.p177mm.protocal.protobuf.cbv;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ag */
public final class C29181ag extends C4015a {
    private String appId;
    private String appName;
    MMActivity crP;
    private String hcl;
    private int rig;
    private C37952b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkC;
    private boolean rkD = false;
    C13624b rlP = new C13624b();
    C43611v rlQ;
    Map<String, C1440a> rlR = new HashMap();
    private Map<String, cbv> rlS = new HashMap();
    private int rlT = 0;
    private boolean rlU = false;
    ayt rlV;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$b */
    class C13624b {
        ArrayList<String> rma = new ArrayList();
        Map<String, Boolean> rmb = new HashMap();
        Map<String, Integer> rmc = new HashMap();

        C13624b() {
            AppMethodBeat.m2504i(38488);
            AppMethodBeat.m2505o(38488);
        }

        /* renamed from: q */
        public final C13624b mo25831q(String str, int i, boolean z) {
            AppMethodBeat.m2504i(38489);
            this.rma.add(str);
            this.rmc.put(str, Integer.valueOf(i));
            this.rmb.put(str, Boolean.valueOf(z));
            AppMethodBeat.m2505o(38489);
            return this;
        }

        /* renamed from: S */
        public final void mo25829S(ArrayList<String> arrayList) {
            AppMethodBeat.m2504i(38490);
            this.rmb.clear();
            if (arrayList == null) {
                this.rma = new ArrayList();
                AppMethodBeat.m2505o(38490);
                return;
            }
            this.rma = arrayList;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.rmb.put((String) it.next(), Boolean.FALSE);
            }
            AppMethodBeat.m2505o(38490);
        }

        public final String toString() {
            AppMethodBeat.m2504i(38491);
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
                    AppMethodBeat.m2505o(38491);
                    return str2;
                }
            }
        }

        /* renamed from: ZC */
        public final C13624b mo25830ZC(String str) {
            AppMethodBeat.m2504i(38492);
            try {
                for (String split : str.split(";")) {
                    String[] split2 = split.split(",");
                    this.rma.add(split2[0]);
                    this.rmc.put(split2[0], Integer.valueOf(C5046bo.getInt(split2[1], 0)));
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(38492);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$6 */
    class C220566 implements C5279d {
        C220566() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(38482);
            int size;
            switch (menuItem.getItemId()) {
                case 0:
                    C29181ag c29181ag = C29181ag.this;
                    size = 9 - c29181ag.rlP.rma.size();
                    if (size <= 0) {
                        C4990ab.m7412e("MicroMsg.PicWidget", "has select the max image count");
                        AppMethodBeat.m2505o(38482);
                        return;
                    }
                    if (size < 9) {
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2));
                        C14987n.m23302a(c29181ag.crP, 11, new Intent(), 2, 2);
                    } else {
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2));
                        C14987n.m23302a(c29181ag.crP, 11, new Intent(), 2, 0);
                    }
                    c29181ag.mo47349DR(1);
                    AppMethodBeat.m2505o(38482);
                    return;
                case 1:
                    size = 9 - C29181ag.this.rlP.rma.size();
                    if (size > 0) {
                        String string = C29181ag.this.crP.getSharedPreferences(C4996ah.doA(), 0).getString("gallery", "1");
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(2), Integer.valueOf(2));
                        if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            C14987n.m23306aj(C29181ag.this.crP);
                        } else if (size < 9) {
                            C14987n.m23295a(C29181ag.this.crP, 9, size, 4, 1, null);
                        } else {
                            C14987n.m23295a(C29181ag.this.crP, 9, size, 4, 3, null);
                        }
                        C29181ag.this.mo47349DR(2);
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.PicWidget", "has select the max image count");
                    AppMethodBeat.m2505o(38482);
                    return;
            }
            AppMethodBeat.m2505o(38482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$7 */
    class C220577 implements C15946a {
        C220577() {
        }

        /* renamed from: ZB */
        public final String mo25777ZB(String str) {
            AppMethodBeat.m2504i(38483);
            String str2 = C13373af.getAccSnsTmpPath() + C1178g.m2591x((str + System.currentTimeMillis()).getBytes());
            AppMethodBeat.m2505o(38483);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$1 */
    class C248311 extends C22145a {
        C248311() {
        }

        /* renamed from: DO */
        public final void mo37706DO(int i) {
            AppMethodBeat.m2504i(38476);
            C4990ab.m7410d("MicroMsg.PicWidget", "I click");
            if (i < 0) {
                C29181ag.this.cst();
                AppMethodBeat.m2505o(38476);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(C29181ag.this.crP, SnsUploadBrowseUI.class);
            intent.putExtra("sns_gallery_position", i);
            intent.putExtra("sns_gallery_temp_paths", C29181ag.this.rlP.rma);
            C29181ag.this.crP.startActivityForResult(intent, 7);
            AppMethodBeat.m2505o(38476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$4 */
    class C291824 implements Runnable {
        C291824() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38480);
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : C29181ag.this.rlP.rma) {
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
                C7060h.pYm.mo8381e(15523, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4));
            }
            C4990ab.m7410d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(38480);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$2 */
    class C291832 implements C4087a {
        C291832() {
        }

        /* renamed from: fu */
        public final void mo8949fu(int i, int i2) {
            AppMethodBeat.m2504i(38477);
            C13624b c13624b = C29181ag.this.rlP;
            if (i != i2 && c13624b.rma.size() > i) {
                String str = (String) c13624b.rma.remove(i);
                if (i2 < c13624b.rma.size()) {
                    c13624b.rma.add(i2, str);
                } else {
                    c13624b.rma.add(str);
                }
            }
            C29181ag.this.crP.getIntent().putExtra("sns_kemdia_path_list", C29181ag.this.rlP.rma);
            AppMethodBeat.m2505o(38477);
        }

        public final void removeItem(int i) {
            AppMethodBeat.m2504i(38478);
            C13624b c13624b = C29181ag.this.rlP;
            if (c13624b.rma.size() > i) {
                c13624b.rma.remove(i);
            }
            if (C29181ag.this.crP instanceof SnsUploadUI) {
                ((SnsUploadUI) C29181ag.this.crP).cuE();
            }
            C29181ag.this.crP.getIntent().putExtra("sns_kemdia_path_list", C29181ag.this.rlP.rma);
            ((C4088e) C29181ag.this.rlQ).mo8951Eu(C29181ag.this.rlP.rma.size());
            AppMethodBeat.m2505o(38478);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$3 */
    class C291843 extends C22145a {
        C291843() {
        }

        /* renamed from: DO */
        public final void mo37706DO(int i) {
            AppMethodBeat.m2504i(38479);
            C4990ab.m7410d("MicroMsg.PicWidget", "I click");
            if (i < 0) {
                C29181ag.this.cst();
                AppMethodBeat.m2505o(38479);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(C29181ag.this.crP, SnsUploadBrowseUI.class);
            intent.putExtra("sns_gallery_position", i);
            intent.putExtra("sns_gallery_temp_paths", C29181ag.this.rlP.rma);
            C29181ag.this.crP.startActivityForResult(intent, 7);
            AppMethodBeat.m2505o(38479);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$a */
    class C29185a extends C39759h<String, Integer, Boolean> {
        private ProgressDialog ehJ = null;
        private C29054ax rkO;
        private List<C21881h> rlX;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(38486);
            super.onPostExecute((Boolean) obj);
            this.ehJ.dismiss();
            C29181ag.this.mo47350a(this.rkO);
            AppMethodBeat.m2505o(38486);
        }

        public C29185a(C29054ax c29054ax, List<C21881h> list) {
            AppMethodBeat.m2504i(38484);
            this.rkO = c29054ax;
            this.rlX = list;
            Context context = C29181ag.this.crP;
            C29181ag.this.crP.getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, C29181ag.this.crP.getString(C25738R.string.f9161re), false, new OnCancelListener(C29181ag.this) {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.m2505o(38484);
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(38485);
            C4946a cns = C13373af.cns();
            AppMethodBeat.m2505o(38485);
            return cns;
        }

        /* renamed from: dv */
        public final /* synthetic */ Object mo25905dv() {
            AppMethodBeat.m2504i(38487);
            long currentTimeMillis = System.currentTimeMillis();
            C29054ax c29054ax = this.rkO;
            c29054ax.mo47163dh(this.rlX);
            this.rkO = c29054ax;
            C4990ab.m7410d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.m2505o(38487);
            return bool;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ag$5 */
    class C291875 implements C36073c {
        C291875() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(38481);
            if (!C1947ae.gjt) {
                c44273l.mo70068e(0, C29181ag.this.crP.getString(C25738R.string.f9121q4));
            }
            c44273l.mo70068e(1, C29181ag.this.crP.getString(C25738R.string.f9126qa));
            AppMethodBeat.m2505o(38481);
        }
    }

    public C29181ag(MMActivity mMActivity) {
        AppMethodBeat.m2504i(38493);
        this.crP = mMActivity;
        AppMethodBeat.m2505o(38493);
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(38494);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.rkD = this.crP.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rlU = this.crP.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hcl = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("reportSessionId"), "");
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
        if (!C5046bo.isNullOrNil(stringExtra) || C5046bo.m7540cb(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = C13373af.getAccSnsTmpPath() + C1178g.m2591x((" " + System.currentTimeMillis()).getBytes());
            C5730e.deleteFile(stringExtra);
            C5730e.m8624b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.crP.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        m46355O(bundle);
        boolean O = m46355O(this.crP.getIntent().getExtras());
        this.rlT = 0;
        if (C5046bo.isNullOrNil(stringExtra)) {
            ArrayList stringArrayListExtra = this.crP.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            C1440a location;
            if (C5046bo.m7548ek(stringArrayListExtra)) {
                if (!C5046bo.isNullOrNil(str)) {
                    int i;
                    String str2 = C13373af.getAccSnsTmpPath() + "pre_temp_sns_pic" + C1178g.m2591x(str.getBytes());
                    C5730e.m8643tf(C5730e.atb(str2));
                    C5730e.m8644y(str, str2);
                    if (intExtra == -1) {
                        i = 0;
                    } else {
                        i = intExtra;
                    }
                    this.rlP.mo25831q(str2, i, this.rkD);
                    if (!O) {
                        location = Exif.fromFile(str).getLocation();
                        if (location != null) {
                            this.rlR.put(str2, location);
                        }
                    }
                    try {
                        C5728b c5728b = new C5728b(str);
                        cbv cbv = new cbv();
                        cbv.xbo = this.rkD ? 1 : 2;
                        cbv.xbq = c5728b.lastModified() / 1000;
                        cbv.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rlS.put(str2, cbv);
                        AppMethodBeat.m2505o(38494);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(38494);
                return;
            }
            Iterator it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                C4990ab.m7410d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(str)));
                this.rlP.mo25831q(str, intExtra, false);
                if (!O) {
                    location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rlR.put(str, location);
                    }
                }
                try {
                    C5728b c5728b2 = new C5728b(str);
                    cbv cbv2 = new cbv();
                    cbv2.xbo = this.rkD ? 1 : 2;
                    cbv2.xbq = c5728b2.lastModified() / 1000;
                    cbv2.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                    this.rlS.put(str, cbv2);
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
                }
            }
            AppMethodBeat.m2505o(38494);
            return;
        }
        this.rlP.mo25830ZC(stringExtra);
        AppMethodBeat.m2505o(38494);
    }

    public final int css() {
        AppMethodBeat.m2504i(38495);
        int size = this.rlP.rma.size();
        AppMethodBeat.m2505o(38495);
        return size;
    }

    /* renamed from: O */
    private boolean m46355O(Bundle bundle) {
        AppMethodBeat.m2504i(38496);
        if (bundle == null) {
            AppMethodBeat.m2505o(38496);
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            AppMethodBeat.m2505o(38496);
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split(IOUtils.LINE_SEPARATOR_UNIX);
            if (3 != split.length) {
                C4990ab.m7412e("MicroMsg.PicWidget", "invalid params");
                AppMethodBeat.m2505o(38496);
                return true;
            }
            try {
                this.rlR.put(split[0].trim(), new C1440a(C5046bo.getDouble(split[1], 0.0d), C5046bo.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.PicWidget", e.toString());
            }
        }
        AppMethodBeat.m2505o(38496);
        return true;
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
        AppMethodBeat.m2504i(38497);
        bundle.putString("sns_kemdia_path_list", this.rlP.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.rlR.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((C1440a) entry.getValue()).latitude), Double.valueOf(((C1440a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
        AppMethodBeat.m2505o(38497);
    }

    public final boolean crG() {
        AppMethodBeat.m2504i(38498);
        if (this.rlP != null) {
            boolean z;
            C13624b c13624b = this.rlP;
            if (c13624b.rma == null || c13624b.rma.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.m2505o(38498);
                return true;
            }
        }
        AppMethodBeat.m2505o(38498);
        return false;
    }

    /* renamed from: a */
    public final View mo8861a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        AppMethodBeat.m2504i(38499);
        if (this.rlQ == null) {
            boolean z;
            MMActivity mMActivity = this.crP;
            ArrayList arrayList = this.rlP.rma;
            C248311 c248311 = new C248311();
            C291832 c291832 = new C291832();
            if (this.rlU) {
                z = false;
            } else {
                z = true;
            }
            this.rlQ = new C4088e(view, view2, view3, mMActivity, arrayList, dynamicGridView, c248311, c291832, z);
        } else {
            this.rlQ.setList$22875ea3(this.rlP.rma);
        }
        View view4 = this.rlQ.getView();
        AppMethodBeat.m2505o(38499);
        return view4;
    }

    public final View crH() {
        AppMethodBeat.m2504i(38500);
        this.rlQ = new PreviewImageView(this.crP);
        if (this.rlU) {
            this.rlQ.setIsShowAddImage(false);
        }
        this.rlQ.setImageClick(new C291843());
        this.rlQ.setList$22875ea3(this.rlP.rma);
        View view = this.rlQ.getView();
        AppMethodBeat.m2505o(38500);
        return view;
    }

    /* renamed from: a */
    private static C29054ax m46356a(C29054ax c29054ax, List<C21881h> list) {
        AppMethodBeat.m2504i(38501);
        c29054ax.mo47163dh(list);
        AppMethodBeat.m2505o(38501);
        return c29054ax;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo47350a(C29054ax c29054ax) {
        AppMethodBeat.m2504i(38502);
        int commit = c29054ax.commit();
        if (this.rim != null) {
            this.rim.mo60719ma(commit);
            C24827g.qTp.mo37379c(this.rim);
        }
        if (!(this.rlP == null || this.rlP.rma == null || !C13478s.crt())) {
            C7060h.pYm.mo8381e(12834, Integer.valueOf(this.rlP.rma.size()));
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.crP.setResult(-1, intent);
        this.crP.finish();
        AppMethodBeat.m2505o(38502);
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        String str3;
        AppMethodBeat.m2504i(38503);
        LinkedList<C21881h> linkedList = new LinkedList();
        Iterator it = this.rlP.rma.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            boolean z2;
            str3 = (String) it.next();
            C21881h c21881h = new C21881h(str3, 2);
            c21881h.type = 2;
            c21881h.qFY = i;
            if (i6 == 0) {
                c21881h.qFX = i2;
                if (c41173i != null) {
                    c21881h.qFZ = c41173i.token;
                    c21881h.qGa = c41173i.wFn;
                }
            } else {
                c21881h.qFX = 0;
            }
            int i7 = i6 + 1;
            C13624b c13624b = this.rlP;
            if (c13624b.rmc.containsKey(str3)) {
                i6 = ((Integer) c13624b.rmc.get(str3)).intValue();
            } else {
                i6 = 0;
            }
            c21881h.filterId = i6;
            c21881h.desc = str;
            c13624b = this.rlP;
            if (C5046bo.isNullOrNil(str3) || !c13624b.rmb.containsKey(str3)) {
                z2 = false;
            } else {
                z2 = ((Boolean) c13624b.rmb.get(str3)).booleanValue();
            }
            c21881h.qGc = z2;
            linkedList.add(c21881h);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List Zn = C1855t.m3877Zn();
            for (String str32 : list) {
                if (!Zn.contains(str32)) {
                    cco cco = new cco();
                    cco.jBB = str32;
                    linkedList2.add(cco);
                }
            }
        }
        C29054ax c29054ax = new C29054ax(1);
        pInt.value = c29054ax.aPA;
        if (c41173i != null) {
            c29054ax.mo47165gc(c41173i.token, c41173i.wFn);
        }
        if (i3 > C24826a.qFE) {
            c29054ax.mo47138Dd(3);
        }
        c29054ax.mo47144Ym(str).mo47154a(ayt).mo47158ar(linkedList2).mo47140Df(i).mo47141Dg(i2);
        if (z) {
            c29054ax.mo47143Di(1);
        } else {
            c29054ax.mo47143Di(0);
        }
        if (!C5046bo.isNullOrNil(this.appId)) {
            c29054ax.mo47150Ys(this.appId);
        }
        if (!C5046bo.isNullOrNil(this.appName)) {
            c29054ax.mo47151Yt(C5046bo.m7532bc(this.appName, ""));
        }
        c29054ax.mo47142Dh(this.rig);
        if (this.rjF) {
            c29054ax.mo47142Dh(5);
        }
        if (this.rjG && this.rjH != null) {
            c29054ax.mo47145Yn(this.rjH.mediaTagName);
            c29054ax.mo47157af(this.appId, this.rjH.messageExt, this.rjH.messageAction);
        }
        c29054ax.mo47164g(null, null, null, i4, i5);
        c29054ax.mo47162dg(list2);
        c29054ax.setSessionId(this.hcl);
        if (!(ayt == null || ayt.score == 0)) {
            i6 = ayt.score;
            String str4 = ayt.wCC;
            c29054ax.qNL.wFw = new cap();
            c29054ax.qNL.wFw.wZS = i6;
            c29054ax.qNL.wFw.wZP = str4;
        }
        C4990ab.m7417i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.rlT));
        C7060h.pYm.mo8381e(11602, Integer.valueOf(this.rlT), Integer.valueOf(linkedList.size()));
        for (C21881h c21881h2 : linkedList) {
            C4990ab.m7417i("MicroMsg.PicWidget", "commit path  %s len: %d", c21881h2.path, Long.valueOf(C5730e.asZ(c21881h2.path)));
        }
        for (C21881h c21881h22 : linkedList) {
            cbv cbv;
            String str5 = c21881h22.path;
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
            C1440a c1440a = (C1440a) this.rlR.get(str5);
            if (c1440a == null || (c1440a.latitude == 0.0d && c1440a.longitude == 0.0d)) {
                cbv.xbk = -1000.0f;
                cbv.xbl = -1000.0f;
            } else {
                cbv.xbk = (float) c1440a.latitude;
                cbv.xbl = (float) c1440a.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + c29054ax.qNL.wFr.size());
            stringBuffer.append("||item poi lat " + cbv.xbm + " " + cbv.xbn);
            stringBuffer.append("||item pic lat " + cbv.xbk + " " + cbv.xbl);
            stringBuffer.append("||item exitime:" + cbv.xbp + " filetime: " + cbv.xbq);
            stringBuffer.append("||item source: " + cbv.xbo);
            C4990ab.m7416i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            c29054ax.qNL.wFr.add(cbv);
        }
        if (linkedList.size() <= 1) {
            C29181ag.m46356a(c29054ax, linkedList);
            mo47350a(c29054ax);
        } else {
            new C29185a(c29054ax, linkedList).mo62862u("");
        }
        C1720g.m3539RS().mo10302aa(new C291824());
        AppMethodBeat.m2505o(38503);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cst() {
        AppMethodBeat.m2504i(38504);
        C1720g.m3537RQ();
        if (!C1720g.m3536RP().isSDCardAvailable()) {
            C23639t.m36492hO(this.crP);
            AppMethodBeat.m2505o(38504);
            return false;
        } else if (this.rlP.rma.size() >= 9) {
            C30379h.m48467g(this.crP, C25738R.string.eqf, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(38504);
            return false;
        } else {
            try {
                C29199ax c29199ax = new C29199ax(this.crP);
                c29199ax.rBl = new C291875();
                c29199ax.rBm = new C220566();
                c29199ax.cuu();
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(38504);
            return true;
        }
    }

    /* renamed from: d */
    public final boolean mo47353d(List<String> list, int i, boolean z) {
        AppMethodBeat.m2504i(38505);
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.PicWidget", "no image selected");
            AppMethodBeat.m2505o(38505);
            return true;
        } else if (this.rlP.rma.size() >= 9) {
            AppMethodBeat.m2505o(38505);
            return true;
        } else {
            for (String str : list) {
                if (C5730e.m8628ct(str)) {
                    String str2 = "pre_temp_sns_pic" + C1178g.m2591x((str + System.currentTimeMillis()).getBytes());
                    C13478s.m21642aj(C13373af.getAccSnsTmpPath(), str, str2);
                    C4990ab.m7410d("MicroMsg.PicWidget", "newPath " + C13373af.getAccSnsTmpPath() + str2);
                    this.rlP.mo25831q(C13373af.getAccSnsTmpPath() + str2, i, z);
                    ((C4088e) this.rlQ).mo8951Eu(this.rlP.rma.size());
                    this.rlQ.setList$22875ea3(this.rlP.rma);
                    this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                    try {
                        C5728b c5728b = new C5728b(str);
                        cbv cbv = new cbv();
                        cbv.xbo = z ? 1 : 2;
                        cbv.xbq = c5728b.lastModified() / 1000;
                        cbv.xbp = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rlS.put(C13373af.getAccSnsTmpPath() + str2, cbv);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    C1440a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rlR.put(C13373af.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
            AppMethodBeat.m2505o(38505);
            return true;
        }
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        AppMethodBeat.m2504i(38506);
        String h;
        String x;
        boolean d;
        String stringExtra;
        String cz;
        switch (i) {
            case 2:
                C4990ab.m7410d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    AppMethodBeat.m2505o(38506);
                    return false;
                }
                C4990ab.m7410d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                C24826a.gkE.mo38891a(this.crP, intent, intent2, C13373af.getAccSnsTmpPath(), 4, new C220577());
                AppMethodBeat.m2505o(38506);
                return true;
            case 3:
                C4990ab.m7410d("MicroMsg.PicWidget", "onActivityResult 2");
                h = C14987n.m23320h(this.crP.getApplicationContext(), intent, C13373af.getAccSnsTmpPath());
                if (h == null) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", h);
                x = C1178g.m2591x((h + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", C13373af.getAccSnsTmpPath() + x);
                C1440a location = Exif.fromFile(h).getLocation();
                if (location != null) {
                    this.rlR.put(C13373af.getAccSnsTmpPath() + x, location);
                    C4990ab.m7411d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", Double.valueOf(location.latitude), Double.valueOf(location.longitude));
                }
                cbv cbv = new cbv();
                cbv.xbo = 1;
                cbv.xbq = System.currentTimeMillis();
                cbv.xbp = C5046bo.anl(Exif.fromFile(h).dateTime);
                this.rlS.put(C13373af.getAccSnsTmpPath() + x, cbv);
                C24826a.gkE.mo38890a(this.crP, intent3, 4);
                this.rkD = true;
                AppMethodBeat.m2505o(38506);
                return true;
            case 4:
                C4990ab.m7410d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                C4990ab.m7410d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath ".concat(String.valueOf(h)));
                if (h == null) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                } else if (!C5730e.m8628ct(h)) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                } else if (this.rlP.rma.size() >= 9) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                } else {
                    int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                    x = "pre_temp_sns_pic" + C1178g.m2591x((h + System.currentTimeMillis()).getBytes());
                    C4990ab.m7416i("MicroMsg.PicWidget", "onactivity result " + C5730e.asZ(h) + " " + h);
                    C5730e.m8644y(h, C13373af.getAccSnsTmpPath() + x);
                    if (this.rlR.containsKey(h)) {
                        this.rlR.put(C13373af.getAccSnsTmpPath() + x, this.rlR.get(h));
                    }
                    h = C13373af.getAccSnsTmpPath() + x;
                    C4990ab.m7410d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(h)));
                    this.rlP.mo25831q(h, intExtra, false);
                    this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                    ((C4088e) this.rlQ).mo8951Eu(this.rlP.rma.size());
                    this.rlQ.setList$22875ea3(this.rlP.rma);
                    AppMethodBeat.m2505o(38506);
                    return true;
                }
            case 7:
                if (intent == null) {
                    AppMethodBeat.m2505o(38506);
                    return true;
                }
                this.rlP.mo25829S(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.crP.getIntent().putExtra("sns_kemdia_path_list", this.rlP.rma);
                ((C4088e) this.rlQ).mo8951Eu(this.rlP.rma.size());
                this.rlQ.setList$22875ea3(this.rlP.rma);
                this.rlT = intent.getIntExtra("sns_update_preview_image_count", 0);
                AppMethodBeat.m2505o(38506);
                return true;
            case 9:
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && C5046bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                    d = mo47353d(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
                    AppMethodBeat.m2505o(38506);
                    return d;
                }
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                x = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (C5046bo.isNullOrNil(x) || !C5730e.m8628ct(x)) {
                    x = C13373af.getAccSnsTmpPath() + C1178g.m2587cz(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            C4990ab.m7412e("MicroMsg.PicWidget", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.PicWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        C5056d.m7625a(frameAtTime, 80, CompressFormat.JPEG, x, true);
                        Options amj = C5056d.amj(x);
                        C4990ab.m7417i("MicroMsg.PicWidget", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.PicWidget", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.m2505o(38506);
                    }
                }
                C4990ab.m7417i("MicroMsg.PicWidget", "video path %s thumb path %s and %s %s ", stringExtra, x, Long.valueOf(C5730e.asZ(stringExtra)), Long.valueOf(C5730e.asZ(x)));
                cz = C1178g.m2587cz(stringExtra);
                if (this.crP instanceof SnsUploadUI) {
                    ((SnsUploadUI) this.crP).mo25788a(stringExtra, x, cz, null, false);
                    ((SnsUploadUI) this.crP).cuF();
                }
                AppMethodBeat.m2505o(38506);
                return true;
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        h = sightCaptureResult.osI;
                        if (!C5046bo.isNullOrNil(h)) {
                            d = mo47353d(Collections.singletonList(h), 0, true);
                            AppMethodBeat.m2505o(38506);
                            return d;
                        }
                    }
                    stringExtra = sightCaptureResult.osC;
                    x = sightCaptureResult.osD;
                    byte[] bArr = null;
                    this.crP.getIntent().putExtra("KSightThumbPath", sightCaptureResult.osD);
                    if (C5046bo.isNullOrNil(sightCaptureResult.osF)) {
                        cz = C1178g.m2587cz(stringExtra);
                    } else {
                        cz = sightCaptureResult.osF;
                    }
                    try {
                        bArr = sightCaptureResult.osH.toByteArray();
                    } catch (Exception e32) {
                        C4990ab.m7417i("MicroMsg.PicWidget", "put sight extinfo to snsuploadui error: %s", e32.getMessage());
                    }
                    if (this.crP instanceof SnsUploadUI) {
                        ((SnsUploadUI) this.crP).mo25788a(stringExtra, x, cz, bArr, true);
                        ((SnsUploadUI) this.crP).cuF();
                    }
                    AppMethodBeat.m2505o(38506);
                    return true;
                }
                break;
        }
        AppMethodBeat.m2505o(38506);
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38507);
        if (this.rlQ != null) {
            this.rlQ.clean();
        }
        this.rlR.clear();
        this.rlS.clear();
        AppMethodBeat.m2505o(38507);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DR */
    public final void mo47349DR(int i) {
        AppMethodBeat.m2504i(38508);
        C32660ag Fr = new C32660ag().mo53148Fr();
        Fr.cYH = (long) i;
        Fr.mo53149fj(this.rkC).ajK();
        AppMethodBeat.m2505o(38508);
    }
}
