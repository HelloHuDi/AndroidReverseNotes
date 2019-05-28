package com.tencent.p177mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView */
public class MMSightRecordView extends FrameLayout {
    public static C12537b osZ;
    public C21288e osY;

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$h */
    public interface C3474h {
        /* renamed from: dX */
        void mo7934dX(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$a */
    public interface C12536a {
        /* renamed from: q */
        void mo24462q(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$b */
    public interface C12537b {
        C21288e asn();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$c */
    public interface C21285c {
        void aDp();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$d */
    public interface C21286d {
        void aDo();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$f */
    public interface C21287f {
        void aDr();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$e */
    public static abstract class C21288e {
        /* renamed from: EL */
        public abstract boolean mo36674EL();

        /* renamed from: a */
        public abstract void mo36675a(C21289g c21289g, boolean z);

        /* renamed from: a */
        public abstract void mo36676a(C3474h c3474h);

        /* renamed from: a */
        public abstract void mo36677a(ByteBuffer byteBuffer, C21287f c21287f);

        public abstract void aso();

        public abstract void ast();

        public abstract void asu();

        /* renamed from: b */
        public abstract void mo36681b(Context context, ViewGroup viewGroup);

        public abstract int getCameraRotation();

        public abstract Bitmap getCurrentFramePicture();

        public abstract Point getDrawSizePoint();

        public abstract int getFlashMode();

        public abstract Point getPictureSize();

        public abstract Point getPreviewSize();

        public abstract String getVideoFilePath();

        public abstract Point getVideoSize();

        public abstract void release();

        public abstract void setClipPictureSize(boolean z);

        public abstract void setClipVideoSize(boolean z);

        public abstract void setDisplayRatio(float f);

        public abstract void setEnableDragZoom(boolean z);

        public abstract void setEnableTouchFocus(boolean z);

        public abstract void setFlashMode(int i);

        public abstract void setFrameDataCallback(C12536a c12536a);

        public abstract void setInitDoneCallback(C21285c c21285c);

        public abstract void setInitErrorCallback(C21286d c21286d);

        public abstract void setPreviewSizeLimit(int i);

        public abstract void setRGBSizeLimit(int i);

        public abstract void setUseBackCamera(boolean z);

        public abstract void setVideoFilePath(String str);

        public abstract void setVideoPara$2e715812(int i);

        public abstract void startPreview();

        public abstract void switchCamera();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.MMSightRecordView$g */
    public interface C21289g {
        /* renamed from: F */
        void mo21838F(Bitmap bitmap);

        void aDq();
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(60282);
        init(context);
        AppMethodBeat.m2505o(60282);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(60283);
        init(context);
        AppMethodBeat.m2505o(60283);
    }

    public MMSightRecordView(Context context) {
        super(context);
        AppMethodBeat.m2504i(60284);
        init(context);
        AppMethodBeat.m2505o(60284);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(60285);
        this.osY = osZ.asn();
        this.osY.mo36681b(context, this);
        AppMethodBeat.m2505o(60285);
    }

    public void setInitErrorCallback(C21286d c21286d) {
        AppMethodBeat.m2504i(60286);
        this.osY.setInitErrorCallback(c21286d);
        AppMethodBeat.m2505o(60286);
    }

    public void setInitDoneCallback(C21285c c21285c) {
        AppMethodBeat.m2504i(60287);
        this.osY.setInitDoneCallback(c21285c);
        AppMethodBeat.m2505o(60287);
    }

    public void setDisplayRatio(float f) {
        AppMethodBeat.m2504i(60288);
        this.osY.setDisplayRatio(f);
        AppMethodBeat.m2505o(60288);
    }

    public void setPreviewSizeLimit(int i) {
        AppMethodBeat.m2504i(60289);
        this.osY.setPreviewSizeLimit(i);
        AppMethodBeat.m2505o(60289);
    }

    public final void setVideoPara$2e715812(int i) {
        AppMethodBeat.m2504i(60290);
        this.osY.setVideoPara$2e715812(i);
        AppMethodBeat.m2505o(60290);
    }

    public void setVideoFilePath(String str) {
        AppMethodBeat.m2504i(60291);
        this.osY.setVideoFilePath(str);
        AppMethodBeat.m2505o(60291);
    }

    public String getVideoFilePath() {
        AppMethodBeat.m2504i(60292);
        String videoFilePath = this.osY.getVideoFilePath();
        AppMethodBeat.m2505o(60292);
        return videoFilePath;
    }

    /* renamed from: a */
    public final void mo36649a(C3474h c3474h) {
        AppMethodBeat.m2504i(60293);
        this.osY.mo36676a(c3474h);
        AppMethodBeat.m2505o(60293);
    }

    /* renamed from: a */
    public final void mo36648a(C21289g c21289g, boolean z) {
        AppMethodBeat.m2504i(60294);
        this.osY.mo36675a(c21289g, z);
        AppMethodBeat.m2505o(60294);
    }

    public void setUseBackCamera(boolean z) {
        AppMethodBeat.m2504i(60295);
        this.osY.setUseBackCamera(z);
        AppMethodBeat.m2505o(60295);
    }

    public Point getPictureSize() {
        AppMethodBeat.m2504i(60296);
        Point pictureSize = this.osY.getPictureSize();
        AppMethodBeat.m2505o(60296);
        return pictureSize;
    }

    public Point getVideoSize() {
        AppMethodBeat.m2504i(60297);
        Point videoSize = this.osY.getVideoSize();
        AppMethodBeat.m2505o(60297);
        return videoSize;
    }

    public Point getPreviewSize() {
        AppMethodBeat.m2504i(60298);
        Point previewSize = this.osY.getPreviewSize();
        AppMethodBeat.m2505o(60298);
        return previewSize;
    }

    public Point getDrawSizePoint() {
        AppMethodBeat.m2504i(60299);
        Point drawSizePoint = this.osY.getDrawSizePoint();
        AppMethodBeat.m2505o(60299);
        return drawSizePoint;
    }

    public void setFrameDataCallback(C12536a c12536a) {
        AppMethodBeat.m2504i(60300);
        this.osY.setFrameDataCallback(c12536a);
        AppMethodBeat.m2505o(60300);
    }

    public int getCameraRotation() {
        AppMethodBeat.m2504i(60301);
        int cameraRotation = this.osY.getCameraRotation();
        AppMethodBeat.m2505o(60301);
        return cameraRotation;
    }

    public void setClipVideoSize(boolean z) {
        AppMethodBeat.m2504i(60302);
        this.osY.setClipVideoSize(z);
        AppMethodBeat.m2505o(60302);
    }

    public void setClipPictureSize(boolean z) {
        AppMethodBeat.m2504i(60303);
        this.osY.setClipPictureSize(z);
        AppMethodBeat.m2505o(60303);
    }

    public void setFlashMode(int i) {
        AppMethodBeat.m2504i(60304);
        this.osY.setFlashMode(i);
        AppMethodBeat.m2505o(60304);
    }

    public int getFlashMode() {
        AppMethodBeat.m2504i(60305);
        int flashMode = this.osY.getFlashMode();
        AppMethodBeat.m2505o(60305);
        return flashMode;
    }

    public void setEnableDragZoom(boolean z) {
        AppMethodBeat.m2504i(60306);
        this.osY.setEnableDragZoom(z);
        AppMethodBeat.m2505o(60306);
    }

    public void setEnableTouchFocus(boolean z) {
        AppMethodBeat.m2504i(60307);
        this.osY.setEnableTouchFocus(z);
        AppMethodBeat.m2505o(60307);
    }

    public void setRGBSizeLimit(int i) {
        AppMethodBeat.m2504i(60308);
        this.osY.setRGBSizeLimit(i);
        AppMethodBeat.m2505o(60308);
    }

    public Bitmap getCurrentFramePicture() {
        AppMethodBeat.m2504i(60309);
        Bitmap currentFramePicture = this.osY.getCurrentFramePicture();
        AppMethodBeat.m2505o(60309);
        return currentFramePicture;
    }

    /* renamed from: a */
    public final void mo36650a(ByteBuffer byteBuffer, C21287f c21287f) {
        AppMethodBeat.m2504i(60310);
        this.osY.mo36677a(byteBuffer, c21287f);
        AppMethodBeat.m2505o(60310);
    }
}
