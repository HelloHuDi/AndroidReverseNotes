package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class r {
    r() {
    }

    public static boolean a(String str, o oVar, c cVar, b bVar, k kVar, x xVar, ac acVar, s sVar, w wVar, aa aaVar, v vVar, a aVar, v vVar2) {
        AppMethodBeat.i(92991);
        try {
            ab.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(str)));
            Map z = br.z(str, "deviceinfoconfig");
            if (z == null) {
                ab.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                AppMethodBeat.o(92991);
                return false;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                oVar.esP = bo.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                oVar.esO = true;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                oVar.esQ = bo.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                oVar.esO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.num") != null) {
                cVar.eqQ = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.num"), 0);
                cVar.eqR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.surface") != null) {
                cVar.eqS = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.surface"), 0);
                cVar.eqT = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.format") != null) {
                cVar.eqW = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.format"), 0);
                cVar.aTf = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.autofloat") != null) {
                cVar.eqU = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.autofloat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
                cVar.eqV = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                cVar.eqZ.erD = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                cVar.eqZ.fps = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                cVar.eqZ.erE = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                cVar.eqZ.rotate = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                cVar.eqZ.erF = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                cVar.eqZ.width = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                cVar.eqZ.height = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                cVar.era = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                cVar.eqX.erD = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                cVar.eqX.fps = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                cVar.eqX.erE = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                cVar.eqX.rotate = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                cVar.eqX.erF = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                cVar.eqX.width = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                cVar.eqX.height = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                cVar.eqY = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                cVar.erc = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                cVar.erd = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                cVar.ere = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                cVar.erf = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.erg = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.erh = true;
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.erj = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.eri = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                cVar.erk = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                cVar.erl = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                cVar.erx = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                cVar.ery = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.erg = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.erh = true;
                cVar.erb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.erj = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.eri = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                cVar.erm = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                cVar.ern = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                cVar.ero = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                cVar.erp = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                cVar.erq = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                cVar.err = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                cVar.ert = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                cVar.eru = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                cVar.erv = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                cVar.erw = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
                cVar.erz = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
                cVar.erA = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
                cVar.erB = bo.getInt((String) z.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
                cVar.erC = bo.getBoolean((String) z.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
            }
            if (z.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                bVar.epH = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.smode") != null) {
                bVar.epI = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.smode"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.omode") != null) {
                bVar.epJ = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.omode"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                bVar.epK = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.operating") != null) {
                bVar.epL = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.operating"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                bVar.epM = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                bVar.epN = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                bVar.epG = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                bVar.epO = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.epP = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                bVar.epQ = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                bVar.epR = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                bVar.epS = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                bVar.eqf = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                bVar.eqe = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                bVar.eqg = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                bVar.eqh = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                bVar.eqi = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                bVar.eqj = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                bVar.eqk = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                bVar.eqm = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                bVar.eqn = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                bVar.eqo = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                bVar.eqp = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                bVar.eqq = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                bVar.eqr = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                bVar.eqs = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                bVar.eqt = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                bVar.equ = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                bVar.eqv = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                bVar.eqw = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                bVar.eqx = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                bVar.epT = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                bVar.epU = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                bVar.epV = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                bVar.epW = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                bVar.epZ = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                bVar.eqa = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                bVar.eqb = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                bVar.eqc = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                bVar.eqy = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                bVar.eqz = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                bVar.eqB[0] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                bVar.eqB[1] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                bVar.eqB[2] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                bVar.eqB[3] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                bVar.eqB[4] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                bVar.eqB[5] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                bVar.eqB[6] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                bVar.eqB[7] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                bVar.eqB[8] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                bVar.eqB[9] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                bVar.eqB[10] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                bVar.eqB[11] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                bVar.eqB[12] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                bVar.eqB[13] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                bVar.eqB[14] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                bVar.eqA = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctoff") != null && bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                bVar.eqA = 0;
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                bVar.epX = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                bVar.epY = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                bVar.eqC[0] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                bVar.eqC[1] = (short) bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                bVar.eqM = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                bVar.eqN = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                bVar.eqO = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                bVar.eqP = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                bVar.eqE = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                bVar.eqd = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.epP = bo.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                bVar.eqG = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                bVar.eqH = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                bVar.eqI = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                bVar.eqJ = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                bVar.eqK = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                bVar.eqL = bo.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                bVar.eqF = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.erQ = true;
                kVar.erR = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.erI = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                kVar.erJ = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                kVar.erK = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                kVar.erM = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                kVar.erL = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                kVar.erN = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                kVar.erP = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                kVar.erO = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.app") != null) {
                kVar.erS = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                kVar.esl = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                kVar.esm = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                kVar.esn = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                kVar.eso = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                kVar.erT = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                kVar.erU = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                kVar.erV = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                kVar.erW = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.linespe") != null) {
                kVar.erX = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                kVar.esi = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                kVar.erY = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                kVar.erZ = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                kVar.esa = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                kVar.esd = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                kVar.esc = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.ese = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.esf = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                kVar.esb = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.ese = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.esf = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.base") != null) {
                kVar.esp = (String) z.get(".deviceinfoconfig.voip.common.base");
            }
            if (z.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                kVar.esq = (String) z.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (z.get(".deviceinfoconfig.voip.common.classloader") != null) {
                kVar.esr = (String) z.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (z.get(".deviceinfoconfig.voip.common.resources") != null) {
                kVar.ess = (String) z.get(".deviceinfoconfig.voip.common.resources");
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                kVar.esg = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                kVar.est = (String) z.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                kVar.esu = (String) z.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                kVar.esv = (String) z.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                kVar.esw = (String) z.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                kVar.esx = (String) z.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (z.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                kVar.esy = (String) z.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                kVar.esh = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                kVar.esz = (String) z.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                kVar.esA = (String) z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == bo.getInt((String) z.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.xBI = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.xBJ = bo.getDouble((String) z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                kVar.esB = (String) z.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (z.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                kVar.esC = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                kVar.esD = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                kVar.esE = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                b.bK(kVar.esE == 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                kVar.esF = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                kVar.esj = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                kVar.esk = bo.getDouble((String) z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                kVar.esG = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
                kVar.esH = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
                kVar.esI = bo.getInt((String) z.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                xVar.etU = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                xVar.mVideoWidth = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                xVar.mVideoHeight = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                xVar.etV = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                xVar.etW = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                xVar.etX = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                xVar.etY = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                xVar.etZ = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                xVar.eua = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                xVar.eub = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
                xVar.euc = bo.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                acVar.eui = bo.getInt((String) z.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                acVar.euj = bo.getInt((String) z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                ab.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(acVar.euj));
                ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", acVar.euj).commit();
            }
            kVar.dump();
            int i = bo.getInt((String) z.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = bo.getInt((String) z.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            ab.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (sVar != null) {
                sVar.iS(i);
                sVar.iR(i2);
            }
            int i3 = bo.getInt((String) z.get(".deviceinfoconfig.soter.isSupport"), 0);
            ab.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(i3));
            if (aaVar != null) {
                aaVar.bJ(i3 > 0);
                aaVar.iU(i3);
            }
            if (i == 11 && i2 == 11 && aaVar != null) {
                sVar.iS(1);
                sVar.iR(1);
                aaVar.bJ(true);
                aaVar.iU(1);
                aaVar.Mf();
                ab.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
            }
            ab.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) z.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (wVar != null) {
                wVar.kv(r2);
            }
            ab.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", br.z(str, "manufacturerName"));
            if (wVar != null) {
                wVar.f(r2);
            }
            ab.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(bo.getInt((String) z.get(".deviceinfoconfig.style.swipback"), 0)));
            if (wVar != null) {
                wVar.iT(r2);
            }
            ab.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(bo.getInt((String) z.get(".deviceinfoconfig.game.isLimit"), 0)), (String) z.get(".deviceinfoconfig.game.limitPrompt"));
            if (aVar != null) {
                aVar.bG(i == 1);
                aVar.kr(r2);
            }
            i = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            i2 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            i3 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i4 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i5 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i6 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i7 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i8 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i9 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i10 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            int i11 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            int i12 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
            int i13 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
            int i14 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
            int i15 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
            int i16 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
            int i17 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
            int i18 = bo.getInt((String) z.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
            if (vVar != null) {
                vVar.etz = i;
                vVar.etA = i2;
                vVar.etB = i3;
                vVar.etC = i4;
                vVar.etD = i5;
                vVar.etE = i6;
                vVar.etF = i7;
                vVar.etG = i8;
                vVar.etH = i9;
                vVar.etI = i10;
                vVar.etJ = i11;
                vVar.etM = i15;
                vVar.etN = i16;
                vVar.etO = i17;
                vVar.etP = i18;
                ab.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", vVar.toString());
            }
            if (vVar2 != null) {
                vVar2.etz = i13;
                vVar2.etA = i2;
                vVar2.etB = i3;
                vVar2.etC = i4;
                vVar2.etD = i5;
                vVar2.etE = i6;
                vVar2.etF = i7;
                vVar2.etG = i8;
                vVar2.etH = i9;
                vVar2.etI = i10;
                vVar2.etJ = i11;
                vVar2.etK = i12;
                vVar2.etL = i14;
                ab.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", vVar2.toString());
            }
            AppMethodBeat.o(92991);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            AppMethodBeat.o(92991);
            return false;
        }
    }
}
