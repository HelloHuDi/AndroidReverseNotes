package com.tencent.p177mm.p235i;

import java.io.ByteArrayOutputStream;
import java.util.Map;

/* renamed from: com.tencent.mm.i.g */
public class C42130g {
    public boolean allow_mobile_net_download = false;
    public boolean cRY;
    public int certificateVerifyPolicy = 2;
    public int connectionCount = 1;
    public C1628a egl;
    public String egm = "";
    public int egn = 0;
    public int ego = 0;
    public String[] egp = null;
    public boolean egq = true;
    public boolean egr = false;
    public boolean egs = false;
    public String egt = "";
    public Map<String, String> egu = null;
    public boolean egv = false;
    public boolean egw = false;
    public int egx;
    public int egy = 1;
    public C1629b egz;
    public int expectImageFormat = 1;
    public int field_advideoflag = 0;
    public String field_aesKey = "";
    public int field_appType = 0;
    public int field_arg = 0;
    public String field_authKey;
    public boolean field_autostart = false;
    public int field_bzScene = 0;
    public int field_chattype = 0;
    public boolean field_enable_hitcheck = true;
    public String field_fake_bigfile_signature = "";
    public String field_fake_bigfile_signature_aeskey = "";
    public String field_fileId = "";
    public int field_fileType = 0;
    public String field_filemd5 = "";
    public boolean field_force_aeskeycdn = false;
    public String field_fullpath = "";
    public boolean field_isColdSnsData = false;
    public boolean field_isSilentTask = false;
    public boolean field_isStreamMedia = false;
    public int field_largesvideo = 0;
    public long field_lastProgressCallbackTime = 0;
    public int field_limitrate = 0;
    public String field_mediaId = "";
    public int field_midFileLength = 0;
    public String field_midimgpath = "";
    public boolean field_needCompressImage = false;
    public boolean field_needStorage = false;
    public boolean field_onlycheckexist = false;
    public int field_preloadRatio = 30;
    public int field_priority = 0;
    public int field_requestVideoFormat = 1;
    public boolean field_sendmsg_viacdn = false;
    public String field_signalQuality = "";
    public int field_smallVideoFlag = 0;
    public String field_snsScene = "";
    public long field_startTime = 0;
    public String field_svr_signature = "";
    public String field_talker = "";
    public String field_thumbpath = "";
    public int field_totalLen = 0;
    public boolean field_trysafecdn = false;
    public boolean field_use_multithread = false;
    public String field_videoFileId = "";
    public int field_videosource = 0;
    public String field_wxmsgparam = "";
    public int initialDownloadLength = -1;
    public int initialDownloadOffset = -1;
    public boolean is_resume_task = false;
    public int lastError = 0;

    /* renamed from: com.tencent.mm.i.g$a */
    public interface C1628a {
        /* renamed from: a */
        int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z);

        /* renamed from: a */
        void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream);

        /* renamed from: l */
        byte[] mo5084l(String str, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.i.g$b */
    public interface C1629b {
        /* renamed from: a */
        void mo5085a(String str, C9545d c9545d);
    }

    /* renamed from: Jp */
    public final boolean mo67675Jp() {
        return this.egy == 2;
    }

    /* renamed from: Jq */
    public final boolean mo67676Jq() {
        return this.egy == 3;
    }

    /* renamed from: Jr */
    public final boolean mo67677Jr() {
        return this.egy == 1;
    }

    /* renamed from: Js */
    public final boolean mo67678Js() {
        return this.egy == 4;
    }

    /* renamed from: Jt */
    public final boolean mo67679Jt() {
        return this.egy == 6;
    }
}
