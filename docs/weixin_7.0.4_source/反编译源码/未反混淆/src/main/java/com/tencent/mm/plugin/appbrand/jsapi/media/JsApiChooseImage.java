package com.tencent.mm.plugin.appbrand.jsapi.media;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";

    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131126);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(131126);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        boolean hOS;
        boolean hOT;
        boolean hOU;
        boolean hOV;

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final void k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131127);
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
            AppMethodBeat.o(131127);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(131128);
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
            AppMethodBeat.o(131128);
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
            AppMethodBeat.i(131129);
            k(parcel);
            AppMethodBeat.o(131129);
        }

        static {
            AppMethodBeat.i(131130);
            AppMethodBeat.o(131130);
        }
    }

    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131131);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(131131);
                return chooseResult;
            }
        };
        int bFZ;
        ArrayList<AppBrandLocalMediaObject> hOW;

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131132);
            this.bFZ = parcel.readInt();
            this.hOW = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
            AppMethodBeat.o(131132);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131133);
            parcel.writeInt(this.bFZ);
            parcel.writeTypedList(this.hOW);
            AppMethodBeat.o(131133);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(131134);
            AppMethodBeat.o(131134);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private p ejZ;
        ChooseRequest hOX;
        ChooseResult hOY = new ChooseResult();
        int hOZ;
        private OnCancelListener hPa;

        private a() {
            AppMethodBeat.i(131139);
            AppMethodBeat.o(131139);
        }

        static /* synthetic */ String Bp(String str) {
            AppMethodBeat.i(131147);
            String Bo = Bo(str);
            AppMethodBeat.o(131147);
            return Bo;
        }

        static /* synthetic */ String Bq(String str) {
            AppMethodBeat.i(131148);
            String Bn = Bn(str);
            AppMethodBeat.o(131148);
            return Bn;
        }

        static /* synthetic */ void a(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131146);
            aVar.a(processResult);
            AppMethodBeat.o(131146);
        }

        static /* synthetic */ void b(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131149);
            aVar.a(processResult);
            AppMethodBeat.o(131149);
        }

        public final void a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.i(131140);
            this.hOX = (ChooseRequest) processRequest;
            this.hOX.count = Math.max(1, Math.min(9, this.hOX.count));
            if ((this.hOX.hOU & this.hOX.hOV) != 0) {
                i = 8;
            } else {
                i = 7;
            }
            this.hOZ = i;
            if (bo.gO(aBQ()) > 200) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                t.makeText(aBQ(), ah.getResources().getString(R.string.ha), 1).show();
            }
            aBQ().ifE = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", !this.hOX.hOU);
            intent.putExtra("query_media_type", 1);
            if (this.hOX.hOS && this.hOX.hOT) {
                n.a(aBQ(), 1, this.hOX.count, this.hOZ, intent);
                AppMethodBeat.o(131140);
            } else if (this.hOX.hOT) {
                intent.putExtra("show_header_view", false);
                n.a(aBQ(), 1, this.hOX.count, this.hOZ, intent);
                AppMethodBeat.o(131140);
            } else if (this.hOX.hOS) {
                n.c(aBQ(), e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                AppMethodBeat.o(131140);
            } else {
                ab.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.hOY.bFZ = -2;
                a((ProcessResult) this.hOY);
                AppMethodBeat.o(131140);
            }
        }

        private void or(int i) {
            AppMethodBeat.i(131141);
            this.hPa = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131135);
                    a.this.hOY.bFZ = 0;
                    a.a(a.this, a.this.hOY);
                    AppMethodBeat.o(131135);
                }
            };
            Context aBQ = aBQ();
            ah.getResources().getString(R.string.tz);
            this.ejZ = h.b(aBQ, ah.getResources().getString(i), true, this.hPa);
            AppMethodBeat.o(131141);
        }

        private static String Bn(String str) {
            AppMethodBeat.i(131142);
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree != 0) {
                orientationInDegree %= v2helper.VOIP_ENC_HEIGHT_LV1;
                try {
                    Options options = new Options();
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        ab.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                        AppMethodBeat.o(131142);
                        return str;
                    }
                    Bitmap b = d.b(decodeFile, (float) orientationInDegree);
                    String str2 = e.euR + "microMsg.tmp." + System.currentTimeMillis() + (c.e(options) ? FileUtils.PIC_POSTFIX_JPEG : ".png");
                    try {
                        d.a(b, 80, c.e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                        if (c.e(options)) {
                            b.bY(str, str2);
                        }
                        AppMethodBeat.o(131142);
                        return str2;
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", e);
                        com.tencent.mm.a.e.deleteFile(str2);
                        AppMethodBeat.o(131142);
                        return str;
                    }
                } catch (OutOfMemoryError e2) {
                    AppMethodBeat.o(131142);
                    return str;
                } catch (NullPointerException e3) {
                    AppMethodBeat.o(131142);
                    return str;
                }
            }
            AppMethodBeat.o(131142);
            return str;
        }

        private static String Bo(String str) {
            Bitmap decodeFile;
            AppMethodBeat.i(131143);
            String str2 = e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                decodeFile = MMBitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e) {
                ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e3)));
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = d.decodeFile(str, null);
                } catch (Exception e32) {
                    ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e32)));
                    decodeFile = null;
                }
            } catch (Exception e322) {
                ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e ".concat(String.valueOf(e322)));
                decodeFile = null;
            }
            if (decodeFile == null) {
                ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                AppMethodBeat.o(131143);
                return null;
            }
            decodeFile.recycle();
            long anU = bo.anU();
            try {
                ab.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(c.cU(str2, str)), Long.valueOf(bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
                if (c.cU(str2, str)) {
                    AppMethodBeat.o(131143);
                    return str2;
                }
                AppMethodBeat.o(131143);
                return str;
            } catch (OutOfMemoryError e5) {
                ab.e("MicroMsg.JsApiChooseImage", "compressImage, oom");
                AppMethodBeat.o(131143);
                return str;
            }
        }

        public final void aBX() {
            AppMethodBeat.i(131144);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.o(131144);
        }

        /* JADX WARNING: Missing block: B:32:0x00d3, code skipped:
            if (r0 == false) goto L_0x00fa;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(int i, int i2, Intent intent) {
            boolean z = true;
            AppMethodBeat.i(131145);
            if (i2 == 0) {
                this.hOY.bFZ = 0;
                a((ProcessResult) this.hOY);
                AppMethodBeat.o(131145);
                return;
            }
            final String h;
            switch (i) {
                case 1:
                case 3:
                    if (intent == null) {
                        this.hOY.bFZ = 0;
                        a((ProcessResult) this.hOY);
                        AppMethodBeat.o(131145);
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
                    ab.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.valueOf(z2), Boolean.valueOf(this.hOX.hOU), Boolean.valueOf(this.hOX.hOV), Boolean.valueOf(r6), Boolean.valueOf(z3));
                    if (z3) {
                        or(R.string.hb);
                    }
                    if (!z3) {
                        boolean z4;
                        if (!bo.ek(stringArrayListExtra)) {
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
                        or(R.string.k2);
                    }
                    m.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(131137);
                            final ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                            for (String str : stringArrayListExtra) {
                                String Bp;
                                boolean z = z2;
                                if (z3) {
                                    Bp = a.Bp(str);
                                    z |= 1;
                                } else {
                                    if (z) {
                                        Bp = a.Bq(str);
                                        if (!Bp.equals(str)) {
                                            z |= 1;
                                        }
                                    }
                                    Bp = str;
                                }
                                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.j(a.this.hOX.appId, Bp, z);
                                if (j != null) {
                                    arrayList.add(j);
                                } else {
                                    ab.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", Bp);
                                }
                            }
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131136);
                                    a.this.hOY.bFZ = -1;
                                    a.this.hOY.hOW = arrayList;
                                    a.b(a.this, a.this.hOY);
                                    AppMethodBeat.o(131136);
                                }
                            });
                            AppMethodBeat.o(131137);
                        }
                    });
                    AppMethodBeat.o(131145);
                    return;
                case 2:
                    h2 = n.h(aBQ().getApplicationContext(), intent, e.euR);
                    if (bo.isNullOrNil(h2)) {
                        ab.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
                        this.hOY.bFZ = -2;
                        a((ProcessResult) this.hOY);
                        AppMethodBeat.o(131145);
                        return;
                    }
                    ab.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", h2);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(131138);
                            Intent intent = new Intent();
                            intent.putExtra("key_send_raw_image", !a.this.hOX.hOU);
                            intent.putExtra("max_select_count", a.this.hOX.count);
                            intent.putExtra("query_source_type", a.this.hOZ);
                            intent.putExtra("isPreviewPhoto", true);
                            intent.putExtra("max_select_count", 1);
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(h2);
                            intent.putStringArrayListExtra("preview_image_list", arrayList);
                            intent.putExtra("preview_image", true);
                            intent.addFlags(67108864);
                            a.a(a.this, "gallery", ".ui.GalleryEntryUI", intent);
                            AppMethodBeat.o(131138);
                        }
                    });
                    AppMethodBeat.o(131145);
                    return;
                default:
                    this.hOY.bFZ = -2;
                    a((ProcessResult) this.hOY);
                    AppMethodBeat.o(131145);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            AppMethodBeat.i(131150);
            aVar.aBQ().ifE = aVar;
            com.tencent.mm.bp.d.b(aVar.aBQ(), str, str2, intent, 3);
            AppMethodBeat.o(131150);
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131151);
        if (com.tencent.mm.plugin.appbrand.n.xa(cVar.getAppId()).gPi) {
            cVar.M(i, j("cancel", null));
            AppMethodBeat.o(131151);
            return;
        }
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131151);
            return;
        }
        String str;
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        String optString = jSONObject.optString("sizeType");
        ab.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", optJSONArray, optString, jSONObject.optString("count"));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.hOS = true;
            chooseRequest.hOT = true;
        } else {
            chooseRequest.hOS = optJSONArray.toString().contains("camera");
            chooseRequest.hOT = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.hOS) {
            boolean z;
            com.tencent.mm.plugin.appbrand.permission.n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(131125);
                    if (i != 113) {
                        AppMethodBeat.o(131125);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        cVar.M(i, JsApiChooseImage.this.j("fail:system permission denied", null));
                        AppMethodBeat.o(131125);
                    } else {
                        JsApiChooseImage.this.a(cVar, jSONObject, i);
                        AppMethodBeat.o(131125);
                    }
                }
            });
            Context context2 = cVar.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                cVar.M(i, j("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.permission.n.Dr(cVar.getAppId());
                }
            }
            if (!z) {
                AppMethodBeat.o(131151);
                return;
            }
        }
        com.tencent.mm.plugin.appbrand.n.xb(cVar.getAppId()).gPi = true;
        g.a(cVar.getAppId(), new g.c() {
            public final void onResume() {
                AppMethodBeat.i(131123);
                com.tencent.mm.plugin.appbrand.n.xb(cVar.getAppId()).gPi = false;
                g.b(cVar.getAppId(), this);
                AppMethodBeat.o(131123);
            }
        });
        if (bo.isNullOrNil(optString)) {
            str = "compressed";
        } else {
            str = optString;
        }
        chooseRequest.hOU = str.contains("compressed");
        chooseRequest.hOV = str.contains("original");
        chooseRequest.count = bo.getInt(r4, 9);
        chooseRequest.appId = cVar.getAppId();
        com.tencent.mm.plugin.appbrand.ipc.a.b(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
            public final /* synthetic */ void c(ProcessResult processResult) {
                AppMethodBeat.i(131124);
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bFZ) {
                        case -1:
                            ArrayList arrayList = chooseResult.hOW;
                            if (bo.ek(arrayList)) {
                                ab.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            ArrayList arrayList3 = new ArrayList(arrayList.size());
                            ArrayList arrayList4 = new ArrayList(arrayList.size());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                                if (!(appBrandLocalMediaObject == null || bo.isNullOrNil(appBrandLocalMediaObject.czD))) {
                                    arrayList2.add(appBrandLocalMediaObject.czD);
                                    arrayList3.add(Long.valueOf(appBrandLocalMediaObject.gjQ));
                                    arrayList4.add(appBrandLocalMediaObject.fnQ);
                                }
                            }
                            ab.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", JsApiChooseImage.l(arrayList2));
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("tempFilePaths", JsApiChooseImage.m(arrayList2));
                            hashMap.put("tempFileSizes", JsApiChooseImage.m(arrayList3));
                            if (com.tencent.mm.sdk.a.b.dnO()) {
                                hashMap.put("__realPaths", JsApiChooseImage.m(arrayList4));
                            }
                            cVar.M(i, JsApiChooseImage.this.j("ok", hashMap));
                            AppMethodBeat.o(131124);
                            return;
                        case 0:
                            cVar.M(i, JsApiChooseImage.this.j("cancel", null));
                            AppMethodBeat.o(131124);
                            return;
                    }
                }
                cVar.M(i, JsApiChooseImage.this.j("fail", null));
                AppMethodBeat.o(131124);
            }
        });
        AppMethodBeat.o(131151);
    }

    static /* synthetic */ String l(ArrayList arrayList) {
        AppMethodBeat.i(131152);
        if (arrayList.size() == 0) {
            ab.e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.o(131152);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(131152);
        return jSONArray2;
    }

    static /* synthetic */ JSONArray m(ArrayList arrayList) {
        AppMethodBeat.i(131153);
        if (arrayList.size() == 0) {
            ab.e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.o(131153);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        AppMethodBeat.o(131153);
        return jSONArray;
    }
}
