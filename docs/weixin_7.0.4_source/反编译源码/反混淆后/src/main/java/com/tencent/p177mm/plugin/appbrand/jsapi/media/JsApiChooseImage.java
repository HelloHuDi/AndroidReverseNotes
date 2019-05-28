package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.C6184a.C0315a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p290g.C2154b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C38507c;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage */
public final class JsApiChooseImage extends C10296a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$ChooseRequest */
    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new C166711();
        String appId;
        int count;
        boolean hOS;
        boolean hOT;
        boolean hOU;
        boolean hOV;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$ChooseRequest$1 */
        static class C166711 implements Creator<ChooseRequest> {
            C166711() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131126);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.m2505o(131126);
                return chooseRequest;
            }
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C42538a.class;
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131127);
            this.appId = parcel.readString();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOS = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOT = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOU = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hOV = z2;
            AppMethodBeat.m2505o(131127);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(131128);
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
            if (this.hOS) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hOT) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hOU) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hOV) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.m2505o(131128);
        }

        public final String aBZ() {
            return "GalleryChooseImage";
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.m2504i(131129);
            mo6049k(parcel);
            AppMethodBeat.m2505o(131129);
        }

        static {
            AppMethodBeat.m2504i(131130);
            AppMethodBeat.m2505o(131130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$ChooseResult */
    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new C333541();
        int bFZ;
        ArrayList<AppBrandLocalMediaObject> hOW;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$ChooseResult$1 */
        static class C333541 implements Creator<ChooseResult> {
            C333541() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131131);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.m2505o(131131);
                return chooseResult;
            }
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(131132);
            this.bFZ = parcel.readInt();
            this.hOW = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
            AppMethodBeat.m2505o(131132);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131133);
            parcel.writeInt(this.bFZ);
            parcel.writeTypedList(this.hOW);
            AppMethodBeat.m2505o(131133);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.m2504i(131134);
            AppMethodBeat.m2505o(131134);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a */
    static final class C42538a extends AppBrandProxyUIProcessTask {
        private C44275p ejZ;
        ChooseRequest hOX;
        ChooseResult hOY = new ChooseResult();
        int hOZ;
        private OnCancelListener hPa;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a$1 */
        class C425391 implements OnCancelListener {
            C425391() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131135);
                C42538a.this.hOY.bFZ = 0;
                C42538a.m75320a(C42538a.this, C42538a.this.hOY);
                AppMethodBeat.m2505o(131135);
            }
        }

        private C42538a() {
            AppMethodBeat.m2504i(131139);
            AppMethodBeat.m2505o(131139);
        }

        /* renamed from: Bp */
        static /* synthetic */ String m75318Bp(String str) {
            AppMethodBeat.m2504i(131147);
            String Bo = C42538a.m75317Bo(str);
            AppMethodBeat.m2505o(131147);
            return Bo;
        }

        /* renamed from: Bq */
        static /* synthetic */ String m75319Bq(String str) {
            AppMethodBeat.m2504i(131148);
            String Bn = C42538a.m75316Bn(str);
            AppMethodBeat.m2505o(131148);
            return Bn;
        }

        /* renamed from: a */
        static /* synthetic */ void m75320a(C42538a c42538a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131146);
            c42538a.mo34449a(processResult);
            AppMethodBeat.m2505o(131146);
        }

        /* renamed from: b */
        static /* synthetic */ void m75322b(C42538a c42538a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131149);
            c42538a.mo34449a(processResult);
            AppMethodBeat.m2505o(131149);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.m2504i(131140);
            this.hOX = (ChooseRequest) processRequest;
            this.hOX.count = Math.max(1, Math.min(9, this.hOX.count));
            if ((this.hOX.hOU & this.hOX.hOV) != 0) {
                i = 8;
            } else {
                i = 7;
            }
            this.hOZ = i;
            if (C5046bo.m7553gO(aBQ()) > 200) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                C23639t.makeText(aBQ(), C4996ah.getResources().getString(C25738R.string.f8857ha), 1).show();
            }
            aBQ().ifE = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", !this.hOX.hOU);
            intent.putExtra("query_media_type", 1);
            if (this.hOX.hOS && this.hOX.hOT) {
                C14987n.m23296a(aBQ(), 1, this.hOX.count, this.hOZ, intent);
                AppMethodBeat.m2505o(131140);
            } else if (this.hOX.hOT) {
                intent.putExtra("show_header_view", false);
                C14987n.m23296a(aBQ(), 1, this.hOX.count, this.hOZ, intent);
                AppMethodBeat.m2505o(131140);
            } else if (this.hOX.hOS) {
                C14987n.m23311c(aBQ(), C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                AppMethodBeat.m2505o(131140);
            } else {
                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.hOY.bFZ = -2;
                mo34449a((ProcessResult) this.hOY);
                AppMethodBeat.m2505o(131140);
            }
        }

        /* renamed from: or */
        private void m75323or(int i) {
            AppMethodBeat.m2504i(131141);
            this.hPa = new C425391();
            Context aBQ = aBQ();
            C4996ah.getResources().getString(C25738R.string.f9238tz);
            this.ejZ = C30379h.m48458b(aBQ, C4996ah.getResources().getString(i), true, this.hPa);
            AppMethodBeat.m2505o(131141);
        }

        /* renamed from: Bn */
        private static String m75316Bn(String str) {
            AppMethodBeat.m2504i(131142);
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree != 0) {
                orientationInDegree %= v2helper.VOIP_ENC_HEIGHT_LV1;
                try {
                    Options options = new Options();
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        C4990ab.m7412e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                        AppMethodBeat.m2505o(131142);
                        return str;
                    }
                    Bitmap b = C5056d.m7648b(decodeFile, (float) orientationInDegree);
                    String str2 = C6457e.euR + "microMsg.tmp." + System.currentTimeMillis() + (C38507c.m65173e(options) ? FileUtils.PIC_POSTFIX_JPEG : ".png");
                    try {
                        C5056d.m7625a(b, 80, C38507c.m65173e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                        if (C38507c.m65173e(options)) {
                            C2154b.m4366bY(str, str2);
                        }
                        AppMethodBeat.m2505o(131142);
                        return str2;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", e);
                        C1173e.deleteFile(str2);
                        AppMethodBeat.m2505o(131142);
                        return str;
                    }
                } catch (OutOfMemoryError e2) {
                    AppMethodBeat.m2505o(131142);
                    return str;
                } catch (NullPointerException e3) {
                    AppMethodBeat.m2505o(131142);
                    return str;
                }
            }
            AppMethodBeat.m2505o(131142);
            return str;
        }

        /* renamed from: Bo */
        private static String m75317Bo(String str) {
            Bitmap decodeFile;
            AppMethodBeat.m2504i(131143);
            String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                decodeFile = MMBitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e) {
                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = C5056d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e3)));
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = C5056d.decodeFile(str, null);
                } catch (Exception e32) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e32)));
                    decodeFile = null;
                }
            } catch (Exception e322) {
                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e ".concat(String.valueOf(e322)));
                decodeFile = null;
            }
            if (decodeFile == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                AppMethodBeat.m2505o(131143);
                return null;
            }
            decodeFile.recycle();
            long anU = C5046bo.anU();
            try {
                C4990ab.m7417i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(C38507c.m65172cU(str2, str)), Long.valueOf(C5046bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
                if (C38507c.m65172cU(str2, str)) {
                    AppMethodBeat.m2505o(131143);
                    return str2;
                }
                AppMethodBeat.m2505o(131143);
                return str;
            } catch (OutOfMemoryError e5) {
                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "compressImage, oom");
                AppMethodBeat.m2505o(131143);
                return str;
            }
        }

        public final void aBX() {
            AppMethodBeat.m2504i(131144);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.m2505o(131144);
        }

        /* JADX WARNING: Missing block: B:32:0x00d3, code skipped:
            if (r0 == false) goto L_0x00fa;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            boolean z = true;
            AppMethodBeat.m2504i(131145);
            if (i2 == 0) {
                this.hOY.bFZ = 0;
                mo34449a((ProcessResult) this.hOY);
                AppMethodBeat.m2505o(131145);
                return;
            }
            final String h;
            switch (i) {
                case 1:
                case 3:
                    if (intent == null) {
                        this.hOY.bFZ = 0;
                        mo34449a((ProcessResult) this.hOY);
                        AppMethodBeat.m2505o(131145);
                        return;
                    }
                    boolean z2;
                    final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    final boolean z3 = (((!this.hOX.hOV ? 1 : 0) & this.hOX.hOU) == 0 && ((this.hOX.hOU & this.hOX.hOV) & intent.getBooleanExtra("CropImage_Compress_Img", false)) == 0) ? false : true;
                    if (intent.getBooleanExtra("isTakePhoto", false) || intent.getBooleanExtra("isPreviewPhoto", false)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C4990ab.m7411d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.valueOf(z2), Boolean.valueOf(this.hOX.hOU), Boolean.valueOf(this.hOX.hOV), Boolean.valueOf(r6), Boolean.valueOf(z3));
                    if (z3) {
                        m75323or(C25738R.string.f8858hb);
                    }
                    if (!z3) {
                        boolean z4;
                        if (!C5046bo.m7548ek(stringArrayListExtra)) {
                            for (String h2 : stringArrayListExtra) {
                                if (Exif.fromFile(h2).getOrientationInDegree() != 0) {
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                        z4 = false;
                        break;
                    }
                    z = false;
                    if (z) {
                        m75323or(C25738R.string.f8940k2);
                    }
                    C45673m.aNS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(131137);
                            final ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                            for (String str : stringArrayListExtra) {
                                String Bp;
                                boolean z = z2;
                                if (z3) {
                                    Bp = C42538a.m75318Bp(str);
                                    z |= 1;
                                } else {
                                    if (z) {
                                        Bp = C42538a.m75319Bq(str);
                                        if (!Bp.equals(str)) {
                                            z |= 1;
                                        }
                                    }
                                    Bp = str;
                                }
                                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.m29651j(C42538a.this.hOX.appId, Bp, z);
                                if (j != null) {
                                    arrayList.add(j);
                                } else {
                                    C4990ab.m7413e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", Bp);
                                }
                            }
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131136);
                                    C42538a.this.hOY.bFZ = -1;
                                    C42538a.this.hOY.hOW = arrayList;
                                    C42538a.m75322b(C42538a.this, C42538a.this.hOY);
                                    AppMethodBeat.m2505o(131136);
                                }
                            });
                            AppMethodBeat.m2505o(131137);
                        }
                    });
                    AppMethodBeat.m2505o(131145);
                    return;
                case 2:
                    h2 = C14987n.m23320h(aBQ().getApplicationContext(), intent, C6457e.euR);
                    if (C5046bo.isNullOrNil(h2)) {
                        C4990ab.m7420w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
                        this.hOY.bFZ = -2;
                        mo34449a((ProcessResult) this.hOY);
                        AppMethodBeat.m2505o(131145);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", h2);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(131138);
                            Intent intent = new Intent();
                            intent.putExtra("key_send_raw_image", !C42538a.this.hOX.hOU);
                            intent.putExtra("max_select_count", C42538a.this.hOX.count);
                            intent.putExtra("query_source_type", C42538a.this.hOZ);
                            intent.putExtra("isPreviewPhoto", true);
                            intent.putExtra("max_select_count", 1);
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(h2);
                            intent.putStringArrayListExtra("preview_image_list", arrayList);
                            intent.putExtra("preview_image", true);
                            intent.addFlags(67108864);
                            C42538a.m75321a(C42538a.this, "gallery", ".ui.GalleryEntryUI", intent);
                            AppMethodBeat.m2505o(131138);
                        }
                    });
                    AppMethodBeat.m2505o(131145);
                    return;
                default:
                    this.hOY.bFZ = -2;
                    mo34449a((ProcessResult) this.hOY);
                    AppMethodBeat.m2505o(131145);
                    return;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m75321a(C42538a c42538a, String str, String str2, Intent intent) {
            AppMethodBeat.m2504i(131150);
            c42538a.aBQ().ifE = c42538a;
            C25985d.m41468b(c42538a.aBQ(), str, str2, intent, 3);
            AppMethodBeat.m2505o(131150);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131151);
        if (C38450n.m65048xa(c2241c.getAppId()).gPi) {
            c2241c.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(131151);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131151);
            return;
        }
        String str;
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        String optString = jSONObject.optString("sizeType");
        C4990ab.m7417i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", optJSONArray, optString, jSONObject.optString("count"));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.hOS = true;
            chooseRequest.hOT = true;
        } else {
            chooseRequest.hOS = optJSONArray.toString().contains("camera");
            chooseRequest.hOT = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.hOS) {
            boolean z;
            C19663n.m30463b(c2241c.getAppId(), new C0315a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.m2504i(131125);
                    if (i != 113) {
                        AppMethodBeat.m2505o(131125);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        c2241c.mo6107M(i, JsApiChooseImage.this.mo73394j("fail:system permission denied", null));
                        AppMethodBeat.m2505o(131125);
                    } else {
                        JsApiChooseImage.this.mo5994a(c2241c, jSONObject, i);
                        AppMethodBeat.m2505o(131125);
                    }
                }
            });
            Context context2 = c2241c.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                c2241c.mo6107M(i, mo73394j("fail", null));
                z = false;
            } else {
                z = C35805b.m58707a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                if (z) {
                    C19663n.m30460Dr(c2241c.getAppId());
                }
            }
            if (!z) {
                AppMethodBeat.m2505o(131151);
                return;
            }
        }
        C38450n.m65049xb(c2241c.getAppId()).gPi = true;
        C33183g.m54274a(c2241c.getAppId(), new C33186c() {
            public final void onResume() {
                AppMethodBeat.m2504i(131123);
                C38450n.m65049xb(c2241c.getAppId()).gPi = false;
                C33183g.m54276b(c2241c.getAppId(), this);
                AppMethodBeat.m2505o(131123);
            }
        });
        if (C5046bo.isNullOrNil(optString)) {
            str = "compressed";
        } else {
            str = optString;
        }
        chooseRequest.hOU = str.contains("compressed");
        chooseRequest.hOV = str.contains("original");
        chooseRequest.count = C5046bo.getInt(r4, 9);
        chooseRequest.appId = c2241c.getAppId();
        C26907a.m42843b(context, chooseRequest, new C19247b<ChooseResult>() {
            /* renamed from: c */
            public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                AppMethodBeat.m2504i(131124);
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bFZ) {
                        case -1:
                            ArrayList arrayList = chooseResult.hOW;
                            if (C5046bo.m7548ek(arrayList)) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            ArrayList arrayList3 = new ArrayList(arrayList.size());
                            ArrayList arrayList4 = new ArrayList(arrayList.size());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                                if (!(appBrandLocalMediaObject == null || C5046bo.isNullOrNil(appBrandLocalMediaObject.czD))) {
                                    arrayList2.add(appBrandLocalMediaObject.czD);
                                    arrayList3.add(Long.valueOf(appBrandLocalMediaObject.gjQ));
                                    arrayList4.add(appBrandLocalMediaObject.fnQ);
                                }
                            }
                            C4990ab.m7417i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", JsApiChooseImage.m75326l(arrayList2));
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("tempFilePaths", JsApiChooseImage.m75327m(arrayList2));
                            hashMap.put("tempFileSizes", JsApiChooseImage.m75327m(arrayList3));
                            if (C4872b.dnO()) {
                                hashMap.put("__realPaths", JsApiChooseImage.m75327m(arrayList4));
                            }
                            c2241c.mo6107M(i, JsApiChooseImage.this.mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(131124);
                            return;
                        case 0:
                            c2241c.mo6107M(i, JsApiChooseImage.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(131124);
                            return;
                    }
                }
                c2241c.mo6107M(i, JsApiChooseImage.this.mo73394j("fail", null));
                AppMethodBeat.m2505o(131124);
            }
        });
        AppMethodBeat.m2505o(131151);
    }

    /* renamed from: l */
    static /* synthetic */ String m75326l(ArrayList arrayList) {
        AppMethodBeat.m2504i(131152);
        if (arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.m2505o(131152);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.m2505o(131152);
        return jSONArray2;
    }

    /* renamed from: m */
    static /* synthetic */ JSONArray m75327m(ArrayList arrayList) {
        AppMethodBeat.m2504i(131153);
        if (arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.m2505o(131153);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        AppMethodBeat.m2505o(131153);
        return jSONArray;
    }
}
