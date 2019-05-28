package com.tencent.mm.plugin.story.model.c;

import a.f.b.j;
import a.f.b.y;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J%\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ&\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
public final class c extends com.tencent.mm.loader.d.b<d> {
    private static final String TAG = TAG;
    public static final a rVM = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    public static final class b implements com.tencent.mm.i.g.a {
        final /* synthetic */ d rVN;
        final /* synthetic */ com.tencent.mm.loader.d.b.b rVO;
        final /* synthetic */ String rVP;

        b(d dVar, com.tencent.mm.loader.d.b.b bVar, String str) {
            this.rVN = dVar;
            this.rVO = bVar;
            this.rVP = str;
        }

        public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(109292);
            j.p(str, "mediaId");
            ab.i(c.TAG, "mediaId " + str + " startRet " + i + " sceneResult " + dVar + " onlyCheckExist " + z);
            if (dVar != null) {
                if (this.rVN == null) {
                    AppMethodBeat.o(109292);
                    return 0;
                }
                com.tencent.mm.loader.d.b.b bVar = this.rVO;
                com.tencent.mm.loader.h.a S = com.tencent.mm.loader.h.a.S(this.rVP, "");
                j.o(S, "HttpFileResponse.create(tmpFilePath, \"\")");
                bVar.a(S);
            }
            AppMethodBeat.o(109292);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(109293);
            j.p(str, "mediaId");
            j.p(byteArrayOutputStream, "buff");
            AppMethodBeat.o(109293);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(109294);
            j.p(str, "mediaId");
            j.p(bArr, "inbuf");
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(109294);
            return bArr2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(109298);
        AppMethodBeat.o(109298);
    }

    public final void a(com.tencent.mm.loader.h.a.a<d> aVar, f fVar, com.tencent.mm.loader.d.b.b bVar) {
        AppMethodBeat.i(109295);
        j.p(aVar, "data");
        j.p(fVar, "fileNameCreator");
        j.p(bVar, "callback");
        d dVar = (d) aVar.value();
        y yVar = y.AVH;
        r3 = new Object[5];
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        j.o(g.RN(), "MMKernel.account()");
        r3[1] = p.getString(com.tencent.mm.kernel.a.QF());
        r3[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
        r3[3] = Integer.valueOf(at.getStrength(ah.getContext()));
        r3[4] = "";
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(r3, 5));
        j.o(format, "java.lang.String.format(format, *args)");
        e eVar = new e();
        ab.i(TAG, "loadDataImp " + ((d) aVar.value()) + " story " + dVar.rVQ.Url);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String str = ((d) aVar.value()).rVQ.Url;
        String str2 = ((d) aVar.value()).username;
        if (str == null) {
            str2 = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = com.tencent.mm.plugin.story.model.l.aar(str2) + "/pic/";
            byte[] bytes = str.getBytes(a.k.d.UTF_8);
            j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            str2 = stringBuilder2.append(com.tencent.mm.plugin.story.model.l.gv(str2, com.tencent.mm.a.g.x(bytes))).append(".d").toString();
        }
        String stringBuilder3 = stringBuilder.append(str2).append(fVar.c(aVar)).toString();
        j.o(dVar, "story");
        if (a(dVar, stringBuilder3, eVar, format)) {
            eVar.egl = new b(dVar, bVar, stringBuilder3);
            if (com.tencent.mm.al.f.afx().d(eVar)) {
                ab.i(TAG, "SubCoreCdnTransport addRecvTask suc");
                AppMethodBeat.o(109295);
                return;
            }
            ab.w(TAG, "SubCoreCdnTransport addRecvTask failed");
            bVar.onError();
            AppMethodBeat.o(109295);
            return;
        }
        ab.w(TAG, "attachSnsImgTaskInfo failed");
        bVar.onError();
        AppMethodBeat.o(109295);
    }

    private static String[] di(List<String> list) {
        AppMethodBeat.i(109297);
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = (String) list.get(i);
        }
        AppMethodBeat.o(109297);
        return strArr;
    }

    private static boolean a(d dVar, String str, e eVar, String str2) {
        AppMethodBeat.i(109296);
        try {
            cek cek = dVar.rVQ;
            String host = new URL(cek.wEH).getHost();
            ArrayList arrayList = new ArrayList();
            int a = com.tencent.mm.network.b.a(host, false, (List) arrayList);
            ArrayList arrayList2 = new ArrayList();
            int a2 = com.tencent.mm.network.b.a(host, true, (List) arrayList2);
            Random random = new Random();
            random.setSeed(bo.anU());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            eVar.field_mediaId = cek.Id + "_";
            eVar.url = cek.wEH;
            eVar.host = host;
            eVar.referer = str2;
            eVar.egd = str;
            eVar.ege = di(arrayList);
            eVar.egf = di(arrayList2);
            eVar.egg = a;
            eVar.egh = a2;
            eVar.isColdSnsData = false;
            eVar.signalQuality = at.getStrength(ah.getContext());
            eVar.snsScene = "";
            eVar.snsCipherKey = dVar.rVQ.wFb;
            eVar.duk = 3;
            eVar.egi = 100;
            eVar.fileType = 20201;
            ab.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", eVar);
            AppMethodBeat.o(109296);
            return true;
        } catch (MalformedURLException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            ab.w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(e)));
            AppMethodBeat.o(109296);
            return false;
        }
    }
}
