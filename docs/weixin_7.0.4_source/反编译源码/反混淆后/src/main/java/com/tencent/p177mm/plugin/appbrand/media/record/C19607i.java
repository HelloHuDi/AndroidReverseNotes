package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.i */
public final class C19607i {
    /* renamed from: ph */
    public static String m30402ph(int i) {
        AppMethodBeat.m2504i(105640);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errType:" + i + ", err:");
        switch (i) {
            case 1:
                stringBuilder.append("error PCM record callback");
                break;
            case 2:
                stringBuilder.append("init encoder fail, occur exception");
                break;
            case 3:
                stringBuilder.append("encoder un initial occur exception");
                break;
            case 4:
                stringBuilder.append("start record occur exception");
                break;
            case 5:
                stringBuilder.append("resume record occur exception");
                break;
            case 6:
                stringBuilder.append("fail to start record");
                break;
            case 7:
                stringBuilder.append("fail to resume record");
                break;
            case 8:
                stringBuilder.append("fail to pause record");
                break;
            case 9:
                stringBuilder.append("fail to stop record");
                break;
            case 15:
                stringBuilder.append("check param invalid");
                break;
            case 16:
                stringBuilder.append("not support format type");
                break;
            case 17:
                stringBuilder.append("fail to init mp3 encoder");
                break;
            case 18:
                stringBuilder.append("mp3 file not found exception");
                break;
            case 19:
                stringBuilder.append("mp3 encode exception");
                break;
            case 20:
                stringBuilder.append("mp3 write buffer exception");
                break;
            case 21:
                stringBuilder.append("fail to init aac encoder");
                break;
            case 22:
                stringBuilder.append("fail to create mp4 file");
                break;
            case 23:
                stringBuilder.append("aac encode exception");
                break;
            case 24:
                stringBuilder.append("create cache file fail");
                break;
            case 25:
                stringBuilder.append("init encoder fail");
                break;
            case 26:
                stringBuilder.append("not support sample rate");
                break;
            default:
                stringBuilder.append("unknow error");
                break;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(105640);
        return stringBuilder2;
    }

    /* renamed from: pi */
    public static int m30403pi(int i) {
        AppMethodBeat.m2504i(105641);
        C4990ab.m7417i("MicroMsg.Record.RecordErrorHandler", "getErrIdKey errType:%d", Integer.valueOf(i));
        switch (i) {
            case 1:
                AppMethodBeat.m2505o(105641);
                return 3;
            case 2:
                AppMethodBeat.m2505o(105641);
                return 4;
            case 3:
                AppMethodBeat.m2505o(105641);
                return 5;
            case 4:
                AppMethodBeat.m2505o(105641);
                return 6;
            case 5:
                AppMethodBeat.m2505o(105641);
                return 7;
            case 6:
                AppMethodBeat.m2505o(105641);
                return 8;
            case 7:
                AppMethodBeat.m2505o(105641);
                return 9;
            case 8:
                AppMethodBeat.m2505o(105641);
                return 10;
            case 9:
                AppMethodBeat.m2505o(105641);
                return 11;
            case 15:
                AppMethodBeat.m2505o(105641);
                return 15;
            case 16:
                AppMethodBeat.m2505o(105641);
                return 16;
            case 17:
                AppMethodBeat.m2505o(105641);
                return 17;
            case 18:
                AppMethodBeat.m2505o(105641);
                return 18;
            case 19:
                AppMethodBeat.m2505o(105641);
                return 19;
            case 20:
                AppMethodBeat.m2505o(105641);
                return 20;
            case 21:
                AppMethodBeat.m2505o(105641);
                return 21;
            case 22:
                AppMethodBeat.m2505o(105641);
                return 22;
            case 23:
                AppMethodBeat.m2505o(105641);
                return 23;
            case 24:
                AppMethodBeat.m2505o(105641);
                return 24;
            case 25:
                AppMethodBeat.m2505o(105641);
                return 25;
            case 26:
                AppMethodBeat.m2505o(105641);
                return 26;
            default:
                AppMethodBeat.m2505o(105641);
                return 0;
        }
    }
}
