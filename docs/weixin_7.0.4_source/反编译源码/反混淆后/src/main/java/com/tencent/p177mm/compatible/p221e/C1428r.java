package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p223i.C1436b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import java.util.Map;

/* renamed from: com.tencent.mm.compatible.e.r */
final class C1428r {
    C1428r() {
    }

    /* renamed from: a */
    public static boolean m3051a(String str, C1423o c1423o, C1418c c1418c, C1416b c1416b, C1419k c1419k, C1432x c1432x, C1415ac c1415ac, C1429s c1429s, C1431w c1431w, C1413aa c1413aa, C1430v c1430v, C1412a c1412a, C1430v c1430v2) {
        AppMethodBeat.m2504i(92991);
        try {
            C4990ab.m7410d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(str)));
            Map z = C5049br.m7595z(str, "deviceinfoconfig");
            if (z == null) {
                C4990ab.m7416i("MicroMsg.DeviceInfoParser", "hy: null device config");
                AppMethodBeat.m2505o(92991);
                return false;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                c1423o.esP = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                c1423o.esO = true;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                c1423o.esQ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                c1423o.esO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.num") != null) {
                c1418c.eqQ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.num"), 0);
                c1418c.eqR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.surface") != null) {
                c1418c.eqS = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.surface"), 0);
                c1418c.eqT = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.format") != null) {
                c1418c.eqW = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.format"), 0);
                c1418c.aTf = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.autofloat") != null) {
                c1418c.eqU = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.autofloat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
                c1418c.eqV = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                c1418c.eqZ.erD = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                c1418c.eqZ.fps = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                c1418c.eqZ.erE = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                c1418c.eqZ.rotate = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                c1418c.eqZ.erF = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                c1418c.eqZ.width = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                c1418c.eqZ.height = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                c1418c.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                c1418c.eqX.erD = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                c1418c.eqX.fps = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                c1418c.eqX.erE = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                c1418c.eqX.rotate = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                c1418c.eqX.erF = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                c1418c.eqX.width = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                c1418c.eqX.height = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                c1418c.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                c1418c.erc = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                c1418c.erd = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                c1418c.ere = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                c1418c.erf = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                c1418c.erg = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                c1418c.erh = true;
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                c1418c.erj = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                c1418c.eri = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                c1418c.erk = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                c1418c.erl = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                c1418c.erx = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                c1418c.ery = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                c1418c.erg = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                c1418c.erh = true;
                c1418c.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                c1418c.erj = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                c1418c.eri = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                c1418c.erm = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                c1418c.ern = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                c1418c.ero = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                c1418c.erp = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                c1418c.erq = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                c1418c.err = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                c1418c.ert = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                c1418c.eru = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                c1418c.erv = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                c1418c.erw = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
                c1418c.erz = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
                c1418c.erA = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
                c1418c.erB = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
                c1418c.erC = C5046bo.getBoolean((String) z.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
            }
            if (z.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                c1416b.epH = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.smode") != null) {
                c1416b.epI = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.smode"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.omode") != null) {
                c1416b.epJ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.omode"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                c1416b.epK = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.operating") != null) {
                c1416b.epL = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.operating"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                c1416b.epM = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                c1416b.epN = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                c1416b.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                c1416b.epO = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                c1416b.epP = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                c1416b.epQ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                c1416b.epR = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                c1416b.epS = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                c1416b.eqf = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                c1416b.eqe = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                c1416b.eqg = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                c1416b.eqh = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                c1416b.eqi = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                c1416b.eqj = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                c1416b.eqk = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                c1416b.eqm = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                c1416b.eqn = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                c1416b.eqo = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                c1416b.eqp = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                c1416b.eqq = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                c1416b.eqr = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                c1416b.eqs = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                c1416b.eqt = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                c1416b.equ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                c1416b.eqv = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                c1416b.eqw = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                c1416b.eqx = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                c1416b.epT = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                c1416b.epU = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                c1416b.epV = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                c1416b.epW = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                c1416b.epZ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                c1416b.eqa = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                c1416b.eqb = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                c1416b.eqc = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                c1416b.eqy = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                c1416b.eqz = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                c1416b.eqB[0] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                c1416b.eqB[1] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                c1416b.eqB[2] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                c1416b.eqB[3] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                c1416b.eqB[4] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                c1416b.eqB[5] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                c1416b.eqB[6] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                c1416b.eqB[7] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                c1416b.eqB[8] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                c1416b.eqB[9] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                c1416b.eqB[10] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                c1416b.eqB[11] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                c1416b.eqB[12] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                c1416b.eqB[13] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                c1416b.eqB[14] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                c1416b.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctoff") != null && C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                c1416b.eqA = 0;
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                c1416b.epX = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                c1416b.epY = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                c1416b.eqC[0] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                c1416b.eqC[1] = (short) C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                c1416b.eqM = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                c1416b.eqN = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                c1416b.eqO = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                c1416b.eqP = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                c1416b.eqE = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                c1416b.eqd = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                c1416b.epP = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                c1416b.eqG = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                c1416b.eqH = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                c1416b.eqI = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                c1416b.eqJ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                c1416b.eqK = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                c1416b.eqL = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                c1416b.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                c1419k.erQ = true;
                c1419k.erR = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                c1419k.erI = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                c1419k.erJ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                c1419k.erK = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                c1419k.erM = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                c1419k.erL = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                c1419k.erN = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                c1419k.erP = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                c1419k.erO = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.app") != null) {
                c1419k.erS = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                c1419k.esl = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                c1419k.esm = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                c1419k.esn = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                c1419k.eso = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                c1419k.erT = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                c1419k.erU = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                c1419k.erV = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                c1419k.erW = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.linespe") != null) {
                c1419k.erX = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                c1419k.esi = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                c1419k.erY = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                c1419k.erZ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                c1419k.esa = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                c1419k.esd = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                c1419k.esc = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                c1419k.ese = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                c1419k.esf = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                c1419k.esb = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                c1419k.ese = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                c1419k.esf = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.base") != null) {
                c1419k.esp = (String) z.get(".deviceinfoconfig.voip.common.base");
            }
            if (z.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                c1419k.esq = (String) z.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (z.get(".deviceinfoconfig.voip.common.classloader") != null) {
                c1419k.esr = (String) z.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (z.get(".deviceinfoconfig.voip.common.resources") != null) {
                c1419k.ess = (String) z.get(".deviceinfoconfig.voip.common.resources");
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                c1419k.esg = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                c1419k.est = (String) z.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                c1419k.esu = (String) z.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                c1419k.esv = (String) z.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                c1419k.esw = (String) z.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                c1419k.esx = (String) z.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (z.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                c1419k.esy = (String) z.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                c1419k.esh = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                c1419k.esz = (String) z.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                c1419k.esA = (String) z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.xBI = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.xBJ = C5046bo.getDouble((String) z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                c1419k.esB = (String) z.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (z.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                c1419k.esC = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                c1419k.esD = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                c1419k.esE = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                C1436b.m3062bK(c1419k.esE == 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                c1419k.esF = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                c1419k.esj = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                c1419k.esk = C5046bo.getDouble((String) z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                c1419k.esG = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
                c1419k.esH = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
                c1419k.esI = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                c1432x.etU = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                c1432x.mVideoWidth = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                c1432x.mVideoHeight = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                c1432x.etV = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                c1432x.etW = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                c1432x.etX = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                c1432x.etY = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                c1432x.etZ = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                c1432x.eua = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                c1432x.eub = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
                c1432x.euc = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                c1415ac.eui = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                c1415ac.euj = C5046bo.getInt((String) z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                C4990ab.m7417i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(c1415ac.euj));
                C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", c1415ac.euj).commit();
            }
            c1419k.dump();
            int i = C5046bo.getInt((String) z.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = C5046bo.getInt((String) z.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (c1429s != null) {
                c1429s.mo4878iS(i);
                c1429s.mo4877iR(i2);
            }
            int i3 = C5046bo.getInt((String) z.get(".deviceinfoconfig.soter.isSupport"), 0);
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(i3));
            if (c1413aa != null) {
                c1413aa.mo4846bJ(i3 > 0);
                c1413aa.mo4847iU(i3);
            }
            if (i == 11 && i2 == 11 && c1413aa != null) {
                c1429s.mo4878iS(1);
                c1429s.mo4877iR(1);
                c1413aa.mo4846bJ(true);
                c1413aa.mo4847iU(1);
                c1413aa.mo4845Mf();
                C4990ab.m7416i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
            }
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) z.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (c1431w != null) {
                c1431w.mo4883kv(r2);
            }
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", C5049br.m7595z(str, "manufacturerName"));
            if (c1431w != null) {
                c1431w.mo4881f(r2);
            }
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".deviceinfoconfig.style.swipback"), 0)));
            if (c1431w != null) {
                c1431w.mo4882iT(r2);
            }
            C4990ab.m7417i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(C5046bo.getInt((String) z.get(".deviceinfoconfig.game.isLimit"), 0)), (String) z.get(".deviceinfoconfig.game.limitPrompt"));
            if (c1412a != null) {
                c1412a.mo4843bG(i == 1);
                c1412a.mo4844kr(r2);
            }
            i = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            i2 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            i3 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i4 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i5 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i6 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i7 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i8 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i9 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i10 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            int i11 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            int i12 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
            int i13 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
            int i14 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
            int i15 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
            int i16 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
            int i17 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
            int i18 = C5046bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
            if (c1430v != null) {
                c1430v.etz = i;
                c1430v.etA = i2;
                c1430v.etB = i3;
                c1430v.etC = i4;
                c1430v.etD = i5;
                c1430v.etE = i6;
                c1430v.etF = i7;
                c1430v.etG = i8;
                c1430v.etH = i9;
                c1430v.etI = i10;
                c1430v.etJ = i11;
                c1430v.etM = i15;
                c1430v.etN = i16;
                c1430v.etO = i17;
                c1430v.etP = i18;
                C4990ab.m7417i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", c1430v.toString());
            }
            if (c1430v2 != null) {
                c1430v2.etz = i13;
                c1430v2.etA = i2;
                c1430v2.etB = i3;
                c1430v2.etC = i4;
                c1430v2.etD = i5;
                c1430v2.etE = i6;
                c1430v2.etF = i7;
                c1430v2.etG = i8;
                c1430v2.etH = i9;
                c1430v2.etI = i10;
                c1430v2.etJ = i11;
                c1430v2.etK = i12;
                c1430v2.etL = i14;
                C4990ab.m7417i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", c1430v2.toString());
            }
            AppMethodBeat.m2505o(92991);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(92991);
            return false;
        }
    }
}
