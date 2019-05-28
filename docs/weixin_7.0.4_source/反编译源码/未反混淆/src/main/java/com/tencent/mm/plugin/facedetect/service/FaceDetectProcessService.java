package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.s;
import com.tencent.mm.plugin.appbrand.jsapi.i.k;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.service.MMService;

public class FaceDetectProcessService extends MMService {
    private a lVQ = new a();
    public g lVR = null;
    private Messenger lVS = null;
    private a lVT = null;

    public class a extends Binder {
    }

    public FaceDetectProcessService() {
        AppMethodBeat.i(340);
        AppMethodBeat.o(340);
    }

    public final void onCreate() {
        AppMethodBeat.i(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", Integer.valueOf(hashCode()));
        super.onCreate();
        this.lVR = new g();
        AppMethodBeat.o(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(b.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        int onStartCommand;
        if (intent == null) {
            ab.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(b.CTRL_INDEX);
            return onStartCommand;
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.lVS = messenger;
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(b.CTRL_INDEX);
            return onStartCommand;
        }
        ab.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", Integer.valueOf(intent.getIntExtra("k_cmd", -1)));
        switch (intent.getIntExtra("k_cmd", -1)) {
            case 0:
                a aVar;
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("k_server_scene", 2)) {
                    case 0:
                    case 1:
                        aVar = null;
                        break;
                    case 2:
                    case 5:
                        aVar = new b();
                        break;
                    default:
                        aVar = null;
                        break;
                }
                this.lVT = aVar;
                g gVar = this.lVR;
                if (gVar.lTP != null) {
                    ab.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    gVar.bsH();
                }
                if (p.bsN()) {
                    gVar.lTP = new FaceProNative();
                    onStartCommand = gVar.lTP.engineInit(stringExtra, byteArrayExtra, p.bsP(), p.bsQ());
                    ab.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", Integer.valueOf(onStartCommand));
                } else {
                    ab.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    onStartCommand = -4;
                }
                ec(0, onStartCommand);
                break;
            case 1:
                final AnonymousClass1 anonymousClass1 = new q() {
                    public final void b(final FaceResult faceResult) {
                        int i = -1;
                        AppMethodBeat.i(337);
                        String str = "MicroMsg.FaceDetectProcessService";
                        String str2 = "alvinluo release out result == null:%b, result: %d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(faceResult == null);
                        objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
                        ab.i(str, str2, objArr);
                        if (faceResult == null || faceResult.result != 0) {
                            ab.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                            if (faceResult != null) {
                                i = faceResult.result;
                            }
                            FaceDetectProcessService.a(FaceDetectProcessService.this, i);
                            AppMethodBeat.o(337);
                            return;
                        }
                        f.V(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(336);
                                String a = p.a(faceResult);
                                Bundle bundle = new Bundle();
                                bundle.putInt("key_face_result_code", 0);
                                bundle.putString("key_face_result_file_path", a);
                                FaceDetectProcessService.a(FaceDetectProcessService.this, bundle);
                                AppMethodBeat.o(336);
                            }
                        });
                        AppMethodBeat.o(337);
                    }
                };
                f.V(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(339);
                        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
                        final FaceResult bsG = FaceDetectProcessService.this.lVR.bsG();
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(338);
                                anonymousClass1.b(bsG);
                                AppMethodBeat.o(338);
                            }
                        });
                        AppMethodBeat.o(339);
                    }
                });
                break;
            case 4:
                com.tencent.mm.plugin.facedetect.e.a.btw().lZc = intent.getBooleanExtra("key_is_need_video", false);
                break;
            case 5:
                if (this.lVT != null) {
                    this.lVT.S(intent);
                    break;
                }
                break;
            case 6:
                String stringExtra2 = intent.getStringExtra("key_bio_buffer_path");
                Bundle bundle = new Bundle();
                bundle.putString("key_bio_buffer_path", stringExtra2);
                l(6, bundle);
                break;
            default:
                ab.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
        }
        onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.o(b.CTRL_INDEX);
        return onStartCommand;
    }

    public final IBinder Iu() {
        AppMethodBeat.i(s.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", Integer.valueOf(hashCode()));
        this.lVQ = new a();
        a aVar = this.lVQ;
        AppMethodBeat.o(s.CTRL_INDEX);
        return aVar;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(344);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(344);
        return onUnbind;
    }

    public final void onDestroy() {
        AppMethodBeat.i(345);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
        AppMethodBeat.o(345);
    }

    private void p(Message message) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX);
        try {
            if (this.lVS != null) {
                ab.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.lVS.hashCode()));
                this.lVS.send(message);
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.FaceDetectProcessService", e, "", new Object[0]);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX);
        }
    }

    private void ec(int i, int i2) {
        AppMethodBeat.i(k.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        p(message);
        AppMethodBeat.o(k.CTRL_INDEX);
    }

    private void l(int i, Bundle bundle) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.i.f.a.CTRL_INDEX);
        Message obtain = Message.obtain();
        obtain.what = i;
        if (bundle != null) {
            obtain.setData(bundle);
        }
        p(obtain);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.i.f.a.CTRL_INDEX);
    }

    public final String getTag() {
        return "MicroMsg.FaceDetectProcessService";
    }
}
