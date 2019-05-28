package com.tencent.p177mm.plugin.story.model.p1304c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p1197h.C32734a;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p245d.C32725b.C18531b;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C26325e;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C8001y;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J%\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ&\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.c.c */
public final class C22229c extends C32725b<C24833d> {
    private static final String TAG = TAG;
    public static final C22230a rVM = new C22230a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.c.c$b */
    public static final class C22228b implements C1628a {
        final /* synthetic */ C24833d rVN;
        final /* synthetic */ C18531b rVO;
        final /* synthetic */ String rVP;

        C22228b(C24833d c24833d, C18531b c18531b, String str) {
            this.rVN = c24833d;
            this.rVO = c18531b;
            this.rVP = str;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(109292);
            C25052j.m39376p(str, "mediaId");
            C4990ab.m7416i(C22229c.TAG, "mediaId " + str + " startRet " + i + " sceneResult " + c9545d + " onlyCheckExist " + z);
            if (c9545d != null) {
                if (this.rVN == null) {
                    AppMethodBeat.m2505o(109292);
                    return 0;
                }
                C18531b c18531b = this.rVO;
                C32734a S = C32734a.m53415S(this.rVP, "");
                C25052j.m39375o(S, "HttpFileResponse.create(tmpFilePath, \"\")");
                c18531b.mo33782a(S);
            }
            AppMethodBeat.m2505o(109292);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(109293);
            C25052j.m39376p(str, "mediaId");
            C25052j.m39376p(byteArrayOutputStream, "buff");
            AppMethodBeat.m2505o(109293);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(109294);
            C25052j.m39376p(str, "mediaId");
            C25052j.m39376p(bArr, "inbuf");
            byte[] bArr2 = new byte[0];
            AppMethodBeat.m2505o(109294);
            return bArr2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.c.c$a */
    public static final class C22230a {
        private C22230a() {
        }

        public /* synthetic */ C22230a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109298);
        AppMethodBeat.m2505o(109298);
    }

    /* renamed from: a */
    public final void mo37770a(C42156a<C24833d> c42156a, C32733f c32733f, C18531b c18531b) {
        AppMethodBeat.m2504i(109295);
        C25052j.m39376p(c42156a, "data");
        C25052j.m39376p(c32733f, "fileNameCreator");
        C25052j.m39376p(c18531b, "callback");
        C24833d c24833d = (C24833d) c42156a.value();
        C8001y c8001y = C8001y.AVH;
        r3 = new Object[5];
        C4133a c4133a = C43644j.rST;
        C25052j.m39375o(C1720g.m3534RN(), "MMKernel.account()");
        r3[1] = C1183p.getString(C1668a.m3383QF());
        r3[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
        r3[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
        r3[4] = "";
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(r3, 5));
        C25052j.m39375o(format, "java.lang.String.format(format, *args)");
        C26325e c26325e = new C26325e();
        C4990ab.m7416i(TAG, "loadDataImp " + ((C24833d) c42156a.value()) + " story " + c24833d.rVQ.Url);
        StringBuilder stringBuilder = new StringBuilder();
        C29309l c29309l = C29309l.rTg;
        String str = ((C24833d) c42156a.value()).rVQ.Url;
        String str2 = ((C24833d) c42156a.value()).username;
        if (str == null) {
            str2 = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = C29309l.aar(str2) + "/pic/";
            byte[] bytes = str.getBytes(C17355d.UTF_8);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            str2 = stringBuilder2.append(C29309l.m46526gv(str2, C1178g.m2591x(bytes))).append(".d").toString();
        }
        String stringBuilder3 = stringBuilder.append(str2).append(c32733f.mo53286c(c42156a)).toString();
        C25052j.m39375o(c24833d, "story");
        if (C22229c.m33912a(c24833d, stringBuilder3, c26325e, format)) {
            c26325e.egl = new C22228b(c24833d, c18531b, stringBuilder3);
            if (C37461f.afx().mo51224d(c26325e)) {
                C4990ab.m7416i(TAG, "SubCoreCdnTransport addRecvTask suc");
                AppMethodBeat.m2505o(109295);
                return;
            }
            C4990ab.m7420w(TAG, "SubCoreCdnTransport addRecvTask failed");
            c18531b.onError();
            AppMethodBeat.m2505o(109295);
            return;
        }
        C4990ab.m7420w(TAG, "attachSnsImgTaskInfo failed");
        c18531b.onError();
        AppMethodBeat.m2505o(109295);
    }

    /* renamed from: di */
    private static String[] m33913di(List<String> list) {
        AppMethodBeat.m2504i(109297);
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = (String) list.get(i);
        }
        AppMethodBeat.m2505o(109297);
        return strArr;
    }

    /* renamed from: a */
    private static boolean m33912a(C24833d c24833d, String str, C26325e c26325e, String str2) {
        AppMethodBeat.m2504i(109296);
        try {
            cek cek = c24833d.rVQ;
            String host = new URL(cek.wEH).getHost();
            ArrayList arrayList = new ArrayList();
            int a = C1897b.m4018a(host, false, (List) arrayList);
            ArrayList arrayList2 = new ArrayList();
            int a2 = C1897b.m4018a(host, true, (List) arrayList2);
            Random random = new Random();
            random.setSeed(C5046bo.anU());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            c26325e.field_mediaId = cek.f4416Id + "_";
            c26325e.url = cek.wEH;
            c26325e.host = host;
            c26325e.referer = str2;
            c26325e.egd = str;
            c26325e.ege = C22229c.m33913di(arrayList);
            c26325e.egf = C22229c.m33913di(arrayList2);
            c26325e.egg = a;
            c26325e.egh = a2;
            c26325e.isColdSnsData = false;
            c26325e.signalQuality = C5023at.getStrength(C4996ah.getContext());
            c26325e.snsScene = "";
            c26325e.snsCipherKey = c24833d.rVQ.wFb;
            c26325e.duk = 3;
            c26325e.egi = 100;
            c26325e.fileType = 20201;
            C4990ab.m7417i(TAG, "attachSnsImgTaskInfo reqDownType:%s", c26325e);
            AppMethodBeat.m2505o(109296);
            return true;
        } catch (MalformedURLException e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            C4990ab.m7420w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(109296);
            return false;
        }
    }
}
