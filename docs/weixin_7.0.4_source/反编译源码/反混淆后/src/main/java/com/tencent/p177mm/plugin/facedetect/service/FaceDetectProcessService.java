package com.tencent.p177mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C2262b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33325s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C19400k;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f.C10436a;
import com.tencent.p177mm.plugin.facedetect.FaceProNative;
import com.tencent.p177mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.p177mm.plugin.facedetect.model.C11810f;
import com.tencent.p177mm.plugin.facedetect.model.C43032g;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.C43037q;
import com.tencent.p177mm.plugin.facedetect.model.FaceContextData;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.service.MMService;

/* renamed from: com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService */
public class FaceDetectProcessService extends MMService {
    private C34101a lVQ = new C34101a();
    public C43032g lVR = null;
    private Messenger lVS = null;
    private C39014a lVT = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService$1 */
    class C341001 implements C43037q {
        C341001() {
        }

        /* renamed from: b */
        public final void mo54656b(final FaceResult faceResult) {
            int i = -1;
            AppMethodBeat.m2504i(337);
            String str = "MicroMsg.FaceDetectProcessService";
            String str2 = "alvinluo release out result == null:%b, result: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(faceResult == null);
            objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
            C4990ab.m7417i(str, str2, objArr);
            if (faceResult == null || faceResult.result != 0) {
                C4990ab.m7416i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                if (faceResult != null) {
                    i = faceResult.result;
                }
                FaceDetectProcessService.m55895a(FaceDetectProcessService.this, i);
                AppMethodBeat.m2505o(337);
                return;
            }
            C11810f.m19659V(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(336);
                    String a = C43036p.m76430a(faceResult);
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_face_result_code", 0);
                    bundle.putString("key_face_result_file_path", a);
                    FaceDetectProcessService.m55896a(FaceDetectProcessService.this, bundle);
                    AppMethodBeat.m2505o(336);
                }
            });
            AppMethodBeat.m2505o(337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService$a */
    public class C34101a extends Binder {
    }

    public FaceDetectProcessService() {
        AppMethodBeat.m2504i(340);
        AppMethodBeat.m2505o(340);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
        C4990ab.m7417i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", Integer.valueOf(hashCode()));
        super.onCreate();
        this.lVR = new C43032g();
        AppMethodBeat.m2505o(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(C2262b.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        int onStartCommand;
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C2262b.CTRL_INDEX);
            return onStartCommand;
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.lVS = messenger;
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C2262b.CTRL_INDEX);
            return onStartCommand;
        }
        C4990ab.m7417i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", Integer.valueOf(intent.getIntExtra("k_cmd", -1)));
        switch (intent.getIntExtra("k_cmd", -1)) {
            case 0:
                C39014a c39014a;
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.m85187a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("k_server_scene", 2)) {
                    case 0:
                    case 1:
                        c39014a = null;
                        break;
                    case 2:
                    case 5:
                        c39014a = new C45919b();
                        break;
                    default:
                        c39014a = null;
                        break;
                }
                this.lVT = c39014a;
                C43032g c43032g = this.lVR;
                if (c43032g.lTP != null) {
                    C4990ab.m7420w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    c43032g.bsH();
                }
                if (C43036p.bsN()) {
                    c43032g.lTP = new FaceProNative();
                    onStartCommand = c43032g.lTP.engineInit(stringExtra, byteArrayExtra, C43036p.bsP(), C43036p.bsQ());
                    C4990ab.m7417i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", Integer.valueOf(onStartCommand));
                } else {
                    C4990ab.m7420w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    onStartCommand = -4;
                }
                m55897ec(0, onStartCommand);
                break;
            case 1:
                final C341001 c341001 = new C341001();
                C11810f.m19659V(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(339);
                        C4990ab.m7416i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
                        final FaceResult bsG = FaceDetectProcessService.this.lVR.bsG();
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(338);
                                c341001.mo54656b(bsG);
                                AppMethodBeat.m2505o(338);
                            }
                        });
                        AppMethodBeat.m2505o(339);
                    }
                });
                break;
            case 4:
                C27922a.btw().lZc = intent.getBooleanExtra("key_is_need_video", false);
                break;
            case 5:
                if (this.lVT != null) {
                    this.lVT.mo61919S(intent);
                    break;
                }
                break;
            case 6:
                String stringExtra2 = intent.getStringExtra("key_bio_buffer_path");
                Bundle bundle = new Bundle();
                bundle.putString("key_bio_buffer_path", stringExtra2);
                m55898l(6, bundle);
                break;
            default:
                C4990ab.m7412e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
        }
        onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.m2505o(C2262b.CTRL_INDEX);
        return onStartCommand;
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        AppMethodBeat.m2504i(C33325s.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", Integer.valueOf(hashCode()));
        this.lVQ = new C34101a();
        C34101a c34101a = this.lVQ;
        AppMethodBeat.m2505o(C33325s.CTRL_INDEX);
        return c34101a;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(344);
        C4990ab.m7416i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(344);
        return onUnbind;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(345);
        C4990ab.m7416i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
        AppMethodBeat.m2505o(345);
    }

    /* renamed from: p */
    private void m55899p(Message message) {
        AppMethodBeat.m2504i(C45604f.CTRL_INDEX);
        try {
            if (this.lVS != null) {
                C4990ab.m7417i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.lVS.hashCode()));
                this.lVS.send(message);
            }
            AppMethodBeat.m2505o(C45604f.CTRL_INDEX);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceDetectProcessService", e, "", new Object[0]);
            AppMethodBeat.m2505o(C45604f.CTRL_INDEX);
        }
    }

    /* renamed from: ec */
    private void m55897ec(int i, int i2) {
        AppMethodBeat.m2504i(C19400k.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        m55899p(message);
        AppMethodBeat.m2505o(C19400k.CTRL_INDEX);
    }

    /* renamed from: l */
    private void m55898l(int i, Bundle bundle) {
        AppMethodBeat.m2504i(C10436a.CTRL_INDEX);
        Message obtain = Message.obtain();
        obtain.what = i;
        if (bundle != null) {
            obtain.setData(bundle);
        }
        m55899p(obtain);
        AppMethodBeat.m2505o(C10436a.CTRL_INDEX);
    }

    public final String getTag() {
        return "MicroMsg.FaceDetectProcessService";
    }
}
