package com.tencent.p177mm.plugin.facedetectaction.p967b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceActionUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

/* renamed from: com.tencent.mm.plugin.facedetectaction.b.a */
public final class C45922a {
    public int hGq;
    public Camera mCamera;
    public Context mContext;
    public int mDesiredPreviewHeight;
    public int mDesiredPreviewWidth;
    public int mbW;
    public String mbX;
    public FaceActionUI mbY;
    public TextView mbZ;
    public C20665a mca;
    public Rect mcb;
    public Rect mcc;
    int mcd;
    int mce;
    float mcf;
    float mcg;
    public FaceTraceingNotice mch;
    public FaceDetectResult mci;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$a */
    public interface C20665a {
        /* renamed from: a */
        void mo35962a(FaceStatus faceStatus, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$b */
    public static class C27943b {
        private static C45922a mcl = new C45922a();

        static {
            AppMethodBeat.m2504i(681);
            AppMethodBeat.m2505o(681);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$1 */
    public class C390291 implements FaceTraceingNotice {

        /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$1$1 */
        class C390281 implements PoseDetectResult {
            C390281() {
            }

            public final void onSuccess() {
                AppMethodBeat.m2504i(676);
                C4990ab.m7416i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start success");
                AppMethodBeat.m2505o(676);
            }

            public final void onFailed(int i, String str, String str2) {
                AppMethodBeat.m2504i(677);
                C4990ab.m7417i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start failed：[%s],[%s]", str, str2);
                AppMethodBeat.m2505o(677);
            }
        }

        public final void onTracing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(678);
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "Face mState：init");
                    YTPoseDetectInterface.start(C4996ah.getContext(), C45922a.this.mCamera, C45922a.this.hGq, new C390281());
                    AppMethodBeat.m2505o(678);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "Face mState：detecting");
                    C45922a c45922a = C45922a.this;
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "setFaceRect（）");
                    c45922a.mcd = c45922a.mbY.getResources().getDisplayMetrics().widthPixels;
                    c45922a.mce = c45922a.mbY.getResources().getDisplayMetrics().heightPixels;
                    c45922a.mcc.left = (int) (((double) c45922a.mcd) * 0.15d);
                    c45922a.mcc.right = (int) (((double) c45922a.mcd) * 0.85d);
                    c45922a.mcc.top = (int) (((double) c45922a.mce) * 0.2d);
                    c45922a.mcc.bottom = (int) (((double) c45922a.mce) * 0.65d);
                    c45922a = C45922a.this;
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "setFaceLiveRect（）");
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInPreviewFrame is".concat(String.valueOf(rect)));
                    if (rect != null) {
                        int i2 = c45922a.mcd;
                        int i3 = c45922a.mce;
                        int i4 = c45922a.mDesiredPreviewWidth;
                        int i5 = c45922a.mDesiredPreviewHeight;
                        c45922a.mcf = ((float) i2) / ((float) i5);
                        c45922a.mcg = ((float) i3) / ((float) i4);
                        c45922a.mcb.left = (int) (((float) rect.left) * c45922a.mcf);
                        c45922a.mcb.right = (int) (((float) rect.right) * c45922a.mcf);
                        c45922a.mcb.top = (int) (((float) rect.top) * c45922a.mcg);
                        c45922a.mcb.bottom = (int) (((float) rect.bottom) * c45922a.mcg);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "mUiWidth：" + c45922a.mcd);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "mUiHeight：" + c45922a.mce);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "previewWidth：".concat(String.valueOf(i4)));
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "previewHeight：".concat(String.valueOf(i5)));
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInPreviewFrame.right：" + rect.right);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "mWidthRatio：" + c45922a.mcf);
                    }
                    c45922a = C45922a.this;
                    Rect rect2 = C45922a.this.mcc;
                    Rect rect3 = C45922a.this.mcb;
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "getFacePreviewAdvise（）");
                    if (faceStatus != null) {
                        boolean contains = rect2.contains(rect3);
                        float f = ((float) ((rect3.right - rect3.left) * (rect3.bottom - rect3.top))) / ((float) ((rect2.right - rect2.left) * (rect2.bottom - rect2.top)));
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInScreen left is ：" + rect3.left);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInScreen right is ：" + rect3.right);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInScreen top is ：" + rect3.top);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceInScreen bottom is ：" + rect3.bottom);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "checkRect left is ：" + rect2.left);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "checkRect right is ：" + rect2.right);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "checkRect top is ：" + rect2.top);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "checkRect bottom is ：" + rect2.bottom);
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "faceProportion ：".concat(String.valueOf(f)));
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "isInRect？ ：".concat(String.valueOf(contains)));
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "status".concat(String.valueOf(faceStatus)));
                        if (((double) f) >= 0.3d) {
                            if (((double) f) <= 0.75d) {
                                if (contains) {
                                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "Detecting result：normal");
                                    C4990ab.m7417i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", Integer.valueOf(c45922a.mbW), c45922a.mbX);
                                    if (c45922a.mbX == null) {
                                        switch (c45922a.mbW) {
                                            case 0:
                                                c45922a.mbZ.setText(C25738R.string.bjd);
                                                break;
                                            case 1:
                                                c45922a.mbZ.setText(C25738R.string.bjb);
                                                break;
                                            case 2:
                                                c45922a.mbZ.setText(C25738R.string.bjc);
                                                break;
                                        }
                                    }
                                    c45922a.mbZ.setText(c45922a.mbX);
                                    c45922a.mca.mo35962a(faceStatus, bArr);
                                    break;
                                }
                                C4990ab.m7416i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                                c45922a.mbZ.setText(C25738R.string.bla);
                                AppMethodBeat.m2505o(678);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.FaceActionLogic", "Detecting result：too close");
                            c45922a.mbZ.setText(C25738R.string.ble);
                            AppMethodBeat.m2505o(678);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.FaceActionLogic", "Detecting result：too far");
                        c45922a.mbZ.setText(C25738R.string.blf);
                        AppMethodBeat.m2505o(678);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "status == null");
                    c45922a.mbZ.setText(C25738R.string.bla);
                    AppMethodBeat.m2505o(678);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.FaceActionLogic", "Face mState：stop detect");
                    AppMethodBeat.m2505o(678);
                    return;
            }
            AppMethodBeat.m2505o(678);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$2 */
    public class C459212 implements FaceDetectResult {
        public final void onSuccess() {
            AppMethodBeat.m2504i(679);
            C4990ab.m7416i("MicroMsg.FaceActionLogic", "camera detect success ");
            AppMethodBeat.m2505o(679);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(680);
            C4990ab.m7417i("MicroMsg.FaceActionLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", Integer.valueOf(i), str, str2);
            AppMethodBeat.m2505o(680);
        }
    }

    /* synthetic */ C45922a(byte b) {
        this();
    }

    private C45922a() {
    }
}
