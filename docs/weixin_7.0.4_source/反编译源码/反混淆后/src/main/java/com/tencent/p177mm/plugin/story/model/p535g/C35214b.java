package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C46284g;
import com.tencent.p177mm.plugin.story.model.C46284g.C22238a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c.C29276a;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35188e;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0002J.\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0005J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.b */
public final class C35214b implements C46284g {
    final String TAG;
    private String clientId;
    String fFa;
    private int fWD;
    private String hxH;
    private final String mPath;
    private long qKa;
    private cel rXG;
    private final C13788a rXH;
    final C22238a rXI;
    private final C39879j rXz;
    private final String thumbPath;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.b$a */
    public static final class C13788a implements C1628a {
        final /* synthetic */ C35214b rXJ;

        C13788a(C35214b c35214b) {
            this.rXJ = c35214b;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(109443);
            C25052j.m39376p(str, "mediaId");
            if (i == -21005) {
                C4990ab.m7411d(this.rXJ.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), c18496c, c9545d);
                this.rXJ.rXI.mo25980a(0, true, this.rXJ);
                AppMethodBeat.m2505o(109443);
            } else if (c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7417i(this.rXJ.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), c18496c, c9545d);
                C35214b c35214b = this.rXJ;
                String str2 = c9545d.field_fileUrl;
                C25052j.m39375o(str2, "sceneResult.field_fileUrl");
                C35184a c35184a = C35183a.sdm;
                int cAU = C35183a.scE;
                String str3 = c9545d.field_thumbUrl;
                C25052j.m39375o(str3, "sceneResult.field_thumbUrl");
                C35184a c35184a2 = C35183a.sdm;
                int cAU2 = C35183a.scE;
                StringBuilder stringBuilder = new StringBuilder("upload_ + ");
                String str4 = this.rXJ.fFa;
                if (str4 == null) {
                    str4 = BuildConfig.COMMAND;
                }
                c35214b.mo55852a(str2, cAU, str3, cAU2, stringBuilder.append(str4).toString());
                this.rXJ.rXI.mo25980a(0, true, this.rXJ);
                AppMethodBeat.m2505o(109443);
            } else if (c9545d != null && c9545d.field_retCode != 0) {
                C4990ab.m7417i(this.rXJ.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), c18496c, c9545d);
                this.rXJ.czv();
                this.rXJ.rXI.mo25980a(c9545d.field_retCode, false, this.rXJ);
                AppMethodBeat.m2505o(109443);
            } else if (i != 0) {
                C4990ab.m7417i(this.rXJ.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), c18496c, c9545d);
                this.rXJ.czv();
                this.rXJ.rXI.mo25980a(i, false, this.rXJ);
                AppMethodBeat.m2505o(109443);
            } else {
                C4990ab.m7411d(this.rXJ.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), c18496c, c9545d);
                AppMethodBeat.m2505o(109443);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(109444);
            C25052j.m39376p(str, "mediaId");
            C25052j.m39376p(byteArrayOutputStream, "buff");
            AppMethodBeat.m2505o(109444);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(109445);
            C25052j.m39376p(str, "mediaId");
            C25052j.m39376p(bArr, "inbuf");
            AppMethodBeat.m2505o(109445);
            return null;
        }
    }

    public C35214b(C39879j c39879j, String str, String str2, C22238a c22238a) {
        C25052j.m39376p(c39879j, "storyInfo");
        C25052j.m39376p(str, "mPath");
        C25052j.m39376p(str2, "thumbPath");
        C25052j.m39376p(c22238a, "callback");
        AppMethodBeat.m2504i(109449);
        this.rXz = c39879j;
        this.mPath = str;
        this.thumbPath = str2;
        this.rXI = c22238a;
        this.clientId = "";
        this.hxH = "";
        this.rXG = new cel();
        this.TAG = "MicroMsg.StorySightCdnUpload";
        this.rXH = new C13788a(this);
        this.qKa = C1839cb.aaE();
        this.rXG = this.rXz.cBU();
        String str3 = this.rXG.ptv;
        if (str3 == null) {
            str3 = "";
        }
        this.clientId = str3;
        str3 = this.rXG.cvZ;
        if (str3 == null) {
            str3 = "";
        }
        this.hxH = str3;
        if (C5046bo.isNullOrNil(this.clientId)) {
            str3 = C5046bo.m7588yz();
            Charset charset = C17355d.UTF_8;
            if (str3 == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(109449);
                throw c44941v;
            }
            byte[] bytes = str3.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            this.clientId = C1178g.m2591x(bytes);
            this.rXG.ptv = this.clientId;
            try {
                C39879j c39879j2 = this.rXz;
                byte[] toByteArray = this.rXG.toByteArray();
                C25052j.m39375o(toByteArray, "postinfo.toByteArray()");
                c39879j2.mo63083bk(toByteArray);
                C4133a c4133a = C43644j.rST;
                C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            }
        }
        int asZ = (int) C5730e.asZ(this.mPath);
        C4990ab.m7417i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", this.mPath, Integer.valueOf(asZ), this.hxH);
        AppMethodBeat.m2505o(109449);
    }

    /* Access modifiers changed, original: final */
    public final void czv() {
        AppMethodBeat.m2504i(109446);
        C4990ab.m7416i(this.TAG, "snsupload sight by cdn error! " + C5046bo.dpG());
        try {
            this.rXG.eRu++;
            cel cel = this.rXG;
            C35188e c35188e = C35188e.sdz;
            cel.wFD = C35188e.cBA();
            C39879j c39879j = this.rXz;
            byte[] toByteArray = this.rXG.toByteArray();
            C25052j.m39375o(toByteArray, "postinfo.toByteArray()");
            c39879j.mo63083bk(toByteArray);
            C4133a c4133a = C43644j.rST;
            C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
            AppMethodBeat.m2505o(109446);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(109446);
        }
    }

    /* renamed from: a */
    public final boolean mo55852a(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.m2504i(109447);
        C25052j.m39376p(str, "url");
        C25052j.m39376p(str2, "thumbUrl");
        C25052j.m39376p(str3, "meidiaId");
        C4990ab.m7410d(this.TAG, "upload ok " + str + "  " + str3 + "  " + i);
        cel cel = this.rXG;
        C35188e c35188e = C35188e.sdz;
        cel.wFD = C35188e.cBz();
        this.rXG.eRu = 0;
        this.rXG.wFi = (long) C1839cb.aaF();
        C39879j c39879j = this.rXz;
        byte[] toByteArray = this.rXG.toByteArray();
        C25052j.m39375o(toByteArray, "postinfo.toByteArray()");
        c39879j.mo63083bk(toByteArray);
        cek cek = (cek) this.rXz.cBR().xeA.wbK.get(0);
        cek.Url = str;
        cek.jCt = i;
        cek.wEH = str2;
        cek.jCt = i2;
        C37461f.afy();
        cek.wFc = C8941a.m16130rJ(this.mPath);
        C4990ab.m7416i(this.TAG, "mediaObj.videomd5 " + cek.wFc);
        cfb cBR = this.rXz.cBR();
        cBR.xeA.wbK.set(0, cek);
        this.rXz.mo63082b(cBR);
        C4133a c4133a = C43644j.rST;
        C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
        AppMethodBeat.m2505o(109447);
        return true;
    }

    public final boolean cne() {
        AppMethodBeat.m2504i(109448);
        String cz = C1178g.m2587cz(this.mPath);
        if (C5046bo.isNullOrNil(this.hxH) || (C25052j.m39373j(this.hxH, cz) ^ 1) == 0) {
            C4990ab.m7417i(this.TAG, "check upload %s %d %s", this.mPath, Integer.valueOf(r3.wDQ), Boolean.valueOf(new baa().wDP));
            if (C21846d.m33388WR(this.mPath) != null) {
                C4990ab.m7417i(this.TAG, "mediaInfo: %s", C21846d.m33388WR(this.mPath));
            }
            if ((this.rXG.xei & 1) == 0) {
                SightVideoJNI.optimizeMP4(this.mPath);
            }
            try {
                cz = C1178g.m2587cz(this.mPath);
                C25052j.m39375o(cz, "MD5.getMD5(mPath)");
                this.hxH = cz;
                this.rXG.cvZ = this.hxH;
                this.rXG.xei |= 1;
                C39879j c39879j = this.rXz;
                byte[] toByteArray = this.rXG.toByteArray();
                C25052j.m39375o(toByteArray, "postinfo.toByteArray()");
                c39879j.mo63083bk(toByteArray);
                C4990ab.m7417i(this.TAG, "new md5 is %s %s", this.mPath, this.hxH);
                C4133a c4133a = C43644j.rST;
                C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
            } catch (Exception e) {
                C4990ab.m7413e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", e.getMessage());
            }
            this.fFa = this.clientId;
            C42130g c42130g = new C42130g();
            c42130g.egl = this.rXH;
            c42130g.field_mediaId = this.fFa;
            c42130g.field_fullpath = this.mPath;
            c42130g.field_thumbpath = this.thumbPath;
            c42130g.field_fileType = CdnLogic.kMediaTypeAppVideo;
            c42130g.field_talker = "";
            c42130g.field_priority = C42129a.efC;
            c42130g.field_needStorage = true;
            c42130g.field_isStreamMedia = false;
            c42130g.field_appType = 205;
            c42130g.field_bzScene = 2;
            C29276a c29276a = (C29276a) C29275c.rRk.mo53288Uw();
            if (c29276a != null) {
                C4990ab.m7416i(this.TAG, "StoryEncodeElementConfig " + c29276a.duration);
                c42130g.field_largesvideo = c29276a.duration + 3;
            } else {
                c42130g.field_largesvideo = 18;
            }
            c42130g.egy = 6;
            cz = C1178g.m2587cz(this.mPath);
            if (C5046bo.isNullOrNil(this.hxH) || (C25052j.m39373j(this.hxH, cz) ^ 1) == 0) {
                C4990ab.m7410d(this.TAG, "will addSendTask");
                if (C37461f.afx().mo51225e(c42130g)) {
                    int i;
                    if (r3.wDP) {
                        i = 4;
                    } else {
                        i = 5;
                    }
                    this.fWD = i;
                    AppMethodBeat.m2505o(109448);
                    return true;
                }
                C4990ab.m7413e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.fFa);
                this.rXI.mo25980a(-3, false, this);
                AppMethodBeat.m2505o(109448);
                return false;
            }
            C4990ab.m7417i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
            czv();
            this.rXI.mo25980a(-2, false, this);
            AppMethodBeat.m2505o(109448);
            return false;
        }
        C4990ab.m7417i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
        czv();
        this.rXI.mo25980a(-2, false, this);
        AppMethodBeat.m2505o(109448);
        return false;
    }
}
