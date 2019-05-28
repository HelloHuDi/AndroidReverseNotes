package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MMSightRecordView extends FrameLayout {
    public static b osZ;
    public e osY;

    public interface h {
        void dX(boolean z);
    }

    public interface a {
        void q(byte[] bArr, int i, int i2);
    }

    public interface b {
        e asn();
    }

    public interface c {
        void aDp();
    }

    public interface d {
        void aDo();
    }

    public interface f {
        void aDr();
    }

    public static abstract class e {
        public abstract boolean EL();

        public abstract void a(g gVar, boolean z);

        public abstract void a(h hVar);

        public abstract void a(ByteBuffer byteBuffer, f fVar);

        public abstract void aso();

        public abstract void ast();

        public abstract void asu();

        public abstract void b(Context context, ViewGroup viewGroup);

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

        public abstract void setFrameDataCallback(a aVar);

        public abstract void setInitDoneCallback(c cVar);

        public abstract void setInitErrorCallback(d dVar);

        public abstract void setPreviewSizeLimit(int i);

        public abstract void setRGBSizeLimit(int i);

        public abstract void setUseBackCamera(boolean z);

        public abstract void setVideoFilePath(String str);

        public abstract void setVideoPara$2e715812(int i);

        public abstract void startPreview();

        public abstract void switchCamera();
    }

    public interface g {
        void F(Bitmap bitmap);

        void aDq();
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(60282);
        init(context);
        AppMethodBeat.o(60282);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(60283);
        init(context);
        AppMethodBeat.o(60283);
    }

    public MMSightRecordView(Context context) {
        super(context);
        AppMethodBeat.i(60284);
        init(context);
        AppMethodBeat.o(60284);
    }

    private void init(Context context) {
        AppMethodBeat.i(60285);
        this.osY = osZ.asn();
        this.osY.b(context, this);
        AppMethodBeat.o(60285);
    }

    public void setInitErrorCallback(d dVar) {
        AppMethodBeat.i(60286);
        this.osY.setInitErrorCallback(dVar);
        AppMethodBeat.o(60286);
    }

    public void setInitDoneCallback(c cVar) {
        AppMethodBeat.i(60287);
        this.osY.setInitDoneCallback(cVar);
        AppMethodBeat.o(60287);
    }

    public void setDisplayRatio(float f) {
        AppMethodBeat.i(60288);
        this.osY.setDisplayRatio(f);
        AppMethodBeat.o(60288);
    }

    public void setPreviewSizeLimit(int i) {
        AppMethodBeat.i(60289);
        this.osY.setPreviewSizeLimit(i);
        AppMethodBeat.o(60289);
    }

    public final void setVideoPara$2e715812(int i) {
        AppMethodBeat.i(60290);
        this.osY.setVideoPara$2e715812(i);
        AppMethodBeat.o(60290);
    }

    public void setVideoFilePath(String str) {
        AppMethodBeat.i(60291);
        this.osY.setVideoFilePath(str);
        AppMethodBeat.o(60291);
    }

    public String getVideoFilePath() {
        AppMethodBeat.i(60292);
        String videoFilePath = this.osY.getVideoFilePath();
        AppMethodBeat.o(60292);
        return videoFilePath;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(60293);
        this.osY.a(hVar);
        AppMethodBeat.o(60293);
    }

    public final void a(g gVar, boolean z) {
        AppMethodBeat.i(60294);
        this.osY.a(gVar, z);
        AppMethodBeat.o(60294);
    }

    public void setUseBackCamera(boolean z) {
        AppMethodBeat.i(60295);
        this.osY.setUseBackCamera(z);
        AppMethodBeat.o(60295);
    }

    public Point getPictureSize() {
        AppMethodBeat.i(60296);
        Point pictureSize = this.osY.getPictureSize();
        AppMethodBeat.o(60296);
        return pictureSize;
    }

    public Point getVideoSize() {
        AppMethodBeat.i(60297);
        Point videoSize = this.osY.getVideoSize();
        AppMethodBeat.o(60297);
        return videoSize;
    }

    public Point getPreviewSize() {
        AppMethodBeat.i(60298);
        Point previewSize = this.osY.getPreviewSize();
        AppMethodBeat.o(60298);
        return previewSize;
    }

    public Point getDrawSizePoint() {
        AppMethodBeat.i(60299);
        Point drawSizePoint = this.osY.getDrawSizePoint();
        AppMethodBeat.o(60299);
        return drawSizePoint;
    }

    public void setFrameDataCallback(a aVar) {
        AppMethodBeat.i(60300);
        this.osY.setFrameDataCallback(aVar);
        AppMethodBeat.o(60300);
    }

    public int getCameraRotation() {
        AppMethodBeat.i(60301);
        int cameraRotation = this.osY.getCameraRotation();
        AppMethodBeat.o(60301);
        return cameraRotation;
    }

    public void setClipVideoSize(boolean z) {
        AppMethodBeat.i(60302);
        this.osY.setClipVideoSize(z);
        AppMethodBeat.o(60302);
    }

    public void setClipPictureSize(boolean z) {
        AppMethodBeat.i(60303);
        this.osY.setClipPictureSize(z);
        AppMethodBeat.o(60303);
    }

    public void setFlashMode(int i) {
        AppMethodBeat.i(60304);
        this.osY.setFlashMode(i);
        AppMethodBeat.o(60304);
    }

    public int getFlashMode() {
        AppMethodBeat.i(60305);
        int flashMode = this.osY.getFlashMode();
        AppMethodBeat.o(60305);
        return flashMode;
    }

    public void setEnableDragZoom(boolean z) {
        AppMethodBeat.i(60306);
        this.osY.setEnableDragZoom(z);
        AppMethodBeat.o(60306);
    }

    public void setEnableTouchFocus(boolean z) {
        AppMethodBeat.i(60307);
        this.osY.setEnableTouchFocus(z);
        AppMethodBeat.o(60307);
    }

    public void setRGBSizeLimit(int i) {
        AppMethodBeat.i(60308);
        this.osY.setRGBSizeLimit(i);
        AppMethodBeat.o(60308);
    }

    public Bitmap getCurrentFramePicture() {
        AppMethodBeat.i(60309);
        Bitmap currentFramePicture = this.osY.getCurrentFramePicture();
        AppMethodBeat.o(60309);
        return currentFramePicture;
    }

    public final void a(ByteBuffer byteBuffer, f fVar) {
        AppMethodBeat.i(60310);
        this.osY.a(byteBuffer, fVar);
        AppMethodBeat.o(60310);
    }
}
