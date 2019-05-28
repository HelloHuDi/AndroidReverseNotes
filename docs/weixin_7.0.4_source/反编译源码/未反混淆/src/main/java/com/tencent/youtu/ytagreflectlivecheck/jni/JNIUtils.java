package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.FaceFrame;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLive;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JNIUtils {
    private static final String TAG = "LightLiveCheck";

    public static Timeval getTimeval() {
        AppMethodBeat.i(123169);
        long nanoTime = System.nanoTime() / 1000;
        Timeval timeval = new Timeval(nanoTime / 1000000, (int) (nanoTime % 1000000));
        AppMethodBeat.o(123169);
        return timeval;
    }

    public static PersonLiveReq translation(FullPack fullPack, String str) {
        AppMethodBeat.i(123170);
        PersonLiveReq personLiveReq = new PersonLiveReq();
        personLiveReq.setApp_id("starimeliu");
        personLiveReq.setBusiness_name("starimeliu");
        personLiveReq.setPerson_id("starimeliu");
        personLiveReq.setLivedata(translation(fullPack.AGin, fullPack.frames, str));
        personLiveReq.setLive_type(2);
        personLiveReq.setReq_type("live");
        AppMethodBeat.o(123170);
        return personLiveReq;
    }

    private static PersonLive translation(DataPack dataPack, byte[] bArr, String str) {
        AppMethodBeat.i(123171);
        PersonLive personLive = new PersonLive();
        personLive.setReflect_data(translation(dataPack, 0));
        personLive.setColor_data(str);
        personLive.setPlatform(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(translation(bArr));
        personLive.setFrames(arrayList);
        AppMethodBeat.o(123171);
        return personLive;
    }

    private static FaceFrame translation(byte[] bArr) {
        AppMethodBeat.i(123172);
        FaceFrame faceFrame = new FaceFrame();
        faceFrame.setImage(new String(Base64.encode(bArr, 2)));
        AppMethodBeat.o(123172);
        return faceFrame;
    }

    private static ReflectColorData translation(DataPack dataPack, int i) {
        AppMethodBeat.i(123173);
        ReflectColorData reflectColorData = new ReflectColorData();
        ArrayList arrayList = new ArrayList();
        for (RawImgData translation : dataPack.videoData) {
            arrayList.add(translation(translation));
        }
        reflectColorData.setImages_data(arrayList);
        reflectColorData.setBegin_time(dataPack.beginTime);
        reflectColorData.setChangepoint_time(dataPack.changePointTime);
        reflectColorData.setOffset_sys(dataPack.offsetSys);
        reflectColorData.setFrame_num(dataPack.frameNum);
        reflectColorData.setLandmark_num(dataPack.landMarkNum);
        reflectColorData.setWidth(dataPack.width);
        reflectColorData.setHeight(dataPack.height);
        try {
            reflectColorData.setLog(new String(dataPack.log, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        reflectColorData.setConfig_begin(dataPack.config_begin);
        AppMethodBeat.o(123173);
        return reflectColorData;
    }

    private static ColorImgData translation(RawImgData rawImgData) {
        AppMethodBeat.i(123174);
        ColorImgData colorImgData = new ColorImgData();
        colorImgData.setImage(new String(Base64.encode(rawImgData.frameBuffer, 2)));
        colorImgData.setCapture_time(rawImgData.captureTime);
        colorImgData.setX(rawImgData.x);
        colorImgData.setY(rawImgData.y);
        AppMethodBeat.o(123174);
        return colorImgData;
    }
}
