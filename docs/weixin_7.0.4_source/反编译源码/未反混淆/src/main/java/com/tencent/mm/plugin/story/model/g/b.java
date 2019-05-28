package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.v;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.g;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

@l(dWo = {1, 1, 13}, dWp = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0002J.\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0005J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b implements g {
    final String TAG;
    private String clientId;
    String fFa;
    private int fWD;
    private String hxH;
    private final String mPath;
    private long qKa;
    private cel rXG;
    private final a rXH;
    final com.tencent.mm.plugin.story.model.g.a rXI;
    private final j rXz;
    private final String thumbPath;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    public static final class a implements com.tencent.mm.i.g.a {
        final /* synthetic */ b rXJ;

        a(b bVar) {
            this.rXJ = bVar;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(109443);
            a.f.b.j.p(str, "mediaId");
            if (i == -21005) {
                ab.d(this.rXJ.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), cVar, dVar);
                this.rXJ.rXI.a(0, true, this.rXJ);
                AppMethodBeat.o(109443);
            } else if (dVar != null && dVar.field_retCode == 0) {
                ab.i(this.rXJ.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), cVar, dVar);
                b bVar = this.rXJ;
                String str2 = dVar.field_fileUrl;
                a.f.b.j.o(str2, "sceneResult.field_fileUrl");
                com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
                int cAU = com.tencent.mm.plugin.story.h.a.scE;
                String str3 = dVar.field_thumbUrl;
                a.f.b.j.o(str3, "sceneResult.field_thumbUrl");
                com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                int cAU2 = com.tencent.mm.plugin.story.h.a.scE;
                StringBuilder stringBuilder = new StringBuilder("upload_ + ");
                String str4 = this.rXJ.fFa;
                if (str4 == null) {
                    str4 = BuildConfig.COMMAND;
                }
                bVar.a(str2, cAU, str3, cAU2, stringBuilder.append(str4).toString());
                this.rXJ.rXI.a(0, true, this.rXJ);
                AppMethodBeat.o(109443);
            } else if (dVar != null && dVar.field_retCode != 0) {
                ab.i(this.rXJ.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), cVar, dVar);
                this.rXJ.czv();
                this.rXJ.rXI.a(dVar.field_retCode, false, this.rXJ);
                AppMethodBeat.o(109443);
            } else if (i != 0) {
                ab.i(this.rXJ.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), cVar, dVar);
                this.rXJ.czv();
                this.rXJ.rXI.a(i, false, this.rXJ);
                AppMethodBeat.o(109443);
            } else {
                ab.d(this.rXJ.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.rXJ.fFa, Integer.valueOf(i), cVar, dVar);
                AppMethodBeat.o(109443);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(109444);
            a.f.b.j.p(str, "mediaId");
            a.f.b.j.p(byteArrayOutputStream, "buff");
            AppMethodBeat.o(109444);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(109445);
            a.f.b.j.p(str, "mediaId");
            a.f.b.j.p(bArr, "inbuf");
            AppMethodBeat.o(109445);
            return null;
        }
    }

    public b(j jVar, String str, String str2, com.tencent.mm.plugin.story.model.g.a aVar) {
        a.f.b.j.p(jVar, "storyInfo");
        a.f.b.j.p(str, "mPath");
        a.f.b.j.p(str2, "thumbPath");
        a.f.b.j.p(aVar, "callback");
        AppMethodBeat.i(109449);
        this.rXz = jVar;
        this.mPath = str;
        this.thumbPath = str2;
        this.rXI = aVar;
        this.clientId = "";
        this.hxH = "";
        this.rXG = new cel();
        this.TAG = "MicroMsg.StorySightCdnUpload";
        this.rXH = new a(this);
        this.qKa = cb.aaE();
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
        if (bo.isNullOrNil(this.clientId)) {
            str3 = bo.yz();
            Charset charset = a.k.d.UTF_8;
            if (str3 == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(109449);
                throw vVar;
            }
            byte[] bytes = str3.getBytes(charset);
            a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            this.clientId = com.tencent.mm.a.g.x(bytes);
            this.rXG.ptv = this.clientId;
            try {
                j jVar2 = this.rXz;
                byte[] toByteArray = this.rXG.toByteArray();
                a.f.b.j.o(toByteArray, "postinfo.toByteArray()");
                jVar2.bk(toByteArray);
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            }
        }
        int asZ = (int) e.asZ(this.mPath);
        ab.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", this.mPath, Integer.valueOf(asZ), this.hxH);
        AppMethodBeat.o(109449);
    }

    /* Access modifiers changed, original: final */
    public final void czv() {
        AppMethodBeat.i(109446);
        ab.i(this.TAG, "snsupload sight by cdn error! " + bo.dpG());
        try {
            this.rXG.eRu++;
            cel cel = this.rXG;
            com.tencent.mm.plugin.story.h.a.e eVar = com.tencent.mm.plugin.story.h.a.e.sdz;
            cel.wFD = com.tencent.mm.plugin.story.h.a.e.cBA();
            j jVar = this.rXz;
            byte[] toByteArray = this.rXG.toByteArray();
            a.f.b.j.o(toByteArray, "postinfo.toByteArray()");
            jVar.bk(toByteArray);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
            AppMethodBeat.o(109446);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.o(109446);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.i(109447);
        a.f.b.j.p(str, "url");
        a.f.b.j.p(str2, "thumbUrl");
        a.f.b.j.p(str3, "meidiaId");
        ab.d(this.TAG, "upload ok " + str + "  " + str3 + "  " + i);
        cel cel = this.rXG;
        com.tencent.mm.plugin.story.h.a.e eVar = com.tencent.mm.plugin.story.h.a.e.sdz;
        cel.wFD = com.tencent.mm.plugin.story.h.a.e.cBz();
        this.rXG.eRu = 0;
        this.rXG.wFi = (long) cb.aaF();
        j jVar = this.rXz;
        byte[] toByteArray = this.rXG.toByteArray();
        a.f.b.j.o(toByteArray, "postinfo.toByteArray()");
        jVar.bk(toByteArray);
        cek cek = (cek) this.rXz.cBR().xeA.wbK.get(0);
        cek.Url = str;
        cek.jCt = i;
        cek.wEH = str2;
        cek.jCt = i2;
        f.afy();
        cek.wFc = com.tencent.mm.al.a.rJ(this.mPath);
        ab.i(this.TAG, "mediaObj.videomd5 " + cek.wFc);
        cfb cBR = this.rXz.cBR();
        cBR.xeA.wbK.set(0, cek);
        this.rXz.b(cBR);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
        AppMethodBeat.o(109447);
        return true;
    }

    public final boolean cne() {
        AppMethodBeat.i(109448);
        String cz = com.tencent.mm.a.g.cz(this.mPath);
        if (bo.isNullOrNil(this.hxH) || (a.f.b.j.j(this.hxH, cz) ^ 1) == 0) {
            ab.i(this.TAG, "check upload %s %d %s", this.mPath, Integer.valueOf(r3.wDQ), Boolean.valueOf(new baa().wDP));
            if (com.tencent.mm.plugin.sight.base.d.WR(this.mPath) != null) {
                ab.i(this.TAG, "mediaInfo: %s", com.tencent.mm.plugin.sight.base.d.WR(this.mPath));
            }
            if ((this.rXG.xei & 1) == 0) {
                SightVideoJNI.optimizeMP4(this.mPath);
            }
            try {
                cz = com.tencent.mm.a.g.cz(this.mPath);
                a.f.b.j.o(cz, "MD5.getMD5(mPath)");
                this.hxH = cz;
                this.rXG.cvZ = this.hxH;
                this.rXG.xei |= 1;
                j jVar = this.rXz;
                byte[] toByteArray = this.rXG.toByteArray();
                a.f.b.j.o(toByteArray, "postinfo.toByteArray()");
                jVar.bk(toByteArray);
                ab.i(this.TAG, "new md5 is %s %s", this.mPath, this.hxH);
                com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
            } catch (Exception e) {
                ab.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", e.getMessage());
            }
            this.fFa = this.clientId;
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.egl = this.rXH;
            gVar.field_mediaId = this.fFa;
            gVar.field_fullpath = this.mPath;
            gVar.field_thumbpath = this.thumbPath;
            gVar.field_fileType = CdnLogic.kMediaTypeAppVideo;
            gVar.field_talker = "";
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_needStorage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 205;
            gVar.field_bzScene = 2;
            com.tencent.mm.plugin.story.c.a.c.a aVar2 = (com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw();
            if (aVar2 != null) {
                ab.i(this.TAG, "StoryEncodeElementConfig " + aVar2.duration);
                gVar.field_largesvideo = aVar2.duration + 3;
            } else {
                gVar.field_largesvideo = 18;
            }
            gVar.egy = 6;
            cz = com.tencent.mm.a.g.cz(this.mPath);
            if (bo.isNullOrNil(this.hxH) || (a.f.b.j.j(this.hxH, cz) ^ 1) == 0) {
                ab.d(this.TAG, "will addSendTask");
                if (f.afx().e(gVar)) {
                    int i;
                    if (r3.wDP) {
                        i = 4;
                    } else {
                        i = 5;
                    }
                    this.fWD = i;
                    AppMethodBeat.o(109448);
                    return true;
                }
                ab.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.fFa);
                this.rXI.a(-3, false, this);
                AppMethodBeat.o(109448);
                return false;
            }
            ab.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
            czv();
            this.rXI.a(-2, false, this);
            AppMethodBeat.o(109448);
            return false;
        }
        ab.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
        czv();
        this.rXI.a(-2, false, this);
        AppMethodBeat.o(109448);
        return false;
    }
}
